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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BarFolderFirstDirActivity extends ProxyAdkBaseActivity<BarFolderFirstDirActivity> {
    public static String jdT = "st_type";
    private ProgressBar jdP;
    private com.baidu.tieba.square.square.a jdQ;
    private a jdR;
    protected ViewGroup jdS;
    private NavigationBar mNavigationBar;
    protected ListView mList = null;
    private String stType = null;

    public static void e(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(jdT, str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        initUI();
        ag(bundle);
        cmR();
        TiebaStatic.eventStat(getPageContext().getContext(), "category_1", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        this.jdQ.notifyDataSetChanged();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(getResources().getString(R.string.bar_first_dir_name));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mList = (ListView) findViewById(R.id.list);
        this.jdQ = new com.baidu.tieba.square.square.a(getPageContext().getPageActivity(), new b(), true);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds76)));
        this.mList.addHeaderView(textView);
        this.mList.setAdapter((ListAdapter) this.jdQ);
        this.jdP = (ProgressBar) findViewById(R.id.progress);
        this.jdS = (ViewGroup) findViewById(R.id.body_container);
        bc.prepareNewView(this.jdS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.jdR != null) {
            this.jdR.cancel();
        }
        a(null, true);
    }

    protected void cmR() {
        this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.square.BarFolderFirstDirActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d dVar;
                ArrayList<d> cmS = BarFolderFirstDirActivity.this.jdQ.cmS();
                if (cmS != null && i < cmS.size() && (dVar = cmS.get(i)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(BarFolderFirstDirActivity.this.getPageContext().getPageActivity(), dVar.jbQ, dVar.jbR, dVar.jbS)));
                }
            }
        });
    }

    protected void ag(Bundle bundle) {
        if (bundle != null) {
            this.stType = bundle.getString(jdT);
        } else {
            this.stType = getIntent().getStringExtra(jdT);
        }
        this.jdP.setVisibility(0);
        this.mList.setEnabled(false);
        if (this.jdR != null) {
            this.jdR.cancel();
        }
        this.jdR = new a();
        this.jdR.setPriority(3);
        this.jdR.execute("");
    }

    protected void a(b bVar, boolean z) {
        this.jdP.setVisibility(8);
        this.mList.setEnabled(true);
        this.jdR = null;
        if (!z) {
            if (bVar.cmw()) {
                showToast(bVar.getErrorMsg());
                return;
            }
            this.jdQ.aH(bVar.cmS());
            this.mList.setVisibility(4);
            this.jdQ.notifyDataSetChanged();
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
        if (this.jdS != null) {
            bc.processSkin(this.jdS, i);
        }
        am.setFrsPBBgColor(findViewById(R.id.root_view), i);
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
        /* renamed from: E */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b doInBackground(Object... objArr) {
            boolean z = true;
            boolean z2 = false;
            b bVar = new b();
            com.baidu.adp.lib.cache.l<String> nl = com.baidu.tbadk.core.d.a.akN().nl("tb.first_dir");
            String str = nl.get("first_dir_cache_key");
            if (str != null) {
                if (!str.equals("")) {
                    bVar.parserJson(str);
                    publishProgress(bVar);
                    z2 = z;
                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_FIRST_DIR);
                    if (BarFolderFirstDirActivity.this.stType != null) {
                        this.mNetwork.addPostData(BarFolderFirstDirActivity.jdT, BarFolderFirstDirActivity.this.stType);
                    }
                    String postNetData = this.mNetwork.postNetData();
                    if (!this.mNetwork.amr().amS().isRequestSuccess()) {
                        bVar.parserJson(postNetData);
                        if ((postNetData + "").trim().equals((str + "").trim())) {
                            if (z2) {
                                return null;
                            }
                        } else {
                            nl.set("first_dir_cache_key", postNetData, 86400000L);
                        }
                    } else {
                        bVar.setErrorMsg(this.mNetwork.getErrorString());
                    }
                    return bVar;
                }
            }
            z = false;
            z2 = z;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.FORUM_FIRST_DIR);
            if (BarFolderFirstDirActivity.this.stType != null) {
            }
            String postNetData2 = this.mNetwork.postNetData();
            if (!this.mNetwork.amr().amS().isRequestSuccess()) {
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
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            BarFolderFirstDirActivity.this.a(null, true);
        }
    }
}
