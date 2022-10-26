package com.baidu.tieba;

import android.graphics.Bitmap;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class t86 implements bh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z95 a;

    @Override // com.baidu.tieba.bh
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public t86() {
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
        this.a = z95.b;
    }

    @Override // com.baidu.tieba.bh
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return jq4.c().g();
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
    @Override // com.baidu.tieba.bh
    /* renamed from: b */
    public pn getFromLocal(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        pn pnVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            pn pnVar2 = null;
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
            ArrayList i3 = y86.k().i();
            if ((y86.k().q(str3) || y86.k().r(str3)) && valueOf2.booleanValue() && !new File(y86.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (y86.k().o(str3) && valueOf2.booleanValue()) {
                String g = y86.k().g(str3, true);
                String h = y86.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = y86.k().g(str3, true);
                Iterator it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d65 d65Var = (d65) it.next();
                    if (d65Var.m(str3)) {
                        if (d65Var.j()) {
                            pnVar2 = d65Var.n(str3);
                        } else {
                            pnVar2 = e(d65Var.f(), g2, ygVar);
                        }
                    }
                }
                if (pnVar2 == null && valueOf != null) {
                    return e(valueOf, g2, ygVar);
                }
                return pnVar2;
            }
            String g3 = y86.k().g(str3, false);
            if (booleanValue && y86.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator it2 = i3.iterator();
            pn pnVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    d65 d65Var2 = (d65) it2.next();
                    if (d65Var2.m(str3)) {
                        if (d65Var2.j()) {
                            pnVar3 = d65Var2.o(str3);
                        } else {
                            Bitmap f2 = f(d65Var2.f(), g3, ygVar);
                            if (f2 == null) {
                                return null;
                            }
                            pnVar = new pn(f2, false, str3);
                        }
                    }
                } else {
                    pnVar = pnVar3;
                    break;
                }
            }
            if (pnVar == null && valueOf != null && (f = f(valueOf, g3, ygVar)) != null) {
                return new pn(f, false, str3);
            }
            return pnVar;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    /* renamed from: d */
    public pn getFromRemote(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        pn pnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
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
                    sh5.g(t86.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = y86.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                nc ncVar = new nc(str3, g, DiskFileOperate.Action.WRITE);
                                ncVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                ncVar.setSubFolder(false);
                                ncVar.setSavedCache(false);
                                ncVar.setSdCard(false);
                                ncVar.setData(downloadImageBytes);
                                lc.f().call(ncVar);
                                if (ygVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(ncVar);
                                    ygVar.a = diskCancelWorker;
                                }
                                Iterator it = y86.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        d65 d65Var = (d65) it.next();
                                        if (d65Var.m(valueOf2)) {
                                            pnVar = e(d65Var.f(), g, ygVar);
                                            break;
                                        }
                                    } else {
                                        pnVar = null;
                                        break;
                                    }
                                }
                                if (pnVar == null && valueOf != null) {
                                    pnVar = e(valueOf, g, ygVar);
                                }
                                if (pnVar == null) {
                                    return null;
                                }
                            } else {
                                l85.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                pn pnVar2 = new pn(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                pnVar2.y(needCache);
                                if (needCache) {
                                    pc pcVar = new pc(str3, g, DiskFileOperate.Action.WRITE);
                                    pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    pcVar.setSubFolder(false);
                                    pcVar.setData(downloadImageBytes);
                                    pcVar.setSavedCache(false);
                                    pcVar.setSdCard(false);
                                    pcVar.setGif(valueOf4.booleanValue());
                                    lc.f().a(pcVar);
                                    if (ygVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(pcVar);
                                        ygVar.a = diskCancelWorker2;
                                    }
                                }
                                pnVar = pnVar2;
                            }
                            return pnVar;
                        }
                    }
                }
            }
            return null;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    /* renamed from: c */
    public pn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return l85.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (pn) invokeCommon.objValue;
    }

    public pn e(String str, String str2, yg ygVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, ygVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, ygVar);
                if (f == null) {
                    return null;
                }
                return new pn(f, false, str2);
            }
            byte[] bArr = new byte[0];
            nc ncVar = new nc(str3, str2, DiskFileOperate.Action.READ);
            ncVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ncVar.setSubFolder(false);
            ncVar.setIsFormatData(false);
            ncVar.setSavedCache(false);
            ncVar.setSdCard(false);
            ncVar.setLock(bArr);
            if (ygVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ncVar);
                ygVar.a = diskCancelWorker;
            }
            if (!lc.f().a(ncVar)) {
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
            if (!ncVar.isSuccess()) {
                return null;
            }
            ncVar.formatData(ncVar.getData());
            return new pn(ncVar.a());
        }
        return (pn) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, yg ygVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, ygVar)) == null) {
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
            if (ygVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                ygVar.a = diskCancelWorker;
            }
            if (!lc.f().a(diskEmotionOperate)) {
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

    public final void g(String str) {
        y86 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = y86.k()).g(str, true)) != null) {
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

    @Override // com.baidu.tieba.bh
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof pn)) {
            pn pnVar = (pn) obj;
            if (pnVar.u()) {
                pnVar.A(i);
                pnVar.z(i2);
                l85.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), pnVar);
            }
        }
    }
}
