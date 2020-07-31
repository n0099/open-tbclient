package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes17.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a mgM;
    private LocalVideoActivity mgX;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.mgX = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dqW() {
        b bVar = new b(this.mgX);
        bVar.b(this.mgM);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.mgM = aVar;
    }
}
