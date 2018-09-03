package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gMF = BdUniqueId.gen();
    public String text;
    public String url;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.text = actBtn.text;
            this.url = actBtn.url;
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gMF;
    }
}
