package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel hDS;
    private final c.b hDT;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hDS = cloudMusicModel;
        this.hDT = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bIR() {
        this.hDT.nX(true);
        this.hDS.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void al(CloudMusicData cloudMusicData) {
                b.this.hDT.nX(false);
                if (cloudMusicData != null) {
                    b.this.hDT.nY(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hDT.nY(true);
                        return;
                    } else {
                        b.this.hDT.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hDT.nY(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aDS() {
        this.hDS.cancelLoadData();
    }
}
