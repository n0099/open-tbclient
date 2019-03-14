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
    public static boolean eYJ = false;
    private static String iAn = "";
    private static String iAo = "";
    private static String iAp = "";
    private static String iAq = "";
    public com.baidu.tieba.square.flist.c iAc;
    private ForumListModel.RequestParams iAd;
    private com.baidu.tieba.square.flist.b iAg;
    private com.baidu.tieba.square.flist.b iAh;
    private DirMenuModel iAi;
    private ForumListDetailModel iAj;
    private int izL;
    private int izM;
    private Drawable izN;
    private Drawable izO;
    private Drawable izP;
    private Drawable izQ;
    private Drawable izR;
    private Drawable izS;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int izT = 200;
    private int izU = 200;
    private int izV = 0;
    private final LikeModel bUq = new LikeModel(getPageContext());
    private boolean izW = false;
    private int menu_choose = 0;
    private boolean izX = false;
    private int izY = 0;
    private int izZ = 200;
    private boolean iAa = true;
    private boolean iAb = true;
    private boolean iAe = false;
    private boolean iAf = false;
    private final ForumListDetailModel.a iAk = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.iAg.ccR() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.iAc.ccX();
                ForumListActivity.this.iAc.ccW();
                if (ForumListActivity.this.iAd.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.iAc.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.iAd.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.iAc.ccW();
                    ForumListActivity.this.iAd.recommend_type = ForumListActivity.this.izY;
                    ForumListActivity.this.iAd.rn = ForumListActivity.this.izZ;
                }
                ForumListActivity.this.iAc.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.iAc.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.izX) {
                    ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.iAc.iAQ.setImageDrawable(ForumListActivity.this.izR);
                    ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.iAc.iAT.setImageDrawable(ForumListActivity.this.izR);
                    ForumListActivity.this.izX = false;
                }
                ForumListActivity.this.iAc.eKt.setText(ForumListActivity.this.iAd.menu_name);
                ForumListActivity.this.iAc.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iAc.iBa.zf(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.iAg.yt(min);
                ForumListActivity.this.iAg.a(ForumListActivity.this.bUq);
                ForumListActivity.this.iAg.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.iAc.iAK.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.iAc.iAF.setVisibility(0);
                } else {
                    ForumListActivity.this.iAc.iAF.setVisibility(8);
                }
                ForumListActivity.this.iAc.iAM.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.iAh.yt(min2);
                ForumListActivity.this.iAh.a(ForumListActivity.this.bUq);
                ForumListActivity.this.iAh.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.iAc.iAL.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.iAc.iAG.setVisibility(0);
                } else {
                    ForumListActivity.this.iAc.iAG.setVisibility(8);
                }
                ForumListActivity.this.iAc.iAN.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(d.g.item_root).setVisibility(0);
                ForumListActivity.this.iAc.ccW();
                if (ForumListActivity.this.iAc.iBa.getCount() > 0) {
                    ForumListActivity.this.iAc.iBb.setClickable(true);
                    ForumListActivity.this.iAc.iBb.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b iAl = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, com.baidu.tieba.square.square.d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.iAc.ccX();
                    return;
                }
                return;
            }
            dVar.iBS.add(0, dVar);
            if (ForumListActivity.this.iAc.iBa != null) {
                ForumListActivity.this.iAc.iBa.a(dVar);
                ForumListActivity.this.Ck(String.valueOf(ForumListActivity.this.iAc.eKt.getText()));
                ForumListActivity.this.iAc.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iAc.iBa.notifyDataSetChanged();
            }
            ForumListActivity.this.iAc.iBb.setClickable(true);
            ForumListActivity.this.iAc.iBb.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener iAm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.iAc.iAW, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.iAc.ccX();
            ForumListActivity.this.iAc.ccY();
            ArrayList<com.baidu.tieba.square.square.d> arrayList = ForumListActivity.this.iAc.iBa.ccK().iBS;
            ForumListActivity.this.ab(arrayList.get(i).izF, arrayList.get(i).izH, arrayList.get(i).izG);
        }
    };
    private final h.c dhq = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (!ForumListActivity.this.iAg.ccT() && !ForumListActivity.this.iAh.ccT()) {
                if (ForumListActivity.this.iAa) {
                    ForumListActivity.this.iAd.recommend_type = 0;
                    ForumListActivity.this.iAd.rn = 200;
                    ForumListActivity.this.iAj.a(ForumListActivity.this.iAd);
                    ForumListActivity.this.iAj.LoadData();
                    ForumListActivity.this.iAa = false;
                } else if (ForumListActivity.this.iAc.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.iAe) {
                        ForumListActivity.this.izT = 50;
                    } else {
                        ForumListActivity.this.izT = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.iAc.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.iAf) {
                        ForumListActivity.this.izU = 50;
                    } else {
                        ForumListActivity.this.izU = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck(String str) {
        com.baidu.tieba.square.square.d ccK = this.iAc.iBa.ccK();
        if (ccK != null) {
            ArrayList<com.baidu.tieba.square.square.d> arrayList = ccK.iBS;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).izF.equals(str)) {
                    this.menu_choose = i;
                    this.iAc.iBa.zf(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.iAd.menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.iAd.menu_name = str;
        this.iAd.menu_type = com.baidu.adp.lib.g.b.l(str3, 0);
        this.iAd.parent_menu_id = com.baidu.adp.lib.g.b.l(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.iAd.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.iAd.offset = 0;
        this.iAd.rn = 10;
        this.izY = this.iAd.recommend_type;
        this.izZ = this.iAd.rn;
        this.iAd.recommend_type = 0;
        this.iAd.rn = 200;
        this.izX = true;
        this.iAj.a(this.iAd);
        this.iAj.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iAt;

        private b() {
            this.iAt = false;
        }

        public void pO(boolean z) {
            this.iAt = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iAc.iAR.setEnabled(false);
            ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iAd.recommend_type = 2;
                ForumListActivity.this.iAd.offset = 0;
                ForumListActivity.this.iAd.rn = ForumListActivity.this.izU;
                return ForumListModel.new_fetch(ForumListActivity.this.iAd);
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
                ForumListActivity.this.iAh.yt(min);
                ForumListActivity.this.iAh.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.izU == 200) {
                    ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.iAc.iAT.setImageDrawable(ForumListActivity.this.izR);
                } else {
                    ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                    ForumListActivity.this.iAc.iAT.setImageDrawable(ForumListActivity.this.izS);
                    ForumListActivity.this.iAf = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.neterror));
                if (!this.iAt) {
                    if (ForumListActivity.this.izU == 200) {
                        ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                        ForumListActivity.this.iAc.iAT.setImageDrawable(ForumListActivity.this.izR);
                    } else {
                        ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                        ForumListActivity.this.iAc.iAT.setImageDrawable(ForumListActivity.this.izS);
                    }
                } else {
                    ForumListActivity.this.iAc.iAS.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.iAc.iAT.setImageDrawable(ForumListActivity.this.izR);
                    ForumListActivity.this.iAd.rn = 200;
                    ForumListActivity.this.izU = 200;
                }
            }
            ForumListActivity.this.iAc.iAR.setEnabled(true);
            ForumListActivity.this.iAc.ccW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iAt;

        private c() {
            this.iAt = false;
        }

        public void pO(boolean z) {
            this.iAt = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iAc.iAO.setEnabled(false);
            ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iAd.recommend_type = 1;
                ForumListActivity.this.iAd.offset = 0;
                ForumListActivity.this.iAd.rn = ForumListActivity.this.izT;
                return ForumListModel.new_fetch(ForumListActivity.this.iAd);
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
                ForumListActivity.this.iAg.yt(min);
                ForumListActivity.this.iAg.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.izT == 200) {
                    ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.iAc.iAQ.setImageDrawable(ForumListActivity.this.izR);
                } else {
                    ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                    ForumListActivity.this.iAc.iAQ.setImageDrawable(ForumListActivity.this.izS);
                    ForumListActivity.this.iAe = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.neterror));
                if (!this.iAt) {
                    if (ForumListActivity.this.izT == 200) {
                        ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                        ForumListActivity.this.iAc.iAQ.setImageDrawable(ForumListActivity.this.izR);
                    } else {
                        ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_collapse_list));
                        ForumListActivity.this.iAc.iAQ.setImageDrawable(ForumListActivity.this.izS);
                    }
                } else {
                    ForumListActivity.this.iAc.iAP.setText(ForumListActivity.this.getPageContext().getString(d.j.flist_expand_list));
                    ForumListActivity.this.iAc.iAQ.setImageDrawable(ForumListActivity.this.izR);
                    ForumListActivity.this.iAd.rn = 200;
                    ForumListActivity.this.izT = 200;
                }
            }
            ForumListActivity.this.iAc.iAO.setEnabled(true);
            ForumListActivity.this.iAc.ccW();
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
        this.iAc = new com.baidu.tieba.square.flist.c(this);
        this.iAc.iAK = (BdListView) ccM();
        this.iAc.iAL = (BdListView) ccO();
        this.iAc.mProgressBar.setVisibility(0);
        this.iAc.iBb.setOnClickListener(null);
        this.iAc.iBb.setClickable(false);
        this.iAc.mViewPager.setAdapter(new a());
        this.iAc.iAK.setPullRefresh(this.iAc.iAU);
        this.iAc.iAL.setPullRefresh(this.iAc.iAV);
        if (com.baidu.adp.lib.g.b.l(stringExtra3, 0) != 0) {
            h = l.h(getActivity(), d.e.ds98);
        } else {
            h = l.h(getActivity(), d.e.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + h));
        this.iAc.iAK.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, h + UtilHelper.getLightStatusBarHeight()));
        this.iAc.iAL.addHeaderView(textView2, 0);
        this.iAg = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.iAc.iAK.setAdapter((ListAdapter) this.iAg);
        this.iAh = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.iAc.iAL.setAdapter((ListAdapter) this.iAh);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (ap.isEmpty(str4)) {
            str4 = str;
        }
        this.iAc.eKt.setText(str4);
        this.iAc.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iAd = new ForumListModel.RequestParams();
        this.iAd.menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.iAd.menu_name = str4;
        this.iAd.menu_type = com.baidu.adp.lib.g.b.l(str3, 0);
        this.iAd.parent_menu_id = com.baidu.adp.lib.g.b.l(str2, 0);
        this.iAd.parent_menu_name = str;
        this.iAd.offset = 0;
        this.iAd.rn = 10;
        if (this.iAd.menu_id != 0) {
            this.iAc.ccV();
            this.izW = true;
            this.iAb = false;
            this.iAg.i(Boolean.valueOf(this.iAb));
            this.iAc.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.iAb = true;
            this.iAg.i(Boolean.valueOf(this.iAb));
            this.iAc.ccU();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.iAc.iAU.setListPullRefreshListener(this.dhq);
        this.iAc.iAV.setListPullRefreshListener(this.dhq);
        this.iAg.notifyDataSetChanged();
        this.iAh.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.iAc.ccX();
        } else {
            this.iAi = new DirMenuModel(getPageContext(), str, str3, str2);
            this.iAi.a(this.iAl);
            this.iAi.LoadData();
        }
        this.iAj = new ForumListDetailModel(getPageContext(), this.iAd);
        this.iAj.a(this.iAk);
        this.iAc.iAK.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (eYJ) {
            eYJ = false;
            finish();
            b(getPageContext().getPageActivity(), iAn, iAp, iAo, iAq);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.iAg != null) {
                this.iAg.ccS();
                this.iAg.notifyDataSetChanged();
            }
            if (this.iAh != null) {
                this.iAh.ccS();
                this.iAh.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.bUq != null) {
            this.bUq.cdI();
        }
        this.iAc.mViewPager.setAdapter(null);
        this.iAc.iAL.setAdapter((ListAdapter) null);
        this.iAc.iAK.setAdapter((ListAdapter) null);
        if (this.iAc.iAZ != null) {
            this.iAc.iAZ.setAdapter((ListAdapter) null);
        }
        if (this.iAi != null) {
            this.iAi.cancelLoadData();
        }
        if (this.iAj != null) {
            this.iAj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iAc.eIH);
        this.iAc.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iAg.pP(true);
            this.iAh.pP(true);
        } else {
            this.iAg.pP(false);
            this.iAh.pP(false);
        }
        this.iAg.notifyDataSetChanged();
        this.iAh.notifyDataSetChanged();
        if (this.iAc.iAW != null) {
            this.iAc.iAW.setBackgroundDrawable(al.getDrawable(d.f.bg_allsproutpop_dropdown));
        }
        al.k(this.iAc.iAH, d.f.bg_pop_most);
        this.izL = al.getColor(d.C0277d.common_color_10243);
        this.izM = al.getColor(d.C0277d.cp_btn_a);
        this.izN = al.getDrawable(d.f.btn_pop_most_left_n);
        this.izO = al.getDrawable(d.f.btn_pop_most_right_n);
        this.izP = al.getDrawable(d.f.btn_pop_most_left_s);
        this.izQ = al.getDrawable(d.f.btn_pop_most_right_s);
        this.izR = al.getDrawable(d.f.ico_downward);
        this.izS = al.getDrawable(d.f.ico_upward);
        this.iAg.ck(d.f.btn_add_end, d.f.btn_add);
        this.iAh.ck(d.f.btn_add_end, d.f.btn_add);
        al.k(this.iAc.iAG, d.f.bg_black_banner_down);
        al.d(this.iAc.iAS, d.C0277d.common_color_10243, 1);
        al.k(this.iAc.iAF, d.f.bg_black_banner_down);
        al.d(this.iAc.iAP, d.C0277d.common_color_10243, 1);
        if (this.iAe) {
            al.c(this.iAc.iAQ, d.f.ico_upward);
        } else {
            al.c(this.iAc.iAQ, d.f.ico_downward);
        }
        if (this.iAf) {
            al.c(this.iAc.iAT, d.f.ico_upward);
        } else {
            al.c(this.iAc.iAT, d.f.ico_downward);
        }
        if (this.iAc.mViewPager.getCurrentItem() == 0) {
            this.iAc.iAM.setTextColor(this.izM);
            this.iAc.iAM.setBackgroundDrawable(this.izP);
            this.iAc.iAN.setBackgroundDrawable(this.izO);
            this.iAc.iAN.setTextColor(this.izL);
            return;
        }
        this.iAc.iAN.setTextColor(this.izM);
        this.iAc.iAN.setBackgroundDrawable(this.izQ);
        this.iAc.iAM.setBackgroundDrawable(this.izN);
        this.iAc.iAM.setTextColor(this.izL);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.tab_recommends) {
            this.iAc.mViewPager.setCurrentItem(0);
            this.izV = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == d.g.tab_hot) {
            this.iAc.mViewPager.setCurrentItem(1);
            this.izV = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == d.g.title_menu) {
            this.iAc.d(this.iAm);
        }
    }

    private View ccM() {
        this.iAc.iAK = ccQ();
        this.iAc.iAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ccN();
            }
        });
        return this.iAc.iAK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccN() {
        if (this.iAe) {
            int min = Math.min(this.iAg.getCount(), 200);
            this.izT = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iAg.ccR(), 0, forumInfoDataArr, 0, min);
            this.iAg.yt(min);
            this.iAg.a(forumInfoDataArr);
            this.iAe = false;
            this.iAc.iAP.setText(getPageContext().getString(d.j.flist_expand_list));
            this.iAc.iAQ.setImageDrawable(this.izR);
            return;
        }
        this.izT = 50;
        c cVar = new c();
        cVar.pO(true);
        cVar.execute(new Void[0]);
    }

    private View ccO() {
        this.iAc.iAL = ccQ();
        this.iAc.iAR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ccP();
            }
        });
        return this.iAc.iAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccP() {
        if (this.iAf) {
            int min = Math.min(this.iAh.getCount(), 200);
            this.izU = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iAh.ccR(), 0, forumInfoDataArr, 0, min);
            this.iAh.yt(min);
            this.iAh.a(forumInfoDataArr);
            this.iAf = false;
            this.iAc.iAS.setText(getPageContext().getString(d.j.flist_expand_list));
            this.iAc.iAT.setImageDrawable(this.izR);
            return;
        }
        this.izU = 50;
        b bVar = new b();
        bVar.pO(true);
        bVar.execute(new Void[0]);
    }

    private BdListView ccQ() {
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
        if (!this.izW) {
            if (i == 0) {
                this.iAg.ccS();
                this.iAg.notifyDataSetChanged();
                this.iAc.iAM.setBackgroundDrawable(this.izP);
                this.iAc.iAM.setTextColor(this.izM);
                this.iAc.iAN.setBackgroundDrawable(this.izO);
                this.iAc.iAN.setTextColor(this.izL);
            } else if (i == 1) {
                this.iAh.ccS();
                this.iAh.notifyDataSetChanged();
                this.iAc.iAN.setBackgroundDrawable(this.izQ);
                this.iAc.iAN.setTextColor(this.izM);
                this.iAc.iAM.setBackgroundDrawable(this.izN);
                this.iAc.iAM.setTextColor(this.izL);
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
            return ForumListActivity.this.izW ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.iAc.iAK);
                    return ForumListActivity.this.iAc.iAK;
                case 1:
                    viewGroup.addView(ForumListActivity.this.iAc.iAL);
                    return ForumListActivity.this.iAc.iAL;
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
        final ForumInfoData[] ccR;
        if (i == 11002 && i2 == -1) {
            this.iAj.LoadData();
            if (this.izV == 0) {
                ccR = this.iAg.ccR();
            } else {
                ccR = this.iAh.ccR();
            }
            this.bUq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.bUq.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.bUq.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.bUq.getErrorString());
                        } else if (((r) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(d.j.attention_success));
                            if (ForumListActivity.this.izV == 0) {
                                ForumListActivity.this.iAg.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ccR[ForumListActivity.this.iAg.iAu].forum_name);
                            } else if (ForumListActivity.this.izV == 1) {
                                ForumListActivity.this.iAh.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ccR[ForumListActivity.this.iAh.iAu].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.izV == 0) {
                this.bUq.dV(ccR[this.iAg.iAu].forum_name, String.valueOf(ccR[this.iAg.iAu].forum_id));
            } else {
                this.bUq.dV(ccR[this.iAh.iAu].forum_name, String.valueOf(ccR[this.iAh.iAu].forum_id));
            }
        }
    }
}
