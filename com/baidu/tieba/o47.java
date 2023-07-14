package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class o47 implements ui5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o47() {
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

    @Override // com.baidu.tieba.ui5
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) && i != 3) {
            try {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ui5
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
            MessageManager.getInstance().runTask(2004603, (Class) null);
            try {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ui5
    public void onFileUpdateProgress(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) || downloadData == null) {
            return;
        }
        p47.f().i(downloadData);
    }

    @Override // com.baidu.tieba.ui5
    public boolean onFileDownloaded(DownloadData downloadData) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(downloadData.getPath());
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int g = i47.c().g(downloadData.getId(), fileInputStream);
                EmotionGroupData n = q47.o().n(downloadData.getId());
                if (n == null) {
                    if (g == 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            BdLog.detailException(e2);
                        }
                        return false;
                    }
                    n = new EmotionGroupData();
                    n.setBytesLength((int) downloadData.getSize());
                    n.setBytesReceived((int) downloadData.getLength());
                    n.setDownloadUrl(downloadData.getUrl());
                    n.setGroupId(downloadData.getId());
                    n.setEmotionsCount(g);
                    n.setHeight(downloadData.getHeight());
                    n.setWidth(downloadData.getWidth());
                    n.setDownloadTime(System.currentTimeMillis());
                    n.setGroupDesc(downloadData.getDescription());
                    n.setGroupName(downloadData.getName());
                    n.setStatus(1);
                    q47.o().g(n);
                }
                q47.o().h(downloadData.getStatusMsg(), n);
                downloadData.setStatusMsg(null);
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    BdLog.detailException(e3);
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                BdLog.detailException(e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        BdLog.detailException(e5);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        BdLog.detailException(e6);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ui5
    public boolean onPreDownload(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            EmotionGroupData n = q47.o().n(downloadData.getId());
            if (n != null && j47.d(downloadData.getId())) {
                q47.o().h(downloadData.getStatusMsg(), n);
                downloadData.setStatusMsg(null);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
