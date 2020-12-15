package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes23.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a nFU;
    private LocalVideoActivity nGf;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.nGf = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dVl() {
        b bVar = new b(this.nGf);
        bVar.b(this.nFU);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.nFU = aVar;
    }
}
