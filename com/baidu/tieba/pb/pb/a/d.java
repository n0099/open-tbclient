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
    private p ZM;
    private boolean bNh;
    private View.OnClickListener bQO;
    View bXa;
    View csm;
    LinearLayout eja;
    DeclareItemView ejb;
    DeclareItemView ejc;
    DeclareItemView ejd;
    DeclareItemView eje;
    DeclareItemView ejf;
    TextView ejg;
    private boolean ejh;
    private ArrayList<a> eji;
    private int[] ejj;
    private da ejk;
    private boolean ejl;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.ejh = true;
        this.eji = new ArrayList<>();
        this.mSkinType = 3;
        this.ejj = new int[]{w.g.image_emoticon_huaji, w.g.image_emoticon_zan, w.g.image_emoticon_love, w.g.image_emoticon_shuitei, w.g.image_emoticon_shengqi};
        this.offset = 0;
        this.ejl = false;
        this.bNh = true;
        this.bQO = new e(this);
        aU(view);
        this.mContext = context;
    }

    public void aU(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eja = (LinearLayout) view.findViewById(w.h.emotion_vote);
        this.ejb = (DeclareItemView) view.findViewById(w.h.huaji_item);
        this.ejf = (DeclareItemView) view.findViewById(w.h.zan_item);
        this.ejc = (DeclareItemView) view.findViewById(w.h.love_item);
        this.ejd = (DeclareItemView) view.findViewById(w.h.shengqi_item);
        this.eje = (DeclareItemView) view.findViewById(w.h.tushui_item);
        this.ejg = (TextView) view.findViewById(w.h.vote_count_view);
        this.bXa = view.findViewById(w.h.top_divider_line);
        this.csm = view.findViewById(w.h.bottom_divider_line);
        if ((this.eja.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eja.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
        }
        this.eji.add(new a(this.ejb));
        this.eji.add(new a(this.ejf));
        this.eji.add(new a(this.ejc));
        this.eji.add(new a(this.eje));
        this.eji.add(new a(this.ejd));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aLh();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aLj();
            this.ejg.setAlpha(1.0f);
            if (this.ejh) {
                Iterator<a> it = this.eji.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.ejp.setAlpha(0.0f);
                        next.ejp.setClickable(false);
                    }
                }
                aVar.ejp.setNeedTranslate(true);
                this.ejh = false;
            }
        }
    }

    public void aLh() {
        int size = this.eji.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eji.get(i);
            if (aVar != null) {
                aVar.ejp.setOffSet(this.offset);
                aVar.ejp.setOnClickListener(this.bQO);
                if (i < this.ejj.length) {
                    aVar.ejq.setImageResource(this.ejj[i]);
                }
                aVar.ejr.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        int size = this.eji.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eji.get(i);
            if (aVar != null) {
                aVar.ejp.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, long j) {
        if (!this.ejl) {
            this.ejl = true;
            if (this.ZM != null && view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eja.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                in(false);
                if (this.ejh) {
                    if (aVar.ejt != null) {
                        if (aVar.ejt.Vm) {
                            a(aVar.ejt, false);
                            aVar.io(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            in(true);
                            this.ejl = false;
                            TiebaStatic.log(new as("c12000").s("obj_id", aVar.ejt.Vi).g("tid", this.ZM.getTid()));
                            return;
                        }
                        if (this.ZM.qh()) {
                            Iterator<a> it = this.eji.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.ejt, false);
                                    next.io(false);
                                    TiebaStatic.log(new as("c12000").s("obj_id", aVar.ejt.Vi).g("tid", this.ZM.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.ejt, true);
                        aVar.io(true);
                        TiebaStatic.log(new as("c11999").s("obj_id", aVar.ejt.Vi).g("tid", this.ZM.getTid()));
                    }
                } else {
                    TiebaStatic.log(new as("c12002").g("tid", this.ZM.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eji.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.ejh ? ObjectAnimator.ofFloat(next2.ejp, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.ejp, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.ejh) {
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
            this.ZM = pVar;
            aLi();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.ZM.qe().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.ZM.qe().get(i);
                if (qVar != null && i < this.ejj.length) {
                    qVar.Vn = this.ejj[i];
                }
                aVar = (a) x.c(this.eji, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Vm) {
                        if (!this.ejh) {
                            aVar.a(qVar);
                            aVar.aLj();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.ejh) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.bNh) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.bNh = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Vm != z) {
            if (this.ejk == null) {
                this.ejk = new da();
            }
            if (this.ZM != null) {
                this.ejk.eno = this.ZM.qf();
                this.ejk.Vh = this.ZM.getTid();
                this.ejk.mForumId = this.ZM.getForumId();
            }
            this.ejk.enp = qVar.Vi;
            this.ejk.enq = z ? 1 : 0;
            this.ejk.aMk();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eji.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aq.i(this.ejg, w.e.cp_cont_c);
            aq.k(this.bXa, w.e.cp_bg_line_c);
            aq.k(this.csm, w.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLi() {
        String format;
        if (this.ZM != null && this.ZM.qh()) {
            long bD = this.ZM.bD(this.ejj.length);
            if (bD > 0) {
                if (this.ZM.qg()) {
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
                this.ejg.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public DeclareItemView ejp;
        public TbImageView ejq;
        public TextView ejr;
        private String ejs;
        public q ejt;
        private final int eju;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eju = 3;
            if (declareItemView != null) {
                this.ejp = declareItemView;
                this.ejq = (TbImageView) declareItemView.findViewById(w.h.declare_image);
                this.ejr = (TextView) declareItemView.findViewById(w.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aq.i(this.ejr, w.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.ejt = qVar;
                cl(qVar.Vl);
                if (!StringUtils.isNull(qVar.Vk)) {
                    this.ejs = qVar.Vk;
                }
                if (!StringUtils.isNull(qVar.Vj)) {
                    this.ejq.c(qVar.Vj, 10, false);
                } else {
                    this.ejq.setImageResource(qVar.Vn);
                }
                io(qVar.Vm);
            }
        }

        public void io(boolean z) {
            if (this.ejt != null && this.ejt.Vm != z) {
                if (z) {
                    cl(this.ejt.Vl + 1);
                    this.ejr.setSelected(true);
                } else {
                    cl(this.ejt.Vl - 1);
                    this.ejr.setSelected(false);
                }
                this.ejt.Vm = z;
            }
        }

        public void cl(long j) {
            if (this.ejt != null && j >= 0) {
                this.ejt.Vl = j;
            }
            this.ejr.setText(au.t(j));
        }

        public void aLj() {
            this.ejr.setText(au.c(this.ejs, 3, null));
            this.ejr.setSelected(true);
        }
    }
}
