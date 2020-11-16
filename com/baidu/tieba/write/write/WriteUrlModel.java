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

    public void h(String str, String str2, String str3, String str4, String str5, String str6) {
        WriteData cXs = cXs();
        if (cXs != null) {
            cancelLoadData();
            cXs.setTitle(str);
            cXs.setIsNoTitle(StringUtils.isNull(str));
            cXs.setContent(str2);
            cXs.setLinkUrl(str3);
            cXs.setLinkUrlCode(str4);
            cXs.setIsLinkThread(true);
            cXs.setPostLatLng(true);
            cXs.setLat(str5);
            cXs.setLng(str6);
            dLl();
        }
    }
}
