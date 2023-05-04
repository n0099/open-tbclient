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
/* loaded from: classes6.dex */
public class vq6 implements dg<tm> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ri5 a;

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

    public vq6() {
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
        this.a = ri5.b;
    }

    @Override // com.baidu.tieba.dg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return iw4.c().g();
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
    public tm getFromLocal(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        tm tmVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
            tm tmVar2 = null;
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
            ArrayList<be5> i3 = ar6.k().i();
            if ((ar6.k().q(str3) || ar6.k().r(str3)) && valueOf2.booleanValue() && !new File(ar6.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (ar6.k().o(str3) && valueOf2.booleanValue()) {
                String g = ar6.k().g(str3, true);
                String h = ar6.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = ar6.k().g(str3, true);
                Iterator<be5> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    be5 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            tmVar2 = next.n(str3);
                        } else {
                            tmVar2 = e(next.f(), g2, agVar);
                        }
                    }
                }
                if (tmVar2 == null && valueOf != null) {
                    return e(valueOf, g2, agVar);
                }
                return tmVar2;
            }
            String g3 = ar6.k().g(str3, false);
            if (booleanValue && ar6.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<be5> it2 = i3.iterator();
            tm tmVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    be5 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            tmVar3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, agVar);
                            if (f2 == null) {
                                return null;
                            }
                            tmVar = new tm(f2, false, str3);
                        }
                    }
                } else {
                    tmVar = tmVar3;
                    break;
                }
            }
            if (tmVar == null && valueOf != null && (f = f(valueOf, g3, agVar)) != null) {
                return new tm(f, false, str3);
            }
            return tmVar;
        }
        return (tm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg
    /* renamed from: d */
    public tm getFromRemote(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        tm tmVar;
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
                    dr5.g(vq6.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = ar6.k().g(valueOf2, valueOf4.booleanValue());
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
                                Iterator<be5> it = ar6.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        be5 next = it.next();
                                        if (next.m(valueOf2)) {
                                            tmVar = e(next.f(), g, agVar);
                                            break;
                                        }
                                    } else {
                                        tmVar = null;
                                        break;
                                    }
                                }
                                if (tmVar == null && valueOf != null) {
                                    tmVar = e(valueOf, g, agVar);
                                }
                                if (tmVar == null) {
                                    return null;
                                }
                            } else {
                                TbImageMemoryCache.v().t(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                tm tmVar2 = new tm(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                tmVar2.y(needCache);
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
                                tmVar = tmVar2;
                            }
                            return tmVar;
                        }
                    }
                }
            }
            return null;
        }
        return (tm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg
    /* renamed from: c */
    public tm getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.v().A(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (tm) invokeCommon.objValue;
    }

    public tm e(String str, String str2, ag agVar) {
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
                return new tm(f, false, str2);
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
            return new tm(wbVar.a());
        }
        return (tm) invokeLLL.objValue;
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
        ar6 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = ar6.k()).g(str, true)) != null) {
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
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof tm)) {
            tm tmVar = (tm) obj;
            if (tmVar.u()) {
                tmVar.A(i);
                tmVar.z(i2);
                TbImageMemoryCache.v().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), tmVar);
            }
        }
    }
}
