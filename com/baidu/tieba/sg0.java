package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public class sg0 extends qg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sg0() {
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

    @Override // com.baidu.tieba.pg0
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (this.e) {
                System.currentTimeMillis();
            }
            I();
            if (i != this.f || i2 != this.g) {
                this.f = i;
                this.g = i2;
                t(" w * h : " + i + " * " + i2);
                s();
            }
            if (i != 0 && i2 != 0) {
                q();
                mg0 mg0Var = this.c;
                if (mg0Var != null) {
                    mg0Var.g();
                }
                mg0 mg0Var2 = this.d;
                if (mg0Var2 != null) {
                    mg0Var2.g();
                }
            }
        }
    }

    @Override // com.baidu.tieba.pg0
    public int d(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaTrack, i, map)) == null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                u(e.toString(), e);
            }
            if (this.c != null && i != 0 && mediaTrack != null && this.m != null && this.l != null) {
                lg0 G = G(map, mediaTrack);
                if (G != null) {
                    return this.c.e(i, G);
                }
                return i;
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0099 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: float[] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pg0
    public int f(MediaTrack mediaTrack, int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaTrack, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            try {
                try {
                    if (this.c != null && mediaTrack != null && this.m != null && this.l != null) {
                        mg0 mg0Var = this.c;
                        float f = mediaTrack.glClearColor[0];
                        float f2 = mediaTrack.glClearColor[1];
                        float f3 = mediaTrack.glClearColor[2];
                        i3 = mediaTrack.glClearColor[3];
                        mg0Var.h(f, f2, f3, i3);
                        ArrayList arrayList = new ArrayList();
                        try {
                            if (mediaTrack.mediaSegments != null && mediaTrack.mediaSegments.size() > this.i) {
                                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(this.i);
                                if (i == 0) {
                                    i4 = mediaSegment.textureId;
                                } else {
                                    i4 = i;
                                }
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        if (i2 != 3) {
                                            if (i2 != 4) {
                                                if (i2 != 5) {
                                                    z = B(mediaTrack, mediaSegment, i4, map, arrayList);
                                                } else {
                                                    z = x(i4);
                                                }
                                            } else {
                                                C(map, arrayList, mediaTrack);
                                            }
                                        } else {
                                            z = A(mediaTrack, i4, map);
                                        }
                                    } else {
                                        z = y(mediaSegment, i4, map);
                                    }
                                } else {
                                    z = z(mediaSegment, i4, map);
                                }
                                i4 = z;
                            } else {
                                i4 = i;
                            }
                            if (i4 != 0 && arrayList.size() > 0) {
                                i4 = this.c.f(i4, arrayList);
                            }
                            return i4;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            u(e.toString(), e);
                            mg0 mg0Var2 = this.c;
                            if (mg0Var2 != null) {
                                mg0Var2.h(0.0f, 0.0f, 0.0f, 0.0f);
                            }
                            return i3;
                        }
                    }
                    mg0 mg0Var3 = this.c;
                    if (mg0Var3 != null) {
                        mg0Var3.h(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    return i;
                } catch (Exception e2) {
                    e = e2;
                    i3 = i;
                }
            } finally {
                mg0 mg0Var4 = this.c;
                if (mg0Var4 != null) {
                    mg0Var4.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        } else {
            return invokeCommon.intValue;
        }
    }

    @Override // com.baidu.tieba.pg0
    public int h(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, mediaSegment, i, map)) == null) {
            if (mediaSegment == null) {
                return i;
            }
            return r(mediaSegment, i, map);
        }
        return invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        if (r8 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        r8.h(0.0f, 0.0f, 0.0f, 0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r8 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
        return r9;
     */
    @Override // com.baidu.tieba.pg0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        mg0 mg0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, mediaTrack, i, map)) == null) {
            try {
                try {
                    if (this.c != null && mediaTrack != null && this.m != null && this.l != null) {
                        this.c.h(mediaTrack.glClearColor[0], mediaTrack.glClearColor[1], mediaTrack.glClearColor[2], mediaTrack.glClearColor[3]);
                        ArrayList arrayList = new ArrayList();
                        i = D(map, arrayList, mediaTrack, i);
                        if (i != 0 && arrayList.size() > 0) {
                            return this.c.f(i, arrayList);
                        }
                        mg0Var = this.c;
                    }
                    mg0 mg0Var2 = this.c;
                    if (mg0Var2 != null) {
                        mg0Var2.h(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    return i;
                } catch (Exception e) {
                    e.printStackTrace();
                    u(e.toString(), e);
                    mg0Var = this.c;
                }
            } finally {
                mg0 mg0Var3 = this.c;
                if (mg0Var3 != null) {
                    mg0Var3.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        } else {
            return invokeLIL.intValue;
        }
    }

    @Override // com.baidu.tieba.pg0
    public int k(int i, float[] fArr, float[] fArr2, int i2, int i3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})) == null) {
            if (i == 0 || this.m == null) {
                return i;
            }
            Map<String, ShaderConfig> map = this.l;
            if (map != null && !map.containsKey(xg0.g)) {
                this.l.put(xg0.g, ShaderConfig.getGaussianBlurHShaderConfig(f));
                this.l.put(xg0.h, ShaderConfig.getGaussianBlurVShaderConfig(f));
                Map<String, lg0> l = vg0.l(this.a, this.l);
                for (Map.Entry<String, lg0> entry : l.entrySet()) {
                    lg0 value = entry.getValue();
                    value.l();
                    value.v(i2, i3);
                }
                this.m.putAll(l);
            }
            if (this.d == null) {
                this.d = new mg0();
            }
            this.d.g();
            this.d.c(i2, i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m.get(xg0.g));
            arrayList.add(this.m.get(xg0.h));
            float[] fArr3 = fArr;
            float[] fArr4 = fArr2;
            int i4 = 0;
            while (i4 < arrayList.size()) {
                lg0 lg0Var = (lg0) arrayList.get(i4);
                lg0Var.v(i2, i3);
                if (i4 == 0) {
                    lg0Var.e(GLES20.glGetUniformLocation(lg0Var.j(), "wRatio"), "wRatio", new ShaderParams("wRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f}));
                } else {
                    lg0Var.e(GLES20.glGetUniformLocation(lg0Var.j(), "hRatio"), "hRatio", new ShaderParams("hRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f}));
                }
                w(lg0Var, fArr3, fArr4, null);
                i4++;
                fArr3 = null;
                fArr4 = null;
            }
            return this.d.f(i, arrayList);
        }
        return invokeCommon.intValue;
    }
}
