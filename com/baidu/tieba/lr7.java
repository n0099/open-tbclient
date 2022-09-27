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
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class lr7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lr7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFaceSyncUploadModel a;
    public NewFaceSyncDownloadModel b;
    public NewFaceGroupDownloadModel c;
    public ld6 d;
    public od6 e;
    public boolean f;
    public boolean g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr7 a;

        public a(lr7 lr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f = kr7.i().f()) == null) {
                return;
            }
            if (f.isEmpty()) {
                str = "all_delete";
            } else {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (int i2 = 0; i2 < f.size() && i < 30; i2++) {
                    MyEmotionGroupData myEmotionGroupData = f.get(i2);
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        if (i2 < f.size() - 1) {
                            sb.append("_");
                        }
                        i++;
                    }
                }
                str = sb.toString();
            }
            this.a.a.z(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements mr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr7 a;

        /* loaded from: classes4.dex */
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
                    ir7.a("【表情云同步】：3 - 开始：处理收藏的表情");
                    this.b.a.d.f(this.a.getCollectEmotionList());
                }
            }
        }

        /* renamed from: com.baidu.tieba.lr7$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0330b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GetCloudFaceGroupMessage a;
            public final /* synthetic */ b b;

            public RunnableC0330b(b bVar, GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
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
                    ir7.a("【表情云同步】：3 - 开始：处理diy的表情");
                    this.b.a.e.f(this.a.getDiyEmotionList());
                }
            }
        }

        public b(lr7 lr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr7Var;
        }

        @Override // com.baidu.tieba.mr7
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getCloudFaceGroupMessage) == null) {
                if (getCloudFaceGroupMessage == null) {
                    this.a.g = false;
                    this.a.f = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= lr7.l()) {
                    this.a.g = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < lr7.l()) {
                        ir7.a("【表情云同步】：上传本地的收藏的状态");
                        new UserCollectModel().z();
                    }
                    jd6.t().o();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    this.a.g = false;
                } else {
                    hr7.b().a(new a(this, getCloudFaceGroupMessage));
                }
                if (getCloudFaceGroupMessage.getDiyUpdateTime() <= lr7.m()) {
                    this.a.g = false;
                    if (getCloudFaceGroupMessage.getDiyUpdateTime() < lr7.m()) {
                        ir7.a("【表情云同步】：上传本地的diy的状态");
                        new UserDiyModel().z();
                    }
                    nd6.q().m();
                } else if (getCloudFaceGroupMessage.getDiyEmotionList() == null) {
                    this.a.g = false;
                } else {
                    hr7.b().a(new RunnableC0330b(this, getCloudFaceGroupMessage));
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= lr7.n()) {
                    this.a.f = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < lr7.n()) {
                        this.a.z();
                    }
                    kr7.i().e();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() == null) {
                    this.a.f = false;
                } else {
                    ir7.a("【表情云同步】：3 - 开始：处理收藏的表情包");
                    this.a.r(getCloudFaceGroupMessage.getFaceGroupData());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ lr7 b;

        public c(lr7 lr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lr7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kr7.i().b(true);
                List<MyEmotionGroupData> f = kr7.i().f();
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

    /* loaded from: classes4.dex */
    public class d implements nr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ List b;
        public final /* synthetic */ lr7 c;

        public d(lr7 lr7Var, AtomicInteger atomicInteger, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr7Var, atomicInteger, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lr7Var;
            this.a = atomicInteger;
            this.b = list;
        }

        @Override // com.baidu.tieba.nr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.decrementAndGet() == 0) {
                this.c.s(this.b);
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a.decrementAndGet() == 0) {
                this.c.s(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ lr7 b;

        public e(lr7 lr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lr7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.s(this.a);
            }
        }
    }

    public lr7() {
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
        this.d = new ld6();
        this.e = new od6();
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode())) : (String) invokeV.objValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            ox4 k = ox4.k();
            return k.m("face_collect_update_time" + k(), 0L);
        }
        return invokeV.longValue;
    }

    public static long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ox4 k = ox4.k();
            return k.m("face_diy_update_time" + k(), 0L);
        }
        return invokeV.longValue;
    }

    public static long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            ox4 k = ox4.k();
            return k.m("face_group_update_time" + k(), 0L);
        }
        return invokeV.longValue;
    }

    public static lr7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (h == null) {
                synchronized (lr7.class) {
                    if (h == null) {
                        h = new lr7();
                    }
                }
            }
            return h;
        }
        return (lr7) invokeV.objValue;
    }

    public static void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            ox4 k = ox4.k();
            k.x("face_collect_update_time" + k(), j);
        }
    }

    public static void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65551, null, j) == null) {
            ox4 k = ox4.k();
            k.x("face_diy_update_time" + k(), j);
        }
    }

    public static void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65552, null, j) == null) {
            ox4 k = ox4.k();
            k.x("face_group_update_time" + k(), j);
        }
    }

    public final void i(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ir7.a("【表情云同步】：5 - 收藏表情包：删除云端没有的表情包");
                    kr7.i().c(arrayList, false);
                }
            }
            j(list, list2);
        }
    }

    public final void j(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : list) {
                    if (!list2.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ir7.a("【表情云同步】：5 - 收藏表情包：下载本地没有的表情包");
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

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public final void r(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            hr7.b().a(new c(this, list));
        }
    }

    public final void s(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            ir7.a("【表情云同步】：5 - 收藏表情包：根据云端数据进行排序");
            if (kr7.i().j(list, false)) {
                w(System.currentTimeMillis());
            }
            this.f = false;
        }
    }

    public final void t(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (ej.C()) {
                hr7.b().a(new e(this, list));
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

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ir7.a("【表情云同步】：1 - 开始，请求\"c/e/meme/getAllMeme\"接口");
            this.f = true;
            this.g = true;
            this.b.z(new b(this));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hr7.b().a(new a(this));
        }
    }
}
