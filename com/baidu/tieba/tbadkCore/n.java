package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jeS = BdUniqueId.gen();
    public String text;
    public String url;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.text = actBtn.text;
            this.url = actBtn.url;
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jeS;
    }
}
