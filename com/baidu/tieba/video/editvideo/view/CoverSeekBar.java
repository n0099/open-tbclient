package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.scale.ScalableType;
import com.baidu.tieba.video.editvideo.scale.ScalableVideoView;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public class CoverSeekBar extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public LinearLayout b;
    public ScalableVideoView c;
    public int d;
    public int e;
    public d f;
    public LinearLayout.LayoutParams g;
    public Thread h;
    public float i;
    public float j;
    public float k;
    public Handler l;

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void b();

        void onProgress(int i);
    }

    /* loaded from: classes6.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverSeekBar a;

        /* renamed from: com.baidu.tieba.video.editvideo.view.CoverSeekBar$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0459a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0459a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                    if (i == 3) {
                        this.a.a.c.c();
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public a(CoverSeekBar coverSeekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSeekBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverSeekBar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.a.c.i();
                    mediaPlayer.setOnInfoListener(new C0459a(this));
                    return;
                }
                this.a.c.h(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverSeekBar a;

        public b(CoverSeekBar coverSeekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSeekBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverSeekBar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                this.a.setImage(message.arg1, (Bitmap) message.obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CoverSeekBar b;

        public c(CoverSeekBar coverSeekBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSeekBar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = coverSeekBar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.a);
                    int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                    for (int i = 0; i < this.b.a; i++) {
                        Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime((i / (this.b.a - 1)) * parseInt * 1000, 2), this.b.d, this.b.e, 2);
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.arg1 = i;
                        obtain.obj = extractThumbnail;
                        this.b.l.sendMessage(obtain);
                    }
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverSeekBar(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getX() - this.j);
            float abs2 = Math.abs(motionEvent.getY() - this.k);
            float f = this.i;
            if (abs < f && abs2 < f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.c.setDataSource(str);
            this.c.setScalableType(ScalableType.CENTER_CROP);
            this.c.d(new a(this));
            h(str);
            f(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setProgressImage(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.c.h(i2);
            int width = (int) (((i / 1000.0f) * getWidth()) - this.d);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            if (width <= 0) {
                width = 0;
            } else if (width >= getWidth() - this.d) {
                width = getWidth() - this.d;
            }
            layoutParams.setMargins(width, 0, 0, 0);
            this.c.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 10;
        this.l = new b(this);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04b5, this);
        g();
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Thread thread = new Thread(new c(this, str));
            this.h = thread;
            thread.start();
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c.h(i);
        }
    }

    public void setOnProgressChanged(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f = dVar;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.d = yi.l(getContext()) / 10;
            this.e = yi.g(getContext(), R.dimen.obfuscated_res_0x7f070237);
            this.g = new LinearLayout.LayoutParams(this.d, this.e);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f3d);
            this.c = (ScalableVideoView) findViewById(R.id.obfuscated_res_0x7f09074f);
            this.c.setLayoutParams(new FrameLayout.LayoutParams(this.d, this.e));
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ScalableVideoView scalableVideoView = this.c;
            if (scalableVideoView == null) {
                return 0;
            }
            return scalableVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ScalableVideoView scalableVideoView = this.c;
            if (scalableVideoView != null) {
                scalableVideoView.e();
            }
            Thread thread = this.h;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public void h(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (this.b.getChildCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime(), this.d, this.e, 2);
            for (int i = 0; i < this.a; i++) {
                if (z) {
                    ImageView imageView = (ImageView) this.b.getChildAt(i);
                    if (extractThumbnail != null) {
                        imageView.setBackgroundDrawable(new BitmapDrawable(extractThumbnail));
                    }
                } else {
                    ImageView imageView2 = new ImageView(getContext());
                    if (extractThumbnail != null) {
                        imageView2.setBackgroundDrawable(new BitmapDrawable(extractThumbnail));
                    }
                    SkinManager.setImageResource(imageView2, R.drawable.bg_seekbar);
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.b.addView(imageView2, this.g);
                }
            }
            mediaMetadataRetriever.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void l(MotionEvent motionEvent) {
        float paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) {
            int width = getWidth();
            int paddingLeft2 = ((width - getPaddingLeft()) - getPaddingRight()) - this.d;
            int x = (int) motionEvent.getX();
            float f = 0.0f;
            if (x < getPaddingLeft() - (this.d / 2)) {
                paddingLeft = 0.0f;
            } else if (x > (width - getPaddingRight()) - (this.d / 2)) {
                paddingLeft = 1.0f;
            } else {
                paddingLeft = ((x - getPaddingLeft()) - (this.d / 2)) / paddingLeft2;
            }
            float f2 = 1000.0f;
            float f3 = (paddingLeft * 1000.0f) + 0.0f;
            if (f3 >= 0.0f) {
                f = f3;
            }
            if (f <= 1000.0f) {
                f2 = f;
            }
            d dVar = this.f;
            if (dVar != null) {
                dVar.onProgress((int) f2);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && !i(motionEvent)) {
                        l(motionEvent);
                    }
                } else if (this.f != null) {
                    l(motionEvent);
                    this.f.a();
                }
            } else {
                this.j = motionEvent.getX();
                this.k = motionEvent.getY();
                d dVar = this.f;
                if (dVar != null) {
                    dVar.b();
                    l(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setImage(int i, Bitmap bitmap) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048586, this, i, bitmap) != null) || bitmap == null) {
            return;
        }
        if (this.b.getChildCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        ((ImageView) this.b.getChildAt(i)).setBackgroundDrawable(new BitmapDrawable(bitmap));
    }
}
