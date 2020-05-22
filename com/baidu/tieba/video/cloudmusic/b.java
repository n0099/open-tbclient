package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel lAA;
    private final c.b lAB;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.lAA = cloudMusicModel;
        this.lAB = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dhV() {
        this.lAB.uQ(true);
        this.lAA.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aI(CloudMusicData cloudMusicData) {
                b.this.lAB.uQ(false);
                if (cloudMusicData != null) {
                    b.this.lAB.uR(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.lAB.uR(true);
                        return;
                    } else {
                        b.this.lAB.a(cloudMusicData);
                        return;
                    }
                }
                b.this.lAB.uR(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bXE() {
        this.lAA.cancelLoadData();
    }
}
