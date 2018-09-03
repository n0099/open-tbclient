package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel hcD;
    private final c.b hcE;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hcD = cloudMusicModel;
        this.hcE = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bAv() {
        this.hcE.mQ(true);
        this.hcD.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ag(CloudMusicData cloudMusicData) {
                b.this.hcE.mQ(false);
                if (cloudMusicData != null) {
                    b.this.hcE.mR(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hcE.mR(true);
                        return;
                    } else {
                        b.this.hcE.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hcE.mR(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void awr() {
        this.hcD.cancelLoadData();
    }
}
