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
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
    private NoNetworkView eXf;
    private LinearLayout gUq;
    private Button gUr;
    private View gUv;
    private View gUw;
    private ImageView gUy;
    private AtSelectFriendList jSJ;
    private TextView jSP;
    private TextView jSQ;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> jSI = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cWD = null;
    private BdListView Ni = null;
    private final Handler mHandler = new Handler();
    private a jSK = null;
    private com.baidu.tieba.write.model.b jSL = null;
    private com.baidu.tieba.write.write.a jSM = null;
    private String jSN = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View jSO = null;
    private final int jSR = 5;
    private boolean jSS = true;
    private boolean jST = false;
    private final Runnable jSU = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.GV(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a jpc = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                AtListActivity.this.refreshData();
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
        refreshData();
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
        this.eXf.onChangeSkinType(getPageContext(), i);
        this.jSM.notifyDataSetChanged();
        am.getColor(R.color.common_color_10221);
        am.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        am.k(this.gUr, R.drawable.post_button_bg);
        am.f(this.gUr, R.color.cp_btn_a, 3);
        am.a(this.gUy, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        am.j(this.jSQ, R.color.navi_back_text_color);
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
        this.mNoDataView.akw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj(int i) {
        if (i == 2) {
            this.Ni.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.no_chat_friends));
            this.gUq.setVisibility(8);
        } else if (i == 1) {
            this.Ni.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.no_search_friends));
            this.gUq.setVisibility(8);
        } else if (i == 0) {
            this.Ni.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.jSS) {
                this.gUq.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.jSM.getItem(i);
        if (item != null) {
            if (this.jSS) {
                if (this.jSK == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.jSJ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.jSM.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.jST) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new an("c12930").l(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.jSK != null) {
            this.jSK.cancel();
        }
        this.mHandler.removeCallbacks(this.jSU);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.no_chat_friends), null, true);
        this.jSO = findViewById(R.id.at_candidate_border);
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
        aJt();
        this.eXf = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eXf.a(this.jpc);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.Ni = (BdListView) findViewById(R.id.list);
        this.jSM = new com.baidu.tieba.write.write.a(this, this.jSS);
        this.jSM.a(this);
        this.jSM.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.jSJ.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Ni.setAdapter((ListAdapter) this.jSM);
        this.Ni.setOnItemClickListener(this);
        this.Ni.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.gUq = (LinearLayout) this.mParent.findViewById(R.id.invite_candidate);
        this.gUr = (Button) this.mParent.findViewById(R.id.button_send);
        this.gUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.jSJ.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        wb(0);
        this.jSJ = (AtSelectFriendList) this.mParent.findViewById(R.id.candidate_list);
        this.jSJ.setMaxCount(5);
        this.jSJ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Ni.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        bHL();
    }

    private void aJt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.jSQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.gUv != null && AtListActivity.this.gUv.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.gUv.setVisibility(8);
                    AtListActivity.this.jSP.setVisibility(0);
                    AtListActivity.this.gUw.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.jSP = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.gUw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jSP.setVisibility(8);
                AtListActivity.this.gUw.setVisibility(8);
                AtListActivity.this.gUv.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.gUy = (ImageView) this.gUw.findViewById(R.id.new_friend_search);
        this.gUv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gUv.setVisibility(8);
        this.mEditText = (EditText) this.gUv.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.jSN)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.jSU);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.jSU, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cWD.setVisibility(0);
                    } else {
                        AtListActivity.this.cWD.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.jSN = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.cWD = (TextView) findViewById(R.id.search_bar_delete_button);
        this.cWD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void bHL() {
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
                AtListActivity.this.Ni.requestFocus();
            }
        });
        this.Ni.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (!isFinishing()) {
            this.jSM.setData(null);
            if (this.jSL.cBa() != null) {
                ArrayList<MetaData> cAS = this.jSL.cBa().cAS();
                Iterator<MetaData> it = cAS.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!v.aa(cAS)) {
                    Dj(0);
                } else {
                    Dj(1);
                }
                this.jSM.setData(cAS);
            } else {
                this.jSM.setData(null);
                if (this.jSK == null) {
                    this.jSK = new a();
                    this.jSK.setPriority(3);
                    this.jSK.execute("");
                }
            }
            this.jSM.notifyDataSetInvalidated();
            this.Ni.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            this.mProgress.setVisibility(0);
            this.jSM.setData(null);
            if (!v.aa(this.jSI)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.jSI;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.jSI.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getName_show() != null && next.getName_show().contains(str)) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = arrayList2;
                }
            }
            this.mProgress.setVisibility(8);
            if (!v.aa(arrayList)) {
                Dj(0);
            } else {
                Dj(1);
            }
            this.jSM.setData(arrayList);
            this.jSM.notifyDataSetInvalidated();
            this.Ni.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.jSL = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.jSS = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.jST = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.jSS = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.jST = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.jSJ.f(metaData);
            wb(this.jSJ.getItemLength());
            bHM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.jSJ.h(metaData);
            wb(this.jSJ.getItemLength());
            bHM();
        }
    }

    private void bHM() {
        if (this.jSJ.getItemLength() > 0) {
            this.gUr.setEnabled(true);
        } else {
            this.gUr.setEnabled(false);
        }
    }

    private void wb(int i) {
        this.gUr.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private x mNetwork;

        private a() {
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
                this.mNetwork.ik();
            }
            AtListActivity.this.jSK = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.jST) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String aii = this.mNetwork.aii();
            if (!this.mNetwork.aiG().ajH().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.GK(aii);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.jSK = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.gUq != null && AtListActivity.this.gUq.getVisibility() == 0) {
                AtListActivity.this.jSO.setVisibility(0);
            }
            if (this.mNetwork.aiG().ajH().isRequestSuccess()) {
                AtListActivity.this.jSL.a(bVar);
                if (AtListActivity.this.jSM != null) {
                    if (bVar == null || bVar.cAS() == null || !bVar.cAS().isEmpty()) {
                        AtListActivity.this.Dj(0);
                    } else {
                        AtListActivity.this.Dj(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.jSI = bVar.cAS();
                    }
                    AtListActivity.this.jSM.setData(AtListActivity.this.jSI);
                    AtListActivity.this.jSM.notifyDataSetInvalidated();
                    AtListActivity.this.Ni.setSelection(0);
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
            this.jSJ.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.Ni == null) {
            return null;
        }
        return this.Ni.getPreLoadHandle();
    }
}
