package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class m2 implements t1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final AudioManager b;
    public final List<f2> c;

    public m2(Context context, r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, r1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        if (!r1Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(r1Var.q).build();
            } else {
                this.a = new SoundPool(r1Var.q, 3, 0);
            }
            this.b = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.tieba.n0
    public p1 a(t2 t2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t2Var)) == null) {
            if (this.a != null) {
                w1 w1Var = (w1) t2Var;
                if (w1Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = w1Var.u();
                        i2 i2Var = new i2(this.a, this.b, this.a.load(u, 1));
                        u.close();
                        return i2Var;
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error loading audio file: " + t2Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    return new i2(this.a, this.b, this.a.load(w1Var.e().getPath(), 1));
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + t2Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (p1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t1
    public void d(f2 f2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2Var) == null) {
            synchronized (this.c) {
                this.c.remove(this);
            }
        }
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                ((f2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.baidu.tieba.t1
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (f2 f2Var : this.c) {
                if (f2Var.a()) {
                    f2Var.pause();
                    f2Var.d = true;
                } else {
                    f2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.baidu.tieba.t1
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (int i = 0; i < this.c.size(); i++) {
                if (this.c.get(i).d) {
                    this.c.get(i).f();
                }
            }
        }
        this.a.autoResume();
    }

    @Override // com.baidu.tieba.n0
    public o1 f(t2 t2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t2Var)) == null) {
            if (this.a != null) {
                w1 w1Var = (w1) t2Var;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (w1Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = w1Var.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        f2 f2Var = new f2(this, mediaPlayer);
                        synchronized (this.c) {
                            this.c.add(f2Var);
                        }
                        return f2Var;
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Error loading audio file: " + t2Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    mediaPlayer.setDataSource(w1Var.e().getPath());
                    mediaPlayer.prepare();
                    f2 f2Var2 = new f2(this, mediaPlayer);
                    synchronized (this.c) {
                        this.c.add(f2Var2);
                    }
                    return f2Var2;
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + t2Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (o1) invokeL.objValue;
    }
}
