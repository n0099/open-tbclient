package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes23.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a mYn;
    private LocalVideoActivity mYy;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.mYy = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dKh() {
        b bVar = new b(this.mYy);
        bVar.b(this.mYn);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.mYn = aVar;
    }
}
