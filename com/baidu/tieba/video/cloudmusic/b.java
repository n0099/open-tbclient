package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes23.dex */
public class b implements c.a {
    private final CloudMusicModel nBS;
    private final c.b nBT;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.nBS = cloudMusicModel;
        this.nBT = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dTW() {
        this.nBT.yD(true);
        this.nBS.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aS(CloudMusicData cloudMusicData) {
                b.this.nBT.yD(false);
                if (cloudMusicData != null) {
                    b.this.nBT.yE(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.nBT.yE(true);
                        return;
                    } else {
                        b.this.nBT.a(cloudMusicData);
                        return;
                    }
                }
                b.this.nBT.yE(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cFg() {
        this.nBS.cancelLoadData();
    }
}
