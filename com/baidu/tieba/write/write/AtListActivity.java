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
    private Intent fpm;
    private TextView fqG;
    private LinearLayout jLh;
    private Button jLi;
    private View jLm;
    private View jLn;
    private ImageView jLp;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList ncY;
    private TextView nde;
    protected ArrayList<MetaData> ncX = new ArrayList<>();
    private BdListView VG = null;
    private a ncZ = null;
    private com.baidu.tieba.write.model.b nda = null;
    private com.baidu.tieba.write.write.a ndb = null;
    private String ndc = null;
    private RelativeLayout jnW = null;
    private View ndd = null;
    private final int ndf = 5;
    private boolean ndg = true;
    private boolean ndh = false;
    private boolean ndi = false;
    private final Handler mHandler = new Handler();
    private final Runnable ndj = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Ts(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.mEditText.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bvV();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvP() {
        View childAt;
        return this.VG != null && this.VG.getFirstVisiblePosition() == 0 && (childAt = this.VG.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvQ() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
        if (this.jLm == null || this.jLm.getVisibility() != 0) {
            return true;
        }
        this.jLm.setVisibility(8);
        this.nde.setVisibility(0);
        this.jLn.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qV(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bvR() {
        return this.fpm;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bvV() {
        if (!isFinishing()) {
            this.ndb.setData(null);
            if (this.nda.dKs() != null) {
                ArrayList<MetaData> dKm = this.nda.dKs().dKm();
                Iterator<MetaData> it = dKm.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!y.isEmpty(dKm)) {
                    Ko(0);
                } else {
                    Ko(1);
                }
                this.ndb.setData(dKm);
            } else {
                this.ndb.setData(null);
                if (this.ncZ == null) {
                    this.ncZ = new a();
                    this.ncZ.setPriority(3);
                    this.ncZ.execute("");
                }
            }
            this.ndb.notifyDataSetInvalidated();
            this.VG.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jnW);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.ndb.notifyDataSetChanged();
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ap.setBackgroundResource(this.jLi, R.drawable.post_button_bg);
        ap.setViewTextColor(this.jLi, R.color.cp_cont_a, 3);
        SvgManager.bkl().a(this.jLp, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        this.mNoDataView.bll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko(int i) {
        if (i == 2) {
            this.VG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.no_chat_friends)));
            this.jLh.setVisibility(8);
        } else if (i == 1) {
            this.VG.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.no_search_friends)));
            this.jLh.setVisibility(8);
        } else if (i == 0) {
            this.VG.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.ndg) {
                this.jLh.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.ndb.getItem(i);
        if (item != null) {
            if (this.ndg) {
                if (this.ncZ == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.ncY.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.ndb.notifyDataSetChanged();
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.mEditText);
            if (this.ndh) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new aq("c12930").u("obj_id", item.getUserIdLong()));
            }
            if (this.ndi) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.fpm = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.fpm.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ncZ != null) {
            this.ncZ.cancel();
        }
        this.mHandler.removeCallbacks(this.ndj);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.jnW = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.jnW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dG(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.ndd = findViewById(R.id.at_candidate_border);
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
        bvT();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.VG = (BdListView) findViewById(R.id.list);
        this.ndb = new com.baidu.tieba.write.write.a(this, this.ndg);
        this.ndb.a(this);
        this.ndb.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.ncY.getItemLength()) {
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
        this.VG.setAdapter((ListAdapter) this.ndb);
        this.VG.setOnItemClickListener(this);
        this.VG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
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
        this.jLh = (LinearLayout) this.jnW.findViewById(R.id.invite_candidate);
        this.jLi = (Button) this.jnW.findViewById(R.id.button_send);
        this.jLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.fpm = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.ncY.getDataList());
                AtListActivity.this.fpm.putExtras(bundle);
                com.baidu.adp.lib.util.l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        Co(0);
        this.ncY = (AtSelectFriendList) this.jnW.findViewById(R.id.candidate_list);
        this.ncY.setMaxCount(5);
        this.ncY.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.VG.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cMV();
    }

    private void bvT() {
        this.nde = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.jLn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.nde.setVisibility(8);
                AtListActivity.this.jLn.setVisibility(8);
                AtListActivity.this.jLm.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.jLp = (ImageView) this.jLn.findViewById(R.id.new_friend_search);
        this.jLm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jLm.setVisibility(8);
        this.mEditText = (EditText) this.jLm.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.ndc)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.ndj);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.ndj, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.fqG.setVisibility(0);
                    } else {
                        AtListActivity.this.fqG.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.ndc = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
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
        this.fqG = (TextView) findViewById(R.id.search_bar_delete_button);
        this.fqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void cMV() {
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
                AtListActivity.this.VG.requestFocus();
            }
        });
        this.VG.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.ndb.setData(null);
            if (!y.isEmpty(this.ncX)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.ncX;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.ncX.iterator();
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
                Ko(0);
            } else {
                Ko(1);
            }
            this.ndb.setData(arrayList);
            this.ndb.notifyDataSetInvalidated();
            this.VG.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.nda = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.ndg = bundle.getBoolean("is_need_multiple");
            this.ndh = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.ndi = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.ndg = getIntent().getBooleanExtra("is_need_multiple", true);
        this.ndh = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.ndi = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.ncY.f(metaData);
            Co(this.ncY.getItemLength());
            cMW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.ncY.h(metaData);
            Co(this.ncY.getItemLength());
            cMW();
        }
    }

    private void cMW() {
        if (this.ncY.getItemLength() > 0) {
            this.jLi.setEnabled(true);
        } else {
            this.jLi.setEnabled(false);
        }
    }

    private void Co(int i) {
        this.jLi.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
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
            AtListActivity.this.ncZ = null;
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
            if (!AtListActivity.this.ndh) {
                if (AtListActivity.this.ndi) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.bjL().bkr().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Td(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.ncZ = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            if (AtListActivity.this.jLh != null && AtListActivity.this.jLh.getVisibility() == 0) {
                AtListActivity.this.ndd.setVisibility(0);
            }
            if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                AtListActivity.this.nda.a(bVar);
                if (AtListActivity.this.ndb != null) {
                    if (bVar == null || bVar.dKm() == null || !bVar.dKm().isEmpty()) {
                        AtListActivity.this.Ko(0);
                    } else {
                        AtListActivity.this.Ko(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.ncX = bVar.dKm();
                    }
                    AtListActivity.this.ndb.setData(AtListActivity.this.ncX);
                    AtListActivity.this.ndb.notifyDataSetInvalidated();
                    AtListActivity.this.VG.setSelection(0);
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
            this.ncY.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public t onGetPreLoadListView() {
        if (this.VG == null) {
            return null;
        }
        return this.VG.getPreLoadHandle();
    }
}
