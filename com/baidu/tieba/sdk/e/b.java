package com.baidu.tieba.sdk.e;

import android.app.Activity;
import android.content.Intent;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        if (customMessage.getData() instanceof AlaLiveRoomActivityConfig) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
            Intent intent = new Intent();
            intent.putExtra("live_id", alaLiveRoomActivityConfig.getIntent().getLongExtra("live_id", 0L));
            intent.putExtra("user_name", alaLiveRoomActivityConfig.getIntent().getStringExtra("user_name"));
            intent.putExtra("live_broadcast_gift_toast_queue", alaLiveRoomActivityConfig.getIntent().getStringExtra("live_broadcast_gift_toast_queue"));
            intent.putExtra("last_live_info", alaLiveRoomActivityConfig.getIntent().getStringExtra("last_live_info"));
            intent.putExtra("room_id", alaLiveRoomActivityConfig.getIntent().getStringExtra("room_id"));
            intent.putExtra("params", alaLiveRoomActivityConfig.getIntent().getStringExtra("params"));
            if (!(alaLiveRoomActivityConfig.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.baidu.tieba.sdk.b.d dwQ = com.baidu.tieba.sdk.d.a.dwM().dwQ();
            if (dwQ != null) {
                dwQ.g(alaLiveRoomActivityConfig.getContext(), intent);
                return null;
            }
            return null;
        }
        return null;
    }
}
