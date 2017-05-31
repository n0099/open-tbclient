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
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.dq;
import com.baidu.tieba.pb.view.DeclareItemView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends z.a {
    private p Za;
    public boolean alE;
    private boolean bRY;
    private View.OnClickListener bVy;
    View caZ;
    View cvI;
    LinearLayout ejD;
    DeclareItemView ejE;
    DeclareItemView ejF;
    DeclareItemView ejG;
    DeclareItemView ejH;
    DeclareItemView ejI;
    TextView ejJ;
    private boolean ejK;
    private ArrayList<a> ejL;
    private int[] ejM;
    private dq ejN;
    private boolean ejO;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.ejK = true;
        this.ejL = new ArrayList<>();
        this.mSkinType = 3;
        this.ejM = new int[]{w.g.image_emoticon_huaji, w.g.image_emoticon_zan, w.g.image_emoticon_love, w.g.image_emoticon_shuitei, w.g.image_emoticon_shengqi};
        this.offset = 0;
        this.ejO = false;
        this.bRY = true;
        this.bVy = new e(this);
        aR(view);
        this.mContext = context;
    }

    public void aR(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.ejD = (LinearLayout) view.findViewById(w.h.emotion_vote);
        this.ejE = (DeclareItemView) view.findViewById(w.h.huaji_item);
        this.ejI = (DeclareItemView) view.findViewById(w.h.zan_item);
        this.ejF = (DeclareItemView) view.findViewById(w.h.love_item);
        this.ejG = (DeclareItemView) view.findViewById(w.h.shengqi_item);
        this.ejH = (DeclareItemView) view.findViewById(w.h.tushui_item);
        this.ejJ = (TextView) view.findViewById(w.h.vote_count_view);
        this.caZ = view.findViewById(w.h.top_divider_line);
        this.cvI = view.findViewById(w.h.bottom_divider_line);
        if ((this.ejD.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.ejD.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
        }
        this.ejL.add(new a(this.ejE));
        this.ejL.add(new a(this.ejI));
        this.ejL.add(new a(this.ejF));
        this.ejL.add(new a(this.ejH));
        this.ejL.add(new a(this.ejG));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aJu();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aJw();
            this.ejJ.setAlpha(1.0f);
            if (this.ejK) {
                Iterator<a> it = this.ejL.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.ejS.setAlpha(0.0f);
                        next.ejS.setClickable(false);
                    }
                }
                aVar.ejS.setNeedTranslate(true);
                this.ejK = false;
            }
        }
    }

    public void aJu() {
        int size = this.ejL.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.ejL.get(i);
            if (aVar != null) {
                aVar.ejS.setOffSet(this.offset);
                aVar.ejS.setOnClickListener(this.bVy);
                if (i < this.ejM.length) {
                    aVar.ejT.setImageResource(this.ejM[i]);
                }
                aVar.ejU.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(boolean z) {
        int size = this.ejL.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.ejL.get(i);
            if (aVar != null) {
                aVar.ejS.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, long j) {
        if (!this.ejO) {
            this.ejO = true;
            if (this.Za != null && view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.ejD.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                ic(false);
                if (this.ejK) {
                    if (aVar.ejW != null) {
                        if (aVar.ejW.Uq) {
                            a(aVar.ejW, false);
                            aVar.id(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            ic(true);
                            this.ejO = false;
                            TiebaStatic.log(new as("c12000").r("obj_id", aVar.ejW.Um).f("tid", this.Za.getTid()));
                            return;
                        }
                        if (this.Za.pD()) {
                            Iterator<a> it = this.ejL.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.ejW, false);
                                    next.id(false);
                                    TiebaStatic.log(new as("c12000").r("obj_id", aVar.ejW.Um).f("tid", this.Za.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.ejW, true);
                        aVar.id(true);
                        TiebaStatic.log(new as("c11999").r("obj_id", aVar.ejW.Um).f("tid", this.Za.getTid()));
                    }
                } else {
                    TiebaStatic.log(new as("c12002").f("tid", this.Za.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.ejL.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.ejK ? ObjectAnimator.ofFloat(next2.ejS, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.ejS, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.ejK) {
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
        if (pVar != null && pVar.pA() != null) {
            this.Za = pVar;
            aJv();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.Za.pA().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.Za.pA().get(i);
                if (qVar != null && i < this.ejM.length) {
                    qVar.Ur = this.ejM[i];
                }
                aVar = (a) x.c(this.ejL, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.Uq) {
                        if (!this.ejK) {
                            aVar.a(qVar);
                            aVar.aJw();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.ejK) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.bRY) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.bRY = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.Uq != z) {
            if (this.ejN == null) {
                this.ejN = new dq();
            }
            if (this.Za != null) {
                this.ejN.eoL = this.Za.pB();
                this.ejN.Ul = this.Za.getTid();
                this.ejN.mForumId = this.Za.getForumId();
            }
            this.ejN.eoM = qVar.Um;
            this.ejN.eoN = z ? 1 : 0;
            this.ejN.aKD();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.ejL.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aq.i(this.ejJ, w.e.cp_cont_c);
            aq.k(this.caZ, w.e.cp_bg_line_c);
            aq.k(this.cvI, w.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJv() {
        String format;
        if (this.Za != null && this.Za.pD()) {
            long bB = this.Za.bB(this.ejM.length);
            if (bB > 0) {
                if (this.Za.pC()) {
                    if (bB == 1) {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_me), new Object[0]);
                    } else {
                        format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_other_to_host), au.t(bB));
                    }
                } else if (bB == 1) {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_me_to_host), new Object[0]);
                } else {
                    format = String.format(TbadkCoreApplication.m9getInst().getString(w.l.declare_text_we_to_host), au.t(bB - 1));
                }
                this.ejJ.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends z.a {
        public DeclareItemView ejS;
        public TbImageView ejT;
        public TextView ejU;
        private String ejV;
        public q ejW;
        private final int ejX;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.ejX = 3;
            if (declareItemView != null) {
                this.ejS = declareItemView;
                this.ejT = (TbImageView) declareItemView.findViewById(w.h.declare_image);
                this.ejU = (TextView) declareItemView.findViewById(w.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aq.i(this.ejU, w.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.ejW = qVar;
                bZ(qVar.Up);
                if (!StringUtils.isNull(qVar.Uo)) {
                    this.ejV = qVar.Uo;
                }
                if (!StringUtils.isNull(qVar.Un)) {
                    this.ejT.c(qVar.Un, 10, false);
                } else {
                    this.ejT.setImageResource(qVar.Ur);
                }
                id(qVar.Uq);
            }
        }

        public void id(boolean z) {
            if (this.ejW != null && this.ejW.Uq != z) {
                if (z) {
                    bZ(this.ejW.Up + 1);
                    this.ejU.setSelected(true);
                } else {
                    bZ(this.ejW.Up - 1);
                    this.ejU.setSelected(false);
                }
                this.ejW.Uq = z;
            }
        }

        public void bZ(long j) {
            if (this.ejW != null && j >= 0) {
                this.ejW.Up = j;
            }
            this.ejU.setText(au.t(j));
        }

        public void aJw() {
            this.ejU.setText(au.c(this.ejV, 3, null));
            this.ejU.setSelected(true);
        }
    }
}
