package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends SuspendedActivity implements AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a, a.b {
    private TextView fnx;
    private Button jCA;
    private View jCE;
    private View jCF;
    private ImageView jCH;
    private LinearLayout jCz;
    private Intent jdZ;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList mSK;
    private TextView mSR;
    protected ArrayList<MetaData> mSJ = new ArrayList<>();
    private BdListView Vo = null;
    private a mSL = null;
    private com.baidu.tieba.write.model.b mSM = null;
    private com.baidu.tieba.write.write.a mSN = null;
    private String mSO = null;
    private RelativeLayout jfk = null;
    private View mSQ = null;
    private final int mSS = 5;
    private boolean mST = true;
    private boolean mSU = false;
    private boolean mSV = false;
    private final Handler mHandler = new Handler();
    private final Runnable mSW = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.SS(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        buQ();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buK() {
        View childAt;
        return this.Vo != null && this.Vo.getFirstVisiblePosition() == 0 && (childAt = this.Vo.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buL() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
        if (this.jCE == null || this.jCE.getVisibility() != 0) {
            return true;
        }
        this.jCE.setVisibility(8);
        this.mSR.setVisibility(0);
        this.jCF.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buM() {
        return this.jdZ;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void buQ() {
        if (!isFinishing()) {
            this.mSN.setData(null);
            if (this.mSM.dGp() != null) {
                ArrayList<MetaData> dGj = this.mSM.dGp().dGj();
                Iterator<MetaData> it = dGj.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!y.isEmpty(dGj)) {
                    JJ(0);
                } else {
                    JJ(1);
                }
                this.mSN.setData(dGj);
            } else {
                this.mSN.setData(null);
                if (this.mSL == null) {
                    this.mSL = new a();
                    this.mSL.setPriority(3);
                    this.mSL.execute("");
                }
            }
            this.mSN.notifyDataSetInvalidated();
            this.Vo.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jfk);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mSN.notifyDataSetChanged();
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ap.setBackgroundResource(this.jCA, R.drawable.post_button_bg);
        ap.setViewTextColor(this.jCA, R.color.cp_cont_a, 3);
        SvgManager.bjq().a(this.jCH, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mContainer, R.color.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.bkq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ(int i) {
        if (i == 2) {
            this.Vo.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.no_chat_friends)));
            this.jCz.setVisibility(8);
        } else if (i == 1) {
            this.Vo.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.no_search_friends)));
            this.jCz.setVisibility(8);
        } else if (i == 0) {
            this.Vo.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mST) {
                this.jCz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.mSN.getItem(i);
        if (item != null) {
            if (this.mST) {
                if (this.mSL == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.mSK.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.mSN.notifyDataSetChanged();
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.mSU) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new aq("c12930").u("obj_id", item.getUserIdLong()));
            }
            if (this.mSV) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.jdZ = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.jdZ.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mSL != null) {
            this.mSL.cancel();
        }
        this.mHandler.removeCallbacks(this.mSW);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.jfk = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.jfk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dE(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.mSQ = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        buO();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.Vo = (BdListView) findViewById(R.id.list);
        this.mSN = new com.baidu.tieba.write.write.a(this, this.mST);
        this.mSN.a(this);
        this.mSN.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.mSK.getItemLength()) {
                            AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                            tbCheckBox.setChecked(false);
                            ((MetaData) obj).setChecked(false);
                            return;
                        }
                        AtListActivity.this.d((MetaData) obj);
                        return;
                    }
                    AtListActivity.this.e((MetaData) obj);
                }
            }
        });
        this.Vo.setAdapter((ListAdapter) this.mSN);
        this.Vo.setOnItemClickListener(this);
        this.Vo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra("keyboard", false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.jCz = (LinearLayout) this.jfk.findViewById(R.id.invite_candidate);
        this.jCA = (Button) this.jfk.findViewById(R.id.button_send);
        this.jCA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jdZ = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.mSK.getDataList());
                AtListActivity.this.jdZ.putExtras(bundle);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        BN(0);
        this.mSK = (AtSelectFriendList) this.jfk.findViewById(R.id.candidate_list);
        this.mSK.setMaxCount(5);
        this.mSK.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Vo.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cJo();
    }

    private void buO() {
        this.mSR = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.jCF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mSR.setVisibility(8);
                AtListActivity.this.jCF.setVisibility(8);
                AtListActivity.this.jCE.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.jCH = (ImageView) this.jCF.findViewById(R.id.new_friend_search);
        this.jCE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jCE.setVisibility(8);
        this.mEditText = (EditText) this.jCE.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.mSO)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.mSW);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.mSW, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.fnx.setVisibility(0);
                    } else {
                        AtListActivity.this.fnx.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.mSO = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fnx = (TextView) findViewById(R.id.search_bar_delete_button);
        this.fnx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void cJo() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds80) + getResources().getDimensionPixelSize(R.dimen.ds16) + getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.Vo.requestFocus();
            }
        });
        this.Vo.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SS(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.mSN.setData(null);
            if (!y.isEmpty(this.mSJ)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.mSJ;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.mSJ.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getName_show() != null && next.getName_show().contains(str)) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = arrayList2;
                }
            }
            hideLoadingView(this.mContainer);
            if (!y.isEmpty(arrayList)) {
                JJ(0);
            } else {
                JJ(1);
            }
            this.mSN.setData(arrayList);
            this.mSN.notifyDataSetInvalidated();
            this.Vo.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.mSM = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.mST = bundle.getBoolean("is_need_multiple");
            this.mSU = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.mSV = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.mST = getIntent().getBooleanExtra("is_need_multiple", true);
        this.mSU = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.mSV = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.mSK.f(metaData);
            BN(this.mSK.getItemLength());
            cJp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.mSK.h(metaData);
            BN(this.mSK.getItemLength());
            cJp();
        }
    }

    private void cJp() {
        if (this.mSK.getItemLength() > 0) {
            this.jCA.setEnabled(true);
        } else {
            this.jCA.setEnabled(false);
        }
    }

    private void BN(int i) {
        this.jCA.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private aa mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.showLoadingView(AtListActivity.this.mContainer);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            AtListActivity.this.mSL = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new aa();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.mSU) {
                if (AtListActivity.this.mSV) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.biQ().bjw().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.SD(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.mSL = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            if (AtListActivity.this.jCz != null && AtListActivity.this.jCz.getVisibility() == 0) {
                AtListActivity.this.mSQ.setVisibility(0);
            }
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                AtListActivity.this.mSM.a(bVar);
                if (AtListActivity.this.mSN != null) {
                    if (bVar == null || bVar.dGj() == null || !bVar.dGj().isEmpty()) {
                        AtListActivity.this.JJ(0);
                    } else {
                        AtListActivity.this.JJ(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.mSJ = bVar.dGj();
                    }
                    AtListActivity.this.mSN.setData(AtListActivity.this.mSJ);
                    AtListActivity.this.mSN.notifyDataSetInvalidated();
                    AtListActivity.this.Vo.setSelection(0);
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
            this.mSK.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public t onGetPreLoadListView() {
        if (this.Vo == null) {
            return null;
        }
        return this.Vo.getPreLoadHandle();
    }
}
