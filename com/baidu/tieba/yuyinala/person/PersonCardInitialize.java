package com.baidu.tieba.yuyinala.person;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
/* loaded from: classes4.dex */
public class PersonCardInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaPersonCardActivityConfig.class, PersonCardActivity.class);
    }
}
