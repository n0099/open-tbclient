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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tieba.l8a;
import com.baidu.tieba.m55;
import com.baidu.tieba.o55;
import com.baidu.tieba.o95;
import com.baidu.tieba.p75;
import com.baidu.tieba.tr6;
import com.baidu.tieba.tr8;
import com.baidu.tieba.vea;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.tieba.xg;
import com.baidu.tieba.xr6;
import com.baidu.tieba.zr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class TbFileVideoActivity extends BaseActivity<TbFileVideoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public MultiMediaEditLayout b;
    public ImageView c;
    public View d;
    public xr6 e;
    public TbMultiMediaData f;
    public VideoInfo g;
    public int h;
    public QmFilterItem i;
    public TBLottieAnimationView j;
    public RelativeLayout k;
    public TbGLMediaPreviewView l;
    public CustomMessageListener m;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                this.a.j.pauseAnimation();
                this.a.k.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                long j = this.a.f.start;
                long j2 = this.a.f.end;
                this.a.f.start = ((float) this.a.e.getFrom()) * this.a.f.getCurrentSpeed();
                this.a.f.end = ((float) this.a.e.d()) * this.a.f.getCurrentSpeed();
                tr8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("write", "视频选择完成，点击下一步。mFileFrom=" + this.a.h);
                if (this.a.h == 1) {
                    TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.a.getPageContext().getPageActivity());
                    tbEditVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
                    tbEditVideoActivityConfig.setMultiMediaData(this.a.f);
                    tbEditVideoActivityConfig.setVideoFrom(1);
                    tbEditVideoActivityConfig.setVideoRatio(this.a.e.getRatio());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                    this.a.f.start = j;
                    this.a.f.end = j2;
                } else if (this.a.h == 2) {
                    Intent intent = new Intent();
                    intent.putExtra("enter_anim_values", l8a.a(this.a.l));
                    intent.putExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA, (Parcelable) this.a.f);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements o55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m55 a;
        public final /* synthetic */ TbFileVideoActivity b;

        public e(TbFileVideoActivity tbFileVideoActivity, m55 m55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, m55Var};
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
            this.a = m55Var;
        }

        @Override // com.baidu.tieba.o55.f
        public void M0(o55 o55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o55Var, i, view2) == null) {
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("enter_anim_values", l8a.a(this.b.l));
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
        this.m = new a(this, 2921583);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            E1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            xr6 xr6Var = this.e;
            if (xr6Var != null) {
                xr6Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            xr6 xr6Var = this.e;
            if (xr6Var != null) {
                xr6Var.onPause();
            }
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xr6 xr6Var = this.e;
            if (xr6Var != null && xr6Var.g()) {
                m55 m55Var = new m55(getPageContext(), new o55(getPageContext().getPageActivity()));
                m55Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f060c), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f1183)}, new e(this, m55Var));
                m55Var.l();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("enter_anim_values", l8a.a(this.l));
            setResult(0, intent);
            finish();
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f090aec);
            this.l = tbGLMediaPreviewView;
            tbGLMediaPreviewView.setOnClickListener(this);
            int color = getResources().getColor(R.color.CAM_X0105);
            this.l.setGlClearColor((Color.red(color) * 1.0f) / 255.0f, (Color.green(color) * 1.0f) / 255.0f, (Color.blue(color) * 1.0f) / 255.0f, (Color.alpha(color) * 1.0f) / 255.0f);
            this.b = (MultiMediaEditLayout) findViewById(R.id.obfuscated_res_0x7f0917a8);
            zr6 zr6Var = new zr6(getPageContext(), this.l, this.b, this.f, this.h, getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false));
            this.e = zr6Var;
            zr6Var.a(this.i);
            int i = this.h;
            if (i == 2) {
                this.e.h(true);
            } else if (i == 1) {
                this.e.h(false);
            }
        }
    }

    public final void H1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && i > 0) {
            tr6 tr6Var = new tr6(getPageContext(), this.b);
            tr6Var.L(R.drawable.bg_tip_blue_up_right);
            tr6Var.l(4);
            tr6Var.N(true);
            tr6Var.Q(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
            tr6Var.R(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
            tr6Var.C(R.color.CAM_X0101);
            tr6Var.J(R.dimen.T_X08);
            tr6Var.p(R.dimen.T_X08);
            tr6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            tr6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
            tr6Var.S(getResources().getString(i));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0911f4 || view2.getId() == R.id.obfuscated_res_0x7f090aec) {
                if (!o95.p().l("key_file_video_clip_play_pause_show", false)) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0911f4) {
                        I1(R.raw.obfuscated_res_0x7f11000e);
                    }
                    o95.p().A("key_file_video_clip_play_pause_show", true);
                }
                xr6 xr6Var = this.e;
                if (xr6Var != null) {
                    if (xr6Var.isPlaying()) {
                        this.e.pause();
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c16));
                        return;
                    }
                    this.e.start();
                    this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c1e));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0059);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                VideoInfo videoInfo = (VideoInfo) getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
                this.g = videoInfo;
                if (videoInfo != null) {
                    this.f = vea.a(videoInfo);
                } else {
                    this.f = (TbMultiMediaData) getIntent().getParcelableExtra(TbFileVideoActivityConfig.MULTI_MEDIA_DATA);
                }
                this.h = getIntent().getIntExtra(TbFileVideoActivityConfig.FILE_FROM, 0);
                this.i = (QmFilterItem) getIntent().getSerializableExtra(TbFileVideoActivityConfig.FILTER_NAME);
            }
            F1();
            initView();
            registerListener(this.m);
        }
    }

    public final void I1(@RawRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.k == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090546);
                this.k = relativeLayout;
                p75 d2 = p75.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.j == null) {
                this.j = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090545);
            }
            this.k.setVisibility(0);
            this.j.setAnimation(i);
            this.j.loop(true);
            this.j.playAnimation();
            xg.a().postDelayed(new b(this), 3000L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (getIntent() != null) {
                this.h = getIntent().getIntExtra(TbFileVideoActivityConfig.FILE_FROM, 0);
            }
            if (this.h == 2) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            View view2 = this.d;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            xr6 xr6Var = this.e;
            if (xr6Var != null) {
                xr6Var.onResume();
                this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c16));
            }
        }
    }

    public final void initView() {
        Resources resources;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0722)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bfe));
            addSystemImageButton.setOnClickListener(new c(this));
            NavigationBar navigationBar2 = this.a;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            if (this.h == 2) {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f1297;
            } else {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f0e03;
            }
            navigationBar2.addTextButton(controlAlign, resources.getString(i), new d(this)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.d = findViewById(R.id.obfuscated_res_0x7f091c9a);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911f4);
            this.c = imageView;
            imageView.setOnClickListener(this);
            if (!o95.p().l("key_file_video_clip_tail_tip_show", false)) {
                H1(R.string.obfuscated_res_0x7f0f0724);
                o95.p().A("key_file_video_clip_tail_tip_show", true);
            }
        }
    }
}
