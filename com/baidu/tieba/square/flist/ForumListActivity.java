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
    private Drawable izD;
    public com.baidu.tieba.square.flist.c izN;
    private ForumListModel.RequestParams izO;
    private com.baidu.tieba.square.flist.b izR;
    private com.baidu.tieba.square.flist.b izS;
    private DirMenuModel izT;
    private ForumListDetailModel izU;
    private int izw;
    private int izx;
    private Drawable izy;
    private Drawable izz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    public static boolean eYw = false;
    private static String izY = "";
    private static String izZ = "";
    private static String iAa = "";
    private static String iAb = "";
    private int izE = 200;
    private int izF = 200;
    private int izG = 0;
    private final LikeModel bUt = new LikeModel(getPageContext());
    private boolean izH = false;
    private int menu_choose = 0;
    private boolean izI = false;
    private int izJ = 0;
    private int izK = 200;
    private boolean izL = true;
    private boolean izM = true;
    private boolean izP = false;
    private boolean izQ = false;
    private final ForumListDetailModel.a izV = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.izR.ccN() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.izN.ccT();
                ForumListActivity.this.izN.ccS();
                if (ForumListActivity.this.izO.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.izN.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.izO.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.izN.ccS();
                    ForumListActivity.this.izO.recommend_type = ForumListActivity.this.izJ;
                    ForumListActivity.this.izO.rn = ForumListActivity.this.izK;
                }
                ForumListActivity.this.izN.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.izN.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.izI) {
                    ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izN.iAB.setImageDrawable(ForumListActivity.this.izC);
                    ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izN.iAE.setImageDrawable(ForumListActivity.this.izC);
                    ForumListActivity.this.izI = false;
                }
                ForumListActivity.this.izN.eKg.setText(ForumListActivity.this.izO.menu_name);
                ForumListActivity.this.izN.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.izN.iAL.zb(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.izR.yp(min);
                ForumListActivity.this.izR.a(ForumListActivity.this.bUt);
                ForumListActivity.this.izR.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.izN.iAv.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.izN.iAq.setVisibility(0);
                } else {
                    ForumListActivity.this.izN.iAq.setVisibility(8);
                }
                ForumListActivity.this.izN.iAx.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.izS.yp(min2);
                ForumListActivity.this.izS.a(ForumListActivity.this.bUt);
                ForumListActivity.this.izS.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.izN.iAw.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.izN.iAr.setVisibility(0);
                } else {
                    ForumListActivity.this.izN.iAr.setVisibility(8);
                }
                ForumListActivity.this.izN.iAy.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(d.g.item_root).setVisibility(0);
                ForumListActivity.this.izN.ccS();
                if (ForumListActivity.this.izN.iAL.getCount() > 0) {
                    ForumListActivity.this.izN.iAM.setClickable(true);
                    ForumListActivity.this.izN.iAM.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b izW = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, com.baidu.tieba.square.square.d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.izN.ccT();
                    return;
                }
                return;
            }
            dVar.iBD.add(0, dVar);
            if (ForumListActivity.this.izN.iAL != null) {
                ForumListActivity.this.izN.iAL.a(dVar);
                ForumListActivity.this.Cj(String.valueOf(ForumListActivity.this.izN.eKg.getText()));
                ForumListActivity.this.izN.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.izN.iAL.notifyDataSetChanged();
            }
            ForumListActivity.this.izN.iAM.setClickable(true);
            ForumListActivity.this.izN.iAM.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener izX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.izN.iAH, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.izN.ccT();
            ForumListActivity.this.izN.ccU();
            ArrayList<com.baidu.tieba.square.square.d> arrayList = ForumListActivity.this.izN.iAL.ccG().iBD;
            ForumListActivity.this.ab(arrayList.get(i).izq, arrayList.get(i).izs, arrayList.get(i).izr);
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (!ForumListActivity.this.izR.ccP() && !ForumListActivity.this.izS.ccP()) {
                if (ForumListActivity.this.izL) {
                    ForumListActivity.this.izO.recommend_type = 0;
                    ForumListActivity.this.izO.rn = 200;
                    ForumListActivity.this.izU.a(ForumListActivity.this.izO);
                    ForumListActivity.this.izU.LoadData();
                    ForumListActivity.this.izL = false;
                } else if (ForumListActivity.this.izN.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.izP) {
                        ForumListActivity.this.izE = 50;
                    } else {
                        ForumListActivity.this.izE = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.izN.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.izQ) {
                        ForumListActivity.this.izF = 50;
                    } else {
                        ForumListActivity.this.izF = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj(String str) {
        com.baidu.tieba.square.square.d ccG = this.izN.iAL.ccG();
        if (ccG != null) {
            ArrayList<com.baidu.tieba.square.square.d> arrayList = ccG.iBD;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).izq.equals(str)) {
                    this.menu_choose = i;
                    this.izN.iAL.zb(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.izO.menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.izO.menu_name = str;
        this.izO.menu_type = com.baidu.adp.lib.g.b.l(str3, 0);
        this.izO.parent_menu_id = com.baidu.adp.lib.g.b.l(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.izO.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.izO.offset = 0;
        this.izO.rn = 10;
        this.izJ = this.izO.recommend_type;
        this.izK = this.izO.rn;
        this.izO.recommend_type = 0;
        this.izO.rn = 200;
        this.izI = true;
        this.izU.a(this.izO);
        this.izU.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iAe;

        private b() {
            this.iAe = false;
        }

        public void pO(boolean z) {
            this.iAe = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.izN.iAC.setEnabled(false);
            ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.izO.recommend_type = 2;
                ForumListActivity.this.izO.offset = 0;
                ForumListActivity.this.izO.rn = ForumListActivity.this.izF;
                return ForumListModel.new_fetch(ForumListActivity.this.izO);
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
                ForumListActivity.this.izS.yp(min);
                ForumListActivity.this.izS.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.izF == 200) {
                    ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izN.iAE.setImageDrawable(ForumListActivity.this.izC);
                } else {
                    ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                    ForumListActivity.this.izN.iAE.setImageDrawable(ForumListActivity.this.izD);
                    ForumListActivity.this.izQ = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.neterror));
                if (!this.iAe) {
                    if (ForumListActivity.this.izF == 200) {
                        ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                        ForumListActivity.this.izN.iAE.setImageDrawable(ForumListActivity.this.izC);
                    } else {
                        ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                        ForumListActivity.this.izN.iAE.setImageDrawable(ForumListActivity.this.izD);
                    }
                } else {
                    ForumListActivity.this.izN.iAD.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izN.iAE.setImageDrawable(ForumListActivity.this.izC);
                    ForumListActivity.this.izO.rn = 200;
                    ForumListActivity.this.izF = 200;
                }
            }
            ForumListActivity.this.izN.iAC.setEnabled(true);
            ForumListActivity.this.izN.ccS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iAe;

        private c() {
            this.iAe = false;
        }

        public void pO(boolean z) {
            this.iAe = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.izN.iAz.setEnabled(false);
            ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.izO.recommend_type = 1;
                ForumListActivity.this.izO.offset = 0;
                ForumListActivity.this.izO.rn = ForumListActivity.this.izE;
                return ForumListModel.new_fetch(ForumListActivity.this.izO);
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
                ForumListActivity.this.izR.yp(min);
                ForumListActivity.this.izR.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.izE == 200) {
                    ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izN.iAB.setImageDrawable(ForumListActivity.this.izC);
                } else {
                    ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                    ForumListActivity.this.izN.iAB.setImageDrawable(ForumListActivity.this.izD);
                    ForumListActivity.this.izP = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.neterror));
                if (!this.iAe) {
                    if (ForumListActivity.this.izE == 200) {
                        ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                        ForumListActivity.this.izN.iAB.setImageDrawable(ForumListActivity.this.izC);
                    } else {
                        ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                        ForumListActivity.this.izN.iAB.setImageDrawable(ForumListActivity.this.izD);
                    }
                } else {
                    ForumListActivity.this.izN.iAA.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.izN.iAB.setImageDrawable(ForumListActivity.this.izC);
                    ForumListActivity.this.izO.rn = 200;
                    ForumListActivity.this.izE = 200;
                }
            }
            ForumListActivity.this.izN.iAz.setEnabled(true);
            ForumListActivity.this.izN.ccS();
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
        this.izN = new com.baidu.tieba.square.flist.c(this);
        this.izN.iAv = (BdListView) ccI();
        this.izN.iAw = (BdListView) ccK();
        this.izN.mProgressBar.setVisibility(0);
        this.izN.iAM.setOnClickListener(null);
        this.izN.iAM.setClickable(false);
        this.izN.mViewPager.setAdapter(new a());
        this.izN.iAv.setPullRefresh(this.izN.iAF);
        this.izN.iAw.setPullRefresh(this.izN.iAG);
        if (com.baidu.adp.lib.g.b.l(stringExtra3, 0) != 0) {
            h = l.h(getActivity(), d.e.ds98);
        } else {
            h = l.h(getActivity(), d.e.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + h));
        this.izN.iAv.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, h + UtilHelper.getLightStatusBarHeight()));
        this.izN.iAw.addHeaderView(textView2, 0);
        this.izR = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.izN.iAv.setAdapter((ListAdapter) this.izR);
        this.izS = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.izN.iAw.setAdapter((ListAdapter) this.izS);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (ap.isEmpty(str4)) {
            str4 = str;
        }
        this.izN.eKg.setText(str4);
        this.izN.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.izO = new ForumListModel.RequestParams();
        this.izO.menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.izO.menu_name = str4;
        this.izO.menu_type = com.baidu.adp.lib.g.b.l(str3, 0);
        this.izO.parent_menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.izO.parent_menu_name = str;
        this.izO.offset = 0;
        this.izO.rn = 10;
        if (this.izO.menu_id != 0) {
            this.izN.ccR();
            this.izH = true;
            this.izM = false;
            this.izR.i(Boolean.valueOf(this.izM));
            this.izN.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.izM = true;
            this.izR.i(Boolean.valueOf(this.izM));
            this.izN.ccQ();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.izN.iAF.setListPullRefreshListener(this.dhu);
        this.izN.iAG.setListPullRefreshListener(this.dhu);
        this.izR.notifyDataSetChanged();
        this.izS.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.izN.ccT();
        } else {
            this.izT = new DirMenuModel(getPageContext(), str, str3, str2);
            this.izT.a(this.izW);
            this.izT.LoadData();
        }
        this.izU = new ForumListDetailModel(getPageContext(), this.izO);
        this.izU.a(this.izV);
        this.izN.iAv.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (eYw) {
            eYw = false;
            finish();
            b(getPageContext().getPageActivity(), izY, iAa, izZ, iAb);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.izR != null) {
                this.izR.ccO();
                this.izR.notifyDataSetChanged();
            }
            if (this.izS != null) {
                this.izS.ccO();
                this.izS.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.bUt != null) {
            this.bUt.cdE();
        }
        this.izN.mViewPager.setAdapter(null);
        this.izN.iAw.setAdapter((ListAdapter) null);
        this.izN.iAv.setAdapter((ListAdapter) null);
        if (this.izN.iAK != null) {
            this.izN.iAK.setAdapter((ListAdapter) null);
        }
        if (this.izT != null) {
            this.izT.cancelLoadData();
        }
        if (this.izU != null) {
            this.izU.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.izN.eIu);
        this.izN.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.izR.pP(true);
            this.izS.pP(true);
        } else {
            this.izR.pP(false);
            this.izS.pP(false);
        }
        this.izR.notifyDataSetChanged();
        this.izS.notifyDataSetChanged();
        if (this.izN.iAH != null) {
            this.izN.iAH.setBackgroundDrawable(al.getDrawable(d.f.bg_allsproutpop_dropdown));
        }
        al.k(this.izN.iAs, d.f.bg_pop_most);
        this.izw = al.getColor(d.C0277d.common_color_10243);
        this.izx = al.getColor(d.C0277d.cp_btn_a);
        this.izy = al.getDrawable(d.f.btn_pop_most_left_n);
        this.izz = al.getDrawable(d.f.btn_pop_most_right_n);
        this.izA = al.getDrawable(d.f.btn_pop_most_left_s);
        this.izB = al.getDrawable(d.f.btn_pop_most_right_s);
        this.izC = al.getDrawable(d.f.ico_downward);
        this.izD = al.getDrawable(d.f.ico_upward);
        this.izR.ck(d.f.btn_add_end, d.f.btn_add);
        this.izS.ck(d.f.btn_add_end, d.f.btn_add);
        al.k(this.izN.iAr, d.f.bg_black_banner_down);
        al.d(this.izN.iAD, d.C0277d.common_color_10243, 1);
        al.k(this.izN.iAq, d.f.bg_black_banner_down);
        al.d(this.izN.iAA, d.C0277d.common_color_10243, 1);
        if (this.izP) {
            al.c(this.izN.iAB, d.f.ico_upward);
        } else {
            al.c(this.izN.iAB, d.f.ico_downward);
        }
        if (this.izQ) {
            al.c(this.izN.iAE, d.f.ico_upward);
        } else {
            al.c(this.izN.iAE, d.f.ico_downward);
        }
        if (this.izN.mViewPager.getCurrentItem() == 0) {
            this.izN.iAx.setTextColor(this.izx);
            this.izN.iAx.setBackgroundDrawable(this.izA);
            this.izN.iAy.setBackgroundDrawable(this.izz);
            this.izN.iAy.setTextColor(this.izw);
            return;
        }
        this.izN.iAy.setTextColor(this.izx);
        this.izN.iAy.setBackgroundDrawable(this.izB);
        this.izN.iAx.setBackgroundDrawable(this.izy);
        this.izN.iAx.setTextColor(this.izw);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.tab_recommends) {
            this.izN.mViewPager.setCurrentItem(0);
            this.izG = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == d.g.tab_hot) {
            this.izN.mViewPager.setCurrentItem(1);
            this.izG = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == d.g.title_menu) {
            this.izN.d(this.izX);
        }
    }

    private View ccI() {
        this.izN.iAv = ccM();
        this.izN.iAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ccJ();
            }
        });
        return this.izN.iAv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccJ() {
        if (this.izP) {
            int min = Math.min(this.izR.getCount(), 200);
            this.izE = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.izR.ccN(), 0, forumInfoDataArr, 0, min);
            this.izR.yp(min);
            this.izR.a(forumInfoDataArr);
            this.izP = false;
            this.izN.iAA.setText(getPageContext().getString(d.j.flist_expand_list));
            this.izN.iAB.setImageDrawable(this.izC);
            return;
        }
        this.izE = 50;
        c cVar = new c();
        cVar.pO(true);
        cVar.execute(new Void[0]);
    }

    private View ccK() {
        this.izN.iAw = ccM();
        this.izN.iAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ccL();
            }
        });
        return this.izN.iAw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccL() {
        if (this.izQ) {
            int min = Math.min(this.izS.getCount(), 200);
            this.izF = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.izS.ccN(), 0, forumInfoDataArr, 0, min);
            this.izS.yp(min);
            this.izS.a(forumInfoDataArr);
            this.izQ = false;
            this.izN.iAD.setText(getPageContext().getString(d.j.flist_expand_list));
            this.izN.iAE.setImageDrawable(this.izC);
            return;
        }
        this.izF = 50;
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
        if (!this.izH) {
            if (i == 0) {
                this.izR.ccO();
                this.izR.notifyDataSetChanged();
                this.izN.iAx.setBackgroundDrawable(this.izA);
                this.izN.iAx.setTextColor(this.izx);
                this.izN.iAy.setBackgroundDrawable(this.izz);
                this.izN.iAy.setTextColor(this.izw);
            } else if (i == 1) {
                this.izS.ccO();
                this.izS.notifyDataSetChanged();
                this.izN.iAy.setBackgroundDrawable(this.izB);
                this.izN.iAy.setTextColor(this.izx);
                this.izN.iAx.setBackgroundDrawable(this.izy);
                this.izN.iAx.setTextColor(this.izw);
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
            return ForumListActivity.this.izH ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.izN.iAv);
                    return ForumListActivity.this.izN.iAv;
                case 1:
                    viewGroup.addView(ForumListActivity.this.izN.iAw);
                    return ForumListActivity.this.izN.iAw;
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
            this.izU.LoadData();
            if (this.izG == 0) {
                ccN = this.izR.ccN();
            } else {
                ccN = this.izS.ccN();
            }
            this.bUt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.bUt.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.bUt.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.bUt.getErrorString());
                        } else if (((r) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.attention_success));
                            if (ForumListActivity.this.izG == 0) {
                                ForumListActivity.this.izR.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ccN[ForumListActivity.this.izR.iAf].forum_name);
                            } else if (ForumListActivity.this.izG == 1) {
                                ForumListActivity.this.izS.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ccN[ForumListActivity.this.izS.iAf].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.izG == 0) {
                this.bUt.dW(ccN[this.izR.iAf].forum_name, String.valueOf(ccN[this.izR.iAf].forum_id));
            } else {
                this.bUt.dW(ccN[this.izS.iAf].forum_name, String.valueOf(ccN[this.izS.iAf].forum_id));
            }
        }
    }
}
