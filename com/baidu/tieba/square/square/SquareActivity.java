package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ft4;
import com.repackage.ji;
import com.repackage.sd8;
import com.repackage.ts4;
import com.repackage.ud8;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class SquareActivity extends BaseActivity<Object> implements SwipeBackLayout.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_NAME = "square_page";
    public static boolean needRefresh;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasCacheData;
    public long initTime;
    public TbPageContext<Object> mContext;
    public final ft4.g mListPullRefreshListener;
    public NavigationBar mNavigationBar;
    public final NoNetworkView.b mNetworkChangeListener;
    public final View.OnKeyListener mOnKyeListener;
    public final SquareModel.a mOnLoadSquareDataCallback;
    public View mRootView;
    public SquareModel mSquareModel;
    public ud8 mView;
    public boolean needLoadCacheAtFirst;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public a(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SquareModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public b(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, sd8 sd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, sd8Var}) == null) {
                this.a.mView.h(true, "");
                SquareActivity squareActivity = this.a;
                squareActivity.hideLoadingView(squareActivity.mView.i());
                if (z && sd8Var != null && !sd8Var.g()) {
                    this.a.mView.l(this.a.mSquareModel.H());
                    this.a.hasCacheData = true;
                    this.a.mView.j();
                    this.a.removeNetWorkStateChangeListener();
                }
                if (this.a.needLoadCacheAtFirst) {
                    this.a.needLoadCacheAtFirst = false;
                    this.a.updateData(true);
                    if (!this.a.hasCacheData) {
                        this.a.mView.j();
                        SquareActivity squareActivity2 = this.a;
                        squareActivity2.showLoadingView(squareActivity2.mView.i());
                    }
                } else {
                    if (this.a.initTime > -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - this.a.initTime, this.a.mSquareModel.J() - this.a.initTime, this.a.mSquareModel.L(), this.a.mSquareModel.K(), currentTimeMillis - this.a.mSquareModel.I());
                        this.a.initTime = -1L;
                    }
                    if (!this.a.hasCacheData) {
                        if (ji.z()) {
                            this.a.mView.o(R.string.obfuscated_res_0x7f0f0c4d);
                        } else {
                            this.a.mView.o(R.string.obfuscated_res_0x7f0f078c);
                        }
                    }
                }
                if (!ji.z()) {
                    this.a.mView.g();
                    if (this.a.hasCacheData) {
                        return;
                    }
                    this.a.addNetWorkStateChangeListener();
                    return;
                }
                this.a.mContext.showToast(str);
                this.a.mView.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public c(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.updateData(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public d(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (view2 instanceof ListView) {
                    ListView listView = (ListView) view2;
                    if (keyEvent.getAction() == 0) {
                        if (i == 21) {
                            if (listView.getSelectedView() == null) {
                                listView.dispatchKeyEvent(new KeyEvent(0, 19));
                                return true;
                            }
                        } else if (i == 22 && listView.getSelectedView() == null) {
                            listView.dispatchKeyEvent(new KeyEvent(0, 20));
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ft4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SquareActivity a;

        public e(SquareActivity squareActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = squareActivity;
        }

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.updateData(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1521321087, "Lcom/baidu/tieba/square/square/SquareActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1521321087, "Lcom/baidu/tieba/square/square/SquareActivity;");
        }
    }

    public SquareActivity() {
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
        this.mView = null;
        this.mSquareModel = null;
        this.hasCacheData = false;
        this.needLoadCacheAtFirst = false;
        this.initTime = -1L;
        this.mOnLoadSquareDataCallback = new b(this);
        this.mNetworkChangeListener = new c(this);
        this.mOnKyeListener = new d(this);
        this.mListPullRefreshListener = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNetWorkStateChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mView.b(this.mNetworkChangeListener);
        }
    }

    private void cancelAllAsyncTask() {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (squareModel = this.mSquareModel) == null) {
            return;
        }
        squareModel.cancelLoadData();
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            SquareModel squareModel = new SquareModel(getPageContext());
            this.mSquareModel = squareModel;
            squareModel.P(this.mOnLoadSquareDataCallback);
            this.needLoadCacheAtFirst = true;
            updateData(true);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            ud8 ud8Var = new ud8(getPageContext(), this.mRootView, this.mOnKyeListener);
            this.mView = ud8Var;
            ud8Var.n(this.mListPullRefreshListener);
            NavigationBar navigationBar = (NavigationBar) this.mContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.mNavigationBar.setTitleText(this.mContext.getString(R.string.obfuscated_res_0x7f0f02c1));
        }
    }

    public static String makeStatisticsParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("square_page");
            try {
                sb.append(URLEncoder.encode("|", IMAudioTransRequest.CHARSET));
            } catch (Exception e2) {
                e2.printStackTrace();
                sb.append("|");
            }
            sb.append(str + "_" + str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNetWorkStateChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mView.m(this.mNetworkChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateData(boolean z) {
        SquareModel squareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65556, this, z) == null) || (squareModel = this.mSquareModel) == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.H() == null || this.mSquareModel.H().g();
        boolean z4 = z;
        if (!ji.z()) {
            this.needLoadCacheAtFirst = false;
            z4 = false;
            z3 = true;
        }
        if (this.needLoadCacheAtFirst) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            cancelAllAsyncTask();
            if (z2) {
                this.mSquareModel.O();
            } else {
                this.mSquareModel.N();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!getIntent().getBooleanExtra("back_special", false)) {
                finish();
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                ts4.e(getActivity(), 1);
            } else {
                ts4.e(getActivity(), 2);
            }
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            ud8 ud8Var = this.mView;
            if (ud8Var != null) {
                ud8Var.onChangeSkinType(i);
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getPageContext();
            this.initTime = System.currentTimeMillis();
            this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0794, (ViewGroup) null);
            getPageContext().getPageActivity().setContentView(this.mRootView);
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            cancelAllAsyncTask();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (needRefresh) {
                updateData(true);
                needRefresh = false;
            }
        }
    }
}
