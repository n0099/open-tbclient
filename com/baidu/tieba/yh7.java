package com.baidu.tieba;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BottomCommonTipLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class yh7 extends sh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public ActivityForumBinding c;
    public PollingModel d;
    public BottomCommonTipLayout e;
    public boolean f;
    public final CustomMessageListener g;
    public final CustomMessageListener h;
    public final Runnable i;

    /* loaded from: classes9.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yh7 yh7Var) {
            super(2921801);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof MemberBroadcastData)) {
                yh7 yh7Var = this.a;
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    yh7Var.w((MemberBroadcastData) data);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.MemberBroadcastData");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yh7 yh7Var) {
            super(2921774);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof MemberBroadcastData)) {
                ni7 value = ((ForumViewModel) new ViewModelProvider(this.a.q()).get(ForumViewModel.class)).c().getValue();
                boolean z = true;
                if (!((value == null || value.r() != 1) ? false : false)) {
                    return;
                }
                yh7 yh7Var = this.a;
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    yh7Var.w((MemberBroadcastData) data);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.MemberBroadcastData");
            }
        }
    }

    public yh7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.g = new b(this);
        this.h = new a(this);
        this.i = new Runnable() { // from class: com.baidu.tieba.pg7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    yh7.t(yh7.this);
                }
            }
        };
    }

    public static final void u(yh7 this$0, ni7 ni7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, ni7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SafeHandler.getInst().post(this$0.i);
        }
    }

    public static final void t(yh7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            PollingModel pollingModel = this$0.d;
            if (pollingModel != null) {
                pollingModel.getData(PollingModel.MEMBER_BROADCAST);
            }
        }
    }

    @Override // com.baidu.tieba.sh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            o(this.g);
            o(this.h);
            TbPageContext<?> a2 = fo7.a(this.b);
            if (a2 != null) {
                this.d = new PollingModel(a2, a2.getUniqueId());
            }
            ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().observe(this.b, new Observer() { // from class: com.baidu.tieba.bg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        yh7.u(yh7.this, (ni7) obj);
                    }
                }
            });
            this.c = binding;
        }
    }

    @Override // com.baidu.tieba.sh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.l();
        }
    }

    @Override // com.baidu.tieba.sh7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.m();
            this.f = false;
        }
    }

    @Override // com.baidu.tieba.sh7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.n();
            this.f = true;
        }
    }

    public final FragmentActivity q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BottomCommonTipLayout bottomCommonTipLayout = this.e;
            if (bottomCommonTipLayout != null) {
                return bottomCommonTipLayout.m();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, memberBroadcastData) == null) {
            if (this.e == null) {
                ActivityForumBinding activityForumBinding = null;
                BottomCommonTipLayout bottomCommonTipLayout = new BottomCommonTipLayout(this.b, null, 2, null);
                this.e = bottomCommonTipLayout;
                bottomCommonTipLayout.setId(R.id.member_broadcast_tip_layout);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds151);
                layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds203);
                layoutParams.gravity = 80;
                bottomCommonTipLayout.setLayoutParams(layoutParams);
                ActivityForumBinding activityForumBinding2 = this.c;
                if (activityForumBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityForumBinding = activityForumBinding2;
                }
                activityForumBinding.r.addView(bottomCommonTipLayout);
            }
            ni7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
            String str = (value == null || (str = Long.valueOf(value.e()).toString()) == null) ? "" : "";
            BottomCommonTipLayout bottomCommonTipLayout2 = this.e;
            if (bottomCommonTipLayout2 != null) {
                bottomCommonTipLayout2.p(memberBroadcastData, "frs_vip_brd", 1, str);
            }
        }
    }

    public final void w(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, memberBroadcastData) == null) && this.f && !YunDialogManager.isShowingDialog() && !xh7.k(this.b).u() && new MemberBroadcastHelper(memberBroadcastData).isMeetFrequency()) {
            v(memberBroadcastData);
        }
    }
}
