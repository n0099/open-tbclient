package com.baidu.tieba;

import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
/* loaded from: classes5.dex */
public class kf0 extends hf0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String G = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n";
    public static int[] H;
    public static int I;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public int[] B;
    public int[] C;
    public FloatBuffer D;
    public List<Integer> E;
    public int F;

    @Override // com.baidu.tieba.hf0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ kf0 b;

        public a(kf0 kf0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kf0Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kf0Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.E = this.a;
                for (int i = 0; i < this.a.size(); i++) {
                    this.b.C[i] = ((Integer) this.a.get(i)).intValue();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947911028, "Lcom/baidu/tieba/kf0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947911028, "Lcom/baidu/tieba/kf0;");
                return;
            }
        }
        H = new int[]{33987, 33988, 33989, 33990, 33991, 33992, 33993, 33994, 33995, 33996};
        I = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kf0(String str, String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.F = 3553;
        if (!TextUtils.isEmpty(str2) && str2.contains("samplerExternalOES")) {
            this.F = 36197;
        }
        int i3 = I;
        this.A = new int[i3];
        this.B = new int[i3];
        this.C = new int[i3];
        for (int i4 = 0; i4 < I; i4++) {
            this.C[i4] = -1;
        }
        this.D = ByteBuffer.allocateDirect(pf0.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        X(Rotation.NORMAL, false, false);
    }

    public void Y(List<Integer> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null && list.size() != 0) {
            B(new a(this, list));
        }
    }

    public static String W(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (I <= H.length) {
                I = i;
                StringBuilder sb = new StringBuilder(G);
                for (int i2 = 0; i2 < i; i2++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("attribute vec4 inputTextureCoordinate");
                    int i3 = i2 + 2;
                    sb2.append(i3);
                    sb.append(sb2.toString());
                    sb.append(";\n");
                    sb.append("varying vec2 textureCoordinate" + i3);
                    sb.append(";\n");
                }
                sb.append("\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n");
                for (int i4 = 0; i4 < i; i4++) {
                    sb.append("    ");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("textureCoordinate");
                    int i5 = i4 + 2;
                    sb3.append(i5);
                    sb.append(sb3.toString());
                    sb.append(" = ");
                    sb.append("inputTextureCoordinate" + i5);
                    sb.append(".xy");
                    sb.append(";\n");
                }
                sb.append("}");
                return sb.toString();
            }
            throw new RuntimeException("too many textures !!!");
        }
        return (String) invokeI.objValue;
    }

    public void X(Rotation rotation, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rotation, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.D.clear();
            this.D.put(pf0.b(rotation, z, z2)).position(0);
        }
    }

    @Override // com.baidu.tieba.hf0
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = 0;
            while (true) {
                int[] iArr = this.A;
                if (i < iArr.length) {
                    GLES20.glDisableVertexAttribArray(iArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.hf0
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.u();
            List<Integer> list = this.E;
            if (list != null) {
                Y(list);
            }
        }
    }

    @Override // com.baidu.tieba.hf0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = 0;
            while (true) {
                int[] iArr = this.A;
                if (i < iArr.length) {
                    if (this.C[i] != -1) {
                        GLES20.glEnableVertexAttribArray(iArr[i]);
                        GLES20.glActiveTexture(H[i]);
                        GLES20.glBindTexture(this.F, this.C[i]);
                        GLES20.glUniform1i(this.B[i], i + 3);
                        this.D.position(0);
                        GLES20.glVertexAttribPointer(this.A[i], 2, 5126, false, 0, (Buffer) this.D);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.hf0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.t();
            int i = 0;
            while (true) {
                int[] iArr = this.A;
                if (i < iArr.length) {
                    int j = j();
                    StringBuilder sb = new StringBuilder();
                    sb.append("inputTextureCoordinate");
                    int i2 = i + 2;
                    sb.append(i2);
                    iArr[i] = GLES20.glGetAttribLocation(j, sb.toString());
                    int[] iArr2 = this.B;
                    int j2 = j();
                    iArr2[i] = GLES20.glGetUniformLocation(j2, "inputImageTexture" + i2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
