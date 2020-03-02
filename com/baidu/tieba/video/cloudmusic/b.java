package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel kvG;
    private final c.b kvH;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kvG = cloudMusicModel;
        this.kvH = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cPs() {
        this.kvH.tl(true);
        this.kvG.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aC(CloudMusicData cloudMusicData) {
                b.this.kvH.tl(false);
                if (cloudMusicData != null) {
                    b.this.kvH.tm(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kvH.tm(true);
                        return;
                    } else {
                        b.this.kvH.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kvH.tm(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bGv() {
        this.kvG.cancelLoadData();
    }
}
