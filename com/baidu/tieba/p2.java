package com.baidu.tieba;

import android.media.MediaPlayer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class p2 implements y1, MediaPlayer.OnCompletionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d2 a;
    public MediaPlayer b;
    public boolean c;
    public boolean d;
    public y1.a e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p2 a;

        public a(p2 p2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p2 p2Var = this.a;
                p2Var.e.a(p2Var);
            }
        }
    }

    public p2(d2 d2Var, MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d2Var, mediaPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = false;
        this.a = d2Var;
        this.b = mediaPlayer;
        this.e = null;
        mediaPlayer.setOnCompletionListener(this);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null) {
                return false;
            }
            try {
                return mediaPlayer.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (mediaPlayer = this.b) == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                this.b.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.media.MediaPlayer, com.baidu.tieba.y1$a] */
    @Override // com.baidu.tieba.b7
    public void dispose() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (mediaPlayer = this.b) == null) {
            return;
        }
        try {
            try {
                mediaPlayer.release();
            } finally {
                this.b = null;
                this.e = null;
                this.a.d(this);
            }
        } catch (Throwable unused) {
            y0.a.log("AndroidMusic", "error while disposing AndroidMusic instance, non-fatal");
        }
    }

    public void f() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (mediaPlayer = this.b) == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                return;
            }
            try {
                if (!this.c) {
                    this.b.prepare();
                    this.c = true;
                }
                this.b.start();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, mediaPlayer) == null) && this.e != null) {
            y0.a.postRunnable(new a(this));
        }
    }
}
