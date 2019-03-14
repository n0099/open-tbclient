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
    public static String iBI = "st_type";
    private ProgressBar iBE;
    private com.baidu.tieba.square.square.a iBF;
    private a iBG;
    protected ViewGroup iBH;
    private NavigationBar mNavigationBar;
    protected ListView mList = null;
    private String stType = null;

    public static void h(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(iBI, str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.bar_folder_dir_activity);
        initUI();
        ag(bundle);
        cdb();
        TiebaStatic.eventStat(getPageContext().getContext(), "category_1", RGState.METHOD_NAME_ENTER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        this.iBF.notifyDataSetChanged();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getResources().getString(d.j.bar_first_dir_name));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mList = (ListView) findViewById(d.g.list);
        this.iBF = new com.baidu.tieba.square.square.a(getPageContext().getPageActivity(), new b(), true);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(getActivity(), d.e.ds76)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.iBF);
        this.iBE = (ProgressBar) findViewById(d.g.progress);
        this.iBH = (ViewGroup) findViewById(d.g.body_container);
        bc.aD(this.iBH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iBG != null) {
            this.iBG.cancel();
        }
        a(null, true);
    }

    protected void cdb() {
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.square.BarFolderFirstDirActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d dVar;
                ArrayList<d> cdc = BarFolderFirstDirActivity.this.iBF.cdc();
                if (cdc != null && i < cdc.size() && (dVar = cdc.get(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(BarFolderFirstDirActivity.this.getPageContext().getPageActivity(), dVar.izF, dVar.izG, dVar.izH)));
                }
            }
        });
    }

    protected void ag(Bundle bundle) {
        if (bundle != null) {
            this.stType = bundle.getString(iBI);
        } else {
            this.stType = getIntent().getStringExtra(iBI);
        }
        this.iBE.setVisibility(0);
        this.mList.setEnabled(false);
        if (this.iBG != null) {
            this.iBG.cancel();
        }
        this.iBG = new a();
        this.iBG.setPriority(3);
        this.iBG.execute("");
    }

    protected void a(b bVar, boolean z) {
        this.iBE.setVisibility(8);
        this.mList.setEnabled(true);
        this.iBG = null;
        if (!z) {
            if (bVar.isFailed()) {
                showToast(bVar.getErrorMsg());
                return;
            }
            this.iBF.az(bVar.cdc());
            this.mList.setVisibility(4);
            this.iBF.notifyDataSetChanged();
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
        if (this.iBH != null) {
            bc.c(this.iBH, i);
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
            com.baidu.adp.lib.cache.l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.first_dir");
            String str = lv.get("first_dir_cache_key");
            if (str != null) {
                if (!str.equals("")) {
                    bVar.parserJson(str);
                    publishProgress(bVar);
                    z2 = z;
                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/forum/forumdir");
                    if (BarFolderFirstDirActivity.this.stType != null) {
                        this.mNetwork.x(BarFolderFirstDirActivity.iBI, BarFolderFirstDirActivity.this.stType);
                    }
                    String acj = this.mNetwork.acj();
                    if (!this.mNetwork.acH().adG().isRequestSuccess()) {
                        bVar.parserJson(acj);
                        if ((acj + "").trim().equals((str + "").trim())) {
                            if (z2) {
                                return null;
                            }
                        } else {
                            lv.a("first_dir_cache_key", acj, 86400000L);
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
            String acj2 = this.mNetwork.acj();
            if (!this.mNetwork.acH().adG().isRequestSuccess()) {
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
