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
    public static boolean fvS = false;
    private static String jcI = "";
    private static String jcJ = "";
    private static String jcK = "";
    private static String jcL = "";
    private com.baidu.tieba.square.flist.b jcB;
    private com.baidu.tieba.square.flist.b jcC;
    private DirMenuModel jcD;
    private ForumListDetailModel jcE;
    private int jcf;
    private int jcg;
    private Drawable jch;
    private Drawable jci;
    private Drawable jcj;
    private Drawable jck;
    private Drawable jcl;
    private Drawable jcm;
    public com.baidu.tieba.square.flist.c jcx;
    private ForumListModel.RequestParams jcy;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int jcn = 200;
    private int jco = 200;
    private int jcp = 0;
    private final LikeModel cer = new LikeModel(getPageContext());
    private boolean jcq = false;
    private int jcr = 0;
    private boolean jcs = false;
    private int jct = 0;
    private int jcu = 200;
    private boolean jcv = true;
    private boolean jcw = true;
    private boolean jcz = false;
    private boolean jcA = false;
    private final ForumListDetailModel.a jcF = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jcB.coR() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jcx.coX();
                ForumListActivity.this.jcx.coW();
                if (ForumListActivity.this.jcy.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jcx.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jcy.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jcx.coW();
                    ForumListActivity.this.jcy.recommend_type = ForumListActivity.this.jct;
                    ForumListActivity.this.jcy.rn = ForumListActivity.this.jcu;
                }
                ForumListActivity.this.jcx.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jcx.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.jcs) {
                    ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jcx.jdl.setImageDrawable(ForumListActivity.this.jcl);
                    ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jcx.jdo.setImageDrawable(ForumListActivity.this.jcl);
                    ForumListActivity.this.jcs = false;
                }
                ForumListActivity.this.jcx.fhE.setText(ForumListActivity.this.jcy.menu_name);
                ForumListActivity.this.jcx.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jcx.jdv.AU(ForumListActivity.this.jcr);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jcB.Ah(min);
                ForumListActivity.this.jcB.a(ForumListActivity.this.cer);
                ForumListActivity.this.jcB.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jcx.jdf.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jcx.jda.setVisibility(0);
                } else {
                    ForumListActivity.this.jcx.jda.setVisibility(8);
                }
                ForumListActivity.this.jcx.jdh.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jcC.Ah(min2);
                ForumListActivity.this.jcC.a(ForumListActivity.this.cer);
                ForumListActivity.this.jcC.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jcx.jdg.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jcx.jdb.setVisibility(0);
                } else {
                    ForumListActivity.this.jcx.jdb.setVisibility(8);
                }
                ForumListActivity.this.jcx.jdi.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jcx.coW();
                if (ForumListActivity.this.jcx.jdv.getCount() > 0) {
                    ForumListActivity.this.jcx.jdw.setClickable(true);
                    ForumListActivity.this.jcx.jdw.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jcG = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jcx.coX();
                    return;
                }
                return;
            }
            dVar.jem.add(0, dVar);
            if (ForumListActivity.this.jcx.jdv != null) {
                ForumListActivity.this.jcx.jdv.a(dVar);
                ForumListActivity.this.EV(String.valueOf(ForumListActivity.this.jcx.fhE.getText()));
                ForumListActivity.this.jcx.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jcx.jdv.notifyDataSetChanged();
            }
            ForumListActivity.this.jcx.jdw.setClickable(true);
            ForumListActivity.this.jcx.jdw.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jcH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.jcx.jdr, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.jcr = i;
            ForumListActivity.this.jcx.coX();
            ForumListActivity.this.jcx.coY();
            ArrayList<d> arrayList = ForumListActivity.this.jcx.jdv.coK().jem;
            ForumListActivity.this.ad(arrayList.get(i).jbZ, arrayList.get(i).jcb, arrayList.get(i).jca);
        }
    };
    private final h.c dvZ = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            if (!ForumListActivity.this.jcB.coT() && !ForumListActivity.this.jcC.coT()) {
                if (ForumListActivity.this.jcv) {
                    ForumListActivity.this.jcy.recommend_type = 0;
                    ForumListActivity.this.jcy.rn = 200;
                    ForumListActivity.this.jcE.a(ForumListActivity.this.jcy);
                    ForumListActivity.this.jcE.LoadData();
                    ForumListActivity.this.jcv = false;
                } else if (ForumListActivity.this.jcx.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jcz) {
                        ForumListActivity.this.jcn = 50;
                    } else {
                        ForumListActivity.this.jcn = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jcx.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jcA) {
                        ForumListActivity.this.jco = 50;
                    } else {
                        ForumListActivity.this.jco = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void EV(String str) {
        d coK = this.jcx.jdv.coK();
        if (coK != null) {
            ArrayList<d> arrayList = coK.jem;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).jbZ.equals(str)) {
                    this.jcr = i;
                    this.jcx.jdv.AU(this.jcr);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(String str, String str2, String str3) {
        this.jcy.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.jcy.menu_name = str;
        this.jcy.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.jcy.parent_menu_id = com.baidu.adp.lib.g.b.f(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jcy.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jcy.offset = 0;
        this.jcy.rn = 10;
        this.jct = this.jcy.recommend_type;
        this.jcu = this.jcy.rn;
        this.jcy.recommend_type = 0;
        this.jcy.rn = 200;
        this.jcs = true;
        this.jcE.a(this.jcy);
        this.jcE.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jcO;

        private b() {
            this.jcO = false;
        }

        public void qX(boolean z) {
            this.jcO = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jcx.jdm.setEnabled(false);
            ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jcy.recommend_type = 2;
                ForumListActivity.this.jcy.offset = 0;
                ForumListActivity.this.jcy.rn = ForumListActivity.this.jco;
                return ForumListModel.new_fetch(ForumListActivity.this.jcy);
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
                ForumListActivity.this.jcC.Ah(min);
                ForumListActivity.this.jcC.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.jco == 200) {
                    ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jcx.jdo.setImageDrawable(ForumListActivity.this.jcl);
                } else {
                    ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jcx.jdo.setImageDrawable(ForumListActivity.this.jcm);
                    ForumListActivity.this.jcA = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jcO) {
                    if (ForumListActivity.this.jco == 200) {
                        ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jcx.jdo.setImageDrawable(ForumListActivity.this.jcl);
                    } else {
                        ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jcx.jdo.setImageDrawable(ForumListActivity.this.jcm);
                    }
                } else {
                    ForumListActivity.this.jcx.jdn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jcx.jdo.setImageDrawable(ForumListActivity.this.jcl);
                    ForumListActivity.this.jcy.rn = 200;
                    ForumListActivity.this.jco = 200;
                }
            }
            ForumListActivity.this.jcx.jdm.setEnabled(true);
            ForumListActivity.this.jcx.coW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jcO;

        private c() {
            this.jcO = false;
        }

        public void qX(boolean z) {
            this.jcO = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jcx.jdj.setEnabled(false);
            ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jcy.recommend_type = 1;
                ForumListActivity.this.jcy.offset = 0;
                ForumListActivity.this.jcy.rn = ForumListActivity.this.jcn;
                return ForumListModel.new_fetch(ForumListActivity.this.jcy);
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
                ForumListActivity.this.jcB.Ah(min);
                ForumListActivity.this.jcB.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.jcn == 200) {
                    ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jcx.jdl.setImageDrawable(ForumListActivity.this.jcl);
                } else {
                    ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jcx.jdl.setImageDrawable(ForumListActivity.this.jcm);
                    ForumListActivity.this.jcz = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jcO) {
                    if (ForumListActivity.this.jcn == 200) {
                        ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jcx.jdl.setImageDrawable(ForumListActivity.this.jcl);
                    } else {
                        ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jcx.jdl.setImageDrawable(ForumListActivity.this.jcm);
                    }
                } else {
                    ForumListActivity.this.jcx.jdk.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jcx.jdl.setImageDrawable(ForumListActivity.this.jcl);
                    ForumListActivity.this.jcy.rn = 200;
                    ForumListActivity.this.jcn = 200;
                }
            }
            ForumListActivity.this.jcx.jdj.setEnabled(true);
            ForumListActivity.this.jcx.coW();
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
        this.jcx = new com.baidu.tieba.square.flist.c(this);
        this.jcx.jdf = (BdListView) coM();
        this.jcx.jdg = (BdListView) coO();
        this.jcx.mProgressBar.setVisibility(0);
        this.jcx.jdw.setOnClickListener(null);
        this.jcx.jdw.setClickable(false);
        this.jcx.mViewPager.setAdapter(new a());
        this.jcx.jdf.setPullRefresh(this.jcx.jdp);
        this.jcx.jdg.setPullRefresh(this.jcx.jdq);
        if (com.baidu.adp.lib.g.b.f(stringExtra3, 0) != 0) {
            g = l.g(getActivity(), R.dimen.ds98);
        } else {
            g = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g));
        this.jcx.jdf.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, g + UtilHelper.getLightStatusBarHeight()));
        this.jcx.jdg.addHeaderView(textView2, 0);
        this.jcB = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jcx.jdf.setAdapter((ListAdapter) this.jcB);
        this.jcC = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jcx.jdg.setAdapter((ListAdapter) this.jcC);
        u(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void u(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jcx.fhE.setText(str4);
        this.jcx.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jcy = new ForumListModel.RequestParams();
        this.jcy.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.jcy.menu_name = str4;
        this.jcy.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.jcy.parent_menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.jcy.parent_menu_name = str;
        this.jcy.offset = 0;
        this.jcy.rn = 10;
        if (this.jcy.menu_id != 0) {
            this.jcx.coV();
            this.jcq = true;
            this.jcw = false;
            this.jcB.i(Boolean.valueOf(this.jcw));
            this.jcx.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jcw = true;
            this.jcB.i(Boolean.valueOf(this.jcw));
            this.jcx.coU();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jcx.jdp.setListPullRefreshListener(this.dvZ);
        this.jcx.jdq.setListPullRefreshListener(this.dvZ);
        this.jcB.notifyDataSetChanged();
        this.jcC.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jcx.coX();
        } else {
            this.jcD = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jcD.a(this.jcG);
            this.jcD.LoadData();
        }
        this.jcE = new ForumListDetailModel(getPageContext(), this.jcy);
        this.jcE.a(this.jcF);
        this.jcx.jdf.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (fvS) {
            fvS = false;
            finish();
            b(getPageContext().getPageActivity(), jcI, jcK, jcJ, jcL);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jcB != null) {
                this.jcB.coS();
                this.jcB.notifyDataSetChanged();
            }
            if (this.jcC != null) {
                this.jcC.coS();
                this.jcC.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.cer != null) {
            this.cer.cpO();
        }
        this.jcx.mViewPager.setAdapter(null);
        this.jcx.jdg.setAdapter((ListAdapter) null);
        this.jcx.jdf.setAdapter((ListAdapter) null);
        if (this.jcx.jdu != null) {
            this.jcx.jdu.setAdapter((ListAdapter) null);
        }
        if (this.jcD != null) {
            this.jcD.cancelLoadData();
        }
        if (this.jcE != null) {
            this.jcE.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jcx.ffS);
        this.jcx.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jcB.qY(true);
            this.jcC.qY(true);
        } else {
            this.jcB.qY(false);
            this.jcC.qY(false);
        }
        this.jcB.notifyDataSetChanged();
        this.jcC.notifyDataSetChanged();
        if (this.jcx.jdr != null) {
            this.jcx.jdr.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.k(this.jcx.jdc, R.drawable.bg_pop_most);
        this.jcf = am.getColor(R.color.common_color_10243);
        this.jcg = am.getColor(R.color.cp_cont_a);
        this.jch = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.jci = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.jcj = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.jck = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.jcl = am.getDrawable(R.drawable.ico_downward);
        this.jcm = am.getDrawable(R.drawable.ico_upward);
        this.jcB.cv(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jcC.cv(R.drawable.btn_add_end, R.drawable.btn_add);
        am.k(this.jcx.jdb, R.drawable.bg_black_banner_down);
        am.f(this.jcx.jdn, R.color.common_color_10243, 1);
        am.k(this.jcx.jda, R.drawable.bg_black_banner_down);
        am.f(this.jcx.jdk, R.color.common_color_10243, 1);
        if (this.jcz) {
            am.c(this.jcx.jdl, (int) R.drawable.ico_upward);
        } else {
            am.c(this.jcx.jdl, (int) R.drawable.ico_downward);
        }
        if (this.jcA) {
            am.c(this.jcx.jdo, (int) R.drawable.ico_upward);
        } else {
            am.c(this.jcx.jdo, (int) R.drawable.ico_downward);
        }
        if (this.jcx.mViewPager.getCurrentItem() == 0) {
            this.jcx.jdh.setTextColor(this.jcg);
            this.jcx.jdh.setBackgroundDrawable(this.jcj);
            this.jcx.jdi.setBackgroundDrawable(this.jci);
            this.jcx.jdi.setTextColor(this.jcf);
            return;
        }
        this.jcx.jdi.setTextColor(this.jcg);
        this.jcx.jdi.setBackgroundDrawable(this.jck);
        this.jcx.jdh.setBackgroundDrawable(this.jch);
        this.jcx.jdh.setTextColor(this.jcf);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jcx.mViewPager.setCurrentItem(0);
            this.jcp = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jcx.mViewPager.setCurrentItem(1);
            this.jcp = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jcx.d(this.jcH);
        }
    }

    private View coM() {
        this.jcx.jdf = coQ();
        this.jcx.jdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.coN();
            }
        });
        return this.jcx.jdf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coN() {
        if (this.jcz) {
            int min = Math.min(this.jcB.getCount(), 200);
            this.jcn = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jcB.coR(), 0, forumInfoDataArr, 0, min);
            this.jcB.Ah(min);
            this.jcB.a(forumInfoDataArr);
            this.jcz = false;
            this.jcx.jdk.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jcx.jdl.setImageDrawable(this.jcl);
            return;
        }
        this.jcn = 50;
        c cVar = new c();
        cVar.qX(true);
        cVar.execute(new Void[0]);
    }

    private View coO() {
        this.jcx.jdg = coQ();
        this.jcx.jdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.coP();
            }
        });
        return this.jcx.jdg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coP() {
        if (this.jcA) {
            int min = Math.min(this.jcC.getCount(), 200);
            this.jco = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jcC.coR(), 0, forumInfoDataArr, 0, min);
            this.jcC.Ah(min);
            this.jcC.a(forumInfoDataArr);
            this.jcA = false;
            this.jcx.jdn.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jcx.jdo.setImageDrawable(this.jcl);
            return;
        }
        this.jco = 50;
        b bVar = new b();
        bVar.qX(true);
        bVar.execute(new Void[0]);
    }

    private BdListView coQ() {
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
        if (!this.jcq) {
            if (i == 0) {
                this.jcB.coS();
                this.jcB.notifyDataSetChanged();
                this.jcx.jdh.setBackgroundDrawable(this.jcj);
                this.jcx.jdh.setTextColor(this.jcg);
                this.jcx.jdi.setBackgroundDrawable(this.jci);
                this.jcx.jdi.setTextColor(this.jcf);
            } else if (i == 1) {
                this.jcC.coS();
                this.jcC.notifyDataSetChanged();
                this.jcx.jdi.setBackgroundDrawable(this.jck);
                this.jcx.jdi.setTextColor(this.jcg);
                this.jcx.jdh.setBackgroundDrawable(this.jch);
                this.jcx.jdh.setTextColor(this.jcf);
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
            return ForumListActivity.this.jcq ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jcx.jdf);
                    return ForumListActivity.this.jcx.jdf;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jcx.jdg);
                    return ForumListActivity.this.jcx.jdg;
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
        final ForumInfoData[] coR;
        if (i == 11002 && i2 == -1) {
            this.jcE.LoadData();
            if (this.jcp == 0) {
                coR = this.jcB.coR();
            } else {
                coR = this.jcC.coR();
            }
            this.cer.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.cer.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.cer.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.cer.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.jcp == 0) {
                                ForumListActivity.this.jcB.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(coR[ForumListActivity.this.jcB.jcP].forum_name);
                            } else if (ForumListActivity.this.jcp == 1) {
                                ForumListActivity.this.jcC.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(coR[ForumListActivity.this.jcC.jcP].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.jcp == 0) {
                this.cer.em(coR[this.jcB.jcP].forum_name, String.valueOf(coR[this.jcB.jcP].forum_id));
            } else {
                this.cer.em(coR[this.jcC.jcP].forum_name, String.valueOf(coR[this.jcC.jcP].forum_id));
            }
        }
    }
}
