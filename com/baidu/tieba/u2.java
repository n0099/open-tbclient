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
/* loaded from: classes8.dex */
public class u2 implements b2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final AudioManager b;
    public final List<n2> c;

    public u2(Context context, z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, z1Var};
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
        if (!z1Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(z1Var.q).build();
            } else {
                this.a = new SoundPool(z1Var.q, 3, 0);
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

    @Override // com.baidu.tieba.v0
    public x1 a(b3 b3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b3Var)) == null) {
            if (this.a != null) {
                e2 e2Var = (e2) b3Var;
                if (e2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = e2Var.u();
                        q2 q2Var = new q2(this.a, this.b, this.a.load(u, 1));
                        u.close();
                        return q2Var;
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error loading audio file: " + b3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    return new q2(this.a, this.b, this.a.load(e2Var.e().getPath(), 1));
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + b3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (x1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b2
    public void d(n2 n2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n2Var) == null) {
            synchronized (this.c) {
                this.c.remove(this);
            }
        }
    }

    @Override // com.baidu.tieba.z6
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                ((n2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.baidu.tieba.b2
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (n2 n2Var : this.c) {
                if (n2Var.a()) {
                    n2Var.pause();
                    n2Var.d = true;
                } else {
                    n2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.baidu.tieba.b2
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

    @Override // com.baidu.tieba.v0
    public w1 f(b3 b3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b3Var)) == null) {
            if (this.a != null) {
                e2 e2Var = (e2) b3Var;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (e2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = e2Var.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        n2 n2Var = new n2(this, mediaPlayer);
                        synchronized (this.c) {
                            this.c.add(n2Var);
                        }
                        return n2Var;
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Error loading audio file: " + b3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    mediaPlayer.setDataSource(e2Var.e().getPath());
                    mediaPlayer.prepare();
                    n2 n2Var2 = new n2(this, mediaPlayer);
                    synchronized (this.c) {
                        this.c.add(n2Var2);
                    }
                    return n2Var2;
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + b3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (w1) invokeL.objValue;
    }
}
