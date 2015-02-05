package com.baidu.tieba.light.share;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ChatMessage chatMessage;
        if (socketResponsedMessage != null && (chatMessage = (ChatMessage) socketResponsedMessage.getOrginalMessage()) != null && GameShareListenerStatic.z(chatMessage) == 1) {
            if (socketResponsedMessage.getError() == 0) {
                GameShareListenerStatic.e(GameShareListenerStatic.mContext, com.baidu.adp.lib.g.b.ei().inflate(GameShareListenerStatic.mContext, x.tip_game_share, null));
                TiebaStatic.eventStat(GameShareListenerStatic.mContext, "game_share_tbg_ok", "click", 1, "dev_id", com.baidu.tbadk.game.b.vH().getGameInfoData().getGameId(), "share_type", 5);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ei().inflate(GameShareListenerStatic.mContext, x.tip_game_share, null);
            ((TextView) linearLayout.findViewById(w.tip_text)).setText("分享失败");
            ((ImageView) linearLayout.findViewById(w.tip_iamge)).setImageResource(v.icon_toast_game_error);
            GameShareListenerStatic.e(GameShareListenerStatic.mContext, linearLayout);
        }
    }
}
