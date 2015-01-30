package com.baidu.tieba.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m255getInst().saveSettingData();
    }
}
