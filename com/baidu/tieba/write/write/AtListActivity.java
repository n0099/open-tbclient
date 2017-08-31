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
    private NoNetworkView bIw;
    private LinearLayout dLf;
    private Button dLg;
    private View dLk;
    private View dLl;
    private ImageView dLn;
    private AtSelectFriendList gFr;
    private TextView gFy;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected ArrayList<MetaData> gFq = new ArrayList<>();
    private EditText dHA = null;
    private TextView cjc = null;
    private BdListView Hw = null;
    private final Handler mHandler = new Handler();
    private a gFs = null;
    private b gFt = null;
    private com.baidu.tieba.write.model.b gFu = null;
    private com.baidu.tieba.write.write.a gFv = null;
    private String gFw = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gFx = null;
    private final int gFz = 5;
    private boolean gFA = true;
    private final Runnable gFB = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.th(com.baidu.adp.lib.util.j.a(AtListActivity.this.dHA.getText(), ""));
        }
    };
    private NoNetworkView.a gpa = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.th(null);
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
        th(null);
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
        this.bIw.onChangeSkinType(getPageContext(), i);
        this.gFv.notifyDataSetChanged();
        aj.getColor(d.e.common_color_10221);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        aj.j(this.dLg, d.g.post_button_bg);
        aj.c(this.dLg, d.e.cp_cont_i, 3);
        aj.a(this.dLn, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void uK(int i) {
        if (i == 2) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dl(d.l.no_chat_friends));
            this.dLf.setVisibility(8);
        } else if (i == 1) {
            this.Hw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dl(d.l.no_search_friends));
            this.dLf.setVisibility(8);
        } else if (i == 0) {
            this.Hw.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gFA) {
                this.dLf.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gFv.getItem(i);
        if (item != null) {
            if (this.gFA) {
                if (this.gFs == null && this.gFt == null) {
                    if (item.isChecked()) {
                        f(item);
                    } else if (5 <= this.gFr.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        e(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gFv.notifyDataSetChanged();
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
            k.a(getPageContext().getPageActivity(), this.dHA);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gFs != null) {
            this.gFs.cancel();
        }
        if (this.gFt != null) {
            this.gFt.cancel();
        }
        this.mHandler.removeCallbacks(this.gFB);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(getActivity(), d.f.ds320)), NoDataViewFactory.d.dl(d.l.no_chat_friends), null, true);
        this.gFx = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dHA);
                    return false;
                }
                return false;
            }
        });
        Xs();
        this.bIw = (NoNetworkView) findViewById(d.h.view_no_network);
        this.bIw.a(this.gpa);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.Hw = (BdListView) findViewById(d.h.list);
        this.gFv = new com.baidu.tieba.write.write.a(this, this.gFA);
        this.gFv.a(this);
        this.gFv.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.f((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gFr.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        this.Hw.setAdapter((ListAdapter) this.gFv);
        this.Hw.setOnItemClickListener(this);
        this.Hw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dHA);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dHA.getParent() != null) {
            ((View) this.dHA.getParent()).setFocusable(true);
            ((View) this.dHA.getParent()).setFocusableInTouchMode(true);
        }
        this.dLf = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dLg = (Button) this.mParent.findViewById(d.h.button_send);
        this.dLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gFr.getDataList());
                intent.putExtras(bundle);
                k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dHA);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        nn(0);
        this.gFr = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gFr.setMaxCount(5);
        this.gFr.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
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
        aBu();
    }

    private void Xs() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dLk != null && AtListActivity.this.dLk.getVisibility() == 0) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dHA);
                    AtListActivity.this.dLk.setVisibility(8);
                    AtListActivity.this.gFy.setVisibility(0);
                    AtListActivity.this.dLl.setVisibility(0);
                    AtListActivity.this.dHA.getText().clear();
                    return;
                }
                k.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dHA);
                AtListActivity.this.finish();
            }
        });
        this.gFy = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dLl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gFy.setVisibility(8);
                AtListActivity.this.dLl.setVisibility(8);
                AtListActivity.this.dLk.setVisibility(0);
                AtListActivity.this.dHA.requestFocus();
            }
        });
        this.dLn = (ImageView) this.dLl.findViewById(d.h.new_friend_search);
        this.dLk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dLk.setVisibility(8);
        this.dHA = (EditText) this.dLk.findViewById(d.h.search_bar_edit);
        this.dHA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.j.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gFw)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gFB);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gFB, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cjc.setVisibility(0);
                    } else {
                        AtListActivity.this.cjc.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gFw = com.baidu.adp.lib.util.j.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dHA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    k.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cjc = (TextView) findViewById(d.h.search_bar_delete_button);
        this.cjc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dHA.getText().clear();
            }
        });
    }

    private void aBu() {
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
    public void th(String str) {
        if (!isFinishing()) {
            this.gFv.setData(null);
            if (this.gFs != null) {
                this.gFs.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gFu.byt() != null) {
                    ArrayList<MetaData> byo = this.gFu.byt().byo();
                    Iterator<MetaData> it = byo.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (byo != null && !byo.isEmpty()) {
                        uK(0);
                    } else {
                        uK(1);
                    }
                    this.gFv.setData(byo);
                } else {
                    this.gFv.setData(null);
                    if (this.gFt == null) {
                        this.gFt = new b();
                        this.gFt.setPriority(3);
                        this.gFt.execute("");
                    }
                }
            } else {
                this.gFs = new a();
                this.gFs.setPriority(2);
                this.gFs.execute(str);
                if (this.gFt == null && this.gFu.byt() == null) {
                    this.gFt = new b();
                    this.gFt.setPriority(3);
                    this.gFt.execute("");
                }
            }
            this.gFv.notifyDataSetInvalidated();
            this.Hw.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gFu = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gFA = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gFA = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.gFr.g(metaData);
            nn(this.gFr.getItemLength());
            aBv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(MetaData metaData) {
        if (metaData != null) {
            this.gFr.i(metaData);
            nn(this.gFr.getItemLength());
            aBv();
        }
    }

    private void aBv() {
        if (this.gFr.getItemLength() > 0) {
            this.dLg.setEnabled(true);
        } else {
            this.dLg.setEnabled(false);
        }
    }

    private void nn(int i) {
        this.dLg.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gFD;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.gFD = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gFs = null;
            this.gFD = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gFD = strArr[0];
            this.mNetwork = new x();
            if (this.gFD != null && this.gFD.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gFD);
                String uM = this.mNetwork.uM();
                if (this.mNetwork.vj().wg().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b byt = AtListActivity.this.gFu.byt();
                    if (byt != null) {
                        dVar.e(uM, byt.byp());
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
            AtListActivity.this.gFs = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vj().wg().isRequestSuccess() && this.gFD != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dHA.getText(), "").equals(this.gFD)) {
                if (dVar == null || dVar.byq().isEmpty()) {
                    AtListActivity.this.uK(1);
                } else {
                    AtListActivity.this.uK(0);
                }
                AtListActivity.this.gFu.a(dVar);
                AtListActivity.this.gFv.setData(dVar.byq());
                AtListActivity.this.gFv.notifyDataSetInvalidated();
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
            AtListActivity.this.gFt = null;
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
            bVar.sX(uM);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gFt = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dLf != null && AtListActivity.this.dLf.getVisibility() == 0) {
                AtListActivity.this.gFx.setVisibility(0);
            }
            if (this.mNetwork.vj().wg().isRequestSuccess()) {
                AtListActivity.this.gFu.a(bVar);
                if (AtListActivity.this.gFv != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dHA.getText(), "").length() != 0) {
                        if (AtListActivity.this.gFu.byu() != null) {
                            if (bVar != null && bVar.byp() != null && !bVar.byp().isEmpty()) {
                                AtListActivity.this.uK(2);
                            }
                            AtListActivity.this.gFu.byu().l(bVar.byp());
                            AtListActivity.this.gFv.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.byo() == null || !bVar.byo().isEmpty()) {
                            AtListActivity.this.uK(0);
                        } else {
                            AtListActivity.this.uK(2);
                        }
                        AtListActivity.this.gFq = bVar.byo();
                        AtListActivity.this.gFv.setData(AtListActivity.this.gFq);
                        AtListActivity.this.gFv.notifyDataSetInvalidated();
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
            this.gFr.h(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.Hw;
    }
}
