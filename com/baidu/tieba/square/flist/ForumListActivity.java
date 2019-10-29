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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    private int jbW;
    private int jbX;
    private Drawable jbY;
    private Drawable jbZ;
    private Drawable jca;
    private Drawable jcb;
    private Drawable jcc;
    private Drawable jcd;
    public com.baidu.tieba.square.flist.c jco;
    private ForumListModel.RequestParams jcp;
    private com.baidu.tieba.square.flist.b jcs;
    private com.baidu.tieba.square.flist.b jct;
    private DirMenuModel jcu;
    private ForumListDetailModel jcv;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    public static boolean fvf = false;
    private static String jcz = "";
    private static String jcA = "";
    private static String jcB = "";
    private static String jcC = "";
    private int jce = 200;
    private int jcf = 200;
    private int jcg = 0;
    private final LikeModel csF = new LikeModel(getPageContext());
    private boolean jch = false;
    private int jci = 0;
    private boolean jcj = false;
    private int jck = 0;
    private int jcl = 200;
    private boolean jcm = true;
    private boolean jcn = true;
    private boolean jcq = false;
    private boolean jcr = false;
    private final ForumListDetailModel.a jcw = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jcs.cmH() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jco.cmN();
                ForumListActivity.this.jco.cmM();
                if (ForumListActivity.this.jcp.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jco.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jcp.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jco.cmM();
                    ForumListActivity.this.jcp.recommend_type = ForumListActivity.this.jck;
                    ForumListActivity.this.jcp.rn = ForumListActivity.this.jcl;
                }
                ForumListActivity.this.jco.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jco.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.jcj) {
                    ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jco.jdc.setImageDrawable(ForumListActivity.this.jcc);
                    ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jco.jdf.setImageDrawable(ForumListActivity.this.jcc);
                    ForumListActivity.this.jcj = false;
                }
                ForumListActivity.this.jco.aqv.setText(ForumListActivity.this.jcp.menu_name);
                ForumListActivity.this.jco.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jco.jdm.zC(ForumListActivity.this.jci);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jcs.yP(min);
                ForumListActivity.this.jcs.a(ForumListActivity.this.csF);
                ForumListActivity.this.jcs.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jco.jcW.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jco.jcR.setVisibility(0);
                } else {
                    ForumListActivity.this.jco.jcR.setVisibility(8);
                }
                ForumListActivity.this.jco.jcY.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jct.yP(min2);
                ForumListActivity.this.jct.a(ForumListActivity.this.csF);
                ForumListActivity.this.jct.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jco.jcX.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jco.jcS.setVisibility(0);
                } else {
                    ForumListActivity.this.jco.jcS.setVisibility(8);
                }
                ForumListActivity.this.jco.jcZ.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jco.cmM();
                if (ForumListActivity.this.jco.jdm.getCount() > 0) {
                    ForumListActivity.this.jco.jdn.setClickable(true);
                    ForumListActivity.this.jco.jdn.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jcx = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jco.cmN();
                    return;
                }
                return;
            }
            dVar.jed.add(0, dVar);
            if (ForumListActivity.this.jco.jdm != null) {
                ForumListActivity.this.jco.jdm.a(dVar);
                ForumListActivity.this.DA(String.valueOf(ForumListActivity.this.jco.aqv.getText()));
                ForumListActivity.this.jco.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jco.jdm.notifyDataSetChanged();
            }
            ForumListActivity.this.jco.jdn.setClickable(true);
            ForumListActivity.this.jco.jdn.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jcy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.jco.jdi, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.jci = i;
            ForumListActivity.this.jco.cmN();
            ForumListActivity.this.jco.cmO();
            ArrayList<d> arrayList = ForumListActivity.this.jco.jdm.cmA().jed;
            ForumListActivity.this.af(arrayList.get(i).jbQ, arrayList.get(i).jbS, arrayList.get(i).jbR);
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.jcs.cmJ() && !ForumListActivity.this.jct.cmJ()) {
                if (ForumListActivity.this.jcm) {
                    ForumListActivity.this.jcp.recommend_type = 0;
                    ForumListActivity.this.jcp.rn = 200;
                    ForumListActivity.this.jcv.a(ForumListActivity.this.jcp);
                    ForumListActivity.this.jcv.LoadData();
                    ForumListActivity.this.jcm = false;
                } else if (ForumListActivity.this.jco.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jcq) {
                        ForumListActivity.this.jce = 50;
                    } else {
                        ForumListActivity.this.jce = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jco.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jcr) {
                        ForumListActivity.this.jcf = 50;
                    } else {
                        ForumListActivity.this.jcf = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void DA(String str) {
        d cmA = this.jco.jdm.cmA();
        if (cmA != null) {
            ArrayList<d> arrayList = cmA.jed;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).jbQ.equals(str)) {
                    this.jci = i;
                    this.jco.jdm.zC(this.jci);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str, String str2, String str3) {
        this.jcp.menu_id = com.baidu.adp.lib.g.b.toInt(str2, 0);
        this.jcp.menu_name = str;
        this.jcp.menu_type = com.baidu.adp.lib.g.b.toInt(str3, 0);
        this.jcp.parent_menu_id = com.baidu.adp.lib.g.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jcp.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jcp.offset = 0;
        this.jcp.rn = 10;
        this.jck = this.jcp.recommend_type;
        this.jcl = this.jcp.rn;
        this.jcp.recommend_type = 0;
        this.jcp.rn = 200;
        this.jcj = true;
        this.jcv.a(this.jcp);
        this.jcv.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jcF;

        private b() {
            this.jcF = false;
        }

        public void qG(boolean z) {
            this.jcF = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jco.jdd.setEnabled(false);
            ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jcp.recommend_type = 2;
                ForumListActivity.this.jcp.offset = 0;
                ForumListActivity.this.jcp.rn = ForumListActivity.this.jcf;
                return ForumListModel.new_fetch(ForumListActivity.this.jcp);
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
                ForumListActivity.this.jct.yP(min);
                ForumListActivity.this.jct.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.jcf == 200) {
                    ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jco.jdf.setImageDrawable(ForumListActivity.this.jcc);
                } else {
                    ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jco.jdf.setImageDrawable(ForumListActivity.this.jcd);
                    ForumListActivity.this.jcr = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jcF) {
                    if (ForumListActivity.this.jcf == 200) {
                        ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jco.jdf.setImageDrawable(ForumListActivity.this.jcc);
                    } else {
                        ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jco.jdf.setImageDrawable(ForumListActivity.this.jcd);
                    }
                } else {
                    ForumListActivity.this.jco.jde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jco.jdf.setImageDrawable(ForumListActivity.this.jcc);
                    ForumListActivity.this.jcp.rn = 200;
                    ForumListActivity.this.jcf = 200;
                }
            }
            ForumListActivity.this.jco.jdd.setEnabled(true);
            ForumListActivity.this.jco.cmM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jcF;

        private c() {
            this.jcF = false;
        }

        public void qG(boolean z) {
            this.jcF = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jco.jda.setEnabled(false);
            ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jcp.recommend_type = 1;
                ForumListActivity.this.jcp.offset = 0;
                ForumListActivity.this.jcp.rn = ForumListActivity.this.jce;
                return ForumListModel.new_fetch(ForumListActivity.this.jcp);
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
                ForumListActivity.this.jcs.yP(min);
                ForumListActivity.this.jcs.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.jce == 200) {
                    ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jco.jdc.setImageDrawable(ForumListActivity.this.jcc);
                } else {
                    ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jco.jdc.setImageDrawable(ForumListActivity.this.jcd);
                    ForumListActivity.this.jcq = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jcF) {
                    if (ForumListActivity.this.jce == 200) {
                        ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jco.jdc.setImageDrawable(ForumListActivity.this.jcc);
                    } else {
                        ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jco.jdc.setImageDrawable(ForumListActivity.this.jcd);
                    }
                } else {
                    ForumListActivity.this.jco.jdb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jco.jdc.setImageDrawable(ForumListActivity.this.jcc);
                    ForumListActivity.this.jcp.rn = 200;
                    ForumListActivity.this.jce = 200;
                }
            }
            ForumListActivity.this.jco.jda.setEnabled(true);
            ForumListActivity.this.jco.cmM();
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
        this.jco = new com.baidu.tieba.square.flist.c(this);
        this.jco.jcW = (BdListView) cmC();
        this.jco.jcX = (BdListView) cmE();
        this.jco.mProgressBar.setVisibility(0);
        this.jco.jdn.setOnClickListener(null);
        this.jco.jdn.setClickable(false);
        this.jco.mViewPager.setAdapter(new a());
        this.jco.jcW.setPullRefresh(this.jco.jdg);
        this.jco.jcX.setPullRefresh(this.jco.jdh);
        if (com.baidu.adp.lib.g.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.jco.jcW.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.jco.jcX.addHeaderView(textView2, 0);
        this.jcs = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jco.jcW.setAdapter((ListAdapter) this.jcs);
        this.jct = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jco.jcX.setAdapter((ListAdapter) this.jct);
        x(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void x(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jco.aqv.setText(str4);
        this.jco.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jcp = new ForumListModel.RequestParams();
        this.jcp.menu_id = com.baidu.adp.lib.g.b.toInt(str2, 0);
        this.jcp.menu_name = str4;
        this.jcp.menu_type = com.baidu.adp.lib.g.b.toInt(str3, 0);
        this.jcp.parent_menu_id = com.baidu.adp.lib.g.b.toInt(str2, 0);
        this.jcp.parent_menu_name = str;
        this.jcp.offset = 0;
        this.jcp.rn = 10;
        if (this.jcp.menu_id != 0) {
            this.jco.cmL();
            this.jch = true;
            this.jcn = false;
            this.jcs.i(Boolean.valueOf(this.jcn));
            this.jco.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jcn = true;
            this.jcs.i(Boolean.valueOf(this.jcn));
            this.jco.cmK();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jco.jdg.setListPullRefreshListener(this.dCB);
        this.jco.jdh.setListPullRefreshListener(this.dCB);
        this.jcs.notifyDataSetChanged();
        this.jct.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jco.cmN();
        } else {
            this.jcu = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jcu.a(this.jcx);
            this.jcu.LoadData();
        }
        this.jcv = new ForumListDetailModel(getPageContext(), this.jcp);
        this.jcv.a(this.jcw);
        this.jco.jcW.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (fvf) {
            fvf = false;
            finish();
            b(getPageContext().getPageActivity(), jcz, jcB, jcA, jcC);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jcs != null) {
                this.jcs.cmI();
                this.jcs.notifyDataSetChanged();
            }
            if (this.jct != null) {
                this.jct.cmI();
                this.jct.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.csF != null) {
            this.csF.cnF();
        }
        this.jco.mViewPager.setAdapter(null);
        this.jco.jcX.setAdapter((ListAdapter) null);
        this.jco.jcW.setAdapter((ListAdapter) null);
        if (this.jco.jdl != null) {
            this.jco.jdl.setAdapter((ListAdapter) null);
        }
        if (this.jcu != null) {
            this.jcu.cancelLoadData();
        }
        if (this.jcv != null) {
            this.jcv.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jco.fiG);
        this.jco.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jcs.qH(true);
            this.jct.qH(true);
        } else {
            this.jcs.qH(false);
            this.jct.qH(false);
        }
        this.jcs.notifyDataSetChanged();
        this.jct.notifyDataSetChanged();
        if (this.jco.jdi != null) {
            this.jco.jdi.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.jco.jcT, R.drawable.bg_pop_most);
        this.jbW = am.getColor(R.color.common_color_10243);
        this.jbX = am.getColor(R.color.cp_cont_a);
        this.jbY = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.jbZ = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.jca = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.jcb = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.jcc = am.getDrawable(R.drawable.ico_downward);
        this.jcd = am.getDrawable(R.drawable.ico_upward);
        this.jcs.co(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jct.co(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jco.jcS, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jco.jde, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.jco.jcR, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jco.jdb, R.color.common_color_10243, 1);
        if (this.jcq) {
            am.setImageResource(this.jco.jdc, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jco.jdc, R.drawable.ico_downward);
        }
        if (this.jcr) {
            am.setImageResource(this.jco.jdf, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jco.jdf, R.drawable.ico_downward);
        }
        if (this.jco.mViewPager.getCurrentItem() == 0) {
            this.jco.jcY.setTextColor(this.jbX);
            this.jco.jcY.setBackgroundDrawable(this.jca);
            this.jco.jcZ.setBackgroundDrawable(this.jbZ);
            this.jco.jcZ.setTextColor(this.jbW);
            return;
        }
        this.jco.jcZ.setTextColor(this.jbX);
        this.jco.jcZ.setBackgroundDrawable(this.jcb);
        this.jco.jcY.setBackgroundDrawable(this.jbY);
        this.jco.jcY.setTextColor(this.jbW);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jco.mViewPager.setCurrentItem(0);
            this.jcg = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jco.mViewPager.setCurrentItem(1);
            this.jcg = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jco.d(this.jcy);
        }
    }

    private View cmC() {
        this.jco.jcW = cmG();
        this.jco.jda.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cmD();
            }
        });
        return this.jco.jcW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        if (this.jcq) {
            int min = Math.min(this.jcs.getCount(), 200);
            this.jce = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jcs.cmH(), 0, forumInfoDataArr, 0, min);
            this.jcs.yP(min);
            this.jcs.a(forumInfoDataArr);
            this.jcq = false;
            this.jco.jdb.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jco.jdc.setImageDrawable(this.jcc);
            return;
        }
        this.jce = 50;
        c cVar = new c();
        cVar.qG(true);
        cVar.execute(new Void[0]);
    }

    private View cmE() {
        this.jco.jcX = cmG();
        this.jco.jdd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cmF();
            }
        });
        return this.jco.jcX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmF() {
        if (this.jcr) {
            int min = Math.min(this.jct.getCount(), 200);
            this.jcf = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jct.cmH(), 0, forumInfoDataArr, 0, min);
            this.jct.yP(min);
            this.jct.a(forumInfoDataArr);
            this.jcr = false;
            this.jco.jde.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jco.jdf.setImageDrawable(this.jcc);
            return;
        }
        this.jcf = 50;
        b bVar = new b();
        bVar.qG(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cmG() {
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
        if (!this.jch) {
            if (i == 0) {
                this.jcs.cmI();
                this.jcs.notifyDataSetChanged();
                this.jco.jcY.setBackgroundDrawable(this.jca);
                this.jco.jcY.setTextColor(this.jbX);
                this.jco.jcZ.setBackgroundDrawable(this.jbZ);
                this.jco.jcZ.setTextColor(this.jbW);
            } else if (i == 1) {
                this.jct.cmI();
                this.jct.notifyDataSetChanged();
                this.jco.jcZ.setBackgroundDrawable(this.jcb);
                this.jco.jcZ.setTextColor(this.jbX);
                this.jco.jcY.setBackgroundDrawable(this.jbY);
                this.jco.jcY.setTextColor(this.jbW);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes5.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.jch ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jco.jcW);
                    return ForumListActivity.this.jco.jcW;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jco.jcX);
                    return ForumListActivity.this.jco.jcX;
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
        final ForumInfoData[] cmH;
        if (i == 11002 && i2 == -1) {
            this.jcv.LoadData();
            if (this.jcg == 0) {
                cmH = this.jcs.cmH();
            } else {
                cmH = this.jct.cmH();
            }
            this.csF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.csF.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.csF.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.csF.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.jcg == 0) {
                                ForumListActivity.this.jcs.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cmH[ForumListActivity.this.jcs.jcG].forum_name);
                            } else if (ForumListActivity.this.jcg == 1) {
                                ForumListActivity.this.jct.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cmH[ForumListActivity.this.jct.jcG].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.jcg == 0) {
                this.csF.dY(cmH[this.jcs.jcG].forum_name, String.valueOf(cmH[this.jcs.jcG].forum_id));
            } else {
                this.csF.dY(cmH[this.jct.jcG].forum_name, String.valueOf(cmH[this.jct.jcG].forum_id));
            }
        }
    }
}
