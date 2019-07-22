package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel juy;
    private final c.b juz;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.juy = cloudMusicModel;
        this.juz = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void ctP() {
        this.juz.rB(true);
        this.juy.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void az(CloudMusicData cloudMusicData) {
                b.this.juz.rB(false);
                if (cloudMusicData != null) {
                    b.this.juz.rC(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.juz.rC(true);
                        return;
                    } else {
                        b.this.juz.a(cloudMusicData);
                        return;
                    }
                }
                b.this.juz.rC(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bos() {
        this.juy.cancelLoadData();
    }
}
