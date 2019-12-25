package com.baidu.tieba.tbadkCore.voice;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    public static boolean cJF() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VOICE_RECORDER_AVAILABLE, Boolean.class) != null;
    }
}
