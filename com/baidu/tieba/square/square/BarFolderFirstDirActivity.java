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
import b.a.e.e.p.l;
import b.a.r0.i3.j.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
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
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class BarFolderFirstDirActivity extends ProxyAdkBaseActivity<BarFolderFirstDirActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String l = "st_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f54098e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.i3.j.a f54099f;

    /* renamed from: g  reason: collision with root package name */
    public b f54100g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f54101h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f54102i;
    public String j;
    public NavigationBar k;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BarFolderFirstDirActivity f54103e;

        public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barFolderFirstDirActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54103e = barFolderFirstDirActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            ArrayList<d> c2;
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (c2 = this.f54103e.f54099f.c()) == null || i2 >= c2.size() || (dVar = c2.get(i2)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f54103e.getPageContext().getPageActivity(), dVar.f18098b, dVar.f18097a, dVar.f18099c)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54101h = null;
        this.j = null;
    }

    public static void k(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str) == null) {
            Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
            intent.putExtra(l, str);
            activity.startActivity(intent);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54101h.setOnItemClickListener(new a(this));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            navigationBar.setTitleText(getResources().getString(R.string.bar_first_dir_name));
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f54101h = (ListView) findViewById(R.id.list);
            this.f54099f = new b.a.r0.i3.j.a(getPageContext().getPageActivity(), new b.a.r0.i3.j.b(), true);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds76)));
            this.f54101h.addHeaderView(textView);
            this.f54101h.setAdapter((ListAdapter) this.f54099f);
            this.f54098e = (ProgressBar) findViewById(R.id.progress);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.body_container);
            this.f54102i = viewGroup;
            ViewHelper.prepareNewView(viewGroup);
        }
    }

    public void j(b.a.r0.i3.j.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bVar, z) == null) {
            this.f54098e.setVisibility(8);
            this.f54101h.setEnabled(true);
            this.f54100g = null;
            if (z) {
                return;
            }
            if (bVar.c()) {
                showToast(bVar.b());
                return;
            }
            this.f54099f.d(bVar.h());
            this.f54101h.setVisibility(4);
            this.f54099f.notifyDataSetChanged();
            this.f54101h.setVisibility(0);
        }
    }

    public void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (bundle != null) {
                this.j = bundle.getString(l);
            } else {
                this.j = getIntent().getStringExtra(l);
            }
            this.f54098e.setVisibility(0);
            this.f54101h.setEnabled(false);
            b bVar = this.f54100g;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.f54100g = bVar2;
            bVar2.setPriority(3);
            this.f54100g.execute("");
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.k.onChangeSkinType(getPageContext(), i2);
            ListView listView = this.f54101h;
            if (listView != null) {
                listView.invalidateViews();
            }
            ViewGroup viewGroup = this.f54102i;
            if (viewGroup != null) {
                ViewHelper.processSkin(viewGroup, i2);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.root_view), i2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.bar_folder_dir_activity);
            i();
            l(bundle);
            h();
            TiebaStatic.eventStat(getPageContext().getContext(), "category_1", "enter");
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            b bVar = this.f54100g;
            if (bVar != null) {
                bVar.cancel();
            }
            j(null, true);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            this.f54099f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, b.a.r0.i3.j.b, b.a.r0.i3.j.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BarFolderFirstDirActivity f54105b;

        public b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barFolderFirstDirActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54105b = barFolderFirstDirActivity;
            this.f54104a = null;
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
        public b.a.r0.i3.j.b doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                b.a.r0.i3.j.b bVar = new b.a.r0.i3.j.b();
                b.a.q0.s.r.a.f();
                b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.first_dir");
                String str = g2.get("first_dir_cache_key");
                boolean z = true;
                boolean z2 = false;
                if (str != null) {
                    if (!str.equals("")) {
                        bVar.e(str);
                        publishProgress(bVar);
                        z2 = z;
                        this.f54104a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                        if (this.f54105b.j != null) {
                            this.f54104a.addPostData(BarFolderFirstDirActivity.l, this.f54105b.j);
                        }
                        String postNetData = this.f54104a.postNetData();
                        if (!this.f54104a.getNetContext().getResponse().isRequestSuccess()) {
                            bVar.e(postNetData);
                            String trim = (postNetData + "").trim();
                            if (!trim.equals((str + "").trim())) {
                                g2.e("first_dir_cache_key", postNetData, 86400000L);
                            } else if (z2) {
                                return null;
                            }
                        } else {
                            bVar.g(this.f54104a.getErrorString());
                        }
                        return bVar;
                    }
                }
                z = false;
                z2 = z;
                this.f54104a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                if (this.f54105b.j != null) {
                }
                String postNetData2 = this.f54104a.postNetData();
                if (!this.f54104a.getNetContext().getResponse().isRequestSuccess()) {
                }
                return bVar;
            }
            return (b.a.r0.i3.j.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(b.a.r0.i3.j.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f54105b.j(bVar, false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f54104a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f54104a = null;
                }
                this.f54105b.j(null, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(b.a.r0.i3.j.b... bVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVarArr) == null) {
                super.onProgressUpdate(bVarArr);
                this.f54105b.j(bVarArr[0], false);
            }
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this(barFolderFirstDirActivity);
        }
    }
}
