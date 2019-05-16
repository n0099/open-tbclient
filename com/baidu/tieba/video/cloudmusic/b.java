package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jom;
    private final c.b jon;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jom = cloudMusicModel;
        this.jon = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void crb() {
        this.jon.rn(true);
        this.jom.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void az(CloudMusicData cloudMusicData) {
                b.this.jon.rn(false);
                if (cloudMusicData != null) {
                    b.this.jon.ro(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.jon.ro(true);
                        return;
                    } else {
                        b.this.jon.a(cloudMusicData);
                        return;
                    }
                }
                b.this.jon.ro(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bmo() {
        this.jom.cancelLoadData();
    }
}
