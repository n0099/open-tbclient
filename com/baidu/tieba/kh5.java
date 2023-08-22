package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null && !currentActivity.isDestroyed()) {
            new BdTopToast(currentActivity, 2000).setIcon(false).setContent(currentActivity.getString(R.string.item_download_fail)).show((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    public static void b(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, downloadData) == null) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null && !currentActivity.isDestroyed()) {
            new BdTopToast(currentActivity, 2000).setIcon(false).setContent(currentActivity.getString(R.string.item_download_no_net)).show((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    public static void c(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, downloadData) == null) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null && !currentActivity.isDestroyed()) {
            new BdTopToast(currentActivity, 2000).setIcon(true).setContent(currentActivity.getString(R.string.item_download_success)).show((ViewGroup) currentActivity.findViewById(16908290));
        }
    }
}
