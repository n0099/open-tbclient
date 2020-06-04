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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes10.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean hnk = false;
    private static String lfW = "";
    private static String lfX = "";
    private static String lfY = "";
    private static String lfZ = "";
    private Drawable lfA;
    public com.baidu.tieba.square.flist.c lfL;
    private ForumListModel.RequestParams lfM;
    private com.baidu.tieba.square.flist.b lfP;
    private com.baidu.tieba.square.flist.b lfQ;
    private DirMenuModel lfR;
    private ForumListDetailModel lfS;
    private int lft;
    private int lfu;
    private Drawable lfv;
    private Drawable lfw;
    private Drawable lfx;
    private Drawable lfy;
    private Drawable lfz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int lfB = 200;
    private int lfC = 200;
    private int lfD = 0;
    private final LikeModel dYI = new LikeModel(getPageContext());
    private boolean lfE = false;
    private int lfF = 0;
    private boolean lfG = false;
    private int lfH = 0;
    private int lfI = 200;
    private boolean lfJ = true;
    private boolean lfK = true;
    private boolean lfN = false;
    private boolean lfO = false;
    private final ForumListDetailModel.a lfT = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.lfP.dch() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.lfL.dcn();
                ForumListActivity.this.lfL.dcm();
                if (ForumListActivity.this.lfM.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.lfL.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.lfM.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.lfL.dcm();
                    ForumListActivity.this.lfM.recommend_type = ForumListActivity.this.lfH;
                    ForumListActivity.this.lfM.rn = ForumListActivity.this.lfI;
                }
                ForumListActivity.this.lfL.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.lfL.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lfG) {
                    ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lfL.lgz.setImageDrawable(ForumListActivity.this.lfz);
                    ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lfL.lgC.setImageDrawable(ForumListActivity.this.lfz);
                    ForumListActivity.this.lfG = false;
                }
                ForumListActivity.this.lfL.bem.setText(ForumListActivity.this.lfM.menu_name);
                ForumListActivity.this.lfL.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lfL.lgJ.DF(ForumListActivity.this.lfF);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.lfP.CR(min);
                ForumListActivity.this.lfP.a(ForumListActivity.this.dYI);
                ForumListActivity.this.lfP.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.lfL.lgt.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.lfL.lgo.setVisibility(0);
                } else {
                    ForumListActivity.this.lfL.lgo.setVisibility(8);
                }
                ForumListActivity.this.lfL.lgv.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.lfQ.CR(min2);
                ForumListActivity.this.lfQ.a(ForumListActivity.this.dYI);
                ForumListActivity.this.lfQ.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.lfL.lgu.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.lfL.lgp.setVisibility(0);
                } else {
                    ForumListActivity.this.lfL.lgp.setVisibility(8);
                }
                ForumListActivity.this.lfL.lgw.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.lfL.dcm();
                if (ForumListActivity.this.lfL.lgJ.getCount() > 0) {
                    ForumListActivity.this.lfL.lgK.setClickable(true);
                    ForumListActivity.this.lfL.lgK.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b lfU = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.lfL.dcn();
                    return;
                }
                return;
            }
            eVar.lhu.add(0, eVar);
            if (ForumListActivity.this.lfL.lgJ != null) {
                ForumListActivity.this.lfL.lgJ.a(eVar);
                ForumListActivity.this.Mh(String.valueOf(ForumListActivity.this.lfL.bem.getText()));
                ForumListActivity.this.lfL.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lfL.lgJ.notifyDataSetChanged();
            }
            ForumListActivity.this.lfL.lgK.setClickable(true);
            ForumListActivity.this.lfL.lgK.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener lfV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.lfL.lgF, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.lfF = i;
            ForumListActivity.this.lfL.dcn();
            ForumListActivity.this.lfL.dco();
            ArrayList<e> arrayList = ForumListActivity.this.lfL.lgJ.dca().lhu;
            ForumListActivity.this.ax(arrayList.get(i).lfn, arrayList.get(i).lfp, arrayList.get(i).lfo);
        }
    };
    private final f.c fiZ = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.lfP.dcj() && !ForumListActivity.this.lfQ.dcj()) {
                if (ForumListActivity.this.lfJ) {
                    ForumListActivity.this.lfM.recommend_type = 0;
                    ForumListActivity.this.lfM.rn = 200;
                    ForumListActivity.this.lfS.a(ForumListActivity.this.lfM);
                    ForumListActivity.this.lfS.LoadData();
                    ForumListActivity.this.lfJ = false;
                } else if (ForumListActivity.this.lfL.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.lfN) {
                        ForumListActivity.this.lfB = 50;
                    } else {
                        ForumListActivity.this.lfB = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.lfL.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.lfO) {
                        ForumListActivity.this.lfC = 50;
                    } else {
                        ForumListActivity.this.lfC = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(String str) {
        e dca = this.lfL.lgJ.dca();
        if (dca != null) {
            ArrayList<e> arrayList = dca.lhu;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).lfn.equals(str)) {
                    this.lfF = i;
                    this.lfL.lgJ.DF(this.lfF);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.lfM.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lfM.menu_name = str;
        this.lfM.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lfM.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.lfM.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.lfM.offset = 0;
        this.lfM.rn = 10;
        this.lfH = this.lfM.recommend_type;
        this.lfI = this.lfM.rn;
        this.lfM.recommend_type = 0;
        this.lfM.rn = 200;
        this.lfG = true;
        this.lfS.a(this.lfM);
        this.lfS.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lgc;

        private b() {
            this.lgc = false;
        }

        public void uk(boolean z) {
            this.lgc = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lfL.lgA.setEnabled(false);
            ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lfM.recommend_type = 2;
                ForumListActivity.this.lfM.offset = 0;
                ForumListActivity.this.lfM.rn = ForumListActivity.this.lfC;
                return ForumListModel.new_fetch(ForumListActivity.this.lfM);
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
                ForumListActivity.this.lfQ.CR(min);
                ForumListActivity.this.lfQ.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.lfC == 200) {
                    ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lfL.lgC.setImageDrawable(ForumListActivity.this.lfz);
                } else {
                    ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lfL.lgC.setImageDrawable(ForumListActivity.this.lfA);
                    ForumListActivity.this.lfO = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lgc) {
                    if (ForumListActivity.this.lfC == 200) {
                        ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lfL.lgC.setImageDrawable(ForumListActivity.this.lfz);
                    } else {
                        ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lfL.lgC.setImageDrawable(ForumListActivity.this.lfA);
                    }
                } else {
                    ForumListActivity.this.lfL.lgB.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lfL.lgC.setImageDrawable(ForumListActivity.this.lfz);
                    ForumListActivity.this.lfM.rn = 200;
                    ForumListActivity.this.lfC = 200;
                }
            }
            ForumListActivity.this.lfL.lgA.setEnabled(true);
            ForumListActivity.this.lfL.dcm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lgc;

        private c() {
            this.lgc = false;
        }

        public void uk(boolean z) {
            this.lgc = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lfL.lgx.setEnabled(false);
            ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lfM.recommend_type = 1;
                ForumListActivity.this.lfM.offset = 0;
                ForumListActivity.this.lfM.rn = ForumListActivity.this.lfB;
                return ForumListModel.new_fetch(ForumListActivity.this.lfM);
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
                ForumListActivity.this.lfP.CR(min);
                ForumListActivity.this.lfP.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.lfB == 200) {
                    ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lfL.lgz.setImageDrawable(ForumListActivity.this.lfz);
                } else {
                    ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lfL.lgz.setImageDrawable(ForumListActivity.this.lfA);
                    ForumListActivity.this.lfN = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lgc) {
                    if (ForumListActivity.this.lfB == 200) {
                        ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lfL.lgz.setImageDrawable(ForumListActivity.this.lfz);
                    } else {
                        ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lfL.lgz.setImageDrawable(ForumListActivity.this.lfA);
                    }
                } else {
                    ForumListActivity.this.lfL.lgy.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lfL.lgz.setImageDrawable(ForumListActivity.this.lfz);
                    ForumListActivity.this.lfM.rn = 200;
                    ForumListActivity.this.lfB = 200;
                }
            }
            ForumListActivity.this.lfL.lgx.setEnabled(true);
            ForumListActivity.this.lfL.dcm();
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
        this.lfL = new com.baidu.tieba.square.flist.c(this);
        this.lfL.lgt = (BdListView) dcc();
        this.lfL.lgu = (BdListView) dce();
        this.lfL.mProgressBar.setVisibility(0);
        this.lfL.lgK.setOnClickListener(null);
        this.lfL.lgK.setClickable(false);
        this.lfL.mViewPager.setAdapter(new a());
        this.lfL.lgt.setPullRefresh(this.lfL.lgD);
        this.lfL.lgu.setPullRefresh(this.lfL.lgE);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.lfL.lgt.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.lfL.lgu.addHeaderView(textView2, 0);
        this.lfP = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.lfL.lgt.setAdapter((ListAdapter) this.lfP);
        this.lfQ = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.lfL.lgu.setAdapter((ListAdapter) this.lfQ);
        D(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void D(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.lfL.bem.setText(str4);
        this.lfL.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.lfM = new ForumListModel.RequestParams();
        this.lfM.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lfM.menu_name = str4;
        this.lfM.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lfM.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lfM.parent_menu_name = str;
        this.lfM.offset = 0;
        this.lfM.rn = 10;
        if (this.lfM.menu_id != 0) {
            this.lfL.dcl();
            this.lfE = true;
            this.lfK = false;
            this.lfP.m(Boolean.valueOf(this.lfK));
            this.lfL.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.lfK = true;
            this.lfP.m(Boolean.valueOf(this.lfK));
            this.lfL.dck();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.lfL.lgD.setListPullRefreshListener(this.fiZ);
        this.lfL.lgE.setListPullRefreshListener(this.fiZ);
        this.lfP.notifyDataSetChanged();
        this.lfQ.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.lfL.dcn();
        } else {
            this.lfR = new DirMenuModel(getPageContext(), str, str3, str2);
            this.lfR.a(this.lfU);
            this.lfR.LoadData();
        }
        this.lfS = new ForumListDetailModel(getPageContext(), this.lfM);
        this.lfS.a(this.lfT);
        this.lfL.lgt.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hnk) {
            hnk = false;
            finish();
            c(getPageContext().getPageActivity(), lfW, lfY, lfX, lfZ);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.lfP != null) {
                this.lfP.dci();
                this.lfP.notifyDataSetChanged();
            }
            if (this.lfQ != null) {
                this.lfQ.dci();
                this.lfQ.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dYI != null) {
            this.dYI.ddc();
        }
        this.lfL.mViewPager.setAdapter(null);
        this.lfL.lgu.setAdapter((ListAdapter) null);
        this.lfL.lgt.setAdapter((ListAdapter) null);
        if (this.lfL.lgI != null) {
            this.lfL.lgI.setAdapter((ListAdapter) null);
        }
        if (this.lfR != null) {
            this.lfR.cancelLoadData();
        }
        if (this.lfS != null) {
            this.lfS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lfL.haJ);
        this.lfL.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lfP.ul(true);
            this.lfQ.ul(true);
        } else {
            this.lfP.ul(false);
            this.lfQ.ul(false);
        }
        this.lfP.notifyDataSetChanged();
        this.lfQ.notifyDataSetChanged();
        if (this.lfL.lgF != null) {
            this.lfL.lgF.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.lfL.lgq, R.drawable.bg_pop_most);
        this.lft = am.getColor(R.color.common_color_10243);
        this.lfu = am.getColor(R.color.cp_cont_a);
        this.lfv = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lfw = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.lfx = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lfy = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.lfz = am.getDrawable(R.drawable.ico_downward);
        this.lfA = am.getDrawable(R.drawable.ico_upward);
        this.lfP.cT(R.drawable.btn_add_end, R.drawable.btn_add);
        this.lfQ.cT(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.lfL.lgp, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.lfL.lgB, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.lfL.lgo, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.lfL.lgy, R.color.common_color_10243, 1);
        if (this.lfN) {
            am.setImageResource(this.lfL.lgz, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.lfL.lgz, R.drawable.ico_downward);
        }
        if (this.lfO) {
            am.setImageResource(this.lfL.lgC, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.lfL.lgC, R.drawable.ico_downward);
        }
        if (this.lfL.mViewPager.getCurrentItem() == 0) {
            this.lfL.lgv.setTextColor(this.lfu);
            this.lfL.lgv.setBackgroundDrawable(this.lfx);
            this.lfL.lgw.setBackgroundDrawable(this.lfw);
            this.lfL.lgw.setTextColor(this.lft);
            return;
        }
        this.lfL.lgw.setTextColor(this.lfu);
        this.lfL.lgw.setBackgroundDrawable(this.lfy);
        this.lfL.lgv.setBackgroundDrawable(this.lfv);
        this.lfL.lgv.setTextColor(this.lft);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.lfL.mViewPager.setCurrentItem(0);
            this.lfD = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.lfL.mViewPager.setCurrentItem(1);
            this.lfD = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.lfL.c(this.lfV);
        }
    }

    private View dcc() {
        this.lfL.lgt = dcg();
        this.lfL.lgx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dcd();
            }
        });
        return this.lfL.lgt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcd() {
        if (this.lfN) {
            int min = Math.min(this.lfP.getCount(), 200);
            this.lfB = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lfP.dch(), 0, forumInfoDataArr, 0, min);
            this.lfP.CR(min);
            this.lfP.a(forumInfoDataArr);
            this.lfN = false;
            this.lfL.lgy.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lfL.lgz.setImageDrawable(this.lfz);
            return;
        }
        this.lfB = 50;
        c cVar = new c();
        cVar.uk(true);
        cVar.execute(new Void[0]);
    }

    private View dce() {
        this.lfL.lgu = dcg();
        this.lfL.lgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dcf();
            }
        });
        return this.lfL.lgu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcf() {
        if (this.lfO) {
            int min = Math.min(this.lfQ.getCount(), 200);
            this.lfC = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lfQ.dch(), 0, forumInfoDataArr, 0, min);
            this.lfQ.CR(min);
            this.lfQ.a(forumInfoDataArr);
            this.lfO = false;
            this.lfL.lgB.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lfL.lgC.setImageDrawable(this.lfz);
            return;
        }
        this.lfC = 50;
        b bVar = new b();
        bVar.uk(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dcg() {
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
        if (!this.lfE) {
            if (i == 0) {
                this.lfP.dci();
                this.lfP.notifyDataSetChanged();
                this.lfL.lgv.setBackgroundDrawable(this.lfx);
                this.lfL.lgv.setTextColor(this.lfu);
                this.lfL.lgw.setBackgroundDrawable(this.lfw);
                this.lfL.lgw.setTextColor(this.lft);
            } else if (i == 1) {
                this.lfQ.dci();
                this.lfQ.notifyDataSetChanged();
                this.lfL.lgw.setBackgroundDrawable(this.lfy);
                this.lfL.lgw.setTextColor(this.lfu);
                this.lfL.lgv.setBackgroundDrawable(this.lfv);
                this.lfL.lgv.setTextColor(this.lft);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes10.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.lfE ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.lfL.lgt);
                    return ForumListActivity.this.lfL.lgt;
                case 1:
                    viewGroup.addView(ForumListActivity.this.lfL.lgu);
                    return ForumListActivity.this.lfL.lgu;
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
        final ForumInfoData[] dch;
        if (i == 11002 && i2 == -1) {
            this.lfS.LoadData();
            if (this.lfD == 0) {
                dch = this.lfP.dch();
            } else {
                dch = this.lfQ.dch();
            }
            this.dYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dYI.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dYI.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dYI.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.lfD == 0) {
                                ForumListActivity.this.lfP.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dch[ForumListActivity.this.lfP.lgd].forum_name);
                            } else if (ForumListActivity.this.lfD == 1) {
                                ForumListActivity.this.lfQ.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dch[ForumListActivity.this.lfQ.lgd].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.lfD == 0) {
                this.dYI.fq(dch[this.lfP.lgd].forum_name, String.valueOf(dch[this.lfP.lgd].forum_id));
            } else {
                this.dYI.fq(dch[this.lfQ.lgd].forum_name, String.valueOf(dch[this.lfQ.lgd].forum_id));
            }
        }
    }
}
