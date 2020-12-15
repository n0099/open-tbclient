package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes23.dex */
public class b implements c.a {
    private final CloudMusicModel nBU;
    private final c.b nBV;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nBU = cloudMusicModel;
        this.nBV = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dTX() {
        this.nBV.yD(true);
        this.nBU.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aS(CloudMusicData cloudMusicData) {
                b.this.nBV.yD(false);
                if (cloudMusicData != null) {
                    b.this.nBV.yE(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nBV.yE(true);
                        return;
                    } else {
                        b.this.nBV.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nBV.yE(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cFh() {
        this.nBU.cancelLoadData();
    }
}
