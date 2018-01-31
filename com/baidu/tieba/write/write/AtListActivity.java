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
    private NoNetworkView dmD;
    private LinearLayout eMQ;
    private Button eMR;
    private View eMV;
    private View eMW;
    private ImageView eMY;
    private AtSelectFriendList hIg;
    private TextView hIn;
    private TextView hIo;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    protected ArrayList<MetaData> hIf = new ArrayList<>();
    private EditText rE = null;
    private TextView dtE = null;
    private BdListView avm = null;
    private final Handler mHandler = new Handler();
    private a hIh = null;
    private b hIi = null;
    private com.baidu.tieba.write.model.b hIj = null;
    private com.baidu.tieba.write.write.a hIk = null;
    private String hIl = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hIm = null;
    private final int hIp = 5;
    private boolean hIq = true;
    private final Runnable hIr = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uC(k.a(AtListActivity.this.rE.getText(), ""));
        }
    };
    private NoNetworkView.a hfL = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bq(boolean z) {
            if (z) {
                AtListActivity.this.uC(null);
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
        uC(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dmD.onChangeSkinType(getPageContext(), i);
        this.hIk.notifyDataSetChanged();
        aj.getColor(d.C0108d.common_color_10221);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.s(this.eMR, d.f.post_button_bg);
        aj.e(this.eMR, d.C0108d.cp_cont_i, 3);
        aj.a(this.eMY, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.r(this.hIo, d.C0108d.navi_back_text_color);
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
            this.avm.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gn(d.j.no_chat_friends));
            this.eMQ.setVisibility(8);
        } else if (i == 1) {
            this.avm.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gn(d.j.no_search_friends));
            this.eMQ.setVisibility(8);
        } else if (i == 0) {
            this.avm.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hIq) {
                this.eMQ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hIk.getItem(i);
        if (item != null) {
            if (this.hIq) {
                if (this.hIh == null && this.hIi == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hIg.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hIk.notifyDataSetChanged();
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
        if (this.hIh != null) {
            this.hIh.cancel();
        }
        if (this.hIi != null) {
            this.hIi.cancel();
        }
        this.mHandler.removeCallbacks(this.hIr);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.s(getActivity(), d.e.ds320)), NoDataViewFactory.d.gn(d.j.no_chat_friends), null, true);
        this.hIm = findViewById(d.g.at_candidate_border);
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
        avQ();
        this.dmD = (NoNetworkView) findViewById(d.g.view_no_network);
        this.dmD.a(this.hfL);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.avm = (BdListView) findViewById(d.g.list);
        this.hIk = new com.baidu.tieba.write.write.a(this, this.hIq);
        this.hIk.a(this);
        this.hIk.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hIg.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.avm.setAdapter((ListAdapter) this.hIk);
        this.avm.setOnItemClickListener(this);
        this.avm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.eMQ = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eMR = (Button) this.mParent.findViewById(d.g.button_send);
        this.eMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hIg.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qI(0);
        this.hIg = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hIg.setMaxCount(5);
        this.hIg.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.avm.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aLE();
    }

    private void avQ() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hIo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eMV != null && AtListActivity.this.eMV.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    AtListActivity.this.eMV.setVisibility(8);
                    AtListActivity.this.hIn.setVisibility(0);
                    AtListActivity.this.eMW.setVisibility(0);
                    AtListActivity.this.rE.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.finish();
            }
        });
        this.hIn = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.eMW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hIn.setVisibility(8);
                AtListActivity.this.eMW.setVisibility(8);
                AtListActivity.this.eMV.setVisibility(0);
                AtListActivity.this.rE.requestFocus();
            }
        });
        this.eMY = (ImageView) this.eMW.findViewById(d.g.new_friend_search);
        this.eMV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eMV.setVisibility(8);
        this.rE = (EditText) this.eMV.findViewById(d.g.search_bar_edit);
        this.rE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hIl)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hIr);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hIr, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.dtE.setVisibility(0);
                    } else {
                        AtListActivity.this.dtE.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hIl = k.a(charSequence, null);
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
        this.dtE = (TextView) findViewById(d.g.search_bar_delete_button);
        this.dtE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.rE.getText().clear();
            }
        });
    }

    private void aLE() {
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
                AtListActivity.this.avm.requestFocus();
            }
        });
        this.avm.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC(String str) {
        if (!isFinishing()) {
            this.hIk.setData(null);
            if (this.hIh != null) {
                this.hIh.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hIj.bGf() != null) {
                    ArrayList<MetaData> bFU = this.hIj.bGf().bFU();
                    Iterator<MetaData> it = bFU.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bFU != null && !bFU.isEmpty()) {
                        xJ(0);
                    } else {
                        xJ(1);
                    }
                    this.hIk.setData(bFU);
                } else {
                    this.hIk.setData(null);
                    if (this.hIi == null) {
                        this.hIi = new b();
                        this.hIi.setPriority(3);
                        this.hIi.execute("");
                    }
                }
            } else {
                this.hIh = new a();
                this.hIh.setPriority(2);
                this.hIh.execute(str);
                if (this.hIi == null && this.hIj.bGf() == null) {
                    this.hIi = new b();
                    this.hIi.setPriority(3);
                    this.hIi.execute("");
                }
            }
            this.hIk.notifyDataSetInvalidated();
            this.avm.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hIj = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hIq = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.hIq = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hIg.f(metaData);
            qI(this.hIg.getItemLength());
            aLF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hIg.h(metaData);
            qI(this.hIg.getItemLength());
            aLF();
        }
    }

    private void aLF() {
        if (this.hIg.getItemLength() > 0) {
            this.eMR.setEnabled(true);
        } else {
            this.eMR.setEnabled(false);
        }
    }

    private void qI(int i) {
        this.eMR.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hIt;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hIt = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hIh = null;
            this.hIt = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hIt = strArr[0];
            this.mNetwork = new x();
            if (this.hIt != null && this.hIt.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.hIt);
                String BI = this.mNetwork.BI();
                if (this.mNetwork.Cg().Dd().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b bGf = AtListActivity.this.hIj.bGf();
                    if (bGf != null) {
                        cVar.e(BI, bGf.bFV());
                        return cVar;
                    }
                    cVar.e(BI, null);
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
            AtListActivity.this.hIh = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Cg().Dd().isRequestSuccess() && this.hIt != null && k.a(AtListActivity.this.rE.getText(), "").equals(this.hIt)) {
                if (cVar == null || cVar.bFW().isEmpty()) {
                    AtListActivity.this.xJ(1);
                } else {
                    AtListActivity.this.xJ(0);
                }
                AtListActivity.this.hIj.a(cVar);
                AtListActivity.this.hIk.setData(cVar.bFW());
                AtListActivity.this.hIk.notifyDataSetInvalidated();
                AtListActivity.this.avm.setSelection(0);
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
                this.mNetwork.mS();
            }
            AtListActivity.this.hIi = null;
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
            String BI = this.mNetwork.BI();
            if (!this.mNetwork.Cg().Dd().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.un(BI);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hIi = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eMQ != null && AtListActivity.this.eMQ.getVisibility() == 0) {
                AtListActivity.this.hIm.setVisibility(0);
            }
            if (this.mNetwork.Cg().Dd().isRequestSuccess()) {
                AtListActivity.this.hIj.a(bVar);
                if (AtListActivity.this.hIk != null) {
                    if (k.a(AtListActivity.this.rE.getText(), "").length() != 0) {
                        if (AtListActivity.this.hIj.bGg() != null) {
                            if (bVar != null && bVar.bFV() != null && !bVar.bFV().isEmpty()) {
                                AtListActivity.this.xJ(2);
                            }
                            AtListActivity.this.hIj.bGg().k(bVar.bFV());
                            AtListActivity.this.hIk.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bFU() == null || !bVar.bFU().isEmpty()) {
                            AtListActivity.this.xJ(0);
                        } else {
                            AtListActivity.this.xJ(2);
                        }
                        AtListActivity.this.hIf = bVar.bFU();
                        AtListActivity.this.hIk.setData(AtListActivity.this.hIf);
                        AtListActivity.this.hIk.notifyDataSetInvalidated();
                        AtListActivity.this.avm.setSelection(0);
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
            this.hIg.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.avm == null) {
            return null;
        }
        return this.avm.getPreLoadHandle();
    }
}
