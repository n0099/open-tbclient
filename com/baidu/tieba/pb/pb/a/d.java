package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.view.DeclareItemView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends j.a {
    private p Zs;
    public boolean ana;
    View cKF;
    private boolean ceZ;
    private View.OnClickListener cjs;
    View cpg;
    LinearLayout eDK;
    DeclareItemView eDL;
    DeclareItemView eDM;
    DeclareItemView eDN;
    DeclareItemView eDO;
    DeclareItemView eDP;
    TextView eDQ;
    private boolean eDR;
    private ArrayList<a> eDS;
    private int[] eDT;
    private n eDU;
    private boolean eDV;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eDR = true;
        this.eDS = new ArrayList<>();
        this.mSkinType = 3;
        this.eDT = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eDV = false;
        this.ceZ = true;
        this.cjs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aN(d.this.mContext) && !com.baidu.tieba.pb.f.iI(d.this.ana)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        aY(view);
        this.mContext = context;
    }

    public void aY(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eDK = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.eDL = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.eDP = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.eDM = (DeclareItemView) view.findViewById(d.h.love_item);
        this.eDN = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.eDO = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.eDQ = (TextView) view.findViewById(d.h.vote_count_view);
        this.cpg = view.findViewById(d.h.top_divider_line);
        this.cKF = view.findViewById(d.h.bottom_divider_line);
        if ((this.eDK.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eDK.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.eDS.add(new a(this.eDL));
        this.eDS.add(new a(this.eDP));
        this.eDS.add(new a(this.eDM));
        this.eDS.add(new a(this.eDO));
        this.eDS.add(new a(this.eDN));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aPR();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aPT();
            this.eDQ.setAlpha(1.0f);
            if (this.eDR) {
                Iterator<a> it = this.eDS.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eDZ.setAlpha(0.0f);
                        next.eDZ.setClickable(false);
                    }
                }
                aVar.eDZ.setNeedTranslate(true);
                this.eDR = false;
            }
        }
    }

    public void aPR() {
        int size = this.eDS.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eDS.get(i);
            if (aVar != null) {
                aVar.eDZ.setOffSet(this.offset);
                aVar.eDZ.setOnClickListener(this.cjs);
                if (i < this.eDT.length) {
                    aVar.eEa.setImageResource(this.eDT[i]);
                }
                aVar.eEb.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(boolean z) {
        int size = this.eDS.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eDS.get(i);
            if (aVar != null) {
                aVar.eDZ.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eDV) {
            this.eDV = true;
            if (this.Zs != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eDK.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iS(false);
                if (this.eDR) {
                    if (aVar.eEd != null) {
                        if (aVar.eEd.UG) {
                            a(aVar.eEd, false);
                            aVar.iT(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iS(true);
                            this.eDV = false;
                            TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eEd.UC).f("tid", this.Zs.getTid()));
                            return;
                        }
                        if (this.Zs.pD()) {
                            Iterator<a> it = this.eDS.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eEd, false);
                                    next.iT(false);
                                    TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eEd.UC).f("tid", this.Zs.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eEd, true);
                        aVar.iT(true);
                        TiebaStatic.log(new aj("c11999").r("obj_id", aVar.eEd.UC).f("tid", this.Zs.getTid()));
                    }
                } else {
                    TiebaStatic.log(new aj("c12002").f("tid", this.Zs.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eDS.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eDR ? ObjectAnimator.ofFloat(next2.eDZ, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eDZ, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eDR) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eDR) {
                            if (aVar.eEd != null) {
                                aVar.ct(aVar.eEd.UF);
                            }
                            ObjectAnimator.ofFloat(d.this.eDQ, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eDR) {
                            d.this.iS(true);
                            d.this.eDR = true;
                        } else {
                            view.setClickable(true);
                            aVar.aPT();
                            d.this.aPS();
                            ObjectAnimator.ofFloat(d.this.eDQ, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eDR = false;
                        }
                        d.this.eDV = false;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                animatorSet3.setDuration(j).start();
            }
        }
    }

    public void a(p pVar) {
        a aVar;
        if (pVar != null && pVar.pA() != null) {
            this.Zs = pVar;
            aPS();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.Zs.pA().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.Zs.pA().get(i);
                if (qVar != null && i < this.eDT.length) {
                    qVar.UH = this.eDT[i];
                }
                aVar = (a) u.c(this.eDS, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.UG) {
                        if (!this.eDR) {
                            aVar.a(qVar);
                            aVar.aPT();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eDR) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.ceZ) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ceZ = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.UG != z) {
            if (this.eDU == null) {
                this.eDU = new n();
            }
            if (this.Zs != null) {
                this.eDU.eJb = this.Zs.pB();
                this.eDU.UB = this.Zs.getTid();
                this.eDU.mForumId = this.Zs.getForumId();
            }
            this.eDU.eJc = qVar.UC;
            this.eDU.eJd = z ? 1 : 0;
            this.eDU.aRd();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eDS.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            ai.i(this.eDQ, d.e.cp_cont_c);
            ai.k(this.cpg, d.e.cp_bg_line_c);
            ai.k(this.cKF, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPS() {
        String format;
        if (this.Zs != null && this.Zs.pD()) {
            long bA = this.Zs.bA(this.eDT.length);
            if (bA > 0) {
                if (this.Zs.pC()) {
                    if (bA == 1) {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_other_to_host), al.u(bA));
                    }
                } else if (bA == 1) {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_we_to_host), al.u(bA - 1));
                }
                this.eDQ.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eDZ;
        public TbImageView eEa;
        public TextView eEb;
        private String eEc;
        public q eEd;
        private final int eEe;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eEe = 3;
            if (declareItemView != null) {
                this.eDZ = declareItemView;
                this.eEa = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.eEb = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                ai.i(this.eEb, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eEd = qVar;
                ct(qVar.UF);
                if (!StringUtils.isNull(qVar.UE)) {
                    this.eEc = qVar.UE;
                }
                if (!StringUtils.isNull(qVar.UD)) {
                    this.eEa.c(qVar.UD, 10, false);
                } else {
                    this.eEa.setImageResource(qVar.UH);
                }
                iT(qVar.UG);
            }
        }

        public void iT(boolean z) {
            if (this.eEd != null && this.eEd.UG != z) {
                if (z) {
                    ct(this.eEd.UF + 1);
                    this.eEb.setSelected(true);
                } else {
                    ct(this.eEd.UF - 1);
                    this.eEb.setSelected(false);
                }
                this.eEd.UG = z;
            }
        }

        public void ct(long j) {
            if (this.eEd != null && j >= 0) {
                this.eEd.UF = j;
            }
            this.eEb.setText(al.u(j));
        }

        public void aPT() {
            this.eEb.setText(al.c(this.eEc, 3, null));
            this.eEb.setSelected(true);
        }
    }
}
