package com.baidu.tieba;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.a65;
import com.baidu.tieba.immessagecenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l9 a;
    public y55 b;
    public a65 c;
    public List<w55> d;
    public w55 e;
    public oq8 f;
    public c g;
    public a65.e h;

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes7.dex */
    public class a implements a65.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq8 a;

        public a(pq8 pq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq8Var;
        }

        @Override // com.baidu.tieba.a65.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a65.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq8 a;

        public b(pq8 pq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq8Var;
        }

        @Override // com.baidu.tieba.a65.e
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

    public pq8(l9 l9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l9Var};
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
        this.a = l9Var;
        this.c = new a65(l9Var.getPageActivity());
        w55 w55Var = new w55(l9Var.getString(R.string.obfuscated_res_0x7f0f0546), this.c);
        this.e = w55Var;
        w55Var.m(this.h);
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(this.e);
        this.c.o(new a(this));
        this.c.l(this.d);
        this.b = new y55(l9Var, this.c);
        e();
        g();
    }

    public void h(oq8 oq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oq8Var) == null) {
            this.f = oq8Var;
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
        y55 y55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (y55Var = this.b) != null && y55Var.isShowing()) {
            this.b.dismiss();
        }
    }

    public void e() {
        a65 a65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (a65Var = this.c) != null) {
            a65Var.j();
        }
    }

    public void j() {
        y55 y55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (y55Var = this.b) != null) {
            y55Var.show();
        }
    }

    public void f() {
        l9 l9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (l9Var = this.a) != null && this.b != null) {
            Display defaultDisplay = l9Var.getPageActivity().getWindowManager().getDefaultDisplay();
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
