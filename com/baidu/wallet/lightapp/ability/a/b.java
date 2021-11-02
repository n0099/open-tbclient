package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityTakePictureModel;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.ImageBase64Utils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LightappBusinessClient.METHOD_CALL_CAMERA : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            LogUtil.d(LightappBusinessClient.METHOD_CALL_CAMERA, str);
            int a2 = a(str, "type");
            if (1 == a2) {
                try {
                    i2 = (int) (new JSONObject(str).optDouble("quality") * 100.0d);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i2 = -1;
                }
                IdCardDetectionController.getInstance().startIdcarddetect(activity, 6, new IdCardDetectionController.IIdCardDetectionListener(this, iLightappInvokerCallback, (i2 <= 0 || 40 < i2) ? -1 : i2, activity, str2) { // from class: com.baidu.wallet.lightapp.ability.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f58594a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f58595b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Activity f58596c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f58597d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ b f58598e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, Integer.valueOf(r8), activity, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58598e = this;
                        this.f58594a = iLightappInvokerCallback;
                        this.f58595b = r8;
                        this.f58596c = activity;
                        this.f58597d = str2;
                    }

                    @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                    public void onDetectFailed(int i3, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str3) == null) {
                            if (i3 != -1) {
                                if (i3 == -2) {
                                    this.f58598e.a(this.f58594a, this.f58597d, LightappConstants.ERRCODE_CANCEL, "取消", "#callCameraFail");
                                    return;
                                }
                                return;
                            }
                            NativeAbilityTakePictureModel nativeAbilityTakePictureModel = new NativeAbilityTakePictureModel(1);
                            NativeAbilityTakePictureModel.Data data = nativeAbilityTakePictureModel.cnt;
                            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
                            data.des = PhoneUtils.getApplicationName(this.f58596c) + "没有访问相机的权限";
                            this.f58594a.onResult(1, nativeAbilityTakePictureModel.toJson());
                        }
                    }

                    @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                    public void onDetectOK(Bundle bundle) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                            if (bundle == null) {
                                ILightappInvokerCallback iLightappInvokerCallback2 = this.f58594a;
                                if (iLightappInvokerCallback2 != null) {
                                    iLightappInvokerCallback2.onResult(1, "internal error");
                                    return;
                                }
                                return;
                            }
                            String string = bundle.getString("pic1");
                            ImageBase64Utils.ImageBase64Listener imageBase64Listener = new ImageBase64Utils.ImageBase64Listener(this, new NativeAbilityTakePictureModel(0)) { // from class: com.baidu.wallet.lightapp.ability.a.b.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ NativeAbilityTakePictureModel f58599a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f58600b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f58600b = this;
                                    this.f58599a = r7;
                                }

                                @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                public void onBase64Result(String str3) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str3) == null) {
                                        NativeAbilityTakePictureModel nativeAbilityTakePictureModel = this.f58599a;
                                        nativeAbilityTakePictureModel.cnt.image = str3;
                                        this.f58600b.f58594a.onResult(0, nativeAbilityTakePictureModel.toJson());
                                    }
                                }
                            };
                            ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                            int i3 = this.f58595b;
                            if (i3 > 0) {
                                imageBase64Utils.getImageBase64(string, -1, i3, imageBase64Listener);
                            } else {
                                imageBase64Utils.getImageBase64(string, 640, 40, imageBase64Listener);
                            }
                        }
                    }
                }, false);
                return;
            }
            a(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + a2, "#callCameraFail");
        }
    }
}
