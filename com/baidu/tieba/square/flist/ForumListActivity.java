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
    public static boolean iSM = false;
    private static String nfP = "";
    private static String nfQ = "";
    private static String nfR = "";
    private static String nfS = "";
    public com.baidu.tieba.square.flist.c nfE;
    private ForumListModel.RequestParams nfF;
    private com.baidu.tieba.square.flist.b nfI;
    private com.baidu.tieba.square.flist.b nfJ;
    private DirMenuModel nfK;
    private ForumListDetailModel nfL;
    private int nfn;
    private int nfo;
    private Drawable nfp;
    private Drawable nfq;
    private Drawable nfr;
    private Drawable nfs;
    private Drawable nft;
    private Drawable nfu;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int nfv = 200;
    private int nfw = 200;
    private int nfx = 0;
    private final LikeModel fgf = new LikeModel(getPageContext());
    private boolean nfy = false;
    private int menu_choose = 0;
    private boolean nfz = false;
    private int nfA = 0;
    private int nfB = 200;
    private boolean nfC = true;
    private boolean nfD = true;
    private boolean nfG = false;
    private boolean nfH = false;
    private final ForumListDetailModel.a nfM = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nfI.dND() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nfE.dNJ();
                ForumListActivity.this.nfE.dNI();
                if (ForumListActivity.this.nfF.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nfE.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nfF.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nfE.dNI();
                    ForumListActivity.this.nfF.recommend_type = ForumListActivity.this.nfA;
                    ForumListActivity.this.nfF.rn = ForumListActivity.this.nfB;
                }
                ForumListActivity.this.nfE.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nfE.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nfz) {
                    ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfE.ngs.setImageDrawable(ForumListActivity.this.nft);
                    ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfE.ngv.setImageDrawable(ForumListActivity.this.nft);
                    ForumListActivity.this.nfz = false;
                }
                ForumListActivity.this.nfE.bIt.setText(ForumListActivity.this.nfF.menu_name);
                ForumListActivity.this.nfE.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nfE.ngC.KG(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nfI.JR(min);
                ForumListActivity.this.nfI.a(ForumListActivity.this.fgf);
                ForumListActivity.this.nfI.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nfE.ngm.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nfE.ngh.setVisibility(0);
                } else {
                    ForumListActivity.this.nfE.ngh.setVisibility(8);
                }
                ForumListActivity.this.nfE.ngo.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nfJ.JR(min2);
                ForumListActivity.this.nfJ.a(ForumListActivity.this.fgf);
                ForumListActivity.this.nfJ.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nfE.ngn.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nfE.ngi.setVisibility(0);
                } else {
                    ForumListActivity.this.nfE.ngi.setVisibility(8);
                }
                ForumListActivity.this.nfE.ngp.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nfE.dNI();
                if (ForumListActivity.this.nfE.ngC.getCount() > 0) {
                    ForumListActivity.this.nfE.ngD.setClickable(true);
                    ForumListActivity.this.nfE.ngD.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b nfN = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nfE.dNJ();
                    return;
                }
                return;
            }
            eVar.nhn.add(0, eVar);
            if (ForumListActivity.this.nfE.ngC != null) {
                ForumListActivity.this.nfE.ngC.a(eVar);
                ForumListActivity.this.Tl(String.valueOf(ForumListActivity.this.nfE.bIt.getText()));
                ForumListActivity.this.nfE.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nfE.ngC.notifyDataSetChanged();
            }
            ForumListActivity.this.nfE.ngD.setClickable(true);
            ForumListActivity.this.nfE.ngD.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener nfO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nfE.ngy, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nfE.dNJ();
            ForumListActivity.this.nfE.dNK();
            ArrayList<e> arrayList = ForumListActivity.this.nfE.ngC.dNw().nhn;
            ForumListActivity.this.aK(arrayList.get(i).nfh, arrayList.get(i).nfj, arrayList.get(i).nfi);
        }
    };
    private final f.c gyc = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nfI.dNF() && !ForumListActivity.this.nfJ.dNF()) {
                if (ForumListActivity.this.nfC) {
                    ForumListActivity.this.nfF.recommend_type = 0;
                    ForumListActivity.this.nfF.rn = 200;
                    ForumListActivity.this.nfL.a(ForumListActivity.this.nfF);
                    ForumListActivity.this.nfL.LoadData();
                    ForumListActivity.this.nfC = false;
                } else if (ForumListActivity.this.nfE.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nfG) {
                        ForumListActivity.this.nfv = 50;
                    } else {
                        ForumListActivity.this.nfv = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nfE.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nfH) {
                        ForumListActivity.this.nfw = 50;
                    } else {
                        ForumListActivity.this.nfw = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl(String str) {
        e dNw = this.nfE.ngC.dNw();
        if (dNw != null) {
            ArrayList<e> arrayList = dNw.nhn;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).nfh.equals(str)) {
                    this.menu_choose = i;
                    this.nfE.ngC.KG(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(String str, String str2, String str3) {
        this.nfF.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nfF.menu_name = str;
        this.nfF.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nfF.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nfF.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nfF.offset = 0;
        this.nfF.rn = 10;
        this.nfA = this.nfF.recommend_type;
        this.nfB = this.nfF.rn;
        this.nfF.recommend_type = 0;
        this.nfF.rn = 200;
        this.nfz = true;
        this.nfL.a(this.nfF);
        this.nfL.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nfV;

        private b() {
            this.nfV = false;
        }

        public void xS(boolean z) {
            this.nfV = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nfE.ngt.setEnabled(false);
            ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nfF.recommend_type = 2;
                ForumListActivity.this.nfF.offset = 0;
                ForumListActivity.this.nfF.rn = ForumListActivity.this.nfw;
                return ForumListModel.new_fetch(ForumListActivity.this.nfF);
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
                ForumListActivity.this.nfJ.JR(min);
                ForumListActivity.this.nfJ.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nfw == 200) {
                    ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfE.ngv.setImageDrawable(ForumListActivity.this.nft);
                } else {
                    ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nfE.ngv.setImageDrawable(ForumListActivity.this.nfu);
                    ForumListActivity.this.nfH = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nfV) {
                    if (ForumListActivity.this.nfw == 200) {
                        ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nfE.ngv.setImageDrawable(ForumListActivity.this.nft);
                    } else {
                        ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nfE.ngv.setImageDrawable(ForumListActivity.this.nfu);
                    }
                } else {
                    ForumListActivity.this.nfE.ngu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfE.ngv.setImageDrawable(ForumListActivity.this.nft);
                    ForumListActivity.this.nfF.rn = 200;
                    ForumListActivity.this.nfw = 200;
                }
            }
            ForumListActivity.this.nfE.ngt.setEnabled(true);
            ForumListActivity.this.nfE.dNI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean nfV;

        private c() {
            this.nfV = false;
        }

        public void xS(boolean z) {
            this.nfV = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nfE.ngq.setEnabled(false);
            ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nfF.recommend_type = 1;
                ForumListActivity.this.nfF.offset = 0;
                ForumListActivity.this.nfF.rn = ForumListActivity.this.nfv;
                return ForumListModel.new_fetch(ForumListActivity.this.nfF);
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
                ForumListActivity.this.nfI.JR(min);
                ForumListActivity.this.nfI.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nfv == 200) {
                    ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfE.ngs.setImageDrawable(ForumListActivity.this.nft);
                } else {
                    ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nfE.ngs.setImageDrawable(ForumListActivity.this.nfu);
                    ForumListActivity.this.nfG = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.nfV) {
                    if (ForumListActivity.this.nfv == 200) {
                        ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nfE.ngs.setImageDrawable(ForumListActivity.this.nft);
                    } else {
                        ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nfE.ngs.setImageDrawable(ForumListActivity.this.nfu);
                    }
                } else {
                    ForumListActivity.this.nfE.ngr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nfE.ngs.setImageDrawable(ForumListActivity.this.nft);
                    ForumListActivity.this.nfF.rn = 200;
                    ForumListActivity.this.nfv = 200;
                }
            }
            ForumListActivity.this.nfE.ngq.setEnabled(true);
            ForumListActivity.this.nfE.dNI();
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
        this.nfE = new com.baidu.tieba.square.flist.c(this);
        this.nfE.ngm = (BdListView) dNy();
        this.nfE.ngn = (BdListView) dNA();
        this.nfE.mProgressBar.setVisibility(0);
        this.nfE.ngD.setOnClickListener(null);
        this.nfE.ngD.setClickable(false);
        this.nfE.mViewPager.setAdapter(new a());
        this.nfE.ngm.setPullRefresh(this.nfE.ngw);
        this.nfE.ngn.setPullRefresh(this.nfE.ngx);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nfE.ngm.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nfE.ngn.addHeaderView(textView2, 0);
        this.nfI = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nfE.ngm.setAdapter((ListAdapter) this.nfI);
        this.nfJ = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nfE.ngn.setAdapter((ListAdapter) this.nfJ);
        I(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void I(String str, String str2, String str3, String str4) {
        if (au.isEmpty(str4)) {
            str4 = str;
        }
        this.nfE.bIt.setText(str4);
        this.nfE.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nfF = new ForumListModel.RequestParams();
        this.nfF.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nfF.menu_name = str4;
        this.nfF.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nfF.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nfF.parent_menu_name = str;
        this.nfF.offset = 0;
        this.nfF.rn = 10;
        if (this.nfF.menu_id != 0) {
            this.nfE.dNH();
            this.nfy = true;
            this.nfD = false;
            this.nfI.s(Boolean.valueOf(this.nfD));
            this.nfE.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.nfD = true;
            this.nfI.s(Boolean.valueOf(this.nfD));
            this.nfE.dNG();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nfE.ngw.setListPullRefreshListener(this.gyc);
        this.nfE.ngx.setListPullRefreshListener(this.gyc);
        this.nfI.notifyDataSetChanged();
        this.nfJ.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nfE.dNJ();
        } else {
            this.nfK = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nfK.a(this.nfN);
            this.nfK.LoadData();
        }
        this.nfL = new ForumListDetailModel(getPageContext(), this.nfF);
        this.nfL.a(this.nfM);
        this.nfE.ngm.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (iSM) {
            iSM = false;
            finish();
            c(getPageContext().getPageActivity(), nfP, nfR, nfQ, nfS);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nfI != null) {
                this.nfI.dNE();
                this.nfI.notifyDataSetChanged();
            }
            if (this.nfJ != null) {
                this.nfJ.dNE();
                this.nfJ.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.fgf != null) {
            this.fgf.dOA();
        }
        this.nfE.mViewPager.setAdapter(null);
        this.nfE.ngn.setAdapter((ListAdapter) null);
        this.nfE.ngm.setAdapter((ListAdapter) null);
        if (this.nfE.ngB != null) {
            this.nfE.ngB.setAdapter((ListAdapter) null);
        }
        if (this.nfK != null) {
            this.nfK.cancelLoadData();
        }
        if (this.nfL != null) {
            this.nfL.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nfE.iGd);
        this.nfE.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nfI.xT(true);
            this.nfJ.xT(true);
        } else {
            this.nfI.xT(false);
            this.nfJ.xT(false);
        }
        this.nfI.notifyDataSetChanged();
        this.nfJ.notifyDataSetChanged();
        if (this.nfE.ngy != null) {
            this.nfE.ngy.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.nfE.ngj, R.drawable.bg_pop_most);
        this.nfn = ap.getColor(R.color.common_color_10243);
        this.nfo = ap.getColor(R.color.CAM_X0101);
        this.nfp = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nfq = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nfr = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nfs = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nft = ap.getDrawable(R.drawable.ico_downward);
        this.nfu = ap.getDrawable(R.drawable.ico_upward);
        this.nfI.dx(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nfJ.dx(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nfE.ngi, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nfE.ngu, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.nfE.ngh, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nfE.ngr, R.color.common_color_10243, 1);
        if (this.nfG) {
            ap.setImageResource(this.nfE.ngs, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nfE.ngs, R.drawable.ico_downward);
        }
        if (this.nfH) {
            ap.setImageResource(this.nfE.ngv, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nfE.ngv, R.drawable.ico_downward);
        }
        if (this.nfE.mViewPager.getCurrentItem() == 0) {
            this.nfE.ngo.setTextColor(this.nfo);
            this.nfE.ngo.setBackgroundDrawable(this.nfr);
            this.nfE.ngp.setBackgroundDrawable(this.nfq);
            this.nfE.ngp.setTextColor(this.nfn);
            return;
        }
        this.nfE.ngp.setTextColor(this.nfo);
        this.nfE.ngp.setBackgroundDrawable(this.nfs);
        this.nfE.ngo.setBackgroundDrawable(this.nfp);
        this.nfE.ngo.setTextColor(this.nfn);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nfE.mViewPager.setCurrentItem(0);
            this.nfx = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nfE.mViewPager.setCurrentItem(1);
            this.nfx = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nfE.c(this.nfO);
        }
    }

    private View dNy() {
        this.nfE.ngm = dNC();
        this.nfE.ngq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNz();
            }
        });
        return this.nfE.ngm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNz() {
        if (this.nfG) {
            int min = Math.min(this.nfI.getCount(), 200);
            this.nfv = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nfI.dND(), 0, forumInfoDataArr, 0, min);
            this.nfI.JR(min);
            this.nfI.a(forumInfoDataArr);
            this.nfG = false;
            this.nfE.ngr.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nfE.ngs.setImageDrawable(this.nft);
            return;
        }
        this.nfv = 50;
        c cVar = new c();
        cVar.xS(true);
        cVar.execute(new Void[0]);
    }

    private View dNA() {
        this.nfE.ngn = dNC();
        this.nfE.ngt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dNB();
            }
        });
        return this.nfE.ngn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNB() {
        if (this.nfH) {
            int min = Math.min(this.nfJ.getCount(), 200);
            this.nfw = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nfJ.dND(), 0, forumInfoDataArr, 0, min);
            this.nfJ.JR(min);
            this.nfJ.a(forumInfoDataArr);
            this.nfH = false;
            this.nfE.ngu.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nfE.ngv.setImageDrawable(this.nft);
            return;
        }
        this.nfw = 50;
        b bVar = new b();
        bVar.xS(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dNC() {
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
        if (!this.nfy) {
            if (i == 0) {
                this.nfI.dNE();
                this.nfI.notifyDataSetChanged();
                this.nfE.ngo.setBackgroundDrawable(this.nfr);
                this.nfE.ngo.setTextColor(this.nfo);
                this.nfE.ngp.setBackgroundDrawable(this.nfq);
                this.nfE.ngp.setTextColor(this.nfn);
            } else if (i == 1) {
                this.nfJ.dNE();
                this.nfJ.notifyDataSetChanged();
                this.nfE.ngp.setBackgroundDrawable(this.nfs);
                this.nfE.ngp.setTextColor(this.nfo);
                this.nfE.ngo.setBackgroundDrawable(this.nfp);
                this.nfE.ngo.setTextColor(this.nfn);
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
            return ForumListActivity.this.nfy ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nfE.ngm);
                    return ForumListActivity.this.nfE.ngm;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nfE.ngn);
                    return ForumListActivity.this.nfE.ngn;
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
        final ForumInfoData[] dND;
        if (i == 11002 && i2 == -1) {
            this.nfL.LoadData();
            if (this.nfx == 0) {
                dND = this.nfI.dND();
            } else {
                dND = this.nfJ.dND();
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
                            if (ForumListActivity.this.nfx == 0) {
                                ForumListActivity.this.nfI.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dND[ForumListActivity.this.nfI.nfW].forum_name);
                            } else if (ForumListActivity.this.nfx == 1) {
                                ForumListActivity.this.nfJ.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dND[ForumListActivity.this.nfJ.nfW].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nfx == 0) {
                this.fgf.gu(dND[this.nfI.nfW].forum_name, String.valueOf(dND[this.nfI.nfW].forum_id));
            } else {
                this.fgf.gu(dND[this.nfJ.nfW].forum_name, String.valueOf(dND[this.nfJ.nfW].forum_id));
            }
        }
    }
}
