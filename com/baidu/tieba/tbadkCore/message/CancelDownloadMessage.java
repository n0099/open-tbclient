package com.baidu.tieba.tbadkCore.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class CancelDownloadMessage extends CustomResponsedMessage<Boolean> {
    public CancelDownloadMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_CANCEL_FILE_DOWNLOAD, bool);
    }
}
