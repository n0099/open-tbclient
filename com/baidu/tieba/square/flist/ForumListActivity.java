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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    private Drawable izA;
    private Drawable izB;
    private Drawable izC;
    public com.baidu.tieba.square.flist.c izM;
    private ForumListModel.RequestParams izN;
    private com.baidu.tieba.square.flist.b izQ;
    private com.baidu.tieba.square.flist.b izR;
    private DirMenuModel izS;
    private ForumListDetailModel izT;
    private int izv;
    private int izw;
    private Drawable izx;
    private Drawable izy;
    private Drawable izz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    public static boolean eYv = false;
    private static String izX = "";
    private static String izY = "";
    private static String izZ = "";
    private static String iAa = "";
    private int izD = 200;
    private int izE = 200;
    private int izF = 0;
    private final LikeModel bUs = new LikeModel(getPageContext());
    private boolean izG = false;
    private int menu_choose = 0;
    private boolean izH = false;
    private int izI = 0;
    private int izJ = 200;
    private boolean izK = true;
    private boolean izL = true;
    private boolean izO = false;
    private boolean izP = false;
    private final ForumListDetailModel.a izU = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.izQ.ccN() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.izM.ccT();
                ForumListActivity.this.izM.ccS();
                if (ForumListActivity.this.izN.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.izM.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.izN.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.izM.ccS();
                    ForumListActivity.this.izN.recommend_type = ForumListActivity.this.izI;
                    ForumListActivity.this.izN.rn = ForumListActivity.this.izJ;
                }
                ForumListActivity.this.izM.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.izM.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.izH) {
                    ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izM.iAA.setImageDrawable(ForumListActivity.this.izB);
                    ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izM.iAD.setImageDrawable(ForumListActivity.this.izB);
                    ForumListActivity.this.izH = false;
                }
                ForumListActivity.this.izM.eKf.setText(ForumListActivity.this.izN.menu_name);
                ForumListActivity.this.izM.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.izM.iAK.zb(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.izQ.yp(min);
                ForumListActivity.this.izQ.a(ForumListActivity.this.bUs);
                ForumListActivity.this.izQ.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.izM.iAu.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.izM.iAp.setVisibility(0);
                } else {
                    ForumListActivity.this.izM.iAp.setVisibility(8);
                }
                ForumListActivity.this.izM.iAw.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.izR.yp(min2);
                ForumListActivity.this.izR.a(ForumListActivity.this.bUs);
                ForumListActivity.this.izR.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.izM.iAv.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.izM.iAq.setVisibility(0);
                } else {
                    ForumListActivity.this.izM.iAq.setVisibility(8);
                }
                ForumListActivity.this.izM.iAx.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(d.g.item_root).setVisibility(0);
                ForumListActivity.this.izM.ccS();
                if (ForumListActivity.this.izM.iAK.getCount() > 0) {
                    ForumListActivity.this.izM.iAL.setClickable(true);
                    ForumListActivity.this.izM.iAL.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b izV = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, com.baidu.tieba.square.square.d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.izM.ccT();
                    return;
                }
                return;
            }
            dVar.iBC.add(0, dVar);
            if (ForumListActivity.this.izM.iAK != null) {
                ForumListActivity.this.izM.iAK.a(dVar);
                ForumListActivity.this.Cj(String.valueOf(ForumListActivity.this.izM.eKf.getText()));
                ForumListActivity.this.izM.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.izM.iAK.notifyDataSetChanged();
            }
            ForumListActivity.this.izM.iAL.setClickable(true);
            ForumListActivity.this.izM.iAL.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener izW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.izM.iAG, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.izM.ccT();
            ForumListActivity.this.izM.ccU();
            ArrayList<com.baidu.tieba.square.square.d> arrayList = ForumListActivity.this.izM.iAK.ccG().iBC;
            ForumListActivity.this.ab(arrayList.get(i).izp, arrayList.get(i).izr, arrayList.get(i).izq);
        }
    };
    private final h.c dht = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (!ForumListActivity.this.izQ.ccP() && !ForumListActivity.this.izR.ccP()) {
                if (ForumListActivity.this.izK) {
                    ForumListActivity.this.izN.recommend_type = 0;
                    ForumListActivity.this.izN.rn = 200;
                    ForumListActivity.this.izT.a(ForumListActivity.this.izN);
                    ForumListActivity.this.izT.LoadData();
                    ForumListActivity.this.izK = false;
                } else if (ForumListActivity.this.izM.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.izO) {
                        ForumListActivity.this.izD = 50;
                    } else {
                        ForumListActivity.this.izD = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.izM.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.izP) {
                        ForumListActivity.this.izE = 50;
                    } else {
                        ForumListActivity.this.izE = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj(String str) {
        com.baidu.tieba.square.square.d ccG = this.izM.iAK.ccG();
        if (ccG != null) {
            ArrayList<com.baidu.tieba.square.square.d> arrayList = ccG.iBC;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).izp.equals(str)) {
                    this.menu_choose = i;
                    this.izM.iAK.zb(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.izN.menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.izN.menu_name = str;
        this.izN.menu_type = com.baidu.adp.lib.g.b.l(str3, 0);
        this.izN.parent_menu_id = com.baidu.adp.lib.g.b.l(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.izN.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.izN.offset = 0;
        this.izN.rn = 10;
        this.izI = this.izN.recommend_type;
        this.izJ = this.izN.rn;
        this.izN.recommend_type = 0;
        this.izN.rn = 200;
        this.izH = true;
        this.izT.a(this.izN);
        this.izT.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iAd;

        private b() {
            this.iAd = false;
        }

        public void pO(boolean z) {
            this.iAd = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.izM.iAB.setEnabled(false);
            ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.izN.recommend_type = 2;
                ForumListActivity.this.izN.offset = 0;
                ForumListActivity.this.izN.rn = ForumListActivity.this.izE;
                return ForumListModel.new_fetch(ForumListActivity.this.izN);
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
                ForumListActivity.this.izR.yp(min);
                ForumListActivity.this.izR.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.izE == 200) {
                    ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izM.iAD.setImageDrawable(ForumListActivity.this.izB);
                } else {
                    ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                    ForumListActivity.this.izM.iAD.setImageDrawable(ForumListActivity.this.izC);
                    ForumListActivity.this.izP = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.neterror));
                if (!this.iAd) {
                    if (ForumListActivity.this.izE == 200) {
                        ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                        ForumListActivity.this.izM.iAD.setImageDrawable(ForumListActivity.this.izB);
                    } else {
                        ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                        ForumListActivity.this.izM.iAD.setImageDrawable(ForumListActivity.this.izC);
                    }
                } else {
                    ForumListActivity.this.izM.iAC.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izM.iAD.setImageDrawable(ForumListActivity.this.izB);
                    ForumListActivity.this.izN.rn = 200;
                    ForumListActivity.this.izE = 200;
                }
            }
            ForumListActivity.this.izM.iAB.setEnabled(true);
            ForumListActivity.this.izM.ccS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iAd;

        private c() {
            this.iAd = false;
        }

        public void pO(boolean z) {
            this.iAd = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.izM.iAy.setEnabled(false);
            ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.izN.recommend_type = 1;
                ForumListActivity.this.izN.offset = 0;
                ForumListActivity.this.izN.rn = ForumListActivity.this.izD;
                return ForumListModel.new_fetch(ForumListActivity.this.izN);
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
                ForumListActivity.this.izQ.yp(min);
                ForumListActivity.this.izQ.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.izD == 200) {
                    ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izM.iAA.setImageDrawable(ForumListActivity.this.izB);
                } else {
                    ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                    ForumListActivity.this.izM.iAA.setImageDrawable(ForumListActivity.this.izC);
                    ForumListActivity.this.izO = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.neterror));
                if (!this.iAd) {
                    if (ForumListActivity.this.izD == 200) {
                        ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                        ForumListActivity.this.izM.iAA.setImageDrawable(ForumListActivity.this.izB);
                    } else {
                        ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                        ForumListActivity.this.izM.iAA.setImageDrawable(ForumListActivity.this.izC);
                    }
                } else {
                    ForumListActivity.this.izM.iAz.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izM.iAA.setImageDrawable(ForumListActivity.this.izB);
                    ForumListActivity.this.izN.rn = 200;
                    ForumListActivity.this.izD = 200;
                }
            }
            ForumListActivity.this.izM.iAy.setEnabled(true);
            ForumListActivity.this.izM.ccS();
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
        int h;
        super.onCreate(bundle);
        setContentView(d.h.forum_list_activity);
        String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
        String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
        this.izM = new com.baidu.tieba.square.flist.c(this);
        this.izM.iAu = (BdListView) ccI();
        this.izM.iAv = (BdListView) ccK();
        this.izM.mProgressBar.setVisibility(0);
        this.izM.iAL.setOnClickListener(null);
        this.izM.iAL.setClickable(false);
        this.izM.mViewPager.setAdapter(new a());
        this.izM.iAu.setPullRefresh(this.izM.iAE);
        this.izM.iAv.setPullRefresh(this.izM.iAF);
        if (com.baidu.adp.lib.g.b.l(stringExtra3, 0) != 0) {
            h = l.h(getActivity(), d.e.ds98);
        } else {
            h = l.h(getActivity(), d.e.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + h));
        this.izM.iAu.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, h + UtilHelper.getLightStatusBarHeight()));
        this.izM.iAv.addHeaderView(textView2, 0);
        this.izQ = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.izM.iAu.setAdapter((ListAdapter) this.izQ);
        this.izR = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.izM.iAv.setAdapter((ListAdapter) this.izR);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (ap.isEmpty(str4)) {
            str4 = str;
        }
        this.izM.eKf.setText(str4);
        this.izM.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.izN = new ForumListModel.RequestParams();
        this.izN.menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.izN.menu_name = str4;
        this.izN.menu_type = com.baidu.adp.lib.g.b.l(str3, 0);
        this.izN.parent_menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.izN.parent_menu_name = str;
        this.izN.offset = 0;
        this.izN.rn = 10;
        if (this.izN.menu_id != 0) {
            this.izM.ccR();
            this.izG = true;
            this.izL = false;
            this.izQ.i(Boolean.valueOf(this.izL));
            this.izM.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.izL = true;
            this.izQ.i(Boolean.valueOf(this.izL));
            this.izM.ccQ();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.izM.iAE.setListPullRefreshListener(this.dht);
        this.izM.iAF.setListPullRefreshListener(this.dht);
        this.izQ.notifyDataSetChanged();
        this.izR.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.izM.ccT();
        } else {
            this.izS = new DirMenuModel(getPageContext(), str, str3, str2);
            this.izS.a(this.izV);
            this.izS.LoadData();
        }
        this.izT = new ForumListDetailModel(getPageContext(), this.izN);
        this.izT.a(this.izU);
        this.izM.iAu.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (eYv) {
            eYv = false;
            finish();
            b(getPageContext().getPageActivity(), izX, izZ, izY, iAa);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.izQ != null) {
                this.izQ.ccO();
                this.izQ.notifyDataSetChanged();
            }
            if (this.izR != null) {
                this.izR.ccO();
                this.izR.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.bUs != null) {
            this.bUs.cdE();
        }
        this.izM.mViewPager.setAdapter(null);
        this.izM.iAv.setAdapter((ListAdapter) null);
        this.izM.iAu.setAdapter((ListAdapter) null);
        if (this.izM.iAJ != null) {
            this.izM.iAJ.setAdapter((ListAdapter) null);
        }
        if (this.izS != null) {
            this.izS.cancelLoadData();
        }
        if (this.izT != null) {
            this.izT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.izM.eIt);
        this.izM.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.izQ.pP(true);
            this.izR.pP(true);
        } else {
            this.izQ.pP(false);
            this.izR.pP(false);
        }
        this.izQ.notifyDataSetChanged();
        this.izR.notifyDataSetChanged();
        if (this.izM.iAG != null) {
            this.izM.iAG.setBackgroundDrawable(al.getDrawable(d.f.bg_allsproutpop_dropdown));
        }
        al.k(this.izM.iAr, d.f.bg_pop_most);
        this.izv = al.getColor(d.C0277d.common_color_10243);
        this.izw = al.getColor(d.C0277d.cp_btn_a);
        this.izx = al.getDrawable(d.f.btn_pop_most_left_n);
        this.izy = al.getDrawable(d.f.btn_pop_most_right_n);
        this.izz = al.getDrawable(d.f.btn_pop_most_left_s);
        this.izA = al.getDrawable(d.f.btn_pop_most_right_s);
        this.izB = al.getDrawable(d.f.ico_downward);
        this.izC = al.getDrawable(d.f.ico_upward);
        this.izQ.ck(d.f.btn_add_end, d.f.btn_add);
        this.izR.ck(d.f.btn_add_end, d.f.btn_add);
        al.k(this.izM.iAq, d.f.bg_black_banner_down);
        al.d(this.izM.iAC, d.C0277d.common_color_10243, 1);
        al.k(this.izM.iAp, d.f.bg_black_banner_down);
        al.d(this.izM.iAz, d.C0277d.common_color_10243, 1);
        if (this.izO) {
            al.c(this.izM.iAA, d.f.ico_upward);
        } else {
            al.c(this.izM.iAA, d.f.ico_downward);
        }
        if (this.izP) {
            al.c(this.izM.iAD, d.f.ico_upward);
        } else {
            al.c(this.izM.iAD, d.f.ico_downward);
        }
        if (this.izM.mViewPager.getCurrentItem() == 0) {
            this.izM.iAw.setTextColor(this.izw);
            this.izM.iAw.setBackgroundDrawable(this.izz);
            this.izM.iAx.setBackgroundDrawable(this.izy);
            this.izM.iAx.setTextColor(this.izv);
            return;
        }
        this.izM.iAx.setTextColor(this.izw);
        this.izM.iAx.setBackgroundDrawable(this.izA);
        this.izM.iAw.setBackgroundDrawable(this.izx);
        this.izM.iAw.setTextColor(this.izv);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.tab_recommends) {
            this.izM.mViewPager.setCurrentItem(0);
            this.izF = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == d.g.tab_hot) {
            this.izM.mViewPager.setCurrentItem(1);
            this.izF = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == d.g.title_menu) {
            this.izM.d(this.izW);
        }
    }

    private View ccI() {
        this.izM.iAu = ccM();
        this.izM.iAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ccJ();
            }
        });
        return this.izM.iAu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccJ() {
        if (this.izO) {
            int min = Math.min(this.izQ.getCount(), 200);
            this.izD = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.izQ.ccN(), 0, forumInfoDataArr, 0, min);
            this.izQ.yp(min);
            this.izQ.a(forumInfoDataArr);
            this.izO = false;
            this.izM.iAz.setText(getPageContext().getString(d.j.flist_expand_list));
            this.izM.iAA.setImageDrawable(this.izB);
            return;
        }
        this.izD = 50;
        c cVar = new c();
        cVar.pO(true);
        cVar.execute(new Void[0]);
    }

    private View ccK() {
        this.izM.iAv = ccM();
        this.izM.iAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ccL();
            }
        });
        return this.izM.iAv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccL() {
        if (this.izP) {
            int min = Math.min(this.izR.getCount(), 200);
            this.izE = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.izR.ccN(), 0, forumInfoDataArr, 0, min);
            this.izR.yp(min);
            this.izR.a(forumInfoDataArr);
            this.izP = false;
            this.izM.iAC.setText(getPageContext().getString(d.j.flist_expand_list));
            this.izM.iAD.setImageDrawable(this.izB);
            return;
        }
        this.izE = 50;
        b bVar = new b();
        bVar.pO(true);
        bVar.execute(new Void[0]);
    }

    private BdListView ccM() {
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
        if (!this.izG) {
            if (i == 0) {
                this.izQ.ccO();
                this.izQ.notifyDataSetChanged();
                this.izM.iAw.setBackgroundDrawable(this.izz);
                this.izM.iAw.setTextColor(this.izw);
                this.izM.iAx.setBackgroundDrawable(this.izy);
                this.izM.iAx.setTextColor(this.izv);
            } else if (i == 1) {
                this.izR.ccO();
                this.izR.notifyDataSetChanged();
                this.izM.iAx.setBackgroundDrawable(this.izA);
                this.izM.iAx.setTextColor(this.izw);
                this.izM.iAw.setBackgroundDrawable(this.izx);
                this.izM.iAw.setTextColor(this.izv);
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
            return ForumListActivity.this.izG ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.izM.iAu);
                    return ForumListActivity.this.izM.iAu;
                case 1:
                    viewGroup.addView(ForumListActivity.this.izM.iAv);
                    return ForumListActivity.this.izM.iAv;
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
        final ForumInfoData[] ccN;
        if (i == 11002 && i2 == -1) {
            this.izT.LoadData();
            if (this.izF == 0) {
                ccN = this.izQ.ccN();
            } else {
                ccN = this.izR.ccN();
            }
            this.bUs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.bUs.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.bUs.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.bUs.getErrorString());
                        } else if (((r) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.attention_success));
                            if (ForumListActivity.this.izF == 0) {
                                ForumListActivity.this.izQ.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ccN[ForumListActivity.this.izQ.iAe].forum_name);
                            } else if (ForumListActivity.this.izF == 1) {
                                ForumListActivity.this.izR.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ccN[ForumListActivity.this.izR.iAe].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.izF == 0) {
                this.bUs.dW(ccN[this.izQ.iAe].forum_name, String.valueOf(ccN[this.izQ.iAe].forum_id));
            } else {
                this.bUs.dW(ccN[this.izR.iAe].forum_name, String.valueOf(ccN[this.izR.iAe].forum_id));
            }
        }
    }
}
