package com.baidu.tieba.impersonal.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hi9;
import com.baidu.tieba.impersonal.PersonalChatActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/impersonal/dispatcher/PersonalChatDispatcher;", "Lcom/baidu/tieba/schema/SchemaDispatcher;", "()V", StatConstants.VALUE_TYPE_DISPATCH, "", "params", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "getPageParamsObj", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalChatDispatcher implements hi9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String OPEN_TALK_PROLOGUE = "spriteTalk";
    public static final String OPEN_TALK_TYPE = "spriteType";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1025349231, "Lcom/baidu/tieba/impersonal/dispatcher/PersonalChatDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1025349231, "Lcom/baidu/tieba/impersonal/dispatcher/PersonalChatDispatcher;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public PersonalChatDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private final JSONObject getPageParamsObj(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OPEN_TALK_TYPE, jSONObject.optString(OPEN_TALK_TYPE));
                jSONObject2.put(OPEN_TALK_PROLOGUE, jSONObject.optString(OPEN_TALK_PROLOGUE));
                jSONObject.put("pageParams", jSONObject2);
            } catch (Exception e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hi9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            if (!NetWorkUtils.isConnected(context)) {
                BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f0db4)).o();
                return;
            }
            String optString = jSONObject.optString(OPEN_TALK_PROLOGUE);
            String optString2 = jSONObject.optString(OPEN_TALK_TYPE);
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true);
            loginActivityConfig.setJumpToAfterDestroy(2);
            loginActivityConfig.setBackScheme(Uri.parse("tiebaapp://router/portal").buildUpon().appendQueryParameter(BdUniDispatchSchemeController.PARAM_CHAT_ROOM_ID_CAMEL, getPageParamsObj(jSONObject).toString()).build().toString());
            if (!ViewHelper.checkUpIsLoginFromH5(loginActivityConfig)) {
                return;
            }
            PersonalChatActivity.c.a(context, optString2, optString);
        }
    }
}
