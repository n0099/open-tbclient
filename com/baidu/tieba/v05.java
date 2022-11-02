package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v05 implements tg<t05> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: b */
    public t05 getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (t05) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }

    public v05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: a */
    public t05 getFromLocal(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(false);
            diskFileOperate.setIsFormatData(false);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskFileOperate);
                qgVar.a = diskCancelWorker;
            }
            diskFileOperate.call();
            if (!diskFileOperate.isSuccess()) {
                return null;
            }
            String desPath = diskFileOperate.getDesPath();
            t05 t05Var = new t05();
            t05Var.a = str;
            t05Var.b = desPath;
            return t05Var;
        }
        return (t05) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: c */
    public t05 getFromRemote(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            int i3 = 1;
            String str4 = null;
            if (objArr.length == 1) {
                str3 = String.valueOf(objArr[0]);
            } else {
                str3 = null;
            }
            t05 t05Var = new t05();
            WebClient webClient = new WebClient();
            if (qgVar != null) {
                qgVar.a = webClient;
            }
            String str5 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
            if (!TextUtils.isEmpty(str3)) {
                str5 = str5 + "&play_from=" + str3;
            }
            byte[] downloadCommonBytes = webClient.downloadCommonBytes(str5);
            if (!webClient.IsRequestSuccess()) {
                t05Var.c = 3;
                t05Var.d = pj.a(R.string.obfuscated_res_0x7f0f0c7f);
                return t05Var;
            } else if (downloadCommonBytes != null && downloadCommonBytes.length != 0) {
                if (str == null) {
                    i3 = 5;
                } else if (downloadCommonBytes != null && downloadCommonBytes.length != 0) {
                    DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                    diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                    diskFileOperate.setSubFolder(false);
                    diskFileOperate.setData(downloadCommonBytes);
                    if (qgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(diskFileOperate);
                        qgVar.a = diskCancelWorker;
                    }
                    diskFileOperate.call();
                    if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                        str4 = diskFileOperate.getFileInfo().getAbsolutePath();
                        i3 = 0;
                    } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                        i3 = 2;
                    }
                } else {
                    i3 = 6;
                }
                if (i3 == 0) {
                    t05Var.b = str4;
                    t05Var.a = str;
                } else {
                    t05Var.c = i3;
                    t05Var.d = t05.a(i3);
                }
                return t05Var;
            } else {
                t05Var.c = 4;
                t05Var.d = pj.a(R.string.obfuscated_res_0x7f0f15b9);
                return t05Var;
            }
        }
        return (t05) invokeCommon.objValue;
    }
}
