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
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes5.dex */
public class InterestLabelStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(LabelSettingActivityConfig.class, LabelSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(LabelRecommendActivityConfig.class, LabelRecommendActivity.class);
        bJE();
        bJF();
    }

    private static void bJE() {
        a.a(309467, ResponseSocketGetLabelMessage.class, false, false);
        a.a(309467, CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, TbConfig.URL_GET_INTEREST_LABEL_LIST, ResponseHttpGetLabelMessage.class, false, false, true, false);
    }

    private static void bJF() {
        a.a(309468, ResponseSocketSubLabelMessage.class, false, false);
        a.a(309468, CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, TbConfig.URL_SUB_INTEREST_LABEL_LIST, ResponseHttpSubLabelMessage.class, false, false, true, false);
    }
}
