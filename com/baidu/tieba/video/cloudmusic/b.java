package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jvF;
    private final c.b jvG;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jvF = cloudMusicModel;
        this.jvG = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cul() {
        this.jvG.rC(true);
        this.jvF.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void az(CloudMusicData cloudMusicData) {
                b.this.jvG.rC(false);
                if (cloudMusicData != null) {
                    b.this.jvG.rD(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.jvG.rD(true);
                        return;
                    } else {
                        b.this.jvG.a(cloudMusicData);
                        return;
                    }
                }
                b.this.jvG.rD(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void boF() {
        this.jvF.cancelLoadData();
    }
}
