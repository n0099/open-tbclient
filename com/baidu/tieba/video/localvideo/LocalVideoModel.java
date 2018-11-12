package com.baidu.tieba.video.localvideo;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.video.localvideo.b;
/* loaded from: classes5.dex */
public class LocalVideoModel extends BdBaseModel {
    private LocalVideoActivity hxH;
    private b.a hxw;

    public LocalVideoModel(LocalVideoActivity localVideoActivity) {
        super(localVideoActivity.getPageContext());
        this.hxH = localVideoActivity;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bHp() {
        b bVar = new b(this.hxH);
        bVar.b(this.hxw);
        bVar.execute(new Void[0]);
    }

    public void a(b.a aVar) {
        this.hxw = aVar;
    }
}
