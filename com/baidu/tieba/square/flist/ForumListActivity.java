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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
    public static boolean hzB = false;
    private static String lzT = "";
    private static String lzU = "";
    private static String lzV = "";
    private static String lzW = "";
    public com.baidu.tieba.square.flist.c lzI;
    private ForumListModel.RequestParams lzJ;
    private com.baidu.tieba.square.flist.b lzM;
    private com.baidu.tieba.square.flist.b lzN;
    private DirMenuModel lzO;
    private ForumListDetailModel lzP;
    private int lzq;
    private int lzr;
    private Drawable lzs;
    private Drawable lzt;
    private Drawable lzu;
    private Drawable lzv;
    private Drawable lzw;
    private Drawable lzx;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int lzy = 200;
    private int lzz = 200;
    private int lzA = 0;
    private final LikeModel egK = new LikeModel(getPageContext());
    private boolean lzB = false;
    private int lzC = 0;
    private boolean lzD = false;
    private int lzE = 0;
    private int lzF = 200;
    private boolean lzG = true;
    private boolean lzH = true;
    private boolean lzK = false;
    private boolean lzL = false;
    private final ForumListDetailModel.a lzQ = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.lzM.dgw() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.lzI.dgC();
                ForumListActivity.this.lzI.dgB();
                if (ForumListActivity.this.lzJ.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.lzI.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.lzJ.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.lzI.dgB();
                    ForumListActivity.this.lzJ.recommend_type = ForumListActivity.this.lzE;
                    ForumListActivity.this.lzJ.rn = ForumListActivity.this.lzF;
                }
                ForumListActivity.this.lzI.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.lzI.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lzD) {
                    ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lzI.lAw.setImageDrawable(ForumListActivity.this.lzw);
                    ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lzI.lAz.setImageDrawable(ForumListActivity.this.lzw);
                    ForumListActivity.this.lzD = false;
                }
                ForumListActivity.this.lzI.bjy.setText(ForumListActivity.this.lzJ.menu_name);
                ForumListActivity.this.lzI.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lzI.lAG.EH(ForumListActivity.this.lzC);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.lzM.DT(min);
                ForumListActivity.this.lzM.a(ForumListActivity.this.egK);
                ForumListActivity.this.lzM.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.lzI.lAq.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.lzI.lAl.setVisibility(0);
                } else {
                    ForumListActivity.this.lzI.lAl.setVisibility(8);
                }
                ForumListActivity.this.lzI.lAs.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.lzN.DT(min2);
                ForumListActivity.this.lzN.a(ForumListActivity.this.egK);
                ForumListActivity.this.lzN.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.lzI.lAr.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.lzI.lAm.setVisibility(0);
                } else {
                    ForumListActivity.this.lzI.lAm.setVisibility(8);
                }
                ForumListActivity.this.lzI.lAt.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.lzI.dgB();
                if (ForumListActivity.this.lzI.lAG.getCount() > 0) {
                    ForumListActivity.this.lzI.lAH.setClickable(true);
                    ForumListActivity.this.lzI.lAH.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b lzR = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.lzI.dgC();
                    return;
                }
                return;
            }
            eVar.lBr.add(0, eVar);
            if (ForumListActivity.this.lzI.lAG != null) {
                ForumListActivity.this.lzI.lAG.a(eVar);
                ForumListActivity.this.MJ(String.valueOf(ForumListActivity.this.lzI.bjy.getText()));
                ForumListActivity.this.lzI.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lzI.lAG.notifyDataSetChanged();
            }
            ForumListActivity.this.lzI.lAH.setClickable(true);
            ForumListActivity.this.lzI.lAH.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener lzS = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.lzI.lAC, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.lzC = i;
            ForumListActivity.this.lzI.dgC();
            ForumListActivity.this.lzI.dgD();
            ArrayList<e> arrayList = ForumListActivity.this.lzI.lAG.dgp().lBr;
            ForumListActivity.this.ay(arrayList.get(i).lzk, arrayList.get(i).lzm, arrayList.get(i).lzl);
        }
    };
    private final f.c fum = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.lzM.dgy() && !ForumListActivity.this.lzN.dgy()) {
                if (ForumListActivity.this.lzG) {
                    ForumListActivity.this.lzJ.recommend_type = 0;
                    ForumListActivity.this.lzJ.rn = 200;
                    ForumListActivity.this.lzP.a(ForumListActivity.this.lzJ);
                    ForumListActivity.this.lzP.LoadData();
                    ForumListActivity.this.lzG = false;
                } else if (ForumListActivity.this.lzI.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.lzK) {
                        ForumListActivity.this.lzy = 50;
                    } else {
                        ForumListActivity.this.lzy = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.lzI.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.lzL) {
                        ForumListActivity.this.lzz = 50;
                    } else {
                        ForumListActivity.this.lzz = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ(String str) {
        e dgp = this.lzI.lAG.dgp();
        if (dgp != null) {
            ArrayList<e> arrayList = dgp.lBr;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).lzk.equals(str)) {
                    this.lzC = i;
                    this.lzI.lAG.EH(this.lzC);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(String str, String str2, String str3) {
        this.lzJ.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lzJ.menu_name = str;
        this.lzJ.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lzJ.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.lzJ.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.lzJ.offset = 0;
        this.lzJ.rn = 10;
        this.lzE = this.lzJ.recommend_type;
        this.lzF = this.lzJ.rn;
        this.lzJ.recommend_type = 0;
        this.lzJ.rn = 200;
        this.lzD = true;
        this.lzP.a(this.lzJ);
        this.lzP.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lzZ;

        private b() {
            this.lzZ = false;
        }

        public void uz(boolean z) {
            this.lzZ = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lzI.lAx.setEnabled(false);
            ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lzJ.recommend_type = 2;
                ForumListActivity.this.lzJ.offset = 0;
                ForumListActivity.this.lzJ.rn = ForumListActivity.this.lzz;
                return ForumListModel.new_fetch(ForumListActivity.this.lzJ);
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
                ForumListActivity.this.lzN.DT(min);
                ForumListActivity.this.lzN.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.lzz == 200) {
                    ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lzI.lAz.setImageDrawable(ForumListActivity.this.lzw);
                } else {
                    ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lzI.lAz.setImageDrawable(ForumListActivity.this.lzx);
                    ForumListActivity.this.lzL = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lzZ) {
                    if (ForumListActivity.this.lzz == 200) {
                        ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lzI.lAz.setImageDrawable(ForumListActivity.this.lzw);
                    } else {
                        ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lzI.lAz.setImageDrawable(ForumListActivity.this.lzx);
                    }
                } else {
                    ForumListActivity.this.lzI.lAy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lzI.lAz.setImageDrawable(ForumListActivity.this.lzw);
                    ForumListActivity.this.lzJ.rn = 200;
                    ForumListActivity.this.lzz = 200;
                }
            }
            ForumListActivity.this.lzI.lAx.setEnabled(true);
            ForumListActivity.this.lzI.dgB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lzZ;

        private c() {
            this.lzZ = false;
        }

        public void uz(boolean z) {
            this.lzZ = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lzI.lAu.setEnabled(false);
            ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lzJ.recommend_type = 1;
                ForumListActivity.this.lzJ.offset = 0;
                ForumListActivity.this.lzJ.rn = ForumListActivity.this.lzy;
                return ForumListModel.new_fetch(ForumListActivity.this.lzJ);
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
                ForumListActivity.this.lzM.DT(min);
                ForumListActivity.this.lzM.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.lzy == 200) {
                    ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lzI.lAw.setImageDrawable(ForumListActivity.this.lzw);
                } else {
                    ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lzI.lAw.setImageDrawable(ForumListActivity.this.lzx);
                    ForumListActivity.this.lzK = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lzZ) {
                    if (ForumListActivity.this.lzy == 200) {
                        ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lzI.lAw.setImageDrawable(ForumListActivity.this.lzw);
                    } else {
                        ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lzI.lAw.setImageDrawable(ForumListActivity.this.lzx);
                    }
                } else {
                    ForumListActivity.this.lzI.lAv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lzI.lAw.setImageDrawable(ForumListActivity.this.lzw);
                    ForumListActivity.this.lzJ.rn = 200;
                    ForumListActivity.this.lzy = 200;
                }
            }
            ForumListActivity.this.lzI.lAu.setEnabled(true);
            ForumListActivity.this.lzI.dgB();
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
        this.lzI = new com.baidu.tieba.square.flist.c(this);
        this.lzI.lAq = (BdListView) dgr();
        this.lzI.lAr = (BdListView) dgt();
        this.lzI.mProgressBar.setVisibility(0);
        this.lzI.lAH.setOnClickListener(null);
        this.lzI.lAH.setClickable(false);
        this.lzI.mViewPager.setAdapter(new a());
        this.lzI.lAq.setPullRefresh(this.lzI.lAA);
        this.lzI.lAr.setPullRefresh(this.lzI.lAB);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.lzI.lAq.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.lzI.lAr.addHeaderView(textView2, 0);
        this.lzM = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.lzI.lAq.setAdapter((ListAdapter) this.lzM);
        this.lzN = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.lzI.lAr.setAdapter((ListAdapter) this.lzN);
        D(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void D(String str, String str2, String str3, String str4) {
        if (ar.isEmpty(str4)) {
            str4 = str;
        }
        this.lzI.bjy.setText(str4);
        this.lzI.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.lzJ = new ForumListModel.RequestParams();
        this.lzJ.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lzJ.menu_name = str4;
        this.lzJ.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lzJ.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lzJ.parent_menu_name = str;
        this.lzJ.offset = 0;
        this.lzJ.rn = 10;
        if (this.lzJ.menu_id != 0) {
            this.lzI.dgA();
            this.lzB = true;
            this.lzH = false;
            this.lzM.m(Boolean.valueOf(this.lzH));
            this.lzI.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.lzH = true;
            this.lzM.m(Boolean.valueOf(this.lzH));
            this.lzI.dgz();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.lzI.lAA.setListPullRefreshListener(this.fum);
        this.lzI.lAB.setListPullRefreshListener(this.fum);
        this.lzM.notifyDataSetChanged();
        this.lzN.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.lzI.dgC();
        } else {
            this.lzO = new DirMenuModel(getPageContext(), str, str3, str2);
            this.lzO.a(this.lzR);
            this.lzO.LoadData();
        }
        this.lzP = new ForumListDetailModel(getPageContext(), this.lzJ);
        this.lzP.a(this.lzQ);
        this.lzI.lAq.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hzB) {
            hzB = false;
            finish();
            c(getPageContext().getPageActivity(), lzT, lzV, lzU, lzW);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.lzM != null) {
                this.lzM.dgx();
                this.lzM.notifyDataSetChanged();
            }
            if (this.lzN != null) {
                this.lzN.dgx();
                this.lzN.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.egK != null) {
            this.egK.dhr();
        }
        this.lzI.mViewPager.setAdapter(null);
        this.lzI.lAr.setAdapter((ListAdapter) null);
        this.lzI.lAq.setAdapter((ListAdapter) null);
        if (this.lzI.lAF != null) {
            this.lzI.lAF.setAdapter((ListAdapter) null);
        }
        if (this.lzO != null) {
            this.lzO.cancelLoadData();
        }
        if (this.lzP != null) {
            this.lzP.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lzI.hmU);
        this.lzI.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lzM.uA(true);
            this.lzN.uA(true);
        } else {
            this.lzM.uA(false);
            this.lzN.uA(false);
        }
        this.lzM.notifyDataSetChanged();
        this.lzN.notifyDataSetChanged();
        if (this.lzI.lAC != null) {
            this.lzI.lAC.setBackgroundDrawable(an.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        an.setBackgroundResource(this.lzI.lAn, R.drawable.bg_pop_most);
        this.lzq = an.getColor(R.color.common_color_10243);
        this.lzr = an.getColor(R.color.cp_cont_a);
        this.lzs = an.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lzt = an.getDrawable(R.drawable.btn_pop_most_right_n);
        this.lzu = an.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lzv = an.getDrawable(R.drawable.btn_pop_most_right_s);
        this.lzw = an.getDrawable(R.drawable.ico_downward);
        this.lzx = an.getDrawable(R.drawable.ico_upward);
        this.lzM.cZ(R.drawable.btn_add_end, R.drawable.btn_add);
        this.lzN.cZ(R.drawable.btn_add_end, R.drawable.btn_add);
        an.setBackgroundResource(this.lzI.lAm, R.drawable.bg_black_banner_down);
        an.setViewTextColor(this.lzI.lAy, R.color.common_color_10243, 1);
        an.setBackgroundResource(this.lzI.lAl, R.drawable.bg_black_banner_down);
        an.setViewTextColor(this.lzI.lAv, R.color.common_color_10243, 1);
        if (this.lzK) {
            an.setImageResource(this.lzI.lAw, R.drawable.ico_upward);
        } else {
            an.setImageResource(this.lzI.lAw, R.drawable.ico_downward);
        }
        if (this.lzL) {
            an.setImageResource(this.lzI.lAz, R.drawable.ico_upward);
        } else {
            an.setImageResource(this.lzI.lAz, R.drawable.ico_downward);
        }
        if (this.lzI.mViewPager.getCurrentItem() == 0) {
            this.lzI.lAs.setTextColor(this.lzr);
            this.lzI.lAs.setBackgroundDrawable(this.lzu);
            this.lzI.lAt.setBackgroundDrawable(this.lzt);
            this.lzI.lAt.setTextColor(this.lzq);
            return;
        }
        this.lzI.lAt.setTextColor(this.lzr);
        this.lzI.lAt.setBackgroundDrawable(this.lzv);
        this.lzI.lAs.setBackgroundDrawable(this.lzs);
        this.lzI.lAs.setTextColor(this.lzq);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.lzI.mViewPager.setCurrentItem(0);
            this.lzA = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.lzI.mViewPager.setCurrentItem(1);
            this.lzA = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.lzI.c(this.lzS);
        }
    }

    private View dgr() {
        this.lzI.lAq = dgv();
        this.lzI.lAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dgs();
            }
        });
        return this.lzI.lAq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgs() {
        if (this.lzK) {
            int min = Math.min(this.lzM.getCount(), 200);
            this.lzy = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lzM.dgw(), 0, forumInfoDataArr, 0, min);
            this.lzM.DT(min);
            this.lzM.a(forumInfoDataArr);
            this.lzK = false;
            this.lzI.lAv.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lzI.lAw.setImageDrawable(this.lzw);
            return;
        }
        this.lzy = 50;
        c cVar = new c();
        cVar.uz(true);
        cVar.execute(new Void[0]);
    }

    private View dgt() {
        this.lzI.lAr = dgv();
        this.lzI.lAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dgu();
            }
        });
        return this.lzI.lAr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgu() {
        if (this.lzL) {
            int min = Math.min(this.lzN.getCount(), 200);
            this.lzz = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lzN.dgw(), 0, forumInfoDataArr, 0, min);
            this.lzN.DT(min);
            this.lzN.a(forumInfoDataArr);
            this.lzL = false;
            this.lzI.lAy.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lzI.lAz.setImageDrawable(this.lzw);
            return;
        }
        this.lzz = 50;
        b bVar = new b();
        bVar.uz(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dgv() {
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
        if (!this.lzB) {
            if (i == 0) {
                this.lzM.dgx();
                this.lzM.notifyDataSetChanged();
                this.lzI.lAs.setBackgroundDrawable(this.lzu);
                this.lzI.lAs.setTextColor(this.lzr);
                this.lzI.lAt.setBackgroundDrawable(this.lzt);
                this.lzI.lAt.setTextColor(this.lzq);
            } else if (i == 1) {
                this.lzN.dgx();
                this.lzN.notifyDataSetChanged();
                this.lzI.lAt.setBackgroundDrawable(this.lzv);
                this.lzI.lAt.setTextColor(this.lzr);
                this.lzI.lAs.setBackgroundDrawable(this.lzs);
                this.lzI.lAs.setTextColor(this.lzq);
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
            return ForumListActivity.this.lzB ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.lzI.lAq);
                    return ForumListActivity.this.lzI.lAq;
                case 1:
                    viewGroup.addView(ForumListActivity.this.lzI.lAr);
                    return ForumListActivity.this.lzI.lAr;
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
        final ForumInfoData[] dgw;
        if (i == 11002 && i2 == -1) {
            this.lzP.LoadData();
            if (this.lzA == 0) {
                dgw = this.lzM.dgw();
            } else {
                dgw = this.lzN.dgw();
            }
            this.egK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.egK.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.egK.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.egK.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.lzA == 0) {
                                ForumListActivity.this.lzM.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dgw[ForumListActivity.this.lzM.lAa].forum_name);
                            } else if (ForumListActivity.this.lzA == 1) {
                                ForumListActivity.this.lzN.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dgw[ForumListActivity.this.lzN.lAa].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.lzA == 0) {
                this.egK.fx(dgw[this.lzM.lAa].forum_name, String.valueOf(dgw[this.lzM.lAa].forum_id));
            } else {
                this.egK.fx(dgw[this.lzN.lAa].forum_name, String.valueOf(dgw[this.lzN.lAa].forum_id));
            }
        }
    }
}
