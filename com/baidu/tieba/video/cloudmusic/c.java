package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel hnd;
    private final d.b hne;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.hnd = cloudMusicModel;
        this.hne = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bAi() {
        this.hne.mY(true);
        this.hnd.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void be(CloudMusicData cloudMusicData) {
                c.this.hne.mY(false);
                if (cloudMusicData != null) {
                    c.this.hne.mZ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.hne.mZ(true);
                        return;
                    } else {
                        c.this.hne.a(cloudMusicData);
                        return;
                    }
                }
                c.this.hne.mZ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void avN() {
        this.hnd.cancelLoadData();
    }
}
