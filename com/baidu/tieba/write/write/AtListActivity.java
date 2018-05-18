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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView cIH;
    private View emA;
    private View emB;
    private ImageView emD;
    private LinearLayout emv;
    private Button emw;
    private AtSelectFriendList hgA;
    private TextView hgH;
    private TextView hgI;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hgz = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bct = null;
    private BdListView FH = null;
    private final Handler mHandler = new Handler();
    private a hgB = null;
    private b hgC = null;
    private com.baidu.tieba.write.model.b hgD = null;
    private com.baidu.tieba.write.write.a hgE = null;
    private String hgF = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hgG = null;
    private final int hgJ = 5;
    private boolean hgK = true;
    private boolean hgL = false;
    private final Runnable hgM = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uW(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a gEO = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.uW(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.at_list_activity);
        initData(bundle);
        initUI();
        uW(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cIH.onChangeSkinType(getPageContext(), i);
        this.hgE.notifyDataSetChanged();
        ak.getColor(d.C0126d.common_color_10221);
        ak.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        ak.i(this.emw, d.f.post_button_bg);
        ak.c(this.emw, d.C0126d.cp_cont_i, 3);
        ak.a(this.emD, d.f.icon_search_bg_s, d.f.icon_search_bg);
        ak.h(this.hgI, d.C0126d.navi_back_text_color);
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
    public void vd(int i) {
        if (i == 2) {
            this.FH.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.no_chat_friends));
            this.emv.setVisibility(8);
        } else if (i == 1) {
            this.FH.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.no_search_friends));
            this.emv.setVisibility(8);
        } else if (i == 0) {
            this.FH.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hgK) {
                this.emv.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        super.onItemClick(adapterView, view2, i, j);
        MetaData item = this.hgE.getItem(i);
        if (item != null) {
            if (this.hgK) {
                if (this.hgB == null && this.hgC == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hgA.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hgE.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.hgL) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new al("c12930").f(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(IntentConfig.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hgB != null) {
            this.hgB.cancel();
        }
        if (this.hgC != null) {
            this.hgC.cancel();
        }
        this.mHandler.removeCallbacks(this.hgM);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.no_chat_friends), null, true);
        this.hgG = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        ard();
        this.cIH = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cIH.a(this.gEO);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.FH = (BdListView) findViewById(d.g.list);
        this.hgE = new com.baidu.tieba.write.write.a(this, this.hgK);
        this.hgE.a(this);
        this.hgE.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hgA.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.FH.setAdapter((ListAdapter) this.hgE);
        this.FH.setOnItemClickListener(this);
        this.FH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.emv = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.emw = (Button) this.mParent.findViewById(d.g.button_send);
        this.emw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hgA.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        ob(0);
        this.hgA = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hgA.setMaxCount(5);
        this.hgA.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view2, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.FH.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aHZ();
    }

    private void ard() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hgI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.k.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AtListActivity.this.emA != null && AtListActivity.this.emA.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.emA.setVisibility(8);
                    AtListActivity.this.hgH.setVisibility(0);
                    AtListActivity.this.emB.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hgH = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.select_friend));
        this.emB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AtListActivity.this.hgH.setVisibility(8);
                AtListActivity.this.emB.setVisibility(8);
                AtListActivity.this.emA.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.emD = (ImageView) this.emB.findViewById(d.g.new_friend_search);
        this.emA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.emA.setVisibility(8);
        this.mEditText = (EditText) this.emA.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hgF)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hgM);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hgM, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bct.setVisibility(0);
                    } else {
                        AtListActivity.this.bct.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hgF = com.baidu.adp.lib.util.k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view2);
                } else {
                    l.c(AtListActivity.this.getPageContext().getPageActivity(), view2);
                }
            }
        });
        this.bct = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aHZ() {
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
            public void onClick(View view2) {
                AtListActivity.this.FH.requestFocus();
            }
        });
        this.FH.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW(String str) {
        if (!isFinishing()) {
            this.hgE.setData(null);
            if (this.hgB != null) {
                this.hgB.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hgD.bCh() != null) {
                    ArrayList<MetaData> bBX = this.hgD.bCh().bBX();
                    Iterator<MetaData> it = bBX.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bBX != null && !bBX.isEmpty()) {
                        vd(0);
                    } else {
                        vd(1);
                    }
                    this.hgE.setData(bBX);
                } else {
                    this.hgE.setData(null);
                    if (this.hgC == null) {
                        this.hgC = new b();
                        this.hgC.setPriority(3);
                        this.hgC.execute("");
                    }
                }
            } else {
                this.hgB = new a();
                this.hgB.setPriority(2);
                this.hgB.execute(str);
                if (this.hgC == null && this.hgD.bCh() == null) {
                    this.hgC = new b();
                    this.hgC.setPriority(3);
                    this.hgC.execute("");
                }
            }
            this.hgE.notifyDataSetInvalidated();
            this.FH.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hgD = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hgK = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hgL = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hgK = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hgL = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hgA.f(metaData);
            ob(this.hgA.getItemLength());
            aIa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hgA.h(metaData);
            ob(this.hgA.getItemLength());
            aIa();
        }
    }

    private void aIa() {
        if (this.hgA.getItemLength() > 0) {
            this.emw.setEnabled(true);
        } else {
            this.emw.setEnabled(false);
        }
    }

    private void ob(int i) {
        this.emw.setText(String.format(getPageContext().getString(d.k.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hgO;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hgO = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hgB = null;
            this.hgO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hgO = strArr[0];
            this.mNetwork = new x();
            if (this.hgO == null || this.hgO.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.n(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, this.hgO);
            if (AtListActivity.this.hgL) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String uK = this.mNetwork.uK();
            if (!this.mNetwork.vi().wi().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(uK, AtListActivity.this.hgD.bCh());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hgB = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vi().wi().isRequestSuccess() && this.hgO != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hgO)) {
                if (cVar == null || cVar.bBZ().isEmpty()) {
                    AtListActivity.this.vd(1);
                } else {
                    AtListActivity.this.vd(0);
                }
                AtListActivity.this.hgD.a(cVar);
                AtListActivity.this.hgE.setData(cVar.bBZ());
                AtListActivity.this.hgE.notifyDataSetInvalidated();
                AtListActivity.this.FH.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
                this.mNetwork.eW();
            }
            AtListActivity.this.hgC = null;
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
            if (AtListActivity.this.hgL) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String uK = this.mNetwork.uK();
            if (!this.mNetwork.vi().wi().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uN(uK);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hgC = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.emv != null && AtListActivity.this.emv.getVisibility() == 0) {
                AtListActivity.this.hgG.setVisibility(0);
            }
            if (this.mNetwork.vi().wi().isRequestSuccess()) {
                AtListActivity.this.hgD.a(bVar);
                if (AtListActivity.this.hgE != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hgD.bCi() != null) {
                            if (bVar != null && bVar.bBY() != null && !bVar.bBY().isEmpty()) {
                                AtListActivity.this.vd(2);
                            }
                            AtListActivity.this.hgD.bCi().o(bVar.bBY());
                            AtListActivity.this.hgE.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bBX() == null || !bVar.bBX().isEmpty()) {
                            AtListActivity.this.vd(0);
                        } else {
                            AtListActivity.this.vd(2);
                        }
                        AtListActivity.this.hgz = bVar.bBX();
                        AtListActivity.this.hgE.setData(AtListActivity.this.hgz);
                        AtListActivity.this.hgE.notifyDataSetInvalidated();
                        AtListActivity.this.FH.setSelection(0);
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
    public void a(View view2, MetaData metaData) {
        if (metaData != null) {
            this.hgA.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.FH == null) {
            return null;
        }
        return this.FH.getPreLoadHandle();
    }
}
