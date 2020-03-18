package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel kxw;
    private final c.b kxx;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.kxw = cloudMusicModel;
        this.kxx = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cPN() {
        this.kxx.tr(true);
        this.kxw.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aC(CloudMusicData cloudMusicData) {
                b.this.kxx.tr(false);
                if (cloudMusicData != null) {
                    b.this.kxx.ts(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.kxx.ts(true);
                        return;
                    } else {
                        b.this.kxx.a(cloudMusicData);
                        return;
                    }
                }
                b.this.kxx.ts(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void bGI() {
        this.kxw.cancelLoadData();
    }
}
