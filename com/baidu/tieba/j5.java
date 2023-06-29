package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j5 implements TextureData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c3 a;
    public int b;
    public int c;
    public Pixmap.Format d;
    public Pixmap e;
    public boolean f;
    public boolean g;

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public j5(c3 c3Var, Pixmap pixmap, Pixmap.Format format, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c3Var, pixmap, format, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        this.g = false;
        this.a = c3Var;
        this.e = pixmap;
        this.d = format;
        this.f = z;
        if (pixmap != null) {
            this.b = pixmap.n();
            this.c = this.e.l();
            if (format == null) {
                this.d = this.e.h();
            }
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            throw new GdxRuntimeException("This TextureData implementation does not upload data itself");
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g) {
                this.g = false;
                Pixmap pixmap = this.e;
                this.e = null;
                return pixmap;
            }
            throw new GdxRuntimeException("Call prepare() before calling getPixmap()");
        }
        return (Pixmap) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap.Format d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Pixmap.Format) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public TextureData.TextureDataType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TextureData.TextureDataType.Pixmap;
        }
        return (TextureData.TextureDataType) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.g) {
                if (this.e == null) {
                    if (this.a.d().equals("cim")) {
                        this.e = i3.a(this.a);
                    } else {
                        this.e = new Pixmap(this.a);
                    }
                    this.b = this.e.n();
                    this.c = this.e.l();
                    if (this.d == null) {
                        this.d = this.e.h();
                    }
                }
                this.g = true;
                return;
            }
            throw new GdxRuntimeException("Already prepared");
        }
    }
}
