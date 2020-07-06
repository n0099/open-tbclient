package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes10.dex */
public class b implements c.a {
    private final CloudMusicModel lVs;
    private final c.b lVt;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.lVs = cloudMusicModel;
        this.lVt = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dmz() {
        this.lVt.vg(true);
        this.lVs.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aJ(CloudMusicData cloudMusicData) {
                b.this.lVt.vg(false);
                if (cloudMusicData != null) {
                    b.this.lVt.vh(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.lVt.vh(true);
                        return;
                    } else {
                        b.this.lVt.a(cloudMusicData);
                        return;
                    }
                }
                b.this.lVt.vh(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void caS() {
        this.lVs.cancelLoadData();
    }
}
