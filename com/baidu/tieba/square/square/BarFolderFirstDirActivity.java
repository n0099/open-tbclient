package com.baidu.tieba.square.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mg8;
import com.repackage.mi;
import com.repackage.mr4;
import com.repackage.ng8;
import com.repackage.pg8;
import com.repackage.qe;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BarFolderFirstDirActivity extends BaseActivity<BarFolderFirstDirActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String URL_ST_TYPE = "st_type";
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup bodyContainer;
    public mg8 listAdapter;
    public ListView mList;
    public NavigationBar mNavigationBar;
    public ProgressBar progress;
    public b runningTask;
    public String stType;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BarFolderFirstDirActivity a;

        public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barFolderFirstDirActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = barFolderFirstDirActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ArrayList<pg8> c;
            pg8 pg8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (c = this.a.listAdapter.c()) == null || i >= c.size() || (pg8Var = c.get(i)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.a.getPageContext().getPageActivity(), pg8Var.b, pg8Var.a, pg8Var.c)));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1934629092, "Lcom/baidu/tieba/square/square/BarFolderFirstDirActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1934629092, "Lcom/baidu/tieba/square/square/BarFolderFirstDirActivity;");
        }
    }

    public BarFolderFirstDirActivity() {
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
        this.mList = null;
        this.stType = null;
    }

    public static void startBarFolderFirstDirActivity(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str) == null) {
            Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
            intent.putExtra(URL_ST_TYPE, str);
            activity.startActivity(intent);
        }
    }

    public void bindEvents() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mList.setOnItemClickListener(new a(this));
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.mNavigationBar = navigationBar;
            navigationBar.setTitleText(getResources().getString(R.string.obfuscated_res_0x7f0f02d4));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mList = (ListView) findViewById(R.id.obfuscated_res_0x7f09127a);
            this.listAdapter = new mg8(getPageContext().getPageActivity(), new ng8(), true);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + mi.f(getActivity(), R.dimen.obfuscated_res_0x7f07026f)));
            this.mList.addHeaderView(textView);
            this.mList.setAdapter((ListAdapter) this.listAdapter);
            this.progress = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091975);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090394);
            this.bodyContainer = viewGroup;
            ViewHelper.prepareNewView(viewGroup);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            ListView listView = this.mList;
            if (listView != null) {
                listView.invalidateViews();
            }
            ViewGroup viewGroup = this.bodyContainer;
            if (viewGroup != null) {
                ViewHelper.processSkin(viewGroup, i);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.obfuscated_res_0x7f091b2c), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0134);
            initUI();
            syncDataOnUI(bundle);
            bindEvents();
            TiebaStatic.eventStat(getPageContext().getContext(), "category_1", "enter");
        }
    }

    public void onDataReadyFromUIThread(ng8 ng8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, ng8Var, z) == null) {
            this.progress.setVisibility(8);
            this.mList.setEnabled(true);
            this.runningTask = null;
            if (z) {
                return;
            }
            if (ng8Var.c()) {
                showToast(ng8Var.b());
                return;
            }
            this.listAdapter.d(ng8Var.h());
            this.mList.setVisibility(4);
            this.listAdapter.notifyDataSetChanged();
            this.mList.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            b bVar = this.runningTask;
            if (bVar != null) {
                bVar.cancel();
            }
            onDataReadyFromUIThread(null, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.listAdapter.notifyDataSetChanged();
        }
    }

    public void syncDataOnUI(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (bundle != null) {
                this.stType = bundle.getString(URL_ST_TYPE);
            } else {
                this.stType = getIntent().getStringExtra(URL_ST_TYPE);
            }
            this.progress.setVisibility(0);
            this.mList.setEnabled(false);
            b bVar = this.runningTask;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.runningTask = bVar2;
            bVar2.setPriority(3);
            this.runningTask.execute("");
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, ng8, ng8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ BarFolderFirstDirActivity b;

        public b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barFolderFirstDirActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = barFolderFirstDirActivity;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(10:3|(3:23|24|(8:26|6|7|8|(1:10)|11|(2:13|(1:(1:16))(1:19))(1:20)|18))|5|6|7|8|(0)|11|(0)(0)|18) */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00bc, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00bd, code lost:
            r9.g(r0.getMessage());
            com.baidu.adp.lib.util.BdLog.e(r0.getMessage());
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:12:0x0033, B:14:0x0055, B:15:0x0062, B:17:0x0078, B:22:0x00ab, B:23:0x00b2), top: B:33:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:12:0x0033, B:14:0x0055, B:15:0x0062, B:17:0x0078, B:22:0x00ab, B:23:0x00b2), top: B:33:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b2 A[Catch: Exception -> 0x00bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bc, blocks: (B:12:0x0033, B:14:0x0055, B:15:0x0062, B:17:0x0078, B:22:0x00ab, B:23:0x00b2), top: B:33:0x0033 }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ng8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                ng8 ng8Var = new ng8();
                mr4.f();
                qe<String> g = mr4.g("tb.first_dir");
                String str = g.get("first_dir_cache_key");
                boolean z = true;
                boolean z2 = false;
                if (str != null) {
                    if (!str.equals("")) {
                        ng8Var.e(str);
                        publishProgress(ng8Var);
                        z2 = z;
                        this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                        if (this.b.stType != null) {
                            this.a.addPostData(BarFolderFirstDirActivity.URL_ST_TYPE, this.b.stType);
                        }
                        String postNetData = this.a.postNetData();
                        if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                            ng8Var.e(postNetData);
                            String trim = (postNetData + "").trim();
                            if (!trim.equals((str + "").trim())) {
                                g.e("first_dir_cache_key", postNetData, 86400000L);
                            } else if (z2) {
                                return null;
                            }
                        } else {
                            ng8Var.g(this.a.getErrorString());
                        }
                        return ng8Var;
                    }
                }
                z = false;
                z2 = z;
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                if (this.b.stType != null) {
                }
                String postNetData2 = this.a.postNetData();
                if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                }
                return ng8Var;
            }
            return (ng8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ng8 ng8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ng8Var) == null) || ng8Var == null) {
                return;
            }
            this.b.onDataReadyFromUIThread(ng8Var, false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                this.b.onDataReadyFromUIThread(null, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ng8... ng8VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ng8VarArr) == null) {
                super.onProgressUpdate(ng8VarArr);
                this.b.onDataReadyFromUIThread(ng8VarArr[0], false);
            }
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this(barFolderFirstDirActivity);
        }
    }
}
