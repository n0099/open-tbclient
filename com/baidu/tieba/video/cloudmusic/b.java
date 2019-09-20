package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jyb;
    private final c.b jyc;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jyb = cloudMusicModel;
        this.jyc = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cuZ() {
        this.jyc.rF(true);
        this.jyb.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void az(CloudMusicData cloudMusicData) {
                b.this.jyc.rF(false);
                if (cloudMusicData != null) {
                    b.this.jyc.rG(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.jyc.rG(true);
                        return;
                    } else {
                        b.this.jyc.a(cloudMusicData);
                        return;
                    }
                }
                b.this.jyc.rG(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bpq() {
        this.jyb.cancelLoadData();
    }
}
