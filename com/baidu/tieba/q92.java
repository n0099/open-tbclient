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
public class q92 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q92(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/setPhoneContact");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @SuppressLint({"BDOfflineUrl"})
    private void insert(Context context, p92 p92Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, p92Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
            intent.putExtra("name", p92Var.d());
            intent.putExtra("email", p92Var.r);
            intent.putParcelableArrayListExtra("data", k(p92Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            l(context, intent, callbackHandler);
        }
    }

    public final void j(Context context, p92 p92Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, p92Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
            intent.setType("vnd.android.cursor.item/contact");
            intent.putExtra("name", p92Var.d());
            intent.putExtra("email", p92Var.r);
            intent.putParcelableArrayListExtra("data", k(p92Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            l(context, intent, callbackHandler);
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (context != null && callbackHandler != null && hb3Var != null) {
                if (hb3Var.n0()) {
                    if (ed3.b) {
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
                if (ed3.b) {
                    Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
                }
                String optString = optParamsAsJo.optString("action");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                p92 a = p92.a(optParamsAsJo);
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
                insert(context, a, callbackHandler);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final ArrayList<ContentValues> k(p92 p92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p92Var)) == null) {
            ArrayList<ContentValues> arrayList = new ArrayList<>(16);
            arrayList.add(p92Var.j());
            arrayList.add(p92Var.h());
            arrayList.add(p92Var.s());
            arrayList.add(p92Var.i());
            arrayList.add(p92Var.g());
            arrayList.add(p92Var.r());
            arrayList.add(p92Var.k());
            arrayList.add(p92Var.o());
            arrayList.add(p92Var.n());
            arrayList.add(p92Var.m());
            arrayList.add(p92Var.l());
            arrayList.add(p92Var.b());
            arrayList.add(p92Var.p());
            arrayList.add(p92Var.e());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void l(Context context, Intent intent, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, intent, callbackHandler) == null) {
            try {
                context.startActivity(intent);
                if (!TextUtils.isEmpty(this.c)) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0, DnsModel.MSG_OK).toString());
                }
            } catch (Exception e) {
                if (ed3.b) {
                    Log.d("SetPhoneContactAction", "startContactActivity:" + e.toString());
                }
                if (!TextUtils.isEmpty(this.c)) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
                }
            }
        }
    }
}
