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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean hZM = false;
    private static String miJ = "";
    private static String miK = "";
    private static String miL = "";
    private static String miM = "";
    private com.baidu.tieba.square.flist.b miC;
    private com.baidu.tieba.square.flist.b miD;
    private DirMenuModel miE;
    private ForumListDetailModel miF;
    private int mig;
    private int mih;
    private Drawable mii;
    private Drawable mij;
    private Drawable mik;
    private Drawable mil;
    private Drawable mim;
    private Drawable mio;
    public com.baidu.tieba.square.flist.c miy;
    private ForumListModel.RequestParams miz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int mip = 200;
    private int miq = 200;
    private int mir = 0;
    private final LikeModel ezi = new LikeModel(getPageContext());
    private boolean mis = false;
    private int menu_choose = 0;
    private boolean mit = false;
    private int miu = 0;
    private int miv = 200;
    private boolean miw = true;
    private boolean mix = true;
    private boolean miA = false;
    private boolean miB = false;
    private final ForumListDetailModel.a miG = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.miC.dzb() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.miy.dzh();
                ForumListActivity.this.miy.dzg();
                if (ForumListActivity.this.miz.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.miy.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.miz.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.miy.dzg();
                    ForumListActivity.this.miz.recommend_type = ForumListActivity.this.miu;
                    ForumListActivity.this.miz.rn = ForumListActivity.this.miv;
                }
                ForumListActivity.this.miy.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.miy.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.mit) {
                    ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.miy.mjm.setImageDrawable(ForumListActivity.this.mim);
                    ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.miy.mjp.setImageDrawable(ForumListActivity.this.mim);
                    ForumListActivity.this.mit = false;
                }
                ForumListActivity.this.miy.bsJ.setText(ForumListActivity.this.miz.menu_name);
                ForumListActivity.this.miy.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.miy.mjw.Id(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.miC.Hn(min);
                ForumListActivity.this.miC.a(ForumListActivity.this.ezi);
                ForumListActivity.this.miC.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.miy.mjg.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.miy.mjb.setVisibility(0);
                } else {
                    ForumListActivity.this.miy.mjb.setVisibility(8);
                }
                ForumListActivity.this.miy.mji.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.miD.Hn(min2);
                ForumListActivity.this.miD.a(ForumListActivity.this.ezi);
                ForumListActivity.this.miD.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.miy.mjh.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.miy.mjc.setVisibility(0);
                } else {
                    ForumListActivity.this.miy.mjc.setVisibility(8);
                }
                ForumListActivity.this.miy.mjj.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.miy.dzg();
                if (ForumListActivity.this.miy.mjw.getCount() > 0) {
                    ForumListActivity.this.miy.mjx.setClickable(true);
                    ForumListActivity.this.miy.mjx.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b miH = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.miy.dzh();
                    return;
                }
                return;
            }
            eVar.mkh.add(0, eVar);
            if (ForumListActivity.this.miy.mjw != null) {
                ForumListActivity.this.miy.mjw.a(eVar);
                ForumListActivity.this.QS(String.valueOf(ForumListActivity.this.miy.bsJ.getText()));
                ForumListActivity.this.miy.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.miy.mjw.notifyDataSetChanged();
            }
            ForumListActivity.this.miy.mjx.setClickable(true);
            ForumListActivity.this.miy.mjx.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener miI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.miy.mjs, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.miy.dzh();
            ForumListActivity.this.miy.dzi();
            ArrayList<e> arrayList = ForumListActivity.this.miy.mjw.dyU().mkh;
            ForumListActivity.this.ax(arrayList.get(i).mhZ, arrayList.get(i).mib, arrayList.get(i).mia);
        }
    };
    private final f.c fOd = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.miC.dzd() && !ForumListActivity.this.miD.dzd()) {
                if (ForumListActivity.this.miw) {
                    ForumListActivity.this.miz.recommend_type = 0;
                    ForumListActivity.this.miz.rn = 200;
                    ForumListActivity.this.miF.a(ForumListActivity.this.miz);
                    ForumListActivity.this.miF.LoadData();
                    ForumListActivity.this.miw = false;
                } else if (ForumListActivity.this.miy.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.miA) {
                        ForumListActivity.this.mip = 50;
                    } else {
                        ForumListActivity.this.mip = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.miy.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.miB) {
                        ForumListActivity.this.miq = 50;
                    } else {
                        ForumListActivity.this.miq = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void QS(String str) {
        e dyU = this.miy.mjw.dyU();
        if (dyU != null) {
            ArrayList<e> arrayList = dyU.mkh;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).mhZ.equals(str)) {
                    this.menu_choose = i;
                    this.miy.mjw.Id(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.miz.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.miz.menu_name = str;
        this.miz.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.miz.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.miz.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.miz.offset = 0;
        this.miz.rn = 10;
        this.miu = this.miz.recommend_type;
        this.miv = this.miz.rn;
        this.miz.recommend_type = 0;
        this.miz.rn = 200;
        this.mit = true;
        this.miF.a(this.miz);
        this.miF.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean miP;

        private b() {
            this.miP = false;
        }

        public void wd(boolean z) {
            this.miP = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.miy.mjn.setEnabled(false);
            ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.miz.recommend_type = 2;
                ForumListActivity.this.miz.offset = 0;
                ForumListActivity.this.miz.rn = ForumListActivity.this.miq;
                return ForumListModel.new_fetch(ForumListActivity.this.miz);
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
                ForumListActivity.this.miD.Hn(min);
                ForumListActivity.this.miD.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.miq == 200) {
                    ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.miy.mjp.setImageDrawable(ForumListActivity.this.mim);
                } else {
                    ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.miy.mjp.setImageDrawable(ForumListActivity.this.mio);
                    ForumListActivity.this.miB = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.miP) {
                    if (ForumListActivity.this.miq == 200) {
                        ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.miy.mjp.setImageDrawable(ForumListActivity.this.mim);
                    } else {
                        ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.miy.mjp.setImageDrawable(ForumListActivity.this.mio);
                    }
                } else {
                    ForumListActivity.this.miy.mjo.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.miy.mjp.setImageDrawable(ForumListActivity.this.mim);
                    ForumListActivity.this.miz.rn = 200;
                    ForumListActivity.this.miq = 200;
                }
            }
            ForumListActivity.this.miy.mjn.setEnabled(true);
            ForumListActivity.this.miy.dzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean miP;

        private c() {
            this.miP = false;
        }

        public void wd(boolean z) {
            this.miP = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.miy.mjk.setEnabled(false);
            ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.miz.recommend_type = 1;
                ForumListActivity.this.miz.offset = 0;
                ForumListActivity.this.miz.rn = ForumListActivity.this.mip;
                return ForumListModel.new_fetch(ForumListActivity.this.miz);
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
                ForumListActivity.this.miC.Hn(min);
                ForumListActivity.this.miC.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.mip == 200) {
                    ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.miy.mjm.setImageDrawable(ForumListActivity.this.mim);
                } else {
                    ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.miy.mjm.setImageDrawable(ForumListActivity.this.mio);
                    ForumListActivity.this.miA = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.miP) {
                    if (ForumListActivity.this.mip == 200) {
                        ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.miy.mjm.setImageDrawable(ForumListActivity.this.mim);
                    } else {
                        ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.miy.mjm.setImageDrawable(ForumListActivity.this.mio);
                    }
                } else {
                    ForumListActivity.this.miy.mjl.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.miy.mjm.setImageDrawable(ForumListActivity.this.mim);
                    ForumListActivity.this.miz.rn = 200;
                    ForumListActivity.this.mip = 200;
                }
            }
            ForumListActivity.this.miy.mjk.setEnabled(true);
            ForumListActivity.this.miy.dzg();
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
        this.miy = new com.baidu.tieba.square.flist.c(this);
        this.miy.mjg = (BdListView) dyW();
        this.miy.mjh = (BdListView) dyY();
        this.miy.mProgressBar.setVisibility(0);
        this.miy.mjx.setOnClickListener(null);
        this.miy.mjx.setClickable(false);
        this.miy.mViewPager.setAdapter(new a());
        this.miy.mjg.setPullRefresh(this.miy.mjq);
        this.miy.mjh.setPullRefresh(this.miy.mjr);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.miy.mjg.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.miy.mjh.addHeaderView(textView2, 0);
        this.miC = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.miy.mjg.setAdapter((ListAdapter) this.miC);
        this.miD = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.miy.mjh.setAdapter((ListAdapter) this.miD);
        G(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void G(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.miy.bsJ.setText(str4);
        this.miy.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.miz = new ForumListModel.RequestParams();
        this.miz.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.miz.menu_name = str4;
        this.miz.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.miz.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.miz.parent_menu_name = str;
        this.miz.offset = 0;
        this.miz.rn = 10;
        if (this.miz.menu_id != 0) {
            this.miy.dzf();
            this.mis = true;
            this.mix = false;
            this.miC.r(Boolean.valueOf(this.mix));
            this.miy.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.mix = true;
            this.miC.r(Boolean.valueOf(this.mix));
            this.miy.dze();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.miy.mjq.setListPullRefreshListener(this.fOd);
        this.miy.mjr.setListPullRefreshListener(this.fOd);
        this.miC.notifyDataSetChanged();
        this.miD.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.miy.dzh();
        } else {
            this.miE = new DirMenuModel(getPageContext(), str, str3, str2);
            this.miE.a(this.miH);
            this.miE.LoadData();
        }
        this.miF = new ForumListDetailModel(getPageContext(), this.miz);
        this.miF.a(this.miG);
        this.miy.mjg.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hZM) {
            hZM = false;
            finish();
            c(getPageContext().getPageActivity(), miJ, miL, miK, miM);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.miC != null) {
                this.miC.dzc();
                this.miC.notifyDataSetChanged();
            }
            if (this.miD != null) {
                this.miD.dzc();
                this.miD.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.ezi != null) {
            this.ezi.dzW();
        }
        this.miy.mViewPager.setAdapter(null);
        this.miy.mjh.setAdapter((ListAdapter) null);
        this.miy.mjg.setAdapter((ListAdapter) null);
        if (this.miy.mjv != null) {
            this.miy.mjv.setAdapter((ListAdapter) null);
        }
        if (this.miE != null) {
            this.miE.cancelLoadData();
        }
        if (this.miF != null) {
            this.miF.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.miy.hNd);
        this.miy.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.miC.we(true);
            this.miD.we(true);
        } else {
            this.miC.we(false);
            this.miD.we(false);
        }
        this.miC.notifyDataSetChanged();
        this.miD.notifyDataSetChanged();
        if (this.miy.mjs != null) {
            this.miy.mjs.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.miy.mjd, R.drawable.bg_pop_most);
        this.mig = ap.getColor(R.color.common_color_10243);
        this.mih = ap.getColor(R.color.cp_cont_a);
        this.mii = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.mij = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.mik = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.mil = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.mim = ap.getDrawable(R.drawable.ico_downward);
        this.mio = ap.getDrawable(R.drawable.ico_upward);
        this.miC.dn(R.drawable.btn_add_end, R.drawable.btn_add);
        this.miD.dn(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.miy.mjc, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.miy.mjo, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.miy.mjb, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.miy.mjl, R.color.common_color_10243, 1);
        if (this.miA) {
            ap.setImageResource(this.miy.mjm, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.miy.mjm, R.drawable.ico_downward);
        }
        if (this.miB) {
            ap.setImageResource(this.miy.mjp, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.miy.mjp, R.drawable.ico_downward);
        }
        if (this.miy.mViewPager.getCurrentItem() == 0) {
            this.miy.mji.setTextColor(this.mih);
            this.miy.mji.setBackgroundDrawable(this.mik);
            this.miy.mjj.setBackgroundDrawable(this.mij);
            this.miy.mjj.setTextColor(this.mig);
            return;
        }
        this.miy.mjj.setTextColor(this.mih);
        this.miy.mjj.setBackgroundDrawable(this.mil);
        this.miy.mji.setBackgroundDrawable(this.mii);
        this.miy.mji.setTextColor(this.mig);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.miy.mViewPager.setCurrentItem(0);
            this.mir = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.miy.mViewPager.setCurrentItem(1);
            this.mir = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.miy.c(this.miI);
        }
    }

    private View dyW() {
        this.miy.mjg = dza();
        this.miy.mjk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dyX();
            }
        });
        return this.miy.mjg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyX() {
        if (this.miA) {
            int min = Math.min(this.miC.getCount(), 200);
            this.mip = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.miC.dzb(), 0, forumInfoDataArr, 0, min);
            this.miC.Hn(min);
            this.miC.a(forumInfoDataArr);
            this.miA = false;
            this.miy.mjl.setText(getPageContext().getString(R.string.flist_expand_list));
            this.miy.mjm.setImageDrawable(this.mim);
            return;
        }
        this.mip = 50;
        c cVar = new c();
        cVar.wd(true);
        cVar.execute(new Void[0]);
    }

    private View dyY() {
        this.miy.mjh = dza();
        this.miy.mjn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dyZ();
            }
        });
        return this.miy.mjh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyZ() {
        if (this.miB) {
            int min = Math.min(this.miD.getCount(), 200);
            this.miq = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.miD.dzb(), 0, forumInfoDataArr, 0, min);
            this.miD.Hn(min);
            this.miD.a(forumInfoDataArr);
            this.miB = false;
            this.miy.mjo.setText(getPageContext().getString(R.string.flist_expand_list));
            this.miy.mjp.setImageDrawable(this.mim);
            return;
        }
        this.miq = 50;
        b bVar = new b();
        bVar.wd(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dza() {
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
        if (!this.mis) {
            if (i == 0) {
                this.miC.dzc();
                this.miC.notifyDataSetChanged();
                this.miy.mji.setBackgroundDrawable(this.mik);
                this.miy.mji.setTextColor(this.mih);
                this.miy.mjj.setBackgroundDrawable(this.mij);
                this.miy.mjj.setTextColor(this.mig);
            } else if (i == 1) {
                this.miD.dzc();
                this.miD.notifyDataSetChanged();
                this.miy.mjj.setBackgroundDrawable(this.mil);
                this.miy.mjj.setTextColor(this.mih);
                this.miy.mji.setBackgroundDrawable(this.mii);
                this.miy.mji.setTextColor(this.mig);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes22.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.mis ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.miy.mjg);
                    return ForumListActivity.this.miy.mjg;
                case 1:
                    viewGroup.addView(ForumListActivity.this.miy.mjh);
                    return ForumListActivity.this.miy.mjh;
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
        final ForumInfoData[] dzb;
        if (i == 11002 && i2 == -1) {
            this.miF.LoadData();
            if (this.mir == 0) {
                dzb = this.miC.dzb();
            } else {
                dzb = this.miD.dzb();
            }
            this.ezi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.ezi.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.ezi.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.ezi.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.mir == 0) {
                                ForumListActivity.this.miC.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dzb[ForumListActivity.this.miC.miQ].forum_name);
                            } else if (ForumListActivity.this.mir == 1) {
                                ForumListActivity.this.miD.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dzb[ForumListActivity.this.miD.miQ].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.mir == 0) {
                this.ezi.gd(dzb[this.miC.miQ].forum_name, String.valueOf(dzb[this.miC.miQ].forum_id));
            } else {
                this.ezi.gd(dzb[this.miD.miQ].forum_name, String.valueOf(dzb[this.miD.miQ].forum_id));
            }
        }
    }
}
