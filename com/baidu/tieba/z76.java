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
/* loaded from: classes6.dex */
public class z76 implements ah<on> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i95 a;

    public z76() {
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
        this.a = i95.b;
    }

    public final String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? "_gif" : "");
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah
    /* renamed from: b */
    public on getFromLocal(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        on onVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            on onVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || valueOf2 == null || valueOf3 == null) {
                return null;
            }
            g(valueOf2);
            ArrayList<m55> i3 = e86.k().i();
            if ((e86.k().q(valueOf2) || e86.k().r(valueOf2)) && valueOf3.booleanValue() && !new File(e86.k().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (e86.k().o(valueOf2) && valueOf3.booleanValue()) {
                String g = e86.k().g(valueOf2, true);
                String h = e86.k().h(valueOf2);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = e86.k().g(valueOf2, true);
                Iterator<m55> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m55 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            onVar2 = next.n(valueOf2);
                        } else {
                            onVar2 = e(next.f(), g2, xgVar);
                        }
                    }
                }
                return (onVar2 != null || valueOf == null) ? onVar2 : e(valueOf, g2, xgVar);
            }
            String g3 = e86.k().g(valueOf2, false);
            if (booleanValue && e86.k().o(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<m55> it2 = i3.iterator();
            on onVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    onVar = onVar3;
                    break;
                }
                m55 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        onVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, xgVar);
                        if (f2 == null) {
                            return null;
                        }
                        onVar = new on(f2, false, valueOf2);
                    }
                }
            }
            return (onVar != null || valueOf == null || (f = f(valueOf, g3, xgVar)) == null) ? onVar : new on(f, false, valueOf2);
        }
        return (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah
    /* renamed from: c */
    public on getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? u75.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah
    /* renamed from: d */
    public on getFromRemote(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        on onVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    zg5.g(z76.class.getSimpleName(), valueOf4);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = e86.k().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                mc mcVar = new mc(str3, g, DiskFileOperate.Action.WRITE);
                                mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                mcVar.setSubFolder(false);
                                mcVar.setSavedCache(false);
                                mcVar.setSdCard(false);
                                mcVar.setData(downloadImageBytes);
                                kc.f().call(mcVar);
                                if (xgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(mcVar);
                                    xgVar.a = diskCancelWorker;
                                }
                                Iterator<m55> it = e86.k().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        onVar = null;
                                        break;
                                    }
                                    m55 next = it.next();
                                    if (next.m(valueOf2)) {
                                        onVar = e(next.f(), g, xgVar);
                                        break;
                                    }
                                }
                                if (onVar == null && valueOf != null) {
                                    onVar = e(valueOf, g, xgVar);
                                }
                                if (onVar == null) {
                                    return null;
                                }
                            } else {
                                u75.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                on onVar2 = new on(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                onVar2.y(needCache);
                                if (needCache) {
                                    oc ocVar = new oc(str3, g, DiskFileOperate.Action.WRITE);
                                    ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    ocVar.setSubFolder(false);
                                    ocVar.setData(downloadImageBytes);
                                    ocVar.setSavedCache(false);
                                    ocVar.setSdCard(false);
                                    ocVar.setGif(valueOf3.booleanValue());
                                    kc.f().a(ocVar);
                                    if (xgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(ocVar);
                                        xgVar.a = diskCancelWorker2;
                                    }
                                }
                                onVar = onVar2;
                            }
                            return onVar;
                        }
                    }
                }
            }
            return null;
        }
        return (on) invokeCommon.objValue;
    }

    public on e(String str, String str2, xg xgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, xgVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, xgVar);
                if (f == null) {
                    return null;
                }
                return new on(f, false, str2);
            }
            byte[] bArr = new byte[0];
            mc mcVar = new mc(str3, str2, DiskFileOperate.Action.READ);
            mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            mcVar.setSubFolder(false);
            mcVar.setIsFormatData(false);
            mcVar.setSavedCache(false);
            mcVar.setSdCard(false);
            mcVar.setLock(bArr);
            if (xgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(mcVar);
                xgVar.a = diskCancelWorker;
            }
            if (kc.f().a(mcVar)) {
                int i = BdNetTypeUtil.isWifiNet() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (mcVar.isSuccess()) {
                    mcVar.formatData(mcVar.getData());
                    return new on(mcVar.a());
                }
                return null;
            }
            return null;
        }
        return (on) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, xg xgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, xgVar)) == null) {
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
            if (xgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                xgVar.a = diskCancelWorker;
            }
            if (kc.f().a(diskEmotionOperate)) {
                int i = BdNetTypeUtil.isWifiNet() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (diskEmotionOperate.isSuccess()) {
                    diskEmotionOperate.formatData(diskEmotionOperate.getData());
                    return diskEmotionOperate.getBitmap();
                }
                return null;
            }
            return null;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final void g(@NonNull String str) {
        e86 k;
        String g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (g = (k = e86.k()).g(str, true)) == null) {
            return;
        }
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

    @Override // com.baidu.tieba.ah
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ah
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ah
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? up4.c().g() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ah
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof on)) {
            on onVar = (on) obj;
            if (onVar.u()) {
                onVar.A(i);
                onVar.z(i2);
                u75.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), onVar);
            }
        }
    }
}
