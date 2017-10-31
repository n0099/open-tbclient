package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gCV;
    private final d.b gCW;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gCV = cloudMusicModel;
        this.gCW = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bys() {
        this.gCW.mT(true);
        this.gCV.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ab(CloudMusicData cloudMusicData) {
                c.this.gCW.mT(false);
                if (cloudMusicData != null) {
                    c.this.gCW.mU(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gCW.mU(true);
                        return;
                    } else {
                        c.this.gCW.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gCW.mU(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void akK() {
        this.gCV.cancelLoadData();
    }
}
