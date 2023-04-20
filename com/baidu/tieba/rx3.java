package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rx3 extends qx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx3(Context context, AdElementInfo adElementInfo, rw3 rw3Var) {
        super(context, adElementInfo, rw3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, rw3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AdElementInfo) objArr2[1], (rw3) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = false;
    }

    @Override // com.baidu.tieba.qx3
    public void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, relativeLayout, adElementInfo) == null) {
            int videoWidth = adElementInfo.getVideoWidth();
            int videoHeight = adElementInfo.getVideoHeight();
            this.n = nw3.b().k();
            this.o = nw3.b().j();
            if (videoWidth < videoHeight) {
                this.G = true;
                int i = this.n;
                int i2 = (int) (((i - videoWidth) / 2) * 0.8d);
                int i3 = (int) (((i - videoWidth) / 2) * 0.1d);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
                layoutParams.leftMargin = (this.n - i2) - i3;
                layoutParams.addRule(15);
                layoutParams.removeRule(13);
                layoutParams.removeRule(12);
                layoutParams.bottomMargin = 0;
                relativeLayout.setLayoutParams(layoutParams);
                relativeLayout.setBackgroundColor(this.w.getColor(R.color.obfuscated_res_0x7f06076c));
            }
        }
    }

    @Override // com.baidu.tieba.qx3
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.G) {
                return "reward_banner_land_html";
            }
            return "reward_banner_html";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qx3
    @SuppressLint({"InflateParams"})
    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d06b0, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }
}
