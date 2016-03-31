package com.baidu.tieba.write.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewVcodeExceptionStatic {
    static {
        MessageManager.getInstance().registerListener(new u(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
