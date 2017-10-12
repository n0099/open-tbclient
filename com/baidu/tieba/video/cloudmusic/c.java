package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gur;
    private final d.b gus;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gur = cloudMusicModel;
        this.gus = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bvx() {
        this.gus.mY(true);
        this.gur.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void Y(CloudMusicData cloudMusicData) {
                c.this.gus.mY(false);
                if (cloudMusicData != null) {
                    c.this.gus.mZ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gus.mZ(true);
                        return;
                    } else {
                        c.this.gus.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gus.mZ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aiD() {
        this.gur.cancelLoadData();
    }
}
