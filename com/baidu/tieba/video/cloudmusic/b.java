package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel lVp;
    private final c.b lVq;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.lVp = cloudMusicModel;
        this.lVq = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dmv() {
        this.lVq.vg(true);
        this.lVp.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aJ(CloudMusicData cloudMusicData) {
                b.this.lVq.vg(false);
                if (cloudMusicData != null) {
                    b.this.lVq.vh(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.lVq.vh(true);
                        return;
                    } else {
                        b.this.lVq.a(cloudMusicData);
                        return;
                    }
                }
                b.this.lVq.vh(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void caR() {
        this.lVp.cancelLoadData();
    }
}
