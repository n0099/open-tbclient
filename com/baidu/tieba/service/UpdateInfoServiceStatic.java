package com.baidu.tieba.service;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
/* loaded from: classes.dex */
public class UpdateInfoServiceStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
    }
}
