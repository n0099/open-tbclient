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
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.scale.ScalableType;
import com.baidu.tieba.video.editvideo.scale.ScalableVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes9.dex */
public class CoverSeekBar extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55625e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f55626f;

    /* renamed from: g  reason: collision with root package name */
    public ScalableVideoView f55627g;

    /* renamed from: h  reason: collision with root package name */
    public int f55628h;

    /* renamed from: i  reason: collision with root package name */
    public int f55629i;
    public d j;
    public LinearLayout.LayoutParams k;
    public Thread l;
    public float m;
    public float n;
    public float o;
    public Handler p;

    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverSeekBar f55630e;

        /* renamed from: com.baidu.tieba.video.editvideo.view.CoverSeekBar$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1804a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f55631e;

            public C1804a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55631e = aVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        this.f55631e.f55630e.f55627g.pause();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55630e = coverSeekBar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f55630e.f55627g.start();
                    mediaPlayer.setOnInfoListener(new C1804a(this));
                    return;
                }
                this.f55630e.f55627g.seekTo(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoverSeekBar f55632a;

        public b(CoverSeekBar coverSeekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSeekBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55632a = coverSeekBar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                this.f55632a.setImage(message.arg1, (Bitmap) message.obj);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55633e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoverSeekBar f55634f;

        public c(CoverSeekBar coverSeekBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSeekBar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55634f = coverSeekBar;
            this.f55633e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.f55633e);
                    int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                    for (int i2 = 0; i2 < this.f55634f.f55625e; i2++) {
                        Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime((i2 / (this.f55634f.f55625e - 1)) * parseInt * 1000, 2), this.f55634f.f55628h, this.f55634f.f55629i, 2);
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.arg1 = i2;
                        obtain.obj = extractThumbnail;
                        this.f55634f.p.sendMessage(obtain);
                    }
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a();

        void b();

        void onProgress(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Thread thread = new Thread(new c(this, str));
            this.l = thread;
            thread.start();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.f55628h = l.k(getContext()) / 10;
            this.f55629i = l.g(getContext(), R.dimen.ds112);
            this.k = new LinearLayout.LayoutParams(this.f55628h, this.f55629i);
            this.f55626f = (LinearLayout) findViewById(R.id.images_container);
            this.f55627g = (ScalableVideoView) findViewById(R.id.cover_select_image);
            this.f55627g.setLayoutParams(new FrameLayout.LayoutParams(this.f55628h, this.f55629i));
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ScalableVideoView scalableVideoView = this.f55627g;
            if (scalableVideoView == null) {
                return 0;
            }
            return scalableVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final boolean h(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getX() - this.n);
            float abs2 = Math.abs(motionEvent.getY() - this.o);
            float f2 = this.m;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    public final void i(MotionEvent motionEvent) {
        float paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            int width = getWidth();
            int paddingLeft2 = ((width - getPaddingLeft()) - getPaddingRight()) - this.f55628h;
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - (this.f55628h / 2)) {
                paddingLeft = 0.0f;
            } else {
                paddingLeft = x > (width - getPaddingRight()) - (this.f55628h / 2) ? 1.0f : ((x - getPaddingLeft()) - (this.f55628h / 2)) / paddingLeft2;
            }
            float f2 = (paddingLeft * 1000.0f) + 0.0f;
            float f3 = f2 >= 0.0f ? f2 : 0.0f;
            float f4 = f3 <= 1000.0f ? f3 : 1000.0f;
            d dVar = this.j;
            if (dVar != null) {
                dVar.onProgress((int) f4);
            }
        }
    }

    public void initImageContainer(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            boolean z = this.f55626f.getChildCount() > 0;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(mediaMetadataRetriever.getFrameAtTime(), this.f55628h, this.f55629i, 2);
            for (int i2 = 0; i2 < this.f55625e; i2++) {
                if (z) {
                    ImageView imageView = (ImageView) this.f55626f.getChildAt(i2);
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
                    this.f55626f.addView(imageView2, this.k);
                }
            }
            mediaMetadataRetriever.release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.n = motionEvent.getX();
                this.o = motionEvent.getY();
                d dVar = this.j;
                if (dVar != null) {
                    dVar.b();
                    i(motionEvent);
                }
            } else if (action != 1) {
                if (action == 2 && !h(motionEvent)) {
                    i(motionEvent);
                }
            } else if (this.j != null) {
                i(motionEvent);
                this.j.a();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ScalableVideoView scalableVideoView = this.f55627g;
            if (scalableVideoView != null) {
                scalableVideoView.release();
            }
            Thread thread = this.l;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f55627g.seekTo(i2);
        }
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f55627g.setDataSource(str);
            this.f55627g.setScalableType(ScalableType.CENTER_CROP);
            this.f55627g.prepare(new a(this));
            initImageContainer(str);
            f(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void setImage(int i2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, bitmap) == null) || bitmap == null) {
            return;
        }
        if (this.f55626f.getChildCount() > 0) {
            ((ImageView) this.f55626f.getChildAt(i2)).setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
    }

    public void setOnProgressChanged(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void setProgressImage(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            this.f55627g.seekTo(i3);
            int width = (int) (((i2 / 1000.0f) * getWidth()) - this.f55628h);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f55627g.getLayoutParams();
            if (width <= 0) {
                width = 0;
            } else if (width >= getWidth() - this.f55628h) {
                width = getWidth() - this.f55628h;
            }
            layoutParams.setMargins(width, 0, 0, 0);
            this.f55627g.setLayoutParams(layoutParams);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f55625e = 10;
        this.p = new b(this);
        LayoutInflater.from(context).inflate(R.layout.layout_cover_progress, this);
        g();
    }
}
