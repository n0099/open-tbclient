package com.baidu.tieba.square.flist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean hmZ = false;
    private static String leN = "";
    private static String leO = "";
    private static String leP = "";
    private static String leQ = "";
    public com.baidu.tieba.square.flist.c leC;
    private ForumListModel.RequestParams leD;
    private com.baidu.tieba.square.flist.b leG;
    private com.baidu.tieba.square.flist.b leH;
    private DirMenuModel leI;
    private ForumListDetailModel leJ;
    private int lej;
    private int lek;
    private Drawable lel;
    private Drawable lem;
    private Drawable leo;
    private Drawable lep;
    private Drawable leq;
    private Drawable ler;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int les = 200;
    private int let = 200;
    private int leu = 0;
    private final LikeModel dYI = new LikeModel(getPageContext());
    private boolean lev = false;
    private int lew = 0;
    private boolean lex = false;
    private int ley = 0;
    private int lez = 200;
    private boolean leA = true;
    private boolean leB = true;
    private boolean leE = false;
    private boolean leF = false;
    private final ForumListDetailModel.a leK = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.leG.dbS() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.leC.dbY();
                ForumListActivity.this.leC.dbX();
                if (ForumListActivity.this.leD.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.leC.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.leD.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.leC.dbX();
                    ForumListActivity.this.leD.recommend_type = ForumListActivity.this.ley;
                    ForumListActivity.this.leD.rn = ForumListActivity.this.lez;
                }
                ForumListActivity.this.leC.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.leC.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lex) {
                    ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.leC.lfq.setImageDrawable(ForumListActivity.this.leq);
                    ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.leC.lft.setImageDrawable(ForumListActivity.this.leq);
                    ForumListActivity.this.lex = false;
                }
                ForumListActivity.this.leC.bem.setText(ForumListActivity.this.leD.menu_name);
                ForumListActivity.this.leC.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.leC.lfA.DD(ForumListActivity.this.lew);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.leG.CP(min);
                ForumListActivity.this.leG.a(ForumListActivity.this.dYI);
                ForumListActivity.this.leG.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.leC.lfk.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.leC.lff.setVisibility(0);
                } else {
                    ForumListActivity.this.leC.lff.setVisibility(8);
                }
                ForumListActivity.this.leC.lfm.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.leH.CP(min2);
                ForumListActivity.this.leH.a(ForumListActivity.this.dYI);
                ForumListActivity.this.leH.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.leC.lfl.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.leC.lfg.setVisibility(0);
                } else {
                    ForumListActivity.this.leC.lfg.setVisibility(8);
                }
                ForumListActivity.this.leC.lfn.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.leC.dbX();
                if (ForumListActivity.this.leC.lfA.getCount() > 0) {
                    ForumListActivity.this.leC.lfB.setClickable(true);
                    ForumListActivity.this.leC.lfB.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b leL = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.leC.dbY();
                    return;
                }
                return;
            }
            eVar.lgl.add(0, eVar);
            if (ForumListActivity.this.leC.lfA != null) {
                ForumListActivity.this.leC.lfA.a(eVar);
                ForumListActivity.this.Mg(String.valueOf(ForumListActivity.this.leC.bem.getText()));
                ForumListActivity.this.leC.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.leC.lfA.notifyDataSetChanged();
            }
            ForumListActivity.this.leC.lfB.setClickable(true);
            ForumListActivity.this.leC.lfB.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener leM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.leC.lfw, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.lew = i;
            ForumListActivity.this.leC.dbY();
            ForumListActivity.this.leC.dbZ();
            ArrayList<e> arrayList = ForumListActivity.this.leC.lfA.dbL().lgl;
            ForumListActivity.this.ax(arrayList.get(i).led, arrayList.get(i).lef, arrayList.get(i).lee);
        }
    };
    private final f.c fiO = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.leG.dbU() && !ForumListActivity.this.leH.dbU()) {
                if (ForumListActivity.this.leA) {
                    ForumListActivity.this.leD.recommend_type = 0;
                    ForumListActivity.this.leD.rn = 200;
                    ForumListActivity.this.leJ.a(ForumListActivity.this.leD);
                    ForumListActivity.this.leJ.LoadData();
                    ForumListActivity.this.leA = false;
                } else if (ForumListActivity.this.leC.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.leE) {
                        ForumListActivity.this.les = 50;
                    } else {
                        ForumListActivity.this.les = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.leC.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.leF) {
                        ForumListActivity.this.let = 50;
                    } else {
                        ForumListActivity.this.let = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Mg(String str) {
        e dbL = this.leC.lfA.dbL();
        if (dbL != null) {
            ArrayList<e> arrayList = dbL.lgl;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).led.equals(str)) {
                    this.lew = i;
                    this.leC.lfA.DD(this.lew);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.leD.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.leD.menu_name = str;
        this.leD.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.leD.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.leD.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.leD.offset = 0;
        this.leD.rn = 10;
        this.ley = this.leD.recommend_type;
        this.lez = this.leD.rn;
        this.leD.recommend_type = 0;
        this.leD.rn = 200;
        this.lex = true;
        this.leJ.a(this.leD);
        this.leJ.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean leT;

        private b() {
            this.leT = false;
        }

        public void uk(boolean z) {
            this.leT = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.leC.lfr.setEnabled(false);
            ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.leD.recommend_type = 2;
                ForumListActivity.this.leD.offset = 0;
                ForumListActivity.this.leD.rn = ForumListActivity.this.let;
                return ForumListModel.new_fetch(ForumListActivity.this.leD);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ForumListModel forumListModel) {
            if (forumListModel != null && forumListModel.recommend_list_right != null) {
                int min = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min);
                ForumListActivity.this.leH.CP(min);
                ForumListActivity.this.leH.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.let == 200) {
                    ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.leC.lft.setImageDrawable(ForumListActivity.this.leq);
                } else {
                    ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.leC.lft.setImageDrawable(ForumListActivity.this.ler);
                    ForumListActivity.this.leF = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.leT) {
                    if (ForumListActivity.this.let == 200) {
                        ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.leC.lft.setImageDrawable(ForumListActivity.this.leq);
                    } else {
                        ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.leC.lft.setImageDrawable(ForumListActivity.this.ler);
                    }
                } else {
                    ForumListActivity.this.leC.lfs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.leC.lft.setImageDrawable(ForumListActivity.this.leq);
                    ForumListActivity.this.leD.rn = 200;
                    ForumListActivity.this.let = 200;
                }
            }
            ForumListActivity.this.leC.lfr.setEnabled(true);
            ForumListActivity.this.leC.dbX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean leT;

        private c() {
            this.leT = false;
        }

        public void uk(boolean z) {
            this.leT = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.leC.lfo.setEnabled(false);
            ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.leD.recommend_type = 1;
                ForumListActivity.this.leD.offset = 0;
                ForumListActivity.this.leD.rn = ForumListActivity.this.les;
                return ForumListModel.new_fetch(ForumListActivity.this.leD);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ForumListModel forumListModel) {
            if (forumListModel != null && forumListModel.recommend_list_left != null) {
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                ForumListActivity.this.leG.CP(min);
                ForumListActivity.this.leG.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.les == 200) {
                    ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.leC.lfq.setImageDrawable(ForumListActivity.this.leq);
                } else {
                    ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.leC.lfq.setImageDrawable(ForumListActivity.this.ler);
                    ForumListActivity.this.leE = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.leT) {
                    if (ForumListActivity.this.les == 200) {
                        ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.leC.lfq.setImageDrawable(ForumListActivity.this.leq);
                    } else {
                        ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.leC.lfq.setImageDrawable(ForumListActivity.this.ler);
                    }
                } else {
                    ForumListActivity.this.leC.lfp.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.leC.lfq.setImageDrawable(ForumListActivity.this.leq);
                    ForumListActivity.this.leD.rn = 200;
                    ForumListActivity.this.les = 200;
                }
            }
            ForumListActivity.this.leC.lfo.setEnabled(true);
            ForumListActivity.this.leC.dbX();
        }
    }

    public static void c(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ForumListActivity.class);
        intent.putExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME, str);
        intent.putExtra(ForumListActivityConfig.KEY_MENU_TYPE, str2);
        intent.putExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID, str3);
        intent.putExtra("level_2_menu_name", str4);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        int dimens;
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
        String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
        this.leC = new com.baidu.tieba.square.flist.c(this);
        this.leC.lfk = (BdListView) dbN();
        this.leC.lfl = (BdListView) dbP();
        this.leC.mProgressBar.setVisibility(0);
        this.leC.lfB.setOnClickListener(null);
        this.leC.lfB.setClickable(false);
        this.leC.mViewPager.setAdapter(new a());
        this.leC.lfk.setPullRefresh(this.leC.lfu);
        this.leC.lfl.setPullRefresh(this.leC.lfv);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.leC.lfk.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.leC.lfl.addHeaderView(textView2, 0);
        this.leG = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.leC.lfk.setAdapter((ListAdapter) this.leG);
        this.leH = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.leC.lfl.setAdapter((ListAdapter) this.leH);
        D(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void D(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.leC.bem.setText(str4);
        this.leC.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.leD = new ForumListModel.RequestParams();
        this.leD.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.leD.menu_name = str4;
        this.leD.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.leD.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.leD.parent_menu_name = str;
        this.leD.offset = 0;
        this.leD.rn = 10;
        if (this.leD.menu_id != 0) {
            this.leC.dbW();
            this.lev = true;
            this.leB = false;
            this.leG.m(Boolean.valueOf(this.leB));
            this.leC.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.leB = true;
            this.leG.m(Boolean.valueOf(this.leB));
            this.leC.dbV();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.leC.lfu.setListPullRefreshListener(this.fiO);
        this.leC.lfv.setListPullRefreshListener(this.fiO);
        this.leG.notifyDataSetChanged();
        this.leH.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.leC.dbY();
        } else {
            this.leI = new DirMenuModel(getPageContext(), str, str3, str2);
            this.leI.a(this.leL);
            this.leI.LoadData();
        }
        this.leJ = new ForumListDetailModel(getPageContext(), this.leD);
        this.leJ.a(this.leK);
        this.leC.lfk.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hmZ) {
            hmZ = false;
            finish();
            c(getPageContext().getPageActivity(), leN, leP, leO, leQ);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.leG != null) {
                this.leG.dbT();
                this.leG.notifyDataSetChanged();
            }
            if (this.leH != null) {
                this.leH.dbT();
                this.leH.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dYI != null) {
            this.dYI.dcN();
        }
        this.leC.mViewPager.setAdapter(null);
        this.leC.lfl.setAdapter((ListAdapter) null);
        this.leC.lfk.setAdapter((ListAdapter) null);
        if (this.leC.lfz != null) {
            this.leC.lfz.setAdapter((ListAdapter) null);
        }
        if (this.leI != null) {
            this.leI.cancelLoadData();
        }
        if (this.leJ != null) {
            this.leJ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.leC.hay);
        this.leC.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.leG.ul(true);
            this.leH.ul(true);
        } else {
            this.leG.ul(false);
            this.leH.ul(false);
        }
        this.leG.notifyDataSetChanged();
        this.leH.notifyDataSetChanged();
        if (this.leC.lfw != null) {
            this.leC.lfw.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.leC.lfh, R.drawable.bg_pop_most);
        this.lej = am.getColor(R.color.common_color_10243);
        this.lek = am.getColor(R.color.cp_cont_a);
        this.lel = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lem = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.leo = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lep = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.leq = am.getDrawable(R.drawable.ico_downward);
        this.ler = am.getDrawable(R.drawable.ico_upward);
        this.leG.cT(R.drawable.btn_add_end, R.drawable.btn_add);
        this.leH.cT(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.leC.lfg, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.leC.lfs, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.leC.lff, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.leC.lfp, R.color.common_color_10243, 1);
        if (this.leE) {
            am.setImageResource(this.leC.lfq, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.leC.lfq, R.drawable.ico_downward);
        }
        if (this.leF) {
            am.setImageResource(this.leC.lft, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.leC.lft, R.drawable.ico_downward);
        }
        if (this.leC.mViewPager.getCurrentItem() == 0) {
            this.leC.lfm.setTextColor(this.lek);
            this.leC.lfm.setBackgroundDrawable(this.leo);
            this.leC.lfn.setBackgroundDrawable(this.lem);
            this.leC.lfn.setTextColor(this.lej);
            return;
        }
        this.leC.lfn.setTextColor(this.lek);
        this.leC.lfn.setBackgroundDrawable(this.lep);
        this.leC.lfm.setBackgroundDrawable(this.lel);
        this.leC.lfm.setTextColor(this.lej);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.leC.mViewPager.setCurrentItem(0);
            this.leu = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.leC.mViewPager.setCurrentItem(1);
            this.leu = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.leC.c(this.leM);
        }
    }

    private View dbN() {
        this.leC.lfk = dbR();
        this.leC.lfo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dbO();
            }
        });
        return this.leC.lfk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbO() {
        if (this.leE) {
            int min = Math.min(this.leG.getCount(), 200);
            this.les = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.leG.dbS(), 0, forumInfoDataArr, 0, min);
            this.leG.CP(min);
            this.leG.a(forumInfoDataArr);
            this.leE = false;
            this.leC.lfp.setText(getPageContext().getString(R.string.flist_expand_list));
            this.leC.lfq.setImageDrawable(this.leq);
            return;
        }
        this.les = 50;
        c cVar = new c();
        cVar.uk(true);
        cVar.execute(new Void[0]);
    }

    private View dbP() {
        this.leC.lfl = dbR();
        this.leC.lfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dbQ();
            }
        });
        return this.leC.lfl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbQ() {
        if (this.leF) {
            int min = Math.min(this.leH.getCount(), 200);
            this.let = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.leH.dbS(), 0, forumInfoDataArr, 0, min);
            this.leH.CP(min);
            this.leH.a(forumInfoDataArr);
            this.leF = false;
            this.leC.lfs.setText(getPageContext().getString(R.string.flist_expand_list));
            this.leC.lft.setImageDrawable(this.leq);
            return;
        }
        this.let = 50;
        b bVar = new b();
        bVar.uk(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dbR() {
        BdListView bdListView = new BdListView(getPageContext().getPageActivity());
        bdListView.setScrollingCacheEnabled(false);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setSelector(17170445);
        bdListView.setDivider(new ColorDrawable(0));
        bdListView.setDividerHeight(0);
        bdListView.setFooterDividersEnabled(false);
        bdListView.setHorizontalFadingEdgeEnabled(false);
        bdListView.setVerticalFadingEdgeEnabled(false);
        return bdListView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.lev) {
            if (i == 0) {
                this.leG.dbT();
                this.leG.notifyDataSetChanged();
                this.leC.lfm.setBackgroundDrawable(this.leo);
                this.leC.lfm.setTextColor(this.lek);
                this.leC.lfn.setBackgroundDrawable(this.lem);
                this.leC.lfn.setTextColor(this.lej);
            } else if (i == 1) {
                this.leH.dbT();
                this.leH.notifyDataSetChanged();
                this.leC.lfn.setBackgroundDrawable(this.lep);
                this.leC.lfn.setTextColor(this.lek);
                this.leC.lfm.setBackgroundDrawable(this.lel);
                this.leC.lfm.setTextColor(this.lej);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes10.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.lev ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.leC.lfk);
                    return ForumListActivity.this.leC.lfk;
                case 1:
                    viewGroup.addView(ForumListActivity.this.leC.lfl);
                    return ForumListActivity.this.leC.lfl;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    protected void onActivityResult(int i, int i2, Intent intent) {
        final ForumInfoData[] dbS;
        if (i == 11002 && i2 == -1) {
            this.leJ.LoadData();
            if (this.leu == 0) {
                dbS = this.leG.dbS();
            } else {
                dbS = this.leH.dbS();
            }
            this.dYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dYI.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dYI.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dYI.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.leu == 0) {
                                ForumListActivity.this.leG.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dbS[ForumListActivity.this.leG.leU].forum_name);
                            } else if (ForumListActivity.this.leu == 1) {
                                ForumListActivity.this.leH.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dbS[ForumListActivity.this.leH.leU].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.leu == 0) {
                this.dYI.fq(dbS[this.leG.leU].forum_name, String.valueOf(dbS[this.leG.leU].forum_id));
            } else {
                this.dYI.fq(dbS[this.leH.leU].forum_name, String.valueOf(dbS[this.leH.leU].forum_id));
            }
        }
    }
}
