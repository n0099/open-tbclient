package com.baidu.tieba.sdk.e;

import android.app.Activity;
import android.content.Intent;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
/* loaded from: classes11.dex */
public class c implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        if (customMessage.getData() instanceof YuyinAlaLiveRoomActivityConfig) {
            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = (YuyinAlaLiveRoomActivityConfig) customMessage.getData();
            Intent intent = new Intent();
            intent.putExtra("live_id", yuyinAlaLiveRoomActivityConfig.getIntent().getLongExtra("live_id", 0L));
            intent.putExtra("user_name", yuyinAlaLiveRoomActivityConfig.getIntent().getStringExtra("user_name"));
            intent.putExtra("live_broadcast_gift_toast_queue", yuyinAlaLiveRoomActivityConfig.getIntent().getStringExtra("live_broadcast_gift_toast_queue"));
            intent.putExtra("last_live_info", yuyinAlaLiveRoomActivityConfig.getIntent().getStringExtra("last_live_info"));
            intent.putExtra("room_id", yuyinAlaLiveRoomActivityConfig.getIntent().getStringExtra("room_id"));
            intent.putExtra("params", yuyinAlaLiveRoomActivityConfig.getIntent().getStringExtra("params"));
            if (!(yuyinAlaLiveRoomActivityConfig.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.baidu.tieba.sdk.b.d dHi = com.baidu.tieba.sdk.d.a.dHc().dHi();
            if (dHi != null) {
                dHi.h(yuyinAlaLiveRoomActivityConfig.getContext(), intent);
                return null;
            }
            return null;
        }
        return null;
    }
}
