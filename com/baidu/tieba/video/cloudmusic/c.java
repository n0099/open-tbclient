package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel hoX;
    private final d.b hoY;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.hoX = cloudMusicModel;
        this.hoY = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bAY() {
        this.hoY.nn(true);
        this.hoX.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void bg(CloudMusicData cloudMusicData) {
                c.this.hoY.nn(false);
                if (cloudMusicData != null) {
                    c.this.hoY.no(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.hoY.no(true);
                        return;
                    } else {
                        c.this.hoY.a(cloudMusicData);
                        return;
                    }
                }
                c.this.hoY.no(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void awQ() {
        this.hoX.cancelLoadData();
    }
}
