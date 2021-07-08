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
import d.a.c.e.p.l;
import d.a.p0.e3.j.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BarFolderFirstDirActivity extends ProxyAdkBaseActivity<BarFolderFirstDirActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String l = "st_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f21030e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.e3.j.a f21031f;

    /* renamed from: g  reason: collision with root package name */
    public b f21032g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f21033h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f21034i;
    public String j;
    public NavigationBar k;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BarFolderFirstDirActivity f21035e;

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
            this.f21035e = barFolderFirstDirActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            ArrayList<d> d2;
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (d2 = this.f21035e.f21031f.d()) == null || i2 >= d2.size() || (dVar = d2.get(i2)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f21035e.getPageContext().getPageActivity(), dVar.f56012b, dVar.f56011a, dVar.f56013c)));
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
        this.f21033h = null;
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
            this.f21033h.setOnItemClickListener(new a(this));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            navigationBar.setTitleText(getResources().getString(R.string.bar_first_dir_name));
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21033h = (ListView) findViewById(R.id.list);
            this.f21031f = new d.a.p0.e3.j.a(getPageContext().getPageActivity(), new d.a.p0.e3.j.b(), true);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds76)));
            this.f21033h.addHeaderView(textView);
            this.f21033h.setAdapter((ListAdapter) this.f21031f);
            this.f21030e = (ProgressBar) findViewById(R.id.progress);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.body_container);
            this.f21034i = viewGroup;
            ViewHelper.prepareNewView(viewGroup);
        }
    }

    public void j(d.a.p0.e3.j.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bVar, z) == null) {
            this.f21030e.setVisibility(8);
            this.f21033h.setEnabled(true);
            this.f21032g = null;
            if (z) {
                return;
            }
            if (bVar.c()) {
                showToast(bVar.b());
                return;
            }
            this.f21031f.e(bVar.h());
            this.f21033h.setVisibility(4);
            this.f21031f.notifyDataSetChanged();
            this.f21033h.setVisibility(0);
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
            this.f21030e.setVisibility(0);
            this.f21033h.setEnabled(false);
            b bVar = this.f21032g;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, null);
            this.f21032g = bVar2;
            bVar2.setPriority(3);
            this.f21032g.execute("");
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.k.onChangeSkinType(getPageContext(), i2);
            ListView listView = this.f21033h;
            if (listView != null) {
                listView.invalidateViews();
            }
            ViewGroup viewGroup = this.f21034i;
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
            b bVar = this.f21032g;
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
            this.f21031f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, d.a.p0.e3.j.b, d.a.p0.e3.j.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BarFolderFirstDirActivity f21037b;

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
            this.f21037b = barFolderFirstDirActivity;
            this.f21036a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(10:3|(3:23|24|(8:26|6|7|8|(1:10)|11|(2:13|(1:(1:16))(1:19))(1:20)|18))|5|6|7|8|(0)|11|(0)(0)|18) */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00bd, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
            r9.g(r0.getMessage());
            com.baidu.adp.lib.util.BdLog.e(r0.getMessage());
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: Exception -> 0x00bd, TryCatch #0 {Exception -> 0x00bd, blocks: (B:12:0x0034, B:14:0x0056, B:15:0x0063, B:17:0x0079, B:22:0x00ac, B:23:0x00b3), top: B:33:0x0034 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0079 A[Catch: Exception -> 0x00bd, TryCatch #0 {Exception -> 0x00bd, blocks: (B:12:0x0034, B:14:0x0056, B:15:0x0063, B:17:0x0079, B:22:0x00ac, B:23:0x00b3), top: B:33:0x0034 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b3 A[Catch: Exception -> 0x00bd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bd, blocks: (B:12:0x0034, B:14:0x0056, B:15:0x0063, B:17:0x0079, B:22:0x00ac, B:23:0x00b3), top: B:33:0x0034 }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d.a.p0.e3.j.b doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d.a.p0.e3.j.b bVar = new d.a.p0.e3.j.b();
                d.a.c.e.d.l<String> g2 = d.a.o0.r.r.a.f().g("tb.first_dir");
                String str = g2.get("first_dir_cache_key");
                boolean z = true;
                boolean z2 = false;
                if (str != null) {
                    if (!str.equals("")) {
                        bVar.e(str);
                        publishProgress(bVar);
                        z2 = z;
                        this.f21036a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                        if (this.f21037b.j != null) {
                            this.f21036a.addPostData(BarFolderFirstDirActivity.l, this.f21037b.j);
                        }
                        String postNetData = this.f21036a.postNetData();
                        if (!this.f21036a.getNetContext().getResponse().isRequestSuccess()) {
                            bVar.e(postNetData);
                            String trim = (postNetData + "").trim();
                            if (!trim.equals((str + "").trim())) {
                                g2.e("first_dir_cache_key", postNetData, 86400000L);
                            } else if (z2) {
                                return null;
                            }
                        } else {
                            bVar.g(this.f21036a.getErrorString());
                        }
                        return bVar;
                    }
                }
                z = false;
                z2 = z;
                this.f21036a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                if (this.f21037b.j != null) {
                }
                String postNetData2 = this.f21036a.postNetData();
                if (!this.f21036a.getNetContext().getResponse().isRequestSuccess()) {
                }
                return bVar;
            }
            return (d.a.p0.e3.j.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.p0.e3.j.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f21037b.j(bVar, false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f21036a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f21036a = null;
                }
                this.f21037b.j(null, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(d.a.p0.e3.j.b... bVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVarArr) == null) {
                super.onProgressUpdate(bVarArr);
                this.f21037b.j(bVarArr[0], false);
            }
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this(barFolderFirstDirActivity);
        }
    }
}
