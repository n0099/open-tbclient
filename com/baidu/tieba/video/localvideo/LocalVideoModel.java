package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes10.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity kzE;
    private b.a kzt;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.kzE = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cQC() {
        b bVar = new b(this.kzE);
        bVar.b(this.kzt);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.kzt = aVar;
    }
}
