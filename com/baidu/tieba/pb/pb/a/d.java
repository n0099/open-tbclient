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
    public boolean anN;
    View cVi;
    private boolean clS;
    private View.OnClickListener cry;
    View cyv;
    LinearLayout eGh;
    DeclareItemView eGi;
    DeclareItemView eGj;
    DeclareItemView eGk;
    DeclareItemView eGl;
    DeclareItemView eGm;
    TextView eGn;
    private boolean eGo;
    private ArrayList<a> eGp;
    private int[] eGq;
    private n eGr;
    private boolean eGs;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eGo = true;
        this.eGp = new ArrayList<>();
        this.mSkinType = 3;
        this.eGq = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eGs = false;
        this.clS = true;
        this.cry = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aU(d.this.mContext) && !com.baidu.tieba.pb.f.iM(d.this.anN)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        bg(view);
        this.mContext = context;
    }

    public void bg(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eGh = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.eGi = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.eGm = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.eGj = (DeclareItemView) view.findViewById(d.h.love_item);
        this.eGk = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.eGl = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.eGn = (TextView) view.findViewById(d.h.vote_count_view);
        this.cyv = view.findViewById(d.h.top_divider_line);
        this.cVi = view.findViewById(d.h.bottom_divider_line);
        if ((this.eGh.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eGh.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.f(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.eGp.add(new a(this.eGi));
        this.eGp.add(new a(this.eGm));
        this.eGp.add(new a(this.eGj));
        this.eGp.add(new a(this.eGl));
        this.eGp.add(new a(this.eGk));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aQc();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aQe();
            this.eGn.setAlpha(1.0f);
            if (this.eGo) {
                Iterator<a> it = this.eGp.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eGw.setAlpha(0.0f);
                        next.eGw.setClickable(false);
                    }
                }
                aVar.eGw.setNeedTranslate(true);
                this.eGo = false;
            }
        }
    }

    public void aQc() {
        int size = this.eGp.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eGp.get(i);
            if (aVar != null) {
                aVar.eGw.setOffSet(this.offset);
                aVar.eGw.setOnClickListener(this.cry);
                if (i < this.eGq.length) {
                    aVar.eGx.setImageResource(this.eGq[i]);
                }
                aVar.eGy.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW(boolean z) {
        int size = this.eGp.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eGp.get(i);
            if (aVar != null) {
                aVar.eGw.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.eGs) {
            this.eGs = true;
            if (this.ZV != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eGh.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iW(false);
                if (this.eGo) {
                    if (aVar.eGA != null) {
                        if (aVar.eGA.Vk) {
                            a(aVar.eGA, false);
                            aVar.iX(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iW(true);
                            this.eGs = false;
                            TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eGA.Vg).f("tid", this.ZV.getTid()));
                            return;
                        }
                        if (this.ZV.pI()) {
                            Iterator<a> it = this.eGp.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eGA, false);
                                    next.iX(false);
                                    TiebaStatic.log(new ak("c12000").r("obj_id", aVar.eGA.Vg).f("tid", this.ZV.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eGA, true);
                        aVar.iX(true);
                        TiebaStatic.log(new ak("c11999").r("obj_id", aVar.eGA.Vg).f("tid", this.ZV.getTid()));
                    }
                } else {
                    TiebaStatic.log(new ak("c12002").f("tid", this.ZV.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eGp.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eGo ? ObjectAnimator.ofFloat(next2.eGw, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eGw, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eGo) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.eGo) {
                            if (aVar.eGA != null) {
                                aVar.co(aVar.eGA.Vj);
                            }
                            ObjectAnimator.ofFloat(d.this.eGn, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.eGo) {
                            d.this.iW(true);
                            d.this.eGo = true;
                        } else {
                            view.setClickable(true);
                            aVar.aQe();
                            d.this.aQd();
                            ObjectAnimator.ofFloat(d.this.eGn, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.eGo = false;
                        }
                        d.this.eGs = false;
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
            aQd();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.ZV.pF().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.ZV.pF().get(i);
                if (qVar != null && i < this.eGq.length) {
                    qVar.Vl = this.eGq[i];
                }
                aVar = (a) v.c(this.eGp, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Vk) {
                        if (!this.eGo) {
                            aVar.a(qVar);
                            aVar.aQe();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eGo) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.clS) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.clS = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Vk != z) {
            if (this.eGr == null) {
                this.eGr = new n();
            }
            if (this.ZV != null) {
                this.eGr.eLv = this.ZV.pG();
                this.eGr.Vf = this.ZV.getTid();
                this.eGr.mForumId = this.ZV.getForumId();
            }
            this.eGr.eLw = qVar.Vg;
            this.eGr.eLx = z ? 1 : 0;
            this.eGr.aRs();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eGp.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aj.i(this.eGn, d.e.cp_cont_c);
            aj.k(this.cyv, d.e.cp_bg_line_c);
            aj.k(this.cVi, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQd() {
        String format;
        if (this.ZV != null && this.ZV.pI()) {
            long bC = this.ZV.bC(this.eGq.length);
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
                this.eGn.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public q eGA;
        private final int eGB;
        public DeclareItemView eGw;
        public TbImageView eGx;
        public TextView eGy;
        private String eGz;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eGB = 3;
            if (declareItemView != null) {
                this.eGw = declareItemView;
                this.eGx = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.eGy = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.i(this.eGy, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eGA = qVar;
                co(qVar.Vj);
                if (!StringUtils.isNull(qVar.Vi)) {
                    this.eGz = qVar.Vi;
                }
                if (!StringUtils.isNull(qVar.Vh)) {
                    this.eGx.c(qVar.Vh, 10, false);
                } else {
                    this.eGx.setImageResource(qVar.Vl);
                }
                iX(qVar.Vk);
            }
        }

        public void iX(boolean z) {
            if (this.eGA != null && this.eGA.Vk != z) {
                if (z) {
                    co(this.eGA.Vj + 1);
                    this.eGy.setSelected(true);
                } else {
                    co(this.eGA.Vj - 1);
                    this.eGy.setSelected(false);
                }
                this.eGA.Vk = z;
            }
        }

        public void co(long j) {
            if (this.eGA != null && j >= 0) {
                this.eGA.Vj = j;
            }
            this.eGy.setText(am.u(j));
        }

        public void aQe() {
            this.eGy.setText(am.d(this.eGz, 3, null));
            this.eGy.setSelected(true);
        }
    }
}
