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
/* loaded from: classes10.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean gob = false;
    private static String kaM = "";
    private static String kaN = "";
    private static String kaO = "";
    private static String kaP = "";
    public com.baidu.tieba.square.flist.c kaB;
    private ForumListModel.RequestParams kaC;
    private com.baidu.tieba.square.flist.b kaF;
    private com.baidu.tieba.square.flist.b kaG;
    private DirMenuModel kaH;
    private ForumListDetailModel kaI;
    private int kai;
    private int kaj;
    private Drawable kak;
    private Drawable kal;
    private Drawable kam;
    private Drawable kan;
    private Drawable kao;
    private Drawable kap;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int kaq = 200;
    private int kar = 200;
    private int kas = 0;
    private final LikeModel djT = new LikeModel(getPageContext());
    private boolean kat = false;
    private int kau = 0;
    private boolean kaw = false;
    private int kax = 0;
    private int kay = 200;
    private boolean kaz = true;
    private boolean kaA = true;
    private boolean kaD = false;
    private boolean kaE = false;
    private final ForumListDetailModel.a kaJ = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.kaF.cJy() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.kaB.cJE();
                ForumListActivity.this.kaB.cJD();
                if (ForumListActivity.this.kaC.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.kaB.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.kaC.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.kaB.cJD();
                    ForumListActivity.this.kaC.recommend_type = ForumListActivity.this.kax;
                    ForumListActivity.this.kaC.rn = ForumListActivity.this.kay;
                }
                ForumListActivity.this.kaB.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.kaB.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.kaw) {
                    ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaB.kbp.setImageDrawable(ForumListActivity.this.kao);
                    ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaB.kbs.setImageDrawable(ForumListActivity.this.kao);
                    ForumListActivity.this.kaw = false;
                }
                ForumListActivity.this.kaB.aCS.setText(ForumListActivity.this.kaC.menu_name);
                ForumListActivity.this.kaB.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kaB.kbz.Cj(ForumListActivity.this.kau);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.kaF.Bx(min);
                ForumListActivity.this.kaF.a(ForumListActivity.this.djT);
                ForumListActivity.this.kaF.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.kaB.kbj.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.kaB.kbe.setVisibility(0);
                } else {
                    ForumListActivity.this.kaB.kbe.setVisibility(8);
                }
                ForumListActivity.this.kaB.kbl.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.kaG.Bx(min2);
                ForumListActivity.this.kaG.a(ForumListActivity.this.djT);
                ForumListActivity.this.kaG.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.kaB.kbk.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.kaB.kbf.setVisibility(0);
                } else {
                    ForumListActivity.this.kaB.kbf.setVisibility(8);
                }
                ForumListActivity.this.kaB.kbm.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.kaB.cJD();
                if (ForumListActivity.this.kaB.kbz.getCount() > 0) {
                    ForumListActivity.this.kaB.kbA.setClickable(true);
                    ForumListActivity.this.kaB.kbA.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b kaK = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.kaB.cJE();
                    return;
                }
                return;
            }
            eVar.kcg.add(0, eVar);
            if (ForumListActivity.this.kaB.kbz != null) {
                ForumListActivity.this.kaB.kbz.a(eVar);
                ForumListActivity.this.IL(String.valueOf(ForumListActivity.this.kaB.aCS.getText()));
                ForumListActivity.this.kaB.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kaB.kbz.notifyDataSetChanged();
            }
            ForumListActivity.this.kaB.kbA.setClickable(true);
            ForumListActivity.this.kaB.kbA.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener kaL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.kaB.kbv, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.kau = i;
            ForumListActivity.this.kaB.cJE();
            ForumListActivity.this.kaB.cJF();
            ArrayList<e> arrayList = ForumListActivity.this.kaB.kbz.cJr().kcg;
            ForumListActivity.this.at(arrayList.get(i).kac, arrayList.get(i).kae, arrayList.get(i).kad);
        }
    };
    private final g.c erT = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.kaF.cJA() && !ForumListActivity.this.kaG.cJA()) {
                if (ForumListActivity.this.kaz) {
                    ForumListActivity.this.kaC.recommend_type = 0;
                    ForumListActivity.this.kaC.rn = 200;
                    ForumListActivity.this.kaI.a(ForumListActivity.this.kaC);
                    ForumListActivity.this.kaI.LoadData();
                    ForumListActivity.this.kaz = false;
                } else if (ForumListActivity.this.kaB.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.kaD) {
                        ForumListActivity.this.kaq = 50;
                    } else {
                        ForumListActivity.this.kaq = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.kaB.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.kaE) {
                        ForumListActivity.this.kar = 50;
                    } else {
                        ForumListActivity.this.kar = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void IL(String str) {
        e cJr = this.kaB.kbz.cJr();
        if (cJr != null) {
            ArrayList<e> arrayList = cJr.kcg;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).kac.equals(str)) {
                    this.kau = i;
                    this.kaB.kbz.Cj(this.kau);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.kaC.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaC.menu_name = str;
        this.kaC.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kaC.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.kaC.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.kaC.offset = 0;
        this.kaC.rn = 10;
        this.kax = this.kaC.recommend_type;
        this.kay = this.kaC.rn;
        this.kaC.recommend_type = 0;
        this.kaC.rn = 200;
        this.kaw = true;
        this.kaI.a(this.kaC);
        this.kaI.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kaS;

        private b() {
            this.kaS = false;
        }

        public void sE(boolean z) {
            this.kaS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kaB.kbq.setEnabled(false);
            ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kaC.recommend_type = 2;
                ForumListActivity.this.kaC.offset = 0;
                ForumListActivity.this.kaC.rn = ForumListActivity.this.kar;
                return ForumListModel.new_fetch(ForumListActivity.this.kaC);
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
                ForumListActivity.this.kaG.Bx(min);
                ForumListActivity.this.kaG.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.kar == 200) {
                    ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaB.kbs.setImageDrawable(ForumListActivity.this.kao);
                } else {
                    ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kaB.kbs.setImageDrawable(ForumListActivity.this.kap);
                    ForumListActivity.this.kaE = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kaS) {
                    if (ForumListActivity.this.kar == 200) {
                        ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kaB.kbs.setImageDrawable(ForumListActivity.this.kao);
                    } else {
                        ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kaB.kbs.setImageDrawable(ForumListActivity.this.kap);
                    }
                } else {
                    ForumListActivity.this.kaB.kbr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaB.kbs.setImageDrawable(ForumListActivity.this.kao);
                    ForumListActivity.this.kaC.rn = 200;
                    ForumListActivity.this.kar = 200;
                }
            }
            ForumListActivity.this.kaB.kbq.setEnabled(true);
            ForumListActivity.this.kaB.cJD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kaS;

        private c() {
            this.kaS = false;
        }

        public void sE(boolean z) {
            this.kaS = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kaB.kbn.setEnabled(false);
            ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kaC.recommend_type = 1;
                ForumListActivity.this.kaC.offset = 0;
                ForumListActivity.this.kaC.rn = ForumListActivity.this.kaq;
                return ForumListModel.new_fetch(ForumListActivity.this.kaC);
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
                ForumListActivity.this.kaF.Bx(min);
                ForumListActivity.this.kaF.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.kaq == 200) {
                    ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaB.kbp.setImageDrawable(ForumListActivity.this.kao);
                } else {
                    ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kaB.kbp.setImageDrawable(ForumListActivity.this.kap);
                    ForumListActivity.this.kaD = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kaS) {
                    if (ForumListActivity.this.kaq == 200) {
                        ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kaB.kbp.setImageDrawable(ForumListActivity.this.kao);
                    } else {
                        ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kaB.kbp.setImageDrawable(ForumListActivity.this.kap);
                    }
                } else {
                    ForumListActivity.this.kaB.kbo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaB.kbp.setImageDrawable(ForumListActivity.this.kao);
                    ForumListActivity.this.kaC.rn = 200;
                    ForumListActivity.this.kaq = 200;
                }
            }
            ForumListActivity.this.kaB.kbn.setEnabled(true);
            ForumListActivity.this.kaB.cJD();
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
        this.kaB = new com.baidu.tieba.square.flist.c(this);
        this.kaB.kbj = (BdListView) cJt();
        this.kaB.kbk = (BdListView) cJv();
        this.kaB.mProgressBar.setVisibility(0);
        this.kaB.kbA.setOnClickListener(null);
        this.kaB.kbA.setClickable(false);
        this.kaB.mViewPager.setAdapter(new a());
        this.kaB.kbj.setPullRefresh(this.kaB.kbt);
        this.kaB.kbk.setPullRefresh(this.kaB.kbu);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.kaB.kbj.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.kaB.kbk.addHeaderView(textView2, 0);
        this.kaF = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.kaB.kbj.setAdapter((ListAdapter) this.kaF);
        this.kaG = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.kaB.kbk.setAdapter((ListAdapter) this.kaG);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.kaB.aCS.setText(str4);
        this.kaB.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.kaC = new ForumListModel.RequestParams();
        this.kaC.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaC.menu_name = str4;
        this.kaC.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kaC.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaC.parent_menu_name = str;
        this.kaC.offset = 0;
        this.kaC.rn = 10;
        if (this.kaC.menu_id != 0) {
            this.kaB.cJC();
            this.kat = true;
            this.kaA = false;
            this.kaF.m(Boolean.valueOf(this.kaA));
            this.kaB.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.kaA = true;
            this.kaF.m(Boolean.valueOf(this.kaA));
            this.kaB.cJB();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.kaB.kbt.setListPullRefreshListener(this.erT);
        this.kaB.kbu.setListPullRefreshListener(this.erT);
        this.kaF.notifyDataSetChanged();
        this.kaG.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.kaB.cJE();
        } else {
            this.kaH = new DirMenuModel(getPageContext(), str, str3, str2);
            this.kaH.a(this.kaK);
            this.kaH.LoadData();
        }
        this.kaI = new ForumListDetailModel(getPageContext(), this.kaC);
        this.kaI.a(this.kaJ);
        this.kaB.kbj.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (gob) {
            gob = false;
            finish();
            b(getPageContext().getPageActivity(), kaM, kaO, kaN, kaP);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.kaF != null) {
                this.kaF.cJz();
                this.kaF.notifyDataSetChanged();
            }
            if (this.kaG != null) {
                this.kaG.cJz();
                this.kaG.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.djT != null) {
            this.djT.cKs();
        }
        this.kaB.mViewPager.setAdapter(null);
        this.kaB.kbk.setAdapter((ListAdapter) null);
        this.kaB.kbj.setAdapter((ListAdapter) null);
        if (this.kaB.kby != null) {
            this.kaB.kby.setAdapter((ListAdapter) null);
        }
        if (this.kaH != null) {
            this.kaH.cancelLoadData();
        }
        if (this.kaI != null) {
            this.kaI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kaB.gby);
        this.kaB.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kaF.sF(true);
            this.kaG.sF(true);
        } else {
            this.kaF.sF(false);
            this.kaG.sF(false);
        }
        this.kaF.notifyDataSetChanged();
        this.kaG.notifyDataSetChanged();
        if (this.kaB.kbv != null) {
            this.kaB.kbv.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.kaB.kbg, R.drawable.bg_pop_most);
        this.kai = am.getColor(R.color.common_color_10243);
        this.kaj = am.getColor(R.color.cp_cont_a);
        this.kak = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.kal = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.kam = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.kan = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.kao = am.getDrawable(R.drawable.ico_downward);
        this.kap = am.getDrawable(R.drawable.ico_upward);
        this.kaF.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        this.kaG.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kaB.kbf, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kaB.kbr, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.kaB.kbe, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kaB.kbo, R.color.common_color_10243, 1);
        if (this.kaD) {
            am.setImageResource(this.kaB.kbp, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kaB.kbp, R.drawable.ico_downward);
        }
        if (this.kaE) {
            am.setImageResource(this.kaB.kbs, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kaB.kbs, R.drawable.ico_downward);
        }
        if (this.kaB.mViewPager.getCurrentItem() == 0) {
            this.kaB.kbl.setTextColor(this.kaj);
            this.kaB.kbl.setBackgroundDrawable(this.kam);
            this.kaB.kbm.setBackgroundDrawable(this.kal);
            this.kaB.kbm.setTextColor(this.kai);
            return;
        }
        this.kaB.kbm.setTextColor(this.kaj);
        this.kaB.kbm.setBackgroundDrawable(this.kan);
        this.kaB.kbl.setBackgroundDrawable(this.kak);
        this.kaB.kbl.setTextColor(this.kai);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.kaB.mViewPager.setCurrentItem(0);
            this.kas = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.kaB.mViewPager.setCurrentItem(1);
            this.kas = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.kaB.d(this.kaL);
        }
    }

    private View cJt() {
        this.kaB.kbj = cJx();
        this.kaB.kbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJu();
            }
        });
        return this.kaB.kbj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJu() {
        if (this.kaD) {
            int min = Math.min(this.kaF.getCount(), 200);
            this.kaq = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kaF.cJy(), 0, forumInfoDataArr, 0, min);
            this.kaF.Bx(min);
            this.kaF.a(forumInfoDataArr);
            this.kaD = false;
            this.kaB.kbo.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kaB.kbp.setImageDrawable(this.kao);
            return;
        }
        this.kaq = 50;
        c cVar = new c();
        cVar.sE(true);
        cVar.execute(new Void[0]);
    }

    private View cJv() {
        this.kaB.kbk = cJx();
        this.kaB.kbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJw();
            }
        });
        return this.kaB.kbk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJw() {
        if (this.kaE) {
            int min = Math.min(this.kaG.getCount(), 200);
            this.kar = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kaG.cJy(), 0, forumInfoDataArr, 0, min);
            this.kaG.Bx(min);
            this.kaG.a(forumInfoDataArr);
            this.kaE = false;
            this.kaB.kbr.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kaB.kbs.setImageDrawable(this.kao);
            return;
        }
        this.kar = 50;
        b bVar = new b();
        bVar.sE(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cJx() {
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
        if (!this.kat) {
            if (i == 0) {
                this.kaF.cJz();
                this.kaF.notifyDataSetChanged();
                this.kaB.kbl.setBackgroundDrawable(this.kam);
                this.kaB.kbl.setTextColor(this.kaj);
                this.kaB.kbm.setBackgroundDrawable(this.kal);
                this.kaB.kbm.setTextColor(this.kai);
            } else if (i == 1) {
                this.kaG.cJz();
                this.kaG.notifyDataSetChanged();
                this.kaB.kbm.setBackgroundDrawable(this.kan);
                this.kaB.kbm.setTextColor(this.kaj);
                this.kaB.kbl.setBackgroundDrawable(this.kak);
                this.kaB.kbl.setTextColor(this.kai);
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
            return ForumListActivity.this.kat ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.kaB.kbj);
                    return ForumListActivity.this.kaB.kbj;
                case 1:
                    viewGroup.addView(ForumListActivity.this.kaB.kbk);
                    return ForumListActivity.this.kaB.kbk;
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
        final ForumInfoData[] cJy;
        if (i == 11002 && i2 == -1) {
            this.kaI.LoadData();
            if (this.kas == 0) {
                cJy = this.kaF.cJy();
            } else {
                cJy = this.kaG.cJy();
            }
            this.djT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.djT.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.djT.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.djT.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.kas == 0) {
                                ForumListActivity.this.kaF.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJy[ForumListActivity.this.kaF.kaT].forum_name);
                            } else if (ForumListActivity.this.kas == 1) {
                                ForumListActivity.this.kaG.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJy[ForumListActivity.this.kaG.kaT].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.kas == 0) {
                this.djT.eC(cJy[this.kaF.kaT].forum_name, String.valueOf(cJy[this.kaF.kaT].forum_id));
            } else {
                this.djT.eC(cJy[this.kaG.kaT].forum_name, String.valueOf(cJy[this.kaG.kaT].forum_id));
            }
        }
    }
}
