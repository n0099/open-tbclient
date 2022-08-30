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
/* loaded from: classes4.dex */
public class j3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public Files.FileType b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(253246567, "Lcom/baidu/tieba/j3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(253246567, "Lcom/baidu/tieba/j3$a;");
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

    public j3() {
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

    public j3 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.getPath().length() == 0 ? new j3(new File(str), this.b) : new j3(new File(this.a, str), this.b) : (j3) invokeL.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int f = (int) f();
            if (f != 0) {
                return f;
            }
            return 512;
        }
        return invokeV.intValue;
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
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH));
            return j3.class.getResource(sb.toString()) != null;
        }
        return invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String name = this.a.getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
        }
        return (String) invokeV.objValue;
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

    public File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b == Files.FileType.External ? new File(e1.d.e(), this.a.getPath()) : this.a : (File) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof j3) {
                j3 j3Var = (j3) obj;
                return this.b == j3Var.b && j().equals(j3Var.j());
            }
            return false;
        }
        return invokeL.booleanValue;
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
                i8.a(m);
                return available;
            } catch (Exception unused) {
                i8.a(m);
                return 0L;
            } catch (Throwable th) {
                i8.a(m);
                throw th;
            }
        }
        return invokeV.longValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getName() : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String name = this.a.getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((37 + this.b.hashCode()) * 67) + j().hashCode() : invokeV.intValue;
    }

    public j3 i() {
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
            return new j3(parentFile, this.b);
        }
        return (j3) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH) : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String replace = this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH);
            int lastIndexOf = replace.lastIndexOf(46);
            return lastIndexOf == -1 ? replace : replace.substring(0, lastIndexOf);
        }
        return (String) invokeV.objValue;
    }

    public BufferedInputStream l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) ? new BufferedInputStream(m(), i) : (BufferedInputStream) invokeI.objValue;
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
            InputStream resourceAsStream = j3.class.getResourceAsStream("/" + this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH));
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new GdxRuntimeException("File not found: " + this.a + " (" + this.b + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (InputStream) invokeV.objValue;
    }

    public byte[] n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputStream m = m();
            try {
                try {
                    return i8.d(m, b());
                } catch (IOException e) {
                    throw new GdxRuntimeException("Error reading file: " + this, e);
                }
            } finally {
                i8.a(m);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? p(null) : (String) invokeV.objValue;
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048594, this, str)) != null) {
            return (String) invokeL.objValue;
        }
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
                        i8.a(inputStreamReader);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading layout file: " + this, e);
            }
        } catch (Throwable th) {
            i8.a(inputStreamReader);
            throw th;
        }
    }

    public BufferedReader q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) ? new BufferedReader(new InputStreamReader(m()), i) : (BufferedReader) invokeI.objValue;
    }

    public Reader r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            InputStream m = m();
            try {
                return new InputStreamReader(m, str);
            } catch (UnsupportedEncodingException e) {
                i8.a(m);
                throw new GdxRuntimeException("Error reading file: " + this, e);
            }
        }
        return (Reader) invokeL.objValue;
    }

    public j3 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (this.a.getPath().length() != 0) {
                return new j3(new File(this.a.getParent(), str), this.b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (j3) invokeL.objValue;
    }

    public Files.FileType t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.b : (Files.FileType) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.getPath().replace('\\', WebvttCueParser.CHAR_SLASH) : (String) invokeV.objValue;
    }

    public j3(String str, Files.FileType fileType) {
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

    public j3(File file, Files.FileType fileType) {
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
}
