package com.baidu.tieba;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class p2 extends a2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean d;
    public long e;
    public t2 f;
    public String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(File file, Files.FileType fileType) {
        super((AssetManager) null, file, fileType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, fileType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (File) objArr2[1], (Files.FileType) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(String str) {
        super((AssetManager) null, str, Files.FileType.Internal);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (String) objArr2[1], (Files.FileType) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        w();
    }

    @Override // com.baidu.tieba.a2, com.baidu.tieba.x2
    public x2 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.getPath().length() == 0) {
                return new p2(new File(str), this.b);
            }
            return new p2(new File(this.a, str), this.b);
        }
        return (x2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a2, com.baidu.tieba.x2
    public x2 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (this.a.getPath().length() != 0) {
                return s0.d.d(new File(this.a.getParent(), str).getPath(), this.b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (x2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a2, com.baidu.tieba.x2
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.d && this.f.b(v()).length == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a2, com.baidu.tieba.x2
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d) {
                return this.e;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.a2, com.baidu.tieba.x2
    public x2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null) {
                parentFile = new File("");
            }
            return new p2(parentFile.getPath());
        }
        return (x2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a2
    public AssetFileDescriptor u() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f.a(v());
        }
        return (AssetFileDescriptor) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return !this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a2, com.baidu.tieba.x2
    public InputStream m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return this.f.c(v());
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading file: " + this.a + " (ZipResourceFile)", e);
            }
        }
        return (InputStream) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH);
            t2 c = ((b2) s0.d).c();
            this.f = c;
            AssetFileDescriptor a = c.a(v());
            if (a != null) {
                this.d = true;
                this.e = a.getLength();
                try {
                    a.close();
                } catch (IOException unused) {
                }
            } else {
                this.d = false;
            }
            if (x()) {
                this.g += "/";
            }
        }
    }
}
