package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.FeedBackLayout;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes8.dex */
public class NHFooterView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MARGIN_BOTTOM = 35;
    public static int MARGIN_TOP = 25;
    public transient /* synthetic */ FieldHolder $fh;
    public FeedBackLayout mFeedBackLayout;
    public HomeCfgResponse.FooterConfig mFooterData;
    public NetImageView mPicture;
    public View mSeperator;
    public View mSeperatorB;
    public HomeCfgResponse.TitleConfig mTitleData;
    public b mWalletHomeInterface;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1403430681, "Lcom/baidu/wallet/home/ui/widget/newhome/NHFooterView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1403430681, "Lcom/baidu/wallet/home/ui/widget/newhome/NHFooterView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHFooterView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initView();
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            this.mSeperatorB = new View(getContext());
            addView(this.mSeperatorB, new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), MARGIN_BOTTOM)));
        }
    }

    public void setData(HomeCfgResponse homeCfgResponse, b bVar, int i2) {
        HomeCfgResponse.FooterItemDate[] footerItemDateArr;
        HomeCfgResponse.TitleItem[] titleItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, homeCfgResponse, bVar, i2) == null) {
            setBackgroundColor(ResUtils.getColor(getContext(), "5".equals(homeCfgResponse.version) ? "wallet_home_nh_whiteColor_bg" : "wallet_extend_home_nh_separate_bright"));
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
                this.mSeperator.setVisibility(0);
                this.mSeperatorB.setVisibility(0);
                this.mPicture.setVisibility(0);
                NetImageView netImageView = this.mPicture;
                netImageView.setImageUrl(this.mWalletHomeInterface.getAndroidPrefix() + this.mFooterData.data[0].footer_slogan);
                if (!TextUtils.isEmpty(this.mFooterData.data[0].footer_link_addr)) {
                    this.mPicture.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHFooterView.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NHFooterView f61628a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61628a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                NHFooterView nHFooterView = this.f61628a;
                                b bVar2 = nHFooterView.mWalletHomeInterface;
                                HomeCfgResponse.FooterItemDate[] footerItemDateArr2 = nHFooterView.mFooterData.data;
                                bVar2.jump(footerItemDateArr2[0].footer_desc, footerItemDateArr2[0].footer_type, footerItemDateArr2[0].footer_link_addr, false);
                            }
                        }
                    });
                }
            } else {
                this.mSeperator.setVisibility(8);
                this.mSeperatorB.setVisibility(8);
                this.mPicture.setVisibility(8);
            }
            int dip2px = DisplayUtils.dip2px(getContext(), MARGIN_TOP);
            int dip2px2 = ((i2 - dip2px) - DisplayUtils.dip2px(getContext(), MARGIN_BOTTOM)) - ((DisplayUtils.getDisplayWidth(getContext()) * 160) / 750);
            if (dip2px2 > 0) {
                this.mSeperator.setLayoutParams(new LinearLayout.LayoutParams(-1, dip2px2 + dip2px));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        initView();
    }
}
