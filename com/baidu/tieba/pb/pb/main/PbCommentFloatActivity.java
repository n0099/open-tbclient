package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.suspended.TranView;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.m36;
import com.baidu.tieba.pb.pb.main.view.CommentFloatSusPendedView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.wu5;
import com.baidu.tieba.yca;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public class PbCommentFloatActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public wu5 B;
    public BdUniqueId C;
    public TextView D;
    public ImageView E;
    public LinearLayout F;
    public TiePlusEventController G;
    public m36 H;
    public int I;
    public boolean J;
    public int K;
    public NoNetworkView.b L;
    public CustomMessageListener M;
    public CommentFloatSusPendedView u;
    public TranView v;
    public NavigationBar w;
    public NoNetworkView x;
    public ImageView y;
    public LinearLayout z;

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d077f : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommentFloatActivity a;

        public a(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommentFloatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.H != null) {
                this.a.H.q(TiePlusStat.StatType.CLICK);
                this.a.G.r(this.a.H);
                this.a.G.o(this.a.H);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommentFloatActivity a;

        public b(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommentFloatActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void j(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !z) {
                return;
            }
            this.a.m2();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommentFloatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbCommentFloatActivity pbCommentFloatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity, Integer.valueOf(i)};
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
            this.a = pbCommentFloatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ThreadData)) {
                return;
            }
            ThreadData threadData = (ThreadData) customResponsedMessage.getData();
            PbModel pbModel = this.a.a;
            if (pbModel != null && pbModel.z1() != null && this.a.a.z1().N() != null && threadData != null) {
                this.a.j2();
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (this.a.a.z1().N().getBaijiahaoData() != null) {
                    str2 = this.a.a.z1().N().getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        this.a.a.z1().N().setReply_num(threadData.getReply_num());
                        this.a.p2();
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = this.a.a.z1().N().getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    this.a.a.z1().N().setReply_num(threadData.getReply_num());
                    this.a.p2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommentFloatActivity a;

        public d(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommentFloatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Fragment fragment = this.a.b;
                if ((fragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment).T3()) {
                    ((AbsVideoPbFragment) this.a.b).k4();
                } else {
                    this.a.b2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommentFloatActivity a;

        public e(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommentFloatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.a.K1().getForumId());
                statisticItem.param("tid", this.a.K1().S1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.K1().X0());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 5);
                if (this.a.getIntent() != null) {
                    statisticItem.param("obj_locate", this.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0));
                }
                TiebaStatic.log(statisticItem);
                this.a.b2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommentFloatActivity a;

        public f(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommentFloatActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o2();
            }
        }
    }

    public PbCommentFloatActivity() {
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
        this.J = false;
        this.K = 0;
        this.L = new b(this);
        this.M = new c(this, 2921416);
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            wu5 wu5Var = this.B;
            if (wu5Var != null) {
                Intent resultIntent = wu5Var.getResultIntent();
                if (resultIntent != null) {
                    setResult(-1, resultIntent);
                }
                if (this.v != null && !this.u.getIsFinish()) {
                    this.u.r();
                } else {
                    super.finish();
                }
            } else {
                super.finish();
            }
            zg.a().postDelayed(new f(this), 400L);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            n2(true);
            if (this.B == null) {
                wu5 e2 = e2(this.A, this.w);
                this.B = e2;
                if (e2 != null) {
                    this.u.setContentViewTop(e2);
                }
            }
            TiePlusEventController tiePlusEventController = this.G;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public Fragment C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            VideoPbCommentFloatFragment videoPbCommentFloatFragment = new VideoPbCommentFloatFragment();
            videoPbCommentFloatFragment.setArguments(getIntent().getExtras());
            return videoPbCommentFloatFragment;
        }
        return (Fragment) invokeL.objValue;
    }

    public void n2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.J = z;
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getIntent() == null) {
                return 0;
            }
            return getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            wu5 wu5Var = this.B;
            if (wu5Var != null && !wu5Var.Q0()) {
                return;
            }
            if (this.v != null) {
                this.u.r();
            } else {
                finish();
            }
        }
    }

    public int c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.K;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public int d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getActivity() == null || getActivity().getIntent() == null) {
                return 0;
            }
            return getActivity().getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.A = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0907a2);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0922d5);
            this.x = noNetworkView;
            noNetworkView.a(this.L);
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TranView tranView = new TranView(getPageContext().getPageActivity());
            this.v = tranView;
            tranView.setVisibility(0);
            this.v.setOnClickListener(new d(this));
        }
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            CustomMessage customMessage = new CustomMessage(2921598);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921598, Boolean.TRUE);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            TbadkCoreApplication.getInst().resetFontSize();
            CommentFloatSusPendedView commentFloatSusPendedView = this.u;
            if (commentFloatSusPendedView != null) {
                commentFloatSusPendedView.q();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            n2(false);
            TiePlusEventController tiePlusEventController = this.G;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    public final void a2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d85.d(this.D).x(R.color.CAM_X0304);
            int i = this.I;
            if (i != 0 && (imageView = this.E) != null) {
                if (i != 3 && i != 7) {
                    if (i == 2) {
                        WebPManager.setPureDrawable(imageView, R.drawable.icon_mask_downline, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                        return;
                    } else if (i == 6) {
                        WebPManager.setPureDrawable(imageView, R.drawable.icon_mask_orderline, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                        return;
                    } else if (i == 5) {
                        WebPManager.setPureDrawable(imageView, R.drawable.icon_mask_messageline, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                        return;
                    } else {
                        WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_post_link16, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                        return;
                    }
                }
                WebPManager.setPureDrawable(this.E, R.drawable.icon_pure_wechat16, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void p2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (pbModel = this.a) != null && pbModel.z1() != null && this.a.z1().N() != null) {
            this.w.setCenterTextTitle(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f1477), Integer.valueOf(this.a.z1().N().getReply_num())));
        }
    }

    public final wu5 e2(FrameLayout frameLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, frameLayout, navigationBar)) == null) {
            p2();
            Fragment fragment = this.b;
            if (fragment instanceof AbsVideoPbFragment) {
                AbsVideoPbFragment absVideoPbFragment = (AbsVideoPbFragment) fragment;
                if (absVideoPbFragment.p3() != null) {
                    return absVideoPbFragment.p3();
                }
                return null;
            }
            return null;
        }
        return (wu5) invokeLL.objValue;
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            CommentFloatSusPendedView commentFloatSusPendedView = (CommentFloatSusPendedView) findViewById(R.id.suspended_view);
            this.u = commentFloatSusPendedView;
            commentFloatSusPendedView.setVideoPageUniqueId(this.C);
            this.u.setIsNoBgColor(true);
            k2();
            h2();
            i2();
            g2();
            this.u.setNavigationBar(this.z);
            this.u.setTranView(this.v);
            this.u.setContentView(this.A);
            this.u.s();
            this.D = (TextView) findViewById(R.id.obfuscated_res_0x7f091eec);
            this.E = (ImageView) findViewById(R.id.obfuscated_res_0x7f0924f8);
            this.F = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0924f6);
            this.G = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_COMMENT_TOP);
            registerListener(this.M);
        }
    }

    public final void h2() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.suspended_navigation_bar);
            this.w = navigationBar;
            navigationBar.mCenterText.setTextSize(0, yi.g(getPageContext().getPageActivity(), R.dimen.T_X07));
            this.w.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            this.y = this.w.getBackImageView();
            this.w.setIsCorner(true);
            this.w.setStatusBarVisibility(8);
            this.w.isShowBottomLine(true);
            this.z = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0918bd);
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds562);
            if (!TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            this.K = g + i;
            this.z.addView(this.v, 0, new LinearLayout.LayoutParams(-1, this.K));
        }
    }

    public void j2() {
        PbModel pbModel;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pbModel = this.a) != null && pbModel.z1() != null && this.a.z1().N() != null && this.a.z1().F() != null) {
            yca ycaVar = (yca) ListUtils.getItem(this.a.z1().F(), 0);
            List<PbContent> list = null;
            if (ycaVar != null) {
                list = ycaVar.j0;
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(TiePlusHelper.t(list), 0);
            if (pbContent != null && (tiebaPlusInfo = pbContent.tiebaplus_info) != null) {
                Integer num = pbContent.type;
                this.I = tiebaPlusInfo.jump_type.intValue();
                m36 c2 = m36.c(num.intValue(), tiebaPlusInfo, this.a.z1().N());
                this.H = c2;
                c2.b(this.a.z1().N().statFloor);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.r(this.H);
                this.D.setText(tiebaPlusInfo.desc);
                a2();
                this.F.setVisibility(0);
                this.w.isShowBottomLine(false);
                this.F.setOnClickListener(new a(this));
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            super.onChangeSkinType(i);
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
            this.w.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.F, R.color.CAM_X0208);
            a2();
            WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.x.d(getPageContext(), i);
            this.u.p(i);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0201);
            wu5 wu5Var = this.B;
            if (wu5Var != null) {
                wu5Var.q(i);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            TbadkCoreApplication.getInst().setTempFontSize(3);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.C = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            f2();
        }
    }
}
