package com.baidu.tieba.setting.model.imageWatermarkType;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes10.dex */
public class SetImageWatermarkTypeReqMsg extends HttpMessage {
    private static final String SWITCH = "switch";

    public SetImageWatermarkTypeReqMsg(int i) {
        super(CmdConfigHttp.CMD_SET_IMAGE_WATERMARK_TYPE);
        addParam(SWITCH, i);
    }
}
