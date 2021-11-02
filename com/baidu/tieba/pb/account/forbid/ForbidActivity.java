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
import b.a.e.e.p.k;
import b.a.q0.s.s.a;
import b.a.r0.k2.f;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import b.a.r0.k2.p.a.a;
import b.a.r0.k2.p.a.b;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d mAdapter;
    public b.a.q0.s.s.a mErrorDialog;
    public RadioGroup mForbidDays;
    public TextView mForbidIdView;
    public View.OnClickListener mForbidListener;
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

    /* loaded from: classes9.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbidActivity f52093e;

        public a(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52093e = forbidActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, radioGroup, i2) == null) {
                ForbidActivity forbidActivity = this.f52093e;
                forbidActivity.changeSelectedButton(forbidActivity.mForbidDays.getCheckedRadioButtonId());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.InterfaceC0945b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForbidActivity f52094a;

        public b(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52094a = forbidActivity;
        }

        @Override // b.a.r0.k2.p.a.b.InterfaceC0945b
        public void a(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, forbidTplData) == null) {
                if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                    this.f52094a.showToast(l.neterror);
                } else {
                    this.f52094a.showToast(forbidTplData.error.errMsg);
                }
            }
        }

        @Override // b.a.r0.k2.p.a.b.InterfaceC0945b
        public void b(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidTplData) == null) {
                this.f52094a.mForbidIdView.setText(this.f52094a.mUserNameShow);
                int i2 = forbidTplData.type;
                if (i2 == 1 || i2 == 2) {
                    this.f52094a.findViewById(i.radio_forbid_3).setVisibility(0);
                    this.f52094a.findViewById(i.radio_forbid_10).setVisibility(0);
                }
                this.f52094a.mAdapter = new d(forbidTplData.reason);
                this.f52094a.mListView.setAdapter((ListAdapter) this.f52094a.mAdapter);
                String[] strArr = forbidTplData.reason;
                if (strArr == null || strArr.length == 0) {
                    this.f52094a.showToast(l.no_data_text);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbidActivity f52095e;

        /* loaded from: classes9.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f52096a;

            /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1748a implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f52097e;

                public C1748a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52097e = aVar;
                }

                @Override // b.a.q0.s.s.a.e
                public void onClick(b.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                        return;
                    }
                    aVar.dismiss();
                    this.f52097e.f52096a.f52095e.getActivity().finish();
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52096a = cVar;
            }

            @Override // b.a.r0.k2.p.a.a.b
            public void a(ForbidResultData forbidResultData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, forbidResultData) == null) {
                    ForbidActivity forbidActivity = this.f52096a.f52095e;
                    forbidActivity.showToast(forbidActivity.getPageContext().getString(l.forbid_success));
                    this.f52096a.f52095e.finish();
                }
            }

            @Override // b.a.r0.k2.p.a.a.b
            public void b(ForbidResultData forbidResultData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidResultData) == null) || forbidResultData == null) {
                    return;
                }
                String str = forbidResultData.error_msg;
                switch (forbidResultData.error_code) {
                    case NetWorkErr.ERROR_DELETE_MCN_USER_THREAD /* 1211067 */:
                    case NetWorkErr.ERROR_IS_REPEAT_FORBIDDEN /* 1211068 */:
                        if (this.f52096a.f52095e.mErrorDialog == null) {
                            ForbidActivity forbidActivity = this.f52096a.f52095e;
                            forbidActivity.mErrorDialog = new b.a.q0.s.s.a(forbidActivity.getActivity());
                        }
                        this.f52096a.f52095e.mErrorDialog.setMessage(str);
                        this.f52096a.f52095e.mErrorDialog.setPositiveButton(l.know, new C1748a(this));
                        this.f52096a.f52095e.mErrorDialog.setCanceledOnTouchOutside(false);
                        this.f52096a.f52095e.mErrorDialog.create(this.f52096a.f52095e.getPageContext());
                        this.f52096a.f52095e.mErrorDialog.show();
                        return;
                    default:
                        ForbidActivity forbidActivity2 = this.f52096a.f52095e;
                        forbidActivity2.showToast(forbidActivity2.getPageContext().getString(l.forbid_failure));
                        return;
                }
            }
        }

        public c(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52095e = forbidActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForbidActivity forbidActivity;
            View findViewById;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52095e.mForbidDays == null || this.f52095e.mAdapter == null || k.isEmpty(this.f52095e.mAdapter.b()) || (findViewById = (forbidActivity = this.f52095e).findViewById(forbidActivity.mForbidDays.getCheckedRadioButtonId())) == null) {
                return;
            }
            b.a.r0.k2.p.a.a.b(this.f52095e.mForumId, this.f52095e.mForumName, this.f52095e.mThreadId, this.f52095e.mUserName, this.f52095e.mPostId, (String) findViewById.getTag(), this.f52095e.mAdapter.b(), this.f52095e.mUserNameShow, this.f52095e.mUserPortrait, new a(this));
        }
    }

    /* loaded from: classes9.dex */
    public static class d extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String[] f52098e;

        /* renamed from: f  reason: collision with root package name */
        public int f52099f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f52100g;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f52101e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52101e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f52101e.f52099f = ((e) view.getTag()).f52104c;
                    this.f52101e.notifyDataSetChanged();
                }
            }
        }

        public d(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52099f = 0;
            this.f52100g = new a(this);
            this.f52098e = strArr;
        }

        public String b() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.f52098e;
                if (strArr == null || (i2 = this.f52099f) >= strArr.length) {
                    return null;
                }
                return strArr[i2];
            }
            return (String) invokeV.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String[] strArr = this.f52098e;
                if (strArr == null) {
                    return 0;
                }
                return strArr.length;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(j.forbid_list_item, (ViewGroup) null);
                    eVar = new e(null);
                    eVar.f52102a = (TextView) view.findViewById(i.reason_text);
                    eVar.f52103b = (ImageView) view.findViewById(i.check_img);
                    view.setTag(eVar);
                    view.setOnClickListener(this.f52100g);
                } else {
                    eVar = (e) view.getTag();
                }
                eVar.f52104c = i2;
                eVar.f52102a.setText(this.f52098e[i2]);
                if (eVar.f52104c == this.f52099f) {
                    SkinManager.setImageResource(eVar.f52103b, h.icon_found_information_choose);
                    eVar.f52103b.setVisibility(0);
                    SkinManager.setViewTextColor(eVar.f52102a, f.common_color_10047, 1);
                } else {
                    eVar.f52103b.setVisibility(4);
                    SkinManager.setViewTextColor(eVar.f52102a, f.common_color_10039, 1);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f52102a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f52103b;

        /* renamed from: c  reason: collision with root package name */
        public int f52104c;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public ForbidActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mForbidListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSelectedButton(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            for (int i3 = 0; i3 < 3; i3++) {
                RadioButton radioButton = (RadioButton) this.mForbidDays.getChildAt(i3);
                if (radioButton.getId() == i2) {
                    SkinManager.setBackgroundResource(radioButton, h.btn_prohibit_day_s);
                    SkinManager.setViewTextColor(radioButton, f.CAM_X0101, 3);
                } else {
                    SkinManager.setBackgroundResource(radioButton, h.btn_prohibit_day_n);
                    SkinManager.setViewTextColor(radioButton, f.common_color_10039, 3);
                }
            }
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            Intent intent = getIntent();
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.mThreadId = intent.getStringExtra("thread_id");
            this.mMgrUserID = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
            this.mUserName = intent.getStringExtra("user_name");
            this.mPostId = intent.getStringExtra("post_id");
            this.mUserNameShow = intent.getStringExtra("name_show");
            this.mUserPortrait = intent.getStringExtra("portrait");
            b.a.r0.k2.p.a.b.b(this.mForumId, this.mMgrUserID, new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z = i2 == 1;
            View findViewById = findViewById(i.root);
            getLayoutMode().k(z);
            getLayoutMode().j(findViewById);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mForbidTextView.setTextColor(SkinManager.getColor(f.CAM_X0106));
            this.mListView.setDivider(SkinManager.getDrawable(h.forbid_list_divider));
            this.mListView.setDividerHeight(b.a.e.e.p.l.e(getPageContext().getPageActivity(), 1.0f));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(j.account_forbid_activity);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                NavigationBar navigationBar = (NavigationBar) findViewById(i.view_navigation_bar);
                this.mNavigationBar = navigationBar;
                navigationBar.setTitleText(getPageContext().getString(l.forbid_page_title));
                this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.mForbidTextView = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(l.forbid_btn_txt), this.mForbidListener);
                this.mForbidIdView = (TextView) findViewById(i.forbid_id);
                this.mListView = (BdListView) findViewById(i.listview_forbid_reason);
                RadioGroup radioGroup = (RadioGroup) findViewById(i.forbid_days);
                this.mForbidDays = radioGroup;
                radioGroup.setOnCheckedChangeListener(new a(this));
                initData();
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11018)));
        }
    }
}
