package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
/* loaded from: classes8.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    private TbImageView gCN;
    private TextView iwC;
    private LinearLayout kRS;
    private ViewGroup kVV;
    private LineCountNotifyTextView kVW;
    private TextView kVX;
    private LinearLayout kVY;
    private TbImageView kVZ;
    private TextView kWa;
    private TbImageView kWb;
    private TextView kWc;
    private int kWd;
    private int kWe;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kWd = 0;
        this.kWe = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.kVV = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
        this.gCN = (TbImageView) z(this.kVV, R.id.img);
        this.kVW = (LineCountNotifyTextView) z(this.kVV, R.id.one_title);
        this.kVX = (TextView) z(this.kVV, R.id.discription);
        View view = (View) z(this.kVV, R.id.hot_thread_comment);
        this.iwC = (TextView) z(view, R.id.hot_thread_line_tag);
        this.kVY = (LinearLayout) z(view, R.id.ll_left);
        this.kVZ = (TbImageView) z(view, R.id.iconLeft);
        this.kWa = (TextView) z(view, R.id.textLeft);
        this.kRS = (LinearLayout) z(view, R.id.ll_right);
        this.kWb = (TbImageView) z(view, R.id.iconRight);
        this.kWc = (TextView) z(view, R.id.textRight);
        return this.kVV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        ao.setBackgroundResource(this.kVV, R.drawable.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        ao.setViewTextColor(this.iwC, R.color.CAM_X0111);
        ao.setViewTextColor(this.kWa, R.color.CAM_X0110);
        ao.setViewTextColor(this.kWc, R.color.CAM_X0110);
        if (this.kWd != 0 && this.kVW != null) {
            ao.setViewTextColor(this.kVW, this.kWd, 1);
        }
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.iwC != null) {
            if (onePicInfoCard != null && !com.baidu.tieba.lego.card.c.b.DB(onePicInfoCard.gettBgColor()) && !com.baidu.tieba.lego.card.c.b.DB(onePicInfoCard.gettBgColorN())) {
                this.iwC.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
            } else {
                ao.setBackgroundResource(this.iwC, R.drawable.label_bg_tie_n);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final OnePicInfoCard onePicInfoCard) {
        String str = null;
        if (!TextUtils.isEmpty(onePicInfoCard.getPic())) {
            str = onePicInfoCard.getPic();
        }
        this.gCN.startLoad(str, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.kVW.setText(onePicInfoCard.getCardTitle());
            this.kVW.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void bFH() {
                    int lineCount = OnePicInfoCardView.this.kVW.getLineCount();
                    if (OnePicInfoCardView.this.kWe != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.kVX.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.kVX.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.kWe = lineCount;
                    OnePicInfoCardView.this.kVX.setText(onePicInfoCard.getDesc());
                }
            });
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.iwC.setVisibility(8);
        } else {
            this.iwC.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.iwC.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.kVY.setVisibility(8);
            this.kRS.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.kVY.setVisibility(0);
                a(this.kWa, this.kVZ, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.kRS.setVisibility(0);
                a(this.kWc, this.kWb, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.kVY.setVisibility(8);
            this.kRS.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.SC(String.valueOf(onePicInfoCard.getItemId()))) {
            this.kWd = R.color.CAM_X0108;
        } else {
            this.kWd = R.color.CAM_X0105;
        }
        ao.setViewTextColor(this.kVW, this.kWd, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.c((OnePicInfoCardView) onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.kTK : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(com.baidu.tieba.lego.card.f.ov(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        try {
            textView.setText(at.numberUniformFormat(Long.parseLong(bVar.content)));
        } catch (NumberFormatException e) {
            textView.setText(bVar.content);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(OnePicInfoCard onePicInfoCard) {
        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) onePicInfoCard).fF(TiebaInitialize.Params.OBJ_URL, onePicInfoCard.getScheme()).bz("obj_locate", getStatPosition()).a(onePicInfoCard);
        super.e(onePicInfoCard);
    }
}
