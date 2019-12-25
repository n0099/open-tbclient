package com.baidu.tieba.write.write;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes10.dex */
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
        WriteData cFi = cFi();
        if (cFi != null) {
            cancelLoadData();
            cFi.setTitle(str);
            cFi.setIsNoTitle(StringUtils.isNull(str));
            cFi.setContent(str2);
            cFi.setLinkUrl(str3);
            cFi.setLinkUrlCode(str4);
            cFi.setIsLinkThread(true);
            cFi.setPostLatLng(true);
            cFi.setLat(str5);
            cFi.setLng(str6);
            cJG();
        }
    }
}
