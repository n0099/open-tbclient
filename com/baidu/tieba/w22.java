package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class w22 extends s12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String L;
    public int M;
    public String N;
    public String O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1168T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w22() {
        super("textArea", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = "";
        this.N = "";
        this.O = "";
    }

    private void i() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (jSONObject = this.j) != null) {
            int g = bk3.g(c(jSONObject, "minHeight", 0.0f));
            if (g < 0) {
                g = 0;
            }
            this.U = g;
            int g2 = bk3.g(c(this.j, "maxHeight", 2.1474836E9f));
            if (g2 < 0) {
                g2 = Integer.MAX_VALUE;
            }
            this.V = g2;
        }
    }

    @Override // com.baidu.tieba.s12, com.baidu.tieba.x12, com.baidu.tieba.z12, com.baidu.tieba.b22, com.baidu.tieba.jw2
    public void a(JSONObject jSONObject) throws JSONException {
        qw2 qw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.t = jSONObject.optString("value");
        this.L = jSONObject.optString("placeholder");
        o(jSONObject);
        boolean z = false;
        this.P = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        boolean optBoolean = jSONObject.optBoolean("autoHeight", false);
        this.Q = optBoolean;
        if (optBoolean && (qw2Var = this.h) != null) {
            qw2Var.j(-2);
            this.h.k(true);
        }
        boolean optBoolean2 = jSONObject.optBoolean("fixed");
        this.R = optBoolean2;
        qw2 qw2Var2 = this.h;
        if (qw2Var2 != null) {
            qw2Var2.i(optBoolean2);
        }
        this.S = jSONObject.optBoolean("showConfirmBar", true);
        this.f1168T = jSONObject.optBoolean("adjustPosition", true);
        this.W = jSONObject.optBoolean("disabled", false);
        if (jSONObject.optInt("confirmHold") == 1) {
            z = true;
        }
        this.X = z;
        i();
    }

    @Override // com.baidu.tieba.s12, com.baidu.tieba.x12, com.baidu.tieba.z12, com.baidu.tieba.b22
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.g(jSONObject);
            this.W = jSONObject.optBoolean("disabled", this.W);
            this.L = jSONObject.optString("placeholder", this.L);
            this.t = jSONObject.optString("value", this.t);
            this.P = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.P);
            this.S = jSONObject.optBoolean("showConfirmBar", this.S);
            this.f1168T = jSONObject.optBoolean("adjustPosition", this.f1168T);
            n(jSONObject);
            p(jSONObject);
            o(jSONObject);
            i();
        }
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("autoHeight", this.Q);
            this.Q = optBoolean;
            qw2 qw2Var = this.h;
            if (qw2Var != null) {
                if (optBoolean) {
                    qw2Var.j(-2);
                    this.h.k(true);
                    return;
                }
                int c = qw2Var.c();
                int i = this.K;
                if (i > 0) {
                    c = i;
                }
                this.h.j(c);
                this.h.k(false);
            }
        }
    }

    public final void o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("placeholderStyle")) != null) {
            this.M = optJSONObject.optInt(TtmlNode.ATTR_TTS_FONT_SIZE);
            this.N = optJSONObject.optString(TtmlNode.ATTR_TTS_FONT_WEIGHT);
            this.O = optJSONObject.optString("color");
        }
    }

    public final void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("fixed", this.R);
            this.R = optBoolean;
            qw2 qw2Var = this.h;
            if (qw2Var != null) {
                qw2Var.i(optBoolean);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.P = z;
        }
    }
}
