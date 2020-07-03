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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes2.dex */
public class AtListActivity extends SuspendedActivity implements AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a, a.b {
    private TextView eXC;
    private Intent iIV;
    private LinearLayout jfd;
    private Button jfe;
    private View jfi;
    private View jfj;
    private ImageView jfl;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList mso;
    private TextView msu;
    protected ArrayList<MetaData> msn = new ArrayList<>();
    private BdListView US = null;
    private a msp = null;
    private com.baidu.tieba.write.model.b msq = null;
    private com.baidu.tieba.write.write.a msr = null;
    private String mss = null;
    private RelativeLayout iKg = null;
    private View mst = null;
    private final int msv = 5;
    private boolean msw = true;
    private boolean msx = false;
    private boolean msy = false;
    private final Handler mHandler = new Handler();
    private final Runnable msz = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Pi(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bis();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bim() {
        View childAt;
        return this.US != null && this.US.getFirstVisiblePosition() == 0 && (childAt = this.US.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bin() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
        if (this.jfi == null || this.jfi.getVisibility() != 0) {
            return true;
        }
        this.jfi.setVisibility(8);
        this.msu.setVisibility(0);
        this.jfj.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ob(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bio() {
        return this.iIV;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bis() {
        if (!isFinishing()) {
            this.msr.setData(null);
            if (this.msq.drC() != null) {
                ArrayList<MetaData> drw = this.msq.drC().drw();
                Iterator<MetaData> it = drw.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!w.isEmpty(drw)) {
                    GR(0);
                } else {
                    GR(1);
                }
                this.msr.setData(drw);
            } else {
                this.msr.setData(null);
                if (this.msp == null) {
                    this.msp = new a();
                    this.msp.setPriority(3);
                    this.msp.execute("");
                }
            }
            this.msr.notifyDataSetInvalidated();
            this.US.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iKg);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.msr.notifyDataSetChanged();
        an.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        an.setBackgroundResource(this.jfe, R.drawable.post_button_bg);
        an.setViewTextColor(this.jfe, R.color.cp_cont_a, 3);
        SvgManager.aWQ().a(this.jfl, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setViewTextColor(this.mContainer, (int) R.color.cp_bg_line_d);
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
        this.mNoDataView.aXU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR(int i) {
        if (i == 2) {
            this.US.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.no_chat_friends)));
            this.jfd.setVisibility(8);
        } else if (i == 1) {
            this.US.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.no_search_friends)));
            this.jfd.setVisibility(8);
        } else if (i == 0) {
            this.US.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.msw) {
                this.jfd.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.msr.getItem(i);
        if (item != null) {
            if (this.msw) {
                if (this.msp == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.mso.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.msr.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.msx) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ao("c12930").s("obj_id", item.getUserIdLong()));
            }
            if (this.msy) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.iIV = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.iIV.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.msp != null) {
            this.msp.cancel();
        }
        this.mHandler.removeCallbacks(this.msz);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.iKg = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.iKg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dm(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.mst = findViewById(R.id.at_candidate_border);
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
        biq();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.US = (BdListView) findViewById(R.id.list);
        this.msr = new com.baidu.tieba.write.write.a(this, this.msw);
        this.msr.a(this);
        this.msr.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.mso.getItemLength()) {
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
        this.US.setAdapter((ListAdapter) this.msr);
        this.US.setOnItemClickListener(this);
        this.US.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
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
        this.jfd = (LinearLayout) this.iKg.findViewById(R.id.invite_candidate);
        this.jfe = (Button) this.iKg.findViewById(R.id.button_send);
        this.jfe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.iIV = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.mso.getDataList());
                AtListActivity.this.iIV.putExtras(bundle);
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        yV(0);
        this.mso = (AtSelectFriendList) this.iKg.findViewById(R.id.candidate_list);
        this.mso.setMaxCount(5);
        this.mso.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.US.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cuu();
    }

    private void biq() {
        this.msu = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.jfj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.msu.setVisibility(8);
                AtListActivity.this.jfj.setVisibility(8);
                AtListActivity.this.jfi.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.jfl = (ImageView) this.jfj.findViewById(R.id.new_friend_search);
        this.jfi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jfi.setVisibility(8);
        this.mEditText = (EditText) this.jfi.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.mss)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.msz);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.msz, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.eXC.setVisibility(0);
                    } else {
                        AtListActivity.this.eXC.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.mss = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
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
        this.eXC = (TextView) findViewById(R.id.search_bar_delete_button);
        this.eXC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void cuu() {
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
                AtListActivity.this.US.requestFocus();
            }
        });
        this.US.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.msr.setData(null);
            if (!w.isEmpty(this.msn)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.msn;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.msn.iterator();
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
            if (!w.isEmpty(arrayList)) {
                GR(0);
            } else {
                GR(1);
            }
            this.msr.setData(arrayList);
            this.msr.notifyDataSetInvalidated();
            this.US.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.msq = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.msw = bundle.getBoolean("is_need_multiple");
            this.msx = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.msy = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.msw = getIntent().getBooleanExtra("is_need_multiple", true);
        this.msx = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.msy = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.mso.f(metaData);
            yV(this.mso.getItemLength());
            cuv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.mso.h(metaData);
            yV(this.mso.getItemLength());
            cuv();
        }
    }

    private void cuv() {
        if (this.mso.getItemLength() > 0) {
            this.jfe.setEnabled(true);
        } else {
            this.jfe.setEnabled(false);
        }
    }

    private void yV(int i) {
        this.jfe.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private y mNetwork;

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
            AtListActivity.this.msp = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: T */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new y();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.msx) {
                if (AtListActivity.this.msy) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.aWu().aWW().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.OT(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.msp = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            if (AtListActivity.this.jfd != null && AtListActivity.this.jfd.getVisibility() == 0) {
                AtListActivity.this.mst.setVisibility(0);
            }
            if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                AtListActivity.this.msq.a(bVar);
                if (AtListActivity.this.msr != null) {
                    if (bVar == null || bVar.drw() == null || !bVar.drw().isEmpty()) {
                        AtListActivity.this.GR(0);
                    } else {
                        AtListActivity.this.GR(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.msn = bVar.drw();
                    }
                    AtListActivity.this.msr.setData(AtListActivity.this.msn);
                    AtListActivity.this.msr.notifyDataSetInvalidated();
                    AtListActivity.this.US.setSelection(0);
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
            this.mso.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public t onGetPreLoadListView() {
        if (this.US == null) {
            return null;
        }
        return this.US.getPreLoadHandle();
    }
}
