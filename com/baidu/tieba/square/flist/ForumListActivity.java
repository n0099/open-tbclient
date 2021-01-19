package com.baidu.tieba.square.flist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean jas = false;
    private static String ngR = "";
    private static String ngS = "";
    private static String ngT = "";
    private static String ngU = "";
    public com.baidu.tieba.square.flist.c ngG;
    private ForumListModel.RequestParams ngH;
    private com.baidu.tieba.square.flist.b ngK;
    private com.baidu.tieba.square.flist.b ngL;
    private DirMenuModel ngM;
    private ForumListDetailModel ngN;
    private int ngp;
    private int ngq;
    private Drawable ngr;
    private Drawable ngs;
    private Drawable ngt;
    private Drawable ngu;
    private Drawable ngv;
    private Drawable ngw;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int ngx = 200;
    private int ngy = 200;
    private int ngz = 0;
    private final LikeModel fle = new LikeModel(getPageContext());
    private boolean ngA = false;
    private int menu_choose = 0;
    private boolean ngB = false;
    private int ngC = 0;
    private int ngD = 200;
    private boolean ngE = true;
    private boolean ngF = true;
    private boolean ngI = false;
    private boolean ngJ = false;
    private final ForumListDetailModel.a ngO = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.ngK.dJF() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.ngG.dJL();
                ForumListActivity.this.ngG.dJK();
                if (ForumListActivity.this.ngH.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.ngG.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.ngH.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.ngG.dJK();
                    ForumListActivity.this.ngH.recommend_type = ForumListActivity.this.ngC;
                    ForumListActivity.this.ngH.rn = ForumListActivity.this.ngD;
                }
                ForumListActivity.this.ngG.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.ngG.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.ngB) {
                    ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.ngG.nhu.setImageDrawable(ForumListActivity.this.ngv);
                    ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.ngG.nhx.setImageDrawable(ForumListActivity.this.ngv);
                    ForumListActivity.this.ngB = false;
                }
                ForumListActivity.this.ngG.bIw.setText(ForumListActivity.this.ngH.menu_name);
                ForumListActivity.this.ngG.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.ngG.nhE.IU(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.ngK.Ie(min);
                ForumListActivity.this.ngK.a(ForumListActivity.this.fle);
                ForumListActivity.this.ngK.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.ngG.nho.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.ngG.nhj.setVisibility(0);
                } else {
                    ForumListActivity.this.ngG.nhj.setVisibility(8);
                }
                ForumListActivity.this.ngG.nhq.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.ngL.Ie(min2);
                ForumListActivity.this.ngL.a(ForumListActivity.this.fle);
                ForumListActivity.this.ngL.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.ngG.nhp.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.ngG.nhk.setVisibility(0);
                } else {
                    ForumListActivity.this.ngG.nhk.setVisibility(8);
                }
                ForumListActivity.this.ngG.nhr.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.ngG.dJK();
                if (ForumListActivity.this.ngG.nhE.getCount() > 0) {
                    ForumListActivity.this.ngG.nhF.setClickable(true);
                    ForumListActivity.this.ngG.nhF.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b ngP = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.ngG.dJL();
                    return;
                }
                return;
            }
            eVar.niq.add(0, eVar);
            if (ForumListActivity.this.ngG.nhE != null) {
                ForumListActivity.this.ngG.nhE.a(eVar);
                ForumListActivity.this.RM(String.valueOf(ForumListActivity.this.ngG.bIw.getText()));
                ForumListActivity.this.ngG.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.ngG.nhE.notifyDataSetChanged();
            }
            ForumListActivity.this.ngG.nhF.setClickable(true);
            ForumListActivity.this.ngG.nhF.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener ngQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.ngG.nhA, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.ngG.dJL();
            ForumListActivity.this.ngG.dJM();
            ArrayList<e> arrayList = ForumListActivity.this.ngG.nhE.dJy().niq;
            ForumListActivity.this.aM(arrayList.get(i).ngj, arrayList.get(i).ngl, arrayList.get(i).ngk);
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.ngK.dJH() && !ForumListActivity.this.ngL.dJH()) {
                if (ForumListActivity.this.ngE) {
                    ForumListActivity.this.ngH.recommend_type = 0;
                    ForumListActivity.this.ngH.rn = 200;
                    ForumListActivity.this.ngN.a(ForumListActivity.this.ngH);
                    ForumListActivity.this.ngN.LoadData();
                    ForumListActivity.this.ngE = false;
                } else if (ForumListActivity.this.ngG.Zi.getCurrentItem() == 0) {
                    if (ForumListActivity.this.ngI) {
                        ForumListActivity.this.ngx = 50;
                    } else {
                        ForumListActivity.this.ngx = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.ngG.Zi.getCurrentItem() == 1) {
                    if (ForumListActivity.this.ngJ) {
                        ForumListActivity.this.ngy = 50;
                    } else {
                        ForumListActivity.this.ngy = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void RM(String str) {
        e dJy = this.ngG.nhE.dJy();
        if (dJy != null) {
            ArrayList<e> arrayList = dJy.niq;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).ngj.equals(str)) {
                    this.menu_choose = i;
                    this.ngG.nhE.IU(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(String str, String str2, String str3) {
        this.ngH.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.ngH.menu_name = str;
        this.ngH.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.ngH.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.ngH.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.ngH.offset = 0;
        this.ngH.rn = 10;
        this.ngC = this.ngH.recommend_type;
        this.ngD = this.ngH.rn;
        this.ngH.recommend_type = 0;
        this.ngH.rn = 200;
        this.ngB = true;
        this.ngN.a(this.ngH);
        this.ngN.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean ngX;

        private b() {
            this.ngX = false;
        }

        public void xQ(boolean z) {
            this.ngX = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.ngG.nhv.setEnabled(false);
            ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.ngH.recommend_type = 2;
                ForumListActivity.this.ngH.offset = 0;
                ForumListActivity.this.ngH.rn = ForumListActivity.this.ngy;
                return ForumListModel.new_fetch(ForumListActivity.this.ngH);
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
                ForumListActivity.this.ngL.Ie(min);
                ForumListActivity.this.ngL.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.ngy == 200) {
                    ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.ngG.nhx.setImageDrawable(ForumListActivity.this.ngv);
                } else {
                    ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.ngG.nhx.setImageDrawable(ForumListActivity.this.ngw);
                    ForumListActivity.this.ngJ = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.ngX) {
                    if (ForumListActivity.this.ngy == 200) {
                        ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.ngG.nhx.setImageDrawable(ForumListActivity.this.ngv);
                    } else {
                        ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.ngG.nhx.setImageDrawable(ForumListActivity.this.ngw);
                    }
                } else {
                    ForumListActivity.this.ngG.nhw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.ngG.nhx.setImageDrawable(ForumListActivity.this.ngv);
                    ForumListActivity.this.ngH.rn = 200;
                    ForumListActivity.this.ngy = 200;
                }
            }
            ForumListActivity.this.ngG.nhv.setEnabled(true);
            ForumListActivity.this.ngG.dJK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean ngX;

        private c() {
            this.ngX = false;
        }

        public void xQ(boolean z) {
            this.ngX = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.ngG.nhs.setEnabled(false);
            ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.ngH.recommend_type = 1;
                ForumListActivity.this.ngH.offset = 0;
                ForumListActivity.this.ngH.rn = ForumListActivity.this.ngx;
                return ForumListModel.new_fetch(ForumListActivity.this.ngH);
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
                ForumListActivity.this.ngK.Ie(min);
                ForumListActivity.this.ngK.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.ngx == 200) {
                    ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.ngG.nhu.setImageDrawable(ForumListActivity.this.ngv);
                } else {
                    ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.ngG.nhu.setImageDrawable(ForumListActivity.this.ngw);
                    ForumListActivity.this.ngI = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.ngX) {
                    if (ForumListActivity.this.ngx == 200) {
                        ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.ngG.nhu.setImageDrawable(ForumListActivity.this.ngv);
                    } else {
                        ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.ngG.nhu.setImageDrawable(ForumListActivity.this.ngw);
                    }
                } else {
                    ForumListActivity.this.ngG.nht.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.ngG.nhu.setImageDrawable(ForumListActivity.this.ngv);
                    ForumListActivity.this.ngH.rn = 200;
                    ForumListActivity.this.ngx = 200;
                }
            }
            ForumListActivity.this.ngG.nhs.setEnabled(true);
            ForumListActivity.this.ngG.dJK();
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
        this.ngG = new com.baidu.tieba.square.flist.c(this);
        this.ngG.nho = (BdListView) dJA();
        this.ngG.nhp = (BdListView) dJC();
        this.ngG.mProgressBar.setVisibility(0);
        this.ngG.nhF.setOnClickListener(null);
        this.ngG.nhF.setClickable(false);
        this.ngG.Zi.setAdapter(new a());
        this.ngG.nho.setPullRefresh(this.ngG.nhy);
        this.ngG.nhp.setPullRefresh(this.ngG.nhz);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.ngG.nho.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.ngG.nhp.addHeaderView(textView2, 0);
        this.ngK = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.ngG.nho.setAdapter((ListAdapter) this.ngK);
        this.ngL = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.ngG.nhp.setAdapter((ListAdapter) this.ngL);
        H(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void H(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.ngG.bIw.setText(str4);
        this.ngG.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ngH = new ForumListModel.RequestParams();
        this.ngH.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.ngH.menu_name = str4;
        this.ngH.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.ngH.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.ngH.parent_menu_name = str;
        this.ngH.offset = 0;
        this.ngH.rn = 10;
        if (this.ngH.menu_id != 0) {
            this.ngG.dJJ();
            this.ngA = true;
            this.ngF = false;
            this.ngK.t(Boolean.valueOf(this.ngF));
            this.ngG.Zi.getAdapter().notifyDataSetChanged();
        } else {
            this.ngF = true;
            this.ngK.t(Boolean.valueOf(this.ngF));
            this.ngG.dJI();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.ngG.nhy.setListPullRefreshListener(this.gEB);
        this.ngG.nhz.setListPullRefreshListener(this.gEB);
        this.ngK.notifyDataSetChanged();
        this.ngL.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.ngG.dJL();
        } else {
            this.ngM = new DirMenuModel(getPageContext(), str, str3, str2);
            this.ngM.a(this.ngP);
            this.ngM.LoadData();
        }
        this.ngN = new ForumListDetailModel(getPageContext(), this.ngH);
        this.ngN.a(this.ngO);
        this.ngG.nho.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (jas) {
            jas = false;
            finish();
            c(getPageContext().getPageActivity(), ngR, ngT, ngS, ngU);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.ngK != null) {
                this.ngK.dJG();
                this.ngK.notifyDataSetChanged();
            }
            if (this.ngL != null) {
                this.ngL.dJG();
                this.ngL.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fle != null) {
            this.fle.dKC();
        }
        this.ngG.Zi.setAdapter(null);
        this.ngG.nhp.setAdapter((ListAdapter) null);
        this.ngG.nho.setAdapter((ListAdapter) null);
        if (this.ngG.nhD != null) {
            this.ngG.nhD.setAdapter((ListAdapter) null);
        }
        if (this.ngM != null) {
            this.ngM.cancelLoadData();
        }
        if (this.ngN != null) {
            this.ngN.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ngG.iNK);
        this.ngG.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ngK.xR(true);
            this.ngL.xR(true);
        } else {
            this.ngK.xR(false);
            this.ngL.xR(false);
        }
        this.ngK.notifyDataSetChanged();
        this.ngL.notifyDataSetChanged();
        if (this.ngG.nhA != null) {
            this.ngG.nhA.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ao.setBackgroundResource(this.ngG.nhl, R.drawable.bg_pop_most);
        this.ngp = ao.getColor(R.color.common_color_10243);
        this.ngq = ao.getColor(R.color.CAM_X0101);
        this.ngr = ao.getDrawable(R.drawable.btn_pop_most_left_n);
        this.ngs = ao.getDrawable(R.drawable.btn_pop_most_right_n);
        this.ngt = ao.getDrawable(R.drawable.btn_pop_most_left_s);
        this.ngu = ao.getDrawable(R.drawable.btn_pop_most_right_s);
        this.ngv = ao.getDrawable(R.drawable.ico_downward);
        this.ngw = ao.getDrawable(R.drawable.ico_upward);
        this.ngK.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        this.ngL.dt(R.drawable.btn_add_end, R.drawable.btn_add);
        ao.setBackgroundResource(this.ngG.nhk, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.ngG.nhw, R.color.common_color_10243, 1);
        ao.setBackgroundResource(this.ngG.nhj, R.drawable.bg_black_banner_down);
        ao.setViewTextColor(this.ngG.nht, R.color.common_color_10243, 1);
        if (this.ngI) {
            ao.setImageResource(this.ngG.nhu, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.ngG.nhu, R.drawable.ico_downward);
        }
        if (this.ngJ) {
            ao.setImageResource(this.ngG.nhx, R.drawable.ico_upward);
        } else {
            ao.setImageResource(this.ngG.nhx, R.drawable.ico_downward);
        }
        if (this.ngG.Zi.getCurrentItem() == 0) {
            this.ngG.nhq.setTextColor(this.ngq);
            this.ngG.nhq.setBackgroundDrawable(this.ngt);
            this.ngG.nhr.setBackgroundDrawable(this.ngs);
            this.ngG.nhr.setTextColor(this.ngp);
            return;
        }
        this.ngG.nhr.setTextColor(this.ngq);
        this.ngG.nhr.setBackgroundDrawable(this.ngu);
        this.ngG.nhq.setBackgroundDrawable(this.ngr);
        this.ngG.nhq.setTextColor(this.ngp);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.ngG.Zi.setCurrentItem(0);
            this.ngz = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.ngG.Zi.setCurrentItem(1);
            this.ngz = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.ngG.c(this.ngQ);
        }
    }

    private View dJA() {
        this.ngG.nho = dJE();
        this.ngG.nhs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dJB();
            }
        });
        return this.ngG.nho;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJB() {
        if (this.ngI) {
            int min = Math.min(this.ngK.getCount(), 200);
            this.ngx = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.ngK.dJF(), 0, forumInfoDataArr, 0, min);
            this.ngK.Ie(min);
            this.ngK.a(forumInfoDataArr);
            this.ngI = false;
            this.ngG.nht.setText(getPageContext().getString(R.string.flist_expand_list));
            this.ngG.nhu.setImageDrawable(this.ngv);
            return;
        }
        this.ngx = 50;
        c cVar = new c();
        cVar.xQ(true);
        cVar.execute(new Void[0]);
    }

    private View dJC() {
        this.ngG.nhp = dJE();
        this.ngG.nhv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dJD();
            }
        });
        return this.ngG.nhp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJD() {
        if (this.ngJ) {
            int min = Math.min(this.ngL.getCount(), 200);
            this.ngy = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.ngL.dJF(), 0, forumInfoDataArr, 0, min);
            this.ngL.Ie(min);
            this.ngL.a(forumInfoDataArr);
            this.ngJ = false;
            this.ngG.nhw.setText(getPageContext().getString(R.string.flist_expand_list));
            this.ngG.nhx.setImageDrawable(this.ngv);
            return;
        }
        this.ngy = 50;
        b bVar = new b();
        bVar.xQ(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dJE() {
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.ngA) {
            if (i == 0) {
                this.ngK.dJG();
                this.ngK.notifyDataSetChanged();
                this.ngG.nhq.setBackgroundDrawable(this.ngt);
                this.ngG.nhq.setTextColor(this.ngq);
                this.ngG.nhr.setBackgroundDrawable(this.ngs);
                this.ngG.nhr.setTextColor(this.ngp);
            } else if (i == 1) {
                this.ngL.dJG();
                this.ngL.notifyDataSetChanged();
                this.ngG.nhr.setBackgroundDrawable(this.ngu);
                this.ngG.nhr.setTextColor(this.ngq);
                this.ngG.nhq.setBackgroundDrawable(this.ngr);
                this.ngG.nhq.setTextColor(this.ngp);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes7.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.ngA ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.ngG.nho);
                    return ForumListActivity.this.ngG.nho;
                case 1:
                    viewGroup.addView(ForumListActivity.this.ngG.nhp);
                    return ForumListActivity.this.ngG.nhp;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        final ForumInfoData[] dJF;
        if (i == 11002 && i2 == -1) {
            this.ngN.LoadData();
            if (this.ngz == 0) {
                dJF = this.ngK.dJF();
            } else {
                dJF = this.ngL.dJF();
            }
            this.fle.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (ForumListActivity.this.fle.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.fle.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.fle.getErrorString());
                        } else if (((w) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.ngz == 0) {
                                ForumListActivity.this.ngK.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dJF[ForumListActivity.this.ngK.ngY].forum_name);
                            } else if (ForumListActivity.this.ngz == 1) {
                                ForumListActivity.this.ngL.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dJF[ForumListActivity.this.ngL.ngY].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.ngz == 0) {
                this.fle.gq(dJF[this.ngK.ngY].forum_name, String.valueOf(dJF[this.ngK.ngY].forum_id));
            } else {
                this.fle.gq(dJF[this.ngL.ngY].forum_name, String.valueOf(dJF[this.ngL.ngY].forum_id));
            }
        }
    }
}
