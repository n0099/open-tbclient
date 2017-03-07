package com.baidu.tieba.tblauncher.alarmRemind;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import tbclient.GetClientConfig.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.clientConfig.b {
    final /* synthetic */ b fyM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fyM = bVar;
    }

    @Override // com.baidu.tbadk.clientConfig.b
    public void z(Object obj) {
        this.fyM.fyK = false;
        if (obj != null && (obj instanceof DataRes)) {
            DataRes dataRes = (DataRes) obj;
            if (dataRes.local_dialog != null) {
                String c = a.c(dataRes);
                if (!TextUtils.isEmpty(c)) {
                    TbadkSettings.getInst().saveString(this.fyM.qh("remind_recommend_info"), c);
                    TbadkSettings.getInst().saveInt(this.fyM.qh("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                    TbadkSettings.getInst().saveString(this.fyM.qh("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                    this.fyM.lp(true);
                    TbadkSettings.getInst().saveLong(this.fyM.qh("remind_recommend_data_time"), System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.clientConfig.b
    public void onError(String str) {
        this.fyM.fyK = false;
    }
}
