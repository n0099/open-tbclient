package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class WebNativeReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_FROM = "aladdin_wake";
    public transient /* synthetic */ FieldHolder $fh;

    public WebNativeReceiver() {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            Intent intent2 = new Intent(context, DealIntentService.class);
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("type");
            String stringExtra2 = intent.getStringExtra("from");
            if (stringExtra2 == null) {
                stringExtra2 = DEFAULT_FROM;
            }
            if (stringExtra == null) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 3);
            } else if (stringExtra.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 0);
                intent2.putExtra("url", intent.getStringExtra("url"));
                intent2.putExtra("from", stringExtra2);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "aladdin", null, 1, "st_type", stringExtra2, "st_param", intent.getStringExtra("url"));
            } else if (stringExtra.equals("pb")) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 1);
                intent2.putExtra("id", intent.getStringExtra("id"));
                intent2.putExtra("from", stringExtra2);
            } else if (stringExtra.equals("frs")) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
                intent2.putExtra("from", stringExtra2);
            } else if (stringExtra.equals("groupinfo")) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 13);
                intent2.putExtra(DBTableDefine.GroupMessageColumns.COLUMN_GROUPID, intent.getStringExtra(DBTableDefine.GroupMessageColumns.COLUMN_GROUPID));
            } else if (stringExtra.equals(TiebaStatic.DQPay.TYPE_VALUE)) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 15);
                intent2.putExtra(MemberPayActivityConfig.PAY_TYPE, intent.getStringExtra(MemberPayActivityConfig.PAY_TYPE));
                intent2.putExtra("props_id", intent.getStringExtra("props_id"));
                intent2.putExtra("quan_num", intent.getStringExtra("quan_num"));
                intent2.putExtra("is_left", intent.getStringExtra("is_left"));
                intent2.putExtra("props_mon", intent.getStringExtra("props_mon"));
            } else if (stringExtra.equals("officialba_msg")) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 22);
                intent2.putExtra("barid", intent.getStringExtra("barid"));
                intent2.putExtra("barname", intent.getStringExtra("barname"));
                intent2.putExtra("portrait", intent.getStringExtra("portrait"));
            } else if (stringExtra.equals("recommendpb")) {
                intent2.putExtra(DealIntentService.KEY_CLASS, 28);
                intent2.putExtra(PbChosenActivityConfig.KEY_TID, intent.getStringExtra(PbChosenActivityConfig.KEY_TID));
            } else {
                return;
            }
            context.startService(intent2);
        }
    }
}
