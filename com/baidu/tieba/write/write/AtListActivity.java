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
    private NoNetworkView ctj;
    private LinearLayout dYS;
    private Button dYT;
    private View dYX;
    private View dYY;
    private ImageView dZa;
    private AtSelectFriendList hjZ;
    private TextView hkg;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mNoDataView;
    protected ArrayList<MetaData> hjY = new ArrayList<>();
    private EditText dVm = null;
    private TextView cAh = null;
    private BdListView Hi = null;
    private final Handler mHandler = new Handler();
    private a hka = null;
    private b hkb = null;
    private com.baidu.tieba.write.model.b hkc = null;
    private com.baidu.tieba.write.write.a hkd = null;
    private String hke = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hkf = null;
    private final int hkh = 5;
    private boolean hki = true;
    private final Runnable hkj = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uU(k.a(AtListActivity.this.dVm.getText(), ""));
        }
    };
    private NoNetworkView.a gJb = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
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
        this.ctj.onChangeSkinType(getPageContext(), i);
        this.hkd.notifyDataSetChanged();
        aj.getColor(d.C0095d.common_color_10221);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.j(this.dYT, d.f.post_button_bg);
        aj.c(this.dYT, d.C0095d.cp_cont_i, 3);
        aj.a(this.dZa, d.f.icon_search_bg_s, d.f.icon_search_bg);
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
            this.Hi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_chat_friends));
            this.dYS.setVisibility(8);
        } else if (i == 1) {
            this.Hi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.j.no_search_friends));
            this.dYS.setVisibility(8);
        } else if (i == 0) {
            this.Hi.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hki) {
                this.dYS.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hkd.getItem(i);
        if (item != null) {
            if (this.hki) {
                if (this.hka == null && this.hkb == null) {
                    if (item.isChecked()) {
                        g(item);
                    } else if (5 <= this.hjZ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        f(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hkd.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.dVm);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hka != null) {
            this.hka.cancel();
        }
        if (this.hkb != null) {
            this.hkb.cancel();
        }
        this.mHandler.removeCallbacks(this.hkj);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_chat_friends), null, true);
        this.hkf = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVm);
                    return false;
                }
                return false;
            }
        });
        anb();
        this.ctj = (NoNetworkView) findViewById(d.g.view_no_network);
        this.ctj.a(this.gJb);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Hi = (BdListView) findViewById(d.g.list);
        this.hkd = new com.baidu.tieba.write.write.a(this, this.hki);
        this.hkd.a(this);
        this.hkd.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.g((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hjZ.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.f((MetaData) obj);
                    }
                }
            }
        });
        this.Hi.setAdapter((ListAdapter) this.hkd);
        this.Hi.setOnItemClickListener(this);
        this.Hi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVm);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dVm.getParent() != null) {
            ((View) this.dVm.getParent()).setFocusable(true);
            ((View) this.dVm.getParent()).setFocusableInTouchMode(true);
        }
        this.dYS = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.dYT = (Button) this.mParent.findViewById(d.g.button_send);
        this.dYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hjZ.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVm);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nX(0);
        this.hjZ = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hjZ.setMaxCount(5);
        this.hjZ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Hi.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        aEt();
    }

    private void anb() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dYX != null && AtListActivity.this.dYX.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVm);
                    AtListActivity.this.dYX.setVisibility(8);
                    AtListActivity.this.hkg.setVisibility(0);
                    AtListActivity.this.dYY.setVisibility(0);
                    AtListActivity.this.dVm.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dVm);
                AtListActivity.this.finish();
            }
        });
        this.hkg = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.dYY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hkg.setVisibility(8);
                AtListActivity.this.dYY.setVisibility(8);
                AtListActivity.this.dYX.setVisibility(0);
                AtListActivity.this.dVm.requestFocus();
            }
        });
        this.dZa = (ImageView) this.dYY.findViewById(d.g.new_friend_search);
        this.dYX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dYX.setVisibility(8);
        this.dVm = (EditText) this.dYX.findViewById(d.g.search_bar_edit);
        this.dVm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hke)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hkj);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hkj, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cAh.setVisibility(0);
                    } else {
                        AtListActivity.this.cAh.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hke = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dVm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cAh = (TextView) findViewById(d.g.search_bar_delete_button);
        this.cAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dVm.getText().clear();
            }
        });
    }

    private void aEt() {
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
                AtListActivity.this.Hi.requestFocus();
            }
        });
        this.Hi.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(String str) {
        if (!isFinishing()) {
            this.hkd.setData(null);
            if (this.hka != null) {
                this.hka.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hkc.bGQ() != null) {
                    ArrayList<MetaData> bGF = this.hkc.bGQ().bGF();
                    Iterator<MetaData> it = bGF.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bGF != null && !bGF.isEmpty()) {
                        wp(0);
                    } else {
                        wp(1);
                    }
                    this.hkd.setData(bGF);
                } else {
                    this.hkd.setData(null);
                    if (this.hkb == null) {
                        this.hkb = new b();
                        this.hkb.setPriority(3);
                        this.hkb.execute("");
                    }
                }
            } else {
                this.hka = new a();
                this.hka.setPriority(2);
                this.hka.execute(str);
                if (this.hkb == null && this.hkc.bGQ() == null) {
                    this.hkb = new b();
                    this.hkb.setPriority(3);
                    this.hkb.execute("");
                }
            }
            this.hkd.notifyDataSetInvalidated();
            this.Hi.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hkc = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hki = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.hki = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.hjZ.h(metaData);
            nX(this.hjZ.getItemLength());
            aEu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.hjZ.j(metaData);
            nX(this.hjZ.getItemLength());
            aEu();
        }
    }

    private void aEu() {
        if (this.hjZ.getItemLength() > 0) {
            this.dYT.setEnabled(true);
        } else {
            this.dYT.setEnabled(false);
        }
    }

    private void nX(int i) {
        this.dYT.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hkl;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hkl = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hka = null;
            this.hkl = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hkl = strArr[0];
            this.mNetwork = new x();
            if (this.hkl != null && this.hkl.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.hkl);
                String up = this.mNetwork.up();
                if (this.mNetwork.uN().vL().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b bGQ = AtListActivity.this.hkc.bGQ();
                    if (bGQ != null) {
                        cVar.e(up, bGQ.bGG());
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
            AtListActivity.this.hka = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uN().vL().isRequestSuccess() && this.hkl != null && k.a(AtListActivity.this.dVm.getText(), "").equals(this.hkl)) {
                if (cVar == null || cVar.bGH().isEmpty()) {
                    AtListActivity.this.wp(1);
                } else {
                    AtListActivity.this.wp(0);
                }
                AtListActivity.this.hkc.a(cVar);
                AtListActivity.this.hkd.setData(cVar.bGH());
                AtListActivity.this.hkd.notifyDataSetInvalidated();
                AtListActivity.this.Hi.setSelection(0);
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
            AtListActivity.this.hkb = null;
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
            AtListActivity.this.hkb = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dYS != null && AtListActivity.this.dYS.getVisibility() == 0) {
                AtListActivity.this.hkf.setVisibility(0);
            }
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                AtListActivity.this.hkc.a(bVar);
                if (AtListActivity.this.hkd != null) {
                    if (k.a(AtListActivity.this.dVm.getText(), "").length() != 0) {
                        if (AtListActivity.this.hkc.bGR() != null) {
                            if (bVar != null && bVar.bGG() != null && !bVar.bGG().isEmpty()) {
                                AtListActivity.this.wp(2);
                            }
                            AtListActivity.this.hkc.bGR().l(bVar.bGG());
                            AtListActivity.this.hkd.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bGF() == null || !bVar.bGF().isEmpty()) {
                            AtListActivity.this.wp(0);
                        } else {
                            AtListActivity.this.wp(2);
                        }
                        AtListActivity.this.hjY = bVar.bGF();
                        AtListActivity.this.hkd.setData(AtListActivity.this.hjY);
                        AtListActivity.this.hkd.notifyDataSetInvalidated();
                        AtListActivity.this.Hi.setSelection(0);
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
            this.hjZ.i(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return this.Hi;
    }
}
