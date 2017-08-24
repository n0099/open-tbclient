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
    private p aaQ;
    public boolean aou;
    View cNX;
    private boolean cgS;
    private View.OnClickListener clm;
    View cqZ;
    LinearLayout eGT;
    DeclareItemView eGU;
    DeclareItemView eGV;
    DeclareItemView eGW;
    DeclareItemView eGX;
    DeclareItemView eGY;
    TextView eGZ;
    private boolean eHa;
    private ArrayList<a> eHb;
    private int[] eHc;
    private n eHd;
    private boolean eHe;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eHa = true;
        this.eHb = new ArrayList<>();
        this.mSkinType = 3;
        this.eHc = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eHe = false;
        this.cgS = true;
        this.clm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(d.this.mContext) && !com.baidu.tieba.pb.f.iL(d.this.aou)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        aZ(view);
        this.mContext = context;
    }

    public void aZ(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eGT = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.eGU = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.eGY = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.eGV = (DeclareItemView) view.findViewById(d.h.love_item);
        this.eGW = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.eGX = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.eGZ = (TextView) view.findViewById(d.h.vote_count_view);
        this.cqZ = view.findViewById(d.h.top_divider_line);
        this.cNX = view.findViewById(d.h.bottom_divider_line);
        if ((this.eGT.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eGT.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.eHb.add(new a(this.eGU));
        this.eHb.add(new a(this.eGY));
        this.eHb.add(new a(this.eGV));
        this.eHb.add(new a(this.eGX));
        this.eHb.add(new a(this.eGW));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQE();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aQG();
            this.eGZ.setAlpha(1.0f);
            if (this.eHa) {
                Iterator<a> it = this.eHb.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eHi.setAlpha(0.0f);
                        next.eHi.setClickable(false);
                    }
                }
                aVar.eHi.setNeedTranslate(true);
                this.eHa = false;
            }
        }
    }

    public void aQE() {
        int size = this.eHb.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eHb.get(i);
            if (aVar != null) {
                aVar.eHi.setOffSet(this.offset);
                aVar.eHi.setOnClickListener(this.clm);
                if (i < this.eHc.length) {
                    aVar.eHj.setImageResource(this.eHc[i]);
                }
                aVar.eHk.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        int size = this.eHb.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eHb.get(i);
            if (aVar != null) {
                aVar.eHi.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eHe) {
            this.eHe = true;
            if (this.aaQ != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eGT.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iV(false);
                if (this.eHa) {
                    if (aVar.eHm != null) {
                        if (aVar.eHm.Wh) {
                            a(aVar.eHm, false);
                            aVar.iW(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iV(true);
                            this.eHe = false;
                            TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eHm.Wd).g("tid", this.aaQ.getTid()));
                            return;
                        }
                        if (this.aaQ.pO()) {
                            Iterator<a> it = this.eHb.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eHm, false);
                                    next.iW(false);
                                    TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eHm.Wd).g("tid", this.aaQ.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eHm, true);
                        aVar.iW(true);
                        TiebaStatic.log(new aj("c11999").r("obj_id", aVar.eHm.Wd).g("tid", this.aaQ.getTid()));
                    }
                } else {
                    TiebaStatic.log(new aj("c12002").g("tid", this.aaQ.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eHb.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eHa ? ObjectAnimator.ofFloat(next2.eHi, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eHi, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eHa) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eHa) {
                            if (aVar.eHm != null) {
                                aVar.ct(aVar.eHm.Wg);
                            }
                            ObjectAnimator.ofFloat(d.this.eGZ, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eHa) {
                            d.this.iV(true);
                            d.this.eHa = true;
                        } else {
                            view.setClickable(true);
                            aVar.aQG();
                            d.this.aQF();
                            ObjectAnimator.ofFloat(d.this.eGZ, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eHa = false;
                        }
                        d.this.eHe = false;
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
        if (pVar != null && pVar.pL() != null) {
            this.aaQ = pVar;
            aQF();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.aaQ.pL().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.aaQ.pL().get(i);
                if (qVar != null && i < this.eHc.length) {
                    qVar.mDefaultImageId = this.eHc[i];
                }
                aVar = (a) u.c(this.eHb, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Wh) {
                        if (!this.eHa) {
                            aVar.a(qVar);
                            aVar.aQG();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eHa) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.cgS) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.cgS = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Wh != z) {
            if (this.eHd == null) {
                this.eHd = new n();
            }
            if (this.aaQ != null) {
                this.eHd.eMk = this.aaQ.pM();
                this.eHd.Wc = this.aaQ.getTid();
                this.eHd.mForumId = this.aaQ.getForumId();
            }
            this.eHd.eMl = qVar.Wd;
            this.eHd.eMm = z ? 1 : 0;
            this.eHd.aRQ();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eHb.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            ai.i(this.eGZ, d.e.cp_cont_c);
            ai.k(this.cqZ, d.e.cp_bg_line_c);
            ai.k(this.cNX, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQF() {
        String format;
        if (this.aaQ != null && this.aaQ.pO()) {
            long bC = this.aaQ.bC(this.eHc.length);
            if (bC > 0) {
                if (this.aaQ.pN()) {
                    if (bC == 1) {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_other_to_host), al.u(bC));
                    }
                } else if (bC == 1) {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_we_to_host), al.u(bC - 1));
                }
                this.eGZ.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eHi;
        public TbImageView eHj;
        public TextView eHk;
        private String eHl;
        public q eHm;
        private final int eHn;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eHn = 3;
            if (declareItemView != null) {
                this.eHi = declareItemView;
                this.eHj = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.eHk = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                ai.i(this.eHk, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eHm = qVar;
                ct(qVar.Wg);
                if (!StringUtils.isNull(qVar.Wf)) {
                    this.eHl = qVar.Wf;
                }
                if (!StringUtils.isNull(qVar.We)) {
                    this.eHj.c(qVar.We, 10, false);
                } else {
                    this.eHj.setImageResource(qVar.mDefaultImageId);
                }
                iW(qVar.Wh);
            }
        }

        public void iW(boolean z) {
            if (this.eHm != null && this.eHm.Wh != z) {
                if (z) {
                    ct(this.eHm.Wg + 1);
                    this.eHk.setSelected(true);
                } else {
                    ct(this.eHm.Wg - 1);
                    this.eHk.setSelected(false);
                }
                this.eHm.Wh = z;
            }
        }

        public void ct(long j) {
            if (this.eHm != null && j >= 0) {
                this.eHm.Wg = j;
            }
            this.eHk.setText(al.u(j));
        }

        public void aQG() {
            this.eHk.setText(al.d(this.eHl, 3, null));
            this.eHk.setSelected(true);
        }
    }
}
