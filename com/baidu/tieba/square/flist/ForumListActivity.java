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
    private static String jZM = "";
    private static String jZN = "";
    private static String jZO = "";
    private static String jZP = "";
    public com.baidu.tieba.square.flist.c jZB;
    private ForumListModel.RequestParams jZC;
    private com.baidu.tieba.square.flist.b jZF;
    private com.baidu.tieba.square.flist.b jZG;
    private DirMenuModel jZH;
    private ForumListDetailModel jZI;
    private int jZj;
    private int jZk;
    private Drawable jZl;
    private Drawable jZm;
    private Drawable jZn;
    private Drawable jZo;
    private Drawable jZp;
    private Drawable jZq;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int jZr = 200;
    private int jZs = 200;
    private int jZt = 0;
    private final LikeModel dfN = new LikeModel(getPageContext());
    private boolean jZu = false;
    private int jZv = 0;
    private boolean jZw = false;
    private int jZx = 0;
    private int jZy = 200;
    private boolean jZz = true;
    private boolean jZA = true;
    private boolean jZD = false;
    private boolean jZE = false;
    private final ForumListDetailModel.a jZJ = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jZF.cHU() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jZB.cIa();
                ForumListActivity.this.jZB.cHZ();
                if (ForumListActivity.this.jZC.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jZB.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jZC.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jZB.cHZ();
                    ForumListActivity.this.jZC.recommend_type = ForumListActivity.this.jZx;
                    ForumListActivity.this.jZC.rn = ForumListActivity.this.jZy;
                }
                ForumListActivity.this.jZB.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jZB.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.jZw) {
                    ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZB.kap.setImageDrawable(ForumListActivity.this.jZp);
                    ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZB.kas.setImageDrawable(ForumListActivity.this.jZp);
                    ForumListActivity.this.jZw = false;
                }
                ForumListActivity.this.jZB.ayC.setText(ForumListActivity.this.jZC.menu_name);
                ForumListActivity.this.jZB.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jZB.kaA.Cc(ForumListActivity.this.jZv);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jZF.Bo(min);
                ForumListActivity.this.jZF.a(ForumListActivity.this.dfN);
                ForumListActivity.this.jZF.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jZB.kaj.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jZB.kae.setVisibility(0);
                } else {
                    ForumListActivity.this.jZB.kae.setVisibility(8);
                }
                ForumListActivity.this.jZB.kal.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jZG.Bo(min2);
                ForumListActivity.this.jZG.a(ForumListActivity.this.dfN);
                ForumListActivity.this.jZG.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jZB.kak.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jZB.kaf.setVisibility(0);
                } else {
                    ForumListActivity.this.jZB.kaf.setVisibility(8);
                }
                ForumListActivity.this.jZB.kam.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jZB.cHZ();
                if (ForumListActivity.this.jZB.kaA.getCount() > 0) {
                    ForumListActivity.this.jZB.kaB.setClickable(true);
                    ForumListActivity.this.jZB.kaB.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jZK = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jZB.cIa();
                    return;
                }
                return;
            }
            eVar.kbh.add(0, eVar);
            if (ForumListActivity.this.jZB.kaA != null) {
                ForumListActivity.this.jZB.kaA.a(eVar);
                ForumListActivity.this.Ix(String.valueOf(ForumListActivity.this.jZB.ayC.getText()));
                ForumListActivity.this.jZB.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jZB.kaA.notifyDataSetChanged();
            }
            ForumListActivity.this.jZB.kaB.setClickable(true);
            ForumListActivity.this.jZB.kaB.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jZL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.jZB.kaw, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.jZv = i;
            ForumListActivity.this.jZB.cIa();
            ForumListActivity.this.jZB.cIb();
            ArrayList<e> arrayList = ForumListActivity.this.jZB.kaA.cHN().kbh;
            ForumListActivity.this.at(arrayList.get(i).jZd, arrayList.get(i).jZf, arrayList.get(i).jZe);
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.jZF.cHW() && !ForumListActivity.this.jZG.cHW()) {
                if (ForumListActivity.this.jZz) {
                    ForumListActivity.this.jZC.recommend_type = 0;
                    ForumListActivity.this.jZC.rn = 200;
                    ForumListActivity.this.jZI.a(ForumListActivity.this.jZC);
                    ForumListActivity.this.jZI.LoadData();
                    ForumListActivity.this.jZz = false;
                } else if (ForumListActivity.this.jZB.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jZD) {
                        ForumListActivity.this.jZr = 50;
                    } else {
                        ForumListActivity.this.jZr = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jZB.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jZE) {
                        ForumListActivity.this.jZs = 50;
                    } else {
                        ForumListActivity.this.jZs = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix(String str) {
        e cHN = this.jZB.kaA.cHN();
        if (cHN != null) {
            ArrayList<e> arrayList = cHN.kbh;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).jZd.equals(str)) {
                    this.jZv = i;
                    this.jZB.kaA.Cc(this.jZv);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.jZC.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jZC.menu_name = str;
        this.jZC.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.jZC.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jZC.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jZC.offset = 0;
        this.jZC.rn = 10;
        this.jZx = this.jZC.recommend_type;
        this.jZy = this.jZC.rn;
        this.jZC.recommend_type = 0;
        this.jZC.rn = 200;
        this.jZw = true;
        this.jZI.a(this.jZC);
        this.jZI.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jZS;

        private b() {
            this.jZS = false;
        }

        public void sA(boolean z) {
            this.jZS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jZB.kaq.setEnabled(false);
            ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jZC.recommend_type = 2;
                ForumListActivity.this.jZC.offset = 0;
                ForumListActivity.this.jZC.rn = ForumListActivity.this.jZs;
                return ForumListModel.new_fetch(ForumListActivity.this.jZC);
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
                ForumListActivity.this.jZG.Bo(min);
                ForumListActivity.this.jZG.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.jZs == 200) {
                    ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZB.kas.setImageDrawable(ForumListActivity.this.jZp);
                } else {
                    ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jZB.kas.setImageDrawable(ForumListActivity.this.jZq);
                    ForumListActivity.this.jZE = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jZS) {
                    if (ForumListActivity.this.jZs == 200) {
                        ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jZB.kas.setImageDrawable(ForumListActivity.this.jZp);
                    } else {
                        ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jZB.kas.setImageDrawable(ForumListActivity.this.jZq);
                    }
                } else {
                    ForumListActivity.this.jZB.kar.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZB.kas.setImageDrawable(ForumListActivity.this.jZp);
                    ForumListActivity.this.jZC.rn = 200;
                    ForumListActivity.this.jZs = 200;
                }
            }
            ForumListActivity.this.jZB.kaq.setEnabled(true);
            ForumListActivity.this.jZB.cHZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jZS;

        private c() {
            this.jZS = false;
        }

        public void sA(boolean z) {
            this.jZS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jZB.kan.setEnabled(false);
            ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jZC.recommend_type = 1;
                ForumListActivity.this.jZC.offset = 0;
                ForumListActivity.this.jZC.rn = ForumListActivity.this.jZr;
                return ForumListModel.new_fetch(ForumListActivity.this.jZC);
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
                ForumListActivity.this.jZF.Bo(min);
                ForumListActivity.this.jZF.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.jZr == 200) {
                    ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZB.kap.setImageDrawable(ForumListActivity.this.jZp);
                } else {
                    ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jZB.kap.setImageDrawable(ForumListActivity.this.jZq);
                    ForumListActivity.this.jZD = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jZS) {
                    if (ForumListActivity.this.jZr == 200) {
                        ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jZB.kap.setImageDrawable(ForumListActivity.this.jZp);
                    } else {
                        ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jZB.kap.setImageDrawable(ForumListActivity.this.jZq);
                    }
                } else {
                    ForumListActivity.this.jZB.kao.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jZB.kap.setImageDrawable(ForumListActivity.this.jZp);
                    ForumListActivity.this.jZC.rn = 200;
                    ForumListActivity.this.jZr = 200;
                }
            }
            ForumListActivity.this.jZB.kan.setEnabled(true);
            ForumListActivity.this.jZB.cHZ();
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
        this.jZB = new com.baidu.tieba.square.flist.c(this);
        this.jZB.kaj = (BdListView) cHP();
        this.jZB.kak = (BdListView) cHR();
        this.jZB.mProgressBar.setVisibility(0);
        this.jZB.kaB.setOnClickListener(null);
        this.jZB.kaB.setClickable(false);
        this.jZB.mViewPager.setAdapter(new a());
        this.jZB.kaj.setPullRefresh(this.jZB.kat);
        this.jZB.kak.setPullRefresh(this.jZB.kau);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.jZB.kaj.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.jZB.kak.addHeaderView(textView2, 0);
        this.jZF = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jZB.kaj.setAdapter((ListAdapter) this.jZF);
        this.jZG = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jZB.kak.setAdapter((ListAdapter) this.jZG);
        z(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void z(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jZB.ayC.setText(str4);
        this.jZB.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jZC = new ForumListModel.RequestParams();
        this.jZC.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jZC.menu_name = str4;
        this.jZC.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.jZC.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jZC.parent_menu_name = str;
        this.jZC.offset = 0;
        this.jZC.rn = 10;
        if (this.jZC.menu_id != 0) {
            this.jZB.cHY();
            this.jZu = true;
            this.jZA = false;
            this.jZF.m(Boolean.valueOf(this.jZA));
            this.jZB.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jZA = true;
            this.jZF.m(Boolean.valueOf(this.jZA));
            this.jZB.cHX();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jZB.kat.setListPullRefreshListener(this.enH);
        this.jZB.kau.setListPullRefreshListener(this.enH);
        this.jZF.notifyDataSetChanged();
        this.jZG.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jZB.cIa();
        } else {
            this.jZH = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jZH.a(this.jZK);
            this.jZH.LoadData();
        }
        this.jZI = new ForumListDetailModel(getPageContext(), this.jZC);
        this.jZI.a(this.jZJ);
        this.jZB.kaj.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (gma) {
            gma = false;
            finish();
            b(getPageContext().getPageActivity(), jZM, jZO, jZN, jZP);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jZF != null) {
                this.jZF.cHV();
                this.jZF.notifyDataSetChanged();
            }
            if (this.jZG != null) {
                this.jZG.cHV();
                this.jZG.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfN != null) {
            this.dfN.cIO();
        }
        this.jZB.mViewPager.setAdapter(null);
        this.jZB.kak.setAdapter((ListAdapter) null);
        this.jZB.kaj.setAdapter((ListAdapter) null);
        if (this.jZB.kaz != null) {
            this.jZB.kaz.setAdapter((ListAdapter) null);
        }
        if (this.jZH != null) {
            this.jZH.cancelLoadData();
        }
        if (this.jZI != null) {
            this.jZI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jZB.fZy);
        this.jZB.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jZF.sB(true);
            this.jZG.sB(true);
        } else {
            this.jZF.sB(false);
            this.jZG.sB(false);
        }
        this.jZF.notifyDataSetChanged();
        this.jZG.notifyDataSetChanged();
        if (this.jZB.kaw != null) {
            this.jZB.kaw.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.jZB.kag, R.drawable.bg_pop_most);
        this.jZj = am.getColor(R.color.common_color_10243);
        this.jZk = am.getColor(R.color.cp_cont_a);
        this.jZl = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.jZm = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.jZn = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.jZo = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.jZp = am.getDrawable(R.drawable.ico_downward);
        this.jZq = am.getDrawable(R.drawable.ico_upward);
        this.jZF.cF(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jZG.cF(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jZB.kaf, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jZB.kar, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.jZB.kae, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jZB.kao, R.color.common_color_10243, 1);
        if (this.jZD) {
            am.setImageResource(this.jZB.kap, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jZB.kap, R.drawable.ico_downward);
        }
        if (this.jZE) {
            am.setImageResource(this.jZB.kas, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jZB.kas, R.drawable.ico_downward);
        }
        if (this.jZB.mViewPager.getCurrentItem() == 0) {
            this.jZB.kal.setTextColor(this.jZk);
            this.jZB.kal.setBackgroundDrawable(this.jZn);
            this.jZB.kam.setBackgroundDrawable(this.jZm);
            this.jZB.kam.setTextColor(this.jZj);
            return;
        }
        this.jZB.kam.setTextColor(this.jZk);
        this.jZB.kam.setBackgroundDrawable(this.jZo);
        this.jZB.kal.setBackgroundDrawable(this.jZl);
        this.jZB.kal.setTextColor(this.jZj);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jZB.mViewPager.setCurrentItem(0);
            this.jZt = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jZB.mViewPager.setCurrentItem(1);
            this.jZt = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jZB.d(this.jZL);
        }
    }

    private View cHP() {
        this.jZB.kaj = cHT();
        this.jZB.kan.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cHQ();
            }
        });
        return this.jZB.kaj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHQ() {
        if (this.jZD) {
            int min = Math.min(this.jZF.getCount(), 200);
            this.jZr = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jZF.cHU(), 0, forumInfoDataArr, 0, min);
            this.jZF.Bo(min);
            this.jZF.a(forumInfoDataArr);
            this.jZD = false;
            this.jZB.kao.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jZB.kap.setImageDrawable(this.jZp);
            return;
        }
        this.jZr = 50;
        c cVar = new c();
        cVar.sA(true);
        cVar.execute(new Void[0]);
    }

    private View cHR() {
        this.jZB.kak = cHT();
        this.jZB.kaq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cHS();
            }
        });
        return this.jZB.kak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHS() {
        if (this.jZE) {
            int min = Math.min(this.jZG.getCount(), 200);
            this.jZs = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jZG.cHU(), 0, forumInfoDataArr, 0, min);
            this.jZG.Bo(min);
            this.jZG.a(forumInfoDataArr);
            this.jZE = false;
            this.jZB.kar.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jZB.kas.setImageDrawable(this.jZp);
            return;
        }
        this.jZs = 50;
        b bVar = new b();
        bVar.sA(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cHT() {
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
        if (!this.jZu) {
            if (i == 0) {
                this.jZF.cHV();
                this.jZF.notifyDataSetChanged();
                this.jZB.kal.setBackgroundDrawable(this.jZn);
                this.jZB.kal.setTextColor(this.jZk);
                this.jZB.kam.setBackgroundDrawable(this.jZm);
                this.jZB.kam.setTextColor(this.jZj);
            } else if (i == 1) {
                this.jZG.cHV();
                this.jZG.notifyDataSetChanged();
                this.jZB.kam.setBackgroundDrawable(this.jZo);
                this.jZB.kam.setTextColor(this.jZk);
                this.jZB.kal.setBackgroundDrawable(this.jZl);
                this.jZB.kal.setTextColor(this.jZj);
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
            return ForumListActivity.this.jZu ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jZB.kaj);
                    return ForumListActivity.this.jZB.kaj;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jZB.kak);
                    return ForumListActivity.this.jZB.kak;
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
        final ForumInfoData[] cHU;
        if (i == 11002 && i2 == -1) {
            this.jZI.LoadData();
            if (this.jZt == 0) {
                cHU = this.jZF.cHU();
            } else {
                cHU = this.jZG.cHU();
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
                            if (ForumListActivity.this.jZt == 0) {
                                ForumListActivity.this.jZF.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cHU[ForumListActivity.this.jZF.jZT].forum_name);
                            } else if (ForumListActivity.this.jZt == 1) {
                                ForumListActivity.this.jZG.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cHU[ForumListActivity.this.jZG.jZT].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.jZt == 0) {
                this.dfN.et(cHU[this.jZF.jZT].forum_name, String.valueOf(cHU[this.jZF.jZT].forum_id));
            } else {
                this.dfN.et(cHU[this.jZG.jZT].forum_name, String.valueOf(cHU[this.jZG.jZT].forum_id));
            }
        }
    }
}
