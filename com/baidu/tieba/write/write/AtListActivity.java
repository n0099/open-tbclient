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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
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
    private NoNetworkView cRO;
    private LinearLayout exN;
    private Button exO;
    private View exS;
    private View exT;
    private ImageView exV;
    private TextView hsD;
    private TextView hsE;
    private AtSelectFriendList hsw;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hsu = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bkD = null;
    private BdListView LQ = null;
    private final Handler mHandler = new Handler();
    private a hsx = null;
    private b hsy = null;
    private com.baidu.tieba.write.model.b hsz = null;
    private com.baidu.tieba.write.write.a hsA = null;
    private String hsB = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hsC = null;
    private final int hsF = 5;
    private boolean hsG = true;
    private boolean hsH = false;
    private final Runnable hsI = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.vQ(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a gQr = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                AtListActivity.this.vQ(null);
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
        vQ(null);
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
        this.cRO.onChangeSkinType(getPageContext(), i);
        this.hsA.notifyDataSetChanged();
        al.getColor(d.C0141d.common_color_10221);
        al.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        al.i(this.exO, d.f.post_button_bg);
        al.c(this.exO, d.C0141d.cp_cont_i, 3);
        al.a(this.exV, d.f.icon_search_bg_s, d.f.icon_search_bg);
        al.h(this.hsE, d.C0141d.navi_back_text_color);
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
    public void vv(int i) {
        if (i == 2) {
            this.LQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.no_chat_friends));
            this.exN.setVisibility(8);
        } else if (i == 1) {
            this.LQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.no_search_friends));
            this.exN.setVisibility(8);
        } else if (i == 0) {
            this.LQ.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hsG) {
                this.exN.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hsA.getItem(i);
        if (item != null) {
            if (this.hsG) {
                if (this.hsx == null && this.hsy == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hsw.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hsA.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.hsH) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new am("c12930").f(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.hsx != null) {
            this.hsx.cancel();
        }
        if (this.hsy != null) {
            this.hsy.cancel();
        }
        this.mHandler.removeCallbacks(this.hsI);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), NoDataViewFactory.d.dr(d.k.no_chat_friends), null, true);
        this.hsC = findViewById(d.g.at_candidate_border);
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
        avi();
        this.cRO = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cRO.a(this.gQr);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.LQ = (BdListView) findViewById(d.g.list);
        this.hsA = new com.baidu.tieba.write.write.a(this, this.hsG);
        this.hsA.a(this);
        this.hsA.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hsw.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.k.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.LQ.setAdapter((ListAdapter) this.hsA);
        this.LQ.setOnItemClickListener(this);
        this.LQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.exN = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.exO = (Button) this.mParent.findViewById(d.g.button_send);
        this.exO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hsw.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        on(0);
        this.hsw = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hsw.setMaxCount(5);
        this.hsw.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.LQ.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aMU();
    }

    private void avi() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hsE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.k.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.exS != null && AtListActivity.this.exS.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.exS.setVisibility(8);
                    AtListActivity.this.hsD.setVisibility(0);
                    AtListActivity.this.exT.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hsD = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.k.select_friend));
        this.exT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hsD.setVisibility(8);
                AtListActivity.this.exT.setVisibility(8);
                AtListActivity.this.exS.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.exV = (ImageView) this.exT.findViewById(d.g.new_friend_search);
        this.exS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.exS.setVisibility(8);
        this.mEditText = (EditText) this.exS.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hsB)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hsI);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hsI, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bkD.setVisibility(0);
                    } else {
                        AtListActivity.this.bkD.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hsB = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bkD = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bkD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aMU() {
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
                AtListActivity.this.LQ.requestFocus();
            }
        });
        this.LQ.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(String str) {
        if (!isFinishing()) {
            this.hsA.setData(null);
            if (this.hsx != null) {
                this.hsx.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hsz.bHm() != null) {
                    ArrayList<MetaData> bHd = this.hsz.bHm().bHd();
                    Iterator<MetaData> it = bHd.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bHd != null && !bHd.isEmpty()) {
                        vv(0);
                    } else {
                        vv(1);
                    }
                    this.hsA.setData(bHd);
                } else {
                    this.hsA.setData(null);
                    if (this.hsy == null) {
                        this.hsy = new b();
                        this.hsy.setPriority(3);
                        this.hsy.execute("");
                    }
                }
            } else {
                this.hsx = new a();
                this.hsx.setPriority(2);
                this.hsx.execute(str);
                if (this.hsy == null && this.hsz.bHm() == null) {
                    this.hsy = new b();
                    this.hsy.setPriority(3);
                    this.hsy.execute("");
                }
            }
            this.hsA.notifyDataSetInvalidated();
            this.LQ.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hsz = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hsG = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hsH = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hsG = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hsH = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hsw.f(metaData);
            on(this.hsw.getItemLength());
            aMV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hsw.h(metaData);
            on(this.hsw.getItemLength());
            aMV();
        }
    }

    private void aMV() {
        if (this.hsw.getItemLength() > 0) {
            this.exO.setEnabled(true);
        } else {
            this.exO.setEnabled(false);
        }
    }

    private void on(int i) {
        this.exO.setText(String.format(getPageContext().getString(d.k.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hsK;
        private y mNetwork;

        private a() {
            this.mNetwork = null;
            this.hsK = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hsx = null;
            this.hsK = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hsK = strArr[0];
            this.mNetwork = new y();
            if (this.hsK == null || this.hsK.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.o("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.o(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, this.hsK);
            if (AtListActivity.this.hsH) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yl = this.mNetwork.yl();
            if (!this.mNetwork.yJ().zJ().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(yl, AtListActivity.this.hsz.bHm());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hsx = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.yJ().zJ().isRequestSuccess() && this.hsK != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hsK)) {
                if (cVar == null || cVar.bHf().isEmpty()) {
                    AtListActivity.this.vv(1);
                } else {
                    AtListActivity.this.vv(0);
                }
                AtListActivity.this.hsz.a(cVar);
                AtListActivity.this.hsA.setData(cVar.bHf());
                AtListActivity.this.hsA.notifyDataSetInvalidated();
                AtListActivity.this.LQ.setSelection(0);
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
            AtListActivity.this.hsy = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new y();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hsH) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yl = this.mNetwork.yl();
            if (!this.mNetwork.yJ().zJ().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.vH(yl);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hsy = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.exN != null && AtListActivity.this.exN.getVisibility() == 0) {
                AtListActivity.this.hsC.setVisibility(0);
            }
            if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                AtListActivity.this.hsz.a(bVar);
                if (AtListActivity.this.hsA != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hsz.bHn() != null) {
                            if (bVar != null && bVar.bHe() != null && !bVar.bHe().isEmpty()) {
                                AtListActivity.this.vv(2);
                            }
                            AtListActivity.this.hsz.bHn().p(bVar.bHe());
                            AtListActivity.this.hsA.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bHd() == null || !bVar.bHd().isEmpty()) {
                            AtListActivity.this.vv(0);
                        } else {
                            AtListActivity.this.vv(2);
                        }
                        AtListActivity.this.hsu = bVar.bHd();
                        AtListActivity.this.hsA.setData(AtListActivity.this.hsu);
                        AtListActivity.this.hsA.notifyDataSetInvalidated();
                        AtListActivity.this.LQ.setSelection(0);
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
            this.hsw.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.LQ == null) {
            return null;
        }
        return this.LQ.getPreLoadHandle();
    }
}
