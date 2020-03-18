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
        WriteData cIp = cIp();
        if (cIp != null) {
            cancelLoadData();
            cIp.setTitle(str);
            cIp.setIsNoTitle(StringUtils.isNull(str));
            cIp.setContent(str2);
            cIp.setLinkUrl(str3);
            cIp.setLinkUrlCode(str4);
            cIp.setIsLinkThread(true);
            cIp.setPostLatLng(true);
            cIp.setLat(str5);
            cIp.setLng(str6);
            cME();
        }
    }
}
