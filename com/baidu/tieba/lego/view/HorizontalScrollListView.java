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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.i;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    private LinearLayout fUK;
    private final ArrayList<ItemViewHolder> fUL;
    private int height;
    private boolean lcS;
    private TbPageContext lcT;
    private int mSkinType;
    int margin;
    private int width;

    public HorizontalScrollListView(Context context) {
        super(context);
        this.lcS = false;
        this.fUL = new ArrayList<>();
        this.mSkinType = 3;
        eO(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lcS = false;
        this.fUL = new ArrayList<>();
        this.mSkinType = 3;
        eO(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lcS = false;
        this.fUL = new ArrayList<>();
        this.mSkinType = 3;
        eO(context);
    }

    private void eO(Context context) {
        this.margin = (int) context.getResources().getDimension(R.dimen.ds36);
        this.width = (int) context.getResources().getDimension(R.dimen.ds102);
        this.height = (int) context.getResources().getDimension(R.dimen.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fUK = new LinearLayout(context);
        this.fUK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fUK.setOrientation(0);
        addView(this.fUK);
    }

    public void setRound(boolean z) {
        this.lcS = z;
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
        if (x.getCount(list) > 0 && tbPageContext != null) {
            this.lcT = tbPageContext;
            int count = x.getCount(this.fUL);
            int count2 = x.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) x.getItem(this.fUL, 0);
                    if (viewHolder != null) {
                        this.fUK.removeView(viewHolder.getView());
                    }
                    this.fUL.remove(viewHolder);
                }
            }
            int i2 = 0;
            while (i2 < count2) {
                HorRankCard.a aVar = (HorRankCard.a) x.getItem(list, i2);
                ItemViewHolder itemViewHolder = (ItemViewHolder) x.getItem(this.fUL, i2);
                if (itemViewHolder != null) {
                    a(itemViewHolder.getView(), aVar, i2, i2 == count2 + (-1));
                } else {
                    View createView = createView();
                    if (createView != null) {
                        ItemViewHolder itemViewHolder2 = new ItemViewHolder(createView);
                        this.fUL.add(itemViewHolder2);
                        a(itemViewHolder2.getView(), aVar, i2, i2 == count2 + (-1));
                        this.fUK.addView(createView);
                    }
                }
                i2++;
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private View createView() {
        return View.inflate(this.lcT.getPageActivity(), R.layout.card_horizontal_rank_list_item, null);
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
            if (this.lcS) {
                itemViewHolder.ldb.setIsRound(true);
                itemViewHolder.lde.setVisibility(8);
                if (aVar.rank <= 0) {
                    itemViewHolder.lcX.setVisibility(8);
                    itemViewHolder.lcY.setVisibility(8);
                } else {
                    switch (aVar.rank) {
                        case 1:
                            itemViewHolder.lcX.setVisibility(0);
                            ao.setImageResource(itemViewHolder.lcX, R.drawable.icon_grade_star_no1);
                            itemViewHolder.lcY.setVisibility(8);
                            break;
                        case 2:
                            itemViewHolder.lcX.setVisibility(0);
                            ao.setImageResource(itemViewHolder.lcX, R.drawable.icon_grade_star_no2);
                            itemViewHolder.lcY.setVisibility(8);
                            break;
                        case 3:
                            itemViewHolder.lcX.setVisibility(0);
                            ao.setImageResource(itemViewHolder.lcX, R.drawable.icon_grade_star_no3);
                            itemViewHolder.lcY.setVisibility(8);
                            break;
                        default:
                            itemViewHolder.lcY.setVisibility(0);
                            itemViewHolder.lcZ.getDrawable().setColorFilter(ao.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                            itemViewHolder.lcX.setVisibility(8);
                            ao.setViewTextColor(itemViewHolder.lda, R.color.CAM_X0111);
                            itemViewHolder.lda.setText("" + (i + 1));
                            break;
                    }
                }
            } else {
                itemViewHolder.ldb.setIsRound(false);
                ao.setViewTextColor(itemViewHolder.lde, R.color.CAM_X0111);
                itemViewHolder.lcX.setVisibility(8);
                itemViewHolder.lcY.setVisibility(8);
                if (aVar.rank <= 0) {
                    itemViewHolder.lde.setVisibility(8);
                } else {
                    itemViewHolder.lde.setVisibility(0);
                    itemViewHolder.lde.setText(String.valueOf(aVar.rank));
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        if (!com.baidu.tieba.lego.card.c.b.Fh(aVar.bgColorNight)) {
                            itemViewHolder.lde.setBackgroundColor(aVar.bgColorNight);
                        } else {
                            ao.setBackgroundColor(itemViewHolder.lde, com.baidu.tieba.lego.a.kVU[i <= 3 ? i : 3]);
                        }
                    } else if (!com.baidu.tieba.lego.card.c.b.Fh(aVar.bgColor)) {
                        itemViewHolder.lde.setBackgroundColor(aVar.bgColor);
                    } else {
                        ao.setBackgroundColor(itemViewHolder.lde, com.baidu.tieba.lego.a.kVU[i <= 3 ? i : 3]);
                    }
                }
                itemViewHolder.ldb.setRadius(0);
            }
            if (!TextUtils.isEmpty(aVar.kYn)) {
                itemViewHolder.ldb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!TextUtils.isEmpty(aVar.kYn)) {
                            s.cvb().mG(true);
                            i.a((BaseLegoCardInfo) aVar.kYo).fG(TiebaInitialize.Params.OBJ_URL, aVar.kYn).a(aVar.kYo);
                            v.h(HorizontalScrollListView.this.lcT, aVar.kYn);
                        }
                    }
                });
            } else {
                itemViewHolder.ldb.setOnClickListener(null);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.ldb.getLayoutParams();
            layoutParams.width = this.width;
            layoutParams.height = this.height;
            b(layoutParams, i);
            if (this.lcS) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
            } else {
                layoutParams.topMargin = 0;
            }
            itemViewHolder.ldb.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.lde.getLayoutParams();
            b(layoutParams2, i);
            itemViewHolder.lde.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.lcW.getLayoutParams();
            layoutParams3.width = this.width;
            b(layoutParams3, i);
            itemViewHolder.lcW.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.ldd.getLayoutParams();
            layoutParams4.width = this.width;
            b(layoutParams4, i);
            itemViewHolder.ldd.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.ldf.getLayoutParams();
            layoutParams5.width = this.width;
            b(layoutParams5, i);
            itemViewHolder.ldf.setLayoutParams(layoutParams5);
            itemViewHolder.ldb.setTag(aVar.picUrl);
            itemViewHolder.ldb.startLoad(aVar.picUrl, 10, false);
            if (!TextUtils.isEmpty(aVar.kYm)) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.ldc.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.ds30);
                int dimens2 = l.getDimens(getContext(), R.dimen.ds6);
                int dimens3 = l.getDimens(getContext(), R.dimen.ds18);
                int i2 = ((this.width - dimens) + this.margin) - dimens2;
                if (i == 0) {
                    i2 = (i2 - dimens3) + dimens2;
                }
                layoutParams6.setMargins(i2, (this.height - dimens) + dimens2, 0, 0);
                itemViewHolder.ldc.setLayoutParams(layoutParams6);
                itemViewHolder.ldc.startLoad(aVar.kYm, 10, false);
            } else {
                itemViewHolder.ldc.setVisibility(8);
            }
            if (aVar.title != null) {
                itemViewHolder.fUZ.setVisibility(0);
                if (this.lcS) {
                    if (aVar.rank <= 0) {
                        itemViewHolder.fUZ.setMaxWidth(this.width);
                    } else {
                        itemViewHolder.fUZ.setMaxWidth((this.width - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                    }
                } else {
                    itemViewHolder.fUZ.setMaxWidth(this.width);
                }
                itemViewHolder.fUZ.setText(aVar.title);
            } else {
                itemViewHolder.fUZ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.subTitle)) {
                try {
                    itemViewHolder.mSubtitleTextView.setText(at.numberUniformFormat(Long.parseLong(aVar.subTitle)).toLowerCase());
                } catch (Exception e) {
                    itemViewHolder.mSubtitleTextView.setText(aVar.subTitle);
                }
                ao.setViewTextColor(itemViewHolder.mSubtitleTextView, R.color.CAM_X0312);
                itemViewHolder.mSubtitleTextView.setVisibility(0);
            } else {
                itemViewHolder.mSubtitleTextView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.postUrl) && !TextUtils.isEmpty(aVar.btnText) && !TextUtils.isEmpty(aVar.btnDone)) {
                itemViewHolder.ldf.setVisibility(0);
                a(itemViewHolder.ldg, aVar.isDone, aVar.btnText, aVar.btnDone);
                itemViewHolder.ldg.setTag(aVar.postUrl);
                itemViewHolder.ldg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.view.HorizontalScrollListView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (bg.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                            com.baidu.tieba.lego.a.b.dde().a(aVar, aVar.postUrl, null, null);
                        }
                    }
                });
                return;
            }
            itemViewHolder.ldf.setVisibility(8);
        }
    }

    private void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ao.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ao.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        ao.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<ItemViewHolder> it = this.fUL.iterator();
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
            ao.setViewTextColor(itemViewHolder.fUZ, R.color.CAM_X0108, 1);
        }
    }

    /* loaded from: classes9.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public TextView fUZ;
        public LinearLayout lcW;
        public ImageView lcX;
        public FrameLayout lcY;
        public ImageView lcZ;
        public TextView lda;
        public HeadImageView ldb;
        public TbImageView ldc;
        public LinearLayout ldd;
        public TextView lde;
        public LinearLayout ldf;
        public TextView ldg;
        public TextView mSubtitleTextView;

        public ItemViewHolder(View view) {
            super(view);
            this.lcX = null;
            this.lcY = null;
            this.lcZ = null;
            this.lda = null;
            this.ldb = null;
            this.ldc = null;
            this.fUZ = null;
            this.ldd = null;
            this.mSubtitleTextView = null;
            this.lde = null;
            this.ldf = null;
            this.ldg = null;
            this.lcW = (LinearLayout) view.findViewById(R.id.ll_name);
            this.lcY = (FrameLayout) view.findViewById(R.id.fl_left);
            this.lcZ = (ImageView) view.findViewById(R.id.leftBack);
            this.lcX = (ImageView) view.findViewById(R.id.leftIcon);
            this.lda = (TextView) view.findViewById(R.id.leftText);
            this.ldb = (HeadImageView) view.findViewById(R.id.head);
            this.ldb.setGifIconSupport(false);
            this.ldc = (TbImageView) view.findViewById(R.id.head_icon);
            this.fUZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.ldd = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.mSubtitleTextView = (TextView) view.findViewById(R.id.subtitle);
            this.lde = (TextView) view.findViewById(R.id.leftTopText);
            this.ldf = (LinearLayout) view.findViewById(R.id.ll_post);
            this.ldg = (TextView) view.findViewById(R.id.btn_post);
        }
    }
}
