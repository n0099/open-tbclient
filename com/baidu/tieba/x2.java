package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes8.dex */
public class x2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public Files.FileType b;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(266146070, "Lcom/baidu/tieba/x2$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(266146070, "Lcom/baidu/tieba/x2$a;");
                    return;
                }
            }
            int[] iArr = new int[Files.FileType.values().length];
            a = iArr;
            try {
                iArr[Files.FileType.Internal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Files.FileType.Classpath.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Files.FileType.Absolute.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Files.FileType.External.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public x2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int f = (int) f();
            if (f == 0) {
                return 512;
            }
            return f;
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String name = this.a.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return "";
            }
            return name.substring(lastIndexOf + 1);
        }
        return (String) invokeV.objValue;
    }

    public File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b == Files.FileType.External) {
                return new File(s0.d.e(), this.a.getPath());
            }
            return this.a;
        }
        return (File) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.getName();
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String name = this.a.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return name;
            }
            return name.substring(0, lastIndexOf);
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ((37 + this.b.hashCode()) * 67) + j().hashCode();
        }
        return invokeV.intValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH);
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String replace = this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH);
            int lastIndexOf = replace.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return replace;
            }
            return replace.substring(0, lastIndexOf);
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return p(null);
        }
        return (String) invokeV.objValue;
    }

    public Files.FileType t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.b;
        }
        return (Files.FileType) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH);
        }
        return (String) invokeV.objValue;
    }

    public x2(File file, Files.FileType fileType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, fileType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = file;
        this.b = fileType;
    }

    public x2(String str, Files.FileType fileType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, fileType};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = fileType;
        this.a = new File(str);
    }

    public x2 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.getPath().length() == 0) {
                return new x2(new File(str), this.b);
            }
            return new x2(new File(this.a, str), this.b);
        }
        return (x2) invokeL.objValue;
    }

    public Reader r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            InputStream m = m();
            try {
                return new InputStreamReader(m, str);
            } catch (UnsupportedEncodingException e) {
                w7.a(m);
                throw new GdxRuntimeException("Error reading file: " + this, e);
            }
        }
        return (Reader) invokeL.objValue;
    }

    public x2 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (this.a.getPath().length() != 0) {
                return new x2(new File(this.a.getParent(), str), this.b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (x2) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = a.a[this.b.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return e().exists();
                }
            } else if (e().exists()) {
                return true;
            }
            if (x2.class.getResource("/" + this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH)) != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Files.FileType fileType = this.b;
            if (fileType != Files.FileType.Classpath) {
                if (fileType != Files.FileType.Internal) {
                    return e().delete();
                }
                throw new GdxRuntimeException("Cannot delete an internal file: " + this.a);
            }
            throw new GdxRuntimeException("Cannot delete a classpath file: " + this.a);
        }
        return invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (!(obj instanceof x2)) {
                return false;
            }
            x2 x2Var = (x2) obj;
            if (this.b != x2Var.b || !j().equals(x2Var.j())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public BufferedInputStream l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            return new BufferedInputStream(m(), i);
        }
        return (BufferedInputStream) invokeI.objValue;
    }

    public BufferedReader q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            return new BufferedReader(new InputStreamReader(m()), i);
        }
        return (BufferedReader) invokeI.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Files.FileType fileType = this.b;
            if (fileType != Files.FileType.Classpath && (fileType != Files.FileType.Internal || this.a.exists())) {
                return e().length();
            }
            InputStream m = m();
            try {
                long available = m.available();
                w7.a(m);
                return available;
            } catch (Exception unused) {
                w7.a(m);
                return 0L;
            } catch (Throwable th) {
                w7.a(m);
                throw th;
            }
        }
        return invokeV.longValue;
    }

    public x2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null) {
                if (this.b == Files.FileType.Absolute) {
                    parentFile = new File("/");
                } else {
                    parentFile = new File("");
                }
            }
            return new x2(parentFile, this.b);
        }
        return (x2) invokeV.objValue;
    }

    public byte[] n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputStream m = m();
            try {
                try {
                    return w7.d(m, b());
                } catch (IOException e) {
                    throw new GdxRuntimeException("Error reading file: " + this, e);
                }
            } finally {
                w7.a(m);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public InputStream m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Files.FileType fileType = this.b;
            if (fileType != Files.FileType.Classpath && ((fileType != Files.FileType.Internal || e().exists()) && (this.b != Files.FileType.Local || e().exists()))) {
                try {
                    return new FileInputStream(e());
                } catch (Exception e) {
                    if (e().isDirectory()) {
                        throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.a + " (" + this.b + SmallTailInfo.EMOTION_SUFFIX, e);
                    }
                    throw new GdxRuntimeException("Error reading file: " + this.a + " (" + this.b + SmallTailInfo.EMOTION_SUFFIX, e);
                }
            }
            InputStream resourceAsStream = x2.class.getResourceAsStream("/" + this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH));
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new GdxRuntimeException("File not found: " + this.a + " (" + this.b + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (InputStream) invokeV.objValue;
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            StringBuilder sb = new StringBuilder(b());
            InputStreamReader inputStreamReader = null;
            try {
                try {
                    if (str == null) {
                        inputStreamReader = new InputStreamReader(m());
                    } else {
                        inputStreamReader = new InputStreamReader(m(), str);
                    }
                    char[] cArr = new char[256];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            w7.a(inputStreamReader);
                            return sb.toString();
                        }
                        sb.append(cArr, 0, read);
                    }
                } catch (IOException e) {
                    throw new GdxRuntimeException("Error reading layout file: " + this, e);
                }
            } catch (Throwable th) {
                w7.a(inputStreamReader);
                throw th;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
