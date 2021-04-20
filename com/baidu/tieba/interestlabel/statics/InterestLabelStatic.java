package com.baidu.tieba.interestlabel.statics;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.LabelSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import com.baidu.tieba.interestlabel.activity.LabelSettingActivity;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import d.b.i0.d3.d0.a;
/* loaded from: classes4.dex */
public class InterestLabelStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(LabelSettingActivityConfig.class, LabelSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(LabelRecommendActivityConfig.class, LabelRecommendActivity.class);
        a();
        b();
    }

    public static void a() {
        a.h(309467, ResponseSocketGetLabelMessage.class, false, false);
        a.c(309467, CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, TbConfig.URL_GET_INTEREST_LABEL_LIST, ResponseHttpGetLabelMessage.class, false, false, true, false);
    }

    public static void b() {
        a.h(309468, ResponseSocketSubLabelMessage.class, false, false);
        a.c(309468, CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, TbConfig.URL_SUB_INTEREST_LABEL_LIST, ResponseHttpSubLabelMessage.class, false, false, true, false);
    }
}
