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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
/* loaded from: classes9.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    private TbImageView gFx;
    private TextView iCm;
    private LinearLayout kZU;
    private ViewGroup ldY;
    private LineCountNotifyTextView ldZ;
    private TextView lea;
    private LinearLayout leb;
    private TbImageView lec;
    private TextView led;
    private TbImageView lee;
    private TextView lef;
    private int leg;
    private int leh;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.leg = 0;
        this.leh = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.ldY = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
        this.gFx = (TbImageView) z(this.ldY, R.id.img);
        this.ldZ = (LineCountNotifyTextView) z(this.ldY, R.id.one_title);
        this.lea = (TextView) z(this.ldY, R.id.discription);
        View view = (View) z(this.ldY, R.id.hot_thread_comment);
        this.iCm = (TextView) z(view, R.id.hot_thread_line_tag);
        this.leb = (LinearLayout) z(view, R.id.ll_left);
        this.lec = (TbImageView) z(view, R.id.iconLeft);
        this.led = (TextView) z(view, R.id.textLeft);
        this.kZU = (LinearLayout) z(view, R.id.ll_right);
        this.lee = (TbImageView) z(view, R.id.iconRight);
        this.lef = (TextView) z(view, R.id.textRight);
        return this.ldY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.ldY, R.drawable.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        ap.setViewTextColor(this.iCm, R.color.CAM_X0111);
        ap.setViewTextColor(this.led, R.color.CAM_X0110);
        ap.setViewTextColor(this.lef, R.color.CAM_X0110);
        if (this.leg != 0 && this.ldZ != null) {
            ap.setViewTextColor(this.ldZ, this.leg, 1);
        }
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.iCm != null) {
            if (onePicInfoCard != null && !com.baidu.tieba.lego.card.c.b.DT(onePicInfoCard.gettBgColor()) && !com.baidu.tieba.lego.card.c.b.DT(onePicInfoCard.gettBgColorN())) {
                this.iCm.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
            } else {
                ap.setBackgroundResource(this.iCm, R.drawable.label_bg_tie_n);
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
        this.gFx.startLoad(str, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.ldZ.setText(onePicInfoCard.getCardTitle());
            this.ldZ.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void bGb() {
                    int lineCount = OnePicInfoCardView.this.ldZ.getLineCount();
                    if (OnePicInfoCardView.this.leh != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.lea.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.lea.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.leh = lineCount;
                    OnePicInfoCardView.this.lea.setText(onePicInfoCard.getDesc());
                }
            });
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.iCm.setVisibility(8);
        } else {
            this.iCm.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.iCm.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.leb.setVisibility(8);
            this.kZU.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.leb.setVisibility(0);
                a(this.led, this.lec, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.kZU.setVisibility(0);
                a(this.lef, this.lee, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.leb.setVisibility(8);
            this.kZU.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.TA(String.valueOf(onePicInfoCard.getItemId()))) {
            this.leg = R.color.CAM_X0108;
        } else {
            this.leg = R.color.CAM_X0105;
        }
        ap.setViewTextColor(this.ldZ, this.leg, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.c((OnePicInfoCardView) onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.lbN : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(com.baidu.tieba.lego.card.f.oA(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        try {
            textView.setText(au.numberUniformFormat(Long.parseLong(bVar.content)));
        } catch (NumberFormatException e) {
            textView.setText(bVar.content);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(OnePicInfoCard onePicInfoCard) {
        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) onePicInfoCard).fF(TiebaInitialize.Params.OBJ_URL, onePicInfoCard.getScheme()).bA("obj_locate", getStatPosition()).a(onePicInfoCard);
        super.e(onePicInfoCard);
    }
}
