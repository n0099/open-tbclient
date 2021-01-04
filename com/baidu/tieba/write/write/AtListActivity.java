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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
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
/* loaded from: classes8.dex */
public class AtListActivity extends SuspendedActivity implements AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a, a.b {
    private EditText cDt;
    private Intent ghm;
    private TextView giF;
    private LinearLayout kLP;
    private Button kLQ;
    private View kLU;
    private View kLV;
    private ImageView kLX;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList ocX;
    private TextView odd;
    protected ArrayList<MetaData> ocW = new ArrayList<>();
    private BdListView WV = null;
    private a ocY = null;
    private com.baidu.tieba.write.model.a ocZ = null;
    private com.baidu.tieba.write.write.a oda = null;
    private String odb = null;
    private RelativeLayout ltF = null;
    private View odc = null;
    private final int ode = 5;
    private boolean odf = true;
    private boolean odg = false;
    private boolean odh = false;
    private final Handler mHandler = new Handler();
    private final Runnable odi = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Vu(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.cDt.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bIm();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIg() {
        View childAt;
        return this.WV != null && this.WV.getFirstVisiblePosition() == 0 && (childAt = this.WV.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIh() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.cDt);
        if (this.kLU == null || this.kLU.getVisibility() != 0) {
            return true;
        }
        this.kLU.setVisibility(8);
        this.odd.setVisibility(0);
        this.kLV.setVisibility(0);
        this.cDt.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIi() {
        return this.ghm;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bIm() {
        if (!isFinishing()) {
            this.oda.setData(null);
            if (this.ocZ.dYL() != null) {
                ArrayList<MetaData> dYH = this.ocZ.dYL().dYH();
                Iterator<MetaData> it = dYH.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!x.isEmpty(dYH)) {
                    MG(0);
                } else {
                    MG(1);
                }
                this.oda.setData(dYH);
            } else {
                this.oda.setData(null);
                if (this.ocY == null) {
                    this.ocY = new a();
                    this.ocY.setPriority(3);
                    this.ocY.execute("");
                }
            }
            this.oda.notifyDataSetInvalidated();
            this.WV.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ltF);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.oda.notifyDataSetChanged();
        ao.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ao.setBackgroundResource(this.kLQ, R.drawable.post_button_bg);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.kLQ).pK(R.string.J_X03).setBackGroundColor(R.color.CAM_X0302);
        ao.setViewTextColor(this.kLQ, R.color.CAM_X0101, 3);
        this.kLX.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        ao.setViewTextColor(this.mContainer, R.color.CAM_X0201);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.bxw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MG(int i) {
        if (i == 2) {
            this.WV.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.no_chat_friends)));
            this.kLP.setVisibility(8);
        } else if (i == 1) {
            this.WV.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.no_search_friends)));
            this.kLP.setVisibility(8);
        } else if (i == 0) {
            this.WV.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.odf) {
                this.kLP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.oda.getItem(i);
        if (item != null) {
            if (this.odf) {
                if (this.ocY == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.ocX.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.oda.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.cDt);
            if (this.odg) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new aq("c12930").w("obj_id", item.getUserIdLong()));
            }
            if (this.odh) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.ghm = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.ghm.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ocY != null) {
            this.ocY.cancel();
        }
        this.mHandler.removeCallbacks(this.odi);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.ltF = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.ltF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dY(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.odc = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cDt);
                    return false;
                }
                return false;
            }
        });
        bIk();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.WV = (BdListView) findViewById(R.id.list);
        this.oda = new com.baidu.tieba.write.write.a(this, this.odf);
        this.oda.a(this);
        this.oda.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.ocX.getItemLength()) {
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
        this.WV.setAdapter((ListAdapter) this.oda);
        this.WV.setOnItemClickListener(this);
        this.WV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cDt);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra("keyboard", false) && this.cDt.getParent() != null) {
            ((View) this.cDt.getParent()).setFocusable(true);
            ((View) this.cDt.getParent()).setFocusableInTouchMode(true);
        }
        this.kLP = (LinearLayout) this.ltF.findViewById(R.id.invite_candidate);
        this.kLQ = (Button) this.ltF.findViewById(R.id.button_send);
        this.kLQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.ghm = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.ocX.getDataList());
                AtListActivity.this.ghm.putExtras(bundle);
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cDt);
                AtListActivity.this.finish();
            }
        });
        EF(0);
        this.ocX = (AtSelectFriendList) this.ltF.findViewById(R.id.candidate_list);
        this.ocX.setMaxCount(5);
        this.ocX.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.WV.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        daH();
    }

    private void bIk() {
        this.odd = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.kLV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.odd.setVisibility(8);
                AtListActivity.this.kLV.setVisibility(8);
                AtListActivity.this.kLU.setVisibility(0);
                AtListActivity.this.cDt.requestFocus();
            }
        });
        this.kLX = (ImageView) this.kLV.findViewById(R.id.new_friend_search);
        this.kLU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kLU.setVisibility(8);
        this.cDt = (EditText) this.kLU.findViewById(R.id.search_bar_edit);
        this.cDt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.odb)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.odi);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.odi, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.giF.setVisibility(0);
                    } else {
                        AtListActivity.this.giF.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.odb = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.cDt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.showSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.giF = (TextView) findViewById(R.id.search_bar_delete_button);
        this.giF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.cDt.getText().clear();
            }
        });
    }

    private void daH() {
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
                AtListActivity.this.WV.requestFocus();
            }
        });
        this.WV.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vu(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.oda.setData(null);
            if (!x.isEmpty(this.ocW)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.ocW;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.ocW.iterator();
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
            if (!x.isEmpty(arrayList)) {
                MG(0);
            } else {
                MG(1);
            }
            this.oda.setData(arrayList);
            this.oda.notifyDataSetInvalidated();
            this.WV.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.ocZ = new com.baidu.tieba.write.model.a();
        if (bundle != null) {
            this.odf = bundle.getBoolean("is_need_multiple");
            this.odg = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.odh = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.odf = getIntent().getBooleanExtra("is_need_multiple", true);
        this.odg = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.odh = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.ocX.f(metaData);
            EF(this.ocX.getItemLength());
            daI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.ocX.h(metaData);
            EF(this.ocX.getItemLength());
            daI();
        }
    }

    private void daI() {
        if (this.ocX.getItemLength() > 0) {
            this.kLQ.setEnabled(true);
        } else {
            this.kLQ.setEnabled(false);
        }
    }

    private void EF(int i) {
        this.kLQ.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private z mNetwork;

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
            AtListActivity.this.ocY = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ad */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new z();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.odg) {
                if (AtListActivity.this.odh) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Vm(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.ocY = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            AtListActivity.this.hideNetRefreshView(AtListActivity.this.mContainer);
            if (AtListActivity.this.kLP != null && AtListActivity.this.kLP.getVisibility() == 0) {
                AtListActivity.this.odc.setVisibility(0);
            }
            if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                AtListActivity.this.ocZ.a(bVar);
                if (AtListActivity.this.oda != null) {
                    if (bVar == null || bVar.dYH() == null || !bVar.dYH().isEmpty()) {
                        AtListActivity.this.MG(0);
                    } else {
                        AtListActivity.this.MG(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.ocW = bVar.dYH();
                    }
                    AtListActivity.this.oda.setData(AtListActivity.this.ocW);
                    AtListActivity.this.oda.notifyDataSetInvalidated();
                    AtListActivity.this.WV.setSelection(0);
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
            this.ocX.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        if (this.WV == null) {
            return null;
        }
        return this.WV.getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (l.isNetOk()) {
            bIm();
        }
    }
}
