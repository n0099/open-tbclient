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
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean foG = false;
    private static String iSM = "";
    private static String iSN = "";
    private static String iSO = "";
    private static String iSP = "";
    public com.baidu.tieba.square.flist.c iSB;
    private ForumListModel.RequestParams iSC;
    private com.baidu.tieba.square.flist.b iSF;
    private com.baidu.tieba.square.flist.b iSG;
    private DirMenuModel iSH;
    private ForumListDetailModel iSI;
    private int iSj;
    private int iSk;
    private Drawable iSl;
    private Drawable iSm;
    private Drawable iSn;
    private Drawable iSo;
    private Drawable iSp;
    private Drawable iSq;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int iSr = 200;
    private int iSs = 200;
    private int iSt = 0;
    private final LikeModel ccn = new LikeModel(getPageContext());
    private boolean iSu = false;
    private int iSv = 0;
    private boolean iSw = false;
    private int iSx = 0;
    private int iSy = 200;
    private boolean iSz = true;
    private boolean iSA = true;
    private boolean iSD = false;
    private boolean iSE = false;
    private final ForumListDetailModel.a iSJ = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.iSF.ckR() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.iSB.ckX();
                ForumListActivity.this.iSB.ckW();
                if (ForumListActivity.this.iSC.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.iSB.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.iSC.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.iSB.ckW();
                    ForumListActivity.this.iSC.recommend_type = ForumListActivity.this.iSx;
                    ForumListActivity.this.iSC.rn = ForumListActivity.this.iSy;
                }
                ForumListActivity.this.iSB.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.iSB.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.iSw) {
                    ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSB.iTp.setImageDrawable(ForumListActivity.this.iSp);
                    ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSB.iTs.setImageDrawable(ForumListActivity.this.iSp);
                    ForumListActivity.this.iSw = false;
                }
                ForumListActivity.this.iSB.fap.setText(ForumListActivity.this.iSC.menu_name);
                ForumListActivity.this.iSB.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iSB.iTz.Aj(ForumListActivity.this.iSv);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.iSF.zw(min);
                ForumListActivity.this.iSF.a(ForumListActivity.this.ccn);
                ForumListActivity.this.iSF.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.iSB.iTj.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.iSB.iTe.setVisibility(0);
                } else {
                    ForumListActivity.this.iSB.iTe.setVisibility(8);
                }
                ForumListActivity.this.iSB.iTl.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.iSG.zw(min2);
                ForumListActivity.this.iSG.a(ForumListActivity.this.ccn);
                ForumListActivity.this.iSG.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.iSB.iTk.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.iSB.iTf.setVisibility(0);
                } else {
                    ForumListActivity.this.iSB.iTf.setVisibility(8);
                }
                ForumListActivity.this.iSB.iTm.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.iSB.ckW();
                if (ForumListActivity.this.iSB.iTz.getCount() > 0) {
                    ForumListActivity.this.iSB.iTA.setClickable(true);
                    ForumListActivity.this.iSB.iTA.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b iSK = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.iSB.ckX();
                    return;
                }
                return;
            }
            dVar.iUr.add(0, dVar);
            if (ForumListActivity.this.iSB.iTz != null) {
                ForumListActivity.this.iSB.iTz.a(dVar);
                ForumListActivity.this.DF(String.valueOf(ForumListActivity.this.iSB.fap.getText()));
                ForumListActivity.this.iSB.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iSB.iTz.notifyDataSetChanged();
            }
            ForumListActivity.this.iSB.iTA.setClickable(true);
            ForumListActivity.this.iSB.iTA.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener iSL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.iSB.iTv, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.iSv = i;
            ForumListActivity.this.iSB.ckX();
            ForumListActivity.this.iSB.ckY();
            ArrayList<d> arrayList = ForumListActivity.this.iSB.iTz.ckK().iUr;
            ForumListActivity.this.ab(arrayList.get(i).iSd, arrayList.get(i).iSf, arrayList.get(i).iSe);
        }
    };
    private final h.c drX = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (!ForumListActivity.this.iSF.ckT() && !ForumListActivity.this.iSG.ckT()) {
                if (ForumListActivity.this.iSz) {
                    ForumListActivity.this.iSC.recommend_type = 0;
                    ForumListActivity.this.iSC.rn = 200;
                    ForumListActivity.this.iSI.a(ForumListActivity.this.iSC);
                    ForumListActivity.this.iSI.LoadData();
                    ForumListActivity.this.iSz = false;
                } else if (ForumListActivity.this.iSB.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.iSD) {
                        ForumListActivity.this.iSr = 50;
                    } else {
                        ForumListActivity.this.iSr = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.iSB.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.iSE) {
                        ForumListActivity.this.iSs = 50;
                    } else {
                        ForumListActivity.this.iSs = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(String str) {
        d ckK = this.iSB.iTz.ckK();
        if (ckK != null) {
            ArrayList<d> arrayList = ckK.iUr;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).iSd.equals(str)) {
                    this.iSv = i;
                    this.iSB.iTz.Aj(this.iSv);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.iSC.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSC.menu_name = str;
        this.iSC.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iSC.parent_menu_id = com.baidu.adp.lib.g.b.f(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.iSC.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.iSC.offset = 0;
        this.iSC.rn = 10;
        this.iSx = this.iSC.recommend_type;
        this.iSy = this.iSC.rn;
        this.iSC.recommend_type = 0;
        this.iSC.rn = 200;
        this.iSw = true;
        this.iSI.a(this.iSC);
        this.iSI.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iSS;

        private b() {
            this.iSS = false;
        }

        public void qD(boolean z) {
            this.iSS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iSB.iTq.setEnabled(false);
            ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iSC.recommend_type = 2;
                ForumListActivity.this.iSC.offset = 0;
                ForumListActivity.this.iSC.rn = ForumListActivity.this.iSs;
                return ForumListModel.new_fetch(ForumListActivity.this.iSC);
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
                ForumListActivity.this.iSG.zw(min);
                ForumListActivity.this.iSG.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.iSs == 200) {
                    ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSB.iTs.setImageDrawable(ForumListActivity.this.iSp);
                } else {
                    ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iSB.iTs.setImageDrawable(ForumListActivity.this.iSq);
                    ForumListActivity.this.iSE = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iSS) {
                    if (ForumListActivity.this.iSs == 200) {
                        ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iSB.iTs.setImageDrawable(ForumListActivity.this.iSp);
                    } else {
                        ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iSB.iTs.setImageDrawable(ForumListActivity.this.iSq);
                    }
                } else {
                    ForumListActivity.this.iSB.iTr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSB.iTs.setImageDrawable(ForumListActivity.this.iSp);
                    ForumListActivity.this.iSC.rn = 200;
                    ForumListActivity.this.iSs = 200;
                }
            }
            ForumListActivity.this.iSB.iTq.setEnabled(true);
            ForumListActivity.this.iSB.ckW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iSS;

        private c() {
            this.iSS = false;
        }

        public void qD(boolean z) {
            this.iSS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iSB.iTn.setEnabled(false);
            ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iSC.recommend_type = 1;
                ForumListActivity.this.iSC.offset = 0;
                ForumListActivity.this.iSC.rn = ForumListActivity.this.iSr;
                return ForumListModel.new_fetch(ForumListActivity.this.iSC);
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
                ForumListActivity.this.iSF.zw(min);
                ForumListActivity.this.iSF.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.iSr == 200) {
                    ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSB.iTp.setImageDrawable(ForumListActivity.this.iSp);
                } else {
                    ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iSB.iTp.setImageDrawable(ForumListActivity.this.iSq);
                    ForumListActivity.this.iSD = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iSS) {
                    if (ForumListActivity.this.iSr == 200) {
                        ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iSB.iTp.setImageDrawable(ForumListActivity.this.iSp);
                    } else {
                        ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iSB.iTp.setImageDrawable(ForumListActivity.this.iSq);
                    }
                } else {
                    ForumListActivity.this.iSB.iTo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSB.iTp.setImageDrawable(ForumListActivity.this.iSp);
                    ForumListActivity.this.iSC.rn = 200;
                    ForumListActivity.this.iSr = 200;
                }
            }
            ForumListActivity.this.iSB.iTn.setEnabled(true);
            ForumListActivity.this.iSB.ckW();
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
        int g;
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
        String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
        this.iSB = new com.baidu.tieba.square.flist.c(this);
        this.iSB.iTj = (BdListView) ckM();
        this.iSB.iTk = (BdListView) ckO();
        this.iSB.mProgressBar.setVisibility(0);
        this.iSB.iTA.setOnClickListener(null);
        this.iSB.iTA.setClickable(false);
        this.iSB.mViewPager.setAdapter(new a());
        this.iSB.iTj.setPullRefresh(this.iSB.iTt);
        this.iSB.iTk.setPullRefresh(this.iSB.iTu);
        if (com.baidu.adp.lib.g.b.f(stringExtra3, 0) != 0) {
            g = l.g(getActivity(), R.dimen.ds98);
        } else {
            g = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g));
        this.iSB.iTj.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, g + UtilHelper.getLightStatusBarHeight()));
        this.iSB.iTk.addHeaderView(textView2, 0);
        this.iSF = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.iSB.iTj.setAdapter((ListAdapter) this.iSF);
        this.iSG = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.iSB.iTk.setAdapter((ListAdapter) this.iSG);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (ap.isEmpty(str4)) {
            str4 = str;
        }
        this.iSB.fap.setText(str4);
        this.iSB.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iSC = new ForumListModel.RequestParams();
        this.iSC.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSC.menu_name = str4;
        this.iSC.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iSC.parent_menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSC.parent_menu_name = str;
        this.iSC.offset = 0;
        this.iSC.rn = 10;
        if (this.iSC.menu_id != 0) {
            this.iSB.ckV();
            this.iSu = true;
            this.iSA = false;
            this.iSF.i(Boolean.valueOf(this.iSA));
            this.iSB.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.iSA = true;
            this.iSF.i(Boolean.valueOf(this.iSA));
            this.iSB.ckU();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.iSB.iTt.setListPullRefreshListener(this.drX);
        this.iSB.iTu.setListPullRefreshListener(this.drX);
        this.iSF.notifyDataSetChanged();
        this.iSG.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.iSB.ckX();
        } else {
            this.iSH = new DirMenuModel(getPageContext(), str, str3, str2);
            this.iSH.a(this.iSK);
            this.iSH.LoadData();
        }
        this.iSI = new ForumListDetailModel(getPageContext(), this.iSC);
        this.iSI.a(this.iSJ);
        this.iSB.iTj.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (foG) {
            foG = false;
            finish();
            b(getPageContext().getPageActivity(), iSM, iSO, iSN, iSP);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.iSF != null) {
                this.iSF.ckS();
                this.iSF.notifyDataSetChanged();
            }
            if (this.iSG != null) {
                this.iSG.ckS();
                this.iSG.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.ccn != null) {
            this.ccn.clJ();
        }
        this.iSB.mViewPager.setAdapter(null);
        this.iSB.iTk.setAdapter((ListAdapter) null);
        this.iSB.iTj.setAdapter((ListAdapter) null);
        if (this.iSB.iTy != null) {
            this.iSB.iTy.setAdapter((ListAdapter) null);
        }
        if (this.iSH != null) {
            this.iSH.cancelLoadData();
        }
        if (this.iSI != null) {
            this.iSI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iSB.eYD);
        this.iSB.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iSF.qE(true);
            this.iSG.qE(true);
        } else {
            this.iSF.qE(false);
            this.iSG.qE(false);
        }
        this.iSF.notifyDataSetChanged();
        this.iSG.notifyDataSetChanged();
        if (this.iSB.iTv != null) {
            this.iSB.iTv.setBackgroundDrawable(al.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        al.k(this.iSB.iTg, R.drawable.bg_pop_most);
        this.iSj = al.getColor(R.color.common_color_10243);
        this.iSk = al.getColor(R.color.cp_btn_a);
        this.iSl = al.getDrawable(R.drawable.btn_pop_most_left_n);
        this.iSm = al.getDrawable(R.drawable.btn_pop_most_right_n);
        this.iSn = al.getDrawable(R.drawable.btn_pop_most_left_s);
        this.iSo = al.getDrawable(R.drawable.btn_pop_most_right_s);
        this.iSp = al.getDrawable(R.drawable.ico_downward);
        this.iSq = al.getDrawable(R.drawable.ico_upward);
        this.iSF.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        this.iSG.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        al.k(this.iSB.iTf, R.drawable.bg_black_banner_down);
        al.f(this.iSB.iTr, R.color.common_color_10243, 1);
        al.k(this.iSB.iTe, R.drawable.bg_black_banner_down);
        al.f(this.iSB.iTo, R.color.common_color_10243, 1);
        if (this.iSD) {
            al.c(this.iSB.iTp, (int) R.drawable.ico_upward);
        } else {
            al.c(this.iSB.iTp, (int) R.drawable.ico_downward);
        }
        if (this.iSE) {
            al.c(this.iSB.iTs, (int) R.drawable.ico_upward);
        } else {
            al.c(this.iSB.iTs, (int) R.drawable.ico_downward);
        }
        if (this.iSB.mViewPager.getCurrentItem() == 0) {
            this.iSB.iTl.setTextColor(this.iSk);
            this.iSB.iTl.setBackgroundDrawable(this.iSn);
            this.iSB.iTm.setBackgroundDrawable(this.iSm);
            this.iSB.iTm.setTextColor(this.iSj);
            return;
        }
        this.iSB.iTm.setTextColor(this.iSk);
        this.iSB.iTm.setBackgroundDrawable(this.iSo);
        this.iSB.iTl.setBackgroundDrawable(this.iSl);
        this.iSB.iTl.setTextColor(this.iSj);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.iSB.mViewPager.setCurrentItem(0);
            this.iSt = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.iSB.mViewPager.setCurrentItem(1);
            this.iSt = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.iSB.d(this.iSL);
        }
    }

    private View ckM() {
        this.iSB.iTj = ckQ();
        this.iSB.iTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ckN();
            }
        });
        return this.iSB.iTj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckN() {
        if (this.iSD) {
            int min = Math.min(this.iSF.getCount(), 200);
            this.iSr = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iSF.ckR(), 0, forumInfoDataArr, 0, min);
            this.iSF.zw(min);
            this.iSF.a(forumInfoDataArr);
            this.iSD = false;
            this.iSB.iTo.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iSB.iTp.setImageDrawable(this.iSp);
            return;
        }
        this.iSr = 50;
        c cVar = new c();
        cVar.qD(true);
        cVar.execute(new Void[0]);
    }

    private View ckO() {
        this.iSB.iTk = ckQ();
        this.iSB.iTq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ckP();
            }
        });
        return this.iSB.iTk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckP() {
        if (this.iSE) {
            int min = Math.min(this.iSG.getCount(), 200);
            this.iSs = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iSG.ckR(), 0, forumInfoDataArr, 0, min);
            this.iSG.zw(min);
            this.iSG.a(forumInfoDataArr);
            this.iSE = false;
            this.iSB.iTr.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iSB.iTs.setImageDrawable(this.iSp);
            return;
        }
        this.iSs = 50;
        b bVar = new b();
        bVar.qD(true);
        bVar.execute(new Void[0]);
    }

    private BdListView ckQ() {
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
        if (!this.iSu) {
            if (i == 0) {
                this.iSF.ckS();
                this.iSF.notifyDataSetChanged();
                this.iSB.iTl.setBackgroundDrawable(this.iSn);
                this.iSB.iTl.setTextColor(this.iSk);
                this.iSB.iTm.setBackgroundDrawable(this.iSm);
                this.iSB.iTm.setTextColor(this.iSj);
            } else if (i == 1) {
                this.iSG.ckS();
                this.iSG.notifyDataSetChanged();
                this.iSB.iTm.setBackgroundDrawable(this.iSo);
                this.iSB.iTm.setTextColor(this.iSk);
                this.iSB.iTl.setBackgroundDrawable(this.iSl);
                this.iSB.iTl.setTextColor(this.iSj);
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
            return ForumListActivity.this.iSu ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.iSB.iTj);
                    return ForumListActivity.this.iSB.iTj;
                case 1:
                    viewGroup.addView(ForumListActivity.this.iSB.iTk);
                    return ForumListActivity.this.iSB.iTk;
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
        final ForumInfoData[] ckR;
        if (i == 11002 && i2 == -1) {
            this.iSI.LoadData();
            if (this.iSt == 0) {
                ckR = this.iSF.ckR();
            } else {
                ckR = this.iSG.ckR();
            }
            this.ccn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.ccn.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.ccn.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.ccn.getErrorString());
                        } else if (((r) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.iSt == 0) {
                                ForumListActivity.this.iSF.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ckR[ForumListActivity.this.iSF.iST].forum_name);
                            } else if (ForumListActivity.this.iSt == 1) {
                                ForumListActivity.this.iSG.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ckR[ForumListActivity.this.iSG.iST].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.iSt == 0) {
                this.ccn.ek(ckR[this.iSF.iST].forum_name, String.valueOf(ckR[this.iSF.iST].forum_id));
            } else {
                this.ccn.ek(ckR[this.iSG.iST].forum_name, String.valueOf(ckR[this.iSG.iST].forum_id));
            }
        }
    }
}
