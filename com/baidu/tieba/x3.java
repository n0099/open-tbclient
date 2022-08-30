package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a7;
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
/* loaded from: classes6.dex */
public class x3 implements h7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a7<ParticleEmitter> a;
    public boolean b;

    public x3() {
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
        this.a = new a7<>(8);
    }

    public void a(j3 j3Var, j3 j3Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, j3Var, j3Var2) == null) {
            i(j3Var);
            g(j3Var2);
        }
    }

    @Override // com.baidu.tieba.h7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                a7.b<a4> it = this.a.get(i2).g().iterator();
                while (it.hasNext()) {
                    it.next().f().dispose();
                }
            }
        }
    }

    public void f(j3 j3Var, b4 b4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, j3Var, b4Var, str) == null) {
            i(j3Var);
            h(b4Var, str);
        }
    }

    public void g(j3 j3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, j3Var) == null) {
            this.b = true;
            w7 w7Var = new w7(this.a.b);
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    a7<a4> a7Var = new a7<>();
                    a7.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        a4 a4Var = (a4) w7Var.c(name);
                        if (a4Var == null) {
                            a4Var = new a4(j(j3Var.a(name)));
                            w7Var.i(name, a4Var);
                        }
                        a7Var.a(a4Var);
                    }
                    particleEmitter.u(a7Var);
                }
            }
        }
    }

    public void h(b4 b4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, b4Var, str) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    a7<a4> a7Var = new a7<>();
                    a7.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        a4 a = b4Var.a(name);
                        if (a != null) {
                            a7Var.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(a7Var);
                }
            }
        }
    }

    public void i(j3 j3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, j3Var) != null) {
            return;
        }
        InputStream m = j3Var.m();
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
                        throw new GdxRuntimeException("Error loading effect: " + j3Var, e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        i8.a(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader2.readLine() != null);
                i8.a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public Texture j(j3 j3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, j3Var)) == null) ? new Texture(j3Var, false) : (Texture) invokeL.objValue;
    }

    public ParticleEmitter k(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bufferedReader)) == null) ? new ParticleEmitter(bufferedReader) : (ParticleEmitter) invokeL.objValue;
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
