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
    private static String iSS = "";
    private static String iST = "";
    private static String iSU = "";
    private static String iSV = "";
    public com.baidu.tieba.square.flist.c iSH;
    private ForumListModel.RequestParams iSI;
    private com.baidu.tieba.square.flist.b iSL;
    private com.baidu.tieba.square.flist.b iSM;
    private DirMenuModel iSN;
    private ForumListDetailModel iSO;
    private int iSp;
    private int iSq;
    private Drawable iSr;
    private Drawable iSs;
    private Drawable iSt;
    private Drawable iSu;
    private Drawable iSv;
    private Drawable iSw;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int iSx = 200;
    private int iSy = 200;
    private int iSz = 0;
    private final LikeModel cco = new LikeModel(getPageContext());
    private boolean iSA = false;
    private int iSB = 0;
    private boolean iSC = false;
    private int iSD = 0;
    private int iSE = 200;
    private boolean iSF = true;
    private boolean iSG = true;
    private boolean iSJ = false;
    private boolean iSK = false;
    private final ForumListDetailModel.a iSP = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.iSL.ckU() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.iSH.cla();
                ForumListActivity.this.iSH.ckZ();
                if (ForumListActivity.this.iSI.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.iSH.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.iSI.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.iSH.ckZ();
                    ForumListActivity.this.iSI.recommend_type = ForumListActivity.this.iSD;
                    ForumListActivity.this.iSI.rn = ForumListActivity.this.iSE;
                }
                ForumListActivity.this.iSH.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.iSH.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.iSC) {
                    ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSH.iTv.setImageDrawable(ForumListActivity.this.iSv);
                    ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSH.iTy.setImageDrawable(ForumListActivity.this.iSv);
                    ForumListActivity.this.iSC = false;
                }
                ForumListActivity.this.iSH.faq.setText(ForumListActivity.this.iSI.menu_name);
                ForumListActivity.this.iSH.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iSH.iTF.Aj(ForumListActivity.this.iSB);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.iSL.zw(min);
                ForumListActivity.this.iSL.a(ForumListActivity.this.cco);
                ForumListActivity.this.iSL.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.iSH.iTp.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.iSH.iTk.setVisibility(0);
                } else {
                    ForumListActivity.this.iSH.iTk.setVisibility(8);
                }
                ForumListActivity.this.iSH.iTr.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.iSM.zw(min2);
                ForumListActivity.this.iSM.a(ForumListActivity.this.cco);
                ForumListActivity.this.iSM.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.iSH.iTq.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.iSH.iTl.setVisibility(0);
                } else {
                    ForumListActivity.this.iSH.iTl.setVisibility(8);
                }
                ForumListActivity.this.iSH.iTs.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.iSH.ckZ();
                if (ForumListActivity.this.iSH.iTF.getCount() > 0) {
                    ForumListActivity.this.iSH.iTG.setClickable(true);
                    ForumListActivity.this.iSH.iTG.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b iSQ = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.iSH.cla();
                    return;
                }
                return;
            }
            dVar.iUx.add(0, dVar);
            if (ForumListActivity.this.iSH.iTF != null) {
                ForumListActivity.this.iSH.iTF.a(dVar);
                ForumListActivity.this.DH(String.valueOf(ForumListActivity.this.iSH.faq.getText()));
                ForumListActivity.this.iSH.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iSH.iTF.notifyDataSetChanged();
            }
            ForumListActivity.this.iSH.iTG.setClickable(true);
            ForumListActivity.this.iSH.iTG.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener iSR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.iSH.iTB, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.iSB = i;
            ForumListActivity.this.iSH.cla();
            ForumListActivity.this.iSH.clb();
            ArrayList<d> arrayList = ForumListActivity.this.iSH.iTF.ckN().iUx;
            ForumListActivity.this.ab(arrayList.get(i).iSj, arrayList.get(i).iSl, arrayList.get(i).iSk);
        }
    };
    private final h.c drY = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (!ForumListActivity.this.iSL.ckW() && !ForumListActivity.this.iSM.ckW()) {
                if (ForumListActivity.this.iSF) {
                    ForumListActivity.this.iSI.recommend_type = 0;
                    ForumListActivity.this.iSI.rn = 200;
                    ForumListActivity.this.iSO.a(ForumListActivity.this.iSI);
                    ForumListActivity.this.iSO.LoadData();
                    ForumListActivity.this.iSF = false;
                } else if (ForumListActivity.this.iSH.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.iSJ) {
                        ForumListActivity.this.iSx = 50;
                    } else {
                        ForumListActivity.this.iSx = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.iSH.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.iSK) {
                        ForumListActivity.this.iSy = 50;
                    } else {
                        ForumListActivity.this.iSy = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void DH(String str) {
        d ckN = this.iSH.iTF.ckN();
        if (ckN != null) {
            ArrayList<d> arrayList = ckN.iUx;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).iSj.equals(str)) {
                    this.iSB = i;
                    this.iSH.iTF.Aj(this.iSB);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.iSI.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSI.menu_name = str;
        this.iSI.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iSI.parent_menu_id = com.baidu.adp.lib.g.b.f(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.iSI.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.iSI.offset = 0;
        this.iSI.rn = 10;
        this.iSD = this.iSI.recommend_type;
        this.iSE = this.iSI.rn;
        this.iSI.recommend_type = 0;
        this.iSI.rn = 200;
        this.iSC = true;
        this.iSO.a(this.iSI);
        this.iSO.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iSY;

        private b() {
            this.iSY = false;
        }

        public void qE(boolean z) {
            this.iSY = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iSH.iTw.setEnabled(false);
            ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iSI.recommend_type = 2;
                ForumListActivity.this.iSI.offset = 0;
                ForumListActivity.this.iSI.rn = ForumListActivity.this.iSy;
                return ForumListModel.new_fetch(ForumListActivity.this.iSI);
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
                ForumListActivity.this.iSM.zw(min);
                ForumListActivity.this.iSM.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.iSy == 200) {
                    ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSH.iTy.setImageDrawable(ForumListActivity.this.iSv);
                } else {
                    ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iSH.iTy.setImageDrawable(ForumListActivity.this.iSw);
                    ForumListActivity.this.iSK = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iSY) {
                    if (ForumListActivity.this.iSy == 200) {
                        ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iSH.iTy.setImageDrawable(ForumListActivity.this.iSv);
                    } else {
                        ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iSH.iTy.setImageDrawable(ForumListActivity.this.iSw);
                    }
                } else {
                    ForumListActivity.this.iSH.iTx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSH.iTy.setImageDrawable(ForumListActivity.this.iSv);
                    ForumListActivity.this.iSI.rn = 200;
                    ForumListActivity.this.iSy = 200;
                }
            }
            ForumListActivity.this.iSH.iTw.setEnabled(true);
            ForumListActivity.this.iSH.ckZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iSY;

        private c() {
            this.iSY = false;
        }

        public void qE(boolean z) {
            this.iSY = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iSH.iTt.setEnabled(false);
            ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iSI.recommend_type = 1;
                ForumListActivity.this.iSI.offset = 0;
                ForumListActivity.this.iSI.rn = ForumListActivity.this.iSx;
                return ForumListModel.new_fetch(ForumListActivity.this.iSI);
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
                ForumListActivity.this.iSL.zw(min);
                ForumListActivity.this.iSL.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.iSx == 200) {
                    ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSH.iTv.setImageDrawable(ForumListActivity.this.iSv);
                } else {
                    ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iSH.iTv.setImageDrawable(ForumListActivity.this.iSw);
                    ForumListActivity.this.iSJ = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iSY) {
                    if (ForumListActivity.this.iSx == 200) {
                        ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iSH.iTv.setImageDrawable(ForumListActivity.this.iSv);
                    } else {
                        ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iSH.iTv.setImageDrawable(ForumListActivity.this.iSw);
                    }
                } else {
                    ForumListActivity.this.iSH.iTu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iSH.iTv.setImageDrawable(ForumListActivity.this.iSv);
                    ForumListActivity.this.iSI.rn = 200;
                    ForumListActivity.this.iSx = 200;
                }
            }
            ForumListActivity.this.iSH.iTt.setEnabled(true);
            ForumListActivity.this.iSH.ckZ();
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
        this.iSH = new com.baidu.tieba.square.flist.c(this);
        this.iSH.iTp = (BdListView) ckP();
        this.iSH.iTq = (BdListView) ckR();
        this.iSH.mProgressBar.setVisibility(0);
        this.iSH.iTG.setOnClickListener(null);
        this.iSH.iTG.setClickable(false);
        this.iSH.mViewPager.setAdapter(new a());
        this.iSH.iTp.setPullRefresh(this.iSH.iTz);
        this.iSH.iTq.setPullRefresh(this.iSH.iTA);
        if (com.baidu.adp.lib.g.b.f(stringExtra3, 0) != 0) {
            g = l.g(getActivity(), R.dimen.ds98);
        } else {
            g = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g));
        this.iSH.iTp.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, g + UtilHelper.getLightStatusBarHeight()));
        this.iSH.iTq.addHeaderView(textView2, 0);
        this.iSL = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.iSH.iTp.setAdapter((ListAdapter) this.iSL);
        this.iSM = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.iSH.iTq.setAdapter((ListAdapter) this.iSM);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (ap.isEmpty(str4)) {
            str4 = str;
        }
        this.iSH.faq.setText(str4);
        this.iSH.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iSI = new ForumListModel.RequestParams();
        this.iSI.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSI.menu_name = str4;
        this.iSI.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iSI.parent_menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iSI.parent_menu_name = str;
        this.iSI.offset = 0;
        this.iSI.rn = 10;
        if (this.iSI.menu_id != 0) {
            this.iSH.ckY();
            this.iSA = true;
            this.iSG = false;
            this.iSL.i(Boolean.valueOf(this.iSG));
            this.iSH.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.iSG = true;
            this.iSL.i(Boolean.valueOf(this.iSG));
            this.iSH.ckX();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.iSH.iTz.setListPullRefreshListener(this.drY);
        this.iSH.iTA.setListPullRefreshListener(this.drY);
        this.iSL.notifyDataSetChanged();
        this.iSM.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.iSH.cla();
        } else {
            this.iSN = new DirMenuModel(getPageContext(), str, str3, str2);
            this.iSN.a(this.iSQ);
            this.iSN.LoadData();
        }
        this.iSO = new ForumListDetailModel(getPageContext(), this.iSI);
        this.iSO.a(this.iSP);
        this.iSH.iTp.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (foH) {
            foH = false;
            finish();
            b(getPageContext().getPageActivity(), iSS, iSU, iST, iSV);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.iSL != null) {
                this.iSL.ckV();
                this.iSL.notifyDataSetChanged();
            }
            if (this.iSM != null) {
                this.iSM.ckV();
                this.iSM.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.cco != null) {
            this.cco.clM();
        }
        this.iSH.mViewPager.setAdapter(null);
        this.iSH.iTq.setAdapter((ListAdapter) null);
        this.iSH.iTp.setAdapter((ListAdapter) null);
        if (this.iSH.iTE != null) {
            this.iSH.iTE.setAdapter((ListAdapter) null);
        }
        if (this.iSN != null) {
            this.iSN.cancelLoadData();
        }
        if (this.iSO != null) {
            this.iSO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iSH.eYE);
        this.iSH.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iSL.qF(true);
            this.iSM.qF(true);
        } else {
            this.iSL.qF(false);
            this.iSM.qF(false);
        }
        this.iSL.notifyDataSetChanged();
        this.iSM.notifyDataSetChanged();
        if (this.iSH.iTB != null) {
            this.iSH.iTB.setBackgroundDrawable(al.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        al.k(this.iSH.iTm, R.drawable.bg_pop_most);
        this.iSp = al.getColor(R.color.common_color_10243);
        this.iSq = al.getColor(R.color.cp_btn_a);
        this.iSr = al.getDrawable(R.drawable.btn_pop_most_left_n);
        this.iSs = al.getDrawable(R.drawable.btn_pop_most_right_n);
        this.iSt = al.getDrawable(R.drawable.btn_pop_most_left_s);
        this.iSu = al.getDrawable(R.drawable.btn_pop_most_right_s);
        this.iSv = al.getDrawable(R.drawable.ico_downward);
        this.iSw = al.getDrawable(R.drawable.ico_upward);
        this.iSL.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        this.iSM.cr(R.drawable.btn_add_end, R.drawable.btn_add);
        al.k(this.iSH.iTl, R.drawable.bg_black_banner_down);
        al.f(this.iSH.iTx, R.color.common_color_10243, 1);
        al.k(this.iSH.iTk, R.drawable.bg_black_banner_down);
        al.f(this.iSH.iTu, R.color.common_color_10243, 1);
        if (this.iSJ) {
            al.c(this.iSH.iTv, (int) R.drawable.ico_upward);
        } else {
            al.c(this.iSH.iTv, (int) R.drawable.ico_downward);
        }
        if (this.iSK) {
            al.c(this.iSH.iTy, (int) R.drawable.ico_upward);
        } else {
            al.c(this.iSH.iTy, (int) R.drawable.ico_downward);
        }
        if (this.iSH.mViewPager.getCurrentItem() == 0) {
            this.iSH.iTr.setTextColor(this.iSq);
            this.iSH.iTr.setBackgroundDrawable(this.iSt);
            this.iSH.iTs.setBackgroundDrawable(this.iSs);
            this.iSH.iTs.setTextColor(this.iSp);
            return;
        }
        this.iSH.iTs.setTextColor(this.iSq);
        this.iSH.iTs.setBackgroundDrawable(this.iSu);
        this.iSH.iTr.setBackgroundDrawable(this.iSr);
        this.iSH.iTr.setTextColor(this.iSp);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.iSH.mViewPager.setCurrentItem(0);
            this.iSz = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.iSH.mViewPager.setCurrentItem(1);
            this.iSz = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.iSH.d(this.iSR);
        }
    }

    private View ckP() {
        this.iSH.iTp = ckT();
        this.iSH.iTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ckQ();
            }
        });
        return this.iSH.iTp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckQ() {
        if (this.iSJ) {
            int min = Math.min(this.iSL.getCount(), 200);
            this.iSx = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iSL.ckU(), 0, forumInfoDataArr, 0, min);
            this.iSL.zw(min);
            this.iSL.a(forumInfoDataArr);
            this.iSJ = false;
            this.iSH.iTu.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iSH.iTv.setImageDrawable(this.iSv);
            return;
        }
        this.iSx = 50;
        c cVar = new c();
        cVar.qE(true);
        cVar.execute(new Void[0]);
    }

    private View ckR() {
        this.iSH.iTq = ckT();
        this.iSH.iTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.ckS();
            }
        });
        return this.iSH.iTq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckS() {
        if (this.iSK) {
            int min = Math.min(this.iSM.getCount(), 200);
            this.iSy = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iSM.ckU(), 0, forumInfoDataArr, 0, min);
            this.iSM.zw(min);
            this.iSM.a(forumInfoDataArr);
            this.iSK = false;
            this.iSH.iTx.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iSH.iTy.setImageDrawable(this.iSv);
            return;
        }
        this.iSy = 50;
        b bVar = new b();
        bVar.qE(true);
        bVar.execute(new Void[0]);
    }

    private BdListView ckT() {
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
        if (!this.iSA) {
            if (i == 0) {
                this.iSL.ckV();
                this.iSL.notifyDataSetChanged();
                this.iSH.iTr.setBackgroundDrawable(this.iSt);
                this.iSH.iTr.setTextColor(this.iSq);
                this.iSH.iTs.setBackgroundDrawable(this.iSs);
                this.iSH.iTs.setTextColor(this.iSp);
            } else if (i == 1) {
                this.iSM.ckV();
                this.iSM.notifyDataSetChanged();
                this.iSH.iTs.setBackgroundDrawable(this.iSu);
                this.iSH.iTs.setTextColor(this.iSq);
                this.iSH.iTr.setBackgroundDrawable(this.iSr);
                this.iSH.iTr.setTextColor(this.iSp);
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
            return ForumListActivity.this.iSA ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.iSH.iTp);
                    return ForumListActivity.this.iSH.iTp;
                case 1:
                    viewGroup.addView(ForumListActivity.this.iSH.iTq);
                    return ForumListActivity.this.iSH.iTq;
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
        final ForumInfoData[] ckU;
        if (i == 11002 && i2 == -1) {
            this.iSO.LoadData();
            if (this.iSz == 0) {
                ckU = this.iSL.ckU();
            } else {
                ckU = this.iSM.ckU();
            }
            this.cco.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.cco.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.cco.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.cco.getErrorString());
                        } else if (((r) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.iSz == 0) {
                                ForumListActivity.this.iSL.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ckU[ForumListActivity.this.iSL.iSZ].forum_name);
                            } else if (ForumListActivity.this.iSz == 1) {
                                ForumListActivity.this.iSM.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(ckU[ForumListActivity.this.iSM.iSZ].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.iSz == 0) {
                this.cco.ek(ckU[this.iSL.iSZ].forum_name, String.valueOf(ckU[this.iSL.iSZ].forum_id));
            } else {
                this.cco.ek(ckU[this.iSM.iSZ].forum_name, String.valueOf(ckU[this.iSM.iSZ].forum_id));
            }
        }
    }
}
