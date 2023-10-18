package com.baidu.tieba.memberCenter.bubble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.a59;
import com.baidu.tieba.b59;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.z49;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a59 a;
    public BubbleListModel b;
    public BubbleListModel.c c;
    public BubbleListModel.d d;
    public b59.e e;
    public b59.e f;
    public CustomMessageListener g;

    /* loaded from: classes7.dex */
    public class a implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        public a(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bubbleChooseActivity;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bubbleListData) == null) {
                this.a.a.x();
                this.a.a.y(null, false);
                if (bubbleListData != null) {
                    if (!bubbleListData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                            this.a.showToast(bubbleListData.getError_msg());
                            return;
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                            return;
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                this.a.a.x();
                if (bubbleListData == null) {
                    return;
                }
                this.a.a.y(bubbleListData.getB_info(), BubbleListModel.P(bubbleListData.getB_info()));
                if (this.a.b.R() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == this.a.b.R()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            this.a.b.X(this.a.b.R());
                            this.a.b.W(this.a.b.R(), BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity()), BdUtilHelper.getEquipmentHeight(this.a.getPageContext().getPageActivity()));
                        }
                    }
                    this.a.b.Y(-1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        public b(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bubbleChooseActivity;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, setBubbleResultData) == null) {
                this.a.a.x();
                int Q = this.a.b.Q();
                z49 f = this.a.a.f();
                if (Q == 0) {
                    f.d(true);
                    for (BubbleListData.BubbleData bubbleData : f.b()) {
                        if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                            bubbleData.setIs_def(0);
                        }
                    }
                    f.notifyDataSetChanged();
                } else if (setBubbleResultData.getB_info().canUser()) {
                    for (BubbleListData.BubbleData bubbleData2 : f.b()) {
                        if (bubbleData2.getBcode() == Q) {
                            bubbleData2.setIs_def(1);
                        } else if (bubbleData2.isDef()) {
                            bubbleData2.setIs_def(0);
                        }
                    }
                    f.d(false);
                    f.notifyDataSetChanged();
                } else {
                    this.a.showToast(R.string.setdefualt_error);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                this.a.a.x();
                if (setBubbleResultData != null) {
                    if (!setBubbleResultData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                            this.a.showToast(setBubbleResultData.getError_msg());
                            return;
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                            return;
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements b59.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        @Override // com.baidu.tieba.b59.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bubbleChooseActivity;
        }

        @Override // com.baidu.tieba.b59.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.U0(i);
            this.a.a.z();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements b59.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        @Override // com.baidu.tieba.b59.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bubbleChooseActivity;
        }

        @Override // com.baidu.tieba.b59.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "consume_19", "click");
                this.a.b.Y(i);
                PayPanelUtils.b bVar = new PayPanelUtils.b();
                bVar.i(IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION);
                bVar.g(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE);
                bVar.f(MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                bVar.h(23004);
                PayPanelUtils.launchPayPanel(this.a.getPageContext(), bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(BubbleChooseActivity bubbleChooseActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity, Integer.valueOf(i)};
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
            this.a = bubbleChooseActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.S0();
            }
        }
    }

    public BubbleChooseActivity() {
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
        this.c = new a(this);
        this.d = new b(this);
        this.e = new c(this);
        this.f = new d(this);
        this.g = new e(this, 2010040);
    }

    public final void U0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b.W(i, BdUtilHelper.getEquipmentWidth(getPageContext().getPageActivity()), BdUtilHelper.getEquipmentHeight(getPageContext().getPageActivity()));
            this.b.X(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            initView();
            S0();
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.V(0, 50, BdUtilHelper.getEquipmentWidth(getPageContext().getPageActivity()), BdUtilHelper.getEquipmentHeight(getPageContext().getPageActivity()));
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.S();
            this.b.T();
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BubbleListModel bubbleListModel = new BubbleListModel(getPageContext());
            this.b = bubbleListModel;
            bubbleListModel.Z(this.c);
            this.b.a0(this.d);
            this.b.U(this.g);
            T0();
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a59 a59Var = new a59(getPageContext());
            this.a = a59Var;
            a59Var.t().setOnItemClickListener(this);
            this.a.z();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            BubbleListModel bubbleListModel = this.b;
            if (bubbleListModel != null) {
                bubbleListModel.unRegisterListener();
                this.b.b0(this.g);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 23004) {
                S0();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.g()) {
                Activity pageActivity = getPageContext().getPageActivity();
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f1884);
                BrowserHelper.startWebActivity(pageActivity, string, TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, true, true);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        BubbleListData.BubbleData u;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.onItemClick(adapterView, view2, i, j);
            if (adapterView == this.a.t() && view2 != null && (view2 instanceof BubbleView) && (u = this.a.u(i)) != null) {
                if (u.getBcode() != 0 && !u.canUse()) {
                    if (u.isFree()) {
                        b59.a(getPageContext(), u, this.e);
                        return;
                    } else {
                        b59.b(getPageContext(), u, this.f);
                        return;
                    }
                }
                U0(u.getBcode());
                this.a.z();
            }
        }
    }
}
