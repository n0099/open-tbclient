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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean gma = false;
    private static String jZH = "";
    private static String jZI = "";
    private static String jZJ = "";
    private static String jZK = "";
    private com.baidu.tieba.square.flist.b jZA;
    private com.baidu.tieba.square.flist.b jZB;
    private DirMenuModel jZC;
    private ForumListDetailModel jZD;
    private int jZe;
    private int jZf;
    private Drawable jZg;
    private Drawable jZh;
    private Drawable jZi;
    private Drawable jZj;
    private Drawable jZk;
    private Drawable jZl;
    public com.baidu.tieba.square.flist.c jZw;
    private ForumListModel.RequestParams jZx;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int jZm = 200;
    private int jZn = 200;
    private int jZo = 0;
    private final LikeModel dfN = new LikeModel(getPageContext());
    private boolean jZp = false;
    private int jZq = 0;
    private boolean jZr = false;
    private int jZs = 0;
    private int jZt = 200;
    private boolean jZu = true;
    private boolean jZv = true;
    private boolean jZy = false;
    private boolean jZz = false;
    private final ForumListDetailModel.a jZE = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jZA.cHS() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jZw.cHY();
                ForumListActivity.this.jZw.cHX();
                if (ForumListActivity.this.jZx.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jZw.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jZx.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jZw.cHX();
                    ForumListActivity.this.jZx.recommend_type = ForumListActivity.this.jZs;
                    ForumListActivity.this.jZx.rn = ForumListActivity.this.jZt;
                }
                ForumListActivity.this.jZw.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jZw.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.jZr) {
                    ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZw.kak.setImageDrawable(ForumListActivity.this.jZk);
                    ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZw.kan.setImageDrawable(ForumListActivity.this.jZk);
                    ForumListActivity.this.jZr = false;
                }
                ForumListActivity.this.jZw.ayC.setText(ForumListActivity.this.jZx.menu_name);
                ForumListActivity.this.jZw.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jZw.kau.Cc(ForumListActivity.this.jZq);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jZA.Bo(min);
                ForumListActivity.this.jZA.a(ForumListActivity.this.dfN);
                ForumListActivity.this.jZA.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jZw.kae.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jZw.jZZ.setVisibility(0);
                } else {
                    ForumListActivity.this.jZw.jZZ.setVisibility(8);
                }
                ForumListActivity.this.jZw.kag.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jZB.Bo(min2);
                ForumListActivity.this.jZB.a(ForumListActivity.this.dfN);
                ForumListActivity.this.jZB.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jZw.kaf.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jZw.kaa.setVisibility(0);
                } else {
                    ForumListActivity.this.jZw.kaa.setVisibility(8);
                }
                ForumListActivity.this.jZw.kah.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jZw.cHX();
                if (ForumListActivity.this.jZw.kau.getCount() > 0) {
                    ForumListActivity.this.jZw.kaw.setClickable(true);
                    ForumListActivity.this.jZw.kaw.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jZF = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jZw.cHY();
                    return;
                }
                return;
            }
            eVar.kbc.add(0, eVar);
            if (ForumListActivity.this.jZw.kau != null) {
                ForumListActivity.this.jZw.kau.a(eVar);
                ForumListActivity.this.Ix(String.valueOf(ForumListActivity.this.jZw.ayC.getText()));
                ForumListActivity.this.jZw.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jZw.kau.notifyDataSetChanged();
            }
            ForumListActivity.this.jZw.kaw.setClickable(true);
            ForumListActivity.this.jZw.kaw.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jZG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.jZw.kaq, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.jZq = i;
            ForumListActivity.this.jZw.cHY();
            ForumListActivity.this.jZw.cHZ();
            ArrayList<e> arrayList = ForumListActivity.this.jZw.kau.cHL().kbc;
            ForumListActivity.this.at(arrayList.get(i).jYY, arrayList.get(i).jZa, arrayList.get(i).jYZ);
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.jZA.cHU() && !ForumListActivity.this.jZB.cHU()) {
                if (ForumListActivity.this.jZu) {
                    ForumListActivity.this.jZx.recommend_type = 0;
                    ForumListActivity.this.jZx.rn = 200;
                    ForumListActivity.this.jZD.a(ForumListActivity.this.jZx);
                    ForumListActivity.this.jZD.LoadData();
                    ForumListActivity.this.jZu = false;
                } else if (ForumListActivity.this.jZw.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jZy) {
                        ForumListActivity.this.jZm = 50;
                    } else {
                        ForumListActivity.this.jZm = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jZw.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jZz) {
                        ForumListActivity.this.jZn = 50;
                    } else {
                        ForumListActivity.this.jZn = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix(String str) {
        e cHL = this.jZw.kau.cHL();
        if (cHL != null) {
            ArrayList<e> arrayList = cHL.kbc;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).jYY.equals(str)) {
                    this.jZq = i;
                    this.jZw.kau.Cc(this.jZq);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.jZx.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jZx.menu_name = str;
        this.jZx.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.jZx.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jZx.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jZx.offset = 0;
        this.jZx.rn = 10;
        this.jZs = this.jZx.recommend_type;
        this.jZt = this.jZx.rn;
        this.jZx.recommend_type = 0;
        this.jZx.rn = 200;
        this.jZr = true;
        this.jZD.a(this.jZx);
        this.jZD.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jZN;

        private b() {
            this.jZN = false;
        }

        public void sA(boolean z) {
            this.jZN = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jZw.kal.setEnabled(false);
            ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jZx.recommend_type = 2;
                ForumListActivity.this.jZx.offset = 0;
                ForumListActivity.this.jZx.rn = ForumListActivity.this.jZn;
                return ForumListModel.new_fetch(ForumListActivity.this.jZx);
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
                ForumListActivity.this.jZB.Bo(min);
                ForumListActivity.this.jZB.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.jZn == 200) {
                    ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZw.kan.setImageDrawable(ForumListActivity.this.jZk);
                } else {
                    ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jZw.kan.setImageDrawable(ForumListActivity.this.jZl);
                    ForumListActivity.this.jZz = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jZN) {
                    if (ForumListActivity.this.jZn == 200) {
                        ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jZw.kan.setImageDrawable(ForumListActivity.this.jZk);
                    } else {
                        ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jZw.kan.setImageDrawable(ForumListActivity.this.jZl);
                    }
                } else {
                    ForumListActivity.this.jZw.kam.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZw.kan.setImageDrawable(ForumListActivity.this.jZk);
                    ForumListActivity.this.jZx.rn = 200;
                    ForumListActivity.this.jZn = 200;
                }
            }
            ForumListActivity.this.jZw.kal.setEnabled(true);
            ForumListActivity.this.jZw.cHX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jZN;

        private c() {
            this.jZN = false;
        }

        public void sA(boolean z) {
            this.jZN = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jZw.kai.setEnabled(false);
            ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jZx.recommend_type = 1;
                ForumListActivity.this.jZx.offset = 0;
                ForumListActivity.this.jZx.rn = ForumListActivity.this.jZm;
                return ForumListModel.new_fetch(ForumListActivity.this.jZx);
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
                ForumListActivity.this.jZA.Bo(min);
                ForumListActivity.this.jZA.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.jZm == 200) {
                    ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZw.kak.setImageDrawable(ForumListActivity.this.jZk);
                } else {
                    ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jZw.kak.setImageDrawable(ForumListActivity.this.jZl);
                    ForumListActivity.this.jZy = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jZN) {
                    if (ForumListActivity.this.jZm == 200) {
                        ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jZw.kak.setImageDrawable(ForumListActivity.this.jZk);
                    } else {
                        ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jZw.kak.setImageDrawable(ForumListActivity.this.jZl);
                    }
                } else {
                    ForumListActivity.this.jZw.kaj.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZw.kak.setImageDrawable(ForumListActivity.this.jZk);
                    ForumListActivity.this.jZx.rn = 200;
                    ForumListActivity.this.jZm = 200;
                }
            }
            ForumListActivity.this.jZw.kai.setEnabled(true);
            ForumListActivity.this.jZw.cHX();
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4) {
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
        this.jZw = new com.baidu.tieba.square.flist.c(this);
        this.jZw.kae = (BdListView) cHN();
        this.jZw.kaf = (BdListView) cHP();
        this.jZw.mProgressBar.setVisibility(0);
        this.jZw.kaw.setOnClickListener(null);
        this.jZw.kaw.setClickable(false);
        this.jZw.mViewPager.setAdapter(new a());
        this.jZw.kae.setPullRefresh(this.jZw.kao);
        this.jZw.kaf.setPullRefresh(this.jZw.kap);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.jZw.kae.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.jZw.kaf.addHeaderView(textView2, 0);
        this.jZA = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jZw.kae.setAdapter((ListAdapter) this.jZA);
        this.jZB = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jZw.kaf.setAdapter((ListAdapter) this.jZB);
        z(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void z(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jZw.ayC.setText(str4);
        this.jZw.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jZx = new ForumListModel.RequestParams();
        this.jZx.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jZx.menu_name = str4;
        this.jZx.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.jZx.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jZx.parent_menu_name = str;
        this.jZx.offset = 0;
        this.jZx.rn = 10;
        if (this.jZx.menu_id != 0) {
            this.jZw.cHW();
            this.jZp = true;
            this.jZv = false;
            this.jZA.m(Boolean.valueOf(this.jZv));
            this.jZw.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jZv = true;
            this.jZA.m(Boolean.valueOf(this.jZv));
            this.jZw.cHV();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jZw.kao.setListPullRefreshListener(this.enH);
        this.jZw.kap.setListPullRefreshListener(this.enH);
        this.jZA.notifyDataSetChanged();
        this.jZB.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jZw.cHY();
        } else {
            this.jZC = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jZC.a(this.jZF);
            this.jZC.LoadData();
        }
        this.jZD = new ForumListDetailModel(getPageContext(), this.jZx);
        this.jZD.a(this.jZE);
        this.jZw.kae.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (gma) {
            gma = false;
            finish();
            b(getPageContext().getPageActivity(), jZH, jZJ, jZI, jZK);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jZA != null) {
                this.jZA.cHT();
                this.jZA.notifyDataSetChanged();
            }
            if (this.jZB != null) {
                this.jZB.cHT();
                this.jZB.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfN != null) {
            this.dfN.cIM();
        }
        this.jZw.mViewPager.setAdapter(null);
        this.jZw.kaf.setAdapter((ListAdapter) null);
        this.jZw.kae.setAdapter((ListAdapter) null);
        if (this.jZw.kat != null) {
            this.jZw.kat.setAdapter((ListAdapter) null);
        }
        if (this.jZC != null) {
            this.jZC.cancelLoadData();
        }
        if (this.jZD != null) {
            this.jZD.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jZw.fZy);
        this.jZw.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jZA.sB(true);
            this.jZB.sB(true);
        } else {
            this.jZA.sB(false);
            this.jZB.sB(false);
        }
        this.jZA.notifyDataSetChanged();
        this.jZB.notifyDataSetChanged();
        if (this.jZw.kaq != null) {
            this.jZw.kaq.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.jZw.kab, R.drawable.bg_pop_most);
        this.jZe = am.getColor(R.color.common_color_10243);
        this.jZf = am.getColor(R.color.cp_cont_a);
        this.jZg = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.jZh = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.jZi = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.jZj = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.jZk = am.getDrawable(R.drawable.ico_downward);
        this.jZl = am.getDrawable(R.drawable.ico_upward);
        this.jZA.cF(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jZB.cF(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jZw.kaa, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jZw.kam, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.jZw.jZZ, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jZw.kaj, R.color.common_color_10243, 1);
        if (this.jZy) {
            am.setImageResource(this.jZw.kak, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jZw.kak, R.drawable.ico_downward);
        }
        if (this.jZz) {
            am.setImageResource(this.jZw.kan, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jZw.kan, R.drawable.ico_downward);
        }
        if (this.jZw.mViewPager.getCurrentItem() == 0) {
            this.jZw.kag.setTextColor(this.jZf);
            this.jZw.kag.setBackgroundDrawable(this.jZi);
            this.jZw.kah.setBackgroundDrawable(this.jZh);
            this.jZw.kah.setTextColor(this.jZe);
            return;
        }
        this.jZw.kah.setTextColor(this.jZf);
        this.jZw.kah.setBackgroundDrawable(this.jZj);
        this.jZw.kag.setBackgroundDrawable(this.jZg);
        this.jZw.kag.setTextColor(this.jZe);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jZw.mViewPager.setCurrentItem(0);
            this.jZo = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jZw.mViewPager.setCurrentItem(1);
            this.jZo = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jZw.d(this.jZG);
        }
    }

    private View cHN() {
        this.jZw.kae = cHR();
        this.jZw.kai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cHO();
            }
        });
        return this.jZw.kae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHO() {
        if (this.jZy) {
            int min = Math.min(this.jZA.getCount(), 200);
            this.jZm = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jZA.cHS(), 0, forumInfoDataArr, 0, min);
            this.jZA.Bo(min);
            this.jZA.a(forumInfoDataArr);
            this.jZy = false;
            this.jZw.kaj.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jZw.kak.setImageDrawable(this.jZk);
            return;
        }
        this.jZm = 50;
        c cVar = new c();
        cVar.sA(true);
        cVar.execute(new Void[0]);
    }

    private View cHP() {
        this.jZw.kaf = cHR();
        this.jZw.kal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cHQ();
            }
        });
        return this.jZw.kaf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHQ() {
        if (this.jZz) {
            int min = Math.min(this.jZB.getCount(), 200);
            this.jZn = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jZB.cHS(), 0, forumInfoDataArr, 0, min);
            this.jZB.Bo(min);
            this.jZB.a(forumInfoDataArr);
            this.jZz = false;
            this.jZw.kam.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jZw.kan.setImageDrawable(this.jZk);
            return;
        }
        this.jZn = 50;
        b bVar = new b();
        bVar.sA(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cHR() {
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
        if (!this.jZp) {
            if (i == 0) {
                this.jZA.cHT();
                this.jZA.notifyDataSetChanged();
                this.jZw.kag.setBackgroundDrawable(this.jZi);
                this.jZw.kag.setTextColor(this.jZf);
                this.jZw.kah.setBackgroundDrawable(this.jZh);
                this.jZw.kah.setTextColor(this.jZe);
            } else if (i == 1) {
                this.jZB.cHT();
                this.jZB.notifyDataSetChanged();
                this.jZw.kah.setBackgroundDrawable(this.jZj);
                this.jZw.kah.setTextColor(this.jZf);
                this.jZw.kag.setBackgroundDrawable(this.jZg);
                this.jZw.kag.setTextColor(this.jZe);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes8.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.jZp ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jZw.kae);
                    return ForumListActivity.this.jZw.kae;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jZw.kaf);
                    return ForumListActivity.this.jZw.kaf;
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
        final ForumInfoData[] cHS;
        if (i == 11002 && i2 == -1) {
            this.jZD.LoadData();
            if (this.jZo == 0) {
                cHS = this.jZA.cHS();
            } else {
                cHS = this.jZB.cHS();
            }
            this.dfN.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dfN.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dfN.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dfN.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.jZo == 0) {
                                ForumListActivity.this.jZA.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cHS[ForumListActivity.this.jZA.jZO].forum_name);
                            } else if (ForumListActivity.this.jZo == 1) {
                                ForumListActivity.this.jZB.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cHS[ForumListActivity.this.jZB.jZO].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.jZo == 0) {
                this.dfN.et(cHS[this.jZA.jZO].forum_name, String.valueOf(cHS[this.jZA.jZO].forum_id));
            } else {
                this.dfN.et(cHS[this.jZB.jZO].forum_name, String.valueOf(cHS[this.jZB.jZO].forum_id));
            }
        }
    }
}
