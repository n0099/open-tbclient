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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean giR = false;
    private static String jWf = "";
    private static String jWg = "";
    private static String jWh = "";
    private static String jWi = "";
    private int jVC;
    private int jVD;
    private Drawable jVE;
    private Drawable jVF;
    private Drawable jVG;
    private Drawable jVH;
    private Drawable jVI;
    private Drawable jVJ;
    public com.baidu.tieba.square.flist.c jVU;
    private ForumListModel.RequestParams jVV;
    private com.baidu.tieba.square.flist.b jVY;
    private com.baidu.tieba.square.flist.b jVZ;
    private DirMenuModel jWa;
    private ForumListDetailModel jWb;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int jVK = 200;
    private int jVL = 200;
    private int jVM = 0;
    private final LikeModel dfB = new LikeModel(getPageContext());
    private boolean jVN = false;
    private int jVO = 0;
    private boolean jVP = false;
    private int jVQ = 0;
    private int jVR = 200;
    private boolean jVS = true;
    private boolean jVT = true;
    private boolean jVW = false;
    private boolean jVX = false;
    private final ForumListDetailModel.a jWc = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jVY.cGO() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jVU.cGU();
                ForumListActivity.this.jVU.cGT();
                if (ForumListActivity.this.jVV.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jVU.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jVV.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jVU.cGT();
                    ForumListActivity.this.jVV.recommend_type = ForumListActivity.this.jVQ;
                    ForumListActivity.this.jVV.rn = ForumListActivity.this.jVR;
                }
                ForumListActivity.this.jVU.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jVU.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.jVP) {
                    ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jVU.jWI.setImageDrawable(ForumListActivity.this.jVI);
                    ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jVU.jWL.setImageDrawable(ForumListActivity.this.jVI);
                    ForumListActivity.this.jVP = false;
                }
                ForumListActivity.this.jVU.axT.setText(ForumListActivity.this.jVV.menu_name);
                ForumListActivity.this.jVU.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jVU.jWS.BX(ForumListActivity.this.jVO);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jVY.Bj(min);
                ForumListActivity.this.jVY.a(ForumListActivity.this.dfB);
                ForumListActivity.this.jVY.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jVU.jWC.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jVU.jWx.setVisibility(0);
                } else {
                    ForumListActivity.this.jVU.jWx.setVisibility(8);
                }
                ForumListActivity.this.jVU.jWE.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jVZ.Bj(min2);
                ForumListActivity.this.jVZ.a(ForumListActivity.this.dfB);
                ForumListActivity.this.jVZ.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jVU.jWD.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jVU.jWy.setVisibility(0);
                } else {
                    ForumListActivity.this.jVU.jWy.setVisibility(8);
                }
                ForumListActivity.this.jVU.jWF.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jVU.cGT();
                if (ForumListActivity.this.jVU.jWS.getCount() > 0) {
                    ForumListActivity.this.jVU.jWT.setClickable(true);
                    ForumListActivity.this.jVU.jWT.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jWd = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jVU.cGU();
                    return;
                }
                return;
            }
            eVar.jXz.add(0, eVar);
            if (ForumListActivity.this.jVU.jWS != null) {
                ForumListActivity.this.jVU.jWS.a(eVar);
                ForumListActivity.this.In(String.valueOf(ForumListActivity.this.jVU.axT.getText()));
                ForumListActivity.this.jVU.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jVU.jWS.notifyDataSetChanged();
            }
            ForumListActivity.this.jVU.jWT.setClickable(true);
            ForumListActivity.this.jVU.jWT.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jWe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.jVU.jWO, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.jVO = i;
            ForumListActivity.this.jVU.cGU();
            ForumListActivity.this.jVU.cGV();
            ArrayList<e> arrayList = ForumListActivity.this.jVU.jWS.cGH().jXz;
            ForumListActivity.this.as(arrayList.get(i).jVw, arrayList.get(i).jVy, arrayList.get(i).jVx);
        }
    };
    private final g.c emI = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.jVY.cGQ() && !ForumListActivity.this.jVZ.cGQ()) {
                if (ForumListActivity.this.jVS) {
                    ForumListActivity.this.jVV.recommend_type = 0;
                    ForumListActivity.this.jVV.rn = 200;
                    ForumListActivity.this.jWb.a(ForumListActivity.this.jVV);
                    ForumListActivity.this.jWb.LoadData();
                    ForumListActivity.this.jVS = false;
                } else if (ForumListActivity.this.jVU.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jVW) {
                        ForumListActivity.this.jVK = 50;
                    } else {
                        ForumListActivity.this.jVK = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jVU.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jVX) {
                        ForumListActivity.this.jVL = 50;
                    } else {
                        ForumListActivity.this.jVL = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void In(String str) {
        e cGH = this.jVU.jWS.cGH();
        if (cGH != null) {
            ArrayList<e> arrayList = cGH.jXz;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).jVw.equals(str)) {
                    this.jVO = i;
                    this.jVU.jWS.BX(this.jVO);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, String str2, String str3) {
        this.jVV.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jVV.menu_name = str;
        this.jVV.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.jVV.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jVV.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jVV.offset = 0;
        this.jVV.rn = 10;
        this.jVQ = this.jVV.recommend_type;
        this.jVR = this.jVV.rn;
        this.jVV.recommend_type = 0;
        this.jVV.rn = 200;
        this.jVP = true;
        this.jWb.a(this.jVV);
        this.jWb.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jWl;

        private b() {
            this.jWl = false;
        }

        public void so(boolean z) {
            this.jWl = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jVU.jWJ.setEnabled(false);
            ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jVV.recommend_type = 2;
                ForumListActivity.this.jVV.offset = 0;
                ForumListActivity.this.jVV.rn = ForumListActivity.this.jVL;
                return ForumListModel.new_fetch(ForumListActivity.this.jVV);
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
                ForumListActivity.this.jVZ.Bj(min);
                ForumListActivity.this.jVZ.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.jVL == 200) {
                    ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jVU.jWL.setImageDrawable(ForumListActivity.this.jVI);
                } else {
                    ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jVU.jWL.setImageDrawable(ForumListActivity.this.jVJ);
                    ForumListActivity.this.jVX = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jWl) {
                    if (ForumListActivity.this.jVL == 200) {
                        ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jVU.jWL.setImageDrawable(ForumListActivity.this.jVI);
                    } else {
                        ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jVU.jWL.setImageDrawable(ForumListActivity.this.jVJ);
                    }
                } else {
                    ForumListActivity.this.jVU.jWK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jVU.jWL.setImageDrawable(ForumListActivity.this.jVI);
                    ForumListActivity.this.jVV.rn = 200;
                    ForumListActivity.this.jVL = 200;
                }
            }
            ForumListActivity.this.jVU.jWJ.setEnabled(true);
            ForumListActivity.this.jVU.cGT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jWl;

        private c() {
            this.jWl = false;
        }

        public void so(boolean z) {
            this.jWl = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jVU.jWG.setEnabled(false);
            ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jVV.recommend_type = 1;
                ForumListActivity.this.jVV.offset = 0;
                ForumListActivity.this.jVV.rn = ForumListActivity.this.jVK;
                return ForumListModel.new_fetch(ForumListActivity.this.jVV);
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
                ForumListActivity.this.jVY.Bj(min);
                ForumListActivity.this.jVY.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.jVK == 200) {
                    ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jVU.jWI.setImageDrawable(ForumListActivity.this.jVI);
                } else {
                    ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jVU.jWI.setImageDrawable(ForumListActivity.this.jVJ);
                    ForumListActivity.this.jVW = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jWl) {
                    if (ForumListActivity.this.jVK == 200) {
                        ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jVU.jWI.setImageDrawable(ForumListActivity.this.jVI);
                    } else {
                        ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jVU.jWI.setImageDrawable(ForumListActivity.this.jVJ);
                    }
                } else {
                    ForumListActivity.this.jVU.jWH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jVU.jWI.setImageDrawable(ForumListActivity.this.jVI);
                    ForumListActivity.this.jVV.rn = 200;
                    ForumListActivity.this.jVK = 200;
                }
            }
            ForumListActivity.this.jVU.jWG.setEnabled(true);
            ForumListActivity.this.jVU.cGT();
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
        int dimens;
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
        String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
        this.jVU = new com.baidu.tieba.square.flist.c(this);
        this.jVU.jWC = (BdListView) cGJ();
        this.jVU.jWD = (BdListView) cGL();
        this.jVU.mProgressBar.setVisibility(0);
        this.jVU.jWT.setOnClickListener(null);
        this.jVU.jWT.setClickable(false);
        this.jVU.mViewPager.setAdapter(new a());
        this.jVU.jWC.setPullRefresh(this.jVU.jWM);
        this.jVU.jWD.setPullRefresh(this.jVU.jWN);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.jVU.jWC.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.jVU.jWD.addHeaderView(textView2, 0);
        this.jVY = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jVU.jWC.setAdapter((ListAdapter) this.jVY);
        this.jVZ = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jVU.jWD.setAdapter((ListAdapter) this.jVZ);
        z(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void z(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jVU.axT.setText(str4);
        this.jVU.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jVV = new ForumListModel.RequestParams();
        this.jVV.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jVV.menu_name = str4;
        this.jVV.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.jVV.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.jVV.parent_menu_name = str;
        this.jVV.offset = 0;
        this.jVV.rn = 10;
        if (this.jVV.menu_id != 0) {
            this.jVU.cGS();
            this.jVN = true;
            this.jVT = false;
            this.jVY.m(Boolean.valueOf(this.jVT));
            this.jVU.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jVT = true;
            this.jVY.m(Boolean.valueOf(this.jVT));
            this.jVU.cGR();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jVU.jWM.setListPullRefreshListener(this.emI);
        this.jVU.jWN.setListPullRefreshListener(this.emI);
        this.jVY.notifyDataSetChanged();
        this.jVZ.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jVU.cGU();
        } else {
            this.jWa = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jWa.a(this.jWd);
            this.jWa.LoadData();
        }
        this.jWb = new ForumListDetailModel(getPageContext(), this.jVV);
        this.jWb.a(this.jWc);
        this.jVU.jWC.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (giR) {
            giR = false;
            finish();
            b(getPageContext().getPageActivity(), jWf, jWh, jWg, jWi);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jVY != null) {
                this.jVY.cGP();
                this.jVY.notifyDataSetChanged();
            }
            if (this.jVZ != null) {
                this.jVZ.cGP();
                this.jVZ.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfB != null) {
            this.dfB.cHI();
        }
        this.jVU.mViewPager.setAdapter(null);
        this.jVU.jWD.setAdapter((ListAdapter) null);
        this.jVU.jWC.setAdapter((ListAdapter) null);
        if (this.jVU.jWR != null) {
            this.jVU.jWR.setAdapter((ListAdapter) null);
        }
        if (this.jWa != null) {
            this.jWa.cancelLoadData();
        }
        if (this.jWb != null) {
            this.jWb.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jVU.fWp);
        this.jVU.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jVY.sp(true);
            this.jVZ.sp(true);
        } else {
            this.jVY.sp(false);
            this.jVZ.sp(false);
        }
        this.jVY.notifyDataSetChanged();
        this.jVZ.notifyDataSetChanged();
        if (this.jVU.jWO != null) {
            this.jVU.jWO.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.jVU.jWz, R.drawable.bg_pop_most);
        this.jVC = am.getColor(R.color.common_color_10243);
        this.jVD = am.getColor(R.color.cp_cont_a);
        this.jVE = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.jVF = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.jVG = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.jVH = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.jVI = am.getDrawable(R.drawable.ico_downward);
        this.jVJ = am.getDrawable(R.drawable.ico_upward);
        this.jVY.cG(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jVZ.cG(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jVU.jWy, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jVU.jWK, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.jVU.jWx, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jVU.jWH, R.color.common_color_10243, 1);
        if (this.jVW) {
            am.setImageResource(this.jVU.jWI, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jVU.jWI, R.drawable.ico_downward);
        }
        if (this.jVX) {
            am.setImageResource(this.jVU.jWL, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jVU.jWL, R.drawable.ico_downward);
        }
        if (this.jVU.mViewPager.getCurrentItem() == 0) {
            this.jVU.jWE.setTextColor(this.jVD);
            this.jVU.jWE.setBackgroundDrawable(this.jVG);
            this.jVU.jWF.setBackgroundDrawable(this.jVF);
            this.jVU.jWF.setTextColor(this.jVC);
            return;
        }
        this.jVU.jWF.setTextColor(this.jVD);
        this.jVU.jWF.setBackgroundDrawable(this.jVH);
        this.jVU.jWE.setBackgroundDrawable(this.jVE);
        this.jVU.jWE.setTextColor(this.jVC);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jVU.mViewPager.setCurrentItem(0);
            this.jVM = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jVU.mViewPager.setCurrentItem(1);
            this.jVM = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jVU.d(this.jWe);
        }
    }

    private View cGJ() {
        this.jVU.jWC = cGN();
        this.jVU.jWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cGK();
            }
        });
        return this.jVU.jWC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGK() {
        if (this.jVW) {
            int min = Math.min(this.jVY.getCount(), 200);
            this.jVK = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jVY.cGO(), 0, forumInfoDataArr, 0, min);
            this.jVY.Bj(min);
            this.jVY.a(forumInfoDataArr);
            this.jVW = false;
            this.jVU.jWH.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jVU.jWI.setImageDrawable(this.jVI);
            return;
        }
        this.jVK = 50;
        c cVar = new c();
        cVar.so(true);
        cVar.execute(new Void[0]);
    }

    private View cGL() {
        this.jVU.jWD = cGN();
        this.jVU.jWJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cGM();
            }
        });
        return this.jVU.jWD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGM() {
        if (this.jVX) {
            int min = Math.min(this.jVZ.getCount(), 200);
            this.jVL = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jVZ.cGO(), 0, forumInfoDataArr, 0, min);
            this.jVZ.Bj(min);
            this.jVZ.a(forumInfoDataArr);
            this.jVX = false;
            this.jVU.jWK.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jVU.jWL.setImageDrawable(this.jVI);
            return;
        }
        this.jVL = 50;
        b bVar = new b();
        bVar.so(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cGN() {
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
        if (!this.jVN) {
            if (i == 0) {
                this.jVY.cGP();
                this.jVY.notifyDataSetChanged();
                this.jVU.jWE.setBackgroundDrawable(this.jVG);
                this.jVU.jWE.setTextColor(this.jVD);
                this.jVU.jWF.setBackgroundDrawable(this.jVF);
                this.jVU.jWF.setTextColor(this.jVC);
            } else if (i == 1) {
                this.jVZ.cGP();
                this.jVZ.notifyDataSetChanged();
                this.jVU.jWF.setBackgroundDrawable(this.jVH);
                this.jVU.jWF.setTextColor(this.jVD);
                this.jVU.jWE.setBackgroundDrawable(this.jVE);
                this.jVU.jWE.setTextColor(this.jVC);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes7.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.jVN ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jVU.jWC);
                    return ForumListActivity.this.jVU.jWC;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jVU.jWD);
                    return ForumListActivity.this.jVU.jWD;
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
        final ForumInfoData[] cGO;
        if (i == 11002 && i2 == -1) {
            this.jWb.LoadData();
            if (this.jVM == 0) {
                cGO = this.jVY.cGO();
            } else {
                cGO = this.jVZ.cGO();
            }
            this.dfB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dfB.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dfB.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dfB.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.jVM == 0) {
                                ForumListActivity.this.jVY.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cGO[ForumListActivity.this.jVY.jWm].forum_name);
                            } else if (ForumListActivity.this.jVM == 1) {
                                ForumListActivity.this.jVZ.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cGO[ForumListActivity.this.jVZ.jWm].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.jVM == 0) {
                this.dfB.er(cGO[this.jVY.jWm].forum_name, String.valueOf(cGO[this.jVY.jWm].forum_id));
            } else {
                this.dfB.er(cGO[this.jVZ.jWm].forum_name, String.valueOf(cGO[this.jVZ.jWm].forum_id));
            }
        }
    }
}
