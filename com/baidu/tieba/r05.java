package com.baidu.tieba;

import android.text.format.DateUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r05 {
    public static /* synthetic */ Interceptable $ic;
    public static r05 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<iu4> a;

    public r05() {
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
        this.a = new ArrayList<>();
    }

    public static r05 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (r05.class) {
                    if (b == null) {
                        b = new r05();
                    }
                }
            }
            return b;
        }
        return (r05) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).edit().clear();
        }
    }

    public final ArrayList<iu4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getInt(str, 0);
        }
        return invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getLong(str, 0L);
        }
        return invokeL.longValue;
    }

    public void f(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) && jSONArray != null) {
            h(jSONArray);
        }
    }

    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).contains(str);
        }
        return invokeL.booleanValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = str;
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public final void h(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount) && jSONArray != null) {
                this.a.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONObject != null) {
                        iu4 iu4Var = new iu4();
                        iu4Var.a = jSONObject.optInt("active_id");
                        iu4Var.b = jSONObject.optInt("mission_id");
                        iu4Var.c = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE);
                        long d = d("business_update_time" + currentAccount + iu4Var.a);
                        if (g("business_count_hint" + currentAccount + iu4Var.a) && DateUtils.isToday(d)) {
                            iu4Var.s = c("business_count_hint" + currentAccount + iu4Var.a);
                        } else {
                            iu4Var.s = jSONObject.optInt("show_num");
                            a();
                            i("business_count_hint" + currentAccount + iu4Var.a, iu4Var.s);
                            j("business_update_time" + currentAccount + iu4Var.a, System.currentTimeMillis());
                        }
                        iu4Var.t = jSONObject.optInt("show_time_begin");
                        iu4Var.u = jSONObject.optInt("show_time_end");
                        JSONArray optJSONArray = jSONObject.optJSONArray("forumIds");
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            try {
                                iu4Var.w.add((String) optJSONArray.get(i2));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_page");
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            try {
                                iu4Var.v.add((String) optJSONArray2.get(i3));
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                        this.a.add(iu4Var);
                    }
                }
            }
        }
    }

    public void i(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
            EditorHelper.putInt(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, i);
        }
    }

    public void j(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j) == null) {
            EditorHelper.putLong(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, j);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:33|(5:35|(4:38|(2:40|41)(1:43)|42|36)|44|45|(2:56|52))(1:57)|47|48|49|50|51|52) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00eb, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(String str, String str2) {
        ArrayList<iu4> e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, str, str2) != null) || (e = e()) == null || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        for (int i = 0; i < e.size(); i++) {
            int i2 = e.get(i).a;
            int i3 = e.get(i).b;
            int i4 = e.get(i).c;
            int c = c("business_count_hint" + currentAccount + i2);
            long j = e.get(i).t;
            long j2 = e.get(i).u;
            ArrayList<String> arrayList = e.get(i).v;
            ArrayList<String> arrayList2 = e.get(i).w;
            if (c != 0 && System.currentTimeMillis() / 1000 > j && System.currentTimeMillis() / 1000 < j2) {
                boolean z = false;
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    if (arrayList.get(i5).equals(str)) {
                        z = true;
                    }
                }
                if (z) {
                    if (str.equals("2")) {
                        boolean z2 = false;
                        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                            if (arrayList2.get(i6).equals(str2)) {
                                z2 = true;
                            }
                        }
                        if (!z2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(i2), String.valueOf(i3));
                    k(jSONObject.toString());
                }
            }
        }
    }
}
