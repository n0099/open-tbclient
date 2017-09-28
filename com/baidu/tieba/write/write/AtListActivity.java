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
    private NoNetworkView ccR;
    private LinearLayout dIp;
    private Button dIq;
    private View dIu;
    private View dIv;
    private ImageView dIx;
    private AtSelectFriendList gLg;
    private TextView gLn;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    protected ArrayList<MetaData> gLf = new ArrayList<>();
    private EditText dEK = null;
    private TextView cjI = null;
    private BdListView HN = null;
    private final Handler mHandler = new Handler();
    private a gLh = null;
    private b gLi = null;
    private com.baidu.tieba.write.model.b gLj = null;
    private com.baidu.tieba.write.write.a gLk = null;
    private String gLl = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gLm = null;
    private final int gLo = 5;
    private boolean gLp = true;
    private final Runnable gLq = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.to(k.a(AtListActivity.this.dEK.getText(), ""));
        }
    };
    private NoNetworkView.a gnK = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.to(null);
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
        to(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ccR.onChangeSkinType(getPageContext(), i);
        this.gLk.notifyDataSetChanged();
        aj.getColor(d.e.common_color_10221);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        aj.j(this.dIq, d.g.post_button_bg);
        aj.c(this.dIq, d.e.cp_cont_i, 3);
        aj.a(this.dIx, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void vi(int i) {
        if (i == 2) {
            this.HN.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.l.no_chat_friends));
            this.dIp.setVisibility(8);
        } else if (i == 1) {
            this.HN.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dq(d.l.no_search_friends));
            this.dIp.setVisibility(8);
        } else if (i == 0) {
            this.HN.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gLp) {
                this.dIp.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gLk.getItem(i);
        if (item != null) {
            if (this.gLp) {
                if (this.gLh == null && this.gLi == null) {
                    if (item.isChecked()) {
                        g(item);
                    } else if (5 <= this.gLg.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        f(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gLk.notifyDataSetChanged();
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
            l.a(getPageContext().getPageActivity(), this.dEK);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gLh != null) {
            this.gLh.cancel();
        }
        if (this.gLi != null) {
            this.gLi.cancel();
        }
        this.mHandler.removeCallbacks(this.gLq);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.f.ds320)), NoDataViewFactory.d.dq(d.l.no_chat_friends), null, true);
        this.gLm = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEK);
                    return false;
                }
                return false;
            }
        });
        aiB();
        this.ccR = (NoNetworkView) findViewById(d.h.view_no_network);
        this.ccR.a(this.gnK);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.HN = (BdListView) findViewById(d.h.list);
        this.gLk = new com.baidu.tieba.write.write.a(this, this.gLp);
        this.gLk.a(this);
        this.gLk.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.g((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gLg.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.f((MetaData) obj);
                    }
                }
            }
        });
        this.HN.setAdapter((ListAdapter) this.gLk);
        this.HN.setOnItemClickListener(this);
        this.HN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEK);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dEK.getParent() != null) {
            ((View) this.dEK.getParent()).setFocusable(true);
            ((View) this.dEK.getParent()).setFocusableInTouchMode(true);
        }
        this.dIp = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dIq = (Button) this.mParent.findViewById(d.h.button_send);
        this.dIq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gLg.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEK);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nl(0);
        this.gLg = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gLg.setMaxCount(5);
        this.gLg.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.HN.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.g((MetaData) obj);
                    }
                }
            }
        });
        aAq();
    }

    private void aiB() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dIu != null && AtListActivity.this.dIu.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEK);
                    AtListActivity.this.dIu.setVisibility(8);
                    AtListActivity.this.gLn.setVisibility(0);
                    AtListActivity.this.dIv.setVisibility(0);
                    AtListActivity.this.dEK.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dEK);
                AtListActivity.this.finish();
            }
        });
        this.gLn = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dIv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gLn.setVisibility(8);
                AtListActivity.this.dIv.setVisibility(8);
                AtListActivity.this.dIu.setVisibility(0);
                AtListActivity.this.dEK.requestFocus();
            }
        });
        this.dIx = (ImageView) this.dIv.findViewById(d.h.new_friend_search);
        this.dIu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dIu.setVisibility(8);
        this.dEK = (EditText) this.dIu.findViewById(d.h.search_bar_edit);
        this.dEK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gLl)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gLq);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gLq, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cjI.setVisibility(0);
                    } else {
                        AtListActivity.this.cjI.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gLl = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dEK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cjI = (TextView) findViewById(d.h.search_bar_delete_button);
        this.cjI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dEK.getText().clear();
            }
        });
    }

    private void aAq() {
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
                AtListActivity.this.HN.requestFocus();
            }
        });
        this.HN.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(String str) {
        if (!isFinishing()) {
            this.gLk.setData(null);
            if (this.gLh != null) {
                this.gLh.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gLj.bzV() != null) {
                    ArrayList<MetaData> bzQ = this.gLj.bzV().bzQ();
                    Iterator<MetaData> it = bzQ.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bzQ != null && !bzQ.isEmpty()) {
                        vi(0);
                    } else {
                        vi(1);
                    }
                    this.gLk.setData(bzQ);
                } else {
                    this.gLk.setData(null);
                    if (this.gLi == null) {
                        this.gLi = new b();
                        this.gLi.setPriority(3);
                        this.gLi.execute("");
                    }
                }
            } else {
                this.gLh = new a();
                this.gLh.setPriority(2);
                this.gLh.execute(str);
                if (this.gLi == null && this.gLj.bzV() == null) {
                    this.gLi = new b();
                    this.gLi.setPriority(3);
                    this.gLi.execute("");
                }
            }
            this.gLk.notifyDataSetInvalidated();
            this.HN.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gLj = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gLp = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gLp = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.gLg.h(metaData);
            nl(this.gLg.getItemLength());
            aAr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(MetaData metaData) {
        if (metaData != null) {
            this.gLg.j(metaData);
            nl(this.gLg.getItemLength());
            aAr();
        }
    }

    private void aAr() {
        if (this.gLg.getItemLength() > 0) {
            this.dIq.setEnabled(true);
        } else {
            this.dIq.setEnabled(false);
        }
    }

    private void nl(int i) {
        this.dIq.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gLs;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.gLs = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gLh = null;
            this.gLs = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gLs = strArr[0];
            this.mNetwork = new x();
            if (this.gLs != null && this.gLs.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gLs);
                String up = this.mNetwork.up();
                if (this.mNetwork.uN().vK().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b bzV = AtListActivity.this.gLj.bzV();
                    if (bzV != null) {
                        dVar.e(up, bzV.bzR());
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
            AtListActivity.this.gLh = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uN().vK().isRequestSuccess() && this.gLs != null && k.a(AtListActivity.this.dEK.getText(), "").equals(this.gLs)) {
                if (dVar == null || dVar.bzS().isEmpty()) {
                    AtListActivity.this.vi(1);
                } else {
                    AtListActivity.this.vi(0);
                }
                AtListActivity.this.gLj.a(dVar);
                AtListActivity.this.gLk.setData(dVar.bzS());
                AtListActivity.this.gLk.notifyDataSetInvalidated();
                AtListActivity.this.HN.setSelection(0);
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
            AtListActivity.this.gLi = null;
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
            if (!this.mNetwork.uN().vK().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.td(up);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gLi = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dIp != null && AtListActivity.this.dIp.getVisibility() == 0) {
                AtListActivity.this.gLm.setVisibility(0);
            }
            if (this.mNetwork.uN().vK().isRequestSuccess()) {
                AtListActivity.this.gLj.a(bVar);
                if (AtListActivity.this.gLk != null) {
                    if (k.a(AtListActivity.this.dEK.getText(), "").length() != 0) {
                        if (AtListActivity.this.gLj.bzW() != null) {
                            if (bVar != null && bVar.bzR() != null && !bVar.bzR().isEmpty()) {
                                AtListActivity.this.vi(2);
                            }
                            AtListActivity.this.gLj.bzW().l(bVar.bzR());
                            AtListActivity.this.gLk.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bzQ() == null || !bVar.bzQ().isEmpty()) {
                            AtListActivity.this.vi(0);
                        } else {
                            AtListActivity.this.vi(2);
                        }
                        AtListActivity.this.gLf = bVar.bzQ();
                        AtListActivity.this.gLk.setData(AtListActivity.this.gLf);
                        AtListActivity.this.gLk.notifyDataSetInvalidated();
                        AtListActivity.this.HN.setSelection(0);
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
            this.gLg.i(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.HN;
    }
}
