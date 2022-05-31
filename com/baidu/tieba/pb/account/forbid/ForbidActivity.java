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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.ro7;
import com.repackage.so7;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d mAdapter;
    public dq4 mErrorDialog;
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

    /* loaded from: classes3.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbidActivity a;

        public a(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbidActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, radioGroup, i) == null) {
                ForbidActivity forbidActivity = this.a;
                forbidActivity.changeSelectedButton(forbidActivity.mForbidDays.getCheckedRadioButtonId());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements so7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbidActivity a;

        public b(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbidActivity;
        }

        @Override // com.repackage.so7.b
        public void a(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, forbidTplData) == null) {
                if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    this.a.showToast(forbidTplData.error.errMsg);
                }
            }
        }

        @Override // com.repackage.so7.b
        public void b(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidTplData) == null) {
                this.a.mForbidIdView.setText(this.a.mUserNameShow);
                int i = forbidTplData.type;
                if (i == 1 || i == 2) {
                    this.a.findViewById(R.id.obfuscated_res_0x7f0919ab).setVisibility(0);
                    this.a.findViewById(R.id.obfuscated_res_0x7f0919aa).setVisibility(0);
                }
                this.a.mAdapter = new d(forbidTplData.reason);
                this.a.mListView.setAdapter((ListAdapter) this.a.mAdapter);
                String[] strArr = forbidTplData.reason;
                if (strArr == null || strArr.length == 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c4d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbidActivity a;

        /* loaded from: classes3.dex */
        public class a implements ro7.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0219a implements dq4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0219a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.repackage.dq4.e
                public void onClick(dq4 dq4Var) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || dq4Var == null) {
                        return;
                    }
                    dq4Var.dismiss();
                    this.a.a.a.getActivity().finish();
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.ro7.b
            public void a(ForbidResultData forbidResultData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, forbidResultData) == null) {
                    ForbidActivity forbidActivity = this.a.a;
                    forbidActivity.showToast(forbidActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0648));
                    this.a.a.finish();
                }
            }

            @Override // com.repackage.ro7.b
            public void b(ForbidResultData forbidResultData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidResultData) == null) || forbidResultData == null) {
                    return;
                }
                String str = forbidResultData.error_msg;
                switch (forbidResultData.error_code) {
                    case NetWorkErr.ERROR_DELETE_MCN_USER_THREAD /* 1211067 */:
                    case NetWorkErr.ERROR_IS_REPEAT_FORBIDDEN /* 1211068 */:
                        if (this.a.a.mErrorDialog == null) {
                            ForbidActivity forbidActivity = this.a.a;
                            forbidActivity.mErrorDialog = new dq4(forbidActivity.getActivity());
                        }
                        this.a.a.mErrorDialog.setMessage(str);
                        this.a.a.mErrorDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f098e, new C0219a(this));
                        this.a.a.mErrorDialog.setCanceledOnTouchOutside(false);
                        this.a.a.mErrorDialog.create(this.a.a.getPageContext());
                        this.a.a.mErrorDialog.show();
                        return;
                    default:
                        ForbidActivity forbidActivity2 = this.a.a;
                        forbidActivity2.showToast(forbidActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0646));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbidActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ForbidActivity forbidActivity;
            View findViewById;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mForbidDays == null || this.a.mAdapter == null || ki.isEmpty(this.a.mAdapter.b()) || (findViewById = (forbidActivity = this.a).findViewById(forbidActivity.mForbidDays.getCheckedRadioButtonId())) == null) {
                return;
            }
            ro7.b(this.a.mForumId, this.a.mForumName, this.a.mThreadId, this.a.mUserName, this.a.mPostId, (String) findViewById.getTag(), this.a.mAdapter.b(), this.a.mUserNameShow, this.a.mUserPortrait, new a(this));
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] a;
        public int b;
        public View.OnClickListener c;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.b = ((e) view2.getTag()).c;
                    this.a.notifyDataSetChanged();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 0;
            this.c = new a(this);
            this.a = strArr;
        }

        public String b() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.a;
                if (strArr == null || (i = this.b) >= strArr.length) {
                    return null;
                }
                return strArr[i];
            }
            return (String) invokeV.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String[] strArr = this.a;
                if (strArr == null) {
                    return 0;
                }
                return strArr.length;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0298, (ViewGroup) null);
                    eVar = new e(null);
                    eVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c7);
                    eVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905ff);
                    view2.setTag(eVar);
                    view2.setOnClickListener(this.c);
                } else {
                    eVar = (e) view2.getTag();
                }
                eVar.c = i;
                eVar.a.setText(this.a[i]);
                if (eVar.c == this.b) {
                    SkinManager.setImageResource(eVar.b, R.drawable.icon_found_information_choose);
                    eVar.b.setVisibility(0);
                    SkinManager.setViewTextColor(eVar.a, R.color.common_color_10047, 1);
                } else {
                    eVar.b.setVisibility(4);
                    SkinManager.setViewTextColor(eVar.a, R.color.common_color_10039, 1);
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public int c;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mForbidListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSelectedButton(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                RadioButton radioButton = (RadioButton) this.mForbidDays.getChildAt(i2);
                if (radioButton.getId() == i) {
                    SkinManager.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_s);
                    SkinManager.setViewTextColor(radioButton, R.color.CAM_X0101, 3);
                } else {
                    SkinManager.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_n);
                    SkinManager.setViewTextColor(radioButton, R.color.common_color_10039, 3);
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
            so7.b(this.mForumId, this.mMgrUserID, new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            boolean z = i == 1;
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091ac5);
            getLayoutMode().k(z);
            getLayoutMode().j(findViewById);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mForbidTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            this.mListView.setDivider(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08056f));
            this.mListView.setDividerHeight(li.d(getPageContext().getPageActivity(), 1.0f));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0021);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
                this.mNavigationBar = navigationBar;
                navigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0647));
                this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.mForbidTextView = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f0645), this.mForbidListener);
                this.mForbidIdView = (TextView) findViewById(R.id.obfuscated_res_0x7f0909f9);
                this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09124f);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.obfuscated_res_0x7f0909f8);
                this.mForbidDays = radioGroup;
                radioGroup.setOnCheckedChangeListener(new a(this));
                initData();
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11018)));
        }
    }
}
