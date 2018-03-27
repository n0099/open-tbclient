package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes2.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a hte;
    private LocalVideoActivity htp;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.htp = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bCr() {
        b bVar = new b(this.htp);
        bVar.b(this.hte);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.hte = aVar;
    }
}
