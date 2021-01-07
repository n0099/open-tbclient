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
/* loaded from: classes9.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    private TbImageView gHt;
    private TextView iBj;
    private LinearLayout kWx;
    private ViewGroup laB;
    private LineCountNotifyTextView laC;
    private TextView laD;
    private LinearLayout laE;
    private TbImageView laF;
    private TextView laG;
    private TbImageView laH;
    private TextView laI;
    private int laJ;
    private int laK;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.laJ = 0;
        this.laK = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.laB = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
        this.gHt = (TbImageView) z(this.laB, R.id.img);
        this.laC = (LineCountNotifyTextView) z(this.laB, R.id.one_title);
        this.laD = (TextView) z(this.laB, R.id.discription);
        View view = (View) z(this.laB, R.id.hot_thread_comment);
        this.iBj = (TextView) z(view, R.id.hot_thread_line_tag);
        this.laE = (LinearLayout) z(view, R.id.ll_left);
        this.laF = (TbImageView) z(view, R.id.iconLeft);
        this.laG = (TextView) z(view, R.id.textLeft);
        this.kWx = (LinearLayout) z(view, R.id.ll_right);
        this.laH = (TbImageView) z(view, R.id.iconRight);
        this.laI = (TextView) z(view, R.id.textRight);
        return this.laB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
        ao.setBackgroundResource(this.laB, R.drawable.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        ao.setViewTextColor(this.iBj, R.color.CAM_X0111);
        ao.setViewTextColor(this.laG, R.color.CAM_X0110);
        ao.setViewTextColor(this.laI, R.color.CAM_X0110);
        if (this.laJ != 0 && this.laC != null) {
            ao.setViewTextColor(this.laC, this.laJ, 1);
        }
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.iBj != null) {
            if (onePicInfoCard != null && !com.baidu.tieba.lego.card.c.b.Fh(onePicInfoCard.gettBgColor()) && !com.baidu.tieba.lego.card.c.b.Fh(onePicInfoCard.gettBgColorN())) {
                this.iBj.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
            } else {
                ao.setBackgroundResource(this.iBj, R.drawable.label_bg_tie_n);
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
        this.gHt.startLoad(str, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.laC.setText(onePicInfoCard.getCardTitle());
            this.laC.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void bJz() {
                    int lineCount = OnePicInfoCardView.this.laC.getLineCount();
                    if (OnePicInfoCardView.this.laK != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.laD.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.laD.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.laK = lineCount;
                    OnePicInfoCardView.this.laD.setText(onePicInfoCard.getDesc());
                }
            });
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.iBj.setVisibility(8);
        } else {
            this.iBj.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.iBj.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.laE.setVisibility(8);
            this.kWx.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.laE.setVisibility(0);
                a(this.laG, this.laF, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.kWx.setVisibility(0);
                a(this.laI, this.laH, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.laE.setVisibility(8);
            this.kWx.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.TK(String.valueOf(onePicInfoCard.getItemId()))) {
            this.laJ = R.color.CAM_X0108;
        } else {
            this.laJ = R.color.CAM_X0105;
        }
        ao.setViewTextColor(this.laC, this.laJ, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.c((OnePicInfoCardView) onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.kYp : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(com.baidu.tieba.lego.card.f.qc(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
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
        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) onePicInfoCard).fG(TiebaInitialize.Params.OBJ_URL, onePicInfoCard.getScheme()).bz("obj_locate", getStatPosition()).a(onePicInfoCard);
        super.e(onePicInfoCard);
    }
}
