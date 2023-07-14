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
import com.baidu.tieba.l9a;
import com.baidu.tieba.m9a;
import com.baidu.tieba.o55;
import com.baidu.tieba.o9a;
import com.baidu.tieba.ye;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class BarFolderFirstDirActivity extends BaseActivity<BarFolderFirstDirActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String h = "st_type";
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar a;
    public l9a b;
    public b c;
    public ListView d;
    public ViewGroup e;
    public String f;
    public NavigationBar g;

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

    /* loaded from: classes7.dex */
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
            ArrayList<o9a> c;
            o9a o9aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (c = this.a.b.c()) == null || i >= c.size() || (o9aVar = c.get(i)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.a.getPageContext().getPageActivity(), o9aVar.b, o9aVar.a, o9aVar.c)));
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, m9a, m9a> {
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
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(m9a m9aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m9aVar) == null) && m9aVar != null) {
                this.b.y1(m9aVar, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(m9a... m9aVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, m9aVarArr) == null) {
                super.onProgressUpdate(m9aVarArr);
                this.b.y1(m9aVarArr[0], false);
            }
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this(barFolderFirstDirActivity);
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
        public m9a doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                m9a m9aVar = new m9a();
                o55.e();
                ye<String> f = o55.f("tb.first_dir");
                String str = f.get("first_dir_cache_key");
                boolean z = true;
                boolean z2 = false;
                if (str != null) {
                    if (!str.equals("")) {
                        m9aVar.e(str);
                        publishProgress(m9aVar);
                        z2 = z;
                        this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                        if (this.b.f != null) {
                            this.a.addPostData(BarFolderFirstDirActivity.h, this.b.f);
                        }
                        String postNetData = this.a.postNetData();
                        if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                            m9aVar.e(postNetData);
                            String trim = (postNetData + "").trim();
                            if (trim.equals((str + "").trim())) {
                                if (z2) {
                                    return null;
                                }
                            } else {
                                f.e("first_dir_cache_key", postNetData, 86400000L);
                            }
                        } else {
                            m9aVar.g(this.a.getErrorString());
                        }
                        return m9aVar;
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
                return m9aVar;
            }
            return (m9a) invokeL.objValue;
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
                this.b.y1(null, true);
            }
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            b bVar = this.c;
            if (bVar != null) {
                bVar.cancel();
            }
            y1(null, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            this.b.notifyDataSetChanged();
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.setOnItemClickListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d013d);
            x1();
            A1(bundle);
            w1();
            TiebaStatic.eventStat(getPageContext().getContext(), "category_1", "enter");
        }
    }

    public static void z1(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str) == null) {
            Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
            intent.putExtra(h, str);
            activity.startActivity(intent);
        }
    }

    public void A1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
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
            SkinManager.setFrsPBBgColor(findViewById(R.id.obfuscated_res_0x7f091f6a), i);
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.g = navigationBar;
            navigationBar.setTitleText(getResources().getString(R.string.obfuscated_res_0x7f0f031d));
            this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (ListView) findViewById(R.id.obfuscated_res_0x7f09151f);
            this.b = new l9a(getPageContext().getPageActivity(), new m9a(), true);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + yi.g(getActivity(), R.dimen.obfuscated_res_0x7f07026f)));
            this.d.addHeaderView(textView);
            this.d.setAdapter((ListAdapter) this.b);
            this.a = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091d48);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09040f);
            this.e = viewGroup;
            ViewHelper.prepareNewView(viewGroup);
        }
    }

    public void y1(m9a m9aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, m9aVar, z) == null) {
            this.a.setVisibility(8);
            this.d.setEnabled(true);
            this.c = null;
            if (z) {
                return;
            }
            if (m9aVar.c()) {
                showToast(m9aVar.b());
                return;
            }
            this.b.d(m9aVar.h());
            this.d.setVisibility(4);
            this.b.notifyDataSetChanged();
            this.d.setVisibility(0);
        }
    }
}
