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
    private NoNetworkView cHB;
    private LinearLayout elr;
    private Button els;
    private View elw;
    private View elx;
    private ImageView elz;
    private TextView hfG;
    private TextView hfH;
    private AtSelectFriendList hfz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hfy = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bcs = null;
    private BdListView FL = null;
    private final Handler mHandler = new Handler();
    private a hfA = null;
    private b hfB = null;
    private com.baidu.tieba.write.model.b hfC = null;
    private com.baidu.tieba.write.write.a hfD = null;
    private String hfE = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hfF = null;
    private final int hfI = 5;
    private boolean hfJ = true;
    private boolean hfK = false;
    private final Runnable hfL = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uT(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a gDO = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.uT(null);
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
        uT(null);
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
        this.cHB.onChangeSkinType(getPageContext(), i);
        this.hfD.notifyDataSetChanged();
        ak.getColor(d.C0126d.common_color_10221);
        ak.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        ak.i(this.els, d.f.post_button_bg);
        ak.c(this.els, d.C0126d.cp_cont_i, 3);
        ak.a(this.elz, d.f.icon_search_bg_s, d.f.icon_search_bg);
        ak.h(this.hfH, d.C0126d.navi_back_text_color);
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
    public void vf(int i) {
        if (i == 2) {
            this.FL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.no_chat_friends));
            this.elr.setVisibility(8);
        } else if (i == 1) {
            this.FL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.no_search_friends));
            this.elr.setVisibility(8);
        } else if (i == 0) {
            this.FL.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hfJ) {
                this.elr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        super.onItemClick(adapterView, view2, i, j);
        MetaData item = this.hfD.getItem(i);
        if (item != null) {
            if (this.hfJ) {
                if (this.hfA == null && this.hfB == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hfz.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hfD.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.hfK) {
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
        if (this.hfA != null) {
            this.hfA.cancel();
        }
        if (this.hfB != null) {
            this.hfB.cancel();
        }
        this.mHandler.removeCallbacks(this.hfL);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.no_chat_friends), null, true);
        this.hfF = findViewById(d.g.at_candidate_border);
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
        are();
        this.cHB = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cHB.a(this.gDO);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.FL = (BdListView) findViewById(d.g.list);
        this.hfD = new com.baidu.tieba.write.write.a(this, this.hfJ);
        this.hfD.a(this);
        this.hfD.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hfz.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.FL.setAdapter((ListAdapter) this.hfD);
        this.FL.setOnItemClickListener(this);
        this.FL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.elr = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.els = (Button) this.mParent.findViewById(d.g.button_send);
        this.els.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hfz.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        od(0);
        this.hfz = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hfz.setMaxCount(5);
        this.hfz.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view2, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.FL.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aIb();
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hfH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.k.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AtListActivity.this.elw != null && AtListActivity.this.elw.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.elw.setVisibility(8);
                    AtListActivity.this.hfG.setVisibility(0);
                    AtListActivity.this.elx.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hfG = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.select_friend));
        this.elx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AtListActivity.this.hfG.setVisibility(8);
                AtListActivity.this.elx.setVisibility(8);
                AtListActivity.this.elw.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.elz = (ImageView) this.elx.findViewById(d.g.new_friend_search);
        this.elw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.elw.setVisibility(8);
        this.mEditText = (EditText) this.elw.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hfE)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hfL);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hfL, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bcs.setVisibility(0);
                    } else {
                        AtListActivity.this.bcs.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hfE = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bcs = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bcs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aIb() {
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
                AtListActivity.this.FL.requestFocus();
            }
        });
        this.FL.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(String str) {
        if (!isFinishing()) {
            this.hfD.setData(null);
            if (this.hfA != null) {
                this.hfA.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hfC.bCj() != null) {
                    ArrayList<MetaData> bBZ = this.hfC.bCj().bBZ();
                    Iterator<MetaData> it = bBZ.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bBZ != null && !bBZ.isEmpty()) {
                        vf(0);
                    } else {
                        vf(1);
                    }
                    this.hfD.setData(bBZ);
                } else {
                    this.hfD.setData(null);
                    if (this.hfB == null) {
                        this.hfB = new b();
                        this.hfB.setPriority(3);
                        this.hfB.execute("");
                    }
                }
            } else {
                this.hfA = new a();
                this.hfA.setPriority(2);
                this.hfA.execute(str);
                if (this.hfB == null && this.hfC.bCj() == null) {
                    this.hfB = new b();
                    this.hfB.setPriority(3);
                    this.hfB.execute("");
                }
            }
            this.hfD.notifyDataSetInvalidated();
            this.FL.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hfC = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hfJ = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hfK = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hfJ = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hfK = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hfz.f(metaData);
            od(this.hfz.getItemLength());
            aIc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hfz.h(metaData);
            od(this.hfz.getItemLength());
            aIc();
        }
    }

    private void aIc() {
        if (this.hfz.getItemLength() > 0) {
            this.els.setEnabled(true);
        } else {
            this.els.setEnabled(false);
        }
    }

    private void od(int i) {
        this.els.setText(String.format(getPageContext().getString(d.k.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hfN;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hfN = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hfA = null;
            this.hfN = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hfN = strArr[0];
            this.mNetwork = new x();
            if (this.hfN == null || this.hfN.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.n(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, this.hfN);
            if (AtListActivity.this.hfK) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String uL = this.mNetwork.uL();
            if (!this.mNetwork.vj().wj().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(uL, AtListActivity.this.hfC.bCj());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hfA = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vj().wj().isRequestSuccess() && this.hfN != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hfN)) {
                if (cVar == null || cVar.bCb().isEmpty()) {
                    AtListActivity.this.vf(1);
                } else {
                    AtListActivity.this.vf(0);
                }
                AtListActivity.this.hfC.a(cVar);
                AtListActivity.this.hfD.setData(cVar.bCb());
                AtListActivity.this.hfD.notifyDataSetInvalidated();
                AtListActivity.this.FL.setSelection(0);
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
            AtListActivity.this.hfB = null;
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
            if (AtListActivity.this.hfK) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String uL = this.mNetwork.uL();
            if (!this.mNetwork.vj().wj().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uK(uL);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hfB = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.elr != null && AtListActivity.this.elr.getVisibility() == 0) {
                AtListActivity.this.hfF.setVisibility(0);
            }
            if (this.mNetwork.vj().wj().isRequestSuccess()) {
                AtListActivity.this.hfC.a(bVar);
                if (AtListActivity.this.hfD != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hfC.bCk() != null) {
                            if (bVar != null && bVar.bCa() != null && !bVar.bCa().isEmpty()) {
                                AtListActivity.this.vf(2);
                            }
                            AtListActivity.this.hfC.bCk().o(bVar.bCa());
                            AtListActivity.this.hfD.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bBZ() == null || !bVar.bBZ().isEmpty()) {
                            AtListActivity.this.vf(0);
                        } else {
                            AtListActivity.this.vf(2);
                        }
                        AtListActivity.this.hfy = bVar.bBZ();
                        AtListActivity.this.hfD.setData(AtListActivity.this.hfy);
                        AtListActivity.this.hfD.notifyDataSetInvalidated();
                        AtListActivity.this.FL.setSelection(0);
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
            this.hfz.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.FL == null) {
            return null;
        }
        return this.FL.getPreLoadHandle();
    }
}
