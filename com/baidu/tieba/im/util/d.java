package com.baidu.tieba.im.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.model.RequestGroupLocModel;
/* loaded from: classes.dex */
public class d {
    private RequestGroupLocModel biH;
    private g biI;
    private double biF = 0.0d;
    private double biG = 0.0d;
    private BdUniqueId unique_id = null;
    private final com.baidu.adp.lib.d.d locationCallBack = new e(this);
    private final com.baidu.adp.framework.listener.e biJ = new f(this, 103010);

    public d(g gVar) {
        this.biH = null;
        this.biI = null;
        this.biH = new RequestGroupLocModel(null);
        this.biI = gVar;
        this.biJ.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.biJ);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.biH.setUniqueId(bdUniqueId);
    }

    public void Nj() {
        com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
    }

    public void RQ() {
        this.biH.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.biJ);
    }
}
