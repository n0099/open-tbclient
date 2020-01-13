package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes8.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity kyE;
    private b.a kyt;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.kyE = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cPh() {
        b bVar = new b(this.kyE);
        bVar.b(this.kyt);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.kyt = aVar;
    }
}
