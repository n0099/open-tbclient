package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jor;
    private final c.b jos;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jor = cloudMusicModel;
        this.jos = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cre() {
        this.jos.ro(true);
        this.jor.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void az(CloudMusicData cloudMusicData) {
                b.this.jos.ro(false);
                if (cloudMusicData != null) {
                    b.this.jos.rp(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.jos.rp(true);
                        return;
                    } else {
                        b.this.jos.a(cloudMusicData);
                        return;
                    }
                }
                b.this.jos.rp(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bmr() {
        this.jor.cancelLoadData();
    }
}
