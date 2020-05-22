package com.baidu.tieba.sdk.e;

import android.app.Activity;
import android.content.Intent;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.tieba.sdk.b.e;
/* loaded from: classes3.dex */
public class b implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        if (customMessage.getData() instanceof AlaLiveRoomActivityConfig) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
            Intent intent = new Intent();
            intent.putExtra("live_id", alaLiveRoomActivityConfig.getIntent().getLongExtra("live_id", 0L));
            intent.putExtra("user_name", alaLiveRoomActivityConfig.getIntent().getStringExtra("user_name"));
            intent.putExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE, alaLiveRoomActivityConfig.getIntent().getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE));
            intent.putExtra("room_id", alaLiveRoomActivityConfig.getIntent().getStringExtra("room_id"));
            intent.putExtra("params", alaLiveRoomActivityConfig.getIntent().getStringExtra("params"));
            if (!(alaLiveRoomActivityConfig.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            e cWn = com.baidu.tieba.sdk.d.a.cWj().cWn();
            if (cWn != null) {
                cWn.f(alaLiveRoomActivityConfig.getContext(), intent);
                return null;
            }
            return null;
        }
        return null;
    }
}
