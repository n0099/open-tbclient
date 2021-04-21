package com.baidu.wallet.fastpay.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter;
import com.baidu.wallet.base.widget.compromtion.CommonPromotionView;
import com.baidu.wallet.fastpay.datamodel.PromotionInfoResponse;
import com.baidu.wallet.fastpay.ui.widget.FastPayPromotionView;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a extends BasePromotionAdapter {

    /* renamed from: a  reason: collision with root package name */
    public PromotionInfoResponse f24141a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24142b;

    public a(Context context, PromotionInfoResponse promotionInfoResponse) {
        this.f24141a = promotionInfoResponse;
        this.f24142b = context;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public CommonPromotionView createAdapterView(Context context) {
        PromotionInfoResponse promotionInfoResponse = this.f24141a;
        if (promotionInfoResponse == null) {
            return null;
        }
        int i = promotionInfoResponse.promotion_type;
        if (i == 1) {
            CommonPromotionView commonPromotionView = new CommonPromotionView(context);
            commonPromotionView.setCenText(getCenText()).setCenTextColor(ResUtils.getColor(this.f24142b, "wallet_fp_promtion_text"));
            return commonPromotionView;
        } else if (i == 2) {
            CommonPromotionView commonPromotionView2 = new CommonPromotionView(context);
            commonPromotionView2.setCenText(getCenText()).setTextClickListener(getClickListener()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl());
            PromotionInfoResponse promotionInfoResponse2 = this.f24141a;
            if (promotionInfoResponse2.link_type == 0 || TextUtils.isEmpty(promotionInfoResponse2.promotion_detail_url)) {
                return commonPromotionView2;
            }
            commonPromotionView2.setDefRightDrawable(getDefRightDraw());
            return commonPromotionView2;
        } else if (i == 3) {
            CommonPromotionView commonPromotionView3 = new CommonPromotionView(context);
            a();
            commonPromotionView3.setCenText(getCenText()).setTextClickListener(getClickListener()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl());
            PromotionInfoResponse promotionInfoResponse3 = this.f24141a;
            if (promotionInfoResponse3.link_type == 0 || TextUtils.isEmpty(promotionInfoResponse3.promotion_detail_url)) {
                return commonPromotionView3;
            }
            commonPromotionView3.setDefRightDrawable(getDefRightDraw());
            return commonPromotionView3;
        } else if (i != 4) {
            return null;
        } else {
            FastPayPromotionView fastPayPromotionView = new FastPayPromotionView(context);
            fastPayPromotionView.setCenText(getCenText()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl()).setClickRightImgToClose();
            PromotionInfoResponse promotionInfoResponse4 = this.f24141a;
            if (promotionInfoResponse4.link_type == 0 || TextUtils.isEmpty(promotionInfoResponse4.promotion_detail_url)) {
                return fastPayPromotionView;
            }
            fastPayPromotionView.setDefRightDrawable(getDefRightDraw());
            return fastPayPromotionView;
        }
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public int getBackGround() {
        return super.getBackGround();
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public CharSequence getCenText() {
        return this.f24141a.promotion_txt;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.wallet.fastpay.ui.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(a.this.f24141a.promotion_detail_url)) {
                    return;
                }
                DXMSdkSAUtils.onEventWithValues(com.baidu.wallet.fastpay.a.a.f24046g, Arrays.asList(a.this.f24141a.promotion_detail_url));
                PayStatisticsUtil.onEventWithValue(com.baidu.wallet.fastpay.a.a.f24046g, a.this.f24141a.promotion_detail_url);
                int i = a.this.f24141a.link_type;
                if (i == 1) {
                    BaiduWalletDelegate.getInstance().openH5Module(a.this.f24142b, a.this.f24141a.promotion_detail_url, true);
                } else if (i != 3) {
                } else {
                    BaiduWalletDelegate.getInstance().gotoWalletService(a.this.f24142b, a.this.f24141a.promotion_detail_url, "");
                }
            }
        };
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public Drawable getDefLeftDraw() {
        int i = this.f24141a.promotion_type;
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return null;
                }
                return ResUtils.getDrawable(this.f24142b, "wallet_fp_promotion_gift");
            }
            return ResUtils.getDrawable(this.f24142b, "wallet_fp_promotion_youhui");
        }
        return ResUtils.getDrawable(this.f24142b, "wallet_fp_promoiton_left");
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public Drawable getDefRightDraw() {
        if (this.f24141a.promotion_type != 4) {
            return ResUtils.getDrawable(this.f24142b, "wallet_fp_promotion_right");
        }
        return ResUtils.getDrawable(this.f24142b, "wallet_fp_promotion_close");
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public String getLeftUrl() {
        return this.f24141a.promotion_img_url;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public String getRightUrl() {
        return null;
    }

    private void a() {
        if (TextUtils.isEmpty(this.f24141a.promotion_txt)) {
            return;
        }
        Matcher matcher = Pattern.compile("[-+]?([0-9]*\\.[0-9]+|[0-9]+)").matcher(this.f24141a.promotion_txt);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group();
            String str = this.f24141a.promotion_txt;
            stringBuffer.append(str.substring(0, str.indexOf(group)));
            stringBuffer.append(String.format("<font color='#E85352'>%s</font>", group));
            PromotionInfoResponse promotionInfoResponse = this.f24141a;
            String str2 = promotionInfoResponse.promotion_txt;
            promotionInfoResponse.promotion_txt = str2.substring(str2.indexOf(group) + group.length());
        }
        PromotionInfoResponse promotionInfoResponse2 = this.f24141a;
        stringBuffer.append(promotionInfoResponse2.promotion_txt);
        promotionInfoResponse2.promotion_txt = stringBuffer.toString();
    }
}
