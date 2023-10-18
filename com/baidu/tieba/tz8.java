package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class tz8 implements rz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vz8 a;
    public List<ICardInfo> b;
    public String c;
    public String d;
    public String e;
    public List<uz8> f;
    public boolean g;
    public int h;
    public String i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;

    public tz8(vz8 vz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vz8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.h = 1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.a = vz8Var;
    }

    @Override // com.baidu.tieba.rz8
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rz8
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ICardInfo> list = this.b;
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rz8
    public List<ICardInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public List<uz8> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public vz8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (vz8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rz8
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rz8
    public void b(boolean z, Message message, boolean z2, int i) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            if (z) {
                this.l = true;
            } else {
                this.k = true;
            }
            DataRes dataRes = (DataRes) message;
            if (dataRes == null) {
                return;
            }
            if (dataRes.has_more.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.g = z3;
            if (!TextUtils.isEmpty(dataRes.page_info)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.page_info);
                    JSONObject optJSONObject = jSONObject.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.c = optJSONObject.optString("name");
                        this.d = optJSONObject.optString("url");
                        this.e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f == null) {
                            this.f = new ArrayList();
                        } else {
                            this.f.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                uz8 uz8Var = new uz8();
                                uz8Var.b(optJSONObject2);
                                if (uz8Var.a()) {
                                    this.f.add(uz8Var);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (dataRes.cards != null) {
                for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                    ICardInfo i4 = sy8.i(dataRes.cards.get(i3));
                    if (i4 != null && i4.isValid()) {
                        arrayList.add(i4);
                    }
                    if (i3 == dataRes.cards.size() - 1 && i4 != null) {
                        o(i4.getFlipId());
                    }
                }
            }
            if (z2) {
                this.b.addAll(arrayList);
                this.h = i;
                return;
            }
            this.h = 1;
            this.b = arrayList;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.i = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(PageInfo.KEY);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, optString));
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.c = optJSONObject.optString("name");
                        this.d = optJSONObject.optString("url");
                        this.e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f == null) {
                            this.f = new ArrayList();
                        } else {
                            this.f.clear();
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                uz8 uz8Var = new uz8();
                                uz8Var.b(optJSONObject2);
                                if (uz8Var.a()) {
                                    this.f.add(uz8Var);
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ICardInfo i3 = sy8.i(optJSONArray2.getString(i2));
                        if (i3 != null && i3.isValid()) {
                            arrayList.add(i3);
                        }
                        if (i2 == optJSONArray2.length() - 1 && i3 != null) {
                            o(i3.getFlipId());
                        }
                    }
                }
                this.b = arrayList;
                if (c()) {
                    this.m = true;
                } else {
                    this.m = false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
