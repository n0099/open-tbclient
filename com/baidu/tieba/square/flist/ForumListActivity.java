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
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean fuo = false;
    private static String jbI = "";
    private static String jbJ = "";
    private static String jbK = "";
    private static String jbL = "";
    private com.baidu.tieba.square.flist.b jbB;
    private com.baidu.tieba.square.flist.b jbC;
    private DirMenuModel jbD;
    private ForumListDetailModel jbE;
    private int jbf;
    private int jbg;
    private Drawable jbh;
    private Drawable jbi;
    private Drawable jbj;
    private Drawable jbk;
    private Drawable jbl;
    private Drawable jbm;
    public com.baidu.tieba.square.flist.c jbx;
    private ForumListModel.RequestParams jby;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int jbn = 200;
    private int jbo = 200;
    private int jbp = 0;
    private final LikeModel crO = new LikeModel(getPageContext());
    private boolean jbq = false;
    private int jbr = 0;
    private boolean jbs = false;
    private int jbt = 0;
    private int jbu = 200;
    private boolean jbv = true;
    private boolean jbw = true;
    private boolean jbz = false;
    private boolean jbA = false;
    private final ForumListDetailModel.a jbF = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jbB.cmF() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jbx.cmL();
                ForumListActivity.this.jbx.cmK();
                if (ForumListActivity.this.jby.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jbx.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jby.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jbx.cmK();
                    ForumListActivity.this.jby.recommend_type = ForumListActivity.this.jbt;
                    ForumListActivity.this.jby.rn = ForumListActivity.this.jbu;
                }
                ForumListActivity.this.jbx.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jbx.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.jbs) {
                    ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jbx.jcl.setImageDrawable(ForumListActivity.this.jbl);
                    ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jbx.jco.setImageDrawable(ForumListActivity.this.jbl);
                    ForumListActivity.this.jbs = false;
                }
                ForumListActivity.this.jbx.aqd.setText(ForumListActivity.this.jby.menu_name);
                ForumListActivity.this.jbx.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jbx.jcv.zB(ForumListActivity.this.jbr);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jbB.yO(min);
                ForumListActivity.this.jbB.a(ForumListActivity.this.crO);
                ForumListActivity.this.jbB.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jbx.jcf.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jbx.jca.setVisibility(0);
                } else {
                    ForumListActivity.this.jbx.jca.setVisibility(8);
                }
                ForumListActivity.this.jbx.jch.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jbC.yO(min2);
                ForumListActivity.this.jbC.a(ForumListActivity.this.crO);
                ForumListActivity.this.jbC.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jbx.jcg.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jbx.jcb.setVisibility(0);
                } else {
                    ForumListActivity.this.jbx.jcb.setVisibility(8);
                }
                ForumListActivity.this.jbx.jci.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jbx.cmK();
                if (ForumListActivity.this.jbx.jcv.getCount() > 0) {
                    ForumListActivity.this.jbx.jcw.setClickable(true);
                    ForumListActivity.this.jbx.jcw.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jbG = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jbx.cmL();
                    return;
                }
                return;
            }
            dVar.jdm.add(0, dVar);
            if (ForumListActivity.this.jbx.jcv != null) {
                ForumListActivity.this.jbx.jcv.a(dVar);
                ForumListActivity.this.DA(String.valueOf(ForumListActivity.this.jbx.aqd.getText()));
                ForumListActivity.this.jbx.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jbx.jcv.notifyDataSetChanged();
            }
            ForumListActivity.this.jbx.jcw.setClickable(true);
            ForumListActivity.this.jbx.jcw.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jbH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.jbx.jcr, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.jbr = i;
            ForumListActivity.this.jbx.cmL();
            ForumListActivity.this.jbx.cmM();
            ArrayList<d> arrayList = ForumListActivity.this.jbx.jcv.cmy().jdm;
            ForumListActivity.this.af(arrayList.get(i).jaZ, arrayList.get(i).jbb, arrayList.get(i).jba);
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.jbB.cmH() && !ForumListActivity.this.jbC.cmH()) {
                if (ForumListActivity.this.jbv) {
                    ForumListActivity.this.jby.recommend_type = 0;
                    ForumListActivity.this.jby.rn = 200;
                    ForumListActivity.this.jbE.a(ForumListActivity.this.jby);
                    ForumListActivity.this.jbE.LoadData();
                    ForumListActivity.this.jbv = false;
                } else if (ForumListActivity.this.jbx.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jbz) {
                        ForumListActivity.this.jbn = 50;
                    } else {
                        ForumListActivity.this.jbn = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jbx.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jbA) {
                        ForumListActivity.this.jbo = 50;
                    } else {
                        ForumListActivity.this.jbo = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void DA(String str) {
        d cmy = this.jbx.jcv.cmy();
        if (cmy != null) {
            ArrayList<d> arrayList = cmy.jdm;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).jaZ.equals(str)) {
                    this.jbr = i;
                    this.jbx.jcv.zB(this.jbr);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str, String str2, String str3) {
        this.jby.menu_id = com.baidu.adp.lib.g.b.toInt(str2, 0);
        this.jby.menu_name = str;
        this.jby.menu_type = com.baidu.adp.lib.g.b.toInt(str3, 0);
        this.jby.parent_menu_id = com.baidu.adp.lib.g.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jby.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jby.offset = 0;
        this.jby.rn = 10;
        this.jbt = this.jby.recommend_type;
        this.jbu = this.jby.rn;
        this.jby.recommend_type = 0;
        this.jby.rn = 200;
        this.jbs = true;
        this.jbE.a(this.jby);
        this.jbE.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jbO;

        private b() {
            this.jbO = false;
        }

        public void qG(boolean z) {
            this.jbO = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jbx.jcm.setEnabled(false);
            ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jby.recommend_type = 2;
                ForumListActivity.this.jby.offset = 0;
                ForumListActivity.this.jby.rn = ForumListActivity.this.jbo;
                return ForumListModel.new_fetch(ForumListActivity.this.jby);
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
                ForumListActivity.this.jbC.yO(min);
                ForumListActivity.this.jbC.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.jbo == 200) {
                    ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jbx.jco.setImageDrawable(ForumListActivity.this.jbl);
                } else {
                    ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jbx.jco.setImageDrawable(ForumListActivity.this.jbm);
                    ForumListActivity.this.jbA = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jbO) {
                    if (ForumListActivity.this.jbo == 200) {
                        ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jbx.jco.setImageDrawable(ForumListActivity.this.jbl);
                    } else {
                        ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jbx.jco.setImageDrawable(ForumListActivity.this.jbm);
                    }
                } else {
                    ForumListActivity.this.jbx.jcn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jbx.jco.setImageDrawable(ForumListActivity.this.jbl);
                    ForumListActivity.this.jby.rn = 200;
                    ForumListActivity.this.jbo = 200;
                }
            }
            ForumListActivity.this.jbx.jcm.setEnabled(true);
            ForumListActivity.this.jbx.cmK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jbO;

        private c() {
            this.jbO = false;
        }

        public void qG(boolean z) {
            this.jbO = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jbx.jcj.setEnabled(false);
            ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jby.recommend_type = 1;
                ForumListActivity.this.jby.offset = 0;
                ForumListActivity.this.jby.rn = ForumListActivity.this.jbn;
                return ForumListModel.new_fetch(ForumListActivity.this.jby);
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
                ForumListActivity.this.jbB.yO(min);
                ForumListActivity.this.jbB.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.jbn == 200) {
                    ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jbx.jcl.setImageDrawable(ForumListActivity.this.jbl);
                } else {
                    ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jbx.jcl.setImageDrawable(ForumListActivity.this.jbm);
                    ForumListActivity.this.jbz = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jbO) {
                    if (ForumListActivity.this.jbn == 200) {
                        ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jbx.jcl.setImageDrawable(ForumListActivity.this.jbl);
                    } else {
                        ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jbx.jcl.setImageDrawable(ForumListActivity.this.jbm);
                    }
                } else {
                    ForumListActivity.this.jbx.jck.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jbx.jcl.setImageDrawable(ForumListActivity.this.jbl);
                    ForumListActivity.this.jby.rn = 200;
                    ForumListActivity.this.jbn = 200;
                }
            }
            ForumListActivity.this.jbx.jcj.setEnabled(true);
            ForumListActivity.this.jbx.cmK();
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
        this.jbx = new com.baidu.tieba.square.flist.c(this);
        this.jbx.jcf = (BdListView) cmA();
        this.jbx.jcg = (BdListView) cmC();
        this.jbx.mProgressBar.setVisibility(0);
        this.jbx.jcw.setOnClickListener(null);
        this.jbx.jcw.setClickable(false);
        this.jbx.mViewPager.setAdapter(new a());
        this.jbx.jcf.setPullRefresh(this.jbx.jcp);
        this.jbx.jcg.setPullRefresh(this.jbx.jcq);
        if (com.baidu.adp.lib.g.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.jbx.jcf.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.jbx.jcg.addHeaderView(textView2, 0);
        this.jbB = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jbx.jcf.setAdapter((ListAdapter) this.jbB);
        this.jbC = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jbx.jcg.setAdapter((ListAdapter) this.jbC);
        x(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void x(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jbx.aqd.setText(str4);
        this.jbx.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jby = new ForumListModel.RequestParams();
        this.jby.menu_id = com.baidu.adp.lib.g.b.toInt(str2, 0);
        this.jby.menu_name = str4;
        this.jby.menu_type = com.baidu.adp.lib.g.b.toInt(str3, 0);
        this.jby.parent_menu_id = com.baidu.adp.lib.g.b.toInt(str2, 0);
        this.jby.parent_menu_name = str;
        this.jby.offset = 0;
        this.jby.rn = 10;
        if (this.jby.menu_id != 0) {
            this.jbx.cmJ();
            this.jbq = true;
            this.jbw = false;
            this.jbB.i(Boolean.valueOf(this.jbw));
            this.jbx.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jbw = true;
            this.jbB.i(Boolean.valueOf(this.jbw));
            this.jbx.cmI();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jbx.jcp.setListPullRefreshListener(this.dBK);
        this.jbx.jcq.setListPullRefreshListener(this.dBK);
        this.jbB.notifyDataSetChanged();
        this.jbC.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jbx.cmL();
        } else {
            this.jbD = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jbD.a(this.jbG);
            this.jbD.LoadData();
        }
        this.jbE = new ForumListDetailModel(getPageContext(), this.jby);
        this.jbE.a(this.jbF);
        this.jbx.jcf.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (fuo) {
            fuo = false;
            finish();
            b(getPageContext().getPageActivity(), jbI, jbK, jbJ, jbL);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jbB != null) {
                this.jbB.cmG();
                this.jbB.notifyDataSetChanged();
            }
            if (this.jbC != null) {
                this.jbC.cmG();
                this.jbC.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.crO != null) {
            this.crO.cnD();
        }
        this.jbx.mViewPager.setAdapter(null);
        this.jbx.jcg.setAdapter((ListAdapter) null);
        this.jbx.jcf.setAdapter((ListAdapter) null);
        if (this.jbx.jcu != null) {
            this.jbx.jcu.setAdapter((ListAdapter) null);
        }
        if (this.jbD != null) {
            this.jbD.cancelLoadData();
        }
        if (this.jbE != null) {
            this.jbE.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jbx.fhN);
        this.jbx.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jbB.qH(true);
            this.jbC.qH(true);
        } else {
            this.jbB.qH(false);
            this.jbC.qH(false);
        }
        this.jbB.notifyDataSetChanged();
        this.jbC.notifyDataSetChanged();
        if (this.jbx.jcr != null) {
            this.jbx.jcr.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.jbx.jcc, R.drawable.bg_pop_most);
        this.jbf = am.getColor(R.color.common_color_10243);
        this.jbg = am.getColor(R.color.cp_cont_a);
        this.jbh = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.jbi = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.jbj = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.jbk = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.jbl = am.getDrawable(R.drawable.ico_downward);
        this.jbm = am.getDrawable(R.drawable.ico_upward);
        this.jbB.cm(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jbC.cm(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.jbx.jcb, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jbx.jcn, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.jbx.jca, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.jbx.jck, R.color.common_color_10243, 1);
        if (this.jbz) {
            am.setImageResource(this.jbx.jcl, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jbx.jcl, R.drawable.ico_downward);
        }
        if (this.jbA) {
            am.setImageResource(this.jbx.jco, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.jbx.jco, R.drawable.ico_downward);
        }
        if (this.jbx.mViewPager.getCurrentItem() == 0) {
            this.jbx.jch.setTextColor(this.jbg);
            this.jbx.jch.setBackgroundDrawable(this.jbj);
            this.jbx.jci.setBackgroundDrawable(this.jbi);
            this.jbx.jci.setTextColor(this.jbf);
            return;
        }
        this.jbx.jci.setTextColor(this.jbg);
        this.jbx.jci.setBackgroundDrawable(this.jbk);
        this.jbx.jch.setBackgroundDrawable(this.jbh);
        this.jbx.jch.setTextColor(this.jbf);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jbx.mViewPager.setCurrentItem(0);
            this.jbp = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jbx.mViewPager.setCurrentItem(1);
            this.jbp = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jbx.d(this.jbH);
        }
    }

    private View cmA() {
        this.jbx.jcf = cmE();
        this.jbx.jcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cmB();
            }
        });
        return this.jbx.jcf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmB() {
        if (this.jbz) {
            int min = Math.min(this.jbB.getCount(), 200);
            this.jbn = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jbB.cmF(), 0, forumInfoDataArr, 0, min);
            this.jbB.yO(min);
            this.jbB.a(forumInfoDataArr);
            this.jbz = false;
            this.jbx.jck.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jbx.jcl.setImageDrawable(this.jbl);
            return;
        }
        this.jbn = 50;
        c cVar = new c();
        cVar.qG(true);
        cVar.execute(new Void[0]);
    }

    private View cmC() {
        this.jbx.jcg = cmE();
        this.jbx.jcm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cmD();
            }
        });
        return this.jbx.jcg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        if (this.jbA) {
            int min = Math.min(this.jbC.getCount(), 200);
            this.jbo = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jbC.cmF(), 0, forumInfoDataArr, 0, min);
            this.jbC.yO(min);
            this.jbC.a(forumInfoDataArr);
            this.jbA = false;
            this.jbx.jcn.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jbx.jco.setImageDrawable(this.jbl);
            return;
        }
        this.jbo = 50;
        b bVar = new b();
        bVar.qG(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cmE() {
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
        if (!this.jbq) {
            if (i == 0) {
                this.jbB.cmG();
                this.jbB.notifyDataSetChanged();
                this.jbx.jch.setBackgroundDrawable(this.jbj);
                this.jbx.jch.setTextColor(this.jbg);
                this.jbx.jci.setBackgroundDrawable(this.jbi);
                this.jbx.jci.setTextColor(this.jbf);
            } else if (i == 1) {
                this.jbC.cmG();
                this.jbC.notifyDataSetChanged();
                this.jbx.jci.setBackgroundDrawable(this.jbk);
                this.jbx.jci.setTextColor(this.jbg);
                this.jbx.jch.setBackgroundDrawable(this.jbh);
                this.jbx.jch.setTextColor(this.jbf);
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
            return ForumListActivity.this.jbq ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jbx.jcf);
                    return ForumListActivity.this.jbx.jcf;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jbx.jcg);
                    return ForumListActivity.this.jbx.jcg;
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
        final ForumInfoData[] cmF;
        if (i == 11002 && i2 == -1) {
            this.jbE.LoadData();
            if (this.jbp == 0) {
                cmF = this.jbB.cmF();
            } else {
                cmF = this.jbC.cmF();
            }
            this.crO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.crO.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.crO.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.crO.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.jbp == 0) {
                                ForumListActivity.this.jbB.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cmF[ForumListActivity.this.jbB.jbP].forum_name);
                            } else if (ForumListActivity.this.jbp == 1) {
                                ForumListActivity.this.jbC.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cmF[ForumListActivity.this.jbC.jbP].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.jbp == 0) {
                this.crO.dY(cmF[this.jbB.jbP].forum_name, String.valueOf(cmF[this.jbB.jbP].forum_id));
            } else {
                this.crO.dY(cmF[this.jbC.jbP].forum_name, String.valueOf(cmF[this.jbC.jbP].forum_id));
            }
        }
    }
}
