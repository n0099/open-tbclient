package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes17.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a myQ;
    private LocalVideoActivity mzb;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.mzb = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dCB() {
        b bVar = new b(this.mzb);
        bVar.b(this.myQ);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.myQ = aVar;
    }
}
