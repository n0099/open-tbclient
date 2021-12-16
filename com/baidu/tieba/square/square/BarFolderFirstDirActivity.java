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
import c.a.d.f.d.l;
import c.a.d.f.p.m;
import c.a.s0.s3.j.d;
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
/* loaded from: classes12.dex */
public class BarFolderFirstDirActivity extends ProxyAdkBaseActivity<BarFolderFirstDirActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String l = "st_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f49660e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.s3.j.a f49661f;

    /* renamed from: g  reason: collision with root package name */
    public b f49662g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f49663h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f49664i;

    /* renamed from: j  reason: collision with root package name */
    public String f49665j;

    /* renamed from: k  reason: collision with root package name */
    public NavigationBar f49666k;

    /* loaded from: classes12.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BarFolderFirstDirActivity f49667e;

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
            this.f49667e = barFolderFirstDirActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            ArrayList<d> c2;
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (c2 = this.f49667e.f49661f.c()) == null || i2 >= c2.size() || (dVar = c2.get(i2)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f49667e.getPageContext().getPageActivity(), dVar.f23693b, dVar.a, dVar.f23694c)));
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
        this.f49663h = null;
        this.f49665j = null;
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
            this.f49663h.setOnItemClickListener(new a(this));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.f49666k = navigationBar;
            navigationBar.setTitleText(getResources().getString(R.string.bar_first_dir_name));
            this.f49666k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f49663h = (ListView) findViewById(R.id.list);
            this.f49661f = new c.a.s0.s3.j.a(getPageContext().getPageActivity(), new c.a.s0.s3.j.b(), true);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + m.f(getActivity(), R.dimen.ds76)));
            this.f49663h.addHeaderView(textView);
            this.f49663h.setAdapter((ListAdapter) this.f49661f);
            this.f49660e = (ProgressBar) findViewById(R.id.progress);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.body_container);
            this.f49664i = viewGroup;
            ViewHelper.prepareNewView(viewGroup);
        }
    }

    public void j(c.a.s0.s3.j.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bVar, z) == null) {
            this.f49660e.setVisibility(8);
            this.f49663h.setEnabled(true);
            this.f49662g = null;
            if (z) {
                return;
            }
            if (bVar.c()) {
                showToast(bVar.b());
                return;
            }
            this.f49661f.d(bVar.h());
            this.f49663h.setVisibility(4);
            this.f49661f.notifyDataSetChanged();
            this.f49663h.setVisibility(0);
        }
    }

    public void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (bundle != null) {
                this.f49665j = bundle.getString(l);
            } else {
                this.f49665j = getIntent().getStringExtra(l);
            }
            this.f49660e.setVisibility(0);
            this.f49663h.setEnabled(false);
            b bVar = this.f49662g;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.f49662g = bVar2;
            bVar2.setPriority(3);
            this.f49662g.execute("");
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f49666k.onChangeSkinType(getPageContext(), i2);
            ListView listView = this.f49663h;
            if (listView != null) {
                listView.invalidateViews();
            }
            ViewGroup viewGroup = this.f49664i;
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
            b bVar = this.f49662g;
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
            this.f49661f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes12.dex */
    public class b extends BdAsyncTask<Object, c.a.s0.s3.j.b, c.a.s0.s3.j.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BarFolderFirstDirActivity f49668b;

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
            this.f49668b = barFolderFirstDirActivity;
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
        public c.a.s0.s3.j.b doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                c.a.s0.s3.j.b bVar = new c.a.s0.s3.j.b();
                c.a.r0.s.s.a.f();
                l<String> g2 = c.a.r0.s.s.a.g("tb.first_dir");
                String str = g2.get("first_dir_cache_key");
                boolean z = true;
                boolean z2 = false;
                if (str != null) {
                    if (!str.equals("")) {
                        bVar.e(str);
                        publishProgress(bVar);
                        z2 = z;
                        this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                        if (this.f49668b.f49665j != null) {
                            this.a.addPostData(BarFolderFirstDirActivity.l, this.f49668b.f49665j);
                        }
                        String postNetData = this.a.postNetData();
                        if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                            bVar.e(postNetData);
                            String trim = (postNetData + "").trim();
                            if (!trim.equals((str + "").trim())) {
                                g2.e("first_dir_cache_key", postNetData, 86400000L);
                            } else if (z2) {
                                return null;
                            }
                        } else {
                            bVar.g(this.a.getErrorString());
                        }
                        return bVar;
                    }
                }
                z = false;
                z2 = z;
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                if (this.f49668b.f49665j != null) {
                }
                String postNetData2 = this.a.postNetData();
                if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                }
                return bVar;
            }
            return (c.a.s0.s3.j.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.s0.s3.j.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f49668b.j(bVar, false);
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
                this.f49668b.j(null, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(c.a.s0.s3.j.b... bVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVarArr) == null) {
                super.onProgressUpdate(bVarArr);
                this.f49668b.j(bVarArr[0], false);
            }
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this(barFolderFirstDirActivity);
        }
    }
}
