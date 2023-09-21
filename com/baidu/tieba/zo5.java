package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes9.dex */
public interface zo5 {
    void onFailure(int i, String str);

    void onSuccess(Map<Long, ? extends ArrayList<IMEmojiReplyListListener.IMEmojiItem>> map);
}
