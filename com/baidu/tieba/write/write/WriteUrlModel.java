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

    public void au(Intent intent) {
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
        WriteData cSo = cSo();
        if (cSo != null) {
            cancelLoadData();
            cSo.setTitle(str);
            cSo.setIsNoTitle(StringUtils.isNull(str));
            cSo.setContent(str2);
            cSo.setLinkUrl(str3);
            cSo.setLinkUrlCode(str4);
            cSo.setIsLinkThread(true);
            cSo.setPostLatLng(true);
            cSo.setLat(str5);
            cSo.setLng(str6);
            dFC();
        }
    }
}
