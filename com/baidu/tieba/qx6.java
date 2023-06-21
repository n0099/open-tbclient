package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DiskEmotionOperate;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class qx6 implements rg<hn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final io5 a;

    @Override // com.baidu.tieba.rg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public qx6() {
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
        this.a = io5.b;
    }

    @Override // com.baidu.tieba.rg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return o05.c().g();
        }
        return invokeV.booleanValue;
    }

    public final String a(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (z) {
                str2 = "_gif";
            } else {
                str2 = "";
            }
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rg
    /* renamed from: b */
    public hn getFromLocal(String str, String str2, int i, int i2, og ogVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        hn hnVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ogVar, objArr})) == null) {
            hn hnVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String str3 = "";
            if (objArr[0] == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(objArr[0]);
            }
            if (objArr[1] != null) {
                str3 = String.valueOf(objArr[1]);
            }
            Boolean valueOf2 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || str3 == null || valueOf2 == null) {
                return null;
            }
            g(str3);
            ArrayList<ri5> i3 = vx6.k().i();
            if ((vx6.k().q(str3) || vx6.k().r(str3)) && valueOf2.booleanValue() && !new File(vx6.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (vx6.k().o(str3) && valueOf2.booleanValue()) {
                String g = vx6.k().g(str3, true);
                String h = vx6.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = vx6.k().g(str3, true);
                Iterator<ri5> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ri5 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            hnVar2 = next.n(str3);
                        } else {
                            hnVar2 = e(next.f(), g2, ogVar);
                        }
                    }
                }
                if (hnVar2 == null && valueOf != null) {
                    return e(valueOf, g2, ogVar);
                }
                return hnVar2;
            }
            String g3 = vx6.k().g(str3, false);
            if (booleanValue && vx6.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<ri5> it2 = i3.iterator();
            hn hnVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    ri5 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            hnVar3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, ogVar);
                            if (f2 == null) {
                                return null;
                            }
                            hnVar = new hn(f2, false, str3);
                        }
                    }
                } else {
                    hnVar = hnVar3;
                    break;
                }
            }
            if (hnVar == null && valueOf != null && (f = f(valueOf, g3, ogVar)) != null) {
                return new hn(f, false, str3);
            }
            return hnVar;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rg
    /* renamed from: d */
    public hn getFromRemote(String str, String str2, int i, int i2, og ogVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        hn hnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ogVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                if (objArr[0] == null) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(objArr[0]);
                }
                if (objArr[1] == null) {
                    valueOf2 = "";
                } else {
                    valueOf2 = String.valueOf(objArr[1]);
                }
                Boolean valueOf4 = Boolean.valueOf(String.valueOf(objArr[2]));
                if (objArr[3] == null) {
                    valueOf3 = "";
                } else {
                    valueOf3 = String.valueOf(objArr[3]);
                }
                if (valueOf != null && valueOf2 != null && valueOf4 != null && valueOf3 != null) {
                    vw5.g(qx6.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = vx6.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                gc gcVar = new gc(str3, g, DiskFileOperate.Action.WRITE);
                                gcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                gcVar.setSubFolder(false);
                                gcVar.setSavedCache(false);
                                gcVar.setSdCard(false);
                                gcVar.setData(downloadImageBytes);
                                ec.f().call(gcVar);
                                if (ogVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(gcVar);
                                    ogVar.a = diskCancelWorker;
                                }
                                Iterator<ri5> it = vx6.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        ri5 next = it.next();
                                        if (next.m(valueOf2)) {
                                            hnVar = e(next.f(), g, ogVar);
                                            break;
                                        }
                                    } else {
                                        hnVar = null;
                                        break;
                                    }
                                }
                                if (hnVar == null && valueOf != null) {
                                    hnVar = e(valueOf, g, ogVar);
                                }
                                if (hnVar == null) {
                                    return null;
                                }
                            } else {
                                TbImageMemoryCache.u().s(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                hn hnVar2 = new hn(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                hnVar2.y(needCache);
                                if (needCache) {
                                    ic icVar = new ic(str3, g, DiskFileOperate.Action.WRITE);
                                    icVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    icVar.setSubFolder(false);
                                    icVar.setData(downloadImageBytes);
                                    icVar.setSavedCache(false);
                                    icVar.setSdCard(false);
                                    icVar.setGif(valueOf4.booleanValue());
                                    ec.f().a(icVar);
                                    if (ogVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(icVar);
                                        ogVar.a = diskCancelWorker2;
                                    }
                                }
                                hnVar = hnVar2;
                            }
                            return hnVar;
                        }
                    }
                }
            }
            return null;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rg
    /* renamed from: c */
    public hn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.u().z(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (hn) invokeCommon.objValue;
    }

    public hn e(String str, String str2, og ogVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, ogVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, ogVar);
                if (f == null) {
                    return null;
                }
                return new hn(f, false, str2);
            }
            byte[] bArr = new byte[0];
            gc gcVar = new gc(str3, str2, DiskFileOperate.Action.READ);
            gcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            gcVar.setSubFolder(false);
            gcVar.setIsFormatData(false);
            gcVar.setSavedCache(false);
            gcVar.setSdCard(false);
            gcVar.setLock(bArr);
            if (ogVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(gcVar);
                ogVar.a = diskCancelWorker;
            }
            if (!ec.f().a(gcVar)) {
                return null;
            }
            int i = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (!gcVar.isSuccess()) {
                return null;
            }
            gcVar.formatData(gcVar.getData());
            return new hn(gcVar.a());
        }
        return (hn) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, og ogVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, ogVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(".emotions/");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            byte[] bArr = new byte[0];
            DiskEmotionOperate diskEmotionOperate = new DiskEmotionOperate(sb.toString(), str2, DiskFileOperate.Action.READ);
            diskEmotionOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskEmotionOperate.setSubFolder(false);
            diskEmotionOperate.setIsFormatData(false);
            diskEmotionOperate.setSavedCache(false);
            diskEmotionOperate.setSdCard(false);
            diskEmotionOperate.setLock(bArr);
            if (ogVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                ogVar.a = diskCancelWorker;
            }
            if (!ec.f().a(diskEmotionOperate)) {
                return null;
            }
            int i = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (!diskEmotionOperate.isSuccess()) {
                return null;
            }
            diskEmotionOperate.formatData(diskEmotionOperate.getData());
            return diskEmotionOperate.getBitmap();
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final void g(@NonNull String str) {
        vx6 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = vx6.k()).g(str, true)) != null) {
            boolean q = k.q(str);
            boolean r = k.r(str);
            String replace = g.replace(".gif", ".jpg");
            if (!q && !r) {
                g = this.a.e(k.h(str), g);
                replace = g.replace(".gif", ".jpg");
            }
            if (FileHelper.isGifImage(replace)) {
                FileHelper.renameTo(replace, g);
            }
        }
    }

    @Override // com.baidu.tieba.rg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof hn)) {
            hn hnVar = (hn) obj;
            if (hnVar.u()) {
                hnVar.A(i);
                hnVar.z(i2);
                TbImageMemoryCache.u().l(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), hnVar);
            }
        }
    }
}
