package com.baidu.tieba.video.editvideo.scale;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.epa;
import com.baidu.tieba.fpa;
import com.baidu.tieba.mz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes8.dex */
public class ScalableVideoView extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;
    public ScalableType b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, surfaceTexture, i, i2) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, surfaceTexture) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
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
        this.b = ScalableType.NONE;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mz5.videoScaleStyle, 0, 0)) == null) {
            return;
        }
        int i4 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
        obtainStyledAttributes.recycle();
        this.b = ScalableType.values()[i4];
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, assetFileDescriptor) == null) {
            setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            assetFileDescriptor.close();
        }
    }

    public void d(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, onPreparedListener) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(onPreparedListener);
        this.a.prepare();
    }

    public void h(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    public void setAssetData(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            setDataSource(TbadkCoreApplication.getInst().getResources().getAssets().openFd(str));
        }
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048602, this, z) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, onCompletionListener) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, onErrorListener) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, onInfoListener) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.setOnInfoListener(onInfoListener);
    }

    public void setRawData(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            setDataSource(getResources().openRawResourceFd(i));
        }
    }

    public void setScalableType(ScalableType scalableType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, scalableType) == null) {
            this.b = scalableType;
            g(getVideoWidth(), getVideoHeight());
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.a = mediaPlayer;
                mediaPlayer.setOnVideoSizeChangedListener(this);
                setSurfaceTextureListener(this);
                return;
            }
            f();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                return false;
            }
            return mediaPlayer.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.pause();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.a = null;
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (mediaPlayer = this.a) != null) {
            mediaPlayer.reset();
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getDuration();
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public void i() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.start();
    }

    public void j() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.stop();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            if (this.a == null) {
                return;
            }
            if (b()) {
                j();
            }
            e();
        }
    }

    public final void g(int i, int i2) {
        Matrix m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) && i != 0 && i2 != 0 && (m = new epa(new fpa(getWidth(), getHeight()), new fpa(i, i2)).m(this.b)) != null) {
            setTransform(m);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, surfaceTexture, i, i2) == null) {
            try {
                Surface surface = new Surface(surfaceTexture);
                if (this.a != null) {
                    this.a.setSurface(surface);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, mediaPlayer, i, i2) == null) {
            g(i, i2);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, context, uri, map) == null) {
            a();
            this.a.setDataSource(context, uri, map);
        }
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, uri) == null) {
            a();
            this.a.setDataSource(context, uri);
        }
    }

    public void setVolume(float f, float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.setVolume(f, f2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fileDescriptor) == null) {
            a();
            this.a.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{fileDescriptor, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a();
            this.a.setDataSource(fileDescriptor, j, j2);
        }
    }

    public void setDataSource(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            a();
            this.a.setDataSource(str);
        }
    }
}
