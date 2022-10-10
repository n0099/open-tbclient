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
import com.baidu.tieba.c46;
import com.baidu.tieba.e46;
import com.baidu.tieba.gh;
import com.baidu.tieba.hv4;
import com.baidu.tieba.n09;
import com.baidu.tieba.ox4;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.tieba.vu8;
import com.baidu.tieba.wu4;
import com.baidu.tieba.x36;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TbFileVideoActivity extends BaseActivity<TbFileVideoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public MultiMediaEditLayout b;
    public ImageView c;
    public View d;
    public c46 e;
    public TbMultiMediaData f;
    public VideoInfo g;
    public int h;
    public QmFilterItem i;
    public TBLottieAnimationView j;
    public RelativeLayout k;
    public TbGLMediaPreviewView l;
    public CustomMessageListener m;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                if (this.a.h != 1) {
                    if (this.a.h == 2) {
                        Intent intent = new Intent();
                        intent.putExtra("enter_anim_values", vu8.a(this.a.l));
                        intent.putExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA, (Parcelable) this.a.f);
                        this.a.setResult(-1, intent);
                        this.a.finish();
                        return;
                    }
                    return;
                }
                TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.a.getPageContext().getPageActivity());
                tbEditVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
                tbEditVideoActivityConfig.setMultiMediaData(this.a.f);
                tbEditVideoActivityConfig.setVideoFrom(1);
                tbEditVideoActivityConfig.setVideoRatio(this.a.e.getRatio());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                this.a.f.start = j;
                this.a.f.end = j2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu4 a;
        public final /* synthetic */ TbFileVideoActivity b;

        public e(TbFileVideoActivity tbFileVideoActivity, wu4 wu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbFileVideoActivity, wu4Var};
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
            this.a = wu4Var;
        }

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("enter_anim_values", vu8.a(this.b.l));
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

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c46 c46Var = this.e;
            if (c46Var != null && c46Var.g()) {
                wu4 wu4Var = new wu4(getPageContext(), new yu4(getPageContext().getPageActivity()));
                wu4Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f0538), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f0f97)}, new e(this, wu4Var));
                wu4Var.k();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("enter_anim_values", vu8.a(this.l));
            setResult(0, intent);
            finish();
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f0909b8);
            this.l = tbGLMediaPreviewView;
            tbGLMediaPreviewView.setOnClickListener(this);
            int color = getResources().getColor(R.color.CAM_X0105);
            this.l.setGlClearColor((Color.red(color) * 1.0f) / 255.0f, (Color.green(color) * 1.0f) / 255.0f, (Color.blue(color) * 1.0f) / 255.0f, (Color.alpha(color) * 1.0f) / 255.0f);
            this.b = (MultiMediaEditLayout) findViewById(R.id.obfuscated_res_0x7f0915ae);
            e46 e46Var = new e46(getPageContext(), this.l, this.b, this.f, this.h, getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false));
            this.e = e46Var;
            e46Var.a(this.i);
            int i = this.h;
            if (i == 2) {
                this.e.h(true);
            } else if (i == 1) {
                this.e.h(false);
            }
        }
    }

    public final void H1() {
        Resources resources;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091657);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f062a)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ((ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f092680)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a22));
            addSystemImageButton.setOnClickListener(new c(this));
            NavigationBar navigationBar2 = this.a;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            if (this.h == 2) {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f10a3;
            } else {
                resources = getResources();
                i = R.string.obfuscated_res_0x7f0f0c62;
            }
            navigationBar2.addTextButton(controlAlign, resources.getString(i), new d(this)).setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.d = findViewById(R.id.obfuscated_res_0x7f091a74);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091023);
            this.c = imageView;
            imageView.setOnClickListener(this);
            if (ox4.k().h("key_file_video_clip_tail_tip_show", false)) {
                return;
            }
            I1(R.string.obfuscated_res_0x7f0f062c);
            ox4.k().u("key_file_video_clip_tail_tip_show", true);
        }
    }

    public final void I1(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i <= 0) {
            return;
        }
        x36 x36Var = new x36(getPageContext(), this.b);
        x36Var.q0(R.drawable.obfuscated_res_0x7f0802f6);
        x36Var.Q(4);
        x36Var.r0(true);
        x36Var.u0(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
        x36Var.v0(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
        x36Var.h0(R.color.CAM_X0101);
        x36Var.o0(R.dimen.T_X08);
        x36Var.U(R.dimen.T_X08);
        x36Var.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
        x36Var.n0(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
        x36Var.w0(getResources().getString(i));
    }

    public final void J1(@RawRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.k == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904b3);
                this.k = relativeLayout;
                hv4 d2 = hv4.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.j == null) {
                this.j = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0904b2);
            }
            this.k.setVisibility(0);
            this.j.setAnimation(i);
            this.j.loop(true);
            this.j.playAnimation();
            gh.a().postDelayed(new b(this), 3000L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            F1();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f091023 || view2.getId() == R.id.obfuscated_res_0x7f0909b8) {
                if (!ox4.k().h("key_file_video_clip_play_pause_show", false)) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091023) {
                        J1(R.raw.obfuscated_res_0x7f11000e);
                    }
                    ox4.k().u("key_file_video_clip_play_pause_show", true);
                }
                c46 c46Var = this.e;
                if (c46Var != null) {
                    if (c46Var.isPlaying()) {
                        this.e.pause();
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3a));
                        return;
                    }
                    this.e.start();
                    this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a42));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0055);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                VideoInfo videoInfo = (VideoInfo) getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
                this.g = videoInfo;
                if (videoInfo != null) {
                    this.f = n09.a(videoInfo);
                } else {
                    this.f = (TbMultiMediaData) getIntent().getParcelableExtra(TbFileVideoActivityConfig.MULTI_MEDIA_DATA);
                }
                this.h = getIntent().getIntExtra(TbFileVideoActivityConfig.FILE_FROM, 0);
                this.i = (QmFilterItem) getIntent().getSerializableExtra(TbFileVideoActivityConfig.FILTER_NAME);
            }
            G1();
            H1();
            registerListener(this.m);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            c46 c46Var = this.e;
            if (c46Var != null) {
                c46Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            c46 c46Var = this.e;
            if (c46Var != null) {
                c46Var.onPause();
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
            c46 c46Var = this.e;
            if (c46Var != null) {
                c46Var.onResume();
                this.c.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3a));
            }
        }
    }
}
