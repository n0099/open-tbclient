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
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
import b.a.q0.t.c.v;
import b.a.r0.y1.f.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51564a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MemberPayFragmentActivity memberPayFragmentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51564a = memberPayFragmentActivity;
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
                        this.f51564a.addPaySussStats();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(this.f51564a.mCurrentShowType)));
                        this.f51564a.setResult(-1);
                        b.a.q0.s.e0.b.j().t("show_member_deid_line", true);
                        if (!this.f51564a.mIsClose) {
                            this.f51564a.requestMemberPayInfo();
                        } else {
                            this.f51564a.finish();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51565a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MemberPayFragmentActivity memberPayFragmentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51565a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f51565a.closeLoadingDialog();
                if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                    ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        if (responseMemberPayMessage.getMemberPayResult() != null) {
                            b.a.r0.y1.f.f memberPayResult = responseMemberPayMessage.getMemberPayResult();
                            this.f51565a.initFragment(memberPayResult);
                            if (this.f51565a.mFragmentAdapter != null) {
                                int count = this.f51565a.mFragmentAdapter.getCount();
                                for (int i2 = 0; i2 < count; i2++) {
                                    this.f51565a.mFragmentAdapter.getItem(i2).setDataAndRefreshUI(memberPayResult);
                                }
                                return;
                            }
                            return;
                        }
                        this.f51565a.showToast(R.string.neterror);
                        return;
                    }
                    String errorString = responseMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.f51565a.getResources().getString(R.string.neterror);
                    }
                    this.f51565a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51566a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MemberPayFragmentActivity memberPayFragmentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51566a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && this.f51566a.mFragmentAdapter != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                int count = this.f51566a.mFragmentAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    this.f51566a.mFragmentAdapter.getItem(i2).refreshAutoPayItemUI(bool);
                }
                this.f51566a.showToast(R.string.tips_auto_pay_succ);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51567e;

        public d(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51567e = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51567e.userConfirmDialog();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51568e;

        public e(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51568e = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51568e.userConfirmDialog();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a.q0.p0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51569a;

        public f(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51569a = memberPayFragmentActivity;
        }

        @Override // b.a.q0.p0.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.q0.p0.d c2 = b.a.q0.p0.d.c();
                c2.b("http://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + this.f51569a.mReferPage + "&click_zone=" + this.f51569a.mClickZone, this.f51569a.getPageContext());
                this.f51569a.finish();
            }
        }

        @Override // b.a.q0.p0.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f51569a.requestMemberPayInfo();
            }
        }

        @Override // b.a.q0.p0.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f51569a.requestMemberPayInfo();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51570e;

        public g(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51570e = memberPayFragmentActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberPayFragmentActivity f51571e;

        public h(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51571e = memberPayFragmentActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 0));
                aVar.dismiss();
                if (this.f51571e.mTopTranslateView != null) {
                    this.f51571e.mTopTranslateView.setBackgroundColor(this.f51571e.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
                }
                this.f51571e.finish();
            }
        }
    }

    public MemberPayFragmentActivity() {
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
            int i2 = this.mFrom;
            if (i2 == 6) {
                TiebaStatic.log("consume_24");
            } else if (i2 == 2) {
                TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
            } else if (i2 == 4) {
                TiebaStatic.log("c10751");
            } else if (i2 == 5) {
                TiebaStatic.log("c10750");
            } else if (i2 == 26) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW).param("obj_source", 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaySussStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            int i2 = this.mFrom;
            if (i2 == 2) {
                addStat("consume_10");
            } else if (i2 == 1) {
                addStat("consume_5");
            } else if (i2 == 3) {
                addStat("consume_35");
            } else if (i2 == 4) {
                TiebaStatic.log("c10032");
            } else if (i2 == 5) {
                TiebaStatic.log("c10039");
            } else if (i2 == 6) {
                TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
            } else if (i2 == 7) {
                TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
            }
        }
    }

    private void addStat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, PrefetchEvent.STATE_CLICK);
        }
    }

    private void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65550, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.f45185c = fragment;
        bVar.f45183a = i2;
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.dayTextColorResId = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f45184b = fragmentTabIndicator;
        this.mTabHost.addTabSpec(bVar);
    }

    private String getTabNameByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i2)) == null) {
            if (i2 != 2) {
                return getResources().getString(R.string.tb_normal_member_title);
            }
            return getResources().getString(R.string.tb_vip_member_title);
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
                this.mIsClose = getIntent().getExtras().getBoolean(IntentConfig.CLOSE);
                this.fromScene = getIntent().getExtras().getInt("from_scene", 0);
                this.mSceneId = getIntent().getExtras().getString("scene_id");
            }
            int i2 = this.fromScene;
            if (i2 == 3) {
                this.mSceneId = "4001001001";
            } else if (i2 == 4) {
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
            payConfigModel.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initFragment(b.a.r0.y1.f.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, fVar) == null) || this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        boolean z = fVar.f27565a.f27592c.f27588a == 2 || this.mWantedMemberType == 2;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString(MemberPayFragment.MEMBER_REFER_PAGE, this.mReferPage);
        bundle.putString(MemberPayFragment.MEMBER_CLICK_ZONE, this.mClickZone);
        bundle.putBoolean(MemberPayFragment.MEMBER_IS_PAY_DIALOG, this.mIsPayDialog.booleanValue());
        bundle.putInt(MemberPayFragment.MEMBER_FROM_TYPE, this.mFrom);
        if (!z) {
            f.b bVar = fVar.f27566b;
            if (bVar.f27572a != null) {
                if (bVar.f27573b == null) {
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

    private void initIndicator(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            if (i2 >= 2) {
                this.mIndicatorLayout.setVisibility(0);
            } else {
                this.mIndicatorLayout.setVisibility(4);
            }
            this.mIndicator.setCount(i2);
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
            this.mFragmentAdapter.setFragments(list);
            int count = this.mFragmentAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                createAndAddTabSpec(this.mFragmentAdapter.getItem(i2), i2, getTabNameByType(this.mFragmentAdapter.getItem(i2).getType()));
            }
            this.mTabHost.initViewPagerWithNoType();
            this.mTabHost.changeStyle(0);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            showLoadingDialog(getPageContext().getString(R.string.flist_loading));
            setContentView(R.layout.member_pay_fragment_activity);
            View findViewById = findViewById(R.id.top_translate_view);
            this.mTopTranslateView = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.mainContainer = (RelativeLayout) findViewById(R.id.mainContainer);
            this.mNavigationBar = (RelativeLayout) findViewById(R.id.navigation_bar);
            ImageView imageView = (ImageView) findViewById(R.id.btnClose);
            this.mBtnClose = imageView;
            imageView.setOnClickListener(new e(this));
            this.mTvIcon = (ImageView) findViewById(R.id.tvIcon);
            this.mTvTitle = (TextView) findViewById(R.id.tvTitle);
            this.mIndicatorLayout = (LinearLayout) findViewById(R.id.indicator_parent_view);
            this.mIndicator = (IndicatorView) findViewById(R.id.member_tab_indicator);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.setTabWidgetViewHeight(0);
            this.mTabHost.reset();
            this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
            this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.ds4));
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
            httpMessage.addParam("from_scene", this.fromScene);
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
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setAutoNight(true);
            aVar.setCancelable(true);
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setTitle(getString(R.string.tb_member_confirm_dialog_title));
            aVar.setMessage(getString(R.string.tb_member_confirm_dialog_msg));
            aVar.setPositiveButton(getString(R.string.go_on), new g(this));
            aVar.setNegativeButton(getString(R.string.tb_member_confirm_dialog_quit), new h(this));
            aVar.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, b.a.q0.o0.a
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
    public b.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.f12779a = true;
            }
            return pageStayDurationItem;
        }
        return (b.a.q0.o0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0201);
            SkinManager.setImageResource(this.mBtnClose, R.drawable.icon_tbvip_close_black, i2);
            SkinManager.setViewTextColor(this.mTvTitle, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.mainContainer, R.color.CAM_X0201);
            if (this.mCurrentShowType == 2) {
                SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_supervip, i2);
            } else {
                SkinManager.setImageResource(this.mTvIcon, R.drawable.icon_tbvip_commonvip, i2);
            }
            this.mIndicator.setSelector(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
            this.mIndicator.setDrawable(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
            SkinManager.setBackgroundColor(this.mIndicatorLayout, R.color.CAM_X0201);
            MemberPayListAdapter memberPayListAdapter = this.mFragmentAdapter;
            if (memberPayListAdapter != null) {
                int count = memberPayListAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    this.mFragmentAdapter.getItem(i3).changeSkinType(i2);
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
            v consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                userConfirmDialog();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mCurrentIndex = i2;
            MemberPayListAdapter memberPayListAdapter = this.mFragmentAdapter;
            if (memberPayListAdapter != null) {
                this.mCurrentShowType = memberPayListAdapter.getItem(i2).getType();
            }
            updateIndicatorAndTabs();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.anim_alpha_0_to_1_duration_300, R.anim.anim_alpha_1_to_0_duration_300);
        }
    }
}
