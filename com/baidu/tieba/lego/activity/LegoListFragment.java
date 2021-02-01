package com.baidu.tieba.lego.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.c.c;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.card.a.a;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.view.m;
import com.baidu.tieba.lego.card.view.n;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.d.b;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.k;
import com.baidu.tieba.recapp.r;
import com.squareup.wire.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> laS;
    private ImageView bDy;
    private String from;
    private NoNetworkView gVA;
    private boolean hasAnimation;
    private String itemId;
    private a jKG;
    private g kZK;
    private n kZO;
    private e kZs;
    private long kZw;
    private LinearLayout laC;
    private LegoListView laD;
    private c laE;
    private com.baidu.tieba.lego.model.a laF;
    private RelativeLayout laH;
    private ImageView laI;
    private TbImageView laJ;
    private TbImageView laK;
    private a.C0775a laL;
    private int laM;
    private String laN;
    private float laO;
    private j lao;
    private boolean laq;
    private com.baidu.tieba.lego.card.view.c lax;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean laG = false;
    private boolean kZF = false;
    private int gyR = -1;
    private int jiq = -1;
    private boolean jja = false;
    private int laP = 0;
    private View laQ = null;
    private k laR = null;
    private m laT = new m() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.m
        public void mu(String str) {
            if (LegoListFragment.this.kZO != null) {
                LegoListFragment.this.kZO.NJ(str);
            }
        }
    };
    private d laU = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoListFragment.this.laF.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void p(long j, String str) {
            LegoListFragment.this.laF.w(j, str);
        }
    };
    private View.OnLayoutChangeListener laV = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.lax.Ea(LegoListFragment.this.dbo());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.lax.dco();
            }
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.lax.dcq()) {
                if (LegoListFragment.this.laD != null && view == LegoListFragment.this.laD.getListView() && LegoListFragment.this.jKG != null) {
                    LegoListFragment.this.jKG.onTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
    };
    private a.InterfaceC0710a iFe = new a.InterfaceC0710a() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.10
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            LegoListFragment.this.jja = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            LegoListFragment.this.jja = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11
        private int fNi = 0;
        private int laX = 0;
        private boolean laY = false;
        private int laZ = -1;
        private int lba = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.laP = i;
            if (1 == i && LegoListFragment.this.laQ != null && (findFocus = LegoListFragment.this.laQ.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.aa(1, LegoListFragment.this.jja);
                if (this.laY) {
                    LegoListFragment.this.lax.DY(com.baidu.tieba.lego.card.c.c.lcf);
                    LegoListFragment.this.laD.getListView().setSelectionFromTop(this.laZ, this.lba);
                    LegoListFragment.this.lax.dco();
                    LegoListFragment.this.laD.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.aa(1, LegoListFragment.this.jja);
                            AnonymousClass11.this.laY = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.laR != null) {
                LegoListFragment.this.laR.onScrollStateChanged(absListView, i);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z;
            int i4;
            int i5;
            double d;
            int i6;
            int i7;
            if (LegoListFragment.this.lax.dcq() && LegoListFragment.this.laD != null && LegoListFragment.this.laD.getListView() != null && LegoListFragment.this.laD.getListView().getChildAt(0) != null) {
                LegoListFragment.this.lax.dco();
                boolean z2 = true;
                if (i == this.fNi && LegoListFragment.this.jja) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.laX || LegoListFragment.this.jja) ? z2 : false;
                boolean z4 = false;
                if (this.laX < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.fNi > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.laY) {
                    BaseAdapter adapter = LegoListFragment.this.getAdapter();
                    if (!z4) {
                        if (adapter != null && adapter.getCount() > (i + i2) - 1) {
                            int i8 = ((i + i2) - 1) - 1;
                            if (i8 < 0) {
                                i8 = 0;
                            }
                            Object item = adapter.getItem(i8);
                            int i9 = 0;
                            if (item instanceof BaseLegoCardInfo) {
                                i9 = ((BaseLegoCardInfo) item).getPage();
                            }
                            Object item2 = adapter.getItem((i + i2) - 1);
                            if (!(item2 instanceof BaseLegoCardInfo)) {
                                i7 = 0;
                            } else {
                                i7 = ((BaseLegoCardInfo) item2).getPage();
                            }
                            if (i9 != 0 && i7 != 0 && i9 < i7) {
                                this.laY = true;
                                this.laZ = (i + i2) - 1;
                                this.lba = 0;
                                com.baidu.tieba.lego.card.c.c.lcf = i7;
                                LegoListFragment.this.laD.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.laD.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.laZ, AnonymousClass11.this.lba, 400);
                                    }
                                });
                            }
                        }
                    } else {
                        int i10 = i + 1;
                        if (adapter != null && adapter.getCount() > i10) {
                            Object item3 = adapter.getItem(i);
                            if (!(item3 instanceof BaseLegoCardInfo)) {
                                i4 = 0;
                            } else {
                                i4 = ((BaseLegoCardInfo) item3).getPage();
                            }
                            Object item4 = adapter.getItem(i10);
                            if (!(item4 instanceof BaseLegoCardInfo)) {
                                i5 = 0;
                            } else {
                                i5 = ((BaseLegoCardInfo) item4).getPage();
                            }
                            if (i4 != 0 && i5 != 0 && i4 < i5) {
                                int i11 = i - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i12 = i;
                                while (i11 >= 0) {
                                    Object item5 = adapter.getItem(i11);
                                    if (!(item5 instanceof BaseLegoCardInfo)) {
                                        d = ratio;
                                        i6 = i11;
                                    } else if (((BaseLegoCardInfo) item5).getPage() != i4) {
                                        break;
                                    } else {
                                        d = ((BaseLegoCardInfo) item5).getRatio() + ratio;
                                        i12 = i11;
                                        i6 = i11 - 1;
                                    }
                                    ratio = d;
                                    i11 = i6;
                                }
                                this.laY = true;
                                if (ratio > 2.67d) {
                                    this.laZ = i + 1;
                                    this.lba = (int) ((l.getScreenSize(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.laZ = i12;
                                    this.lba = 0;
                                }
                                com.baidu.tieba.lego.card.c.c.lcf = i4;
                                LegoListFragment.this.laD.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.laD.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.laZ, AnonymousClass11.this.lba, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.fNi = i;
                this.laX = (i + i2) - 1;
                if (this.lba > 0) {
                    this.laX--;
                }
                LegoListFragment.this.jiq = i;
                LegoListFragment.this.gyR = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.aa(2, LegoListFragment.this.jja);
                }
            }
        }
    };
    private Runnable ktP = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.kZO != null) {
                LegoListFragment.this.kZO.dcD();
            }
        }
    };

    public static void dbm() {
        if (laS == null) {
            laS = new HashSet();
        } else {
            laS.clear();
        }
    }

    public int dbn() {
        return this.laP;
    }

    public void b(j jVar) {
        this.lao = jVar;
    }

    public void a(com.baidu.tieba.lego.card.view.c cVar) {
        this.lax = cVar;
        this.lax.a(this.laT);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.laH != null) {
            if (configuration.orientation == 2) {
                this.laH.setVisibility(8);
            } else if (this.laq) {
                this.laH.setVisibility(0);
            } else {
                this.laH.setVisibility(8);
            }
        }
    }

    public void hg(long j) {
        this.kZw = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.kZF = z;
    }

    public boolean isFullScreen() {
        return !this.lax.dcq();
    }

    public int dbo() {
        int[] iArr = new int[2];
        this.laD.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, boolean z) {
        if (this.kZO != null && this.laD != null && this.laD.getListView() != null && this.laD.kZt != null && this.laD.kZt.getCount() != 0) {
            this.kZO.a(this.jiq, this.gyR, z, i);
        }
    }

    public void a(k kVar) {
        this.laR = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.laH = relativeLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = l.getEquipmentWidth(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.laC = new LinearLayout(getActivity());
        this.laC.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.laC.setOrientation(1);
        this.gVA = new NoNetworkView(getActivity());
        if (!this.laq) {
            this.laC.addView(this.gVA);
            if (l.isNetOk()) {
                this.gVA.setVisibility(8);
            } else {
                this.gVA.setVisibility(0);
            }
        }
        this.laD = a(this.laU);
        this.laD.setDrawingCacheEnabled(false);
        this.kZs = new e();
        this.kZs.lfE = this.kZw;
        this.kZs.itemId = this.itemId;
        this.laE = new c(this.kZs);
        this.laD.a(this.laE, true);
        this.laC.addView(this.laD);
        this.laD.getListView().setOnScrollListener(this.mOnScrollListener);
        this.laD.getListView().addOnLayoutChangeListener(this.laV);
        this.laD.getListView().setOnTouchListener(this.bST);
        this.jKG = new com.baidu.tieba.f.a();
        this.jKG.a(this.iFe);
        this.kZO = this.laD.getPlaySwitchController();
        frameLayout.addView(this.laC, new FrameLayout.LayoutParams(-1, -1));
        if (this.laq) {
            this.laH.setVisibility(0);
            this.laI = (ImageView) this.laH.findViewById(R.id.btn_share);
            l.addToParentArea(getActivity(), this.laI, 20, 20, 20, 20);
            this.laI.setVisibility(8);
            this.bDy = (ImageView) this.laH.findViewById(R.id.btn_close);
            l.addToParentArea(getActivity(), this.bDy, 20, 20, 20, 20);
            this.bDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.endAnimation();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.hasAnimation && this.laL != null && this.laL.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                this.laM = l.getStatusBarHeight(getActivity());
                this.rect = this.laL.rect;
                this.rect.top -= this.laM;
                this.rect.bottom -= this.laM;
                this.laJ = new TbImageView(getActivity());
                this.laJ.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.laJ.setLayoutParams(layoutParams);
                this.laJ.startLoad(this.laL.picUrl, 17, false);
                frameLayout.addView(this.laJ, layoutParams);
                if (this.laL.dbx()) {
                    Rect rect = this.laL.lbq;
                    this.laO = l.getDimens(getActivity(), R.dimen.ds10);
                    this.laK = new TbImageView(getActivity());
                    this.laK.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.laO), 0, 0);
                    this.laK.setLayoutParams(layoutParams2);
                    this.laK.startLoad(this.laL.lbp, 17, false);
                    frameLayout.addView(this.laK, layoutParams2);
                    this.laK.setVisibility(8);
                }
                e(this.rect);
                this.laC.setVisibility(8);
            }
            r.dDm().dDi().f(this.kZw, this.itemId, this.from);
        } else if (this.laH != null) {
            this.laH.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.laQ = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void e(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.laJ, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.laJ, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.laJ, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.laJ, "translationY", -rect.top);
        this.laJ.setPivotX(0.0f);
        this.laJ.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.laC.setVisibility(8);
                LegoListFragment.this.laJ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.laL.dbx()) {
                    LegoListFragment.this.laC.setVisibility(8);
                    LegoListFragment.this.dbp();
                    return;
                }
                LegoListFragment.this.laC.setVisibility(0);
                LegoListFragment.this.laJ.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbp() {
        this.laK.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.laK, "translationY", -this.laO);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.laK, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.laC.setVisibility(8);
                LegoListFragment.this.laJ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.laK.setVisibility(8);
                LegoListFragment.this.laJ.setVisibility(8);
                LegoListFragment.this.laC.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void endAnimation() {
        if (this.laK == null) {
            getActivity().finish();
            return;
        }
        this.laJ.startLoad(this.laL.picUrl, 17, false);
        float f = this.rect.top - this.laM;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.laJ.setPivotX(0.5f);
        this.laJ.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.laJ.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.laC.setVisibility(8);
                if (LegoListFragment.this.laL.dbx()) {
                    LegoListFragment.this.laK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LegoListFragment.this.getActivity().finish();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private LegoListView a(d dVar) {
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.kZF);
        legoListView.kZt.setFrom(this.from);
        if (this.laq) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.l(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(List<com.baidu.tieba.lego.c.d> list) {
        if (this.laI != null) {
            if (y.isEmpty(list)) {
                this.laI.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.laI.setVisibility(0);
                        this.laI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.lao != null) {
                                        LegoListFragment.this.lao.a(dVar);
                                        return;
                                    }
                                    return;
                                }
                                bh.skipToLoginActivity(LegoListFragment.this.getActivity());
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TextUtils.isEmpty(this.laN)) {
            this.laE.NM(this.laN);
            if (this.laE.dcP()) {
                eI(this.laE.dcO());
                this.laD.a(this.laE, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.laG) {
            dbq();
        }
    }

    private void dbq() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.laD.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
    }

    private void initModel() {
        this.laF = b.dcT().b(getPageContext(), getUniqueId());
        this.laF.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.dq(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.laG = true;
                    LegoListFragment.this.laE.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.laE.dcM()) || TextUtils.isEmpty(LegoListFragment.this.laE.dcN())) {
                        if (LegoListFragment.this.lao != null) {
                            LegoListFragment.this.lao.KF(LegoListFragment.this.laE.getTitle());
                        }
                    } else if (LegoListFragment.this.lao != null) {
                        LegoListFragment.this.lao.fG(LegoListFragment.this.laE.dcM(), LegoListFragment.this.laE.dcN());
                    }
                    if (LegoListFragment.this.lao != null) {
                        LegoListFragment.this.lao.eG(LegoListFragment.this.laE.dcO());
                    }
                    LegoListFragment.this.laD.a(LegoListFragment.this.laE, false);
                    if (LegoListFragment.this.kZF && LegoListFragment.this.laq) {
                        LegoListFragment.this.eI(LegoListFragment.this.laE.dcO());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.dq(LegoListFragment.this.getView());
                if (LegoListFragment.this.laE.hasData()) {
                    LegoListFragment.this.laD.a(LegoListFragment.this.laE, false);
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, int i) {
        if (this.kZK == null) {
            if (i < 0) {
                this.kZK = new g(getActivity());
            } else {
                this.kZK = new g(getActivity(), i);
            }
            this.kZK.onChangeSkinType();
        }
        this.kZK.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(View view) {
        if (this.kZK != null) {
            this.kZK.dettachView(view);
            this.kZK = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.laF != null) {
                        LegoListFragment.this.laF.a(2, LegoListFragment.this.kZs.lfE, LegoListFragment.this.kZs.itemId, 1, "");
                        LegoListFragment.this.WZ();
                        LegoListFragment.this.b(LegoListFragment.this.getView(), false, LegoListFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                    }
                }
            });
        }
        this.refreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.laD.setViewBackGround();
        if (this.kZO != null) {
            this.kZO.tN(false);
            this.kZO.dcC();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ktP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.laD.setViewForeground();
        if (this.kZO != null) {
            this.kZO.tN(true);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ktP, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.laD.onDestory();
        if (this.kZO != null) {
            this.kZO.destroy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ktP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gVA != null) {
            this.gVA.onChangeSkinType(com.baidu.adp.base.j.K(getActivity()), i);
        }
        if (this.laH != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.laH);
        }
        super.onChangeSkinType(i);
    }

    public void NB(String str) {
        this.laN = str;
    }

    public void fI(String str, String str2) {
        this.laL = a.C0775a.NE(str);
        this.laL.NF(str2);
    }

    public void tC(boolean z) {
        this.hasAnimation = z;
    }

    public void tD(boolean z) {
        this.laq = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.laD == null) {
            return null;
        }
        return this.laD.kZt;
    }

    public n getPlaySwitchController() {
        return this.kZO;
    }
}
