package com.baidu.tieba.tbadkCore.tiebaStatMsg;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Static {
    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.tbadkCore.tiebaStatMsg.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                GroupNewsPojo p;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && !TextUtils.isEmpty(p.getCmd())) {
                    String content = p.getContent();
                    if (!TextUtils.isEmpty(content)) {
                        try {
                            JSONObject jSONObject = new JSONObject(content);
                            BdUploadStatMsgData bdUploadStatMsgData = new BdUploadStatMsgData();
                            bdUploadStatMsgData.parentType = jSONObject.optString("type");
                            bdUploadStatMsgData.childType = jSONObject.optString(FuFaceItem.JK_SUB_TYPE);
                            bdUploadStatMsgData.isWifi = jSONObject.optInt("is_wifi") == 1;
                            if (jSONObject.optLong("continue_time") > 0) {
                                bdUploadStatMsgData.deadLineTime = (jSONObject.optLong("continue_time") * 1000) + System.currentTimeMillis();
                            }
                            BdStatisticsManager.getInstance().addEntryToTmpSwitchConfDic(bdUploadStatMsgData.parentType, bdUploadStatMsgData.childType, bdUploadStatMsgData);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_STAT, customMessageListener);
        }
    }
}
