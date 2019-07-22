package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hIl = BdUniqueId.gen();
    public static final BdUniqueId hIm = BdUniqueId.gen();
    public long hIn;
    public String hIo;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hIp = "";
    public boolean hIq = false;

    public i(BdUniqueId bdUniqueId) {
        this.mType = hIm;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
