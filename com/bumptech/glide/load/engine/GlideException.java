package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class GlideException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final StackTraceElement[] EMPTY_ELEMENTS;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Throwable> causes;
    public Class<?> dataClass;
    public DataSource dataSource;
    public String detailMessage;
    @Nullable
    public Exception exception;
    public Key key;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Throwable) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class IndentedAppendable implements Appendable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EMPTY_SEQUENCE = "";
        public static final String INDENT = "  ";
        public transient /* synthetic */ FieldHolder $fh;
        public final Appendable appendable;
        public boolean printedNewLine;

        @NonNull
        private CharSequence safeSequence(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, charSequence)) == null) ? charSequence == null ? "" : charSequence : (CharSequence) invokeL.objValue;
        }

        public IndentedAppendable(Appendable appendable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appendable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.printedNewLine = true;
            this.appendable = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
                CharSequence safeSequence = safeSequence(charSequence);
                return append(safeSequence, 0, safeSequence.length());
            }
            return (Appendable) invokeL.objValue;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c)})) == null) {
                boolean z = false;
                if (this.printedNewLine) {
                    this.printedNewLine = false;
                    this.appendable.append(INDENT);
                }
                if (c == '\n') {
                    z = true;
                }
                this.printedNewLine = z;
                this.appendable.append(c);
                return this;
            }
            return (Appendable) invokeCommon.objValue;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i, int i2) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2)) == null) {
                CharSequence safeSequence = safeSequence(charSequence);
                boolean z = false;
                if (this.printedNewLine) {
                    this.printedNewLine = false;
                    this.appendable.append(INDENT);
                }
                if (safeSequence.length() > 0 && safeSequence.charAt(i2 - 1) == '\n') {
                    z = true;
                }
                this.printedNewLine = z;
                this.appendable.append(safeSequence, i, i2);
                return this;
            }
            return (Appendable) invokeLII.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-325035686, "Lcom/bumptech/glide/load/engine/GlideException;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-325035686, "Lcom/bumptech/glide/load/engine/GlideException;");
                return;
            }
        }
        EMPTY_ELEMENTS = new StackTraceElement[0];
    }

    public List<Throwable> getCauses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.causes;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public Exception getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.exception;
        }
        return (Exception) invokeV.objValue;
    }

    public List<Throwable> getRootCauses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            addRootCauses(this, arrayList);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            printStackTrace(System.err);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlideException(String str) {
        this(str, Collections.emptyList());
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
                this((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void logRootCauses(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            List<Throwable> rootCauses = getRootCauses();
            int size = rootCauses.size();
            int i = 0;
            while (i < size) {
                StringBuilder sb = new StringBuilder();
                sb.append("Root cause (");
                int i2 = i + 1;
                sb.append(i2);
                sb.append(" of ");
                sb.append(size);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                Log.i(str, sb.toString(), rootCauses.get(i));
                i = i2;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, th};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static void appendExceptionMessage(Throwable th, Appendable appendable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, th, appendable) == null) {
            try {
                appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
            } catch (IOException unused) {
                throw new RuntimeException(th);
            }
        }
    }

    public GlideException(String str, List<Throwable> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, th, list) == null) {
            if (th instanceof GlideException) {
                for (Throwable th2 : ((GlideException) th).getCauses()) {
                    addRootCauses(th2, list);
                }
                return;
            }
            list.add(th);
        }
    }

    public static void appendCauses(List<Throwable> list, Appendable appendable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, appendable) == null) {
            try {
                appendCausesWrapped(list, appendable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoggingDetails(Key key, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, key, dataSource) == null) {
            setLoggingDetails(key, dataSource, null);
        }
    }

    public static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, appendable) == null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
                Throwable th = list.get(i);
                if (th instanceof GlideException) {
                    ((GlideException) th).printStackTrace(appendable);
                } else {
                    appendExceptionMessage(th, appendable);
                }
                i = i2;
            }
        }
    }

    private void printStackTrace(Appendable appendable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, appendable) == null) {
            appendExceptionMessage(this, appendable);
            appendCauses(getCauses(), new IndentedAppendable(appendable));
        }
    }

    public void setOrigin(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, exc) == null) {
            this.exception = exc;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder(71);
            sb.append(this.detailMessage);
            String str3 = "";
            if (this.dataClass == null) {
                str = "";
            } else {
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataClass;
            }
            sb.append(str);
            if (this.dataSource == null) {
                str2 = "";
            } else {
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataSource;
            }
            sb.append(str2);
            if (this.key != null) {
                str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + this.key;
            }
            sb.append(str3);
            List<Throwable> rootCauses = getRootCauses();
            if (rootCauses.isEmpty()) {
                return sb.toString();
            }
            if (rootCauses.size() == 1) {
                sb.append("\nThere was 1 root cause:");
            } else {
                sb.append("\nThere were ");
                sb.append(rootCauses.size());
                sb.append(" root causes:");
            }
            for (Throwable th : rootCauses) {
                sb.append('\n');
                sb.append(th.getClass().getName());
                sb.append('(');
                sb.append(th.getMessage());
                sb.append(')');
            }
            sb.append("\n call GlideException#logRootCauses(String) for more detail");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, printStream) == null) {
            printStackTrace((Appendable) printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, printWriter) == null) {
            printStackTrace((Appendable) printWriter);
        }
    }

    public void setLoggingDetails(Key key, DataSource dataSource, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, key, dataSource, cls) == null) {
            this.key = key;
            this.dataSource = dataSource;
            this.dataClass = cls;
        }
    }
}
