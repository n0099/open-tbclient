package com.baidu.tieba.pb.account.forbid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import d.a.o0.e2.f.a.a;
import d.a.o0.e2.f.a.b;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    public d mAdapter;
    public d.a.n0.r.s.a mErrorDialog;
    public RadioGroup mForbidDays;
    public TextView mForbidIdView;
    public View.OnClickListener mForbidListener = new c();
    public TextView mForbidTextView;
    public String mForumId;
    public String mForumName;
    public BdListView mListView;
    public String mMgrUserID;
    public NavigationBar mNavigationBar;
    public String mPostId;
    public String mThreadId;
    public String mUserName;
    public String mUserNameShow;
    public String mUserPortrait;

    /* loaded from: classes5.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            ForbidActivity forbidActivity = ForbidActivity.this;
            forbidActivity.changeSelectedButton(forbidActivity.mForbidDays.getCheckedRadioButtonId());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.InterfaceC1310b {
        public b() {
        }

        @Override // d.a.o0.e2.f.a.b.InterfaceC1310b
        public void a(ForbidTplData forbidTplData) {
            if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                ForbidActivity.this.showToast(R.string.neterror);
            } else {
                ForbidActivity.this.showToast(forbidTplData.error.errMsg);
            }
        }

        @Override // d.a.o0.e2.f.a.b.InterfaceC1310b
        public void b(ForbidTplData forbidTplData) {
            ForbidActivity.this.mForbidIdView.setText(ForbidActivity.this.mUserNameShow);
            int i2 = forbidTplData.type;
            if (i2 == 1 || i2 == 2) {
                ForbidActivity.this.findViewById(R.id.radio_forbid_3).setVisibility(0);
                ForbidActivity.this.findViewById(R.id.radio_forbid_10).setVisibility(0);
            }
            ForbidActivity.this.mAdapter = new d(forbidTplData.reason);
            ForbidActivity.this.mListView.setAdapter((ListAdapter) ForbidActivity.this.mAdapter);
            String[] strArr = forbidTplData.reason;
            if (strArr == null || strArr.length == 0) {
                ForbidActivity.this.showToast(R.string.no_data_text);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a implements a.b {

            /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0206a implements a.e {
                public C0206a() {
                }

                @Override // d.a.n0.r.s.a.e
                public void onClick(d.a.n0.r.s.a aVar) {
                    if (aVar != null) {
                        aVar.dismiss();
                        ForbidActivity.this.getActivity().finish();
                    }
                }
            }

            public a() {
            }

            @Override // d.a.o0.e2.f.a.a.b
            public void a(ForbidResultData forbidResultData) {
                ForbidActivity forbidActivity = ForbidActivity.this;
                forbidActivity.showToast(forbidActivity.getPageContext().getString(R.string.forbid_success));
                ForbidActivity.this.finish();
            }

            @Override // d.a.o0.e2.f.a.a.b
            public void b(ForbidResultData forbidResultData) {
                if (forbidResultData == null) {
                    return;
                }
                String str = forbidResultData.error_msg;
                switch (forbidResultData.error_code) {
                    case NetWorkErr.ERROR_DELETE_MCN_USER_THREAD /* 1211067 */:
                    case NetWorkErr.ERROR_IS_REPEAT_FORBIDDEN /* 1211068 */:
                        if (ForbidActivity.this.mErrorDialog == null) {
                            ForbidActivity forbidActivity = ForbidActivity.this;
                            forbidActivity.mErrorDialog = new d.a.n0.r.s.a(forbidActivity.getActivity());
                        }
                        ForbidActivity.this.mErrorDialog.setMessage(str);
                        ForbidActivity.this.mErrorDialog.setPositiveButton(R.string.know, new C0206a());
                        ForbidActivity.this.mErrorDialog.setCanceledOnTouchOutside(false);
                        ForbidActivity.this.mErrorDialog.create(ForbidActivity.this.getPageContext());
                        ForbidActivity.this.mErrorDialog.show();
                        return;
                    default:
                        ForbidActivity forbidActivity2 = ForbidActivity.this;
                        forbidActivity2.showToast(forbidActivity2.getPageContext().getString(R.string.forbid_failure));
                        return;
                }
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ForbidActivity.this.mAdapter == null || k.isEmpty(ForbidActivity.this.mAdapter.b())) {
                return;
            }
            ForbidActivity forbidActivity = ForbidActivity.this;
            d.a.o0.e2.f.a.a.b(ForbidActivity.this.mForumId, ForbidActivity.this.mForumName, ForbidActivity.this.mThreadId, ForbidActivity.this.mUserName, ForbidActivity.this.mPostId, (String) forbidActivity.findViewById(forbidActivity.mForbidDays.getCheckedRadioButtonId()).getTag(), ForbidActivity.this.mAdapter.b(), ForbidActivity.this.mUserNameShow, ForbidActivity.this.mUserPortrait, new a());
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public String[] f18963e;

        /* renamed from: f  reason: collision with root package name */
        public int f18964f = 0;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f18965g = new a();

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f18964f = ((e) view.getTag()).f18969c;
                d.this.notifyDataSetChanged();
            }
        }

        public d(String[] strArr) {
            this.f18963e = strArr;
        }

        public String b() {
            int i2;
            String[] strArr = this.f18963e;
            if (strArr == null || (i2 = this.f18964f) >= strArr.length) {
                return null;
            }
            return strArr[i2];
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = this.f18963e;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return 0L;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i2, View view, ViewGroup viewGroup) {
            e eVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.forbid_list_item, (ViewGroup) null);
                eVar = new e(null);
                eVar.f18967a = (TextView) view.findViewById(R.id.reason_text);
                eVar.f18968b = (ImageView) view.findViewById(R.id.check_img);
                view.setTag(eVar);
                view.setOnClickListener(this.f18965g);
            } else {
                eVar = (e) view.getTag();
            }
            eVar.f18969c = i2;
            eVar.f18967a.setText(this.f18963e[i2]);
            if (eVar.f18969c == this.f18964f) {
                SkinManager.setImageResource(eVar.f18968b, R.drawable.icon_found_information_choose);
                eVar.f18968b.setVisibility(0);
                SkinManager.setViewTextColor(eVar.f18967a, R.color.common_color_10047, 1);
            } else {
                eVar.f18968b.setVisibility(4);
                SkinManager.setViewTextColor(eVar.f18967a, R.color.common_color_10039, 1);
            }
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public TextView f18967a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f18968b;

        /* renamed from: c  reason: collision with root package name */
        public int f18969c;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSelectedButton(int i2) {
        for (int i3 = 0; i3 < 3; i3++) {
            RadioButton radioButton = (RadioButton) this.mForbidDays.getChildAt(i3);
            if (radioButton.getId() == i2) {
                SkinManager.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_s);
                SkinManager.setViewTextColor(radioButton, R.color.CAM_X0101, 3);
            } else {
                SkinManager.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_n);
                SkinManager.setViewTextColor(radioButton, R.color.common_color_10039, 3);
            }
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.mForumId = intent.getStringExtra("forum_id");
        this.mForumName = intent.getStringExtra("forum_name");
        this.mThreadId = intent.getStringExtra("thread_id");
        this.mMgrUserID = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
        this.mUserName = intent.getStringExtra("user_name");
        this.mPostId = intent.getStringExtra("post_id");
        this.mUserNameShow = intent.getStringExtra("name_show");
        this.mUserPortrait = intent.getStringExtra("portrait");
        d.a.o0.e2.f.a.b.b(this.mForumId, this.mMgrUserID, new b());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        boolean z = i2 == 1;
        View findViewById = findViewById(R.id.root);
        getLayoutMode().k(z);
        getLayoutMode().j(findViewById);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mForbidTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        this.mListView.setDivider(SkinManager.getDrawable(R.drawable.forbid_list_divider));
        this.mListView.setDividerHeight(l.e(getPageContext().getPageActivity(), 1.0f));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_forbid_activity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setTitleText(getPageContext().getString(R.string.forbid_page_title));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mForbidTextView = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.forbid_btn_txt), this.mForbidListener);
            this.mForbidIdView = (TextView) findViewById(R.id.forbid_id);
            this.mListView = (BdListView) findViewById(R.id.listview_forbid_reason);
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.forbid_days);
            this.mForbidDays = radioGroup;
            radioGroup.setOnCheckedChangeListener(new a());
            initData();
            return;
        }
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11018)));
    }
}
