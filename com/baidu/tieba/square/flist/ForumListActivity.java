package com.baidu.tieba.square.flist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean jeZ = false;
    private static String nlw = "";
    private static String nlx = "";
    private static String nly = "";
    private static String nlz = "";
    private int nkU;
    private int nkV;
    private Drawable nkW;
    private Drawable nkX;
    private Drawable nkY;
    private Drawable nkZ;
    private Drawable nla;
    private Drawable nlb;
    public com.baidu.tieba.square.flist.c nll;
    private ForumListModel.RequestParams nlm;
    private com.baidu.tieba.square.flist.b nlp;
    private com.baidu.tieba.square.flist.b nlq;
    private DirMenuModel nlr;
    private ForumListDetailModel nls;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int nlc = 200;
    private int nld = 200;
    private int nle = 0;
    private final LikeModel fpO = new LikeModel(getPageContext());
    private boolean nlf = false;
    private int menu_choose = 0;
    private boolean nlg = false;
    private int nlh = 0;
    private int nli = 200;
    private boolean nlj = true;
    private boolean nlk = true;
    private boolean nln = false;
    private boolean nlo = false;
    private final ForumListDetailModel.a nlt = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nlp.dNx() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nll.dND();
                ForumListActivity.this.nll.dNC();
                if (ForumListActivity.this.nlm.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nll.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nlm.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nll.dNC();
                    ForumListActivity.this.nlm.recommend_type = ForumListActivity.this.nlh;
                    ForumListActivity.this.nlm.rn = ForumListActivity.this.nli;
                }
                ForumListActivity.this.nll.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nll.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nlg) {
                    ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nll.nlZ.setImageDrawable(ForumListActivity.this.nla);
                    ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nll.nmc.setImageDrawable(ForumListActivity.this.nla);
                    ForumListActivity.this.nlg = false;
                }
                ForumListActivity.this.nll.bNi.setText(ForumListActivity.this.nlm.menu_name);
                ForumListActivity.this.nll.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nll.nmj.KB(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nlp.JL(min);
                ForumListActivity.this.nlp.a(ForumListActivity.this.fpO);
                ForumListActivity.this.nlp.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nll.nlT.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nll.nlO.setVisibility(0);
                } else {
                    ForumListActivity.this.nll.nlO.setVisibility(8);
                }
                ForumListActivity.this.nll.nlV.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nlq.JL(min2);
                ForumListActivity.this.nlq.a(ForumListActivity.this.fpO);
                ForumListActivity.this.nlq.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nll.nlU.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nll.nlP.setVisibility(0);
                } else {
                    ForumListActivity.this.nll.nlP.setVisibility(8);
                }
                ForumListActivity.this.nll.nlW.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nll.dNC();
                if (ForumListActivity.this.nll.nmj.getCount() > 0) {
                    ForumListActivity.this.nll.nmk.setClickable(true);
                    ForumListActivity.this.nll.nmk.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b nlu = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nll.dND();
                    return;
                }
                return;
            }
            eVar.nmU.add(0, eVar);
            if (ForumListActivity.this.nll.nmj != null) {
                ForumListActivity.this.nll.nmj.a(eVar);
                ForumListActivity.this.ST(String.valueOf(ForumListActivity.this.nll.bNi.getText()));
                ForumListActivity.this.nll.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nll.nmj.notifyDataSetChanged();
            }
            ForumListActivity.this.nll.nmk.setClickable(true);
            ForumListActivity.this.nll.nmk.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener nlv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nll.nmf, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nll.dND();
            ForumListActivity.this.nll.dNE();
            ArrayList<e> arrayList = ForumListActivity.this.nll.nmj.dNq().nmU;
            ForumListActivity.this.aN(arrayList.get(i).nkO, arrayList.get(i).nkQ, arrayList.get(i).nkP);
        }
    };
    private final f.c gJh = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nlp.dNz() && !ForumListActivity.this.nlq.dNz()) {
                if (ForumListActivity.this.nlj) {
                    ForumListActivity.this.nlm.recommend_type = 0;
                    ForumListActivity.this.nlm.rn = 200;
                    ForumListActivity.this.nls.a(ForumListActivity.this.nlm);
                    ForumListActivity.this.nls.LoadData();
                    ForumListActivity.this.nlj = false;
                } else if (ForumListActivity.this.nll.Zk.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nln) {
                        ForumListActivity.this.nlc = 50;
                    } else {
                        ForumListActivity.this.nlc = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nll.Zk.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nlo) {
                        ForumListActivity.this.nld = 50;
                    } else {
                        ForumListActivity.this.nld = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ST(String str) {
        e dNq = this.nll.nmj.dNq();
        if (dNq != null) {
            ArrayList<e> arrayList = dNq.nmU;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).nkO.equals(str)) {
                    this.menu_choose = i;
                    this.nll.nmj.KB(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, String str2, String str3) {
        this.nlm.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nlm.menu_name = str;
        this.nlm.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nlm.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nlm.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nlm.offset = 0;
        this.nlm.rn = 10;
        this.nlh = this.nlm.recommend_type;
        this.nli = this.nlm.rn;
        this.nlm.recommend_type = 0;
        this.nlm.rn = 200;
        this.nlg = true;
        this.nls.a(this.nlm);
        this.nls.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nlC;

        private b() {
            this.nlC = false;
        }

        public void xU(boolean z) {
            this.nlC = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nll.nma.setEnabled(false);
            ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nlm.recommend_type = 2;
                ForumListActivity.this.nlm.offset = 0;
                ForumListActivity.this.nlm.rn = ForumListActivity.this.nld;
                return ForumListModel.new_fetch(ForumListActivity.this.nlm);
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
                ForumListActivity.this.nlq.JL(min);
                ForumListActivity.this.nlq.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nld == 200) {
                    ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nll.nmc.setImageDrawable(ForumListActivity.this.nla);
                } else {
                    ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nll.nmc.setImageDrawable(ForumListActivity.this.nlb);
                    ForumListActivity.this.nlo = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nlC) {
                    if (ForumListActivity.this.nld == 200) {
                        ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nll.nmc.setImageDrawable(ForumListActivity.this.nla);
                    } else {
                        ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nll.nmc.setImageDrawable(ForumListActivity.this.nlb);
                    }
                } else {
                    ForumListActivity.this.nll.nmb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nll.nmc.setImageDrawable(ForumListActivity.this.nla);
                    ForumListActivity.this.nlm.rn = 200;
                    ForumListActivity.this.nld = 200;
                }
            }
            ForumListActivity.this.nll.nma.setEnabled(true);
            ForumListActivity.this.nll.dNC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nlC;

        private c() {
            this.nlC = false;
        }

        public void xU(boolean z) {
            this.nlC = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nll.nlX.setEnabled(false);
            ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nlm.recommend_type = 1;
                ForumListActivity.this.nlm.offset = 0;
                ForumListActivity.this.nlm.rn = ForumListActivity.this.nlc;
                return ForumListModel.new_fetch(ForumListActivity.this.nlm);
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
                ForumListActivity.this.nlp.JL(min);
                ForumListActivity.this.nlp.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nlc == 200) {
                    ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nll.nlZ.setImageDrawable(ForumListActivity.this.nla);
                } else {
                    ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nll.nlZ.setImageDrawable(ForumListActivity.this.nlb);
                    ForumListActivity.this.nln = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nlC) {
                    if (ForumListActivity.this.nlc == 200) {
                        ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nll.nlZ.setImageDrawable(ForumListActivity.this.nla);
                    } else {
                        ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nll.nlZ.setImageDrawable(ForumListActivity.this.nlb);
                    }
                } else {
                    ForumListActivity.this.nll.nlY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nll.nlZ.setImageDrawable(ForumListActivity.this.nla);
                    ForumListActivity.this.nlm.rn = 200;
                    ForumListActivity.this.nlc = 200;
                }
            }
            ForumListActivity.this.nll.nlX.setEnabled(true);
            ForumListActivity.this.nll.dNC();
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
        this.nll = new com.baidu.tieba.square.flist.c(this);
        this.nll.nlT = (BdListView) dNs();
        this.nll.nlU = (BdListView) dNu();
        this.nll.mProgressBar.setVisibility(0);
        this.nll.nmk.setOnClickListener(null);
        this.nll.nmk.setClickable(false);
        this.nll.Zk.setAdapter(new a());
        this.nll.nlT.setPullRefresh(this.nll.nmd);
        this.nll.nlU.setPullRefresh(this.nll.nme);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nll.nlT.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nll.nlU.addHeaderView(textView2, 0);
        this.nlp = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nll.nlT.setAdapter((ListAdapter) this.nlp);
        this.nlq = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nll.nlU.setAdapter((ListAdapter) this.nlq);
        H(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void H(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.nll.bNi.setText(str4);
        this.nll.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nlm = new ForumListModel.RequestParams();
        this.nlm.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nlm.menu_name = str4;
        this.nlm.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nlm.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nlm.parent_menu_name = str;
        this.nlm.offset = 0;
        this.nlm.rn = 10;
        if (this.nlm.menu_id != 0) {
            this.nll.dNB();
            this.nlf = true;
            this.nlk = false;
            this.nlp.t(Boolean.valueOf(this.nlk));
            this.nll.Zk.getAdapter().notifyDataSetChanged();
        } else {
            this.nlk = true;
            this.nlp.t(Boolean.valueOf(this.nlk));
            this.nll.dNA();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nll.nmd.setListPullRefreshListener(this.gJh);
        this.nll.nme.setListPullRefreshListener(this.gJh);
        this.nlp.notifyDataSetChanged();
        this.nlq.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nll.dND();
        } else {
            this.nlr = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nlr.a(this.nlu);
            this.nlr.LoadData();
        }
        this.nls = new ForumListDetailModel(getPageContext(), this.nlm);
        this.nls.a(this.nlt);
        this.nll.nlT.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (jeZ) {
            jeZ = false;
            finish();
            c(getPageContext().getPageActivity(), nlw, nly, nlx, nlz);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nlp != null) {
                this.nlp.dNy();
                this.nlp.notifyDataSetChanged();
            }
            if (this.nlq != null) {
                this.nlq.dNy();
                this.nlq.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fpO != null) {
            this.fpO.dOu();
        }
        this.nll.Zk.setAdapter(null);
        this.nll.nlU.setAdapter((ListAdapter) null);
        this.nll.nlT.setAdapter((ListAdapter) null);
        if (this.nll.nmi != null) {
            this.nll.nmi.setAdapter((ListAdapter) null);
        }
        if (this.nlr != null) {
            this.nlr.cancelLoadData();
        }
        if (this.nls != null) {
            this.nls.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nll.iSr);
        this.nll.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nlp.xV(true);
            this.nlq.xV(true);
        } else {
            this.nlp.xV(false);
            this.nlq.xV(false);
        }
        this.nlp.notifyDataSetChanged();
        this.nlq.notifyDataSetChanged();
        if (this.nll.nmf != null) {
            this.nll.nmf.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ao.setBackgroundResource(this.nll.nlQ, R.drawable.bg_pop_most);
        this.nkU = ao.getColor(R.color.common_color_10243);
        this.nkV = ao.getColor(R.color.CAM_X0101);
        this.nkW = ao.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nkX = ao.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nkY = ao.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nkZ = ao.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nla = ao.getDrawable(R.drawable.ico_downward);
        this.nlb = ao.getDrawable(R.drawable.ico_upward);
        this.nlp.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nlq.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.nll.nlP, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.nll.nmb, R.color.common_color_10243, 1);
        ao.setBackgroundResource(this.nll.nlO, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.nll.nlY, R.color.common_color_10243, 1);
        if (this.nln) {
            ao.setImageResource(this.nll.nlZ, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.nll.nlZ, R.drawable.ico_downward);
        }
        if (this.nlo) {
            ao.setImageResource(this.nll.nmc, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.nll.nmc, R.drawable.ico_downward);
        }
        if (this.nll.Zk.getCurrentItem() == 0) {
            this.nll.nlV.setTextColor(this.nkV);
            this.nll.nlV.setBackgroundDrawable(this.nkY);
            this.nll.nlW.setBackgroundDrawable(this.nkX);
            this.nll.nlW.setTextColor(this.nkU);
            return;
        }
        this.nll.nlW.setTextColor(this.nkV);
        this.nll.nlW.setBackgroundDrawable(this.nkZ);
        this.nll.nlV.setBackgroundDrawable(this.nkW);
        this.nll.nlV.setTextColor(this.nkU);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nll.Zk.setCurrentItem(0);
            this.nle = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nll.Zk.setCurrentItem(1);
            this.nle = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nll.c(this.nlv);
        }
    }

    private View dNs() {
        this.nll.nlT = dNw();
        this.nll.nlX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNt();
            }
        });
        return this.nll.nlT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNt() {
        if (this.nln) {
            int min = Math.min(this.nlp.getCount(), 200);
            this.nlc = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nlp.dNx(), 0, forumInfoDataArr, 0, min);
            this.nlp.JL(min);
            this.nlp.a(forumInfoDataArr);
            this.nln = false;
            this.nll.nlY.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nll.nlZ.setImageDrawable(this.nla);
            return;
        }
        this.nlc = 50;
        c cVar = new c();
        cVar.xU(true);
        cVar.execute(new Void[0]);
    }

    private View dNu() {
        this.nll.nlU = dNw();
        this.nll.nma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNv();
            }
        });
        return this.nll.nlU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNv() {
        if (this.nlo) {
            int min = Math.min(this.nlq.getCount(), 200);
            this.nld = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nlq.dNx(), 0, forumInfoDataArr, 0, min);
            this.nlq.JL(min);
            this.nlq.a(forumInfoDataArr);
            this.nlo = false;
            this.nll.nmb.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nll.nmc.setImageDrawable(this.nla);
            return;
        }
        this.nld = 50;
        b bVar = new b();
        bVar.xU(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dNw() {
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.nlf) {
            if (i == 0) {
                this.nlp.dNy();
                this.nlp.notifyDataSetChanged();
                this.nll.nlV.setBackgroundDrawable(this.nkY);
                this.nll.nlV.setTextColor(this.nkV);
                this.nll.nlW.setBackgroundDrawable(this.nkX);
                this.nll.nlW.setTextColor(this.nkU);
            } else if (i == 1) {
                this.nlq.dNy();
                this.nlq.notifyDataSetChanged();
                this.nll.nlW.setBackgroundDrawable(this.nkZ);
                this.nll.nlW.setTextColor(this.nkV);
                this.nll.nlV.setBackgroundDrawable(this.nkW);
                this.nll.nlV.setTextColor(this.nkU);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes8.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.nlf ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nll.nlT);
                    return ForumListActivity.this.nll.nlT;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nll.nlU);
                    return ForumListActivity.this.nll.nlU;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        final ForumInfoData[] dNx;
        if (i == 11002 && i2 == -1) {
            this.nls.LoadData();
            if (this.nle == 0) {
                dNx = this.nlp.dNx();
            } else {
                dNx = this.nlq.dNx();
            }
            this.fpO.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (ForumListActivity.this.fpO.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.fpO.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.fpO.getErrorString());
                        } else if (((w) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.nle == 0) {
                                ForumListActivity.this.nlp.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dNx[ForumListActivity.this.nlp.nlD].forum_name);
                            } else if (ForumListActivity.this.nle == 1) {
                                ForumListActivity.this.nlq.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dNx[ForumListActivity.this.nlq.nlD].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nle == 0) {
                this.fpO.gr(dNx[this.nlp.nlD].forum_name, String.valueOf(dNx[this.nlp.nlD].forum_id));
            } else {
                this.fpO.gr(dNx[this.nlq.nlD].forum_name, String.valueOf(dNx[this.nlq.nlD].forum_id));
            }
        }
    }
}
