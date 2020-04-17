package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel lhL;
    private final c.b lhM;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.lhL = cloudMusicModel;
        this.lhM = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void daJ() {
        this.lhM.us(true);
        this.lhL.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aE(CloudMusicData cloudMusicData) {
                b.this.lhM.us(false);
                if (cloudMusicData != null) {
                    b.this.lhM.ut(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.lhM.ut(true);
                        return;
                    } else {
                        b.this.lhM.a(cloudMusicData);
                        return;
                    }
                }
                b.this.lhM.ut(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bRj() {
        this.lhL.cancelLoadData();
    }
}
