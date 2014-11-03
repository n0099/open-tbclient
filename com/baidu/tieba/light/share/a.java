package com.baidu.tieba.light.share;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class a {
    public static Context mContext = TbadkApplication.m251getInst().getContext();
    private static com.baidu.adp.framework.listener.e blS = new b(205001);
    private static com.baidu.adp.framework.listener.e blT = new c(202001);

    public a() {
        MessageManager.getInstance().registerListener(blS);
        MessageManager.getInstance().registerListener(blT);
    }

    public static int A(ChatMessage chatMessage) {
        if (chatMessage.getContent() == null || chatMessage.getContent().length() == 0) {
            return -1;
        }
        return new com.baidu.tieba.im.widget.a().aw(chatMessage.getContent(), "game-share-parse");
    }

    public static void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }
}
