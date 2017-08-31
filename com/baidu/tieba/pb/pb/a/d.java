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
    private p ZV;
    public boolean anP;
    View cUo;
    private boolean cla;
    private View.OnClickListener cqF;
    View cxD;
    LinearLayout eFn;
    DeclareItemView eFo;
    DeclareItemView eFp;
    DeclareItemView eFq;
    DeclareItemView eFr;
    DeclareItemView eFs;
    TextView eFt;
    private boolean eFu;
    private ArrayList<a> eFv;
    private int[] eFw;
    private n eFx;
    private boolean eFy;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eFu = true;
        this.eFv = new ArrayList<>();
        this.mSkinType = 3;
        this.eFw = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eFy = false;
        this.cla = true;
        this.cqF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(d.this.mContext) && !com.baidu.tieba.pb.f.iL(d.this.anP)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        bg(view);
        this.mContext = context;
    }

    public void bg(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eFn = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.eFo = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.eFs = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.eFp = (DeclareItemView) view.findViewById(d.h.love_item);
        this.eFq = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.eFr = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.eFt = (TextView) view.findViewById(d.h.vote_count_view);
        this.cxD = view.findViewById(d.h.top_divider_line);
        this.cUo = view.findViewById(d.h.bottom_divider_line);
        if ((this.eFn.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eFn.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.eFv.add(new a(this.eFo));
        this.eFv.add(new a(this.eFs));
        this.eFv.add(new a(this.eFp));
        this.eFv.add(new a(this.eFr));
        this.eFv.add(new a(this.eFq));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aPR();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aPT();
            this.eFt.setAlpha(1.0f);
            if (this.eFu) {
                Iterator<a> it = this.eFv.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eFC.setAlpha(0.0f);
                        next.eFC.setClickable(false);
                    }
                }
                aVar.eFC.setNeedTranslate(true);
                this.eFu = false;
            }
        }
    }

    public void aPR() {
        int size = this.eFv.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eFv.get(i);
            if (aVar != null) {
                aVar.eFC.setOffSet(this.offset);
                aVar.eFC.setOnClickListener(this.cqF);
                if (i < this.eFw.length) {
                    aVar.eFD.setImageResource(this.eFw[i]);
                }
                aVar.eFE.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        int size = this.eFv.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eFv.get(i);
            if (aVar != null) {
                aVar.eFC.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eFy) {
            this.eFy = true;
            if (this.ZV != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eFn.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iV(false);
                if (this.eFu) {
                    if (aVar.eFG != null) {
                        if (aVar.eFG.Vk) {
                            a(aVar.eFG, false);
                            aVar.iW(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iV(true);
                            this.eFy = false;
                            TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eFG.Vg).f("tid", this.ZV.getTid()));
                            return;
                        }
                        if (this.ZV.pI()) {
                            Iterator<a> it = this.eFv.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eFG, false);
                                    next.iW(false);
                                    TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eFG.Vg).f("tid", this.ZV.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eFG, true);
                        aVar.iW(true);
                        TiebaStatic.log(new ak("c11999").r("obj_id", aVar.eFG.Vg).f("tid", this.ZV.getTid()));
                    }
                } else {
                    TiebaStatic.log(new ak("c12002").f("tid", this.ZV.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eFv.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eFu ? ObjectAnimator.ofFloat(next2.eFC, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eFC, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eFu) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eFu) {
                            if (aVar.eFG != null) {
                                aVar.co(aVar.eFG.Vj);
                            }
                            ObjectAnimator.ofFloat(d.this.eFt, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eFu) {
                            d.this.iV(true);
                            d.this.eFu = true;
                        } else {
                            view.setClickable(true);
                            aVar.aPT();
                            d.this.aPS();
                            ObjectAnimator.ofFloat(d.this.eFt, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eFu = false;
                        }
                        d.this.eFy = false;
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
        if (pVar != null && pVar.pF() != null) {
            this.ZV = pVar;
            aPS();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.ZV.pF().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.ZV.pF().get(i);
                if (qVar != null && i < this.eFw.length) {
                    qVar.Vl = this.eFw[i];
                }
                aVar = (a) v.c(this.eFv, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Vk) {
                        if (!this.eFu) {
                            aVar.a(qVar);
                            aVar.aPT();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eFu) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.cla) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.cla = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Vk != z) {
            if (this.eFx == null) {
                this.eFx = new n();
            }
            if (this.ZV != null) {
                this.eFx.eKB = this.ZV.pG();
                this.eFx.Vf = this.ZV.getTid();
                this.eFx.mForumId = this.ZV.getForumId();
            }
            this.eFx.eKC = qVar.Vg;
            this.eFx.eKD = z ? 1 : 0;
            this.eFx.aRh();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eFv.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aj.i(this.eFt, d.e.cp_cont_c);
            aj.k(this.cxD, d.e.cp_bg_line_c);
            aj.k(this.cUo, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPS() {
        String format;
        if (this.ZV != null && this.ZV.pI()) {
            long bC = this.ZV.bC(this.eFw.length);
            if (bC > 0) {
                if (this.ZV.pH()) {
                    if (bC == 1) {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_other_to_host), am.u(bC));
                    }
                } else if (bC == 1) {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_we_to_host), am.u(bC - 1));
                }
                this.eFt.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eFC;
        public TbImageView eFD;
        public TextView eFE;
        private String eFF;
        public q eFG;
        private final int eFH;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eFH = 3;
            if (declareItemView != null) {
                this.eFC = declareItemView;
                this.eFD = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.eFE = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.i(this.eFE, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eFG = qVar;
                co(qVar.Vj);
                if (!StringUtils.isNull(qVar.Vi)) {
                    this.eFF = qVar.Vi;
                }
                if (!StringUtils.isNull(qVar.Vh)) {
                    this.eFD.c(qVar.Vh, 10, false);
                } else {
                    this.eFD.setImageResource(qVar.Vl);
                }
                iW(qVar.Vk);
            }
        }

        public void iW(boolean z) {
            if (this.eFG != null && this.eFG.Vk != z) {
                if (z) {
                    co(this.eFG.Vj + 1);
                    this.eFE.setSelected(true);
                } else {
                    co(this.eFG.Vj - 1);
                    this.eFE.setSelected(false);
                }
                this.eFG.Vk = z;
            }
        }

        public void co(long j) {
            if (this.eFG != null && j >= 0) {
                this.eFG.Vj = j;
            }
            this.eFE.setText(am.u(j));
        }

        public void aPT() {
            this.eFE.setText(am.d(this.eFF, 3, null));
            this.eFE.setSelected(true);
        }
    }
}
