package com.baidu.yuyinala.privatemessage.implugin.b;

import android.content.Context;
import android.util.LongSparseArray;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d;
/* loaded from: classes10.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a pcD;
    private Context mContext;
    private LongSparseArray<ImageMsg> pcE = new LongSparseArray<>();

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a hu(Context context) {
        if (pcD == null) {
            synchronized (a.class) {
                if (pcD == null) {
                    pcD = new a(context);
                }
            }
        }
        return pcD;
    }

    public void a(ChatMsg chatMsg, String str) {
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().saveMessage(this.mContext, chatMsg);
        switch (chatMsg.getMsgType()) {
            case 0:
                b(chatMsg, str);
                return;
            case 8:
                c(chatMsg, str);
                return;
            default:
                f(chatMsg);
                return;
        }
    }

    private void b(ChatMsg chatMsg, String str) {
        if (chatMsg instanceof TextMsg) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(this.mContext, chatMsg, new C0973a(str));
        } else {
            LogUtils.e(TAG, "sendTextChatMsg msg error");
        }
    }

    private void c(ChatMsg chatMsg, String str) {
        if (chatMsg instanceof SignleGraphicTextMsg) {
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(this.mContext, chatMsg, new C0973a(str));
        } else {
            LogUtils.e(TAG, "sendTextChatMsg msg error");
        }
    }

    private void f(ChatMsg chatMsg) {
        LogUtils.e(TAG, "sendUnknownChatMsg " + chatMsg);
    }

    public void a(ImageMsg imageMsg) {
        if (this.pcE != null) {
            if (this.pcE.get(imageMsg.getRowId()) != null) {
                imageMsg.setProgress(this.pcE.get(imageMsg.getRowId()).getProgress());
            } else {
                imageMsg.setStatus(2);
            }
        }
    }

    public void a(int i, ChatMsg chatMsg, String str) {
        c YG = d.elv().YG(str);
        if (YG != null) {
            YG.onSendMessageResult(i, chatMsg);
        }
        if (chatMsg.getMsgType() == 1) {
            this.pcE.remove(chatMsg.getRowId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0973a implements b.f {
        private String mListenerKey;

        private C0973a(String str) {
            this.mListenerKey = str;
        }

        @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
        public void onSendMessageResult(int i, ChatMsg chatMsg) {
            a.hu(a.this.mContext).a(i, chatMsg, this.mListenerKey);
        }
    }
}
