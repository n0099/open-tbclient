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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes17.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean hFq = false;
    private static String lHk = "";
    private static String lHl = "";
    private static String lHm = "";
    private static String lHn = "";
    private int lGI;
    private int lGJ;
    private Drawable lGK;
    private Drawable lGL;
    private Drawable lGM;
    private Drawable lGN;
    private Drawable lGO;
    private Drawable lGP;
    public com.baidu.tieba.square.flist.c lGZ;
    private ForumListModel.RequestParams lHa;
    private com.baidu.tieba.square.flist.b lHd;
    private com.baidu.tieba.square.flist.b lHe;
    private DirMenuModel lHf;
    private ForumListDetailModel lHg;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int lGQ = 200;
    private int lGR = 200;
    private int lGS = 0;
    private final LikeModel emT = new LikeModel(getPageContext());
    private boolean lGT = false;
    private int menu_choose = 0;
    private boolean lGU = false;
    private int lGV = 0;
    private int lGW = 200;
    private boolean lGX = true;
    private boolean lGY = true;
    private boolean lHb = false;
    private boolean lHc = false;
    private final ForumListDetailModel.a lHh = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.lHd.djG() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.lGZ.djM();
                ForumListActivity.this.lGZ.djL();
                if (ForumListActivity.this.lHa.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.lGZ.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.lHa.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.lGZ.djL();
                    ForumListActivity.this.lHa.recommend_type = ForumListActivity.this.lGV;
                    ForumListActivity.this.lHa.rn = ForumListActivity.this.lGW;
                }
                ForumListActivity.this.lGZ.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.lGZ.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lGU) {
                    ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGZ.lHN.setImageDrawable(ForumListActivity.this.lGO);
                    ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGZ.lHQ.setImageDrawable(ForumListActivity.this.lGO);
                    ForumListActivity.this.lGU = false;
                }
                ForumListActivity.this.lGZ.bjS.setText(ForumListActivity.this.lHa.menu_name);
                ForumListActivity.this.lGZ.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lGZ.lHX.Fd(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.lHd.Ep(min);
                ForumListActivity.this.lHd.a(ForumListActivity.this.emT);
                ForumListActivity.this.lHd.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.lGZ.lHH.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.lGZ.lHC.setVisibility(0);
                } else {
                    ForumListActivity.this.lGZ.lHC.setVisibility(8);
                }
                ForumListActivity.this.lGZ.lHJ.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.lHe.Ep(min2);
                ForumListActivity.this.lHe.a(ForumListActivity.this.emT);
                ForumListActivity.this.lHe.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.lGZ.lHI.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.lGZ.lHD.setVisibility(0);
                } else {
                    ForumListActivity.this.lGZ.lHD.setVisibility(8);
                }
                ForumListActivity.this.lGZ.lHK.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.lGZ.djL();
                if (ForumListActivity.this.lGZ.lHX.getCount() > 0) {
                    ForumListActivity.this.lGZ.lHY.setClickable(true);
                    ForumListActivity.this.lGZ.lHY.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b lHi = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.lGZ.djM();
                    return;
                }
                return;
            }
            eVar.lII.add(0, eVar);
            if (ForumListActivity.this.lGZ.lHX != null) {
                ForumListActivity.this.lGZ.lHX.a(eVar);
                ForumListActivity.this.Nr(String.valueOf(ForumListActivity.this.lGZ.bjS.getText()));
                ForumListActivity.this.lGZ.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lGZ.lHX.notifyDataSetChanged();
            }
            ForumListActivity.this.lGZ.lHY.setClickable(true);
            ForumListActivity.this.lGZ.lHY.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener lHj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.lGZ.lHT, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.lGZ.djM();
            ForumListActivity.this.lGZ.djN();
            ArrayList<e> arrayList = ForumListActivity.this.lGZ.lHX.djz().lII;
            ForumListActivity.this.ax(arrayList.get(i).lGC, arrayList.get(i).lGE, arrayList.get(i).lGD);
        }
    };
    private final f.c fzt = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.lHd.djI() && !ForumListActivity.this.lHe.djI()) {
                if (ForumListActivity.this.lGX) {
                    ForumListActivity.this.lHa.recommend_type = 0;
                    ForumListActivity.this.lHa.rn = 200;
                    ForumListActivity.this.lHg.a(ForumListActivity.this.lHa);
                    ForumListActivity.this.lHg.LoadData();
                    ForumListActivity.this.lGX = false;
                } else if (ForumListActivity.this.lGZ.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.lHb) {
                        ForumListActivity.this.lGQ = 50;
                    } else {
                        ForumListActivity.this.lGQ = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.lGZ.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.lHc) {
                        ForumListActivity.this.lGR = 50;
                    } else {
                        ForumListActivity.this.lGR = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Nr(String str) {
        e djz = this.lGZ.lHX.djz();
        if (djz != null) {
            ArrayList<e> arrayList = djz.lII;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).lGC.equals(str)) {
                    this.menu_choose = i;
                    this.lGZ.lHX.Fd(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.lHa.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lHa.menu_name = str;
        this.lHa.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lHa.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.lHa.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.lHa.offset = 0;
        this.lHa.rn = 10;
        this.lGV = this.lHa.recommend_type;
        this.lGW = this.lHa.rn;
        this.lHa.recommend_type = 0;
        this.lHa.rn = 200;
        this.lGU = true;
        this.lHg.a(this.lHa);
        this.lHg.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lHq;

        private b() {
            this.lHq = false;
        }

        public void vd(boolean z) {
            this.lHq = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lGZ.lHO.setEnabled(false);
            ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lHa.recommend_type = 2;
                ForumListActivity.this.lHa.offset = 0;
                ForumListActivity.this.lHa.rn = ForumListActivity.this.lGR;
                return ForumListModel.new_fetch(ForumListActivity.this.lHa);
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
                ForumListActivity.this.lHe.Ep(min);
                ForumListActivity.this.lHe.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.lGR == 200) {
                    ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGZ.lHQ.setImageDrawable(ForumListActivity.this.lGO);
                } else {
                    ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lGZ.lHQ.setImageDrawable(ForumListActivity.this.lGP);
                    ForumListActivity.this.lHc = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lHq) {
                    if (ForumListActivity.this.lGR == 200) {
                        ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lGZ.lHQ.setImageDrawable(ForumListActivity.this.lGO);
                    } else {
                        ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lGZ.lHQ.setImageDrawable(ForumListActivity.this.lGP);
                    }
                } else {
                    ForumListActivity.this.lGZ.lHP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGZ.lHQ.setImageDrawable(ForumListActivity.this.lGO);
                    ForumListActivity.this.lHa.rn = 200;
                    ForumListActivity.this.lGR = 200;
                }
            }
            ForumListActivity.this.lGZ.lHO.setEnabled(true);
            ForumListActivity.this.lGZ.djL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lHq;

        private c() {
            this.lHq = false;
        }

        public void vd(boolean z) {
            this.lHq = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lGZ.lHL.setEnabled(false);
            ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lHa.recommend_type = 1;
                ForumListActivity.this.lHa.offset = 0;
                ForumListActivity.this.lHa.rn = ForumListActivity.this.lGQ;
                return ForumListModel.new_fetch(ForumListActivity.this.lHa);
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
                ForumListActivity.this.lHd.Ep(min);
                ForumListActivity.this.lHd.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.lGQ == 200) {
                    ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGZ.lHN.setImageDrawable(ForumListActivity.this.lGO);
                } else {
                    ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lGZ.lHN.setImageDrawable(ForumListActivity.this.lGP);
                    ForumListActivity.this.lHb = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lHq) {
                    if (ForumListActivity.this.lGQ == 200) {
                        ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lGZ.lHN.setImageDrawable(ForumListActivity.this.lGO);
                    } else {
                        ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lGZ.lHN.setImageDrawable(ForumListActivity.this.lGP);
                    }
                } else {
                    ForumListActivity.this.lGZ.lHM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGZ.lHN.setImageDrawable(ForumListActivity.this.lGO);
                    ForumListActivity.this.lHa.rn = 200;
                    ForumListActivity.this.lGQ = 200;
                }
            }
            ForumListActivity.this.lGZ.lHL.setEnabled(true);
            ForumListActivity.this.lGZ.djL();
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
        this.lGZ = new com.baidu.tieba.square.flist.c(this);
        this.lGZ.lHH = (BdListView) djB();
        this.lGZ.lHI = (BdListView) djD();
        this.lGZ.mProgressBar.setVisibility(0);
        this.lGZ.lHY.setOnClickListener(null);
        this.lGZ.lHY.setClickable(false);
        this.lGZ.mViewPager.setAdapter(new a());
        this.lGZ.lHH.setPullRefresh(this.lGZ.lHR);
        this.lGZ.lHI.setPullRefresh(this.lGZ.lHS);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.lGZ.lHH.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.lGZ.lHI.addHeaderView(textView2, 0);
        this.lHd = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.lGZ.lHH.setAdapter((ListAdapter) this.lHd);
        this.lHe = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.lGZ.lHI.setAdapter((ListAdapter) this.lHe);
        D(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void D(String str, String str2, String str3, String str4) {
        if (as.isEmpty(str4)) {
            str4 = str;
        }
        this.lGZ.bjS.setText(str4);
        this.lGZ.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.lHa = new ForumListModel.RequestParams();
        this.lHa.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lHa.menu_name = str4;
        this.lHa.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lHa.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lHa.parent_menu_name = str;
        this.lHa.offset = 0;
        this.lHa.rn = 10;
        if (this.lHa.menu_id != 0) {
            this.lGZ.djK();
            this.lGT = true;
            this.lGY = false;
            this.lHd.o(Boolean.valueOf(this.lGY));
            this.lGZ.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.lGY = true;
            this.lHd.o(Boolean.valueOf(this.lGY));
            this.lGZ.djJ();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.lGZ.lHR.setListPullRefreshListener(this.fzt);
        this.lGZ.lHS.setListPullRefreshListener(this.fzt);
        this.lHd.notifyDataSetChanged();
        this.lHe.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.lGZ.djM();
        } else {
            this.lHf = new DirMenuModel(getPageContext(), str, str3, str2);
            this.lHf.a(this.lHi);
            this.lHf.LoadData();
        }
        this.lHg = new ForumListDetailModel(getPageContext(), this.lHa);
        this.lHg.a(this.lHh);
        this.lGZ.lHH.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hFq) {
            hFq = false;
            finish();
            c(getPageContext().getPageActivity(), lHk, lHm, lHl, lHn);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.lHd != null) {
                this.lHd.djH();
                this.lHd.notifyDataSetChanged();
            }
            if (this.lHe != null) {
                this.lHe.djH();
                this.lHe.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.emT != null) {
            this.emT.dkB();
        }
        this.lGZ.mViewPager.setAdapter(null);
        this.lGZ.lHI.setAdapter((ListAdapter) null);
        this.lGZ.lHH.setAdapter((ListAdapter) null);
        if (this.lGZ.lHW != null) {
            this.lGZ.lHW.setAdapter((ListAdapter) null);
        }
        if (this.lHf != null) {
            this.lHf.cancelLoadData();
        }
        if (this.lHg != null) {
            this.lHg.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lGZ.hsG);
        this.lGZ.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lHd.ve(true);
            this.lHe.ve(true);
        } else {
            this.lHd.ve(false);
            this.lHe.ve(false);
        }
        this.lHd.notifyDataSetChanged();
        this.lHe.notifyDataSetChanged();
        if (this.lGZ.lHT != null) {
            this.lGZ.lHT.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ao.setBackgroundResource(this.lGZ.lHE, R.drawable.bg_pop_most);
        this.lGI = ao.getColor(R.color.common_color_10243);
        this.lGJ = ao.getColor(R.color.cp_cont_a);
        this.lGK = ao.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lGL = ao.getDrawable(R.drawable.btn_pop_most_right_n);
        this.lGM = ao.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lGN = ao.getDrawable(R.drawable.btn_pop_most_right_s);
        this.lGO = ao.getDrawable(R.drawable.ico_downward);
        this.lGP = ao.getDrawable(R.drawable.ico_upward);
        this.lHd.db(R.drawable.btn_add_end, R.drawable.btn_add);
        this.lHe.db(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.lGZ.lHD, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.lGZ.lHP, R.color.common_color_10243, 1);
        ao.setBackgroundResource(this.lGZ.lHC, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.lGZ.lHM, R.color.common_color_10243, 1);
        if (this.lHb) {
            ao.setImageResource(this.lGZ.lHN, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.lGZ.lHN, R.drawable.ico_downward);
        }
        if (this.lHc) {
            ao.setImageResource(this.lGZ.lHQ, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.lGZ.lHQ, R.drawable.ico_downward);
        }
        if (this.lGZ.mViewPager.getCurrentItem() == 0) {
            this.lGZ.lHJ.setTextColor(this.lGJ);
            this.lGZ.lHJ.setBackgroundDrawable(this.lGM);
            this.lGZ.lHK.setBackgroundDrawable(this.lGL);
            this.lGZ.lHK.setTextColor(this.lGI);
            return;
        }
        this.lGZ.lHK.setTextColor(this.lGJ);
        this.lGZ.lHK.setBackgroundDrawable(this.lGN);
        this.lGZ.lHJ.setBackgroundDrawable(this.lGK);
        this.lGZ.lHJ.setTextColor(this.lGI);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.lGZ.mViewPager.setCurrentItem(0);
            this.lGS = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.lGZ.mViewPager.setCurrentItem(1);
            this.lGS = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.lGZ.c(this.lHj);
        }
    }

    private View djB() {
        this.lGZ.lHH = djF();
        this.lGZ.lHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.djC();
            }
        });
        return this.lGZ.lHH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djC() {
        if (this.lHb) {
            int min = Math.min(this.lHd.getCount(), 200);
            this.lGQ = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lHd.djG(), 0, forumInfoDataArr, 0, min);
            this.lHd.Ep(min);
            this.lHd.a(forumInfoDataArr);
            this.lHb = false;
            this.lGZ.lHM.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lGZ.lHN.setImageDrawable(this.lGO);
            return;
        }
        this.lGQ = 50;
        c cVar = new c();
        cVar.vd(true);
        cVar.execute(new Void[0]);
    }

    private View djD() {
        this.lGZ.lHI = djF();
        this.lGZ.lHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.djE();
            }
        });
        return this.lGZ.lHI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djE() {
        if (this.lHc) {
            int min = Math.min(this.lHe.getCount(), 200);
            this.lGR = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lHe.djG(), 0, forumInfoDataArr, 0, min);
            this.lHe.Ep(min);
            this.lHe.a(forumInfoDataArr);
            this.lHc = false;
            this.lGZ.lHP.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lGZ.lHQ.setImageDrawable(this.lGO);
            return;
        }
        this.lGR = 50;
        b bVar = new b();
        bVar.vd(true);
        bVar.execute(new Void[0]);
    }

    private BdListView djF() {
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
        if (!this.lGT) {
            if (i == 0) {
                this.lHd.djH();
                this.lHd.notifyDataSetChanged();
                this.lGZ.lHJ.setBackgroundDrawable(this.lGM);
                this.lGZ.lHJ.setTextColor(this.lGJ);
                this.lGZ.lHK.setBackgroundDrawable(this.lGL);
                this.lGZ.lHK.setTextColor(this.lGI);
            } else if (i == 1) {
                this.lHe.djH();
                this.lHe.notifyDataSetChanged();
                this.lGZ.lHK.setBackgroundDrawable(this.lGN);
                this.lGZ.lHK.setTextColor(this.lGJ);
                this.lGZ.lHJ.setBackgroundDrawable(this.lGK);
                this.lGZ.lHJ.setTextColor(this.lGI);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes17.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.lGT ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.lGZ.lHH);
                    return ForumListActivity.this.lGZ.lHH;
                case 1:
                    viewGroup.addView(ForumListActivity.this.lGZ.lHI);
                    return ForumListActivity.this.lGZ.lHI;
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
        final ForumInfoData[] djG;
        if (i == 11002 && i2 == -1) {
            this.lHg.LoadData();
            if (this.lGS == 0) {
                djG = this.lHd.djG();
            } else {
                djG = this.lHe.djG();
            }
            this.emT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.emT.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.emT.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.emT.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.lGS == 0) {
                                ForumListActivity.this.lHd.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(djG[ForumListActivity.this.lHd.lHr].forum_name);
                            } else if (ForumListActivity.this.lGS == 1) {
                                ForumListActivity.this.lHe.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(djG[ForumListActivity.this.lHe.lHr].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.lGS == 0) {
                this.emT.fz(djG[this.lHd.lHr].forum_name, String.valueOf(djG[this.lHd.lHr].forum_id));
            } else {
                this.emT.fz(djG[this.lHe.lHr].forum_name, String.valueOf(djG[this.lHe.lHr].forum_id));
            }
        }
    }
}
