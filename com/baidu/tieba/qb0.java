package com.baidu.tieba;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class qb0 implements pb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public volatile boolean b;
    public mb0 c;
    public mb0 d;
    public boolean e;
    public int f;
    public int g;
    public final LinkedList<Runnable> h;
    public int i;
    public long j;
    public List<MediaTrack> k;
    public Map<String, ShaderConfig> l;
    public Map<String, lb0> m;
    public boolean n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ qb0 c;

        public a(qb0 qb0Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb0Var, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qb0Var;
            this.a = i;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qb0 qb0Var = this.c;
                qb0Var.i = this.a;
                qb0Var.j = this.b;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ qb0 c;

        public b(qb0 qb0Var, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb0Var, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qb0Var;
            this.a = list;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.b) {
                    this.c.s();
                }
                qb0 qb0Var = this.c;
                qb0Var.k = this.a;
                qb0Var.l = this.b;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ qb0 b;

        public c(qb0 qb0Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb0Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qb0Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.k = this.a;
            }
        }
    }

    public qb0() {
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
        this.e = false;
        this.h = new LinkedList<>();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            while (!this.h.isEmpty()) {
                this.h.removeFirst().run();
            }
        }
    }

    @Override // com.baidu.tieba.pb0
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.pb0
    public List<MediaTrack> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb0
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            this.a = context;
        }
    }

    @Override // com.baidu.tieba.pb0
    public void n(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.h.add(new c(this, list));
        }
    }

    public void p(lb0 lb0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, lb0Var) == null) && !this.n && (lb0Var instanceof ob0)) {
            ((ob0) lb0Var).X(Rotation.NORMAL, false, true);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.e) {
            Log.d("zmy", "---> " + str);
        }
    }

    public int A(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        MediaSegment mediaSegment;
        lb0 F;
        int e;
        MediaSegment mediaSegment2;
        lb0 F2;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, mediaTrack, i, map)) == null) {
            if (this.i == 0 && (mediaSegment2 = mediaTrack.superpositionHeader) != null && ((TextUtils.equals(mediaSegment2.superpositionType, "all") || TextUtils.equals(mediaTrack.superpositionHeader.superpositionType, "without_trans")) && (F2 = F(mediaTrack.superpositionHeader, map)) != null && (e2 = this.c.e(i, F2)) != i)) {
                i = e2;
            }
            if (this.i == mediaTrack.mediaSegments.size() - 1 && (mediaSegment = mediaTrack.superpositionFooter) != null) {
                if ((TextUtils.equals(mediaSegment.superpositionType, "all") || TextUtils.equals(mediaTrack.superpositionFooter.superpositionType, "without_trans")) && (F = F(mediaTrack.superpositionFooter, map)) != null && (e = this.c.e(i, F)) != i) {
                    return e;
                }
                return i;
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int z(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        lb0 lb0Var;
        List<MediaTextureData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048606, this, mediaSegment, i, map)) == null) {
            String str = mediaSegment.lutConfigKey;
            if (!TextUtils.isEmpty(str)) {
                ShaderConfig shaderConfig = this.l.get(str);
                String str2 = null;
                if (shaderConfig != null && (list = shaderConfig.textures) != null) {
                    for (MediaTextureData mediaTextureData : list) {
                        if (mediaTextureData.textureId == 0 || !TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_LUT)) {
                            str = null;
                            break;
                        }
                        while (r0.hasNext()) {
                        }
                    }
                    str2 = str;
                }
                if (!TextUtils.isEmpty(str2) && (lb0Var = this.m.get(str2)) != null) {
                    v(lb0Var, map);
                    J(str2, lb0Var);
                    int e = this.c.e(i, lb0Var);
                    if (e != i) {
                        return e;
                    }
                    return i;
                }
                return i;
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    public int B(MediaTrack mediaTrack, MediaSegment mediaSegment, int i, Map<String, float[]> map, List<lb0> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaTrack, mediaSegment, Integer.valueOf(i), map, list})) == null) {
            int A = A(mediaTrack, y(mediaSegment, z(mediaSegment, i, map), map), map);
            C(map, list, mediaTrack);
            return A;
        }
        return invokeCommon.intValue;
    }

    public void C(Map<String, float[]> map, List<lb0> list, MediaTrack mediaTrack) {
        List<MediaTransition> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, map, list, mediaTrack) == null) && (list2 = mediaTrack.mediaTransitions) != null) {
            int size = list2.size();
            int i = this.i;
            if (size > i) {
                MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i);
                long j = mediaTransition.end;
                long j2 = mediaTransition.start;
                if (j - j2 > 0) {
                    long j3 = this.j;
                    if (j3 >= j2 && j3 <= j) {
                        String str = mediaTransition.shaderConfigKey;
                        if (!TextUtils.isEmpty(str)) {
                            H(this.i, mediaTrack, mediaTransition, map);
                            lb0 lb0Var = this.m.get(str);
                            if (lb0Var != null) {
                                v(lb0Var, map);
                                K(str, lb0Var, mediaTransition);
                                list.add(lb0Var);
                            }
                        }
                    }
                }
            }
        }
    }

    public lb0 E(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, mediaSegment, i, map)) == null) {
            if (i == 0) {
                i = mediaSegment.textureId;
            }
            lb0 lb0Var = null;
            if (i == 0) {
                return null;
            }
            int r = r(mediaSegment, i, map);
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str)) {
                List<MediaTextureData> list = this.l.get(str).textures;
                if (list != null) {
                    for (MediaTextureData mediaTextureData : list) {
                        mediaTextureData.textureId = r;
                    }
                }
                lb0Var = this.m.get(str);
                if (lb0Var != null) {
                    v(lb0Var, map);
                    J(str, lb0Var);
                    p(lb0Var);
                }
            }
            return lb0Var;
        }
        return (lb0) invokeLIL.objValue;
    }

    public void K(String str, lb0 lb0Var, MediaTransition mediaTransition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, str, lb0Var, mediaTransition) == null) && (lb0Var instanceof ob0)) {
            ArrayList arrayList = new ArrayList();
            for (MediaTextureData mediaTextureData : this.l.get(str).textures) {
                int i = mediaTextureData.textureId;
                if (i != 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            ((ob0) lb0Var).Y(arrayList);
            p(lb0Var);
            lb0Var.Q(mediaTransition.start, mediaTransition.end, mediaTransition.tParams);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r5 <= r14) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int D(Map<String, float[]> map, List<lb0> list, MediaTrack mediaTrack, int i) {
        InterceptResult invokeLLLI;
        int i2;
        boolean z;
        long j;
        lb0 lb0Var;
        lb0 lb0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, map, list, mediaTrack, i)) == null) {
            boolean m = xb0.m(mediaTrack, "effect");
            if (m) {
                i2 = mediaTrack.mediaSegments.size() - 1;
            } else {
                i2 = 0;
            }
            if (!m ? i2 < mediaTrack.mediaSegments.size() : i2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            int i3 = i2;
            int i4 = i;
            while (z2) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i3);
                if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                    long j2 = mediaSegment.start;
                    long j3 = mediaSegment.end;
                    if (j2 != j3) {
                        long j4 = this.j;
                        if (j4 >= j2) {
                        }
                    }
                    if (!m) {
                        i3--;
                    } else {
                        i3++;
                    }
                    if (m ? i3 < mediaTrack.mediaSegments.size() : i3 >= 0) {
                        z2 = true;
                    }
                }
                if (!m && !xb0.m(mediaTrack, "template_effect") && mediaSegment.mediaAEffect != null) {
                    int e = this.c.e(i4, E(mediaSegment, mediaSegment.textureId, map));
                    if (e != i4) {
                        i4 = e;
                    }
                } else {
                    String str = mediaSegment.shaderConfigKey;
                    if (!TextUtils.isEmpty(str) && (lb0Var2 = this.m.get(str)) != null) {
                        v(lb0Var2, map);
                        J(str, lb0Var2);
                        p(lb0Var2);
                        list.add(lb0Var2);
                    }
                    MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
                    if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                        MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                        if (mediaAEffect2.duration > 0) {
                            String str2 = mediaAEffect2.shaderConfigKey;
                            long j5 = mediaSegment.effectStart;
                            if (j5 <= 0) {
                                j5 = mediaSegment.start;
                            }
                            long j6 = j5;
                            long j7 = mediaSegment.effectEnd;
                            if (j7 > 0) {
                                j = j7;
                            } else {
                                j = mediaSegment.end;
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                long j8 = this.j;
                                if (j8 >= j6 && j8 <= j && (lb0Var = this.m.get(str2)) != null) {
                                    v(lb0Var, map);
                                    J(str2, lb0Var);
                                    p(lb0Var);
                                    lb0Var.F(mediaAEffect2.effectType, j6, j, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                    list.add(lb0Var);
                                }
                            }
                        }
                    }
                }
                if (m) {
                    break;
                }
                if (!m) {
                }
                z2 = m ? false : false;
            }
            return i4;
        }
        return invokeLLLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r5 <= r3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final lb0 F(MediaSegment mediaSegment, Map<String, float[]> map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, mediaSegment, map)) == null) {
            if (mediaSegment == null) {
                return null;
            }
            if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                long j = mediaSegment.start;
                long j2 = mediaSegment.end;
                if (j != j2) {
                    long j3 = this.j;
                    if (j3 >= j) {
                    }
                }
                z = false;
                if (z) {
                    return null;
                }
                return E(mediaSegment, mediaSegment.textureId, map);
            }
            z = true;
            if (z) {
            }
        } else {
            return (lb0) invokeLL.objValue;
        }
    }

    public lb0 G(Map<String, float[]> map, MediaTrack mediaTrack) {
        InterceptResult invokeLL;
        lb0 F;
        lb0 F2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, map, mediaTrack)) == null) {
            if (mediaTrack != null) {
                MediaSegment mediaSegment = mediaTrack.superpositionHeader;
                if (mediaSegment != null && TextUtils.equals(mediaSegment.superpositionType, "self") && (F2 = F(mediaTrack.superpositionHeader, map)) != null) {
                    return F2;
                }
                MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                if (mediaSegment2 != null && TextUtils.equals(mediaSegment2.superpositionType, "self") && (F = F(mediaTrack.superpositionFooter, map)) != null) {
                    return F;
                }
                return null;
            }
            return null;
        }
        return (lb0) invokeLL.objValue;
    }

    public void H(int i, MediaTrack mediaTrack, MediaTransition mediaTransition, Map<String, float[]> map) {
        int i2;
        List<MediaTextureData> list;
        lb0 F;
        int e;
        List<MediaTextureData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), mediaTrack, mediaTransition, map}) == null) {
            ShaderConfig shaderConfig = this.l.get(mediaTransition.shaderConfigKey);
            if (shaderConfig != null && (list2 = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData : list2) {
                    if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                        i2 = mediaTextureData.textureId;
                        break;
                    }
                }
            }
            i2 = 0;
            if (i2 == 0) {
                return;
            }
            int i3 = i + 1;
            if (mediaTrack.mediaSegments.size() > i3) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i3);
                i2 = y(mediaSegment, x(z(mediaSegment, i2, map)), map);
                MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                if (mediaSegment2 != null && TextUtils.equals(mediaSegment2.superpositionType, "all") && (F = F(mediaTrack.superpositionFooter, map)) != null && (e = this.c.e(i2, F)) != i2) {
                    i2 = e;
                }
            }
            if (shaderConfig != null && (list = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData2 : list) {
                    if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData2.type)) {
                        mediaTextureData2.textureId = i2;
                        return;
                    }
                }
            }
        }
    }

    public void J(String str, lb0 lb0Var) {
        ShaderConfig shaderConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, lb0Var) == null) && (lb0Var instanceof ob0) && !TextUtils.isEmpty(str) && (shaderConfig = this.l.get(str)) != null && shaderConfig.textures != null) {
            ArrayList arrayList = new ArrayList();
            for (MediaTextureData mediaTextureData : shaderConfig.textures) {
                int i = mediaTextureData.textureId;
                if (i != 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            ((ob0) lb0Var).Y(arrayList);
        }
    }

    @Override // com.baidu.tieba.pb0
    @Deprecated
    public int d(int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        lb0 G;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048589, this, i, i2, map)) == null) {
            try {
                c(i, i2);
            } catch (Exception e) {
                e.printStackTrace();
                u(e.toString(), e);
            }
            if (this.c != null && this.k != null && this.m != null && this.l != null) {
                ArrayList arrayList = new ArrayList();
                MediaTrack mediaTrack = null;
                int size = vb0.x(this.k, "edit_sticker") ? this.k.size() - 2 : this.k.size() - 1;
                int i4 = 0;
                for (int i5 = 0; i5 < this.k.size(); i5++) {
                    MediaTrack mediaTrack2 = this.k.get(i5);
                    if (i5 == 0) {
                        if (mediaTrack2.mediaSegments != null && mediaTrack2.mediaSegments.size() > this.i) {
                            MediaSegment mediaSegment = mediaTrack2.mediaSegments.get(this.i);
                            int i6 = mediaSegment.textureId;
                            if (TextUtils.equals(mediaSegment.type, "camera")) {
                                this.n = true;
                                if (mediaSegment.vertexMtx != null || mediaSegment.textureMtx != null) {
                                    nb0 nb0Var = (nb0) this.m.get(xb0.b);
                                    if (mediaSegment.vertexMtx != null) {
                                        nb0Var.U(mediaSegment.vertexMtx);
                                    }
                                    if (mediaSegment.textureMtx != null) {
                                        nb0Var.V(mediaSegment.textureMtx);
                                    }
                                    nb0Var.D(1.0f);
                                    int e2 = this.c.e(i6, nb0Var);
                                    if (e2 != i6) {
                                        i3 = e2;
                                        i4 = B(mediaTrack2, mediaSegment, i3, map, arrayList);
                                    }
                                }
                            }
                            i3 = i6;
                            i4 = B(mediaTrack2, mediaSegment, i3, map, arrayList);
                        }
                        mediaTrack = mediaTrack2;
                    } else {
                        D(map, arrayList, mediaTrack2, i4);
                    }
                    if (i5 == size && (G = G(map, mediaTrack)) != null) {
                        arrayList.add(G);
                    }
                }
                if (i4 != 0) {
                    return this.c.f(i4, arrayList);
                }
                return 0;
            }
            return 0;
        }
        return invokeIIL.intValue;
    }

    @Override // com.baidu.tieba.pb0
    public void f(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, list, map) == null) {
            this.h.add(new b(this, list, map));
        }
    }

    @Override // com.baidu.tieba.pb0
    public void h(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.h.add(new a(this, i, j));
        }
    }

    public void u(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, str, exc) == null) && this.e) {
            Log.d("zmy", "---> " + str, exc);
        }
    }

    public void v(lb0 lb0Var, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, lb0Var, map) == null) {
            float[] fArr = rb0.b;
            w(lb0Var, fArr, fArr, map);
        }
    }

    @Override // com.baidu.tieba.pb0
    @Deprecated
    public int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            I();
            List<MediaTrack> list = this.k;
            if (list != null && list.size() != 0 && this.k.get(0).mediaSegments != null && this.k.get(0).mediaSegments.size() == 1 && i3 != 0 && i4 != 0) {
                if (i3 != this.f || i4 != this.g) {
                    this.f = i3;
                    this.g = i4;
                    t(" w * h : " + i3 + " * " + i4);
                    s();
                }
                try {
                    MediaSegment mediaSegment = this.k.get(0).mediaSegments.get(0);
                    mediaSegment.textureId = i;
                    mediaSegment.vertexMtx = fArr;
                    mediaSegment.textureMtx = fArr2;
                    int d = d(i3, i4, map);
                    if (d != 0) {
                        if (fArr2 != null) {
                            Matrix.setIdentityM(fArr2, 0);
                        }
                        if (fArr != null) {
                            Matrix.setIdentityM(fArr, 0);
                        }
                    }
                    return d;
                } catch (Exception e) {
                    e.printStackTrace();
                    u(e.toString(), e);
                }
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public void q() {
        Map<String, ShaderConfig> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && !this.b && this.k != null && (map = this.l) != null) {
            if (!map.containsKey(xb0.b)) {
                this.l.put(xb0.b, ShaderConfig.getDefaultShaderConfig());
            }
            if (!this.l.containsKey(xb0.f)) {
                this.l.put(xb0.f, ShaderConfig.getStickerShaderConfig());
            }
            Map<String, lb0> l = vb0.l(this.a, this.l);
            this.m = l;
            for (Map.Entry<String, lb0> entry : l.entrySet()) {
                lb0 value = entry.getValue();
                value.l();
                value.v(this.f, this.g);
            }
            if (this.c == null) {
                this.c = new mb0();
            }
            this.c.c(this.f, this.g);
            this.b = true;
        }
    }

    public int r(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048597, this, mediaSegment, i, map)) == null) {
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                if (mediaAEffect2.duration > 0) {
                    String str = mediaAEffect2.shaderConfigKey;
                    if (!TextUtils.isEmpty(str)) {
                        List<MediaTextureData> list = this.l.get(str).textures;
                        if (list != null) {
                            for (MediaTextureData mediaTextureData : list) {
                                mediaTextureData.textureId = i;
                            }
                        }
                        lb0 lb0Var = this.m.get(str);
                        long j2 = mediaSegment.effectStart;
                        if (j2 <= 0) {
                            j2 = mediaSegment.start;
                        }
                        long j3 = j2;
                        long j4 = mediaSegment.effectEnd;
                        if (j4 > 0) {
                            j = j4;
                        } else {
                            j = mediaSegment.end;
                        }
                        if (lb0Var != null) {
                            long j5 = this.j;
                            if (j5 >= j3 && j5 <= j) {
                                v(lb0Var, map);
                                J(str, lb0Var);
                                lb0Var.F(mediaAEffect2.effectType, j3, j, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                int e = this.c.e(i, lb0Var);
                                if (e != i) {
                                    return e;
                                }
                            }
                        }
                    }
                }
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    public int y(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        long j;
        lb0 lb0Var;
        lb0 lb0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048605, this, mediaSegment, i, map)) == null) {
            int i2 = i;
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str) && (lb0Var2 = this.m.get(str)) != null) {
                v(lb0Var2, map);
                J(str, lb0Var2);
                int e = this.c.e(i2, lb0Var2);
                if (e != i2) {
                    i2 = e;
                }
            }
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                if (mediaAEffect2.duration > 0) {
                    String str2 = mediaAEffect2.shaderConfigKey;
                    long j2 = mediaSegment.effectStart;
                    if (j2 <= 0) {
                        j2 = mediaSegment.start;
                    }
                    long j3 = j2;
                    long j4 = mediaSegment.effectEnd;
                    if (j4 > 0) {
                        j = j4;
                    } else {
                        j = mediaSegment.end;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        long j5 = this.j;
                        if (j5 >= j3 && j5 <= j && (lb0Var = this.m.get(str2)) != null) {
                            v(lb0Var, map);
                            J(str2, lb0Var);
                            lb0Var.F(mediaAEffect2.effectType, j3, j, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                            int e2 = this.c.e(i2, lb0Var);
                            if (e2 != i2) {
                                return e2;
                            }
                            return i2;
                        }
                        return i2;
                    }
                    return i2;
                }
                return i2;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.tieba.pb0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                if (this.c != null) {
                    this.c.b();
                    this.c = null;
                }
                if (this.d != null) {
                    this.d.b();
                    this.d = null;
                }
                if (this.l != null) {
                    for (Map.Entry<String, ShaderConfig> entry : this.l.entrySet()) {
                        entry.getValue().destroy();
                    }
                    this.l = null;
                }
                s();
            } catch (Exception e) {
                t(e.getMessage());
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            try {
                if (!this.b) {
                    return;
                }
                if (this.m != null) {
                    for (Map.Entry<String, lb0> entry : this.m.entrySet()) {
                        entry.getValue().h();
                    }
                    this.m = null;
                }
                this.j = 0L;
                this.b = false;
            } catch (Exception e) {
                t(e.getMessage());
            }
        }
    }

    public void w(lb0 lb0Var, float[] fArr, float[] fArr2, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048603, this, lb0Var, fArr, fArr2, map) != null) || lb0Var == null) {
            return;
        }
        if (lb0Var instanceof nb0) {
            if (fArr == null) {
                fArr = rb0.b;
            }
            if (fArr2 == null) {
                fArr2 = rb0.b;
            }
            nb0 nb0Var = (nb0) lb0Var;
            nb0Var.U(fArr);
            nb0Var.V(fArr2);
        }
        lb0Var.J();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, float[]> entry : map.entrySet()) {
                lb0Var.I(GLES20.glGetUniformLocation(lb0Var.j(), entry.getKey()), entry.getValue(), true);
            }
        }
        lb0Var.E(this.j);
    }

    public int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            List<MediaTrack> list = this.k;
            if (list == null) {
                return i;
            }
            String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
            if (!xb0.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                str = "user_background";
            }
            int i2 = 1;
            while (true) {
                if (i2 >= this.k.size()) {
                    break;
                }
                MediaTrack mediaTrack = this.k.get(i2);
                if (mediaTrack != null && xb0.m(mediaTrack, str)) {
                    mb0 mb0Var = this.c;
                    float[] fArr = mediaTrack.glClearColor;
                    mb0Var.h(fArr[0], fArr[1], fArr[2], fArr[3]);
                    List<MediaSegment> list2 = mediaTrack.mediaSegments;
                    if (list2 != null) {
                        for (MediaSegment mediaSegment : list2) {
                            if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                                long j = mediaSegment.start;
                                long j2 = mediaSegment.end;
                                if (j != j2) {
                                    long j3 = this.j;
                                    if (j3 >= j && j3 <= j2) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (mediaSegment.textureId == 0) {
                                continue;
                            } else if (TextUtils.equals(mediaSegment.type, "input")) {
                                return i;
                            } else {
                                lb0 lb0Var = this.m.get(xb0.f);
                                if (lb0Var != null) {
                                    v(lb0Var, null);
                                    if (lb0Var instanceof ob0) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(Integer.valueOf(i));
                                        ((ob0) lb0Var).Y(arrayList);
                                    }
                                    p(lb0Var);
                                    int e = this.c.e(mediaSegment.textureId, lb0Var);
                                    if (e != mediaSegment.textureId) {
                                        i = e;
                                    }
                                }
                            }
                        }
                    } else {
                        lb0 lb0Var2 = this.m.get(xb0.b);
                        if (lb0Var2 != null) {
                            v(lb0Var2, null);
                            GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                            GLES20.glBlendFunc(770, 771);
                            int e2 = this.c.e(i, lb0Var2);
                            GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                            if (e2 != i) {
                                i = e2;
                            }
                        }
                    }
                    this.c.h(0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    i2++;
                }
            }
            return i;
        }
        return invokeI.intValue;
    }
}
