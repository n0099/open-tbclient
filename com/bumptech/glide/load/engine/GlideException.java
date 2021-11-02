package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes11.dex */
public final class GlideException extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final StackTraceElement[] EMPTY_ELEMENTS;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Throwable> causes;
    public Class<?> dataClass;
    public DataSource dataSource;
    public String detailMessage;
    public Key key;

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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlideException(String str) {
        this(str, Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, appendable) == null) {
            try {
                appendCausesWrapped(list, appendable);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, appendable) == null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
                Throwable th = list.get(i2);
                if (th instanceof GlideException) {
                    ((GlideException) th).printStackTrace(appendable);
                } else {
                    appendExceptionMessage(th, appendable);
                }
                i2 = i3;
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

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Throwable) invokeV.objValue;
    }

    public List<Throwable> getCauses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.causes : (List) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder(71);
            sb.append(this.detailMessage);
            sb.append(this.dataClass != null ? StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataClass : "");
            sb.append(this.dataSource != null ? StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataSource : "");
            sb.append(this.key != null ? StringUtil.ARRAY_ELEMENT_SEPARATOR + this.key : "");
            List<Throwable> rootCauses = getRootCauses();
            if (rootCauses.isEmpty()) {
                return sb.toString();
            }
            if (rootCauses.size() == 1) {
                sb.append("\nThere was 1 cause:");
            } else {
                sb.append("\nThere were ");
                sb.append(rootCauses.size());
                sb.append(" causes:");
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

    public List<Throwable> getRootCauses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            addRootCauses(this, arrayList);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void logRootCauses(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            List<Throwable> rootCauses = getRootCauses();
            int size = rootCauses.size();
            int i2 = 0;
            while (i2 < size) {
                StringBuilder sb = new StringBuilder();
                sb.append("Root cause (");
                int i3 = i2 + 1;
                sb.append(i3);
                sb.append(" of ");
                sb.append(size);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.toString();
                rootCauses.get(i2);
                i2 = i3;
            }
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            printStackTrace(System.err);
        }
    }

    public void setLoggingDetails(Key key, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, key, dataSource) == null) {
            setLoggingDetails(key, dataSource, null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, printStream) == null) {
            printStackTrace((Appendable) printStream);
        }
    }

    public void setLoggingDetails(Key key, DataSource dataSource, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, key, dataSource, cls) == null) {
            this.key = key;
            this.dataSource = dataSource;
            this.dataClass = cls;
        }
    }

    public GlideException(String str, List<Throwable> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, printWriter) == null) {
            printStackTrace((Appendable) printWriter);
        }
    }

    private void printStackTrace(Appendable appendable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, appendable) == null) {
            appendExceptionMessage(this, appendable);
            appendCauses(getCauses(), new IndentedAppendable(appendable));
        }
    }

    /* loaded from: classes11.dex */
    public static final class IndentedAppendable implements Appendable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EMPTY_SEQUENCE = "";
        public static final String INDENT = "  ";
        public transient /* synthetic */ FieldHolder $fh;
        public final Appendable appendable;
        public boolean printedNewLine;

        public IndentedAppendable(Appendable appendable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appendable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.printedNewLine = true;
            this.appendable = appendable;
        }

        @NonNull
        private CharSequence safeSequence(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, charSequence)) == null) ? charSequence == null ? "" : charSequence : (CharSequence) invokeL.objValue;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)})) == null) {
                if (this.printedNewLine) {
                    this.printedNewLine = false;
                    this.appendable.append(INDENT);
                }
                this.printedNewLine = c2 == '\n';
                this.appendable.append(c2);
                return this;
            }
            return (Appendable) invokeCommon.objValue;
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
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3)) == null) {
                CharSequence safeSequence = safeSequence(charSequence);
                boolean z = false;
                if (this.printedNewLine) {
                    this.printedNewLine = false;
                    this.appendable.append(INDENT);
                }
                if (safeSequence.length() > 0 && safeSequence.charAt(i3 - 1) == '\n') {
                    z = true;
                }
                this.printedNewLine = z;
                this.appendable.append(safeSequence, i2, i3);
                return this;
            }
            return (Appendable) invokeLII.objValue;
        }
    }
}
