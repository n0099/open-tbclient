package com.baidu.tieba.recapp.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c.a.t0.k3.f0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class RecAppDownloadReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_CANCEL_DOWNLOAD = "action_cancel_download";
    public static final String ACTION_PAUSE_DOWNLOAD = "action_pause_download";
    public static final String DOWNLOAD_DATA = "download_data";
    public transient /* synthetic */ FieldHolder $fh;

    public RecAppDownloadReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadData downloadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || (downloadData = (DownloadData) intent.getSerializableExtra("download_data")) == null) {
            return;
        }
        int l = k.l(downloadData);
        if ("action_pause_download".equals(intent.getAction())) {
            if (downloadData.getDownloadStaticsData() != null) {
                downloadData.getDownloadStaticsData().setDa_range_nt("1");
            }
            if (l == 7) {
                downloadData.setStatus(5);
                k.j().v(downloadData.getId(), downloadData.getUrl(), downloadData.getName(), downloadData.getPosition(), downloadData.getNotifyId(), downloadData.getTag(), downloadData.isNeedInvokeApk(), downloadData.isForceDownload(), downloadData.isNeedNotify(), downloadData.getApp_icon(), downloadData.getDownloadStaticsData(), downloadData.getUser_name());
                k.j().r(downloadData);
            } else if (l == 1 || l == 5) {
                downloadData.setStatus(4);
                k.j().f(downloadData.getUrl(), downloadData.getId(), true);
                k.j().o(downloadData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else if ("action_cancel_download".equals(intent.getAction())) {
            k.j().g(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016483, downloadData));
        }
    }
}
