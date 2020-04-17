package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
/* loaded from: classes.dex */
public class b {
    public static VoiceManager fo(Context context) {
        TbPageContext tbPageContext;
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.T(context) instanceof e) && (tbPageContext = (TbPageContext) i.T(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
