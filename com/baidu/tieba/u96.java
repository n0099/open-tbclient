package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.aiapps.apps.share.AiAppsShareDelegateActivity;
import com.baidu.tieba.dw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes8.dex */
public class u96 implements dw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dw2.a a;
    public CustomMessageListener b;

    @Override // com.baidu.tieba.dw2
    public void b(Context context, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, uri) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u96 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u96 u96Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u96Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u96Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.a.b();
                } else {
                    this.a.a.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw2.a a;

        public b(u96 u96Var, dw2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u96Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) && delegateResult.isOk()) {
                if (delegateResult.mResult.getBoolean("share_result")) {
                    this.a.b();
                } else {
                    this.a.a();
                }
            }
        }
    }

    public u96() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this, 2921366);
        TbadkCoreApplication.getInst().setSkinType(0);
        MessageManager.getInstance().registerListener(this.b);
    }

    @Override // com.baidu.tieba.dw2
    public void a(Context context, JSONObject jSONObject, dw2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, context, jSONObject, aVar) == null) && (context instanceof Activity)) {
            this.a = aVar;
            Bundle bundle = new Bundle();
            try {
                String optString = jSONObject.optString("shareUrl");
                if (StringUtils.isNull(optString)) {
                    optString = jSONObject.getString(GameAssistConstKt.KEY_LINKURL);
                }
                if (optString.indexOf("appid") > 0) {
                    jSONObject.put(GameAssistConstKt.KEY_LINKURL, "https://tieba.baidu.com/mo/q/smallapp/sharePage?from=singlemessage&isappinstalled=0#/?" + optString.substring(optString.indexOf("appid")));
                } else {
                    jSONObject.put(GameAssistConstKt.KEY_LINKURL, optString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bundle.putString("options", jSONObject.toString());
            bundle.putBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_SNAPSHOT, jSONObject.optBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_SNAPSHOT));
            bundle.putBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_FORCE_LIGHT_THEME, jSONObject.optBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_FORCE_LIGHT_THEME));
            bundle.putString("source", "swan_");
            Activity activity = (Activity) context;
            bundle.putInt("screenOrientation", activity.getRequestedOrientation());
            DelegateUtils.callOnMainWithActivity(activity, AiAppsShareDelegateActivity.class, s96.class, bundle, new b(this, aVar));
        }
    }
}
