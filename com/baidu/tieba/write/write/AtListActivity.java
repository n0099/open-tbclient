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
    private NoNetworkView dmi;
    private View eMA;
    private View eMB;
    private ImageView eMD;
    private LinearLayout eMv;
    private Button eMw;
    private AtSelectFriendList hHM;
    private TextView hHT;
    private TextView hHU;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    protected ArrayList<MetaData> hHL = new ArrayList<>();
    private EditText rE = null;
    private TextView dtj = null;
    private BdListView avj = null;
    private final Handler mHandler = new Handler();
    private a hHN = null;
    private b hHO = null;
    private com.baidu.tieba.write.model.b hHP = null;
    private com.baidu.tieba.write.write.a hHQ = null;
    private String hHR = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hHS = null;
    private final int hHV = 5;
    private boolean hHW = true;
    private final Runnable hHX = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uv(k.a(AtListActivity.this.rE.getText(), ""));
        }
    };
    private NoNetworkView.a hfr = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (z) {
                AtListActivity.this.uv(null);
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
        uv(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dmi.onChangeSkinType(getPageContext(), i);
        this.hHQ.notifyDataSetChanged();
        aj.getColor(d.C0107d.common_color_10221);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.s(this.eMw, d.f.post_button_bg);
        aj.e(this.eMw, d.C0107d.cp_cont_i, 3);
        aj.a(this.eMD, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.r(this.hHU, d.C0107d.navi_back_text_color);
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
    public void xJ(int i) {
        if (i == 2) {
            this.avj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gn(d.j.no_chat_friends));
            this.eMv.setVisibility(8);
        } else if (i == 1) {
            this.avj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gn(d.j.no_search_friends));
            this.eMv.setVisibility(8);
        } else if (i == 0) {
            this.avj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hHW) {
                this.eMv.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hHQ.getItem(i);
        if (item != null) {
            if (this.hHW) {
                if (this.hHN == null && this.hHO == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hHM.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hHQ.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.rE);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hHN != null) {
            this.hHN.cancel();
        }
        if (this.hHO != null) {
            this.hHO.cancel();
        }
        this.mHandler.removeCallbacks(this.hHX);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.s(getActivity(), d.e.ds320)), NoDataViewFactory.d.gn(d.j.no_chat_friends), null, true);
        this.hHS = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    return false;
                }
                return false;
            }
        });
        avL();
        this.dmi = (NoNetworkView) findViewById(d.g.view_no_network);
        this.dmi.a(this.hfr);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.avj = (BdListView) findViewById(d.g.list);
        this.hHQ = new com.baidu.tieba.write.write.a(this, this.hHW);
        this.hHQ.a(this);
        this.hHQ.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hHM.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.avj.setAdapter((ListAdapter) this.hHQ);
        this.avj.setOnItemClickListener(this);
        this.avj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.rE.getParent() != null) {
            ((View) this.rE.getParent()).setFocusable(true);
            ((View) this.rE.getParent()).setFocusableInTouchMode(true);
        }
        this.eMv = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eMw = (Button) this.mParent.findViewById(d.g.button_send);
        this.eMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hHM.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qI(0);
        this.hHM = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hHM.setMaxCount(5);
        this.hHM.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.avj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aLz();
    }

    private void avL() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hHU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eMA != null && AtListActivity.this.eMA.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    AtListActivity.this.eMA.setVisibility(8);
                    AtListActivity.this.hHT.setVisibility(0);
                    AtListActivity.this.eMB.setVisibility(0);
                    AtListActivity.this.rE.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.finish();
            }
        });
        this.hHT = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.eMB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hHT.setVisibility(8);
                AtListActivity.this.eMB.setVisibility(8);
                AtListActivity.this.eMA.setVisibility(0);
                AtListActivity.this.rE.requestFocus();
            }
        });
        this.eMD = (ImageView) this.eMB.findViewById(d.g.new_friend_search);
        this.eMA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eMA.setVisibility(8);
        this.rE = (EditText) this.eMA.findViewById(d.g.search_bar_edit);
        this.rE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hHR)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hHX);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hHX, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.dtj.setVisibility(0);
                    } else {
                        AtListActivity.this.dtj.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hHR = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.rE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.dtj = (TextView) findViewById(d.g.search_bar_delete_button);
        this.dtj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.rE.getText().clear();
            }
        });
    }

    private void aLz() {
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
                AtListActivity.this.avj.requestFocus();
            }
        });
        this.avj.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uv(String str) {
        if (!isFinishing()) {
            this.hHQ.setData(null);
            if (this.hHN != null) {
                this.hHN.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hHP.bGd() != null) {
                    ArrayList<MetaData> bFS = this.hHP.bGd().bFS();
                    Iterator<MetaData> it = bFS.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bFS != null && !bFS.isEmpty()) {
                        xJ(0);
                    } else {
                        xJ(1);
                    }
                    this.hHQ.setData(bFS);
                } else {
                    this.hHQ.setData(null);
                    if (this.hHO == null) {
                        this.hHO = new b();
                        this.hHO.setPriority(3);
                        this.hHO.execute("");
                    }
                }
            } else {
                this.hHN = new a();
                this.hHN.setPriority(2);
                this.hHN.execute(str);
                if (this.hHO == null && this.hHP.bGd() == null) {
                    this.hHO = new b();
                    this.hHO.setPriority(3);
                    this.hHO.execute("");
                }
            }
            this.hHQ.notifyDataSetInvalidated();
            this.avj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hHP = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hHW = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.hHW = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hHM.f(metaData);
            qI(this.hHM.getItemLength());
            aLA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hHM.h(metaData);
            qI(this.hHM.getItemLength());
            aLA();
        }
    }

    private void aLA() {
        if (this.hHM.getItemLength() > 0) {
            this.eMw.setEnabled(true);
        } else {
            this.eMw.setEnabled(false);
        }
    }

    private void qI(int i) {
        this.eMw.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hHZ;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hHZ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hHN = null;
            this.hHZ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hHZ = strArr[0];
            this.mNetwork = new x();
            if (this.hHZ != null && this.hHZ.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.hHZ);
                String BH = this.mNetwork.BH();
                if (this.mNetwork.Cf().Dc().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b bGd = AtListActivity.this.hHP.bGd();
                    if (bGd != null) {
                        cVar.e(BH, bGd.bFT());
                        return cVar;
                    }
                    cVar.e(BH, null);
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
            AtListActivity.this.hHN = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Cf().Dc().isRequestSuccess() && this.hHZ != null && k.a(AtListActivity.this.rE.getText(), "").equals(this.hHZ)) {
                if (cVar == null || cVar.bFU().isEmpty()) {
                    AtListActivity.this.xJ(1);
                } else {
                    AtListActivity.this.xJ(0);
                }
                AtListActivity.this.hHP.a(cVar);
                AtListActivity.this.hHQ.setData(cVar.bFU());
                AtListActivity.this.hHQ.notifyDataSetInvalidated();
                AtListActivity.this.avj.setSelection(0);
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
                this.mNetwork.mR();
            }
            AtListActivity.this.hHO = null;
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
            String BH = this.mNetwork.BH();
            if (!this.mNetwork.Cf().Dc().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.ug(BH);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hHO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eMv != null && AtListActivity.this.eMv.getVisibility() == 0) {
                AtListActivity.this.hHS.setVisibility(0);
            }
            if (this.mNetwork.Cf().Dc().isRequestSuccess()) {
                AtListActivity.this.hHP.a(bVar);
                if (AtListActivity.this.hHQ != null) {
                    if (k.a(AtListActivity.this.rE.getText(), "").length() != 0) {
                        if (AtListActivity.this.hHP.bGe() != null) {
                            if (bVar != null && bVar.bFT() != null && !bVar.bFT().isEmpty()) {
                                AtListActivity.this.xJ(2);
                            }
                            AtListActivity.this.hHP.bGe().k(bVar.bFT());
                            AtListActivity.this.hHQ.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bFS() == null || !bVar.bFS().isEmpty()) {
                            AtListActivity.this.xJ(0);
                        } else {
                            AtListActivity.this.xJ(2);
                        }
                        AtListActivity.this.hHL = bVar.bFS();
                        AtListActivity.this.hHQ.setData(AtListActivity.this.hHL);
                        AtListActivity.this.hHQ.notifyDataSetInvalidated();
                        AtListActivity.this.avj.setSelection(0);
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
            this.hHM.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.avj == null) {
            return null;
        }
        return this.avj.getPreLoadHandle();
    }
}
