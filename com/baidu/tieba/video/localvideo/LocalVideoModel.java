package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes22.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a mIG;
    private LocalVideoActivity mIR;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.mIR = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dGv() {
        b bVar = new b(this.mIR);
        bVar.b(this.mIG);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.mIG = aVar;
    }
}
