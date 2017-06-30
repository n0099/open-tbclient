package com.baidu.tieba.pb.pb.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.dx;
import com.baidu.tieba.pb.view.DeclareItemView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends z.a {
    private q Zb;
    public boolean amt;
    private boolean bZt;
    View cDv;
    private View.OnClickListener cdH;
    View cjk;
    LinearLayout esB;
    DeclareItemView esC;
    DeclareItemView esD;
    DeclareItemView esE;
    DeclareItemView esF;
    DeclareItemView esG;
    TextView esH;
    private boolean esI;
    private ArrayList<a> esJ;
    private int[] esK;
    private dx esL;
    private boolean esM;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.esI = true;
        this.esJ = new ArrayList<>();
        this.mSkinType = 3;
        this.esK = new int[]{w.g.image_emoticon_huaji, w.g.image_emoticon_zan, w.g.image_emoticon_love, w.g.image_emoticon_shuitei, w.g.image_emoticon_shengqi};
        this.offset = 0;
        this.esM = false;
        this.bZt = true;
        this.cdH = new e(this);
        aT(view);
        this.mContext = context;
    }

    public void aT(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.esB = (LinearLayout) view.findViewById(w.h.emotion_vote);
        this.esC = (DeclareItemView) view.findViewById(w.h.huaji_item);
        this.esG = (DeclareItemView) view.findViewById(w.h.zan_item);
        this.esD = (DeclareItemView) view.findViewById(w.h.love_item);
        this.esE = (DeclareItemView) view.findViewById(w.h.shengqi_item);
        this.esF = (DeclareItemView) view.findViewById(w.h.tushui_item);
        this.esH = (TextView) view.findViewById(w.h.vote_count_view);
        this.cjk = view.findViewById(w.h.top_divider_line);
        this.cDv = view.findViewById(w.h.bottom_divider_line);
        if ((this.esB.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.esB.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
        }
        this.esJ.add(new a(this.esC));
        this.esJ.add(new a(this.esG));
        this.esJ.add(new a(this.esD));
        this.esJ.add(new a(this.esF));
        this.esJ.add(new a(this.esE));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aNo();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aNq();
            this.esH.setAlpha(1.0f);
            if (this.esI) {
                Iterator<a> it = this.esJ.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.esQ.setAlpha(0.0f);
                        next.esQ.setClickable(false);
                    }
                }
                aVar.esQ.setNeedTranslate(true);
                this.esI = false;
            }
        }
    }

    public void aNo() {
        int size = this.esJ.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.esJ.get(i);
            if (aVar != null) {
                aVar.esQ.setOffSet(this.offset);
                aVar.esQ.setOnClickListener(this.cdH);
                if (i < this.esK.length) {
                    aVar.esR.setImageResource(this.esK[i]);
                }
                aVar.esS.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy(boolean z) {
        int size = this.esJ.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.esJ.get(i);
            if (aVar != null) {
                aVar.esQ.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, long j) {
        if (!this.esM) {
            this.esM = true;
            if (this.Zb != null && view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.esB.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                iy(false);
                if (this.esI) {
                    if (aVar.esU != null) {
                        if (aVar.esU.Up) {
                            a(aVar.esU, false);
                            aVar.iz(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            iy(true);
                            this.esM = false;
                            TiebaStatic.log(new au("c12000").r("obj_id", aVar.esU.Ul).f("tid", this.Zb.getTid()));
                            return;
                        }
                        if (this.Zb.pA()) {
                            Iterator<a> it = this.esJ.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.esU, false);
                                    next.iz(false);
                                    TiebaStatic.log(new au("c12000").r("obj_id", aVar.esU.Ul).f("tid", this.Zb.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.esU, true);
                        aVar.iz(true);
                        TiebaStatic.log(new au("c11999").r("obj_id", aVar.esU.Ul).f("tid", this.Zb.getTid()));
                    }
                } else {
                    TiebaStatic.log(new au("c12002").f("tid", this.Zb.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.esJ.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.esI ? ObjectAnimator.ofFloat(next2.esQ, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.esQ, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.esI) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new f(this, aVar, j, view));
                animatorSet3.setDuration(j).start();
            }
        }
    }

    public void a(q qVar) {
        a aVar;
        if (qVar != null && qVar.px() != null) {
            this.Zb = qVar;
            aNp();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.Zb.px().size()) {
                    aVar = aVar2;
                    break;
                }
                r rVar = this.Zb.px().get(i);
                if (rVar != null && i < this.esK.length) {
                    rVar.Uq = this.esK[i];
                }
                aVar = (a) com.baidu.tbadk.core.util.z.c(this.esJ, i);
                if (aVar != null) {
                    if (aVar2 == null && rVar.Up) {
                        if (!this.esI) {
                            aVar.a(rVar);
                            aVar.aNq();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.esI) {
                        aVar.a(rVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.bZt) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.bZt = false;
        }
    }

    private void a(r rVar, boolean z) {
        if (rVar != null && rVar.Up != z) {
            if (this.esL == null) {
                this.esL = new dx();
            }
            if (this.Zb != null) {
                this.esL.exR = this.Zb.py();
                this.esL.Uk = this.Zb.getTid();
                this.esL.mForumId = this.Zb.getForumId();
            }
            this.esL.exS = rVar.Ul;
            this.esL.exT = z ? 1 : 0;
            this.esL.aOA();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.esJ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            as.i(this.esH, w.e.cp_cont_c);
            as.k(this.cjk, w.e.cp_bg_line_c);
            as.k(this.cDv, w.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNp() {
        String format;
        if (this.Zb != null && this.Zb.pA()) {
            long bB = this.Zb.bB(this.esK.length);
            if (bB > 0) {
                if (this.Zb.pz()) {
                    if (bB == 1) {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_other_to_host), aw.t(bB));
                    }
                } else if (bB == 1) {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_we_to_host), aw.t(bB - 1));
                }
                this.esH.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends z.a {
        public DeclareItemView esQ;
        public TbImageView esR;
        public TextView esS;
        private String esT;
        public r esU;
        private final int esV;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.esV = 3;
            if (declareItemView != null) {
                this.esQ = declareItemView;
                this.esR = (TbImageView) declareItemView.findViewById(w.h.declare_image);
                this.esS = (TextView) declareItemView.findViewById(w.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                as.i(this.esS, w.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(r rVar) {
            if (rVar != null) {
                this.esU = rVar;
                cp(rVar.Uo);
                if (!StringUtils.isNull(rVar.Un)) {
                    this.esT = rVar.Un;
                }
                if (!StringUtils.isNull(rVar.Um)) {
                    this.esR.c(rVar.Um, 10, false);
                } else {
                    this.esR.setImageResource(rVar.Uq);
                }
                iz(rVar.Up);
            }
        }

        public void iz(boolean z) {
            if (this.esU != null && this.esU.Up != z) {
                if (z) {
                    cp(this.esU.Uo + 1);
                    this.esS.setSelected(true);
                } else {
                    cp(this.esU.Uo - 1);
                    this.esS.setSelected(false);
                }
                this.esU.Up = z;
            }
        }

        public void cp(long j) {
            if (this.esU != null && j >= 0) {
                this.esU.Uo = j;
            }
            this.esS.setText(aw.t(j));
        }

        public void aNq() {
            this.esS.setText(aw.c(this.esT, 3, null));
            this.esS.setSelected(true);
        }
    }
}
