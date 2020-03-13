package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel kvS;
    private final c.b kvT;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kvS = cloudMusicModel;
        this.kvT = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cPt() {
        this.kvT.tl(true);
        this.kvS.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aC(CloudMusicData cloudMusicData) {
                b.this.kvT.tl(false);
                if (cloudMusicData != null) {
                    b.this.kvT.tm(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kvT.tm(true);
                        return;
                    } else {
                        b.this.kvT.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kvT.tm(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bGw() {
        this.kvS.cancelLoadData();
    }
}
