package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
                intent2.putExtra("url", intent.getStringExtra("url"));
                intent2.putExtra("from", stringExtra2);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "aladdin", null, 1, "st_type", stringExtra2, "st_param", intent.getStringExtra("url"));
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
                intent2.putExtra(InviteFriendListActivityConfig.GROUP_ID, intent.getStringExtra(InviteFriendListActivityConfig.GROUP_ID));
            } else if (stringExtra.equals("pay")) {
                intent2.putExtra("class", 15);
                intent2.putExtra("pay_type", intent.getStringExtra("pay_type"));
                intent2.putExtra("props_id", intent.getStringExtra("props_id"));
                intent2.putExtra("quan_num", intent.getStringExtra("quan_num"));
                intent2.putExtra("is_left", intent.getStringExtra("is_left"));
                intent2.putExtra("props_mon", intent.getStringExtra("props_mon"));
            } else if (stringExtra.equals("officialba_msg")) {
                intent2.putExtra("class", 22);
                intent2.putExtra("barid", intent.getStringExtra("barid"));
                intent2.putExtra("barname", intent.getStringExtra("barname"));
                intent2.putExtra(IntentConfig.PORTRAIT, intent.getStringExtra(IntentConfig.PORTRAIT));
            } else if (stringExtra.equals("recommendpb")) {
                intent2.putExtra("class", 28);
                intent2.putExtra(PbChosenActivityConfig.KEY_TID, intent.getStringExtra(PbChosenActivityConfig.KEY_TID));
            } else {
                return;
            }
            context.startService(intent2);
        }
    }
}
