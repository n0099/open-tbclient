package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class LiveRoomChatForcast extends RelativeLayout {
    private Button bjl;
    private View bjm;
    private View bjn;

    public LiveRoomChatForcast(Context context) {
        super(context);
        init(context);
    }

    public LiveRoomChatForcast(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LiveRoomChatForcast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View a = com.baidu.adp.lib.g.b.ek().a(context, w.live_room_chat_forcast, this, true);
        this.bjl = (Button) a.findViewById(v.live_room_forcast_btn);
        this.bjm = a.findViewById(v.live_room_close_btn);
        this.bjn = a.findViewById(v.live_room_close_layout);
        com.baidu.adp.lib.util.m.a(context, this.bjm, 30, 30, 30, 30);
    }

    public Button getForcastBtn() {
        return this.bjl;
    }

    public View getLiveRoomCloseBtn() {
        return this.bjn;
    }
}
