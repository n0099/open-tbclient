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
    public static boolean fuf = false;
    private static String jan = "";
    private static String jao = "";
    private static String jap = "";
    private static String jaq = "";
    private int iZK;
    private int iZL;
    private Drawable iZM;
    private Drawable iZN;
    private Drawable iZO;
    private Drawable iZP;
    private Drawable iZQ;
    private Drawable iZR;
    public com.baidu.tieba.square.flist.c jac;
    private ForumListModel.RequestParams jad;
    private com.baidu.tieba.square.flist.b jag;
    private com.baidu.tieba.square.flist.b jah;
    private DirMenuModel jai;
    private ForumListDetailModel jaj;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int iZS = 200;
    private int iZT = 200;
    private int iZU = 0;
    private final LikeModel cdy = new LikeModel(getPageContext());
    private boolean iZV = false;
    private int iZW = 0;
    private boolean iZX = false;
    private int iZY = 0;
    private int iZZ = 200;
    private boolean jaa = true;
    private boolean jab = true;
    private boolean jae = false;
    private boolean jaf = false;
    private final ForumListDetailModel.a jak = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.jag.coe() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.jac.cok();
                ForumListActivity.this.jac.coj();
                if (ForumListActivity.this.jad.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.jac.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.jad.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.jac.coj();
                    ForumListActivity.this.jad.recommend_type = ForumListActivity.this.iZY;
                    ForumListActivity.this.jad.rn = ForumListActivity.this.iZZ;
                }
                ForumListActivity.this.jac.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.jac.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.iZX) {
                    ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jac.jaQ.setImageDrawable(ForumListActivity.this.iZQ);
                    ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jac.jaT.setImageDrawable(ForumListActivity.this.iZQ);
                    ForumListActivity.this.iZX = false;
                }
                ForumListActivity.this.jac.ffR.setText(ForumListActivity.this.jad.menu_name);
                ForumListActivity.this.jac.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jac.jba.AR(ForumListActivity.this.iZW);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.jag.Ae(min);
                ForumListActivity.this.jag.a(ForumListActivity.this.cdy);
                ForumListActivity.this.jag.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.jac.jaK.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.jac.jaF.setVisibility(0);
                } else {
                    ForumListActivity.this.jac.jaF.setVisibility(8);
                }
                ForumListActivity.this.jac.jaM.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.jah.Ae(min2);
                ForumListActivity.this.jah.a(ForumListActivity.this.cdy);
                ForumListActivity.this.jah.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.jac.jaL.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.jac.jaG.setVisibility(0);
                } else {
                    ForumListActivity.this.jac.jaG.setVisibility(8);
                }
                ForumListActivity.this.jac.jaN.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.jac.coj();
                if (ForumListActivity.this.jac.jba.getCount() > 0) {
                    ForumListActivity.this.jac.jbb.setClickable(true);
                    ForumListActivity.this.jac.jbb.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b jal = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, d dVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.jac.cok();
                    return;
                }
                return;
            }
            dVar.jbR.add(0, dVar);
            if (ForumListActivity.this.jac.jba != null) {
                ForumListActivity.this.jac.jba.a(dVar);
                ForumListActivity.this.Ev(String.valueOf(ForumListActivity.this.jac.ffR.getText()));
                ForumListActivity.this.jac.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.jac.jba.notifyDataSetChanged();
            }
            ForumListActivity.this.jac.jbb.setClickable(true);
            ForumListActivity.this.jac.jbb.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener jam = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.a(ForumListActivity.this.jac.jaW, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.iZW = i;
            ForumListActivity.this.jac.cok();
            ForumListActivity.this.jac.col();
            ArrayList<d> arrayList = ForumListActivity.this.jac.jba.cnX().jbR;
            ForumListActivity.this.ab(arrayList.get(i).iZE, arrayList.get(i).iZG, arrayList.get(i).iZF);
        }
    };
    private final h.c duo = new h.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (!ForumListActivity.this.jag.cog() && !ForumListActivity.this.jah.cog()) {
                if (ForumListActivity.this.jaa) {
                    ForumListActivity.this.jad.recommend_type = 0;
                    ForumListActivity.this.jad.rn = 200;
                    ForumListActivity.this.jaj.a(ForumListActivity.this.jad);
                    ForumListActivity.this.jaj.LoadData();
                    ForumListActivity.this.jaa = false;
                } else if (ForumListActivity.this.jac.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.jae) {
                        ForumListActivity.this.iZS = 50;
                    } else {
                        ForumListActivity.this.iZS = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.jac.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.jaf) {
                        ForumListActivity.this.iZT = 50;
                    } else {
                        ForumListActivity.this.iZT = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev(String str) {
        d cnX = this.jac.jba.cnX();
        if (cnX != null) {
            ArrayList<d> arrayList = cnX.jbR;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).iZE.equals(str)) {
                    this.iZW = i;
                    this.jac.jba.AR(this.iZW);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, String str2, String str3) {
        this.jad.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.jad.menu_name = str;
        this.jad.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.jad.parent_menu_id = com.baidu.adp.lib.g.b.f(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.jad.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.jad.offset = 0;
        this.jad.rn = 10;
        this.iZY = this.jad.recommend_type;
        this.iZZ = this.jad.rn;
        this.jad.recommend_type = 0;
        this.jad.rn = 200;
        this.iZX = true;
        this.jaj.a(this.jad);
        this.jaj.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jat;

        private b() {
            this.jat = false;
        }

        public void qU(boolean z) {
            this.jat = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jac.jaR.setEnabled(false);
            ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jad.recommend_type = 2;
                ForumListActivity.this.jad.offset = 0;
                ForumListActivity.this.jad.rn = ForumListActivity.this.iZT;
                return ForumListModel.new_fetch(ForumListActivity.this.jad);
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
                ForumListActivity.this.jah.Ae(min);
                ForumListActivity.this.jah.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.iZT == 200) {
                    ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jac.jaT.setImageDrawable(ForumListActivity.this.iZQ);
                } else {
                    ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jac.jaT.setImageDrawable(ForumListActivity.this.iZR);
                    ForumListActivity.this.jaf = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jat) {
                    if (ForumListActivity.this.iZT == 200) {
                        ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jac.jaT.setImageDrawable(ForumListActivity.this.iZQ);
                    } else {
                        ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jac.jaT.setImageDrawable(ForumListActivity.this.iZR);
                    }
                } else {
                    ForumListActivity.this.jac.jaS.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jac.jaT.setImageDrawable(ForumListActivity.this.iZQ);
                    ForumListActivity.this.jad.rn = 200;
                    ForumListActivity.this.iZT = 200;
                }
            }
            ForumListActivity.this.jac.jaR.setEnabled(true);
            ForumListActivity.this.jac.coj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean jat;

        private c() {
            this.jat = false;
        }

        public void qU(boolean z) {
            this.jat = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.jac.jaO.setEnabled(false);
            ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.jad.recommend_type = 1;
                ForumListActivity.this.jad.offset = 0;
                ForumListActivity.this.jad.rn = ForumListActivity.this.iZS;
                return ForumListModel.new_fetch(ForumListActivity.this.jad);
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
                ForumListActivity.this.jag.Ae(min);
                ForumListActivity.this.jag.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.iZS == 200) {
                    ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jac.jaQ.setImageDrawable(ForumListActivity.this.iZQ);
                } else {
                    ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.jac.jaQ.setImageDrawable(ForumListActivity.this.iZR);
                    ForumListActivity.this.jae = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.jat) {
                    if (ForumListActivity.this.iZS == 200) {
                        ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.jac.jaQ.setImageDrawable(ForumListActivity.this.iZQ);
                    } else {
                        ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.jac.jaQ.setImageDrawable(ForumListActivity.this.iZR);
                    }
                } else {
                    ForumListActivity.this.jac.jaP.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.jac.jaQ.setImageDrawable(ForumListActivity.this.iZQ);
                    ForumListActivity.this.jad.rn = 200;
                    ForumListActivity.this.iZS = 200;
                }
            }
            ForumListActivity.this.jac.jaO.setEnabled(true);
            ForumListActivity.this.jac.coj();
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
        this.jac = new com.baidu.tieba.square.flist.c(this);
        this.jac.jaK = (BdListView) cnZ();
        this.jac.jaL = (BdListView) cob();
        this.jac.mProgressBar.setVisibility(0);
        this.jac.jbb.setOnClickListener(null);
        this.jac.jbb.setClickable(false);
        this.jac.mViewPager.setAdapter(new a());
        this.jac.jaK.setPullRefresh(this.jac.jaU);
        this.jac.jaL.setPullRefresh(this.jac.jaV);
        if (com.baidu.adp.lib.g.b.f(stringExtra3, 0) != 0) {
            g = l.g(getActivity(), R.dimen.ds98);
        } else {
            g = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g));
        this.jac.jaK.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, g + UtilHelper.getLightStatusBarHeight()));
        this.jac.jaL.addHeaderView(textView2, 0);
        this.jag = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.jac.jaK.setAdapter((ListAdapter) this.jag);
        this.jah = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.jac.jaL.setAdapter((ListAdapter) this.jah);
        t(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void t(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.jac.ffR.setText(str4);
        this.jac.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.jad = new ForumListModel.RequestParams();
        this.jad.menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.jad.menu_name = str4;
        this.jad.menu_type = com.baidu.adp.lib.g.b.f(str3, 0);
        this.jad.parent_menu_id = com.baidu.adp.lib.g.b.f(str2, 0);
        this.jad.parent_menu_name = str;
        this.jad.offset = 0;
        this.jad.rn = 10;
        if (this.jad.menu_id != 0) {
            this.jac.coi();
            this.iZV = true;
            this.jab = false;
            this.jag.i(Boolean.valueOf(this.jab));
            this.jac.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.jab = true;
            this.jag.i(Boolean.valueOf(this.jab));
            this.jac.coh();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.jac.jaU.setListPullRefreshListener(this.duo);
        this.jac.jaV.setListPullRefreshListener(this.duo);
        this.jag.notifyDataSetChanged();
        this.jah.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.jac.cok();
        } else {
            this.jai = new DirMenuModel(getPageContext(), str, str3, str2);
            this.jai.a(this.jal);
            this.jai.LoadData();
        }
        this.jaj = new ForumListDetailModel(getPageContext(), this.jad);
        this.jaj.a(this.jak);
        this.jac.jaK.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (fuf) {
            fuf = false;
            finish();
            b(getPageContext().getPageActivity(), jan, jap, jao, jaq);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.jag != null) {
                this.jag.cof();
                this.jag.notifyDataSetChanged();
            }
            if (this.jah != null) {
                this.jah.cof();
                this.jah.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.cdy != null) {
            this.cdy.cpa();
        }
        this.jac.mViewPager.setAdapter(null);
        this.jac.jaL.setAdapter((ListAdapter) null);
        this.jac.jaK.setAdapter((ListAdapter) null);
        if (this.jac.jaZ != null) {
            this.jac.jaZ.setAdapter((ListAdapter) null);
        }
        if (this.jai != null) {
            this.jai.cancelLoadData();
        }
        if (this.jaj != null) {
            this.jaj.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jac.fef);
        this.jac.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jag.qV(true);
            this.jah.qV(true);
        } else {
            this.jag.qV(false);
            this.jah.qV(false);
        }
        this.jag.notifyDataSetChanged();
        this.jah.notifyDataSetChanged();
        if (this.jac.jaW != null) {
            this.jac.jaW.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.k(this.jac.jaH, R.drawable.bg_pop_most);
        this.iZK = am.getColor(R.color.common_color_10243);
        this.iZL = am.getColor(R.color.cp_btn_a);
        this.iZM = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.iZN = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.iZO = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.iZP = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.iZQ = am.getDrawable(R.drawable.ico_downward);
        this.iZR = am.getDrawable(R.drawable.ico_upward);
        this.jag.cw(R.drawable.btn_add_end, R.drawable.btn_add);
        this.jah.cw(R.drawable.btn_add_end, R.drawable.btn_add);
        am.k(this.jac.jaG, R.drawable.bg_black_banner_down);
        am.f(this.jac.jaS, R.color.common_color_10243, 1);
        am.k(this.jac.jaF, R.drawable.bg_black_banner_down);
        am.f(this.jac.jaP, R.color.common_color_10243, 1);
        if (this.jae) {
            am.c(this.jac.jaQ, (int) R.drawable.ico_upward);
        } else {
            am.c(this.jac.jaQ, (int) R.drawable.ico_downward);
        }
        if (this.jaf) {
            am.c(this.jac.jaT, (int) R.drawable.ico_upward);
        } else {
            am.c(this.jac.jaT, (int) R.drawable.ico_downward);
        }
        if (this.jac.mViewPager.getCurrentItem() == 0) {
            this.jac.jaM.setTextColor(this.iZL);
            this.jac.jaM.setBackgroundDrawable(this.iZO);
            this.jac.jaN.setBackgroundDrawable(this.iZN);
            this.jac.jaN.setTextColor(this.iZK);
            return;
        }
        this.jac.jaN.setTextColor(this.iZL);
        this.jac.jaN.setBackgroundDrawable(this.iZP);
        this.jac.jaM.setBackgroundDrawable(this.iZM);
        this.jac.jaM.setTextColor(this.iZK);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.jac.mViewPager.setCurrentItem(0);
            this.iZU = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.jac.mViewPager.setCurrentItem(1);
            this.iZU = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.jac.d(this.jam);
        }
    }

    private View cnZ() {
        this.jac.jaK = cod();
        this.jac.jaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.coa();
            }
        });
        return this.jac.jaK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coa() {
        if (this.jae) {
            int min = Math.min(this.jag.getCount(), 200);
            this.iZS = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jag.coe(), 0, forumInfoDataArr, 0, min);
            this.jag.Ae(min);
            this.jag.a(forumInfoDataArr);
            this.jae = false;
            this.jac.jaP.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jac.jaQ.setImageDrawable(this.iZQ);
            return;
        }
        this.iZS = 50;
        c cVar = new c();
        cVar.qU(true);
        cVar.execute(new Void[0]);
    }

    private View cob() {
        this.jac.jaL = cod();
        this.jac.jaR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.coc();
            }
        });
        return this.jac.jaL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        if (this.jaf) {
            int min = Math.min(this.jah.getCount(), 200);
            this.iZT = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.jah.coe(), 0, forumInfoDataArr, 0, min);
            this.jah.Ae(min);
            this.jah.a(forumInfoDataArr);
            this.jaf = false;
            this.jac.jaS.setText(getPageContext().getString(R.string.flist_expand_list));
            this.jac.jaT.setImageDrawable(this.iZQ);
            return;
        }
        this.iZT = 50;
        b bVar = new b();
        bVar.qU(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cod() {
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
        if (!this.iZV) {
            if (i == 0) {
                this.jag.cof();
                this.jag.notifyDataSetChanged();
                this.jac.jaM.setBackgroundDrawable(this.iZO);
                this.jac.jaM.setTextColor(this.iZL);
                this.jac.jaN.setBackgroundDrawable(this.iZN);
                this.jac.jaN.setTextColor(this.iZK);
            } else if (i == 1) {
                this.jah.cof();
                this.jah.notifyDataSetChanged();
                this.jac.jaN.setBackgroundDrawable(this.iZP);
                this.jac.jaN.setTextColor(this.iZL);
                this.jac.jaM.setBackgroundDrawable(this.iZM);
                this.jac.jaM.setTextColor(this.iZK);
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
            return ForumListActivity.this.iZV ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.jac.jaK);
                    return ForumListActivity.this.jac.jaK;
                case 1:
                    viewGroup.addView(ForumListActivity.this.jac.jaL);
                    return ForumListActivity.this.jac.jaL;
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
        final ForumInfoData[] coe;
        if (i == 11002 && i2 == -1) {
            this.jaj.LoadData();
            if (this.iZU == 0) {
                coe = this.jag.coe();
            } else {
                coe = this.jah.coe();
            }
            this.cdy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (ForumListActivity.this.cdy.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.cdy.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.cdy.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.iZU == 0) {
                                ForumListActivity.this.jag.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(coe[ForumListActivity.this.jag.jau].forum_name);
                            } else if (ForumListActivity.this.iZU == 1) {
                                ForumListActivity.this.jah.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(coe[ForumListActivity.this.jah.jau].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.iZU == 0) {
                this.cdy.el(coe[this.jag.jau].forum_name, String.valueOf(coe[this.jag.jau].forum_id));
            } else {
                this.cdy.el(coe[this.jah.jau].forum_name, String.valueOf(coe[this.jah.jau].forum_id));
            }
        }
    }
}
