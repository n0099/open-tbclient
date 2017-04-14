package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
