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
    private NoNetworkView ckb;
    private LinearLayout dPP;
    private Button dPQ;
    private View dPU;
    private View dPV;
    private ImageView dPX;
    private AtSelectFriendList gUQ;
    private TextView gUX;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.f mNoDataView;
    protected ArrayList<MetaData> gUP = new ArrayList<>();
    private EditText dMk = null;
    private TextView cqR = null;
    private BdListView Hj = null;
    private final Handler mHandler = new Handler();
    private a gUR = null;
    private b gUS = null;
    private com.baidu.tieba.write.model.b gUT = null;
    private com.baidu.tieba.write.write.a gUU = null;
    private String gUV = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gUW = null;
    private final int gUY = 5;
    private boolean gUZ = true;
    private final Runnable gVa = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.ua(k.a(AtListActivity.this.dMk.getText(), ""));
        }
    };
    private NoNetworkView.a gwi = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (z) {
                AtListActivity.this.ua(null);
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
        ua(null);
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
        this.ckb.onChangeSkinType(getPageContext(), i);
        this.gUU.notifyDataSetChanged();
        aj.getColor(d.C0080d.common_color_10221);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.j(this.dPQ, d.f.post_button_bg);
        aj.c(this.dPQ, d.C0080d.cp_cont_i, 3);
        aj.a(this.dPX, d.f.icon_search_bg_s, d.f.icon_search_bg);
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
    public void vC(int i) {
        if (i == 2) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_chat_friends));
            this.dPP.setVisibility(8);
        } else if (i == 1) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_search_friends));
            this.dPP.setVisibility(8);
        } else if (i == 0) {
            this.Hj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gUZ) {
                this.dPP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gUU.getItem(i);
        if (item != null) {
            if (this.gUZ) {
                if (this.gUR == null && this.gUS == null) {
                    if (item.isChecked()) {
                        h(item);
                    } else if (5 <= this.gUQ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        g(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gUU.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.dMk);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gUR != null) {
            this.gUR.cancel();
        }
        if (this.gUS != null) {
            this.gUS.cancel();
        }
        this.mHandler.removeCallbacks(this.gVa);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_chat_friends), null, true);
        this.gUW = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMk);
                    return false;
                }
                return false;
            }
        });
        akI();
        this.ckb = (NoNetworkView) findViewById(d.g.view_no_network);
        this.ckb.a(this.gwi);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Hj = (BdListView) findViewById(d.g.list);
        this.gUU = new com.baidu.tieba.write.write.a(this, this.gUZ);
        this.gUU.a(this);
        this.gUU.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.h((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gUQ.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        this.Hj.setAdapter((ListAdapter) this.gUU);
        this.Hj.setOnItemClickListener(this);
        this.Hj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMk);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dMk.getParent() != null) {
            ((View) this.dMk.getParent()).setFocusable(true);
            ((View) this.dMk.getParent()).setFocusableInTouchMode(true);
        }
        this.dPP = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.dPQ = (Button) this.mParent.findViewById(d.g.button_send);
        this.dPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gUQ.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMk);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nB(0);
        this.gUQ = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.gUQ.setMaxCount(5);
        this.gUQ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
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
        aCG();
    }

    private void akI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dPU != null && AtListActivity.this.dPU.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMk);
                    AtListActivity.this.dPU.setVisibility(8);
                    AtListActivity.this.gUX.setVisibility(0);
                    AtListActivity.this.dPV.setVisibility(0);
                    AtListActivity.this.dMk.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dMk);
                AtListActivity.this.finish();
            }
        });
        this.gUX = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.dPV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gUX.setVisibility(8);
                AtListActivity.this.dPV.setVisibility(8);
                AtListActivity.this.dPU.setVisibility(0);
                AtListActivity.this.dMk.requestFocus();
            }
        });
        this.dPX = (ImageView) this.dPV.findViewById(d.g.new_friend_search);
        this.dPU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dPU.setVisibility(8);
        this.dMk = (EditText) this.dPU.findViewById(d.g.search_bar_edit);
        this.dMk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gUV)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gVa);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gVa, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cqR.setVisibility(0);
                    } else {
                        AtListActivity.this.cqR.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gUV = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dMk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cqR = (TextView) findViewById(d.g.search_bar_delete_button);
        this.cqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dMk.getText().clear();
            }
        });
    }

    private void aCG() {
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
    public void ua(String str) {
        if (!isFinishing()) {
            this.gUU.setData(null);
            if (this.gUR != null) {
                this.gUR.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gUT.bDm() != null) {
                    ArrayList<MetaData> bDh = this.gUT.bDm().bDh();
                    Iterator<MetaData> it = bDh.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bDh != null && !bDh.isEmpty()) {
                        vC(0);
                    } else {
                        vC(1);
                    }
                    this.gUU.setData(bDh);
                } else {
                    this.gUU.setData(null);
                    if (this.gUS == null) {
                        this.gUS = new b();
                        this.gUS.setPriority(3);
                        this.gUS.execute("");
                    }
                }
            } else {
                this.gUR = new a();
                this.gUR.setPriority(2);
                this.gUR.execute(str);
                if (this.gUS == null && this.gUT.bDm() == null) {
                    this.gUS = new b();
                    this.gUS.setPriority(3);
                    this.gUS.execute("");
                }
            }
            this.gUU.notifyDataSetInvalidated();
            this.Hj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gUT = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gUZ = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gUZ = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.gUQ.i(metaData);
            nB(this.gUQ.getItemLength());
            aCH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(MetaData metaData) {
        if (metaData != null) {
            this.gUQ.k(metaData);
            nB(this.gUQ.getItemLength());
            aCH();
        }
    }

    private void aCH() {
        if (this.gUQ.getItemLength() > 0) {
            this.dPQ.setEnabled(true);
        } else {
            this.dPQ.setEnabled(false);
        }
    }

    private void nB(int i) {
        this.dPQ.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gVc;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.gVc = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gUR = null;
            this.gVc = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gVc = strArr[0];
            this.mNetwork = new x();
            if (this.gVc != null && this.gVc.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gVc);
                String up = this.mNetwork.up();
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b bDm = AtListActivity.this.gUT.bDm();
                    if (bDm != null) {
                        dVar.e(up, bDm.bDi());
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
            AtListActivity.this.gUR = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uN().vL().isRequestSuccess() && this.gVc != null && k.a(AtListActivity.this.dMk.getText(), "").equals(this.gVc)) {
                if (dVar == null || dVar.bDj().isEmpty()) {
                    AtListActivity.this.vC(1);
                } else {
                    AtListActivity.this.vC(0);
                }
                AtListActivity.this.gUT.a(dVar);
                AtListActivity.this.gUU.setData(dVar.bDj());
                AtListActivity.this.gUU.notifyDataSetInvalidated();
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
            AtListActivity.this.gUS = null;
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
            bVar.tP(up);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gUS = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dPP != null && AtListActivity.this.dPP.getVisibility() == 0) {
                AtListActivity.this.gUW.setVisibility(0);
            }
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                AtListActivity.this.gUT.a(bVar);
                if (AtListActivity.this.gUU != null) {
                    if (k.a(AtListActivity.this.dMk.getText(), "").length() != 0) {
                        if (AtListActivity.this.gUT.bDn() != null) {
                            if (bVar != null && bVar.bDi() != null && !bVar.bDi().isEmpty()) {
                                AtListActivity.this.vC(2);
                            }
                            AtListActivity.this.gUT.bDn().l(bVar.bDi());
                            AtListActivity.this.gUU.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bDh() == null || !bVar.bDh().isEmpty()) {
                            AtListActivity.this.vC(0);
                        } else {
                            AtListActivity.this.vC(2);
                        }
                        AtListActivity.this.gUP = bVar.bDh();
                        AtListActivity.this.gUU.setData(AtListActivity.this.gUP);
                        AtListActivity.this.gUU.notifyDataSetInvalidated();
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
            this.gUQ.j(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.Hj;
    }
}
