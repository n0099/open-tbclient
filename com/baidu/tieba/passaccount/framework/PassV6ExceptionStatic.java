package com.baidu.tieba.passaccount.framework;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PassV6ExceptionStatic {
    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
