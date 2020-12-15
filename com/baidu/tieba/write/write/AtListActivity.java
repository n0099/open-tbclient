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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private Intent fXF;
    private TextView fYY;
    private LinearLayout kGG;
    private Button kGH;
    private View kGL;
    private View kGM;
    private ImageView kGO;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList oaK;
    private TextView oaQ;
    protected ArrayList<MetaData> oaJ = new ArrayList<>();
    private BdListView WX = null;
    private a oaL = null;
    private com.baidu.tieba.write.model.b oaM = null;
    private com.baidu.tieba.write.write.a oaN = null;
    private String oaO = null;
    private RelativeLayout kjG = null;
    private View oaP = null;
    private final int oaR = 5;
    private boolean oaS = true;
    private boolean oaT = false;
    private boolean oaU = false;
    private final Handler mHandler = new Handler();
    private final Runnable oaV = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.VW(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bFR();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        View childAt;
        return this.WX != null && this.WX.getFirstVisiblePosition() == 0 && (childAt = this.WX.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
        if (this.kGL == null || this.kGL.getVisibility() != 0) {
            return true;
        }
        this.kGL.setVisibility(8);
        this.oaQ.setVisibility(0);
        this.kGM.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXF;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bFR() {
        if (!isFinishing()) {
            this.oaN.setData(null);
            if (this.oaM.dZg() != null) {
                ArrayList<MetaData> dZa = this.oaM.dZg().dZa();
                Iterator<MetaData> it = dZa.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!y.isEmpty(dZa)) {
                    MU(0);
                } else {
                    MU(1);
                }
                this.oaN.setData(dZa);
            } else {
                this.oaN.setData(null);
                if (this.oaL == null) {
                    this.oaL = new a();
                    this.oaL.setPriority(3);
                    this.oaL.execute("");
                }
            }
            this.oaN.notifyDataSetInvalidated();
            this.WX.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kjG);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.oaN.notifyDataSetChanged();
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ap.setBackgroundResource(this.kGH, R.drawable.post_button_bg);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.kGH).pA(R.string.J_X03).setBackGroundColor(R.color.CAM_X0302);
        ap.setViewTextColor(this.kGH, R.color.CAM_X0101, 3);
        this.kGO.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        ap.setViewTextColor(this.mContainer, R.color.CAM_X0201);
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
        this.mNoDataView.bvb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU(int i) {
        if (i == 2) {
            this.WX.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.no_chat_friends)));
            this.kGG.setVisibility(8);
        } else if (i == 1) {
            this.WX.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.no_search_friends)));
            this.kGG.setVisibility(8);
        } else if (i == 0) {
            this.WX.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.oaS) {
                this.kGG.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.oaN.getItem(i);
        if (item != null) {
            if (this.oaS) {
                if (this.oaL == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.oaK.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.oaN.notifyDataSetChanged();
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.oaT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ar("c12930").w("obj_id", item.getUserIdLong()));
            }
            if (this.oaU) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.fXF = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.fXF.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.oaL != null) {
            this.oaL.cancel();
        }
        this.mHandler.removeCallbacks(this.oaV);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.kjG = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.kjG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dZ(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.oaP = findViewById(R.id.at_candidate_border);
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
        bFP();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.WX = (BdListView) findViewById(R.id.list);
        this.oaN = new com.baidu.tieba.write.write.a(this, this.oaS);
        this.oaN.a(this);
        this.oaN.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.oaK.getItemLength()) {
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
        this.WX.setAdapter((ListAdapter) this.oaN);
        this.WX.setOnItemClickListener(this);
        this.WX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
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
        this.kGG = (LinearLayout) this.kjG.findViewById(R.id.invite_candidate);
        this.kGH = (Button) this.kjG.findViewById(R.id.button_send);
        this.kGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.fXF = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.oaK.getDataList());
                AtListActivity.this.fXF.putExtras(bundle);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        EN(0);
        this.oaK = (AtSelectFriendList) this.kjG.findViewById(R.id.candidate_list);
        this.oaK.setMaxCount(5);
        this.oaK.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.WX.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        dbe();
    }

    private void bFP() {
        this.oaQ = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.kGM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.oaQ.setVisibility(8);
                AtListActivity.this.kGM.setVisibility(8);
                AtListActivity.this.kGL.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.kGO = (ImageView) this.kGM.findViewById(R.id.new_friend_search);
        this.kGL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kGL.setVisibility(8);
        this.mEditText = (EditText) this.kGL.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.oaO)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.oaV);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.oaV, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.fYY.setVisibility(0);
                    } else {
                        AtListActivity.this.fYY.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.oaO = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
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
        this.fYY = (TextView) findViewById(R.id.search_bar_delete_button);
        this.fYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void dbe() {
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
                AtListActivity.this.WX.requestFocus();
            }
        });
        this.WX.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VW(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.oaN.setData(null);
            if (!y.isEmpty(this.oaJ)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.oaJ;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.oaJ.iterator();
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
                MU(0);
            } else {
                MU(1);
            }
            this.oaN.setData(arrayList);
            this.oaN.notifyDataSetInvalidated();
            this.WX.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.oaM = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.oaS = bundle.getBoolean("is_need_multiple");
            this.oaT = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.oaU = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.oaS = getIntent().getBooleanExtra("is_need_multiple", true);
        this.oaT = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.oaU = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.oaK.f(metaData);
            EN(this.oaK.getItemLength());
            dbf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.oaK.h(metaData);
            EN(this.oaK.getItemLength());
            dbf();
        }
    }

    private void dbf() {
        if (this.oaK.getItemLength() > 0) {
            this.kGH.setEnabled(true);
        } else {
            this.kGH.setEnabled(false);
        }
    }

    private void EN(int i) {
        this.kGH.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
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
            AtListActivity.this.oaL = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: X */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new aa();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.oaT) {
                if (AtListActivity.this.oaU) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.btv().buf().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.VH(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.oaL = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            AtListActivity.this.hideNetRefreshView(AtListActivity.this.mContainer);
            if (AtListActivity.this.kGG != null && AtListActivity.this.kGG.getVisibility() == 0) {
                AtListActivity.this.oaP.setVisibility(0);
            }
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                AtListActivity.this.oaM.a(bVar);
                if (AtListActivity.this.oaN != null) {
                    if (bVar == null || bVar.dZa() == null || !bVar.dZa().isEmpty()) {
                        AtListActivity.this.MU(0);
                    } else {
                        AtListActivity.this.MU(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.oaJ = bVar.dZa();
                    }
                    AtListActivity.this.oaN.setData(AtListActivity.this.oaJ);
                    AtListActivity.this.oaN.notifyDataSetInvalidated();
                    AtListActivity.this.WX.setSelection(0);
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
                AtListActivity.this.showNetRefreshView(AtListActivity.this.mContainer, AtListActivity.this.getString(R.string.refresh_view_title_text), null, AtListActivity.this.getString(R.string.refresh_view_button_text), true, AtListActivity.this.getNetRefreshListener());
            }
            super.onPostExecute(bVar);
        }
    }

    @Override // com.baidu.tieba.write.write.a.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.oaK.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public t onGetPreLoadListView() {
        if (this.WX == null) {
            return null;
        }
        return this.WX.getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            bFR();
        }
    }
}
