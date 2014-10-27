package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class WebNativeReceiver extends BroadcastReceiver {
    private static final String DEFAULT_FROM = "aladdin_wake";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, DealIntentService.class);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            String stringExtra2 = intent.getStringExtra("from");
            if (stringExtra2 == null) {
                stringExtra2 = DEFAULT_FROM;
            }
            if (stringExtra == null) {
                intent2.putExtra("class", 3);
            } else if (stringExtra.equals("web")) {
                intent2.putExtra("class", 0);
                intent2.putExtra(ImageViewerConfig.URL, intent.getStringExtra(ImageViewerConfig.URL));
                intent2.putExtra("from", stringExtra2);
                TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), "aladdin", null, 1, "st_type", stringExtra2, "st_param", intent.getStringExtra(ImageViewerConfig.URL));
            } else if (stringExtra.equals("pb")) {
                intent2.putExtra("class", 1);
                intent2.putExtra("id", intent.getStringExtra("id"));
                intent2.putExtra("from", stringExtra2);
            } else if (stringExtra.equals("frs")) {
                intent2.putExtra("class", 2);
                intent2.putExtra(ImageViewerConfig.FORUM_NAME, intent.getStringExtra(ImageViewerConfig.FORUM_NAME));
                intent2.putExtra("from", stringExtra2);
            } else if (stringExtra.equals("groupinfo")) {
                intent2.putExtra("class", 13);
                intent2.putExtra("groupid", intent.getStringExtra("groupid"));
            } else if (stringExtra.equals("pay")) {
                intent2.putExtra("class", 15);
                intent2.putExtra("pay_type", intent.getStringExtra("pay_type"));
                intent2.putExtra(PayActivityConfig.PROPS_ID, intent.getStringExtra(PayActivityConfig.PROPS_ID));
                intent2.putExtra("quan_num", intent.getStringExtra("quan_num"));
                intent2.putExtra(PayActivityConfig.IS_LEFT, intent.getStringExtra(PayActivityConfig.IS_LEFT));
                intent2.putExtra(PayActivityConfig.PROPS_MON, intent.getStringExtra(PayActivityConfig.PROPS_MON));
            } else if (stringExtra.equals("livegroup")) {
                intent2.putExtra("class", 17);
                intent2.putExtra("groupid", intent.getStringExtra("groupid"));
            } else if (stringExtra.equals("officialba_msg")) {
                intent2.putExtra("class", 22);
                intent2.putExtra("barid", intent.getStringExtra("barid"));
                intent2.putExtra("barname", intent.getStringExtra("barname"));
                intent2.putExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
            } else {
                return;
            }
            context.startService(intent2);
        }
    }
}
