package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes8.dex */
public class b implements c.a {
    private final CloudMusicModel kuC;
    private final c.b kuD;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kuC = cloudMusicModel;
        this.kuD = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cNT() {
        this.kuD.th(true);
        this.kuC.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aA(CloudMusicData cloudMusicData) {
                b.this.kuD.th(false);
                if (cloudMusicData != null) {
                    b.this.kuD.ti(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kuD.ti(true);
                        return;
                    } else {
                        b.this.kuD.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kuD.ti(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bER() {
        this.kuC.cancelLoadData();
    }
}
