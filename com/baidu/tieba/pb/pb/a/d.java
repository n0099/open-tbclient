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
    public boolean ank;
    View cGQ;
    private boolean csW;
    private View.OnClickListener czc;
    View deP;
    private ArrayList<a> eHA;
    private int[] eHB;
    private com.baidu.tieba.pb.pb.main.p eHC;
    private boolean eHD;
    LinearLayout eHs;
    DeclareItemView eHt;
    DeclareItemView eHu;
    DeclareItemView eHv;
    DeclareItemView eHw;
    DeclareItemView eHx;
    TextView eHy;
    private boolean eHz;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eHz = true;
        this.eHA = new ArrayList<>();
        this.mSkinType = 3;
        this.eHB = new int[]{d.f.image_emoticon_huaji, d.f.image_emoticon_zan, d.f.image_emoticon_love, d.f.image_emoticon_shuitei, d.f.image_emoticon_shengqi};
        this.offset = 0;
        this.eHD = false;
        this.csW = true;
        this.czc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(d.this.mContext)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        bg(view);
        this.mContext = context;
    }

    public void bg(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eHs = (LinearLayout) view.findViewById(d.g.emotion_vote);
        this.eHt = (DeclareItemView) view.findViewById(d.g.huaji_item);
        this.eHx = (DeclareItemView) view.findViewById(d.g.zan_item);
        this.eHu = (DeclareItemView) view.findViewById(d.g.love_item);
        this.eHv = (DeclareItemView) view.findViewById(d.g.shengqi_item);
        this.eHw = (DeclareItemView) view.findViewById(d.g.tushui_item);
        this.eHy = (TextView) view.findViewById(d.g.vote_count_view);
        this.cGQ = view.findViewById(d.g.top_divider_line);
        this.deP = view.findViewById(d.g.bottom_divider_line);
        if ((this.eHs.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eHs.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        }
        this.eHA.add(new a(this.eHt));
        this.eHA.add(new a(this.eHx));
        this.eHA.add(new a(this.eHu));
        this.eHA.add(new a(this.eHw));
        this.eHA.add(new a(this.eHv));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQK();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aQM();
            this.eHy.setAlpha(1.0f);
            if (this.eHz) {
                Iterator<a> it = this.eHA.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eHH.setAlpha(0.0f);
                        next.eHH.setClickable(false);
                    }
                }
                aVar.eHH.setNeedTranslate(true);
                this.eHz = false;
            }
        }
    }

    public void aQK() {
        int size = this.eHA.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eHA.get(i);
            if (aVar != null) {
                aVar.eHH.setOffSet(this.offset);
                aVar.eHH.setOnClickListener(this.czc);
                if (i < this.eHB.length) {
                    aVar.eHI.setImageResource(this.eHB[i]);
                }
                aVar.eHJ.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        int size = this.eHA.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eHA.get(i);
            if (aVar != null) {
                aVar.eHH.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eHD) {
            this.eHD = true;
            if (this.aae != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eHs.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iB(false);
                if (this.eHz) {
                    if (aVar.eHL != null) {
                        if (aVar.eHL.VE) {
                            a(aVar.eHL, false);
                            aVar.iC(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iB(true);
                            this.eHD = false;
                            TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eHL.VA).f("tid", this.aae.getTid()));
                            return;
                        }
                        if (this.aae.pH()) {
                            Iterator<a> it = this.eHA.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eHL, false);
                                    next.iC(false);
                                    TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eHL.VA).f("tid", this.aae.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eHL, true);
                        aVar.iC(true);
                        TiebaStatic.log(new ak("c11999").r("obj_id", aVar.eHL.VA).f("tid", this.aae.getTid()));
                    }
                } else {
                    TiebaStatic.log(new ak("c12002").f("tid", this.aae.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eHA.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eHz ? ObjectAnimator.ofFloat(next2.eHH, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eHH, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eHz) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eHz) {
                            if (aVar.eHL != null) {
                                aVar.cn(aVar.eHL.VD);
                            }
                            ObjectAnimator.ofFloat(d.this.eHy, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eHz) {
                            d.this.iB(true);
                            d.this.eHz = true;
                        } else {
                            view.setClickable(true);
                            aVar.aQM();
                            d.this.aQL();
                            ObjectAnimator.ofFloat(d.this.eHy, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eHz = false;
                        }
                        d.this.eHD = false;
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
            aQL();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.aae.pE().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.aae.pE().get(i);
                if (qVar != null && i < this.eHB.length) {
                    qVar.VF = this.eHB[i];
                }
                aVar = (a) v.c(this.eHA, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.VE) {
                        if (!this.eHz) {
                            aVar.a(qVar);
                            aVar.aQM();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eHz) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.csW) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.csW = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.VE != z) {
            if (this.eHC == null) {
                this.eHC = new com.baidu.tieba.pb.pb.main.p();
            }
            if (this.aae != null) {
                this.eHC.eNr = this.aae.pF();
                this.eHC.Vz = this.aae.getTid();
                this.eHC.mForumId = this.aae.getForumId();
            }
            this.eHC.eNs = qVar.VA;
            this.eHC.eNt = z ? 1 : 0;
            this.eHC.aSp();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eHA.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aj.i(this.eHy, d.C0080d.cp_cont_c);
            aj.k(this.cGQ, d.C0080d.cp_bg_line_c);
            aj.k(this.deP, d.C0080d.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQL() {
        String format;
        if (this.aae != null && this.aae.pH()) {
            long bD = this.aae.bD(this.eHB.length);
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
                this.eHy.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eHH;
        public TbImageView eHI;
        public TextView eHJ;
        private String eHK;
        public q eHL;
        private final int eHM;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eHM = 3;
            if (declareItemView != null) {
                this.eHH = declareItemView;
                this.eHI = (TbImageView) declareItemView.findViewById(d.g.declare_image);
                this.eHJ = (TextView) declareItemView.findViewById(d.g.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.i(this.eHJ, d.f.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eHL = qVar;
                cn(qVar.VD);
                if (!StringUtils.isNull(qVar.VC)) {
                    this.eHK = qVar.VC;
                }
                if (!StringUtils.isNull(qVar.VB)) {
                    this.eHI.startLoad(qVar.VB, 10, false);
                } else {
                    this.eHI.setImageResource(qVar.VF);
                }
                iC(qVar.VE);
            }
        }

        public void iC(boolean z) {
            if (this.eHL != null && this.eHL.VE != z) {
                if (z) {
                    cn(this.eHL.VD + 1);
                    this.eHJ.setSelected(true);
                } else {
                    cn(this.eHL.VD - 1);
                    this.eHJ.setSelected(false);
                }
                this.eHL.VE = z;
            }
        }

        public void cn(long j) {
            if (this.eHL != null && j >= 0) {
                this.eHL.VD = j;
            }
            this.eHJ.setText(am.u(j));
        }

        public void aQM() {
            this.eHJ.setText(am.d(this.eHK, 3, null));
            this.eHJ.setSelected(true);
        }
    }
}
