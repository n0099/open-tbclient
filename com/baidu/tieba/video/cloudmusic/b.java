package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel iVA;
    private final c.b iVB;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.iVA = cloudMusicModel;
        this.iVB = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cja() {
        this.iVB.qy(true);
        this.iVA.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aB(CloudMusicData cloudMusicData) {
                b.this.iVB.qy(false);
                if (cloudMusicData != null) {
                    b.this.iVB.qz(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.iVB.qz(true);
                        return;
                    } else {
                        b.this.iVB.a(cloudMusicData);
                        return;
                    }
                }
                b.this.iVB.qz(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void beY() {
        this.iVA.cancelLoadData();
    }
}
