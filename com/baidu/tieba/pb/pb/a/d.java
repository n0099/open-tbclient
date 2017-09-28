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
    private p ZV;
    public boolean anb;
    View cUW;
    private boolean clO;
    private View.OnClickListener crU;
    View czn;
    LinearLayout ezD;
    DeclareItemView ezE;
    DeclareItemView ezF;
    DeclareItemView ezG;
    DeclareItemView ezH;
    DeclareItemView ezI;
    TextView ezJ;
    private boolean ezK;
    private ArrayList<a> ezL;
    private int[] ezM;
    private n ezN;
    private boolean ezO;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.ezK = true;
        this.ezL = new ArrayList<>();
        this.mSkinType = 3;
        this.ezM = new int[]{d.g.image_emoticon_huaji, d.g.image_emoticon_zan, d.g.image_emoticon_love, d.g.image_emoticon_shuitei, d.g.image_emoticon_shengqi};
        this.offset = 0;
        this.ezO = false;
        this.clO = true;
        this.crU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aU(d.this.mContext) && !com.baidu.tieba.pb.f.iw(d.this.anb)) {
                    d.this.a(view2, 300L);
                }
            }
        };
        bc(view);
        this.mContext = context;
    }

    public void bc(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.ezD = (LinearLayout) view.findViewById(d.h.emotion_vote);
        this.ezE = (DeclareItemView) view.findViewById(d.h.huaji_item);
        this.ezI = (DeclareItemView) view.findViewById(d.h.zan_item);
        this.ezF = (DeclareItemView) view.findViewById(d.h.love_item);
        this.ezG = (DeclareItemView) view.findViewById(d.h.shengqi_item);
        this.ezH = (DeclareItemView) view.findViewById(d.h.tushui_item);
        this.ezJ = (TextView) view.findViewById(d.h.vote_count_view);
        this.czn = view.findViewById(d.h.top_divider_line);
        this.cUW = view.findViewById(d.h.bottom_divider_line);
        if ((this.ezD.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.ezD.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - l.f(TbadkCoreApplication.getInst(), d.f.ds8);
        }
        this.ezL.add(new a(this.ezE));
        this.ezL.add(new a(this.ezI));
        this.ezL.add(new a(this.ezF));
        this.ezL.add(new a(this.ezH));
        this.ezL.add(new a(this.ezG));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aNW();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aNY();
            this.ezJ.setAlpha(1.0f);
            if (this.ezK) {
                Iterator<a> it = this.ezL.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.ezS.setAlpha(0.0f);
                        next.ezS.setClickable(false);
                    }
                }
                aVar.ezS.setNeedTranslate(true);
                this.ezK = false;
            }
        }
    }

    public void aNW() {
        int size = this.ezL.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.ezL.get(i);
            if (aVar != null) {
                aVar.ezS.setOffSet(this.offset);
                aVar.ezS.setOnClickListener(this.crU);
                if (i < this.ezM.length) {
                    aVar.ezT.setImageResource(this.ezM[i]);
                }
                aVar.ezU.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(boolean z) {
        int size = this.ezL.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.ezL.get(i);
            if (aVar != null) {
                aVar.ezS.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final long j) {
        if (!this.ezO) {
            this.ezO = true;
            if (this.ZV != null && view != null && (view.getTag() instanceof a)) {
                final a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.ezD.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iH(false);
                if (this.ezK) {
                    if (aVar.ezW != null) {
                        if (aVar.ezW.Vy) {
                            a(aVar.ezW, false);
                            aVar.iI(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iH(true);
                            this.ezO = false;
                            TiebaStatic.log(new ak("c12000").r("obj_id", aVar.ezW.Vu).f("tid", this.ZV.getTid()));
                            return;
                        }
                        if (this.ZV.pJ()) {
                            Iterator<a> it = this.ezL.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.ezW, false);
                                    next.iI(false);
                                    TiebaStatic.log(new ak("c12000").r("obj_id", aVar.ezW.Vu).f("tid", this.ZV.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.ezW, true);
                        aVar.iI(true);
                        TiebaStatic.log(new ak("c11999").r("obj_id", aVar.ezW.Vu).f("tid", this.ZV.getTid()));
                    }
                } else {
                    TiebaStatic.log(new ak("c12002").f("tid", this.ZV.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.ezL.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.ezK ? ObjectAnimator.ofFloat(next2.ezS, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.ezS, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.ezK) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.a.d.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (!d.this.ezK) {
                            if (aVar.ezW != null) {
                                aVar.cl(aVar.ezW.Vx);
                            }
                            ObjectAnimator.ofFloat(d.this.ezJ, "alpha", 1.0f, 0.0f).setDuration(j / 3).start();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!d.this.ezK) {
                            d.this.iH(true);
                            d.this.ezK = true;
                        } else {
                            view.setClickable(true);
                            aVar.aNY();
                            d.this.aNX();
                            ObjectAnimator.ofFloat(d.this.ezJ, "alpha", 0.0f, 1.0f).setDuration(j / 3).start();
                            d.this.ezK = false;
                        }
                        d.this.ezO = false;
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
        if (pVar != null && pVar.pG() != null) {
            this.ZV = pVar;
            aNX();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.ZV.pG().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.ZV.pG().get(i);
                if (qVar != null && i < this.ezM.length) {
                    qVar.Vz = this.ezM[i];
                }
                aVar = (a) v.c(this.ezL, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Vy) {
                        if (!this.ezK) {
                            aVar.a(qVar);
                            aVar.aNY();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.ezK) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.clO) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.clO = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Vy != z) {
            if (this.ezN == null) {
                this.ezN = new n();
            }
            if (this.ZV != null) {
                this.ezN.eEU = this.ZV.pH();
                this.ezN.Vt = this.ZV.getTid();
                this.ezN.mForumId = this.ZV.getForumId();
            }
            this.ezN.eEV = qVar.Vu;
            this.ezN.eEW = z ? 1 : 0;
            this.ezN.aPo();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.ezL.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aj.i(this.ezJ, d.e.cp_cont_c);
            aj.k(this.czn, d.e.cp_bg_line_c);
            aj.k(this.cUW, d.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNX() {
        String format;
        if (this.ZV != null && this.ZV.pJ()) {
            long bG = this.ZV.bG(this.ezM.length);
            if (bG > 0) {
                if (this.ZV.pI()) {
                    if (bG == 1) {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_other_to_host), am.t(bG));
                    }
                } else if (bG == 1) {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getString(d.l.declare_text_we_to_host), am.t(bG - 1));
                }
                this.ezJ.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public DeclareItemView ezS;
        public TbImageView ezT;
        public TextView ezU;
        private String ezV;
        public q ezW;
        private final int ezX;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.ezX = 3;
            if (declareItemView != null) {
                this.ezS = declareItemView;
                this.ezT = (TbImageView) declareItemView.findViewById(d.h.declare_image);
                this.ezU = (TextView) declareItemView.findViewById(d.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.i(this.ezU, d.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.ezW = qVar;
                cl(qVar.Vx);
                if (!StringUtils.isNull(qVar.Vw)) {
                    this.ezV = qVar.Vw;
                }
                if (!StringUtils.isNull(qVar.Vv)) {
                    this.ezT.c(qVar.Vv, 10, false);
                } else {
                    this.ezT.setImageResource(qVar.Vz);
                }
                iI(qVar.Vy);
            }
        }

        public void iI(boolean z) {
            if (this.ezW != null && this.ezW.Vy != z) {
                if (z) {
                    cl(this.ezW.Vx + 1);
                    this.ezU.setSelected(true);
                } else {
                    cl(this.ezW.Vx - 1);
                    this.ezU.setSelected(false);
                }
                this.ezW.Vy = z;
            }
        }

        public void cl(long j) {
            if (this.ezW != null && j >= 0) {
                this.ezW.Vx = j;
            }
            this.ezU.setText(am.t(j));
        }

        public void aNY() {
            this.ezU.setText(am.d(this.ezV, 3, null));
            this.ezU.setSelected(true);
        }
    }
}
