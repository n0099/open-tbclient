package com.baidu.wallet.bankdetection.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes10.dex */
public class a extends BaseBean<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f57290a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f57291b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f57292c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, byte[] bArr, byte[] bArr2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, bArr, bArr2};
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
        this.f57290a = str;
        this.f57291b = bArr;
        this.f57292c = bArr2;
    }

    private String a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bArr, str)) == null) {
            try {
                return Base64Utils.encodeToString(a(bArr, str.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            execBean(String.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String a2 = a(516);
            arrayList.add(new RestNameValuePair("ik", SecurePay.getInstance().encryptProxy(a2)));
            if (!TextUtils.isEmpty(this.f57290a)) {
                arrayList.add(new RestNameValuePair(AdvanceSetting.CLEAR_NOTIFICATION, SecurePay.getInstance().encryptProxy(this.f57290a)));
            }
            byte[] bArr = this.f57291b;
            if (bArr != null && bArr.length > 0) {
                arrayList.add(new RestNameValuePair("cni", a(bArr, a2)));
            }
            byte[] bArr2 = this.f57292c;
            if (bArr2 != null && bArr2.length > 0) {
                arrayList.add(new RestNameValuePair("ci", a(bArr2, a2)));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 517;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_BANKCARD_IMG;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BaseBean, com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    private byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null) {
                return null;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < i2 / 32; i3++) {
                stringBuffer.append(a());
            }
            return stringBuffer.toString();
        }
        return (String) invokeI.objValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? UUID.randomUUID().toString() : (String) invokeV.objValue;
    }
}
