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
import com.baidu.tieba.bc9;
import com.baidu.tieba.cn8;
import com.baidu.tieba.cu5;
import com.baidu.tieba.hi;
import com.baidu.tieba.jg;
import com.baidu.tieba.n15;
import com.baidu.tieba.pb.pb.main.view.CommentFloatSusPendedView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.vl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class PbCommentFloatActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public FrameLayout B;
    public vl5 C;
    public BdUniqueId D;
    public TextView E;
    public ImageView F;
    public LinearLayout G;
    public TiePlusEventController H;
    public cu5 I;
    public int J;
    public boolean K;
    public int L;
    public NoNetworkView.b M;
    public CustomMessageListener N;
    public CommentFloatSusPendedView v;
    public TranView w;
    public NavigationBar x;
    public NoNetworkView y;
    public ImageView z;

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d0715 : invokeV.intValue;
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

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.I != null) {
                this.a.I.q(TiePlusStat.StatType.CLICK);
                this.a.H.k(this.a.I);
                this.a.H.h(this.a.I);
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !z) {
                return;
            }
            this.a.n2();
        }
    }

    /* loaded from: classes5.dex */
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
            if (pbModel != null && pbModel.w1() != null && this.a.a.w1().Q() != null && threadData != null) {
                this.a.k2();
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (this.a.a.w1().Q().getBaijiahaoData() != null) {
                    str2 = this.a.a.w1().Q().getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        this.a.a.w1().Q().setReply_num(threadData.getReply_num());
                        this.a.q2();
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = this.a.a.w1().Q().getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    this.a.a.w1().Q().setReply_num(threadData.getReply_num());
                    this.a.q2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                Fragment fragment = this.a.c;
                if ((fragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment).J4()) {
                    ((AbsVideoPbFragment) this.a.c).j5();
                } else {
                    this.a.c2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                statisticItem.param("tid", this.a.K1().Q1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.K1().U0());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 5);
                if (this.a.getIntent() != null) {
                    statisticItem.param("obj_locate", this.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0));
                }
                TiebaStatic.log(statisticItem);
                this.a.c2();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.p2();
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
        this.K = false;
        this.L = 0;
        this.M = new b(this);
        this.N = new c(this, 2921416);
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            vl5 vl5Var = this.C;
            if (vl5Var != null) {
                Intent resultIntent = vl5Var.getResultIntent();
                if (resultIntent != null) {
                    setResult(-1, resultIntent);
                }
                if (this.w != null && !this.v.getIsFinish()) {
                    this.v.r();
                } else {
                    super.finish();
                }
            } else {
                super.finish();
            }
            jg.a().postDelayed(new f(this), 400L);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onResume();
            o2(true);
            if (this.C == null) {
                vl5 f2 = f2(this.B, this.x);
                this.C = f2;
                if (f2 != null) {
                    this.v.setContentViewTop(f2);
                }
            }
            TiePlusEventController tiePlusEventController = this.H;
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

    public void o2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.D);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.K = z;
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

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vl5 vl5Var = this.C;
            if (vl5Var != null && !vl5Var.L0()) {
                return;
            }
            if (this.w != null) {
                this.v.r();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public int d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.L;
        }
        return invokeV.intValue;
    }

    public int e2() {
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
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.B = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09076e);
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f09219b);
            this.y = noNetworkView;
            noNetworkView.a(this.M);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TranView tranView = new TranView(getPageContext().getPageActivity());
            this.w = tranView;
            tranView.setVisibility(0);
            this.w.setOnClickListener(new d(this));
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            TbadkCoreApplication.getInst().resetFontSize();
            CommentFloatSusPendedView commentFloatSusPendedView = this.v;
            if (commentFloatSusPendedView != null) {
                commentFloatSusPendedView.q();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPause();
            o2(false);
            TiePlusEventController tiePlusEventController = this.H;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            CustomMessage customMessage = new CustomMessage(2921598);
            customMessage.setTag(this.D);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921598, Boolean.TRUE);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void b2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n15.d(this.E).w(R.color.CAM_X0304);
            int i = this.J;
            if (i != 0 && (imageView = this.F) != null) {
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
                WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_wechat16, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void q2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (pbModel = this.a) != null && pbModel.w1() != null && this.a.w1().Q() != null) {
            this.x.setCenterTextTitle(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f130d), Integer.valueOf(this.a.w1().Q().getReply_num())));
        }
    }

    public final vl5 f2(FrameLayout frameLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, frameLayout, navigationBar)) == null) {
            q2();
            Fragment fragment = this.c;
            if (fragment instanceof AbsVideoPbFragment) {
                AbsVideoPbFragment absVideoPbFragment = (AbsVideoPbFragment) fragment;
                if (absVideoPbFragment.V3() != null) {
                    return absVideoPbFragment.V3();
                }
                return null;
            }
            return null;
        }
        return (vl5) invokeLL.objValue;
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            CommentFloatSusPendedView commentFloatSusPendedView = (CommentFloatSusPendedView) findViewById(R.id.suspended_view);
            this.v = commentFloatSusPendedView;
            commentFloatSusPendedView.setVideoPageUniqueId(this.D);
            this.v.setIsNoBgColor(true);
            l2();
            i2();
            j2();
            h2();
            this.v.setNavigationBar(this.A);
            this.v.setTranView(this.w);
            this.v.setContentView(this.B);
            this.v.s();
            this.E = (TextView) findViewById(R.id.obfuscated_res_0x7f091dcc);
            this.F = (ImageView) findViewById(R.id.obfuscated_res_0x7f0923b5);
            this.G = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0923b3);
            this.H = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_COMMENT_TOP);
            registerListener(this.N);
        }
    }

    public final void i2() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.suspended_navigation_bar);
            this.x = navigationBar;
            navigationBar.mCenterText.setTextSize(0, hi.g(getPageContext().getPageActivity(), R.dimen.T_X07));
            this.x.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            this.z = this.x.getBackImageView();
            this.x.setIsCorner(true);
            this.x.setStatusBarVisibility(8);
            this.x.isShowBottomLine(true);
            this.A = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0917dc);
            int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds562);
            if (!TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            int i2 = g + i;
            this.L = i2;
            cn8.i(i2);
            this.A.addView(this.w, 0, new LinearLayout.LayoutParams(-1, this.L));
        }
    }

    public void k2() {
        PbModel pbModel;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pbModel = this.a) != null && pbModel.w1() != null && this.a.w1().Q() != null && this.a.w1().H() != null) {
            bc9 bc9Var = (bc9) ListUtils.getItem(this.a.w1().H(), 0);
            List<PbContent> list = null;
            if (bc9Var != null) {
                list = bc9Var.i0;
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(TiePlusHelper.t(list), 0);
            if (pbContent != null && (tiebaPlusInfo = pbContent.tiebaplus_info) != null) {
                Integer num = pbContent.type;
                this.J = tiebaPlusInfo.jump_type.intValue();
                cu5 c2 = cu5.c(num.intValue(), tiebaPlusInfo, this.a.w1().Q());
                this.I = c2;
                c2.b(this.a.w1().Q().statFloor);
                this.I.q(TiePlusStat.StatType.EXPOSE);
                this.H.k(this.I);
                this.E.setText(tiebaPlusInfo.desc);
                b2();
                this.G.setVisibility(0);
                this.x.isShowBottomLine(false);
                this.G.setOnClickListener(new a(this));
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.onChangeSkinType(i);
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
            this.x.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0208);
            b2();
            WebPManager.setPureDrawable(this.z, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.y.d(getPageContext(), i);
            this.v.p(i);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0201);
            vl5 vl5Var = this.C;
            if (vl5Var != null) {
                vl5Var.m(i);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            TbadkCoreApplication.getInst().setTempFontSize(3);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.D = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            g2();
        }
    }
}
