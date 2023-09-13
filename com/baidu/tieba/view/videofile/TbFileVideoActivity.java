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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ara;
import com.baidu.tieba.du6;
import com.baidu.tieba.fu6;
import com.baidu.tieba.g55;
import com.baidu.tieba.i55;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.tieba.vxa;
import com.baidu.tieba.yt6;
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
    public du6 e;
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
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("write", "视频选择完成，点击下一步。mFileFrom=" + this.a.h);
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
                    intent.putExtra("enter_anim_values", ara.a(this.a.l));
                    intent.putExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA, (Parcelable) this.a.f);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ TbFileVideoActivity b;

        public e(TbFileVideoActivity tbFileVideoActivity, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, g55Var};
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
            this.a = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("enter_anim_values", ara.a(this.b.l));
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
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            du6 du6Var = this.e;
            if (du6Var != null) {
                du6Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            du6 du6Var = this.e;
            if (du6Var != null) {
                du6Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            View view2 = this.d;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            du6 du6Var = this.e;
            if (du6Var != null) {
                du6Var.onResume();
                this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c4e));
            }
        }
    }

    public final void initView() {
        Resources resources;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f073a)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c36));
            addSystemImageButton.setOnClickListener(new c(this));
            NavigationBar navigationBar2 = this.a;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            if (this.h == 2) {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f12f1;
            } else {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f0e50;
            }
            navigationBar2.addTextButton(controlAlign, resources.getString(i), new d(this)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.d = findViewById(R.id.obfuscated_res_0x7f091d73);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091241);
            this.c = imageView;
            imageView.setOnClickListener(this);
            if (!SharedPrefHelper.getInstance().getBoolean("key_file_video_clip_tail_tip_show", false)) {
                y1(R.string.obfuscated_res_0x7f0f073c);
                SharedPrefHelper.getInstance().putBoolean("key_file_video_clip_tail_tip_show", true);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f091241 || view2.getId() == R.id.obfuscated_res_0x7f090b14) {
                if (!SharedPrefHelper.getInstance().getBoolean("key_file_video_clip_play_pause_show", false)) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091241) {
                        z1(R.raw.obfuscated_res_0x7f11000f);
                    }
                    SharedPrefHelper.getInstance().putBoolean("key_file_video_clip_play_pause_show", true);
                }
                du6 du6Var = this.e;
                if (du6Var != null) {
                    if (du6Var.isPlaying()) {
                        this.e.pause();
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c4e));
                        return;
                    }
                    this.e.start();
                    this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c56));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d005a);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                VideoInfo videoInfo = (VideoInfo) getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
                this.g = videoInfo;
                if (videoInfo != null) {
                    this.f = vxa.a(videoInfo);
                } else {
                    this.f = (TbMultiMediaData) getIntent().getParcelableExtra(TbFileVideoActivityConfig.MULTI_MEDIA_DATA);
                }
                this.h = getIntent().getIntExtra(TbFileVideoActivityConfig.FILE_FROM, 0);
                this.i = (QmFilterItem) getIntent().getSerializableExtra(TbFileVideoActivityConfig.FILTER_NAME);
            }
            x1();
            initView();
            registerListener(this.m);
        }
    }

    public final void y1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && i > 0) {
            yt6 yt6Var = new yt6(getPageContext(), this.b);
            yt6Var.L(R.drawable.bg_tip_blue_up_right);
            yt6Var.l(4);
            yt6Var.N(true);
            yt6Var.Q(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
            yt6Var.R(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
            yt6Var.C(R.color.CAM_X0101);
            yt6Var.J(R.dimen.T_X08);
            yt6Var.p(R.dimen.T_X08);
            yt6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            yt6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
            yt6Var.S(getResources().getString(i));
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            du6 du6Var = this.e;
            if (du6Var != null && du6Var.i()) {
                g55 g55Var = new g55(getPageContext(), new i55(getPageContext().getPageActivity()));
                g55Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f061c), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f11d9)}, new e(this, g55Var));
                g55Var.l();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("enter_anim_values", ara.a(this.l));
            setResult(0, intent);
            finish();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f090b14);
            this.l = tbGLMediaPreviewView;
            tbGLMediaPreviewView.setOnClickListener(this);
            int color = getResources().getColor(R.color.CAM_X0105);
            this.l.setGlClearColor((Color.red(color) * 1.0f) / 255.0f, (Color.green(color) * 1.0f) / 255.0f, (Color.blue(color) * 1.0f) / 255.0f, (Color.alpha(color) * 1.0f) / 255.0f);
            this.b = (MultiMediaEditLayout) findViewById(R.id.obfuscated_res_0x7f09184e);
            fu6 fu6Var = new fu6(getPageContext(), this.l, this.b, this.f, this.h, getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false));
            this.e = fu6Var;
            fu6Var.a(this.i);
            int i = this.h;
            if (i == 2) {
                this.e.j(true);
            } else if (i == 1) {
                this.e.j(false);
            }
        }
    }

    public final void z1(@RawRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.k == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09055e);
                this.k = relativeLayout;
                EMManager.from(relativeLayout).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0611);
            }
            if (this.j == null) {
                this.j = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09055d);
            }
            this.k.setVisibility(0);
            this.j.setAnimation(i);
            this.j.loop(true);
            this.j.playAnimation();
            SafeHandler.getInst().postDelayed(new b(this), 3000L);
        }
    }
}
