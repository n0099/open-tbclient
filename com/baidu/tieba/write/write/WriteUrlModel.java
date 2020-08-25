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

    public void ax(Intent intent) {
        if (intent != null) {
            WriteData writeData = new WriteData();
            writeData.setType(intent.getIntExtra("type", 0));
            writeData.setForumId(intent.getStringExtra("forum_id"));
            writeData.setForumName(intent.getStringExtra("forum_name"));
            writeData.setCallFrom(intent.getStringExtra("KEY_CALL_FROM"));
            d(writeData);
        }
    }

    public void g(String str, String str2, String str3, String str4, String str5, String str6) {
        WriteData cKZ = cKZ();
        if (cKZ != null) {
            cancelLoadData();
            cKZ.setTitle(str);
            cKZ.setIsNoTitle(StringUtils.isNull(str));
            cKZ.setContent(str2);
            cKZ.setLinkUrl(str3);
            cKZ.setLinkUrlCode(str4);
            cKZ.setIsLinkThread(true);
            cKZ.setPostLatLng(true);
            cKZ.setLat(str5);
            cKZ.setLng(str6);
            dxS();
        }
    }
}
