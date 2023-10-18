package com.baidu.tieba.personPolymeric.jvbao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.fu9;
import com.baidu.tieba.lu9;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.yh;
import com.baidu.tieba.zr9;
import com.baidu.tieba.zu9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ReportThemeActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean x = true;
    public static CustomMessageListener y;
    public transient /* synthetic */ FieldHolder $fh;
    public zu9 a;
    public TextView b;
    public NavigationBar c;
    public View d;
    public TextView e;
    public BdListView f;
    public fu9 g;
    public PersonPostModel h;
    public View i;
    public View j;
    public View k;
    public TextView l;
    public PbListView m;
    public NoDataView n;
    public boolean o;
    public boolean p;
    public int q;
    public ArrayList<String> r;
    public String s;
    public ArrayList<yh> t;
    public Handler u;
    public PersonPostModel.d v;
    public PersonPostModel.c w;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean unused = ReportThemeActivity.x = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportThemeActivity a;

        public b(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reportThemeActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                this.a.M1(message.arg1);
                if (message.arg1 > 10) {
                    this.a.b.setText(this.a.getString(R.string.choose_report_theme_num, new Object[]{10}));
                    new BdTopToast(this.a.getActivity()).setIcon(false).setContent(this.a.getResources().getString(R.string.max_choose_report_theme_num)).show(this.a.c);
                    return;
                }
                this.a.b.setText(this.a.getString(R.string.choose_report_theme_num, new Object[]{Integer.valueOf(message.arg1)}));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportThemeActivity a;

        public c(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reportThemeActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null && this.a.p) {
                if (this.a.m != null && !this.a.m.p()) {
                    this.a.O1(true);
                }
                this.a.O1(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportThemeActivity a;

        public d(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reportThemeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ReportThemeActivity reportThemeActivity = this.a;
                reportThemeActivity.r = reportThemeActivity.I1();
                TiebaStatic.log("c14576");
                Intent intent = new Intent();
                intent.putExtra(ReportThemeActivityConfig.REPORT_TID_LIST, this.a.r);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements PersonPostModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportThemeActivity a;

        public e(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reportThemeActivity;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
        public void S0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) {
                return;
            }
            this.a.F1(personPostModel, z);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReportThemeActivity a;

        public f(ReportThemeActivity reportThemeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reportThemeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reportThemeActivity;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void I0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, personPostModel, z) != null) {
                return;
            }
            this.a.F1(personPostModel, z);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(422209324, "Lcom/baidu/tieba/personPolymeric/jvbao/ReportThemeActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(422209324, "Lcom/baidu/tieba/personPolymeric/jvbao/ReportThemeActivity;");
                return;
            }
        }
        y = new a(2921440);
    }

    public int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public ArrayList<String> I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.r;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.setNextPage(null);
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.smoothScrollToPosition(0);
        }
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.setNextPage(this.m);
            this.m.P(0);
            this.m.U();
        }
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f.setNextPage(this.m);
            this.m.P(0);
            this.m.g();
            this.m.H(getPageContext().getString(R.string.list_no_more));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            this.f.setOnSrollToBottomListener(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onNetRefreshButtonClicked();
            G1(true);
        }
    }

    public ReportThemeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.c = null;
        this.f = null;
        this.g = null;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = new ArrayList<>();
        this.u = new b(this);
        this.v = new e(this);
        this.w = new f(this);
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.report_user));
            this.e = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f04c8));
            this.d = this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.e.setOnClickListener(new d(this));
        }
    }

    public final void K1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this.v, true, 2);
            this.h = personPostModel;
            personPostModel.setUniqueId(getUniqueId());
            TiebaStatic.log("c14572");
        }
    }

    public void M1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i < 1) {
                this.e.setEnabled(false);
            } else {
                this.e.setEnabled(true);
            }
        }
    }

    public void P1(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            Q1(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0873);
            K1(bundle);
            initView();
            G1(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final boolean E1(PersonPostModel personPostModel, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, personPostModel, z)) == null) {
            if (personPostModel != null) {
                boolean z2 = !ListUtils.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() >= 20) {
                        return true;
                    }
                } else {
                    return z2;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void F1(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, personPostModel, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.o = false;
            hideLoadingView(this.i);
            hideNetRefreshView(this.k);
            this.l.setVisibility(0);
            this.b.setVisibility(0);
            if (personPostModel != null && (personPostModel2 = this.h) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                this.h.threadList.addAll(lu9.c(personPostModel.threadList));
            }
            this.p = E1(personPostModel, z);
            PersonPostModel personPostModel3 = this.h;
            if (personPostModel3 != null) {
                if (ListUtils.isEmpty(personPostModel3.threadList) && !BdNetTypeUtil.isNetWorkAvailable()) {
                    showNetRefreshView(this.k, null, false);
                    this.j.setVisibility(8);
                } else {
                    if (this.p) {
                        R1();
                    } else {
                        T1();
                    }
                    P1(this.h.threadList);
                }
            }
            zr9.d().l(System.currentTimeMillis() - currentTimeMillis);
            zr9.d().p(System.currentTimeMillis() - zr9.d().g());
        }
    }

    public void G1(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.h != null && this.i != null && (view2 = this.k) != null) {
            hideNetRefreshView(view2);
            this.j.setVisibility(0);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (z && x) {
                    showLoadingView(this.i);
                }
                O1(true);
                N1();
                return;
            }
            this.e.setEnabled(false);
            this.j.setVisibility(8);
            showNetRefreshView(this.k, null, false);
        }
    }

    public void Q1(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            if (ListUtils.isEmpty(arrayList)) {
                J1();
                if (this.f.getHeaderViewsCount() == 0) {
                    this.l.setVisibility(8);
                    this.b.setVisibility(8);
                    S1(R.string.nad_no_network);
                }
            } else {
                NoDataView noDataView = this.n;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f.removeHeaderView(this.n);
                }
            }
            this.g.j(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.e.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0304, i));
            SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.m.e(i);
            }
        }
    }

    public final void O1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048586, this, z) != null) || this.o) {
            return;
        }
        this.o = true;
        this.s = getIntent().getStringExtra("portrait");
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(ReportThemeActivityConfig.REPORT_TID_LIST);
        this.r = stringArrayListExtra;
        this.q = stringArrayListExtra.size();
        this.b.setText(getPageContext().getPageActivity().getString(R.string.choose_report_theme_num, new Object[]{Integer.valueOf(H1())}));
        this.b.setVisibility(8);
        this.l.setVisibility(8);
        this.e.setEnabled(false);
        this.h.fetchPost(getPageContext(), this.w, z, null, true, 0, false, true, null, this.s);
    }

    public final void S1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            String string = getResources().getString(R.string.no_data_common_txt);
            if (this.n == null) {
                this.n = NoDataViewFactory.a(this, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070386)), NoDataViewFactory.e.d(null, string), null);
            }
            this.n.f(getPageContext(), TbadkApplication.getInst().getSkinType());
            this.n.setVisibility(0);
            this.f.removeHeaderView(this.n);
            this.n.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f.addHeaderView(this.n);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            L1();
            this.i = findViewById(R.id.obfuscated_res_0x7f091fab);
            this.j = findViewById(R.id.obfuscated_res_0x7f09155f);
            this.k = findViewById(R.id.obfuscated_res_0x7f091564);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090704);
            this.f = (BdListView) findViewById(R.id.obfuscated_res_0x7f091f1b);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0907b3);
            fu9 fu9Var = new fu9(this, this.t);
            this.g = fu9Var;
            this.f.setAdapter((ListAdapter) fu9Var);
            this.f.setOnSrollToBottomListener(new c(this));
            MessageManager.getInstance().registerListener(y);
            PbListView pbListView = new PbListView(this);
            this.m = pbListView;
            pbListView.a();
            this.m.s(R.color.CAM_X0205);
            this.m.w(BdUtilHelper.getDimens(this, R.dimen.tbds182));
            this.m.B();
            this.m.L(R.dimen.tbfontsize33);
            this.m.J(SkinManager.getColor(R.color.CAM_X0107));
            this.m.F(R.color.CAM_X0110);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, view2, str, z) == null) {
            if (this.a == null) {
                zu9 zu9Var = new zu9(getPageContext().getPageActivity(), getNetRefreshListener());
                this.a = zu9Var;
                zu9Var.d(getPageContext().getResources().getString(R.string.refresh_view_title_text));
                this.a.c(null);
                this.a.b(getPageContext().getResources().getString(R.string.refresh_view_button_text));
                this.a.e();
                this.a.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.a.onChangeSkinType();
            this.a.attachView(view2, z);
        }
    }
}
