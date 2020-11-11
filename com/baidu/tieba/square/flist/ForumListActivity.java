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
/* loaded from: classes23.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean iHg = false;
    private static String mQR = "";
    private static String mQS = "";
    private static String mQT = "";
    private static String mQU = "";
    public com.baidu.tieba.square.flist.c mQG;
    private ForumListModel.RequestParams mQH;
    private com.baidu.tieba.square.flist.b mQK;
    private com.baidu.tieba.square.flist.b mQL;
    private DirMenuModel mQM;
    private ForumListDetailModel mQN;
    private int mQp;
    private int mQq;
    private Drawable mQr;
    private Drawable mQs;
    private Drawable mQt;
    private Drawable mQu;
    private Drawable mQv;
    private Drawable mQw;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int mQx = 200;
    private int mQy = 200;
    private int mQz = 0;
    private final LikeModel eZA = new LikeModel(getPageContext());
    private boolean mQA = false;
    private int menu_choose = 0;
    private boolean mQB = false;
    private int mQC = 0;
    private int mQD = 200;
    private boolean mQE = true;
    private boolean mQF = true;
    private boolean mQI = false;
    private boolean mQJ = false;
    private final ForumListDetailModel.a mQO = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.mQK.dIw() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.mQG.dIC();
                ForumListActivity.this.mQG.dIB();
                if (ForumListActivity.this.mQH.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.mQG.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.mQH.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.mQG.dIB();
                    ForumListActivity.this.mQH.recommend_type = ForumListActivity.this.mQC;
                    ForumListActivity.this.mQH.rn = ForumListActivity.this.mQD;
                }
                ForumListActivity.this.mQG.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.mQG.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.mQB) {
                    ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mQG.mRv.setImageDrawable(ForumListActivity.this.mQv);
                    ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mQG.mRy.setImageDrawable(ForumListActivity.this.mQv);
                    ForumListActivity.this.mQB = false;
                }
                ForumListActivity.this.mQG.bEW.setText(ForumListActivity.this.mQH.menu_name);
                ForumListActivity.this.mQG.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mQG.mRF.Jo(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.mQK.Iz(min);
                ForumListActivity.this.mQK.a(ForumListActivity.this.eZA);
                ForumListActivity.this.mQK.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.mQG.mRp.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.mQG.mRk.setVisibility(0);
                } else {
                    ForumListActivity.this.mQG.mRk.setVisibility(8);
                }
                ForumListActivity.this.mQG.mRr.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.mQL.Iz(min2);
                ForumListActivity.this.mQL.a(ForumListActivity.this.eZA);
                ForumListActivity.this.mQL.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.mQG.mRq.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.mQG.mRl.setVisibility(0);
                } else {
                    ForumListActivity.this.mQG.mRl.setVisibility(8);
                }
                ForumListActivity.this.mQG.mRs.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.mQG.dIB();
                if (ForumListActivity.this.mQG.mRF.getCount() > 0) {
                    ForumListActivity.this.mQG.mRG.setClickable(true);
                    ForumListActivity.this.mQG.mRG.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b mQP = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.mQG.dIC();
                    return;
                }
                return;
            }
            eVar.mSr.add(0, eVar);
            if (ForumListActivity.this.mQG.mRF != null) {
                ForumListActivity.this.mQG.mRF.a(eVar);
                ForumListActivity.this.Sw(String.valueOf(ForumListActivity.this.mQG.bEW.getText()));
                ForumListActivity.this.mQG.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.mQG.mRF.notifyDataSetChanged();
            }
            ForumListActivity.this.mQG.mRG.setClickable(true);
            ForumListActivity.this.mQG.mRG.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener mQQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.mQG.mRB, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.mQG.dIC();
            ForumListActivity.this.mQG.dID();
            ArrayList<e> arrayList = ForumListActivity.this.mQG.mRF.dIp().mSr;
            ForumListActivity.this.aH(arrayList.get(i).mQj, arrayList.get(i).mQl, arrayList.get(i).mQk);
        }
    };
    private final f.c gqm = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.mQK.dIy() && !ForumListActivity.this.mQL.dIy()) {
                if (ForumListActivity.this.mQE) {
                    ForumListActivity.this.mQH.recommend_type = 0;
                    ForumListActivity.this.mQH.rn = 200;
                    ForumListActivity.this.mQN.a(ForumListActivity.this.mQH);
                    ForumListActivity.this.mQN.LoadData();
                    ForumListActivity.this.mQE = false;
                } else if (ForumListActivity.this.mQG.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.mQI) {
                        ForumListActivity.this.mQx = 50;
                    } else {
                        ForumListActivity.this.mQx = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.mQG.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.mQJ) {
                        ForumListActivity.this.mQy = 50;
                    } else {
                        ForumListActivity.this.mQy = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw(String str) {
        e dIp = this.mQG.mRF.dIp();
        if (dIp != null) {
            ArrayList<e> arrayList = dIp.mSr;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).mQj.equals(str)) {
                    this.menu_choose = i;
                    this.mQG.mRF.Jo(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, String str2, String str3) {
        this.mQH.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mQH.menu_name = str;
        this.mQH.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mQH.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.mQH.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.mQH.offset = 0;
        this.mQH.rn = 10;
        this.mQC = this.mQH.recommend_type;
        this.mQD = this.mQH.rn;
        this.mQH.recommend_type = 0;
        this.mQH.rn = 200;
        this.mQB = true;
        this.mQN.a(this.mQH);
        this.mQN.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean mQX;

        private b() {
            this.mQX = false;
        }

        public void xk(boolean z) {
            this.mQX = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mQG.mRw.setEnabled(false);
            ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mQH.recommend_type = 2;
                ForumListActivity.this.mQH.offset = 0;
                ForumListActivity.this.mQH.rn = ForumListActivity.this.mQy;
                return ForumListModel.new_fetch(ForumListActivity.this.mQH);
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
                ForumListActivity.this.mQL.Iz(min);
                ForumListActivity.this.mQL.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.mQy == 200) {
                    ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mQG.mRy.setImageDrawable(ForumListActivity.this.mQv);
                } else {
                    ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mQG.mRy.setImageDrawable(ForumListActivity.this.mQw);
                    ForumListActivity.this.mQJ = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.mQX) {
                    if (ForumListActivity.this.mQy == 200) {
                        ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mQG.mRy.setImageDrawable(ForumListActivity.this.mQv);
                    } else {
                        ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mQG.mRy.setImageDrawable(ForumListActivity.this.mQw);
                    }
                } else {
                    ForumListActivity.this.mQG.mRx.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mQG.mRy.setImageDrawable(ForumListActivity.this.mQv);
                    ForumListActivity.this.mQH.rn = 200;
                    ForumListActivity.this.mQy = 200;
                }
            }
            ForumListActivity.this.mQG.mRw.setEnabled(true);
            ForumListActivity.this.mQG.dIB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean mQX;

        private c() {
            this.mQX = false;
        }

        public void xk(boolean z) {
            this.mQX = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.mQG.mRt.setEnabled(false);
            ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.mQH.recommend_type = 1;
                ForumListActivity.this.mQH.offset = 0;
                ForumListActivity.this.mQH.rn = ForumListActivity.this.mQx;
                return ForumListModel.new_fetch(ForumListActivity.this.mQH);
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
                ForumListActivity.this.mQK.Iz(min);
                ForumListActivity.this.mQK.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.mQx == 200) {
                    ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mQG.mRv.setImageDrawable(ForumListActivity.this.mQv);
                } else {
                    ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.mQG.mRv.setImageDrawable(ForumListActivity.this.mQw);
                    ForumListActivity.this.mQI = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.mQX) {
                    if (ForumListActivity.this.mQx == 200) {
                        ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.mQG.mRv.setImageDrawable(ForumListActivity.this.mQv);
                    } else {
                        ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.mQG.mRv.setImageDrawable(ForumListActivity.this.mQw);
                    }
                } else {
                    ForumListActivity.this.mQG.mRu.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.mQG.mRv.setImageDrawable(ForumListActivity.this.mQv);
                    ForumListActivity.this.mQH.rn = 200;
                    ForumListActivity.this.mQx = 200;
                }
            }
            ForumListActivity.this.mQG.mRt.setEnabled(true);
            ForumListActivity.this.mQG.dIB();
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
        this.mQG = new com.baidu.tieba.square.flist.c(this);
        this.mQG.mRp = (BdListView) dIr();
        this.mQG.mRq = (BdListView) dIt();
        this.mQG.mProgressBar.setVisibility(0);
        this.mQG.mRG.setOnClickListener(null);
        this.mQG.mRG.setClickable(false);
        this.mQG.mViewPager.setAdapter(new a());
        this.mQG.mRp.setPullRefresh(this.mQG.mRz);
        this.mQG.mRq.setPullRefresh(this.mQG.mRA);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.mQG.mRp.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.mQG.mRq.addHeaderView(textView2, 0);
        this.mQK = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.mQG.mRp.setAdapter((ListAdapter) this.mQK);
        this.mQL = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.mQG.mRq.setAdapter((ListAdapter) this.mQL);
        I(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void I(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.mQG.bEW.setText(str4);
        this.mQG.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mQH = new ForumListModel.RequestParams();
        this.mQH.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mQH.menu_name = str4;
        this.mQH.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.mQH.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.mQH.parent_menu_name = str;
        this.mQH.offset = 0;
        this.mQH.rn = 10;
        if (this.mQH.menu_id != 0) {
            this.mQG.dIA();
            this.mQA = true;
            this.mQF = false;
            this.mQK.s(Boolean.valueOf(this.mQF));
            this.mQG.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.mQF = true;
            this.mQK.s(Boolean.valueOf(this.mQF));
            this.mQG.dIz();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.mQG.mRz.setListPullRefreshListener(this.gqm);
        this.mQG.mRA.setListPullRefreshListener(this.gqm);
        this.mQK.notifyDataSetChanged();
        this.mQL.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.mQG.dIC();
        } else {
            this.mQM = new DirMenuModel(getPageContext(), str, str3, str2);
            this.mQM.a(this.mQP);
            this.mQM.LoadData();
        }
        this.mQN = new ForumListDetailModel(getPageContext(), this.mQH);
        this.mQN.a(this.mQO);
        this.mQG.mRp.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (iHg) {
            iHg = false;
            finish();
            c(getPageContext().getPageActivity(), mQR, mQT, mQS, mQU);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.mQK != null) {
                this.mQK.dIx();
                this.mQK.notifyDataSetChanged();
            }
            if (this.mQL != null) {
                this.mQL.dIx();
                this.mQL.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.eZA != null) {
            this.eZA.dJs();
        }
        this.mQG.mViewPager.setAdapter(null);
        this.mQG.mRq.setAdapter((ListAdapter) null);
        this.mQG.mRp.setAdapter((ListAdapter) null);
        if (this.mQG.mRE != null) {
            this.mQG.mRE.setAdapter((ListAdapter) null);
        }
        if (this.mQM != null) {
            this.mQM.cancelLoadData();
        }
        if (this.mQN != null) {
            this.mQN.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mQG.iux);
        this.mQG.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mQK.xl(true);
            this.mQL.xl(true);
        } else {
            this.mQK.xl(false);
            this.mQL.xl(false);
        }
        this.mQK.notifyDataSetChanged();
        this.mQL.notifyDataSetChanged();
        if (this.mQG.mRB != null) {
            this.mQG.mRB.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.mQG.mRm, R.drawable.bg_pop_most);
        this.mQp = ap.getColor(R.color.common_color_10243);
        this.mQq = ap.getColor(R.color.cp_cont_a);
        this.mQr = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.mQs = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.mQt = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.mQu = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.mQv = ap.getDrawable(R.drawable.ico_downward);
        this.mQw = ap.getDrawable(R.drawable.ico_upward);
        this.mQK.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        this.mQL.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.mQG.mRl, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mQG.mRx, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.mQG.mRk, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.mQG.mRu, R.color.common_color_10243, 1);
        if (this.mQI) {
            ap.setImageResource(this.mQG.mRv, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mQG.mRv, R.drawable.ico_downward);
        }
        if (this.mQJ) {
            ap.setImageResource(this.mQG.mRy, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.mQG.mRy, R.drawable.ico_downward);
        }
        if (this.mQG.mViewPager.getCurrentItem() == 0) {
            this.mQG.mRr.setTextColor(this.mQq);
            this.mQG.mRr.setBackgroundDrawable(this.mQt);
            this.mQG.mRs.setBackgroundDrawable(this.mQs);
            this.mQG.mRs.setTextColor(this.mQp);
            return;
        }
        this.mQG.mRs.setTextColor(this.mQq);
        this.mQG.mRs.setBackgroundDrawable(this.mQu);
        this.mQG.mRr.setBackgroundDrawable(this.mQr);
        this.mQG.mRr.setTextColor(this.mQp);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.mQG.mViewPager.setCurrentItem(0);
            this.mQz = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.mQG.mViewPager.setCurrentItem(1);
            this.mQz = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.mQG.c(this.mQQ);
        }
    }

    private View dIr() {
        this.mQG.mRp = dIv();
        this.mQG.mRt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dIs();
            }
        });
        return this.mQG.mRp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIs() {
        if (this.mQI) {
            int min = Math.min(this.mQK.getCount(), 200);
            this.mQx = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mQK.dIw(), 0, forumInfoDataArr, 0, min);
            this.mQK.Iz(min);
            this.mQK.a(forumInfoDataArr);
            this.mQI = false;
            this.mQG.mRu.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mQG.mRv.setImageDrawable(this.mQv);
            return;
        }
        this.mQx = 50;
        c cVar = new c();
        cVar.xk(true);
        cVar.execute(new Void[0]);
    }

    private View dIt() {
        this.mQG.mRq = dIv();
        this.mQG.mRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dIu();
            }
        });
        return this.mQG.mRq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIu() {
        if (this.mQJ) {
            int min = Math.min(this.mQL.getCount(), 200);
            this.mQy = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.mQL.dIw(), 0, forumInfoDataArr, 0, min);
            this.mQL.Iz(min);
            this.mQL.a(forumInfoDataArr);
            this.mQJ = false;
            this.mQG.mRx.setText(getPageContext().getString(R.string.flist_expand_list));
            this.mQG.mRy.setImageDrawable(this.mQv);
            return;
        }
        this.mQy = 50;
        b bVar = new b();
        bVar.xk(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dIv() {
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
        if (!this.mQA) {
            if (i == 0) {
                this.mQK.dIx();
                this.mQK.notifyDataSetChanged();
                this.mQG.mRr.setBackgroundDrawable(this.mQt);
                this.mQG.mRr.setTextColor(this.mQq);
                this.mQG.mRs.setBackgroundDrawable(this.mQs);
                this.mQG.mRs.setTextColor(this.mQp);
            } else if (i == 1) {
                this.mQL.dIx();
                this.mQL.notifyDataSetChanged();
                this.mQG.mRs.setBackgroundDrawable(this.mQu);
                this.mQG.mRs.setTextColor(this.mQq);
                this.mQG.mRr.setBackgroundDrawable(this.mQr);
                this.mQG.mRr.setTextColor(this.mQp);
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
            return ForumListActivity.this.mQA ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.mQG.mRp);
                    return ForumListActivity.this.mQG.mRp;
                case 1:
                    viewGroup.addView(ForumListActivity.this.mQG.mRq);
                    return ForumListActivity.this.mQG.mRq;
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
        final ForumInfoData[] dIw;
        if (i == 11002 && i2 == -1) {
            this.mQN.LoadData();
            if (this.mQz == 0) {
                dIw = this.mQK.dIw();
            } else {
                dIw = this.mQL.dIw();
            }
            this.eZA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.eZA.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.eZA.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.eZA.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.mQz == 0) {
                                ForumListActivity.this.mQK.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dIw[ForumListActivity.this.mQK.mQY].forum_name);
                            } else if (ForumListActivity.this.mQz == 1) {
                                ForumListActivity.this.mQL.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dIw[ForumListActivity.this.mQL.mQY].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.mQz == 0) {
                this.eZA.gp(dIw[this.mQK.mQY].forum_name, String.valueOf(dIw[this.mQK.mQY].forum_id));
            } else {
                this.eZA.gp(dIw[this.mQL.mQY].forum_name, String.valueOf(dIw[this.mQL.mQY].forum_id));
            }
        }
    }
}
