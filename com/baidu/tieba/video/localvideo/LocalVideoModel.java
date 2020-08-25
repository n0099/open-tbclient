package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes17.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity myJ;
    private b.a myy;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.myJ = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dCs() {
        b bVar = new b(this.myJ);
        bVar.b(this.myy);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.myy = aVar;
    }
}
