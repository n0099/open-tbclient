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
public class w2 implements d2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final AudioManager b;
    public final List<p2> c;

    public w2(Context context, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, b2Var};
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
        if (!b2Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(b2Var.q).build();
            } else {
                this.a = new SoundPool(b2Var.q, 3, 0);
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

    @Override // com.baidu.tieba.x0
    public z1 a(d3 d3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d3Var)) == null) {
            if (this.a != null) {
                g2 g2Var = (g2) d3Var;
                if (g2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = g2Var.u();
                        s2 s2Var = new s2(this.a, this.b, this.a.load(u, 1));
                        u.close();
                        return s2Var;
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error loading audio file: " + d3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    return new s2(this.a, this.b, this.a.load(g2Var.e().getPath(), 1));
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + d3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (z1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d2
    public void d(p2 p2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p2Var) == null) {
            synchronized (this.c) {
                this.c.remove(this);
            }
        }
    }

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                ((p2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.baidu.tieba.d2
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (p2 p2Var : this.c) {
                if (p2Var.a()) {
                    p2Var.pause();
                    p2Var.d = true;
                } else {
                    p2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.baidu.tieba.d2
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

    @Override // com.baidu.tieba.x0
    public y1 f(d3 d3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d3Var)) == null) {
            if (this.a != null) {
                g2 g2Var = (g2) d3Var;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (g2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = g2Var.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        p2 p2Var = new p2(this, mediaPlayer);
                        synchronized (this.c) {
                            this.c.add(p2Var);
                        }
                        return p2Var;
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Error loading audio file: " + d3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    mediaPlayer.setDataSource(g2Var.e().getPath());
                    mediaPlayer.prepare();
                    p2 p2Var2 = new p2(this, mediaPlayer);
                    synchronized (this.c) {
                        this.c.add(p2Var2);
                    }
                    return p2Var2;
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + d3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (y1) invokeL.objValue;
    }
}
