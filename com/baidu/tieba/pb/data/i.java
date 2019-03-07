package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class i implements m {
    public static final BdUniqueId hkM = BdUniqueId.gen();
    public bg bTk;
    private boolean hkN = false;
    private boolean hkO = false;
    private int hkP = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hkM;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hkN = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int aan() {
        if (this.bTk != null) {
            return this.bTk.aan();
        }
        return 0;
    }

    public boolean bIA() {
        return this.bTk != null && this.bTk.aam() == 1;
    }

    public void na(boolean z) {
        this.hkO = z;
    }

    public boolean bIB() {
        return this.hkO;
    }
}
