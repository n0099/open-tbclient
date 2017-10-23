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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.view.DeclareItemView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends j.a {
    private p ZJ;
    public boolean amP;
    View cUK;
    private boolean clB;
    private View.OnClickListener crI;
    View czb;
    private boolean ezA;
    LinearLayout ezp;
    DeclareItemView ezq;
    DeclareItemView ezr;
    DeclareItemView ezs;
    DeclareItemView ezt;
    DeclareItemView ezu;
    TextView ezv;
    private boolean ezw;
    private ArrayList<a> ezx;
    private int[] ezy;
    private n ezz;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.ezw = true;
        this.ezx = new ArrayList<>();
        this.mSkinType = 3;
        this.ezy = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.ezA = false;
        this.clB = true;
        this.crI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(d.this.mContext) && !com.baidu.tieba.pb.f.iv(d.this.amP)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        bc(view);
        this.mContext = context;
    }

    public void bc(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.ezp = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.ezq = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.ezu = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.ezr = (DeclareItemView) view.findViewById(d.h.love_item);
        this.ezs = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.ezt = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.ezv = (TextView) view.findViewById(d.h.vote_count_view);
        this.czb = view.findViewById(d.h.top_divider_line);
        this.cUK = view.findViewById(d.h.bottom_divider_line);
        if ((this.ezp.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.ezp.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - l.f(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.ezx.add(new a(this.ezq));
        this.ezx.add(new a(this.ezu));
        this.ezx.add(new a(this.ezr));
        this.ezx.add(new a(this.ezt));
        this.ezx.add(new a(this.ezs));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aNR();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aNT();
            this.ezv.setAlpha(1.0f);
            if (this.ezw) {
                Iterator<a> it = this.ezx.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.ezE.setAlpha(0.0f);
                        next.ezE.setClickable(false);
                    }
                }
                aVar.ezE.setNeedTranslate(true);
                this.ezw = false;
            }
        }
    }

    public void aNR() {
        int size = this.ezx.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.ezx.get(i);
            if (aVar != null) {
                aVar.ezE.setOffSet(this.offset);
                aVar.ezE.setOnClickListener(this.crI);
                if (i < this.ezy.length) {
                    aVar.ezF.setImageResource(this.ezy[i]);
                }
                aVar.ezG.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG(boolean z) {
        int size = this.ezx.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.ezx.get(i);
            if (aVar != null) {
                aVar.ezE.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.ezA) {
            this.ezA = true;
            if (this.ZJ != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.ezp.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iG(false);
                if (this.ezw) {
                    if (aVar.ezI != null) {
                        if (aVar.ezI.Vm) {
                            a(aVar.ezI, false);
                            aVar.iH(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iG(true);
                            this.ezA = false;
                            TiebaStatic.log(new ak("c12000").r("obj_id", aVar.ezI.Vi).f("tid", this.ZJ.getTid()));
                            return;
                        }
                        if (this.ZJ.pC()) {
                            Iterator<a> it = this.ezx.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.ezI, false);
                                    next.iH(false);
                                    TiebaStatic.log(new ak("c12000").r("obj_id", aVar.ezI.Vi).f("tid", this.ZJ.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.ezI, true);
                        aVar.iH(true);
                        TiebaStatic.log(new ak("c11999").r("obj_id", aVar.ezI.Vi).f("tid", this.ZJ.getTid()));
                    }
                } else {
                    TiebaStatic.log(new ak("c12002").f("tid", this.ZJ.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.ezx.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.ezw ? ObjectAnimator.ofFloat(next2.ezE, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.ezE, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.ezw) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.ezw) {
                            if (aVar.ezI != null) {
                                aVar.cm(aVar.ezI.Vl);
                            }
                            ObjectAnimator.ofFloat(d.this.ezv, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.ezw) {
                            d.this.iG(true);
                            d.this.ezw = true;
                        } else {
                            view.setClickable(true);
                            aVar.aNT();
                            d.this.aNS();
                            ObjectAnimator.ofFloat(d.this.ezv, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.ezw = false;
                        }
                        d.this.ezA = false;
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
        if (pVar != null && pVar.pz() != null) {
            this.ZJ = pVar;
            aNS();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.ZJ.pz().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.ZJ.pz().get(i);
                if (qVar != null && i < this.ezy.length) {
                    qVar.Vn = this.ezy[i];
                }
                aVar = (a) v.c(this.ezx, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Vm) {
                        if (!this.ezw) {
                            aVar.a(qVar);
                            aVar.aNT();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.ezw) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.clB) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.clB = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Vm != z) {
            if (this.ezz == null) {
                this.ezz = new n();
            }
            if (this.ZJ != null) {
                this.ezz.eEG = this.ZJ.pA();
                this.ezz.Vh = this.ZJ.getTid();
                this.ezz.mForumId = this.ZJ.getForumId();
            }
            this.ezz.eEH = qVar.Vi;
            this.ezz.eEI = z ? 1 : 0;
            this.ezz.aPj();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.ezx.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aj.i(this.ezv, d.e.cp_cont_c);
            aj.k(this.czb, d.e.cp_bg_line_c);
            aj.k(this.cUK, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNS() {
        String format;
        if (this.ZJ != null && this.ZJ.pC()) {
            long bF = this.ZJ.bF(this.ezy.length);
            if (bF > 0) {
                if (this.ZJ.pB()) {
                    if (bF == 1) {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_other_to_host), am.u(bF));
                    }
                } else if (bF == 1) {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_we_to_host), am.u(bF - 1));
                }
                this.ezv.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView ezE;
        public TbImageView ezF;
        public TextView ezG;
        private String ezH;
        public q ezI;
        private final int ezJ;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.ezJ = 3;
            if (declareItemView != null) {
                this.ezE = declareItemView;
                this.ezF = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.ezG = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.i(this.ezG, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.ezI = qVar;
                cm(qVar.Vl);
                if (!StringUtils.isNull(qVar.Vk)) {
                    this.ezH = qVar.Vk;
                }
                if (!StringUtils.isNull(qVar.Vj)) {
                    this.ezF.c(qVar.Vj, 10, false);
                } else {
                    this.ezF.setImageResource(qVar.Vn);
                }
                iH(qVar.Vm);
            }
        }

        public void iH(boolean z) {
            if (this.ezI != null && this.ezI.Vm != z) {
                if (z) {
                    cm(this.ezI.Vl + 1);
                    this.ezG.setSelected(true);
                } else {
                    cm(this.ezI.Vl - 1);
                    this.ezG.setSelected(false);
                }
                this.ezI.Vm = z;
            }
        }

        public void cm(long j) {
            if (this.ezI != null && j >= 0) {
                this.ezI.Vl = j;
            }
            this.ezG.setText(am.u(j));
        }

        public void aNT() {
            this.ezG.setText(am.d(this.ezH, 3, null));
            this.ezG.setSelected(true);
        }
    }
}
