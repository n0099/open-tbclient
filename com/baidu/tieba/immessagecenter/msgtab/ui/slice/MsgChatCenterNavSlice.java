package com.baidu.tieba.immessagecenter.msgtab.ui.slice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gu5;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice;
import com.baidu.tieba.j79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J$\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterNavSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "(Lcom/baidu/tbadk/TbPageContext;)V", "ROBOT_MALL_EMTRANCE_CLICK", "", "context", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "mNaviContainer", "Landroid/widget/LinearLayout;", "mNaviIcon", "Landroid/widget/ImageView;", "mNaviMoreText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "mNaviTitle", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "mRobotMallConfig", "Lcom/baidu/tbadk/RobotMallConfig;", "mRotbotMall", "Lcom/baidu/tbadk/widget/TbImageView;", "naviBarView", "Landroid/view/View;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "handleRobotMallEntrance", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setRobotMallStatistic", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public RobotMallConfig r;
    public final int s;
    public View t;

    /* loaded from: classes6.dex */
    public static final class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgChatCenterNavSlice a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(MsgChatCenterNavSlice msgChatCenterNavSlice) {
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
                tbImageView.setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0804f1));
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
        this.s = 2;
    }

    public static final void f0(MsgChatCenterNavSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this$0.k);
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    public static final void g0(MsgChatCenterNavSlice this$0, View view2, View view3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this$0, view2, view3) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RobotMallConfig robotMallConfig = this$0.r;
            RobotMallConfig robotMallConfig2 = null;
            if (robotMallConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRobotMallConfig");
                robotMallConfig = null;
            }
            String aiChatEntranceUrl = robotMallConfig.getAiChatEntranceUrl();
            if (aiChatEntranceUrl != null && aiChatEntranceUrl.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this$0.h0();
                Intrinsics.checkNotNull(view2);
                Context context = view2.getContext();
                RobotMallConfig robotMallConfig3 = this$0.r;
                if (robotMallConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRobotMallConfig");
                } else {
                    robotMallConfig2 = robotMallConfig3;
                }
                BrowserHelper.startWebActivity(context, "", robotMallConfig2.getAiChatEntranceUrl(), false, true, true, null);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d0901, container, false);
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

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(final View view2, Bundle bundle) {
        LinearLayout linearLayout;
        ImageView imageView;
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            gu5.b(view2);
            NavigationBar navigationBar = this.l;
            if (navigationBar != null) {
                navigationBar.setStatusBarVisibility(8);
                TbImageView tbImageView = null;
                EMTextView eMTextView2 = (EMTextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d071d, (View.OnClickListener) null).findViewById(R.id.obfuscated_res_0x7f0919bc);
                this.m = eMTextView2;
                if (eMTextView2 != null) {
                    eMTextView2.setText(this.k.getString(R.string.obfuscated_res_0x7f0f0cf4));
                }
                View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d071c, (View.OnClickListener) null);
                this.t = addCustomView;
                if (addCustomView != null) {
                    linearLayout = (LinearLayout) addCustomView.findViewById(R.id.obfuscated_res_0x7f0919b9);
                } else {
                    linearLayout = null;
                }
                this.n = linearLayout;
                if (linearLayout != null) {
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.t89
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                                MsgChatCenterNavSlice.f0(MsgChatCenterNavSlice.this, view3);
                            }
                        }
                    });
                }
                View view3 = this.t;
                if (view3 != null) {
                    imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0919ba);
                } else {
                    imageView = null;
                }
                this.p = imageView;
                View view4 = this.t;
                if (view4 != null) {
                    eMTextView = (EMTextView) view4.findViewById(R.id.obfuscated_res_0x7f0919bb);
                } else {
                    eMTextView = null;
                }
                this.o = eMTextView;
                if (eMTextView != null) {
                    eMTextView.setText(this.k.getString(R.string.obfuscated_res_0x7f0f0cf3));
                }
                View view5 = this.t;
                if (view5 != null) {
                    tbImageView = (TbImageView) view5.findViewById(R.id.obfuscated_res_0x7f09205e);
                }
                this.q = tbImageView;
                if (tbImageView != null) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u89
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view6) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view6) == null) {
                                MsgChatCenterNavSlice.g0(MsgChatCenterNavSlice.this, view2, view6);
                            }
                        }
                    });
                }
                TbImageView tbImageView2 = this.q;
                if (tbImageView2 != null) {
                    tbImageView2.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0804f1);
                }
                TbImageView tbImageView3 = this.q;
                if (tbImageView3 != null) {
                    tbImageView3.setEvent(new a(this));
                }
            }
        }
    }

    public final void e0() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RobotMallConfig robotMallConfig = TbSingleton.getInstance().getRobotMallConfig();
            Intrinsics.checkNotNullExpressionValue(robotMallConfig, "getInstance().robotMallConfig");
            this.r = robotMallConfig;
            if (j79.a.a()) {
                RobotMallConfig robotMallConfig2 = this.r;
                RobotMallConfig robotMallConfig3 = null;
                if (robotMallConfig2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRobotMallConfig");
                    robotMallConfig2 = null;
                }
                String aiChatEntranceImage = robotMallConfig2.getAiChatEntranceImage();
                boolean z3 = true;
                if (aiChatEntranceImage != null && aiChatEntranceImage.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    RobotMallConfig robotMallConfig4 = this.r;
                    if (robotMallConfig4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRobotMallConfig");
                        robotMallConfig4 = null;
                    }
                    String aiChatEntranceUrl = robotMallConfig4.getAiChatEntranceUrl();
                    if (aiChatEntranceUrl != null && aiChatEntranceUrl.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        TbImageView tbImageView = this.q;
                        if (!((tbImageView == null || tbImageView.getVisibility() != 0) ? false : false)) {
                            TbImageView tbImageView2 = this.q;
                            if (tbImageView2 != null) {
                                tbImageView2.setVisibility(0);
                            }
                            TbImageView tbImageView3 = this.q;
                            if (tbImageView3 != null) {
                                RobotMallConfig robotMallConfig5 = this.r;
                                if (robotMallConfig5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mRobotMallConfig");
                                } else {
                                    robotMallConfig3 = robotMallConfig5;
                                }
                                tbImageView3.startLoad(robotMallConfig3.getAiChatEntranceImage());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            TbImageView tbImageView4 = this.q;
            if (tbImageView4 != null) {
                tbImageView4.setVisibility(8);
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ROBOT_MALL_ENTRANCE_EXPLORE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.s));
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.l;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.j, i);
            }
            EMManager.from(M()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X12);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f080b32, R.color.CAM_X0107, null);
        }
    }
}
