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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView cPM;
    private LinearLayout eBD;
    private Button eBE;
    private View eBI;
    private View eBJ;
    private ImageView eBL;
    private AtSelectFriendList hwE;
    private TextView hwL;
    private TextView hwM;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hwD = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bmc = null;
    private BdListView LS = null;
    private final Handler mHandler = new Handler();
    private a hwF = null;
    private b hwG = null;
    private com.baidu.tieba.write.model.b hwH = null;
    private com.baidu.tieba.write.write.a hwI = null;
    private String hwJ = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hwK = null;
    private final int hwN = 5;
    private boolean hwO = true;
    private boolean hwP = false;
    private final Runnable hwQ = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.vM(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a gUS = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (z) {
                AtListActivity.this.vM(null);
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
        vM(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cPM.onChangeSkinType(getPageContext(), i);
        this.hwI.notifyDataSetChanged();
        am.getColor(d.C0142d.common_color_10221);
        am.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        am.i(this.eBE, d.f.post_button_bg);
        am.c(this.eBE, d.C0142d.cp_cont_i, 3);
        am.a(this.eBL, d.f.icon_search_bg_s, d.f.icon_search_bg);
        am.h(this.hwM, d.C0142d.navi_back_text_color);
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
    public void vE(int i) {
        if (i == 2) {
            this.LS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.no_chat_friends));
            this.eBD.setVisibility(8);
        } else if (i == 1) {
            this.LS.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.no_search_friends));
            this.eBD.setVisibility(8);
        } else if (i == 0) {
            this.LS.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hwO) {
                this.eBD.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hwI.getItem(i);
        if (item != null) {
            if (this.hwO) {
                if (this.hwF == null && this.hwG == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hwE.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hwI.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.hwP) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new an("c12930").f(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.hwF != null) {
            this.hwF.cancel();
        }
        if (this.hwG != null) {
            this.hwG.cancel();
        }
        this.mHandler.removeCallbacks(this.hwQ);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), NoDataViewFactory.d.ds(d.k.no_chat_friends), null, true);
        this.hwK = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        arI();
        this.cPM = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cPM.a(this.gUS);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.LS = (BdListView) findViewById(d.g.list);
        this.hwI = new com.baidu.tieba.write.write.a(this, this.hwO);
        this.hwI.a(this);
        this.hwI.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hwE.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.LS.setAdapter((ListAdapter) this.hwI);
        this.LS.setOnItemClickListener(this);
        this.LS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
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
        this.eBD = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eBE = (Button) this.mParent.findViewById(d.g.button_send);
        this.eBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hwE.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        ou(0);
        this.hwE = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hwE.setMaxCount(5);
        this.hwE.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.LS.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aNA();
    }

    private void arI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hwM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.k.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eBI != null && AtListActivity.this.eBI.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.eBI.setVisibility(8);
                    AtListActivity.this.hwL.setVisibility(0);
                    AtListActivity.this.eBJ.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hwL = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.select_friend));
        this.eBJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hwL.setVisibility(8);
                AtListActivity.this.eBJ.setVisibility(8);
                AtListActivity.this.eBI.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.eBL = (ImageView) this.eBJ.findViewById(d.g.new_friend_search);
        this.eBI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.eBI.setVisibility(8);
        this.mEditText = (EditText) this.eBI.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hwJ)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hwQ);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hwQ, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bmc.setVisibility(0);
                    } else {
                        AtListActivity.this.bmc.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hwJ = com.baidu.adp.lib.util.k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.c(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bmc = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bmc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aNA() {
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
                AtListActivity.this.LS.requestFocus();
            }
        });
        this.LS.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM(String str) {
        if (!isFinishing()) {
            this.hwI.setData(null);
            if (this.hwF != null) {
                this.hwF.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hwH.bHN() != null) {
                    ArrayList<MetaData> bHE = this.hwH.bHN().bHE();
                    Iterator<MetaData> it = bHE.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bHE != null && !bHE.isEmpty()) {
                        vE(0);
                    } else {
                        vE(1);
                    }
                    this.hwI.setData(bHE);
                } else {
                    this.hwI.setData(null);
                    if (this.hwG == null) {
                        this.hwG = new b();
                        this.hwG.setPriority(3);
                        this.hwG.execute("");
                    }
                }
            } else {
                this.hwF = new a();
                this.hwF.setPriority(2);
                this.hwF.execute(str);
                if (this.hwG == null && this.hwH.bHN() == null) {
                    this.hwG = new b();
                    this.hwG.setPriority(3);
                    this.hwG.execute("");
                }
            }
            this.hwI.notifyDataSetInvalidated();
            this.LS.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hwH = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hwO = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hwP = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hwO = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hwP = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hwE.f(metaData);
            ou(this.hwE.getItemLength());
            aNB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hwE.h(metaData);
            ou(this.hwE.getItemLength());
            aNB();
        }
    }

    private void aNB() {
        if (this.hwE.getItemLength() > 0) {
            this.eBE.setEnabled(true);
        } else {
            this.eBE.setEnabled(false);
        }
    }

    private void ou(int i) {
        this.eBE.setText(String.format(getPageContext().getString(d.k.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hwS;
        private y mNetwork;

        private a() {
            this.mNetwork = null;
            this.hwS = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hwF = null;
            this.hwS = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hwS = strArr[0];
            this.mNetwork = new y();
            if (this.hwS == null || this.hwS.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.o("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.o("q", this.hwS);
            if (AtListActivity.this.hwP) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yz = this.mNetwork.yz();
            if (!this.mNetwork.yX().zY().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(yz, AtListActivity.this.hwH.bHN());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hwF = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.yX().zY().isRequestSuccess() && this.hwS != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hwS)) {
                if (cVar == null || cVar.bHG().isEmpty()) {
                    AtListActivity.this.vE(1);
                } else {
                    AtListActivity.this.vE(0);
                }
                AtListActivity.this.hwH.a(cVar);
                AtListActivity.this.hwI.setData(cVar.bHG());
                AtListActivity.this.hwI.notifyDataSetInvalidated();
                AtListActivity.this.LS.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private y mNetwork;

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
                this.mNetwork.hN();
            }
            AtListActivity.this.hwG = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new y();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hwP) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yz = this.mNetwork.yz();
            if (!this.mNetwork.yX().zY().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.vD(yz);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hwG = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eBD != null && AtListActivity.this.eBD.getVisibility() == 0) {
                AtListActivity.this.hwK.setVisibility(0);
            }
            if (this.mNetwork.yX().zY().isRequestSuccess()) {
                AtListActivity.this.hwH.a(bVar);
                if (AtListActivity.this.hwI != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hwH.bHO() != null) {
                            if (bVar != null && bVar.bHF() != null && !bVar.bHF().isEmpty()) {
                                AtListActivity.this.vE(2);
                            }
                            AtListActivity.this.hwH.bHO().p(bVar.bHF());
                            AtListActivity.this.hwI.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bHE() == null || !bVar.bHE().isEmpty()) {
                            AtListActivity.this.vE(0);
                        } else {
                            AtListActivity.this.vE(2);
                        }
                        AtListActivity.this.hwD = bVar.bHE();
                        AtListActivity.this.hwI.setData(AtListActivity.this.hwD);
                        AtListActivity.this.hwI.notifyDataSetInvalidated();
                        AtListActivity.this.LS.setSelection(0);
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
            this.hwE.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.LS == null) {
            return null;
        }
        return this.LS.getPreLoadHandle();
    }
}
