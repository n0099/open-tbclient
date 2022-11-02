package com.baidu.tieba.newinterest.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.io8;
import com.baidu.tieba.ky4;
import com.baidu.tieba.n9;
import com.baidu.tieba.newinterest.data.InterestCommitHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumReqMsg;
import com.baidu.tieba.newinterest.data.InterestedForumSocketResMsg;
import com.baidu.tieba.of5;
import com.baidu.tieba.pb;
import com.baidu.tieba.pu7;
import com.baidu.tieba.qu7;
import com.baidu.tieba.ru7;
import com.baidu.tieba.tu7;
import com.baidu.tieba.wn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class InterestedForumModel {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId i;
    public static ILoginListener j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Gson b;
    public d c;
    public c d;
    public List<pu7> e;
    public boolean f;
    public pb g;
    public HttpMessageListener h;

    /* loaded from: classes5.dex */
    public interface c {
        void b();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void c(qu7 qu7Var);

        void onError(int i, String str);
    }

    /* loaded from: classes5.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterestedForumModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterestedForumModel interestedForumModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interestedForumModel;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() != InterestedForumModel.i) {
                    return;
                }
                qu7 qu7Var = null;
                if (responsedMessage instanceof InterestedForumHttpResMsg) {
                    qu7Var = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                    qu7Var = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (qu7Var != null && !ListUtils.isEmpty(qu7Var.a)) {
                        if (qu7Var != null && this.a.c != null) {
                            InterestedForumModel.c(this.a);
                            this.a.c.c(qu7Var);
                        }
                    } else if (this.a.c != null) {
                        this.a.c.onError(-1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c7f));
                    }
                } else if (this.a.c != null) {
                    this.a.c.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterestedForumModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterestedForumModel interestedForumModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumModel, Integer.valueOf(i)};
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
            this.a = interestedForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == InterestedForumModel.i) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (!interestCommitHttpResMsg.hasError() && interestCommitHttpResMsg.getErrno() == 0) {
                    if (this.a.d != null) {
                        this.a.d.b();
                    }
                    ky4.k().x("key_select_interest_flag", System.currentTimeMillis());
                } else if (this.a.c != null) {
                    this.a.c.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1520231983, "Lcom/baidu/tieba/newinterest/model/InterestedForumModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1520231983, "Lcom/baidu/tieba/newinterest/model/InterestedForumModel;");
                return;
            }
        }
        j = new ILoginListener() { // from class: com.baidu.tieba.newinterest.model.InterestedForumModel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onCancel() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                InterestedForumModel.f(TbSingleton.getInstance().getTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM));
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                InterestedForumModel.f(TbSingleton.getInstance().getTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM));
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                    return;
                }
                InterestedForumModel.f(TbSingleton.getInstance().getTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM));
                TbSingleton.getInstance().removeTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM);
            }
        };
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                f(URLEncoder.encode(j(), IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if ((this.a - 1) * 3 < this.e.size()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            of5 of5Var = new of5(309654);
            of5Var.setResponsedClass(InterestedForumSocketResMsg.class);
            of5Var.g(true);
            of5Var.setPriority(4);
            MessageManager.getInstance().registerTask(of5Var);
        }
    }

    public InterestedForumModel(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Gson();
        this.f = false;
        this.g = new a(this, CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);
        this.h = new b(this, CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        i = bdUniqueId;
        this.g.setTag(bdUniqueId);
        this.h.setTag(i);
        MessageManager.getInstance().registerListener(this.g);
        MessageManager.getInstance().registerListener(this.h);
        p();
        o();
    }

    public static /* synthetic */ int c(InterestedForumModel interestedForumModel) {
        int i2 = interestedForumModel.a;
        interestedForumModel.a = i2 + 1;
        return i2;
    }

    public void i(List<wn> list) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            h(URLEncoder.encode(l(list), IMAudioTransRequest.CHARSET));
        }
    }

    public void r(List<pu7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.e = list;
            this.a = 1;
        }
    }

    public void s(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.d = cVar;
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            httpMessage.addParam("interestList", str);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final List<Integer> k(List<pu7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (pu7 pu7Var : list) {
                    arrayList.add(Integer.valueOf(pu7Var.c()));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, io8.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TbadkCoreApplication.isLogin()) {
                f(str);
            } else if (n9.g().h() > 1) {
                TbSingleton.getInstance().setTempString(TbSingleton.TEMP_STRING_KEY_INTEREST_FORUM, str);
                LoginDialogData loginDialogData = new LoginDialogData(n9.g().f(n9.g().h() - 2), LoginDialogData.INTEREST_FORUM_COMMIT);
                loginDialogData.setLoginListener(j);
                DialogLoginHelper.checkUpIsLogin(loginDialogData);
                TbadkCoreApplication.getInst().getCurrentActivity().finish();
            }
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            if (!ListUtils.isEmpty(this.e)) {
                for (pu7 pu7Var : this.e) {
                    if (pu7Var != null) {
                        hashMap.put(pu7Var.d(), new HashMap());
                    }
                }
            }
            return this.b.toJson(hashMap);
        }
        return (String) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
            List<pu7> list = this.e;
            if (list == null) {
                interestedForumReqMsg.classidList = k(null);
            } else {
                interestedForumReqMsg.classidList = k(list.subList((this.a - 1) * 3, Math.min(list.size(), this.a * 3)));
            }
            interestedForumReqMsg.setTag(i);
            this.f = true;
            MessageManager.getInstance().sendMessage(interestedForumReqMsg);
        }
    }

    public final String l(List<wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = null;
            String str = "";
            for (wn wnVar : list) {
                if (wnVar instanceof tu7) {
                    if (!StringUtils.isNull(str)) {
                        hashMap.put(str, hashMap2);
                    }
                    hashMap2 = new HashMap();
                    str = ((tu7) wnVar).b();
                } else if (wnVar instanceof ru7) {
                    ru7 ru7Var = (ru7) wnVar;
                    if (ru7Var.k() && hashMap2 != null) {
                        hashMap2.put(Long.valueOf(ru7Var.c()), ru7Var.f());
                    }
                }
            }
            if (!StringUtils.isNull(str)) {
                hashMap.put(str, hashMap2);
            }
            if (!ListUtils.isEmpty(this.e)) {
                for (pu7 pu7Var : this.e) {
                    if (pu7Var != null && !hashMap.containsKey(pu7Var.d())) {
                        hashMap.put(pu7Var.d(), new HashMap());
                    }
                }
            }
            return this.b.toJson(hashMap);
        }
        return (String) invokeL.objValue;
    }
}
