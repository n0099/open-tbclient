package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel hEZ;
    private final c.b hFa;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hEZ = cloudMusicModel;
        this.hFa = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bJA() {
        this.hFa.nY(true);
        this.hEZ.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void al(CloudMusicData cloudMusicData) {
                b.this.hFa.nY(false);
                if (cloudMusicData != null) {
                    b.this.hFa.nZ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hFa.nZ(true);
                        return;
                    } else {
                        b.this.hFa.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hFa.nZ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void aEp() {
        this.hEZ.cancelLoadData();
    }
}
