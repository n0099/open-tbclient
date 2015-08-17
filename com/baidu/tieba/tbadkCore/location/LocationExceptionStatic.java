package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class LocationExceptionStatic {
    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
