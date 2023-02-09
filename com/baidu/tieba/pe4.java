package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pe4 extends qe4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pe4(@NonNull Context context) {
        super("GaodeMap", context.getString(R.string.obfuscated_res_0x7f0f0dcb), "com.autonavi.minimap");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.qe4
    public void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048576, this, context, latLng, latLng2, str, str2) == null) && latLng != null && latLng2 != null) {
            Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
            buildUpon.appendQueryParameter("sourceApplication", context.getPackageName());
            buildUpon.appendQueryParameter("slat", String.valueOf(latLng.latitude));
            buildUpon.appendQueryParameter("slon", String.valueOf(latLng.longitude));
            buildUpon.appendQueryParameter("sname", str);
            buildUpon.appendQueryParameter("dlat", String.valueOf(latLng2.latitude));
            buildUpon.appendQueryParameter("dlon", String.valueOf(latLng2.longitude));
            buildUpon.appendQueryParameter("dname", str2);
            buildUpon.appendQueryParameter(BdZeusUtil.URL_KEY_MACHINE, "0");
            buildUpon.appendQueryParameter("t", "0");
            Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            intent.setPackage("com.autonavi.minimap");
            context.startActivity(intent);
        }
    }
}
