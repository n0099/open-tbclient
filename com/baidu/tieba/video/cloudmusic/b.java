package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes17.dex */
public class b implements c.a {
    private final CloudMusicModel muv;
    private final c.b muw;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.muv = cloudMusicModel;
        this.muw = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dBg() {
        this.muw.wz(true);
        this.muv.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aL(CloudMusicData cloudMusicData) {
                b.this.muw.wz(false);
                if (cloudMusicData != null) {
                    b.this.muw.wA(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.muw.wA(true);
                        return;
                    } else {
                        b.this.muw.a(cloudMusicData);
                        return;
                    }
                }
                b.this.muw.wA(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void coU() {
        this.muv.cancelLoadData();
    }
}
