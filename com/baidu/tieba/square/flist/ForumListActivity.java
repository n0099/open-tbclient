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
    public static boolean gpa = false;
    private static String kcC = "";
    private static String kcD = "";
    private static String kcE = "";
    private static String kcF = "";
    private int kbZ;
    private int kca;
    private Drawable kcb;
    private Drawable kcc;
    private Drawable kcd;
    private Drawable kce;
    private Drawable kcf;
    private Drawable kcg;
    public com.baidu.tieba.square.flist.c kcr;
    private ForumListModel.RequestParams kcs;
    private com.baidu.tieba.square.flist.b kcv;
    private com.baidu.tieba.square.flist.b kcw;
    private DirMenuModel kcx;
    private ForumListDetailModel kcy;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int kch = 200;
    private int kci = 200;
    private int kcj = 0;
    private final LikeModel dku = new LikeModel(getPageContext());
    private boolean kck = false;
    private int kcl = 0;
    private boolean kcm = false;
    private int kcn = 0;
    private int kco = 200;
    private boolean kcp = true;
    private boolean kcq = true;
    private boolean kct = false;
    private boolean kcu = false;
    private final ForumListDetailModel.a kcz = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.kcv.cJV() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.kcr.cKb();
                ForumListActivity.this.kcr.cKa();
                if (ForumListActivity.this.kcs.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.kcr.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.kcs.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.kcr.cKa();
                    ForumListActivity.this.kcs.recommend_type = ForumListActivity.this.kcn;
                    ForumListActivity.this.kcs.rn = ForumListActivity.this.kco;
                }
                ForumListActivity.this.kcr.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.kcr.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.kcm) {
                    ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kcr.kdf.setImageDrawable(ForumListActivity.this.kcf);
                    ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kcr.kdi.setImageDrawable(ForumListActivity.this.kcf);
                    ForumListActivity.this.kcm = false;
                }
                ForumListActivity.this.kcr.aDi.setText(ForumListActivity.this.kcs.menu_name);
                ForumListActivity.this.kcr.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kcr.kdp.Cr(ForumListActivity.this.kcl);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.kcv.BF(min);
                ForumListActivity.this.kcv.a(ForumListActivity.this.dku);
                ForumListActivity.this.kcv.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.kcr.kcZ.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.kcr.kcU.setVisibility(0);
                } else {
                    ForumListActivity.this.kcr.kcU.setVisibility(8);
                }
                ForumListActivity.this.kcr.kdb.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.kcw.BF(min2);
                ForumListActivity.this.kcw.a(ForumListActivity.this.dku);
                ForumListActivity.this.kcw.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.kcr.kda.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.kcr.kcV.setVisibility(0);
                } else {
                    ForumListActivity.this.kcr.kcV.setVisibility(8);
                }
                ForumListActivity.this.kcr.kdc.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.kcr.cKa();
                if (ForumListActivity.this.kcr.kdp.getCount() > 0) {
                    ForumListActivity.this.kcr.kdq.setClickable(true);
                    ForumListActivity.this.kcr.kdq.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b kcA = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.kcr.cKb();
                    return;
                }
                return;
            }
            eVar.kdW.add(0, eVar);
            if (ForumListActivity.this.kcr.kdp != null) {
                ForumListActivity.this.kcr.kdp.a(eVar);
                ForumListActivity.this.IL(String.valueOf(ForumListActivity.this.kcr.aDi.getText()));
                ForumListActivity.this.kcr.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kcr.kdp.notifyDataSetChanged();
            }
            ForumListActivity.this.kcr.kdq.setClickable(true);
            ForumListActivity.this.kcr.kdq.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener kcB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.kcr.kdl, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.kcl = i;
            ForumListActivity.this.kcr.cKb();
            ForumListActivity.this.kcr.cKc();
            ArrayList<e> arrayList = ForumListActivity.this.kcr.kdp.cJO().kdW;
            ForumListActivity.this.at(arrayList.get(i).kbT, arrayList.get(i).kbV, arrayList.get(i).kbU);
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.kcv.cJX() && !ForumListActivity.this.kcw.cJX()) {
                if (ForumListActivity.this.kcp) {
                    ForumListActivity.this.kcs.recommend_type = 0;
                    ForumListActivity.this.kcs.rn = 200;
                    ForumListActivity.this.kcy.a(ForumListActivity.this.kcs);
                    ForumListActivity.this.kcy.LoadData();
                    ForumListActivity.this.kcp = false;
                } else if (ForumListActivity.this.kcr.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.kct) {
                        ForumListActivity.this.kch = 50;
                    } else {
                        ForumListActivity.this.kch = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.kcr.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.kcu) {
                        ForumListActivity.this.kci = 50;
                    } else {
                        ForumListActivity.this.kci = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void IL(String str) {
        e cJO = this.kcr.kdp.cJO();
        if (cJO != null) {
            ArrayList<e> arrayList = cJO.kdW;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).kbT.equals(str)) {
                    this.kcl = i;
                    this.kcr.kdp.Cr(this.kcl);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.kcs.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kcs.menu_name = str;
        this.kcs.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kcs.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.kcs.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.kcs.offset = 0;
        this.kcs.rn = 10;
        this.kcn = this.kcs.recommend_type;
        this.kco = this.kcs.rn;
        this.kcs.recommend_type = 0;
        this.kcs.rn = 200;
        this.kcm = true;
        this.kcy.a(this.kcs);
        this.kcy.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kcI;

        private b() {
            this.kcI = false;
        }

        public void sK(boolean z) {
            this.kcI = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kcr.kdg.setEnabled(false);
            ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kcs.recommend_type = 2;
                ForumListActivity.this.kcs.offset = 0;
                ForumListActivity.this.kcs.rn = ForumListActivity.this.kci;
                return ForumListModel.new_fetch(ForumListActivity.this.kcs);
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
                ForumListActivity.this.kcw.BF(min);
                ForumListActivity.this.kcw.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.kci == 200) {
                    ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kcr.kdi.setImageDrawable(ForumListActivity.this.kcf);
                } else {
                    ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kcr.kdi.setImageDrawable(ForumListActivity.this.kcg);
                    ForumListActivity.this.kcu = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kcI) {
                    if (ForumListActivity.this.kci == 200) {
                        ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kcr.kdi.setImageDrawable(ForumListActivity.this.kcf);
                    } else {
                        ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kcr.kdi.setImageDrawable(ForumListActivity.this.kcg);
                    }
                } else {
                    ForumListActivity.this.kcr.kdh.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kcr.kdi.setImageDrawable(ForumListActivity.this.kcf);
                    ForumListActivity.this.kcs.rn = 200;
                    ForumListActivity.this.kci = 200;
                }
            }
            ForumListActivity.this.kcr.kdg.setEnabled(true);
            ForumListActivity.this.kcr.cKa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kcI;

        private c() {
            this.kcI = false;
        }

        public void sK(boolean z) {
            this.kcI = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kcr.kdd.setEnabled(false);
            ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kcs.recommend_type = 1;
                ForumListActivity.this.kcs.offset = 0;
                ForumListActivity.this.kcs.rn = ForumListActivity.this.kch;
                return ForumListModel.new_fetch(ForumListActivity.this.kcs);
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
                ForumListActivity.this.kcv.BF(min);
                ForumListActivity.this.kcv.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.kch == 200) {
                    ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kcr.kdf.setImageDrawable(ForumListActivity.this.kcf);
                } else {
                    ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kcr.kdf.setImageDrawable(ForumListActivity.this.kcg);
                    ForumListActivity.this.kct = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kcI) {
                    if (ForumListActivity.this.kch == 200) {
                        ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kcr.kdf.setImageDrawable(ForumListActivity.this.kcf);
                    } else {
                        ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kcr.kdf.setImageDrawable(ForumListActivity.this.kcg);
                    }
                } else {
                    ForumListActivity.this.kcr.kde.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kcr.kdf.setImageDrawable(ForumListActivity.this.kcf);
                    ForumListActivity.this.kcs.rn = 200;
                    ForumListActivity.this.kch = 200;
                }
            }
            ForumListActivity.this.kcr.kdd.setEnabled(true);
            ForumListActivity.this.kcr.cKa();
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
        this.kcr = new com.baidu.tieba.square.flist.c(this);
        this.kcr.kcZ = (BdListView) cJQ();
        this.kcr.kda = (BdListView) cJS();
        this.kcr.mProgressBar.setVisibility(0);
        this.kcr.kdq.setOnClickListener(null);
        this.kcr.kdq.setClickable(false);
        this.kcr.mViewPager.setAdapter(new a());
        this.kcr.kcZ.setPullRefresh(this.kcr.kdj);
        this.kcr.kda.setPullRefresh(this.kcr.kdk);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.kcr.kcZ.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.kcr.kda.addHeaderView(textView2, 0);
        this.kcv = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.kcr.kcZ.setAdapter((ListAdapter) this.kcv);
        this.kcw = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.kcr.kda.setAdapter((ListAdapter) this.kcw);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.kcr.aDi.setText(str4);
        this.kcr.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.kcs = new ForumListModel.RequestParams();
        this.kcs.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kcs.menu_name = str4;
        this.kcs.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kcs.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kcs.parent_menu_name = str;
        this.kcs.offset = 0;
        this.kcs.rn = 10;
        if (this.kcs.menu_id != 0) {
            this.kcr.cJZ();
            this.kck = true;
            this.kcq = false;
            this.kcv.m(Boolean.valueOf(this.kcq));
            this.kcr.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.kcq = true;
            this.kcv.m(Boolean.valueOf(this.kcq));
            this.kcr.cJY();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.kcr.kdj.setListPullRefreshListener(this.esD);
        this.kcr.kdk.setListPullRefreshListener(this.esD);
        this.kcv.notifyDataSetChanged();
        this.kcw.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.kcr.cKb();
        } else {
            this.kcx = new DirMenuModel(getPageContext(), str, str3, str2);
            this.kcx.a(this.kcA);
            this.kcx.LoadData();
        }
        this.kcy = new ForumListDetailModel(getPageContext(), this.kcs);
        this.kcy.a(this.kcz);
        this.kcr.kcZ.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (gpa) {
            gpa = false;
            finish();
            b(getPageContext().getPageActivity(), kcC, kcE, kcD, kcF);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.kcv != null) {
                this.kcv.cJW();
                this.kcv.notifyDataSetChanged();
            }
            if (this.kcw != null) {
                this.kcw.cJW();
                this.kcw.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dku != null) {
            this.dku.cKP();
        }
        this.kcr.mViewPager.setAdapter(null);
        this.kcr.kda.setAdapter((ListAdapter) null);
        this.kcr.kcZ.setAdapter((ListAdapter) null);
        if (this.kcr.kdo != null) {
            this.kcr.kdo.setAdapter((ListAdapter) null);
        }
        if (this.kcx != null) {
            this.kcx.cancelLoadData();
        }
        if (this.kcy != null) {
            this.kcy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kcr.gcw);
        this.kcr.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kcv.sL(true);
            this.kcw.sL(true);
        } else {
            this.kcv.sL(false);
            this.kcw.sL(false);
        }
        this.kcv.notifyDataSetChanged();
        this.kcw.notifyDataSetChanged();
        if (this.kcr.kdl != null) {
            this.kcr.kdl.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.kcr.kcW, R.drawable.bg_pop_most);
        this.kbZ = am.getColor(R.color.common_color_10243);
        this.kca = am.getColor(R.color.cp_cont_a);
        this.kcb = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.kcc = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.kcd = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.kce = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.kcf = am.getDrawable(R.drawable.ico_downward);
        this.kcg = am.getDrawable(R.drawable.ico_upward);
        this.kcv.cJ(R.drawable.btn_add_end, R.drawable.btn_add);
        this.kcw.cJ(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kcr.kcV, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kcr.kdh, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.kcr.kcU, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kcr.kde, R.color.common_color_10243, 1);
        if (this.kct) {
            am.setImageResource(this.kcr.kdf, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kcr.kdf, R.drawable.ico_downward);
        }
        if (this.kcu) {
            am.setImageResource(this.kcr.kdi, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kcr.kdi, R.drawable.ico_downward);
        }
        if (this.kcr.mViewPager.getCurrentItem() == 0) {
            this.kcr.kdb.setTextColor(this.kca);
            this.kcr.kdb.setBackgroundDrawable(this.kcd);
            this.kcr.kdc.setBackgroundDrawable(this.kcc);
            this.kcr.kdc.setTextColor(this.kbZ);
            return;
        }
        this.kcr.kdc.setTextColor(this.kca);
        this.kcr.kdc.setBackgroundDrawable(this.kce);
        this.kcr.kdb.setBackgroundDrawable(this.kcb);
        this.kcr.kdb.setTextColor(this.kbZ);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.kcr.mViewPager.setCurrentItem(0);
            this.kcj = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.kcr.mViewPager.setCurrentItem(1);
            this.kcj = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.kcr.d(this.kcB);
        }
    }

    private View cJQ() {
        this.kcr.kcZ = cJU();
        this.kcr.kdd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJR();
            }
        });
        return this.kcr.kcZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJR() {
        if (this.kct) {
            int min = Math.min(this.kcv.getCount(), 200);
            this.kch = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kcv.cJV(), 0, forumInfoDataArr, 0, min);
            this.kcv.BF(min);
            this.kcv.a(forumInfoDataArr);
            this.kct = false;
            this.kcr.kde.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kcr.kdf.setImageDrawable(this.kcf);
            return;
        }
        this.kch = 50;
        c cVar = new c();
        cVar.sK(true);
        cVar.execute(new Void[0]);
    }

    private View cJS() {
        this.kcr.kda = cJU();
        this.kcr.kdg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJT();
            }
        });
        return this.kcr.kda;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJT() {
        if (this.kcu) {
            int min = Math.min(this.kcw.getCount(), 200);
            this.kci = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kcw.cJV(), 0, forumInfoDataArr, 0, min);
            this.kcw.BF(min);
            this.kcw.a(forumInfoDataArr);
            this.kcu = false;
            this.kcr.kdh.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kcr.kdi.setImageDrawable(this.kcf);
            return;
        }
        this.kci = 50;
        b bVar = new b();
        bVar.sK(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cJU() {
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
        if (!this.kck) {
            if (i == 0) {
                this.kcv.cJW();
                this.kcv.notifyDataSetChanged();
                this.kcr.kdb.setBackgroundDrawable(this.kcd);
                this.kcr.kdb.setTextColor(this.kca);
                this.kcr.kdc.setBackgroundDrawable(this.kcc);
                this.kcr.kdc.setTextColor(this.kbZ);
            } else if (i == 1) {
                this.kcw.cJW();
                this.kcw.notifyDataSetChanged();
                this.kcr.kdc.setBackgroundDrawable(this.kce);
                this.kcr.kdc.setTextColor(this.kca);
                this.kcr.kdb.setBackgroundDrawable(this.kcb);
                this.kcr.kdb.setTextColor(this.kbZ);
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
            return ForumListActivity.this.kck ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.kcr.kcZ);
                    return ForumListActivity.this.kcr.kcZ;
                case 1:
                    viewGroup.addView(ForumListActivity.this.kcr.kda);
                    return ForumListActivity.this.kcr.kda;
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
        final ForumInfoData[] cJV;
        if (i == 11002 && i2 == -1) {
            this.kcy.LoadData();
            if (this.kcj == 0) {
                cJV = this.kcv.cJV();
            } else {
                cJV = this.kcw.cJV();
            }
            this.dku.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dku.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dku.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dku.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.kcj == 0) {
                                ForumListActivity.this.kcv.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJV[ForumListActivity.this.kcv.kcJ].forum_name);
                            } else if (ForumListActivity.this.kcj == 1) {
                                ForumListActivity.this.kcw.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJV[ForumListActivity.this.kcw.kcJ].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.kcj == 0) {
                this.dku.eA(cJV[this.kcv.kcJ].forum_name, String.valueOf(cJV[this.kcv.kcJ].forum_id));
            } else {
                this.dku.eA(cJV[this.kcw.kcJ].forum_name, String.valueOf(cJV[this.kcw.kcJ].forum_id));
            }
        }
    }
}
