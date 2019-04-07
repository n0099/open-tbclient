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
import com.baidu.adp.lib.util.l;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BarFolderFirstDirActivity extends ProxyAdkBaseActivity<BarFolderFirstDirActivity> {
    public static String iBs = "st_type";
    private ProgressBar iBo;
    private com.baidu.tieba.square.square.a iBp;
    private a iBq;
    protected ViewGroup iBr;
    private NavigationBar mNavigationBar;
    protected ListView mList = null;
    private String stType = null;

    public static void h(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(iBs, str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.bar_folder_dir_activity);
        initUI();
        ag(bundle);
        ccX();
        TiebaStatic.eventStat(getPageContext().getContext(), "category_1", RGState.METHOD_NAME_ENTER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        this.iBp.notifyDataSetChanged();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getResources().getString(d.j.bar_first_dir_name));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mList = (ListView) findViewById(d.g.list);
        this.iBp = new com.baidu.tieba.square.square.a(getPageContext().getPageActivity(), new b(), true);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(getActivity(), d.e.ds76)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.iBp);
        this.iBo = (ProgressBar) findViewById(d.g.progress);
        this.iBr = (ViewGroup) findViewById(d.g.body_container);
        bc.aD(this.iBr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iBq != null) {
            this.iBq.cancel();
        }
        a(null, true);
    }

    protected void ccX() {
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.square.BarFolderFirstDirActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d dVar;
                ArrayList<d> ccY = BarFolderFirstDirActivity.this.iBp.ccY();
                if (ccY != null && i < ccY.size() && (dVar = ccY.get(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(BarFolderFirstDirActivity.this.getPageContext().getPageActivity(), dVar.izp, dVar.izq, dVar.izr)));
                }
            }
        });
    }

    protected void ag(Bundle bundle) {
        if (bundle != null) {
            this.stType = bundle.getString(iBs);
        } else {
            this.stType = getIntent().getStringExtra(iBs);
        }
        this.iBo.setVisibility(0);
        this.mList.setEnabled(false);
        if (this.iBq != null) {
            this.iBq.cancel();
        }
        this.iBq = new a();
        this.iBq.setPriority(3);
        this.iBq.execute("");
    }

    protected void a(b bVar, boolean z) {
        this.iBo.setVisibility(8);
        this.mList.setEnabled(true);
        this.iBq = null;
        if (!z) {
            if (bVar.isFailed()) {
                showToast(bVar.getErrorMsg());
                return;
            }
            this.iBp.az(bVar.ccY());
            this.mList.setVisibility(4);
            this.iBp.notifyDataSetChanged();
            this.mList.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mList != null) {
            this.mList.invalidateViews();
        }
        if (this.iBr != null) {
            bc.c(this.iBr, i);
        }
        al.h(findViewById(d.g.root_view), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, b, b> {
        private x mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(b... bVarArr) {
            super.onProgressUpdate(bVarArr);
            BarFolderFirstDirActivity.this.a(bVarArr[0], false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't wrap try/catch for region: R(11:1|(3:22|23|(9:25|4|5|6|(1:8)|9|(2:11|(1:(1:14))(1:18))(1:19)|16|17))|3|4|5|6|(0)|9|(0)(0)|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00cd, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00ce, code lost:
            r3.setErrorMsg(r0.getMessage());
            com.baidu.adp.lib.util.BdLog.e(r0.getMessage());
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0058 A[Catch: Exception -> 0x00cd, TryCatch #0 {Exception -> 0x00cd, blocks: (B:8:0x0033, B:10:0x0058, B:11:0x0065, B:13:0x007b, B:18:0x00b8, B:20:0x00c3), top: B:27:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x007b A[Catch: Exception -> 0x00cd, TryCatch #0 {Exception -> 0x00cd, blocks: (B:8:0x0033, B:10:0x0058, B:11:0x0065, B:13:0x007b, B:18:0x00b8, B:20:0x00c3), top: B:27:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c3 A[Catch: Exception -> 0x00cd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cd, blocks: (B:8:0x0033, B:10:0x0058, B:11:0x0065, B:13:0x007b, B:18:0x00b8, B:20:0x00c3), top: B:27:0x0033 }] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b doInBackground(Object... objArr) {
            boolean z = true;
            boolean z2 = false;
            b bVar = new b();
            com.baidu.adp.lib.cache.l<String> lw = com.baidu.tbadk.core.c.a.aaT().lw("tb.first_dir");
            String str = lw.get("first_dir_cache_key");
            if (str != null) {
                if (!str.equals("")) {
                    bVar.parserJson(str);
                    publishProgress(bVar);
                    z2 = z;
                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                    if (BarFolderFirstDirActivity.this.stType != null) {
                        this.mNetwork.x(BarFolderFirstDirActivity.iBs, BarFolderFirstDirActivity.this.stType);
                    }
                    String acg = this.mNetwork.acg();
                    if (!this.mNetwork.acE().adD().isRequestSuccess()) {
                        bVar.parserJson(acg);
                        if ((acg + "").trim().equals((str + "").trim())) {
                            if (z2) {
                                return null;
                            }
                        } else {
                            lw.a("first_dir_cache_key", acg, 86400000L);
                        }
                    } else {
                        bVar.setErrorMsg(this.mNetwork.getErrorString());
                    }
                    return bVar;
                }
            }
            z = false;
            z2 = z;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
            if (BarFolderFirstDirActivity.this.stType != null) {
            }
            String acg2 = this.mNetwork.acg();
            if (!this.mNetwork.acE().adD().isRequestSuccess()) {
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            if (bVar != null) {
                BarFolderFirstDirActivity.this.a(bVar, false);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ji();
                this.mNetwork = null;
            }
            BarFolderFirstDirActivity.this.a(null, true);
        }
    }
}
