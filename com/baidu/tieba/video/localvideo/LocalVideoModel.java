package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes2.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a hgH;
    private LocalVideoActivity hgS;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.hgS = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bBO() {
        b bVar = new b(this.hgS);
        bVar.b(this.hgH);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.hgH = aVar;
    }
}
