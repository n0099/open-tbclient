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
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class wd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r9 a;
    public wu4 b;
    public yu4 c;
    public List<uu4> d;
    public uu4 e;
    public vd7 f;
    public c g;
    public yu4.d h;

    /* loaded from: classes6.dex */
    public class a implements yu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd7 a;

        public a(wd7 wd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd7Var;
        }

        @Override // com.baidu.tieba.yu4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd7 a;

        public b(wd7 wd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd7Var;
        }

        @Override // com.baidu.tieba.yu4.d
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

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    public wd7(r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var};
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
        this.a = r9Var;
        this.c = new yu4(r9Var.getPageActivity());
        uu4 uu4Var = new uu4(r9Var.getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
        this.e = uu4Var;
        uu4Var.m(this.h);
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(this.e);
        this.c.m(new a(this));
        this.c.j(this.d);
        this.b = new wu4(r9Var, this.c);
        e();
        g();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f == null) {
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
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wu4Var = this.b) != null && wu4Var.isShowing()) {
            this.b.dismiss();
        }
    }

    public void e() {
        yu4 yu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (yu4Var = this.c) == null) {
            return;
        }
        yu4Var.i();
    }

    public void f() {
        r9 r9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (r9Var = this.a) == null || this.b == null) {
            return;
        }
        Display defaultDisplay = r9Var.getPageActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
        attributes.width = displayMetrics.widthPixels;
        this.b.getWindow().setAttributes(attributes);
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

    public void h(vd7 vd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vd7Var) == null) {
            this.f = vd7Var;
        }
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.g = cVar;
        }
    }

    public void j() {
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (wu4Var = this.b) == null) {
            return;
        }
        wu4Var.show();
    }
}
