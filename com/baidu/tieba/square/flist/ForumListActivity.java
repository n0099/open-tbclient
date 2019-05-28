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
    public static boolean foH = false;
    private static String iSO = "";
    private static String iSP = "";
    private static String iSQ = "";
    private static String iSR = "";
    public com.baidu.tieba.square.flist.c iSD;
    private ForumListModel.RequestParams iSE;
    private com.baidu.tieba.square.flist.b iSH;
    private com.baidu.tieba.square.flist.b iSI;
    private DirMenuModel iSJ;
    private ForumListDetailModel iSK;
    private int iSl;
    private int iSm;
    private Drawable iSn;
    private Drawable iSo;
    private Drawable iSp;
    private Drawable iSq;
    private Drawable iSr;
    private Drawable iSs;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int iSt = 200;
    private int iSu = 200;
    private int iSv = 0;
    private final LikeModel ccn = new LikeModel(getPageContext());
    private boolean iSw = false;
    private int iSx = 0;
    private boolean iSy = false;
    private int iSz = 0;
    private int iSA = 200;
    private boolean iSB = true;
    private boolean iSC = true;
    private boolean iSF = false;
    private boolean iSG = false;
    private final ForumListDetailModel.a iSL = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.iSH.ckT() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.iSD.ckZ();
                ForumListActivity.this.iSD.ckY();
                if (ForumListActivity.this.iSE.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.iSD.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.iSE.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.iSD.ckY();
                    ForumListActivity.this.iSE.recommend_type = ForumListActivity.this.iSz;
                    ForumListActivity.this.iSE.rn = ForumListActivity.this.iSA;
                }
                ForumListActivity.this.iSD.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.iSD.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.iSy) {
                    ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSD.iTr.setImageDrawable(ForumListActivity.this.iSr);
                    ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSD.iTu.setImageDrawable(ForumListActivity.this.iSr);
                    ForumListActivity.this.iSy = false;
                }
                ForumListActivity.this.iSD.faq.setText(ForumListActivity.this.iSE.menu_name);
                ForumListActivity.this.iSD.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iSD.iTB.Aj(ForumListActivity.this.iSx);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.iSH.zw(min);
                ForumListActivity.this.iSH.a(ForumListActivity.this.ccn);
                ForumListActivity.this.iSH.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.iSD.iTl.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.iSD.iTg.setVisibility(0);
                } else {
                    ForumListActivity.this.iSD.iTg.setVisibility(8);
                }
                ForumListActivity.this.iSD.iTn.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.iSI.zw(min2);
                ForumListActivity.this.iSI.a(ForumListActivity.this.ccn);
                ForumListActivity.this.iSI.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.iSD.iTm.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.iSD.iTh.setVisibility(0);
                } else {
                    ForumListActivity.this.iSD.iTh.setVisibility(8);
                }
                ForumListActivity.this.iSD.iTo.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.iSD.ckY();
                if (ForumListActivity.this.iSD.iTB.getCount() > 0) {
                    ForumListActivity.this.iSD.iTC.setClickable(true);
                    ForumListActivity.this.iSD.iTC.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b iSM = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.iSD.ckZ();
                    return;
                }
                return;
            }
            dVar.iUt.add(0, dVar);
            if (ForumListActivity.this.iSD.iTB != null) {
                ForumListActivity.this.iSD.iTB.a(dVar);
                ForumListActivity.this.DF(String.valueOf(ForumListActivity.this.iSD.faq.getText()));
                ForumListActivity.this.iSD.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iSD.iTB.notifyDataSetChanged();
            }
            ForumListActivity.this.iSD.iTC.setClickable(true);
            ForumListActivity.this.iSD.iTC.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener iSN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.iSD.iTx, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.iSx = i;
            ForumListActivity.this.iSD.ckZ();
            ForumListActivity.this.iSD.cla();
            ArrayList<d> arrayList = ForumListActivity.this.iSD.iTB.ckM().iUt;
            ForumListActivity.this.ab(arrayList.get(i).iSf, arrayList.get(i).iSh, arrayList.get(i).iSg);
        }
    };
    private final h.c drY = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (!ForumListActivity.this.iSH.ckV() && !ForumListActivity.this.iSI.ckV()) {
                if (ForumListActivity.this.iSB) {
                    ForumListActivity.this.iSE.recommend_type = 0;
                    ForumListActivity.this.iSE.rn = 200;
                    ForumListActivity.this.iSK.a(ForumListActivity.this.iSE);
                    ForumListActivity.this.iSK.LoadData();
                    ForumListActivity.this.iSB = false;
                } else if (ForumListActivity.this.iSD.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.iSF) {
                        ForumListActivity.this.iSt = 50;
                    } else {
                        ForumListActivity.this.iSt = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.iSD.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.iSG) {
                        ForumListActivity.this.iSu = 50;
                    } else {
                        ForumListActivity.this.iSu = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(String str) {
        d ckM = this.iSD.iTB.ckM();
        if (ckM != null) {
            ArrayList<d> arrayList = ckM.iUt;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).iSf.equals(str)) {
                    this.iSx = i;
                    this.iSD.iTB.Aj(this.iSx);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.iSE.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSE.menu_name = str;
        this.iSE.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iSE.parent_menu_id = com.baidu.adp.lib.g.b.f(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.iSE.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.iSE.offset = 0;
        this.iSE.rn = 10;
        this.iSz = this.iSE.recommend_type;
        this.iSA = this.iSE.rn;
        this.iSE.recommend_type = 0;
        this.iSE.rn = 200;
        this.iSy = true;
        this.iSK.a(this.iSE);
        this.iSK.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iSU;

        private b() {
            this.iSU = false;
        }

        public void qD(boolean z) {
            this.iSU = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iSD.iTs.setEnabled(false);
            ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iSE.recommend_type = 2;
                ForumListActivity.this.iSE.offset = 0;
                ForumListActivity.this.iSE.rn = ForumListActivity.this.iSu;
                return ForumListModel.new_fetch(ForumListActivity.this.iSE);
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
                ForumListActivity.this.iSI.zw(min);
                ForumListActivity.this.iSI.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.iSu == 200) {
                    ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSD.iTu.setImageDrawable(ForumListActivity.this.iSr);
                } else {
                    ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iSD.iTu.setImageDrawable(ForumListActivity.this.iSs);
                    ForumListActivity.this.iSG = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iSU) {
                    if (ForumListActivity.this.iSu == 200) {
                        ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iSD.iTu.setImageDrawable(ForumListActivity.this.iSr);
                    } else {
                        ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iSD.iTu.setImageDrawable(ForumListActivity.this.iSs);
                    }
                } else {
                    ForumListActivity.this.iSD.iTt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSD.iTu.setImageDrawable(ForumListActivity.this.iSr);
                    ForumListActivity.this.iSE.rn = 200;
                    ForumListActivity.this.iSu = 200;
                }
            }
            ForumListActivity.this.iSD.iTs.setEnabled(true);
            ForumListActivity.this.iSD.ckY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iSU;

        private c() {
            this.iSU = false;
        }

        public void qD(boolean z) {
            this.iSU = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iSD.iTp.setEnabled(false);
            ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iSE.recommend_type = 1;
                ForumListActivity.this.iSE.offset = 0;
                ForumListActivity.this.iSE.rn = ForumListActivity.this.iSt;
                return ForumListModel.new_fetch(ForumListActivity.this.iSE);
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
                ForumListActivity.this.iSH.zw(min);
                ForumListActivity.this.iSH.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.iSt == 200) {
                    ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSD.iTr.setImageDrawable(ForumListActivity.this.iSr);
                } else {
                    ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iSD.iTr.setImageDrawable(ForumListActivity.this.iSs);
                    ForumListActivity.this.iSF = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iSU) {
                    if (ForumListActivity.this.iSt == 200) {
                        ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iSD.iTr.setImageDrawable(ForumListActivity.this.iSr);
                    } else {
                        ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iSD.iTr.setImageDrawable(ForumListActivity.this.iSs);
                    }
                } else {
                    ForumListActivity.this.iSD.iTq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSD.iTr.setImageDrawable(ForumListActivity.this.iSr);
                    ForumListActivity.this.iSE.rn = 200;
                    ForumListActivity.this.iSt = 200;
                }
            }
            ForumListActivity.this.iSD.iTp.setEnabled(true);
            ForumListActivity.this.iSD.ckY();
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
        this.iSD = new com.baidu.tieba.square.flist.c(this);
        this.iSD.iTl = (BdListView) ckO();
        this.iSD.iTm = (BdListView) ckQ();
        this.iSD.mProgressBar.setVisibility(0);
        this.iSD.iTC.setOnClickListener(null);
        this.iSD.iTC.setClickable(false);
        this.iSD.mViewPager.setAdapter(new a());
        this.iSD.iTl.setPullRefresh(this.iSD.iTv);
        this.iSD.iTm.setPullRefresh(this.iSD.iTw);
        if (com.baidu.adp.lib.g.b.f(stringExtra3, 0) != 0) {
            g = l.g(getActivity(), R.dimen.ds98);
        } else {
            g = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g));
        this.iSD.iTl.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, g + UtilHelper.getLightStatusBarHeight()));
        this.iSD.iTm.addHeaderView(textView2, 0);
        this.iSH = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.iSD.iTl.setAdapter((ListAdapter) this.iSH);
        this.iSI = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.iSD.iTm.setAdapter((ListAdapter) this.iSI);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (ap.isEmpty(str4)) {
            str4 = str;
        }
        this.iSD.faq.setText(str4);
        this.iSD.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iSE = new ForumListModel.RequestParams();
        this.iSE.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSE.menu_name = str4;
        this.iSE.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iSE.parent_menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSE.parent_menu_name = str;
        this.iSE.offset = 0;
        this.iSE.rn = 10;
        if (this.iSE.menu_id != 0) {
            this.iSD.ckX();
            this.iSw = true;
            this.iSC = false;
            this.iSH.i(Boolean.valueOf(this.iSC));
            this.iSD.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.iSC = true;
            this.iSH.i(Boolean.valueOf(this.iSC));
            this.iSD.ckW();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.iSD.iTv.setListPullRefreshListener(this.drY);
        this.iSD.iTw.setListPullRefreshListener(this.drY);
        this.iSH.notifyDataSetChanged();
        this.iSI.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.iSD.ckZ();
        } else {
            this.iSJ = new DirMenuModel(getPageContext(), str, str3, str2);
            this.iSJ.a(this.iSM);
            this.iSJ.LoadData();
        }
        this.iSK = new ForumListDetailModel(getPageContext(), this.iSE);
        this.iSK.a(this.iSL);
        this.iSD.iTl.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (foH) {
            foH = false;
            finish();
            b(getPageContext().getPageActivity(), iSO, iSQ, iSP, iSR);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.iSH != null) {
                this.iSH.ckU();
                this.iSH.notifyDataSetChanged();
            }
            if (this.iSI != null) {
                this.iSI.ckU();
                this.iSI.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.ccn != null) {
            this.ccn.clL();
        }
        this.iSD.mViewPager.setAdapter(null);
        this.iSD.iTm.setAdapter((ListAdapter) null);
        this.iSD.iTl.setAdapter((ListAdapter) null);
        if (this.iSD.iTA != null) {
            this.iSD.iTA.setAdapter((ListAdapter) null);
        }
        if (this.iSJ != null) {
            this.iSJ.cancelLoadData();
        }
        if (this.iSK != null) {
            this.iSK.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iSD.eYE);
        this.iSD.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iSH.qE(true);
            this.iSI.qE(true);
        } else {
            this.iSH.qE(false);
            this.iSI.qE(false);
        }
        this.iSH.notifyDataSetChanged();
        this.iSI.notifyDataSetChanged();
        if (this.iSD.iTx != null) {
            this.iSD.iTx.setBackgroundDrawable(al.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        al.k(this.iSD.iTi, R.drawable.bg_pop_most);
        this.iSl = al.getColor(R.color.common_color_10243);
        this.iSm = al.getColor(R.color.cp_btn_a);
        this.iSn = al.getDrawable(R.drawable.btn_pop_most_left_n);
        this.iSo = al.getDrawable(R.drawable.btn_pop_most_right_n);
        this.iSp = al.getDrawable(R.drawable.btn_pop_most_left_s);
        this.iSq = al.getDrawable(R.drawable.btn_pop_most_right_s);
        this.iSr = al.getDrawable(R.drawable.ico_downward);
        this.iSs = al.getDrawable(R.drawable.ico_upward);
        this.iSH.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        this.iSI.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        al.k(this.iSD.iTh, R.drawable.bg_black_banner_down);
        al.f(this.iSD.iTt, R.color.common_color_10243, 1);
        al.k(this.iSD.iTg, R.drawable.bg_black_banner_down);
        al.f(this.iSD.iTq, R.color.common_color_10243, 1);
        if (this.iSF) {
            al.c(this.iSD.iTr, (int) R.drawable.ico_upward);
        } else {
            al.c(this.iSD.iTr, (int) R.drawable.ico_downward);
        }
        if (this.iSG) {
            al.c(this.iSD.iTu, (int) R.drawable.ico_upward);
        } else {
            al.c(this.iSD.iTu, (int) R.drawable.ico_downward);
        }
        if (this.iSD.mViewPager.getCurrentItem() == 0) {
            this.iSD.iTn.setTextColor(this.iSm);
            this.iSD.iTn.setBackgroundDrawable(this.iSp);
            this.iSD.iTo.setBackgroundDrawable(this.iSo);
            this.iSD.iTo.setTextColor(this.iSl);
            return;
        }
        this.iSD.iTo.setTextColor(this.iSm);
        this.iSD.iTo.setBackgroundDrawable(this.iSq);
        this.iSD.iTn.setBackgroundDrawable(this.iSn);
        this.iSD.iTn.setTextColor(this.iSl);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.iSD.mViewPager.setCurrentItem(0);
            this.iSv = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.iSD.mViewPager.setCurrentItem(1);
            this.iSv = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.iSD.d(this.iSN);
        }
    }

    private View ckO() {
        this.iSD.iTl = ckS();
        this.iSD.iTp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ckP();
            }
        });
        return this.iSD.iTl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckP() {
        if (this.iSF) {
            int min = Math.min(this.iSH.getCount(), 200);
            this.iSt = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iSH.ckT(), 0, forumInfoDataArr, 0, min);
            this.iSH.zw(min);
            this.iSH.a(forumInfoDataArr);
            this.iSF = false;
            this.iSD.iTq.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iSD.iTr.setImageDrawable(this.iSr);
            return;
        }
        this.iSt = 50;
        c cVar = new c();
        cVar.qD(true);
        cVar.execute(new Void[0]);
    }

    private View ckQ() {
        this.iSD.iTm = ckS();
        this.iSD.iTs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ckR();
            }
        });
        return this.iSD.iTm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckR() {
        if (this.iSG) {
            int min = Math.min(this.iSI.getCount(), 200);
            this.iSu = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iSI.ckT(), 0, forumInfoDataArr, 0, min);
            this.iSI.zw(min);
            this.iSI.a(forumInfoDataArr);
            this.iSG = false;
            this.iSD.iTt.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iSD.iTu.setImageDrawable(this.iSr);
            return;
        }
        this.iSu = 50;
        b bVar = new b();
        bVar.qD(true);
        bVar.execute(new Void[0]);
    }

    private BdListView ckS() {
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
        if (!this.iSw) {
            if (i == 0) {
                this.iSH.ckU();
                this.iSH.notifyDataSetChanged();
                this.iSD.iTn.setBackgroundDrawable(this.iSp);
                this.iSD.iTn.setTextColor(this.iSm);
                this.iSD.iTo.setBackgroundDrawable(this.iSo);
                this.iSD.iTo.setTextColor(this.iSl);
            } else if (i == 1) {
                this.iSI.ckU();
                this.iSI.notifyDataSetChanged();
                this.iSD.iTo.setBackgroundDrawable(this.iSq);
                this.iSD.iTo.setTextColor(this.iSm);
                this.iSD.iTn.setBackgroundDrawable(this.iSn);
                this.iSD.iTn.setTextColor(this.iSl);
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
            return ForumListActivity.this.iSw ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.iSD.iTl);
                    return ForumListActivity.this.iSD.iTl;
                case 1:
                    viewGroup.addView(ForumListActivity.this.iSD.iTm);
                    return ForumListActivity.this.iSD.iTm;
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
        final ForumInfoData[] ckT;
        if (i == 11002 && i2 == -1) {
            this.iSK.LoadData();
            if (this.iSv == 0) {
                ckT = this.iSH.ckT();
            } else {
                ckT = this.iSI.ckT();
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
                            if (ForumListActivity.this.iSv == 0) {
                                ForumListActivity.this.iSH.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ckT[ForumListActivity.this.iSH.iSV].forum_name);
                            } else if (ForumListActivity.this.iSv == 1) {
                                ForumListActivity.this.iSI.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ckT[ForumListActivity.this.iSI.iSV].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.iSv == 0) {
                this.ccn.ek(ckT[this.iSH.iSV].forum_name, String.valueOf(ckT[this.iSH.iSV].forum_id));
            } else {
                this.ccn.ek(ckT[this.iSI.iSV].forum_name, String.valueOf(ckT[this.iSI.iSV].forum_id));
            }
        }
    }
}
