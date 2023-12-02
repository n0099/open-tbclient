package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpMessageListener a;
    public c b;
    public BdUniqueId c;
    public CustomMessageListener d;

    /* loaded from: classes6.dex */
    public interface c {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k16 k16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k16Var, Integer.valueOf(i)};
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
            this.a = k16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                this.a.c((JSONObject) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k16 k16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k16Var, Integer.valueOf(i)};
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
            this.a = k16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003185 || !(httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) || !httpResponsedMessage.isSuccess() || this.a.b == null) {
                return;
            }
            this.a.b.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k16(String str) {
        this(str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public k16(String str, @Nullable BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.d = new a(this, 2016489);
        this.c = bdUniqueId;
        if (this.a == null) {
            this.a = new b(this, CmdConfigHttp.CMD_NEG_DELETE_THREAD);
        }
        if (this.c != null) {
            this.a.setSelfListener(true);
            this.a.setTag(this.c);
            this.d.setSelfListener(true);
            this.d.setTag(this.c);
        }
        MessageManager.getInstance().registerListener(this.a);
        MessageManager.getInstance().registerListener(this.d);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public final void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            try {
                int i = jSONObject.getInt("type");
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONObject.getJSONArray("thread_ids"));
                String JsonArrayToString2 = StringHelper.JsonArrayToString(jSONObject.getJSONArray("reason"));
                String JsonArrayToString3 = StringHelper.JsonArrayToString(jSONObject.getJSONArray("is_frs_masks"));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i);
                httpMessage.addParam("thread_ids", JsonArrayToString);
                httpMessage.addParam("is_frs_masks", JsonArrayToString3);
                httpMessage.addParam("reason", JsonArrayToString2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                if (this.c != null) {
                    httpMessage.setTag(this.c);
                }
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.d);
            MessageManager.getInstance().unRegisterListener(this.a);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.a);
            MessageManager.getInstance().registerListener(this.d);
        }
    }
}
