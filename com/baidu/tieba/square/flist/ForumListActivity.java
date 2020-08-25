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
    public static boolean hSG = false;
    private static String lYQ = "";
    private static String lYR = "";
    private static String lYS = "";
    private static String lYT = "";
    public com.baidu.tieba.square.flist.c lYF;
    private ForumListModel.RequestParams lYG;
    private com.baidu.tieba.square.flist.b lYJ;
    private com.baidu.tieba.square.flist.b lYK;
    private DirMenuModel lYL;
    private ForumListDetailModel lYM;
    private int lYo;
    private int lYp;
    private Drawable lYq;
    private Drawable lYr;
    private Drawable lYs;
    private Drawable lYt;
    private Drawable lYu;
    private Drawable lYv;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    private int lYw = 200;
    private int lYx = 200;
    private int lYy = 0;
    private final LikeModel ewX = new LikeModel(getPageContext());
    private boolean lYz = false;
    private int menu_choose = 0;
    private boolean lYA = false;
    private int lYB = 0;
    private int lYC = 200;
    private boolean lYD = true;
    private boolean lYE = true;
    private boolean lYH = false;
    private boolean lYI = false;
    private final ForumListDetailModel.a lYN = new ForumListDetailModel.a() { // from class: com.baidu.tieba.square.flist.ForumListActivity.1
        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.a
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.lYJ.dvd() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.lYF.dvj();
                ForumListActivity.this.lYF.dvi();
                if (ForumListActivity.this.lYG.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.lYF.mProgressBar.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.lYG.menu_type == 2 && !z2) {
                    ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.lYF.dvi();
                    ForumListActivity.this.lYG.recommend_type = ForumListActivity.this.lYB;
                    ForumListActivity.this.lYG.rn = ForumListActivity.this.lYC;
                }
                ForumListActivity.this.lYF.mProgressBar.setVisibility(8);
            } else {
                ForumListActivity.this.lYF.mProgressBar.setVisibility(8);
                if (ForumListActivity.this.lYA) {
                    ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYF.lZt.setImageDrawable(ForumListActivity.this.lYu);
                    ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYF.lZw.setImageDrawable(ForumListActivity.this.lYu);
                    ForumListActivity.this.lYA = false;
                }
                ForumListActivity.this.lYF.bpx.setText(ForumListActivity.this.lYG.menu_name);
                ForumListActivity.this.lYF.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lYF.lZD.HA(ForumListActivity.this.menu_choose);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.recommend_list_left.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.recommend_list_right.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.recommend_list_left.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.recommend_list_right.forum_list, 0, min2);
                ForumListActivity.this.lYJ.GM(min);
                ForumListActivity.this.lYJ.a(ForumListActivity.this.ewX);
                ForumListActivity.this.lYJ.a(ForumListActivity.this.recommend_list_left.forum_list);
                ForumListActivity.this.lYF.lZn.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.lYF.lZi.setVisibility(0);
                } else {
                    ForumListActivity.this.lYF.lZi.setVisibility(8);
                }
                ForumListActivity.this.lYF.lZp.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.lYK.GM(min2);
                ForumListActivity.this.lYK.a(ForumListActivity.this.ewX);
                ForumListActivity.this.lYK.a(ForumListActivity.this.recommend_list_right.forum_list);
                ForumListActivity.this.lYF.lZo.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.lYF.lZj.setVisibility(0);
                } else {
                    ForumListActivity.this.lYF.lZj.setVisibility(8);
                }
                ForumListActivity.this.lYF.lZq.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.lYF.dvi();
                if (ForumListActivity.this.lYF.lZD.getCount() > 0) {
                    ForumListActivity.this.lYF.lZE.setClickable(true);
                    ForumListActivity.this.lYF.lZE.setOnClickListener(ForumListActivity.this);
                }
            }
        }
    };
    private final DirMenuModel.b lYO = new DirMenuModel.b() { // from class: com.baidu.tieba.square.flist.ForumListActivity.2
        @Override // com.baidu.tieba.square.flist.DirMenuModel.b
        public void a(boolean z, int i, e eVar, String str, boolean z2) {
            if (!z || i != 0) {
                if (!z2) {
                    ForumListActivity.this.lYF.dvj();
                    return;
                }
                return;
            }
            eVar.maq.add(0, eVar);
            if (ForumListActivity.this.lYF.lZD != null) {
                ForumListActivity.this.lYF.lZD.a(eVar);
                ForumListActivity.this.Qs(String.valueOf(ForumListActivity.this.lYF.bpx.getText()));
                ForumListActivity.this.lYF.mNavigationBar.onChangeSkinType(ForumListActivity.this.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.lYF.lZD.notifyDataSetChanged();
            }
            ForumListActivity.this.lYF.lZE.setClickable(true);
            ForumListActivity.this.lYF.lZE.setOnClickListener(ForumListActivity.this);
        }
    };
    private final AdapterView.OnItemClickListener lYP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            g.dismissPopupWindow(ForumListActivity.this.lYF.lZz, ForumListActivity.this.getPageContext().getPageActivity());
            ForumListActivity.this.menu_choose = i;
            ForumListActivity.this.lYF.dvj();
            ForumListActivity.this.lYF.dvk();
            ArrayList<e> arrayList = ForumListActivity.this.lYF.lZD.duW().maq;
            ForumListActivity.this.ax(arrayList.get(i).lYi, arrayList.get(i).lYk, arrayList.get(i).lYj);
        }
    };
    private final f.c fKL = new f.c() { // from class: com.baidu.tieba.square.flist.ForumListActivity.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!ForumListActivity.this.lYJ.dvf() && !ForumListActivity.this.lYK.dvf()) {
                if (ForumListActivity.this.lYD) {
                    ForumListActivity.this.lYG.recommend_type = 0;
                    ForumListActivity.this.lYG.rn = 200;
                    ForumListActivity.this.lYM.a(ForumListActivity.this.lYG);
                    ForumListActivity.this.lYM.LoadData();
                    ForumListActivity.this.lYD = false;
                } else if (ForumListActivity.this.lYF.mViewPager.getCurrentItem() == 0) {
                    if (ForumListActivity.this.lYH) {
                        ForumListActivity.this.lYw = 50;
                    } else {
                        ForumListActivity.this.lYw = 200;
                    }
                    new c().execute(new Void[0]);
                } else if (ForumListActivity.this.lYF.mViewPager.getCurrentItem() == 1) {
                    if (ForumListActivity.this.lYI) {
                        ForumListActivity.this.lYx = 50;
                    } else {
                        ForumListActivity.this.lYx = 200;
                    }
                    new b().execute(new Void[0]);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Qs(String str) {
        e duW = this.lYF.lZD.duW();
        if (duW != null) {
            ArrayList<e> arrayList = duW.maq;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).lYi.equals(str)) {
                    this.menu_choose = i;
                    this.lYF.lZD.HA(this.menu_choose);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, String str2, String str3) {
        this.lYG.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lYG.menu_name = str;
        this.lYG.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lYG.parent_menu_id = com.baidu.adp.lib.f.b.toInt(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
        this.lYG.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        this.lYG.offset = 0;
        this.lYG.rn = 10;
        this.lYB = this.lYG.recommend_type;
        this.lYC = this.lYG.rn;
        this.lYG.recommend_type = 0;
        this.lYG.rn = 200;
        this.lYA = true;
        this.lYM.a(this.lYG);
        this.lYM.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lYW;

        private b() {
            this.lYW = false;
        }

        public void vS(boolean z) {
            this.lYW = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lYF.lZu.setEnabled(false);
            ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lYG.recommend_type = 2;
                ForumListActivity.this.lYG.offset = 0;
                ForumListActivity.this.lYG.rn = ForumListActivity.this.lYx;
                return ForumListModel.new_fetch(ForumListActivity.this.lYG);
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
                ForumListActivity.this.lYK.GM(min);
                ForumListActivity.this.lYK.a(ForumListActivity.this.recommend_list_right.forum_list);
                if (ForumListActivity.this.lYx == 200) {
                    ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYF.lZw.setImageDrawable(ForumListActivity.this.lYu);
                } else {
                    ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lYF.lZw.setImageDrawable(ForumListActivity.this.lYv);
                    ForumListActivity.this.lYI = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lYW) {
                    if (ForumListActivity.this.lYx == 200) {
                        ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lYF.lZw.setImageDrawable(ForumListActivity.this.lYu);
                    } else {
                        ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lYF.lZw.setImageDrawable(ForumListActivity.this.lYv);
                    }
                } else {
                    ForumListActivity.this.lYF.lZv.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYF.lZw.setImageDrawable(ForumListActivity.this.lYu);
                    ForumListActivity.this.lYG.rn = 200;
                    ForumListActivity.this.lYx = 200;
                }
            }
            ForumListActivity.this.lYF.lZu.setEnabled(true);
            ForumListActivity.this.lYF.dvi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        boolean lYW;

        private c() {
            this.lYW = false;
        }

        public void vS(boolean z) {
            this.lYW = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.lYF.lZr.setEnabled(false);
            ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_loading));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.lYG.recommend_type = 1;
                ForumListActivity.this.lYG.offset = 0;
                ForumListActivity.this.lYG.rn = ForumListActivity.this.lYw;
                return ForumListModel.new_fetch(ForumListActivity.this.lYG);
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
                ForumListActivity.this.lYJ.GM(min);
                ForumListActivity.this.lYJ.a(ForumListActivity.this.recommend_list_left.forum_list);
                if (ForumListActivity.this.lYw == 200) {
                    ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYF.lZt.setImageDrawable(ForumListActivity.this.lYu);
                } else {
                    ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity.this.lYF.lZt.setImageDrawable(ForumListActivity.this.lYv);
                    ForumListActivity.this.lYH = true;
                }
            } else {
                ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.neterror));
                if (!this.lYW) {
                    if (ForumListActivity.this.lYw == 200) {
                        ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity.this.lYF.lZt.setImageDrawable(ForumListActivity.this.lYu);
                    } else {
                        ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity.this.lYF.lZt.setImageDrawable(ForumListActivity.this.lYv);
                    }
                } else {
                    ForumListActivity.this.lYF.lZs.setText(ForumListActivity.this.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity.this.lYF.lZt.setImageDrawable(ForumListActivity.this.lYu);
                    ForumListActivity.this.lYG.rn = 200;
                    ForumListActivity.this.lYw = 200;
                }
            }
            ForumListActivity.this.lYF.lZr.setEnabled(true);
            ForumListActivity.this.lYF.dvi();
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
        this.lYF = new com.baidu.tieba.square.flist.c(this);
        this.lYF.lZn = (BdListView) duY();
        this.lYF.lZo = (BdListView) dva();
        this.lYF.mProgressBar.setVisibility(0);
        this.lYF.lZE.setOnClickListener(null);
        this.lYF.lZE.setClickable(false);
        this.lYF.mViewPager.setAdapter(new a());
        this.lYF.lZn.setPullRefresh(this.lYF.lZx);
        this.lYF.lZo.setPullRefresh(this.lYF.lZy);
        if (com.baidu.adp.lib.f.b.toInt(stringExtra3, 0) != 0) {
            dimens = l.getDimens(getActivity(), R.dimen.ds98);
        } else {
            dimens = l.getDimens(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + dimens));
        this.lYF.lZn.addHeaderView(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, dimens + UtilHelper.getLightStatusBarHeight()));
        this.lYF.lZo.addHeaderView(textView2, 0);
        this.lYJ = new com.baidu.tieba.square.flist.b(getPageContext(), 0);
        this.lYF.lZn.setAdapter((ListAdapter) this.lYJ);
        this.lYK = new com.baidu.tieba.square.flist.b(getPageContext(), 1);
        this.lYF.lZo.setAdapter((ListAdapter) this.lYK);
        C(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    private void C(String str, String str2, String str3, String str4) {
        if (at.isEmpty(str4)) {
            str4 = str;
        }
        this.lYF.bpx.setText(str4);
        this.lYF.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.lYG = new ForumListModel.RequestParams();
        this.lYG.menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lYG.menu_name = str4;
        this.lYG.menu_type = com.baidu.adp.lib.f.b.toInt(str3, 0);
        this.lYG.parent_menu_id = com.baidu.adp.lib.f.b.toInt(str2, 0);
        this.lYG.parent_menu_name = str;
        this.lYG.offset = 0;
        this.lYG.rn = 10;
        if (this.lYG.menu_id != 0) {
            this.lYF.dvh();
            this.lYz = true;
            this.lYE = false;
            this.lYJ.q(Boolean.valueOf(this.lYE));
            this.lYF.mViewPager.getAdapter().notifyDataSetChanged();
        } else {
            this.lYE = true;
            this.lYJ.q(Boolean.valueOf(this.lYE));
            this.lYF.dvg();
        }
        this.recommend_list_left = new ForumListModel.List();
        this.recommend_list_right = new ForumListModel.List();
        this.recommend_list_left.forum_list = new ForumInfoData[50];
        this.recommend_list_right.forum_list = new ForumInfoData[50];
        this.lYF.lZx.setListPullRefreshListener(this.fKL);
        this.lYF.lZy.setListPullRefreshListener(this.fKL);
        this.lYJ.notifyDataSetChanged();
        this.lYK.notifyDataSetChanged();
        if (str3.equals("2")) {
            this.lYF.dvj();
        } else {
            this.lYL = new DirMenuModel(getPageContext(), str, str3, str2);
            this.lYL.a(this.lYO);
            this.lYL.LoadData();
        }
        this.lYM = new ForumListDetailModel(getPageContext(), this.lYG);
        this.lYM.a(this.lYN);
        this.lYF.lZn.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (hSG) {
            hSG = false;
            finish();
            c(getPageContext().getPageActivity(), lYQ, lYS, lYR, lYT);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (this.lYJ != null) {
                this.lYJ.dve();
                this.lYJ.notifyDataSetChanged();
            }
            if (this.lYK != null) {
                this.lYK.dve();
                this.lYK.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.ewX != null) {
            this.ewX.dvY();
        }
        this.lYF.mViewPager.setAdapter(null);
        this.lYF.lZo.setAdapter((ListAdapter) null);
        this.lYF.lZn.setAdapter((ListAdapter) null);
        if (this.lYF.lZC != null) {
            this.lYF.lZC.setAdapter((ListAdapter) null);
        }
        if (this.lYL != null) {
            this.lYL.cancelLoadData();
        }
        if (this.lYM != null) {
            this.lYM.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lYF.hFW);
        this.lYF.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lYJ.vT(true);
            this.lYK.vT(true);
        } else {
            this.lYJ.vT(false);
            this.lYK.vT(false);
        }
        this.lYJ.notifyDataSetChanged();
        this.lYK.notifyDataSetChanged();
        if (this.lYF.lZz != null) {
            this.lYF.lZz.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_allsproutpop_dropdown));
        }
        ap.setBackgroundResource(this.lYF.lZk, R.drawable.bg_pop_most);
        this.lYo = ap.getColor(R.color.common_color_10243);
        this.lYp = ap.getColor(R.color.cp_cont_a);
        this.lYq = ap.getDrawable(R.drawable.btn_pop_most_left_n);
        this.lYr = ap.getDrawable(R.drawable.btn_pop_most_right_n);
        this.lYs = ap.getDrawable(R.drawable.btn_pop_most_left_s);
        this.lYt = ap.getDrawable(R.drawable.btn_pop_most_right_s);
        this.lYu = ap.getDrawable(R.drawable.ico_downward);
        this.lYv = ap.getDrawable(R.drawable.ico_upward);
        this.lYJ.dj(R.drawable.btn_add_end, R.drawable.btn_add);
        this.lYK.dj(R.drawable.btn_add_end, R.drawable.btn_add);
        ap.setBackgroundResource(this.lYF.lZj, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.lYF.lZv, R.color.common_color_10243, 1);
        ap.setBackgroundResource(this.lYF.lZi, R.drawable.bg_black_banner_down);
        ap.setViewTextColor(this.lYF.lZs, R.color.common_color_10243, 1);
        if (this.lYH) {
            ap.setImageResource(this.lYF.lZt, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.lYF.lZt, R.drawable.ico_downward);
        }
        if (this.lYI) {
            ap.setImageResource(this.lYF.lZw, R.drawable.ico_upward);
        } else {
            ap.setImageResource(this.lYF.lZw, R.drawable.ico_downward);
        }
        if (this.lYF.mViewPager.getCurrentItem() == 0) {
            this.lYF.lZp.setTextColor(this.lYp);
            this.lYF.lZp.setBackgroundDrawable(this.lYs);
            this.lYF.lZq.setBackgroundDrawable(this.lYr);
            this.lYF.lZq.setTextColor(this.lYo);
            return;
        }
        this.lYF.lZq.setTextColor(this.lYp);
        this.lYF.lZq.setBackgroundDrawable(this.lYt);
        this.lYF.lZp.setBackgroundDrawable(this.lYq);
        this.lYF.lZp.setTextColor(this.lYo);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.lYF.mViewPager.setCurrentItem(0);
            this.lYy = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.lYF.mViewPager.setCurrentItem(1);
            this.lYy = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", "click", 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.lYF.c(this.lYP);
        }
    }

    private View duY() {
        this.lYF.lZn = dvc();
        this.lYF.lZr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.duZ();
            }
        });
        return this.lYF.lZn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duZ() {
        if (this.lYH) {
            int min = Math.min(this.lYJ.getCount(), 200);
            this.lYw = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lYJ.dvd(), 0, forumInfoDataArr, 0, min);
            this.lYJ.GM(min);
            this.lYJ.a(forumInfoDataArr);
            this.lYH = false;
            this.lYF.lZs.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lYF.lZt.setImageDrawable(this.lYu);
            return;
        }
        this.lYw = 50;
        c cVar = new c();
        cVar.vS(true);
        cVar.execute(new Void[0]);
    }

    private View dva() {
        this.lYF.lZo = dvc();
        this.lYF.lZu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.flist.ForumListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForumListActivity.this.dvb();
            }
        });
        return this.lYF.lZo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvb() {
        if (this.lYI) {
            int min = Math.min(this.lYK.getCount(), 200);
            this.lYx = 200;
            ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
            System.arraycopy(this.lYK.dvd(), 0, forumInfoDataArr, 0, min);
            this.lYK.GM(min);
            this.lYK.a(forumInfoDataArr);
            this.lYI = false;
            this.lYF.lZv.setText(getPageContext().getString(R.string.flist_expand_list));
            this.lYF.lZw.setImageDrawable(this.lYu);
            return;
        }
        this.lYx = 50;
        b bVar = new b();
        bVar.vS(true);
        bVar.execute(new Void[0]);
    }

    private BdListView dvc() {
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
        if (!this.lYz) {
            if (i == 0) {
                this.lYJ.dve();
                this.lYJ.notifyDataSetChanged();
                this.lYF.lZp.setBackgroundDrawable(this.lYs);
                this.lYF.lZp.setTextColor(this.lYp);
                this.lYF.lZq.setBackgroundDrawable(this.lYr);
                this.lYF.lZq.setTextColor(this.lYo);
            } else if (i == 1) {
                this.lYK.dve();
                this.lYK.notifyDataSetChanged();
                this.lYF.lZq.setBackgroundDrawable(this.lYt);
                this.lYF.lZq.setTextColor(this.lYp);
                this.lYF.lZp.setBackgroundDrawable(this.lYq);
                this.lYF.lZp.setTextColor(this.lYo);
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
            return ForumListActivity.this.lYz ? 1 : 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    viewGroup.addView(ForumListActivity.this.lYF.lZn);
                    return ForumListActivity.this.lYF.lZn;
                case 1:
                    viewGroup.addView(ForumListActivity.this.lYF.lZo);
                    return ForumListActivity.this.lYF.lZo;
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
        final ForumInfoData[] dvd;
        if (i == 11002 && i2 == -1) {
            this.lYM.LoadData();
            if (this.lYy == 0) {
                dvd = this.lYJ.dvd();
            } else {
                dvd = this.lYK.dvd();
            }
            this.ewX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.square.flist.ForumListActivity.7
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (ForumListActivity.this.ewX.getErrorCode() == 22) {
                        ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.had_liked_forum));
                    } else if (obj != null) {
                        if (ForumListActivity.this.ewX.getErrorCode() != 0) {
                            ForumListActivity.this.showToast(ForumListActivity.this.ewX.getErrorString());
                        } else if (((v) obj).isLike() == 1) {
                            ForumListActivity.this.showToast(ForumListActivity.this.getPageContext().getString(R.string.attention_success));
                            if (ForumListActivity.this.lYy == 0) {
                                ForumListActivity.this.lYJ.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dvd[ForumListActivity.this.lYJ.lYX].forum_name);
                            } else if (ForumListActivity.this.lYy == 1) {
                                ForumListActivity.this.lYK.notifyDataSetChanged();
                                TbadkCoreApplication.getInst().addLikeForum(dvd[ForumListActivity.this.lYK.lYX].forum_name);
                            }
                        }
                    }
                }
            });
            if (this.lYy == 0) {
                this.ewX.fQ(dvd[this.lYJ.lYX].forum_name, String.valueOf(dvd[this.lYJ.lYX].forum_id));
            } else {
                this.ewX.fQ(dvd[this.lYK.lYX].forum_name, String.valueOf(dvd[this.lYK.lYX].forum_id));
            }
        }
    }
}
