package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel htv;
    private final c.b htw;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.htv = cloudMusicModel;
        this.htw = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bFX() {
        this.htw.nS(true);
        this.htv.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ak(CloudMusicData cloudMusicData) {
                b.this.htw.nS(false);
                if (cloudMusicData != null) {
                    b.this.htw.nT(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.htw.nT(true);
                        return;
                    } else {
                        b.this.htw.a(cloudMusicData);
                        return;
                    }
                }
                b.this.htw.nT(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aBt() {
        this.htv.cancelLoadData();
    }
}
