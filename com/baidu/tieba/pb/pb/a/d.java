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
import com.baidu.tieba.pb.pb.main.dc;
import com.baidu.tieba.pb.view.DeclareItemView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends y.a {
    private p Zv;
    private boolean bKX;
    private View.OnClickListener bOI;
    View bUV;
    View crv;
    LinearLayout eiD;
    DeclareItemView eiE;
    DeclareItemView eiF;
    DeclareItemView eiG;
    DeclareItemView eiH;
    DeclareItemView eiI;
    TextView eiJ;
    private boolean eiK;
    private ArrayList<a> eiL;
    private int[] eiM;
    private dc eiN;
    private boolean eiO;
    private final long eiP;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eiK = true;
        this.eiL = new ArrayList<>();
        this.mSkinType = 3;
        this.eiM = new int[]{w.g.image_emoticon_huaji, w.g.image_emoticon_zan, w.g.image_emoticon_love, w.g.image_emoticon_shuitei, w.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eiO = false;
        this.eiP = 300L;
        this.bKX = true;
        this.bOI = new e(this);
        aW(view);
        this.mContext = context;
    }

    public void aW(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eiD = (LinearLayout) view.findViewById(w.h.emotion_vote);
        this.eiE = (DeclareItemView) view.findViewById(w.h.huaji_item);
        this.eiI = (DeclareItemView) view.findViewById(w.h.zan_item);
        this.eiF = (DeclareItemView) view.findViewById(w.h.love_item);
        this.eiG = (DeclareItemView) view.findViewById(w.h.shengqi_item);
        this.eiH = (DeclareItemView) view.findViewById(w.h.tushui_item);
        this.eiJ = (TextView) view.findViewById(w.h.vote_count_view);
        this.bUV = view.findViewById(w.h.top_divider_line);
        this.crv = view.findViewById(w.h.bottom_divider_line);
        if ((this.eiD.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eiD.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
        }
        this.eiL.add(new a(this.eiE));
        this.eiL.add(new a(this.eiI));
        this.eiL.add(new a(this.eiF));
        this.eiL.add(new a(this.eiH));
        this.eiL.add(new a(this.eiG));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aJZ();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aKb();
            this.eiJ.setAlpha(1.0f);
            if (this.eiK) {
                Iterator<a> it = this.eiL.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.eiT.setAlpha(0.0f);
                        next.eiT.setClickable(false);
                    }
                }
                aVar.eiT.setNeedTranslate(true);
                this.eiK = false;
            }
        }
    }

    public void aJZ() {
        int size = this.eiL.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eiL.get(i);
            if (aVar != null) {
                aVar.eiT.setOffSet(this.offset);
                aVar.eiT.setOnClickListener(this.bOI);
                if (i < this.eiM.length) {
                    aVar.eiU.setImageResource(this.eiM[i]);
                }
                aVar.eiV.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        int size = this.eiL.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eiL.get(i);
            if (aVar != null) {
                aVar.eiT.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, long j) {
        if (!this.eiO) {
            this.eiO = true;
            if (this.Zv != null && view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eiD.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                ie(false);
                if (this.eiK) {
                    if (aVar.eiX != null) {
                        if (aVar.eiX.UR) {
                            a(aVar.eiX, false);
                            aVar.m17if(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            ie(true);
                            this.eiO = false;
                            TiebaStatic.log(new as("c12000").s("obj_id", aVar.eiX.UM).g("tid", this.Zv.getTid()));
                            return;
                        }
                        if (this.Zv.pJ()) {
                            Iterator<a> it = this.eiL.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eiX, false);
                                    next.m17if(false);
                                    TiebaStatic.log(new as("c12000").s("obj_id", aVar.eiX.UM).g("tid", this.Zv.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eiX, true);
                        aVar.m17if(true);
                        TiebaStatic.log(new as("c11999").s("obj_id", aVar.eiX.UM).g("tid", this.Zv.getTid()));
                    }
                } else {
                    TiebaStatic.log(new as("c12002").g("tid", this.Zv.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eiL.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eiK ? ObjectAnimator.ofFloat(next2.eiT, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.eiT, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eiK) {
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
        if (pVar != null && pVar.pG() != null) {
            this.Zv = pVar;
            aKa();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.Zv.pG().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.Zv.pG().get(i);
                if (qVar != null && i < this.eiM.length) {
                    qVar.US = this.eiM[i];
                }
                aVar = (a) x.c(this.eiL, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.UR) {
                        if (!this.eiK) {
                            aVar.a(qVar);
                            aVar.aKb();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eiK) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.bKX) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.bKX = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.UR != z) {
            if (this.eiN == null) {
                this.eiN = new dc();
            }
            if (this.Zv != null) {
                this.eiN.emO = this.Zv.pH();
                this.eiN.UL = this.Zv.getTid();
                this.eiN.mForumId = this.Zv.getForumId();
            }
            this.eiN.emP = qVar.UM;
            this.eiN.emQ = z ? 1 : 0;
            this.eiN.aLb();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eiL.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aq.i((View) this.eiJ, w.e.cp_cont_c);
            aq.k(this.bUV, w.e.cp_bg_line_c);
            aq.k(this.crv, w.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKa() {
        String format;
        if (this.Zv != null && this.Zv.pJ()) {
            long bA = this.Zv.bA(this.eiM.length);
            if (bA > 0) {
                if (this.Zv.pI()) {
                    if (bA == 1) {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_other_to_host), au.t(bA));
                    }
                } else if (bA == 1) {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_we_to_host), au.t(bA - 1));
                }
                this.eiJ.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public DeclareItemView eiT;
        public TbImageView eiU;
        public TextView eiV;
        private String eiW;
        public q eiX;
        private final int eiY;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eiY = 3;
            if (declareItemView != null) {
                this.eiT = declareItemView;
                this.eiU = (TbImageView) declareItemView.findViewById(w.h.declare_image);
                this.eiV = (TextView) declareItemView.findViewById(w.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aq.i((View) this.eiV, w.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eiX = qVar;
                cl(qVar.UQ);
                if (!StringUtils.isNull(qVar.UO)) {
                    this.eiW = qVar.UO;
                }
                if (!StringUtils.isNull(qVar.UN)) {
                    this.eiU.c(qVar.UN, 10, false);
                } else {
                    this.eiU.setImageResource(qVar.US);
                }
                m17if(qVar.UR);
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m17if(boolean z) {
            if (this.eiX != null && this.eiX.UR != z) {
                if (z) {
                    cl(this.eiX.UQ + 1);
                    this.eiV.setSelected(true);
                } else {
                    cl(this.eiX.UQ - 1);
                    this.eiV.setSelected(false);
                }
                this.eiX.UR = z;
            }
        }

        public void cl(long j) {
            if (this.eiX != null && j >= 0) {
                this.eiX.UQ = j;
            }
            this.eiV.setText(au.t(j));
        }

        public void aKb() {
            this.eiV.setText(au.c(this.eiW, 3, null));
            this.eiV.setSelected(true);
        }
    }
}
