package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ue8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteViews a;

    /* loaded from: classes6.dex */
    public class a extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue8 a;

        public a(ue8 ue8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) || this.a.a == null || onVar == null || onVar.p() == null) {
                return;
            }
            this.a.a.setImageViewBitmap(R.id.obfuscated_res_0x7f09029c, onVar.p());
        }
    }

    public ue8(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadData, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), (int) R.layout.obfuscated_res_0x7f0d023b);
        c(i);
        this.a.setTextViewText(R.id.obfuscated_res_0x7f090841, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cfe));
        this.a.setImageViewResource(R.id.obfuscated_res_0x7f09082f, R.drawable.obfuscated_res_0x7f080e79);
        this.a.setImageViewResource(R.id.obfuscated_res_0x7f090832, R.drawable.obfuscated_res_0x7f080e77);
        this.a.setTextViewText(R.id.obfuscated_res_0x7f09082d, downloadData.getUser_name());
        zg.h().m(downloadData.getApp_icon(), 17, new a(this), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.a.setOnClickPendingIntent(R.id.obfuscated_res_0x7f09082f, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.a.setOnClickPendingIntent(R.id.obfuscated_res_0x7f090832, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (RemoteViews) invokeV.objValue;
    }

    public void c(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i > 0) {
                str = i + "%";
            } else {
                str = "0%";
            }
            this.a.setProgressBar(R.id.obfuscated_res_0x7f09083f, 100, i, false);
            this.a.setTextViewText(R.id.obfuscated_res_0x7f090840, str);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setTextViewText(R.id.obfuscated_res_0x7f090841, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0523));
            this.a.setImageViewResource(R.id.obfuscated_res_0x7f09082f, R.drawable.obfuscated_res_0x7f080e7a);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setTextViewText(R.id.obfuscated_res_0x7f090841, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cfe));
            this.a.setImageViewResource(R.id.obfuscated_res_0x7f09082f, R.drawable.obfuscated_res_0x7f080e79);
        }
    }
}
