package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes10.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity lZG;
    private b.a lZv;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.lZG = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dnN() {
        b bVar = new b(this.lZG);
        bVar.b(this.lZv);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.lZv = aVar;
    }
}
