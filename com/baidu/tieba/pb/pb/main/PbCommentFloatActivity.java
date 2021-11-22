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
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
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
import com.baidu.tieba.pb.pb.main.view.CommentFloatSusPendedView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes9.dex */
public class PbCommentFloatActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TiePlusEventController eventController;
    public ImageView mCancel;
    public b.a.q0.e1.p.a mCommentTopDataWrapper;
    public FrameLayout mContentView;
    public int mJumpType;
    public NavigationBar mNavigationBar;
    public LinearLayout mNavigationBarGroup;
    public NoNetworkView.b mNetListener;
    public NoNetworkView mNoNetView;
    public TextView mRichTextView;
    public CommentFloatSusPendedView mSusPendedView;
    public b.a.q0.w0.a mSuspendedContentView;
    public LinearLayout mTiePlusContainer;
    public ImageView mTiePlusImage;
    public TranView mTranView;
    public CustomMessageListener mUpdateCommentNumListener;
    public BdUniqueId mVideoPageUniqueId;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommentFloatActivity f53122e;

        public a(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53122e = pbCommentFloatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53122e.mCommentTopDataWrapper == null) {
                return;
            }
            this.f53122e.mCommentTopDataWrapper.p(TiePlusStat.StatType.CLICK);
            this.f53122e.eventController.statRichTextEvent(this.f53122e.mCommentTopDataWrapper);
            this.f53122e.eventController.processClick(this.f53122e.mCommentTopDataWrapper);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommentFloatActivity f53123e;

        public b(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53123e = pbCommentFloatActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f53123e.requestData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbCommentFloatActivity f53124a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbCommentFloatActivity pbCommentFloatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity, Integer.valueOf(i2)};
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
            this.f53124a = pbCommentFloatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d2)) {
                return;
            }
            d2 d2Var = (d2) customResponsedMessage.getData();
            PbModel pbModel = this.f53124a.mPbModel;
            if (pbModel == null || pbModel.P0() == null || this.f53124a.mPbModel.P0().O() == null || d2Var == null) {
                return;
            }
            this.f53124a.initTiePlusRichTextView();
            String str = d2Var.L() != null ? d2Var.L().oriUgcNid : "";
            String str2 = this.f53124a.mPbModel.P0().O().L() != null ? this.f53124a.mPbModel.P0().O().L().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    this.f53124a.mPbModel.P0().O().p4(d2Var.U0());
                    this.f53124a.updateNavigationBarTitle();
                    return;
                }
                return;
            }
            String f0 = d2Var.f0();
            String f02 = this.f53124a.mPbModel.P0().O().f0();
            if ("0".equals(f02) || TextUtils.isEmpty(f02) || !f02.equals(f0)) {
                return;
            }
            this.f53124a.mPbModel.P0().O().p4(d2Var.U0());
            this.f53124a.updateNavigationBarTitle();
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommentFloatActivity f53125e;

        public d(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53125e = pbCommentFloatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Fragment fragment = this.f53125e.mCurrentFragment;
                if ((fragment instanceof AbsVideoPbFragment) && ((AbsVideoPbFragment) fragment).isEditToolVisible()) {
                    ((AbsVideoPbFragment) this.f53125e.mCurrentFragment).resetCommentView();
                } else {
                    this.f53125e.close();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommentFloatActivity f53126e;

        public e(PbCommentFloatActivity pbCommentFloatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommentFloatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53126e = pbCommentFloatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.f53126e.getPbModel().getForumId());
                statisticItem.param("tid", this.f53126e.getPbModel().f1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.f53126e.getPbModel().p0());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 5);
                if (this.f53126e.getIntent() != null) {
                    statisticItem.param("obj_locate", this.f53126e.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0));
                }
                TiebaStatic.log(statisticItem);
                this.f53126e.close();
            }
        }
    }

    public PbCommentFloatActivity() {
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
        this.mNetListener = new b(this);
        this.mUpdateCommentNumListener = new c(this, 2921416);
    }

    private void changeTiePlusSkin() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            b.a.q0.s.u.c.d(this.mRichTextView).v(f.CAM_X0304);
            int i2 = this.mJumpType;
            if (i2 == 0 || (imageView = this.mTiePlusImage) == null) {
                return;
            }
            if (i2 == 3) {
                WebPManager.setPureDrawable(imageView, h.icon_pure_wechat16, f.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (i2 == 2) {
                WebPManager.setPureDrawable(imageView, h.icon_mask_downline, f.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (i2 == 6) {
                WebPManager.setPureDrawable(imageView, h.icon_mask_orderline, f.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(imageView, h.icon_pure_post_link16, f.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    private b.a.q0.w0.a getSuspendedContentView(FrameLayout frameLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, frameLayout, navigationBar)) == null) {
            updateNavigationBarTitle();
            Fragment fragment = this.mCurrentFragment;
            if (fragment instanceof AbsVideoPbFragment) {
                AbsVideoPbFragment absVideoPbFragment = (AbsVideoPbFragment) fragment;
                if (absVideoPbFragment.getDetailInfoAndReplyFragment() != null) {
                    return absVideoPbFragment.getDetailInfoAndReplyFragment();
                }
                return null;
            }
            return null;
        }
        return (b.a.q0.w0.a) invokeLL.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            CommentFloatSusPendedView commentFloatSusPendedView = (CommentFloatSusPendedView) findViewById(i.suspended_view);
            this.mSusPendedView = commentFloatSusPendedView;
            commentFloatSusPendedView.setVideoPageUniqueId(this.mVideoPageUniqueId);
            this.mSusPendedView.setIsNoBgColor(true);
            initTranView();
            initNavigationBar();
            initNoNetView();
            initContentView();
            this.mSusPendedView.setNavigationBar(this.mNavigationBarGroup);
            this.mSusPendedView.setTranView(this.mTranView);
            this.mSusPendedView.setContentView(this.mContentView);
            this.mSusPendedView.show();
            this.mRichTextView = (TextView) findViewById(i.rich_text_view);
            this.mTiePlusImage = (ImageView) findViewById(i.tie_plus_iamge);
            this.mTiePlusContainer = (LinearLayout) findViewById(i.tie_plus_container);
            this.eventController = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_COMMENT_TOP);
            registerListener(this.mUpdateCommentNumListener);
        }
    }

    private void initContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mContentView = (FrameLayout) findViewById(i.container);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(i.suspended_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.mCenterText.setTextSize(0, l.g(getPageContext().getPageActivity(), g.T_X07));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            this.mCancel = this.mNavigationBar.getBackImageView();
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBarGroup = (LinearLayout) findViewById(i.navigation_bar_container);
            this.mNavigationBarGroup.addView(this.mTranView, 0, new LinearLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), g.tbds562) + ((TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) ? 0 : UtilHelper.getStatusBarHeight())));
        }
    }

    private void initNoNetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(i.suspended_no_network);
            this.mNoNetView = noNetworkView;
            noNetworkView.addNetworkChangeListener(this.mNetListener);
        }
    }

    private void initTranView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            TranView tranView = new TranView(getPageContext().getPageActivity());
            this.mTranView = tranView;
            tranView.setVisibility(0);
            this.mTranView.setOnClickListener(new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationBarTitle() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (pbModel = this.mPbModel) == null || pbModel.P0() == null || this.mPbModel.P0().O() == null) {
            return;
        }
        this.mNavigationBar.setCenterTextTitle(String.format(getResources().getString(b.a.r0.k2.l.subpb_floor_reply_count), Integer.valueOf(this.mPbModel.P0().O().U0())));
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.w0.a aVar = this.mSuspendedContentView;
            if (aVar == null || aVar.isOnViewCancel()) {
                if (this.mTranView != null) {
                    this.mSusPendedView.onFinish();
                } else {
                    finish();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public Fragment createFragment(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new VideoPbCommentFloatFragment() : (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.q0.w0.a aVar = this.mSuspendedContentView;
            if (aVar != null) {
                Intent resultIntent = aVar.getResultIntent();
                if (resultIntent != null) {
                    setResult(-1, resultIntent);
                }
                if (this.mTranView != null && !this.mSusPendedView.getIsFinish()) {
                    this.mSusPendedView.onFinish();
                    return;
                } else {
                    super.finish();
                    return;
                }
            }
            super.finish();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getContentViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? j.pb_comment_float_layout : invokeV.intValue;
    }

    public int getFromVideoPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getActivity() == null || getActivity().getIntent() == null) {
                return 0;
            }
            return getActivity().getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getImmersionVideoCommentSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (getIntent() != null) {
                return getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getShowFloorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void initTiePlusRichTextView() {
        PbModel pbModel;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.mPbModel) == null || pbModel.P0() == null || this.mPbModel.P0().O() == null || this.mPbModel.P0().F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(this.mPbModel.P0().F(), 0);
        PbContent pbContent = (PbContent) ListUtils.getItem(TiePlusHelper.q(postData != null ? postData.p0 : null), 0);
        if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
            return;
        }
        Integer num = pbContent.type;
        this.mJumpType = tiebaPlusInfo.jump_type.intValue();
        b.a.q0.e1.p.a c2 = b.a.q0.e1.p.a.c(num.intValue(), tiebaPlusInfo, this.mPbModel.P0().O());
        this.mCommentTopDataWrapper = c2;
        c2.b(this.mPbModel.P0().O().T1);
        this.mCommentTopDataWrapper.p(TiePlusStat.StatType.EXPOSE);
        this.eventController.statRichTextEvent(this.mCommentTopDataWrapper);
        this.mRichTextView.setText(tiebaPlusInfo.desc);
        changeTiePlusSkin();
        this.mTiePlusContainer.setVisibility(0);
        this.mNavigationBar.isShowBottomLine(false);
        this.mTiePlusContainer.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.mTiePlusContainer, f.CAM_X0208);
            changeTiePlusSkin();
            WebPManager.setPureDrawable(this.mCancel, h.icon_pure_topbar_close44, f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.mNoNetView.onChangeSkinType(getPageContext(), i2);
            this.mSusPendedView.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mSusPendedView, f.CAM_X0608);
            SkinManager.setBackgroundColor(this.mContentView, f.CAM_X0201);
            b.a.q0.w0.a aVar = this.mSuspendedContentView;
            if (aVar != null) {
                aVar.onViewChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            if (TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
                setUseStyleImmersiveSticky(false);
            }
            TbadkCoreApplication.getInst().setTempFontSize(3);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.mVideoPageUniqueId = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            init();
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            syncFloatDestroy();
            super.onDestroy();
            TbadkCoreApplication.getInst().resetFontSize();
            CommentFloatSusPendedView commentFloatSusPendedView = this.mSusPendedView;
            if (commentFloatSusPendedView != null) {
                commentFloatSusPendedView.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            syncFloatBackGround(false);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            syncFloatBackGround(true);
            if (this.mSuspendedContentView == null) {
                b.a.q0.w0.a suspendedContentView = getSuspendedContentView(this.mContentView, this.mNavigationBar);
                this.mSuspendedContentView = suspendedContentView;
                if (suspendedContentView != null) {
                    this.mSusPendedView.setContentViewTop(suspendedContentView);
                }
            }
        }
    }

    public void syncFloatBackGround(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.mVideoPageUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void syncFloatDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            CustomMessage customMessage = new CustomMessage(2921598);
            customMessage.setTag(this.mVideoPageUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921598, Boolean.TRUE);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
