package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gNL;
    private final d.b gNM;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gNL = cloudMusicModel;
        this.gNM = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bAH() {
        this.gNM.nA(true);
        this.gNL.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ad(CloudMusicData cloudMusicData) {
                c.this.gNM.nA(false);
                if (cloudMusicData != null) {
                    c.this.gNM.nB(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gNM.nB(true);
                        return;
                    } else {
                        c.this.gNM.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gNM.nB(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void amU() {
        this.gNL.cancelLoadData();
    }
}
