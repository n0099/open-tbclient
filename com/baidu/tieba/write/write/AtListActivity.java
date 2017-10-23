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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView ccF;
    private LinearLayout dIb;
    private Button dIc;
    private View dIg;
    private View dIh;
    private ImageView dIj;
    private AtSelectFriendList gKQ;
    private TextView gKX;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    protected ArrayList<MetaData> gKP = new ArrayList<>();
    private EditText dEw = null;
    private TextView cjw = null;
    private BdListView HO = null;
    private final Handler mHandler = new Handler();
    private a gKR = null;
    private b gKS = null;
    private com.baidu.tieba.write.model.b gKT = null;
    private com.baidu.tieba.write.write.a gKU = null;
    private String gKV = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gKW = null;
    private final int gKY = 5;
    private boolean gKZ = true;
    private final Runnable gLa = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.tn(k.a(AtListActivity.this.dEw.getText(), ""));
        }
    };
    private NoNetworkView.a gnv = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aL(boolean z) {
            if (z) {
                AtListActivity.this.tn(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.at_list_activity);
        initData(bundle);
        initUI();
        tn(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ccF.onChangeSkinType(getPageContext(), i);
        this.gKU.notifyDataSetChanged();
        aj.getColor(d.e.common_color_10221);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        aj.j(this.dIc, d.g.post_button_bg);
        aj.c(this.dIc, d.e.cp_cont_i, 3);
        aj.a(this.dIj, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void vh(int i) {
        if (i == 2) {
            this.HO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.l.no_chat_friends));
            this.dIb.setVisibility(8);
        } else if (i == 1) {
            this.HO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.l.no_search_friends));
            this.dIb.setVisibility(8);
        } else if (i == 0) {
            this.HO.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gKZ) {
                this.dIb.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gKU.getItem(i);
        if (item != null) {
            if (this.gKZ) {
                if (this.gKR == null && this.gKS == null) {
                    if (item.isChecked()) {
                        g(item);
                    } else if (5 <= this.gKQ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        f(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gKU.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.dEw);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gKR != null) {
            this.gKR.cancel();
        }
        if (this.gKS != null) {
            this.gKS.cancel();
        }
        this.mHandler.removeCallbacks(this.gLa);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.f.ds320)), NoDataViewFactory.d.dp(d.l.no_chat_friends), null, true);
        this.gKW = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEw);
                    return false;
                }
                return false;
            }
        });
        aiw();
        this.ccF = (NoNetworkView) findViewById(d.h.view_no_network);
        this.ccF.a(this.gnv);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.HO = (BdListView) findViewById(d.h.list);
        this.gKU = new com.baidu.tieba.write.write.a(this, this.gKZ);
        this.gKU.a(this);
        this.gKU.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.g((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gKQ.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.f((MetaData) obj);
                    }
                }
            }
        });
        this.HO.setAdapter((ListAdapter) this.gKU);
        this.HO.setOnItemClickListener(this);
        this.HO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEw);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dEw.getParent() != null) {
            ((View) this.dEw.getParent()).setFocusable(true);
            ((View) this.dEw.getParent()).setFocusableInTouchMode(true);
        }
        this.dIb = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dIc = (Button) this.mParent.findViewById(d.h.button_send);
        this.dIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gKQ.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEw);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nk(0);
        this.gKQ = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gKQ.setMaxCount(5);
        this.gKQ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.HO.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        aAl();
    }

    private void aiw() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dIg != null && AtListActivity.this.dIg.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEw);
                    AtListActivity.this.dIg.setVisibility(8);
                    AtListActivity.this.gKX.setVisibility(0);
                    AtListActivity.this.dIh.setVisibility(0);
                    AtListActivity.this.dEw.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEw);
                AtListActivity.this.finish();
            }
        });
        this.gKX = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dIh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gKX.setVisibility(8);
                AtListActivity.this.dIh.setVisibility(8);
                AtListActivity.this.dIg.setVisibility(0);
                AtListActivity.this.dEw.requestFocus();
            }
        });
        this.dIj = (ImageView) this.dIh.findViewById(d.h.new_friend_search);
        this.dIg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dIg.setVisibility(8);
        this.dEw = (EditText) this.dIg.findViewById(d.h.search_bar_edit);
        this.dEw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gKV)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gLa);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gLa, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cjw.setVisibility(0);
                    } else {
                        AtListActivity.this.cjw.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gKV = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dEw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cjw = (TextView) findViewById(d.h.search_bar_delete_button);
        this.cjw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dEw.getText().clear();
            }
        });
    }

    private void aAl() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds80) + getResources().getDimensionPixelSize(d.f.ds16) + getResources().getDimensionPixelSize(d.f.ds16);
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
                AtListActivity.this.HO.requestFocus();
            }
        });
        this.HO.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tn(String str) {
        if (!isFinishing()) {
            this.gKU.setData(null);
            if (this.gKR != null) {
                this.gKR.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gKT.bzO() != null) {
                    ArrayList<MetaData> bzJ = this.gKT.bzO().bzJ();
                    Iterator<MetaData> it = bzJ.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bzJ != null && !bzJ.isEmpty()) {
                        vh(0);
                    } else {
                        vh(1);
                    }
                    this.gKU.setData(bzJ);
                } else {
                    this.gKU.setData(null);
                    if (this.gKS == null) {
                        this.gKS = new b();
                        this.gKS.setPriority(3);
                        this.gKS.execute("");
                    }
                }
            } else {
                this.gKR = new a();
                this.gKR.setPriority(2);
                this.gKR.execute(str);
                if (this.gKS == null && this.gKT.bzO() == null) {
                    this.gKS = new b();
                    this.gKS.setPriority(3);
                    this.gKS.execute("");
                }
            }
            this.gKU.notifyDataSetInvalidated();
            this.HO.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gKT = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gKZ = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gKZ = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.gKQ.h(metaData);
            nk(this.gKQ.getItemLength());
            aAm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.gKQ.j(metaData);
            nk(this.gKQ.getItemLength());
            aAm();
        }
    }

    private void aAm() {
        if (this.gKQ.getItemLength() > 0) {
            this.dIc.setEnabled(true);
        } else {
            this.dIc.setEnabled(false);
        }
    }

    private void nk(int i) {
        this.dIc.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gLc;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.gLc = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gKR = null;
            this.gLc = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gLc = strArr[0];
            this.mNetwork = new x();
            if (this.gLc != null && this.gLc.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gLc);
                String ui = this.mNetwork.ui();
                if (this.mNetwork.uG().vD().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b bzO = AtListActivity.this.gKT.bzO();
                    if (bzO != null) {
                        dVar.e(ui, bzO.bzK());
                        return dVar;
                    }
                    dVar.e(ui, null);
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
            AtListActivity.this.gKR = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uG().vD().isRequestSuccess() && this.gLc != null && k.a(AtListActivity.this.dEw.getText(), "").equals(this.gLc)) {
                if (dVar == null || dVar.bzL().isEmpty()) {
                    AtListActivity.this.vh(1);
                } else {
                    AtListActivity.this.vh(0);
                }
                AtListActivity.this.gKT.a(dVar);
                AtListActivity.this.gKU.setData(dVar.bzL());
                AtListActivity.this.gKU.notifyDataSetInvalidated();
                AtListActivity.this.HO.setSelection(0);
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
            AtListActivity.this.gKS = null;
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
            String ui = this.mNetwork.ui();
            if (!this.mNetwork.uG().vD().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.tc(ui);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gKS = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dIb != null && AtListActivity.this.dIb.getVisibility() == 0) {
                AtListActivity.this.gKW.setVisibility(0);
            }
            if (this.mNetwork.uG().vD().isRequestSuccess()) {
                AtListActivity.this.gKT.a(bVar);
                if (AtListActivity.this.gKU != null) {
                    if (k.a(AtListActivity.this.dEw.getText(), "").length() != 0) {
                        if (AtListActivity.this.gKT.bzP() != null) {
                            if (bVar != null && bVar.bzK() != null && !bVar.bzK().isEmpty()) {
                                AtListActivity.this.vh(2);
                            }
                            AtListActivity.this.gKT.bzP().l(bVar.bzK());
                            AtListActivity.this.gKU.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bzJ() == null || !bVar.bzJ().isEmpty()) {
                            AtListActivity.this.vh(0);
                        } else {
                            AtListActivity.this.vh(2);
                        }
                        AtListActivity.this.gKP = bVar.bzJ();
                        AtListActivity.this.gKU.setData(AtListActivity.this.gKP);
                        AtListActivity.this.gKU.notifyDataSetInvalidated();
                        AtListActivity.this.HO.setSelection(0);
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
            this.gKQ.i(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.HO;
    }
}
