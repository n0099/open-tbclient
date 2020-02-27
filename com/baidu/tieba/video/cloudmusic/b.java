package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel kvE;
    private final c.b kvF;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kvE = cloudMusicModel;
        this.kvF = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cPq() {
        this.kvF.tl(true);
        this.kvE.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aC(CloudMusicData cloudMusicData) {
                b.this.kvF.tl(false);
                if (cloudMusicData != null) {
                    b.this.kvF.tm(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kvF.tm(true);
                        return;
                    } else {
                        b.this.kvF.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kvF.tm(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bGt() {
        this.kvE.cancelLoadData();
    }
}
