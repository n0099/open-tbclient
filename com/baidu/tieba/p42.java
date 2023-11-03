package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p42 extends d83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p42(d73 d73Var) {
        super(d73Var, "/swanAPI/setPhoneContact");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d73Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.d83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g63Var)) == null) {
            if (context != null && callbackHandler != null && g63Var != null) {
                if (g63Var.o0()) {
                    if (d83.b) {
                        Log.d("SetPhoneContactAction", "SetPhoneContactAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (d83.b) {
                    Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
                }
                String optString = optParamsAsJo.optString("action");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                o42 a = o42.a(optParamsAsJo);
                if (!a.t()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                this.c = optParamsAsJo.optString("cb");
                char c = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -1183792455) {
                    if (hashCode == 3108362 && optString.equals(StatKey.EDITADDR_TAG_STAGE_EDIT)) {
                        c = 1;
                    }
                } else if (optString.equals("insert")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                        return false;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    j(context, a, callbackHandler);
                    return true;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                l(context, a, callbackHandler);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context, o42 o42Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, o42Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
            intent.setType("vnd.android.cursor.item/contact");
            intent.putExtra("name", o42Var.d());
            intent.putExtra("email", o42Var.r);
            intent.putParcelableArrayListExtra("data", k(o42Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            m(context, intent, callbackHandler);
        }
    }

    @SuppressLint({"BDOfflineUrl"})
    public final void l(Context context, o42 o42Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, o42Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
            intent.putExtra("name", o42Var.d());
            intent.putExtra("email", o42Var.r);
            intent.putParcelableArrayListExtra("data", k(o42Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            m(context, intent, callbackHandler);
        }
    }

    public final ArrayList<ContentValues> k(o42 o42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o42Var)) == null) {
            ArrayList<ContentValues> arrayList = new ArrayList<>(16);
            arrayList.add(o42Var.j());
            arrayList.add(o42Var.h());
            arrayList.add(o42Var.s());
            arrayList.add(o42Var.i());
            arrayList.add(o42Var.g());
            arrayList.add(o42Var.r());
            arrayList.add(o42Var.k());
            arrayList.add(o42Var.o());
            arrayList.add(o42Var.n());
            arrayList.add(o42Var.m());
            arrayList.add(o42Var.l());
            arrayList.add(o42Var.b());
            arrayList.add(o42Var.p());
            arrayList.add(o42Var.e());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void m(Context context, Intent intent, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, intent, callbackHandler) == null) {
            try {
                context.startActivity(intent);
                if (!TextUtils.isEmpty(this.c)) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0, DnsModel.MSG_OK).toString());
                }
            } catch (Exception e) {
                if (d83.b) {
                    Log.d("SetPhoneContactAction", "startContactActivity:" + e.toString());
                }
                if (!TextUtils.isEmpty(this.c)) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
                }
            }
        }
    }
}
