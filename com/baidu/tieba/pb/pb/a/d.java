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
import com.baidu.tieba.pb.view.DeclareItemView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends j.a {
    private p aae;
    public boolean anj;
    View cHj;
    private boolean ctp;
    private View.OnClickListener czv;
    View dfj;
    LinearLayout eHM;
    DeclareItemView eHN;
    DeclareItemView eHO;
    DeclareItemView eHP;
    DeclareItemView eHQ;
    DeclareItemView eHR;
    TextView eHS;
    private boolean eHT;
    private ArrayList<a> eHU;
    private int[] eHV;
    private com.baidu.tieba.pb.pb.main.p eHW;
    private boolean eHX;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eHT = true;
        this.eHU = new ArrayList<>();
        this.mSkinType = 3;
        this.eHV = new int[]{d.f.image_emoticon_huaji, d.f.image_emoticon_zan, d.f.image_emoticon_love, d.f.image_emoticon_shuitei, d.f.image_emoticon_shengqi};
        this.offset = 0;
        this.eHX = false;
        this.ctp = true;
        this.czv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(d.this.mContext)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        bh(view);
        this.mContext = context;
    }

    public void bh(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eHM = (LinearLayout) view.findViewById(d.g.emotion_vote);
        this.eHN = (DeclareItemView) view.findViewById(d.g.huaji_item);
        this.eHR = (DeclareItemView) view.findViewById(d.g.zan_item);
        this.eHO = (DeclareItemView) view.findViewById(d.g.love_item);
        this.eHP = (DeclareItemView) view.findViewById(d.g.shengqi_item);
        this.eHQ = (DeclareItemView) view.findViewById(d.g.tushui_item);
        this.eHS = (TextView) view.findViewById(d.g.vote_count_view);
        this.cHj = view.findViewById(d.g.top_divider_line);
        this.dfj = view.findViewById(d.g.bottom_divider_line);
        if ((this.eHM.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eHM.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        }
        this.eHU.add(new a(this.eHN));
        this.eHU.add(new a(this.eHR));
        this.eHU.add(new a(this.eHO));
        this.eHU.add(new a(this.eHQ));
        this.eHU.add(new a(this.eHP));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQS();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aQU();
            this.eHS.setAlpha(1.0f);
            if (this.eHT) {
                Iterator<a> it = this.eHU.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eIb.setAlpha(0.0f);
                        next.eIb.setClickable(false);
                    }
                }
                aVar.eIb.setNeedTranslate(true);
                this.eHT = false;
            }
        }
    }

    public void aQS() {
        int size = this.eHU.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eHU.get(i);
            if (aVar != null) {
                aVar.eIb.setOffSet(this.offset);
                aVar.eIb.setOnClickListener(this.czv);
                if (i < this.eHV.length) {
                    aVar.eIc.setImageResource(this.eHV[i]);
                }
                aVar.eId.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(boolean z) {
        int size = this.eHU.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eHU.get(i);
            if (aVar != null) {
                aVar.eIb.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eHX) {
            this.eHX = true;
            if (this.aae != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eHM.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iH(false);
                if (this.eHT) {
                    if (aVar.eIf != null) {
                        if (aVar.eIf.VE) {
                            a(aVar.eIf, false);
                            aVar.iI(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iH(true);
                            this.eHX = false;
                            TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eIf.VA).f("tid", this.aae.getTid()));
                            return;
                        }
                        if (this.aae.pH()) {
                            Iterator<a> it = this.eHU.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eIf, false);
                                    next.iI(false);
                                    TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eIf.VA).f("tid", this.aae.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eIf, true);
                        aVar.iI(true);
                        TiebaStatic.log(new ak("c11999").r("obj_id", aVar.eIf.VA).f("tid", this.aae.getTid()));
                    }
                } else {
                    TiebaStatic.log(new ak("c12002").f("tid", this.aae.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eHU.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eHT ? ObjectAnimator.ofFloat(next2.eIb, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eIb, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eHT) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eHT) {
                            if (aVar.eIf != null) {
                                aVar.cn(aVar.eIf.VD);
                            }
                            ObjectAnimator.ofFloat(d.this.eHS, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eHT) {
                            d.this.iH(true);
                            d.this.eHT = true;
                        } else {
                            view.setClickable(true);
                            aVar.aQU();
                            d.this.aQT();
                            ObjectAnimator.ofFloat(d.this.eHS, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eHT = false;
                        }
                        d.this.eHX = false;
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
        if (pVar != null && pVar.pE() != null) {
            this.aae = pVar;
            aQT();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.aae.pE().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.aae.pE().get(i);
                if (qVar != null && i < this.eHV.length) {
                    qVar.VF = this.eHV[i];
                }
                aVar = (a) v.c(this.eHU, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.VE) {
                        if (!this.eHT) {
                            aVar.a(qVar);
                            aVar.aQU();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eHT) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.ctp) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ctp = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.VE != z) {
            if (this.eHW == null) {
                this.eHW = new com.baidu.tieba.pb.pb.main.p();
            }
            if (this.aae != null) {
                this.eHW.eNL = this.aae.pF();
                this.eHW.Vz = this.aae.getTid();
                this.eHW.mForumId = this.aae.getForumId();
            }
            this.eHW.eNM = qVar.VA;
            this.eHW.eNN = z ? 1 : 0;
            this.eHW.aSx();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eHU.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aj.i(this.eHS, d.C0080d.cp_cont_c);
            aj.k(this.cHj, d.C0080d.cp_bg_line_c);
            aj.k(this.dfj, d.C0080d.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQT() {
        String format;
        if (this.aae != null && this.aae.pH()) {
            long bD = this.aae.bD(this.eHV.length);
            if (bD > 0) {
                if (this.aae.pG()) {
                    if (bD == 1) {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.j.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.j.declare_text_other_to_host), am.u(bD));
                    }
                } else if (bD == 1) {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.j.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.j.declare_text_we_to_host), am.u(bD - 1));
                }
                this.eHS.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eIb;
        public TbImageView eIc;
        public TextView eId;
        private String eIe;
        public q eIf;
        private final int eIg;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eIg = 3;
            if (declareItemView != null) {
                this.eIb = declareItemView;
                this.eIc = (TbImageView) declareItemView.findViewById(d.g.declare_image);
                this.eId = (TextView) declareItemView.findViewById(d.g.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.i(this.eId, d.f.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eIf = qVar;
                cn(qVar.VD);
                if (!StringUtils.isNull(qVar.VC)) {
                    this.eIe = qVar.VC;
                }
                if (!StringUtils.isNull(qVar.VB)) {
                    this.eIc.startLoad(qVar.VB, 10, false);
                } else {
                    this.eIc.setImageResource(qVar.VF);
                }
                iI(qVar.VE);
            }
        }

        public void iI(boolean z) {
            if (this.eIf != null && this.eIf.VE != z) {
                if (z) {
                    cn(this.eIf.VD + 1);
                    this.eId.setSelected(true);
                } else {
                    cn(this.eIf.VD - 1);
                    this.eId.setSelected(false);
                }
                this.eIf.VE = z;
            }
        }

        public void cn(long j) {
            if (this.eIf != null && j >= 0) {
                this.eIf.VD = j;
            }
            this.eId.setText(am.u(j));
        }

        public void aQU() {
            this.eId.setText(am.d(this.eIe, 3, null));
            this.eId.setSelected(true);
        }
    }
}
