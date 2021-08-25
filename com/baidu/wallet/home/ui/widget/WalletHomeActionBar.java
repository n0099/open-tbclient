package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes8.dex */
public class WalletHomeActionBar extends BdActionBar implements com.baidu.wallet.home.ui.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61152a;

    /* renamed from: b  reason: collision with root package name */
    public c f61153b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f61154c;

    /* renamed from: d  reason: collision with root package name */
    public String f61155d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61156e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.wallet.home.ui.b.a f61157f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletHomeActionBar(Context context) {
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
        this.f61156e = "baiduapp".equals(BeanConstants.CHANNEL_ID);
        initHomeActionBar(context);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void hideRightZone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setRightImgZone2Visibility(8);
        }
    }

    public void initHomeActionBar(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f61157f = new com.baidu.wallet.home.ui.b.a(this);
            setLeftImgZone2NotifyTextColor(getResources().getColor(ResUtils.color(context, "wallet_base_whiteColor")));
            View rightZoneView = getRightZoneView();
            this.f61152a = rightZoneView;
            this.f61153b = new c(rightZoneView);
            this.f61154c = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_dot"));
            setSafeIconVisible(false);
            setRightImgZone2OnClickListener(new View.OnClickListener(this, context) { // from class: com.baidu.wallet.home.ui.widget.WalletHomeActionBar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f61158a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ WalletHomeActionBar f61159b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61159b = this;
                    this.f61158a = context;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f61159b.f61157f == null) {
                        return;
                    }
                    this.f61159b.f61157f.a(this.f61158a);
                }
            });
            setRightImgZone2Visibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshMenu(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, titleItemDataArr, str2) == null) {
            if (this.f61153b == null) {
                this.f61153b = new c(this.f61152a);
            }
            this.f61153b.a(str, titleItemDataArr, str2);
            this.f61153b.dismiss();
            this.f61153b.notifyMenuSetChanged();
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshRightZone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            setRightImgZone2Visibility(0);
            setRightImgZone2Src(str);
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshRightZoneDot(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f61154c.setVisibility(0);
                this.f61154c.setImageResource(ResUtils.drawable(getContext(), "wallet_home_red_star"));
                return;
            }
            this.f61154c.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshSafeTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            setTitleCenterSafeTipText(str);
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            setTitle(str);
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void showMenu() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (cVar = this.f61153b) == null) {
            return;
        }
        cVar.show();
    }

    public void toRefreshTitleBar(Context context, String str, HomeCfgResponse.TitleConfig titleConfig, String str2) {
        com.baidu.wallet.home.ui.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, context, str, titleConfig, str2) == null) || (aVar = this.f61157f) == null) {
            return;
        }
        this.f61155d = str2;
        aVar.a(context, str, titleConfig, str2);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshRightZone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (getRightImgZone2ImgView() instanceof NetImageView) {
                ((NetImageView) getRightImgZone2ImgView()).releaseRemoteDrawable();
            }
            setRightImgZone2Visibility(0);
            setRightImgZone2Src(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletHomeActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61156e = "baiduapp".equals(BeanConstants.CHANNEL_ID);
        initHomeActionBar(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletHomeActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f61156e = "baiduapp".equals(BeanConstants.CHANNEL_ID);
        initHomeActionBar(context);
    }
}
