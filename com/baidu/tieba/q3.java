package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t6;
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
public class q3 implements a7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t6<ParticleEmitter> a;
    public boolean b;

    public q3() {
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
        this.a = new t6<>(8);
    }

    public void a(c3 c3Var, c3 c3Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, c3Var, c3Var2) == null) {
            i(c3Var);
            g(c3Var2);
        }
    }

    @Override // com.baidu.tieba.a7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.b) {
            return;
        }
        int i = this.a.b;
        for (int i2 = 0; i2 < i; i2++) {
            t6.b<t3> it = this.a.get(i2).g().iterator();
            while (it.hasNext()) {
                it.next().f().dispose();
            }
        }
    }

    public void f(c3 c3Var, u3 u3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, c3Var, u3Var, str) == null) {
            i(c3Var);
            h(u3Var, str);
        }
    }

    public void g(c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c3Var) == null) {
            this.b = true;
            p7 p7Var = new p7(this.a.b);
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    t6<t3> t6Var = new t6<>();
                    t6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        t3 t3Var = (t3) p7Var.c(name);
                        if (t3Var == null) {
                            t3Var = new t3(j(c3Var.a(name)));
                            p7Var.i(name, t3Var);
                        }
                        t6Var.a(t3Var);
                    }
                    particleEmitter.u(t6Var);
                }
            }
        }
    }

    public void h(u3 u3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, u3Var, str) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    t6<t3> t6Var = new t6<>();
                    t6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        t3 a = u3Var.a(name);
                        if (a != null) {
                            t6Var.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(t6Var);
                }
            }
        }
    }

    public void i(c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c3Var) == null) {
            InputStream m = c3Var.m();
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
                            throw new GdxRuntimeException("Error loading effect: " + c3Var, e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            b8.a(bufferedReader);
                            throw th;
                        }
                    } while (bufferedReader2.readLine() != null);
                    b8.a(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
    }

    public Texture j(c3 c3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c3Var)) == null) {
            return new Texture(c3Var, false);
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
