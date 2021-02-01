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
/* loaded from: classes9.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    private LinearLayout fSq;
    private final ArrayList<ItemViewHolder> fSr;
    private int height;
    private boolean lgp;
    private TbPageContext lgq;
    private int mSkinType;
    int margin;
    private int width;

    public HorizontalScrollListView(Context context) {
        super(context);
        this.lgp = false;
        this.fSr = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lgp = false;
        this.fSr = new ArrayList<>();
        this.mSkinType = 3;
        initView(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lgp = false;
        this.fSr = new ArrayList<>();
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
        this.fSq = new LinearLayout(context);
        this.fSq.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fSq.setOrientation(0);
        addView(this.fSq);
    }

    public void setRound(boolean z) {
        this.lgp = z;
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
            this.lgq = tbPageContext;
            int count = y.getCount(this.fSr);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) y.getItem(this.fSr, 0);
                    if (viewHolder != null) {
                        this.fSq.removeView(viewHolder.getView());
                    }
                    this.fSr.remove(viewHolder);
                }
            }
            int i2 = 0;
            while (i2 < count2) {
                HorRankCard.a aVar = (HorRankCard.a) y.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) y.getItem(this.fSr, i2);
                if (itemViewHolder != null) {
                    a(itemViewHolder.getView(), aVar, i2, i2 == count2 + (-1));
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fSr.add(itemViewHolder2);
                        a(itemViewHolder2.getView(), aVar, i2, i2 == count2 + (-1));
                        this.fSq.addView(createView);
                    }
                }
                i2++;
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private View createView() {
        return View.inflate(this.lgq.getPageActivity(), R.layout.card_horizontal_rank_list_item, null);
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
            if (this.lgp) {
                itemViewHolder.lgy.setIsRound(true);
                itemViewHolder.lgB.setVisibility(8);
                if (aVar.rank <= 0) {
                    itemViewHolder.lgu.setVisibility(8);
                    itemViewHolder.lgv.setVisibility(8);
                } else {
                    switch (aVar.rank) {
                        case 1:
                            itemViewHolder.lgu.setVisibility(0);
                            ap.setImageResource(itemViewHolder.lgu, R.drawable.icon_grade_star_no1);
                            itemViewHolder.lgv.setVisibility(8);
                            break;
                        case 2:
                            itemViewHolder.lgu.setVisibility(0);
                            ap.setImageResource(itemViewHolder.lgu, R.drawable.icon_grade_star_no2);
                            itemViewHolder.lgv.setVisibility(8);
                            break;
                        case 3:
                            itemViewHolder.lgu.setVisibility(0);
                            ap.setImageResource(itemViewHolder.lgu, R.drawable.icon_grade_star_no3);
                            itemViewHolder.lgv.setVisibility(8);
                            break;
                        default:
                            itemViewHolder.lgv.setVisibility(0);
                            itemViewHolder.lgw.getDrawable().setColorFilter(ap.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                            itemViewHolder.lgu.setVisibility(8);
                            ap.setViewTextColor(itemViewHolder.lgx, R.color.CAM_X0111);
                            itemViewHolder.lgx.setText("" + (i + 1));
                            break;
                    }
                }
            } else {
                itemViewHolder.lgy.setIsRound(false);
                ap.setViewTextColor(itemViewHolder.lgB, R.color.CAM_X0111);
                itemViewHolder.lgu.setVisibility(8);
                itemViewHolder.lgv.setVisibility(8);
                if (aVar.rank <= 0) {
                    itemViewHolder.lgB.setVisibility(8);
                } else {
                    itemViewHolder.lgB.setVisibility(0);
                    itemViewHolder.lgB.setText(String.valueOf(aVar.rank));
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        if (!com.baidu.tieba.lego.card.c.b.DT(aVar.bgColorNight)) {
                            itemViewHolder.lgB.setBackgroundColor(aVar.bgColorNight);
                        } else {
                            ap.setBackgroundColor(itemViewHolder.lgB, com.baidu.tieba.lego.a.kZr[i <= 3 ? i : 3]);
                        }
                    } else if (!com.baidu.tieba.lego.card.c.b.DT(aVar.bgColor)) {
                        itemViewHolder.lgB.setBackgroundColor(aVar.bgColor);
                    } else {
                        ap.setBackgroundColor(itemViewHolder.lgB, com.baidu.tieba.lego.a.kZr[i <= 3 ? i : 3]);
                    }
                }
                itemViewHolder.lgy.setRadius(0);
            }
            if (!TextUtils.isEmpty(aVar.lbL)) {
                itemViewHolder.lgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!TextUtils.isEmpty(aVar.lbL)) {
                            t.csu().mG(true);
                            i.a((BaseLegoCardInfo) aVar.lbM).fF(TiebaInitialize.Params.OBJ_URL, aVar.lbL).a(aVar.lbM);
                            v.j(HorizontalScrollListView.this.lgq, aVar.lbL);
                        }
                    }
                });
            } else {
                itemViewHolder.lgy.setOnClickListener(null);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.lgy.getLayoutParams();
            layoutParams.width = this.width;
            layoutParams.height = this.height;
            b(layoutParams, i);
            if (this.lgp) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
            } else {
                layoutParams.topMargin = 0;
            }
            itemViewHolder.lgy.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.lgB.getLayoutParams();
            b(layoutParams2, i);
            itemViewHolder.lgB.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.lgt.getLayoutParams();
            layoutParams3.width = this.width;
            b(layoutParams3, i);
            itemViewHolder.lgt.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.lgA.getLayoutParams();
            layoutParams4.width = this.width;
            b(layoutParams4, i);
            itemViewHolder.lgA.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.lgC.getLayoutParams();
            layoutParams5.width = this.width;
            b(layoutParams5, i);
            itemViewHolder.lgC.setLayoutParams(layoutParams5);
            itemViewHolder.lgy.setTag(aVar.picUrl);
            itemViewHolder.lgy.startLoad(aVar.picUrl, 10, false);
            if (!TextUtils.isEmpty(aVar.lbK)) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.lgz.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.ds30);
                int dimens2 = l.getDimens(getContext(), R.dimen.ds6);
                int dimens3 = l.getDimens(getContext(), R.dimen.ds18);
                int i2 = ((this.width - dimens) + this.margin) - dimens2;
                if (i == 0) {
                    i2 = (i2 - dimens3) + dimens2;
                }
                layoutParams6.setMargins(i2, (this.height - dimens) + dimens2, 0, 0);
                itemViewHolder.lgz.setLayoutParams(layoutParams6);
                itemViewHolder.lgz.startLoad(aVar.lbK, 10, false);
            } else {
                itemViewHolder.lgz.setVisibility(8);
            }
            if (aVar.title != null) {
                itemViewHolder.fSF.setVisibility(0);
                if (this.lgp) {
                    if (aVar.rank <= 0) {
                        itemViewHolder.fSF.setMaxWidth(this.width);
                    } else {
                        itemViewHolder.fSF.setMaxWidth((this.width - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                    }
                } else {
                    itemViewHolder.fSF.setMaxWidth(this.width);
                }
                itemViewHolder.fSF.setText(aVar.title);
            } else {
                itemViewHolder.fSF.setVisibility(8);
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
                itemViewHolder.lgC.setVisibility(0);
                a(itemViewHolder.lgD, aVar.isDone, aVar.btnText, aVar.btnDone);
                itemViewHolder.lgD.setTag(aVar.postUrl);
                itemViewHolder.lgD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (bh.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                            com.baidu.tieba.lego.a.b.dbk().a(aVar, aVar.postUrl, null, null);
                        }
                    }
                });
                return;
            }
            itemViewHolder.lgC.setVisibility(8);
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
            Iterator<ItemViewHolder> it = this.fSr.iterator();
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
            ap.setViewTextColor(itemViewHolder.fSF, R.color.CAM_X0108, 1);
        }
    }

    /* loaded from: classes9.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public TextView fSF;
        public LinearLayout lgA;
        public TextView lgB;
        public LinearLayout lgC;
        public TextView lgD;
        public LinearLayout lgt;
        public ImageView lgu;
        public FrameLayout lgv;
        public ImageView lgw;
        public TextView lgx;
        public HeadImageView lgy;
        public TbImageView lgz;
        public TextView mSubtitleTextView;

        public ItemViewHolder(View view) {
            super(view);
            this.lgu = null;
            this.lgv = null;
            this.lgw = null;
            this.lgx = null;
            this.lgy = null;
            this.lgz = null;
            this.fSF = null;
            this.lgA = null;
            this.mSubtitleTextView = null;
            this.lgB = null;
            this.lgC = null;
            this.lgD = null;
            this.lgt = (LinearLayout) view.findViewById(R.id.ll_name);
            this.lgv = (FrameLayout) view.findViewById(R.id.fl_left);
            this.lgw = (ImageView) view.findViewById(R.id.leftBack);
            this.lgu = (ImageView) view.findViewById(R.id.leftIcon);
            this.lgx = (TextView) view.findViewById(R.id.leftText);
            this.lgy = (HeadImageView) view.findViewById(R.id.head);
            this.lgy.setGifIconSupport(false);
            this.lgz = (TbImageView) view.findViewById(R.id.head_icon);
            this.fSF = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.lgA = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.mSubtitleTextView = (TextView) view.findViewById(R.id.subtitle);
            this.lgB = (TextView) view.findViewById(R.id.leftTopText);
            this.lgC = (LinearLayout) view.findViewById(R.id.ll_post);
            this.lgD = (TextView) view.findViewById(R.id.btn_post);
        }
    }
}
