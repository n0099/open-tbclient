package com.baidu.tieba.tbadkCore.voice;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    public static boolean bvy() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VOICE_RECORDER_AVAILABLE, Boolean.class) != null;
    }
}
