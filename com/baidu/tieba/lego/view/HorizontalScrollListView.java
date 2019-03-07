package com.baidu.tieba.lego.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.i;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    private LinearLayout cyp;
    private final ArrayList<a> cyq;
    private boolean gLH;
    int gLI;
    private TbPageContext gLJ;
    private int height;
    private int mSkinType;
    private int width;

    public HorizontalScrollListView(Context context) {
        super(context);
        this.gLH = false;
        this.cyq = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLH = false;
        this.cyq = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLH = false;
        this.cyq = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    private void initView(Context context) {
        this.gLI = (int) context.getResources().getDimension(d.e.ds36);
        this.width = (int) context.getResources().getDimension(d.e.ds102);
        this.height = (int) context.getResources().getDimension(d.e.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.cyp = new LinearLayout(context);
        this.cyp.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cyp.setOrientation(0);
        addView(this.cyp);
    }

    public void setRound(boolean z) {
        this.gLH = z;
        if (z) {
            this.gLI = (int) getResources().getDimension(d.e.ds36);
        } else {
            this.gLI = (int) getResources().getDimension(d.e.ds18);
        }
    }

    public void setDisplayNum(double d) {
        int dimensionPixelSize;
        int i = (int) d;
        if (Math.abs(d - i) < 0.01d) {
            d = i;
            dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24) * 2;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        }
        this.width = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.gLI * (((int) (0.5d + d)) - 1))) / d);
    }

    public void setRatio(double d) {
        this.height = (int) ((this.width * d) + 0.5d);
    }

    public void setData(List<HorRankCard.a> list, TbPageContext tbPageContext) {
        if (v.S(list) > 0 && tbPageContext != null) {
            this.gLJ = tbPageContext;
            int S = v.S(this.cyq);
            int S2 = v.S(list);
            if (S > S2) {
                for (int i = 0; i < S - S2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.c(this.cyq, 0);
                    if (aVar != null) {
                        this.cyp.removeView(aVar.getView());
                    }
                    this.cyq.remove(aVar);
                }
            }
            int i2 = 0;
            while (i2 < S2) {
                HorRankCard.a aVar2 = (HorRankCard.a) com.baidu.tbadk.core.util.v.c(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.c(this.cyq, i2);
                if (aVar3 != null) {
                    a(aVar3.getView(), aVar2, i2, i2 == S2 + (-1));
                } else {
                    View oM = oM();
                    if (oM != null) {
                        a aVar4 = new a(oM);
                        this.cyq.add(aVar4);
                        a(aVar4.getView(), aVar2, i2, i2 == S2 + (-1));
                        this.cyp.addView(oM);
                    }
                }
                i2++;
            }
            hN(this.mSkinType);
        }
    }

    private View oM() {
        return View.inflate(this.gLJ.getPageActivity(), d.h.card_horizontal_rank_list_item, null);
    }

    private void a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds24);
        } else {
            layoutParams.leftMargin = this.gLI;
        }
    }

    private void a(View view, final HorRankCard.a aVar, int i, boolean z) {
        if (aVar != null && view != null && view.getTag() != null) {
            if (z) {
                view.setPadding(0, 0, l.h(getContext(), d.e.ds24), l.h(getContext(), d.e.ds24));
            } else {
                view.setPadding(0, 0, 0, l.h(getContext(), d.e.ds24));
            }
            a aVar2 = (a) view.getTag();
            if (this.gLH) {
                aVar2.gLR.setIsRound(true);
                aVar2.gLU.setVisibility(8);
                if (aVar.rank <= 0) {
                    aVar2.gLN.setVisibility(8);
                    aVar2.gLO.setVisibility(8);
                } else {
                    switch (aVar.rank) {
                        case 1:
                            aVar2.gLN.setVisibility(0);
                            al.c(aVar2.gLN, d.f.icon_grade_star_no1);
                            aVar2.gLO.setVisibility(8);
                            break;
                        case 2:
                            aVar2.gLN.setVisibility(0);
                            al.c(aVar2.gLN, d.f.icon_grade_star_no2);
                            aVar2.gLO.setVisibility(8);
                            break;
                        case 3:
                            aVar2.gLN.setVisibility(0);
                            al.c(aVar2.gLN, d.f.icon_grade_star_no3);
                            aVar2.gLO.setVisibility(8);
                            break;
                        default:
                            aVar2.gLO.setVisibility(0);
                            aVar2.gLP.getDrawable().setColorFilter(al.getColor(d.C0236d.cp_bg_line_a), PorterDuff.Mode.SRC);
                            aVar2.gLN.setVisibility(8);
                            al.j(aVar2.gLQ, d.C0236d.cp_cont_g);
                            aVar2.gLQ.setText("" + (i + 1));
                            break;
                    }
                }
            } else {
                aVar2.gLR.setIsRound(false);
                al.j(aVar2.gLU, d.C0236d.cp_cont_g);
                aVar2.gLN.setVisibility(8);
                aVar2.gLO.setVisibility(8);
                if (aVar.rank <= 0) {
                    aVar2.gLU.setVisibility(8);
                } else {
                    aVar2.gLU.setVisibility(0);
                    aVar2.gLU.setText(String.valueOf(aVar.rank));
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        if (!com.baidu.tieba.lego.card.d.a.uP(aVar.bgColorNight)) {
                            aVar2.gLU.setBackgroundColor(aVar.bgColorNight);
                        } else {
                            al.l(aVar2.gLU, com.baidu.tieba.lego.a.gEA[i <= 3 ? i : 3]);
                        }
                    } else if (!com.baidu.tieba.lego.card.d.a.uP(aVar.bgColor)) {
                        aVar2.gLU.setBackgroundColor(aVar.bgColor);
                    } else {
                        al.l(aVar2.gLU, com.baidu.tieba.lego.a.gEA[i <= 3 ? i : 3]);
                    }
                }
                aVar2.gLR.setRadius(0);
            }
            if (!TextUtils.isEmpty(aVar.gGZ)) {
                aVar2.gLR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!TextUtils.isEmpty(aVar.gGZ)) {
                            t.aQF().go(true);
                            i.a((BaseLegoCardInfo) aVar.gHa).di("obj_url", aVar.gGZ).a(aVar.gHa);
                            q.f(HorizontalScrollListView.this.gLJ, aVar.gGZ);
                        }
                    }
                });
            } else {
                aVar2.gLR.setOnClickListener(null);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar2.gLR.getLayoutParams();
            layoutParams.width = this.width;
            layoutParams.height = this.height;
            a(layoutParams, i);
            if (this.gLH) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(d.e.ds10);
            } else {
                layoutParams.topMargin = 0;
            }
            aVar2.gLR.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.gLU.getLayoutParams();
            a(layoutParams2, i);
            aVar2.gLU.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aVar2.gLM.getLayoutParams();
            layoutParams3.width = this.width;
            a(layoutParams3, i);
            aVar2.gLM.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aVar2.gLT.getLayoutParams();
            layoutParams4.width = this.width;
            a(layoutParams4, i);
            aVar2.gLT.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) aVar2.gLV.getLayoutParams();
            layoutParams5.width = this.width;
            a(layoutParams5, i);
            aVar2.gLV.setLayoutParams(layoutParams5);
            aVar2.gLR.setTag(aVar.picUrl);
            aVar2.gLR.startLoad(aVar.picUrl, 10, false);
            if (!TextUtils.isEmpty(aVar.gGY)) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) aVar2.gLS.getLayoutParams();
                int h = l.h(getContext(), d.e.ds30);
                int h2 = l.h(getContext(), d.e.ds6);
                int h3 = l.h(getContext(), d.e.ds18);
                int i2 = ((this.width - h) + this.gLI) - h2;
                if (i == 0) {
                    i2 = (i2 - h3) + h2;
                }
                layoutParams6.setMargins(i2, (this.height - h) + h2, 0, 0);
                aVar2.gLS.setLayoutParams(layoutParams6);
                aVar2.gLS.startLoad(aVar.gGY, 10, false);
            } else {
                aVar2.gLS.setVisibility(8);
            }
            if (aVar.title != null) {
                aVar2.cyE.setVisibility(0);
                if (this.gLH) {
                    if (aVar.rank <= 0) {
                        aVar2.cyE.setMaxWidth(this.width);
                    } else {
                        aVar2.cyE.setMaxWidth((this.width - getResources().getDimensionPixelSize(d.e.ds22)) - getResources().getDimensionPixelSize(d.e.ds4));
                    }
                } else {
                    aVar2.cyE.setMaxWidth(this.width);
                }
                aVar2.cyE.setText(aVar.title);
            } else {
                aVar2.cyE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.subTitle)) {
                try {
                    aVar2.mSubtitleTextView.setText(ap.as(Long.parseLong(aVar.subTitle)).toLowerCase());
                } catch (Exception e) {
                    aVar2.mSubtitleTextView.setText(aVar.subTitle);
                }
                al.j(aVar2.mSubtitleTextView, d.C0236d.cp_other_e);
                aVar2.mSubtitleTextView.setVisibility(0);
            } else {
                aVar2.mSubtitleTextView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.postUrl) && !TextUtils.isEmpty(aVar.btnText) && !TextUtils.isEmpty(aVar.btnDone)) {
                aVar2.gLV.setVisibility(0);
                a(aVar2.gLW, aVar.isDone, aVar.btnText, aVar.btnDone);
                aVar2.gLW.setTag(aVar.postUrl);
                aVar2.gLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (bc.cZ(HorizontalScrollListView.this.getContext())) {
                            com.baidu.tieba.lego.a.b.bzz().a(aVar, aVar.postUrl, null, null);
                        }
                    }
                });
                return;
            }
            aVar2.gLV.setVisibility(8);
        }
    }

    private void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            al.d(textView, d.C0236d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.d(textView, d.C0236d.btn_forum_focus_color, 1);
        textView.setText(str);
        al.k(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    public void hN(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.cyq.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            al.d(aVar.cyE, d.C0236d.cp_cont_c, 1);
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public TextView cyE;
        public LinearLayout gLM;
        public ImageView gLN;
        public FrameLayout gLO;
        public ImageView gLP;
        public TextView gLQ;
        public HeadImageView gLR;
        public TbImageView gLS;
        public LinearLayout gLT;
        public TextView gLU;
        public LinearLayout gLV;
        public TextView gLW;
        public TextView mSubtitleTextView;

        public a(View view) {
            super(view);
            this.gLN = null;
            this.gLO = null;
            this.gLP = null;
            this.gLQ = null;
            this.gLR = null;
            this.gLS = null;
            this.cyE = null;
            this.gLT = null;
            this.mSubtitleTextView = null;
            this.gLU = null;
            this.gLV = null;
            this.gLW = null;
            this.gLM = (LinearLayout) view.findViewById(d.g.ll_name);
            this.gLO = (FrameLayout) view.findViewById(d.g.fl_left);
            this.gLP = (ImageView) view.findViewById(d.g.leftBack);
            this.gLN = (ImageView) view.findViewById(d.g.leftIcon);
            this.gLQ = (TextView) view.findViewById(d.g.leftText);
            this.gLR = (HeadImageView) view.findViewById(d.g.head);
            this.gLR.setGifIconSupport(false);
            this.gLS = (TbImageView) view.findViewById(d.g.head_icon);
            this.cyE = (TextView) view.findViewById(d.g.m_forum_name_textview);
            this.gLT = (LinearLayout) view.findViewById(d.g.ll_subtitle);
            this.mSubtitleTextView = (TextView) view.findViewById(d.g.subtitle);
            this.gLU = (TextView) view.findViewById(d.g.leftTopText);
            this.gLV = (LinearLayout) view.findViewById(d.g.ll_post);
            this.gLW = (TextView) view.findViewById(d.g.btn_post);
        }
    }
}
