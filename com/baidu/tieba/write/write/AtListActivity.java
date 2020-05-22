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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SvgManager;
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
/* loaded from: classes2.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView fan;
    private LinearLayout iNo;
    private Button iNp;
    private View iNt;
    private View iNu;
    private ImageView iNw;
    private TextView lWB;
    private TextView lWC;
    private AtSelectFriendList lWv;
    private RelativeLayout mContainer;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> lWu = new ArrayList<>();
    private EditText mEditText = null;
    private TextView eNg = null;
    private BdListView Um = null;
    private final Handler mHandler = new Handler();
    private a lWw = null;
    private com.baidu.tieba.write.model.b lWx = null;
    private com.baidu.tieba.write.write.a lWy = null;
    private String lWz = null;
    private RelativeLayout isn = null;
    private View lWA = null;
    private final int lWD = 5;
    private boolean lWE = true;
    private boolean lWF = false;
    private boolean lWG = false;
    private final Runnable lWH = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Oy(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a lua = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
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
        getLayoutMode().onModeChanged(this.isn);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fan.onChangeSkinType(getPageContext(), i);
        this.lWy.notifyDataSetChanged();
        am.getColor(R.color.common_color_10221);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        am.setBackgroundResource(this.iNp, R.drawable.post_button_bg);
        am.setViewTextColor(this.iNp, R.color.cp_cont_a, 3);
        SvgManager.aUV().a(this.iNw, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.lWC, (int) R.color.navi_back_text_color);
        am.setViewTextColor(this.mContainer, (int) R.color.cp_bg_line_d);
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
        this.mNoDataView.aVZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK(int i) {
        if (i == 2) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.no_chat_friends)));
            this.iNo.setVisibility(8);
        } else if (i == 1) {
            this.Um.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.no_search_friends)));
            this.iNo.setVisibility(8);
        } else if (i == 0) {
            this.Um.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.lWE) {
                this.iNo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.lWy.getItem(i);
        if (item != null) {
            if (this.lWE) {
                if (this.lWw == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.lWv.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.lWy.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.lWF) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new an("c12930").s("obj_id", item.getUserIdLong()));
            }
            if (this.lWG) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lWw != null) {
            this.lWw.cancel();
        }
        this.mHandler.removeCallbacks(this.lWH);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.isn = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.isn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dj(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.lWA = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        brb();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.fan = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fan.a(this.lua);
        this.Um = (BdListView) findViewById(R.id.list);
        this.lWy = new com.baidu.tieba.write.write.a(this, this.lWE);
        this.lWy.a(this);
        this.lWy.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.lWv.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Um.setAdapter((ListAdapter) this.lWy);
        this.Um.setOnItemClickListener(this);
        this.Um.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra("keyboard", false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.iNo = (LinearLayout) this.isn.findViewById(R.id.invite_candidate);
        this.iNp = (Button) this.isn.findViewById(R.id.button_send);
        this.iNp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.lWv.getDataList());
                intent.putExtras(bundle);
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        yj(0);
        this.lWv = (AtSelectFriendList) this.isn.findViewById(R.id.candidate_list);
        this.lWv.setMaxCount(5);
        this.lWv.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Um.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cqw();
    }

    private void brb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.lWC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.iNt != null && AtListActivity.this.iNt.getVisibility() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.iNt.setVisibility(8);
                    AtListActivity.this.lWB.setVisibility(0);
                    AtListActivity.this.iNu.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.lWB = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.iNu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.lWB.setVisibility(8);
                AtListActivity.this.iNu.setVisibility(8);
                AtListActivity.this.iNt.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.iNw = (ImageView) this.iNu.findViewById(R.id.new_friend_search);
        this.iNt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.iNt.setVisibility(8);
        this.mEditText = (EditText) this.iNt.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.lWz)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.lWH);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.lWH, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.eNg.setVisibility(0);
                    } else {
                        AtListActivity.this.eNg.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.lWz = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.showSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.eNg = (TextView) findViewById(R.id.search_bar_delete_button);
        this.eNg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void cqw() {
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
                AtListActivity.this.Um.requestFocus();
            }
        });
        this.Um.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (!isFinishing()) {
            this.lWy.setData(null);
            if (this.lWx.dmZ() != null) {
                ArrayList<MetaData> dmR = this.lWx.dmZ().dmR();
                Iterator<MetaData> it = dmR.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!v.isEmpty(dmR)) {
                    FK(0);
                } else {
                    FK(1);
                }
                this.lWy.setData(dmR);
            } else {
                this.lWy.setData(null);
                if (this.lWw == null) {
                    this.lWw = new a();
                    this.lWw.setPriority(3);
                    this.lWw.execute("");
                }
            }
            this.lWy.notifyDataSetInvalidated();
            this.Um.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.lWy.setData(null);
            if (!v.isEmpty(this.lWu)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.lWu;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.lWu.iterator();
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
            if (!v.isEmpty(arrayList)) {
                FK(0);
            } else {
                FK(1);
            }
            this.lWy.setData(arrayList);
            this.lWy.notifyDataSetInvalidated();
            this.Um.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.lWx = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.lWE = bundle.getBoolean("is_need_multiple");
            this.lWF = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.lWG = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.lWE = getIntent().getBooleanExtra("is_need_multiple", true);
        this.lWF = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.lWG = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.lWv.f(metaData);
            yj(this.lWv.getItemLength());
            cqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.lWv.h(metaData);
            yj(this.lWv.getItemLength());
            cqx();
        }
    }

    private void cqx() {
        if (this.lWv.getItemLength() > 0) {
            this.iNp.setEnabled(true);
        } else {
            this.iNp.setEnabled(false);
        }
    }

    private void yj(int i) {
        this.iNp.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private x mNetwork;

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
            AtListActivity.this.lWw = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: U */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.lWF) {
                if (AtListActivity.this.lWG) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.aUA().aVb().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Ol(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.lWw = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            if (AtListActivity.this.iNo != null && AtListActivity.this.iNo.getVisibility() == 0) {
                AtListActivity.this.lWA.setVisibility(0);
            }
            if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                AtListActivity.this.lWx.a(bVar);
                if (AtListActivity.this.lWy != null) {
                    if (bVar == null || bVar.dmR() == null || !bVar.dmR().isEmpty()) {
                        AtListActivity.this.FK(0);
                    } else {
                        AtListActivity.this.FK(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.lWu = bVar.dmR();
                    }
                    AtListActivity.this.lWy.setData(AtListActivity.this.lWu);
                    AtListActivity.this.lWy.notifyDataSetInvalidated();
                    AtListActivity.this.Um.setSelection(0);
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
            this.lWv.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public r onGetPreLoadListView() {
        if (this.Um == null) {
            return null;
        }
        return this.Um.getPreLoadHandle();
    }
}
