package com.baidu.tieba.memberCenter.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.pt4;
import com.baidu.tieba.vm8;
import com.baidu.tieba.wm8;
import com.baidu.tieba.xm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wm8 a;
    public BubbleListModel b;
    public BubbleListModel.c c;
    public BubbleListModel.d d;
    public xm8.e e;
    public xm8.e f;
    public CustomMessageListener g;

    /* loaded from: classes5.dex */
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
                this.a.a.A();
                this.a.a.B(null, false);
                if (bubbleListData != null) {
                    if (!bubbleListData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                            this.a.showToast(bubbleListData.getError_msg());
                            return;
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                            return;
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                this.a.a.A();
                if (bubbleListData == null) {
                    return;
                }
                this.a.a.B(bubbleListData.getB_info(), BubbleListModel.X(bubbleListData.getB_info()));
                if (this.a.b.Z() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == this.a.b.Z()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            this.a.b.f0(this.a.b.Z());
                            this.a.b.e0(this.a.b.Z(), ii.l(this.a.getPageContext().getPageActivity()), ii.j(this.a.getPageContext().getPageActivity()));
                        }
                    }
                    this.a.b.g0(-1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.a.A();
                int Y = this.a.b.Y();
                vm8 u = this.a.a.u();
                if (Y == 0) {
                    u.d(true);
                    for (BubbleListData.BubbleData bubbleData : u.b()) {
                        if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                            bubbleData.setIs_def(0);
                        }
                    }
                    u.notifyDataSetChanged();
                } else if (setBubbleResultData.getB_info().canUser()) {
                    for (BubbleListData.BubbleData bubbleData2 : u.b()) {
                        if (bubbleData2.getBcode() == Y) {
                            bubbleData2.setIs_def(1);
                        } else if (bubbleData2.isDef()) {
                            bubbleData2.setIs_def(0);
                        }
                    }
                    u.d(false);
                    u.notifyDataSetChanged();
                } else {
                    this.a.showToast(R.string.setdefualt_error);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                this.a.a.A();
                if (setBubbleResultData != null) {
                    if (!setBubbleResultData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                            this.a.showToast(setBubbleResultData.getError_msg());
                            return;
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                            return;
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements xm8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        @Override // com.baidu.tieba.xm8.e
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

        @Override // com.baidu.tieba.xm8.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.D1(i);
            this.a.a.C();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements xm8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleChooseActivity a;

        @Override // com.baidu.tieba.xm8.e
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

        @Override // com.baidu.tieba.xm8.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "consume_19", "click");
                this.a.b.g0(i);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.getPageContext().getPageActivity(), true, 23004, "pop_unable", 7);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.a();
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

    public final void D1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.e0(i, ii.l(getPageContext().getPageActivity()), ii.j(getPageContext().getPageActivity()));
            this.b.f0(i);
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
            a();
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.a0();
            this.b.b0();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.d0(0, 50, ii.l(getPageContext().getPageActivity()), ii.j(getPageContext().getPageActivity()));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BubbleListModel bubbleListModel = new BubbleListModel(getPageContext());
            this.b = bubbleListModel;
            bubbleListModel.h0(this.c);
            this.b.i0(this.d);
            this.b.c0(this.g);
            C1();
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wm8 wm8Var = new wm8(getPageContext());
            this.a = wm8Var;
            wm8Var.y().setOnItemClickListener(this);
            this.a.C();
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
                this.b.j0(this.g);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 23004) {
                a();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.x()) {
                Activity pageActivity = getPageContext().getPageActivity();
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f16e8);
                pt4.x(pageActivity, string, TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, true, true);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        BubbleListData.BubbleData z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.onItemClick(adapterView, view2, i, j);
            if (adapterView == this.a.y() && view2 != null && (view2 instanceof BubbleView) && (z = this.a.z(i)) != null) {
                if (z.getBcode() != 0 && !z.canUse()) {
                    if (z.isFree()) {
                        xm8.a(getPageContext(), z, this.e);
                        return;
                    } else {
                        xm8.b(getPageContext(), z, this.f);
                        return;
                    }
                }
                D1(z.getBcode());
                this.a.C();
            }
        }
    }
}
