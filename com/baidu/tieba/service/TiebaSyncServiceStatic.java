package com.baidu.tieba.service;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
/* loaded from: classes.dex */
public class TiebaSyncServiceStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
    }
}
