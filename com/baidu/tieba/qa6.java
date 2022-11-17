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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class qa6 implements ug<in> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final cb5 a;

    @Override // com.baidu.tieba.ug
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ug
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public qa6() {
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
        this.a = cb5.b;
    }

    @Override // com.baidu.tieba.ug
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return cr4.c().g();
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
    @Override // com.baidu.tieba.ug
    /* renamed from: b */
    public in getFromLocal(String str, String str2, int i, int i2, rg rgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        in inVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rgVar, objArr})) == null) {
            in inVar2 = null;
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
            ArrayList<d75> i3 = va6.k().i();
            if ((va6.k().q(str3) || va6.k().r(str3)) && valueOf2.booleanValue() && !new File(va6.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (va6.k().o(str3) && valueOf2.booleanValue()) {
                String g = va6.k().g(str3, true);
                String h = va6.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = va6.k().g(str3, true);
                Iterator<d75> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d75 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            inVar2 = next.n(str3);
                        } else {
                            inVar2 = e(next.f(), g2, rgVar);
                        }
                    }
                }
                if (inVar2 == null && valueOf != null) {
                    return e(valueOf, g2, rgVar);
                }
                return inVar2;
            }
            String g3 = va6.k().g(str3, false);
            if (booleanValue && va6.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<d75> it2 = i3.iterator();
            in inVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    d75 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            inVar3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, rgVar);
                            if (f2 == null) {
                                return null;
                            }
                            inVar = new in(f2, false, str3);
                        }
                    }
                } else {
                    inVar = inVar3;
                    break;
                }
            }
            if (inVar == null && valueOf != null && (f = f(valueOf, g3, rgVar)) != null) {
                return new in(f, false, str3);
            }
            return inVar;
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ug
    /* renamed from: d */
    public in getFromRemote(String str, String str2, int i, int i2, rg rgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        in inVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rgVar, objArr})) == null) {
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
                    xi5.g(qa6.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = va6.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                nc ncVar = new nc(str3, g, DiskFileOperate.Action.WRITE);
                                ncVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                ncVar.setSubFolder(false);
                                ncVar.setSavedCache(false);
                                ncVar.setSdCard(false);
                                ncVar.setData(downloadImageBytes);
                                lc.f().call(ncVar);
                                if (rgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(ncVar);
                                    rgVar.a = diskCancelWorker;
                                }
                                Iterator<d75> it = va6.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        d75 next = it.next();
                                        if (next.m(valueOf2)) {
                                            inVar = e(next.f(), g, rgVar);
                                            break;
                                        }
                                    } else {
                                        inVar = null;
                                        break;
                                    }
                                }
                                if (inVar == null && valueOf != null) {
                                    inVar = e(valueOf, g, rgVar);
                                }
                                if (inVar == null) {
                                    return null;
                                }
                            } else {
                                l95.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                in inVar2 = new in(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                inVar2.y(needCache);
                                if (needCache) {
                                    pc pcVar = new pc(str3, g, DiskFileOperate.Action.WRITE);
                                    pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    pcVar.setSubFolder(false);
                                    pcVar.setData(downloadImageBytes);
                                    pcVar.setSavedCache(false);
                                    pcVar.setSdCard(false);
                                    pcVar.setGif(valueOf4.booleanValue());
                                    lc.f().a(pcVar);
                                    if (rgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(pcVar);
                                        rgVar.a = diskCancelWorker2;
                                    }
                                }
                                inVar = inVar2;
                            }
                            return inVar;
                        }
                    }
                }
            }
            return null;
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ug
    /* renamed from: c */
    public in getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return l95.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (in) invokeCommon.objValue;
    }

    public in e(String str, String str2, rg rgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, rgVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, rgVar);
                if (f == null) {
                    return null;
                }
                return new in(f, false, str2);
            }
            byte[] bArr = new byte[0];
            nc ncVar = new nc(str3, str2, DiskFileOperate.Action.READ);
            ncVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ncVar.setSubFolder(false);
            ncVar.setIsFormatData(false);
            ncVar.setSavedCache(false);
            ncVar.setSdCard(false);
            ncVar.setLock(bArr);
            if (rgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ncVar);
                rgVar.a = diskCancelWorker;
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
            return new in(ncVar.a());
        }
        return (in) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, rg rgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, rgVar)) == null) {
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
            if (rgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                rgVar.a = diskCancelWorker;
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

    public final void g(@NonNull String str) {
        va6 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = va6.k()).g(str, true)) != null) {
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

    @Override // com.baidu.tieba.ug
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof in)) {
            in inVar = (in) obj;
            if (inVar.u()) {
                inVar.A(i);
                inVar.z(i2);
                l95.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), inVar);
            }
        }
    }
}
