package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes8.dex */
public class b implements c.a {
    private final CloudMusicModel nLG;
    private final c.b nLH;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nLG = cloudMusicModel;
        this.nLH = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dSq() {
        this.nLH.yV(true);
        this.nLG.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aT(CloudMusicData cloudMusicData) {
                b.this.nLH.yV(false);
                if (cloudMusicData != null) {
                    b.this.nLH.yW(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nLH.yW(true);
                        return;
                    } else {
                        b.this.nLH.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nLH.yW(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cFE() {
        this.nLG.cancelLoadData();
    }
}
