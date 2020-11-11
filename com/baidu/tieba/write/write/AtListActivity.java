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
    private Intent fPL;
    private TextView fRe;
    private LinearLayout ksA;
    private Button ksB;
    private View ksF;
    private View ksG;
    private ImageView ksI;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList nKQ;
    private TextView nKW;
    protected ArrayList<MetaData> nKP = new ArrayList<>();
    private BdListView VY = null;
    private a nKR = null;
    private com.baidu.tieba.write.model.b nKS = null;
    private com.baidu.tieba.write.write.a nKT = null;
    private String nKU = null;
    private RelativeLayout jVp = null;
    private View nKV = null;
    private final int nKX = 5;
    private boolean nKY = true;
    private boolean nKZ = false;
    private boolean nLa = false;
    private final Handler mHandler = new Handler();
    private final Runnable nLb = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.UW(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bCX();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCR() {
        View childAt;
        return this.VY != null && this.VY.getFirstVisiblePosition() == 0 && (childAt = this.VY.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCS() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
        if (this.ksF == null || this.ksF.getVisibility() != 0) {
            return true;
        }
        this.ksF.setVisibility(8);
        this.nKW.setVisibility(0);
        this.ksG.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rO(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCT() {
        return this.fPL;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bCX() {
        if (!isFinishing()) {
            this.nKT.setData(null);
            if (this.nKS.dTM() != null) {
                ArrayList<MetaData> dTG = this.nKS.dTM().dTG();
                Iterator<MetaData> it = dTG.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!y.isEmpty(dTG)) {
                    Lz(0);
                } else {
                    Lz(1);
                }
                this.nKT.setData(dTG);
            } else {
                this.nKT.setData(null);
                if (this.nKR == null) {
                    this.nKR = new a();
                    this.nKR.setPriority(3);
                    this.nKR.execute("");
                }
            }
            this.nKT.notifyDataSetInvalidated();
            this.VY.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jVp);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.nKT.notifyDataSetChanged();
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ap.setBackgroundResource(this.ksB, R.drawable.post_button_bg);
        ap.setViewTextColor(this.ksB, R.color.cp_cont_a, 3);
        SvgManager.brn().a(this.ksI, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        this.mNoDataView.bso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lz(int i) {
        if (i == 2) {
            this.VY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_chat_friends)));
            this.ksA.setVisibility(8);
        } else if (i == 1) {
            this.VY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_search_friends)));
            this.ksA.setVisibility(8);
        } else if (i == 0) {
            this.VY.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.nKY) {
                this.ksA.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.nKT.getItem(i);
        if (item != null) {
            if (this.nKY) {
                if (this.nKR == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.nKQ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.nKT.notifyDataSetChanged();
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.nKZ) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new aq("c12930").w("obj_id", item.getUserIdLong()));
            }
            if (this.nLa) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.fPL = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.fPL.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nKR != null) {
            this.nKR.cancel();
        }
        this.mHandler.removeCallbacks(this.nLb);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.jVp = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.jVp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.nKV = findViewById(R.id.at_candidate_border);
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
        bCV();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.VY = (BdListView) findViewById(R.id.list);
        this.nKT = new com.baidu.tieba.write.write.a(this, this.nKY);
        this.nKT.a(this);
        this.nKT.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.nKQ.getItemLength()) {
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
        this.VY.setAdapter((ListAdapter) this.nKT);
        this.VY.setOnItemClickListener(this);
        this.VY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
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
        this.ksA = (LinearLayout) this.jVp.findViewById(R.id.invite_candidate);
        this.ksB = (Button) this.jVp.findViewById(R.id.button_send);
        this.ksB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.fPL = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.nKQ.getDataList());
                AtListActivity.this.fPL.putExtras(bundle);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        DA(0);
        this.nKQ = (AtSelectFriendList) this.jVp.findViewById(R.id.candidate_list);
        this.nKQ.setMaxCount(5);
        this.nKQ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.VY.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cWl();
    }

    private void bCV() {
        this.nKW = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.ksG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.nKW.setVisibility(8);
                AtListActivity.this.ksG.setVisibility(8);
                AtListActivity.this.ksF.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.ksI = (ImageView) this.ksG.findViewById(R.id.new_friend_search);
        this.ksF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.ksF.setVisibility(8);
        this.mEditText = (EditText) this.ksF.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.nKU)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.nLb);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.nLb, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.fRe.setVisibility(0);
                    } else {
                        AtListActivity.this.fRe.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.nKU = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
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
        this.fRe = (TextView) findViewById(R.id.search_bar_delete_button);
        this.fRe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void cWl() {
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
                AtListActivity.this.VY.requestFocus();
            }
        });
        this.VY.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UW(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.nKT.setData(null);
            if (!y.isEmpty(this.nKP)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.nKP;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.nKP.iterator();
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
                Lz(0);
            } else {
                Lz(1);
            }
            this.nKT.setData(arrayList);
            this.nKT.notifyDataSetInvalidated();
            this.VY.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.nKS = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.nKY = bundle.getBoolean("is_need_multiple");
            this.nKZ = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.nLa = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.nKY = getIntent().getBooleanExtra("is_need_multiple", true);
        this.nKZ = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.nLa = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.nKQ.f(metaData);
            DA(this.nKQ.getItemLength());
            cWm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.nKQ.h(metaData);
            DA(this.nKQ.getItemLength());
            cWm();
        }
    }

    private void cWm() {
        if (this.nKQ.getItemLength() > 0) {
            this.ksB.setEnabled(true);
        } else {
            this.ksB.setEnabled(false);
        }
    }

    private void DA(int i) {
        this.ksB.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
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
            AtListActivity.this.nKR = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: W */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new aa();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.nKZ) {
                if (AtListActivity.this.nLa) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.bqN().bru().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.UH(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.nKR = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            if (AtListActivity.this.ksA != null && AtListActivity.this.ksA.getVisibility() == 0) {
                AtListActivity.this.nKV.setVisibility(0);
            }
            if (this.mNetwork.bqN().bru().isRequestSuccess()) {
                AtListActivity.this.nKS.a(bVar);
                if (AtListActivity.this.nKT != null) {
                    if (bVar == null || bVar.dTG() == null || !bVar.dTG().isEmpty()) {
                        AtListActivity.this.Lz(0);
                    } else {
                        AtListActivity.this.Lz(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.nKP = bVar.dTG();
                    }
                    AtListActivity.this.nKT.setData(AtListActivity.this.nKP);
                    AtListActivity.this.nKT.notifyDataSetInvalidated();
                    AtListActivity.this.VY.setSelection(0);
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
            this.nKQ.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public t onGetPreLoadListView() {
        if (this.VY == null) {
            return null;
        }
        return this.VY.getPreLoadHandle();
    }
}
