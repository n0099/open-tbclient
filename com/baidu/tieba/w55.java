package com.baidu.tieba;

import android.net.Uri;
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
public class w55 implements dg<u55> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg
    /* renamed from: b */
    public u55 getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (u55) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.dg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.dg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }

    public w55() {
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
    @Override // com.baidu.tieba.dg
    /* renamed from: a */
    public u55 getFromLocal(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
            if (str.contains("https://")) {
                str = Uri.parse(str).getLastPathSegment();
            }
            DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(false);
            diskFileOperate.setIsFormatData(false);
            if (agVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskFileOperate);
                agVar.a = diskCancelWorker;
            }
            diskFileOperate.call();
            if (!diskFileOperate.isSuccess()) {
                return null;
            }
            String desPath = diskFileOperate.getDesPath();
            u55 u55Var = new u55();
            u55Var.h(str);
            u55Var.i(desPath);
            return u55Var;
        }
        return (u55) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg
    /* renamed from: c */
    public u55 getFromRemote(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
            int i3 = 1;
            String str5 = null;
            if (objArr.length == 1) {
                str3 = String.valueOf(objArr[0]);
            } else {
                str3 = null;
            }
            u55 u55Var = new u55();
            WebClient webClient = new WebClient();
            if (agVar != null) {
                agVar.a = webClient;
            }
            if (str.contains("https://")) {
                str4 = Uri.parse(str).getLastPathSegment();
            } else {
                String str6 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str;
                    str = str6 + "&play_from=" + str3;
                } else {
                    str4 = str;
                    str = str6;
                }
            }
            byte[] downloadCommonBytes = webClient.downloadCommonBytes(str);
            if (!webClient.IsRequestSuccess()) {
                u55Var.f(3);
                u55Var.g(zi.a(R.string.obfuscated_res_0x7f0f0d1f));
                return u55Var;
            } else if (downloadCommonBytes != null && downloadCommonBytes.length != 0) {
                if (str4 == null) {
                    i3 = 5;
                } else if (downloadCommonBytes != null && downloadCommonBytes.length != 0) {
                    DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str4, DiskFileOperate.Action.WRITE);
                    diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                    diskFileOperate.setSubFolder(false);
                    diskFileOperate.setData(downloadCommonBytes);
                    if (agVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(diskFileOperate);
                        agVar.a = diskCancelWorker;
                    }
                    diskFileOperate.call();
                    if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                        str5 = diskFileOperate.getFileInfo().getAbsolutePath();
                        i3 = 0;
                    } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                        i3 = 2;
                    }
                } else {
                    i3 = 6;
                }
                if (i3 == 0) {
                    u55Var.i(str5);
                    u55Var.h(str4);
                } else {
                    u55Var.f(i3);
                    u55Var.g(u55.a(i3));
                }
                return u55Var;
            } else {
                u55Var.f(4);
                u55Var.g(zi.a(R.string.voice_cache_error_no_file));
                return u55Var;
            }
        }
        return (u55) invokeCommon.objValue;
    }
}
