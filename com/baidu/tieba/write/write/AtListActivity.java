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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import d.b.c.j.e.q;
import d.b.i0.v3.v.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class AtListActivity extends SuspendedActivity implements d.b.h0.t0.a, AdapterView.OnItemClickListener, a.c {
    public static final String FROM_AT = "0";
    public static final String FROM_BJH = "2";
    public static final String FROM_CHAT = "1";
    public static final int NOFRIEND_MODE_ATSUGGEST = 1;
    public static final int NOFRIEND_MODE_FRIENDLIST = 2;
    public static final int NOFRIEND_MODE_NO = 0;
    public Button mButtonPost;
    public LinearLayout mCandidateContainer;
    public AtSelectFriendList mCandidateList;
    public RelativeLayout mContainer;
    public LinearLayout mContentView;
    public TextView mDelete;
    public EditText mEditText;
    public View mListFooter;
    public View mNaviSearchEditView;
    public View mNaviSearchFindView;
    public TextView mNaviTitleTV;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public Intent mResultIntent;
    public ImageView mSearchImageView;
    public ArrayList<MetaData> mFriendList = new ArrayList<>();
    public BdListView mListView = null;
    public l mFriendListTask = null;
    public d.b.i0.v3.o.a mModel = null;
    public d.b.i0.v3.v.a mAdapter = null;
    public String mPreEditString = null;
    public RelativeLayout mParent = null;
    public View mDivLine = null;
    public final int MAX_SELECT_COUNTS = 5;
    public boolean isNeedMultiple = true;
    public boolean isForChat = false;
    public boolean isForBjh = false;
    public final Handler mHandler = new Handler();
    public final Runnable mSuggestRunnable = new c();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AtListActivity.this.mEditText.getText().clear();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AtListActivity.this.mListView.requestFocus();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AtListActivity atListActivity = AtListActivity.this;
            atListActivity.requestSuggestData(d.b.c.e.p.k.charSequence2String(atListActivity.mEditText.getText(), ""));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                d.b.c.e.p.l.w(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TbCheckBox.b {
        public e() {
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            if (obj instanceof MetaData) {
                if (z) {
                    if (5 > AtListActivity.this.mCandidateList.getItemLength()) {
                        AtListActivity.this.addCandidate((MetaData) obj);
                        return;
                    }
                    AtListActivity atListActivity = AtListActivity.this;
                    atListActivity.showToastWithIcon(String.format(atListActivity.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                AtListActivity.this.removeCandidate((MetaData) obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                d.b.c.e.p.l.w(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AtListActivity.this.mResultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("name_show", AtListActivity.this.mCandidateList.getDataList());
            AtListActivity.this.mResultIntent.putExtras(bundle);
            d.b.c.e.p.l.w(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
            AtListActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements AtSelectFriendList.b {
        public h() {
        }

        @Override // com.baidu.tieba.write.write.AtSelectFriendList.b
        public void a(View view, Object obj) {
            if (obj != null) {
                if (obj instanceof TbCheckBox.c) {
                    ((TbCheckBox.c) obj).setChecked(false);
                }
                View findViewWithTag = AtListActivity.this.mListView.findViewWithTag(obj);
                if (findViewWithTag instanceof TbCheckBox) {
                    ((TbCheckBox) findViewWithTag).setChecked(false);
                } else if (obj instanceof MetaData) {
                    AtListActivity.this.removeCandidate((MetaData) obj);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AtListActivity.this.mNaviTitleTV.setVisibility(8);
            AtListActivity.this.mNaviSearchFindView.setVisibility(8);
            AtListActivity.this.mNaviSearchEditView.setVisibility(0);
            AtListActivity.this.mEditText.requestFocus();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements TextWatcher {
        public j() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String = d.b.c.e.p.k.charSequence2String(editable, null);
            if (charSequence2String == null) {
                return;
            }
            if (!charSequence2String.equals(AtListActivity.this.mPreEditString)) {
                AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.mSuggestRunnable);
                AtListActivity.this.mHandler.postDelayed(AtListActivity.this.mSuggestRunnable, 300L);
            }
            if (charSequence2String.length() > 0) {
                AtListActivity.this.mDelete.setVisibility(0);
            } else {
                AtListActivity.this.mDelete.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AtListActivity.this.mPreEditString = d.b.c.e.p.k.charSequence2String(charSequence, null);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnFocusChangeListener {
        public k() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.b.c.e.p.l.w(AtListActivity.this.getPageContext().getPageActivity(), view);
            } else {
                d.b.c.e.p.l.J(AtListActivity.this.getPageContext().getPageActivity(), view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCandidate(MetaData metaData) {
        if (metaData != null) {
            this.mCandidateList.e(metaData);
            setCandidateCount(this.mCandidateList.getItemLength());
            setPostButtonState();
        }
    }

    private void addListViewFooter() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds80) + getResources().getDimensionPixelSize(R.dimen.ds16) + getResources().getDimensionPixelSize(R.dimen.ds16);
        View view = new View(getPageContext().getContext());
        this.mListFooter = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new b());
        this.mListView.addFooterView(this.mListFooter);
    }

    private void initData(Bundle bundle) {
        this.mModel = new d.b.i0.v3.o.a();
        if (bundle != null) {
            this.isNeedMultiple = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.isForChat = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.isForBjh = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.isNeedMultiple = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.isForChat = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.isForBjh = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    private void initNavigationBar() {
        this.mNaviTitleTV = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new i());
        this.mNaviSearchFindView = addCustomView;
        this.mSearchImageView = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
        View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.mNaviSearchEditView = addCustomView2;
        addCustomView2.setVisibility(8);
        EditText editText = (EditText) this.mNaviSearchEditView.findViewById(R.id.search_bar_edit);
        this.mEditText = editText;
        editText.addTextChangedListener(new j());
        this.mEditText.setOnFocusChangeListener(new k());
        TextView textView = (TextView) findViewById(R.id.search_bar_delete_button);
        this.mDelete = textView;
        textView.setOnClickListener(new a());
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.b(getPageContext().getContext(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, d.b.c.e.p.l.g(getActivity(), R.dimen.ds320)), NoDataViewFactory.e.d(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.mDivLine = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new d());
        initNavigationBar();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.mListView = (BdListView) findViewById(R.id.list);
        d.b.i0.v3.v.a aVar = new d.b.i0.v3.v.a(this, this.isNeedMultiple);
        this.mAdapter = aVar;
        aVar.f(this);
        this.mAdapter.d(new e());
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new f());
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mCandidateContainer = (LinearLayout) this.mParent.findViewById(R.id.invite_candidate);
        Button button = (Button) this.mParent.findViewById(R.id.button_send);
        this.mButtonPost = button;
        button.setOnClickListener(new g());
        setCandidateCount(0);
        AtSelectFriendList atSelectFriendList = (AtSelectFriendList) this.mParent.findViewById(R.id.candidate_list);
        this.mCandidateList = atSelectFriendList;
        atSelectFriendList.setMaxCount(5);
        this.mCandidateList.setItemOPerationHandler(new h());
        addListViewFooter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCandidate(MetaData metaData) {
        if (metaData != null) {
            this.mCandidateList.k(metaData);
            setCandidateCount(this.mCandidateList.getItemLength());
            setPostButtonState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSuggestData(String str) {
        if (isFinishing()) {
            return;
        }
        showLoadingView(this.mContainer);
        ArrayList<MetaData> arrayList = null;
        this.mAdapter.e(null);
        if (!ListUtils.isEmpty(this.mFriendList)) {
            if (str != null && str.length() != 0) {
                arrayList = new ArrayList<>();
                Iterator<MetaData> it = this.mFriendList.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getName_show() != null && next.getName_show().contains(str)) {
                        arrayList.add(next);
                    }
                }
            } else {
                arrayList = this.mFriendList;
            }
        }
        hideLoadingView(this.mContainer);
        if (!ListUtils.isEmpty(arrayList)) {
            setNoFriends(0);
        } else {
            setNoFriends(1);
        }
        this.mAdapter.e(arrayList);
        this.mAdapter.notifyDataSetInvalidated();
        this.mListView.setSelection(0);
    }

    private void setCandidateCount(int i2) {
        this.mButtonPost.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i2), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoFriends(int i2) {
        if (i2 == 2) {
            this.mListView.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_chat_friends)));
            this.mCandidateContainer.setVisibility(8);
        } else if (i2 == 1) {
            this.mListView.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_search_friends)));
            this.mCandidateContainer.setVisibility(8);
        } else if (i2 == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.isNeedMultiple) {
                this.mCandidateContainer.setVisibility(0);
            }
        }
    }

    private void setPostButtonState() {
        if (this.mCandidateList.getItemLength() > 0) {
            this.mButtonPost.setEnabled(true);
        } else {
            this.mButtonPost.setEnabled(false);
        }
    }

    @Override // d.b.h0.t0.a
    public Intent getResultIntent() {
        return this.mResultIntent;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.b.h0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // d.b.i0.v3.v.a.c
    public void handlerItem(View view, MetaData metaData) {
        if (metaData == null) {
            return;
        }
        this.mCandidateList.g(metaData);
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewCancel() {
        d.b.c.e.p.l.w(getPageContext().getPageActivity(), this.mEditText);
        View view = this.mNaviSearchEditView;
        if (view == null || view.getVisibility() != 0) {
            return true;
        }
        this.mNaviSearchEditView.setVisibility(8);
        this.mNaviTitleTV.setVisibility(0);
        this.mNaviSearchFindView.setVisibility(0);
        this.mEditText.getText().clear();
        return false;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewTop() {
        View childAt;
        BdListView bdListView = this.mListView;
        return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.mListView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mParent);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        this.mAdapter.notifyDataSetChanged();
        SkinManager.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        SkinManager.setBackgroundResource(this.mButtonPost, R.drawable.post_button_bg);
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.mButtonPost);
        d2.k(R.string.J_X03);
        d2.f(R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.mButtonPost, R.color.CAM_X0101, 3);
        this.mSearchImageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        SkinManager.setViewTextColor(this.mContainer, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        requestData();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        l lVar = this.mFriendListTask;
        if (lVar != null) {
            lVar.cancel();
        }
        this.mHandler.removeCallbacks(this.mSuggestRunnable);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        BdListView bdListView = this.mListView;
        if (bdListView == null) {
            return null;
        }
        return bdListView.getPreLoadHandle();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        super.onItemClick(adapterView, view, i2, j2);
        MetaData item = this.mAdapter.getItem(i2);
        if (item == null) {
            return;
        }
        if (this.isNeedMultiple) {
            if (this.mFriendListTask != null) {
                return;
            }
            if (item.isChecked()) {
                removeCandidate(item);
            } else if (5 <= this.mCandidateList.getItemLength()) {
                showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                return;
            } else {
                addCandidate(item);
            }
            item.setChecked(!item.isChecked());
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        d.b.c.e.p.l.w(getPageContext().getPageActivity(), this.mEditText);
        if (this.isForChat) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
            TiebaStatic.log(new StatisticItem("c12930").param("obj_id", item.getUserIdLong()));
        }
        if (this.isForBjh) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new d.b.h0.t.b(item.getUk(), item.getName_show())));
        }
        this.mResultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("name_show", item.getName_show());
        bundle.putString("user_name", item.getUserName());
        bundle.putString("user_id", item.getUserId());
        bundle.putString("portrait", item.getPortrait());
        this.mResultIntent.putExtras(bundle);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (d.b.c.e.p.l.C()) {
            requestData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.d(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.e();
    }

    @Override // d.b.h0.t0.a
    public void onViewChangeSkinType(int i2) {
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        if (isFinishing()) {
            return;
        }
        this.mAdapter.e(null);
        if (this.mModel.a() != null) {
            ArrayList<MetaData> a2 = this.mModel.a().a();
            Iterator<MetaData> it = a2.iterator();
            while (it.hasNext()) {
                it.next().setChecked(false);
            }
            if (!ListUtils.isEmpty(a2)) {
                setNoFriends(0);
            } else {
                setNoFriends(1);
            }
            this.mAdapter.e(a2);
        } else {
            this.mAdapter.e(null);
            if (this.mFriendListTask == null) {
                l lVar = new l(this, null);
                this.mFriendListTask = lVar;
                lVar.setPriority(3);
                this.mFriendListTask.execute("");
            }
        }
        this.mAdapter.notifyDataSetInvalidated();
        this.mListView.setSelection(0);
    }

    /* loaded from: classes5.dex */
    public class l extends BdAsyncTask<String, Integer, d.b.i0.v3.m.b> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f22098a;

        public l() {
            this.f22098a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.b.i0.v3.m.b doInBackground(String... strArr) {
            NetWork netWork = new NetWork();
            this.f22098a = netWork;
            netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (!AtListActivity.this.isForChat) {
                if (AtListActivity.this.isForBjh) {
                    this.f22098a.addPostData("from", "2");
                } else {
                    this.f22098a.addPostData("from", "0");
                }
            } else {
                this.f22098a.addPostData("from", "1");
            }
            String postNetData = this.f22098a.postNetData();
            if (this.f22098a.getNetContext().getResponse().isRequestSuccess()) {
                d.b.i0.v3.m.b bVar = new d.b.i0.v3.m.b();
                bVar.b(postNetData);
                return bVar;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.b.i0.v3.m.b bVar) {
            AtListActivity.this.mFriendListTask = null;
            AtListActivity atListActivity = AtListActivity.this;
            atListActivity.hideLoadingView(atListActivity.mContainer);
            AtListActivity atListActivity2 = AtListActivity.this;
            atListActivity2.hideNetRefreshView(atListActivity2.mContainer);
            if (AtListActivity.this.mCandidateContainer != null && AtListActivity.this.mCandidateContainer.getVisibility() == 0) {
                AtListActivity.this.mDivLine.setVisibility(0);
            }
            if (this.f22098a.getNetContext().getResponse().isRequestSuccess()) {
                AtListActivity.this.mModel.b(bVar);
                if (AtListActivity.this.mAdapter == null) {
                    return;
                }
                if (bVar == null || bVar.a() == null || !bVar.a().isEmpty()) {
                    AtListActivity.this.setNoFriends(0);
                } else {
                    AtListActivity.this.setNoFriends(2);
                }
                if (bVar != null) {
                    AtListActivity.this.mFriendList = bVar.a();
                }
                AtListActivity.this.mAdapter.e(AtListActivity.this.mFriendList);
                AtListActivity.this.mAdapter.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.f22098a.getErrorString());
                AtListActivity atListActivity3 = AtListActivity.this;
                atListActivity3.showNetRefreshView(atListActivity3.mContainer, AtListActivity.this.getString(R.string.refresh_view_title_text), null, AtListActivity.this.getString(R.string.refresh_view_button_text), true, AtListActivity.this.getNetRefreshListener());
            }
            super.onPostExecute(bVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f22098a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            AtListActivity.this.mFriendListTask = null;
            AtListActivity atListActivity = AtListActivity.this;
            atListActivity.hideLoadingView(atListActivity.mContainer);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity atListActivity = AtListActivity.this;
            atListActivity.showLoadingView(atListActivity.mContainer);
            super.onPreExecute();
        }

        public /* synthetic */ l(AtListActivity atListActivity, c cVar) {
            this();
        }
    }
}
