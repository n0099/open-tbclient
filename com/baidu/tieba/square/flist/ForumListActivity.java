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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
    public static boolean ftG = false;
    private static String iZj = "";
    private static String iZk = "";
    private static String iZl = "";
    private static String iZm = "";
    private int iYG;
    private int iYH;
    private Drawable iYI;
    private Drawable iYJ;
    private Drawable iYK;
    private Drawable iYL;
    private Drawable iYM;
    private Drawable iYN;
    public com.baidu.tieba.square.flist.c iYY;
    private ForumListModel.RequestParams iYZ;
    private com.baidu.tieba.square.flist.b iZc;
    private com.baidu.tieba.square.flist.b iZd;
    private DirMenuModel iZe;
    private ForumListDetailModel iZf;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int iYO = 200;
    private int iYP = 200;
    private int iYQ = 0;
    private final LikeModel cdr = new LikeModel(getPageContext());
    private boolean iYR = false;
    private int iYS = 0;
    private boolean iYT = false;
    private int iYU = 0;
    private int iYV = 200;
    private boolean iYW = true;
    private boolean iYX = true;
    private boolean iZa = false;
    private boolean iZb = false;
    private final ForumListDetailModel.a iZg = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.iZc.cnM() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.iYY.cnS();
                ForumListActivity.this.iYY.cnR();
                if (ForumListActivity.this.iYZ.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.iYY.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.iYZ.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.iYY.cnR();
                    ForumListActivity.this.iYZ.recommend_type = ForumListActivity.this.iYU;
                    ForumListActivity.this.iYZ.rn = ForumListActivity.this.iYV;
                }
                ForumListActivity.this.iYY.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.iYY.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.iYT) {
                    ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iYY.iZM.setImageDrawable(ForumListActivity.this.iYM);
                    ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iYY.iZP.setImageDrawable(ForumListActivity.this.iYM);
                    ForumListActivity.this.iYT = false;
                }
                ForumListActivity.this.iYY.ffr.setText(ForumListActivity.this.iYZ.menu_name);
                ForumListActivity.this.iYY.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iYY.iZW.AP(ForumListActivity.this.iYS);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.iZc.Ac(min);
                ForumListActivity.this.iZc.a(ForumListActivity.this.cdr);
                ForumListActivity.this.iZc.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.iYY.iZG.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.iYY.iZB.setVisibility(0);
                } else {
                    ForumListActivity.this.iYY.iZB.setVisibility(8);
                }
                ForumListActivity.this.iYY.iZI.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.iZd.Ac(min2);
                ForumListActivity.this.iZd.a(ForumListActivity.this.cdr);
                ForumListActivity.this.iZd.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.iYY.iZH.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.iYY.iZC.setVisibility(0);
                } else {
                    ForumListActivity.this.iYY.iZC.setVisibility(8);
                }
                ForumListActivity.this.iYY.iZJ.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.iYY.cnR();
                if (ForumListActivity.this.iYY.iZW.getCount() > 0) {
                    ForumListActivity.this.iYY.iZX.setClickable(true);
                    ForumListActivity.this.iYY.iZX.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b iZh = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.iYY.cnS();
                    return;
                }
                return;
            }
            dVar.jaN.add(0, dVar);
            if (ForumListActivity.this.iYY.iZW != null) {
                ForumListActivity.this.iYY.iZW.a(dVar);
                ForumListActivity.this.Eu(String.valueOf(ForumListActivity.this.iYY.ffr.getText()));
                ForumListActivity.this.iYY.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.iYY.iZW.notifyDataSetChanged();
            }
            ForumListActivity.this.iYY.iZX.setClickable(true);
            ForumListActivity.this.iYY.iZX.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener iZi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.iYY.iZS, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.iYS = i;
            ForumListActivity.this.iYY.cnS();
            ForumListActivity.this.iYY.cnT();
            ArrayList<d> arrayList = ForumListActivity.this.iYY.iZW.cnF().jaN;
            ForumListActivity.this.ab(arrayList.get(i).iYA, arrayList.get(i).iYC, arrayList.get(i).iYB);
        }
    };
    private final h.c duh = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (!ForumListActivity.this.iZc.cnO() && !ForumListActivity.this.iZd.cnO()) {
                if (ForumListActivity.this.iYW) {
                    ForumListActivity.this.iYZ.recommend_type = 0;
                    ForumListActivity.this.iYZ.rn = 200;
                    ForumListActivity.this.iZf.a(ForumListActivity.this.iYZ);
                    ForumListActivity.this.iZf.LoadData();
                    ForumListActivity.this.iYW = false;
                } else if (ForumListActivity.this.iYY.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.iZa) {
                        ForumListActivity.this.iYO = 50;
                    } else {
                        ForumListActivity.this.iYO = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.iYY.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.iZb) {
                        ForumListActivity.this.iYP = 50;
                    } else {
                        ForumListActivity.this.iYP = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu(String str) {
        d cnF = this.iYY.iZW.cnF();
        if (cnF != null) {
            ArrayList<d> arrayList = cnF.jaN;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).iYA.equals(str)) {
                    this.iYS = i;
                    this.iYY.iZW.AP(this.iYS);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.iYZ.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iYZ.menu_name = str;
        this.iYZ.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iYZ.parent_menu_id = com.baidu.adp.lib.g.b.f(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.iYZ.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.iYZ.offset = 0;
        this.iYZ.rn = 10;
        this.iYU = this.iYZ.recommend_type;
        this.iYV = this.iYZ.rn;
        this.iYZ.recommend_type = 0;
        this.iYZ.rn = 200;
        this.iYT = true;
        this.iZf.a(this.iYZ);
        this.iZf.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iZp;

        private b() {
            this.iZp = false;
        }

        public void qT(boolean z) {
            this.iZp = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iYY.iZN.setEnabled(false);
            ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iYZ.recommend_type = 2;
                ForumListActivity.this.iYZ.offset = 0;
                ForumListActivity.this.iYZ.rn = ForumListActivity.this.iYP;
                return ForumListModel.new_fetch(ForumListActivity.this.iYZ);
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
                ForumListActivity.this.iZd.Ac(min);
                ForumListActivity.this.iZd.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.iYP == 200) {
                    ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iYY.iZP.setImageDrawable(ForumListActivity.this.iYM);
                } else {
                    ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iYY.iZP.setImageDrawable(ForumListActivity.this.iYN);
                    ForumListActivity.this.iZb = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iZp) {
                    if (ForumListActivity.this.iYP == 200) {
                        ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iYY.iZP.setImageDrawable(ForumListActivity.this.iYM);
                    } else {
                        ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iYY.iZP.setImageDrawable(ForumListActivity.this.iYN);
                    }
                } else {
                    ForumListActivity.this.iYY.iZO.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iYY.iZP.setImageDrawable(ForumListActivity.this.iYM);
                    ForumListActivity.this.iYZ.rn = 200;
                    ForumListActivity.this.iYP = 200;
                }
            }
            ForumListActivity.this.iYY.iZN.setEnabled(true);
            ForumListActivity.this.iYY.cnR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean iZp;

        private c() {
            this.iZp = false;
        }

        public void qT(boolean z) {
            this.iZp = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.iYY.iZK.setEnabled(false);
            ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.iYZ.recommend_type = 1;
                ForumListActivity.this.iYZ.offset = 0;
                ForumListActivity.this.iYZ.rn = ForumListActivity.this.iYO;
                return ForumListModel.new_fetch(ForumListActivity.this.iYZ);
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
                ForumListActivity.this.iZc.Ac(min);
                ForumListActivity.this.iZc.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.iYO == 200) {
                    ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iYY.iZM.setImageDrawable(ForumListActivity.this.iYM);
                } else {
                    ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.iYY.iZM.setImageDrawable(ForumListActivity.this.iYN);
                    ForumListActivity.this.iZa = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.iZp) {
                    if (ForumListActivity.this.iYO == 200) {
                        ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.iYY.iZM.setImageDrawable(ForumListActivity.this.iYM);
                    } else {
                        ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.iYY.iZM.setImageDrawable(ForumListActivity.this.iYN);
                    }
                } else {
                    ForumListActivity.this.iYY.iZL.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.iYY.iZM.setImageDrawable(ForumListActivity.this.iYM);
                    ForumListActivity.this.iYZ.rn = 200;
                    ForumListActivity.this.iYO = 200;
                }
            }
            ForumListActivity.this.iYY.iZK.setEnabled(true);
            ForumListActivity.this.iYY.cnR();
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
        this.iYY = new com.baidu.tieba.square.flist.c(this);
        this.iYY.iZG = (BdListView) cnH();
        this.iYY.iZH = (BdListView) cnJ();
        this.iYY.mProgressBar.setVisibility(0);
        this.iYY.iZX.setOnClickListener(null);
        this.iYY.iZX.setClickable(false);
        this.iYY.mViewPager.setAdapter(new a());
        this.iYY.iZG.setPullRefresh(this.iYY.iZQ);
        this.iYY.iZH.setPullRefresh(this.iYY.iZR);
        if (com.baidu.adp.lib.g.b.f(stringExtra3, 0) != 0) {
            g = l.g(getActivity(), R.dimen.ds98);
        } else {
            g = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g));
        this.iYY.iZG.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, g + UtilHelper.getLightStatusBarHeight()));
        this.iYY.iZH.addHeaderView(textView2, 0);
        this.iZc = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.iYY.iZG.setAdapter((ListAdapter) this.iZc);
        this.iZd = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.iYY.iZH.setAdapter((ListAdapter) this.iZd);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.iYY.ffr.setText(str4);
        this.iYY.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.iYZ = new ForumListModel.RequestParams();
        this.iYZ.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iYZ.menu_name = str4;
        this.iYZ.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.iYZ.parent_menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.iYZ.parent_menu_name = str;
        this.iYZ.offset = 0;
        this.iYZ.rn = 10;
        if (this.iYZ.menu_id != 0) {
            this.iYY.cnQ();
            this.iYR = true;
            this.iYX = false;
            this.iZc.i(Boolean.valueOf(this.iYX));
            this.iYY.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.iYX = true;
            this.iZc.i(Boolean.valueOf(this.iYX));
            this.iYY.cnP();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.iYY.iZQ.setListPullRefreshListener(this.duh);
        this.iYY.iZR.setListPullRefreshListener(this.duh);
        this.iZc.notifyDataSetChanged();
        this.iZd.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.iYY.cnS();
        } else {
            this.iZe = new DirMenuModel(getPageContext(), str, str3, str2);
            this.iZe.a(this.iZh);
            this.iZe.LoadData();
        }
        this.iZf = new ForumListDetailModel(getPageContext(), this.iYZ);
        this.iZf.a(this.iZg);
        this.iYY.iZG.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (ftG) {
            ftG = false;
            finish();
            b(getPageContext().getPageActivity(), iZj, iZl, iZk, iZm);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.iZc != null) {
                this.iZc.cnN();
                this.iZc.notifyDataSetChanged();
            }
            if (this.iZd != null) {
                this.iZd.cnN();
                this.iZd.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.cdr != null) {
            this.cdr.coE();
        }
        this.iYY.mViewPager.setAdapter(null);
        this.iYY.iZH.setAdapter((ListAdapter) null);
        this.iYY.iZG.setAdapter((ListAdapter) null);
        if (this.iYY.iZV != null) {
            this.iYY.iZV.setAdapter((ListAdapter) null);
        }
        if (this.iZe != null) {
            this.iZe.cancelLoadData();
        }
        if (this.iZf != null) {
            this.iZf.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iYY.fdF);
        this.iYY.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iZc.qU(true);
            this.iZd.qU(true);
        } else {
            this.iZc.qU(false);
            this.iZd.qU(false);
        }
        this.iZc.notifyDataSetChanged();
        this.iZd.notifyDataSetChanged();
        if (this.iYY.iZS != null) {
            this.iYY.iZS.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.k(this.iYY.iZD, R.drawable.bg_pop_most);
        this.iYG = am.getColor(R.color.common_color_10243);
        this.iYH = am.getColor(R.color.cp_btn_a);
        this.iYI = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.iYJ = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.iYK = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.iYL = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.iYM = am.getDrawable(R.drawable.ico_downward);
        this.iYN = am.getDrawable(R.drawable.ico_upward);
        this.iZc.cw(R.drawable.btn_add_end, R.drawable.btn_add);
        this.iZd.cw(R.drawable.btn_add_end, R.drawable.btn_add);
        am.k(this.iYY.iZC, R.drawable.bg_black_banner_down);
        am.f(this.iYY.iZO, R.color.common_color_10243, 1);
        am.k(this.iYY.iZB, R.drawable.bg_black_banner_down);
        am.f(this.iYY.iZL, R.color.common_color_10243, 1);
        if (this.iZa) {
            am.c(this.iYY.iZM, (int) R.drawable.ico_upward);
        } else {
            am.c(this.iYY.iZM, (int) R.drawable.ico_downward);
        }
        if (this.iZb) {
            am.c(this.iYY.iZP, (int) R.drawable.ico_upward);
        } else {
            am.c(this.iYY.iZP, (int) R.drawable.ico_downward);
        }
        if (this.iYY.mViewPager.getCurrentItem() == 0) {
            this.iYY.iZI.setTextColor(this.iYH);
            this.iYY.iZI.setBackgroundDrawable(this.iYK);
            this.iYY.iZJ.setBackgroundDrawable(this.iYJ);
            this.iYY.iZJ.setTextColor(this.iYG);
            return;
        }
        this.iYY.iZJ.setTextColor(this.iYH);
        this.iYY.iZJ.setBackgroundDrawable(this.iYL);
        this.iYY.iZI.setBackgroundDrawable(this.iYI);
        this.iYY.iZI.setTextColor(this.iYG);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.iYY.mViewPager.setCurrentItem(0);
            this.iYQ = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.iYY.mViewPager.setCurrentItem(1);
            this.iYQ = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.iYY.d(this.iZi);
        }
    }

    private View cnH() {
        this.iYY.iZG = cnL();
        this.iYY.iZK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cnI();
            }
        });
        return this.iYY.iZG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnI() {
        if (this.iZa) {
            int min = Math.min(this.iZc.getCount(), 200);
            this.iYO = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iZc.cnM(), 0, forumInfoDataArr, 0, min);
            this.iZc.Ac(min);
            this.iZc.a(forumInfoDataArr);
            this.iZa = false;
            this.iYY.iZL.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iYY.iZM.setImageDrawable(this.iYM);
            return;
        }
        this.iYO = 50;
        c cVar = new c();
        cVar.qT(true);
        cVar.execute(new Void[0]);
    }

    private View cnJ() {
        this.iYY.iZH = cnL();
        this.iYY.iZN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cnK();
            }
        });
        return this.iYY.iZH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnK() {
        if (this.iZb) {
            int min = Math.min(this.iZd.getCount(), 200);
            this.iYP = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.iZd.cnM(), 0, forumInfoDataArr, 0, min);
            this.iZd.Ac(min);
            this.iZd.a(forumInfoDataArr);
            this.iZb = false;
            this.iYY.iZO.setText(getPageContext().getString(R.string.flist_expand_list));
            this.iYY.iZP.setImageDrawable(this.iYM);
            return;
        }
        this.iYP = 50;
        b bVar = new b();
        bVar.qT(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cnL() {
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
        if (!this.iYR) {
            if (i == 0) {
                this.iZc.cnN();
                this.iZc.notifyDataSetChanged();
                this.iYY.iZI.setBackgroundDrawable(this.iYK);
                this.iYY.iZI.setTextColor(this.iYH);
                this.iYY.iZJ.setBackgroundDrawable(this.iYJ);
                this.iYY.iZJ.setTextColor(this.iYG);
            } else if (i == 1) {
                this.iZd.cnN();
                this.iZd.notifyDataSetChanged();
                this.iYY.iZJ.setBackgroundDrawable(this.iYL);
                this.iYY.iZJ.setTextColor(this.iYH);
                this.iYY.iZI.setBackgroundDrawable(this.iYI);
                this.iYY.iZI.setTextColor(this.iYG);
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
            return ForumListActivity.this.iYR ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.iYY.iZG);
                    return ForumListActivity.this.iYY.iZG;
                case 1:
                    viewGroup.addView(ForumListActivity.this.iYY.iZH);
                    return ForumListActivity.this.iYY.iZH;
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
        final ForumInfoData[] cnM;
        if (i == 11002 && i2 == -1) {
            this.iZf.LoadData();
            if (this.iYQ == 0) {
                cnM = this.iZc.cnM();
            } else {
                cnM = this.iZd.cnM();
            }
            this.cdr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.cdr.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.cdr.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.cdr.getErrorString());
                        } else if (((r) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.iYQ == 0) {
                                ForumListActivity.this.iZc.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cnM[ForumListActivity.this.iZc.iZq].forum_name);
                            } else if (ForumListActivity.this.iYQ == 1) {
                                ForumListActivity.this.iZd.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cnM[ForumListActivity.this.iZd.iZq].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.iYQ == 0) {
                this.cdr.el(cnM[this.iZc.iZq].forum_name, String.valueOf(cnM[this.iZc.iZq].forum_id));
            } else {
                this.cdr.el(cnM[this.iZd.iZq].forum_name, String.valueOf(cnM[this.iZd.iZq].forum_id));
            }
        }
    }
}
