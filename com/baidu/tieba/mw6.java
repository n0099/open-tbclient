package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ImageView.BdImage;
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
public class mw6 implements sb<BdImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fl5 a;

    @Override // com.baidu.tieba.sb
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sb
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public mw6() {
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
        this.a = fl5.b;
    }

    @Override // com.baidu.tieba.sb
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return lv4.c().g();
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
    @Override // com.baidu.tieba.sb
    /* renamed from: b */
    public BdImage getFromLocal(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        BdImage bdImage;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
            BdImage bdImage2 = null;
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
            ArrayList<se5> i3 = rw6.k().i();
            if ((rw6.k().q(str3) || rw6.k().r(str3)) && valueOf2.booleanValue() && !new File(rw6.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (rw6.k().o(str3) && valueOf2.booleanValue()) {
                String g = rw6.k().g(str3, true);
                String h = rw6.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = rw6.k().g(str3, true);
                Iterator<se5> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    se5 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            bdImage2 = next.n(str3);
                        } else {
                            bdImage2 = e(next.f(), g2, rbVar);
                        }
                    }
                }
                if (bdImage2 == null && valueOf != null) {
                    return e(valueOf, g2, rbVar);
                }
                return bdImage2;
            }
            String g3 = rw6.k().g(str3, false);
            if (booleanValue && rw6.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<se5> it2 = i3.iterator();
            BdImage bdImage3 = null;
            while (true) {
                if (it2.hasNext()) {
                    se5 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            bdImage3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, rbVar);
                            if (f2 == null) {
                                return null;
                            }
                            bdImage = new BdImage(f2, false, str3);
                        }
                    }
                } else {
                    bdImage = bdImage3;
                    break;
                }
            }
            if (bdImage == null && valueOf != null && (f = f(valueOf, g3, rbVar)) != null) {
                return new BdImage(f, false, str3);
            }
            return bdImage;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb
    /* renamed from: d */
    public BdImage getFromRemote(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
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
                    kt5.g(mw6.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = rw6.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                l7 l7Var = new l7(str3, g, DiskFileOperate.Action.WRITE);
                                l7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                l7Var.setSubFolder(false);
                                l7Var.setSavedCache(false);
                                l7Var.setSdCard(false);
                                l7Var.setData(downloadImageBytes);
                                j7.g().d(l7Var);
                                if (rbVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(l7Var);
                                    rbVar.a = diskCancelWorker;
                                }
                                Iterator<se5> it = rw6.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        se5 next = it.next();
                                        if (next.m(valueOf2)) {
                                            bdImage = e(next.f(), g, rbVar);
                                            break;
                                        }
                                    } else {
                                        bdImage = null;
                                        break;
                                    }
                                }
                                if (bdImage == null && valueOf != null) {
                                    bdImage = e(valueOf, g, rbVar);
                                }
                                if (bdImage == null) {
                                    return null;
                                }
                            } else {
                                TbImageMemoryCache.B().v(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                BdImage bdImage2 = new BdImage(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                bdImage2.setNeedCache(needCache);
                                if (needCache) {
                                    n7 n7Var = new n7(str3, g, DiskFileOperate.Action.WRITE);
                                    n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    n7Var.setSubFolder(false);
                                    n7Var.setData(downloadImageBytes);
                                    n7Var.setSavedCache(false);
                                    n7Var.setSdCard(false);
                                    n7Var.setGif(valueOf4.booleanValue());
                                    j7.g().a(n7Var);
                                    if (rbVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(n7Var);
                                        rbVar.a = diskCancelWorker2;
                                    }
                                }
                                bdImage = bdImage2;
                            }
                            return bdImage;
                        }
                    }
                }
            }
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb
    /* renamed from: c */
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.B().D(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (BdImage) invokeCommon.objValue;
    }

    public BdImage e(String str, String str2, rb rbVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, rbVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, rbVar);
                if (f == null) {
                    return null;
                }
                return new BdImage(f, false, str2);
            }
            byte[] bArr = new byte[0];
            l7 l7Var = new l7(str3, str2, DiskFileOperate.Action.READ);
            l7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            l7Var.setSubFolder(false);
            l7Var.setIsFormatData(false);
            l7Var.setSavedCache(false);
            l7Var.setSdCard(false);
            l7Var.setLock(bArr);
            if (rbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(l7Var);
                rbVar.a = diskCancelWorker;
            }
            if (!j7.g().a(l7Var)) {
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
            if (!l7Var.isSuccess()) {
                return null;
            }
            l7Var.formatData(l7Var.getData());
            return new BdImage(l7Var.a());
        }
        return (BdImage) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, rb rbVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, rbVar)) == null) {
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
            if (rbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                rbVar.a = diskCancelWorker;
            }
            if (!j7.g().a(diskEmotionOperate)) {
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
        rw6 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = rw6.k()).g(str, true)) != null) {
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

    @Override // com.baidu.tieba.sb
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof BdImage)) {
            BdImage bdImage = (BdImage) obj;
            if (bdImage.isNeedCache()) {
                bdImage.setRequestWidth(i);
                bdImage.setRequestHeight(i2);
                TbImageMemoryCache.B().l(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), bdImage);
            }
        }
    }
}
