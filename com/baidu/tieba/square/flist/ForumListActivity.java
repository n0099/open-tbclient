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
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean iHU = false;
    private static String mRL = "";
    private static String mRM = "";
    private static String mRN = "";
    private static String mRO = "";
    public com.baidu.tieba.square.flist.c mRA;
    private ForumListModel.RequestParams mRB;
    private com.baidu.tieba.square.flist.b mRE;
    private com.baidu.tieba.square.flist.b mRF;
    private DirMenuModel mRG;
    private ForumListDetailModel mRH;
    private int mRj;
    private int mRk;
    private Drawable mRl;
    private Drawable mRm;
    private Drawable mRn;
    private Drawable mRo;
    private Drawable mRp;
    private Drawable mRq;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int mRr = 200;
    private int mRs = 200;
    private int mRt = 0;
    private final LikeModel eYI = new LikeModel(getPageContext());
    private boolean mRu = false;
    private int menu_choose = 0;
    private boolean mRv = false;
    private int mRw = 0;
    private int mRx = 200;
    private boolean mRy = true;
    private boolean mRz = true;
    private boolean mRC = false;
    private boolean mRD = false;
    private final ForumListDetailModel.a mRI = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.mRE.dIn() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.mRA.dIt();
                ForumListActivity.this.mRA.dIs();
                if (ForumListActivity.this.mRB.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.mRA.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.mRB.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.mRA.dIs();
                    ForumListActivity.this.mRB.recommend_type = ForumListActivity.this.mRw;
                    ForumListActivity.this.mRB.rn = ForumListActivity.this.mRx;
                }
                ForumListActivity.this.mRA.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.mRA.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.mRv) {
                    ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mRA.mSo.setImageDrawable(ForumListActivity.this.mRp);
                    ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mRA.mSs.setImageDrawable(ForumListActivity.this.mRp);
                    ForumListActivity.this.mRv = false;
                }
                ForumListActivity.this.mRA.bDl.setText(ForumListActivity.this.mRB.menu_name);
                ForumListActivity.this.mRA.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mRA.mSz.JQ(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.mRE.Ja(min);
                ForumListActivity.this.mRE.a(ForumListActivity.this.eYI);
                ForumListActivity.this.mRE.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.mRA.mSi.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.mRA.mSd.setVisibility(0);
                } else {
                    ForumListActivity.this.mRA.mSd.setVisibility(8);
                }
                ForumListActivity.this.mRA.mSk.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.mRF.Ja(min2);
                ForumListActivity.this.mRF.a(ForumListActivity.this.eYI);
                ForumListActivity.this.mRF.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.mRA.mSj.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.mRA.mSe.setVisibility(0);
                } else {
                    ForumListActivity.this.mRA.mSe.setVisibility(8);
                }
                ForumListActivity.this.mRA.mSl.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.mRA.dIs();
                if (ForumListActivity.this.mRA.mSz.getCount() > 0) {
                    ForumListActivity.this.mRA.mSA.setClickable(true);
                    ForumListActivity.this.mRA.mSA.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b mRJ = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.mRA.dIt();
                    return;
                }
                return;
            }
            eVar.mTn.add(0, eVar);
            if (ForumListActivity.this.mRA.mSz != null) {
                ForumListActivity.this.mRA.mSz.a(eVar);
                ForumListActivity.this.RX(String.valueOf(ForumListActivity.this.mRA.bDl.getText()));
                ForumListActivity.this.mRA.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mRA.mSz.notifyDataSetChanged();
            }
            ForumListActivity.this.mRA.mSA.setClickable(true);
            ForumListActivity.this.mRA.mSA.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener mRK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.mRA.mSv, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.mRA.dIt();
            ForumListActivity.this.mRA.dIu();
            ArrayList<e> arrayList = ForumListActivity.this.mRA.mSz.dIg().mTn;
            ForumListActivity.this.aH(arrayList.get(i).mRd, arrayList.get(i).mRf, arrayList.get(i).mRe);
        }
    };
    private final f.c gpT = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.mRE.dIp() && !ForumListActivity.this.mRF.dIp()) {
                if (ForumListActivity.this.mRy) {
                    ForumListActivity.this.mRB.recommend_type = 0;
                    ForumListActivity.this.mRB.rn = 200;
                    ForumListActivity.this.mRH.a(ForumListActivity.this.mRB);
                    ForumListActivity.this.mRH.LoadData();
                    ForumListActivity.this.mRy = false;
                } else if (ForumListActivity.this.mRA.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.mRC) {
                        ForumListActivity.this.mRr = 50;
                    } else {
                        ForumListActivity.this.mRr = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.mRA.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.mRD) {
                        ForumListActivity.this.mRs = 50;
                    } else {
                        ForumListActivity.this.mRs = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void RX(String str) {
        e dIg = this.mRA.mSz.dIg();
        if (dIg != null) {
            ArrayList<e> arrayList = dIg.mTn;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).mRd.equals(str)) {
                    this.menu_choose = i;
                    this.mRA.mSz.JQ(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, String str2, String str3) {
        this.mRB.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mRB.menu_name = str;
        this.mRB.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mRB.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.mRB.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.mRB.offset = 0;
        this.mRB.rn = 10;
        this.mRw = this.mRB.recommend_type;
        this.mRx = this.mRB.rn;
        this.mRB.recommend_type = 0;
        this.mRB.rn = 200;
        this.mRv = true;
        this.mRH.a(this.mRB);
        this.mRH.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean mRR;

        private b() {
            this.mRR = false;
        }

        public void xo(boolean z) {
            this.mRR = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mRA.mSq.setEnabled(false);
            ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mRB.recommend_type = 2;
                ForumListActivity.this.mRB.offset = 0;
                ForumListActivity.this.mRB.rn = ForumListActivity.this.mRs;
                return ForumListModel.new_fetch(ForumListActivity.this.mRB);
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
                ForumListActivity.this.mRF.Ja(min);
                ForumListActivity.this.mRF.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.mRs == 200) {
                    ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mRA.mSs.setImageDrawable(ForumListActivity.this.mRp);
                } else {
                    ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mRA.mSs.setImageDrawable(ForumListActivity.this.mRq);
                    ForumListActivity.this.mRD = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.mRR) {
                    if (ForumListActivity.this.mRs == 200) {
                        ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mRA.mSs.setImageDrawable(ForumListActivity.this.mRp);
                    } else {
                        ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mRA.mSs.setImageDrawable(ForumListActivity.this.mRq);
                    }
                } else {
                    ForumListActivity.this.mRA.mSr.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mRA.mSs.setImageDrawable(ForumListActivity.this.mRp);
                    ForumListActivity.this.mRB.rn = 200;
                    ForumListActivity.this.mRs = 200;
                }
            }
            ForumListActivity.this.mRA.mSq.setEnabled(true);
            ForumListActivity.this.mRA.dIs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean mRR;

        private c() {
            this.mRR = false;
        }

        public void xo(boolean z) {
            this.mRR = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mRA.mSm.setEnabled(false);
            ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mRB.recommend_type = 1;
                ForumListActivity.this.mRB.offset = 0;
                ForumListActivity.this.mRB.rn = ForumListActivity.this.mRr;
                return ForumListModel.new_fetch(ForumListActivity.this.mRB);
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
                ForumListActivity.this.mRE.Ja(min);
                ForumListActivity.this.mRE.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.mRr == 200) {
                    ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mRA.mSo.setImageDrawable(ForumListActivity.this.mRp);
                } else {
                    ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mRA.mSo.setImageDrawable(ForumListActivity.this.mRq);
                    ForumListActivity.this.mRC = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.mRR) {
                    if (ForumListActivity.this.mRr == 200) {
                        ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mRA.mSo.setImageDrawable(ForumListActivity.this.mRp);
                    } else {
                        ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mRA.mSo.setImageDrawable(ForumListActivity.this.mRq);
                    }
                } else {
                    ForumListActivity.this.mRA.mSn.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mRA.mSo.setImageDrawable(ForumListActivity.this.mRp);
                    ForumListActivity.this.mRB.rn = 200;
                    ForumListActivity.this.mRr = 200;
                }
            }
            ForumListActivity.this.mRA.mSm.setEnabled(true);
            ForumListActivity.this.mRA.dIs();
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
        this.mRA = new com.baidu.tieba.square.flist.c(this);
        this.mRA.mSi = (BdListView) dIi();
        this.mRA.mSj = (BdListView) dIk();
        this.mRA.mProgressBar.setVisibility(0);
        this.mRA.mSA.setOnClickListener(null);
        this.mRA.mSA.setClickable(false);
        this.mRA.mViewPager.setAdapter(new a());
        this.mRA.mSi.setPullRefresh(this.mRA.mSt);
        this.mRA.mSj.setPullRefresh(this.mRA.mSu);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.mRA.mSi.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.mRA.mSj.addHeaderView(textView2, 0);
        this.mRE = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.mRA.mSi.setAdapter((ListAdapter) this.mRE);
        this.mRF = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.mRA.mSj.setAdapter((ListAdapter) this.mRF);
        I(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void I(String str, String str2, String str3, String str4) {
        if (au.isEmpty(str4)) {
            str4 = str;
        }
        this.mRA.bDl.setText(str4);
        this.mRA.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mRB = new ForumListModel.RequestParams();
        this.mRB.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mRB.menu_name = str4;
        this.mRB.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mRB.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mRB.parent_menu_name = str;
        this.mRB.offset = 0;
        this.mRB.rn = 10;
        if (this.mRB.menu_id != 0) {
            this.mRA.dIr();
            this.mRu = true;
            this.mRz = false;
            this.mRE.s(Boolean.valueOf(this.mRz));
            this.mRA.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.mRz = true;
            this.mRE.s(Boolean.valueOf(this.mRz));
            this.mRA.dIq();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.mRA.mSt.setListPullRefreshListener(this.gpT);
        this.mRA.mSu.setListPullRefreshListener(this.gpT);
        this.mRE.notifyDataSetChanged();
        this.mRF.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.mRA.dIt();
        } else {
            this.mRG = new DirMenuModel(getPageContext(), str, str3, str2);
            this.mRG.a(this.mRJ);
            this.mRG.LoadData();
        }
        this.mRH = new ForumListDetailModel(getPageContext(), this.mRB);
        this.mRH.a(this.mRI);
        this.mRA.mSi.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (iHU) {
            iHU = false;
            finish();
            c(getPageContext().getPageActivity(), mRL, mRN, mRM, mRO);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.mRE != null) {
                this.mRE.dIo();
                this.mRE.notifyDataSetChanged();
            }
            if (this.mRF != null) {
                this.mRF.dIo();
                this.mRF.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.eYI != null) {
            this.eYI.dJj();
        }
        this.mRA.mViewPager.setAdapter(null);
        this.mRA.mSj.setAdapter((ListAdapter) null);
        this.mRA.mSi.setAdapter((ListAdapter) null);
        if (this.mRA.mSy != null) {
            this.mRA.mSy.setAdapter((ListAdapter) null);
        }
        if (this.mRG != null) {
            this.mRG.cancelLoadData();
        }
        if (this.mRH != null) {
            this.mRH.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mRA.ivl);
        this.mRA.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mRE.xp(true);
            this.mRF.xp(true);
        } else {
            this.mRE.xp(false);
            this.mRF.xp(false);
        }
        this.mRE.notifyDataSetChanged();
        this.mRF.notifyDataSetChanged();
        if (this.mRA.mSv != null) {
            this.mRA.mSv.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.mRA.mSf, R.drawable.bg_pop_most);
        this.mRj = ap.getColor(R.color.common_color_10243);
        this.mRk = ap.getColor(R.color.CAM_X0101);
        this.mRl = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.mRm = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.mRn = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.mRo = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.mRp = ap.getDrawable(R.drawable.ico_downward);
        this.mRq = ap.getDrawable(R.drawable.ico_upward);
        this.mRE.ds(R.drawable.btn_add_end, R.drawable.btn_add);
        this.mRF.ds(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mRA.mSe, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mRA.mSr, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.mRA.mSd, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mRA.mSn, R.color.common_color_10243, 1);
        if (this.mRC) {
            ap.setImageResource(this.mRA.mSo, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mRA.mSo, R.drawable.ico_downward);
        }
        if (this.mRD) {
            ap.setImageResource(this.mRA.mSs, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mRA.mSs, R.drawable.ico_downward);
        }
        if (this.mRA.mViewPager.getCurrentItem() == 0) {
            this.mRA.mSk.setTextColor(this.mRk);
            this.mRA.mSk.setBackgroundDrawable(this.mRn);
            this.mRA.mSl.setBackgroundDrawable(this.mRm);
            this.mRA.mSl.setTextColor(this.mRj);
            return;
        }
        this.mRA.mSl.setTextColor(this.mRk);
        this.mRA.mSl.setBackgroundDrawable(this.mRo);
        this.mRA.mSk.setBackgroundDrawable(this.mRl);
        this.mRA.mSk.setTextColor(this.mRj);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.mRA.mViewPager.setCurrentItem(0);
            this.mRt = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.mRA.mViewPager.setCurrentItem(1);
            this.mRt = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.mRA.c(this.mRK);
        }
    }

    private View dIi() {
        this.mRA.mSi = dIm();
        this.mRA.mSm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dIj();
            }
        });
        return this.mRA.mSi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIj() {
        if (this.mRC) {
            int min = Math.min(this.mRE.getCount(), 200);
            this.mRr = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mRE.dIn(), 0, forumInfoDataArr, 0, min);
            this.mRE.Ja(min);
            this.mRE.a(forumInfoDataArr);
            this.mRC = false;
            this.mRA.mSn.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mRA.mSo.setImageDrawable(this.mRp);
            return;
        }
        this.mRr = 50;
        c cVar = new c();
        cVar.xo(true);
        cVar.execute(new Void[0]);
    }

    private View dIk() {
        this.mRA.mSj = dIm();
        this.mRA.mSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dIl();
            }
        });
        return this.mRA.mSj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIl() {
        if (this.mRD) {
            int min = Math.min(this.mRF.getCount(), 200);
            this.mRs = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mRF.dIn(), 0, forumInfoDataArr, 0, min);
            this.mRF.Ja(min);
            this.mRF.a(forumInfoDataArr);
            this.mRD = false;
            this.mRA.mSr.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mRA.mSs.setImageDrawable(this.mRp);
            return;
        }
        this.mRs = 50;
        b bVar = new b();
        bVar.xo(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dIm() {
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
        if (!this.mRu) {
            if (i == 0) {
                this.mRE.dIo();
                this.mRE.notifyDataSetChanged();
                this.mRA.mSk.setBackgroundDrawable(this.mRn);
                this.mRA.mSk.setTextColor(this.mRk);
                this.mRA.mSl.setBackgroundDrawable(this.mRm);
                this.mRA.mSl.setTextColor(this.mRj);
            } else if (i == 1) {
                this.mRF.dIo();
                this.mRF.notifyDataSetChanged();
                this.mRA.mSl.setBackgroundDrawable(this.mRo);
                this.mRA.mSl.setTextColor(this.mRk);
                this.mRA.mSk.setBackgroundDrawable(this.mRl);
                this.mRA.mSk.setTextColor(this.mRj);
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
            return ForumListActivity.this.mRu ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.mRA.mSi);
                    return ForumListActivity.this.mRA.mSi;
                case 1:
                    viewGroup.addView(ForumListActivity.this.mRA.mSj);
                    return ForumListActivity.this.mRA.mSj;
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
        final ForumInfoData[] dIn;
        if (i == 11002 && i2 == -1) {
            this.mRH.LoadData();
            if (this.mRt == 0) {
                dIn = this.mRE.dIn();
            } else {
                dIn = this.mRF.dIn();
            }
            this.eYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.eYI.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.eYI.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.eYI.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.mRt == 0) {
                                ForumListActivity.this.mRE.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dIn[ForumListActivity.this.mRE.mRS].forum_name);
                            } else if (ForumListActivity.this.mRt == 1) {
                                ForumListActivity.this.mRF.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dIn[ForumListActivity.this.mRF.mRS].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.mRt == 0) {
                this.eYI.gp(dIn[this.mRE.mRS].forum_name, String.valueOf(dIn[this.mRE.mRS].forum_id));
            } else {
                this.eYI.gp(dIn[this.mRF.mRS].forum_name, String.valueOf(dIn[this.mRF.mRS].forum_id));
            }
        }
    }
}
