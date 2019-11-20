package com.baidu.tieba.write.write;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes3.dex */
public class WriteUrlModel extends NewWriteModel {
    public WriteUrlModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void aN(Intent intent) {
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
        WriteData cla = cla();
        if (cla != null) {
            cancelLoadData();
            cla.setTitle(str);
            cla.setIsNoTitle(StringUtils.isNull(str));
            cla.setContent(str2);
            cla.setLinkUrl(str3);
            cla.setLinkUrlCode(str4);
            cla.setIsLinkThread(true);
            cla.setPostLatLng(true);
            cla.setLat(str5);
            cla.setLng(str6);
            cpC();
        }
    }
}
