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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.i;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    private LinearLayout fTQ;
    private final ArrayList<ItemViewHolder> fTR;
    private int height;
    private boolean liF;
    private TbPageContext liG;
    private int mSkinType;
    int margin;
    private int width;

    public HorizontalScrollListView(Context context) {
        super(context);
        this.liF = false;
        this.fTR = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.liF = false;
        this.fTR = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.liF = false;
        this.fTR = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    private void initView(Context context) {
        this.margin = (int) context.getResources().getDimension(R.dimen.ds36);
        this.width = (int) context.getResources().getDimension(R.dimen.ds102);
        this.height = (int) context.getResources().getDimension(R.dimen.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fTQ = new LinearLayout(context);
        this.fTQ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fTQ.setOrientation(0);
        addView(this.fTQ);
    }

    public void setRound(boolean z) {
        this.liF = z;
        if (z) {
            this.margin = (int) getResources().getDimension(R.dimen.ds36);
        } else {
            this.margin = (int) getResources().getDimension(R.dimen.ds18);
        }
    }

    public void setDisplayNum(double d) {
        int dimensionPixelSize;
        int i = (int) d;
        if (Math.abs(d - i) < 0.01d) {
            d = i;
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        }
        this.width = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.margin * (((int) (0.5d + d)) - 1))) / d);
    }

    public void setRatio(double d) {
        this.height = (int) ((this.width * d) + 0.5d);
    }

    public void setData(List<HorRankCard.a> list, TbPageContext tbPageContext) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.liG = tbPageContext;
            int count = y.getCount(this.fTR);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) y.getItem(this.fTR, 0);
                    if (viewHolder != null) {
                        this.fTQ.removeView(viewHolder.getView());
                    }
                    this.fTR.remove(viewHolder);
                }
            }
            int i2 = 0;
            while (i2 < count2) {
                HorRankCard.a aVar = (HorRankCard.a) y.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) y.getItem(this.fTR, i2);
                if (itemViewHolder != null) {
                    a(itemViewHolder.getView(), aVar, i2, i2 == count2 + (-1));
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fTR.add(itemViewHolder2);
                        a(itemViewHolder2.getView(), aVar, i2, i2 == count2 + (-1));
                        this.fTQ.addView(createView);
                    }
                }
                i2++;
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private View createView() {
        return View.inflate(this.liG.getPageActivity(), R.layout.card_horizontal_rank_list_item, null);
    }

    private void b(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
        } else {
            layoutParams.leftMargin = this.margin;
        }
    }

    private void a(View view, final HorRankCard.a aVar, int i, boolean z) {
        if (aVar != null && view != null && view.getTag() != null) {
            if (z) {
                view.setPadding(0, 0, l.getDimens(getContext(), R.dimen.ds24), l.getDimens(getContext(), R.dimen.ds24));
            } else {
                view.setPadding(0, 0, 0, l.getDimens(getContext(), R.dimen.ds24));
            }
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            if (this.liF) {
                itemViewHolder.liO.setIsRound(true);
                itemViewHolder.liR.setVisibility(8);
                if (aVar.rank <= 0) {
                    itemViewHolder.liK.setVisibility(8);
                    itemViewHolder.liL.setVisibility(8);
                } else {
                    switch (aVar.rank) {
                        case 1:
                            itemViewHolder.liK.setVisibility(0);
                            ap.setImageResource(itemViewHolder.liK, R.drawable.icon_grade_star_no1);
                            itemViewHolder.liL.setVisibility(8);
                            break;
                        case 2:
                            itemViewHolder.liK.setVisibility(0);
                            ap.setImageResource(itemViewHolder.liK, R.drawable.icon_grade_star_no2);
                            itemViewHolder.liL.setVisibility(8);
                            break;
                        case 3:
                            itemViewHolder.liK.setVisibility(0);
                            ap.setImageResource(itemViewHolder.liK, R.drawable.icon_grade_star_no3);
                            itemViewHolder.liL.setVisibility(8);
                            break;
                        default:
                            itemViewHolder.liL.setVisibility(0);
                            itemViewHolder.liM.getDrawable().setColorFilter(ap.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                            itemViewHolder.liK.setVisibility(8);
                            ap.setViewTextColor(itemViewHolder.liN, R.color.CAM_X0111);
                            itemViewHolder.liN.setText("" + (i + 1));
                            break;
                    }
                }
            } else {
                itemViewHolder.liO.setIsRound(false);
                ap.setViewTextColor(itemViewHolder.liR, R.color.CAM_X0111);
                itemViewHolder.liK.setVisibility(8);
                itemViewHolder.liL.setVisibility(8);
                if (aVar.rank <= 0) {
                    itemViewHolder.liR.setVisibility(8);
                } else {
                    itemViewHolder.liR.setVisibility(0);
                    itemViewHolder.liR.setText(String.valueOf(aVar.rank));
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        if (!com.baidu.tieba.lego.card.c.b.DW(aVar.bgColorNight)) {
                            itemViewHolder.liR.setBackgroundColor(aVar.bgColorNight);
                        } else {
                            ap.setBackgroundColor(itemViewHolder.liR, com.baidu.tieba.lego.a.lbI[i <= 3 ? i : 3]);
                        }
                    } else if (!com.baidu.tieba.lego.card.c.b.DW(aVar.bgColor)) {
                        itemViewHolder.liR.setBackgroundColor(aVar.bgColor);
                    } else {
                        ap.setBackgroundColor(itemViewHolder.liR, com.baidu.tieba.lego.a.lbI[i <= 3 ? i : 3]);
                    }
                }
                itemViewHolder.liO.setRadius(0);
            }
            if (!TextUtils.isEmpty(aVar.lec)) {
                itemViewHolder.liO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!TextUtils.isEmpty(aVar.lec)) {
                            t.csH().mG(true);
                            i.a((BaseLegoCardInfo) aVar.led).fF(TiebaInitialize.Params.OBJ_URL, aVar.lec).a(aVar.led);
                            v.j(HorizontalScrollListView.this.liG, aVar.lec);
                        }
                    }
                });
            } else {
                itemViewHolder.liO.setOnClickListener(null);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.liO.getLayoutParams();
            layoutParams.width = this.width;
            layoutParams.height = this.height;
            b(layoutParams, i);
            if (this.liF) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
            } else {
                layoutParams.topMargin = 0;
            }
            itemViewHolder.liO.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.liR.getLayoutParams();
            b(layoutParams2, i);
            itemViewHolder.liR.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.liJ.getLayoutParams();
            layoutParams3.width = this.width;
            b(layoutParams3, i);
            itemViewHolder.liJ.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.liQ.getLayoutParams();
            layoutParams4.width = this.width;
            b(layoutParams4, i);
            itemViewHolder.liQ.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.liS.getLayoutParams();
            layoutParams5.width = this.width;
            b(layoutParams5, i);
            itemViewHolder.liS.setLayoutParams(layoutParams5);
            itemViewHolder.liO.setTag(aVar.picUrl);
            itemViewHolder.liO.startLoad(aVar.picUrl, 10, false);
            if (!TextUtils.isEmpty(aVar.leb)) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.liP.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.ds30);
                int dimens2 = l.getDimens(getContext(), R.dimen.ds6);
                int dimens3 = l.getDimens(getContext(), R.dimen.ds18);
                int i2 = ((this.width - dimens) + this.margin) - dimens2;
                if (i == 0) {
                    i2 = (i2 - dimens3) + dimens2;
                }
                layoutParams6.setMargins(i2, (this.height - dimens) + dimens2, 0, 0);
                itemViewHolder.liP.setLayoutParams(layoutParams6);
                itemViewHolder.liP.startLoad(aVar.leb, 10, false);
            } else {
                itemViewHolder.liP.setVisibility(8);
            }
            if (aVar.title != null) {
                itemViewHolder.fUf.setVisibility(0);
                if (this.liF) {
                    if (aVar.rank <= 0) {
                        itemViewHolder.fUf.setMaxWidth(this.width);
                    } else {
                        itemViewHolder.fUf.setMaxWidth((this.width - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                    }
                } else {
                    itemViewHolder.fUf.setMaxWidth(this.width);
                }
                itemViewHolder.fUf.setText(aVar.title);
            } else {
                itemViewHolder.fUf.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.subTitle)) {
                try {
                    itemViewHolder.mSubtitleTextView.setText(au.numberUniformFormat(Long.parseLong(aVar.subTitle)).toLowerCase());
                } catch (Exception e) {
                    itemViewHolder.mSubtitleTextView.setText(aVar.subTitle);
                }
                ap.setViewTextColor(itemViewHolder.mSubtitleTextView, R.color.CAM_X0312);
                itemViewHolder.mSubtitleTextView.setVisibility(0);
            } else {
                itemViewHolder.mSubtitleTextView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.postUrl) && !TextUtils.isEmpty(aVar.btnText) && !TextUtils.isEmpty(aVar.btnDone)) {
                itemViewHolder.liS.setVisibility(0);
                a(itemViewHolder.liT, aVar.isDone, aVar.btnText, aVar.btnDone);
                itemViewHolder.liT.setTag(aVar.postUrl);
                itemViewHolder.liT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (bh.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                            com.baidu.tieba.lego.a.b.dbA().a(aVar, aVar.postUrl, null, null);
                        }
                    }
                });
                return;
            }
            itemViewHolder.liS.setVisibility(8);
        }
    }

    private void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ap.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        ap.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<ItemViewHolder> it = this.fTR.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(ItemViewHolder itemViewHolder, int i) {
        if (itemViewHolder != null && itemViewHolder.getView() != null) {
            ap.setViewTextColor(itemViewHolder.fUf, R.color.CAM_X0108, 1);
        }
    }

    /* loaded from: classes8.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public TextView fUf;
        public LinearLayout liJ;
        public ImageView liK;
        public FrameLayout liL;
        public ImageView liM;
        public TextView liN;
        public HeadImageView liO;
        public TbImageView liP;
        public LinearLayout liQ;
        public TextView liR;
        public LinearLayout liS;
        public TextView liT;
        public TextView mSubtitleTextView;

        public ItemViewHolder(View view) {
            super(view);
            this.liK = null;
            this.liL = null;
            this.liM = null;
            this.liN = null;
            this.liO = null;
            this.liP = null;
            this.fUf = null;
            this.liQ = null;
            this.mSubtitleTextView = null;
            this.liR = null;
            this.liS = null;
            this.liT = null;
            this.liJ = (LinearLayout) view.findViewById(R.id.ll_name);
            this.liL = (FrameLayout) view.findViewById(R.id.fl_left);
            this.liM = (ImageView) view.findViewById(R.id.leftBack);
            this.liK = (ImageView) view.findViewById(R.id.leftIcon);
            this.liN = (TextView) view.findViewById(R.id.leftText);
            this.liO = (HeadImageView) view.findViewById(R.id.head);
            this.liO.setGifIconSupport(false);
            this.liP = (TbImageView) view.findViewById(R.id.head_icon);
            this.fUf = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.liQ = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.mSubtitleTextView = (TextView) view.findViewById(R.id.subtitle);
            this.liR = (TextView) view.findViewById(R.id.leftTopText);
            this.liS = (LinearLayout) view.findViewById(R.id.ll_post);
            this.liT = (TextView) view.findViewById(R.id.btn_post);
        }
    }
}
