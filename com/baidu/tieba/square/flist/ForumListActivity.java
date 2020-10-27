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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean iBj = false;
    private static String mKU = "";
    private static String mKV = "";
    private static String mKW = "";
    private static String mKX = "";
    public com.baidu.tieba.square.flist.c mKJ;
    private ForumListModel.RequestParams mKK;
    private com.baidu.tieba.square.flist.b mKN;
    private com.baidu.tieba.square.flist.b mKO;
    private DirMenuModel mKP;
    private ForumListDetailModel mKQ;
    private int mKs;
    private int mKt;
    private Drawable mKu;
    private Drawable mKv;
    private Drawable mKw;
    private Drawable mKx;
    private Drawable mKy;
    private Drawable mKz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int mKA = 200;
    private int mKB = 200;
    private int mKC = 0;
    private final LikeModel eTL = new LikeModel(getPageContext());
    private boolean mKD = false;
    private int menu_choose = 0;
    private boolean mKE = false;
    private int mKF = 0;
    private int mKG = 200;
    private boolean mKH = true;
    private boolean mKI = true;
    private boolean mKL = false;
    private boolean mKM = false;
    private final ForumListDetailModel.a mKR = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.mKN.dFU() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.mKJ.dGa();
                ForumListActivity.this.mKJ.dFZ();
                if (ForumListActivity.this.mKK.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.mKJ.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.mKK.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.mKJ.dFZ();
                    ForumListActivity.this.mKK.recommend_type = ForumListActivity.this.mKF;
                    ForumListActivity.this.mKK.rn = ForumListActivity.this.mKG;
                }
                ForumListActivity.this.mKJ.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.mKJ.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.mKE) {
                    ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mKJ.mLx.setImageDrawable(ForumListActivity.this.mKy);
                    ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mKJ.mLA.setImageDrawable(ForumListActivity.this.mKy);
                    ForumListActivity.this.mKE = false;
                }
                ForumListActivity.this.mKJ.byL.setText(ForumListActivity.this.mKK.menu_name);
                ForumListActivity.this.mKJ.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mKJ.mLH.Jb(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.mKN.Im(min);
                ForumListActivity.this.mKN.a(ForumListActivity.this.eTL);
                ForumListActivity.this.mKN.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.mKJ.mLr.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.mKJ.mLm.setVisibility(0);
                } else {
                    ForumListActivity.this.mKJ.mLm.setVisibility(8);
                }
                ForumListActivity.this.mKJ.mLt.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.mKO.Im(min2);
                ForumListActivity.this.mKO.a(ForumListActivity.this.eTL);
                ForumListActivity.this.mKO.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.mKJ.mLs.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.mKJ.mLn.setVisibility(0);
                } else {
                    ForumListActivity.this.mKJ.mLn.setVisibility(8);
                }
                ForumListActivity.this.mKJ.mLu.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.mKJ.dFZ();
                if (ForumListActivity.this.mKJ.mLH.getCount() > 0) {
                    ForumListActivity.this.mKJ.mLI.setClickable(true);
                    ForumListActivity.this.mKJ.mLI.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b mKS = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.mKJ.dGa();
                    return;
                }
                return;
            }
            eVar.mMs.add(0, eVar);
            if (ForumListActivity.this.mKJ.mLH != null) {
                ForumListActivity.this.mKJ.mLH.a(eVar);
                ForumListActivity.this.Sf(String.valueOf(ForumListActivity.this.mKJ.byL.getText()));
                ForumListActivity.this.mKJ.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mKJ.mLH.notifyDataSetChanged();
            }
            ForumListActivity.this.mKJ.mLI.setClickable(true);
            ForumListActivity.this.mKJ.mLI.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener mKT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.mKJ.mLD, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.mKJ.dGa();
            ForumListActivity.this.mKJ.dGb();
            ArrayList<e> arrayList = ForumListActivity.this.mKJ.mLH.dFN().mMs;
            ForumListActivity.this.aG(arrayList.get(i).mKm, arrayList.get(i).mKo, arrayList.get(i).mKn);
        }
    };
    private final f.c gkz = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.mKN.dFW() && !ForumListActivity.this.mKO.dFW()) {
                if (ForumListActivity.this.mKH) {
                    ForumListActivity.this.mKK.recommend_type = 0;
                    ForumListActivity.this.mKK.rn = 200;
                    ForumListActivity.this.mKQ.a(ForumListActivity.this.mKK);
                    ForumListActivity.this.mKQ.LoadData();
                    ForumListActivity.this.mKH = false;
                } else if (ForumListActivity.this.mKJ.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.mKL) {
                        ForumListActivity.this.mKA = 50;
                    } else {
                        ForumListActivity.this.mKA = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.mKJ.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.mKM) {
                        ForumListActivity.this.mKB = 50;
                    } else {
                        ForumListActivity.this.mKB = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf(String str) {
        e dFN = this.mKJ.mLH.dFN();
        if (dFN != null) {
            ArrayList<e> arrayList = dFN.mMs;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).mKm.equals(str)) {
                    this.menu_choose = i;
                    this.mKJ.mLH.Jb(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, String str2, String str3) {
        this.mKK.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mKK.menu_name = str;
        this.mKK.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mKK.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.mKK.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.mKK.offset = 0;
        this.mKK.rn = 10;
        this.mKF = this.mKK.recommend_type;
        this.mKG = this.mKK.rn;
        this.mKK.recommend_type = 0;
        this.mKK.rn = 200;
        this.mKE = true;
        this.mKQ.a(this.mKK);
        this.mKQ.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean mLa;

        private b() {
            this.mLa = false;
        }

        public void xb(boolean z) {
            this.mLa = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mKJ.mLy.setEnabled(false);
            ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mKK.recommend_type = 2;
                ForumListActivity.this.mKK.offset = 0;
                ForumListActivity.this.mKK.rn = ForumListActivity.this.mKB;
                return ForumListModel.new_fetch(ForumListActivity.this.mKK);
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
                ForumListActivity.this.mKO.Im(min);
                ForumListActivity.this.mKO.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.mKB == 200) {
                    ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mKJ.mLA.setImageDrawable(ForumListActivity.this.mKy);
                } else {
                    ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mKJ.mLA.setImageDrawable(ForumListActivity.this.mKz);
                    ForumListActivity.this.mKM = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.mLa) {
                    if (ForumListActivity.this.mKB == 200) {
                        ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mKJ.mLA.setImageDrawable(ForumListActivity.this.mKy);
                    } else {
                        ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mKJ.mLA.setImageDrawable(ForumListActivity.this.mKz);
                    }
                } else {
                    ForumListActivity.this.mKJ.mLz.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mKJ.mLA.setImageDrawable(ForumListActivity.this.mKy);
                    ForumListActivity.this.mKK.rn = 200;
                    ForumListActivity.this.mKB = 200;
                }
            }
            ForumListActivity.this.mKJ.mLy.setEnabled(true);
            ForumListActivity.this.mKJ.dFZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean mLa;

        private c() {
            this.mLa = false;
        }

        public void xb(boolean z) {
            this.mLa = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mKJ.mLv.setEnabled(false);
            ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mKK.recommend_type = 1;
                ForumListActivity.this.mKK.offset = 0;
                ForumListActivity.this.mKK.rn = ForumListActivity.this.mKA;
                return ForumListModel.new_fetch(ForumListActivity.this.mKK);
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
                ForumListActivity.this.mKN.Im(min);
                ForumListActivity.this.mKN.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.mKA == 200) {
                    ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mKJ.mLx.setImageDrawable(ForumListActivity.this.mKy);
                } else {
                    ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mKJ.mLx.setImageDrawable(ForumListActivity.this.mKz);
                    ForumListActivity.this.mKL = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.mLa) {
                    if (ForumListActivity.this.mKA == 200) {
                        ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mKJ.mLx.setImageDrawable(ForumListActivity.this.mKy);
                    } else {
                        ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mKJ.mLx.setImageDrawable(ForumListActivity.this.mKz);
                    }
                } else {
                    ForumListActivity.this.mKJ.mLw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mKJ.mLx.setImageDrawable(ForumListActivity.this.mKy);
                    ForumListActivity.this.mKK.rn = 200;
                    ForumListActivity.this.mKA = 200;
                }
            }
            ForumListActivity.this.mKJ.mLv.setEnabled(true);
            ForumListActivity.this.mKJ.dFZ();
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
        this.mKJ = new com.baidu.tieba.square.flist.c(this);
        this.mKJ.mLr = (BdListView) dFP();
        this.mKJ.mLs = (BdListView) dFR();
        this.mKJ.mProgressBar.setVisibility(0);
        this.mKJ.mLI.setOnClickListener(null);
        this.mKJ.mLI.setClickable(false);
        this.mKJ.mViewPager.setAdapter(new a());
        this.mKJ.mLr.setPullRefresh(this.mKJ.mLB);
        this.mKJ.mLs.setPullRefresh(this.mKJ.mLC);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.mKJ.mLr.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.mKJ.mLs.addHeaderView(textView2, 0);
        this.mKN = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.mKJ.mLr.setAdapter((ListAdapter) this.mKN);
        this.mKO = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.mKJ.mLs.setAdapter((ListAdapter) this.mKO);
        I(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void I(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.mKJ.byL.setText(str4);
        this.mKJ.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mKK = new ForumListModel.RequestParams();
        this.mKK.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mKK.menu_name = str4;
        this.mKK.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mKK.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mKK.parent_menu_name = str;
        this.mKK.offset = 0;
        this.mKK.rn = 10;
        if (this.mKK.menu_id != 0) {
            this.mKJ.dFY();
            this.mKD = true;
            this.mKI = false;
            this.mKN.s(Boolean.valueOf(this.mKI));
            this.mKJ.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.mKI = true;
            this.mKN.s(Boolean.valueOf(this.mKI));
            this.mKJ.dFX();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.mKJ.mLB.setListPullRefreshListener(this.gkz);
        this.mKJ.mLC.setListPullRefreshListener(this.gkz);
        this.mKN.notifyDataSetChanged();
        this.mKO.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.mKJ.dGa();
        } else {
            this.mKP = new DirMenuModel(getPageContext(), str, str3, str2);
            this.mKP.a(this.mKS);
            this.mKP.LoadData();
        }
        this.mKQ = new ForumListDetailModel(getPageContext(), this.mKK);
        this.mKQ.a(this.mKR);
        this.mKJ.mLr.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (iBj) {
            iBj = false;
            finish();
            c(getPageContext().getPageActivity(), mKU, mKW, mKV, mKX);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.mKN != null) {
                this.mKN.dFV();
                this.mKN.notifyDataSetChanged();
            }
            if (this.mKO != null) {
                this.mKO.dFV();
                this.mKO.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTL != null) {
            this.eTL.dGQ();
        }
        this.mKJ.mViewPager.setAdapter(null);
        this.mKJ.mLs.setAdapter((ListAdapter) null);
        this.mKJ.mLr.setAdapter((ListAdapter) null);
        if (this.mKJ.mLG != null) {
            this.mKJ.mLG.setAdapter((ListAdapter) null);
        }
        if (this.mKP != null) {
            this.mKP.cancelLoadData();
        }
        if (this.mKQ != null) {
            this.mKQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mKJ.ioA);
        this.mKJ.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mKN.xc(true);
            this.mKO.xc(true);
        } else {
            this.mKN.xc(false);
            this.mKO.xc(false);
        }
        this.mKN.notifyDataSetChanged();
        this.mKO.notifyDataSetChanged();
        if (this.mKJ.mLD != null) {
            this.mKJ.mLD.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.mKJ.mLo, R.drawable.bg_pop_most);
        this.mKs = ap.getColor(R.color.common_color_10243);
        this.mKt = ap.getColor(R.color.cp_cont_a);
        this.mKu = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.mKv = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.mKw = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.mKx = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.mKy = ap.getDrawable(R.drawable.ico_downward);
        this.mKz = ap.getDrawable(R.drawable.ico_upward);
        this.mKN.dp(R.drawable.btn_add_end, R.drawable.btn_add);
        this.mKO.dp(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mKJ.mLn, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mKJ.mLz, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.mKJ.mLm, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mKJ.mLw, R.color.common_color_10243, 1);
        if (this.mKL) {
            ap.setImageResource(this.mKJ.mLx, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mKJ.mLx, R.drawable.ico_downward);
        }
        if (this.mKM) {
            ap.setImageResource(this.mKJ.mLA, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mKJ.mLA, R.drawable.ico_downward);
        }
        if (this.mKJ.mViewPager.getCurrentItem() == 0) {
            this.mKJ.mLt.setTextColor(this.mKt);
            this.mKJ.mLt.setBackgroundDrawable(this.mKw);
            this.mKJ.mLu.setBackgroundDrawable(this.mKv);
            this.mKJ.mLu.setTextColor(this.mKs);
            return;
        }
        this.mKJ.mLu.setTextColor(this.mKt);
        this.mKJ.mLu.setBackgroundDrawable(this.mKx);
        this.mKJ.mLt.setBackgroundDrawable(this.mKu);
        this.mKJ.mLt.setTextColor(this.mKs);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.mKJ.mViewPager.setCurrentItem(0);
            this.mKC = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.mKJ.mViewPager.setCurrentItem(1);
            this.mKC = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.mKJ.c(this.mKT);
        }
    }

    private View dFP() {
        this.mKJ.mLr = dFT();
        this.mKJ.mLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dFQ();
            }
        });
        return this.mKJ.mLr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFQ() {
        if (this.mKL) {
            int min = Math.min(this.mKN.getCount(), 200);
            this.mKA = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mKN.dFU(), 0, forumInfoDataArr, 0, min);
            this.mKN.Im(min);
            this.mKN.a(forumInfoDataArr);
            this.mKL = false;
            this.mKJ.mLw.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mKJ.mLx.setImageDrawable(this.mKy);
            return;
        }
        this.mKA = 50;
        c cVar = new c();
        cVar.xb(true);
        cVar.execute(new Void[0]);
    }

    private View dFR() {
        this.mKJ.mLs = dFT();
        this.mKJ.mLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dFS();
            }
        });
        return this.mKJ.mLs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFS() {
        if (this.mKM) {
            int min = Math.min(this.mKO.getCount(), 200);
            this.mKB = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mKO.dFU(), 0, forumInfoDataArr, 0, min);
            this.mKO.Im(min);
            this.mKO.a(forumInfoDataArr);
            this.mKM = false;
            this.mKJ.mLz.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mKJ.mLA.setImageDrawable(this.mKy);
            return;
        }
        this.mKB = 50;
        b bVar = new b();
        bVar.xb(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dFT() {
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
        if (!this.mKD) {
            if (i == 0) {
                this.mKN.dFV();
                this.mKN.notifyDataSetChanged();
                this.mKJ.mLt.setBackgroundDrawable(this.mKw);
                this.mKJ.mLt.setTextColor(this.mKt);
                this.mKJ.mLu.setBackgroundDrawable(this.mKv);
                this.mKJ.mLu.setTextColor(this.mKs);
            } else if (i == 1) {
                this.mKO.dFV();
                this.mKO.notifyDataSetChanged();
                this.mKJ.mLu.setBackgroundDrawable(this.mKx);
                this.mKJ.mLu.setTextColor(this.mKt);
                this.mKJ.mLt.setBackgroundDrawable(this.mKu);
                this.mKJ.mLt.setTextColor(this.mKs);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes23.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.mKD ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.mKJ.mLr);
                    return ForumListActivity.this.mKJ.mLr;
                case 1:
                    viewGroup.addView(ForumListActivity.this.mKJ.mLs);
                    return ForumListActivity.this.mKJ.mLs;
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
        final ForumInfoData[] dFU;
        if (i == 11002 && i2 == -1) {
            this.mKQ.LoadData();
            if (this.mKC == 0) {
                dFU = this.mKN.dFU();
            } else {
                dFU = this.mKO.dFU();
            }
            this.eTL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.eTL.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.eTL.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.eTL.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.mKC == 0) {
                                ForumListActivity.this.mKN.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dFU[ForumListActivity.this.mKN.mLb].forum_name);
                            } else if (ForumListActivity.this.mKC == 1) {
                                ForumListActivity.this.mKO.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dFU[ForumListActivity.this.mKO.mLb].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.mKC == 0) {
                this.eTL.gp(dFU[this.mKN.mLb].forum_name, String.valueOf(dFU[this.mKN.mLb].forum_id));
            } else {
                this.eTL.gp(dFU[this.mKO.mLb].forum_name, String.valueOf(dFU[this.mKO.mLb].forum_id));
            }
        }
    }
}
