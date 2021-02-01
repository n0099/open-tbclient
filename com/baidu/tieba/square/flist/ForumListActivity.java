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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes8.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean jfY = false;
    private static String nqA = "";
    private static String nqB = "";
    private static String nqC = "";
    private static String nqD = "";
    private int npY;
    private int npZ;
    private Drawable nqa;
    private Drawable nqb;
    private Drawable nqc;
    private Drawable nqd;
    private Drawable nqe;
    private Drawable nqf;
    public com.baidu.tieba.square.flist.c nqp;
    private ForumListModel.RequestParams nqq;
    private com.baidu.tieba.square.flist.b nqt;
    private com.baidu.tieba.square.flist.b nqu;
    private DirMenuModel nqv;
    private ForumListDetailModel nqw;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int nqg = 200;
    private int nqh = 200;
    private int nqi = 0;
    private final LikeModel fnw = new LikeModel(getPageContext());
    private boolean nqj = false;
    private int menu_choose = 0;
    private boolean nqk = false;
    private int nql = 0;
    private int nqm = 200;
    private boolean nqn = true;
    private boolean nqo = true;
    private boolean nqr = false;
    private boolean nqs = false;
    private final ForumListDetailModel.a nqx = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nqt.dLQ() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nqp.dLW();
                ForumListActivity.this.nqp.dLV();
                if (ForumListActivity.this.nqq.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nqp.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nqq.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nqp.dLV();
                    ForumListActivity.this.nqq.recommend_type = ForumListActivity.this.nql;
                    ForumListActivity.this.nqq.rn = ForumListActivity.this.nqm;
                }
                ForumListActivity.this.nqp.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nqp.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nqk) {
                    ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqp.nrd.setImageDrawable(ForumListActivity.this.nqe);
                    ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqp.nrg.setImageDrawable(ForumListActivity.this.nqe);
                    ForumListActivity.this.nqk = false;
                }
                ForumListActivity.this.nqp.bMg.setText(ForumListActivity.this.nqq.menu_name);
                ForumListActivity.this.nqp.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nqp.nrn.Jo(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nqt.Iy(min);
                ForumListActivity.this.nqt.a(ForumListActivity.this.fnw);
                ForumListActivity.this.nqt.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nqp.nqX.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nqp.nqS.setVisibility(0);
                } else {
                    ForumListActivity.this.nqp.nqS.setVisibility(8);
                }
                ForumListActivity.this.nqp.nqZ.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nqu.Iy(min2);
                ForumListActivity.this.nqu.a(ForumListActivity.this.fnw);
                ForumListActivity.this.nqu.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nqp.nqY.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nqp.nqT.setVisibility(0);
                } else {
                    ForumListActivity.this.nqp.nqT.setVisibility(8);
                }
                ForumListActivity.this.nqp.nra.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nqp.dLV();
                if (ForumListActivity.this.nqp.nrn.getCount() > 0) {
                    ForumListActivity.this.nqp.nro.setClickable(true);
                    ForumListActivity.this.nqp.nro.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b nqy = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nqp.dLW();
                    return;
                }
                return;
            }
            eVar.nrY.add(0, eVar);
            if (ForumListActivity.this.nqp.nrn != null) {
                ForumListActivity.this.nqp.nrn.a(eVar);
                ForumListActivity.this.SJ(String.valueOf(ForumListActivity.this.nqp.bMg.getText()));
                ForumListActivity.this.nqp.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nqp.nrn.notifyDataSetChanged();
            }
            ForumListActivity.this.nqp.nro.setClickable(true);
            ForumListActivity.this.nqp.nro.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener nqz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nqp.nrj, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nqp.dLW();
            ForumListActivity.this.nqp.dLX();
            ArrayList<e> arrayList = ForumListActivity.this.nqp.nrn.dLJ().nrY;
            ForumListActivity.this.aO(arrayList.get(i).npS, arrayList.get(i).npU, arrayList.get(i).npT);
        }
    };
    private final f.c gHl = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nqt.dLS() && !ForumListActivity.this.nqu.dLS()) {
                if (ForumListActivity.this.nqn) {
                    ForumListActivity.this.nqq.recommend_type = 0;
                    ForumListActivity.this.nqq.rn = 200;
                    ForumListActivity.this.nqw.a(ForumListActivity.this.nqq);
                    ForumListActivity.this.nqw.LoadData();
                    ForumListActivity.this.nqn = false;
                } else if (ForumListActivity.this.nqp.Ze.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nqr) {
                        ForumListActivity.this.nqg = 50;
                    } else {
                        ForumListActivity.this.nqg = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nqp.Ze.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nqs) {
                        ForumListActivity.this.nqh = 50;
                    } else {
                        ForumListActivity.this.nqh = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ(String str) {
        e dLJ = this.nqp.nrn.dLJ();
        if (dLJ != null) {
            ArrayList<e> arrayList = dLJ.nrY;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).npS.equals(str)) {
                    this.menu_choose = i;
                    this.nqp.nrn.Jo(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(String str, String str2, String str3) {
        this.nqq.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nqq.menu_name = str;
        this.nqq.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nqq.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nqq.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nqq.offset = 0;
        this.nqq.rn = 10;
        this.nql = this.nqq.recommend_type;
        this.nqm = this.nqq.rn;
        this.nqq.recommend_type = 0;
        this.nqq.rn = 200;
        this.nqk = true;
        this.nqw.a(this.nqq);
        this.nqw.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nqG;

        private b() {
            this.nqG = false;
        }

        public void yj(boolean z) {
            this.nqG = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nqp.nre.setEnabled(false);
            ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nqq.recommend_type = 2;
                ForumListActivity.this.nqq.offset = 0;
                ForumListActivity.this.nqq.rn = ForumListActivity.this.nqh;
                return ForumListModel.new_fetch(ForumListActivity.this.nqq);
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
                ForumListActivity.this.nqu.Iy(min);
                ForumListActivity.this.nqu.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nqh == 200) {
                    ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqp.nrg.setImageDrawable(ForumListActivity.this.nqe);
                } else {
                    ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nqp.nrg.setImageDrawable(ForumListActivity.this.nqf);
                    ForumListActivity.this.nqs = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nqG) {
                    if (ForumListActivity.this.nqh == 200) {
                        ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nqp.nrg.setImageDrawable(ForumListActivity.this.nqe);
                    } else {
                        ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nqp.nrg.setImageDrawable(ForumListActivity.this.nqf);
                    }
                } else {
                    ForumListActivity.this.nqp.nrf.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqp.nrg.setImageDrawable(ForumListActivity.this.nqe);
                    ForumListActivity.this.nqq.rn = 200;
                    ForumListActivity.this.nqh = 200;
                }
            }
            ForumListActivity.this.nqp.nre.setEnabled(true);
            ForumListActivity.this.nqp.dLV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nqG;

        private c() {
            this.nqG = false;
        }

        public void yj(boolean z) {
            this.nqG = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nqp.nrb.setEnabled(false);
            ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nqq.recommend_type = 1;
                ForumListActivity.this.nqq.offset = 0;
                ForumListActivity.this.nqq.rn = ForumListActivity.this.nqg;
                return ForumListModel.new_fetch(ForumListActivity.this.nqq);
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
                ForumListActivity.this.nqt.Iy(min);
                ForumListActivity.this.nqt.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nqg == 200) {
                    ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqp.nrd.setImageDrawable(ForumListActivity.this.nqe);
                } else {
                    ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nqp.nrd.setImageDrawable(ForumListActivity.this.nqf);
                    ForumListActivity.this.nqr = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nqG) {
                    if (ForumListActivity.this.nqg == 200) {
                        ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nqp.nrd.setImageDrawable(ForumListActivity.this.nqe);
                    } else {
                        ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nqp.nrd.setImageDrawable(ForumListActivity.this.nqf);
                    }
                } else {
                    ForumListActivity.this.nqp.nrc.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqp.nrd.setImageDrawable(ForumListActivity.this.nqe);
                    ForumListActivity.this.nqq.rn = 200;
                    ForumListActivity.this.nqg = 200;
                }
            }
            ForumListActivity.this.nqp.nrb.setEnabled(true);
            ForumListActivity.this.nqp.dLV();
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
        this.nqp = new com.baidu.tieba.square.flist.c(this);
        this.nqp.nqX = (BdListView) dLL();
        this.nqp.nqY = (BdListView) dLN();
        this.nqp.mProgressBar.setVisibility(0);
        this.nqp.nro.setOnClickListener(null);
        this.nqp.nro.setClickable(false);
        this.nqp.Ze.setAdapter(new a());
        this.nqp.nqX.setPullRefresh(this.nqp.nrh);
        this.nqp.nqY.setPullRefresh(this.nqp.nri);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nqp.nqX.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nqp.nqY.addHeaderView(textView2, 0);
        this.nqt = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nqp.nqX.setAdapter((ListAdapter) this.nqt);
        this.nqu = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nqp.nqY.setAdapter((ListAdapter) this.nqu);
        F(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void F(String str, String str2, String str3, String str4) {
        if (au.isEmpty(str4)) {
            str4 = str;
        }
        this.nqp.bMg.setText(str4);
        this.nqp.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nqq = new ForumListModel.RequestParams();
        this.nqq.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nqq.menu_name = str4;
        this.nqq.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nqq.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nqq.parent_menu_name = str;
        this.nqq.offset = 0;
        this.nqq.rn = 10;
        if (this.nqq.menu_id != 0) {
            this.nqp.dLU();
            this.nqj = true;
            this.nqo = false;
            this.nqt.s(Boolean.valueOf(this.nqo));
            this.nqp.Ze.getAdapter().notifyDataSetChanged();
        } else {
            this.nqo = true;
            this.nqt.s(Boolean.valueOf(this.nqo));
            this.nqp.dLT();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nqp.nrh.setListPullRefreshListener(this.gHl);
        this.nqp.nri.setListPullRefreshListener(this.gHl);
        this.nqt.notifyDataSetChanged();
        this.nqu.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nqp.dLW();
        } else {
            this.nqv = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nqv.a(this.nqy);
            this.nqv.LoadData();
        }
        this.nqw = new ForumListDetailModel(getPageContext(), this.nqq);
        this.nqw.a(this.nqx);
        this.nqp.nqX.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (jfY) {
            jfY = false;
            finish();
            c(getPageContext().getPageActivity(), nqA, nqC, nqB, nqD);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nqt != null) {
                this.nqt.dLR();
                this.nqt.notifyDataSetChanged();
            }
            if (this.nqu != null) {
                this.nqu.dLR();
                this.nqu.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fnw != null) {
            this.fnw.dMN();
        }
        this.nqp.Ze.setAdapter(null);
        this.nqp.nqY.setAdapter((ListAdapter) null);
        this.nqp.nqX.setAdapter((ListAdapter) null);
        if (this.nqp.nrm != null) {
            this.nqp.nrm.setAdapter((ListAdapter) null);
        }
        if (this.nqv != null) {
            this.nqv.cancelLoadData();
        }
        if (this.nqw != null) {
            this.nqw.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nqp.iTr);
        this.nqp.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nqt.yk(true);
            this.nqu.yk(true);
        } else {
            this.nqt.yk(false);
            this.nqu.yk(false);
        }
        this.nqt.notifyDataSetChanged();
        this.nqu.notifyDataSetChanged();
        if (this.nqp.nrj != null) {
            this.nqp.nrj.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.nqp.nqU, R.drawable.bg_pop_most);
        this.npY = ap.getColor(R.color.common_color_10243);
        this.npZ = ap.getColor(R.color.CAM_X0101);
        this.nqa = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nqb = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nqc = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nqd = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nqe = ap.getDrawable(R.drawable.ico_downward);
        this.nqf = ap.getDrawable(R.drawable.ico_upward);
        this.nqt.dq(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nqu.dq(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nqp.nqT, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nqp.nrf, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.nqp.nqS, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nqp.nrc, R.color.common_color_10243, 1);
        if (this.nqr) {
            ap.setImageResource(this.nqp.nrd, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nqp.nrd, R.drawable.ico_downward);
        }
        if (this.nqs) {
            ap.setImageResource(this.nqp.nrg, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nqp.nrg, R.drawable.ico_downward);
        }
        if (this.nqp.Ze.getCurrentItem() == 0) {
            this.nqp.nqZ.setTextColor(this.npZ);
            this.nqp.nqZ.setBackgroundDrawable(this.nqc);
            this.nqp.nra.setBackgroundDrawable(this.nqb);
            this.nqp.nra.setTextColor(this.npY);
            return;
        }
        this.nqp.nra.setTextColor(this.npZ);
        this.nqp.nra.setBackgroundDrawable(this.nqd);
        this.nqp.nqZ.setBackgroundDrawable(this.nqa);
        this.nqp.nqZ.setTextColor(this.npY);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nqp.Ze.setCurrentItem(0);
            this.nqi = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nqp.Ze.setCurrentItem(1);
            this.nqi = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nqp.c(this.nqz);
        }
    }

    private View dLL() {
        this.nqp.nqX = dLP();
        this.nqp.nrb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dLM();
            }
        });
        return this.nqp.nqX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLM() {
        if (this.nqr) {
            int min = Math.min(this.nqt.getCount(), 200);
            this.nqg = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nqt.dLQ(), 0, forumInfoDataArr, 0, min);
            this.nqt.Iy(min);
            this.nqt.a(forumInfoDataArr);
            this.nqr = false;
            this.nqp.nrc.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nqp.nrd.setImageDrawable(this.nqe);
            return;
        }
        this.nqg = 50;
        c cVar = new c();
        cVar.yj(true);
        cVar.execute(new Void[0]);
    }

    private View dLN() {
        this.nqp.nqY = dLP();
        this.nqp.nre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dLO();
            }
        });
        return this.nqp.nqY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLO() {
        if (this.nqs) {
            int min = Math.min(this.nqu.getCount(), 200);
            this.nqh = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nqu.dLQ(), 0, forumInfoDataArr, 0, min);
            this.nqu.Iy(min);
            this.nqu.a(forumInfoDataArr);
            this.nqs = false;
            this.nqp.nrf.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nqp.nrg.setImageDrawable(this.nqe);
            return;
        }
        this.nqh = 50;
        b bVar = new b();
        bVar.yj(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dLP() {
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
        if (!this.nqj) {
            if (i == 0) {
                this.nqt.dLR();
                this.nqt.notifyDataSetChanged();
                this.nqp.nqZ.setBackgroundDrawable(this.nqc);
                this.nqp.nqZ.setTextColor(this.npZ);
                this.nqp.nra.setBackgroundDrawable(this.nqb);
                this.nqp.nra.setTextColor(this.npY);
            } else if (i == 1) {
                this.nqu.dLR();
                this.nqu.notifyDataSetChanged();
                this.nqp.nra.setBackgroundDrawable(this.nqd);
                this.nqp.nra.setTextColor(this.npZ);
                this.nqp.nqZ.setBackgroundDrawable(this.nqa);
                this.nqp.nqZ.setTextColor(this.npY);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes8.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.nqj ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nqp.nqX);
                    return ForumListActivity.this.nqp.nqX;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nqp.nqY);
                    return ForumListActivity.this.nqp.nqY;
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
        final ForumInfoData[] dLQ;
        if (i == 11002 && i2 == -1) {
            this.nqw.LoadData();
            if (this.nqi == 0) {
                dLQ = this.nqt.dLQ();
            } else {
                dLQ = this.nqu.dLQ();
            }
            this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (ForumListActivity.this.fnw.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.fnw.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.fnw.getErrorString());
                        } else if (((w) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.nqi == 0) {
                                ForumListActivity.this.nqt.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dLQ[ForumListActivity.this.nqt.nqH].forum_name);
                            } else if (ForumListActivity.this.nqi == 1) {
                                ForumListActivity.this.nqu.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dLQ[ForumListActivity.this.nqu.nqH].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nqi == 0) {
                this.fnw.gw(dLQ[this.nqt.nqH].forum_name, String.valueOf(dLQ[this.nqt.nqH].forum_id));
            } else {
                this.fnw.gw(dLQ[this.nqu.nqH].forum_name, String.valueOf(dLQ[this.nqu.nqH].forum_id));
            }
        }
    }
}
