package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final d.b hoA;
    private final CloudMusicModel hoz;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.hoz = cloudMusicModel;
        this.hoA = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bAT() {
        this.hoA.ni(true);
        this.hoz.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void bg(CloudMusicData cloudMusicData) {
                c.this.hoA.ni(false);
                if (cloudMusicData != null) {
                    c.this.hoA.nj(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.hoA.nj(true);
                        return;
                    } else {
                        c.this.hoA.a(cloudMusicData);
                        return;
                    }
                }
                c.this.hoA.nj(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void awO() {
        this.hoz.cancelLoadData();
    }
}
