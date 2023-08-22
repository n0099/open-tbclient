package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ArrayList<r9a> B;
    public ArrayList<r9a> C;
    public ArrayList<r9a> D;
    public HashMap<String, r9a> E;
    public o9a F;
    public int G;
    public t9a H;
    public y9a I;
    public BlockPopInfoData J;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public int u;
    public String v;
    public String w;
    public int x;
    public boolean y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements Comparator<r9a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(q9a q9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(r9a r9aVar, r9a r9aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r9aVar, r9aVar2)) == null) {
                return r9aVar2.i() - r9aVar.i();
            }
            return invokeLL.intValue;
        }
    }

    public q9a() {
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
        this.b = "0";
        this.B = new ArrayList<>();
        this.C = new ArrayList<>();
        this.D = new ArrayList<>();
        this.E = new HashMap<>();
        this.F = new o9a();
        this.H = new t9a();
        this.I = new y9a();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t9a t9aVar = this.H;
            if (t9aVar == null) {
                return false;
            }
            return !StringUtils.isNull(t9aVar.a);
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.l) {
                if (this.p + this.n <= 0) {
                    this.y = true;
                } else {
                    this.y = false;
                }
            } else if (this.p <= 0) {
                this.y = true;
            } else {
                this.y = false;
            }
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.H.a;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.H.b;
        }
        return (String) invokeV.objValue;
    }

    public BlockPopInfoData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.J;
        }
        return (BlockPopInfoData) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    public o9a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.F;
        }
        return (o9a) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public ArrayList<r9a> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.B;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!StringUtils.isNull(this.b) && this.b.equals("1")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public ArrayList<r9a> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.C;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.z;
        }
        return invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<r9a> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.D;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.I.a;
        }
        return (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.I.b;
        }
        return (String) invokeV.objValue;
    }

    public void D(v9a v9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v9aVar) == null) {
            this.z = 0;
            this.A = 0;
            ArrayList<w9a> d = v9aVar.d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                w9a w9aVar = d.get(i);
                r9a r9aVar = this.E.get(w9aVar.c() + "");
                if (r9aVar != null) {
                    if (w9aVar.e() != 0) {
                        this.z++;
                        r9aVar.r(1);
                        r9aVar.o(w9aVar.d());
                        r9aVar.q(w9aVar.a());
                        r9aVar.u(true);
                        r9aVar.s(false);
                        r9aVar.t(false);
                        c(r9aVar);
                    } else {
                        this.A++;
                        r9aVar.u(false);
                        r9aVar.s(true);
                        r9aVar.t(false);
                        r9aVar.p(w9aVar.b().b());
                    }
                }
            }
            b();
            a(true);
        }
    }

    public final void c(r9a r9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r9aVar) == null) {
            if (r9aVar.i() >= this.a) {
                this.o++;
                this.p--;
            } else {
                this.m++;
                this.n--;
            }
            this.E.remove(String.valueOf(r9aVar.c()));
            this.D.remove(r9aVar);
            if (r9aVar.h() + r9aVar.e() >= r9aVar.g()) {
                r9aVar.w(r9aVar.i() + 1);
                r9aVar.v(true);
                if (r9aVar.i() == this.a) {
                    this.o++;
                    this.m--;
                }
            }
            this.C.add(r9aVar);
            TbadkApplication.getInst().addSignedForum(r9aVar.d(), r9aVar.e(), -1);
        }
    }

    public void E(SignData signData) {
        r9a r9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, signData) != null) || signData == null || (r9aVar = this.E.get(signData.forumId)) == null) {
            return;
        }
        r9aVar.r(1);
        r9aVar.o(signData.count_sign_num);
        r9aVar.q(signData.sign_bonus_point);
        r9aVar.u(true);
        r9aVar.s(false);
        r9aVar.t(false);
        c(r9aVar);
        b();
        a(true);
    }

    public void F(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.F.c(jSONObject.optJSONObject("error"));
        this.a = jSONObject.optInt("level", 7);
        this.b = jSONObject.optString("sign_new");
        this.c = jSONObject.optString("title");
        this.d = jSONObject.optString("text_pre");
        this.e = jSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
        this.f = jSONObject.optString("text_mid");
        this.g = jSONObject.optString("text_suf");
        this.h = jSONObject.optString("num_notice");
        this.i = jSONObject.optInt("show_dialog");
        this.j = jSONObject.optString("sign_notice");
        this.k = jSONObject.optInt("valid", 0);
        this.G = jSONObject.optInt("sign_max_num", 50);
        this.u = jSONObject.optInt("can_use", 0);
        this.w = jSONObject.optString("content");
        this.v = jSONObject.optString("button_content");
        JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
        if (optJSONObject != null) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.J = blockPopInfoData;
            blockPopInfoData.block_info = optJSONObject.optString("block_content");
            this.J.ahead_info = optJSONObject.optString("block_confirm");
            this.J.ahead_url = optJSONObject.optString("block_dealurl");
            this.J.ok_info = optJSONObject.optString("block_cancel");
            this.J.appeal_status = optJSONObject.optInt("appeal_status");
            this.J.appeal_msg = optJSONObject.optString("appeal_msg");
        }
        if (this.u == 1) {
            this.l = true;
        } else {
            this.l = false;
        }
        this.r = this.a + this.c;
        this.q = "1-" + (this.a - 1) + TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13e4);
        x9a.o = this.G;
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
        if (optJSONArray != null) {
            int min = Math.min(optJSONArray.length(), x9a.o);
            for (int i = 0; i < min; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    r9a r9aVar = new r9a();
                    r9aVar.n(jSONObject2);
                    if (r9aVar.f() == 0) {
                        if (this.k == 0) {
                            if (this.l) {
                                r9aVar.s(true);
                            } else if (r9aVar.i() > this.a) {
                                r9aVar.s(true);
                            }
                        }
                        if (r9aVar.i() >= this.a) {
                            this.p++;
                        } else {
                            this.n++;
                        }
                        this.D.add(r9aVar);
                        this.E.put(r9aVar.c() + "", r9aVar);
                    } else {
                        if (r9aVar.i() >= this.a) {
                            this.o++;
                        } else {
                            this.m++;
                        }
                        this.C.add(r9aVar);
                        TbadkApplication.getInst().addSignedForum(r9aVar.d(), r9aVar.e(), -1);
                    }
                    this.B.add(r9aVar);
                    Collections.sort(this.B, new a(this));
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
        if (this.H == null) {
            this.H = new t9a();
        }
        this.H.a(optJSONObject2);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
        if (this.I == null) {
            this.I = new y9a();
        }
        this.I.a(optJSONObject3);
        a(false);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                Iterator<r9a> it = this.B.iterator();
                while (it.hasNext()) {
                    r9a next = it.next();
                    if (next instanceof p9a) {
                        arrayList.add(next);
                    }
                }
                this.B.removeAll(arrayList);
            }
            int i = this.p;
            int i2 = this.o;
            if (i + i2 > 0) {
                if (i2 > 0) {
                    this.t = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13fa, Integer.valueOf(this.o), Integer.valueOf(this.p));
                } else {
                    this.t = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13f4, Integer.valueOf(this.p + this.o));
                }
                if (this.B.size() > 0) {
                    this.B.add(0, new p9a(this.r, this.t));
                }
            }
            int i3 = this.n;
            int i4 = this.m;
            if (i3 + i4 > 0) {
                if (i4 > 0) {
                    this.s = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13fa, Integer.valueOf(this.m), Integer.valueOf(this.n));
                } else {
                    this.s = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13f4, Integer.valueOf(this.n + this.m));
                }
                if (this.p + this.o > 0) {
                    if (this.B.size() > this.p + this.o + 1) {
                        this.B.add(this.p + this.o + 1, new p9a(this.q, this.s));
                    }
                } else if (this.B.size() > 0) {
                    this.B.add(0, new p9a(this.q, this.s));
                }
            }
            if (this.B.size() <= 0) {
                this.x = 3;
            } else if (this.l) {
                if (this.k == 1 && this.D.size() > 0) {
                    this.x = 0;
                } else {
                    this.x = 2;
                }
            } else if (this.k == 1 && this.p > 0) {
                this.x = 0;
            } else {
                int i5 = this.p;
                int i6 = this.o;
                if (i5 + i6 > 0) {
                    this.x = 2;
                } else if (i5 + i6 <= 0) {
                    this.x = 3;
                }
            }
        }
    }
}
