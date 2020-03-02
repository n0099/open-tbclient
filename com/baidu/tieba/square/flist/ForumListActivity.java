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
    public static boolean god = false;
    private static String kaO = "";
    private static String kaP = "";
    private static String kaQ = "";
    private static String kaR = "";
    public com.baidu.tieba.square.flist.c kaD;
    private ForumListModel.RequestParams kaE;
    private com.baidu.tieba.square.flist.b kaH;
    private com.baidu.tieba.square.flist.b kaI;
    private DirMenuModel kaJ;
    private ForumListDetailModel kaK;
    private int kak;
    private int kal;
    private Drawable kam;
    private Drawable kan;
    private Drawable kao;
    private Drawable kap;
    private Drawable kaq;
    private Drawable kar;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int kas = 200;
    private int kat = 200;
    private int kau = 0;
    private final LikeModel djU = new LikeModel(getPageContext());
    private boolean kaw = false;
    private int kax = 0;
    private boolean kay = false;
    private int kaz = 0;
    private int kaA = 200;
    private boolean kaB = true;
    private boolean kaC = true;
    private boolean kaF = false;
    private boolean kaG = false;
    private final ForumListDetailModel.a kaL = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.kaH.cJA() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.kaD.cJG();
                ForumListActivity.this.kaD.cJF();
                if (ForumListActivity.this.kaE.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.kaD.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.kaE.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.kaD.cJF();
                    ForumListActivity.this.kaE.recommend_type = ForumListActivity.this.kaz;
                    ForumListActivity.this.kaE.rn = ForumListActivity.this.kaA;
                }
                ForumListActivity.this.kaD.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.kaD.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.kay) {
                    ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaD.kbr.setImageDrawable(ForumListActivity.this.kaq);
                    ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaD.kbu.setImageDrawable(ForumListActivity.this.kaq);
                    ForumListActivity.this.kay = false;
                }
                ForumListActivity.this.kaD.aCT.setText(ForumListActivity.this.kaE.menu_name);
                ForumListActivity.this.kaD.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kaD.kbB.Cj(ForumListActivity.this.kax);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.kaH.Bx(min);
                ForumListActivity.this.kaH.a(ForumListActivity.this.djU);
                ForumListActivity.this.kaH.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.kaD.kbl.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.kaD.kbg.setVisibility(0);
                } else {
                    ForumListActivity.this.kaD.kbg.setVisibility(8);
                }
                ForumListActivity.this.kaD.kbn.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.kaI.Bx(min2);
                ForumListActivity.this.kaI.a(ForumListActivity.this.djU);
                ForumListActivity.this.kaI.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.kaD.kbm.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.kaD.kbh.setVisibility(0);
                } else {
                    ForumListActivity.this.kaD.kbh.setVisibility(8);
                }
                ForumListActivity.this.kaD.kbo.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.kaD.cJF();
                if (ForumListActivity.this.kaD.kbB.getCount() > 0) {
                    ForumListActivity.this.kaD.kbC.setClickable(true);
                    ForumListActivity.this.kaD.kbC.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b kaM = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.kaD.cJG();
                    return;
                }
                return;
            }
            eVar.kci.add(0, eVar);
            if (ForumListActivity.this.kaD.kbB != null) {
                ForumListActivity.this.kaD.kbB.a(eVar);
                ForumListActivity.this.IL(String.valueOf(ForumListActivity.this.kaD.aCT.getText()));
                ForumListActivity.this.kaD.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kaD.kbB.notifyDataSetChanged();
            }
            ForumListActivity.this.kaD.kbC.setClickable(true);
            ForumListActivity.this.kaD.kbC.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener kaN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.kaD.kbx, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.kax = i;
            ForumListActivity.this.kaD.cJG();
            ForumListActivity.this.kaD.cJH();
            ArrayList<e> arrayList = ForumListActivity.this.kaD.kbB.cJt().kci;
            ForumListActivity.this.at(arrayList.get(i).kae, arrayList.get(i).kag, arrayList.get(i).kaf);
        }
    };
    private final g.c erU = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.kaH.cJC() && !ForumListActivity.this.kaI.cJC()) {
                if (ForumListActivity.this.kaB) {
                    ForumListActivity.this.kaE.recommend_type = 0;
                    ForumListActivity.this.kaE.rn = 200;
                    ForumListActivity.this.kaK.a(ForumListActivity.this.kaE);
                    ForumListActivity.this.kaK.LoadData();
                    ForumListActivity.this.kaB = false;
                } else if (ForumListActivity.this.kaD.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.kaF) {
                        ForumListActivity.this.kas = 50;
                    } else {
                        ForumListActivity.this.kas = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.kaD.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.kaG) {
                        ForumListActivity.this.kat = 50;
                    } else {
                        ForumListActivity.this.kat = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void IL(String str) {
        e cJt = this.kaD.kbB.cJt();
        if (cJt != null) {
            ArrayList<e> arrayList = cJt.kci;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).kae.equals(str)) {
                    this.kax = i;
                    this.kaD.kbB.Cj(this.kax);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.kaE.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaE.menu_name = str;
        this.kaE.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kaE.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.kaE.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.kaE.offset = 0;
        this.kaE.rn = 10;
        this.kaz = this.kaE.recommend_type;
        this.kaA = this.kaE.rn;
        this.kaE.recommend_type = 0;
        this.kaE.rn = 200;
        this.kay = true;
        this.kaK.a(this.kaE);
        this.kaK.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kaU;

        private b() {
            this.kaU = false;
        }

        public void sE(boolean z) {
            this.kaU = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kaD.kbs.setEnabled(false);
            ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kaE.recommend_type = 2;
                ForumListActivity.this.kaE.offset = 0;
                ForumListActivity.this.kaE.rn = ForumListActivity.this.kat;
                return ForumListModel.new_fetch(ForumListActivity.this.kaE);
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
                ForumListActivity.this.kaI.Bx(min);
                ForumListActivity.this.kaI.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.kat == 200) {
                    ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaD.kbu.setImageDrawable(ForumListActivity.this.kaq);
                } else {
                    ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kaD.kbu.setImageDrawable(ForumListActivity.this.kar);
                    ForumListActivity.this.kaG = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kaU) {
                    if (ForumListActivity.this.kat == 200) {
                        ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kaD.kbu.setImageDrawable(ForumListActivity.this.kaq);
                    } else {
                        ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kaD.kbu.setImageDrawable(ForumListActivity.this.kar);
                    }
                } else {
                    ForumListActivity.this.kaD.kbt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaD.kbu.setImageDrawable(ForumListActivity.this.kaq);
                    ForumListActivity.this.kaE.rn = 200;
                    ForumListActivity.this.kat = 200;
                }
            }
            ForumListActivity.this.kaD.kbs.setEnabled(true);
            ForumListActivity.this.kaD.cJF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kaU;

        private c() {
            this.kaU = false;
        }

        public void sE(boolean z) {
            this.kaU = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kaD.kbp.setEnabled(false);
            ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kaE.recommend_type = 1;
                ForumListActivity.this.kaE.offset = 0;
                ForumListActivity.this.kaE.rn = ForumListActivity.this.kas;
                return ForumListModel.new_fetch(ForumListActivity.this.kaE);
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
                ForumListActivity.this.kaH.Bx(min);
                ForumListActivity.this.kaH.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.kas == 200) {
                    ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaD.kbr.setImageDrawable(ForumListActivity.this.kaq);
                } else {
                    ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kaD.kbr.setImageDrawable(ForumListActivity.this.kar);
                    ForumListActivity.this.kaF = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kaU) {
                    if (ForumListActivity.this.kas == 200) {
                        ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kaD.kbr.setImageDrawable(ForumListActivity.this.kaq);
                    } else {
                        ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kaD.kbr.setImageDrawable(ForumListActivity.this.kar);
                    }
                } else {
                    ForumListActivity.this.kaD.kbq.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaD.kbr.setImageDrawable(ForumListActivity.this.kaq);
                    ForumListActivity.this.kaE.rn = 200;
                    ForumListActivity.this.kas = 200;
                }
            }
            ForumListActivity.this.kaD.kbp.setEnabled(true);
            ForumListActivity.this.kaD.cJF();
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
        this.kaD = new com.baidu.tieba.square.flist.c(this);
        this.kaD.kbl = (BdListView) cJv();
        this.kaD.kbm = (BdListView) cJx();
        this.kaD.mProgressBar.setVisibility(0);
        this.kaD.kbC.setOnClickListener(null);
        this.kaD.kbC.setClickable(false);
        this.kaD.mViewPager.setAdapter(new a());
        this.kaD.kbl.setPullRefresh(this.kaD.kbv);
        this.kaD.kbm.setPullRefresh(this.kaD.kbw);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.kaD.kbl.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.kaD.kbm.addHeaderView(textView2, 0);
        this.kaH = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.kaD.kbl.setAdapter((ListAdapter) this.kaH);
        this.kaI = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.kaD.kbm.setAdapter((ListAdapter) this.kaI);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.kaD.aCT.setText(str4);
        this.kaD.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.kaE = new ForumListModel.RequestParams();
        this.kaE.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaE.menu_name = str4;
        this.kaE.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kaE.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaE.parent_menu_name = str;
        this.kaE.offset = 0;
        this.kaE.rn = 10;
        if (this.kaE.menu_id != 0) {
            this.kaD.cJE();
            this.kaw = true;
            this.kaC = false;
            this.kaH.m(Boolean.valueOf(this.kaC));
            this.kaD.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.kaC = true;
            this.kaH.m(Boolean.valueOf(this.kaC));
            this.kaD.cJD();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.kaD.kbv.setListPullRefreshListener(this.erU);
        this.kaD.kbw.setListPullRefreshListener(this.erU);
        this.kaH.notifyDataSetChanged();
        this.kaI.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.kaD.cJG();
        } else {
            this.kaJ = new DirMenuModel(getPageContext(), str, str3, str2);
            this.kaJ.a(this.kaM);
            this.kaJ.LoadData();
        }
        this.kaK = new ForumListDetailModel(getPageContext(), this.kaE);
        this.kaK.a(this.kaL);
        this.kaD.kbl.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (god) {
            god = false;
            finish();
            b(getPageContext().getPageActivity(), kaO, kaQ, kaP, kaR);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.kaH != null) {
                this.kaH.cJB();
                this.kaH.notifyDataSetChanged();
            }
            if (this.kaI != null) {
                this.kaI.cJB();
                this.kaI.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.djU != null) {
            this.djU.cKu();
        }
        this.kaD.mViewPager.setAdapter(null);
        this.kaD.kbm.setAdapter((ListAdapter) null);
        this.kaD.kbl.setAdapter((ListAdapter) null);
        if (this.kaD.kbA != null) {
            this.kaD.kbA.setAdapter((ListAdapter) null);
        }
        if (this.kaJ != null) {
            this.kaJ.cancelLoadData();
        }
        if (this.kaK != null) {
            this.kaK.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kaD.gbA);
        this.kaD.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kaH.sF(true);
            this.kaI.sF(true);
        } else {
            this.kaH.sF(false);
            this.kaI.sF(false);
        }
        this.kaH.notifyDataSetChanged();
        this.kaI.notifyDataSetChanged();
        if (this.kaD.kbx != null) {
            this.kaD.kbx.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.kaD.kbi, R.drawable.bg_pop_most);
        this.kak = am.getColor(R.color.common_color_10243);
        this.kal = am.getColor(R.color.cp_cont_a);
        this.kam = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.kan = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.kao = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.kap = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.kaq = am.getDrawable(R.drawable.ico_downward);
        this.kar = am.getDrawable(R.drawable.ico_upward);
        this.kaH.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        this.kaI.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kaD.kbh, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kaD.kbt, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.kaD.kbg, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kaD.kbq, R.color.common_color_10243, 1);
        if (this.kaF) {
            am.setImageResource(this.kaD.kbr, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kaD.kbr, R.drawable.ico_downward);
        }
        if (this.kaG) {
            am.setImageResource(this.kaD.kbu, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kaD.kbu, R.drawable.ico_downward);
        }
        if (this.kaD.mViewPager.getCurrentItem() == 0) {
            this.kaD.kbn.setTextColor(this.kal);
            this.kaD.kbn.setBackgroundDrawable(this.kao);
            this.kaD.kbo.setBackgroundDrawable(this.kan);
            this.kaD.kbo.setTextColor(this.kak);
            return;
        }
        this.kaD.kbo.setTextColor(this.kal);
        this.kaD.kbo.setBackgroundDrawable(this.kap);
        this.kaD.kbn.setBackgroundDrawable(this.kam);
        this.kaD.kbn.setTextColor(this.kak);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.kaD.mViewPager.setCurrentItem(0);
            this.kau = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.kaD.mViewPager.setCurrentItem(1);
            this.kau = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.kaD.d(this.kaN);
        }
    }

    private View cJv() {
        this.kaD.kbl = cJz();
        this.kaD.kbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJw();
            }
        });
        return this.kaD.kbl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJw() {
        if (this.kaF) {
            int min = Math.min(this.kaH.getCount(), 200);
            this.kas = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kaH.cJA(), 0, forumInfoDataArr, 0, min);
            this.kaH.Bx(min);
            this.kaH.a(forumInfoDataArr);
            this.kaF = false;
            this.kaD.kbq.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kaD.kbr.setImageDrawable(this.kaq);
            return;
        }
        this.kas = 50;
        c cVar = new c();
        cVar.sE(true);
        cVar.execute(new Void[0]);
    }

    private View cJx() {
        this.kaD.kbm = cJz();
        this.kaD.kbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJy();
            }
        });
        return this.kaD.kbm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJy() {
        if (this.kaG) {
            int min = Math.min(this.kaI.getCount(), 200);
            this.kat = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kaI.cJA(), 0, forumInfoDataArr, 0, min);
            this.kaI.Bx(min);
            this.kaI.a(forumInfoDataArr);
            this.kaG = false;
            this.kaD.kbt.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kaD.kbu.setImageDrawable(this.kaq);
            return;
        }
        this.kat = 50;
        b bVar = new b();
        bVar.sE(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cJz() {
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
        if (!this.kaw) {
            if (i == 0) {
                this.kaH.cJB();
                this.kaH.notifyDataSetChanged();
                this.kaD.kbn.setBackgroundDrawable(this.kao);
                this.kaD.kbn.setTextColor(this.kal);
                this.kaD.kbo.setBackgroundDrawable(this.kan);
                this.kaD.kbo.setTextColor(this.kak);
            } else if (i == 1) {
                this.kaI.cJB();
                this.kaI.notifyDataSetChanged();
                this.kaD.kbo.setBackgroundDrawable(this.kap);
                this.kaD.kbo.setTextColor(this.kal);
                this.kaD.kbn.setBackgroundDrawable(this.kam);
                this.kaD.kbn.setTextColor(this.kak);
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
            return ForumListActivity.this.kaw ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.kaD.kbl);
                    return ForumListActivity.this.kaD.kbl;
                case 1:
                    viewGroup.addView(ForumListActivity.this.kaD.kbm);
                    return ForumListActivity.this.kaD.kbm;
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
        final ForumInfoData[] cJA;
        if (i == 11002 && i2 == -1) {
            this.kaK.LoadData();
            if (this.kau == 0) {
                cJA = this.kaH.cJA();
            } else {
                cJA = this.kaI.cJA();
            }
            this.djU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.djU.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.djU.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.djU.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.kau == 0) {
                                ForumListActivity.this.kaH.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJA[ForumListActivity.this.kaH.kaV].forum_name);
                            } else if (ForumListActivity.this.kau == 1) {
                                ForumListActivity.this.kaI.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJA[ForumListActivity.this.kaI.kaV].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.kau == 0) {
                this.djU.eC(cJA[this.kaH.kaV].forum_name, String.valueOf(cJA[this.kaH.kaV].forum_id));
            } else {
                this.djU.eC(cJA[this.kaI.kaV].forum_name, String.valueOf(cJA[this.kaI.kaV].forum_id));
            }
        }
    }
}
