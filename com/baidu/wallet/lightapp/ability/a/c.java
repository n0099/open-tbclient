package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityCallIDPhotoModel;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.ImageBase64Utils;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class c extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.lightapp.ability.a.c$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements IdCardDetectionController.IIdCardDetectionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ILightappInvokerCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f53348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f53349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f53350d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f53351e;

        public AnonymousClass1(c cVar, ILightappInvokerCallback iLightappInvokerCallback, int i2, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iLightappInvokerCallback, Integer.valueOf(i2), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53351e = cVar;
            this.a = iLightappInvokerCallback;
            this.f53348b = i2;
            this.f53349c = str;
            this.f53350d = context;
        }

        @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
        public void onDetectFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (i2 == -1) {
                    c cVar = this.f53351e;
                    cVar.a(this.a, this.f53349c, LightappConstants.ERRCODE_NO_PERMISSION, cVar.a(this.f53350d, "访问相机的权限"), "##callIDPotosFail");
                } else if (-2 == i2) {
                    this.f53351e.a(this.a, this.f53349c, LightappConstants.ERRCODE_CANCEL, "取消", "##callIDPotosFail");
                }
            }
        }

        @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
        public void onDetectOK(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                bundle.getInt(ShaderParams.VALUE_TYPE_STEP);
                String string = bundle.getString("pic1");
                String string2 = bundle.getString("pic2");
                NativeAbilityCallIDPhotoModel nativeAbilityCallIDPhotoModel = new NativeAbilityCallIDPhotoModel(0);
                ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                ImageBase64Utils.ImageBase64Listener imageBase64Listener = new ImageBase64Utils.ImageBase64Listener(this, nativeAbilityCallIDPhotoModel, string, string2, imageBase64Utils) { // from class: com.baidu.wallet.lightapp.ability.a.c.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NativeAbilityCallIDPhotoModel a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f53352b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f53353c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ ImageBase64Utils f53354d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f53355e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, nativeAbilityCallIDPhotoModel, string, string2, imageBase64Utils};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53355e = this;
                        this.a = nativeAbilityCallIDPhotoModel;
                        this.f53352b = string;
                        this.f53353c = string2;
                        this.f53354d = imageBase64Utils;
                    }

                    @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                    public void onBase64Result(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.a.cnt.front = str;
                            ImageBase64Utils.ImageBase64Listener imageBase64Listener2 = new ImageBase64Utils.ImageBase64Listener(this) { // from class: com.baidu.wallet.lightapp.ability.a.c.1.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ C19671 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                public void onBase64Result(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                        C19671 c19671 = this.a;
                                        NativeAbilityCallIDPhotoModel nativeAbilityCallIDPhotoModel2 = c19671.a;
                                        nativeAbilityCallIDPhotoModel2.cnt.back = str2;
                                        c19671.f53355e.a.onResult(0, nativeAbilityCallIDPhotoModel2.toJson());
                                        try {
                                            if (this.a.f53352b != null) {
                                                File file = new File(this.a.f53352b);
                                                if (file.exists()) {
                                                    file.delete();
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                        try {
                                            if (this.a.f53353c != null) {
                                                File file2 = new File(this.a.f53353c);
                                                if (file2.exists()) {
                                                    file2.delete();
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
                                        }
                                    }
                                }
                            };
                            ImageBase64Utils imageBase64Utils2 = this.f53354d;
                            String str2 = this.f53353c;
                            int i2 = this.f53355e.f53348b;
                            if (i2 <= 0) {
                                i2 = 40;
                            }
                            imageBase64Utils2.getImageBase64(str2, 640, i2, imageBase64Listener2);
                        }
                    }
                };
                int i2 = this.f53348b;
                if (i2 <= 0) {
                    i2 = 40;
                }
                imageBase64Utils.getImageBase64(string, 640, i2, imageBase64Listener);
            }
        }
    }

    public c() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LightappBusinessClient.METHOD_CALL_ID_PHOTOS : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    @Override // com.baidu.wallet.lightapp.ability.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) != null) {
            return;
        }
        LogUtil.d(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, str);
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        int a = a(str, "type");
        try {
            i2 = (int) (new JSONObject(str).optDouble("quality") * 100.0d);
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = -1;
        }
        int i4 = (i2 <= 0 || 40 < i2) ? -1 : i2;
        if (1 != a) {
            if (2 == a) {
                i3 = 3;
            } else if (3 == a) {
                i3 = 4;
            } else if (4 == a) {
                i3 = 5;
            } else if (5 == a) {
                i3 = 6;
            }
            if (i3 <= 0) {
                a(activity, i3, i4, iLightappInvokerCallback, str2, a(str, "showalbum") == 1);
                return;
            }
            a(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + i3, "#callIDPotosFail");
            return;
        }
        i3 = -1;
        if (i3 <= 0) {
        }
    }

    private void a(Context context, int i2, int i3, ILightappInvokerCallback iLightappInvokerCallback, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), iLightappInvokerCallback, str, Boolean.valueOf(z)}) == null) {
            IdCardDetectionController.getInstance().startIdcarddetect(context, i2, new AnonymousClass1(this, iLightappInvokerCallback, i3, str, context), z);
        }
    }
}
