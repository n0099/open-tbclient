package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class r3 implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u6<ParticleEmitter> a;
    public boolean b;

    public r3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new u6<>(8);
    }

    public void a(d3 d3Var, d3 d3Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, d3Var, d3Var2) == null) {
            i(d3Var);
            g(d3Var2);
        }
    }

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.b) {
            return;
        }
        int i = this.a.b;
        for (int i2 = 0; i2 < i; i2++) {
            u6.b<u3> it = this.a.get(i2).g().iterator();
            while (it.hasNext()) {
                it.next().f().dispose();
            }
        }
    }

    public void f(d3 d3Var, v3 v3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, d3Var, v3Var, str) == null) {
            i(d3Var);
            h(v3Var, str);
        }
    }

    public void g(d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d3Var) == null) {
            this.b = true;
            q7 q7Var = new q7(this.a.b);
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    u6<u3> u6Var = new u6<>();
                    u6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        u3 u3Var = (u3) q7Var.c(name);
                        if (u3Var == null) {
                            u3Var = new u3(j(d3Var.a(name)));
                            q7Var.i(name, u3Var);
                        }
                        u6Var.a(u3Var);
                    }
                    particleEmitter.u(u6Var);
                }
            }
        }
    }

    public void h(v3 v3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, v3Var, str) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    u6<u3> u6Var = new u6<>();
                    u6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        u3 a = v3Var.a(name);
                        if (a != null) {
                            u6Var.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(u6Var);
                }
            }
        }
    }

    public void i(d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, d3Var) == null) {
            InputStream m = d3Var.m();
            this.a.clear();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(m), 512);
                    do {
                        try {
                            this.a.a(k(bufferedReader2));
                        } catch (IOException e) {
                            e = e;
                            throw new GdxRuntimeException("Error loading effect: " + d3Var, e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            c8.a(bufferedReader);
                            throw th;
                        }
                    } while (bufferedReader2.readLine() != null);
                    c8.a(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
    }

    public Texture j(d3 d3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d3Var)) == null) {
            return new Texture(d3Var, false);
        }
        return (Texture) invokeL.objValue;
    }

    public ParticleEmitter k(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bufferedReader)) == null) {
            return new ParticleEmitter(bufferedReader);
        }
        return (ParticleEmitter) invokeL.objValue;
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).update(f);
            }
        }
    }
}
