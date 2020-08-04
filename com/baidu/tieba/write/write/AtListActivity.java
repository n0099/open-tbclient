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
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes3.dex */
public class AtListActivity extends SuspendedActivity implements AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a, a.b {
    private TextView fcd;
    private Intent iPc;
    private LinearLayout jnB;
    private Button jnC;
    private View jnG;
    private View jnH;
    private ImageView jnJ;
    private AtSelectFriendList mAs;
    private TextView mAy;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> mAr = new ArrayList<>();
    private BdListView UL = null;
    private a mAt = null;
    private com.baidu.tieba.write.model.b mAu = null;
    private com.baidu.tieba.write.write.a mAv = null;
    private String mAw = null;
    private RelativeLayout iQn = null;
    private View mAx = null;
    private final int mAz = 5;
    private boolean mAA = true;
    private boolean mAB = false;
    private boolean mAC = false;
    private final Handler mHandler = new Handler();
    private final Runnable mAD = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.PU(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bmd();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blX() {
        View childAt;
        return this.UL != null && this.UL.getFirstVisiblePosition() == 0 && (childAt = this.UL.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blY() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
        if (this.jnG == null || this.jnG.getVisibility() != 0) {
            return true;
        }
        this.jnG.setVisibility(8);
        this.mAy.setVisibility(0);
        this.jnH.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ot(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent blZ() {
        return this.iPc;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bmd() {
        if (!isFinishing()) {
            this.mAv.setData(null);
            if (this.mAu.duT() != null) {
                ArrayList<MetaData> duN = this.mAu.duT().duN();
                Iterator<MetaData> it = duN.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!x.isEmpty(duN)) {
                    Hm(0);
                } else {
                    Hm(1);
                }
                this.mAv.setData(duN);
            } else {
                this.mAv.setData(null);
                if (this.mAt == null) {
                    this.mAt = new a();
                    this.mAt.setPriority(3);
                    this.mAt.execute("");
                }
            }
            this.mAv.notifyDataSetInvalidated();
            this.UL.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iQn);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mAv.notifyDataSetChanged();
        ao.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ao.setBackgroundResource(this.jnC, R.drawable.post_button_bg);
        ao.setViewTextColor(this.jnC, R.color.cp_cont_a, 3);
        SvgManager.baR().a(this.jnJ, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.mContainer, R.color.cp_bg_line_d);
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
        this.mNoDataView.bbU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm(int i) {
        if (i == 2) {
            this.UL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.no_chat_friends)));
            this.jnB.setVisibility(8);
        } else if (i == 1) {
            this.UL.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.no_search_friends)));
            this.jnB.setVisibility(8);
        } else if (i == 0) {
            this.UL.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mAA) {
                this.jnB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.mAv.getItem(i);
        if (item != null) {
            if (this.mAA) {
                if (this.mAt == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.mAs.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.mAv.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.mAB) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ap("c12930").t("obj_id", item.getUserIdLong()));
            }
            if (this.mAC) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.iPc = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.iPc.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mAt != null) {
            this.mAt.cancel();
        }
        this.mHandler.removeCallbacks(this.mAD);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.iQn = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.iQn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.m31do(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.mAx = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        bmb();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.UL = (BdListView) findViewById(R.id.list);
        this.mAv = new com.baidu.tieba.write.write.a(this, this.mAA);
        this.mAv.a(this);
        this.mAv.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.mAs.getItemLength()) {
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
        this.UL.setAdapter((ListAdapter) this.mAv);
        this.UL.setOnItemClickListener(this);
        this.UL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
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
        this.jnB = (LinearLayout) this.iQn.findViewById(R.id.invite_candidate);
        this.jnC = (Button) this.iQn.findViewById(R.id.button_send);
        this.jnC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.iPc = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.mAs.getDataList());
                AtListActivity.this.iPc.putExtras(bundle);
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        zu(0);
        this.mAs = (AtSelectFriendList) this.iQn.findViewById(R.id.candidate_list);
        this.mAs.setMaxCount(5);
        this.mAs.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.UL.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cyx();
    }

    private void bmb() {
        this.mAy = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.jnH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mAy.setVisibility(8);
                AtListActivity.this.jnH.setVisibility(8);
                AtListActivity.this.jnG.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.jnJ = (ImageView) this.jnH.findViewById(R.id.new_friend_search);
        this.jnG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jnG.setVisibility(8);
        this.mEditText = (EditText) this.jnG.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.mAw)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.mAD);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.mAD, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.fcd.setVisibility(0);
                    } else {
                        AtListActivity.this.fcd.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.mAw = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.showSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.fcd = (TextView) findViewById(R.id.search_bar_delete_button);
        this.fcd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void cyx() {
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
                AtListActivity.this.UL.requestFocus();
            }
        });
        this.UL.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PU(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.mAv.setData(null);
            if (!x.isEmpty(this.mAr)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.mAr;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.mAr.iterator();
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
                Hm(0);
            } else {
                Hm(1);
            }
            this.mAv.setData(arrayList);
            this.mAv.notifyDataSetInvalidated();
            this.UL.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.mAu = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.mAA = bundle.getBoolean("is_need_multiple");
            this.mAB = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.mAC = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.mAA = getIntent().getBooleanExtra("is_need_multiple", true);
        this.mAB = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.mAC = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.mAs.f(metaData);
            zu(this.mAs.getItemLength());
            cyy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.mAs.h(metaData);
            zu(this.mAs.getItemLength());
            cyy();
        }
    }

    private void cyy() {
        if (this.mAs.getItemLength() > 0) {
            this.jnC.setEnabled(true);
        } else {
            this.jnC.setEnabled(false);
        }
    }

    private void zu(int i) {
        this.jnC.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            AtListActivity.this.mAt = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: R */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new z();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.mAB) {
                if (AtListActivity.this.mAC) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.bav().baX().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.PF(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.mAt = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            if (AtListActivity.this.jnB != null && AtListActivity.this.jnB.getVisibility() == 0) {
                AtListActivity.this.mAx.setVisibility(0);
            }
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                AtListActivity.this.mAu.a(bVar);
                if (AtListActivity.this.mAv != null) {
                    if (bVar == null || bVar.duN() == null || !bVar.duN().isEmpty()) {
                        AtListActivity.this.Hm(0);
                    } else {
                        AtListActivity.this.Hm(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.mAr = bVar.duN();
                    }
                    AtListActivity.this.mAv.setData(AtListActivity.this.mAr);
                    AtListActivity.this.mAv.notifyDataSetInvalidated();
                    AtListActivity.this.UL.setSelection(0);
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
            this.mAs.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public t onGetPreLoadListView() {
        if (this.UL == null) {
            return null;
        }
        return this.UL.getPreLoadHandle();
    }
}
