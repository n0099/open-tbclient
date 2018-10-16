package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel hrL;
    private final c.b hrM;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hrL = cloudMusicModel;
        this.hrM = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bGy() {
        this.hrM.nE(true);
        this.hrL.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void al(CloudMusicData cloudMusicData) {
                b.this.hrM.nE(false);
                if (cloudMusicData != null) {
                    b.this.hrM.nF(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hrM.nF(true);
                        return;
                    } else {
                        b.this.hrM.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hrM.nF(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aBV() {
        this.hrL.cancelLoadData();
    }
}
