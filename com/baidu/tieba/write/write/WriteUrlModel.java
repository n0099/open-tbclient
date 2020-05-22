package com.baidu.tieba.write.write;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes2.dex */
public class WriteUrlModel extends NewWriteModel {
    public WriteUrlModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void aq(Intent intent) {
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
        WriteData cZP = cZP();
        if (cZP != null) {
            cancelLoadData();
            cZP.setTitle(str);
            cZP.setIsNoTitle(StringUtils.isNull(str));
            cZP.setContent(str2);
            cZP.setLinkUrl(str3);
            cZP.setLinkUrlCode(str4);
            cZP.setIsLinkThread(true);
            cZP.setPostLatLng(true);
            cZP.setLat(str5);
            cZP.setLng(str6);
            deN();
        }
    }
}
