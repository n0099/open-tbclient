package com.baidu.tieba.interestlabel.statics;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.LabelSettingActivityConfig;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import com.baidu.tieba.interestlabel.activity.LabelSettingActivity;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes10.dex */
public class InterestLabelStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(LabelSettingActivityConfig.class, LabelSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(LabelRecommendActivityConfig.class, LabelRecommendActivity.class);
        cbb();
        cbc();
    }

    private static void cbb() {
        a.a(CmdConfigSocket.CMD_GET_INTEREST_LABEL_LIST, ResponseSocketGetLabelMessage.class, false, false);
        a.a(CmdConfigSocket.CMD_GET_INTEREST_LABEL_LIST, 1003333, TbConfig.URL_GET_INTEREST_LABEL_LIST, ResponseHttpGetLabelMessage.class, false, false, true, false);
    }

    private static void cbc() {
        a.a(CmdConfigSocket.CMD_SUB_INTEREST_LABEL_LIST, ResponseSocketSubLabelMessage.class, false, false);
        a.a(CmdConfigSocket.CMD_SUB_INTEREST_LABEL_LIST, 1003334, TbConfig.URL_SUB_INTEREST_LABEL_LIST, ResponseHttpSubLabelMessage.class, false, false, true, false);
    }
}
