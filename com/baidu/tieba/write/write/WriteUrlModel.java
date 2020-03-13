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
        WriteData cHV = cHV();
        if (cHV != null) {
            cancelLoadData();
            cHV.setTitle(str);
            cHV.setIsNoTitle(StringUtils.isNull(str));
            cHV.setContent(str2);
            cHV.setLinkUrl(str3);
            cHV.setLinkUrlCode(str4);
            cHV.setIsLinkThread(true);
            cHV.setPostLatLng(true);
            cHV.setLat(str5);
            cHV.setLng(str6);
            cMk();
        }
    }
}
