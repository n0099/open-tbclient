package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class td implements gd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public td(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    @Override // com.baidu.tieba.gd
    public Object a(wd wdVar) {
        Class<?> a;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wdVar)) == null) {
            try {
                a = wdVar.a();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
            if (a != Byte.class && a != Byte.TYPE) {
                if (a != Short.class && a != Short.TYPE) {
                    if (a != Integer.class && a != Integer.TYPE) {
                        if (a != Long.class && a != Long.TYPE) {
                            if (a != Float.class && a != Float.TYPE) {
                                if (a != Double.class && a != Double.TYPE) {
                                    if (a != Character.class && a != Character.TYPE) {
                                        if (a != Boolean.class && a != Boolean.TYPE) {
                                            if (a == String.class) {
                                                return this.a;
                                            }
                                            if (a == char[].class) {
                                                return this.a.toCharArray();
                                            }
                                            if (a == byte[].class) {
                                                try {
                                                    return wh.e(this.a, 0);
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return null;
                                                }
                                            } else if (dc.e(a, OrmObject.class)) {
                                                return OrmObject.objectWithJsonStr(this.a, a);
                                            } else {
                                                if (dc.e(a, List.class)) {
                                                    try {
                                                        return new id(new JSONArray(this.a)).a(wdVar);
                                                    } catch (JSONException e3) {
                                                        e3.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (a.isArray()) {
                                                    try {
                                                        return new id(new JSONArray(this.a)).a(wdVar);
                                                    } catch (JSONException e4) {
                                                        e4.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (dc.e(a, Queue.class)) {
                                                    try {
                                                        return new id(new JSONArray(this.a)).a(wdVar);
                                                    } catch (JSONException e5) {
                                                        e5.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (dc.e(a, Set.class)) {
                                                    try {
                                                        return new id(new JSONArray(this.a)).a(wdVar);
                                                    } catch (JSONException e6) {
                                                        e6.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (dc.e(a, Map.class)) {
                                                    try {
                                                        return new jd(new JSONObject(this.a)).a(wdVar);
                                                    } catch (JSONException e7) {
                                                        e7.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (dc.e(a, SparseArray.class)) {
                                                    try {
                                                        return new jd(new JSONObject(this.a)).a(wdVar);
                                                    } catch (JSONException e8) {
                                                        e8.printStackTrace();
                                                        return null;
                                                    }
                                                } else {
                                                    return null;
                                                }
                                            }
                                            e.printStackTrace();
                                            return null;
                                        }
                                        return Boolean.valueOf(Boolean.parseBoolean(this.a));
                                    }
                                    return Character.valueOf(this.a.charAt(0));
                                }
                                return Double.valueOf(Double.parseDouble(this.a));
                            }
                            return Float.valueOf(Float.parseFloat(this.a));
                        }
                        return Long.valueOf(Long.parseLong(this.a));
                    }
                    return Integer.valueOf(Integer.parseInt(this.a));
                }
                return Short.valueOf(Short.parseShort(this.a));
            }
            return Byte.valueOf(Byte.parseByte(this.a));
        }
        return invokeL.objValue;
    }
}
