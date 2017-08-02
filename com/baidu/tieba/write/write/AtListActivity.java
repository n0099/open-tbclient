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
    private NoNetworkView bDI;
    private LinearLayout dBn;
    private Button dBo;
    private View dBs;
    private View dBt;
    private ImageView dBv;
    private AtSelectFriendList gDJ;
    private TextView gDQ;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected ArrayList<MetaData> gDI = new ArrayList<>();
    private EditText dxI = null;
    private TextView cdB = null;
    private BdListView Ib = null;
    private final Handler mHandler = new Handler();
    private a gDK = null;
    private b gDL = null;
    private com.baidu.tieba.write.model.b gDM = null;
    private com.baidu.tieba.write.write.a gDN = null;
    private String gDO = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gDP = null;
    private final int gDR = 5;
    private boolean gDS = true;
    private final Runnable gDT = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.tb(com.baidu.adp.lib.util.j.a(AtListActivity.this.dxI.getText(), ""));
        }
    };
    private NoNetworkView.a gnv = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.tb(null);
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
        tb(null);
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
        this.bDI.onChangeSkinType(getPageContext(), i);
        this.gDN.notifyDataSetChanged();
        ai.getColor(d.e.common_color_10221);
        ai.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        ai.j(this.dBo, d.g.post_button_bg);
        ai.c(this.dBo, d.e.cp_cont_i, 3);
        ai.b(this.dBv, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void uA(int i) {
        if (i == 2) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.di(d.l.no_chat_friends));
            this.dBn.setVisibility(8);
        } else if (i == 1) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.di(d.l.no_search_friends));
            this.dBn.setVisibility(8);
        } else if (i == 0) {
            this.Ib.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gDS) {
                this.dBn.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gDN.getItem(i);
        if (item != null) {
            if (this.gDS) {
                if (this.gDK == null && this.gDL == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.gDJ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gDN.notifyDataSetChanged();
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
            k.b(getPageContext().getPageActivity(), this.dxI);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gDK != null) {
            this.gDK.cancel();
        }
        if (this.gDL != null) {
            this.gDL.cancel();
        }
        this.mHandler.removeCallbacks(this.gDT);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(getActivity(), d.f.ds320)), NoDataViewFactory.d.di(d.l.no_chat_friends), null, true);
        this.gDP = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dxI);
                    return false;
                }
                return false;
            }
        });
        VR();
        this.bDI = (NoNetworkView) findViewById(d.h.view_no_network);
        this.bDI.a(this.gnv);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.Ib = (BdListView) findViewById(d.h.list);
        this.gDN = new com.baidu.tieba.write.write.a(this, this.gDS);
        this.gDN.a(this);
        this.gDN.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gDJ.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Ib.setAdapter((ListAdapter) this.gDN);
        this.Ib.setOnItemClickListener(this);
        this.Ib.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dxI);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dxI.getParent() != null) {
            ((View) this.dxI.getParent()).setFocusable(true);
            ((View) this.dxI.getParent()).setFocusableInTouchMode(true);
        }
        this.dBn = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dBo = (Button) this.mParent.findViewById(d.h.button_send);
        this.dBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gDJ.getDataList());
                intent.putExtras(bundle);
                k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dxI);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        mL(0);
        this.gDJ = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gDJ.setMaxCount(5);
        this.gDJ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Ib.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        ayS();
    }

    private void VR() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dBs != null && AtListActivity.this.dBs.getVisibility() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dxI);
                    AtListActivity.this.dBs.setVisibility(8);
                    AtListActivity.this.gDQ.setVisibility(0);
                    AtListActivity.this.dBt.setVisibility(0);
                    AtListActivity.this.dxI.getText().clear();
                    return;
                }
                k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dxI);
                AtListActivity.this.finish();
            }
        });
        this.gDQ = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dBt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gDQ.setVisibility(8);
                AtListActivity.this.dBt.setVisibility(8);
                AtListActivity.this.dBs.setVisibility(0);
                AtListActivity.this.dxI.requestFocus();
            }
        });
        this.dBv = (ImageView) this.dBt.findViewById(d.h.new_friend_search);
        this.dBs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dBs.setVisibility(8);
        this.dxI = (EditText) this.dBs.findViewById(d.h.search_bar_edit);
        this.dxI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.j.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gDO)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gDT);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gDT, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cdB.setVisibility(0);
                    } else {
                        AtListActivity.this.cdB.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gDO = com.baidu.adp.lib.util.j.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dxI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    k.c(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cdB = (TextView) findViewById(d.h.search_bar_delete_button);
        this.cdB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dxI.getText().clear();
            }
        });
    }

    private void ayS() {
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
                AtListActivity.this.Ib.requestFocus();
            }
        });
        this.Ib.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(String str) {
        if (!isFinishing()) {
            this.gDN.setData(null);
            if (this.gDK != null) {
                this.gDK.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gDM.byx() != null) {
                    ArrayList<MetaData> byr = this.gDM.byx().byr();
                    Iterator<MetaData> it = byr.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (byr != null && !byr.isEmpty()) {
                        uA(0);
                    } else {
                        uA(1);
                    }
                    this.gDN.setData(byr);
                } else {
                    this.gDN.setData(null);
                    if (this.gDL == null) {
                        this.gDL = new b();
                        this.gDL.setPriority(3);
                        this.gDL.execute("");
                    }
                }
            } else {
                this.gDK = new a();
                this.gDK.setPriority(2);
                this.gDK.execute(str);
                if (this.gDL == null && this.gDM.byx() == null) {
                    this.gDL = new b();
                    this.gDL.setPriority(3);
                    this.gDL.execute("");
                }
            }
            this.gDN.notifyDataSetInvalidated();
            this.Ib.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gDM = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gDS = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gDS = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.gDJ.f(metaData);
            mL(this.gDJ.getItemLength());
            ayT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.gDJ.h(metaData);
            mL(this.gDJ.getItemLength());
            ayT();
        }
    }

    private void ayT() {
        if (this.gDJ.getItemLength() > 0) {
            this.dBo.setEnabled(true);
        } else {
            this.dBo.setEnabled(false);
        }
    }

    private void mL(int i) {
        this.dBo.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gDV;
        private w mNetwork;

        private a() {
            this.mNetwork = null;
            this.gDV = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gDK = null;
            this.gDV = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gDV = strArr[0];
            this.mNetwork = new w();
            if (this.gDV != null && this.gDV.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gDV);
                String uE = this.mNetwork.uE();
                if (this.mNetwork.vb().vY().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b byx = AtListActivity.this.gDM.byx();
                    if (byx != null) {
                        dVar.e(uE, byx.bys());
                        return dVar;
                    }
                    dVar.e(uE, null);
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
            AtListActivity.this.gDK = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vb().vY().isRequestSuccess() && this.gDV != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dxI.getText(), "").equals(this.gDV)) {
                if (dVar == null || dVar.byt().isEmpty()) {
                    AtListActivity.this.uA(1);
                } else {
                    AtListActivity.this.uA(0);
                }
                AtListActivity.this.gDM.a(dVar);
                AtListActivity.this.gDN.setData(dVar.byt());
                AtListActivity.this.gDN.notifyDataSetInvalidated();
                AtListActivity.this.Ib.setSelection(0);
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
                this.mNetwork.fp();
            }
            AtListActivity.this.gDL = null;
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
            String uE = this.mNetwork.uE();
            if (!this.mNetwork.vb().vY().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.sQ(uE);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gDL = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dBn != null && AtListActivity.this.dBn.getVisibility() == 0) {
                AtListActivity.this.gDP.setVisibility(0);
            }
            if (this.mNetwork.vb().vY().isRequestSuccess()) {
                AtListActivity.this.gDM.a(bVar);
                if (AtListActivity.this.gDN != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dxI.getText(), "").length() != 0) {
                        if (AtListActivity.this.gDM.byy() != null) {
                            if (bVar != null && bVar.bys() != null && !bVar.bys().isEmpty()) {
                                AtListActivity.this.uA(2);
                            }
                            AtListActivity.this.gDM.byy().k(bVar.bys());
                            AtListActivity.this.gDN.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.byr() == null || !bVar.byr().isEmpty()) {
                            AtListActivity.this.uA(0);
                        } else {
                            AtListActivity.this.uA(2);
                        }
                        AtListActivity.this.gDI = bVar.byr();
                        AtListActivity.this.gDN.setData(AtListActivity.this.gDI);
                        AtListActivity.this.gDN.notifyDataSetInvalidated();
                        AtListActivity.this.Ib.setSelection(0);
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
            this.gDJ.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.Ib;
    }
}
