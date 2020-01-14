package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes8.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity kyJ;
    private b.a kyy;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.kyJ = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void cPj() {
        b bVar = new b(this.kyJ);
        bVar.b(this.kyy);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.kyy = aVar;
    }
}
