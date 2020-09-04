package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes17.dex */
public class b implements c.a {
    private final CloudMusicModel muN;
    private final c.b muO;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.muN = cloudMusicModel;
        this.muO = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dBp() {
        this.muO.wB(true);
        this.muN.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aL(CloudMusicData cloudMusicData) {
                b.this.muO.wB(false);
                if (cloudMusicData != null) {
                    b.this.muO.wC(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.muO.wC(true);
                        return;
                    } else {
                        b.this.muO.a(cloudMusicData);
                        return;
                    }
                }
                b.this.muO.wC(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void coV() {
        this.muN.cancelLoadData();
    }
}
