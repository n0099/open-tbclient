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
/* loaded from: classes17.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean hSM = false;
    private static String lZf = "";
    private static String lZg = "";
    private static String lZh = "";
    private static String lZi = "";
    private int lYD;
    private int lYE;
    private Drawable lYF;
    private Drawable lYG;
    private Drawable lYH;
    private Drawable lYI;
    private Drawable lYJ;
    private Drawable lYK;
    public com.baidu.tieba.square.flist.c lYU;
    private ForumListModel.RequestParams lYV;
    private com.baidu.tieba.square.flist.b lYY;
    private com.baidu.tieba.square.flist.b lYZ;
    private DirMenuModel lZa;
    private ForumListDetailModel lZb;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int lYL = 200;
    private int lYM = 200;
    private int lYN = 0;
    private final LikeModel exb = new LikeModel(getPageContext());
    private boolean lYO = false;
    private int menu_choose = 0;
    private boolean lYP = false;
    private int lYQ = 0;
    private int lYR = 200;
    private boolean lYS = true;
    private boolean lYT = true;
    private boolean lYW = false;
    private boolean lYX = false;
    private final ForumListDetailModel.a lZc = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.lYY.dvi() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.lYU.dvo();
                ForumListActivity.this.lYU.dvn();
                if (ForumListActivity.this.lYV.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.lYU.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.lYV.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.lYU.dvn();
                    ForumListActivity.this.lYV.recommend_type = ForumListActivity.this.lYQ;
                    ForumListActivity.this.lYV.rn = ForumListActivity.this.lYR;
                }
                ForumListActivity.this.lYU.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.lYU.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lYP) {
                    ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYU.lZI.setImageDrawable(ForumListActivity.this.lYJ);
                    ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYU.lZL.setImageDrawable(ForumListActivity.this.lYJ);
                    ForumListActivity.this.lYP = false;
                }
                ForumListActivity.this.lYU.bpA.setText(ForumListActivity.this.lYV.menu_name);
                ForumListActivity.this.lYU.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lYU.lZS.HA(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.lYY.GM(min);
                ForumListActivity.this.lYY.a(ForumListActivity.this.exb);
                ForumListActivity.this.lYY.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.lYU.lZC.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.lYU.lZx.setVisibility(0);
                } else {
                    ForumListActivity.this.lYU.lZx.setVisibility(8);
                }
                ForumListActivity.this.lYU.lZE.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.lYZ.GM(min2);
                ForumListActivity.this.lYZ.a(ForumListActivity.this.exb);
                ForumListActivity.this.lYZ.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.lYU.lZD.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.lYU.lZy.setVisibility(0);
                } else {
                    ForumListActivity.this.lYU.lZy.setVisibility(8);
                }
                ForumListActivity.this.lYU.lZF.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.lYU.dvn();
                if (ForumListActivity.this.lYU.lZS.getCount() > 0) {
                    ForumListActivity.this.lYU.lZT.setClickable(true);
                    ForumListActivity.this.lYU.lZT.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b lZd = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.lYU.dvo();
                    return;
                }
                return;
            }
            eVar.maG.add(0, eVar);
            if (ForumListActivity.this.lYU.lZS != null) {
                ForumListActivity.this.lYU.lZS.a(eVar);
                ForumListActivity.this.Qs(String.valueOf(ForumListActivity.this.lYU.bpA.getText()));
                ForumListActivity.this.lYU.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lYU.lZS.notifyDataSetChanged();
            }
            ForumListActivity.this.lYU.lZT.setClickable(true);
            ForumListActivity.this.lYU.lZT.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener lZe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.lYU.lZO, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.lYU.dvo();
            ForumListActivity.this.lYU.dvp();
            ArrayList<e> arrayList = ForumListActivity.this.lYU.lZS.dvb().maG;
            ForumListActivity.this.ax(arrayList.get(i).lYx, arrayList.get(i).lYz, arrayList.get(i).lYy);
        }
    };
    private final f.c fKP = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.lYY.dvk() && !ForumListActivity.this.lYZ.dvk()) {
                if (ForumListActivity.this.lYS) {
                    ForumListActivity.this.lYV.recommend_type = 0;
                    ForumListActivity.this.lYV.rn = 200;
                    ForumListActivity.this.lZb.a(ForumListActivity.this.lYV);
                    ForumListActivity.this.lZb.LoadData();
                    ForumListActivity.this.lYS = false;
                } else if (ForumListActivity.this.lYU.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.lYW) {
                        ForumListActivity.this.lYL = 50;
                    } else {
                        ForumListActivity.this.lYL = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.lYU.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.lYX) {
                        ForumListActivity.this.lYM = 50;
                    } else {
                        ForumListActivity.this.lYM = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Qs(String str) {
        e dvb = this.lYU.lZS.dvb();
        if (dvb != null) {
            ArrayList<e> arrayList = dvb.maG;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).lYx.equals(str)) {
                    this.menu_choose = i;
                    this.lYU.lZS.HA(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.lYV.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lYV.menu_name = str;
        this.lYV.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lYV.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.lYV.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.lYV.offset = 0;
        this.lYV.rn = 10;
        this.lYQ = this.lYV.recommend_type;
        this.lYR = this.lYV.rn;
        this.lYV.recommend_type = 0;
        this.lYV.rn = 200;
        this.lYP = true;
        this.lZb.a(this.lYV);
        this.lZb.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lZl;

        private b() {
            this.lZl = false;
        }

        public void vU(boolean z) {
            this.lZl = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lYU.lZJ.setEnabled(false);
            ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lYV.recommend_type = 2;
                ForumListActivity.this.lYV.offset = 0;
                ForumListActivity.this.lYV.rn = ForumListActivity.this.lYM;
                return ForumListModel.new_fetch(ForumListActivity.this.lYV);
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
                ForumListActivity.this.lYZ.GM(min);
                ForumListActivity.this.lYZ.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.lYM == 200) {
                    ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYU.lZL.setImageDrawable(ForumListActivity.this.lYJ);
                } else {
                    ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lYU.lZL.setImageDrawable(ForumListActivity.this.lYK);
                    ForumListActivity.this.lYX = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lZl) {
                    if (ForumListActivity.this.lYM == 200) {
                        ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lYU.lZL.setImageDrawable(ForumListActivity.this.lYJ);
                    } else {
                        ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lYU.lZL.setImageDrawable(ForumListActivity.this.lYK);
                    }
                } else {
                    ForumListActivity.this.lYU.lZK.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYU.lZL.setImageDrawable(ForumListActivity.this.lYJ);
                    ForumListActivity.this.lYV.rn = 200;
                    ForumListActivity.this.lYM = 200;
                }
            }
            ForumListActivity.this.lYU.lZJ.setEnabled(true);
            ForumListActivity.this.lYU.dvn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lZl;

        private c() {
            this.lZl = false;
        }

        public void vU(boolean z) {
            this.lZl = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lYU.lZG.setEnabled(false);
            ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lYV.recommend_type = 1;
                ForumListActivity.this.lYV.offset = 0;
                ForumListActivity.this.lYV.rn = ForumListActivity.this.lYL;
                return ForumListModel.new_fetch(ForumListActivity.this.lYV);
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
                ForumListActivity.this.lYY.GM(min);
                ForumListActivity.this.lYY.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.lYL == 200) {
                    ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYU.lZI.setImageDrawable(ForumListActivity.this.lYJ);
                } else {
                    ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lYU.lZI.setImageDrawable(ForumListActivity.this.lYK);
                    ForumListActivity.this.lYW = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lZl) {
                    if (ForumListActivity.this.lYL == 200) {
                        ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lYU.lZI.setImageDrawable(ForumListActivity.this.lYJ);
                    } else {
                        ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lYU.lZI.setImageDrawable(ForumListActivity.this.lYK);
                    }
                } else {
                    ForumListActivity.this.lYU.lZH.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYU.lZI.setImageDrawable(ForumListActivity.this.lYJ);
                    ForumListActivity.this.lYV.rn = 200;
                    ForumListActivity.this.lYL = 200;
                }
            }
            ForumListActivity.this.lYU.lZG.setEnabled(true);
            ForumListActivity.this.lYU.dvn();
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
        this.lYU = new com.baidu.tieba.square.flist.c(this);
        this.lYU.lZC = (BdListView) dvd();
        this.lYU.lZD = (BdListView) dvf();
        this.lYU.mProgressBar.setVisibility(0);
        this.lYU.lZT.setOnClickListener(null);
        this.lYU.lZT.setClickable(false);
        this.lYU.mViewPager.setAdapter(new a());
        this.lYU.lZC.setPullRefresh(this.lYU.lZM);
        this.lYU.lZD.setPullRefresh(this.lYU.lZN);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.lYU.lZC.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.lYU.lZD.addHeaderView(textView2, 0);
        this.lYY = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.lYU.lZC.setAdapter((ListAdapter) this.lYY);
        this.lYZ = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.lYU.lZD.setAdapter((ListAdapter) this.lYZ);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.lYU.bpA.setText(str4);
        this.lYU.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.lYV = new ForumListModel.RequestParams();
        this.lYV.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lYV.menu_name = str4;
        this.lYV.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lYV.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lYV.parent_menu_name = str;
        this.lYV.offset = 0;
        this.lYV.rn = 10;
        if (this.lYV.menu_id != 0) {
            this.lYU.dvm();
            this.lYO = true;
            this.lYT = false;
            this.lYY.q(Boolean.valueOf(this.lYT));
            this.lYU.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.lYT = true;
            this.lYY.q(Boolean.valueOf(this.lYT));
            this.lYU.dvl();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.lYU.lZM.setListPullRefreshListener(this.fKP);
        this.lYU.lZN.setListPullRefreshListener(this.fKP);
        this.lYY.notifyDataSetChanged();
        this.lYZ.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.lYU.dvo();
        } else {
            this.lZa = new DirMenuModel(getPageContext(), str, str3, str2);
            this.lZa.a(this.lZd);
            this.lZa.LoadData();
        }
        this.lZb = new ForumListDetailModel(getPageContext(), this.lYV);
        this.lZb.a(this.lZc);
        this.lYU.lZC.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hSM) {
            hSM = false;
            finish();
            c(getPageContext().getPageActivity(), lZf, lZh, lZg, lZi);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.lYY != null) {
                this.lYY.dvj();
                this.lYY.notifyDataSetChanged();
            }
            if (this.lYZ != null) {
                this.lYZ.dvj();
                this.lYZ.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.exb != null) {
            this.exb.dwd();
        }
        this.lYU.mViewPager.setAdapter(null);
        this.lYU.lZD.setAdapter((ListAdapter) null);
        this.lYU.lZC.setAdapter((ListAdapter) null);
        if (this.lYU.lZR != null) {
            this.lYU.lZR.setAdapter((ListAdapter) null);
        }
        if (this.lZa != null) {
            this.lZa.cancelLoadData();
        }
        if (this.lZb != null) {
            this.lZb.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lYU.hGc);
        this.lYU.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lYY.vV(true);
            this.lYZ.vV(true);
        } else {
            this.lYY.vV(false);
            this.lYZ.vV(false);
        }
        this.lYY.notifyDataSetChanged();
        this.lYZ.notifyDataSetChanged();
        if (this.lYU.lZO != null) {
            this.lYU.lZO.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.lYU.lZz, R.drawable.bg_pop_most);
        this.lYD = ap.getColor(R.color.common_color_10243);
        this.lYE = ap.getColor(R.color.cp_cont_a);
        this.lYF = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lYG = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.lYH = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lYI = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.lYJ = ap.getDrawable(R.drawable.ico_downward);
        this.lYK = ap.getDrawable(R.drawable.ico_upward);
        this.lYY.dj(R.drawable.btn_add_end, R.drawable.btn_add);
        this.lYZ.dj(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.lYU.lZy, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.lYU.lZK, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.lYU.lZx, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.lYU.lZH, R.color.common_color_10243, 1);
        if (this.lYW) {
            ap.setImageResource(this.lYU.lZI, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.lYU.lZI, R.drawable.ico_downward);
        }
        if (this.lYX) {
            ap.setImageResource(this.lYU.lZL, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.lYU.lZL, R.drawable.ico_downward);
        }
        if (this.lYU.mViewPager.getCurrentItem() == 0) {
            this.lYU.lZE.setTextColor(this.lYE);
            this.lYU.lZE.setBackgroundDrawable(this.lYH);
            this.lYU.lZF.setBackgroundDrawable(this.lYG);
            this.lYU.lZF.setTextColor(this.lYD);
            return;
        }
        this.lYU.lZF.setTextColor(this.lYE);
        this.lYU.lZF.setBackgroundDrawable(this.lYI);
        this.lYU.lZE.setBackgroundDrawable(this.lYF);
        this.lYU.lZE.setTextColor(this.lYD);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.lYU.mViewPager.setCurrentItem(0);
            this.lYN = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.lYU.mViewPager.setCurrentItem(1);
            this.lYN = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.lYU.c(this.lZe);
        }
    }

    private View dvd() {
        this.lYU.lZC = dvh();
        this.lYU.lZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dve();
            }
        });
        return this.lYU.lZC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dve() {
        if (this.lYW) {
            int min = Math.min(this.lYY.getCount(), 200);
            this.lYL = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lYY.dvi(), 0, forumInfoDataArr, 0, min);
            this.lYY.GM(min);
            this.lYY.a(forumInfoDataArr);
            this.lYW = false;
            this.lYU.lZH.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lYU.lZI.setImageDrawable(this.lYJ);
            return;
        }
        this.lYL = 50;
        c cVar = new c();
        cVar.vU(true);
        cVar.execute(new Void[0]);
    }

    private View dvf() {
        this.lYU.lZD = dvh();
        this.lYU.lZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dvg();
            }
        });
        return this.lYU.lZD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvg() {
        if (this.lYX) {
            int min = Math.min(this.lYZ.getCount(), 200);
            this.lYM = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lYZ.dvi(), 0, forumInfoDataArr, 0, min);
            this.lYZ.GM(min);
            this.lYZ.a(forumInfoDataArr);
            this.lYX = false;
            this.lYU.lZK.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lYU.lZL.setImageDrawable(this.lYJ);
            return;
        }
        this.lYM = 50;
        b bVar = new b();
        bVar.vU(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dvh() {
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
        if (!this.lYO) {
            if (i == 0) {
                this.lYY.dvj();
                this.lYY.notifyDataSetChanged();
                this.lYU.lZE.setBackgroundDrawable(this.lYH);
                this.lYU.lZE.setTextColor(this.lYE);
                this.lYU.lZF.setBackgroundDrawable(this.lYG);
                this.lYU.lZF.setTextColor(this.lYD);
            } else if (i == 1) {
                this.lYZ.dvj();
                this.lYZ.notifyDataSetChanged();
                this.lYU.lZF.setBackgroundDrawable(this.lYI);
                this.lYU.lZF.setTextColor(this.lYE);
                this.lYU.lZE.setBackgroundDrawable(this.lYF);
                this.lYU.lZE.setTextColor(this.lYD);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes17.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.lYO ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.lYU.lZC);
                    return ForumListActivity.this.lYU.lZC;
                case 1:
                    viewGroup.addView(ForumListActivity.this.lYU.lZD);
                    return ForumListActivity.this.lYU.lZD;
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
        final ForumInfoData[] dvi;
        if (i == 11002 && i2 == -1) {
            this.lZb.LoadData();
            if (this.lYN == 0) {
                dvi = this.lYY.dvi();
            } else {
                dvi = this.lYZ.dvi();
            }
            this.exb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.exb.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.exb.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.exb.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.lYN == 0) {
                                ForumListActivity.this.lYY.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dvi[ForumListActivity.this.lYY.lZm].forum_name);
                            } else if (ForumListActivity.this.lYN == 1) {
                                ForumListActivity.this.lYZ.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dvi[ForumListActivity.this.lYZ.lZm].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.lYN == 0) {
                this.exb.fR(dvi[this.lYY.lZm].forum_name, String.valueOf(dvi[this.lYY.lZm].forum_id));
            } else {
                this.exb.fR(dvi[this.lYZ.lZm].forum_name, String.valueOf(dvi[this.lYZ.lZm].forum_id));
            }
        }
    }
}
