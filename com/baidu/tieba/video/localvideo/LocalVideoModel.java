package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes2.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a gHm;
    private LocalVideoActivity gHv;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.gHv = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bzE() {
        b bVar = new b(this.gHv);
        bVar.b(this.gHm);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.gHm = aVar;
    }
}
