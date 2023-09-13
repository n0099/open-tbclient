package com.baidu.tieba.immessagecenter.msgtab.ui.slice;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.RobotMallConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cjb;
import com.baidu.tieba.gy8;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.qx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0006H\u0016J$\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u001c\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterNavSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "(Lcom/baidu/tbadk/TbPageContext;)V", "ROBOT_MALL_EMTRANCE_CLICK", "", "context", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "mNaviContainer", "Landroid/widget/LinearLayout;", "mNaviIcon", "Landroid/widget/ImageView;", "mNaviMoreText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "mNaviTitle", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "mRobotMallImage", "", "mRobotMallUrl", "mRotbotMall", "Lcom/baidu/tbadk/widget/TbImageView;", "mSyncFinishListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "naviBarView", "Landroid/view/View;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "getRobotMall", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onViewCreated", "view", "setRobotMallListener", "setRobotMallStatistic", "setRobotMallVisible", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterNavSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> j;
    public final Activity k;
    public NavigationBar l;
    public EMTextView m;
    public LinearLayout n;
    public EMTextView o;
    public ImageView p;
    public TbImageView q;
    public String r;
    public String s;
    public final int t;
    public View u;
    public final CustomMessageListener v;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterNavSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgChatCenterNavSlice msgChatCenterNavSlice) {
            super(2001371);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgChatCenterNavSlice};
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
            this.a = msgChatCenterNavSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() != 2001371) {
                    return;
                }
                this.a.f0();
                this.a.k0();
                this.a.h0();
                View view2 = this.a.u;
                if (view2 != null) {
                    view2.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterNavSlice a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(MsgChatCenterNavSlice msgChatCenterNavSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgChatCenterNavSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgChatCenterNavSlice;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && !z && (tbImageView = this.a.q) != null) {
                tbImageView.setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0804e4));
            }
        }
    }

    public MsgChatCenterNavSlice(TbPageContext<?> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.j = pageContext;
        this.k = pageContext.getPageActivity();
        this.t = 2;
        this.v = new a(this);
    }

    public static final void g0(MsgChatCenterNavSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this$0.k);
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    public static final void i0(MsgChatCenterNavSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (gy8.a() && this$0.r != null && this$0.s != null) {
                this$0.j0();
                View K = this$0.K();
                Intrinsics.checkNotNull(K);
                BrowserHelper.startWebActivity(K.getContext(), "", this$0.s, false, true, true, null);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View R(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d08e2, container, false);
            if (inflate instanceof NavigationBar) {
                navigationBar = (NavigationBar) inflate;
            } else {
                navigationBar = null;
            }
            this.l = navigationBar;
            if (navigationBar != null) {
                navigationBar.setNavHeight(BdUtilHelper.getDimens(this.k, R.dimen.tbds187));
            }
            return this.l;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void X(View view2, Bundle bundle) {
        LinearLayout linearLayout;
        ImageView imageView;
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.X(view2, bundle);
            qx5.b(view2);
            NavigationBar navigationBar = this.l;
            if (navigationBar != null) {
                navigationBar.setStatusBarVisibility(8);
                TbImageView tbImageView = null;
                EMTextView eMTextView2 = (EMTextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d06fc, (View.OnClickListener) null).findViewById(R.id.obfuscated_res_0x7f0918e8);
                this.m = eMTextView2;
                if (eMTextView2 != null) {
                    eMTextView2.setText(this.k.getString(R.string.obfuscated_res_0x7f0f0cc5));
                }
                View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06fb, (View.OnClickListener) null);
                this.u = addCustomView;
                if (addCustomView != null) {
                    linearLayout = (LinearLayout) addCustomView.findViewById(R.id.obfuscated_res_0x7f0918e5);
                } else {
                    linearLayout = null;
                }
                this.n = linearLayout;
                if (linearLayout != null) {
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xv8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                                MsgChatCenterNavSlice.g0(MsgChatCenterNavSlice.this, view3);
                            }
                        }
                    });
                }
                View view3 = this.u;
                if (view3 != null) {
                    imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0918e6);
                } else {
                    imageView = null;
                }
                this.p = imageView;
                View view4 = this.u;
                if (view4 != null) {
                    eMTextView = (EMTextView) view4.findViewById(R.id.obfuscated_res_0x7f0918e7);
                } else {
                    eMTextView = null;
                }
                this.o = eMTextView;
                if (eMTextView != null) {
                    eMTextView.setText(this.k.getString(R.string.obfuscated_res_0x7f0f0cc4));
                }
                View view5 = this.u;
                if (view5 != null) {
                    tbImageView = (TbImageView) view5.findViewById(R.id.obfuscated_res_0x7f091fc9);
                }
                this.q = tbImageView;
                if (tbImageView != null) {
                    tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0804e4);
                }
                TbImageView tbImageView2 = this.q;
                if (tbImageView2 != null) {
                    tbImageView2.setEvent(new b(this));
                }
            }
            MessageManager.getInstance().registerListener(this.v);
        }
    }

    public final void f0() {
        RobotMallConfig robotMallConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (robotMallConfig = TbSingleton.getInstance().getRobotMallConfig()) != null) {
            this.r = robotMallConfig.getAiChatEntranceImage();
            this.s = robotMallConfig.getAiChatEntranceUrl();
        }
    }

    public final void h0() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tbImageView = this.q) != null) {
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wv8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgChatCenterNavSlice.i0(MsgChatCenterNavSlice.this, view2);
                    }
                }
            });
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ROBOT_MALL_ENTRANCE_EXPLORE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.t));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (gy8.a() && !cjb.a(this.r) && !cjb.a(this.s)) {
                TbImageView tbImageView = this.q;
                if (tbImageView != null) {
                    tbImageView.setVisibility(0);
                }
                TbImageView tbImageView2 = this.q;
                if (tbImageView2 != null) {
                    tbImageView2.startLoad(this.r);
                    return;
                }
                return;
            }
            TbImageView tbImageView3 = this.q;
            if (tbImageView3 != null) {
                tbImageView3.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.l;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.j, i);
            }
            EMManager.from(K()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X12);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f080b1d, R.color.CAM_X0107, null);
        }
    }
}
