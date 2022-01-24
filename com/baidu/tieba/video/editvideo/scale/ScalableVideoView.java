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
import c.a.t0.k4.i.g.a;
import c.a.t0.k4.i.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes13.dex */
public class ScalableVideoView extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer mMediaPlayer;
    public ScalableType mScalableType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context) {
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

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, assetFileDescriptor) == null) {
            setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            assetFileDescriptor.close();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mMediaPlayer == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mMediaPlayer = mediaPlayer;
                mediaPlayer.setOnVideoSizeChangedListener(this);
                setSurfaceTextureListener(this);
                return;
            }
            reset();
        }
    }

    public final void b(int i2, int i3) {
        Matrix m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || i2 == 0 || i3 == 0 || (m = new a(new b(getWidth(), getHeight()), new b(i2, i3)).m(this.mScalableType)) == null) {
            return;
        }
        setTransform(m);
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                return false;
            }
            return mediaPlayer.isLooping();
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                return false;
            }
            return mediaPlayer.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            if (this.mMediaPlayer == null) {
                return;
            }
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, surfaceTexture, i2, i3) == null) {
            try {
                Surface surface = new Surface(surfaceTexture);
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.setSurface(surface);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, surfaceTexture, i2, i3) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceTexture) == null) {
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, mediaPlayer, i2, i3) == null) {
            b(i2, i3);
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.pause();
    }

    public void prepare(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, onPreparedListener) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(onPreparedListener);
        this.mMediaPlayer.prepare();
    }

    public void prepareAsync(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onPreparedListener) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(onPreparedListener);
        this.mMediaPlayer.prepareAsync();
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            reset();
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.mMediaPlayer = null;
            }
        }
    }

    public void reset() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.reset();
    }

    public void seekTo(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
    }

    public void setAssetData(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            setDataSource(TbadkCoreApplication.getInst().getResources().getAssets().openFd(str));
        }
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, onCompletionListener) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, onErrorListener) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onInfoListener) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setOnInfoListener(onInfoListener);
    }

    public void setRawData(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            setDataSource(getResources().openRawResourceFd(i2));
        }
    }

    public void setScalableType(ScalableType scalableType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, scalableType) == null) {
            this.mScalableType = scalableType;
            b(getVideoWidth(), getVideoHeight());
        }
    }

    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public void start() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.start();
    }

    public void stop() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.stop();
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
    public ScalableVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
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
        this.mScalableType = ScalableType.NONE;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.videoScaleStyle, 0, 0)) == null) {
            return;
        }
        int i5 = obtainStyledAttributes.getInt(R$styleable.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
        obtainStyledAttributes.recycle();
        this.mScalableType = ScalableType.values()[i5];
    }

    public void setDataSource(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            a();
            this.mMediaPlayer.setDataSource(str);
        }
    }

    public void prepare() throws IOException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            prepare(null);
        }
    }

    public void prepareAsync() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            prepareAsync(null);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, context, uri, map) == null) {
            a();
            this.mMediaPlayer.setDataSource(context, uri, map);
        }
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, uri) == null) {
            a();
            this.mMediaPlayer.setDataSource(context, uri);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j2, long j3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{fileDescriptor, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            a();
            this.mMediaPlayer.setDataSource(fileDescriptor, j2, j3);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fileDescriptor) == null) {
            a();
            this.mMediaPlayer.setDataSource(fileDescriptor);
        }
    }
}
