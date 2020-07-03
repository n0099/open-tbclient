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

    public void au(Intent intent) {
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
        WriteData dev = dev();
        if (dev != null) {
            cancelLoadData();
            dev.setTitle(str);
            dev.setIsNoTitle(StringUtils.isNull(str));
            dev.setContent(str2);
            dev.setLinkUrl(str3);
            dev.setLinkUrlCode(str4);
            dev.setIsLinkThread(true);
            dev.setPostLatLng(true);
            dev.setLat(str5);
            dev.setLng(str6);
            djn();
        }
    }
}
