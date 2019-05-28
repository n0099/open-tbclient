package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c.a {
    private final CloudMusicModel jon;
    private final c.b joo;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.jon = cloudMusicModel;
        this.joo = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void crd() {
        this.joo.rn(true);
        this.jon.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void az(CloudMusicData cloudMusicData) {
                b.this.joo.rn(false);
                if (cloudMusicData != null) {
                    b.this.joo.ro(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.joo.ro(true);
                        return;
                    } else {
                        b.this.joo.a(cloudMusicData);
                        return;
                    }
                }
                b.this.joo.ro(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bmr() {
        this.jon.cancelLoadData();
    }
}
