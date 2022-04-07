package com.baidu.tieba.view.videofile;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.RawRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hs8;
import com.repackage.lz5;
import com.repackage.mr4;
import com.repackage.or4;
import com.repackage.pg;
import com.repackage.pz5;
import com.repackage.rz5;
import com.repackage.wr4;
import com.repackage.wt4;
import com.repackage.yx8;
/* loaded from: classes4.dex */
public class TbFileVideoActivity extends BaseActivity<TbFileVideoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mAfterJumpWriteActivityListener;
    public TBLottieAnimationView mCaptureGuide;
    public RelativeLayout mCaptureGuideContainer;
    public pz5 mEditManager;
    public int mFileFrom;
    public QmFilterItem mFilterItem;
    public TbMultiMediaData mMultiMediaData;
    public MultiMediaEditLayout mMultiMediaEditLayout;
    public NavigationBar mNavigationBar;
    public ImageView mPreviewPlay;
    public TbGLMediaPreviewView mPreviewView;
    public View mRootView;
    public VideoInfo mVideoInfo;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbFileVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbFileVideoActivity tbFileVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, Integer.valueOf(i)};
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
            this.a = tbFileVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbFileVideoActivity a;

        public b(TbFileVideoActivity tbFileVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbFileVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mCaptureGuide.pauseAnimation();
                this.a.mCaptureGuideContainer.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbFileVideoActivity a;

        public c(TbFileVideoActivity tbFileVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbFileVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onBackPressed();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbFileVideoActivity a;

        public d(TbFileVideoActivity tbFileVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbFileVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                long j = this.a.mMultiMediaData.start;
                long j2 = this.a.mMultiMediaData.end;
                this.a.mMultiMediaData.start = ((float) this.a.mEditManager.getFrom()) * this.a.mMultiMediaData.getCurrentSpeed();
                this.a.mMultiMediaData.end = ((float) this.a.mEditManager.d()) * this.a.mMultiMediaData.getCurrentSpeed();
                if (this.a.mFileFrom != 1) {
                    if (this.a.mFileFrom == 2) {
                        Intent intent = new Intent();
                        intent.putExtra("enter_anim_values", hs8.a(this.a.mPreviewView));
                        intent.putExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA, (Parcelable) this.a.mMultiMediaData);
                        this.a.setResult(-1, intent);
                        this.a.finish();
                        return;
                    }
                    return;
                }
                TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.a.getPageContext().getPageActivity());
                tbEditVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
                tbEditVideoActivityConfig.setMultiMediaData(this.a.mMultiMediaData);
                tbEditVideoActivityConfig.setVideoFrom(1);
                tbEditVideoActivityConfig.setVideoRatio(this.a.mEditManager.getRatio());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                this.a.mMultiMediaData.start = j;
                this.a.mMultiMediaData.end = j2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr4 a;
        public final /* synthetic */ TbFileVideoActivity b;

        public e(TbFileVideoActivity tbFileVideoActivity, mr4 mr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, mr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbFileVideoActivity;
            this.a = mr4Var;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("enter_anim_values", hs8.a(this.b.mPreviewView));
                    this.b.setResult(0, intent);
                    this.b.finish();
                    return;
                }
                this.a.dismiss();
            }
        }
    }

    public TbFileVideoActivity() {
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
        this.mAfterJumpWriteActivityListener = new a(this, 2921583);
    }

    private void backDialogShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            pz5 pz5Var = this.mEditManager;
            if (pz5Var != null && pz5Var.g()) {
                mr4 mr4Var = new mr4(getPageContext(), new or4(getPageContext().getPageActivity()));
                mr4Var.j(getResources().getString(R.string.obfuscated_res_0x7f0f0517), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f0f26)}, new e(this, mr4Var));
                mr4Var.m();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("enter_anim_values", hs8.a(this.mPreviewView));
            setResult(0, intent);
            finish();
        }
    }

    private void initManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f090999);
            this.mPreviewView = tbGLMediaPreviewView;
            tbGLMediaPreviewView.setOnClickListener(this);
            int color = getResources().getColor(R.color.CAM_X0105);
            this.mPreviewView.setGlClearColor((Color.red(color) * 1.0f) / 255.0f, (Color.green(color) * 1.0f) / 255.0f, (Color.blue(color) * 1.0f) / 255.0f, (Color.alpha(color) * 1.0f) / 255.0f);
            this.mMultiMediaEditLayout = (MultiMediaEditLayout) findViewById(R.id.obfuscated_res_0x7f091479);
            rz5 rz5Var = new rz5(getPageContext(), this.mPreviewView, this.mMultiMediaEditLayout, this.mMultiMediaData, this.mFileFrom, getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false));
            this.mEditManager = rz5Var;
            rz5Var.a(this.mFilterItem);
            int i = this.mFileFrom;
            if (i == 2) {
                this.mEditManager.h(true);
            } else if (i == 1) {
                this.mEditManager.h(false);
            }
        }
    }

    private void initView() {
        Resources resources;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091514);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0601)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ((ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09244a)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809c4));
            addSystemImageButton.setOnClickListener(new c(this));
            NavigationBar navigationBar2 = this.mNavigationBar;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            if (this.mFileFrom == 2) {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f1065;
            } else {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f0c21;
            }
            navigationBar2.addTextButton(controlAlign, resources.getString(i), new d(this)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f0918db);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe8);
            this.mPreviewPlay = imageView;
            imageView.setOnClickListener(this);
            if (wt4.k().h("key_file_video_clip_tail_tip_show", false)) {
                return;
            }
            showBottomTip(R.string.obfuscated_res_0x7f0f0603);
            wt4.k().u("key_file_video_clip_tail_tip_show", true);
        }
    }

    private void showBottomTip(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, this, i) == null) || i <= 0) {
            return;
        }
        lz5 lz5Var = new lz5(getPageContext(), this.mMultiMediaEditLayout);
        lz5Var.g0(R.drawable.obfuscated_res_0x7f0802f3);
        lz5Var.L(4);
        lz5Var.h0(true);
        lz5Var.j0(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
        lz5Var.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
        lz5Var.X(R.color.CAM_X0101);
        lz5Var.e0(R.dimen.T_X08);
        lz5Var.P(R.dimen.T_X08);
        lz5Var.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
        lz5Var.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
        lz5Var.l0(getResources().getString(i));
    }

    private void showGuideView(@RawRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i) == null) {
            if (this.mCaptureGuideContainer == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904b0);
                this.mCaptureGuideContainer = relativeLayout;
                wr4 d2 = wr4.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.mCaptureGuide == null) {
                this.mCaptureGuide = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0904af);
            }
            this.mCaptureGuideContainer.setVisibility(0);
            this.mCaptureGuide.setAnimation(i);
            this.mCaptureGuide.loop(true);
            this.mCaptureGuide.playAnimation();
            pg.a().postDelayed(new b(this), 3000L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (getIntent() != null) {
                this.mFileFrom = getIntent().getIntExtra(TbFileVideoActivityConfig.FILE_FROM, 0);
            }
            if (this.mFileFrom == 2) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            backDialogShow();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090fe8 || view2.getId() == R.id.obfuscated_res_0x7f090999) {
                if (!wt4.k().h("key_file_video_clip_play_pause_show", false)) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f090fe8) {
                        showGuideView(R.raw.obfuscated_res_0x7f11000e);
                    }
                    wt4.k().u("key_file_video_clip_play_pause_show", true);
                }
                pz5 pz5Var = this.mEditManager;
                if (pz5Var != null) {
                    if (pz5Var.isPlaying()) {
                        this.mEditManager.pause();
                        this.mPreviewPlay.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809da));
                        return;
                    }
                    this.mEditManager.start();
                    this.mPreviewPlay.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809e2));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0058);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                VideoInfo videoInfo = (VideoInfo) getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
                this.mVideoInfo = videoInfo;
                if (videoInfo != null) {
                    this.mMultiMediaData = yx8.a(videoInfo);
                } else {
                    this.mMultiMediaData = (TbMultiMediaData) getIntent().getParcelableExtra(TbFileVideoActivityConfig.MULTI_MEDIA_DATA);
                }
                this.mFileFrom = getIntent().getIntExtra(TbFileVideoActivityConfig.FILE_FROM, 0);
                this.mFilterItem = (QmFilterItem) getIntent().getSerializableExtra(TbFileVideoActivityConfig.FILTER_NAME);
            }
            initManager();
            initView();
            registerListener(this.mAfterJumpWriteActivityListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            pz5 pz5Var = this.mEditManager;
            if (pz5Var != null) {
                pz5Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            pz5 pz5Var = this.mEditManager;
            if (pz5Var != null) {
                pz5Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            View view2 = this.mRootView;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            pz5 pz5Var = this.mEditManager;
            if (pz5Var != null) {
                pz5Var.onResume();
                this.mPreviewPlay.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809da));
            }
        }
    }
}
