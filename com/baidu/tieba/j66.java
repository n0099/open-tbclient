package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes4.dex */
public class j66 implements mg<an> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a75 a;

    public j66() {
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
        this.a = a75.b;
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
    @Override // com.baidu.tieba.mg
    /* renamed from: b */
    public an getFromLocal(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        an anVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            an anVar2 = null;
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
            ArrayList<d35> i3 = o66.k().i();
            if ((o66.k().q(valueOf2) || o66.k().r(valueOf2)) && valueOf3.booleanValue() && !new File(o66.k().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (o66.k().o(valueOf2) && valueOf3.booleanValue()) {
                String g = o66.k().g(valueOf2, true);
                String h = o66.k().h(valueOf2);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = o66.k().g(valueOf2, true);
                Iterator<d35> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d35 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            anVar2 = next.n(valueOf2);
                        } else {
                            anVar2 = e(next.f(), g2, jgVar);
                        }
                    }
                }
                return (anVar2 != null || valueOf == null) ? anVar2 : e(valueOf, g2, jgVar);
            }
            String g3 = o66.k().g(valueOf2, false);
            if (booleanValue && o66.k().o(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<d35> it2 = i3.iterator();
            an anVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    anVar = anVar3;
                    break;
                }
                d35 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        anVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, jgVar);
                        if (f2 == null) {
                            return null;
                        }
                        anVar = new an(f2, false, valueOf2);
                    }
                }
            }
            return (anVar != null || valueOf == null || (f = f(valueOf, g3, jgVar)) == null) ? anVar : new an(f, false, valueOf2);
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mg
    /* renamed from: c */
    public an getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? m55.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mg
    /* renamed from: d */
    public an getFromRemote(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        an anVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    se5.g(j66.class.getSimpleName(), valueOf4);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = o66.k().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                yb ybVar = new yb(str3, g, DiskFileOperate.Action.WRITE);
                                ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                ybVar.setSubFolder(false);
                                ybVar.setSavedCache(false);
                                ybVar.setSdCard(false);
                                ybVar.setData(downloadImageBytes);
                                wb.f().call(ybVar);
                                if (jgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(ybVar);
                                    jgVar.a = diskCancelWorker;
                                }
                                Iterator<d35> it = o66.k().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        anVar = null;
                                        break;
                                    }
                                    d35 next = it.next();
                                    if (next.m(valueOf2)) {
                                        anVar = e(next.f(), g, jgVar);
                                        break;
                                    }
                                }
                                if (anVar == null && valueOf != null) {
                                    anVar = e(valueOf, g, jgVar);
                                }
                                if (anVar == null) {
                                    return null;
                                }
                            } else {
                                m55.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                an anVar2 = new an(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                anVar2.y(needCache);
                                if (needCache) {
                                    ac acVar = new ac(str3, g, DiskFileOperate.Action.WRITE);
                                    acVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    acVar.setSubFolder(false);
                                    acVar.setData(downloadImageBytes);
                                    acVar.setSavedCache(false);
                                    acVar.setSdCard(false);
                                    acVar.setGif(valueOf3.booleanValue());
                                    wb.f().a(acVar);
                                    if (jgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(acVar);
                                        jgVar.a = diskCancelWorker2;
                                    }
                                }
                                anVar = anVar2;
                            }
                            return anVar;
                        }
                    }
                }
            }
            return null;
        }
        return (an) invokeCommon.objValue;
    }

    public an e(String str, String str2, jg jgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, jgVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, jgVar);
                if (f == null) {
                    return null;
                }
                return new an(f, false, str2);
            }
            byte[] bArr = new byte[0];
            yb ybVar = new yb(str3, str2, DiskFileOperate.Action.READ);
            ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ybVar.setSubFolder(false);
            ybVar.setIsFormatData(false);
            ybVar.setSavedCache(false);
            ybVar.setSdCard(false);
            ybVar.setLock(bArr);
            if (jgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ybVar);
                jgVar.a = diskCancelWorker;
            }
            if (wb.f().a(ybVar)) {
                int i = pi.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (ybVar.isSuccess()) {
                    ybVar.formatData(ybVar.getData());
                    return new an(ybVar.a());
                }
                return null;
            }
            return null;
        }
        return (an) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, jg jgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, jgVar)) == null) {
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
            if (jgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                jgVar.a = diskCancelWorker;
            }
            if (wb.f().a(diskEmotionOperate)) {
                int i = pi.H() ? 300 : 2000;
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
        o66 k;
        String g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (g = (k = o66.k()).g(str, true)) == null) {
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

    @Override // com.baidu.tieba.mg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? sn4.c().g() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof an)) {
            an anVar = (an) obj;
            if (anVar.u()) {
                anVar.A(i);
                anVar.z(i2);
                m55.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), anVar);
            }
        }
    }
}
