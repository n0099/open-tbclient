package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import com.baidu.adp.base.g;
import com.baidu.adp.base.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
/* loaded from: classes.dex */
public class b {
    public static VoiceManager bw(Context context) {
        TbPageContext tbPageContext;
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((k.C(context) instanceof g) && (tbPageContext = (TbPageContext) k.C(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
