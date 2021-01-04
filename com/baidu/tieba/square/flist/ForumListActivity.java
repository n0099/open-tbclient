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
    private int nkV;
    private int nkW;
    private Drawable nkX;
    private Drawable nkY;
    private Drawable nkZ;
    private Drawable nla;
    private Drawable nlb;
    private Drawable nlc;
    public com.baidu.tieba.square.flist.c nlm;
    private ForumListModel.RequestParams nln;
    private com.baidu.tieba.square.flist.b nlq;
    private com.baidu.tieba.square.flist.b nlr;
    private DirMenuModel nls;
    private ForumListDetailModel nlt;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    public static boolean jeZ = false;
    private static String nlx = "";
    private static String nly = "";
    private static String nlz = "";
    private static String nlA = "";
    private int nld = 200;
    private int nle = 200;
    private int nlf = 0;
    private final LikeModel fpO = new LikeModel(getPageContext());
    private boolean nlg = false;
    private int menu_choose = 0;
    private boolean nlh = false;
    private int nli = 0;
    private int nlj = 200;
    private boolean nlk = true;
    private boolean nll = true;
    private boolean nlo = false;
    private boolean nlp = false;
    private final ForumListDetailModel.a nlu = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nlq.dNw() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nlm.dNC();
                ForumListActivity.this.nlm.dNB();
                if (ForumListActivity.this.nln.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nlm.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nln.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nlm.dNB();
                    ForumListActivity.this.nln.recommend_type = ForumListActivity.this.nli;
                    ForumListActivity.this.nln.rn = ForumListActivity.this.nlj;
                }
                ForumListActivity.this.nlm.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nlm.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nlh) {
                    ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nlm.nma.setImageDrawable(ForumListActivity.this.nlb);
                    ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nlm.nmd.setImageDrawable(ForumListActivity.this.nlb);
                    ForumListActivity.this.nlh = false;
                }
                ForumListActivity.this.nlm.bNi.setText(ForumListActivity.this.nln.menu_name);
                ForumListActivity.this.nlm.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nlm.nmk.KB(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nlq.JL(min);
                ForumListActivity.this.nlq.a(ForumListActivity.this.fpO);
                ForumListActivity.this.nlq.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nlm.nlU.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nlm.nlP.setVisibility(0);
                } else {
                    ForumListActivity.this.nlm.nlP.setVisibility(8);
                }
                ForumListActivity.this.nlm.nlW.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nlr.JL(min2);
                ForumListActivity.this.nlr.a(ForumListActivity.this.fpO);
                ForumListActivity.this.nlr.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nlm.nlV.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nlm.nlQ.setVisibility(0);
                } else {
                    ForumListActivity.this.nlm.nlQ.setVisibility(8);
                }
                ForumListActivity.this.nlm.nlX.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nlm.dNB();
                if (ForumListActivity.this.nlm.nmk.getCount() > 0) {
                    ForumListActivity.this.nlm.nml.setClickable(true);
                    ForumListActivity.this.nlm.nml.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b nlv = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nlm.dNC();
                    return;
                }
                return;
            }
            eVar.nmV.add(0, eVar);
            if (ForumListActivity.this.nlm.nmk != null) {
                ForumListActivity.this.nlm.nmk.a(eVar);
                ForumListActivity.this.SU(String.valueOf(ForumListActivity.this.nlm.bNi.getText()));
                ForumListActivity.this.nlm.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nlm.nmk.notifyDataSetChanged();
            }
            ForumListActivity.this.nlm.nml.setClickable(true);
            ForumListActivity.this.nlm.nml.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener nlw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nlm.nmg, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nlm.dNC();
            ForumListActivity.this.nlm.dND();
            ArrayList<e> arrayList = ForumListActivity.this.nlm.nmk.dNp().nmV;
            ForumListActivity.this.aN(arrayList.get(i).nkP, arrayList.get(i).nkR, arrayList.get(i).nkQ);
        }
    };
    private final f.c gJh = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nlq.dNy() && !ForumListActivity.this.nlr.dNy()) {
                if (ForumListActivity.this.nlk) {
                    ForumListActivity.this.nln.recommend_type = 0;
                    ForumListActivity.this.nln.rn = 200;
                    ForumListActivity.this.nlt.a(ForumListActivity.this.nln);
                    ForumListActivity.this.nlt.LoadData();
                    ForumListActivity.this.nlk = false;
                } else if (ForumListActivity.this.nlm.Zk.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nlo) {
                        ForumListActivity.this.nld = 50;
                    } else {
                        ForumListActivity.this.nld = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nlm.Zk.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nlp) {
                        ForumListActivity.this.nle = 50;
                    } else {
                        ForumListActivity.this.nle = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SU(String str) {
        e dNp = this.nlm.nmk.dNp();
        if (dNp != null) {
            ArrayList<e> arrayList = dNp.nmV;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).nkP.equals(str)) {
                    this.menu_choose = i;
                    this.nlm.nmk.KB(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str, String str2, String str3) {
        this.nln.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nln.menu_name = str;
        this.nln.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nln.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nln.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nln.offset = 0;
        this.nln.rn = 10;
        this.nli = this.nln.recommend_type;
        this.nlj = this.nln.rn;
        this.nln.recommend_type = 0;
        this.nln.rn = 200;
        this.nlh = true;
        this.nlt.a(this.nln);
        this.nlt.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nlD;

        private b() {
            this.nlD = false;
        }

        public void xU(boolean z) {
            this.nlD = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nlm.nmb.setEnabled(false);
            ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nln.recommend_type = 2;
                ForumListActivity.this.nln.offset = 0;
                ForumListActivity.this.nln.rn = ForumListActivity.this.nle;
                return ForumListModel.new_fetch(ForumListActivity.this.nln);
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
                ForumListActivity.this.nlr.JL(min);
                ForumListActivity.this.nlr.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nle == 200) {
                    ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nlm.nmd.setImageDrawable(ForumListActivity.this.nlb);
                } else {
                    ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nlm.nmd.setImageDrawable(ForumListActivity.this.nlc);
                    ForumListActivity.this.nlp = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nlD) {
                    if (ForumListActivity.this.nle == 200) {
                        ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nlm.nmd.setImageDrawable(ForumListActivity.this.nlb);
                    } else {
                        ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nlm.nmd.setImageDrawable(ForumListActivity.this.nlc);
                    }
                } else {
                    ForumListActivity.this.nlm.nmc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nlm.nmd.setImageDrawable(ForumListActivity.this.nlb);
                    ForumListActivity.this.nln.rn = 200;
                    ForumListActivity.this.nle = 200;
                }
            }
            ForumListActivity.this.nlm.nmb.setEnabled(true);
            ForumListActivity.this.nlm.dNB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nlD;

        private c() {
            this.nlD = false;
        }

        public void xU(boolean z) {
            this.nlD = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nlm.nlY.setEnabled(false);
            ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nln.recommend_type = 1;
                ForumListActivity.this.nln.offset = 0;
                ForumListActivity.this.nln.rn = ForumListActivity.this.nld;
                return ForumListModel.new_fetch(ForumListActivity.this.nln);
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
                ForumListActivity.this.nlq.JL(min);
                ForumListActivity.this.nlq.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nld == 200) {
                    ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nlm.nma.setImageDrawable(ForumListActivity.this.nlb);
                } else {
                    ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nlm.nma.setImageDrawable(ForumListActivity.this.nlc);
                    ForumListActivity.this.nlo = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nlD) {
                    if (ForumListActivity.this.nld == 200) {
                        ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nlm.nma.setImageDrawable(ForumListActivity.this.nlb);
                    } else {
                        ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nlm.nma.setImageDrawable(ForumListActivity.this.nlc);
                    }
                } else {
                    ForumListActivity.this.nlm.nlZ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nlm.nma.setImageDrawable(ForumListActivity.this.nlb);
                    ForumListActivity.this.nln.rn = 200;
                    ForumListActivity.this.nld = 200;
                }
            }
            ForumListActivity.this.nlm.nlY.setEnabled(true);
            ForumListActivity.this.nlm.dNB();
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
        this.nlm = new com.baidu.tieba.square.flist.c(this);
        this.nlm.nlU = (BdListView) dNr();
        this.nlm.nlV = (BdListView) dNt();
        this.nlm.mProgressBar.setVisibility(0);
        this.nlm.nml.setOnClickListener(null);
        this.nlm.nml.setClickable(false);
        this.nlm.Zk.setAdapter(new a());
        this.nlm.nlU.setPullRefresh(this.nlm.nme);
        this.nlm.nlV.setPullRefresh(this.nlm.nmf);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nlm.nlU.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nlm.nlV.addHeaderView(textView2, 0);
        this.nlq = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nlm.nlU.setAdapter((ListAdapter) this.nlq);
        this.nlr = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nlm.nlV.setAdapter((ListAdapter) this.nlr);
        H(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void H(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.nlm.bNi.setText(str4);
        this.nlm.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nln = new ForumListModel.RequestParams();
        this.nln.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nln.menu_name = str4;
        this.nln.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nln.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nln.parent_menu_name = str;
        this.nln.offset = 0;
        this.nln.rn = 10;
        if (this.nln.menu_id != 0) {
            this.nlm.dNA();
            this.nlg = true;
            this.nll = false;
            this.nlq.t(Boolean.valueOf(this.nll));
            this.nlm.Zk.getAdapter().notifyDataSetChanged();
        } else {
            this.nll = true;
            this.nlq.t(Boolean.valueOf(this.nll));
            this.nlm.dNz();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nlm.nme.setListPullRefreshListener(this.gJh);
        this.nlm.nmf.setListPullRefreshListener(this.gJh);
        this.nlq.notifyDataSetChanged();
        this.nlr.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nlm.dNC();
        } else {
            this.nls = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nls.a(this.nlv);
            this.nls.LoadData();
        }
        this.nlt = new ForumListDetailModel(getPageContext(), this.nln);
        this.nlt.a(this.nlu);
        this.nlm.nlU.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (jeZ) {
            jeZ = false;
            finish();
            c(getPageContext().getPageActivity(), nlx, nlz, nly, nlA);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nlq != null) {
                this.nlq.dNx();
                this.nlq.notifyDataSetChanged();
            }
            if (this.nlr != null) {
                this.nlr.dNx();
                this.nlr.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fpO != null) {
            this.fpO.dOt();
        }
        this.nlm.Zk.setAdapter(null);
        this.nlm.nlV.setAdapter((ListAdapter) null);
        this.nlm.nlU.setAdapter((ListAdapter) null);
        if (this.nlm.nmj != null) {
            this.nlm.nmj.setAdapter((ListAdapter) null);
        }
        if (this.nls != null) {
            this.nls.cancelLoadData();
        }
        if (this.nlt != null) {
            this.nlt.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nlm.iSr);
        this.nlm.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nlq.xV(true);
            this.nlr.xV(true);
        } else {
            this.nlq.xV(false);
            this.nlr.xV(false);
        }
        this.nlq.notifyDataSetChanged();
        this.nlr.notifyDataSetChanged();
        if (this.nlm.nmg != null) {
            this.nlm.nmg.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ao.setBackgroundResource(this.nlm.nlR, R.drawable.bg_pop_most);
        this.nkV = ao.getColor(R.color.common_color_10243);
        this.nkW = ao.getColor(R.color.CAM_X0101);
        this.nkX = ao.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nkY = ao.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nkZ = ao.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nla = ao.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nlb = ao.getDrawable(R.drawable.ico_downward);
        this.nlc = ao.getDrawable(R.drawable.ico_upward);
        this.nlq.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nlr.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.nlm.nlQ, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.nlm.nmc, R.color.common_color_10243, 1);
        ao.setBackgroundResource(this.nlm.nlP, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.nlm.nlZ, R.color.common_color_10243, 1);
        if (this.nlo) {
            ao.setImageResource(this.nlm.nma, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.nlm.nma, R.drawable.ico_downward);
        }
        if (this.nlp) {
            ao.setImageResource(this.nlm.nmd, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.nlm.nmd, R.drawable.ico_downward);
        }
        if (this.nlm.Zk.getCurrentItem() == 0) {
            this.nlm.nlW.setTextColor(this.nkW);
            this.nlm.nlW.setBackgroundDrawable(this.nkZ);
            this.nlm.nlX.setBackgroundDrawable(this.nkY);
            this.nlm.nlX.setTextColor(this.nkV);
            return;
        }
        this.nlm.nlX.setTextColor(this.nkW);
        this.nlm.nlX.setBackgroundDrawable(this.nla);
        this.nlm.nlW.setBackgroundDrawable(this.nkX);
        this.nlm.nlW.setTextColor(this.nkV);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nlm.Zk.setCurrentItem(0);
            this.nlf = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nlm.Zk.setCurrentItem(1);
            this.nlf = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nlm.c(this.nlw);
        }
    }

    private View dNr() {
        this.nlm.nlU = dNv();
        this.nlm.nlY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNs();
            }
        });
        return this.nlm.nlU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNs() {
        if (this.nlo) {
            int min = Math.min(this.nlq.getCount(), 200);
            this.nld = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nlq.dNw(), 0, forumInfoDataArr, 0, min);
            this.nlq.JL(min);
            this.nlq.a(forumInfoDataArr);
            this.nlo = false;
            this.nlm.nlZ.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nlm.nma.setImageDrawable(this.nlb);
            return;
        }
        this.nld = 50;
        c cVar = new c();
        cVar.xU(true);
        cVar.execute(new Void[0]);
    }

    private View dNt() {
        this.nlm.nlV = dNv();
        this.nlm.nmb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNu();
            }
        });
        return this.nlm.nlV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNu() {
        if (this.nlp) {
            int min = Math.min(this.nlr.getCount(), 200);
            this.nle = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nlr.dNw(), 0, forumInfoDataArr, 0, min);
            this.nlr.JL(min);
            this.nlr.a(forumInfoDataArr);
            this.nlp = false;
            this.nlm.nmc.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nlm.nmd.setImageDrawable(this.nlb);
            return;
        }
        this.nle = 50;
        b bVar = new b();
        bVar.xU(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dNv() {
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
        if (!this.nlg) {
            if (i == 0) {
                this.nlq.dNx();
                this.nlq.notifyDataSetChanged();
                this.nlm.nlW.setBackgroundDrawable(this.nkZ);
                this.nlm.nlW.setTextColor(this.nkW);
                this.nlm.nlX.setBackgroundDrawable(this.nkY);
                this.nlm.nlX.setTextColor(this.nkV);
            } else if (i == 1) {
                this.nlr.dNx();
                this.nlr.notifyDataSetChanged();
                this.nlm.nlX.setBackgroundDrawable(this.nla);
                this.nlm.nlX.setTextColor(this.nkW);
                this.nlm.nlW.setBackgroundDrawable(this.nkX);
                this.nlm.nlW.setTextColor(this.nkV);
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
            return ForumListActivity.this.nlg ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nlm.nlU);
                    return ForumListActivity.this.nlm.nlU;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nlm.nlV);
                    return ForumListActivity.this.nlm.nlV;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    protected void onActivityResult(int i, int i2, Intent intent) {
        final ForumInfoData[] dNw;
        if (i == 11002 && i2 == -1) {
            this.nlt.LoadData();
            if (this.nlf == 0) {
                dNw = this.nlq.dNw();
            } else {
                dNw = this.nlr.dNw();
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
                            if (ForumListActivity.this.nlf == 0) {
                                ForumListActivity.this.nlq.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dNw[ForumListActivity.this.nlq.nlE].forum_name);
                            } else if (ForumListActivity.this.nlf == 1) {
                                ForumListActivity.this.nlr.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dNw[ForumListActivity.this.nlr.nlE].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nlf == 0) {
                this.fpO.gr(dNw[this.nlq.nlE].forum_name, String.valueOf(dNw[this.nlq.nlE].forum_id));
            } else {
                this.fpO.gr(dNw[this.nlr.nlE].forum_name, String.valueOf(dNw[this.nlr.nlE].forum_id));
            }
        }
    }
}
