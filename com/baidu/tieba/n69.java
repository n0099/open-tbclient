package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.write.message.QuestionTagListRequestMessage;
import com.baidu.tieba.write.write.message.QuestionTagListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class n69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Cdo> a;
    public b b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public final HttpMessageListener g;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n69 n69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n69Var, Integer.valueOf(i)};
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
            this.a = n69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof QuestionTagListResponseMessage)) {
                QuestionTagListData questionTagListData = ((QuestionTagListResponseMessage) httpResponsedMessage).data;
                if (httpResponsedMessage.getError() != 0 || questionTagListData == null) {
                    if (this.a.b != null) {
                        this.a.b.c(this.a.f != 1, TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c60));
                        return;
                    }
                    return;
                }
                if (!ListUtils.isEmpty(questionTagListData.b)) {
                    this.a.a.addAll(questionTagListData.b);
                }
                this.a.e = questionTagListData.a == 1;
                if (this.a.e) {
                    n69.c(this.a);
                }
                if (this.a.b != null) {
                    this.a.b.a(this.a.e, this.a.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, List<Cdo> list);

        void b(boolean z);

        void c(boolean z, String str);
    }

    public n69() {
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
        this.a = new ArrayList();
        this.f = 1;
        this.g = new a(this, CmdConfigHttp.CMD_QUESTION_THREAD_TAG_LIST);
        g();
    }

    public static /* synthetic */ int c(n69 n69Var) {
        int i = n69Var.f;
        n69Var.f = i + 1;
        return i;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_QUESTION_THREAD_TAG_LIST, TbConfig.SERVER_ADDRESS + TbConfig.QUESTION_THREAD_TAG_LIST);
            tbHttpMessageTask.setResponsedClass(QuestionTagListResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public boolean h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (z || this.e) {
                k();
                b bVar = this.b;
                if (bVar != null) {
                    bVar.b(false);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void i(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
            this.f = 1;
            this.e = false;
            this.a.clear();
            k();
            b bVar = this.b;
            if (bVar != null) {
                bVar.b(true);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.g);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new QuestionTagListRequestMessage().setSearchWords(this.c).setCategory(this.d).setPage(this.f));
        }
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }
}
