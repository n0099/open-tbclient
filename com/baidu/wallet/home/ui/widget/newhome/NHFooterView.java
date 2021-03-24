package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.FeedBackLayout;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class NHFooterView extends LinearLayout {
    public static int MARGIN_TOP;
    public FeedBackLayout mFeedBackLayout;
    public HomeCfgResponse.FooterConfig mFooterData;
    public NetImageView mPicture;
    public View mSeperator;
    public HomeCfgResponse.TitleConfig mTitleData;
    public b mWalletHomeInterface;

    public NHFooterView(Context context) {
        super(context);
        initView();
    }

    public void initView() {
        removeAllViews();
        setBackgroundColor(ResUtils.getColor(getContext(), "wallet_extend_home_nh_separate_bright"));
        setOrientation(1);
        setGravity(1);
        this.mSeperator = new View(getContext());
        addView(this.mSeperator, new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), MARGIN_TOP)));
        this.mFeedBackLayout = new FeedBackLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mFeedBackLayout.setVisibility(8);
        addView(this.mFeedBackLayout, layoutParams);
        NetImageView netImageView = new NetImageView(getContext());
        this.mPicture = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (DisplayUtils.getDisplayWidth(getContext()) * 160) / 750);
        this.mPicture.setVisibility(8);
        addView(this.mPicture, layoutParams2);
    }

    public void setData(HomeCfgResponse homeCfgResponse, b bVar, int i) {
        HomeCfgResponse.FooterItemDate[] footerItemDateArr;
        HomeCfgResponse.TitleItem[] titleItemArr;
        setBackgroundColor(ResUtils.getColor(getContext(), "5".equals(homeCfgResponse.version) ? "wallet_home_nh_whiteColor" : "wallet_extend_home_nh_separate_bright"));
        this.mFooterData = homeCfgResponse.layout_footer;
        HomeCfgResponse.TitleConfig titleConfig = homeCfgResponse.layout_title;
        this.mTitleData = titleConfig;
        this.mWalletHomeInterface = bVar;
        if (bVar == null) {
            return;
        }
        if (titleConfig != null && (titleItemArr = titleConfig.data) != null && titleItemArr.length > 0 && titleItemArr[0].isFeedBackVisible()) {
            this.mFeedBackLayout.setVisibility(0);
            this.mFeedBackLayout.setData(this.mTitleData.data[0], this.mWalletHomeInterface);
        } else {
            this.mFeedBackLayout.setVisibility(8);
        }
        HomeCfgResponse.FooterConfig footerConfig = this.mFooterData;
        if (footerConfig != null && (footerItemDateArr = footerConfig.data) != null && footerItemDateArr.length > 0 && footerItemDateArr[0].isFooterVisible()) {
            this.mPicture.setVisibility(0);
            NetImageView netImageView = this.mPicture;
            netImageView.setImageUrl(this.mWalletHomeInterface.getAndroidPrefix() + this.mFooterData.data[0].footer_slogan);
            if (!TextUtils.isEmpty(this.mFooterData.data[0].footer_link_addr)) {
                this.mPicture.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHFooterView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        NHFooterView nHFooterView = NHFooterView.this;
                        b bVar2 = nHFooterView.mWalletHomeInterface;
                        HomeCfgResponse.FooterItemDate[] footerItemDateArr2 = nHFooterView.mFooterData.data;
                        bVar2.jump(footerItemDateArr2[0].footer_desc, footerItemDateArr2[0].footer_type, footerItemDateArr2[0].footer_link_addr, false);
                    }
                });
            }
        } else {
            this.mPicture.setVisibility(8);
        }
        int dip2px = DisplayUtils.dip2px(getContext(), MARGIN_TOP);
        int displayWidth = (i - dip2px) - ((DisplayUtils.getDisplayWidth(getContext()) * 160) / 750);
        if (displayWidth > 0) {
            this.mSeperator.setLayoutParams(new LinearLayout.LayoutParams(-1, displayWidth + dip2px));
        }
    }

    public NHFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
