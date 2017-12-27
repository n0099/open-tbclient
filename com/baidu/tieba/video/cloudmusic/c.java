package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel hxA;
    private final d.b hxB;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.hxA = cloudMusicModel;
        this.hxB = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bGL() {
        this.hxB.nW(true);
        this.hxA.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void bh(CloudMusicData cloudMusicData) {
                c.this.hxB.nW(false);
                if (cloudMusicData != null) {
                    c.this.hxB.nX(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.hxB.nX(true);
                        return;
                    } else {
                        c.this.hxB.a(cloudMusicData);
                        return;
                    }
                }
                c.this.hxB.nX(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void auK() {
        this.hxA.cancelLoadData();
    }
}
