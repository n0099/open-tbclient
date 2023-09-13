package com.baidu.tieba;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i55;
import com.baidu.tieba.immessagecenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class lt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public g55 b;
    public i55 c;
    public List<e55> d;
    public e55 e;
    public kt8 f;
    public c g;
    public i55.e h;

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes6.dex */
    public class a implements i55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt8 a;

        public a(lt8 lt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt8Var;
        }

        @Override // com.baidu.tieba.i55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements i55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt8 a;

        public b(lt8 lt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt8Var;
        }

        @Override // com.baidu.tieba.i55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
                if (this.a.g != null) {
                    this.a.g.a();
                }
                this.a.d();
            }
        }
    }

    public lt8(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new b(this);
        this.a = bdPageContext;
        this.c = new i55(bdPageContext.getPageActivity());
        e55 e55Var = new e55(bdPageContext.getString(R.string.obfuscated_res_0x7f0f054b), this.c);
        this.e = e55Var;
        e55Var.m(this.h);
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(this.e);
        this.c.o(new a(this));
        this.c.l(this.d);
        this.b = new g55(bdPageContext, this.c);
        e();
        g();
    }

    public void h(kt8 kt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kt8Var) == null) {
            this.f = kt8Var;
        }
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.g = cVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f.a);
        httpMessage.addParam("thread_id", this.f.b);
        httpMessage.addParam("post_id", this.f.c);
        httpMessage.addParam("ori_ugc_nid", this.f.d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        g55 g55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (g55Var = this.b) != null && g55Var.isShowing()) {
            this.b.dismiss();
        }
    }

    public void e() {
        i55 i55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (i55Var = this.c) != null) {
            i55Var.j();
        }
    }

    public void j() {
        g55 g55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (g55Var = this.b) != null) {
            g55Var.show();
        }
    }

    public void f() {
        BdPageContext bdPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdPageContext = this.a) != null && this.b != null) {
            Display defaultDisplay = bdPageContext.getPageActivity().getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
            attributes.width = displayMetrics.widthPixels;
            this.b.getWindow().setAttributes(attributes);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
            tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }
}
