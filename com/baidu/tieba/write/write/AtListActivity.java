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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView eRV;
    private LinearLayout gNo;
    private Button gNp;
    private View gNt;
    private View gNu;
    private ImageView gNw;
    private AtSelectFriendList jKC;
    private TextView jKJ;
    private TextView jKK;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> jKB = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cVa = null;
    private BdListView MR = null;
    private final Handler mHandler = new Handler();
    private a jKD = null;
    private b jKE = null;
    private com.baidu.tieba.write.model.b jKF = null;
    private com.baidu.tieba.write.write.a jKG = null;
    private String jKH = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View jKI = null;
    private final int jKL = 5;
    private boolean jKM = true;
    private boolean jKN = false;
    private final Runnable jKO = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Ga(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a jhL = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                AtListActivity.this.Ga(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        initData(bundle);
        initUI();
        Ga(null);
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
        this.eRV.onChangeSkinType(getPageContext(), i);
        this.jKG.notifyDataSetChanged();
        al.getColor(R.color.common_color_10221);
        al.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        al.k(this.gNp, R.drawable.post_button_bg);
        al.f(this.gNp, R.color.cp_btn_a, 3);
        al.a(this.gNw, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        al.j(this.jKK, R.color.navi_back_text_color);
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
    public void CA(int i) {
        if (i == 2) {
            this.MR.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.no_chat_friends));
            this.gNo.setVisibility(8);
        } else if (i == 1) {
            this.MR.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.no_search_friends));
            this.gNo.setVisibility(8);
        } else if (i == 0) {
            this.MR.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.jKM) {
                this.gNo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.jKG.getItem(i);
        if (item != null) {
            if (this.jKM) {
                if (this.jKD == null && this.jKE == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.jKC.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.jKG.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.jKN) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new am("c12930").l(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.jKD != null) {
            this.jKD.cancel();
        }
        if (this.jKE != null) {
            this.jKE.cancel();
        }
        this.mHandler.removeCallbacks(this.jKO);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.no_chat_friends), null, true);
        this.jKI = findViewById(R.id.at_candidate_border);
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
        aHR();
        this.eRV = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eRV.a(this.jhL);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.MR = (BdListView) findViewById(R.id.list);
        this.jKG = new com.baidu.tieba.write.write.a(this, this.jKM);
        this.jKG.a(this);
        this.jKG.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.jKC.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.MR.setAdapter((ListAdapter) this.jKG);
        this.MR.setOnItemClickListener(this);
        this.MR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.gNo = (LinearLayout) this.mParent.findViewById(R.id.invite_candidate);
        this.gNp = (Button) this.mParent.findViewById(R.id.button_send);
        this.gNp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.jKC.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        vy(0);
        this.jKC = (AtSelectFriendList) this.mParent.findViewById(R.id.candidate_list);
        this.jKC.setMaxCount(5);
        this.jKC.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.MR.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        bEQ();
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.jKK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.gNt != null && AtListActivity.this.gNt.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.gNt.setVisibility(8);
                    AtListActivity.this.jKJ.setVisibility(0);
                    AtListActivity.this.gNu.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.jKJ = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.gNu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jKJ.setVisibility(8);
                AtListActivity.this.gNu.setVisibility(8);
                AtListActivity.this.gNt.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.gNw = (ImageView) this.gNu.findViewById(R.id.new_friend_search);
        this.gNt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gNt.setVisibility(8);
        this.mEditText = (EditText) this.gNt.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.jKH)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.jKO);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.jKO, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cVa.setVisibility(0);
                    } else {
                        AtListActivity.this.cVa.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.jKH = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.cVa = (TextView) findViewById(R.id.search_bar_delete_button);
        this.cVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void bEQ() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds80) + getResources().getDimensionPixelSize(R.dimen.ds16) + getResources().getDimensionPixelSize(R.dimen.ds16);
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
                AtListActivity.this.MR.requestFocus();
            }
        });
        this.MR.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(String str) {
        if (!isFinishing()) {
            this.jKG.setData(null);
            if (this.jKD != null) {
                this.jKD.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.jKF.cxG() != null) {
                    ArrayList<MetaData> cxw = this.jKF.cxG().cxw();
                    Iterator<MetaData> it = cxw.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (cxw != null && !cxw.isEmpty()) {
                        CA(0);
                    } else {
                        CA(1);
                    }
                    this.jKG.setData(cxw);
                } else {
                    this.jKG.setData(null);
                    if (this.jKE == null) {
                        this.jKE = new b();
                        this.jKE.setPriority(3);
                        this.jKE.execute("");
                    }
                }
            } else {
                this.jKD = new a();
                this.jKD.setPriority(2);
                this.jKD.execute(str);
                if (this.jKE == null && this.jKF.cxG() == null) {
                    this.jKE = new b();
                    this.jKE.setPriority(3);
                    this.jKE.execute("");
                }
            }
            this.jKG.notifyDataSetInvalidated();
            this.MR.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.jKF = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.jKM = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.jKN = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.jKM = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.jKN = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.jKC.f(metaData);
            vy(this.jKC.getItemLength());
            bER();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.jKC.h(metaData);
            vy(this.jKC.getItemLength());
            bER();
        }
    }

    private void bER() {
        if (this.jKC.getItemLength() > 0) {
            this.gNp.setEnabled(true);
        } else {
            this.gNp.setEnabled(false);
        }
    }

    private void vy(int i) {
        this.gNp.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String jKQ;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jKQ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.jKD = null;
            this.jKQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.jKQ = strArr[0];
            this.mNetwork = new x();
            if (this.jKQ == null || this.jKQ.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.o("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.o("q", this.jKQ);
            if (AtListActivity.this.jKN) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String ahe = this.mNetwork.ahe();
            if (!this.mNetwork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(ahe, AtListActivity.this.jKF.cxG());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.jKD = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.ahC().aiC().isRequestSuccess() && this.jKQ != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.jKQ)) {
                if (cVar == null || cVar.cxy().isEmpty()) {
                    AtListActivity.this.CA(1);
                } else {
                    AtListActivity.this.CA(0);
                }
                AtListActivity.this.jKF.a(cVar);
                AtListActivity.this.jKG.setData(cVar.cxy());
                AtListActivity.this.jKG.notifyDataSetInvalidated();
                AtListActivity.this.MR.setSelection(0);
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
                this.mNetwork.ia();
            }
            AtListActivity.this.jKE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.jKN) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String ahe = this.mNetwork.ahe();
            if (!this.mNetwork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.FP(ahe);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.jKE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.gNo != null && AtListActivity.this.gNo.getVisibility() == 0) {
                AtListActivity.this.jKI.setVisibility(0);
            }
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                AtListActivity.this.jKF.a(bVar);
                if (AtListActivity.this.jKG != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.jKF.cxH() != null) {
                            if (bVar != null && bVar.cxx() != null && !bVar.cxx().isEmpty()) {
                                AtListActivity.this.CA(2);
                            }
                            AtListActivity.this.jKF.cxH().v(bVar.cxx());
                            AtListActivity.this.jKG.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.cxw() == null || !bVar.cxw().isEmpty()) {
                            AtListActivity.this.CA(0);
                        } else {
                            AtListActivity.this.CA(2);
                        }
                        AtListActivity.this.jKB = bVar.cxw();
                        AtListActivity.this.jKG.setData(AtListActivity.this.jKB);
                        AtListActivity.this.jKG.notifyDataSetInvalidated();
                        AtListActivity.this.MR.setSelection(0);
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
            this.jKC.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.MR == null) {
            return null;
        }
        return this.MR.getPreLoadHandle();
    }
}
