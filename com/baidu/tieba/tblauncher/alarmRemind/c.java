package com.baidu.tieba.tblauncher.alarmRemind;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import tbclient.GetClientConfig.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.clientConfig.c {
    final /* synthetic */ b ebj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ebj = bVar;
    }

    @Override // com.baidu.tbadk.clientConfig.c
    public void w(Object obj) {
        this.ebj.aXB = false;
        if (obj != null && (obj instanceof DataRes)) {
            DataRes dataRes = (DataRes) obj;
            if (dataRes.local_dialog != null) {
                String c = a.c(dataRes);
                if (!TextUtils.isEmpty(c)) {
                    TbadkSettings.getInst().saveString(this.ebj.na("remind_recommend_info"), c);
                    TbadkSettings.getInst().saveInt(this.ebj.na("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                    TbadkSettings.getInst().saveString(this.ebj.na("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                    this.ebj.ih(true);
                    TbadkSettings.getInst().saveLong(this.ebj.na("remind_recommend_data_time"), System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.clientConfig.c
    public void onError(String str) {
        this.ebj.aXB = false;
    }
}
