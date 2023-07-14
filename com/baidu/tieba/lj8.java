package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qj8 a;
    public TbPageContext b;
    public GroupChatDialogFragment c;
    @Nullable
    public wi8 d;
    public do5 e;
    public co5 f;
    public NoDataView g;
    public String h;
    public final View.OnClickListener i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj8 a;

        public a(lj8 lj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.e != null) {
                    this.a.e.dettachView(this.a.a.m());
                    this.a.e = null;
                }
                if (this.a.d != null) {
                    this.a.i();
                    this.a.c.B1();
                }
            }
        }
    }

    public lj8(@NonNull GroupChatDialogFragment groupChatDialogFragment, @NonNull TbPageContext tbPageContext, @NonNull wi8 wi8Var, qj8 qj8Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatDialogFragment, tbPageContext, wi8Var, qj8Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.c = groupChatDialogFragment;
        this.b = tbPageContext;
        this.d = wi8Var;
        this.a = qj8Var;
        this.h = str;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            co5 co5Var = this.f;
            if (co5Var != null) {
                co5Var.m(i);
            }
            do5 do5Var = this.e;
            if (do5Var != null) {
                do5Var.onChangeSkinType();
            }
            NoDataView noDataView = this.g;
            if (noDataView != null) {
                noDataView.f(this.b, i);
            }
        }
    }

    public void e() {
        co5 co5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (co5Var = this.f) != null) {
            co5Var.dettachView(this.a.m());
        }
    }

    public void f() {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (do5Var = this.e) != null) {
            do5Var.dettachView(this.a.m());
            this.e = null;
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.g) != null) {
            noDataView.setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a.n() != null) {
                this.a.n().setVisibility(8);
            }
            if (this.f == null) {
                co5 co5Var = new co5(xm6.getContext());
                this.f = co5Var;
                co5Var.onChangeSkinType();
            }
            this.f.attachView(this.a.m());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a.n() != null) {
                this.a.n().setVisibility(8);
            }
            e();
            if (this.e == null) {
                this.e = new do5(xm6.getContext(), this.i);
            }
            this.e.k(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds300));
            this.e.attachView(this.a.m(), true);
            this.e.p();
            this.e.onChangeSkinType();
            this.e.f(R.color.transparent);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.WEBVIEW;
            String string = xm6.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0955);
            if (this.h.equals("msgTabFragment")) {
                imgType = NoDataViewFactory.ImgType.CREATE;
                string = xm6.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0cb0);
            }
            if (this.a.n() != null) {
                this.a.n().setVisibility(8);
            }
            if (this.g == null) {
                this.g = NoDataViewFactory.b(xm6.getContext(), this.a.r(), NoDataViewFactory.d.b(imgType, 400), NoDataViewFactory.e.d(null, string), null, true);
            }
            this.g.f(this.b, TbadkApplication.getInst().getSkinType());
            this.g.setVisibility(0);
        }
    }
}
