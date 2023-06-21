package com.baidu.tieba;

import android.graphics.Matrix;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class teb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;
    public web b;
    public Matrix c;
    public oeb d;
    public List<SVGAVideoShapeEntity> e;

    public teb(FrameEntity frameEntity) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new web(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = new Matrix();
        this.e = CollectionsKt__CollectionsKt.emptyList();
        Float f12 = frameEntity.alpha;
        if (f12 != null) {
            f = f12.floatValue();
        } else {
            f = 0.0f;
        }
        this.a = f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f13 = layout.x;
            if (f13 != null) {
                f8 = f13.floatValue();
            } else {
                f8 = 0.0f;
            }
            double d = f8;
            Float f14 = layout.y;
            if (f14 != null) {
                f9 = f14.floatValue();
            } else {
                f9 = 0.0f;
            }
            double d2 = f9;
            Float f15 = layout.width;
            if (f15 != null) {
                f10 = f15.floatValue();
            } else {
                f10 = 0.0f;
            }
            double d3 = f10;
            Float f16 = layout.height;
            if (f16 != null) {
                f11 = f16.floatValue();
            } else {
                f11 = 0.0f;
            }
            this.b = new web(d, d2, d3, f11);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f17 = transform.a;
            if (f17 != null) {
                f2 = f17.floatValue();
            } else {
                f2 = 1.0f;
            }
            Float f18 = transform.b;
            if (f18 != null) {
                f3 = f18.floatValue();
            } else {
                f3 = 0.0f;
            }
            Float f19 = transform.c;
            if (f19 != null) {
                f4 = f19.floatValue();
            } else {
                f4 = 0.0f;
            }
            Float f20 = transform.d;
            if (f20 != null) {
                f5 = f20.floatValue();
            } else {
                f5 = 1.0f;
            }
            Float f21 = transform.tx;
            if (f21 != null) {
                f6 = f21.floatValue();
            } else {
                f6 = 0.0f;
            }
            Float f22 = transform.ty;
            if (f22 != null) {
                f7 = f22.floatValue();
            } else {
                f7 = 0.0f;
            }
            fArr[0] = f2;
            fArr[1] = f4;
            fArr[2] = f6;
            fArr[3] = f3;
            fArr[4] = f5;
            fArr[5] = f7;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.d = new oeb(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        Intrinsics.checkExpressionValueIsNotNull(list, "obj.shapes");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ShapeEntity it : list) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(new SVGAVideoShapeEntity(it));
        }
        this.e = arrayList;
    }

    public teb(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        teb tebVar = this;
        tebVar.b = new web(0.0d, 0.0d, 0.0d, 0.0d);
        tebVar.c = new Matrix();
        tebVar.e = CollectionsKt__CollectionsKt.emptyList();
        tebVar.a = jSONObject.optDouble(Key.ALPHA, 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject(TtmlNode.TAG_LAYOUT);
        if (optJSONObject != null) {
            tebVar.b = new web(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject2.optDouble("c", 0.0d);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", 0.0d);
            double optDouble6 = optJSONObject2.optDouble("ty", 0.0d);
            float f = (float) optDouble3;
            z = true;
            float f2 = (float) 0.0d;
            float[] fArr = {(float) optDouble, f, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f2, f2, (float) 1.0d};
            tebVar = this;
            tebVar.c.setValues(fArr);
        } else {
            z = true;
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z) {
                tebVar.d = new oeb(optString);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            tebVar.e = CollectionsKt___CollectionsKt.toList(arrayList);
        }
    }

    public final double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.doubleValue;
    }

    public final web b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (web) invokeV.objValue;
    }

    public final oeb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (oeb) invokeV.objValue;
    }

    public final List<SVGAVideoShapeEntity> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public final Matrix e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (Matrix) invokeV.objValue;
    }

    public final void f(List<SVGAVideoShapeEntity> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.e = list;
        }
    }
}
