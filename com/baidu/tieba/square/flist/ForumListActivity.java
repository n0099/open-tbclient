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
/* loaded from: classes23.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean iSO = false;
    private static String nfR = "";
    private static String nfS = "";
    private static String nfT = "";
    private static String nfU = "";
    public com.baidu.tieba.square.flist.c nfG;
    private ForumListModel.RequestParams nfH;
    private com.baidu.tieba.square.flist.b nfK;
    private com.baidu.tieba.square.flist.b nfL;
    private DirMenuModel nfM;
    private ForumListDetailModel nfN;
    private int nfp;
    private int nfq;
    private Drawable nfr;
    private Drawable nfs;
    private Drawable nft;
    private Drawable nfu;
    private Drawable nfv;
    private Drawable nfw;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int nfx = 200;
    private int nfy = 200;
    private int nfz = 0;
    private final LikeModel fgf = new LikeModel(getPageContext());
    private boolean nfA = false;
    private int menu_choose = 0;
    private boolean nfB = false;
    private int nfC = 0;
    private int nfD = 200;
    private boolean nfE = true;
    private boolean nfF = true;
    private boolean nfI = false;
    private boolean nfJ = false;
    private final ForumListDetailModel.a nfO = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nfK.dNE() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nfG.dNK();
                ForumListActivity.this.nfG.dNJ();
                if (ForumListActivity.this.nfH.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nfG.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nfH.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nfG.dNJ();
                    ForumListActivity.this.nfH.recommend_type = ForumListActivity.this.nfC;
                    ForumListActivity.this.nfH.rn = ForumListActivity.this.nfD;
                }
                ForumListActivity.this.nfG.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nfG.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nfB) {
                    ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfG.ngu.setImageDrawable(ForumListActivity.this.nfv);
                    ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfG.ngx.setImageDrawable(ForumListActivity.this.nfv);
                    ForumListActivity.this.nfB = false;
                }
                ForumListActivity.this.nfG.bIt.setText(ForumListActivity.this.nfH.menu_name);
                ForumListActivity.this.nfG.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nfG.ngE.KG(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nfK.JR(min);
                ForumListActivity.this.nfK.a(ForumListActivity.this.fgf);
                ForumListActivity.this.nfK.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nfG.ngo.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nfG.ngj.setVisibility(0);
                } else {
                    ForumListActivity.this.nfG.ngj.setVisibility(8);
                }
                ForumListActivity.this.nfG.ngq.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nfL.JR(min2);
                ForumListActivity.this.nfL.a(ForumListActivity.this.fgf);
                ForumListActivity.this.nfL.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nfG.ngp.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nfG.ngk.setVisibility(0);
                } else {
                    ForumListActivity.this.nfG.ngk.setVisibility(8);
                }
                ForumListActivity.this.nfG.ngr.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nfG.dNJ();
                if (ForumListActivity.this.nfG.ngE.getCount() > 0) {
                    ForumListActivity.this.nfG.ngF.setClickable(true);
                    ForumListActivity.this.nfG.ngF.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b nfP = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nfG.dNK();
                    return;
                }
                return;
            }
            eVar.nhp.add(0, eVar);
            if (ForumListActivity.this.nfG.ngE != null) {
                ForumListActivity.this.nfG.ngE.a(eVar);
                ForumListActivity.this.Tl(String.valueOf(ForumListActivity.this.nfG.bIt.getText()));
                ForumListActivity.this.nfG.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nfG.ngE.notifyDataSetChanged();
            }
            ForumListActivity.this.nfG.ngF.setClickable(true);
            ForumListActivity.this.nfG.ngF.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener nfQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nfG.ngA, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nfG.dNK();
            ForumListActivity.this.nfG.dNL();
            ArrayList<e> arrayList = ForumListActivity.this.nfG.ngE.dNx().nhp;
            ForumListActivity.this.aK(arrayList.get(i).nfj, arrayList.get(i).nfl, arrayList.get(i).nfk);
        }
    };
    private final f.c gye = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nfK.dNG() && !ForumListActivity.this.nfL.dNG()) {
                if (ForumListActivity.this.nfE) {
                    ForumListActivity.this.nfH.recommend_type = 0;
                    ForumListActivity.this.nfH.rn = 200;
                    ForumListActivity.this.nfN.a(ForumListActivity.this.nfH);
                    ForumListActivity.this.nfN.LoadData();
                    ForumListActivity.this.nfE = false;
                } else if (ForumListActivity.this.nfG.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nfI) {
                        ForumListActivity.this.nfx = 50;
                    } else {
                        ForumListActivity.this.nfx = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nfG.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nfJ) {
                        ForumListActivity.this.nfy = 50;
                    } else {
                        ForumListActivity.this.nfy = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl(String str) {
        e dNx = this.nfG.ngE.dNx();
        if (dNx != null) {
            ArrayList<e> arrayList = dNx.nhp;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).nfj.equals(str)) {
                    this.menu_choose = i;
                    this.nfG.ngE.KG(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(String str, String str2, String str3) {
        this.nfH.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nfH.menu_name = str;
        this.nfH.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nfH.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nfH.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nfH.offset = 0;
        this.nfH.rn = 10;
        this.nfC = this.nfH.recommend_type;
        this.nfD = this.nfH.rn;
        this.nfH.recommend_type = 0;
        this.nfH.rn = 200;
        this.nfB = true;
        this.nfN.a(this.nfH);
        this.nfN.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nfX;

        private b() {
            this.nfX = false;
        }

        public void xS(boolean z) {
            this.nfX = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nfG.ngv.setEnabled(false);
            ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nfH.recommend_type = 2;
                ForumListActivity.this.nfH.offset = 0;
                ForumListActivity.this.nfH.rn = ForumListActivity.this.nfy;
                return ForumListModel.new_fetch(ForumListActivity.this.nfH);
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
                ForumListActivity.this.nfL.JR(min);
                ForumListActivity.this.nfL.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nfy == 200) {
                    ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfG.ngx.setImageDrawable(ForumListActivity.this.nfv);
                } else {
                    ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nfG.ngx.setImageDrawable(ForumListActivity.this.nfw);
                    ForumListActivity.this.nfJ = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nfX) {
                    if (ForumListActivity.this.nfy == 200) {
                        ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nfG.ngx.setImageDrawable(ForumListActivity.this.nfv);
                    } else {
                        ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nfG.ngx.setImageDrawable(ForumListActivity.this.nfw);
                    }
                } else {
                    ForumListActivity.this.nfG.ngw.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfG.ngx.setImageDrawable(ForumListActivity.this.nfv);
                    ForumListActivity.this.nfH.rn = 200;
                    ForumListActivity.this.nfy = 200;
                }
            }
            ForumListActivity.this.nfG.ngv.setEnabled(true);
            ForumListActivity.this.nfG.dNJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nfX;

        private c() {
            this.nfX = false;
        }

        public void xS(boolean z) {
            this.nfX = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nfG.ngs.setEnabled(false);
            ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nfH.recommend_type = 1;
                ForumListActivity.this.nfH.offset = 0;
                ForumListActivity.this.nfH.rn = ForumListActivity.this.nfx;
                return ForumListModel.new_fetch(ForumListActivity.this.nfH);
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
                ForumListActivity.this.nfK.JR(min);
                ForumListActivity.this.nfK.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nfx == 200) {
                    ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfG.ngu.setImageDrawable(ForumListActivity.this.nfv);
                } else {
                    ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nfG.ngu.setImageDrawable(ForumListActivity.this.nfw);
                    ForumListActivity.this.nfI = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nfX) {
                    if (ForumListActivity.this.nfx == 200) {
                        ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nfG.ngu.setImageDrawable(ForumListActivity.this.nfv);
                    } else {
                        ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nfG.ngu.setImageDrawable(ForumListActivity.this.nfw);
                    }
                } else {
                    ForumListActivity.this.nfG.ngt.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfG.ngu.setImageDrawable(ForumListActivity.this.nfv);
                    ForumListActivity.this.nfH.rn = 200;
                    ForumListActivity.this.nfx = 200;
                }
            }
            ForumListActivity.this.nfG.ngs.setEnabled(true);
            ForumListActivity.this.nfG.dNJ();
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
        this.nfG = new com.baidu.tieba.square.flist.c(this);
        this.nfG.ngo = (BdListView) dNz();
        this.nfG.ngp = (BdListView) dNB();
        this.nfG.mProgressBar.setVisibility(0);
        this.nfG.ngF.setOnClickListener(null);
        this.nfG.ngF.setClickable(false);
        this.nfG.mViewPager.setAdapter(new a());
        this.nfG.ngo.setPullRefresh(this.nfG.ngy);
        this.nfG.ngp.setPullRefresh(this.nfG.ngz);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nfG.ngo.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nfG.ngp.addHeaderView(textView2, 0);
        this.nfK = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nfG.ngo.setAdapter((ListAdapter) this.nfK);
        this.nfL = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nfG.ngp.setAdapter((ListAdapter) this.nfL);
        I(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void I(String str, String str2, String str3, String str4) {
        if (au.isEmpty(str4)) {
            str4 = str;
        }
        this.nfG.bIt.setText(str4);
        this.nfG.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nfH = new ForumListModel.RequestParams();
        this.nfH.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nfH.menu_name = str4;
        this.nfH.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nfH.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nfH.parent_menu_name = str;
        this.nfH.offset = 0;
        this.nfH.rn = 10;
        if (this.nfH.menu_id != 0) {
            this.nfG.dNI();
            this.nfA = true;
            this.nfF = false;
            this.nfK.s(Boolean.valueOf(this.nfF));
            this.nfG.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.nfF = true;
            this.nfK.s(Boolean.valueOf(this.nfF));
            this.nfG.dNH();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nfG.ngy.setListPullRefreshListener(this.gye);
        this.nfG.ngz.setListPullRefreshListener(this.gye);
        this.nfK.notifyDataSetChanged();
        this.nfL.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nfG.dNK();
        } else {
            this.nfM = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nfM.a(this.nfP);
            this.nfM.LoadData();
        }
        this.nfN = new ForumListDetailModel(getPageContext(), this.nfH);
        this.nfN.a(this.nfO);
        this.nfG.ngo.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (iSO) {
            iSO = false;
            finish();
            c(getPageContext().getPageActivity(), nfR, nfT, nfS, nfU);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nfK != null) {
                this.nfK.dNF();
                this.nfK.notifyDataSetChanged();
            }
            if (this.nfL != null) {
                this.nfL.dNF();
                this.nfL.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fgf != null) {
            this.fgf.dOB();
        }
        this.nfG.mViewPager.setAdapter(null);
        this.nfG.ngp.setAdapter((ListAdapter) null);
        this.nfG.ngo.setAdapter((ListAdapter) null);
        if (this.nfG.ngD != null) {
            this.nfG.ngD.setAdapter((ListAdapter) null);
        }
        if (this.nfM != null) {
            this.nfM.cancelLoadData();
        }
        if (this.nfN != null) {
            this.nfN.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nfG.iGf);
        this.nfG.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nfK.xT(true);
            this.nfL.xT(true);
        } else {
            this.nfK.xT(false);
            this.nfL.xT(false);
        }
        this.nfK.notifyDataSetChanged();
        this.nfL.notifyDataSetChanged();
        if (this.nfG.ngA != null) {
            this.nfG.ngA.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.nfG.ngl, R.drawable.bg_pop_most);
        this.nfp = ap.getColor(R.color.common_color_10243);
        this.nfq = ap.getColor(R.color.CAM_X0101);
        this.nfr = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nfs = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nft = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nfu = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nfv = ap.getDrawable(R.drawable.ico_downward);
        this.nfw = ap.getDrawable(R.drawable.ico_upward);
        this.nfK.dx(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nfL.dx(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nfG.ngk, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nfG.ngw, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.nfG.ngj, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nfG.ngt, R.color.common_color_10243, 1);
        if (this.nfI) {
            ap.setImageResource(this.nfG.ngu, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nfG.ngu, R.drawable.ico_downward);
        }
        if (this.nfJ) {
            ap.setImageResource(this.nfG.ngx, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nfG.ngx, R.drawable.ico_downward);
        }
        if (this.nfG.mViewPager.getCurrentItem() == 0) {
            this.nfG.ngq.setTextColor(this.nfq);
            this.nfG.ngq.setBackgroundDrawable(this.nft);
            this.nfG.ngr.setBackgroundDrawable(this.nfs);
            this.nfG.ngr.setTextColor(this.nfp);
            return;
        }
        this.nfG.ngr.setTextColor(this.nfq);
        this.nfG.ngr.setBackgroundDrawable(this.nfu);
        this.nfG.ngq.setBackgroundDrawable(this.nfr);
        this.nfG.ngq.setTextColor(this.nfp);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nfG.mViewPager.setCurrentItem(0);
            this.nfz = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nfG.mViewPager.setCurrentItem(1);
            this.nfz = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nfG.c(this.nfQ);
        }
    }

    private View dNz() {
        this.nfG.ngo = dND();
        this.nfG.ngs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNA();
            }
        });
        return this.nfG.ngo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNA() {
        if (this.nfI) {
            int min = Math.min(this.nfK.getCount(), 200);
            this.nfx = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nfK.dNE(), 0, forumInfoDataArr, 0, min);
            this.nfK.JR(min);
            this.nfK.a(forumInfoDataArr);
            this.nfI = false;
            this.nfG.ngt.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nfG.ngu.setImageDrawable(this.nfv);
            return;
        }
        this.nfx = 50;
        c cVar = new c();
        cVar.xS(true);
        cVar.execute(new Void[0]);
    }

    private View dNB() {
        this.nfG.ngp = dND();
        this.nfG.ngv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNC();
            }
        });
        return this.nfG.ngp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNC() {
        if (this.nfJ) {
            int min = Math.min(this.nfL.getCount(), 200);
            this.nfy = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nfL.dNE(), 0, forumInfoDataArr, 0, min);
            this.nfL.JR(min);
            this.nfL.a(forumInfoDataArr);
            this.nfJ = false;
            this.nfG.ngw.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nfG.ngx.setImageDrawable(this.nfv);
            return;
        }
        this.nfy = 50;
        b bVar = new b();
        bVar.xS(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dND() {
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
        if (!this.nfA) {
            if (i == 0) {
                this.nfK.dNF();
                this.nfK.notifyDataSetChanged();
                this.nfG.ngq.setBackgroundDrawable(this.nft);
                this.nfG.ngq.setTextColor(this.nfq);
                this.nfG.ngr.setBackgroundDrawable(this.nfs);
                this.nfG.ngr.setTextColor(this.nfp);
            } else if (i == 1) {
                this.nfL.dNF();
                this.nfL.notifyDataSetChanged();
                this.nfG.ngr.setBackgroundDrawable(this.nfu);
                this.nfG.ngr.setTextColor(this.nfq);
                this.nfG.ngq.setBackgroundDrawable(this.nfr);
                this.nfG.ngq.setTextColor(this.nfp);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes23.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.nfA ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nfG.ngo);
                    return ForumListActivity.this.nfG.ngo;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nfG.ngp);
                    return ForumListActivity.this.nfG.ngp;
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
        final ForumInfoData[] dNE;
        if (i == 11002 && i2 == -1) {
            this.nfN.LoadData();
            if (this.nfz == 0) {
                dNE = this.nfK.dNE();
            } else {
                dNE = this.nfL.dNE();
            }
            this.fgf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.fgf.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.fgf.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.fgf.getErrorString());
                        } else if (((w) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.nfz == 0) {
                                ForumListActivity.this.nfK.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dNE[ForumListActivity.this.nfK.nfY].forum_name);
                            } else if (ForumListActivity.this.nfz == 1) {
                                ForumListActivity.this.nfL.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dNE[ForumListActivity.this.nfL.nfY].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nfz == 0) {
                this.fgf.gu(dNE[this.nfK.nfY].forum_name, String.valueOf(dNE[this.nfK.nfY].forum_id));
            } else {
                this.fgf.gu(dNE[this.nfL.nfY].forum_name, String.valueOf(dNE[this.nfL.nfY].forum_id));
            }
        }
    }
}
