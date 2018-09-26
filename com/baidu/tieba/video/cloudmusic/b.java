package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class b implements c.a {
    private final CloudMusicModel hkv;
    private final c.b hkw;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.hkv = cloudMusicModel;
        this.hkw = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bDk() {
        this.hkw.nn(true);
        this.hkv.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aj(CloudMusicData cloudMusicData) {
                b.this.hkw.nn(false);
                if (cloudMusicData != null) {
                    b.this.hkw.no(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.hkw.no(true);
                        return;
                    } else {
                        b.this.hkw.a(cloudMusicData);
                        return;
                    }
                }
                b.this.hkw.no(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void ayC() {
        this.hkv.cancelLoadData();
    }
}
