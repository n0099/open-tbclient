package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.List;
/* loaded from: classes11.dex */
public class FeedBackLayout extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52581b;

    /* renamed from: c  reason: collision with root package name */
    public View f52582c;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.TitleItem f52583e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_feedback_layout"), this);
            this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_logo"));
            this.f52581b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_home_feedback"));
            View findViewById = findViewById(ResUtils.id(getContext(), "feedback_layout"));
            this.f52582c = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.home.ui.widget.FeedBackLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FeedBackLayout a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.getWalletInterface() == null) {
                        return;
                    }
                    this.a.getWalletInterface().jump(this.a.f52583e.fd_desc, this.a.f52583e.fd_type, this.a.f52583e.fd_link_addr, false);
                }
            });
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52583e != null : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.TitleItem titleItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (titleItem = this.f52583e) == null) {
            return;
        }
        if (!TextUtils.isEmpty(titleItem.fd_logo)) {
            NetImageView netImageView = this.a;
            netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.f52583e.fd_logo);
        }
        if (!this.f52583e.isFeedBackVisible()) {
            this.f52582c.setVisibility(8);
            return;
        }
        this.f52582c.setVisibility(0);
        this.f52581b.setVisibility(0);
        this.f52581b.setText(this.f52583e.fd_desc);
    }

    public void setData(HomeCfgResponse.TitleItem titleItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, titleItem, bVar) == null) {
            this.f52583e = titleItem;
            this.mWalletHomeInterface = bVar;
            if (isDataValid()) {
                initView();
                refreshData();
            }
        }
    }
}
