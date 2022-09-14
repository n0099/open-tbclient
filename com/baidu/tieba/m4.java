package com.baidu.tieba;

import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.b7;
import com.baidu.tieba.u1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes5.dex */
public class m4 extends u1<u1.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d7 d;
    public final Quaternion e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m4(d7 d7Var, s1 s1Var) {
        super(s1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d7Var, s1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Quaternion();
        this.d = d7Var;
    }

    @Override // com.baidu.tieba.u1
    public w4 h(k3 k3Var, u1.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k3Var, aVar)) == null) ? o(k3Var) : (w4) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, com.badlogic.gdx.math.Quaternion] */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v17, types: [T, com.badlogic.gdx.math.Quaternion] */
    public void j(w4 w4Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w4Var, jsonValue) == null) {
            w4 w4Var2 = w4Var;
            JsonValue l = jsonValue.l("animations");
            if (l == null) {
                return;
            }
            w4Var2.e.e(l.j);
            JsonValue jsonValue2 = l.f;
            while (jsonValue2 != null) {
                JsonValue l2 = jsonValue2.l("bones");
                if (l2 != null) {
                    v4 v4Var = new v4();
                    w4Var2.e.a(v4Var);
                    v4Var.b.e(l2.j);
                    v4Var.a = jsonValue2.q("id");
                    for (JsonValue jsonValue3 = l2.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        a5 a5Var = new a5();
                        v4Var.b.a(a5Var);
                        a5Var.a = jsonValue3.q("boneId");
                        JsonValue l3 = jsonValue3.l("keyframes");
                        float f = 1000.0f;
                        float f2 = 0.0f;
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i4 = 3;
                        if (l3 != null && l3.u()) {
                            JsonValue jsonValue4 = l3.f;
                            while (jsonValue4 != null) {
                                float o = jsonValue4.o("keytime", f2) / f;
                                JsonValue l4 = jsonValue4.l("translation");
                                if (l4 != null && l4.j == i4) {
                                    if (a5Var.b == null) {
                                        a5Var.b = new b7<>();
                                    }
                                    b5<Vector3> b5Var = new b5<>();
                                    b5Var.a = o;
                                    b5Var.b = new Vector3(l4.n(i3), l4.n(i2), l4.n(i));
                                    a5Var.b.a(b5Var);
                                }
                                JsonValue l5 = jsonValue4.l(Key.ROTATION);
                                if (l5 != null && l5.j == 4) {
                                    if (a5Var.c == null) {
                                        a5Var.c = new b7<>();
                                    }
                                    b5<Quaternion> b5Var2 = new b5<>();
                                    b5Var2.a = o;
                                    b5Var2.b = new Quaternion(l5.n(0), l5.n(i2), l5.n(i), l5.n(3));
                                    a5Var.c.a(b5Var2);
                                }
                                JsonValue l6 = jsonValue4.l("scale");
                                if (l6 != null && l6.j == 3) {
                                    if (a5Var.d == null) {
                                        a5Var.d = new b7<>();
                                    }
                                    b5<Vector3> b5Var3 = new b5<>();
                                    b5Var3.a = o;
                                    b5Var3.b = new Vector3(l6.n(0), l6.n(1), l6.n(2));
                                    a5Var.d.a(b5Var3);
                                }
                                jsonValue4 = jsonValue4.h;
                                f = 1000.0f;
                                f2 = 0.0f;
                                i = 2;
                                i2 = 1;
                                i3 = 0;
                                i4 = 3;
                            }
                        } else {
                            JsonValue l7 = jsonValue3.l("translation");
                            if (l7 != null && l7.u()) {
                                b7<b5<Vector3>> b7Var = new b7<>();
                                a5Var.b = b7Var;
                                b7Var.e(l7.j);
                                for (JsonValue jsonValue5 = l7.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                    b5<Vector3> b5Var4 = new b5<>();
                                    a5Var.b.a(b5Var4);
                                    b5Var4.a = jsonValue5.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l8 = jsonValue5.l("value");
                                    if (l8 != null && l8.j >= 3) {
                                        b5Var4.b = new Vector3(l8.n(0), l8.n(1), l8.n(2));
                                    }
                                }
                            }
                            JsonValue l9 = jsonValue3.l(Key.ROTATION);
                            if (l9 != null && l9.u()) {
                                b7<b5<Quaternion>> b7Var2 = new b7<>();
                                a5Var.c = b7Var2;
                                b7Var2.e(l9.j);
                                for (JsonValue jsonValue6 = l9.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                    b5<Quaternion> b5Var5 = new b5<>();
                                    a5Var.c.a(b5Var5);
                                    b5Var5.a = jsonValue6.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l10 = jsonValue6.l("value");
                                    if (l10 != null && l10.j >= 4) {
                                        b5Var5.b = new Quaternion(l10.n(0), l10.n(1), l10.n(2), l10.n(3));
                                    }
                                }
                            }
                            JsonValue l11 = jsonValue3.l("scaling");
                            if (l11 != null && l11.u()) {
                                b7<b5<Vector3>> b7Var3 = new b7<>();
                                a5Var.d = b7Var3;
                                b7Var3.e(l11.j);
                                for (JsonValue jsonValue7 = l11.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                    b5<Vector3> b5Var6 = new b5<>();
                                    a5Var.d.a(b5Var6);
                                    b5Var6.a = jsonValue7.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l12 = jsonValue7.l("value");
                                    if (l12 != null && l12.j >= 3) {
                                        b5Var6.b = new Vector3(l12.n(0), l12.n(1), l12.n(2));
                                    }
                                }
                            }
                        }
                    }
                }
                jsonValue2 = jsonValue2.h;
                w4Var2 = w4Var;
            }
        }
    }

    public t3[] k(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonValue)) == null) {
            b7 b7Var = new b7();
            int i = 0;
            int i2 = 0;
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                String j = jsonValue2.j();
                if (j.equals("POSITION")) {
                    b7Var.a(t3.f());
                } else if (j.equals("NORMAL")) {
                    b7Var.a(t3.e());
                } else if (j.equals("COLOR")) {
                    b7Var.a(t3.d());
                } else if (j.equals("COLORPACKED")) {
                    b7Var.a(t3.c());
                } else if (j.equals("TANGENT")) {
                    b7Var.a(t3.g());
                } else if (j.equals("BINORMAL")) {
                    b7Var.a(t3.a());
                } else if (j.startsWith("TEXCOORD")) {
                    b7Var.a(t3.h(i));
                    i++;
                } else if (j.startsWith("BLENDWEIGHT")) {
                    b7Var.a(t3.b(i2));
                    i2++;
                } else {
                    throw new GdxRuntimeException("Unknown vertex attribute '" + j + "', should be one of position, normal, uv, tangent or binormal");
                }
            }
            return (t3[]) b7Var.n(t3.class);
        }
        return (t3[]) invokeL.objValue;
    }

    public l3 l(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsonValue)) == null) {
            if (jsonValue.j >= 3) {
                return new l3(jsonValue.n(0), jsonValue.n(1), jsonValue.n(2), 1.0f);
            }
            throw new GdxRuntimeException("Expected Color values <> than three.");
        }
        return (l3) invokeL.objValue;
    }

    public void m(w4 w4Var, JsonValue jsonValue, String str) {
        JsonValue l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, w4Var, jsonValue, str) == null) || (l = jsonValue.l("materials")) == null) {
            return;
        }
        w4Var.c.e(l.j);
        for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            ModelMaterial modelMaterial = new ModelMaterial();
            String r = jsonValue2.r("id", null);
            if (r != null) {
                modelMaterial.a = r;
                JsonValue l2 = jsonValue2.l("diffuse");
                if (l2 != null) {
                    modelMaterial.c = l(l2);
                }
                JsonValue l3 = jsonValue2.l("ambient");
                if (l3 != null) {
                    modelMaterial.b = l(l3);
                }
                JsonValue l4 = jsonValue2.l("emissive");
                if (l4 != null) {
                    modelMaterial.e = l(l4);
                }
                JsonValue l5 = jsonValue2.l("specular");
                if (l5 != null) {
                    modelMaterial.d = l(l5);
                }
                JsonValue l6 = jsonValue2.l("reflection");
                if (l6 != null) {
                    modelMaterial.f = l(l6);
                }
                modelMaterial.g = jsonValue2.o("shininess", 0.0f);
                modelMaterial.h = jsonValue2.o(NativeConstants.OPACITY, 1.0f);
                JsonValue l7 = jsonValue2.l("textures");
                if (l7 != null) {
                    for (JsonValue jsonValue3 = l7.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        d5 d5Var = new d5();
                        if (jsonValue3.r("id", null) != null) {
                            String r2 = jsonValue3.r(BreakpointSQLiteKey.FILENAME, null);
                            if (r2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                String str2 = "/";
                                sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "");
                                sb.append(r2);
                                d5Var.a = sb.toString();
                                d5Var.b = t(jsonValue3.l("uvTranslation"), 0.0f, 0.0f);
                                d5Var.c = t(jsonValue3.l("uvScaling"), 1.0f, 1.0f);
                                String r3 = jsonValue3.r("type", null);
                                if (r3 != null) {
                                    d5Var.d = r(r3);
                                    if (modelMaterial.i == null) {
                                        modelMaterial.i = new b7<>();
                                    }
                                    modelMaterial.i.a(d5Var);
                                } else {
                                    throw new GdxRuntimeException("Texture needs type.");
                                }
                            } else {
                                throw new GdxRuntimeException("Texture needs filename.");
                            }
                        } else {
                            throw new GdxRuntimeException("Texture has no id.");
                        }
                    }
                    continue;
                }
                w4Var.c.a(modelMaterial);
            } else {
                throw new GdxRuntimeException("Material needs an id.");
            }
        }
    }

    public void n(w4 w4Var, JsonValue jsonValue) {
        JsonValue l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, w4Var, jsonValue) == null) || (l = jsonValue.l("meshes")) == null) {
            return;
        }
        w4Var.b.e(l.j);
        for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
            x4 x4Var = new x4();
            jsonValue2.r("id", "");
            x4Var.a = k(jsonValue2.K("attributes"));
            x4Var.b = jsonValue2.K("vertices").e();
            JsonValue K = jsonValue2.K("parts");
            b7 b7Var = new b7();
            for (JsonValue jsonValue3 = K.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                y4 y4Var = new y4();
                String r = jsonValue3.r("id", null);
                if (r != null) {
                    b7.b it = b7Var.iterator();
                    while (it.hasNext()) {
                        if (((y4) it.next()).a.equals(r)) {
                            throw new GdxRuntimeException("Mesh part with id '" + r + "' already in defined");
                        }
                    }
                    y4Var.a = r;
                    String r2 = jsonValue3.r("type", null);
                    if (r2 != null) {
                        y4Var.c = s(r2);
                        y4Var.b = jsonValue3.K("indices").i();
                        b7Var.a(y4Var);
                    } else {
                        throw new GdxRuntimeException("No primitive type given for mesh part '" + r + "'");
                    }
                } else {
                    throw new GdxRuntimeException("Not id given for mesh part");
                }
            }
            x4Var.c = (y4[]) b7Var.n(y4.class);
            w4Var.b.a(x4Var);
        }
    }

    public w4 o(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k3Var)) == null) {
            JsonValue a = this.d.a(k3Var);
            w4 w4Var = new w4();
            JsonValue K = a.K("version");
            w4Var.a[0] = K.p(0);
            w4Var.a[1] = K.p(1);
            short[] sArr = w4Var.a;
            if (sArr[0] == 0 && sArr[1] == 1) {
                a.r("id", "");
                n(w4Var, a);
                m(w4Var, a, k3Var.i().j());
                p(w4Var, a);
                j(w4Var, a);
                return w4Var;
            }
            throw new GdxRuntimeException("Model version not supported");
        }
        return (w4) invokeL.objValue;
    }

    public b7<z4> p(w4 w4Var, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, w4Var, jsonValue)) == null) {
            JsonValue l = jsonValue.l("nodes");
            if (l != null) {
                w4Var.d.e(l.j);
                for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    w4Var.d.a(q(jsonValue2));
                }
            }
            return w4Var.d;
        }
        return (b7) invokeLL.objValue;
    }

    public z4 q(JsonValue jsonValue) {
        InterceptResult invokeL;
        String str;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonValue)) == null) {
            m4 m4Var = this;
            z4 z4Var = new z4();
            String str3 = null;
            String r = jsonValue.r("id", null);
            if (r != null) {
                z4Var.a = r;
                String str4 = "translation";
                JsonValue l = jsonValue.l("translation");
                if (l == null || l.j == 3) {
                    boolean z = true;
                    z4Var.b = l == null ? null : new Vector3(l.n(0), l.n(1), l.n(2));
                    String str5 = Key.ROTATION;
                    JsonValue l2 = jsonValue.l(Key.ROTATION);
                    if (l2 == null || l2.j == 4) {
                        z4Var.c = l2 == null ? null : new Quaternion(l2.n(0), l2.n(1), l2.n(2), l2.n(3));
                        JsonValue l3 = jsonValue.l("scale");
                        if (l3 == null || l3.j == 3) {
                            z4Var.d = l3 == null ? null : new Vector3(l3.n(0), l3.n(1), l3.n(2));
                            jsonValue.r("mesh", null);
                            JsonValue l4 = jsonValue.l("parts");
                            if (l4 != null) {
                                z4Var.e = new c5[l4.j];
                                JsonValue jsonValue2 = l4.f;
                                int i2 = 0;
                                while (jsonValue2 != null) {
                                    c5 c5Var = new c5();
                                    String r2 = jsonValue2.r("meshpartid", str3);
                                    String r3 = jsonValue2.r("materialid", str3);
                                    if (r2 != null && r3 != null) {
                                        c5Var.a = r3;
                                        c5Var.b = r2;
                                        JsonValue l5 = jsonValue2.l("bones");
                                        if (l5 != null) {
                                            c5Var.c = new c7<>(z, l5.j, String.class, Matrix4.class);
                                            JsonValue jsonValue3 = l5.f;
                                            while (jsonValue3 != null) {
                                                String r4 = jsonValue3.r("node", null);
                                                if (r4 != null) {
                                                    Matrix4 matrix4 = new Matrix4();
                                                    JsonValue l6 = jsonValue3.l(str4);
                                                    if (l6 == null || l6.j < 3) {
                                                        str = str4;
                                                    } else {
                                                        str = str4;
                                                        matrix4.translate(l6.n(0), l6.n(1), l6.n(2));
                                                    }
                                                    JsonValue l7 = jsonValue3.l(str5);
                                                    if (l7 == null || l7.j < 4) {
                                                        str2 = str5;
                                                        i = 3;
                                                    } else {
                                                        str2 = str5;
                                                        i = 3;
                                                        matrix4.rotate(m4Var.e.set(l7.n(0), l7.n(1), l7.n(2), l7.n(3)));
                                                    }
                                                    JsonValue l8 = jsonValue3.l("scale");
                                                    if (l8 != null && l8.j >= i) {
                                                        matrix4.scale(l8.n(0), l8.n(1), l8.n(2));
                                                    }
                                                    c5Var.c.e(r4, matrix4);
                                                    jsonValue3 = jsonValue3.h;
                                                    m4Var = this;
                                                    str4 = str;
                                                    str5 = str2;
                                                } else {
                                                    throw new GdxRuntimeException("Bone node ID missing");
                                                }
                                            }
                                            continue;
                                        }
                                        z4Var.e[i2] = c5Var;
                                        jsonValue2 = jsonValue2.h;
                                        i2++;
                                        str3 = null;
                                        m4Var = this;
                                        str4 = str4;
                                        str5 = str5;
                                        z = true;
                                    } else {
                                        throw new GdxRuntimeException("Node " + r + " part is missing meshPartId or materialId");
                                    }
                                }
                            }
                            JsonValue l9 = jsonValue.l(CriusAttrConstants.CHILDREN);
                            if (l9 != null) {
                                z4Var.f = new z4[l9.j];
                                JsonValue jsonValue4 = l9.f;
                                int i3 = 0;
                                while (jsonValue4 != null) {
                                    z4Var.f[i3] = q(jsonValue4);
                                    jsonValue4 = jsonValue4.h;
                                    i3++;
                                }
                            }
                            return z4Var;
                        }
                        throw new GdxRuntimeException("Node scale incomplete");
                    }
                    throw new GdxRuntimeException("Node rotation incomplete");
                }
                throw new GdxRuntimeException("Node translation incomplete");
            }
            throw new GdxRuntimeException("Node id missing.");
        }
        return (z4) invokeL.objValue;
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str.equalsIgnoreCase("AMBIENT")) {
                return 4;
            }
            if (str.equalsIgnoreCase("BUMP")) {
                return 8;
            }
            if (str.equalsIgnoreCase("DIFFUSE")) {
                return 2;
            }
            if (str.equalsIgnoreCase("EMISSIVE")) {
                return 3;
            }
            if (str.equalsIgnoreCase(HlsPlaylistParser.METHOD_NONE)) {
                return 1;
            }
            if (str.equalsIgnoreCase("NORMAL")) {
                return 7;
            }
            if (str.equalsIgnoreCase("REFLECTION")) {
                return 10;
            }
            if (str.equalsIgnoreCase("SHININESS")) {
                return 6;
            }
            if (str.equalsIgnoreCase("SPECULAR")) {
                return 5;
            }
            return str.equalsIgnoreCase("TRANSPARENCY") ? 9 : 0;
        }
        return invokeL.intValue;
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str.equals("TRIANGLES")) {
                return 4;
            }
            if (str.equals("LINES")) {
                return 1;
            }
            if (str.equals("POINTS")) {
                return 0;
            }
            if (str.equals("TRIANGLE_STRIP")) {
                return 5;
            }
            if (str.equals("LINE_STRIP")) {
                return 3;
            }
            throw new GdxRuntimeException("Unknown primitive type '" + str + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
        }
        return invokeL.intValue;
    }

    public Vector2 t(JsonValue jsonValue, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{jsonValue, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (jsonValue == null) {
                return new Vector2(f, f2);
            }
            if (jsonValue.j == 2) {
                return new Vector2(jsonValue.n(0), jsonValue.n(1));
            }
            throw new GdxRuntimeException("Expected Vector2 values <> than two.");
        }
        return (Vector2) invokeCommon.objValue;
    }
}
