package com.baidu.yuyinala.privatemessage.model;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static IChatSessionChangeListener oFt = new IChatSessionChangeListener() { // from class: com.baidu.yuyinala.privatemessage.model.c.1
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            c.eik();
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            c.eik();
        }
    };
    private static IMediaChatMsgChangedListener oFu = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.model.c.2
        @Override // com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener
        public void onMediaChatMsgChangedResult(int i, long j, int i2, long j2, String str, long j3) {
            c.eik();
        }
    };

    public static void eij() {
        release();
        if (oFt != null) {
            BIMManager.registerChatSessionChangeListener(BdBaseApplication.getInst(), oFt);
        }
        if (oFu != null) {
            BIMManager.mediaRegisterChatMsgChangedListener(BdBaseApplication.getInst(), oFu);
        }
        eik();
    }

    public static void release() {
        BIMManager.unregisterChatSessionChangeListener(BdBaseApplication.getInst(), oFt);
        BIMManager.mediaUnRegisterChatMsgChangedListener(BdBaseApplication.getInst(), oFu);
    }

    public static void eik() {
        final int newMsgCount = BIMManager.getNewMsgCount(BdBaseApplication.getInst());
        BIMManager.mediaGetChatSessions(BdBaseApplication.getInst(), 0L, System.currentTimeMillis(), 20, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.model.c.3
            @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
            public void onMediaGetChatSessionResult(int i, int i2, boolean z, List<ChatSession> list) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501020, Integer.valueOf(newMsgCount + i2)));
            }
        });
    }
}
