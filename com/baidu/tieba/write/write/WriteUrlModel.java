package com.baidu.tieba.write.write;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes.dex */
public class WriteUrlModel extends NewWriteModel {
    public WriteUrlModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void aj(Intent intent) {
        if (intent != null) {
            WriteData writeData = new WriteData();
            writeData.setType(intent.getIntExtra("type", 0));
            writeData.setForumId(intent.getStringExtra("forum_id"));
            writeData.setForumName(intent.getStringExtra("forum_name"));
            writeData.setCallFrom(intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM));
            setWriteData(writeData);
        }
    }

    public void n(String str, String str2, String str3, String str4) {
        WriteData writeData = getWriteData();
        if (writeData != null) {
            cancelLoadData();
            writeData.setTitle(str);
            writeData.setIsNoTitle(StringUtils.isNull(str));
            writeData.setContent(str2);
            writeData.setLinkUrl(str3);
            writeData.setLinkUrlCode(str4);
            writeData.setIsLinkThread(true);
            startPostWrite();
        }
    }
}
