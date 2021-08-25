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
import c.a.p0.s.s.i;
import c.a.q0.v3.g;
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
import com.baidu.tbadk.core.dialog.PopupDialog;
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
/* loaded from: classes7.dex */
public class TbFileVideoActivity extends BaseActivity<TbFileVideoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mAfterJumpWriteActivityListener;
    public TBLottieAnimationView mCaptureGuide;
    public RelativeLayout mCaptureGuideContainer;
    public c.a.q0.f0.a.a mEditManager;
    public int mFileFrom;
    public QmFilterItem mFilterItem;
    public TbMultiMediaData mMultiMediaData;
    public MultiMediaEditLayout mMultiMediaEditLayout;
    public NavigationBar mNavigationBar;
    public ImageView mPreviewPlay;
    public TbGLMediaPreviewView mPreviewView;
    public View mRootView;
    public VideoInfo mVideoInfo;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbFileVideoActivity f58292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbFileVideoActivity tbFileVideoActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, Integer.valueOf(i2)};
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
            this.f58292a = tbFileVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f58292a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbFileVideoActivity f58293e;

        public b(TbFileVideoActivity tbFileVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58293e = tbFileVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58293e.mCaptureGuide.pauseAnimation();
                this.f58293e.mCaptureGuideContainer.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbFileVideoActivity f58294e;

        public c(TbFileVideoActivity tbFileVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58294e = tbFileVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58294e.onBackPressed();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbFileVideoActivity f58295e;

        public d(TbFileVideoActivity tbFileVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58295e = tbFileVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                long j2 = this.f58295e.mMultiMediaData.start;
                long j3 = this.f58295e.mMultiMediaData.end;
                this.f58295e.mMultiMediaData.start = ((float) this.f58295e.mEditManager.getFrom()) * this.f58295e.mMultiMediaData.getCurrentSpeed();
                this.f58295e.mMultiMediaData.end = ((float) this.f58295e.mEditManager.d()) * this.f58295e.mMultiMediaData.getCurrentSpeed();
                if (this.f58295e.mFileFrom != 1) {
                    if (this.f58295e.mFileFrom == 2) {
                        Intent intent = new Intent();
                        intent.putExtra("enter_anim_values", g.a(this.f58295e.mPreviewView));
                        intent.putExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA, (Parcelable) this.f58295e.mMultiMediaData);
                        this.f58295e.setResult(-1, intent);
                        this.f58295e.finish();
                        return;
                    }
                    return;
                }
                TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.f58295e.getPageContext().getPageActivity());
                tbEditVideoActivityConfig.getIntent().putExtras(this.f58295e.getIntent());
                tbEditVideoActivityConfig.setMultiMediaData(this.f58295e.mMultiMediaData);
                tbEditVideoActivityConfig.setVideoFrom(1);
                tbEditVideoActivityConfig.setVideoRatio(this.f58295e.mEditManager.getRatio());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                this.f58295e.mMultiMediaData.start = j2;
                this.f58295e.mMultiMediaData.end = j3;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f58296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbFileVideoActivity f58297f;

        public e(TbFileVideoActivity tbFileVideoActivity, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58297f = tbFileVideoActivity;
            this.f58296e = popupDialog;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("enter_anim_values", g.a(this.f58297f.mPreviewView));
                    this.f58297f.setResult(0, intent);
                    this.f58297f.finish();
                    return;
                }
                this.f58296e.dismiss();
            }
        }
    }

    public TbFileVideoActivity() {
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
        this.mAfterJumpWriteActivityListener = new a(this, 2921583);
    }

    private void backDialogShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null && aVar.f()) {
                PopupDialog popupDialog = new PopupDialog(getPageContext(), new i(getPageContext().getPageActivity()));
                popupDialog.setDefaultContentView(getResources().getString(R.string.edit_video_back_dialog_title), new String[]{getResources().getString(R.string.quit)}, new e(this, popupDialog));
                popupDialog.showDialog();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("enter_anim_values", g.a(this.mPreviewView));
            setResult(0, intent);
            finish();
        }
    }

    private void initManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = (TbGLMediaPreviewView) findViewById(R.id.file_preview_view);
            this.mPreviewView = tbGLMediaPreviewView;
            tbGLMediaPreviewView.setOnClickListener(this);
            int color = getResources().getColor(R.color.CAM_X0105);
            this.mPreviewView.setGlClearColor((Color.red(color) * 1.0f) / 255.0f, (Color.green(color) * 1.0f) / 255.0f, (Color.blue(color) * 1.0f) / 255.0f, (Color.alpha(color) * 1.0f) / 255.0f);
            this.mMultiMediaEditLayout = (MultiMediaEditLayout) findViewById(R.id.multi_media_edit_layout);
            c.a.q0.f0.a.c cVar = new c.a.q0.f0.a.c(getPageContext(), this.mPreviewView, this.mMultiMediaEditLayout, this.mMultiMediaData, this.mFileFrom, getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false));
            this.mEditManager = cVar;
            cVar.a(this.mFilterItem);
            int i2 = this.mFileFrom;
            if (i2 == 2) {
                this.mEditManager.g(true);
            } else if (i2 == 1) {
                this.mEditManager.g(false);
            }
        }
    }

    private void initView() {
        Resources resources;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.file_video_activity_title)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_return44));
            addSystemImageButton.setOnClickListener(new c(this));
            NavigationBar navigationBar2 = this.mNavigationBar;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            if (this.mFileFrom == 2) {
                resources = getResources();
                i2 = R.string.save;
            } else {
                resources = getResources();
                i2 = R.string.next;
            }
            navigationBar2.addTextButton(controlAlign, resources.getString(i2), new d(this)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.mRootView = findViewById(R.id.preview_video_root);
            ImageView imageView = (ImageView) findViewById(R.id.iv_play);
            this.mPreviewPlay = imageView;
            imageView.setOnClickListener(this);
            if (c.a.p0.s.d0.b.j().g("key_file_video_clip_tail_tip_show", false)) {
                return;
            }
            showBottomTip(R.string.file_video_clip_tips);
            c.a.p0.s.d0.b.j().t("key_file_video_clip_tail_tip_show", true);
        }
    }

    private void showBottomTip(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, this, i2) == null) || i2 <= 0) {
            return;
        }
        c.a.q0.e0.e eVar = new c.a.q0.e0.e(getPageContext(), this.mMultiMediaEditLayout);
        eVar.g0(R.drawable.bg_tip_blue_up_right);
        eVar.L(4);
        eVar.h0(true);
        eVar.j0(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
        eVar.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
        eVar.X(R.color.CAM_X0101);
        eVar.e0(R.dimen.T_X08);
        eVar.P(R.dimen.T_X08);
        eVar.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
        eVar.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
        eVar.l0(getResources().getString(i2));
    }

    private void showGuideView(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            if (this.mCaptureGuideContainer == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.capture_guide_view_container);
                this.mCaptureGuideContainer = relativeLayout;
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.mCaptureGuide == null) {
                this.mCaptureGuide = (TBLottieAnimationView) findViewById(R.id.capture_guide_view);
            }
            this.mCaptureGuideContainer.setVisibility(0);
            this.mCaptureGuide.setAnimation(i2);
            this.mCaptureGuide.loop(true);
            this.mCaptureGuide.playAnimation();
            c.a.e.e.m.e.a().postDelayed(new b(this), 3000L);
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
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (view.getId() == R.id.iv_play || view.getId() == R.id.file_preview_view) {
                if (!c.a.p0.s.d0.b.j().g("key_file_video_clip_play_pause_show", false)) {
                    if (view.getId() == R.id.iv_play) {
                        showGuideView(R.raw.file_edit_play_pause);
                    }
                    c.a.p0.s.d0.b.j().t("key_file_video_clip_play_pause_show", true);
                }
                c.a.q0.f0.a.a aVar = this.mEditManager;
                if (aVar != null) {
                    if (aVar.isPlaying()) {
                        this.mEditManager.pause();
                        this.mPreviewPlay.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_edit_play));
                        return;
                    }
                    this.mEditManager.start();
                    this.mPreviewPlay.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_pause26));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_tb_file_video);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                VideoInfo videoInfo = (VideoInfo) getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
                this.mVideoInfo = videoInfo;
                if (videoInfo != null) {
                    this.mMultiMediaData = c.a.q0.a4.l.c.d.d.a(videoInfo);
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
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            View view = this.mRootView;
            if (view != null) {
                view.setSystemUiVisibility(4100);
            }
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onResume();
                this.mPreviewPlay.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_edit_play));
            }
        }
    }
}
