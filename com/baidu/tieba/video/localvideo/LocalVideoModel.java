package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes5.dex */
public class LocalVideoModel extends BdBaseModel {
    private b.a hHT;
    private LocalVideoActivity hIe;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.hIe = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bKj() {
        b bVar = new b(this.hIe);
        bVar.b(this.hHT);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.hHT = aVar;
    }
}
