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
    public static boolean ioN = false;
    private static String myk = "";
    private static String myl = "";
    private static String mym = "";
    private static String myn = "";
    private int mxI;
    private int mxJ;
    private Drawable mxK;
    private Drawable mxL;
    private Drawable mxM;
    private Drawable mxN;
    private Drawable mxO;
    private Drawable mxP;
    public com.baidu.tieba.square.flist.c mxZ;
    private ForumListModel.RequestParams mya;
    private com.baidu.tieba.square.flist.b myd;
    private com.baidu.tieba.square.flist.b mye;
    private DirMenuModel myf;
    private ForumListDetailModel myg;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int mxQ = 200;
    private int mxR = 200;
    private int mxS = 0;
    private final LikeModel eLp = new LikeModel(getPageContext());
    private boolean mxT = false;
    private int menu_choose = 0;
    private boolean mxU = false;
    private int mxV = 0;
    private int mxW = 200;
    private boolean mxX = true;
    private boolean mxY = true;
    private boolean myb = false;
    private boolean myc = false;
    private final ForumListDetailModel.a myh = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.myd.dCM() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.mxZ.dCS();
                ForumListActivity.this.mxZ.dCR();
                if (ForumListActivity.this.mya.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.mxZ.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.mya.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.mxZ.dCR();
                    ForumListActivity.this.mya.recommend_type = ForumListActivity.this.mxV;
                    ForumListActivity.this.mya.rn = ForumListActivity.this.mxW;
                }
                ForumListActivity.this.mxZ.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.mxZ.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.mxU) {
                    ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mxZ.myN.setImageDrawable(ForumListActivity.this.mxO);
                    ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mxZ.myQ.setImageDrawable(ForumListActivity.this.mxO);
                    ForumListActivity.this.mxU = false;
                }
                ForumListActivity.this.mxZ.bwx.setText(ForumListActivity.this.mya.menu_name);
                ForumListActivity.this.mxZ.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mxZ.myX.IJ(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.myd.HT(min);
                ForumListActivity.this.myd.a(ForumListActivity.this.eLp);
                ForumListActivity.this.myd.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.mxZ.myH.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.mxZ.myC.setVisibility(0);
                } else {
                    ForumListActivity.this.mxZ.myC.setVisibility(8);
                }
                ForumListActivity.this.mxZ.myJ.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.mye.HT(min2);
                ForumListActivity.this.mye.a(ForumListActivity.this.eLp);
                ForumListActivity.this.mye.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.mxZ.myI.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.mxZ.myD.setVisibility(0);
                } else {
                    ForumListActivity.this.mxZ.myD.setVisibility(8);
                }
                ForumListActivity.this.mxZ.myK.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.mxZ.dCR();
                if (ForumListActivity.this.mxZ.myX.getCount() > 0) {
                    ForumListActivity.this.mxZ.myY.setClickable(true);
                    ForumListActivity.this.mxZ.myY.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b myi = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.mxZ.dCS();
                    return;
                }
                return;
            }
            eVar.mzI.add(0, eVar);
            if (ForumListActivity.this.mxZ.myX != null) {
                ForumListActivity.this.mxZ.myX.a(eVar);
                ForumListActivity.this.RG(String.valueOf(ForumListActivity.this.mxZ.bwx.getText()));
                ForumListActivity.this.mxZ.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mxZ.myX.notifyDataSetChanged();
            }
            ForumListActivity.this.mxZ.myY.setClickable(true);
            ForumListActivity.this.mxZ.myY.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener myj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.mxZ.myT, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.mxZ.dCS();
            ForumListActivity.this.mxZ.dCT();
            ArrayList<e> arrayList = ForumListActivity.this.mxZ.myX.dCF().mzI;
            ForumListActivity.this.az(arrayList.get(i).mxC, arrayList.get(i).mxE, arrayList.get(i).mxD);
        }
    };
    private final f.c gav = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.myd.dCO() && !ForumListActivity.this.mye.dCO()) {
                if (ForumListActivity.this.mxX) {
                    ForumListActivity.this.mya.recommend_type = 0;
                    ForumListActivity.this.mya.rn = 200;
                    ForumListActivity.this.myg.a(ForumListActivity.this.mya);
                    ForumListActivity.this.myg.LoadData();
                    ForumListActivity.this.mxX = false;
                } else if (ForumListActivity.this.mxZ.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.myb) {
                        ForumListActivity.this.mxQ = 50;
                    } else {
                        ForumListActivity.this.mxQ = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.mxZ.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.myc) {
                        ForumListActivity.this.mxR = 50;
                    } else {
                        ForumListActivity.this.mxR = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void RG(String str) {
        e dCF = this.mxZ.myX.dCF();
        if (dCF != null) {
            ArrayList<e> arrayList = dCF.mzI;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).mxC.equals(str)) {
                    this.menu_choose = i;
                    this.mxZ.myX.IJ(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(String str, String str2, String str3) {
        this.mya.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mya.menu_name = str;
        this.mya.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mya.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.mya.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.mya.offset = 0;
        this.mya.rn = 10;
        this.mxV = this.mya.recommend_type;
        this.mxW = this.mya.rn;
        this.mya.recommend_type = 0;
        this.mya.rn = 200;
        this.mxU = true;
        this.myg.a(this.mya);
        this.myg.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean myq;

        private b() {
            this.myq = false;
        }

        public void wK(boolean z) {
            this.myq = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mxZ.myO.setEnabled(false);
            ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mya.recommend_type = 2;
                ForumListActivity.this.mya.offset = 0;
                ForumListActivity.this.mya.rn = ForumListActivity.this.mxR;
                return ForumListModel.new_fetch(ForumListActivity.this.mya);
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
                ForumListActivity.this.mye.HT(min);
                ForumListActivity.this.mye.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.mxR == 200) {
                    ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mxZ.myQ.setImageDrawable(ForumListActivity.this.mxO);
                } else {
                    ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mxZ.myQ.setImageDrawable(ForumListActivity.this.mxP);
                    ForumListActivity.this.myc = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.myq) {
                    if (ForumListActivity.this.mxR == 200) {
                        ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mxZ.myQ.setImageDrawable(ForumListActivity.this.mxO);
                    } else {
                        ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mxZ.myQ.setImageDrawable(ForumListActivity.this.mxP);
                    }
                } else {
                    ForumListActivity.this.mxZ.myP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mxZ.myQ.setImageDrawable(ForumListActivity.this.mxO);
                    ForumListActivity.this.mya.rn = 200;
                    ForumListActivity.this.mxR = 200;
                }
            }
            ForumListActivity.this.mxZ.myO.setEnabled(true);
            ForumListActivity.this.mxZ.dCR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean myq;

        private c() {
            this.myq = false;
        }

        public void wK(boolean z) {
            this.myq = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mxZ.myL.setEnabled(false);
            ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mya.recommend_type = 1;
                ForumListActivity.this.mya.offset = 0;
                ForumListActivity.this.mya.rn = ForumListActivity.this.mxQ;
                return ForumListModel.new_fetch(ForumListActivity.this.mya);
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
                ForumListActivity.this.myd.HT(min);
                ForumListActivity.this.myd.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.mxQ == 200) {
                    ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mxZ.myN.setImageDrawable(ForumListActivity.this.mxO);
                } else {
                    ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mxZ.myN.setImageDrawable(ForumListActivity.this.mxP);
                    ForumListActivity.this.myb = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.myq) {
                    if (ForumListActivity.this.mxQ == 200) {
                        ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mxZ.myN.setImageDrawable(ForumListActivity.this.mxO);
                    } else {
                        ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mxZ.myN.setImageDrawable(ForumListActivity.this.mxP);
                    }
                } else {
                    ForumListActivity.this.mxZ.myM.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mxZ.myN.setImageDrawable(ForumListActivity.this.mxO);
                    ForumListActivity.this.mya.rn = 200;
                    ForumListActivity.this.mxQ = 200;
                }
            }
            ForumListActivity.this.mxZ.myL.setEnabled(true);
            ForumListActivity.this.mxZ.dCR();
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
        this.mxZ = new com.baidu.tieba.square.flist.c(this);
        this.mxZ.myH = (BdListView) dCH();
        this.mxZ.myI = (BdListView) dCJ();
        this.mxZ.mProgressBar.setVisibility(0);
        this.mxZ.myY.setOnClickListener(null);
        this.mxZ.myY.setClickable(false);
        this.mxZ.mViewPager.setAdapter(new a());
        this.mxZ.myH.setPullRefresh(this.mxZ.myR);
        this.mxZ.myI.setPullRefresh(this.mxZ.myS);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.mxZ.myH.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.mxZ.myI.addHeaderView(textView2, 0);
        this.myd = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.mxZ.myH.setAdapter((ListAdapter) this.myd);
        this.mye = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.mxZ.myI.setAdapter((ListAdapter) this.mye);
        H(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void H(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.mxZ.bwx.setText(str4);
        this.mxZ.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mya = new ForumListModel.RequestParams();
        this.mya.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mya.menu_name = str4;
        this.mya.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mya.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mya.parent_menu_name = str;
        this.mya.offset = 0;
        this.mya.rn = 10;
        if (this.mya.menu_id != 0) {
            this.mxZ.dCQ();
            this.mxT = true;
            this.mxY = false;
            this.myd.s(Boolean.valueOf(this.mxY));
            this.mxZ.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.mxY = true;
            this.myd.s(Boolean.valueOf(this.mxY));
            this.mxZ.dCP();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.mxZ.myR.setListPullRefreshListener(this.gav);
        this.mxZ.myS.setListPullRefreshListener(this.gav);
        this.myd.notifyDataSetChanged();
        this.mye.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.mxZ.dCS();
        } else {
            this.myf = new DirMenuModel(getPageContext(), str, str3, str2);
            this.myf.a(this.myi);
            this.myf.LoadData();
        }
        this.myg = new ForumListDetailModel(getPageContext(), this.mya);
        this.myg.a(this.myh);
        this.mxZ.myH.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (ioN) {
            ioN = false;
            finish();
            c(getPageContext().getPageActivity(), myk, mym, myl, myn);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.myd != null) {
                this.myd.dCN();
                this.myd.notifyDataSetChanged();
            }
            if (this.mye != null) {
                this.mye.dCN();
                this.mye.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.eLp != null) {
            this.eLp.dDI();
        }
        this.mxZ.mViewPager.setAdapter(null);
        this.mxZ.myI.setAdapter((ListAdapter) null);
        this.mxZ.myH.setAdapter((ListAdapter) null);
        if (this.mxZ.myW != null) {
            this.mxZ.myW.setAdapter((ListAdapter) null);
        }
        if (this.myf != null) {
            this.myf.cancelLoadData();
        }
        if (this.myg != null) {
            this.myg.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mxZ.ibY);
        this.mxZ.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.myd.wL(true);
            this.mye.wL(true);
        } else {
            this.myd.wL(false);
            this.mye.wL(false);
        }
        this.myd.notifyDataSetChanged();
        this.mye.notifyDataSetChanged();
        if (this.mxZ.myT != null) {
            this.mxZ.myT.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.mxZ.myE, R.drawable.bg_pop_most);
        this.mxI = ap.getColor(R.color.common_color_10243);
        this.mxJ = ap.getColor(R.color.cp_cont_a);
        this.mxK = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.mxL = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.mxM = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.mxN = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.mxO = ap.getDrawable(R.drawable.ico_downward);
        this.mxP = ap.getDrawable(R.drawable.ico_upward);
        this.myd.dn(R.drawable.btn_add_end, R.drawable.btn_add);
        this.mye.dn(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mxZ.myD, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mxZ.myP, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.mxZ.myC, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mxZ.myM, R.color.common_color_10243, 1);
        if (this.myb) {
            ap.setImageResource(this.mxZ.myN, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mxZ.myN, R.drawable.ico_downward);
        }
        if (this.myc) {
            ap.setImageResource(this.mxZ.myQ, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mxZ.myQ, R.drawable.ico_downward);
        }
        if (this.mxZ.mViewPager.getCurrentItem() == 0) {
            this.mxZ.myJ.setTextColor(this.mxJ);
            this.mxZ.myJ.setBackgroundDrawable(this.mxM);
            this.mxZ.myK.setBackgroundDrawable(this.mxL);
            this.mxZ.myK.setTextColor(this.mxI);
            return;
        }
        this.mxZ.myK.setTextColor(this.mxJ);
        this.mxZ.myK.setBackgroundDrawable(this.mxN);
        this.mxZ.myJ.setBackgroundDrawable(this.mxK);
        this.mxZ.myJ.setTextColor(this.mxI);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.mxZ.mViewPager.setCurrentItem(0);
            this.mxS = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.mxZ.mViewPager.setCurrentItem(1);
            this.mxS = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.mxZ.c(this.myj);
        }
    }

    private View dCH() {
        this.mxZ.myH = dCL();
        this.mxZ.myL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dCI();
            }
        });
        return this.mxZ.myH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCI() {
        if (this.myb) {
            int min = Math.min(this.myd.getCount(), 200);
            this.mxQ = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.myd.dCM(), 0, forumInfoDataArr, 0, min);
            this.myd.HT(min);
            this.myd.a(forumInfoDataArr);
            this.myb = false;
            this.mxZ.myM.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mxZ.myN.setImageDrawable(this.mxO);
            return;
        }
        this.mxQ = 50;
        c cVar = new c();
        cVar.wK(true);
        cVar.execute(new Void[0]);
    }

    private View dCJ() {
        this.mxZ.myI = dCL();
        this.mxZ.myO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dCK();
            }
        });
        return this.mxZ.myI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCK() {
        if (this.myc) {
            int min = Math.min(this.mye.getCount(), 200);
            this.mxR = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mye.dCM(), 0, forumInfoDataArr, 0, min);
            this.mye.HT(min);
            this.mye.a(forumInfoDataArr);
            this.myc = false;
            this.mxZ.myP.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mxZ.myQ.setImageDrawable(this.mxO);
            return;
        }
        this.mxR = 50;
        b bVar = new b();
        bVar.wK(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dCL() {
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
        if (!this.mxT) {
            if (i == 0) {
                this.myd.dCN();
                this.myd.notifyDataSetChanged();
                this.mxZ.myJ.setBackgroundDrawable(this.mxM);
                this.mxZ.myJ.setTextColor(this.mxJ);
                this.mxZ.myK.setBackgroundDrawable(this.mxL);
                this.mxZ.myK.setTextColor(this.mxI);
            } else if (i == 1) {
                this.mye.dCN();
                this.mye.notifyDataSetChanged();
                this.mxZ.myK.setBackgroundDrawable(this.mxN);
                this.mxZ.myK.setTextColor(this.mxJ);
                this.mxZ.myJ.setBackgroundDrawable(this.mxK);
                this.mxZ.myJ.setTextColor(this.mxI);
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
            return ForumListActivity.this.mxT ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.mxZ.myH);
                    return ForumListActivity.this.mxZ.myH;
                case 1:
                    viewGroup.addView(ForumListActivity.this.mxZ.myI);
                    return ForumListActivity.this.mxZ.myI;
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
        final ForumInfoData[] dCM;
        if (i == 11002 && i2 == -1) {
            this.myg.LoadData();
            if (this.mxS == 0) {
                dCM = this.myd.dCM();
            } else {
                dCM = this.mye.dCM();
            }
            this.eLp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.eLp.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.eLp.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.eLp.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.mxS == 0) {
                                ForumListActivity.this.myd.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dCM[ForumListActivity.this.myd.myr].forum_name);
                            } else if (ForumListActivity.this.mxS == 1) {
                                ForumListActivity.this.mye.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dCM[ForumListActivity.this.mye.myr].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.mxS == 0) {
                this.eLp.gk(dCM[this.myd.myr].forum_name, String.valueOf(dCM[this.myd.myr].forum_id));
            } else {
                this.eLp.gk(dCM[this.mye.myr].forum_name, String.valueOf(dCM[this.mye.myr].forum_id));
            }
        }
    }
}
