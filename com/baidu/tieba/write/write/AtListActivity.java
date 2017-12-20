package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView ctf;
    private LinearLayout dYO;
    private Button dYP;
    private View dYT;
    private View dYU;
    private ImageView dYW;
    private AtSelectFriendList hjU;
    private TextView hkb;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mNoDataView;
    protected ArrayList<MetaData> hjT = new ArrayList<>();
    private EditText dVi = null;
    private TextView cAd = null;
    private BdListView Hh = null;
    private final Handler mHandler = new Handler();
    private a hjV = null;
    private b hjW = null;
    private com.baidu.tieba.write.model.b hjX = null;
    private com.baidu.tieba.write.write.a hjY = null;
    private String hjZ = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hka = null;
    private final int hkc = 5;
    private boolean hkd = true;
    private final Runnable hke = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uU(k.a(AtListActivity.this.dVi.getText(), ""));
        }
    };
    private NoNetworkView.a gIW = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (z) {
                AtListActivity.this.uU(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.at_list_activity);
        initData(bundle);
        initUI();
        uU(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ctf.onChangeSkinType(getPageContext(), i);
        this.hjY.notifyDataSetChanged();
        aj.getColor(d.C0096d.common_color_10221);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.j(this.dYP, d.f.post_button_bg);
        aj.c(this.dYP, d.C0096d.cp_cont_i, 3);
        aj.a(this.dYW, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp(int i) {
        if (i == 2) {
            this.Hh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_chat_friends));
            this.dYO.setVisibility(8);
        } else if (i == 1) {
            this.Hh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_search_friends));
            this.dYO.setVisibility(8);
        } else if (i == 0) {
            this.Hh.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hkd) {
                this.dYO.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hjY.getItem(i);
        if (item != null) {
            if (this.hkd) {
                if (this.hjV == null && this.hjW == null) {
                    if (item.isChecked()) {
                        g(item);
                    } else if (5 <= this.hjU.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        f(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hjY.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(IntentConfig.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            l.a(getPageContext().getPageActivity(), this.dVi);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hjV != null) {
            this.hjV.cancel();
        }
        if (this.hjW != null) {
            this.hjW.cancel();
        }
        this.mHandler.removeCallbacks(this.hke);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_chat_friends), null, true);
        this.hka = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVi);
                    return false;
                }
                return false;
            }
        });
        ana();
        this.ctf = (NoNetworkView) findViewById(d.g.view_no_network);
        this.ctf.a(this.gIW);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Hh = (BdListView) findViewById(d.g.list);
        this.hjY = new com.baidu.tieba.write.write.a(this, this.hkd);
        this.hjY.a(this);
        this.hjY.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.g((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hjU.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.f((MetaData) obj);
                    }
                }
            }
        });
        this.Hh.setAdapter((ListAdapter) this.hjY);
        this.Hh.setOnItemClickListener(this);
        this.Hh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVi);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dVi.getParent() != null) {
            ((View) this.dVi.getParent()).setFocusable(true);
            ((View) this.dVi.getParent()).setFocusableInTouchMode(true);
        }
        this.dYO = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.dYP = (Button) this.mParent.findViewById(d.g.button_send);
        this.dYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hjU.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVi);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nX(0);
        this.hjU = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hjU.setMaxCount(5);
        this.hjU.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Hh.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        aEs();
    }

    private void ana() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dYT != null && AtListActivity.this.dYT.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVi);
                    AtListActivity.this.dYT.setVisibility(8);
                    AtListActivity.this.hkb.setVisibility(0);
                    AtListActivity.this.dYU.setVisibility(0);
                    AtListActivity.this.dVi.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVi);
                AtListActivity.this.finish();
            }
        });
        this.hkb = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.dYU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hkb.setVisibility(8);
                AtListActivity.this.dYU.setVisibility(8);
                AtListActivity.this.dYT.setVisibility(0);
                AtListActivity.this.dVi.requestFocus();
            }
        });
        this.dYW = (ImageView) this.dYU.findViewById(d.g.new_friend_search);
        this.dYT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dYT.setVisibility(8);
        this.dVi = (EditText) this.dYT.findViewById(d.g.search_bar_edit);
        this.dVi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hjZ)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hke);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hke, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cAd.setVisibility(0);
                    } else {
                        AtListActivity.this.cAd.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hjZ = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dVi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cAd = (TextView) findViewById(d.g.search_bar_delete_button);
        this.cAd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dVi.getText().clear();
            }
        });
    }

    private void aEs() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds80) + getResources().getDimensionPixelSize(d.e.ds16) + getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.Hh.requestFocus();
            }
        });
        this.Hh.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(String str) {
        if (!isFinishing()) {
            this.hjY.setData(null);
            if (this.hjV != null) {
                this.hjV.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hjX.bGP() != null) {
                    ArrayList<MetaData> bGE = this.hjX.bGP().bGE();
                    Iterator<MetaData> it = bGE.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bGE != null && !bGE.isEmpty()) {
                        wp(0);
                    } else {
                        wp(1);
                    }
                    this.hjY.setData(bGE);
                } else {
                    this.hjY.setData(null);
                    if (this.hjW == null) {
                        this.hjW = new b();
                        this.hjW.setPriority(3);
                        this.hjW.execute("");
                    }
                }
            } else {
                this.hjV = new a();
                this.hjV.setPriority(2);
                this.hjV.execute(str);
                if (this.hjW == null && this.hjX.bGP() == null) {
                    this.hjW = new b();
                    this.hjW.setPriority(3);
                    this.hjW.execute("");
                }
            }
            this.hjY.notifyDataSetInvalidated();
            this.Hh.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hjX = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hkd = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.hkd = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.hjU.h(metaData);
            nX(this.hjU.getItemLength());
            aEt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.hjU.j(metaData);
            nX(this.hjU.getItemLength());
            aEt();
        }
    }

    private void aEt() {
        if (this.hjU.getItemLength() > 0) {
            this.dYP.setEnabled(true);
        } else {
            this.dYP.setEnabled(false);
        }
    }

    private void nX(int i) {
        this.dYP.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hkg;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hkg = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hjV = null;
            this.hkg = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hkg = strArr[0];
            this.mNetwork = new x();
            if (this.hkg != null && this.hkg.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.hkg);
                String up = this.mNetwork.up();
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b bGP = AtListActivity.this.hjX.bGP();
                    if (bGP != null) {
                        cVar.e(up, bGP.bGF());
                        return cVar;
                    }
                    cVar.e(up, null);
                    return cVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hjV = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uN().vL().isRequestSuccess() && this.hkg != null && k.a(AtListActivity.this.dVi.getText(), "").equals(this.hkg)) {
                if (cVar == null || cVar.bGG().isEmpty()) {
                    AtListActivity.this.wp(1);
                } else {
                    AtListActivity.this.wp(0);
                }
                AtListActivity.this.hjX.a(cVar);
                AtListActivity.this.hjY.setData(cVar.bGG());
                AtListActivity.this.hjY.notifyDataSetInvalidated();
                AtListActivity.this.Hh.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private x mNetwork;

        private b() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
            }
            AtListActivity.this.hjW = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            String up = this.mNetwork.up();
            if (!this.mNetwork.uN().vL().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uI(up);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hjW = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dYO != null && AtListActivity.this.dYO.getVisibility() == 0) {
                AtListActivity.this.hka.setVisibility(0);
            }
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                AtListActivity.this.hjX.a(bVar);
                if (AtListActivity.this.hjY != null) {
                    if (k.a(AtListActivity.this.dVi.getText(), "").length() != 0) {
                        if (AtListActivity.this.hjX.bGQ() != null) {
                            if (bVar != null && bVar.bGF() != null && !bVar.bGF().isEmpty()) {
                                AtListActivity.this.wp(2);
                            }
                            AtListActivity.this.hjX.bGQ().l(bVar.bGF());
                            AtListActivity.this.hjY.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bGE() == null || !bVar.bGE().isEmpty()) {
                            AtListActivity.this.wp(0);
                        } else {
                            AtListActivity.this.wp(2);
                        }
                        AtListActivity.this.hjT = bVar.bGE();
                        AtListActivity.this.hjY.setData(AtListActivity.this.hjT);
                        AtListActivity.this.hjY.notifyDataSetInvalidated();
                        AtListActivity.this.Hh.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    @Override // com.baidu.tieba.write.write.a.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.hjU.i(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return this.Hh;
    }
}
