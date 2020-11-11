package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes23.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a nqK;
    private LocalVideoActivity nqV;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.nqV = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dPR() {
        b bVar = new b(this.nqV);
        bVar.b(this.nqK);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.nqK = aVar;
    }
}
