package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
/* loaded from: classes8.dex */
public class NHCreditItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int CREDIT_TAG_LENGTH = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskTextView mButton;
    public MaskTextView mDesc;
    public View mItemPress;
    public RelativeLayout mMainPanel;
    public MaskTextView mNoticeButton;
    public RelativeLayout mNoticePanel;
    public View mNoticePress;
    public MaskTextView mNoticeTitle;
    public NetImageView mPicture;
    public MaskTextView mTag;
    public MaskTextView mTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-10081843, "Lcom/baidu/wallet/home/ui/widget/newhome/NHCreditItem;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-10081843, "Lcom/baidu/wallet/home/ui/widget/newhome/NHCreditItem;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditItem(Context context) {
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_credit_item"), this);
            this.mPicture = (NetImageView) findViewById(ResUtils.id(getContext(), "credit_item_picture_panel"));
            this.mPicture.setLayoutParams(new LinearLayout.LayoutParams(-1, ((DisplayUtils.getDisplayWidth(getContext()) - DisplayUtils.dip2px(getContext(), 30.0f)) * 20) / 67));
            this.mMainPanel = (RelativeLayout) findViewById(ResUtils.id(getContext(), "credit_item_main_panel"));
            this.mTag = (MaskTextView) findViewById(ResUtils.id(getContext(), "credit_item_tag"));
            this.mDesc = (MaskTextView) findViewById(ResUtils.id(getContext(), "credit_item_desc"));
            this.mTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "credit_item_title"));
            this.mButton = (MaskTextView) findViewById(ResUtils.id(getContext(), "credit_item_button"));
            this.mNoticePanel = (RelativeLayout) findViewById(ResUtils.id(getContext(), "credit_item_notice_panel"));
            this.mNoticeTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "credit_item_notice_titile"));
            this.mNoticeButton = (MaskTextView) findViewById(ResUtils.id(getContext(), "credit_item_notice_button"));
            this.mItemPress = findViewById(ResUtils.id(getContext(), "credit_item_press"));
            this.mNoticePress = findViewById(ResUtils.id(getContext(), "credit_item_notice_press"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onEyeMaskChanged();
            this.mTag.resetMaskText();
            this.mDesc.resetMaskText();
            this.mTitle.resetMaskText();
            this.mButton.resetMaskText();
            this.mNoticeTitle.resetMaskText();
            this.mNoticeButton.resetMaskText();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getData() == null) {
            return;
        }
        if ("1".equals(getData().has_credit)) {
            if (getData().buttons != null && getData().buttons.length >= 1) {
                setOnClickListener(null);
                this.mPicture.setVisibility(8);
                this.mMainPanel.setVisibility(0);
                this.mTag.setMaskText(getData().key);
                this.mDesc.setMaskText(getData().name);
                this.mTitle.setTextSize(1, !TextUtils.isEmpty(getData().value1) && getData().value1.contains(PayTypeItemView.PayTypeItemViewData.MASK_FLAG) ? 24.0f : 17.0f);
                this.mTitle.setMaskText(getData().value1);
                if (!TextUtils.isEmpty(getData().getType()) && !TextUtils.isEmpty(getData().getLinkAddr())) {
                    this.mMainPanel.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHCreditItem.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NHCreditItem f61277a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61277a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61277a.getWalletInterface().jump(this.f61277a.getData().getName(), this.f61277a.getData().getType(), this.f61277a.getData().getLinkAddr(), this.f61277a.getData().getPrevlogin());
                            }
                        }
                    });
                } else {
                    this.mItemPress.setBackgroundDrawable(null);
                }
                HomeCfgResponse.DataButton dataButton = getData().buttons[0];
                if (dataButton != null && !TextUtils.isEmpty(dataButton.name)) {
                    this.mButton.setVisibility(0);
                    boolean equals = "2".equals(dataButton.btn_type);
                    this.mButton.setMaskText(dataButton.name);
                    this.mButton.setBackgroundDrawable(ResUtils.getDrawable(getContext(), new String[]{"wallet_home_credit_background", "wallet_home_credit_background_solid"}[equals ? 1 : 0]));
                    this.mButton.setTextColor(ResUtils.getColor(getContext(), new String[]{"wallet_home_nh_text7Color", "wallet_home_nh_whiteColor"}[equals ? 1 : 0]));
                    this.mButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHCreditItem.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NHCreditItem f61278a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61278a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61278a.getWalletInterface().jump(this.f61278a.getData().buttons[0].name, this.f61278a.getData().buttons[0].type, this.f61278a.getData().buttons[0].link_addr, this.f61278a.getData().getPrevlogin());
                            }
                        }
                    });
                } else {
                    this.mButton.setVisibility(8);
                }
                refreshNotice();
            } else {
                this.mPicture.setVisibility(8);
                this.mMainPanel.setVisibility(8);
                this.mNoticePanel.setVisibility(8);
                return;
            }
        } else {
            this.mPicture.setVisibility(0);
            this.mMainPanel.setVisibility(8);
            this.mNoticePanel.setVisibility(8);
            setNetImageViewUrl(this.mPicture, getData().logo);
        }
        handlePoint();
    }

    public void refreshNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!TextUtils.isEmpty(getData().notice)) {
                this.mNoticePanel.setVisibility(0);
                String[] strArr = {"wallet_home_credit_arrow_normal", "wallet_home_credit_arrow_highlight"};
                String[] strArr2 = {"wallet_home_nh_text7Color", "wallet_home_nh_text4Color"};
                boolean equals = "2".equals(getData().notice_style);
                this.mNoticePanel.setBackgroundColor(ResUtils.getColor(getContext(), new String[]{"wallet_home_nh_whiteColor", "wallet_home_nh_solid_highlight"}[equals ? 1 : 0]));
                this.mNoticeTitle.setMaskText(getData().notice);
                this.mNoticeTitle.setTextColor(ResUtils.getColor(getContext(), new String[]{"wallet_home_nh_text8Color", "wallet_home_nh_text4Color"}[equals ? 1 : 0]));
                Drawable drawable = ResUtils.getDrawable(getContext(), new String[]{"wallet_home_credit_notice_normal", "wallet_home_credit_notice_highlight"}[equals ? 1 : 0]);
                drawable.setBounds(0, 0, DisplayUtils.dip2px(getContext(), 13.0f), DisplayUtils.dip2px(getContext(), 13.0f));
                this.mNoticeTitle.setCompoundDrawables(drawable, null, null, null);
                this.mNoticeTitle.setCompoundDrawablePadding(DisplayUtils.dip2px(getContext(), 5.0f));
                if (getData().buttons == null || getData().buttons.length < 2) {
                    return;
                }
                if (!TextUtils.isEmpty(getData().buttons[1].name)) {
                    this.mNoticeButton.setMaskText(getData().buttons[1].name);
                    this.mNoticeButton.setTextColor(ResUtils.getColor(getContext(), strArr2[equals ? 1 : 0]));
                    Drawable drawable2 = ResUtils.getDrawable(getContext(), strArr[equals ? 1 : 0]);
                    drawable2.setBounds(0, 0, DisplayUtils.dip2px(getContext(), 7.5f), DisplayUtils.dip2px(getContext(), 13.0f));
                    this.mNoticeButton.setCompoundDrawables(null, null, drawable2, null);
                    this.mNoticeButton.setCompoundDrawablePadding(DisplayUtils.dip2px(getContext(), 5.0f));
                }
                if (!TextUtils.isEmpty(getData().buttons[1].type) && !TextUtils.isEmpty(getData().buttons[1].link_addr)) {
                    this.mNoticePanel.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHCreditItem.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NHCreditItem f61279a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61279a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61279a.getWalletInterface().jump(this.f61279a.getData().buttons[1].name, this.f61279a.getData().buttons[1].type, this.f61279a.getData().buttons[1].link_addr, this.f61279a.getData().getPrevlogin());
                            }
                        }
                    });
                    return;
                } else {
                    this.mNoticePress.setBackgroundDrawable(null);
                    return;
                }
            }
            this.mNoticePanel.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            initView();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHCreditItem(Context context, AttributeSet attributeSet) {
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
    }
}
