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
    private boolean cgR;
    private View.OnClickListener cll;
    View cqZ;
    LinearLayout eGR;
    DeclareItemView eGS;
    DeclareItemView eGT;
    DeclareItemView eGU;
    DeclareItemView eGV;
    DeclareItemView eGW;
    TextView eGX;
    private boolean eGY;
    private ArrayList<a> eGZ;
    private int[] eHa;
    private n eHb;
    private boolean eHc;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eGY = true;
        this.eGZ = new ArrayList<>();
        this.mSkinType = 3;
        this.eHa = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eHc = false;
        this.cgR = true;
        this.cll = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(d.this.mContext) && !com.baidu.tieba.pb.f.iL(d.this.aou)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        ba(view);
        this.mContext = context;
    }

    public void ba(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eGR = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.eGS = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.eGW = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.eGT = (DeclareItemView) view.findViewById(d.h.love_item);
        this.eGU = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.eGV = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.eGX = (TextView) view.findViewById(d.h.vote_count_view);
        this.cqZ = view.findViewById(d.h.top_divider_line);
        this.cNX = view.findViewById(d.h.bottom_divider_line);
        if ((this.eGR.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eGR.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.eGZ.add(new a(this.eGS));
        this.eGZ.add(new a(this.eGW));
        this.eGZ.add(new a(this.eGT));
        this.eGZ.add(new a(this.eGV));
        this.eGZ.add(new a(this.eGU));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQJ();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aQL();
            this.eGX.setAlpha(1.0f);
            if (this.eGY) {
                Iterator<a> it = this.eGZ.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eHg.setAlpha(0.0f);
                        next.eHg.setClickable(false);
                    }
                }
                aVar.eHg.setNeedTranslate(true);
                this.eGY = false;
            }
        }
    }

    public void aQJ() {
        int size = this.eGZ.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eGZ.get(i);
            if (aVar != null) {
                aVar.eHg.setOffSet(this.offset);
                aVar.eHg.setOnClickListener(this.cll);
                if (i < this.eHa.length) {
                    aVar.eHh.setImageResource(this.eHa[i]);
                }
                aVar.eHi.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        int size = this.eGZ.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eGZ.get(i);
            if (aVar != null) {
                aVar.eHg.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eHc) {
            this.eHc = true;
            if (this.aaQ != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eGR.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iV(false);
                if (this.eGY) {
                    if (aVar.eHk != null) {
                        if (aVar.eHk.Wg) {
                            a(aVar.eHk, false);
                            aVar.iW(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iV(true);
                            this.eHc = false;
                            TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eHk.Wc).g("tid", this.aaQ.getTid()));
                            return;
                        }
                        if (this.aaQ.pN()) {
                            Iterator<a> it = this.eGZ.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eHk, false);
                                    next.iW(false);
                                    TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eHk.Wc).g("tid", this.aaQ.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eHk, true);
                        aVar.iW(true);
                        TiebaStatic.log(new aj("c11999").r("obj_id", aVar.eHk.Wc).g("tid", this.aaQ.getTid()));
                    }
                } else {
                    TiebaStatic.log(new aj("c12002").g("tid", this.aaQ.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eGZ.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eGY ? ObjectAnimator.ofFloat(next2.eHg, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eHg, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eGY) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eGY) {
                            if (aVar.eHk != null) {
                                aVar.ct(aVar.eHk.Wf);
                            }
                            ObjectAnimator.ofFloat(d.this.eGX, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eGY) {
                            d.this.iV(true);
                            d.this.eGY = true;
                        } else {
                            view.setClickable(true);
                            aVar.aQL();
                            d.this.aQK();
                            ObjectAnimator.ofFloat(d.this.eGX, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eGY = false;
                        }
                        d.this.eHc = false;
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
        if (pVar != null && pVar.pK() != null) {
            this.aaQ = pVar;
            aQK();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.aaQ.pK().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.aaQ.pK().get(i);
                if (qVar != null && i < this.eHa.length) {
                    qVar.mDefaultImageId = this.eHa[i];
                }
                aVar = (a) u.c(this.eGZ, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Wg) {
                        if (!this.eGY) {
                            aVar.a(qVar);
                            aVar.aQL();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eGY) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.cgR) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.cgR = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Wg != z) {
            if (this.eHb == null) {
                this.eHb = new n();
            }
            if (this.aaQ != null) {
                this.eHb.eMi = this.aaQ.pL();
                this.eHb.Wb = this.aaQ.getTid();
                this.eHb.mForumId = this.aaQ.getForumId();
            }
            this.eHb.eMj = qVar.Wc;
            this.eHb.eMk = z ? 1 : 0;
            this.eHb.aRV();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eGZ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            ai.i(this.eGX, d.e.cp_cont_c);
            ai.k(this.cqZ, d.e.cp_bg_line_c);
            ai.k(this.cNX, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        String format;
        if (this.aaQ != null && this.aaQ.pN()) {
            long bC = this.aaQ.bC(this.eHa.length);
            if (bC > 0) {
                if (this.aaQ.pM()) {
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
                this.eGX.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eHg;
        public TbImageView eHh;
        public TextView eHi;
        private String eHj;
        public q eHk;
        private final int eHl;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eHl = 3;
            if (declareItemView != null) {
                this.eHg = declareItemView;
                this.eHh = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.eHi = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                ai.i(this.eHi, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eHk = qVar;
                ct(qVar.Wf);
                if (!StringUtils.isNull(qVar.We)) {
                    this.eHj = qVar.We;
                }
                if (!StringUtils.isNull(qVar.Wd)) {
                    this.eHh.c(qVar.Wd, 10, false);
                } else {
                    this.eHh.setImageResource(qVar.mDefaultImageId);
                }
                iW(qVar.Wg);
            }
        }

        public void iW(boolean z) {
            if (this.eHk != null && this.eHk.Wg != z) {
                if (z) {
                    ct(this.eHk.Wf + 1);
                    this.eHi.setSelected(true);
                } else {
                    ct(this.eHk.Wf - 1);
                    this.eHi.setSelected(false);
                }
                this.eHk.Wg = z;
            }
        }

        public void ct(long j) {
            if (this.eHk != null && j >= 0) {
                this.eHk.Wf = j;
            }
            this.eHi.setText(al.u(j));
        }

        public void aQL() {
            this.eHi.setText(al.c(this.eHj, 3, null));
            this.eHi.setSelected(true);
        }
    }
}
