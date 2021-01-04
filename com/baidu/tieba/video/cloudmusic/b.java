package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes8.dex */
public class b implements c.a {
    private final CloudMusicModel nGb;
    private final c.b nGc;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nGb = cloudMusicModel;
        this.nGc = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dTO() {
        this.nGc.yG(true);
        this.nGb.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aT(CloudMusicData cloudMusicData) {
                b.this.nGc.yG(false);
                if (cloudMusicData != null) {
                    b.this.nGc.yH(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nGc.yH(true);
                        return;
                    } else {
                        b.this.nGc.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nGc.yH(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cIb() {
        this.nGb.cancelLoadData();
    }
}
