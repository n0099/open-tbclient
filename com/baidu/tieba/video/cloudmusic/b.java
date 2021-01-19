package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes7.dex */
public class b implements c.a {
    private final CloudMusicModel nBw;
    private final c.b nBx;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nBw = cloudMusicModel;
        this.nBx = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dPX() {
        this.nBx.yC(true);
        this.nBw.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aT(CloudMusicData cloudMusicData) {
                b.this.nBx.yC(false);
                if (cloudMusicData != null) {
                    b.this.nBx.yD(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nBx.yD(true);
                        return;
                    } else {
                        b.this.nBx.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nBx.yD(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cEk() {
        this.nBw.cancelLoadData();
    }
}
