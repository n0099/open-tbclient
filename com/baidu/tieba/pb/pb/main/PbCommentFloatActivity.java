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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.bz5;
import com.baidu.tieba.lq5;
import com.baidu.tieba.nwa;
import com.baidu.tieba.pb.pb.main.view.CommentFloatSusPendedView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
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
    public lq5 B;
    public BdUniqueId C;
    public TextView D;
    public ImageView E;
    public LinearLayout F;
    public TiePlusEventController G;
    public bz5 H;
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
    public int D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? R.layout.obfuscated_res_0x7f0d07c1 : invokeV.intValue;
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
                this.a.G.u(this.a.H);
                this.a.G.q(this.a.H);
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
        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !z) {
                return;
            }
            this.a.o2();
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
            if (pbModel != null && pbModel.s1() != null && this.a.a.s1().R() != null && threadData != null) {
                this.a.k2();
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (this.a.a.s1().R().getBaijiahaoData() != null) {
                    str2 = this.a.a.s1().R().getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        this.a.a.s1().R().setReply_num(threadData.getReply_num());
                        this.a.r2();
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = this.a.a.s1().R().getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    this.a.a.s1().R().setReply_num(threadData.getReply_num());
                    this.a.r2();
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
                if ((fragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment).R4()) {
                    ((AbsVideoPbFragment) this.a.b).k5();
                } else {
                    this.a.a2();
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
                statisticItem.param("fid", this.a.B1().getForumId());
                statisticItem.param("tid", this.a.B1().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.B1().Q0());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 5);
                if (this.a.getIntent() != null) {
                    statisticItem.param("obj_locate", this.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0));
                }
                TiebaStatic.log(statisticItem);
                this.a.a2();
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
                this.a.q2();
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
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            lq5 lq5Var = this.B;
            if (lq5Var != null) {
                Intent resultIntent = lq5Var.getResultIntent();
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
            SafeHandler.getInst().postDelayed(new f(this), 400L);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            p2(true);
            if (this.B == null) {
                lq5 e2 = e2(this.A, this.w);
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

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.J = z;
        }
    }

    public void p2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public Fragment u1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            VideoPbCommentFloatFragment videoPbCommentFloatFragment = new VideoPbCommentFloatFragment();
            videoPbCommentFloatFragment.setArguments(getIntent().getExtras());
            return videoPbCommentFloatFragment;
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getIntent() == null) {
                return 0;
            }
            return getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            lq5 lq5Var = this.B;
            if (lq5Var != null && !lq5Var.C1()) {
                return;
            }
            if (this.v != null) {
                this.u.r();
            } else {
                finish();
            }
        }
    }

    public int b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.K;
        }
        return invokeV.intValue;
    }

    public int c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() == null || getActivity().getIntent() == null) {
                return 0;
            }
            return getActivity().getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.A = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0907f7);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f092411);
            this.x = noNetworkView;
            noNetworkView.addNetworkChangeListener(this.L);
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TranView tranView = new TranView(getPageContext().getPageActivity());
            this.v = tranView;
            tranView.setVisibility(0);
            this.v.setOnClickListener(new d(this));
        }
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            p2(false);
            TiePlusEventController tiePlusEventController = this.G;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            CustomMessage customMessage = new CustomMessage(2921598);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921598, Boolean.TRUE);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void Z1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.D).setTextColor(R.color.CAM_X0304);
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

    public final void r2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (pbModel = this.a) != null && pbModel.s1() != null && this.a.s1().R() != null) {
            this.w.setCenterTextTitle(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f14de), Integer.valueOf(this.a.s1().R().getReply_num())));
        }
    }

    public final lq5 e2(FrameLayout frameLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, frameLayout, navigationBar)) == null) {
            r2();
            Fragment fragment = this.b;
            if (fragment instanceof AbsVideoPbFragment) {
                AbsVideoPbFragment absVideoPbFragment = (AbsVideoPbFragment) fragment;
                if (absVideoPbFragment.n4() != null) {
                    return absVideoPbFragment.n4();
                }
                return null;
            }
            return null;
        }
        return (lq5) invokeLL.objValue;
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CommentFloatSusPendedView commentFloatSusPendedView = (CommentFloatSusPendedView) findViewById(R.id.suspended_view);
            this.u = commentFloatSusPendedView;
            commentFloatSusPendedView.setVideoPageUniqueId(this.C);
            this.u.setIsNoBgColor(true);
            m2();
            h2();
            i2();
            g2();
            this.u.setNavigationBar(this.z);
            this.u.setTranView(this.v);
            this.u.setContentView(this.A);
            this.u.s();
            this.D = (TextView) findViewById(R.id.obfuscated_res_0x7f091fff);
            this.E = (ImageView) findViewById(R.id.obfuscated_res_0x7f09263a);
            this.F = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092638);
            this.G = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_COMMENT_TOP);
            registerListener(this.M);
        }
    }

    public final void h2() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.suspended_navigation_bar);
            this.w = navigationBar;
            navigationBar.mCenterText.setTextSize(0, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.T_X07));
            this.w.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            this.y = this.w.getBackImageView();
            this.w.setIsCorner(true);
            this.w.setStatusBarVisibility(8);
            this.w.isShowBottomLine(true);
            this.z = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0919e0);
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds562);
            if (!TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            this.K = dimens + i;
            this.z.addView(this.v, 0, new LinearLayout.LayoutParams(-1, this.K));
        }
    }

    public void k2() {
        PbModel pbModel;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (pbModel = this.a) != null && pbModel.s1() != null && this.a.s1().R() != null && this.a.s1().I() != null) {
            nwa nwaVar = (nwa) ListUtils.getItem(this.a.s1().I(), 0);
            List<PbContent> list = null;
            if (nwaVar != null) {
                list = nwaVar.t0;
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(TiePlusHelper.E(list), 0);
            if (pbContent != null && (tiebaPlusInfo = pbContent.tiebaplus_info) != null) {
                Integer num = pbContent.type;
                this.I = tiebaPlusInfo.jump_type.intValue();
                bz5 c2 = bz5.c(num.intValue(), tiebaPlusInfo, this.a.s1().R());
                this.H = c2;
                c2.b(this.a.s1().R().statFloor);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.u(this.H);
                this.D.setText(tiebaPlusInfo.desc);
                Z1();
                this.F.setVisibility(0);
                this.w.isShowBottomLine(false);
                this.F.setOnClickListener(new a(this));
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.onChangeSkinType(i);
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
            this.w.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.F, R.color.CAM_X0208);
            Z1();
            WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.x.onChangeSkinType(getPageContext(), i);
            this.u.p(i);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0201);
            lq5 lq5Var = this.B;
            if (lq5Var != null) {
                lq5Var.D(i);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
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
