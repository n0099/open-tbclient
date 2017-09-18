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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView bJn;
    private LinearLayout dLZ;
    private Button dMa;
    private View dMe;
    private View dMf;
    private ImageView dMh;
    private AtSelectFriendList gGk;
    private TextView gGr;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected ArrayList<MetaData> gGj = new ArrayList<>();
    private EditText dIv = null;
    private TextView cjU = null;
    private BdListView Hw = null;
    private final Handler mHandler = new Handler();
    private a gGl = null;
    private b gGm = null;
    private com.baidu.tieba.write.model.b gGn = null;
    private com.baidu.tieba.write.write.a gGo = null;
    private String gGp = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gGq = null;
    private final int gGs = 5;
    private boolean gGt = true;
    private final Runnable gGu = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.tj(com.baidu.adp.lib.util.j.a(AtListActivity.this.dIv.getText(), ""));
        }
    };
    private NoNetworkView.a gpU = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.tj(null);
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
        tj(null);
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
        this.bJn.onChangeSkinType(getPageContext(), i);
        this.gGo.notifyDataSetChanged();
        aj.getColor(d.e.common_color_10221);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        aj.j(this.dMa, d.g.post_button_bg);
        aj.c(this.dMa, d.e.cp_cont_i, 3);
        aj.a(this.dMh, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void uM(int i) {
        if (i == 2) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dl(d.l.no_chat_friends));
            this.dLZ.setVisibility(8);
        } else if (i == 1) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dl(d.l.no_search_friends));
            this.dLZ.setVisibility(8);
        } else if (i == 0) {
            this.Hw.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gGt) {
                this.dLZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gGo.getItem(i);
        if (item != null) {
            if (this.gGt) {
                if (this.gGl == null && this.gGm == null) {
                    if (item.isChecked()) {
                        f(item);
                    } else if (5 <= this.gGk.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        e(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gGo.notifyDataSetChanged();
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
            k.a(getPageContext().getPageActivity(), this.dIv);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gGl != null) {
            this.gGl.cancel();
        }
        if (this.gGm != null) {
            this.gGm.cancel();
        }
        this.mHandler.removeCallbacks(this.gGu);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.f(getActivity(), d.f.ds320)), NoDataViewFactory.d.dl(d.l.no_chat_friends), null, true);
        this.gGq = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dIv);
                    return false;
                }
                return false;
            }
        });
        XD();
        this.bJn = (NoNetworkView) findViewById(d.h.view_no_network);
        this.bJn.a(this.gpU);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.Hw = (BdListView) findViewById(d.h.list);
        this.gGo = new com.baidu.tieba.write.write.a(this, this.gGt);
        this.gGo.a(this);
        this.gGo.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.f((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gGk.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        this.Hw.setAdapter((ListAdapter) this.gGo);
        this.Hw.setOnItemClickListener(this);
        this.Hw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dIv);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dIv.getParent() != null) {
            ((View) this.dIv.getParent()).setFocusable(true);
            ((View) this.dIv.getParent()).setFocusableInTouchMode(true);
        }
        this.dLZ = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dMa = (Button) this.mParent.findViewById(d.h.button_send);
        this.dMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gGk.getDataList());
                intent.putExtras(bundle);
                k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dIv);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        np(0);
        this.gGk = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gGk.setMaxCount(5);
        this.gGk.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Hw.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.f((MetaData) obj);
                    }
                }
            }
        });
        aBF();
    }

    private void XD() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dMe != null && AtListActivity.this.dMe.getVisibility() == 0) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dIv);
                    AtListActivity.this.dMe.setVisibility(8);
                    AtListActivity.this.gGr.setVisibility(0);
                    AtListActivity.this.dMf.setVisibility(0);
                    AtListActivity.this.dIv.getText().clear();
                    return;
                }
                k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dIv);
                AtListActivity.this.finish();
            }
        });
        this.gGr = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dMf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gGr.setVisibility(8);
                AtListActivity.this.dMf.setVisibility(8);
                AtListActivity.this.dMe.setVisibility(0);
                AtListActivity.this.dIv.requestFocus();
            }
        });
        this.dMh = (ImageView) this.dMf.findViewById(d.h.new_friend_search);
        this.dMe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dMe.setVisibility(8);
        this.dIv = (EditText) this.dMe.findViewById(d.h.search_bar_edit);
        this.dIv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.j.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gGp)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gGu);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gGu, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cjU.setVisibility(0);
                    } else {
                        AtListActivity.this.cjU.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gGp = com.baidu.adp.lib.util.j.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dIv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cjU = (TextView) findViewById(d.h.search_bar_delete_button);
        this.cjU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dIv.getText().clear();
            }
        });
    }

    private void aBF() {
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
                AtListActivity.this.Hw.requestFocus();
            }
        });
        this.Hw.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(String str) {
        if (!isFinishing()) {
            this.gGo.setData(null);
            if (this.gGl != null) {
                this.gGl.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gGn.byE() != null) {
                    ArrayList<MetaData> byz = this.gGn.byE().byz();
                    Iterator<MetaData> it = byz.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (byz != null && !byz.isEmpty()) {
                        uM(0);
                    } else {
                        uM(1);
                    }
                    this.gGo.setData(byz);
                } else {
                    this.gGo.setData(null);
                    if (this.gGm == null) {
                        this.gGm = new b();
                        this.gGm.setPriority(3);
                        this.gGm.execute("");
                    }
                }
            } else {
                this.gGl = new a();
                this.gGl.setPriority(2);
                this.gGl.execute(str);
                if (this.gGm == null && this.gGn.byE() == null) {
                    this.gGm = new b();
                    this.gGm.setPriority(3);
                    this.gGm.execute("");
                }
            }
            this.gGo.notifyDataSetInvalidated();
            this.Hw.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gGn = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gGt = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gGt = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.gGk.g(metaData);
            np(this.gGk.getItemLength());
            aBG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.gGk.i(metaData);
            np(this.gGk.getItemLength());
            aBG();
        }
    }

    private void aBG() {
        if (this.gGk.getItemLength() > 0) {
            this.dMa.setEnabled(true);
        } else {
            this.dMa.setEnabled(false);
        }
    }

    private void np(int i) {
        this.dMa.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gGw;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.gGw = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gGl = null;
            this.gGw = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gGw = strArr[0];
            this.mNetwork = new x();
            if (this.gGw != null && this.gGw.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gGw);
                String uM = this.mNetwork.uM();
                if (this.mNetwork.vj().wg().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b byE = AtListActivity.this.gGn.byE();
                    if (byE != null) {
                        dVar.e(uM, byE.byA());
                        return dVar;
                    }
                    dVar.e(uM, null);
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
            AtListActivity.this.gGl = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vj().wg().isRequestSuccess() && this.gGw != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dIv.getText(), "").equals(this.gGw)) {
                if (dVar == null || dVar.byB().isEmpty()) {
                    AtListActivity.this.uM(1);
                } else {
                    AtListActivity.this.uM(0);
                }
                AtListActivity.this.gGn.a(dVar);
                AtListActivity.this.gGo.setData(dVar.byB());
                AtListActivity.this.gGo.notifyDataSetInvalidated();
                AtListActivity.this.Hw.setSelection(0);
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
                this.mNetwork.fp();
            }
            AtListActivity.this.gGm = null;
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
            String uM = this.mNetwork.uM();
            if (!this.mNetwork.vj().wg().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.sZ(uM);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gGm = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dLZ != null && AtListActivity.this.dLZ.getVisibility() == 0) {
                AtListActivity.this.gGq.setVisibility(0);
            }
            if (this.mNetwork.vj().wg().isRequestSuccess()) {
                AtListActivity.this.gGn.a(bVar);
                if (AtListActivity.this.gGo != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dIv.getText(), "").length() != 0) {
                        if (AtListActivity.this.gGn.byF() != null) {
                            if (bVar != null && bVar.byA() != null && !bVar.byA().isEmpty()) {
                                AtListActivity.this.uM(2);
                            }
                            AtListActivity.this.gGn.byF().l(bVar.byA());
                            AtListActivity.this.gGo.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.byz() == null || !bVar.byz().isEmpty()) {
                            AtListActivity.this.uM(0);
                        } else {
                            AtListActivity.this.uM(2);
                        }
                        AtListActivity.this.gGj = bVar.byz();
                        AtListActivity.this.gGo.setData(AtListActivity.this.gGj);
                        AtListActivity.this.gGo.notifyDataSetInvalidated();
                        AtListActivity.this.Hw.setSelection(0);
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
            this.gGk.h(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.Hw;
    }
}
