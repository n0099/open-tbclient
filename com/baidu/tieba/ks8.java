package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ks8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public c b;
    public a c;
    public ArrayList<MarkData> d;
    public int e;
    public int f;
    public boolean g;
    public hs8 h;

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<ks8, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public int d;
        public ms8 e;
        public final /* synthetic */ ks8 f;

        public a(ks8 ks8Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks8Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ks8Var;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0;
            this.e = null;
            this.b = str;
            this.d = i;
            this.c = str2;
            this.e = new ms8();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.a.addPostData("tid", this.b);
                this.a.addPostData("fid", this.c);
                this.e.c(this.a.postNetData());
                if (this.a.getNetContext().getResponse().isRequestSuccess() && this.e.a() == 0) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                String str = null;
                this.f.c = null;
                if (bool.booleanValue()) {
                    if (this.d < this.f.d.size()) {
                        this.f.d.remove(this.d);
                        ks8.i(this.f);
                    }
                } else {
                    str = this.a.getNetContext().getResponse().isRequestSuccess() ? this.e.b() : this.a.getErrorString();
                }
                hs8 hs8Var = this.f.h;
                if (hs8Var != null) {
                    hs8Var.a(2, bool, str);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f.c = null;
                hs8 hs8Var = this.f.h;
                if (hs8Var != null) {
                    hs8Var.a(2, Boolean.FALSE, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Boolean, String, ks8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public int c;
        public ms8 d;
        public Boolean e;
        public final /* synthetic */ ks8 f;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        public b(ks8 ks8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ks8Var;
            this.a = null;
            this.b = null;
            this.c = 0;
            this.d = null;
            this.e = Boolean.FALSE;
            this.c = i;
            this.d = new ms8();
        }

        public final void b(String str) {
            String currentAccount;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (currentAccount = TbadkCoreApplication.getCurrentAccount()) == null) {
                return;
            }
            c25.d();
            se<String> e = c25.e("tb.my_bookmarks");
            if (e != null) {
                e.e(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public ks8 doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, boolArr)) == null) {
                this.e = boolArr[0];
                if (boolArr.length >= 2 && boolArr[1] != null) {
                    z = boolArr[1].booleanValue();
                } else {
                    z = true;
                }
                ks8 ks8Var = new ks8();
                if (this.e.booleanValue() && z) {
                    c25.d();
                    se<String> e = c25.e("tb.my_bookmarks");
                    if (e != null) {
                        publishProgress(e.get(TbadkCoreApplication.getCurrentAccount()));
                    }
                    if (this.f.d == null) {
                        this.f.d = new ArrayList();
                    } else {
                        this.f.d.clear();
                    }
                    this.f.e = 0;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
                this.a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                if (this.f.g) {
                    this.a.addPostData("offset", String.valueOf(0));
                } else {
                    this.a.addPostData("offset", String.valueOf(this.c));
                }
                this.a.addPostData("rn", String.valueOf(20));
                String postNetData = this.a.postNetData();
                this.b = postNetData;
                this.d.c(postNetData);
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    ks8Var.u(this.b);
                    if (this.c == 0) {
                        if (this.f.d == null) {
                            this.f.d = new ArrayList();
                        } else {
                            this.f.d.clear();
                        }
                        this.f.e = 0;
                        if (this.e.booleanValue()) {
                            b(this.b);
                        }
                    }
                }
                return ks8Var;
            }
            return (ks8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(ks8 ks8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ks8Var) == null) {
                if (ks8Var == null) {
                    ks8Var = new ks8();
                }
                ms8 ms8Var = this.d;
                if (ms8Var != null) {
                    d65.a("collection", 0L, 0, "collection_thread_list_result", ms8Var.a(), this.d.b(), new Object[0]);
                }
                this.f.e = ks8Var.m();
                ArrayList<MarkData> n = ks8Var.n();
                if (this.e.booleanValue()) {
                    if (n != null && n.size() != 0) {
                        this.f.B(n);
                    }
                } else {
                    this.f.k(n);
                }
                Iterator<MarkData> it = n.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().getNewCounts() > 0) {
                        i++;
                        this.f.C(i);
                    }
                }
                if (this.f.h != null) {
                    String str = null;
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        if (this.d.a() != 0) {
                            str = this.d.b();
                        }
                        this.f.h.a(0, str, Boolean.FALSE);
                    } else {
                        this.f.h.a(3, Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0db6));
                    }
                }
                this.f.g = false;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onProgressUpdate(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, strArr) == null) {
                super.onProgressUpdate(strArr);
                String str = strArr[0];
                ArrayList<MarkData> arrayList = new ArrayList<>();
                if (str != null) {
                    arrayList = this.f.t(str);
                    if (this.e.booleanValue()) {
                        this.f.B(arrayList);
                    } else {
                        this.f.k(arrayList);
                    }
                } else {
                    this.f.B(arrayList);
                }
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                this.f.h.a(0, null, Boolean.TRUE);
            }
        }
    }

    public ks8() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = null;
        this.d = new ArrayList<>();
        this.g = true;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            String id = next.getId();
            int replyNum = next.getReplyNum();
            if (!hashSet.add(id)) {
                l(id, replyNum);
                it.remove();
            }
        }
    }

    public static /* synthetic */ int i(ks8 ks8Var) {
        int i = ks8Var.f;
        ks8Var.f = i - 1;
        return i;
    }

    public void A(hs8 hs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hs8Var) == null) {
            this.h = hs8Var;
        }
    }

    public void B(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.d = arrayList;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f = i;
        }
    }

    public void j(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, markData) == null) {
            this.d.add(markData);
        }
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) && (arrayList2 = this.d) != null && arrayList != null) {
            arrayList2.addAll(arrayList);
            y();
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            try {
                v(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void w(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bool) == null) {
            x(bool, true);
        }
    }

    public boolean D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
            }
            if (i >= this.d.size() || this.d.get(i) == null || this.d.get(i).getId() == null) {
                return false;
            }
            a aVar2 = new a(this, this.d.get(i).getId(), i, this.d.get(i).getForumId());
            this.c = aVar2;
            aVar2.setPriority(2);
            this.c.execute(new Boolean[0]);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final ArrayList<MarkData> t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            ArrayList<MarkData> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    arrayList.add(markData);
                }
                return arrayList;
            } catch (Exception e) {
                BdLog.e(e.toString());
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public void v(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            try {
                if (!jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                    return;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.d.add(markData);
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public String E(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            ArrayList<MarkData> arrayList = this.d;
            if (arrayList == null) {
                return null;
            }
            if (i >= arrayList.size()) {
                i2 -= (i - this.d.size()) - 1;
                i = this.d.size() - 1;
            }
            JSONArray jSONArray = new JSONArray();
            int i3 = 0;
            for (int i4 = i; i4 >= 0 && i4 > i - i2; i4--) {
                try {
                    JSONObject json = this.d.get(i4).toJson();
                    if (json != null && i3 >= 0) {
                        int i5 = i3 + 1;
                        jSONArray.put(i3, json);
                        i3 = i5;
                    }
                } catch (Exception e) {
                    BdLog.e(e.toString());
                    jSONArray = null;
                }
            }
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }
        return (String) invokeII.objValue;
    }

    public final void l(String str, int i) {
        ArrayList<MarkData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) && (arrayList = this.d) != null && ListUtils.getCount(arrayList) > 0) {
            Iterator<MarkData> it = this.d.iterator();
            while (it.hasNext()) {
                MarkData next = it.next();
                if (next != null && next.getId().equals(str)) {
                    next.setReplyNum(i);
                }
            }
        }
    }

    public void x(Boolean bool, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, bool, z) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, q());
            this.a = bVar2;
            bVar2.setPriority(3);
            this.a.execute(bool, Boolean.valueOf(z));
        }
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<MarkData> arrayList = this.d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public ArrayList<MarkData> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<MarkData> arrayList = this.d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.cancel();
            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f = 0;
            this.e = 0;
            this.g = true;
        }
    }
}
