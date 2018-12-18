package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel hAH;
    private final c.b hAI;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hAH = cloudMusicModel;
        this.hAI = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bIb() {
        this.hAI.nU(true);
        this.hAH.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void al(CloudMusicData cloudMusicData) {
                b.this.hAI.nU(false);
                if (cloudMusicData != null) {
                    b.this.hAI.nV(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hAI.nV(true);
                        return;
                    } else {
                        b.this.hAI.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hAI.nV(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aDd() {
        this.hAH.cancelLoadData();
    }
}
