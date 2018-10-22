package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel hrM;
    private final c.b hrN;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hrM = cloudMusicModel;
        this.hrN = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bGy() {
        this.hrN.nE(true);
        this.hrM.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void al(CloudMusicData cloudMusicData) {
                b.this.hrN.nE(false);
                if (cloudMusicData != null) {
                    b.this.hrN.nF(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hrN.nF(true);
                        return;
                    } else {
                        b.this.hrN.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hrN.nF(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aBW() {
        this.hrM.cancelLoadData();
    }
}
