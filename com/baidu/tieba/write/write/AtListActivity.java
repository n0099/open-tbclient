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
import com.baidu.adp.widget.ListView.g;
import com.baidu.sapi2.SapiAccountManager;
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
    private NoNetworkView cks;
    private LinearLayout dPU;
    private Button dPV;
    private View dPZ;
    private View dQa;
    private ImageView dQc;
    private AtSelectFriendList gWa;
    private TextView gWh;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.f mNoDataView;
    protected ArrayList<MetaData> gVZ = new ArrayList<>();
    private EditText dMp = null;
    private TextView crl = null;
    private BdListView Hj = null;
    private final Handler mHandler = new Handler();
    private a gWb = null;
    private b gWc = null;
    private com.baidu.tieba.write.model.b gWd = null;
    private com.baidu.tieba.write.write.a gWe = null;
    private String gWf = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gWg = null;
    private final int gWi = 5;
    private boolean gWj = true;
    private final Runnable gWk = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uh(k.a(AtListActivity.this.dMp.getText(), ""));
        }
    };
    private NoNetworkView.a gxq = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (z) {
                AtListActivity.this.uh(null);
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
        uh(null);
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
        this.cks.onChangeSkinType(getPageContext(), i);
        this.gWe.notifyDataSetChanged();
        aj.getColor(d.C0080d.common_color_10221);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.j(this.dPV, d.f.post_button_bg);
        aj.c(this.dPV, d.C0080d.cp_cont_i, 3);
        aj.a(this.dQc, d.f.icon_search_bg_s, d.f.icon_search_bg);
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
    public void vG(int i) {
        if (i == 2) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.j.no_chat_friends));
            this.dPU.setVisibility(8);
        } else if (i == 1) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.j.no_search_friends));
            this.dPU.setVisibility(8);
        } else if (i == 0) {
            this.Hj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gWj) {
                this.dPU.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gWe.getItem(i);
        if (item != null) {
            if (this.gWj) {
                if (this.gWb == null && this.gWc == null) {
                    if (item.isChecked()) {
                        h(item);
                    } else if (5 <= this.gWa.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        g(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gWe.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.dMp);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gWb != null) {
            this.gWb.cancel();
        }
        if (this.gWc != null) {
            this.gWc.cancel();
        }
        this.mHandler.removeCallbacks(this.gWk);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.j.no_chat_friends), null, true);
        this.gWg = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMp);
                    return false;
                }
                return false;
            }
        });
        akW();
        this.cks = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cks.a(this.gxq);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Hj = (BdListView) findViewById(d.g.list);
        this.gWe = new com.baidu.tieba.write.write.a(this, this.gWj);
        this.gWe.a(this);
        this.gWe.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.h((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gWa.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        this.Hj.setAdapter((ListAdapter) this.gWe);
        this.Hj.setOnItemClickListener(this);
        this.Hj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMp);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dMp.getParent() != null) {
            ((View) this.dMp.getParent()).setFocusable(true);
            ((View) this.dMp.getParent()).setFocusableInTouchMode(true);
        }
        this.dPU = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.dPV = (Button) this.mParent.findViewById(d.g.button_send);
        this.dPV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gWa.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMp);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nC(0);
        this.gWa = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.gWa.setMaxCount(5);
        this.gWa.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Hj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.h((MetaData) obj);
                    }
                }
            }
        });
        aCK();
    }

    private void akW() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dPZ != null && AtListActivity.this.dPZ.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMp);
                    AtListActivity.this.dPZ.setVisibility(8);
                    AtListActivity.this.gWh.setVisibility(0);
                    AtListActivity.this.dQa.setVisibility(0);
                    AtListActivity.this.dMp.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMp);
                AtListActivity.this.finish();
            }
        });
        this.gWh = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.dQa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gWh.setVisibility(8);
                AtListActivity.this.dQa.setVisibility(8);
                AtListActivity.this.dPZ.setVisibility(0);
                AtListActivity.this.dMp.requestFocus();
            }
        });
        this.dQc = (ImageView) this.dQa.findViewById(d.g.new_friend_search);
        this.dPZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dPZ.setVisibility(8);
        this.dMp = (EditText) this.dPZ.findViewById(d.g.search_bar_edit);
        this.dMp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gWf)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gWk);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gWk, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.crl.setVisibility(0);
                    } else {
                        AtListActivity.this.crl.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gWf = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dMp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.crl = (TextView) findViewById(d.g.search_bar_delete_button);
        this.crl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dMp.getText().clear();
            }
        });
    }

    private void aCK() {
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
                AtListActivity.this.Hj.requestFocus();
            }
        });
        this.Hj.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(String str) {
        if (!isFinishing()) {
            this.gWe.setData(null);
            if (this.gWb != null) {
                this.gWb.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gWd.bDy() != null) {
                    ArrayList<MetaData> bDt = this.gWd.bDy().bDt();
                    Iterator<MetaData> it = bDt.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bDt != null && !bDt.isEmpty()) {
                        vG(0);
                    } else {
                        vG(1);
                    }
                    this.gWe.setData(bDt);
                } else {
                    this.gWe.setData(null);
                    if (this.gWc == null) {
                        this.gWc = new b();
                        this.gWc.setPriority(3);
                        this.gWc.execute("");
                    }
                }
            } else {
                this.gWb = new a();
                this.gWb.setPriority(2);
                this.gWb.execute(str);
                if (this.gWc == null && this.gWd.bDy() == null) {
                    this.gWc = new b();
                    this.gWc.setPriority(3);
                    this.gWc.execute("");
                }
            }
            this.gWe.notifyDataSetInvalidated();
            this.Hj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gWd = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gWj = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gWj = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.gWa.i(metaData);
            nC(this.gWa.getItemLength());
            aCL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(MetaData metaData) {
        if (metaData != null) {
            this.gWa.k(metaData);
            nC(this.gWa.getItemLength());
            aCL();
        }
    }

    private void aCL() {
        if (this.gWa.getItemLength() > 0) {
            this.dPV.setEnabled(true);
        } else {
            this.dPV.setEnabled(false);
        }
    }

    private void nC(int i) {
        this.dPV.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gWm;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.gWm = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gWb = null;
            this.gWm = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gWm = strArr[0];
            this.mNetwork = new x();
            if (this.gWm != null && this.gWm.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gWm);
                String up = this.mNetwork.up();
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b bDy = AtListActivity.this.gWd.bDy();
                    if (bDy != null) {
                        dVar.e(up, bDy.bDu());
                        return dVar;
                    }
                    dVar.e(up, null);
                    return dVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.d dVar) {
            AtListActivity.this.gWb = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uN().vL().isRequestSuccess() && this.gWm != null && k.a(AtListActivity.this.dMp.getText(), "").equals(this.gWm)) {
                if (dVar == null || dVar.bDv().isEmpty()) {
                    AtListActivity.this.vG(1);
                } else {
                    AtListActivity.this.vG(0);
                }
                AtListActivity.this.gWd.a(dVar);
                AtListActivity.this.gWe.setData(dVar.bDv());
                AtListActivity.this.gWe.notifyDataSetInvalidated();
                AtListActivity.this.Hj.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(dVar);
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
            AtListActivity.this.gWc = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            String up = this.mNetwork.up();
            if (!this.mNetwork.uN().vL().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.tV(up);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gWc = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dPU != null && AtListActivity.this.dPU.getVisibility() == 0) {
                AtListActivity.this.gWg.setVisibility(0);
            }
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                AtListActivity.this.gWd.a(bVar);
                if (AtListActivity.this.gWe != null) {
                    if (k.a(AtListActivity.this.dMp.getText(), "").length() != 0) {
                        if (AtListActivity.this.gWd.bDz() != null) {
                            if (bVar != null && bVar.bDu() != null && !bVar.bDu().isEmpty()) {
                                AtListActivity.this.vG(2);
                            }
                            AtListActivity.this.gWd.bDz().l(bVar.bDu());
                            AtListActivity.this.gWe.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bDt() == null || !bVar.bDt().isEmpty()) {
                            AtListActivity.this.vG(0);
                        } else {
                            AtListActivity.this.vG(2);
                        }
                        AtListActivity.this.gVZ = bVar.bDt();
                        AtListActivity.this.gWe.setData(AtListActivity.this.gVZ);
                        AtListActivity.this.gWe.notifyDataSetInvalidated();
                        AtListActivity.this.Hj.setSelection(0);
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
            this.gWa.j(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.Hj;
    }
}
