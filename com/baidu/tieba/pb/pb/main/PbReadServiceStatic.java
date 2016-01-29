package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ReadPbServiceConfig;
/* loaded from: classes.dex */
public class PbReadServiceStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(ReadPbServiceConfig.class, ReaderPbService.class);
    }
}
