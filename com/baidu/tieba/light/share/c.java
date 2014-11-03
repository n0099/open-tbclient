package com.baidu.tieba.light.share;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ChatMessage chatMessage;
        if (socketResponsedMessage != null && (chatMessage = (ChatMessage) socketResponsedMessage.getOrginalMessage()) != null && a.A(chatMessage) == 1) {
            if (socketResponsedMessage.getError() == 0) {
                a.e(a.mContext, com.baidu.adp.lib.g.b.ek().inflate(a.mContext, w.tip_game_share, null));
                TiebaStatic.eventStat(a.mContext, "game_share_tbg_ok", "click", 1, "dev_id", com.baidu.tbadk.game.b.rU().getGameInfoData().getGameId(), "share_type", 5);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(a.mContext, w.tip_game_share, null);
            ((TextView) linearLayout.findViewById(v.tip_text)).setText("分享失败");
            ((ImageView) linearLayout.findViewById(v.tip_iamge)).setImageResource(u.icon_toast_game_error);
            a.e(a.mContext, linearLayout);
        }
    }
}
