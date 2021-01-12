package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes7.dex */
public class b implements c.a {
    private final CloudMusicModel nBv;
    private final c.b nBw;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nBv = cloudMusicModel;
        this.nBw = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dPX() {
        this.nBw.yC(true);
        this.nBv.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aT(CloudMusicData cloudMusicData) {
                b.this.nBw.yC(false);
                if (cloudMusicData != null) {
                    b.this.nBw.yD(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nBw.yD(true);
                        return;
                    } else {
                        b.this.nBw.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nBw.yD(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cEk() {
        this.nBv.cancelLoadData();
    }
}
