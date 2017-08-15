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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView bFB;
    private LinearLayout dEB;
    private Button dEC;
    private View dEG;
    private View dEH;
    private ImageView dEJ;
    private AtSelectFriendList gGM;
    private TextView gGT;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected ArrayList<MetaData> gGL = new ArrayList<>();
    private EditText dAX = null;
    private TextView cft = null;
    private BdListView JE = null;
    private final Handler mHandler = new Handler();
    private a gGN = null;
    private b gGO = null;
    private com.baidu.tieba.write.model.b gGP = null;
    private com.baidu.tieba.write.write.a gGQ = null;
    private String gGR = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gGS = null;
    private final int gGU = 5;
    private boolean gGV = true;
    private final Runnable gGW = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.ti(com.baidu.adp.lib.util.j.a(AtListActivity.this.dAX.getText(), ""));
        }
    };
    private NoNetworkView.a gqz = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.ti(null);
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
        ti(null);
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
        this.bFB.onChangeSkinType(getPageContext(), i);
        this.gGQ.notifyDataSetChanged();
        ai.getColor(d.e.common_color_10221);
        ai.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        ai.j(this.dEC, d.g.post_button_bg);
        ai.c(this.dEC, d.e.cp_cont_i, 3);
        ai.b(this.dEJ, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void uI(int i) {
        if (i == 2) {
            this.JE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dk(d.l.no_chat_friends));
            this.dEB.setVisibility(8);
        } else if (i == 1) {
            this.JE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dk(d.l.no_search_friends));
            this.dEB.setVisibility(8);
        } else if (i == 0) {
            this.JE.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gGV) {
                this.dEB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gGQ.getItem(i);
        if (item != null) {
            if (this.gGV) {
                if (this.gGN == null && this.gGO == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.gGM.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gGQ.notifyDataSetChanged();
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
            k.b(getPageContext().getPageActivity(), this.dAX);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gGN != null) {
            this.gGN.cancel();
        }
        if (this.gGO != null) {
            this.gGO.cancel();
        }
        this.mHandler.removeCallbacks(this.gGW);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(getActivity(), d.f.ds320)), NoDataViewFactory.d.dk(d.l.no_chat_friends), null, true);
        this.gGS = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dAX);
                    return false;
                }
                return false;
            }
        });
        Ws();
        this.bFB = (NoNetworkView) findViewById(d.h.view_no_network);
        this.bFB.a(this.gqz);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.JE = (BdListView) findViewById(d.h.list);
        this.gGQ = new com.baidu.tieba.write.write.a(this, this.gGV);
        this.gGQ.a(this);
        this.gGQ.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gGM.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.JE.setAdapter((ListAdapter) this.gGQ);
        this.JE.setOnItemClickListener(this);
        this.JE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dAX);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dAX.getParent() != null) {
            ((View) this.dAX.getParent()).setFocusable(true);
            ((View) this.dAX.getParent()).setFocusableInTouchMode(true);
        }
        this.dEB = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dEC = (Button) this.mParent.findViewById(d.h.button_send);
        this.dEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gGM.getDataList());
                intent.putExtras(bundle);
                k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dAX);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        mU(0);
        this.gGM = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gGM.setMaxCount(5);
        this.gGM.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.JE.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        azK();
    }

    private void Ws() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dEG != null && AtListActivity.this.dEG.getVisibility() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dAX);
                    AtListActivity.this.dEG.setVisibility(8);
                    AtListActivity.this.gGT.setVisibility(0);
                    AtListActivity.this.dEH.setVisibility(0);
                    AtListActivity.this.dAX.getText().clear();
                    return;
                }
                k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dAX);
                AtListActivity.this.finish();
            }
        });
        this.gGT = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dEH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gGT.setVisibility(8);
                AtListActivity.this.dEH.setVisibility(8);
                AtListActivity.this.dEG.setVisibility(0);
                AtListActivity.this.dAX.requestFocus();
            }
        });
        this.dEJ = (ImageView) this.dEH.findViewById(d.h.new_friend_search);
        this.dEG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dEG.setVisibility(8);
        this.dAX = (EditText) this.dEG.findViewById(d.h.search_bar_edit);
        this.dAX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.j.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gGR)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gGW);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gGW, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cft.setVisibility(0);
                    } else {
                        AtListActivity.this.cft.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gGR = com.baidu.adp.lib.util.j.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dAX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    k.c(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cft = (TextView) findViewById(d.h.search_bar_delete_button);
        this.cft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dAX.getText().clear();
            }
        });
    }

    private void azK() {
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
                AtListActivity.this.JE.requestFocus();
            }
        });
        this.JE.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(String str) {
        if (!isFinishing()) {
            this.gGQ.setData(null);
            if (this.gGN != null) {
                this.gGN.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gGP.bzl() != null) {
                    ArrayList<MetaData> bzf = this.gGP.bzl().bzf();
                    Iterator<MetaData> it = bzf.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bzf != null && !bzf.isEmpty()) {
                        uI(0);
                    } else {
                        uI(1);
                    }
                    this.gGQ.setData(bzf);
                } else {
                    this.gGQ.setData(null);
                    if (this.gGO == null) {
                        this.gGO = new b();
                        this.gGO.setPriority(3);
                        this.gGO.execute("");
                    }
                }
            } else {
                this.gGN = new a();
                this.gGN.setPriority(2);
                this.gGN.execute(str);
                if (this.gGO == null && this.gGP.bzl() == null) {
                    this.gGO = new b();
                    this.gGO.setPriority(3);
                    this.gGO.execute("");
                }
            }
            this.gGQ.notifyDataSetInvalidated();
            this.JE.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gGP = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gGV = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gGV = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.gGM.f(metaData);
            mU(this.gGM.getItemLength());
            azL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.gGM.h(metaData);
            mU(this.gGM.getItemLength());
            azL();
        }
    }

    private void azL() {
        if (this.gGM.getItemLength() > 0) {
            this.dEC.setEnabled(true);
        } else {
            this.dEC.setEnabled(false);
        }
    }

    private void mU(int i) {
        this.dEC.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gGY;
        private w mNetwork;

        private a() {
            this.mNetwork = null;
            this.gGY = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gGN = null;
            this.gGY = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gGY = strArr[0];
            this.mNetwork = new w();
            if (this.gGY != null && this.gGY.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gGY);
                String uO = this.mNetwork.uO();
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b bzl = AtListActivity.this.gGP.bzl();
                    if (bzl != null) {
                        dVar.e(uO, bzl.bzg());
                        return dVar;
                    }
                    dVar.e(uO, null);
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
            AtListActivity.this.gGN = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vl().wi().isRequestSuccess() && this.gGY != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dAX.getText(), "").equals(this.gGY)) {
                if (dVar == null || dVar.bzh().isEmpty()) {
                    AtListActivity.this.uI(1);
                } else {
                    AtListActivity.this.uI(0);
                }
                AtListActivity.this.gGP.a(dVar);
                AtListActivity.this.gGQ.setData(dVar.bzh());
                AtListActivity.this.gGQ.notifyDataSetInvalidated();
                AtListActivity.this.JE.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private w mNetwork;

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
                this.mNetwork.fA();
            }
            AtListActivity.this.gGO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new w();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            String uO = this.mNetwork.uO();
            if (!this.mNetwork.vl().wi().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.sX(uO);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gGO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dEB != null && AtListActivity.this.dEB.getVisibility() == 0) {
                AtListActivity.this.gGS.setVisibility(0);
            }
            if (this.mNetwork.vl().wi().isRequestSuccess()) {
                AtListActivity.this.gGP.a(bVar);
                if (AtListActivity.this.gGQ != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dAX.getText(), "").length() != 0) {
                        if (AtListActivity.this.gGP.bzm() != null) {
                            if (bVar != null && bVar.bzg() != null && !bVar.bzg().isEmpty()) {
                                AtListActivity.this.uI(2);
                            }
                            AtListActivity.this.gGP.bzm().k(bVar.bzg());
                            AtListActivity.this.gGQ.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bzf() == null || !bVar.bzf().isEmpty()) {
                            AtListActivity.this.uI(0);
                        } else {
                            AtListActivity.this.uI(2);
                        }
                        AtListActivity.this.gGL = bVar.bzf();
                        AtListActivity.this.gGQ.setData(AtListActivity.this.gGL);
                        AtListActivity.this.gGQ.notifyDataSetInvalidated();
                        AtListActivity.this.JE.setSelection(0);
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
            this.gGM.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.JE;
    }
}
