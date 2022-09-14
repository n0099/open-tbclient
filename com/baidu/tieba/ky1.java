package com.baidu.tieba;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ky1 extends my1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String t;
    public int u;
    public boolean v;
    public double w;
    public int x;
    public int y;
    public String z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ky1(String str, @NonNull String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = "";
        this.v = false;
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
    }

    private void i() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.j) == null) {
            return;
        }
        try {
            this.u = Color.parseColor(jSONObject.optString("color"));
            this.v = true;
        } catch (Exception unused) {
            yz1.o("Component-Model-TextView", "text color occurs exception");
            this.v = false;
        }
        this.w = this.j.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d);
        this.x = pg3.g((float) this.j.optDouble("lineHeight", 0.0d));
        this.y = pg3.g((float) this.j.optDouble("lineSpace", 0.0d));
        this.z = this.j.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN);
        this.A = this.j.optString(TtmlNode.ATTR_TTS_FONT_WEIGHT);
        this.B = this.j.optString("whiteSpace");
        this.C = this.j.optString("lineBreak");
    }

    @Override // com.baidu.tieba.my1, com.baidu.tieba.oy1, com.baidu.tieba.xs2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.t = jSONObject.optString("text");
        i();
    }

    @Override // com.baidu.tieba.my1, com.baidu.tieba.oy1
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.g(jSONObject);
            this.t = jSONObject.optString("text", this.t);
            i();
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.t = str;
        }
    }
}
