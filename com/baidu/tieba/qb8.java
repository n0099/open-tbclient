package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qb8 {
    public static /* synthetic */ Interceptable $ic;
    public static qb8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public final DialogInterface.OnCancelListener b;

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i, String str, int i2);

        void b(List<d> list);
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, d, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<oa8> a;
        public final int b;
        public c c;
        public final /* synthetic */ qb8 d;

        /* loaded from: classes7.dex */
        public class a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.qb8.c
            public void b(List<d> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                    return;
                }
                this.a.i(list);
            }

            @Override // com.baidu.tieba.qb8.c
            public void a(int i, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                    if (this.a.isCancelled()) {
                        this.a.h(i, str, i2);
                        return;
                    }
                    d dVar = new d();
                    dVar.a = str;
                    dVar.b = i2;
                    dVar.c = i;
                    this.a.publishProgress(dVar);
                }
            }
        }

        /* renamed from: com.baidu.tieba.qb8$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0450b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ int c;
            public final /* synthetic */ b d;

            public RunnableC0450b(b bVar, int i, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = i;
                this.b = str;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                oa8 oa8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (oa8Var = (oa8) this.d.a.get()) != null) {
                    oa8Var.onProgressUpdate(this.a, this.b, this.c);
                    oa8Var.onCanceled();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ b b;

            public c(b bVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    oa8 oa8Var = (oa8) this.b.a.get();
                    List<d> list = this.a;
                    if (list != null && oa8Var != null) {
                        for (d dVar : list) {
                            if (dVar != null) {
                                oa8Var.onProgressUpdate(dVar.c, dVar.a, dVar.b);
                            }
                        }
                        oa8Var.onCanceled();
                        this.a.clear();
                    }
                }
            }
        }

        public b(qb8 qb8Var, int i, oa8 oa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb8Var, Integer.valueOf(i), oa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qb8Var;
            this.c = new a(this);
            this.b = i;
            this.a = new WeakReference<>(oa8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onProgressUpdate(d... dVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVarArr) == null) {
                super.onProgressUpdate(dVarArr);
                oa8 oa8Var = this.a.get();
                if (dVarArr != null && dVarArr.length > 0 && dVarArr[0] != null && oa8Var != null) {
                    d dVar = dVarArr[0];
                    oa8Var.onProgressUpdate(dVar.c, dVar.a, dVar.b);
                }
            }
        }

        public final void i(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                SafeHandler.getInst().post(new c(this, list));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, num) == null) {
                super.onPostExecute((b) num);
                oa8 oa8Var = this.a.get();
                if (oa8Var != null) {
                    if (isCancelled()) {
                        oa8Var.onCanceled();
                    } else {
                        oa8Var.onPostExecute();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Integer doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                if (isCancelled()) {
                    return -1;
                }
                if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                    Object obj = objArr[0];
                    if (obj instanceof List) {
                        List<ImMessageCenterShowItemData> list = (List) obj;
                        int i = this.b;
                        if (i == 4) {
                            this.d.d(list, this.c);
                        } else if (i == 2) {
                            this.d.f(list, this.c);
                        }
                    } else if (obj instanceof ImMessageCenterShowItemData) {
                        this.d.r(((ImMessageCenterShowItemData) obj).getFriendId(), this.b, this.c);
                    }
                    return 0;
                }
                return -2;
            }
            return (Integer) invokeL.objValue;
        }

        public final void h(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                SafeHandler.getInst().post(new RunnableC0450b(this, i, str, i2));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onCancelled();
                oa8 oa8Var = this.a.get();
                if (oa8Var != null) {
                    oa8Var.onCanceled();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onPreExecute();
                oa8 oa8Var = this.a.get();
                if (oa8Var != null) {
                    oa8Var.onPreExecute();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb8 a;

        public a(qb8 qb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public qb8() {
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
        this.b = new a(this);
    }

    public static qb8 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (qb8.class) {
                    if (c == null) {
                        c = new qb8();
                    }
                }
            }
            return c;
        }
        return (qb8) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.a;
            if (bVar != null && bVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                this.a.cancel(true);
            }
            this.a = null;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b bVar = this.a;
            if (bVar != null) {
                if (bVar == null || !bVar.isCancelled()) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, oa8 oa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, imMessageCenterShowItemData, i, oa8Var) == null) {
            b bVar = new b(this, i, oa8Var);
            this.a = bVar;
            bVar.setParallel(TiebaIMConfig.getParallel());
            this.a.setPriority(3);
            this.a.execute(imMessageCenterShowItemData);
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, int i, oa8 oa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i, oa8Var) == null) {
            b bVar = new b(this, i, oa8Var);
            this.a = bVar;
            bVar.setParallel(TiebaIMConfig.getParallel());
            this.a.setPriority(3);
            this.a.execute(list);
        }
    }

    public void d(List<ImMessageCenterShowItemData> list, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, cVar) == null) {
            try {
                try {
                    tb8.d().f();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                int size = list.size();
                int i = 0;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    if (n()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, i2);
                    if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        j(friendId, 4);
                        xb8.w().e(friendId);
                        i++;
                        if (cVar != null) {
                            cVar.a((i * 100) / size, friendId, 4);
                        }
                    }
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    public void p(String str, int i) {
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048590, this, str, i) != null) || (h = mc8.n().h(str, i)) == null) {
            return;
        }
        if (i == 2) {
            be5.p0().r(str);
        } else if (i == 4) {
            be5.p0().q(JavaTypesHelper.toInt(str, 0));
        } else if (i == -4) {
            be5.p0().f(1);
        } else {
            be5.p0().d(str);
        }
        h.setIs_hidden(1);
        h.setUnread_count(0);
        if (i != 2 && i != 4 && i != -7 && i != -8) {
            mc8.n().y(str, i, false);
        } else {
            mc8.n().D(str, i);
        }
    }

    public void e(c cVar) {
        List<String> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            try {
                try {
                    tb8.d().f();
                    xb8.w();
                    y = xb8.y();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!ListUtils.isEmpty(y)) {
                    int size = y.size();
                    int i = 0;
                    for (String str : y) {
                        if (n()) {
                            break;
                        }
                        j(str, 4);
                        xb8.w().e(str);
                        i++;
                        if (cVar != null) {
                            cVar.a((i * 100) / size, str, 4);
                        }
                    }
                    if (!n()) {
                        j(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    }
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (n() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        j(com.baidu.tbadk.core.util.TbEnum.CustomGroupId.STRANGE_MERGE, -7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(c cVar) {
        List<String> e;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            try {
                try {
                    tb8.d().f();
                    e = zb8.e();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!ListUtils.isEmpty(e)) {
                    int size = e.size();
                    int i3 = size / 100;
                    if (size % 100 != 0) {
                        i3++;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i3) {
                            break;
                        } else if (n()) {
                            break;
                        } else {
                            if (i4 == i3 - 1) {
                                i = 100 * i4;
                                i2 = size;
                            } else {
                                i = 100 * i4;
                                i2 = i + 100;
                            }
                            i4++;
                            k(ListUtils.subList(e, i, i2), cVar, (i4 * 100) / i3);
                        }
                    }
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    public void f(List<ImMessageCenterShowItemData> list, c cVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, cVar) == null) {
            try {
                try {
                    tb8.d().f();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!ListUtils.isEmpty(list)) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, size);
                        if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                            arrayList.add(imMessageCenterShowItemData.getFriendId());
                        }
                    }
                    int size2 = arrayList.size();
                    int i3 = size2 / 100;
                    if (size2 % 100 != 0) {
                        i3++;
                    }
                    int i4 = 0;
                    while (i4 < i3) {
                        if (!n()) {
                            if (i4 == i3 - 1) {
                                i = 100 * i4;
                                i2 = size2;
                            } else {
                                i = 100 * i4;
                                i2 = i + 100;
                            }
                            i4++;
                            k(ListUtils.subList(arrayList, i, i2), cVar, (i4 * 100) / i3);
                        }
                    }
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                try {
                    tb8.d().f();
                    j(str, 4);
                    xb8.w().e(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                try {
                    tb8.d().f();
                    j(str, 2);
                    yb8.w().e(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    public final String s(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : list) {
                if (!z) {
                    sb.append(",");
                } else {
                    z = false;
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void j(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) {
            vb8.f().c(str, i);
        }
    }

    public void q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) {
            mc8.n().E(str, i);
        }
    }

    public final void k(List<String> list, c cVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048586, this, list, cVar, i) == null) && list != null && cVar != null) {
            zb8.b(s(list));
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                yb8.w().d(str);
                if (n()) {
                    d dVar = new d();
                    dVar.a = str;
                    dVar.b = 2;
                    dVar.c = i;
                    arrayList.add(dVar);
                } else {
                    cVar.a(i, str, 2);
                }
            }
            if (!arrayList.isEmpty() && cVar != null) {
                cVar.b(arrayList);
            }
        }
    }

    public void m(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
            try {
                try {
                    tb8.d().f();
                    ImMessageCenterPojo h = mc8.n().h(str, i);
                    h.setIs_hidden(1);
                    h.setUnread_count(0);
                    vb8.f().l(h, 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                tb8.d().b();
            }
        }
    }

    public o45 o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            o45 o45Var = new o45(context);
            o45Var.a(context.getString(R.string.delete_msg_loading));
            o45Var.setCanceledOnTouchOutside(false);
            o45Var.setCancelable(true);
            o45Var.setOnCancelListener(this.b);
            return o45Var;
        }
        return (o45) invokeL.objValue;
    }

    public void r(String str, int i, c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048592, this, str, i, cVar) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (-7 == i) {
            g(cVar);
        } else if (-8 == i) {
            e(cVar);
        } else if (2 == i) {
            i(str);
        } else if (4 == i) {
            h(str);
        } else if (-4 == i) {
            m(str, i);
        } else {
            m(str, i);
        }
    }
}
