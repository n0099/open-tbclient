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
    private NoNetworkView csW;
    private LinearLayout dXJ;
    private Button dXK;
    private View dXO;
    private View dXP;
    private ImageView dXR;
    private AtSelectFriendList hhb;
    private TextView hhi;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.f mNoDataView;
    protected ArrayList<MetaData> hha = new ArrayList<>();
    private EditText dUd = null;
    private TextView czV = null;
    private BdListView Hj = null;
    private final Handler mHandler = new Handler();
    private a hhc = null;
    private b hhd = null;
    private com.baidu.tieba.write.model.b hhe = null;
    private com.baidu.tieba.write.write.a hhf = null;
    private String hhg = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hhh = null;
    private final int hhj = 5;
    private boolean hhk = true;
    private final Runnable hhl = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uP(k.a(AtListActivity.this.dUd.getText(), ""));
        }
    };
    private NoNetworkView.a gGo = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (z) {
                AtListActivity.this.uP(null);
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
        uP(null);
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
        this.csW.onChangeSkinType(getPageContext(), i);
        this.hhf.notifyDataSetChanged();
        aj.getColor(d.C0082d.common_color_10221);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.j(this.dXK, d.f.post_button_bg);
        aj.c(this.dXK, d.C0082d.cp_cont_i, 3);
        aj.a(this.dXR, d.f.icon_search_bg_s, d.f.icon_search_bg);
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
    public void wc(int i) {
        if (i == 2) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_chat_friends));
            this.dXJ.setVisibility(8);
        } else if (i == 1) {
            this.Hj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_search_friends));
            this.dXJ.setVisibility(8);
        } else if (i == 0) {
            this.Hj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hhk) {
                this.dXJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hhf.getItem(i);
        if (item != null) {
            if (this.hhk) {
                if (this.hhc == null && this.hhd == null) {
                    if (item.isChecked()) {
                        g(item);
                    } else if (5 <= this.hhb.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        f(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hhf.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.dUd);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hhc != null) {
            this.hhc.cancel();
        }
        if (this.hhd != null) {
            this.hhd.cancel();
        }
        this.mHandler.removeCallbacks(this.hhl);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_chat_friends), null, true);
        this.hhh = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dUd);
                    return false;
                }
                return false;
            }
        });
        amS();
        this.csW = (NoNetworkView) findViewById(d.g.view_no_network);
        this.csW.a(this.gGo);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Hj = (BdListView) findViewById(d.g.list);
        this.hhf = new com.baidu.tieba.write.write.a(this, this.hhk);
        this.hhf.a(this);
        this.hhf.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.g((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hhb.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.f((MetaData) obj);
                    }
                }
            }
        });
        this.Hj.setAdapter((ListAdapter) this.hhf);
        this.Hj.setOnItemClickListener(this);
        this.Hj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dUd);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dUd.getParent() != null) {
            ((View) this.dUd.getParent()).setFocusable(true);
            ((View) this.dUd.getParent()).setFocusableInTouchMode(true);
        }
        this.dXJ = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.dXK = (Button) this.mParent.findViewById(d.g.button_send);
        this.dXK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hhb.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dUd);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nQ(0);
        this.hhb = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hhb.setMaxCount(5);
        this.hhb.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
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
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        aEk();
    }

    private void amS() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dXO != null && AtListActivity.this.dXO.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dUd);
                    AtListActivity.this.dXO.setVisibility(8);
                    AtListActivity.this.hhi.setVisibility(0);
                    AtListActivity.this.dXP.setVisibility(0);
                    AtListActivity.this.dUd.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dUd);
                AtListActivity.this.finish();
            }
        });
        this.hhi = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.dXP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hhi.setVisibility(8);
                AtListActivity.this.dXP.setVisibility(8);
                AtListActivity.this.dXO.setVisibility(0);
                AtListActivity.this.dUd.requestFocus();
            }
        });
        this.dXR = (ImageView) this.dXP.findViewById(d.g.new_friend_search);
        this.dXO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dXO.setVisibility(8);
        this.dUd = (EditText) this.dXO.findViewById(d.g.search_bar_edit);
        this.dUd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hhg)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hhl);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hhl, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.czV.setVisibility(0);
                    } else {
                        AtListActivity.this.czV.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hhg = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dUd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.czV = (TextView) findViewById(d.g.search_bar_delete_button);
        this.czV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dUd.getText().clear();
            }
        });
    }

    private void aEk() {
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
    public void uP(String str) {
        if (!isFinishing()) {
            this.hhf.setData(null);
            if (this.hhc != null) {
                this.hhc.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hhe.bGe() != null) {
                    ArrayList<MetaData> bFT = this.hhe.bGe().bFT();
                    Iterator<MetaData> it = bFT.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bFT != null && !bFT.isEmpty()) {
                        wc(0);
                    } else {
                        wc(1);
                    }
                    this.hhf.setData(bFT);
                } else {
                    this.hhf.setData(null);
                    if (this.hhd == null) {
                        this.hhd = new b();
                        this.hhd.setPriority(3);
                        this.hhd.execute("");
                    }
                }
            } else {
                this.hhc = new a();
                this.hhc.setPriority(2);
                this.hhc.execute(str);
                if (this.hhd == null && this.hhe.bGe() == null) {
                    this.hhd = new b();
                    this.hhd.setPriority(3);
                    this.hhd.execute("");
                }
            }
            this.hhf.notifyDataSetInvalidated();
            this.Hj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hhe = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hhk = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.hhk = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.hhb.h(metaData);
            nQ(this.hhb.getItemLength());
            aEl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.hhb.j(metaData);
            nQ(this.hhb.getItemLength());
            aEl();
        }
    }

    private void aEl() {
        if (this.hhb.getItemLength() > 0) {
            this.dXK.setEnabled(true);
        } else {
            this.dXK.setEnabled(false);
        }
    }

    private void nQ(int i) {
        this.dXK.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hhn;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hhn = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hhc = null;
            this.hhn = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hhn = strArr[0];
            this.mNetwork = new x();
            if (this.hhn != null && this.hhn.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.hhn);
                String us = this.mNetwork.us();
                if (this.mNetwork.uQ().vO().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b bGe = AtListActivity.this.hhe.bGe();
                    if (bGe != null) {
                        cVar.e(us, bGe.bFU());
                        return cVar;
                    }
                    cVar.e(us, null);
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
            AtListActivity.this.hhc = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uQ().vO().isRequestSuccess() && this.hhn != null && k.a(AtListActivity.this.dUd.getText(), "").equals(this.hhn)) {
                if (cVar == null || cVar.bFV().isEmpty()) {
                    AtListActivity.this.wc(1);
                } else {
                    AtListActivity.this.wc(0);
                }
                AtListActivity.this.hhe.a(cVar);
                AtListActivity.this.hhf.setData(cVar.bFV());
                AtListActivity.this.hhf.notifyDataSetInvalidated();
                AtListActivity.this.Hj.setSelection(0);
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
            AtListActivity.this.hhd = null;
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
            String us = this.mNetwork.us();
            if (!this.mNetwork.uQ().vO().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uD(us);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hhd = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dXJ != null && AtListActivity.this.dXJ.getVisibility() == 0) {
                AtListActivity.this.hhh.setVisibility(0);
            }
            if (this.mNetwork.uQ().vO().isRequestSuccess()) {
                AtListActivity.this.hhe.a(bVar);
                if (AtListActivity.this.hhf != null) {
                    if (k.a(AtListActivity.this.dUd.getText(), "").length() != 0) {
                        if (AtListActivity.this.hhe.bGf() != null) {
                            if (bVar != null && bVar.bFU() != null && !bVar.bFU().isEmpty()) {
                                AtListActivity.this.wc(2);
                            }
                            AtListActivity.this.hhe.bGf().l(bVar.bFU());
                            AtListActivity.this.hhf.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bFT() == null || !bVar.bFT().isEmpty()) {
                            AtListActivity.this.wc(0);
                        } else {
                            AtListActivity.this.wc(2);
                        }
                        AtListActivity.this.hha = bVar.bFT();
                        AtListActivity.this.hhf.setData(AtListActivity.this.hha);
                        AtListActivity.this.hhf.notifyDataSetInvalidated();
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
            this.hhb.i(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return this.Hj;
    }
}
