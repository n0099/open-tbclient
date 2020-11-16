package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes22.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a nrR;
    private LocalVideoActivity nsc;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.nsc = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dPQ() {
        b bVar = new b(this.nsc);
        bVar.b(this.nrR);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.nrR = aVar;
    }
}
