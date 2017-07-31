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
    private p aaO;
    public boolean aot;
    View cMa;
    private boolean cgf;
    private View.OnClickListener ckz;
    View cqr;
    LinearLayout eEX;
    DeclareItemView eEY;
    DeclareItemView eEZ;
    DeclareItemView eFa;
    DeclareItemView eFb;
    DeclareItemView eFc;
    TextView eFd;
    private boolean eFe;
    private ArrayList<a> eFf;
    private int[] eFg;
    private n eFh;
    private boolean eFi;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eFe = true;
        this.eFf = new ArrayList<>();
        this.mSkinType = 3;
        this.eFg = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eFi = false;
        this.cgf = true;
        this.ckz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(d.this.mContext) && !com.baidu.tieba.pb.e.iI(d.this.aot)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        aY(view);
        this.mContext = context;
    }

    public void aY(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eEX = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.eEY = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.eFc = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.eEZ = (DeclareItemView) view.findViewById(d.h.love_item);
        this.eFa = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.eFb = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.eFd = (TextView) view.findViewById(d.h.vote_count_view);
        this.cqr = view.findViewById(d.h.top_divider_line);
        this.cMa = view.findViewById(d.h.bottom_divider_line);
        if ((this.eEX.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eEX.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.eFf.add(new a(this.eEY));
        this.eFf.add(new a(this.eFc));
        this.eFf.add(new a(this.eEZ));
        this.eFf.add(new a(this.eFb));
        this.eFf.add(new a(this.eFa));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQc();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aQe();
            this.eFd.setAlpha(1.0f);
            if (this.eFe) {
                Iterator<a> it = this.eFf.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eFm.setAlpha(0.0f);
                        next.eFm.setClickable(false);
                    }
                }
                aVar.eFm.setNeedTranslate(true);
                this.eFe = false;
            }
        }
    }

    public void aQc() {
        int size = this.eFf.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eFf.get(i);
            if (aVar != null) {
                aVar.eFm.setOffSet(this.offset);
                aVar.eFm.setOnClickListener(this.ckz);
                if (i < this.eFg.length) {
                    aVar.eFn.setImageResource(this.eFg[i]);
                }
                aVar.eFo.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(boolean z) {
        int size = this.eFf.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eFf.get(i);
            if (aVar != null) {
                aVar.eFm.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eFi) {
            this.eFi = true;
            if (this.aaO != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eEX.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iS(false);
                if (this.eFe) {
                    if (aVar.eFq != null) {
                        if (aVar.eFq.We) {
                            a(aVar.eFq, false);
                            aVar.iT(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iS(true);
                            this.eFi = false;
                            TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eFq.Wa).g("tid", this.aaO.getTid()));
                            return;
                        }
                        if (this.aaO.pN()) {
                            Iterator<a> it = this.eFf.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eFq, false);
                                    next.iT(false);
                                    TiebaStatic.log(new aj("c12000").r("obj_id", aVar.eFq.Wa).g("tid", this.aaO.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eFq, true);
                        aVar.iT(true);
                        TiebaStatic.log(new aj("c11999").r("obj_id", aVar.eFq.Wa).g("tid", this.aaO.getTid()));
                    }
                } else {
                    TiebaStatic.log(new aj("c12002").g("tid", this.aaO.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eFf.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eFe ? ObjectAnimator.ofFloat(next2.eFm, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eFm, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eFe) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eFe) {
                            if (aVar.eFq != null) {
                                aVar.ct(aVar.eFq.Wd);
                            }
                            ObjectAnimator.ofFloat(d.this.eFd, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eFe) {
                            d.this.iS(true);
                            d.this.eFe = true;
                        } else {
                            view.setClickable(true);
                            aVar.aQe();
                            d.this.aQd();
                            ObjectAnimator.ofFloat(d.this.eFd, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eFe = false;
                        }
                        d.this.eFi = false;
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
            this.aaO = pVar;
            aQd();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.aaO.pK().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.aaO.pK().get(i);
                if (qVar != null && i < this.eFg.length) {
                    qVar.mDefaultImageId = this.eFg[i];
                }
                aVar = (a) u.c(this.eFf, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.We) {
                        if (!this.eFe) {
                            aVar.a(qVar);
                            aVar.aQe();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eFe) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.cgf) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.cgf = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.We != z) {
            if (this.eFh == null) {
                this.eFh = new n();
            }
            if (this.aaO != null) {
                this.eFh.eKo = this.aaO.pL();
                this.eFh.VZ = this.aaO.getTid();
                this.eFh.mForumId = this.aaO.getForumId();
            }
            this.eFh.eKp = qVar.Wa;
            this.eFh.eKq = z ? 1 : 0;
            this.eFh.aRo();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eFf.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            ai.i(this.eFd, d.e.cp_cont_c);
            ai.k(this.cqr, d.e.cp_bg_line_c);
            ai.k(this.cMa, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQd() {
        String format;
        if (this.aaO != null && this.aaO.pN()) {
            long bC = this.aaO.bC(this.eFg.length);
            if (bC > 0) {
                if (this.aaO.pM()) {
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
                this.eFd.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView eFm;
        public TbImageView eFn;
        public TextView eFo;
        private String eFp;
        public q eFq;
        private final int eFr;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eFr = 3;
            if (declareItemView != null) {
                this.eFm = declareItemView;
                this.eFn = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.eFo = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                ai.i(this.eFo, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eFq = qVar;
                ct(qVar.Wd);
                if (!StringUtils.isNull(qVar.Wc)) {
                    this.eFp = qVar.Wc;
                }
                if (!StringUtils.isNull(qVar.Wb)) {
                    this.eFn.c(qVar.Wb, 10, false);
                } else {
                    this.eFn.setImageResource(qVar.mDefaultImageId);
                }
                iT(qVar.We);
            }
        }

        public void iT(boolean z) {
            if (this.eFq != null && this.eFq.We != z) {
                if (z) {
                    ct(this.eFq.Wd + 1);
                    this.eFo.setSelected(true);
                } else {
                    ct(this.eFq.Wd - 1);
                    this.eFo.setSelected(false);
                }
                this.eFq.We = z;
            }
        }

        public void ct(long j) {
            if (this.eFq != null && j >= 0) {
                this.eFq.Wd = j;
            }
            this.eFo.setText(al.u(j));
        }

        public void aQe() {
            this.eFo.setText(al.c(this.eFp, 3, null));
            this.eFo.setSelected(true);
        }
    }
}
