package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class e implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lBe = BdUniqueId.gen();
    private BdUniqueId mTag;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lBe;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }
}
