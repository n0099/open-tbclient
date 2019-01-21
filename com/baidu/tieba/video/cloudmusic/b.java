package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel hFa;
    private final c.b hFb;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hFa = cloudMusicModel;
        this.hFb = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bJA() {
        this.hFb.nY(true);
        this.hFa.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void al(CloudMusicData cloudMusicData) {
                b.this.hFb.nY(false);
                if (cloudMusicData != null) {
                    b.this.hFb.nZ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hFb.nZ(true);
                        return;
                    } else {
                        b.this.hFb.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hFb.nZ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aEp() {
        this.hFa.cancelLoadData();
    }
}
