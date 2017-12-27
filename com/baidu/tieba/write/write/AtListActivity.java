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
    private NoNetworkView dhH;
    private LinearLayout eKV;
    private Button eKW;
    private View eLa;
    private View eLb;
    private ImageView eLd;
    private AtSelectFriendList hSd;
    private TextView hSk;
    private TextView hSl;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mNoDataView;
    protected ArrayList<MetaData> hSc = new ArrayList<>();
    private EditText rE = null;
    private TextView doJ = null;
    private BdListView avk = null;
    private final Handler mHandler = new Handler();
    private a hSe = null;
    private b hSf = null;
    private com.baidu.tieba.write.model.b hSg = null;
    private com.baidu.tieba.write.write.a hSh = null;
    private String hSi = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hSj = null;
    private final int hSm = 5;
    private boolean hSn = true;
    private final Runnable hSo = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.va(k.a(AtListActivity.this.rE.getText(), ""));
        }
    };
    private NoNetworkView.a hpP = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (z) {
                AtListActivity.this.va(null);
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
        va(null);
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
        this.dhH.onChangeSkinType(getPageContext(), i);
        this.hSh.notifyDataSetChanged();
        aj.getColor(d.C0108d.common_color_10221);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.s(this.eKW, d.f.post_button_bg);
        aj.e(this.eKW, d.C0108d.cp_cont_i, 3);
        aj.a(this.eLd, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.r(this.hSl, d.C0108d.navi_back_text_color);
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
    public void zg(int i) {
        if (i == 2) {
            this.avk.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.no_chat_friends));
            this.eKV.setVisibility(8);
        } else if (i == 1) {
            this.avk.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.no_search_friends));
            this.eKV.setVisibility(8);
        } else if (i == 0) {
            this.avk.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hSn) {
                this.eKV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hSh.getItem(i);
        if (item != null) {
            if (this.hSn) {
                if (this.hSe == null && this.hSf == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hSd.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hSh.notifyDataSetChanged();
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
        if (this.hSe != null) {
            this.hSe.cancel();
        }
        if (this.hSf != null) {
            this.hSf.cancel();
        }
        this.mHandler.removeCallbacks(this.hSo);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.s(getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_chat_friends), null, true);
        this.hSj = findViewById(d.g.at_candidate_border);
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
        auI();
        this.dhH = (NoNetworkView) findViewById(d.g.view_no_network);
        this.dhH.a(this.hpP);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.avk = (BdListView) findViewById(d.g.list);
        this.hSh = new com.baidu.tieba.write.write.a(this, this.hSn);
        this.hSh.a(this);
        this.hSh.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hSd.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.avk.setAdapter((ListAdapter) this.hSh);
        this.avk.setOnItemClickListener(this);
        this.avk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.eKV = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eKW = (Button) this.mParent.findViewById(d.g.button_send);
        this.eKW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hSd.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qP(0);
        this.hSd = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hSd.setMaxCount(5);
        this.hSd.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.avk.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aLu();
    }

    private void auI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hSl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eLa != null && AtListActivity.this.eLa.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    AtListActivity.this.eLa.setVisibility(8);
                    AtListActivity.this.hSk.setVisibility(0);
                    AtListActivity.this.eLb.setVisibility(0);
                    AtListActivity.this.rE.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.finish();
            }
        });
        this.hSk = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.eLb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hSk.setVisibility(8);
                AtListActivity.this.eLb.setVisibility(8);
                AtListActivity.this.eLa.setVisibility(0);
                AtListActivity.this.rE.requestFocus();
            }
        });
        this.eLd = (ImageView) this.eLb.findViewById(d.g.new_friend_search);
        this.eLa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eLa.setVisibility(8);
        this.rE = (EditText) this.eLa.findViewById(d.g.search_bar_edit);
        this.rE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hSi)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hSo);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hSo, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.doJ.setVisibility(0);
                    } else {
                        AtListActivity.this.doJ.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hSi = k.a(charSequence, null);
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
        this.doJ = (TextView) findViewById(d.g.search_bar_delete_button);
        this.doJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.rE.getText().clear();
            }
        });
    }

    private void aLu() {
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
                AtListActivity.this.avk.requestFocus();
            }
        });
        this.avk.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(String str) {
        if (!isFinishing()) {
            this.hSh.setData(null);
            if (this.hSe != null) {
                this.hSe.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hSg.bMD() != null) {
                    ArrayList<MetaData> bMs = this.hSg.bMD().bMs();
                    Iterator<MetaData> it = bMs.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bMs != null && !bMs.isEmpty()) {
                        zg(0);
                    } else {
                        zg(1);
                    }
                    this.hSh.setData(bMs);
                } else {
                    this.hSh.setData(null);
                    if (this.hSf == null) {
                        this.hSf = new b();
                        this.hSf.setPriority(3);
                        this.hSf.execute("");
                    }
                }
            } else {
                this.hSe = new a();
                this.hSe.setPriority(2);
                this.hSe.execute(str);
                if (this.hSf == null && this.hSg.bMD() == null) {
                    this.hSf = new b();
                    this.hSf.setPriority(3);
                    this.hSf.execute("");
                }
            }
            this.hSh.notifyDataSetInvalidated();
            this.avk.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hSg = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hSn = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.hSn = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hSd.f(metaData);
            qP(this.hSd.getItemLength());
            aLv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hSd.h(metaData);
            qP(this.hSd.getItemLength());
            aLv();
        }
    }

    private void aLv() {
        if (this.hSd.getItemLength() > 0) {
            this.eKW.setEnabled(true);
        } else {
            this.eKW.setEnabled(false);
        }
    }

    private void qP(int i) {
        this.eKW.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hSq;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hSq = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hSe = null;
            this.hSq = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hSq = strArr[0];
            this.mNetwork = new x();
            if (this.hSq != null && this.hSq.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.hSq);
                String BP = this.mNetwork.BP();
                if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b bMD = AtListActivity.this.hSg.bMD();
                    if (bMD != null) {
                        cVar.e(BP, bMD.bMt());
                        return cVar;
                    }
                    cVar.e(BP, null);
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
            AtListActivity.this.hSe = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Cn().Dl().isRequestSuccess() && this.hSq != null && k.a(AtListActivity.this.rE.getText(), "").equals(this.hSq)) {
                if (cVar == null || cVar.bMu().isEmpty()) {
                    AtListActivity.this.zg(1);
                } else {
                    AtListActivity.this.zg(0);
                }
                AtListActivity.this.hSg.a(cVar);
                AtListActivity.this.hSh.setData(cVar.bMu());
                AtListActivity.this.hSh.notifyDataSetInvalidated();
                AtListActivity.this.avk.setSelection(0);
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
            AtListActivity.this.hSf = null;
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
            String BP = this.mNetwork.BP();
            if (!this.mNetwork.Cn().Dl().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uL(BP);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hSf = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eKV != null && AtListActivity.this.eKV.getVisibility() == 0) {
                AtListActivity.this.hSj.setVisibility(0);
            }
            if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                AtListActivity.this.hSg.a(bVar);
                if (AtListActivity.this.hSh != null) {
                    if (k.a(AtListActivity.this.rE.getText(), "").length() != 0) {
                        if (AtListActivity.this.hSg.bME() != null) {
                            if (bVar != null && bVar.bMt() != null && !bVar.bMt().isEmpty()) {
                                AtListActivity.this.zg(2);
                            }
                            AtListActivity.this.hSg.bME().k(bVar.bMt());
                            AtListActivity.this.hSh.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bMs() == null || !bVar.bMs().isEmpty()) {
                            AtListActivity.this.zg(0);
                        } else {
                            AtListActivity.this.zg(2);
                        }
                        AtListActivity.this.hSc = bVar.bMs();
                        AtListActivity.this.hSh.setData(AtListActivity.this.hSc);
                        AtListActivity.this.hSh.notifyDataSetInvalidated();
                        AtListActivity.this.avk.setSelection(0);
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
            this.hSd.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.avk == null) {
            return null;
        }
        return this.avk.getPreLoadHandle();
    }
}
