package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.faceshop.UserDiyModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class wr7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wr7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFaceSyncUploadModel a;
    public NewFaceSyncDownloadModel b;
    public NewFaceGroupDownloadModel c;
    public sd6 d;
    public vd6 e;
    public boolean f;
    public boolean g;

    /* loaded from: classes6.dex */
    public class b implements xr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GetCloudFaceGroupMessage a;
            public final /* synthetic */ b b;

            public a(b bVar, GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, getCloudFaceGroupMessage};
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
                this.a = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    tr7.a("【表情云同步】：3 - 开始：处理收藏的表情");
                    this.b.a.d.f(this.a.getCollectEmotionList());
                }
            }
        }

        /* renamed from: com.baidu.tieba.wr7$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0444b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GetCloudFaceGroupMessage a;
            public final /* synthetic */ b b;

            public RunnableC0444b(b bVar, GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, getCloudFaceGroupMessage};
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
                this.a = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    tr7.a("【表情云同步】：3 - 开始：处理diy的表情");
                    this.b.a.e.f(this.a.getDiyEmotionList());
                }
            }
        }

        public b(wr7 wr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr7Var;
        }

        @Override // com.baidu.tieba.xr7
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getCloudFaceGroupMessage) == null) {
                if (getCloudFaceGroupMessage != null) {
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() > wr7.l()) {
                        if (getCloudFaceGroupMessage.getCollectEmotionList() != null) {
                            sr7.b().a(new a(this, getCloudFaceGroupMessage));
                        } else {
                            this.a.g = false;
                        }
                    } else {
                        this.a.g = false;
                        if (getCloudFaceGroupMessage.getCollectUpdateTime() < wr7.l()) {
                            tr7.a("【表情云同步】：上传本地的收藏的状态");
                            new UserCollectModel().z();
                        }
                        qd6.t().o();
                    }
                    if (getCloudFaceGroupMessage.getDiyUpdateTime() > wr7.m()) {
                        if (getCloudFaceGroupMessage.getDiyEmotionList() != null) {
                            sr7.b().a(new RunnableC0444b(this, getCloudFaceGroupMessage));
                        } else {
                            this.a.g = false;
                        }
                    } else {
                        this.a.g = false;
                        if (getCloudFaceGroupMessage.getDiyUpdateTime() < wr7.m()) {
                            tr7.a("【表情云同步】：上传本地的diy的状态");
                            new UserDiyModel().z();
                        }
                        ud6.q().m();
                    }
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() > wr7.n()) {
                        if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                            tr7.a("【表情云同步】：3 - 开始：处理收藏的表情包");
                            this.a.r(getCloudFaceGroupMessage.getFaceGroupData());
                            return;
                        }
                        this.a.f = false;
                        return;
                    }
                    this.a.f = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < wr7.n()) {
                        this.a.z();
                    }
                    vr7.i().e();
                    return;
                }
                this.a.g = false;
                this.a.f = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr7 a;

        public a(wr7 wr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            List f;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (f = vr7.i().f()) == null) {
                return;
            }
            if (!f.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (int i2 = 0; i2 < f.size() && i < 30; i2++) {
                    MyEmotionGroupData myEmotionGroupData = (MyEmotionGroupData) f.get(i2);
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        if (i2 < f.size() - 1) {
                            sb.append("_");
                        }
                        i++;
                    }
                }
                str = sb.toString();
            } else {
                str = "all_delete";
            }
            this.a.a.z(str);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ wr7 b;

        public c(wr7 wr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vr7.i().b(true);
                List<MyEmotionGroupData> f = vr7.i().f();
                ArrayList arrayList = new ArrayList();
                if (f != null) {
                    for (MyEmotionGroupData myEmotionGroupData : f) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                this.b.i(this.a, arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements yr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ List b;
        public final /* synthetic */ wr7 c;

        @Override // com.baidu.tieba.yr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public d(wr7 wr7Var, AtomicInteger atomicInteger, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var, atomicInteger, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wr7Var;
            this.a = atomicInteger;
            this.b = list;
        }

        @Override // com.baidu.tieba.yr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.decrementAndGet() != 0) {
                return;
            }
            this.c.s(this.b);
        }

        @Override // com.baidu.tieba.yr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.a.decrementAndGet() != 0) {
                return;
            }
            this.c.s(this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ wr7 b;

        public e(wr7 wr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.s(this.a);
        }
    }

    public wr7() {
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
        this.a = new NewFaceSyncUploadModel();
        this.b = new NewFaceSyncDownloadModel();
        this.c = new NewFaceGroupDownloadModel();
        this.d = new sd6();
        this.e = new vd6();
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            ux4 k = ux4.k();
            return k.m("face_collect_update_time" + k(), 0L);
        }
        return invokeV.longValue;
    }

    public static long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ux4 k = ux4.k();
            return k.m("face_diy_update_time" + k(), 0L);
        }
        return invokeV.longValue;
    }

    public static long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            ux4 k = ux4.k();
            return k.m("face_group_update_time" + k(), 0L);
        }
        return invokeV.longValue;
    }

    public static void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            ux4 k = ux4.k();
            k.x("face_collect_update_time" + k(), j);
        }
    }

    public static void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65551, null, j) == null) {
            ux4 k = ux4.k();
            k.x("face_diy_update_time" + k(), j);
        }
    }

    public static void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65552, null, j) == null) {
            ux4 k = ux4.k();
            k.x("face_group_update_time" + k(), j);
        }
    }

    public final void r(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            sr7.b().a(new c(this, list));
        }
    }

    public final void s(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            tr7.a("【表情云同步】：5 - 收藏表情包：根据云端数据进行排序");
            if (vr7.i().j(list, false)) {
                w(System.currentTimeMillis());
            }
            this.f = false;
        }
    }

    public final void t(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (fj.C()) {
                sr7.b().a(new e(this, list));
            } else {
                s(list);
            }
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.g = z;
        }
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return "";
            }
            return String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode()));
        }
        return (String) invokeV.objValue;
    }

    public static wr7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (h == null) {
                synchronized (wr7.class) {
                    if (h == null) {
                        h = new wr7();
                    }
                }
            }
            return h;
        }
        return (wr7) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            tr7.a("【表情云同步】：1 - 开始，请求\"c/e/meme/getAllMeme\"接口");
            this.f = true;
            this.g = true;
            this.b.z(new b(this));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            sr7.b().a(new a(this));
        }
    }

    public final void i(List list, List list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    tr7.a("【表情云同步】：5 - 收藏表情包：删除云端没有的表情包");
                    vr7.i().c(arrayList, false);
                }
            }
            j(list, list2);
        }
    }

    public final void j(List list, List list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!list2.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    tr7.a("【表情云同步】：5 - 收藏表情包：下载本地没有的表情包");
                    AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
                    for (String str2 : arrayList) {
                        this.c.z(str2, Boolean.FALSE, new d(this, atomicInteger, list));
                    }
                    return;
                }
                t(list);
                return;
            }
            this.f = false;
        }
    }
}
