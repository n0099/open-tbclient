package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
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
public class y3 implements i7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b7<ParticleEmitter> a;
    public boolean b;

    public y3() {
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
        this.a = new b7<>(8);
    }

    public void a(k3 k3Var, k3 k3Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, k3Var, k3Var2) == null) {
            i(k3Var);
            g(k3Var2);
        }
    }

    @Override // com.baidu.tieba.i7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.b) {
            return;
        }
        int i = this.a.b;
        for (int i2 = 0; i2 < i; i2++) {
            b7.b<b4> it = this.a.get(i2).g().iterator();
            while (it.hasNext()) {
                it.next().f().dispose();
            }
        }
    }

    public void f(k3 k3Var, c4 c4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, k3Var, c4Var, str) == null) {
            i(k3Var);
            h(c4Var, str);
        }
    }

    public void g(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k3Var) == null) {
            this.b = true;
            x7 x7Var = new x7(this.a.b);
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    b7<b4> b7Var = new b7<>();
                    b7.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        b4 b4Var = (b4) x7Var.c(name);
                        if (b4Var == null) {
                            b4Var = new b4(j(k3Var.a(name)));
                            x7Var.i(name, b4Var);
                        }
                        b7Var.a(b4Var);
                    }
                    particleEmitter.u(b7Var);
                }
            }
        }
    }

    public void h(c4 c4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, c4Var, str) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    b7<b4> b7Var = new b7<>();
                    b7.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        b4 a = c4Var.a(name);
                        if (a != null) {
                            b7Var.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(b7Var);
                }
            }
        }
    }

    public void i(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, k3Var) == null) {
            InputStream m = k3Var.m();
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
                            throw new GdxRuntimeException("Error loading effect: " + k3Var, e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            j8.a(bufferedReader);
                            throw th;
                        }
                    } while (bufferedReader2.readLine() != null);
                    j8.a(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
    }

    public Texture j(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k3Var)) == null) {
            return new Texture(k3Var, false);
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
