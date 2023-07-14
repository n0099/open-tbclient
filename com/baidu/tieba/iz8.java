package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes6.dex */
public class iz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public final List<ICardInfo> b;
    public int c;
    public boolean d;
    public String e;
    public boolean f;
    public boolean g;
    public final BdListView h;
    public final sz8 i;
    public long j;
    public String k;

    /* loaded from: classes6.dex */
    public interface c {
        void a(List<x09> list);

        void b(long j, String str);

        void c(int i, String str);

        void d(String str, String str2, String str3, List<y09> list);

        void onError(int i, String str);

        void onSuccess();
    }

    /* loaded from: classes6.dex */
    public class a extends wy5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a(iz8 iz8Var, ye yeVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var, yeVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yeVar;
            this.b = j;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wy5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ye yeVar = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                sb.append("_");
                if (TextUtils.isEmpty(this.c)) {
                    str = "";
                } else {
                    str = this.c;
                }
                sb.append(str);
                byte[] bArr = (byte[]) yeVar.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ay5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz8 a;

        public b(iz8 iz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ay5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) {
                return;
            }
            this.a.h(dataRes);
        }
    }

    public iz8(BdListView bdListView, sz8 sz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdListView, sz8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new LinkedList();
        this.c = 1;
        this.e = "";
        this.f = false;
        this.g = false;
        this.h = bdListView;
        this.i = sz8Var;
    }

    public final void e(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, str) == null) {
            o55.e();
            az5.b(new a(this, o55.c("tb.lego_update"), j, str), new b(this));
        }
    }

    public final void f(long j, String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048580, this, j, str) == null) && (cVar = this.a) != null) {
            cVar.b(j, str);
        }
    }

    public void update(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            this.c = 1;
            this.j = j;
            this.k = str;
            if (this.b.size() == 0 && !this.g) {
                e(j, str);
            } else {
                f(j, str);
            }
        }
    }

    public List<ICardInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !d() && this.a != null) {
            this.c++;
            k(true);
            this.a.c(this.c, this.e);
        }
    }

    public final void h(DataRes dataRes) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            this.g = true;
            if (dataRes != null) {
                if (j(true, dataRes) && (cVar = this.a) != null) {
                    cVar.onSuccess();
                }
                f(this.j, this.k);
                return;
            }
            f(this.j, this.k);
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f = z;
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void i(boolean z, DataRes dataRes, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i), str}) == null) {
            k(false);
            if (z) {
                this.h.y();
            }
            if (i == 0 && dataRes != null && j(z, dataRes)) {
                c cVar = this.a;
                if (cVar != null) {
                    cVar.onSuccess();
                }
                if (z) {
                    m(dataRes);
                }
            } else if (this.b.size() > 0) {
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.onError(1, str);
                }
            } else {
                c cVar3 = this.a;
                if (cVar3 != null) {
                    cVar3.onError(2, str);
                }
            }
        }
    }

    public final boolean j(boolean z, DataRes dataRes) {
        InterceptResult invokeZL;
        boolean z2;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, dataRes)) == null) {
            if (dataRes == null) {
                return false;
            }
            if (z) {
                this.b.clear();
            }
            if (dataRes.has_more.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.d = z2;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject3 = new JSONObject(dataRes.page_info);
                JSONArray optJSONArray = jSONObject3.optJSONArray("tab");
                JSONObject optJSONObject = jSONObject3.optJSONObject("title");
                if (optJSONObject == null) {
                    str = "";
                    str2 = str;
                    str3 = str2;
                } else {
                    str2 = optJSONObject.optString("name");
                    str3 = optJSONObject.optString("url");
                    str = optJSONObject.optString("urlNight");
                }
                if (optJSONArray != null) {
                    int i = 0;
                    while (i < optJSONArray.length()) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            y09 y09Var = new y09();
                            y09Var.c = optJSONObject2.optString("title");
                            jSONObject2 = jSONObject3;
                            y09Var.a = optJSONObject2.optLong(LegoListActivityConfig.PAGE_ID);
                            optJSONObject2.optInt("page_type");
                            y09Var.d = optJSONObject2.optInt("rn");
                            y09Var.b = optJSONObject2.optString("item_id");
                            y09Var.e = optJSONObject2.optString("params");
                            y09Var.b();
                            arrayList.add(y09Var);
                        } else {
                            jSONObject2 = jSONObject3;
                        }
                        i++;
                        jSONObject3 = jSONObject2;
                    }
                    jSONObject = jSONObject3;
                    this.a.d(str2, str3, str, arrayList);
                } else {
                    jSONObject = jSONObject3;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject3 != null) {
                            x09 x09Var = new x09();
                            x09Var.b(optJSONObject3);
                            if (x09Var.a()) {
                                arrayList2.add(x09Var);
                            }
                        }
                    }
                    this.a.a(arrayList2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (dataRes.cards != null) {
                for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                    ICardInfo i4 = uz8.i(dataRes.cards.get(i3));
                    if (i4 != null && i4.isValid()) {
                        this.b.add(i4);
                    }
                }
            }
            if (this.b.size() == 0) {
                return false;
            }
            try {
                this.e = this.b.get(this.b.size() - 1).getFlipId();
            } catch (Exception unused) {
                this.e = "";
            }
            this.i.C(this.b);
            return true;
        }
        return invokeZL.booleanValue;
    }

    public final void m(DataRes dataRes) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, dataRes) != null) || dataRes == null) {
            return;
        }
        o55.e();
        ye<byte[]> c2 = o55.c("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        if (TextUtils.isEmpty(this.k)) {
            str = "";
        } else {
            str = this.k;
        }
        sb.append(str);
        c2.a(sb.toString(), dataRes.toByteArray());
    }
}
