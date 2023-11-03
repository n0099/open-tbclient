package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class n2 implements x1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final List<i2> b;

    public n2(Context context, v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, v1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        if (!v1Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(v1Var.q).build();
            } else {
                this.a = new SoundPool(v1Var.q, 3, 0);
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.a = null;
    }

    @Override // com.baidu.tieba.x1
    public void a(i2 i2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i2Var) == null) {
            synchronized (this.b) {
                this.b.remove(this);
            }
        }
    }

    @Override // com.baidu.tieba.l3
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.b) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((i2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.baidu.tieba.x1
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.b) {
            for (i2 i2Var : this.b) {
                if (i2Var.b()) {
                    i2Var.pause();
                    i2Var.d = true;
                } else {
                    i2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.baidu.tieba.x1
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.b) {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).d) {
                    this.b.get(i).c();
                }
            }
        }
        this.a.autoResume();
    }
}
