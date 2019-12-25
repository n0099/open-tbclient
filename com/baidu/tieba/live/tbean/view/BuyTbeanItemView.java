package com.baidu.tieba.live.tbean.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.VCenterTextSpan;
import com.baidu.live.tieba.b.a;
import com.baidu.tieba.live.tbean.TBeanUtil;
import com.baidu.tieba.live.tbean.data.IconInfoData;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
/* loaded from: classes2.dex */
public class BuyTbeanItemView extends a<IconInfoWrapperData> {
    private boolean mIsFromAlaLiveRoom;
    private TbImageView mIvIcon;
    private TbPageContext mPageContext;
    private View mRoot;
    private TextView mTvIconInfo;
    private TextView mTvLable;
    private TextView mTvMember;
    private TextView mTvMemberLead;
    private LinearLayout mTvMemberWrapper;
    private TextView mTvNum;
    private TextView mTvOriginPrice;
    private TextView mTvPrice;

    public BuyTbeanItemView(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mIsFromAlaLiveRoom = z;
        this.mRoot = getView();
        this.mTvNum = (TextView) this.mRoot.findViewById(a.g.tbean_num_tv);
        this.mTvMemberLead = (TextView) this.mRoot.findViewById(a.g.tbean_member_tv_lead);
        this.mTvMember = (TextView) this.mRoot.findViewById(a.g.tbean_member_tv);
        this.mTvMemberWrapper = (LinearLayout) getView().findViewById(a.g.tbean_member_wrapper);
        this.mIvIcon = (TbImageView) this.mRoot.findViewById(a.g.icon_iv);
        this.mTvIconInfo = (TextView) this.mRoot.findViewById(a.g.icon_info_tv);
        this.mTvOriginPrice = (TextView) this.mRoot.findViewById(a.g.tbean_origin_price_tv);
        this.mTvOriginPrice.getPaint().setFlags(21);
        this.mTvOriginPrice.setVisibility(8);
        this.mTvPrice = (TextView) this.mRoot.findViewById(a.g.tbean_price_tv);
        this.mTvLable = (TextView) this.mRoot.findViewById(a.g.tbean_label_tv);
        if (this.mIsFromAlaLiveRoom) {
            this.mRoot.setBackgroundColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_bg_ala));
            this.mTvNum.setTextColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_tbean_num_ala));
            this.mTvMemberLead.setTextColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_tbean_member_extra_ala));
            this.mTvMember.setTextColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_tbean_member_extra_ala));
            this.mTvIconInfo.setTextColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_tbean_icon_info_text_ala));
            this.mTvIconInfo.setBackgroundColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_tbean_icon_info_bg_ala));
            this.mTvPrice.setTextColor(this.mPageContext.getPageActivity().getColor(a.d.sdk_tbn_item_tbean_price_ala));
        }
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public int getYuanFromFen(int i) {
        return (int) (i / 100.0f);
    }

    private SpannableString buildMenberText(int i, int i2) {
        if (this.mPageContext == null) {
            return null;
        }
        String formatTBeanNum = TBeanUtil.formatTBeanNum(i2);
        String str = this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_super_mem_tbean_tip) + "[image]" + formatTBeanNum;
        SpannableString spannableString = new SpannableString(str);
        Bitmap bitmap = SkinManager.getBitmap(a.f.sdk_icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(bitmapDrawable);
        vCenterTextSpan.setPaddingLeft(BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), a.e.sdk_ds4));
        vCenterTextSpan.setPaddingRight(BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), a.e.sdk_ds4));
        TBeanUtil.setSpan(spannableString, str, "[image]", vCenterTextSpan);
        TBeanUtil.setSpan(spannableString, str, formatTBeanNum, new ForegroundColorSpan(SkinManager.getColor(a.d.sdk_cp_cont_b)));
        return spannableString;
    }

    private SpannableString buildPriceText(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        String valueOf = String.valueOf(i);
        String string = this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_pay_money, new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(string);
        TBeanUtil.setSpan(spannableString, string, "¥" + valueOf, new ForegroundColorSpan(SkinManager.getColor(a.d.sdk_cp_link_tip_d)));
        TBeanUtil.setSpan(spannableString, string, valueOf, new RelativeSizeSpan(1.3f));
        return spannableString;
    }

    private String buildPriceCommonText(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        return this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_pay_money, new Object[]{String.valueOf(i)});
    }

    private SpannableString buildTBeanText(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        String formatTBeanNum = TBeanUtil.formatTBeanNum(i);
        String str = this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_give_gift) + "[image]" + formatTBeanNum;
        Bitmap bitmap = SkinManager.getBitmap(a.f.sdk_icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(bitmapDrawable);
        vCenterTextSpan.setPaddingLeft(BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), a.e.sdk_ds4));
        vCenterTextSpan.setPaddingRight(BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), a.e.sdk_ds4));
        SpannableString spannableString = new SpannableString(str);
        TBeanUtil.setSpan(spannableString, str, formatTBeanNum, new ForegroundColorSpan(SkinManager.getColor(a.d.sdk_cp_link_tip_d)));
        TBeanUtil.setSpan(spannableString, str, "[image]", vCenterTextSpan);
        return spannableString;
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mIsFromAlaLiveRoom) {
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.sdk_tbn_buy_tbean_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    public void onBindDataToView(IconInfoWrapperData iconInfoWrapperData) {
        if (iconInfoWrapperData != null && iconInfoWrapperData.info != null && iconInfoWrapperData.userInfo != null) {
            IconInfoData iconInfoData = iconInfoWrapperData.info;
            UserInfoData userInfoData = iconInfoWrapperData.userInfo;
            if (iconInfoData.discount != null && !iconInfoData.discount.isEmpty()) {
                getView().setTag(iconInfoWrapperData.info);
                if (iconInfoWrapperData.mSetting != null) {
                    if (iconInfoWrapperData.mSetting.vip_extra_switch == 1 && iconInfoWrapperData.mSetting.vip_extra_percent > 0) {
                        this.mTvMember.setText(TBeanUtil.formatTBeanNum(TBeanUtil.getTBeanNum(iconInfoWrapperData.userInfo, iconInfoWrapperData.info.non_member_t, iconInfoWrapperData.mSetting) - iconInfoData.non_member_t));
                        this.mTvMemberWrapper.setVisibility(0);
                    } else {
                        this.mTvMemberWrapper.setVisibility(8);
                    }
                } else {
                    this.mTvMemberWrapper.setVisibility(8);
                }
                this.mTvNum.setText(StringHelper.formatTosepara(iconInfoData.non_member_t));
                this.mIvIcon.startLoad(iconInfoData.picUrl, 10, false);
                this.mTvIconInfo.setText(this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_icon_name_valid_day, new Object[]{iconInfoData.name, Integer.valueOf(iconInfoData.duration)}));
                this.mTvPrice.setText(buildPriceCommonText(getYuanFromFen(iconInfoData.dubi)));
                if (!StringUtils.isNull(iconInfoData.tag_name)) {
                    this.mTvLable.setVisibility(0);
                    this.mTvLable.setText(iconInfoData.tag_name);
                    return;
                }
                this.mTvLable.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
