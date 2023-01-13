package com.baidu.tieba.write.write.work.classdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectClassDialogActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.cx4;
import com.baidu.tieba.dp5;
import com.baidu.tieba.nv8;
import com.baidu.tieba.qi9;
import com.baidu.tieba.rb;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassHttpResMessage;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassSocketResMessage;
import com.baidu.tieba.zg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SelectClassDialogActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView k;
    public LinearLayout l;
    public SelectClassDialogView m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public String s;
    public String t;
    public boolean u;
    public qi9 v;
    public rb w;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        /* renamed from: com.baidu.tieba.write.write.work.classdialog.SelectClassDialogActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0477a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0477a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.v != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.v.e();
                    SelectClassDialogActivity selectClassDialogActivity = this.a.a;
                    selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.l);
                    SelectClassDialogActivity selectClassDialogActivity2 = this.a.a;
                    selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.l, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectClassDialogActivity selectClassDialogActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = selectClassDialogActivity;
        }

        @Override // com.baidu.tieba.rb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectClassDialogActivity selectClassDialogActivity = this.a;
                selectClassDialogActivity.showNetRefreshView(selectClassDialogActivity.l, null, this.a.getString(R.string.obfuscated_res_0x7f0f04a6), null, true, new View$OnClickListenerC0477a(this));
                this.a.setNetRefreshViewEmotionMarginTop(UtilHelper.getDimenPixelSize(R.dimen.tbds0));
                return;
            }
            if (responsedMessage instanceof GetSelectClassHttpResMessage) {
                GetSelectClassHttpResMessage getSelectClassHttpResMessage = (GetSelectClassHttpResMessage) responsedMessage;
                this.a.v.g(getSelectClassHttpResMessage.getFirstClass());
                this.a.v.h(getSelectClassHttpResMessage.getSecondClass());
            } else if (responsedMessage instanceof GetSelectClassSocketResMessage) {
                GetSelectClassSocketResMessage getSelectClassSocketResMessage = (GetSelectClassSocketResMessage) responsedMessage;
                this.a.v.g(getSelectClassSocketResMessage.getFirstClass());
                this.a.v.h(getSelectClassSocketResMessage.getSecondClass());
            }
            this.a.E1();
            SelectClassDialogActivity selectClassDialogActivity2 = this.a;
            selectClassDialogActivity2.hideLoadingView(selectClassDialogActivity2.l);
            SelectClassDialogActivity selectClassDialogActivity3 = this.a;
            selectClassDialogActivity3.o = selectClassDialogActivity3.v.b().indexOf(this.a.s);
            if (this.a.o > 0 && this.a.o < this.a.v.c().size()) {
                SelectClassDialogActivity selectClassDialogActivity4 = this.a;
                selectClassDialogActivity4.p = selectClassDialogActivity4.v.c().get(this.a.o).indexOf(this.a.t);
                return;
            }
            this.a.o = 0;
            this.a.p = 0;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.a.a.v.a(this.a.a.q, this.a.a.r)));
                    this.a.a.N0();
                }
            }
        }

        public d(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !this.a.n) {
                return;
            }
            if (this.a.u && this.a.o > 0 && (this.a.o != this.a.q || this.a.p != this.a.r)) {
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.getPageContext().getPageActivity());
                tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f1183);
                tBAlertBuilder.m(R.string.obfuscated_res_0x7f0f1182);
                tBAlertBuilder.o(true);
                tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0509, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f044c, TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
                tBAlertBuilder.i();
                tBAlertBuilder.j(false);
                tBAlertBuilder.z();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.a.v.a(this.a.q, this.a.r)));
            this.a.N0();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        public b(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.v != null) {
                this.a.v.e();
                SelectClassDialogActivity selectClassDialogActivity = this.a;
                selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.l);
                SelectClassDialogActivity selectClassDialogActivity2 = this.a;
                selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.l, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        public c(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // com.baidu.tieba.dp5
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                i = (i < 0 || i >= this.a.v.b().size()) ? 0 : 0;
                i2 = (i2 < 0 || i2 >= this.a.v.c().get(i).size()) ? 0 : 0;
                String str = this.a.v.b().get(i);
                String str2 = this.a.v.c().get(i).get(i2);
                if ((i != 0 || i2 != 0) && (!str.equals(this.a.s) || !str2.equals(this.a.t))) {
                    this.a.n = true;
                    cx4.d(this.a.k).x(R.color.CAM_X0302);
                } else {
                    this.a.n = false;
                    this.a.k.setTextColor(nv8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                    if (str.equals(this.a.s) && str2.equals(this.a.t)) {
                        this.a.s = "";
                        this.a.t = "";
                        this.a.n = true;
                        cx4.d(this.a.k).x(R.color.CAM_X0302);
                    }
                }
                this.a.q = i;
                this.a.r = i2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        public e(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.N0();
        }
    }

    public SelectClassDialogActivity() {
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
        this.n = false;
        this.w = new a(this, CmdConfigHttp.CMD_GET_SELECT_CLASS, 309713);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return UtilHelper.getScreenHeight(this) - UtilHelper.getDimenPixelSize(R.dimen.tbds999);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public View.OnClickListener R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new e(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m.setPicker(this.v.b(), this.v.c());
            int indexOf = this.v.b().indexOf(this.s);
            int i = 0;
            indexOf = (indexOf < 0 || indexOf >= this.v.b().size()) ? 0 : 0;
            int indexOf2 = this.v.c().get(indexOf).indexOf(this.t);
            if (indexOf2 != -1) {
                i = indexOf2;
            }
            this.m.setCurrentItems(indexOf, i);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public zg5 P0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, navigationBar)) == null) {
            this.l = linearLayout;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f1184));
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f0520));
            this.k = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            SelectClassDialogView selectClassDialogView = new SelectClassDialogView(linearLayout, this);
            this.m = selectClassDialogView;
            return selectClassDialogView;
        }
        return (zg5) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.n) {
                cx4.d(this.k).x(R.color.CAM_X0302);
            } else {
                this.k.setTextColor(nv8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.v = new qi9(getUniqueId());
            this.w.getHttpMessageListener().setSelfListener(true);
            this.w.getSocketMessageListener().setSelfListener(true);
            registerListener(this.w);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.v.e();
                showLoadingView(this.l, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
            } else {
                showNetRefreshView(this.l, null, getString(R.string.obfuscated_res_0x7f0f04a6), null, true, new b(this));
                setNetRefreshViewEmotionMarginTop(UtilHelper.getDimenPixelSize(R.dimen.tbds0));
            }
            this.s = getIntent().getStringExtra(SelectClassDialogActivityConfig.SELECT_INIT_FIRST_OPTION);
            this.t = getIntent().getStringExtra(SelectClassDialogActivityConfig.SELECT_INIT_SECOND_OPTION);
            this.u = getIntent().getBooleanExtra(SelectClassDialogActivityConfig.IS_SELECTED_TAGS, false);
            this.m.setOnOptionsSelectChangeListener(new c(this));
        }
    }
}
