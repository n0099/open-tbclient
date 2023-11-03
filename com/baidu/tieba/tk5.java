package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import java.util.List;
/* loaded from: classes8.dex */
public interface tk5 {
    void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> list);

    void onFailure(int i, String str);
}
