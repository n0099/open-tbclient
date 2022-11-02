package com.baidu.tieba.videoEasterEgg;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.R;
import com.baidu.tieba.cz8;
import com.baidu.tieba.dz8;
import com.baidu.tieba.iv4;
import com.baidu.tieba.oy4;
import com.baidu.tieba.wi;
import com.baidu.tieba.yy8;
import com.baidu.tieba.zg;
import com.baidu.tieba.zy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoEasterEggActivity extends BaseActivity<VideoEasterEggActivity> implements zy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public ScaleVideoView c;
    public View d;
    public TextView e;
    public TextView f;
    public cz8 g;
    public oy4 h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public yy8 m;
    public boolean n;
    public Runnable o;
    public MediaPlayer.OnInfoListener p;

    /* loaded from: classes6.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public a(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, compoundButton, z) != null) {
                return;
            }
            this.a.l = z;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public b(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                if (this.a.g != null) {
                    this.a.g.c();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_REPLAY));
                }
                this.a.m.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public c(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                if (this.a.g != null) {
                    this.a.g.a();
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 2));
                }
                this.a.m.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public d(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.l) {
                this.a.g.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public e(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null) {
                this.a.g.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements MediaPlayer.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public f(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (i == 3) {
                    this.a.N1(false);
                    zg.a().removeCallbacks(this.a.o);
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public g(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.onClose();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public h(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.a();
                this.a.M1();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHARE).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public i(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.g != null) {
                    this.a.g.d();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public j(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mediaPlayer) != null) {
                return;
            }
            this.a.n = true;
            if (this.a.g != null) {
                this.a.g.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public k(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.c.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(this.a.p);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements SurfaceHolder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, surfaceHolder, i, i2, i3) == null) {
            }
        }

        public l(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) != null) {
                return;
            }
            this.a.N1(true);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) != null) {
                return;
            }
            this.a.n = false;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEasterEggActivity a;

        public m(VideoEasterEggActivity videoEasterEggActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEasterEggActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEasterEggActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.c();
            }
        }
    }

    public VideoEasterEggActivity() {
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
        this.i = 3;
        this.j = 0;
        this.k = false;
        this.l = false;
        this.o = new e(this);
        this.p = new f(this);
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09066c);
            this.a = imageView;
            imageView.setOnClickListener(new g(this));
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ec4);
            this.b = imageView2;
            imageView2.setOnClickListener(new h(this));
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = new oy4(getPageContext());
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d08e3);
            J1();
            L1();
            I1();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.zy8
    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d.setVisibility(8);
            this.k = true;
            this.j = 0;
            this.n = false;
            E0(str);
        }
    }

    @Override // com.baidu.tieba.zy8
    public void q0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            if (this.m == null) {
                this.m = H1(str, str2);
            }
            this.m.show();
        }
    }

    @Override // com.baidu.tieba.zy8
    public void E0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !wi.isEmpty(str) && !this.c.isPlaying() && !this.n) {
            if (this.k) {
                this.c.seekTo(this.j);
                this.k = false;
            } else {
                this.c.setVideoURI(Uri.parse(str));
                zg.a().postDelayed(this.o, 5000L);
            }
            this.c.start();
        }
    }

    public final void N1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                oy4 oy4Var = this.h;
                if (oy4Var != null && !oy4Var.c()) {
                    this.h.h(true);
                }
                this.c.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                return;
            }
            oy4 oy4Var2 = this.h;
            if (oy4Var2 != null) {
                oy4Var2.h(false);
            }
            this.c.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
        }
    }

    public final yy8 H1(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            yy8 yy8Var = new yy8(this);
            this.m = yy8Var;
            yy8Var.e(str2);
            if (wi.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f053e);
            }
            this.m.f(str);
            this.m.d(R.string.obfuscated_res_0x7f0f053d, new a(this));
            this.m.g(R.string.obfuscated_res_0x7f0f053b, new b(this));
            this.m.h(R.string.obfuscated_res_0x7f0f053c, new c(this));
            this.m.setOnDismissListener(new d(this));
            this.m.create(getPageContext());
            return this.m;
        }
        return (yy8) invokeLL.objValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = findViewById(R.id.obfuscated_res_0x7f090942);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09143f);
            this.e = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0a70);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a37);
            this.f = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f045a);
            this.f.setOnClickListener(new m(this));
            this.d.setVisibility(8);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ScaleVideoView scaleVideoView = (ScaleVideoView) findViewById(R.id.obfuscated_res_0x7f091dff);
            this.c = scaleVideoView;
            scaleVideoView.setOnErrorListener(new i(this));
            this.c.setOnCompletionListener(new j(this));
            this.c.setOnPreparedListener(new k(this));
            this.c.getHolder().addCallback(new l(this));
            N1(true);
        }
    }

    public final void M1() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (scaleVideoView = this.c) != null && scaleVideoView.isPlaying()) {
            this.j = this.c.getCurrentPosition();
            this.c.pause();
            this.k = true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.zy8
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onBackPressed();
            d0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            cz8 cz8Var = this.g;
            if (cz8Var != null) {
                cz8Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            M1();
            cz8 cz8Var = this.g;
            if (cz8Var != null) {
                cz8Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            cz8 cz8Var = this.g;
            if (cz8Var != null) {
                cz8Var.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.zy8
    public void showErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            zg.a().removeCallbacks(this.o);
            this.c.pause();
            this.h.h(false);
            this.d.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i2) != null) || i2 == this.i) {
            return;
        }
        this.i = i2;
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f, R.drawable.continue_play_bg);
        SkinManager.setImageResource(this.a, R.drawable.obfuscated_res_0x7f08072e);
        SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f080733);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            UtilHelper.useNavigationBarStyleImmersiveSticky(this, true);
            this.g = new dz8(getPageContext(), this, getIntent());
            K1();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_EASTER_EGG_SHOW));
        }
    }
}
