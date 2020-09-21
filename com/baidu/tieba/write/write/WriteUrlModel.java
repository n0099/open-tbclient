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

    public void aw(Intent intent) {
        if (intent != null) {
            WriteData writeData = new WriteData();
            writeData.setType(intent.getIntExtra("type", 0));
            writeData.setForumId(intent.getStringExtra("forum_id"));
            writeData.setForumName(intent.getStringExtra("forum_name"));
            writeData.setCallFrom(intent.getStringExtra("KEY_CALL_FROM"));
            e(writeData);
        }
    }

    public void g(String str, String str2, String str3, String str4, String str5, String str6) {
        WriteData cOG = cOG();
        if (cOG != null) {
            cancelLoadData();
            cOG.setTitle(str);
            cOG.setIsNoTitle(StringUtils.isNull(str));
            cOG.setContent(str2);
            cOG.setLinkUrl(str3);
            cOG.setLinkUrlCode(str4);
            cOG.setIsLinkThread(true);
            cOG.setPostLatLng(true);
            cOG.setLat(str5);
            cOG.setLng(str6);
            dBQ();
        }
    }
}
