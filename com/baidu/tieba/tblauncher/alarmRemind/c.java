package com.baidu.tieba.tblauncher.alarmRemind;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import tbclient.GetClientConfig.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.clientConfig.c {
    final /* synthetic */ b fpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.fpe = bVar;
    }

    @Override // com.baidu.tbadk.clientConfig.c
    public void z(Object obj) {
        this.fpe.fpc = false;
        if (obj != null && (obj instanceof DataRes)) {
            DataRes dataRes = (DataRes) obj;
            if (dataRes.local_dialog != null) {
                String c = a.c(dataRes);
                if (!TextUtils.isEmpty(c)) {
                    TbadkSettings.getInst().saveString(this.fpe.qC("remind_recommend_info"), c);
                    TbadkSettings.getInst().saveInt(this.fpe.qC("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                    TbadkSettings.getInst().saveString(this.fpe.qC("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                    this.fpe.kF(true);
                    TbadkSettings.getInst().saveLong(this.fpe.qC("remind_recommend_data_time"), System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.clientConfig.c
    public void onError(String str) {
        this.fpe.fpc = false;
    }
}
