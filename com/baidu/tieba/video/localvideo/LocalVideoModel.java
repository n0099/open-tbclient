package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes10.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a kzH;
    private LocalVideoActivity kzS;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.kzS = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cQF() {
        b bVar = new b(this.kzS);
        bVar.b(this.kzH);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.kzH = aVar;
    }
}
