package com.baidu.tieba.light.share;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class GameShareListenerStatic {
    public static Context mContext = TbadkApplication.getInst().getContext();
    private static final com.baidu.adp.framework.listener.e byl = new a(205001);
    private static final com.baidu.adp.framework.listener.e bym = new b(202001);

    static {
        MessageManager.getInstance().registerListener(byl);
        MessageManager.getInstance().registerListener(bym);
    }

    public GameShareListenerStatic() {
        MessageManager.getInstance().registerListener(byl);
        MessageManager.getInstance().registerListener(bym);
    }

    public static int A(ChatMessage chatMessage) {
        if (chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return -1;
        }
        return new com.baidu.tieba.im.widget.a().aJ(chatMessage.getContent(), "game-share-parse");
    }

    public static void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        toast.show();
    }
}
