package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes7.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a kuQ;
    private LocalVideoActivity kvb;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.kvb = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cOe() {
        b bVar = new b(this.kvb);
        bVar.b(this.kuQ);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.kuQ = aVar;
    }
}
