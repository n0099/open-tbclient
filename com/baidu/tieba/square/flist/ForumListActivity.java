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
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean gYn = false;
    private static String kMw = "";
    private static String kMx = "";
    private static String kMy = "";
    private static String kMz = "";
    private int kLT;
    private int kLU;
    private Drawable kLV;
    private Drawable kLW;
    private Drawable kLX;
    private Drawable kLY;
    private Drawable kLZ;
    private Drawable kMa;
    public com.baidu.tieba.square.flist.c kMl;
    private ForumListModel.RequestParams kMm;
    private com.baidu.tieba.square.flist.b kMp;
    private com.baidu.tieba.square.flist.b kMq;
    private DirMenuModel kMr;
    private ForumListDetailModel kMs;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int kMb = 200;
    private int kMc = 200;
    private int kMd = 0;
    private final LikeModel dKs = new LikeModel(getPageContext());
    private boolean kMe = false;
    private int kMf = 0;
    private boolean kMg = false;
    private int kMh = 0;
    private int kMi = 200;
    private boolean kMj = true;
    private boolean kMk = true;
    private boolean kMn = false;
    private boolean kMo = false;
    private final ForumListDetailModel.a kMt = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.kMp.cUO() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.kMl.cUU();
                ForumListActivity.this.kMl.cUT();
                if (ForumListActivity.this.kMm.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.kMl.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.kMm.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.kMl.cUT();
                    ForumListActivity.this.kMm.recommend_type = ForumListActivity.this.kMh;
                    ForumListActivity.this.kMm.rn = ForumListActivity.this.kMi;
                }
                ForumListActivity.this.kMl.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.kMl.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.kMg) {
                    ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMl.kMZ.setImageDrawable(ForumListActivity.this.kLZ);
                    ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMl.kNc.setImageDrawable(ForumListActivity.this.kLZ);
                    ForumListActivity.this.kMg = false;
                }
                ForumListActivity.this.kMl.aWU.setText(ForumListActivity.this.kMm.menu_name);
                ForumListActivity.this.kMl.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kMl.kNj.CT(ForumListActivity.this.kMf);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.kMp.Cf(min);
                ForumListActivity.this.kMp.a(ForumListActivity.this.dKs);
                ForumListActivity.this.kMp.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.kMl.kMT.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.kMl.kMO.setVisibility(0);
                } else {
                    ForumListActivity.this.kMl.kMO.setVisibility(8);
                }
                ForumListActivity.this.kMl.kMV.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.kMq.Cf(min2);
                ForumListActivity.this.kMq.a(ForumListActivity.this.dKs);
                ForumListActivity.this.kMq.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.kMl.kMU.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.kMl.kMP.setVisibility(0);
                } else {
                    ForumListActivity.this.kMl.kMP.setVisibility(8);
                }
                ForumListActivity.this.kMl.kMW.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.kMl.cUT();
                if (ForumListActivity.this.kMl.kNj.getCount() > 0) {
                    ForumListActivity.this.kMl.kNk.setClickable(true);
                    ForumListActivity.this.kMl.kNk.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b kMu = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.kMl.cUU();
                    return;
                }
                return;
            }
            eVar.kNU.add(0, eVar);
            if (ForumListActivity.this.kMl.kNj != null) {
                ForumListActivity.this.kMl.kNj.a(eVar);
                ForumListActivity.this.Ku(String.valueOf(ForumListActivity.this.kMl.aWU.getText()));
                ForumListActivity.this.kMl.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kMl.kNj.notifyDataSetChanged();
            }
            ForumListActivity.this.kMl.kNk.setClickable(true);
            ForumListActivity.this.kMl.kNk.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener kMv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.kMl.kNf, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.kMf = i;
            ForumListActivity.this.kMl.cUU();
            ForumListActivity.this.kMl.cUV();
            ArrayList<e> arrayList = ForumListActivity.this.kMl.kNj.cUH().kNU;
            ForumListActivity.this.at(arrayList.get(i).kLN, arrayList.get(i).kLP, arrayList.get(i).kLO);
        }
    };
    private final g.c eWe = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.kMp.cUQ() && !ForumListActivity.this.kMq.cUQ()) {
                if (ForumListActivity.this.kMj) {
                    ForumListActivity.this.kMm.recommend_type = 0;
                    ForumListActivity.this.kMm.rn = 200;
                    ForumListActivity.this.kMs.a(ForumListActivity.this.kMm);
                    ForumListActivity.this.kMs.LoadData();
                    ForumListActivity.this.kMj = false;
                } else if (ForumListActivity.this.kMl.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.kMn) {
                        ForumListActivity.this.kMb = 50;
                    } else {
                        ForumListActivity.this.kMb = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.kMl.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.kMo) {
                        ForumListActivity.this.kMc = 50;
                    } else {
                        ForumListActivity.this.kMc = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ku(String str) {
        e cUH = this.kMl.kNj.cUH();
        if (cUH != null) {
            ArrayList<e> arrayList = cUH.kNU;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).kLN.equals(str)) {
                    this.kMf = i;
                    this.kMl.kNj.CT(this.kMf);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.kMm.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kMm.menu_name = str;
        this.kMm.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kMm.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.kMm.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.kMm.offset = 0;
        this.kMm.rn = 10;
        this.kMh = this.kMm.recommend_type;
        this.kMi = this.kMm.rn;
        this.kMm.recommend_type = 0;
        this.kMm.rn = 200;
        this.kMg = true;
        this.kMs.a(this.kMm);
        this.kMs.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kMC;

        private b() {
            this.kMC = false;
        }

        public void tM(boolean z) {
            this.kMC = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kMl.kNa.setEnabled(false);
            ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kMm.recommend_type = 2;
                ForumListActivity.this.kMm.offset = 0;
                ForumListActivity.this.kMm.rn = ForumListActivity.this.kMc;
                return ForumListModel.new_fetch(ForumListActivity.this.kMm);
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
                ForumListActivity.this.kMq.Cf(min);
                ForumListActivity.this.kMq.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.kMc == 200) {
                    ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMl.kNc.setImageDrawable(ForumListActivity.this.kLZ);
                } else {
                    ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kMl.kNc.setImageDrawable(ForumListActivity.this.kMa);
                    ForumListActivity.this.kMo = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kMC) {
                    if (ForumListActivity.this.kMc == 200) {
                        ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kMl.kNc.setImageDrawable(ForumListActivity.this.kLZ);
                    } else {
                        ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kMl.kNc.setImageDrawable(ForumListActivity.this.kMa);
                    }
                } else {
                    ForumListActivity.this.kMl.kNb.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMl.kNc.setImageDrawable(ForumListActivity.this.kLZ);
                    ForumListActivity.this.kMm.rn = 200;
                    ForumListActivity.this.kMc = 200;
                }
            }
            ForumListActivity.this.kMl.kNa.setEnabled(true);
            ForumListActivity.this.kMl.cUT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kMC;

        private c() {
            this.kMC = false;
        }

        public void tM(boolean z) {
            this.kMC = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kMl.kMX.setEnabled(false);
            ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kMm.recommend_type = 1;
                ForumListActivity.this.kMm.offset = 0;
                ForumListActivity.this.kMm.rn = ForumListActivity.this.kMb;
                return ForumListModel.new_fetch(ForumListActivity.this.kMm);
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
                ForumListActivity.this.kMp.Cf(min);
                ForumListActivity.this.kMp.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.kMb == 200) {
                    ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMl.kMZ.setImageDrawable(ForumListActivity.this.kLZ);
                } else {
                    ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kMl.kMZ.setImageDrawable(ForumListActivity.this.kMa);
                    ForumListActivity.this.kMn = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kMC) {
                    if (ForumListActivity.this.kMb == 200) {
                        ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kMl.kMZ.setImageDrawable(ForumListActivity.this.kLZ);
                    } else {
                        ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kMl.kMZ.setImageDrawable(ForumListActivity.this.kMa);
                    }
                } else {
                    ForumListActivity.this.kMl.kMY.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMl.kMZ.setImageDrawable(ForumListActivity.this.kLZ);
                    ForumListActivity.this.kMm.rn = 200;
                    ForumListActivity.this.kMb = 200;
                }
            }
            ForumListActivity.this.kMl.kMX.setEnabled(true);
            ForumListActivity.this.kMl.cUT();
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
        this.kMl = new com.baidu.tieba.square.flist.c(this);
        this.kMl.kMT = (BdListView) cUJ();
        this.kMl.kMU = (BdListView) cUL();
        this.kMl.mProgressBar.setVisibility(0);
        this.kMl.kNk.setOnClickListener(null);
        this.kMl.kNk.setClickable(false);
        this.kMl.mViewPager.setAdapter(new a());
        this.kMl.kMT.setPullRefresh(this.kMl.kNd);
        this.kMl.kMU.setPullRefresh(this.kMl.kNe);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.kMl.kMT.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.kMl.kMU.addHeaderView(textView2, 0);
        this.kMp = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.kMl.kMT.setAdapter((ListAdapter) this.kMp);
        this.kMq = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.kMl.kMU.setAdapter((ListAdapter) this.kMq);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.kMl.aWU.setText(str4);
        this.kMl.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.kMm = new ForumListModel.RequestParams();
        this.kMm.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kMm.menu_name = str4;
        this.kMm.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kMm.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kMm.parent_menu_name = str;
        this.kMm.offset = 0;
        this.kMm.rn = 10;
        if (this.kMm.menu_id != 0) {
            this.kMl.cUS();
            this.kMe = true;
            this.kMk = false;
            this.kMp.m(Boolean.valueOf(this.kMk));
            this.kMl.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.kMk = true;
            this.kMp.m(Boolean.valueOf(this.kMk));
            this.kMl.cUR();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.kMl.kNd.setListPullRefreshListener(this.eWe);
        this.kMl.kNe.setListPullRefreshListener(this.eWe);
        this.kMp.notifyDataSetChanged();
        this.kMq.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.kMl.cUU();
        } else {
            this.kMr = new DirMenuModel(getPageContext(), str, str3, str2);
            this.kMr.a(this.kMu);
            this.kMr.LoadData();
        }
        this.kMs = new ForumListDetailModel(getPageContext(), this.kMm);
        this.kMs.a(this.kMt);
        this.kMl.kMT.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (gYn) {
            gYn = false;
            finish();
            b(getPageContext().getPageActivity(), kMw, kMy, kMx, kMz);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.kMp != null) {
                this.kMp.cUP();
                this.kMp.notifyDataSetChanged();
            }
            if (this.kMq != null) {
                this.kMq.cUP();
                this.kMq.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dKs != null) {
            this.dKs.cVJ();
        }
        this.kMl.mViewPager.setAdapter(null);
        this.kMl.kMU.setAdapter((ListAdapter) null);
        this.kMl.kMT.setAdapter((ListAdapter) null);
        if (this.kMl.kNi != null) {
            this.kMl.kNi.setAdapter((ListAdapter) null);
        }
        if (this.kMr != null) {
            this.kMr.cancelLoadData();
        }
        if (this.kMs != null) {
            this.kMs.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kMl.gLM);
        this.kMl.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kMp.tN(true);
            this.kMq.tN(true);
        } else {
            this.kMp.tN(false);
            this.kMq.tN(false);
        }
        this.kMp.notifyDataSetChanged();
        this.kMq.notifyDataSetChanged();
        if (this.kMl.kNf != null) {
            this.kMl.kNf.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.kMl.kMQ, R.drawable.bg_pop_most);
        this.kLT = am.getColor(R.color.common_color_10243);
        this.kLU = am.getColor(R.color.cp_cont_a);
        this.kLV = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.kLW = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.kLX = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.kLY = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.kLZ = am.getDrawable(R.drawable.ico_downward);
        this.kMa = am.getDrawable(R.drawable.ico_upward);
        this.kMp.cO(R.drawable.btn_add_end, R.drawable.btn_add);
        this.kMq.cO(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kMl.kMP, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kMl.kNb, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.kMl.kMO, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kMl.kMY, R.color.common_color_10243, 1);
        if (this.kMn) {
            am.setImageResource(this.kMl.kMZ, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kMl.kMZ, R.drawable.ico_downward);
        }
        if (this.kMo) {
            am.setImageResource(this.kMl.kNc, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kMl.kNc, R.drawable.ico_downward);
        }
        if (this.kMl.mViewPager.getCurrentItem() == 0) {
            this.kMl.kMV.setTextColor(this.kLU);
            this.kMl.kMV.setBackgroundDrawable(this.kLX);
            this.kMl.kMW.setBackgroundDrawable(this.kLW);
            this.kMl.kMW.setTextColor(this.kLT);
            return;
        }
        this.kMl.kMW.setTextColor(this.kLU);
        this.kMl.kMW.setBackgroundDrawable(this.kLY);
        this.kMl.kMV.setBackgroundDrawable(this.kLV);
        this.kMl.kMV.setTextColor(this.kLT);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.kMl.mViewPager.setCurrentItem(0);
            this.kMd = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.kMl.mViewPager.setCurrentItem(1);
            this.kMd = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.kMl.d(this.kMv);
        }
    }

    private View cUJ() {
        this.kMl.kMT = cUN();
        this.kMl.kMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cUK();
            }
        });
        return this.kMl.kMT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUK() {
        if (this.kMn) {
            int min = Math.min(this.kMp.getCount(), 200);
            this.kMb = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kMp.cUO(), 0, forumInfoDataArr, 0, min);
            this.kMp.Cf(min);
            this.kMp.a(forumInfoDataArr);
            this.kMn = false;
            this.kMl.kMY.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kMl.kMZ.setImageDrawable(this.kLZ);
            return;
        }
        this.kMb = 50;
        c cVar = new c();
        cVar.tM(true);
        cVar.execute(new Void[0]);
    }

    private View cUL() {
        this.kMl.kMU = cUN();
        this.kMl.kNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cUM();
            }
        });
        return this.kMl.kMU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUM() {
        if (this.kMo) {
            int min = Math.min(this.kMq.getCount(), 200);
            this.kMc = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kMq.cUO(), 0, forumInfoDataArr, 0, min);
            this.kMq.Cf(min);
            this.kMq.a(forumInfoDataArr);
            this.kMo = false;
            this.kMl.kNb.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kMl.kNc.setImageDrawable(this.kLZ);
            return;
        }
        this.kMc = 50;
        b bVar = new b();
        bVar.tM(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cUN() {
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
        if (!this.kMe) {
            if (i == 0) {
                this.kMp.cUP();
                this.kMp.notifyDataSetChanged();
                this.kMl.kMV.setBackgroundDrawable(this.kLX);
                this.kMl.kMV.setTextColor(this.kLU);
                this.kMl.kMW.setBackgroundDrawable(this.kLW);
                this.kMl.kMW.setTextColor(this.kLT);
            } else if (i == 1) {
                this.kMq.cUP();
                this.kMq.notifyDataSetChanged();
                this.kMl.kMW.setBackgroundDrawable(this.kLY);
                this.kMl.kMW.setTextColor(this.kLU);
                this.kMl.kMV.setBackgroundDrawable(this.kLV);
                this.kMl.kMV.setTextColor(this.kLT);
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
            return ForumListActivity.this.kMe ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.kMl.kMT);
                    return ForumListActivity.this.kMl.kMT;
                case 1:
                    viewGroup.addView(ForumListActivity.this.kMl.kMU);
                    return ForumListActivity.this.kMl.kMU;
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
        final ForumInfoData[] cUO;
        if (i == 11002 && i2 == -1) {
            this.kMs.LoadData();
            if (this.kMd == 0) {
                cUO = this.kMp.cUO();
            } else {
                cUO = this.kMq.cUO();
            }
            this.dKs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dKs.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dKs.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dKs.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.kMd == 0) {
                                ForumListActivity.this.kMp.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cUO[ForumListActivity.this.kMp.kMD].forum_name);
                            } else if (ForumListActivity.this.kMd == 1) {
                                ForumListActivity.this.kMq.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cUO[ForumListActivity.this.kMq.kMD].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.kMd == 0) {
                this.dKs.eP(cUO[this.kMp.kMD].forum_name, String.valueOf(cUO[this.kMp.kMD].forum_id));
            } else {
                this.dKs.eP(cUO[this.kMq.kMD].forum_name, String.valueOf(cUO[this.kMq.kMD].forum_id));
            }
        }
    }
}
