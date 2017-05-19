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
import com.baidu.tieba.pb.pb.main.dk;
import com.baidu.tieba.pb.view.DeclareItemView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends y.a {
    private p Ze;
    private boolean bMl;
    private View.OnClickListener bPI;
    View bUY;
    View cpl;
    LinearLayout eed;
    DeclareItemView eee;
    DeclareItemView eef;
    DeclareItemView eeg;
    DeclareItemView eeh;
    DeclareItemView eei;
    TextView eej;
    private boolean eek;
    private ArrayList<a> eel;
    private int[] eem;
    private dk een;
    private boolean eeo;
    private Context mContext;
    private int mSkinType;
    private int offset;

    public d(View view, Context context) {
        super(view);
        this.eek = true;
        this.eel = new ArrayList<>();
        this.mSkinType = 3;
        this.eem = new int[]{w.g.image_emoticon_huaji, w.g.image_emoticon_zan, w.g.image_emoticon_love, w.g.image_emoticon_shuitei, w.g.image_emoticon_shengqi};
        this.offset = 0;
        this.eeo = false;
        this.bMl = true;
        this.bPI = new e(this);
        aQ(view);
        this.mContext = context;
    }

    public void aQ(View view) {
        FrameLayout.LayoutParams layoutParams;
        this.eed = (LinearLayout) view.findViewById(w.h.emotion_vote);
        this.eee = (DeclareItemView) view.findViewById(w.h.huaji_item);
        this.eei = (DeclareItemView) view.findViewById(w.h.zan_item);
        this.eef = (DeclareItemView) view.findViewById(w.h.love_item);
        this.eeg = (DeclareItemView) view.findViewById(w.h.shengqi_item);
        this.eeh = (DeclareItemView) view.findViewById(w.h.tushui_item);
        this.eej = (TextView) view.findViewById(w.h.vote_count_view);
        this.bUY = view.findViewById(w.h.top_divider_line);
        this.cpl = view.findViewById(w.h.bottom_divider_line);
        if ((this.eed.getLayoutParams() instanceof FrameLayout.LayoutParams) && (layoutParams = (FrameLayout.LayoutParams) this.eed.getLayoutParams()) != null) {
            this.offset = layoutParams.rightMargin - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds8);
        }
        this.eel.add(new a(this.eee));
        this.eel.add(new a(this.eei));
        this.eel.add(new a(this.eef));
        this.eel.add(new a(this.eeh));
        this.eel.add(new a(this.eeg));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aIC();
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.aIE();
            this.eej.setAlpha(1.0f);
            if (this.eek) {
                Iterator<a> it = this.eel.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next != aVar) {
                        next.ees.setAlpha(0.0f);
                        next.ees.setClickable(false);
                    }
                }
                aVar.ees.setNeedTranslate(true);
                this.eek = false;
            }
        }
    }

    public void aIC() {
        int size = this.eel.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eel.get(i);
            if (aVar != null) {
                aVar.ees.setOffSet(this.offset);
                aVar.ees.setOnClickListener(this.bPI);
                if (i < this.eem.length) {
                    aVar.eet.setImageResource(this.eem[i]);
                }
                aVar.eeu.setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(boolean z) {
        int size = this.eel.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.eel.get(i);
            if (aVar != null) {
                aVar.ees.setClickable(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, long j) {
        if (!this.eeo) {
            this.eeo = true;
            if (this.Ze != null && view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                float measuredWidth = this.offset + ((this.eed.getMeasuredWidth() - view.getX()) - view.getMeasuredWidth());
                hO(false);
                if (this.eek) {
                    if (aVar.eew != null) {
                        if (aVar.eew.UE) {
                            a(aVar.eew, false);
                            aVar.hP(false);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet.setDuration(j).start();
                            hO(true);
                            this.eeo = false;
                            TiebaStatic.log(new as("c12000").s("obj_id", aVar.eew.Uz).g("tid", this.Ze.getTid()));
                            return;
                        }
                        if (this.Ze.pL()) {
                            Iterator<a> it = this.eel.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null && next != aVar) {
                                    a(aVar.eew, false);
                                    next.hP(false);
                                    TiebaStatic.log(new as("c12000").s("obj_id", aVar.eew.Uz).g("tid", this.Ze.getTid()));
                                }
                            }
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.3f, 1.0f)).with(ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.3f, 1.0f));
                            animatorSet2.setDuration(j).start();
                        }
                        a(aVar.eew, true);
                        aVar.hP(true);
                        TiebaStatic.log(new as("c11999").s("obj_id", aVar.eew.Uz).g("tid", this.Ze.getTid()));
                    }
                } else {
                    TiebaStatic.log(new as("c12002").g("tid", this.Ze.getTid()));
                    measuredWidth = 0.0f;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<a> it2 = this.eel.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2 != null && next2 != aVar) {
                        arrayList.add(this.eek ? ObjectAnimator.ofFloat(next2.ees, "alpha", 1.0f, 0.0f) : ObjectAnimator.ofFloat(next2.ees, "alpha", 0.0f, 1.0f));
                    }
                }
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(arrayList);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", measuredWidth);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                if (this.eek) {
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
        if (pVar != null && pVar.pI() != null) {
            this.Ze = pVar;
            aID();
            a aVar2 = null;
            int i = 0;
            while (true) {
                if (i >= this.Ze.pI().size()) {
                    aVar = aVar2;
                    break;
                }
                q qVar = this.Ze.pI().get(i);
                if (qVar != null && i < this.eem.length) {
                    qVar.UF = this.eem[i];
                }
                aVar = (a) x.c(this.eel, i);
                if (aVar != null) {
                    if (aVar2 == null && qVar.UE) {
                        if (!this.eek) {
                            aVar.a(qVar);
                            aVar.aIE();
                            break;
                        }
                        aVar2 = aVar;
                    }
                    if (this.eek) {
                        aVar.a(qVar);
                    }
                }
                i++;
            }
            if (aVar != null && this.bMl) {
                a(aVar);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.bMl = false;
        }
    }

    private void a(q qVar, boolean z) {
        if (qVar != null && qVar.UE != z) {
            if (this.een == null) {
                this.een = new dk();
            }
            if (this.Ze != null) {
                this.een.ejc = this.Ze.pJ();
                this.een.Uy = this.Ze.getTid();
                this.een.mForumId = this.Ze.getForumId();
            }
            this.een.ejd = qVar.Uz;
            this.een.eje = z ? 1 : 0;
            this.een.aJJ();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eel.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
            aq.i(this.eej, w.e.cp_cont_c);
            aq.k(this.bUY, w.e.cp_bg_line_c);
            aq.k(this.cpl, w.e.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aID() {
        String format;
        if (this.Ze != null && this.Ze.pL()) {
            long bA = this.Ze.bA(this.eem.length);
            if (bA > 0) {
                if (this.Ze.pK()) {
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
                this.eej.setText(format);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public DeclareItemView ees;
        public TbImageView eet;
        public TextView eeu;
        private String eev;
        public q eew;
        private final int eex;
        private int mSkinType;

        public a(DeclareItemView declareItemView) {
            super(declareItemView);
            this.mSkinType = 3;
            this.eex = 3;
            if (declareItemView != null) {
                this.ees = declareItemView;
                this.eet = (TbImageView) declareItemView.findViewById(w.h.declare_image);
                this.eeu = (TextView) declareItemView.findViewById(w.h.declare_count);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aq.i(this.eeu, w.g.pb_declare_count_selector);
                this.mSkinType = i;
            }
        }

        public void a(q qVar) {
            if (qVar != null) {
                this.eew = qVar;
                bW(qVar.UD);
                if (!StringUtils.isNull(qVar.UC)) {
                    this.eev = qVar.UC;
                }
                if (!StringUtils.isNull(qVar.UB)) {
                    this.eet.c(qVar.UB, 10, false);
                } else {
                    this.eet.setImageResource(qVar.UF);
                }
                hP(qVar.UE);
            }
        }

        public void hP(boolean z) {
            if (this.eew != null && this.eew.UE != z) {
                if (z) {
                    bW(this.eew.UD + 1);
                    this.eeu.setSelected(true);
                } else {
                    bW(this.eew.UD - 1);
                    this.eeu.setSelected(false);
                }
                this.eew.UE = z;
            }
        }

        public void bW(long j) {
            if (this.eew != null && j >= 0) {
                this.eew.UD = j;
            }
            this.eeu.setText(au.t(j));
        }

        public void aIE() {
            this.eeu.setText(au.c(this.eev, 3, null));
            this.eeu.setSelected(true);
        }
    }
}
