package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.ActBtn;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mWw = BdUniqueId.gen();
    public String text;
    public String url;

    public void a(ActBtn actBtn) {
        if (actBtn != null) {
            this.text = actBtn.text;
            this.url = actBtn.url;
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mWw;
    }
}
