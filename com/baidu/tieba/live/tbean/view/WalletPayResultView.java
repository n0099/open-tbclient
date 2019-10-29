package com.baidu.tieba.live.tbean.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.VCenterTextSpan;
import com.baidu.tieba.live.tbean.BuyTBeanStringUlti;
import com.baidu.tieba.live.tbean.data.CustomData;
/* loaded from: classes6.dex */
public class WalletPayResultView extends LinearLayout {
    private Context mContext;
    private TextView mIconInfoTv;
    private TbImageView mIconIv;
    private TextView mLookRecordToastTv;
    private TextView mPayFailRebuyBtn;
    private ImageView mPayResultIcon;
    private TextView mPayResultInfo;
    private TextView mPayResultSubInfo;
    private TextView mPayResultSubInfoHelp;
    private String mPropsMon;
    private View mRoot;

    public WalletPayResultView(Context context) {
        super(context);
        initUI(context);
    }

    public WalletPayResultView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public WalletPayResultView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(a.h.sdk_tbn_buy_tbean_result_view, (ViewGroup) this, true);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.mPayFailRebuyBtn = (TextView) findViewById(a.g.pay_fail_rebuy_btn);
        this.mPayResultSubInfo = (TextView) findViewById(a.g.pay_result_sub_info);
        this.mPayResultSubInfoHelp = (TextView) findViewById(a.g.pay_result_sub_info_help);
        this.mPayResultInfo = (TextView) findViewById(a.g.pay_result_info);
        this.mPayResultIcon = (ImageView) findViewById(a.g.pay_result_icon);
        this.mLookRecordToastTv = (TextView) findViewById(a.g.look_record_toast_tv);
        this.mIconIv = (TbImageView) findViewById(a.g.icon_iv);
        this.mIconInfoTv = (TextView) findViewById(a.g.icon_info_tv);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mPayFailRebuyBtn.setOnClickListener(onClickListener);
        }
    }

    public void updateResult(boolean z, int i, CustomData customData) {
        this.mPayFailRebuyBtn.setTag(Boolean.valueOf(z));
        if (z) {
            this.mPayResultIcon.setImageResource(a.f.sdk_tbn_icon_send_ok);
            this.mPayResultInfo.setText(a.i.sdk_tbn_buy_result_success);
            this.mPayResultSubInfo.setText(buildTBeanText(i));
            this.mPayResultSubInfoHelp.setVisibility(8);
            this.mPayFailRebuyBtn.setText(a.i.sdk_tbn_pay_finish);
            this.mLookRecordToastTv.setVisibility(0);
            if (customData != null && !StringUtils.isNull(customData.pic_url) && !StringUtils.isNull(customData.name)) {
                this.mIconIv.startLoad(customData.pic_url, 10, false);
                this.mIconInfoTv.setText(this.mContext.getString(a.i.sdk_tbn_icon_name_valid_day, customData.name, Integer.valueOf(customData.duration)));
                this.mIconIv.setVisibility(0);
                this.mIconInfoTv.setVisibility(0);
                return;
            }
            this.mIconIv.setVisibility(8);
            this.mIconInfoTv.setVisibility(8);
            return;
        }
        this.mPayResultIcon.setImageResource(a.f.sdk_tbn_icon_send_error);
        this.mPayResultInfo.setText(a.i.sdk_tbn_buy_result_fail);
        this.mPayResultSubInfoHelp.setText(a.i.sdk_tbn_buy_result_sub_info_help_hint);
        this.mPayResultSubInfoHelp.setVisibility(0);
        this.mPayResultSubInfo.setText(a.i.sdk_tbn_buy_result_sub_info_help_account);
        this.mPayFailRebuyBtn.setText(a.i.sdk_tbn_pay_retry);
        this.mLookRecordToastTv.setVisibility(8);
        this.mIconIv.setVisibility(8);
        this.mIconInfoTv.setVisibility(8);
    }

    private SpannableString buildTBeanText(int i) {
        String formatTBeanNum = BuyTBeanStringUlti.formatTBeanNum(i);
        String str = this.mContext.getString(a.i.sdk_tbn_tbean_get) + "[image]" + formatTBeanNum;
        Bitmap bitmap = SkinManager.getBitmap(a.f.sdk_icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(bitmapDrawable);
        vCenterTextSpan.setPaddingLeft(BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds4));
        vCenterTextSpan.setPaddingRight(BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds4));
        SpannableString spannableString = new SpannableString(str);
        BuyTBeanStringUlti.setSpan(spannableString, str, formatTBeanNum, new ForegroundColorSpan(SkinManager.getColor(a.d.sdk_cp_link_tip_d)));
        BuyTBeanStringUlti.setSpan(spannableString, str, "[image]", vCenterTextSpan);
        return spannableString;
    }
}
