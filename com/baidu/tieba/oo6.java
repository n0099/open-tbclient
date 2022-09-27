package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.view.LoadingUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.util.PersonalChatUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes5.dex */
public class oo6 {
    public static /* synthetic */ Interceptable $ic;
    public static oo6 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends oo6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends di5<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(oo6 oo6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.di5
        /* renamed from: a */
        public Long doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/index/audio");
                netWork.setNeedBdussForGet(true);
                String netString = netWork.getNetString();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        JSONObject optJSONObject = new JSONObject(netString).optJSONObject("data");
                        if (optJSONObject != null) {
                            return Long.valueOf(optJSONObject.optLong("room_id"));
                        }
                        return Long.valueOf(dh.g(this.a, 0L));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return Long.valueOf(dh.g(this.a, 0L));
            }
            return (Long) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ih5<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public c(oo6 oo6Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo6Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ih5
        /* renamed from: a */
        public void onReturnDataInUI(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                LoadingUtil.cancel();
                long longValue = l.longValue();
                TbPageContext tbPageContext = this.a;
                if (tbPageContext == null) {
                    return;
                }
                if (longValue == 0) {
                    ej.N(tbPageContext.getPageActivity(), "当前没有可用房间");
                } else {
                    ((w95) ServiceManager.getService(w95.a.a())).a(this.a, longValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends di5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(oo6 oo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.di5
        /* renamed from: a */
        public JSONObject doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork("https://peiwan.baidu.com/peiwan/api/index/service");
                netWork.setNeedBdussForGet(true);
                String netString = netWork.getNetString();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        return new JSONObject(netString).optJSONObject("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ih5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public e(oo6 oo6Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo6Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ih5
        /* renamed from: a */
        public void onReturnDataInUI(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                LoadingUtil.cancel();
                if (this.a != null && jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("chat_god");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("user_id");
                        if (TextUtils.isEmpty(optString)) {
                            optString = "0";
                        }
                        PersonalChatUtil.jump2ChatFromPeiwan(TbadkCoreApplication.getInst().getContext(), Long.parseLong(optString), optJSONObject.optString("username"), optJSONObject.optString("avatar"));
                        return;
                    }
                    return;
                }
                ej.N(TbadkCoreApplication.getInst(), "网络请求失败");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039027, "Lcom/baidu/tieba/oo6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039027, "Lcom/baidu/tieba/oo6;");
                return;
            }
        }
        a = new a();
    }

    public /* synthetic */ oo6(a aVar) {
        this();
    }

    public static oo6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : (oo6) invokeV.objValue;
    }

    public void a(TbPageContext tbPageContext, LiveFuseForumData liveFuseForumData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, liveFuseForumData, str) == null) || liveFuseForumData == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (liveFuseForumData.type.intValue() == 2) {
            if (str.contains("room_id")) {
                d(tbPageContext, str);
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                e(tbPageContext, str);
            } else {
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
            }
        } else if (liveFuseForumData.type.intValue() == 3) {
            d(tbPageContext, str);
        } else if (liveFuseForumData.type.intValue() == 4) {
            e(tbPageContext, str);
        } else {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, str) == null) && c()) {
            LoadingUtil.show("跳转中...");
            hi5.b(new b(this, Uri.parse(str).getQueryParameter("room_id")), new c(this, tbPageContext));
        }
    }

    public final void e(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, str) == null) && c()) {
            LoadingUtil.show("跳转中...");
            hi5.b(new d(this), new e(this, tbPageContext));
        }
    }

    public oo6() {
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
}
