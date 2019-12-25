package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes7.dex */
public class b implements c.a {
    private final CloudMusicModel kqZ;
    private final c.b kra;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kqZ = cloudMusicModel;
        this.kra = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cMO() {
        this.kra.sV(true);
        this.kqZ.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aA(CloudMusicData cloudMusicData) {
                b.this.kra.sV(false);
                if (cloudMusicData != null) {
                    b.this.kra.sW(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kra.sW(true);
                        return;
                    } else {
                        b.this.kra.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kra.sW(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bDP() {
        this.kqZ.cancelLoadData();
    }
}
