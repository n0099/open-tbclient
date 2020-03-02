package com.baidu.tieba.write.write;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes13.dex */
public class WriteUrlModel extends NewWriteModel {
    public WriteUrlModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void aG(Intent intent) {
        if (intent != null) {
            WriteData writeData = new WriteData();
            writeData.setType(intent.getIntExtra("type", 0));
            writeData.setForumId(intent.getStringExtra("forum_id"));
            writeData.setForumName(intent.getStringExtra("forum_name"));
            writeData.setCallFrom(intent.getStringExtra("KEY_CALL_FROM"));
            d(writeData);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        WriteData cHU = cHU();
        if (cHU != null) {
            cancelLoadData();
            cHU.setTitle(str);
            cHU.setIsNoTitle(StringUtils.isNull(str));
            cHU.setContent(str2);
            cHU.setLinkUrl(str3);
            cHU.setLinkUrlCode(str4);
            cHU.setIsLinkThread(true);
            cHU.setPostLatLng(true);
            cHU.setLat(str5);
            cHU.setLng(str6);
            cMj();
        }
    }
}
