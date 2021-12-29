package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.permission.PermissionListener;
import com.baidu.wallet.core.permission.PermissionsUtil;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityContactSelectModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityContactSelectModelBase64;
import com.baidu.wallet.lightapp.ability.proxy.SelectAddressProxy;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.security.InvalidParameterException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class l extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f53383b;

    /* renamed from: c  reason: collision with root package name */
    public int f53384c;

    /* renamed from: d  reason: collision with root package name */
    public String f53385d;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f53383b = -1;
        this.f53384c = -1;
        this.f53385d = null;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "selectPhonefromAdressBook" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            try {
                try {
                    String optString = new JSONObject(str).optString("key", null);
                    this.f53385d = optString;
                    if (optString != null && optString.trim().length() == 0) {
                        throw new InvalidParameterException("加密密钥格式非法");
                    }
                    this.a = a(str, "type");
                    this.f53383b = a(str, "maxNum");
                    this.f53384c = a(str, "base64");
                    if (this.a != 1 && this.a != 2) {
                        throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                    }
                    if (PermissionManager.checkCallingPermission(activity, "android.permission.READ_CONTACTS")) {
                        a(activity, iLightappInvokerCallback);
                    } else {
                        BaiduWalletUtils.requestPermissionsDialog(null, activity, new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.ability.a.l.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Activity a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ ILightappInvokerCallback f53386b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f53387c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ l f53388d;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, activity, iLightappInvokerCallback, str2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f53388d = this;
                                this.a = activity;
                                this.f53386b = iLightappInvokerCallback;
                                this.f53387c = str2;
                            }

                            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                            public void isAllAgree(Boolean bool) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                    if (bool.booleanValue()) {
                                        PermissionsUtil.requestPermission(this.a, new PermissionListener(this) { // from class: com.baidu.wallet.lightapp.ability.a.l.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass1 a;

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

                                            @Override // com.baidu.wallet.core.permission.PermissionListener
                                            public void permissionDenied(@NonNull List<String> list) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, list) == null) {
                                                    AnonymousClass1 anonymousClass1 = this.a;
                                                    anonymousClass1.f53388d.a(anonymousClass1.a, anonymousClass1.f53387c, anonymousClass1.f53386b);
                                                }
                                            }

                                            @Override // com.baidu.wallet.core.permission.PermissionListener
                                            public void permissionGranted(@NonNull List<String> list) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                                                    AnonymousClass1 anonymousClass1 = this.a;
                                                    anonymousClass1.f53388d.a(anonymousClass1.a, anonymousClass1.f53386b);
                                                }
                                            }
                                        }, "android.permission.READ_CONTACTS");
                                    } else {
                                        this.f53388d.a(this.a, this.f53387c, this.f53386b);
                                    }
                                }
                            }

                            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                            public void isShow(String str3, Boolean bool) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, bool) == null) {
                                }
                            }

                            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                            public void requestResult(String str3, Boolean bool) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str3, bool) == null) {
                                }
                            }
                        });
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    throw new InvalidParameterException("参数格式非法");
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                ContactSelectModel contactSelectModel = new ContactSelectModel(1);
                ContactSelectModel.Data data = contactSelectModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
                data.des = e3.getLocalizedMessage();
                iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, activity, iLightappInvokerCallback) == null) {
            SelectAddressProxy.startSelectAddress(activity, new com.baidu.wallet.lightapp.business.presenter.b(this, activity, iLightappInvokerCallback) { // from class: com.baidu.wallet.lightapp.ability.a.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Activity a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f53389b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ l f53390c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, iLightappInvokerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53390c = this;
                    this.a = activity;
                    this.f53389b = iLightappInvokerCallback;
                }

                @Override // com.baidu.wallet.lightapp.business.presenter.b
                public void onContactsSelected(String str, int i2, String[] strArr, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), strArr, str2, str3}) == null) {
                        NativeAbilityContactSelectModel nativeAbilityContactSelectModel = new NativeAbilityContactSelectModel();
                        if (i2 != 0) {
                            nativeAbilityContactSelectModel.result = 1;
                            if (TextUtils.equals(str2, "取消")) {
                                nativeAbilityContactSelectModel.cnt.errCode = LightappConstants.ERRCODE_CANCEL;
                            } else {
                                nativeAbilityContactSelectModel.cnt.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
                            }
                            nativeAbilityContactSelectModel.cnt.des = str2;
                            this.f53389b.onResult(1, nativeAbilityContactSelectModel.toJson());
                        } else if (strArr != null) {
                            String str4 = strArr.length > 0 ? strArr[0] : "";
                            String str5 = strArr.length > 1 ? strArr[1] : "";
                            nativeAbilityContactSelectModel.result = 0;
                            NativeAbilityContactSelectModel.SelectedContact selectedContact = nativeAbilityContactSelectModel.cnt.selected;
                            selectedContact.name = str4;
                            selectedContact.phone = str5;
                            if (this.f53390c.a != 2) {
                                if (this.f53390c.f53384c == 1) {
                                    NativeAbilityContactSelectModelBase64 nativeAbilityContactSelectModelBase64 = new NativeAbilityContactSelectModelBase64();
                                    nativeAbilityContactSelectModelBase64.result = nativeAbilityContactSelectModel.result;
                                    if (nativeAbilityContactSelectModel.cnt != null) {
                                        if (TextUtils.isEmpty(str3)) {
                                            nativeAbilityContactSelectModel.cnt.allCount = "0";
                                        } else {
                                            nativeAbilityContactSelectModel.cnt.allCount = str3;
                                        }
                                        nativeAbilityContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(nativeAbilityContactSelectModel.cnt).getBytes());
                                    }
                                    this.f53389b.onResult(0, nativeAbilityContactSelectModelBase64.toJson());
                                    return;
                                }
                                if (nativeAbilityContactSelectModel.cnt != null) {
                                    if (TextUtils.isEmpty(str3)) {
                                        nativeAbilityContactSelectModel.cnt.allCount = "0";
                                    } else {
                                        nativeAbilityContactSelectModel.cnt.allCount = str3;
                                    }
                                }
                                this.f53389b.onResult(0, nativeAbilityContactSelectModel.toJson());
                                return;
                            }
                            PhoneContactsMananger.a(this.a).a(new PhoneContactsMananger.d(this, nativeAbilityContactSelectModel, str3) { // from class: com.baidu.wallet.lightapp.ability.a.l.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ NativeAbilityContactSelectModel a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f53391b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f53392c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, nativeAbilityContactSelectModel, str3};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f53392c = this;
                                    this.a = nativeAbilityContactSelectModel;
                                    this.f53391b = str3;
                                }

                                @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                                public void a(List<ContactSelectModel.AllContact> list, int i3) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeLI(1048576, this, list, i3) == null) {
                                        if (this.f53392c.f53390c.f53385d != null) {
                                            this.a.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), this.f53392c.f53390c.f53385d));
                                            if (TextUtils.isEmpty(this.f53391b)) {
                                                this.a.cnt.allCount = "0";
                                            } else {
                                                this.a.cnt.allCount = this.f53391b;
                                            }
                                        } else {
                                            Bundle a = com.baidu.wallet.lightapp.ability.b.a.a().a(this.f53392c.a, JsonUtils.toJson(list));
                                            NativeAbilityContactSelectModel.Data data = this.a.cnt;
                                            data.all = null;
                                            data.aesall = a.getString("aesContent");
                                            this.a.cnt.aeskey = a.getString("aesKey");
                                            if (TextUtils.isEmpty(this.f53391b)) {
                                                this.a.cnt.allCount = "0";
                                            } else if (list != null) {
                                                NativeAbilityContactSelectModel.Data data2 = this.a.cnt;
                                                data2.allCount = list.size() + "";
                                            } else {
                                                this.a.cnt.allCount = this.f53391b;
                                            }
                                        }
                                        if (this.f53392c.f53390c.f53384c == 1) {
                                            NativeAbilityContactSelectModelBase64 nativeAbilityContactSelectModelBase642 = new NativeAbilityContactSelectModelBase64();
                                            NativeAbilityContactSelectModel nativeAbilityContactSelectModel2 = this.a;
                                            nativeAbilityContactSelectModelBase642.result = nativeAbilityContactSelectModel2.result;
                                            NativeAbilityContactSelectModel.Data data3 = nativeAbilityContactSelectModel2.cnt;
                                            if (data3 != null) {
                                                nativeAbilityContactSelectModelBase642.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data3).getBytes());
                                            }
                                            this.f53392c.f53389b.onResult(0, nativeAbilityContactSelectModelBase642.toJson());
                                            return;
                                        }
                                        this.f53392c.f53389b.onResult(0, this.a.toJson());
                                    }
                                }
                            });
                            if (this.f53390c.f53383b > 0) {
                                PhoneContactsMananger.a(this.a).a(this.f53390c.f53383b, false);
                            } else {
                                PhoneContactsMananger.a(this.a).a(1000, false);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, str, iLightappInvokerCallback) == null) {
            ContactSelectModel contactSelectModel = new ContactSelectModel(1);
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = PhoneUtils.getApplicationName(context) + "没有访问通信录的权限";
            iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
        }
    }
}
