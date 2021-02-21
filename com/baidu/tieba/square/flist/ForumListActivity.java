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
    public static boolean jgm = false;
    private static String nra = "";
    private static String nrb = "";
    private static String nrc = "";
    private static String nrd = "";
    private Drawable nqA;
    private Drawable nqB;
    private Drawable nqC;
    private Drawable nqD;
    private Drawable nqE;
    private Drawable nqF;
    public com.baidu.tieba.square.flist.c nqP;
    private ForumListModel.RequestParams nqQ;
    private com.baidu.tieba.square.flist.b nqT;
    private com.baidu.tieba.square.flist.b nqU;
    private DirMenuModel nqV;
    private ForumListDetailModel nqW;
    private int nqy;
    private int nqz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int nqG = 200;
    private int nqH = 200;
    private int nqI = 0;
    private final LikeModel fnw = new LikeModel(getPageContext());
    private boolean nqJ = false;
    private int menu_choose = 0;
    private boolean nqK = false;
    private int nqL = 0;
    private int nqM = 200;
    private boolean nqN = true;
    private boolean nqO = true;
    private boolean nqR = false;
    private boolean nqS = false;
    private final ForumListDetailModel.a nqX = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nqT.dLY() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nqP.dMe();
                ForumListActivity.this.nqP.dMd();
                if (ForumListActivity.this.nqQ.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nqP.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nqQ.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nqP.dMd();
                    ForumListActivity.this.nqQ.recommend_type = ForumListActivity.this.nqL;
                    ForumListActivity.this.nqQ.rn = ForumListActivity.this.nqM;
                }
                ForumListActivity.this.nqP.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nqP.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nqK) {
                    ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqP.nrD.setImageDrawable(ForumListActivity.this.nqE);
                    ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqP.nrG.setImageDrawable(ForumListActivity.this.nqE);
                    ForumListActivity.this.nqK = false;
                }
                ForumListActivity.this.nqP.bMg.setText(ForumListActivity.this.nqQ.menu_name);
                ForumListActivity.this.nqP.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nqP.nrN.Jo(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nqT.Iy(min);
                ForumListActivity.this.nqT.a(ForumListActivity.this.fnw);
                ForumListActivity.this.nqT.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nqP.nrx.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nqP.nrs.setVisibility(0);
                } else {
                    ForumListActivity.this.nqP.nrs.setVisibility(8);
                }
                ForumListActivity.this.nqP.nrz.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nqU.Iy(min2);
                ForumListActivity.this.nqU.a(ForumListActivity.this.fnw);
                ForumListActivity.this.nqU.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nqP.nry.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nqP.nrt.setVisibility(0);
                } else {
                    ForumListActivity.this.nqP.nrt.setVisibility(8);
                }
                ForumListActivity.this.nqP.nrA.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nqP.dMd();
                if (ForumListActivity.this.nqP.nrN.getCount() > 0) {
                    ForumListActivity.this.nqP.nrO.setClickable(true);
                    ForumListActivity.this.nqP.nrO.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b nqY = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nqP.dMe();
                    return;
                }
                return;
            }
            eVar.nsy.add(0, eVar);
            if (ForumListActivity.this.nqP.nrN != null) {
                ForumListActivity.this.nqP.nrN.a(eVar);
                ForumListActivity.this.SV(String.valueOf(ForumListActivity.this.nqP.bMg.getText()));
                ForumListActivity.this.nqP.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nqP.nrN.notifyDataSetChanged();
            }
            ForumListActivity.this.nqP.nrO.setClickable(true);
            ForumListActivity.this.nqP.nrO.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener nqZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nqP.nrJ, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nqP.dMe();
            ForumListActivity.this.nqP.dMf();
            ArrayList<e> arrayList = ForumListActivity.this.nqP.nrN.dLR().nsy;
            ForumListActivity.this.aO(arrayList.get(i).nqs, arrayList.get(i).nqu, arrayList.get(i).nqt);
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nqT.dMa() && !ForumListActivity.this.nqU.dMa()) {
                if (ForumListActivity.this.nqN) {
                    ForumListActivity.this.nqQ.recommend_type = 0;
                    ForumListActivity.this.nqQ.rn = 200;
                    ForumListActivity.this.nqW.a(ForumListActivity.this.nqQ);
                    ForumListActivity.this.nqW.LoadData();
                    ForumListActivity.this.nqN = false;
                } else if (ForumListActivity.this.nqP.Ze.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nqR) {
                        ForumListActivity.this.nqG = 50;
                    } else {
                        ForumListActivity.this.nqG = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nqP.Ze.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nqS) {
                        ForumListActivity.this.nqH = 50;
                    } else {
                        ForumListActivity.this.nqH = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SV(String str) {
        e dLR = this.nqP.nrN.dLR();
        if (dLR != null) {
            ArrayList<e> arrayList = dLR.nsy;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).nqs.equals(str)) {
                    this.menu_choose = i;
                    this.nqP.nrN.Jo(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(String str, String str2, String str3) {
        this.nqQ.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nqQ.menu_name = str;
        this.nqQ.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nqQ.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nqQ.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nqQ.offset = 0;
        this.nqQ.rn = 10;
        this.nqL = this.nqQ.recommend_type;
        this.nqM = this.nqQ.rn;
        this.nqQ.recommend_type = 0;
        this.nqQ.rn = 200;
        this.nqK = true;
        this.nqW.a(this.nqQ);
        this.nqW.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nrg;

        private b() {
            this.nrg = false;
        }

        public void yj(boolean z) {
            this.nrg = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nqP.nrE.setEnabled(false);
            ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nqQ.recommend_type = 2;
                ForumListActivity.this.nqQ.offset = 0;
                ForumListActivity.this.nqQ.rn = ForumListActivity.this.nqH;
                return ForumListModel.new_fetch(ForumListActivity.this.nqQ);
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
                ForumListActivity.this.nqU.Iy(min);
                ForumListActivity.this.nqU.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nqH == 200) {
                    ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqP.nrG.setImageDrawable(ForumListActivity.this.nqE);
                } else {
                    ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nqP.nrG.setImageDrawable(ForumListActivity.this.nqF);
                    ForumListActivity.this.nqS = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nrg) {
                    if (ForumListActivity.this.nqH == 200) {
                        ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nqP.nrG.setImageDrawable(ForumListActivity.this.nqE);
                    } else {
                        ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nqP.nrG.setImageDrawable(ForumListActivity.this.nqF);
                    }
                } else {
                    ForumListActivity.this.nqP.nrF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqP.nrG.setImageDrawable(ForumListActivity.this.nqE);
                    ForumListActivity.this.nqQ.rn = 200;
                    ForumListActivity.this.nqH = 200;
                }
            }
            ForumListActivity.this.nqP.nrE.setEnabled(true);
            ForumListActivity.this.nqP.dMd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nrg;

        private c() {
            this.nrg = false;
        }

        public void yj(boolean z) {
            this.nrg = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nqP.nrB.setEnabled(false);
            ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nqQ.recommend_type = 1;
                ForumListActivity.this.nqQ.offset = 0;
                ForumListActivity.this.nqQ.rn = ForumListActivity.this.nqG;
                return ForumListModel.new_fetch(ForumListActivity.this.nqQ);
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
                ForumListActivity.this.nqT.Iy(min);
                ForumListActivity.this.nqT.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nqG == 200) {
                    ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqP.nrD.setImageDrawable(ForumListActivity.this.nqE);
                } else {
                    ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nqP.nrD.setImageDrawable(ForumListActivity.this.nqF);
                    ForumListActivity.this.nqR = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nrg) {
                    if (ForumListActivity.this.nqG == 200) {
                        ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nqP.nrD.setImageDrawable(ForumListActivity.this.nqE);
                    } else {
                        ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nqP.nrD.setImageDrawable(ForumListActivity.this.nqF);
                    }
                } else {
                    ForumListActivity.this.nqP.nrC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nqP.nrD.setImageDrawable(ForumListActivity.this.nqE);
                    ForumListActivity.this.nqQ.rn = 200;
                    ForumListActivity.this.nqG = 200;
                }
            }
            ForumListActivity.this.nqP.nrB.setEnabled(true);
            ForumListActivity.this.nqP.dMd();
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
        this.nqP = new com.baidu.tieba.square.flist.c(this);
        this.nqP.nrx = (BdListView) dLT();
        this.nqP.nry = (BdListView) dLV();
        this.nqP.mProgressBar.setVisibility(0);
        this.nqP.nrO.setOnClickListener(null);
        this.nqP.nrO.setClickable(false);
        this.nqP.Ze.setAdapter(new a());
        this.nqP.nrx.setPullRefresh(this.nqP.nrH);
        this.nqP.nry.setPullRefresh(this.nqP.nrI);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nqP.nrx.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nqP.nry.addHeaderView(textView2, 0);
        this.nqT = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nqP.nrx.setAdapter((ListAdapter) this.nqT);
        this.nqU = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nqP.nry.setAdapter((ListAdapter) this.nqU);
        F(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void F(String str, String str2, String str3, String str4) {
        if (au.isEmpty(str4)) {
            str4 = str;
        }
        this.nqP.bMg.setText(str4);
        this.nqP.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nqQ = new ForumListModel.RequestParams();
        this.nqQ.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nqQ.menu_name = str4;
        this.nqQ.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nqQ.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nqQ.parent_menu_name = str;
        this.nqQ.offset = 0;
        this.nqQ.rn = 10;
        if (this.nqQ.menu_id != 0) {
            this.nqP.dMc();
            this.nqJ = true;
            this.nqO = false;
            this.nqT.s(Boolean.valueOf(this.nqO));
            this.nqP.Ze.getAdapter().notifyDataSetChanged();
        } else {
            this.nqO = true;
            this.nqT.s(Boolean.valueOf(this.nqO));
            this.nqP.dMb();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nqP.nrH.setListPullRefreshListener(this.gHz);
        this.nqP.nrI.setListPullRefreshListener(this.gHz);
        this.nqT.notifyDataSetChanged();
        this.nqU.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nqP.dMe();
        } else {
            this.nqV = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nqV.a(this.nqY);
            this.nqV.LoadData();
        }
        this.nqW = new ForumListDetailModel(getPageContext(), this.nqQ);
        this.nqW.a(this.nqX);
        this.nqP.nrx.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (jgm) {
            jgm = false;
            finish();
            c(getPageContext().getPageActivity(), nra, nrc, nrb, nrd);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nqT != null) {
                this.nqT.dLZ();
                this.nqT.notifyDataSetChanged();
            }
            if (this.nqU != null) {
                this.nqU.dLZ();
                this.nqU.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fnw != null) {
            this.fnw.dMV();
        }
        this.nqP.Ze.setAdapter(null);
        this.nqP.nry.setAdapter((ListAdapter) null);
        this.nqP.nrx.setAdapter((ListAdapter) null);
        if (this.nqP.nrM != null) {
            this.nqP.nrM.setAdapter((ListAdapter) null);
        }
        if (this.nqV != null) {
            this.nqV.cancelLoadData();
        }
        if (this.nqW != null) {
            this.nqW.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nqP.iTF);
        this.nqP.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nqT.yk(true);
            this.nqU.yk(true);
        } else {
            this.nqT.yk(false);
            this.nqU.yk(false);
        }
        this.nqT.notifyDataSetChanged();
        this.nqU.notifyDataSetChanged();
        if (this.nqP.nrJ != null) {
            this.nqP.nrJ.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.nqP.nru, R.drawable.bg_pop_most);
        this.nqy = ap.getColor(R.color.common_color_10243);
        this.nqz = ap.getColor(R.color.CAM_X0101);
        this.nqA = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nqB = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nqC = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nqD = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nqE = ap.getDrawable(R.drawable.ico_downward);
        this.nqF = ap.getDrawable(R.drawable.ico_upward);
        this.nqT.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nqU.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nqP.nrt, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nqP.nrF, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.nqP.nrs, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nqP.nrC, R.color.common_color_10243, 1);
        if (this.nqR) {
            ap.setImageResource(this.nqP.nrD, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nqP.nrD, R.drawable.ico_downward);
        }
        if (this.nqS) {
            ap.setImageResource(this.nqP.nrG, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nqP.nrG, R.drawable.ico_downward);
        }
        if (this.nqP.Ze.getCurrentItem() == 0) {
            this.nqP.nrz.setTextColor(this.nqz);
            this.nqP.nrz.setBackgroundDrawable(this.nqC);
            this.nqP.nrA.setBackgroundDrawable(this.nqB);
            this.nqP.nrA.setTextColor(this.nqy);
            return;
        }
        this.nqP.nrA.setTextColor(this.nqz);
        this.nqP.nrA.setBackgroundDrawable(this.nqD);
        this.nqP.nrz.setBackgroundDrawable(this.nqA);
        this.nqP.nrz.setTextColor(this.nqy);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nqP.Ze.setCurrentItem(0);
            this.nqI = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nqP.Ze.setCurrentItem(1);
            this.nqI = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nqP.c(this.nqZ);
        }
    }

    private View dLT() {
        this.nqP.nrx = dLX();
        this.nqP.nrB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dLU();
            }
        });
        return this.nqP.nrx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLU() {
        if (this.nqR) {
            int min = Math.min(this.nqT.getCount(), 200);
            this.nqG = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nqT.dLY(), 0, forumInfoDataArr, 0, min);
            this.nqT.Iy(min);
            this.nqT.a(forumInfoDataArr);
            this.nqR = false;
            this.nqP.nrC.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nqP.nrD.setImageDrawable(this.nqE);
            return;
        }
        this.nqG = 50;
        c cVar = new c();
        cVar.yj(true);
        cVar.execute(new Void[0]);
    }

    private View dLV() {
        this.nqP.nry = dLX();
        this.nqP.nrE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dLW();
            }
        });
        return this.nqP.nry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLW() {
        if (this.nqS) {
            int min = Math.min(this.nqU.getCount(), 200);
            this.nqH = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nqU.dLY(), 0, forumInfoDataArr, 0, min);
            this.nqU.Iy(min);
            this.nqU.a(forumInfoDataArr);
            this.nqS = false;
            this.nqP.nrF.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nqP.nrG.setImageDrawable(this.nqE);
            return;
        }
        this.nqH = 50;
        b bVar = new b();
        bVar.yj(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dLX() {
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
        if (!this.nqJ) {
            if (i == 0) {
                this.nqT.dLZ();
                this.nqT.notifyDataSetChanged();
                this.nqP.nrz.setBackgroundDrawable(this.nqC);
                this.nqP.nrz.setTextColor(this.nqz);
                this.nqP.nrA.setBackgroundDrawable(this.nqB);
                this.nqP.nrA.setTextColor(this.nqy);
            } else if (i == 1) {
                this.nqU.dLZ();
                this.nqU.notifyDataSetChanged();
                this.nqP.nrA.setBackgroundDrawable(this.nqD);
                this.nqP.nrA.setTextColor(this.nqz);
                this.nqP.nrz.setBackgroundDrawable(this.nqA);
                this.nqP.nrz.setTextColor(this.nqy);
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
            return ForumListActivity.this.nqJ ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nqP.nrx);
                    return ForumListActivity.this.nqP.nrx;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nqP.nry);
                    return ForumListActivity.this.nqP.nry;
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
        final ForumInfoData[] dLY;
        if (i == 11002 && i2 == -1) {
            this.nqW.LoadData();
            if (this.nqI == 0) {
                dLY = this.nqT.dLY();
            } else {
                dLY = this.nqU.dLY();
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
                            if (ForumListActivity.this.nqI == 0) {
                                ForumListActivity.this.nqT.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dLY[ForumListActivity.this.nqT.nrh].forum_name);
                            } else if (ForumListActivity.this.nqI == 1) {
                                ForumListActivity.this.nqU.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dLY[ForumListActivity.this.nqU.nrh].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nqI == 0) {
                this.fnw.gy(dLY[this.nqT.nrh].forum_name, String.valueOf(dLY[this.nqT.nrh].forum_id));
            } else {
                this.fnw.gy(dLY[this.nqU.nrh].forum_name, String.valueOf(dLY[this.nqU.nrh].forum_id));
            }
        }
    }
}
