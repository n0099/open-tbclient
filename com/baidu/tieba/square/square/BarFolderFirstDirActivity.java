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
import com.repackage.bi8;
import com.repackage.ci8;
import com.repackage.ei8;
import com.repackage.qi;
import com.repackage.tr4;
import com.repackage.ue;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BarFolderFirstDirActivity extends BaseActivity<BarFolderFirstDirActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String h = "st_type";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar a;
    public bi8 b;
    public b c;
    public ListView d;
    public ViewGroup e;
    public String f;
    public NavigationBar g;

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
            ArrayList<ei8> c;
            ei8 ei8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (c = this.a.b.c()) == null || i >= c.size() || (ei8Var = c.get(i)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.a.getPageContext().getPageActivity(), ei8Var.b, ei8Var.a, ei8Var.c)));
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
        this.d = null;
        this.f = null;
    }

    public static void E1(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, str) == null) {
            Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
            intent.putExtra(h, str);
            activity.startActivity(intent);
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setOnItemClickListener(new a(this));
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09255c);
            this.g = navigationBar;
            navigationBar.setTitleText(getResources().getString(R.string.obfuscated_res_0x7f0f02de));
            this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (ListView) findViewById(R.id.obfuscated_res_0x7f091308);
            this.b = new bi8(getPageContext().getPageActivity(), new ci8(), true);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + qi.f(getActivity(), R.dimen.obfuscated_res_0x7f07026f)));
            this.d.addHeaderView(textView);
            this.d.setAdapter((ListAdapter) this.b);
            this.a = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091a78);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0903a9);
            this.e = viewGroup;
            ViewHelper.prepareNewView(viewGroup);
        }
    }

    public void D1(ci8 ci8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ci8Var, z) == null) {
            this.a.setVisibility(8);
            this.d.setEnabled(true);
            this.c = null;
            if (z) {
                return;
            }
            if (ci8Var.c()) {
                showToast(ci8Var.b());
                return;
            }
            this.b.d(ci8Var.h());
            this.d.setVisibility(4);
            this.b.notifyDataSetChanged();
            this.d.setVisibility(0);
        }
    }

    public void F1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (bundle != null) {
                this.f = bundle.getString(h);
            } else {
                this.f = getIntent().getStringExtra(h);
            }
            this.a.setVisibility(0);
            this.d.setEnabled(false);
            b bVar = this.c;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.c = bVar2;
            bVar2.setPriority(3);
            this.c.execute("");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.g.onChangeSkinType(getPageContext(), i);
            ListView listView = this.d;
            if (listView != null) {
                listView.invalidateViews();
            }
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                ViewHelper.processSkin(viewGroup, i);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.obfuscated_res_0x7f091c31), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0131);
            C1();
            F1(bundle);
            B1();
            TiebaStatic.eventStat(getPageContext().getContext(), "category_1", "enter");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            b bVar = this.c;
            if (bVar != null) {
                bVar.cancel();
            }
            D1(null, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            this.b.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, ci8, ci8> {
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
        public ci8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                ci8 ci8Var = new ci8();
                tr4.f();
                ue<String> g = tr4.g("tb.first_dir");
                String str = g.get("first_dir_cache_key");
                boolean z = true;
                boolean z2 = false;
                if (str != null) {
                    if (!str.equals("")) {
                        ci8Var.e(str);
                        publishProgress(ci8Var);
                        z2 = z;
                        this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                        if (this.b.f != null) {
                            this.a.addPostData(BarFolderFirstDirActivity.h, this.b.f);
                        }
                        String postNetData = this.a.postNetData();
                        if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                            ci8Var.e(postNetData);
                            String trim = (postNetData + "").trim();
                            if (!trim.equals((str + "").trim())) {
                                g.e("first_dir_cache_key", postNetData, 86400000L);
                            } else if (z2) {
                                return null;
                            }
                        } else {
                            ci8Var.g(this.a.getErrorString());
                        }
                        return ci8Var;
                    }
                }
                z = false;
                z2 = z;
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                if (this.b.f != null) {
                }
                String postNetData2 = this.a.postNetData();
                if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                }
                return ci8Var;
            }
            return (ci8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ci8 ci8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ci8Var) == null) || ci8Var == null) {
                return;
            }
            this.b.D1(ci8Var, false);
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
                this.b.D1(null, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ci8... ci8VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ci8VarArr) == null) {
                super.onProgressUpdate(ci8VarArr);
                this.b.D1(ci8VarArr[0], false);
            }
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this(barFolderFirstDirActivity);
        }
    }
}
