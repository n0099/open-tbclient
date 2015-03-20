package com.baidu.tieba.service;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
/* loaded from: classes.dex */
public class TiebaSyncServiceStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
    }
}
