package com.baidu.tieba.memberCenter.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import b.a.e.e.p.l;
import b.a.r0.y1.a.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int PAGE_LENGTH;
    public final int PAGE_NUM;
    public b.a.r0.y1.a.b mBubbleChooseView;
    public BubbleListModel mBubbleModel;
    public c.e mFreeBubbleTipDialogCallback;
    public c.e mPayBubbleTipDialogCallback;
    public CustomMessageListener mRefreshListener;
    public BubbleListModel.c mRequestDataCallBack;
    public BubbleListModel.d mSetBubbleCallBack;

    /* loaded from: classes9.dex */
    public class a implements BubbleListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleChooseActivity f51429a;

        public a(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51429a = bubbleChooseActivity;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bubbleListData) == null) {
                this.f51429a.mBubbleChooseView.g();
                this.f51429a.mBubbleChooseView.h(null, false);
                if (bubbleListData != null) {
                    if (!bubbleListData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                            this.f51429a.showToast(bubbleListData.getError_msg());
                            return;
                        } else {
                            this.f51429a.showToast(R.string.neterror);
                            return;
                        }
                    }
                    this.f51429a.showToast(R.string.neterror);
                    return;
                }
                this.f51429a.showToast(R.string.neterror);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleListData) == null) {
                this.f51429a.mBubbleChooseView.g();
                if (bubbleListData == null) {
                    return;
                }
                this.f51429a.mBubbleChooseView.h(bubbleListData.getB_info(), BubbleListModel.y(bubbleListData.getB_info()));
                if (this.f51429a.mBubbleModel.A() <= 0 || (b_info = bubbleListData.getB_info()) == null || b_info.size() == 0) {
                    return;
                }
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null && bubbleData.getBcode() == this.f51429a.mBubbleModel.A()) {
                        if (!bubbleData.canUse() && !bubbleData.isFree()) {
                            break;
                        }
                        this.f51429a.mBubbleModel.G(this.f51429a.mBubbleModel.A());
                        this.f51429a.mBubbleModel.F(this.f51429a.mBubbleModel.A(), l.k(this.f51429a.getPageContext().getPageActivity()), l.i(this.f51429a.getPageContext().getPageActivity()));
                    }
                }
                this.f51429a.mBubbleModel.H(-1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BubbleListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleChooseActivity f51430a;

        public b(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51430a = bubbleChooseActivity;
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, setBubbleResultData) == null) {
                this.f51430a.mBubbleChooseView.g();
                int z = this.f51430a.mBubbleModel.z();
                b.a.r0.y1.a.a c2 = this.f51430a.mBubbleChooseView.c();
                if (z == 0) {
                    c2.d(true);
                    for (BubbleListData.BubbleData bubbleData : c2.b()) {
                        if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                            bubbleData.setIs_def(0);
                        }
                    }
                    c2.notifyDataSetChanged();
                } else if (setBubbleResultData.getB_info().canUser()) {
                    for (BubbleListData.BubbleData bubbleData2 : c2.b()) {
                        if (bubbleData2.getBcode() == z) {
                            bubbleData2.setIs_def(1);
                        } else if (bubbleData2.isDef()) {
                            bubbleData2.setIs_def(0);
                        }
                    }
                    c2.d(false);
                    c2.notifyDataSetChanged();
                } else {
                    this.f51430a.showToast(R.string.setdefualt_error);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setBubbleResultData) == null) {
                this.f51430a.mBubbleChooseView.g();
                if (setBubbleResultData != null) {
                    if (!setBubbleResultData.getError_code().equals("0")) {
                        if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                            this.f51430a.showToast(setBubbleResultData.getError_msg());
                            return;
                        } else {
                            this.f51430a.showToast(R.string.neterror);
                            return;
                        }
                    }
                    this.f51430a.showToast(R.string.neterror);
                    return;
                }
                this.f51430a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleChooseActivity f51431a;

        public c(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51431a = bubbleChooseActivity;
        }

        @Override // b.a.r0.y1.a.c.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f51431a.useBubble(i2);
                this.f51431a.mBubbleChooseView.i();
            }
        }

        @Override // b.a.r0.y1.a.c.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleChooseActivity f51432a;

        public d(BubbleChooseActivity bubbleChooseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51432a = bubbleChooseActivity;
        }

        @Override // b.a.r0.y1.a.c.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                TiebaStatic.eventStat(this.f51432a.getPageContext().getPageActivity(), "consume_19", PrefetchEvent.STATE_CLICK);
                this.f51432a.mBubbleModel.H(i2);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f51432a.getPageContext().getPageActivity(), true, 23004, "pop_unable", 7);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }

        @Override // b.a.r0.y1.a.c.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleChooseActivity f51433a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(BubbleChooseActivity bubbleChooseActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleChooseActivity, Integer.valueOf(i2)};
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
            this.f51433a = bubbleChooseActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f51433a.loadData();
            }
        }
    }

    public BubbleChooseActivity() {
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
        this.PAGE_NUM = 0;
        this.PAGE_LENGTH = 50;
        this.mRequestDataCallBack = new a(this);
        this.mSetBubbleCallBack = new b(this);
        this.mFreeBubbleTipDialogCallback = new c(this);
        this.mPayBubbleTipDialogCallback = new d(this);
        this.mRefreshListener = new e(this, 2010040);
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            BubbleListModel bubbleListModel = new BubbleListModel(getPageContext());
            this.mBubbleModel = bubbleListModel;
            bubbleListModel.I(this.mRequestDataCallBack);
            this.mBubbleModel.J(this.mSetBubbleCallBack);
            this.mBubbleModel.D(this.mRefreshListener);
            registerTask();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            b.a.r0.y1.a.b bVar = new b.a.r0.y1.a.b(getPageContext());
            this.mBubbleChooseView = bVar;
            bVar.e().setOnItemClickListener(this);
            this.mBubbleChooseView.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mBubbleModel.E(0, 50, l.k(getPageContext().getPageActivity()), l.i(getPageContext().getPageActivity()));
        }
    }

    private void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mBubbleModel.B();
            this.mBubbleModel.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void useBubble(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            this.mBubbleModel.F(i2, l.k(getPageContext().getPageActivity()), l.i(getPageContext().getPageActivity()));
            this.mBubbleModel.G(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 23004) {
                loadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mBubbleChooseView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.onClick(view);
            if (view == this.mBubbleChooseView.d()) {
                Activity pageActivity = getPageContext().getPageActivity();
                String string = getPageContext().getString(R.string.web_title_bubble_explain);
                b.a.q0.m.a.p(pageActivity, string, TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            initView();
            loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            BubbleListModel bubbleListModel = this.mBubbleModel;
            if (bubbleListModel != null) {
                bubbleListModel.unRegisterListener();
                this.mBubbleModel.K(this.mRefreshListener);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        BubbleListData.BubbleData f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.onItemClick(adapterView, view, i2, j);
            if (adapterView != this.mBubbleChooseView.e() || view == null || !(view instanceof BubbleView) || (f2 = this.mBubbleChooseView.f(i2)) == null) {
                return;
            }
            if (f2.getBcode() != 0 && !f2.canUse()) {
                if (f2.isFree()) {
                    b.a.r0.y1.a.c.a(getPageContext(), f2, this.mFreeBubbleTipDialogCallback);
                    return;
                } else {
                    b.a.r0.y1.a.c.b(getPageContext(), f2, this.mPayBubbleTipDialogCallback);
                    return;
                }
            }
            useBubble(f2.getBcode());
            this.mBubbleChooseView.i();
        }
    }
}
