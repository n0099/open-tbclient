package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b85;
import com.repackage.dr4;
import com.repackage.e85;
import com.repackage.oi;
import com.repackage.wt4;
import com.repackage.y75;
import com.repackage.zj7;
import com.repackage.zw4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayFragmentActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String MEMBER_PAY_CLICK;
    public String MEMBER_PAY_VISIT;
    public int fromScene;
    public final CustomMessageListener mAutoPaySuccListener;
    public ImageView mBtnClose;
    public String mClickZone;
    public int mCurrentIndex;
    public int mCurrentShowType;
    public MemberPayListAdapter mFragmentAdapter;
    public int mFrom;
    public HttpMessageListener mGetMemberPayinfoListener;
    public boolean mHasInit;
    public IndicatorView mIndicator;
    public LinearLayout mIndicatorLayout;
    public boolean mIsClose;
    public Boolean mIsPayDialog;
    public RelativeLayout mNavigationBar;
    public PayConfigModel mPayConfigModel;
    public String mReferPage;
    public HttpMessageListener mRequestMemberPayInfoListener;
    public String mSceneId;
    public String mStType;
    public FragmentTabHost mTabHost;
    public View mTopTranslateView;
    public ImageView mTvIcon;
    public TextView mTvTitle;
    public int mWantedMemberType;
    public RelativeLayout mainContainer;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MemberPayFragmentActivity memberPayFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505 && (httpResponsedMessage instanceof ResponseGetPayinfoMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0) {
                    ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                    if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (pay_status != 1 && pay_status == 3) {
                            }
                            return;
                        }
                        this.a.addPaySussStats();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(this.a.mCurrentShowType)));
                        this.a.setResult(-1);
                        wt4.k().u("show_member_deid_line", true);
                        if (!this.a.mIsClose) {
                            this.a.requestMemberPayInfo();
                        } else {
                            this.a.finish();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MemberPayFragmentActivity memberPayFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                    ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        if (responseMemberPayMessage.getMemberPayResult() != null) {
                            zj7 memberPayResult = responseMemberPayMessage.getMemberPayResult();
                            this.a.initFragment(memberPayResult);
                            if (this.a.mFragmentAdapter != null) {
                                int count = this.a.mFragmentAdapter.getCount();
                                for (int i = 0; i < count; i++) {
                                    this.a.mFragmentAdapter.getItem(i).C0(memberPayResult);
                                }
                                return;
                            }
                            return;
                        }
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                        return;
                    }
                    String errorString = responseMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c18);
                    }
                    this.a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MemberPayFragmentActivity memberPayFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && this.a.mFragmentAdapter != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                int count = this.a.mFragmentAdapter.getCount();
                for (int i = 0; i < count; i++) {
                    this.a.mFragmentAdapter.getItem(i).B0(bool);
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f13e7);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public d(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.userConfirmDialog();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public e(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.userConfirmDialog();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public f(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // com.repackage.b85
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e85 c = e85.c();
                c.b("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + this.a.mReferPage + "&click_zone=" + this.a.mClickZone, this.a.getPageContext());
                this.a.finish();
            }
        }

        @Override // com.repackage.b85
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.requestMemberPayInfo();
            }
        }

        @Override // com.repackage.b85
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.requestMemberPayInfo();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public g(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public h(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 0));
                dr4Var.dismiss();
                if (this.a.mTopTranslateView != null) {
                    this.a.mTopTranslateView.setBackgroundColor(this.a.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
                }
                this.a.finish();
            }
        }
    }

    public MemberPayFragmentActivity() {
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
        this.mCurrentIndex = 0;
        this.mHasInit = false;
        this.mIsPayDialog = Boolean.FALSE;
        this.MEMBER_PAY_VISIT = "c10482";
        this.MEMBER_PAY_CLICK = "c10483";
        this.mGetMemberPayinfoListener = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.mRequestMemberPayInfoListener = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);
        this.mAutoPaySuccListener = new c(this, 2016525);
    }

    private void addOpenPageStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            int i = this.mFrom;
            if (i == 6) {
                TiebaStatic.log("consume_24");
            } else if (i == 2) {
                TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
            } else if (i == 4) {
                TiebaStatic.log("c10751");
            } else if (i == 5) {
                TiebaStatic.log("c10750");
            } else if (i == 26) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW).param("obj_source", 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaySussStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            int i = this.mFrom;
            if (i == 2) {
                addStat("consume_10");
            } else if (i == 1) {
                addStat("consume_5");
            } else if (i == 3) {
                addStat("consume_35");
            } else if (i == 4) {
                TiebaStatic.log("c10032");
            } else if (i == 5) {
                TiebaStatic.log("c10039");
            } else if (i == 6) {
                TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
            } else if (i == 7) {
                TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
            }
        }
    }

    private void addStat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click");
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65550, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.c = fragment;
        bVar.a = i;
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.b = fragmentTabIndicator;
        this.mTabHost.c(bVar);
    }

    private String getTabNameByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i)) == null) {
            if (i != 2) {
                return getResources().getString(R.string.obfuscated_res_0x7f0f136e);
            }
            return getResources().getString(R.string.obfuscated_res_0x7f0f1371);
        }
        return (String) invokeI.objValue;
    }

    private void handleIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.mWantedMemberType = getIntent().getExtras().getInt("member_type");
                this.mStType = getIntent().getExtras().getString("st_type");
                this.mFrom = getIntent().getExtras().getInt("from", 0);
                this.mIsClose = getIntent().getExtras().getBoolean("close");
                this.fromScene = getIntent().getExtras().getInt(MemberPayActivityConfig.FROM_SCENE, 0);
                this.mSceneId = getIntent().getExtras().getString("scene_id");
            }
            int i = this.fromScene;
            if (i == 3) {
                this.mSceneId = "4001001001";
            } else if (i == 4) {
                this.mSceneId = "4001001002";
            }
            if (StringUtils.isNull(this.mSceneId)) {
                this.mSceneId = "4008001000";
            }
            this.mReferPage = getIntent().getExtras().getString(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = getIntent().getExtras().getString(MemberPayStatistic.CLICK_ZONE);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            registerGetMemberPayInfoTask();
            PayConfigModel payConfigModel = new PayConfigModel(getPageContext(), new f(this));
            this.mPayConfigModel = payConfigModel;
            payConfigModel.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initFragment(zj7 zj7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, zj7Var) == null) || this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        boolean z = zj7Var.a.c.a == 2 || this.mWantedMemberType == 2;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString("member_refer_page", this.mReferPage);
        bundle.putString("member_click_zone", this.mClickZone);
        bundle.putBoolean("member_is_pay_dialog", this.mIsPayDialog.booleanValue());
        bundle.putInt("member_from_type", this.mFrom);
        if (!z) {
            zj7.b bVar = zj7Var.b;
            if (bVar.a != null) {
                if (bVar.b == null) {
                    MemberPayFragment memberPayFragment = new MemberPayFragment();
                    bundle.putInt("member_type", 1);
                    this.mCurrentShowType = 1;
                    memberPayFragment.setArguments(bundle);
                    arrayList.add(memberPayFragment);
                } else {
                    MemberPayFragment memberPayFragment2 = new MemberPayFragment();
                    Bundle bundle2 = (Bundle) bundle.clone();
                    bundle2.putInt("member_type", 2);
                    this.mCurrentShowType = 2;
                    memberPayFragment2.setArguments(bundle2);
                    arrayList.add(memberPayFragment2);
                    MemberPayFragment memberPayFragment3 = new MemberPayFragment();
                    Bundle bundle3 = (Bundle) bundle.clone();
                    bundle3.putInt("member_type", 1);
                    memberPayFragment3.setArguments(bundle3);
                    arrayList.add(memberPayFragment3);
                }
                if (this.mFragmentAdapter != null) {
                    this.mFragmentAdapter = new MemberPayListAdapter(getSupportFragmentManager());
                    initTabSpec(arrayList);
                    initIndicator(this.mFragmentAdapter.getCount());
                    this.mTabHost.setCurrentTab(0);
                    return;
                }
                return;
            }
        }
        MemberPayFragment memberPayFragment4 = new MemberPayFragment();
        bundle.putInt("member_type", 2);
        this.mCurrentShowType = 2;
        memberPayFragment4.setArguments(bundle);
        arrayList.add(memberPayFragment4);
        if (this.mFragmentAdapter != null) {
        }
    }

    private void initIndicator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i) == null) {
            if (i >= 2) {
                this.mIndicatorLayout.setVisibility(0);
            } else {
                this.mIndicatorLayout.setVisibility(4);
            }
            this.mIndicator.setCount(i);
            updateIndicatorAndTabs();
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            registerListener(this.mRequestMemberPayInfoListener);
            registerListener(this.mGetMemberPayinfoListener);
            registerListener(this.mAutoPaySuccListener);
        }
    }

    private void initTabSpec(List<MemberPayFragment> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, list) == null) {
            this.mFragmentAdapter.c(list);
            int count = this.mFragmentAdapter.getCount();
            for (int i = 0; i < count; i++) {
                createAndAddTabSpec(this.mFragmentAdapter.getItem(i), i, getTabNameByType(this.mFragmentAdapter.getItem(i).getType()));
            }
            this.mTabHost.o();
            this.mTabHost.f(0);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d053e);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0920b4);
            this.mTopTranslateView = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.mainContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091364);
            this.mNavigationBar = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091514);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090404);
            this.mBtnClose = imageView;
            imageView.setOnClickListener(new e(this));
            this.mTvIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f09214d);
            this.mTvTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f09215b);
            this.mIndicatorLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090eee);
            this.mIndicator = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f0913dc);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091e2f);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.setTabWidgetViewHeight(0);
            this.mTabHost.u();
            this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
            this.mTabHost.getFragmentTabWidget().setDviderRectHeight(oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070224));
        }
    }

    private void registerGetMemberPayInfoTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
            tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestMemberPayInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
            String str = this.mStType;
            if (str != null) {
                httpMessage.addParam("st_type", str);
            }
            httpMessage.addParam(MemberPayActivityConfig.FROM_SCENE, this.fromScene);
            sendMessage(httpMessage);
        }
    }

    private void updateIndicatorAndTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.mIndicator.setPosition(this.mCurrentIndex);
            this.mTvTitle.setText(getTabNameByType(this.mCurrentShowType));
            if (this.mCurrentShowType == 2) {
                SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_supervip, TbadkCoreApplication.getInst().getSkinType());
            } else {
                SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_commonvip, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userConfirmDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            dr4 dr4Var = new dr4(getPageContext().getPageActivity());
            dr4Var.setAutoNight(true);
            dr4Var.setCancelable(true);
            dr4Var.setTitleShowCenter(true);
            dr4Var.setMessageShowCenter(true);
            dr4Var.setTitle(getString(R.string.obfuscated_res_0x7f0f136a));
            dr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f1368));
            dr4Var.setPositiveButton(getString(R.string.obfuscated_res_0x7f0f07aa), new g(this));
            dr4Var.setNegativeButton(getString(R.string.obfuscated_res_0x7f0f1369), new h(this));
            dr4Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b001" : (String) invokeV.objValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFrom : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public y75 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (y75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0201);
            SkinManager.setImageResource(this.mBtnClose, R.drawable.icon_tbvip_close_black, i);
            SkinManager.setViewTextColor(this.mTvTitle, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.mainContainer, R.color.CAM_X0201);
            if (this.mCurrentShowType == 2) {
                SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_supervip, i);
            } else {
                SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_commonvip, i);
            }
            this.mIndicator.setSelector(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
            this.mIndicator.setDrawable(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
            SkinManager.setBackgroundColor(this.mIndicatorLayout, R.color.CAM_X0201);
            MemberPayListAdapter memberPayListAdapter = this.mFragmentAdapter;
            if (memberPayListAdapter != null) {
                int count = memberPayListAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    this.mFragmentAdapter.getItem(i2).changeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            TiebaStatic.log(this.MEMBER_PAY_VISIT);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getActivity());
                finish();
                return;
            }
            handleIntent();
            zw4 consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
            if (consumePathData != null) {
                this.mIsPayDialog = Boolean.valueOf(consumePathData.b(1, this.mSceneId));
            }
            initView();
            initListener();
            initData();
            addOpenPageStats();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PayConfigModel payConfigModel = this.mPayConfigModel;
            if (payConfigModel != null) {
                payConfigModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            if (i == 4) {
                userConfirmDialog();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mCurrentIndex = i;
            MemberPayListAdapter memberPayListAdapter = this.mFragmentAdapter;
            if (memberPayListAdapter != null) {
                this.mCurrentShowType = memberPayListAdapter.getItem(i).getType();
            }
            updateIndicatorAndTabs();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01002c, R.anim.obfuscated_res_0x7f010036);
        }
    }
}
