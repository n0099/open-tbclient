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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.pb.view.DeclareItemView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends y.a {
    private p ZL;
    private boolean bKQ;
    private View.OnClickListener bOx;
    View bUJ;
    View cpU;
    LinearLayout egK;
    DeclareItemView egL;
    DeclareItemView egM;
    DeclareItemView egN;
    DeclareItemView egO;
    DeclareItemView egP;
    TextView egQ;
    private boolean egR;
    private ArrayList<a> egS;
    private int[] egT;
    private da egU;
    private boolean egV;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.egR = true;
        this.egS = new ArrayList<>();
        this.mSkinType = 3;
        this.egT = new int[]{w.g.image_emoticon_huaji, w.g.image_emoticon_zan, w.g.image_emoticon_love, w.g.image_emoticon_shuitei, w.g.image_emoticon_shengqi};
        this.offset = 0;
        this.egV = false;
        this.bKQ = true;
        this.bOx = new e(this);
        aU(view);
        this.mContext = context;
    }

    public void aU(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.egK = (LinearLayout) view.findViewById(w.h.emotion_vote);
        this.egL = (DeclareItemView) view.findViewById(w.h.huaji_item);
        this.egP = (DeclareItemView) view.findViewById(w.h.zan_item);
        this.egM = (DeclareItemView) view.findViewById(w.h.love_item);
        this.egN = (DeclareItemView) view.findViewById(w.h.shengqi_item);
        this.egO = (DeclareItemView) view.findViewById(w.h.tushui_item);
        this.egQ = (TextView) view.findViewById(w.h.vote_count_view);
        this.bUJ = view.findViewById(w.h.top_divider_line);
        this.cpU = view.findViewById(w.h.bottom_divider_line);
        if ((this.egK.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.egK.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
        }
        this.egS.add(new a(this.egL));
        this.egS.add(new a(this.egP));
        this.egS.add(new a(this.egM));
        this.egS.add(new a(this.egO));
        this.egS.add(new a(this.egN));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aKg();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aKi();
            this.egQ.setAlpha(1.0f);
            if (this.egR) {
                Iterator<a> it = this.egS.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.egZ.setAlpha(0.0f);
                        next.egZ.setClickable(false);
                    }
                }
                aVar.egZ.setNeedTranslate(true);
                this.egR = false;
            }
        }
    }

    public void aKg() {
        int size = this.egS.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.egS.get(i);
            if (aVar != null) {
                aVar.egZ.setOffSet(this.offset);
                aVar.egZ.setOnClickListener(this.bOx);
                if (i < this.egT.length) {
                    aVar.eha.setImageResource(this.egT[i]);
                }
                aVar.ehb.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id(boolean z) {
        int size = this.egS.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.egS.get(i);
            if (aVar != null) {
                aVar.egZ.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, long j) {
        if (!this.egV) {
            this.egV = true;
            if (this.ZL != null && view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.egK.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                id(false);
                if (this.egR) {
                    if (aVar.ehd != null) {
                        if (aVar.ehd.Vk) {
                            a(aVar.ehd, false);
                            aVar.ie(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            id(true);
                            this.egV = false;
                            TiebaStatic.log(new as("c12000").s("obj_id", aVar.ehd.Vg).g("tid", this.ZL.getTid()));
                            return;
                        }
                        if (this.ZL.qh()) {
                            Iterator<a> it = this.egS.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.ehd, false);
                                    next.ie(false);
                                    TiebaStatic.log(new as("c12000").s("obj_id", aVar.ehd.Vg).g("tid", this.ZL.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.ehd, true);
                        aVar.ie(true);
                        TiebaStatic.log(new as("c11999").s("obj_id", aVar.ehd.Vg).g("tid", this.ZL.getTid()));
                    }
                } else {
                    TiebaStatic.log(new as("c12002").g("tid", this.ZL.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.egS.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.egR ? ObjectAnimator.ofFloat(next2.egZ, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.egZ, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.egR) {
                    animatorSet3.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f)).before(ofFloat);
                } else {
                    animatorSet3.play(ofFloat);
                }
                animatorSet3.addListener(new f(this, aVar, j, view));
                animatorSet3.setDuration(j).start();
            }
        }
    }

    public void a(p pVar) {
        a aVar;
        if (pVar != null && pVar.qe() != null) {
            this.ZL = pVar;
            aKh();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.ZL.qe().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.ZL.qe().get(i);
                if (qVar != null && i < this.egT.length) {
                    qVar.Vl = this.egT[i];
                }
                aVar = (a) x.c(this.egS, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Vk) {
                        if (!this.egR) {
                            aVar.a(qVar);
                            aVar.aKi();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.egR) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.bKQ) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.bKQ = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Vk != z) {
            if (this.egU == null) {
                this.egU = new da();
            }
            if (this.ZL != null) {
                this.egU.ekW = this.ZL.qf();
                this.egU.Vf = this.ZL.getTid();
                this.egU.mForumId = this.ZL.getForumId();
            }
            this.egU.ekX = qVar.Vg;
            this.egU.ekY = z ? 1 : 0;
            this.egU.aLj();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.egS.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aq.i(this.egQ, w.e.cp_cont_c);
            aq.k(this.bUJ, w.e.cp_bg_line_c);
            aq.k(this.cpU, w.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        String format;
        if (this.ZL != null && this.ZL.qh()) {
            long bD = this.ZL.bD(this.egT.length);
            if (bD > 0) {
                if (this.ZL.qg()) {
                    if (bD == 1) {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_other_to_host), au.t(bD));
                    }
                } else if (bD == 1) {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_we_to_host), au.t(bD - 1));
                }
                this.egQ.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public DeclareItemView egZ;
        public TbImageView eha;
        public TextView ehb;
        private String ehc;
        public q ehd;
        private final int ehe;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.ehe = 3;
            if (declareItemView != null) {
                this.egZ = declareItemView;
                this.eha = (TbImageView) declareItemView.findViewById(w.h.declare_image);
                this.ehb = (TextView) declareItemView.findViewById(w.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aq.i(this.ehb, w.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.ehd = qVar;
                cl(qVar.Vj);
                if (!StringUtils.isNull(qVar.Vi)) {
                    this.ehc = qVar.Vi;
                }
                if (!StringUtils.isNull(qVar.Vh)) {
                    this.eha.c(qVar.Vh, 10, false);
                } else {
                    this.eha.setImageResource(qVar.Vl);
                }
                ie(qVar.Vk);
            }
        }

        public void ie(boolean z) {
            if (this.ehd != null && this.ehd.Vk != z) {
                if (z) {
                    cl(this.ehd.Vj + 1);
                    this.ehb.setSelected(true);
                } else {
                    cl(this.ehd.Vj - 1);
                    this.ehb.setSelected(false);
                }
                this.ehd.Vk = z;
            }
        }

        public void cl(long j) {
            if (this.ehd != null && j >= 0) {
                this.ehd.Vj = j;
            }
            this.ehb.setText(au.t(j));
        }

        public void aKi() {
            this.ehb.setText(au.c(this.ehc, 3, null));
            this.ehb.setSelected(true);
        }
    }
}
