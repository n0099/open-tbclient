package com.baidu.tieba.tblauncher.alarmRemind;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import tbclient.GetClientConfig.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.clientConfig.b {
    final /* synthetic */ b fAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fAv = bVar;
    }

    @Override // com.baidu.tbadk.clientConfig.b
    public void z(Object obj) {
        this.fAv.fAt = false;
        if (obj != null && (obj instanceof DataRes)) {
            DataRes dataRes = (DataRes) obj;
            if (dataRes.local_dialog != null) {
                String c = a.c(dataRes);
                if (!TextUtils.isEmpty(c)) {
                    TbadkSettings.getInst().saveString(this.fAv.qy("remind_recommend_info"), c);
                    TbadkSettings.getInst().saveInt(this.fAv.qy("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                    TbadkSettings.getInst().saveString(this.fAv.qy("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                    this.fAv.ls(true);
                    TbadkSettings.getInst().saveLong(this.fAv.qy("remind_recommend_data_time"), System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.clientConfig.b
    public void onError(String str) {
        this.fAv.fAt = false;
    }
}
