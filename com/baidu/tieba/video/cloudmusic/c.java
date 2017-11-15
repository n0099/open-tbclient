package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gEd;
    private final d.b gEe;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gEd = cloudMusicModel;
        this.gEe = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void byE() {
        this.gEe.nb(true);
        this.gEd.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void ab(CloudMusicData cloudMusicData) {
                c.this.gEe.nb(false);
                if (cloudMusicData != null) {
                    c.this.gEe.nc(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gEe.nc(true);
                        return;
                    } else {
                        c.this.gEe.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gEe.nc(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void akY() {
        this.gEd.cancelLoadData();
    }
}
