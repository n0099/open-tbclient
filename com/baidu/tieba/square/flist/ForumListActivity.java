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
    private static String lHi = "";
    private static String lHj = "";
    private static String lHk = "";
    private static String lHl = "";
    private int lGG;
    private int lGH;
    private Drawable lGI;
    private Drawable lGJ;
    private Drawable lGK;
    private Drawable lGL;
    private Drawable lGM;
    private Drawable lGN;
    public com.baidu.tieba.square.flist.c lGX;
    private ForumListModel.RequestParams lGY;
    private com.baidu.tieba.square.flist.b lHb;
    private com.baidu.tieba.square.flist.b lHc;
    private DirMenuModel lHd;
    private ForumListDetailModel lHe;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int lGO = 200;
    private int lGP = 200;
    private int lGQ = 0;
    private final LikeModel emT = new LikeModel(getPageContext());
    private boolean lGR = false;
    private int menu_choose = 0;
    private boolean lGS = false;
    private int lGT = 0;
    private int lGU = 200;
    private boolean lGV = true;
    private boolean lGW = true;
    private boolean lGZ = false;
    private boolean lHa = false;
    private final ForumListDetailModel.a lHf = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.lHb.djG() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.lGX.djM();
                ForumListActivity.this.lGX.djL();
                if (ForumListActivity.this.lGY.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.lGX.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.lGY.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.lGX.djL();
                    ForumListActivity.this.lGY.recommend_type = ForumListActivity.this.lGT;
                    ForumListActivity.this.lGY.rn = ForumListActivity.this.lGU;
                }
                ForumListActivity.this.lGX.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.lGX.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lGS) {
                    ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGX.lHL.setImageDrawable(ForumListActivity.this.lGM);
                    ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGX.lHO.setImageDrawable(ForumListActivity.this.lGM);
                    ForumListActivity.this.lGS = false;
                }
                ForumListActivity.this.lGX.bjS.setText(ForumListActivity.this.lGY.menu_name);
                ForumListActivity.this.lGX.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lGX.lHV.Fd(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.lHb.Ep(min);
                ForumListActivity.this.lHb.a(ForumListActivity.this.emT);
                ForumListActivity.this.lHb.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.lGX.lHF.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.lGX.lHA.setVisibility(0);
                } else {
                    ForumListActivity.this.lGX.lHA.setVisibility(8);
                }
                ForumListActivity.this.lGX.lHH.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.lHc.Ep(min2);
                ForumListActivity.this.lHc.a(ForumListActivity.this.emT);
                ForumListActivity.this.lHc.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.lGX.lHG.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.lGX.lHB.setVisibility(0);
                } else {
                    ForumListActivity.this.lGX.lHB.setVisibility(8);
                }
                ForumListActivity.this.lGX.lHI.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.lGX.djL();
                if (ForumListActivity.this.lGX.lHV.getCount() > 0) {
                    ForumListActivity.this.lGX.lHW.setClickable(true);
                    ForumListActivity.this.lGX.lHW.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b lHg = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.lGX.djM();
                    return;
                }
                return;
            }
            eVar.lIG.add(0, eVar);
            if (ForumListActivity.this.lGX.lHV != null) {
                ForumListActivity.this.lGX.lHV.a(eVar);
                ForumListActivity.this.Nr(String.valueOf(ForumListActivity.this.lGX.bjS.getText()));
                ForumListActivity.this.lGX.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lGX.lHV.notifyDataSetChanged();
            }
            ForumListActivity.this.lGX.lHW.setClickable(true);
            ForumListActivity.this.lGX.lHW.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener lHh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.lGX.lHR, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.lGX.djM();
            ForumListActivity.this.lGX.djN();
            ArrayList<e> arrayList = ForumListActivity.this.lGX.lHV.djz().lIG;
            ForumListActivity.this.ax(arrayList.get(i).lGA, arrayList.get(i).lGC, arrayList.get(i).lGB);
        }
    };
    private final f.c fzt = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.lHb.djI() && !ForumListActivity.this.lHc.djI()) {
                if (ForumListActivity.this.lGV) {
                    ForumListActivity.this.lGY.recommend_type = 0;
                    ForumListActivity.this.lGY.rn = 200;
                    ForumListActivity.this.lHe.a(ForumListActivity.this.lGY);
                    ForumListActivity.this.lHe.LoadData();
                    ForumListActivity.this.lGV = false;
                } else if (ForumListActivity.this.lGX.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.lGZ) {
                        ForumListActivity.this.lGO = 50;
                    } else {
                        ForumListActivity.this.lGO = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.lGX.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.lHa) {
                        ForumListActivity.this.lGP = 50;
                    } else {
                        ForumListActivity.this.lGP = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Nr(String str) {
        e djz = this.lGX.lHV.djz();
        if (djz != null) {
            ArrayList<e> arrayList = djz.lIG;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).lGA.equals(str)) {
                    this.menu_choose = i;
                    this.lGX.lHV.Fd(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.lGY.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lGY.menu_name = str;
        this.lGY.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lGY.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.lGY.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.lGY.offset = 0;
        this.lGY.rn = 10;
        this.lGT = this.lGY.recommend_type;
        this.lGU = this.lGY.rn;
        this.lGY.recommend_type = 0;
        this.lGY.rn = 200;
        this.lGS = true;
        this.lHe.a(this.lGY);
        this.lHe.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lHo;

        private b() {
            this.lHo = false;
        }

        public void vd(boolean z) {
            this.lHo = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lGX.lHM.setEnabled(false);
            ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lGY.recommend_type = 2;
                ForumListActivity.this.lGY.offset = 0;
                ForumListActivity.this.lGY.rn = ForumListActivity.this.lGP;
                return ForumListModel.new_fetch(ForumListActivity.this.lGY);
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
                ForumListActivity.this.lHc.Ep(min);
                ForumListActivity.this.lHc.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.lGP == 200) {
                    ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGX.lHO.setImageDrawable(ForumListActivity.this.lGM);
                } else {
                    ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lGX.lHO.setImageDrawable(ForumListActivity.this.lGN);
                    ForumListActivity.this.lHa = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lHo) {
                    if (ForumListActivity.this.lGP == 200) {
                        ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lGX.lHO.setImageDrawable(ForumListActivity.this.lGM);
                    } else {
                        ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lGX.lHO.setImageDrawable(ForumListActivity.this.lGN);
                    }
                } else {
                    ForumListActivity.this.lGX.lHN.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGX.lHO.setImageDrawable(ForumListActivity.this.lGM);
                    ForumListActivity.this.lGY.rn = 200;
                    ForumListActivity.this.lGP = 200;
                }
            }
            ForumListActivity.this.lGX.lHM.setEnabled(true);
            ForumListActivity.this.lGX.djL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lHo;

        private c() {
            this.lHo = false;
        }

        public void vd(boolean z) {
            this.lHo = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lGX.lHJ.setEnabled(false);
            ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lGY.recommend_type = 1;
                ForumListActivity.this.lGY.offset = 0;
                ForumListActivity.this.lGY.rn = ForumListActivity.this.lGO;
                return ForumListModel.new_fetch(ForumListActivity.this.lGY);
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
                ForumListActivity.this.lHb.Ep(min);
                ForumListActivity.this.lHb.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.lGO == 200) {
                    ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGX.lHL.setImageDrawable(ForumListActivity.this.lGM);
                } else {
                    ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lGX.lHL.setImageDrawable(ForumListActivity.this.lGN);
                    ForumListActivity.this.lGZ = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lHo) {
                    if (ForumListActivity.this.lGO == 200) {
                        ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lGX.lHL.setImageDrawable(ForumListActivity.this.lGM);
                    } else {
                        ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lGX.lHL.setImageDrawable(ForumListActivity.this.lGN);
                    }
                } else {
                    ForumListActivity.this.lGX.lHK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lGX.lHL.setImageDrawable(ForumListActivity.this.lGM);
                    ForumListActivity.this.lGY.rn = 200;
                    ForumListActivity.this.lGO = 200;
                }
            }
            ForumListActivity.this.lGX.lHJ.setEnabled(true);
            ForumListActivity.this.lGX.djL();
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
        this.lGX = new com.baidu.tieba.square.flist.c(this);
        this.lGX.lHF = (BdListView) djB();
        this.lGX.lHG = (BdListView) djD();
        this.lGX.mProgressBar.setVisibility(0);
        this.lGX.lHW.setOnClickListener(null);
        this.lGX.lHW.setClickable(false);
        this.lGX.mViewPager.setAdapter(new a());
        this.lGX.lHF.setPullRefresh(this.lGX.lHP);
        this.lGX.lHG.setPullRefresh(this.lGX.lHQ);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.lGX.lHF.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.lGX.lHG.addHeaderView(textView2, 0);
        this.lHb = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.lGX.lHF.setAdapter((ListAdapter) this.lHb);
        this.lHc = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.lGX.lHG.setAdapter((ListAdapter) this.lHc);
        D(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void D(String str, String str2, String str3, String str4) {
        if (as.isEmpty(str4)) {
            str4 = str;
        }
        this.lGX.bjS.setText(str4);
        this.lGX.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.lGY = new ForumListModel.RequestParams();
        this.lGY.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lGY.menu_name = str4;
        this.lGY.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lGY.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lGY.parent_menu_name = str;
        this.lGY.offset = 0;
        this.lGY.rn = 10;
        if (this.lGY.menu_id != 0) {
            this.lGX.djK();
            this.lGR = true;
            this.lGW = false;
            this.lHb.o(Boolean.valueOf(this.lGW));
            this.lGX.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.lGW = true;
            this.lHb.o(Boolean.valueOf(this.lGW));
            this.lGX.djJ();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.lGX.lHP.setListPullRefreshListener(this.fzt);
        this.lGX.lHQ.setListPullRefreshListener(this.fzt);
        this.lHb.notifyDataSetChanged();
        this.lHc.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.lGX.djM();
        } else {
            this.lHd = new DirMenuModel(getPageContext(), str, str3, str2);
            this.lHd.a(this.lHg);
            this.lHd.LoadData();
        }
        this.lHe = new ForumListDetailModel(getPageContext(), this.lGY);
        this.lHe.a(this.lHf);
        this.lGX.lHF.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hFq) {
            hFq = false;
            finish();
            c(getPageContext().getPageActivity(), lHi, lHk, lHj, lHl);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.lHb != null) {
                this.lHb.djH();
                this.lHb.notifyDataSetChanged();
            }
            if (this.lHc != null) {
                this.lHc.djH();
                this.lHc.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.emT != null) {
            this.emT.dkA();
        }
        this.lGX.mViewPager.setAdapter(null);
        this.lGX.lHG.setAdapter((ListAdapter) null);
        this.lGX.lHF.setAdapter((ListAdapter) null);
        if (this.lGX.lHU != null) {
            this.lGX.lHU.setAdapter((ListAdapter) null);
        }
        if (this.lHd != null) {
            this.lHd.cancelLoadData();
        }
        if (this.lHe != null) {
            this.lHe.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lGX.hsG);
        this.lGX.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lHb.ve(true);
            this.lHc.ve(true);
        } else {
            this.lHb.ve(false);
            this.lHc.ve(false);
        }
        this.lHb.notifyDataSetChanged();
        this.lHc.notifyDataSetChanged();
        if (this.lGX.lHR != null) {
            this.lGX.lHR.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ao.setBackgroundResource(this.lGX.lHC, R.drawable.bg_pop_most);
        this.lGG = ao.getColor(R.color.common_color_10243);
        this.lGH = ao.getColor(R.color.cp_cont_a);
        this.lGI = ao.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lGJ = ao.getDrawable(R.drawable.btn_pop_most_right_n);
        this.lGK = ao.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lGL = ao.getDrawable(R.drawable.btn_pop_most_right_s);
        this.lGM = ao.getDrawable(R.drawable.ico_downward);
        this.lGN = ao.getDrawable(R.drawable.ico_upward);
        this.lHb.db(R.drawable.btn_add_end, R.drawable.btn_add);
        this.lHc.db(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.lGX.lHB, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.lGX.lHN, R.color.common_color_10243, 1);
        ao.setBackgroundResource(this.lGX.lHA, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.lGX.lHK, R.color.common_color_10243, 1);
        if (this.lGZ) {
            ao.setImageResource(this.lGX.lHL, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.lGX.lHL, R.drawable.ico_downward);
        }
        if (this.lHa) {
            ao.setImageResource(this.lGX.lHO, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.lGX.lHO, R.drawable.ico_downward);
        }
        if (this.lGX.mViewPager.getCurrentItem() == 0) {
            this.lGX.lHH.setTextColor(this.lGH);
            this.lGX.lHH.setBackgroundDrawable(this.lGK);
            this.lGX.lHI.setBackgroundDrawable(this.lGJ);
            this.lGX.lHI.setTextColor(this.lGG);
            return;
        }
        this.lGX.lHI.setTextColor(this.lGH);
        this.lGX.lHI.setBackgroundDrawable(this.lGL);
        this.lGX.lHH.setBackgroundDrawable(this.lGI);
        this.lGX.lHH.setTextColor(this.lGG);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.lGX.mViewPager.setCurrentItem(0);
            this.lGQ = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.lGX.mViewPager.setCurrentItem(1);
            this.lGQ = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.lGX.c(this.lHh);
        }
    }

    private View djB() {
        this.lGX.lHF = djF();
        this.lGX.lHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.djC();
            }
        });
        return this.lGX.lHF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djC() {
        if (this.lGZ) {
            int min = Math.min(this.lHb.getCount(), 200);
            this.lGO = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lHb.djG(), 0, forumInfoDataArr, 0, min);
            this.lHb.Ep(min);
            this.lHb.a(forumInfoDataArr);
            this.lGZ = false;
            this.lGX.lHK.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lGX.lHL.setImageDrawable(this.lGM);
            return;
        }
        this.lGO = 50;
        c cVar = new c();
        cVar.vd(true);
        cVar.execute(new Void[0]);
    }

    private View djD() {
        this.lGX.lHG = djF();
        this.lGX.lHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.djE();
            }
        });
        return this.lGX.lHG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djE() {
        if (this.lHa) {
            int min = Math.min(this.lHc.getCount(), 200);
            this.lGP = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lHc.djG(), 0, forumInfoDataArr, 0, min);
            this.lHc.Ep(min);
            this.lHc.a(forumInfoDataArr);
            this.lHa = false;
            this.lGX.lHN.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lGX.lHO.setImageDrawable(this.lGM);
            return;
        }
        this.lGP = 50;
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
        if (!this.lGR) {
            if (i == 0) {
                this.lHb.djH();
                this.lHb.notifyDataSetChanged();
                this.lGX.lHH.setBackgroundDrawable(this.lGK);
                this.lGX.lHH.setTextColor(this.lGH);
                this.lGX.lHI.setBackgroundDrawable(this.lGJ);
                this.lGX.lHI.setTextColor(this.lGG);
            } else if (i == 1) {
                this.lHc.djH();
                this.lHc.notifyDataSetChanged();
                this.lGX.lHI.setBackgroundDrawable(this.lGL);
                this.lGX.lHI.setTextColor(this.lGH);
                this.lGX.lHH.setBackgroundDrawable(this.lGI);
                this.lGX.lHH.setTextColor(this.lGG);
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
            return ForumListActivity.this.lGR ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.lGX.lHF);
                    return ForumListActivity.this.lGX.lHF;
                case 1:
                    viewGroup.addView(ForumListActivity.this.lGX.lHG);
                    return ForumListActivity.this.lGX.lHG;
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
            this.lHe.LoadData();
            if (this.lGQ == 0) {
                djG = this.lHb.djG();
            } else {
                djG = this.lHc.djG();
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
                            if (ForumListActivity.this.lGQ == 0) {
                                ForumListActivity.this.lHb.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(djG[ForumListActivity.this.lHb.lHp].forum_name);
                            } else if (ForumListActivity.this.lGQ == 1) {
                                ForumListActivity.this.lHc.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(djG[ForumListActivity.this.lHc.lHp].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.lGQ == 0) {
                this.emT.fz(djG[this.lHb.lHp].forum_name, String.valueOf(djG[this.lHb.lHp].forum_id));
            } else {
                this.emT.fz(djG[this.lHc.lHp].forum_name, String.valueOf(djG[this.lHc.lHp].forum_id));
            }
        }
    }
}
