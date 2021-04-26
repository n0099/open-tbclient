package com.baidu.tieba.tbadkCore.tiebaStatMsg;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Static {

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null || TextUtils.isEmpty(p.getCmd())) {
                return;
            }
            String content = p.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                BdUploadStatMsgData bdUploadStatMsgData = new BdUploadStatMsgData();
                bdUploadStatMsgData.parentType = jSONObject.optString("type");
                bdUploadStatMsgData.childType = jSONObject.optString("sub_type");
                boolean z = true;
                if (jSONObject.optInt("is_wifi") != 1) {
                    z = false;
                }
                bdUploadStatMsgData.isWifi = z;
                if (jSONObject.optLong("continue_time") > 0) {
                    bdUploadStatMsgData.deadLineTime = System.currentTimeMillis() + (jSONObject.optLong("continue_time") * 1000);
                }
                BdStatisticsManager.getInstance().addEntryToTmpSwitchConfDic(bdUploadStatMsgData.parentType, bdUploadStatMsgData.childType, bdUploadStatMsgData);
            } catch (Exception unused) {
            }
        }
    }

    static {
        a aVar = new a(0);
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(2001320, aVar);
        }
    }
}
