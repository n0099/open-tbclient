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
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean goq = false;
    private static String kba = "";
    private static String kbb = "";
    private static String kbc = "";
    private static String kbd = "";
    private Drawable kaA;
    private Drawable kaB;
    private Drawable kaC;
    private Drawable kaD;
    private Drawable kaE;
    public com.baidu.tieba.square.flist.c kaP;
    private ForumListModel.RequestParams kaQ;
    private com.baidu.tieba.square.flist.b kaT;
    private com.baidu.tieba.square.flist.b kaU;
    private DirMenuModel kaV;
    private ForumListDetailModel kaW;
    private int kax;
    private int kay;
    private Drawable kaz;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int kaF = 200;
    private int kaG = 200;
    private int kaH = 0;
    private final LikeModel dkh = new LikeModel(getPageContext());
    private boolean kaI = false;
    private int kaJ = 0;
    private boolean kaK = false;
    private int kaL = 0;
    private int kaM = 200;
    private boolean kaN = true;
    private boolean kaO = true;
    private boolean kaR = false;
    private boolean kaS = false;
    private final ForumListDetailModel.a kaX = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.kaT.cJB() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.kaP.cJH();
                ForumListActivity.this.kaP.cJG();
                if (ForumListActivity.this.kaQ.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.kaP.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.kaQ.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.kaP.cJG();
                    ForumListActivity.this.kaQ.recommend_type = ForumListActivity.this.kaL;
                    ForumListActivity.this.kaQ.rn = ForumListActivity.this.kaM;
                }
                ForumListActivity.this.kaP.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.kaP.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.kaK) {
                    ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaP.kbD.setImageDrawable(ForumListActivity.this.kaD);
                    ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaP.kbG.setImageDrawable(ForumListActivity.this.kaD);
                    ForumListActivity.this.kaK = false;
                }
                ForumListActivity.this.kaP.aCU.setText(ForumListActivity.this.kaQ.menu_name);
                ForumListActivity.this.kaP.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kaP.kbN.Cj(ForumListActivity.this.kaJ);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.kaT.Bx(min);
                ForumListActivity.this.kaT.a(ForumListActivity.this.dkh);
                ForumListActivity.this.kaT.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.kaP.kbx.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.kaP.kbs.setVisibility(0);
                } else {
                    ForumListActivity.this.kaP.kbs.setVisibility(8);
                }
                ForumListActivity.this.kaP.kbz.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.kaU.Bx(min2);
                ForumListActivity.this.kaU.a(ForumListActivity.this.dkh);
                ForumListActivity.this.kaU.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.kaP.kby.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.kaP.kbt.setVisibility(0);
                } else {
                    ForumListActivity.this.kaP.kbt.setVisibility(8);
                }
                ForumListActivity.this.kaP.kbA.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.kaP.cJG();
                if (ForumListActivity.this.kaP.kbN.getCount() > 0) {
                    ForumListActivity.this.kaP.kbO.setClickable(true);
                    ForumListActivity.this.kaP.kbO.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b kaY = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.kaP.cJH();
                    return;
                }
                return;
            }
            eVar.kcu.add(0, eVar);
            if (ForumListActivity.this.kaP.kbN != null) {
                ForumListActivity.this.kaP.kbN.a(eVar);
                ForumListActivity.this.IM(String.valueOf(ForumListActivity.this.kaP.aCU.getText()));
                ForumListActivity.this.kaP.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.kaP.kbN.notifyDataSetChanged();
            }
            ForumListActivity.this.kaP.kbO.setClickable(true);
            ForumListActivity.this.kaP.kbO.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener kaZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.kaP.kbJ, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.kaJ = i;
            ForumListActivity.this.kaP.cJH();
            ForumListActivity.this.kaP.cJI();
            ArrayList<e> arrayList = ForumListActivity.this.kaP.kbN.cJu().kcu;
            ForumListActivity.this.at(arrayList.get(i).kaq, arrayList.get(i).kas, arrayList.get(i).kar);
        }
    };
    private final g.c esh = new g.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.kaT.cJD() && !ForumListActivity.this.kaU.cJD()) {
                if (ForumListActivity.this.kaN) {
                    ForumListActivity.this.kaQ.recommend_type = 0;
                    ForumListActivity.this.kaQ.rn = 200;
                    ForumListActivity.this.kaW.a(ForumListActivity.this.kaQ);
                    ForumListActivity.this.kaW.LoadData();
                    ForumListActivity.this.kaN = false;
                } else if (ForumListActivity.this.kaP.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.kaR) {
                        ForumListActivity.this.kaF = 50;
                    } else {
                        ForumListActivity.this.kaF = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.kaP.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.kaS) {
                        ForumListActivity.this.kaG = 50;
                    } else {
                        ForumListActivity.this.kaG = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void IM(String str) {
        e cJu = this.kaP.kbN.cJu();
        if (cJu != null) {
            ArrayList<e> arrayList = cJu.kcu;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).kaq.equals(str)) {
                    this.kaJ = i;
                    this.kaP.kbN.Cj(this.kaJ);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2, String str3) {
        this.kaQ.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaQ.menu_name = str;
        this.kaQ.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kaQ.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.kaQ.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.kaQ.offset = 0;
        this.kaQ.rn = 10;
        this.kaL = this.kaQ.recommend_type;
        this.kaM = this.kaQ.rn;
        this.kaQ.recommend_type = 0;
        this.kaQ.rn = 200;
        this.kaK = true;
        this.kaW.a(this.kaQ);
        this.kaW.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kbg;

        private b() {
            this.kbg = false;
        }

        public void sE(boolean z) {
            this.kbg = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kaP.kbE.setEnabled(false);
            ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kaQ.recommend_type = 2;
                ForumListActivity.this.kaQ.offset = 0;
                ForumListActivity.this.kaQ.rn = ForumListActivity.this.kaG;
                return ForumListModel.new_fetch(ForumListActivity.this.kaQ);
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
                ForumListActivity.this.kaU.Bx(min);
                ForumListActivity.this.kaU.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.kaG == 200) {
                    ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaP.kbG.setImageDrawable(ForumListActivity.this.kaD);
                } else {
                    ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kaP.kbG.setImageDrawable(ForumListActivity.this.kaE);
                    ForumListActivity.this.kaS = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kbg) {
                    if (ForumListActivity.this.kaG == 200) {
                        ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kaP.kbG.setImageDrawable(ForumListActivity.this.kaD);
                    } else {
                        ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kaP.kbG.setImageDrawable(ForumListActivity.this.kaE);
                    }
                } else {
                    ForumListActivity.this.kaP.kbF.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaP.kbG.setImageDrawable(ForumListActivity.this.kaD);
                    ForumListActivity.this.kaQ.rn = 200;
                    ForumListActivity.this.kaG = 200;
                }
            }
            ForumListActivity.this.kaP.kbE.setEnabled(true);
            ForumListActivity.this.kaP.cJG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean kbg;

        private c() {
            this.kbg = false;
        }

        public void sE(boolean z) {
            this.kbg = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.kaP.kbB.setEnabled(false);
            ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.kaQ.recommend_type = 1;
                ForumListActivity.this.kaQ.offset = 0;
                ForumListActivity.this.kaQ.rn = ForumListActivity.this.kaF;
                return ForumListModel.new_fetch(ForumListActivity.this.kaQ);
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
                ForumListActivity.this.kaT.Bx(min);
                ForumListActivity.this.kaT.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.kaF == 200) {
                    ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaP.kbD.setImageDrawable(ForumListActivity.this.kaD);
                } else {
                    ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.kaP.kbD.setImageDrawable(ForumListActivity.this.kaE);
                    ForumListActivity.this.kaR = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.kbg) {
                    if (ForumListActivity.this.kaF == 200) {
                        ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.kaP.kbD.setImageDrawable(ForumListActivity.this.kaD);
                    } else {
                        ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.kaP.kbD.setImageDrawable(ForumListActivity.this.kaE);
                    }
                } else {
                    ForumListActivity.this.kaP.kbC.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.kaP.kbD.setImageDrawable(ForumListActivity.this.kaD);
                    ForumListActivity.this.kaQ.rn = 200;
                    ForumListActivity.this.kaF = 200;
                }
            }
            ForumListActivity.this.kaP.kbB.setEnabled(true);
            ForumListActivity.this.kaP.cJG();
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
        this.kaP = new com.baidu.tieba.square.flist.c(this);
        this.kaP.kbx = (BdListView) cJw();
        this.kaP.kby = (BdListView) cJy();
        this.kaP.mProgressBar.setVisibility(0);
        this.kaP.kbO.setOnClickListener(null);
        this.kaP.kbO.setClickable(false);
        this.kaP.mViewPager.setAdapter(new a());
        this.kaP.kbx.setPullRefresh(this.kaP.kbH);
        this.kaP.kby.setPullRefresh(this.kaP.kbI);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.kaP.kbx.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.kaP.kby.addHeaderView(textView2, 0);
        this.kaT = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.kaP.kbx.setAdapter((ListAdapter) this.kaT);
        this.kaU = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.kaP.kby.setAdapter((ListAdapter) this.kaU);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (aq.isEmpty(str4)) {
            str4 = str;
        }
        this.kaP.aCU.setText(str4);
        this.kaP.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.kaQ = new ForumListModel.RequestParams();
        this.kaQ.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaQ.menu_name = str4;
        this.kaQ.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.kaQ.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.kaQ.parent_menu_name = str;
        this.kaQ.offset = 0;
        this.kaQ.rn = 10;
        if (this.kaQ.menu_id != 0) {
            this.kaP.cJF();
            this.kaI = true;
            this.kaO = false;
            this.kaT.m(Boolean.valueOf(this.kaO));
            this.kaP.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.kaO = true;
            this.kaT.m(Boolean.valueOf(this.kaO));
            this.kaP.cJE();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.kaP.kbH.setListPullRefreshListener(this.esh);
        this.kaP.kbI.setListPullRefreshListener(this.esh);
        this.kaT.notifyDataSetChanged();
        this.kaU.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.kaP.cJH();
        } else {
            this.kaV = new DirMenuModel(getPageContext(), str, str3, str2);
            this.kaV.a(this.kaY);
            this.kaV.LoadData();
        }
        this.kaW = new ForumListDetailModel(getPageContext(), this.kaQ);
        this.kaW.a(this.kaX);
        this.kaP.kbx.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (goq) {
            goq = false;
            finish();
            b(getPageContext().getPageActivity(), kba, kbc, kbb, kbd);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.kaT != null) {
                this.kaT.cJC();
                this.kaT.notifyDataSetChanged();
            }
            if (this.kaU != null) {
                this.kaU.cJC();
                this.kaU.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.dkh != null) {
            this.dkh.cKv();
        }
        this.kaP.mViewPager.setAdapter(null);
        this.kaP.kby.setAdapter((ListAdapter) null);
        this.kaP.kbx.setAdapter((ListAdapter) null);
        if (this.kaP.kbM != null) {
            this.kaP.kbM.setAdapter((ListAdapter) null);
        }
        if (this.kaV != null) {
            this.kaV.cancelLoadData();
        }
        if (this.kaW != null) {
            this.kaW.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kaP.gbN);
        this.kaP.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kaT.sF(true);
            this.kaU.sF(true);
        } else {
            this.kaT.sF(false);
            this.kaU.sF(false);
        }
        this.kaT.notifyDataSetChanged();
        this.kaU.notifyDataSetChanged();
        if (this.kaP.kbJ != null) {
            this.kaP.kbJ.setBackgroundDrawable(am.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        am.setBackgroundResource(this.kaP.kbu, R.drawable.bg_pop_most);
        this.kax = am.getColor(R.color.common_color_10243);
        this.kay = am.getColor(R.color.cp_cont_a);
        this.kaz = am.getDrawable(R.drawable.btn_pop_most_left_n);
        this.kaA = am.getDrawable(R.drawable.btn_pop_most_right_n);
        this.kaB = am.getDrawable(R.drawable.btn_pop_most_left_s);
        this.kaC = am.getDrawable(R.drawable.btn_pop_most_right_s);
        this.kaD = am.getDrawable(R.drawable.ico_downward);
        this.kaE = am.getDrawable(R.drawable.ico_upward);
        this.kaT.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        this.kaU.cI(R.drawable.btn_add_end, R.drawable.btn_add);
        am.setBackgroundResource(this.kaP.kbt, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kaP.kbF, R.color.common_color_10243, 1);
        am.setBackgroundResource(this.kaP.kbs, R.drawable.bg_black_banner_down);
        am.setViewTextColor(this.kaP.kbC, R.color.common_color_10243, 1);
        if (this.kaR) {
            am.setImageResource(this.kaP.kbD, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kaP.kbD, R.drawable.ico_downward);
        }
        if (this.kaS) {
            am.setImageResource(this.kaP.kbG, R.drawable.ico_upward);
        } else {
            am.setImageResource(this.kaP.kbG, R.drawable.ico_downward);
        }
        if (this.kaP.mViewPager.getCurrentItem() == 0) {
            this.kaP.kbz.setTextColor(this.kay);
            this.kaP.kbz.setBackgroundDrawable(this.kaB);
            this.kaP.kbA.setBackgroundDrawable(this.kaA);
            this.kaP.kbA.setTextColor(this.kax);
            return;
        }
        this.kaP.kbA.setTextColor(this.kay);
        this.kaP.kbA.setBackgroundDrawable(this.kaC);
        this.kaP.kbz.setBackgroundDrawable(this.kaz);
        this.kaP.kbz.setTextColor(this.kax);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.kaP.mViewPager.setCurrentItem(0);
            this.kaH = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.kaP.mViewPager.setCurrentItem(1);
            this.kaH = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.kaP.d(this.kaZ);
        }
    }

    private View cJw() {
        this.kaP.kbx = cJA();
        this.kaP.kbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJx();
            }
        });
        return this.kaP.kbx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJx() {
        if (this.kaR) {
            int min = Math.min(this.kaT.getCount(), 200);
            this.kaF = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kaT.cJB(), 0, forumInfoDataArr, 0, min);
            this.kaT.Bx(min);
            this.kaT.a(forumInfoDataArr);
            this.kaR = false;
            this.kaP.kbC.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kaP.kbD.setImageDrawable(this.kaD);
            return;
        }
        this.kaF = 50;
        c cVar = new c();
        cVar.sE(true);
        cVar.execute(new Void[0]);
    }

    private View cJy() {
        this.kaP.kby = cJA();
        this.kaP.kbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.cJz();
            }
        });
        return this.kaP.kby;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJz() {
        if (this.kaS) {
            int min = Math.min(this.kaU.getCount(), 200);
            this.kaG = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.kaU.cJB(), 0, forumInfoDataArr, 0, min);
            this.kaU.Bx(min);
            this.kaU.a(forumInfoDataArr);
            this.kaS = false;
            this.kaP.kbF.setText(getPageContext().getString(R.string.flist_expand_list));
            this.kaP.kbG.setImageDrawable(this.kaD);
            return;
        }
        this.kaG = 50;
        b bVar = new b();
        bVar.sE(true);
        bVar.execute(new Void[0]);
    }

    private BdListView cJA() {
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
        if (!this.kaI) {
            if (i == 0) {
                this.kaT.cJC();
                this.kaT.notifyDataSetChanged();
                this.kaP.kbz.setBackgroundDrawable(this.kaB);
                this.kaP.kbz.setTextColor(this.kay);
                this.kaP.kbA.setBackgroundDrawable(this.kaA);
                this.kaP.kbA.setTextColor(this.kax);
            } else if (i == 1) {
                this.kaU.cJC();
                this.kaU.notifyDataSetChanged();
                this.kaP.kbA.setBackgroundDrawable(this.kaC);
                this.kaP.kbA.setTextColor(this.kay);
                this.kaP.kbz.setBackgroundDrawable(this.kaz);
                this.kaP.kbz.setTextColor(this.kax);
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
            return ForumListActivity.this.kaI ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.kaP.kbx);
                    return ForumListActivity.this.kaP.kbx;
                case 1:
                    viewGroup.addView(ForumListActivity.this.kaP.kby);
                    return ForumListActivity.this.kaP.kby;
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
        final ForumInfoData[] cJB;
        if (i == 11002 && i2 == -1) {
            this.kaW.LoadData();
            if (this.kaH == 0) {
                cJB = this.kaT.cJB();
            } else {
                cJB = this.kaU.cJB();
            }
            this.dkh.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.dkh.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.dkh.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.dkh.getErrorString());
                        } else if (((t) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.kaH == 0) {
                                ForumListActivity.this.kaT.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJB[ForumListActivity.this.kaT.kbh].forum_name);
                            } else if (ForumListActivity.this.kaH == 1) {
                                ForumListActivity.this.kaU.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(cJB[ForumListActivity.this.kaU.kbh].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.kaH == 0) {
                this.dkh.eC(cJB[this.kaT.kbh].forum_name, String.valueOf(cJB[this.kaT.kbh].forum_id));
            } else {
                this.dkh.eC(cJB[this.kaU.kbh].forum_name, String.valueOf(cJB[this.kaU.kbh].forum_id));
            }
        }
    }
}
