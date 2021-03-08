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
/* loaded from: classes7.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean jhV = false;
    private static String nte = "";
    private static String ntf = "";
    private static String ntg = "";
    private static String nth = "";
    private int nsC;
    private int nsD;
    private Drawable nsE;
    private Drawable nsF;
    private Drawable nsG;
    private Drawable nsH;
    private Drawable nsI;
    private Drawable nsJ;
    public com.baidu.tieba.square.flist.c nsT;
    private ForumListModel.RequestParams nsU;
    private com.baidu.tieba.square.flist.b nsX;
    private com.baidu.tieba.square.flist.b nsY;
    private DirMenuModel nsZ;
    private ForumListDetailModel nta;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int nsK = 200;
    private int nsL = 200;
    private int nsM = 0;
    private final LikeModel foW = new LikeModel(getPageContext());
    private boolean nsN = false;
    private int menu_choose = 0;
    private boolean nsO = false;
    private int nsP = 0;
    private int nsQ = 200;
    private boolean nsR = true;
    private boolean nsS = true;
    private boolean nsV = false;
    private boolean nsW = false;
    private final ForumListDetailModel.a ntb = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.nsX.dMg() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.nsT.dMm();
                ForumListActivity.this.nsT.dMl();
                if (ForumListActivity.this.nsU.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.nsT.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.nsU.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.nsT.dMl();
                    ForumListActivity.this.nsU.recommend_type = ForumListActivity.this.nsP;
                    ForumListActivity.this.nsU.rn = ForumListActivity.this.nsQ;
                }
                ForumListActivity.this.nsT.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.nsT.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.nsO) {
                    ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nsT.ntH.setImageDrawable(ForumListActivity.this.nsI);
                    ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nsT.ntK.setImageDrawable(ForumListActivity.this.nsI);
                    ForumListActivity.this.nsO = false;
                }
                ForumListActivity.this.nsT.bNG.setText(ForumListActivity.this.nsU.menu_name);
                ForumListActivity.this.nsT.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nsT.ntR.Js(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.nsX.IC(min);
                ForumListActivity.this.nsX.a(ForumListActivity.this.foW);
                ForumListActivity.this.nsX.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.nsT.ntB.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.nsT.ntw.setVisibility(0);
                } else {
                    ForumListActivity.this.nsT.ntw.setVisibility(8);
                }
                ForumListActivity.this.nsT.ntD.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.nsY.IC(min2);
                ForumListActivity.this.nsY.a(ForumListActivity.this.foW);
                ForumListActivity.this.nsY.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.nsT.ntC.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.nsT.ntx.setVisibility(0);
                } else {
                    ForumListActivity.this.nsT.ntx.setVisibility(8);
                }
                ForumListActivity.this.nsT.ntE.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.nsT.dMl();
                if (ForumListActivity.this.nsT.ntR.getCount() > 0) {
                    ForumListActivity.this.nsT.ntS.setClickable(true);
                    ForumListActivity.this.nsT.ntS.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b ntc = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.nsT.dMm();
                    return;
                }
                return;
            }
            eVar.nuD.add(0, eVar);
            if (ForumListActivity.this.nsT.ntR != null) {
                ForumListActivity.this.nsT.ntR.a(eVar);
                ForumListActivity.this.Tb(String.valueOf(ForumListActivity.this.nsT.bNG.getText()));
                ForumListActivity.this.nsT.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.nsT.ntR.notifyDataSetChanged();
            }
            ForumListActivity.this.nsT.ntS.setClickable(true);
            ForumListActivity.this.nsT.ntS.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener ntd = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.nsT.ntN, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.nsT.dMm();
            ForumListActivity.this.nsT.dMn();
            ArrayList<e> arrayList = ForumListActivity.this.nsT.ntR.dLZ().nuD;
            ForumListActivity.this.aO(arrayList.get(i).nsw, arrayList.get(i).nsy, arrayList.get(i).nsx);
        }
    };
    private final f.c gJi = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.nsX.dMi() && !ForumListActivity.this.nsY.dMi()) {
                if (ForumListActivity.this.nsR) {
                    ForumListActivity.this.nsU.recommend_type = 0;
                    ForumListActivity.this.nsU.rn = 200;
                    ForumListActivity.this.nta.a(ForumListActivity.this.nsU);
                    ForumListActivity.this.nta.LoadData();
                    ForumListActivity.this.nsR = false;
                } else if (ForumListActivity.this.nsT.aaw.getCurrentItem() == 0) {
                    if (ForumListActivity.this.nsV) {
                        ForumListActivity.this.nsK = 50;
                    } else {
                        ForumListActivity.this.nsK = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.nsT.aaw.getCurrentItem() == 1) {
                    if (ForumListActivity.this.nsW) {
                        ForumListActivity.this.nsL = 50;
                    } else {
                        ForumListActivity.this.nsL = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb(String str) {
        e dLZ = this.nsT.ntR.dLZ();
        if (dLZ != null) {
            ArrayList<e> arrayList = dLZ.nuD;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).nsw.equals(str)) {
                    this.menu_choose = i;
                    this.nsT.ntR.Js(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(String str, String str2, String str3) {
        this.nsU.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nsU.menu_name = str;
        this.nsU.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nsU.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.nsU.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.nsU.offset = 0;
        this.nsU.rn = 10;
        this.nsP = this.nsU.recommend_type;
        this.nsQ = this.nsU.rn;
        this.nsU.recommend_type = 0;
        this.nsU.rn = 200;
        this.nsO = true;
        this.nta.a(this.nsU);
        this.nta.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean ntk;

        private b() {
            this.ntk = false;
        }

        public void yj(boolean z) {
            this.ntk = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nsT.ntI.setEnabled(false);
            ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nsU.recommend_type = 2;
                ForumListActivity.this.nsU.offset = 0;
                ForumListActivity.this.nsU.rn = ForumListActivity.this.nsL;
                return ForumListModel.new_fetch(ForumListActivity.this.nsU);
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
                ForumListActivity.this.nsY.IC(min);
                ForumListActivity.this.nsY.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.nsL == 200) {
                    ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nsT.ntK.setImageDrawable(ForumListActivity.this.nsI);
                } else {
                    ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nsT.ntK.setImageDrawable(ForumListActivity.this.nsJ);
                    ForumListActivity.this.nsW = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.ntk) {
                    if (ForumListActivity.this.nsL == 200) {
                        ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nsT.ntK.setImageDrawable(ForumListActivity.this.nsI);
                    } else {
                        ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nsT.ntK.setImageDrawable(ForumListActivity.this.nsJ);
                    }
                } else {
                    ForumListActivity.this.nsT.ntJ.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nsT.ntK.setImageDrawable(ForumListActivity.this.nsI);
                    ForumListActivity.this.nsU.rn = 200;
                    ForumListActivity.this.nsL = 200;
                }
            }
            ForumListActivity.this.nsT.ntI.setEnabled(true);
            ForumListActivity.this.nsT.dMl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean ntk;

        private c() {
            this.ntk = false;
        }

        public void yj(boolean z) {
            this.ntk = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.nsT.ntF.setEnabled(false);
            ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.nsU.recommend_type = 1;
                ForumListActivity.this.nsU.offset = 0;
                ForumListActivity.this.nsU.rn = ForumListActivity.this.nsK;
                return ForumListModel.new_fetch(ForumListActivity.this.nsU);
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
                ForumListActivity.this.nsX.IC(min);
                ForumListActivity.this.nsX.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.nsK == 200) {
                    ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nsT.ntH.setImageDrawable(ForumListActivity.this.nsI);
                } else {
                    ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.nsT.ntH.setImageDrawable(ForumListActivity.this.nsJ);
                    ForumListActivity.this.nsV = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.ntk) {
                    if (ForumListActivity.this.nsK == 200) {
                        ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.nsT.ntH.setImageDrawable(ForumListActivity.this.nsI);
                    } else {
                        ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.nsT.ntH.setImageDrawable(ForumListActivity.this.nsJ);
                    }
                } else {
                    ForumListActivity.this.nsT.ntG.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.nsT.ntH.setImageDrawable(ForumListActivity.this.nsI);
                    ForumListActivity.this.nsU.rn = 200;
                    ForumListActivity.this.nsK = 200;
                }
            }
            ForumListActivity.this.nsT.ntF.setEnabled(true);
            ForumListActivity.this.nsT.dMl();
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
        this.nsT = new com.baidu.tieba.square.flist.c(this);
        this.nsT.ntB = (BdListView) dMb();
        this.nsT.ntC = (BdListView) dMd();
        this.nsT.mProgressBar.setVisibility(0);
        this.nsT.ntS.setOnClickListener(null);
        this.nsT.ntS.setClickable(false);
        this.nsT.aaw.setAdapter(new a());
        this.nsT.ntB.setPullRefresh(this.nsT.ntL);
        this.nsT.ntC.setPullRefresh(this.nsT.ntM);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.nsT.ntB.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.nsT.ntC.addHeaderView(textView2, 0);
        this.nsX = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.nsT.ntB.setAdapter((ListAdapter) this.nsX);
        this.nsY = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.nsT.ntC.setAdapter((ListAdapter) this.nsY);
        F(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void F(String str, String str2, String str3, String str4) {
        if (au.isEmpty(str4)) {
            str4 = str;
        }
        this.nsT.bNG.setText(str4);
        this.nsT.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.nsU = new ForumListModel.RequestParams();
        this.nsU.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nsU.menu_name = str4;
        this.nsU.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.nsU.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.nsU.parent_menu_name = str;
        this.nsU.offset = 0;
        this.nsU.rn = 10;
        if (this.nsU.menu_id != 0) {
            this.nsT.dMk();
            this.nsN = true;
            this.nsS = false;
            this.nsX.s(Boolean.valueOf(this.nsS));
            this.nsT.aaw.getAdapter().notifyDataSetChanged();
        } else {
            this.nsS = true;
            this.nsX.s(Boolean.valueOf(this.nsS));
            this.nsT.dMj();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.nsT.ntL.setListPullRefreshListener(this.gJi);
        this.nsT.ntM.setListPullRefreshListener(this.gJi);
        this.nsX.notifyDataSetChanged();
        this.nsY.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.nsT.dMm();
        } else {
            this.nsZ = new DirMenuModel(getPageContext(), str, str3, str2);
            this.nsZ.a(this.ntc);
            this.nsZ.LoadData();
        }
        this.nta = new ForumListDetailModel(getPageContext(), this.nsU);
        this.nta.a(this.ntb);
        this.nsT.ntB.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (jhV) {
            jhV = false;
            finish();
            c(getPageContext().getPageActivity(), nte, ntg, ntf, nth);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.nsX != null) {
                this.nsX.dMh();
                this.nsX.notifyDataSetChanged();
            }
            if (this.nsY != null) {
                this.nsY.dMh();
                this.nsY.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.foW != null) {
            this.foW.dNd();
        }
        this.nsT.aaw.setAdapter(null);
        this.nsT.ntC.setAdapter((ListAdapter) null);
        this.nsT.ntB.setAdapter((ListAdapter) null);
        if (this.nsT.ntQ != null) {
            this.nsT.ntQ.setAdapter((ListAdapter) null);
        }
        if (this.nsZ != null) {
            this.nsZ.cancelLoadData();
        }
        if (this.nta != null) {
            this.nta.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nsT.iVo);
        this.nsT.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.nsX.yk(true);
            this.nsY.yk(true);
        } else {
            this.nsX.yk(false);
            this.nsY.yk(false);
        }
        this.nsX.notifyDataSetChanged();
        this.nsY.notifyDataSetChanged();
        if (this.nsT.ntN != null) {
            this.nsT.ntN.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.nsT.nty, R.drawable.bg_pop_most);
        this.nsC = ap.getColor(R.color.common_color_10243);
        this.nsD = ap.getColor(R.color.CAM_X0101);
        this.nsE = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.nsF = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.nsG = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.nsH = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.nsI = ap.getDrawable(R.drawable.ico_downward);
        this.nsJ = ap.getDrawable(R.drawable.ico_upward);
        this.nsX.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        this.nsY.dr(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.nsT.ntx, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nsT.ntJ, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.nsT.ntw, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.nsT.ntG, R.color.common_color_10243, 1);
        if (this.nsV) {
            ap.setImageResource(this.nsT.ntH, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nsT.ntH, R.drawable.ico_downward);
        }
        if (this.nsW) {
            ap.setImageResource(this.nsT.ntK, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.nsT.ntK, R.drawable.ico_downward);
        }
        if (this.nsT.aaw.getCurrentItem() == 0) {
            this.nsT.ntD.setTextColor(this.nsD);
            this.nsT.ntD.setBackgroundDrawable(this.nsG);
            this.nsT.ntE.setBackgroundDrawable(this.nsF);
            this.nsT.ntE.setTextColor(this.nsC);
            return;
        }
        this.nsT.ntE.setTextColor(this.nsD);
        this.nsT.ntE.setBackgroundDrawable(this.nsH);
        this.nsT.ntD.setBackgroundDrawable(this.nsE);
        this.nsT.ntD.setTextColor(this.nsC);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.nsT.aaw.setCurrentItem(0);
            this.nsM = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.nsT.aaw.setCurrentItem(1);
            this.nsM = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.nsT.c(this.ntd);
        }
    }

    private View dMb() {
        this.nsT.ntB = dMf();
        this.nsT.ntF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dMc();
            }
        });
        return this.nsT.ntB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMc() {
        if (this.nsV) {
            int min = Math.min(this.nsX.getCount(), 200);
            this.nsK = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nsX.dMg(), 0, forumInfoDataArr, 0, min);
            this.nsX.IC(min);
            this.nsX.a(forumInfoDataArr);
            this.nsV = false;
            this.nsT.ntG.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nsT.ntH.setImageDrawable(this.nsI);
            return;
        }
        this.nsK = 50;
        c cVar = new c();
        cVar.yj(true);
        cVar.execute(new Void[0]);
    }

    private View dMd() {
        this.nsT.ntC = dMf();
        this.nsT.ntI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dMe();
            }
        });
        return this.nsT.ntC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMe() {
        if (this.nsW) {
            int min = Math.min(this.nsY.getCount(), 200);
            this.nsL = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.nsY.dMg(), 0, forumInfoDataArr, 0, min);
            this.nsY.IC(min);
            this.nsY.a(forumInfoDataArr);
            this.nsW = false;
            this.nsT.ntJ.setText(getPageContext().getString(R.string.flist_expand_list));
            this.nsT.ntK.setImageDrawable(this.nsI);
            return;
        }
        this.nsL = 50;
        b bVar = new b();
        bVar.yj(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dMf() {
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
        if (!this.nsN) {
            if (i == 0) {
                this.nsX.dMh();
                this.nsX.notifyDataSetChanged();
                this.nsT.ntD.setBackgroundDrawable(this.nsG);
                this.nsT.ntD.setTextColor(this.nsD);
                this.nsT.ntE.setBackgroundDrawable(this.nsF);
                this.nsT.ntE.setTextColor(this.nsC);
            } else if (i == 1) {
                this.nsY.dMh();
                this.nsY.notifyDataSetChanged();
                this.nsT.ntE.setBackgroundDrawable(this.nsH);
                this.nsT.ntE.setTextColor(this.nsD);
                this.nsT.ntD.setBackgroundDrawable(this.nsE);
                this.nsT.ntD.setTextColor(this.nsC);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* loaded from: classes7.dex */
    class a extends PagerAdapter {
        a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.nsN ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.nsT.ntB);
                    return ForumListActivity.this.nsT.ntB;
                case 1:
                    viewGroup.addView(ForumListActivity.this.nsT.ntC);
                    return ForumListActivity.this.nsT.ntC;
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
        final ForumInfoData[] dMg;
        if (i == 11002 && i2 == -1) {
            this.nta.LoadData();
            if (this.nsM == 0) {
                dMg = this.nsX.dMg();
            } else {
                dMg = this.nsY.dMg();
            }
            this.foW.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (ForumListActivity.this.foW.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.foW.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.foW.getErrorString());
                        } else if (((w) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.nsM == 0) {
                                ForumListActivity.this.nsX.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dMg[ForumListActivity.this.nsX.ntl].forum_name);
                            } else if (ForumListActivity.this.nsM == 1) {
                                ForumListActivity.this.nsY.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dMg[ForumListActivity.this.nsY.ntl].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.nsM == 0) {
                this.foW.gy(dMg[this.nsX.ntl].forum_name, String.valueOf(dMg[this.nsX.ntl].forum_id));
            } else {
                this.foW.gy(dMg[this.nsY.ntl].forum_name, String.valueOf(dMg[this.nsY.ntl].forum_id));
            }
        }
    }
}
