package com.baidu.tieba.play.a;

import android.content.Context;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class b {
    public static a x(Context context, int i) {
        return i == 1 ? new TbCyberVideoView(context) : new QuickVideoView(context);
    }
}
