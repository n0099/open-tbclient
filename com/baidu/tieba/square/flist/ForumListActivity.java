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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.square.square.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean gYh = false;
    private static String kMs = "";
    private static String kMt = "";
    private static String kMu = "";
    private static String kMv = "";
    private int kLP;
    private int kLQ;
    private Drawable kLR;
    private Drawable kLS;
    private Drawable kLT;
    private Drawable kLU;
    private Drawable kLV;
    private Drawable kLW;
    public com.baidu.tieba.square.flist.c kMh;
    private ForumListModel.RequestParams kMi;
    private com.baidu.tieba.square.flist.b kMl;
    private com.baidu.tieba.square.flist.b kMm;
    private DirMenuModel kMn;
    private ForumListDetailModel kMo;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int kLX = 200;
    private int kLY = 200;
    private int kLZ = 0;
    private final LikeModel dKo = new LikeModel(getPageContext());
    private boolean kMa = false;
    private int kMb = 0;
    private boolean kMc = false;
    private int kMd = 0;
    private int kMe = 200;
    private boolean kMf = true;
    private boolean kMg = true;
    private boolean kMj = false;
    private boolean kMk = false;
    private final ForumListDetailModel.a kMp = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.kMl.cUQ() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.kMh.cUW();
                ForumListActivity.this.kMh.cUV();
                if (ForumListActivity.this.kMi.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.kMh.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.kMi.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.kMh.cUV();
                    ForumListActivity.this.kMi.recommend_type = ForumListActivity.this.kMd;
                    ForumListActivity.this.kMi.rn = ForumListActivity.this.kMe;
                }
                ForumListActivity.this.kMh.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.kMh.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.kMc) {
                    ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMh.kMV.setImageDrawable(ForumListActivity.this.kLV);
                    ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMh.kMY.setImageDrawable(ForumListActivity.this.kLV);
                    ForumListActivity.this.kMc = false;
                }
                ForumListActivity.this.kMh.aWP.setText(ForumListActivity.this.kMi.menu_name);
                ForumListActivity.this.kMh.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kMh.kNf.CT(ForumListActivity.this.kMb);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.kMl.Cf(min);
                ForumListActivity.this.kMl.a(ForumListActivity.this.dKo);
                ForumListActivity.this.kMl.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.kMh.kMP.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.kMh.kMK.setVisibility(0);
                } else {
                    ForumListActivity.this.kMh.kMK.setVisibility(8);
                }
                ForumListActivity.this.kMh.kMR.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.kMm.Cf(min2);
                ForumListActivity.this.kMm.a(ForumListActivity.this.dKo);
                ForumListActivity.this.kMm.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.kMh.kMQ.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.kMh.kML.setVisibility(0);
                } else {
                    ForumListActivity.this.kMh.kML.setVisibility(8);
                }
                ForumListActivity.this.kMh.kMS.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.kMh.cUV();
                if (ForumListActivity.this.kMh.kNf.getCount() > 0) {
                    ForumListActivity.this.kMh.kNg.setClickable(true);
                    ForumListActivity.this.kMh.kNg.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b kMq = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.kMh.cUW();
                    return;
                }
                return;
            }
            eVar.kNQ.add(0, eVar);
            if (ForumListActivity.this.kMh.kNf != null) {
                ForumListActivity.this.kMh.kNf.a(eVar);
                ForumListActivity.this.Kr(String.valueOf(ForumListActivity.this.kMh.aWP.getText()));
                ForumListActivity.this.kMh.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kMh.kNf.notifyDataSetChanged();
            }
            ForumListActivity.this.kMh.kNg.setClickable(true);
            ForumListActivity.this.kMh.kNg.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener kMr = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.kMh.kNb, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.kMb = i;
            ForumListActivity.this.kMh.cUW();
            ForumListActivity.this.kMh.cUX();
            ArrayList<e> arrayList = ForumListActivity.this.kMh.kNf.cUJ().kNQ;
            ForumListActivity.this.at(arrayList.get(i).kLJ, arrayList.get(i).kLL, arrayList.get(i).kLK);
        }
    };
    private final g.c eVZ = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.kMl.cUS() && !ForumListActivity.this.kMm.cUS()) {
                if (ForumListActivity.this.kMf) {
                    ForumListActivity.this.kMi.recommend_type = 0;
                    ForumListActivity.this.kMi.rn = 200;
                    ForumListActivity.this.kMo.a(ForumListActivity.this.kMi);
                    ForumListActivity.this.kMo.LoadData();
                    ForumListActivity.this.kMf = false;
                } else if (ForumListActivity.this.kMh.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.kMj) {
                        ForumListActivity.this.kLX = 50;
                    } else {
                        ForumListActivity.this.kLX = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.kMh.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.kMk) {
                        ForumListActivity.this.kLY = 50;
                    } else {
                        ForumListActivity.this.kLY = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr(String str) {
        e cUJ = this.kMh.kNf.cUJ();
        if (cUJ != null) {
            ArrayList<e> arrayList = cUJ.kNQ;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).kLJ.equals(str)) {
                    this.kMb = i;
                    this.kMh.kNf.CT(this.kMb);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.kMi.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kMi.menu_name = str;
        this.kMi.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kMi.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.kMi.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.kMi.offset = 0;
        this.kMi.rn = 10;
        this.kMd = this.kMi.recommend_type;
        this.kMe = this.kMi.rn;
        this.kMi.recommend_type = 0;
        this.kMi.rn = 200;
        this.kMc = true;
        this.kMo.a(this.kMi);
        this.kMo.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kMy;

        private b() {
            this.kMy = false;
        }

        public void tM(boolean z) {
            this.kMy = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kMh.kMW.setEnabled(false);
            ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kMi.recommend_type = 2;
                ForumListActivity.this.kMi.offset = 0;
                ForumListActivity.this.kMi.rn = ForumListActivity.this.kLY;
                return ForumListModel.new_fetch(ForumListActivity.this.kMi);
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
                ForumListActivity.this.kMm.Cf(min);
                ForumListActivity.this.kMm.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.kLY == 200) {
                    ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMh.kMY.setImageDrawable(ForumListActivity.this.kLV);
                } else {
                    ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kMh.kMY.setImageDrawable(ForumListActivity.this.kLW);
                    ForumListActivity.this.kMk = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kMy) {
                    if (ForumListActivity.this.kLY == 200) {
                        ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kMh.kMY.setImageDrawable(ForumListActivity.this.kLV);
                    } else {
                        ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kMh.kMY.setImageDrawable(ForumListActivity.this.kLW);
                    }
                } else {
                    ForumListActivity.this.kMh.kMX.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMh.kMY.setImageDrawable(ForumListActivity.this.kLV);
                    ForumListActivity.this.kMi.rn = 200;
                    ForumListActivity.this.kLY = 200;
                }
            }
            ForumListActivity.this.kMh.kMW.setEnabled(true);
            ForumListActivity.this.kMh.cUV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kMy;

        private c() {
            this.kMy = false;
        }

        public void tM(boolean z) {
            this.kMy = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kMh.kMT.setEnabled(false);
            ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kMi.recommend_type = 1;
                ForumListActivity.this.kMi.offset = 0;
                ForumListActivity.this.kMi.rn = ForumListActivity.this.kLX;
                return ForumListModel.new_fetch(ForumListActivity.this.kMi);
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
                ForumListActivity.this.kMl.Cf(min);
                ForumListActivity.this.kMl.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.kLX == 200) {
                    ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMh.kMV.setImageDrawable(ForumListActivity.this.kLV);
                } else {
                    ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kMh.kMV.setImageDrawable(ForumListActivity.this.kLW);
                    ForumListActivity.this.kMj = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kMy) {
                    if (ForumListActivity.this.kLX == 200) {
                        ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kMh.kMV.setImageDrawable(ForumListActivity.this.kLV);
                    } else {
                        ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kMh.kMV.setImageDrawable(ForumListActivity.this.kLW);
                    }
                } else {
                    ForumListActivity.this.kMh.kMU.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kMh.kMV.setImageDrawable(ForumListActivity.this.kLV);
                    ForumListActivity.this.kMi.rn = 200;
                    ForumListActivity.this.kLX = 200;
                }
            }
            ForumListActivity.this.kMh.kMT.setEnabled(true);
            ForumListActivity.this.kMh.cUV();
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
        int dimens;
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
        String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
        this.kMh = new com.baidu.tieba.square.flist.c(this);
        this.kMh.kMP = (BdListView) cUL();
        this.kMh.kMQ = (BdListView) cUN();
        this.kMh.mProgressBar.setVisibility(0);
        this.kMh.kNg.setOnClickListener(null);
        this.kMh.kNg.setClickable(false);
        this.kMh.mViewPager.setAdapter(new a());
        this.kMh.kMP.setPullRefresh(this.kMh.kMZ);
        this.kMh.kMQ.setPullRefresh(this.kMh.kNa);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.kMh.kMP.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.kMh.kMQ.addHeaderView(textView2, 0);
        this.kMl = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.kMh.kMP.setAdapter((ListAdapter) this.kMl);
        this.kMm = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.kMh.kMQ.setAdapter((ListAdapter) this.kMm);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.kMh.aWP.setText(str4);
        this.kMh.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.kMi = new ForumListModel.RequestParams();
        this.kMi.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kMi.menu_name = str4;
        this.kMi.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kMi.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kMi.parent_menu_name = str;
        this.kMi.offset = 0;
        this.kMi.rn = 10;
        if (this.kMi.menu_id != 0) {
            this.kMh.cUU();
            this.kMa = true;
            this.kMg = false;
            this.kMl.m(Boolean.valueOf(this.kMg));
            this.kMh.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.kMg = true;
            this.kMl.m(Boolean.valueOf(this.kMg));
            this.kMh.cUT();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.kMh.kMZ.setListPullRefreshListener(this.eVZ);
        this.kMh.kNa.setListPullRefreshListener(this.eVZ);
        this.kMl.notifyDataSetChanged();
        this.kMm.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.kMh.cUW();
        } else {
            this.kMn = new DirMenuModel(getPageContext(), str, str3, str2);
            this.kMn.a(this.kMq);
            this.kMn.LoadData();
        }
        this.kMo = new ForumListDetailModel(getPageContext(), this.kMi);
        this.kMo.a(this.kMp);
        this.kMh.kMP.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (gYh) {
            gYh = false;
            finish();
            b(getPageContext().getPageActivity(), kMs, kMu, kMt, kMv);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.kMl != null) {
                this.kMl.cUR();
                this.kMl.notifyDataSetChanged();
            }
            if (this.kMm != null) {
                this.kMm.cUR();
                this.kMm.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dKo != null) {
            this.dKo.cVL();
        }
        this.kMh.mViewPager.setAdapter(null);
        this.kMh.kMQ.setAdapter((ListAdapter) null);
        this.kMh.kMP.setAdapter((ListAdapter) null);
        if (this.kMh.kNe != null) {
            this.kMh.kNe.setAdapter((ListAdapter) null);
        }
        if (this.kMn != null) {
            this.kMn.cancelLoadData();
        }
        if (this.kMo != null) {
            this.kMo.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kMh.gLG);
        this.kMh.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kMl.tN(true);
            this.kMm.tN(true);
        } else {
            this.kMl.tN(false);
            this.kMm.tN(false);
        }
        this.kMl.notifyDataSetChanged();
        this.kMm.notifyDataSetChanged();
        if (this.kMh.kNb != null) {
            this.kMh.kNb.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.kMh.kMM, R.drawable.bg_pop_most);
        this.kLP = am.getColor(R.color.common_color_10243);
        this.kLQ = am.getColor(R.color.cp_cont_a);
        this.kLR = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.kLS = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.kLT = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.kLU = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.kLV = am.getDrawable(R.drawable.ico_downward);
        this.kLW = am.getDrawable(R.drawable.ico_upward);
        this.kMl.cO(R.drawable.btn_add_end, R.drawable.btn_add);
        this.kMm.cO(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kMh.kML, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kMh.kMX, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.kMh.kMK, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kMh.kMU, R.color.common_color_10243, 1);
        if (this.kMj) {
            am.setImageResource(this.kMh.kMV, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kMh.kMV, R.drawable.ico_downward);
        }
        if (this.kMk) {
            am.setImageResource(this.kMh.kMY, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kMh.kMY, R.drawable.ico_downward);
        }
        if (this.kMh.mViewPager.getCurrentItem() == 0) {
            this.kMh.kMR.setTextColor(this.kLQ);
            this.kMh.kMR.setBackgroundDrawable(this.kLT);
            this.kMh.kMS.setBackgroundDrawable(this.kLS);
            this.kMh.kMS.setTextColor(this.kLP);
            return;
        }
        this.kMh.kMS.setTextColor(this.kLQ);
        this.kMh.kMS.setBackgroundDrawable(this.kLU);
        this.kMh.kMR.setBackgroundDrawable(this.kLR);
        this.kMh.kMR.setTextColor(this.kLP);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.kMh.mViewPager.setCurrentItem(0);
            this.kLZ = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.kMh.mViewPager.setCurrentItem(1);
            this.kLZ = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.kMh.d(this.kMr);
        }
    }

    private View cUL() {
        this.kMh.kMP = cUP();
        this.kMh.kMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cUM();
            }
        });
        return this.kMh.kMP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUM() {
        if (this.kMj) {
            int min = Math.min(this.kMl.getCount(), 200);
            this.kLX = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kMl.cUQ(), 0, forumInfoDataArr, 0, min);
            this.kMl.Cf(min);
            this.kMl.a(forumInfoDataArr);
            this.kMj = false;
            this.kMh.kMU.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kMh.kMV.setImageDrawable(this.kLV);
            return;
        }
        this.kLX = 50;
        c cVar = new c();
        cVar.tM(true);
        cVar.execute(new Void[0]);
    }

    private View cUN() {
        this.kMh.kMQ = cUP();
        this.kMh.kMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cUO();
            }
        });
        return this.kMh.kMQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUO() {
        if (this.kMk) {
            int min = Math.min(this.kMm.getCount(), 200);
            this.kLY = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kMm.cUQ(), 0, forumInfoDataArr, 0, min);
            this.kMm.Cf(min);
            this.kMm.a(forumInfoDataArr);
            this.kMk = false;
            this.kMh.kMX.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kMh.kMY.setImageDrawable(this.kLV);
            return;
        }
        this.kLY = 50;
        b bVar = new b();
        bVar.tM(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cUP() {
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
        if (!this.kMa) {
            if (i == 0) {
                this.kMl.cUR();
                this.kMl.notifyDataSetChanged();
                this.kMh.kMR.setBackgroundDrawable(this.kLT);
                this.kMh.kMR.setTextColor(this.kLQ);
                this.kMh.kMS.setBackgroundDrawable(this.kLS);
                this.kMh.kMS.setTextColor(this.kLP);
            } else if (i == 1) {
                this.kMm.cUR();
                this.kMm.notifyDataSetChanged();
                this.kMh.kMS.setBackgroundDrawable(this.kLU);
                this.kMh.kMS.setTextColor(this.kLQ);
                this.kMh.kMR.setBackgroundDrawable(this.kLR);
                this.kMh.kMR.setTextColor(this.kLP);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes10.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.kMa ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.kMh.kMP);
                    return ForumListActivity.this.kMh.kMP;
                case 1:
                    viewGroup.addView(ForumListActivity.this.kMh.kMQ);
                    return ForumListActivity.this.kMh.kMQ;
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
        final ForumInfoData[] cUQ;
        if (i == 11002 && i2 == -1) {
            this.kMo.LoadData();
            if (this.kLZ == 0) {
                cUQ = this.kMl.cUQ();
            } else {
                cUQ = this.kMm.cUQ();
            }
            this.dKo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dKo.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dKo.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dKo.getErrorString());
                        } else if (((u) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.kLZ == 0) {
                                ForumListActivity.this.kMl.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cUQ[ForumListActivity.this.kMl.kMz].forum_name);
                            } else if (ForumListActivity.this.kLZ == 1) {
                                ForumListActivity.this.kMm.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cUQ[ForumListActivity.this.kMm.kMz].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.kLZ == 0) {
                this.dKo.eP(cUQ[this.kMl.kMz].forum_name, String.valueOf(cUQ[this.kMl.kMz].forum_id));
            } else {
                this.dKo.eP(cUQ[this.kMm.kMz].forum_name, String.valueOf(cUQ[this.kMm.kMz].forum_id));
            }
        }
    }
}
