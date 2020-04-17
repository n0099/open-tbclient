package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes10.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a llH;
    private LocalVideoActivity llS;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.llS = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dbW() {
        b bVar = new b(this.llS);
        bVar.b(this.llH);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.llH = aVar;
    }
}
