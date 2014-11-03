package com.baidu.tieba.im.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.model.RequestGroupLocModel;
/* loaded from: classes.dex */
public class d {
    private RequestGroupLocModel biV;
    private g biW;
    private double biT = 0.0d;
    private double biU = 0.0d;
    private BdUniqueId unique_id = null;
    private final com.baidu.adp.lib.d.d locationCallBack = new e(this);
    private final com.baidu.adp.framework.listener.e biX = new f(this, 103010);

    public d(g gVar) {
        this.biV = null;
        this.biW = null;
        this.biV = new RequestGroupLocModel(null);
        this.biW = gVar;
        this.biX.setTag(this.unique_id);
        MessageManager.getInstance().registerListener(this.biX);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        this.biV.setUniqueId(bdUniqueId);
    }

    public void Nn() {
        com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
    }

    public void RT() {
        this.biV.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.biX);
    }
}
