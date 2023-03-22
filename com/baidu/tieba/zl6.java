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
public class zl6 implements dg<rm> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tg5 a;

    @Override // com.baidu.tieba.dg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public zl6() {
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
        this.a = tg5.b;
    }

    @Override // com.baidu.tieba.dg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return pv4.c().g();
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
    @Override // com.baidu.tieba.dg
    /* renamed from: b */
    public rm getFromLocal(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        rm rmVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
            rm rmVar2 = null;
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
            ArrayList<dc5> i3 = em6.k().i();
            if ((em6.k().q(str3) || em6.k().r(str3)) && valueOf2.booleanValue() && !new File(em6.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (em6.k().o(str3) && valueOf2.booleanValue()) {
                String g = em6.k().g(str3, true);
                String h = em6.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = em6.k().g(str3, true);
                Iterator<dc5> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    dc5 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            rmVar2 = next.n(str3);
                        } else {
                            rmVar2 = e(next.f(), g2, agVar);
                        }
                    }
                }
                if (rmVar2 == null && valueOf != null) {
                    return e(valueOf, g2, agVar);
                }
                return rmVar2;
            }
            String g3 = em6.k().g(str3, false);
            if (booleanValue && em6.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<dc5> it2 = i3.iterator();
            rm rmVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    dc5 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            rmVar3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, agVar);
                            if (f2 == null) {
                                return null;
                            }
                            rmVar = new rm(f2, false, str3);
                        }
                    }
                } else {
                    rmVar = rmVar3;
                    break;
                }
            }
            if (rmVar == null && valueOf != null && (f = f(valueOf, g3, agVar)) != null) {
                return new rm(f, false, str3);
            }
            return rmVar;
        }
        return (rm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg
    /* renamed from: d */
    public rm getFromRemote(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        rm rmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
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
                    dp5.g(zl6.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = em6.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                wb wbVar = new wb(str3, g, DiskFileOperate.Action.WRITE);
                                wbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                wbVar.setSubFolder(false);
                                wbVar.setSavedCache(false);
                                wbVar.setSdCard(false);
                                wbVar.setData(downloadImageBytes);
                                ub.f().call(wbVar);
                                if (agVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(wbVar);
                                    agVar.a = diskCancelWorker;
                                }
                                Iterator<dc5> it = em6.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        dc5 next = it.next();
                                        if (next.m(valueOf2)) {
                                            rmVar = e(next.f(), g, agVar);
                                            break;
                                        }
                                    } else {
                                        rmVar = null;
                                        break;
                                    }
                                }
                                if (rmVar == null && valueOf != null) {
                                    rmVar = e(valueOf, g, agVar);
                                }
                                if (rmVar == null) {
                                    return null;
                                }
                            } else {
                                TbImageMemoryCache.o().m(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                rm rmVar2 = new rm(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                rmVar2.y(needCache);
                                if (needCache) {
                                    yb ybVar = new yb(str3, g, DiskFileOperate.Action.WRITE);
                                    ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    ybVar.setSubFolder(false);
                                    ybVar.setData(downloadImageBytes);
                                    ybVar.setSavedCache(false);
                                    ybVar.setSdCard(false);
                                    ybVar.setGif(valueOf4.booleanValue());
                                    ub.f().a(ybVar);
                                    if (agVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(ybVar);
                                        agVar.a = diskCancelWorker2;
                                    }
                                }
                                rmVar = rmVar2;
                            }
                            return rmVar;
                        }
                    }
                }
            }
            return null;
        }
        return (rm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg
    /* renamed from: c */
    public rm getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.o().u(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (rm) invokeCommon.objValue;
    }

    public rm e(String str, String str2, ag agVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, agVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, agVar);
                if (f == null) {
                    return null;
                }
                return new rm(f, false, str2);
            }
            byte[] bArr = new byte[0];
            wb wbVar = new wb(str3, str2, DiskFileOperate.Action.READ);
            wbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            wbVar.setSubFolder(false);
            wbVar.setIsFormatData(false);
            wbVar.setSavedCache(false);
            wbVar.setSdCard(false);
            wbVar.setLock(bArr);
            if (agVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(wbVar);
                agVar.a = diskCancelWorker;
            }
            if (!ub.f().a(wbVar)) {
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
            if (!wbVar.isSuccess()) {
                return null;
            }
            wbVar.formatData(wbVar.getData());
            return new rm(wbVar.a());
        }
        return (rm) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, ag agVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, agVar)) == null) {
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
            if (agVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                agVar.a = diskCancelWorker;
            }
            if (!ub.f().a(diskEmotionOperate)) {
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
        em6 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = em6.k()).g(str, true)) != null) {
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

    @Override // com.baidu.tieba.dg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof rm)) {
            rm rmVar = (rm) obj;
            if (rmVar.u()) {
                rmVar.A(i);
                rmVar.z(i2);
                TbImageMemoryCache.o().g(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), rmVar);
            }
        }
    }
}
