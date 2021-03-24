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
import com.baidu.platform.comapi.walknavi.fsm.RGState;
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
import d.b.b.e.p.l;
import d.b.i0.z2.j.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BarFolderFirstDirActivity extends ProxyAdkBaseActivity<BarFolderFirstDirActivity> {
    public static String l = "st_type";

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f21247e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.z2.j.a f21248f;

    /* renamed from: g  reason: collision with root package name */
    public b f21249g;
    public ViewGroup i;
    public NavigationBar k;

    /* renamed from: h  reason: collision with root package name */
    public ListView f21250h = null;
    public String j = null;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar;
            ArrayList<d> d2 = BarFolderFirstDirActivity.this.f21248f.d();
            if (d2 == null || i >= d2.size() || (dVar = d2.get(i)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(BarFolderFirstDirActivity.this.getPageContext().getPageActivity(), dVar.f63542b, dVar.f63541a, dVar.f63543c)));
        }
    }

    public static void k(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(l, str);
        activity.startActivity(intent);
    }

    public void h() {
        this.f21250h.setOnItemClickListener(new a());
    }

    public void i() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.k = navigationBar;
        navigationBar.setTitleText(getResources().getString(R.string.bar_first_dir_name));
        this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21250h = (ListView) findViewById(R.id.list);
        this.f21248f = new d.b.i0.z2.j.a(getPageContext().getPageActivity(), new d.b.i0.z2.j.b(), true);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds76)));
        this.f21250h.addHeaderView(textView);
        this.f21250h.setAdapter((ListAdapter) this.f21248f);
        this.f21247e = (ProgressBar) findViewById(R.id.progress);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.body_container);
        this.i = viewGroup;
        ViewHelper.prepareNewView(viewGroup);
    }

    public void j(d.b.i0.z2.j.b bVar, boolean z) {
        this.f21247e.setVisibility(8);
        this.f21250h.setEnabled(true);
        this.f21249g = null;
        if (z) {
            return;
        }
        if (bVar.c()) {
            showToast(bVar.b());
            return;
        }
        this.f21248f.e(bVar.h());
        this.f21250h.setVisibility(4);
        this.f21248f.notifyDataSetChanged();
        this.f21250h.setVisibility(0);
    }

    public void l(Bundle bundle) {
        if (bundle != null) {
            this.j = bundle.getString(l);
        } else {
            this.j = getIntent().getStringExtra(l);
        }
        this.f21247e.setVisibility(0);
        this.f21250h.setEnabled(false);
        b bVar = this.f21249g;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(this, null);
        this.f21249g = bVar2;
        bVar2.setPriority(3);
        this.f21249g.execute("");
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.k.onChangeSkinType(getPageContext(), i);
        ListView listView = this.f21250h;
        if (listView != null) {
            listView.invalidateViews();
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            ViewHelper.processSkin(viewGroup, i);
        }
        SkinManager.setFrsPBBgColor(findViewById(R.id.root_view), i);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        i();
        l(bundle);
        h();
        TiebaStatic.eventStat(getPageContext().getContext(), "category_1", RGState.METHOD_NAME_ENTER);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f21249g;
        if (bVar != null) {
            bVar.cancel();
        }
        j(null, true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        this.f21248f.notifyDataSetChanged();
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, d.b.i0.z2.j.b, d.b.i0.z2.j.b> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21252a;

        public b() {
            this.f21252a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:21|22|(8:24|4|5|6|(1:8)|9|(2:11|(1:(1:14))(1:17))(1:18)|16))|3|4|5|6|(0)|9|(0)(0)|16) */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b9, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00ba, code lost:
            r9.g(r0.getMessage());
            com.baidu.adp.lib.util.BdLog.e(r0.getMessage());
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0052 A[Catch: Exception -> 0x00b9, TryCatch #1 {Exception -> 0x00b9, blocks: (B:10:0x0030, B:12:0x0052, B:13:0x005f, B:15:0x0075, B:20:0x00a8, B:21:0x00af), top: B:29:0x0030 }] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0075 A[Catch: Exception -> 0x00b9, TryCatch #1 {Exception -> 0x00b9, blocks: (B:10:0x0030, B:12:0x0052, B:13:0x005f, B:15:0x0075, B:20:0x00a8, B:21:0x00af), top: B:29:0x0030 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[Catch: Exception -> 0x00b9, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b9, blocks: (B:10:0x0030, B:12:0x0052, B:13:0x005f, B:15:0x0075, B:20:0x00a8, B:21:0x00af), top: B:29:0x0030 }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d.b.i0.z2.j.b doInBackground(Object... objArr) {
            d.b.i0.z2.j.b bVar = new d.b.i0.z2.j.b();
            d.b.b.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.first_dir");
            String str = g2.get("first_dir_cache_key");
            boolean z = true;
            boolean z2 = false;
            if (str != null) {
                if (!str.equals("")) {
                    bVar.e(str);
                    publishProgress(bVar);
                    z2 = z;
                    this.f21252a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                    if (BarFolderFirstDirActivity.this.j != null) {
                        this.f21252a.addPostData(BarFolderFirstDirActivity.l, BarFolderFirstDirActivity.this.j);
                    }
                    String postNetData = this.f21252a.postNetData();
                    if (!this.f21252a.getNetContext().getResponse().isRequestSuccess()) {
                        bVar.e(postNetData);
                        String trim = (postNetData + "").trim();
                        if (!trim.equals((str + "").trim())) {
                            g2.e("first_dir_cache_key", postNetData, 86400000L);
                        } else if (z2) {
                            return null;
                        }
                    } else {
                        bVar.g(this.f21252a.getErrorString());
                    }
                    return bVar;
                }
            }
            z = false;
            z2 = z;
            this.f21252a = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
            if (BarFolderFirstDirActivity.this.j != null) {
            }
            String postNetData2 = this.f21252a.postNetData();
            if (!this.f21252a.getNetContext().getResponse().isRequestSuccess()) {
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.b.i0.z2.j.b bVar) {
            if (bVar != null) {
                BarFolderFirstDirActivity.this.j(bVar, false);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f21252a;
            if (netWork != null) {
                netWork.cancelNetConnect();
                this.f21252a = null;
            }
            BarFolderFirstDirActivity.this.j(null, true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(d.b.i0.z2.j.b... bVarArr) {
            super.onProgressUpdate(bVarArr);
            BarFolderFirstDirActivity.this.j(bVarArr[0], false);
        }

        public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
            this();
        }
    }
}
