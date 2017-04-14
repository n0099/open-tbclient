package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class c {
    public static void atU() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new d(0));
    }
}
