package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes10.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity lEG;
    private b.a lEv;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.lEG = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dji() {
        b bVar = new b(this.lEG);
        bVar.b(this.lEv);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.lEv = aVar;
    }
}
