package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.c;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes23.dex */
public class b implements c.a {
    private final CloudMusicModel ngM;
    private final c.b ngN;

    public b(CloudMusicModel cloudMusicModel, c.b bVar) {
        this.ngM = cloudMusicModel;
        this.ngN = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void dMd() {
        this.ngN.xI(true);
        this.ngM.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void aR(CloudMusicData cloudMusicData) {
                b.this.ngN.xI(false);
                if (cloudMusicData != null) {
                    b.this.ngN.xJ(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        b.this.ngN.xJ(true);
                        return;
                    } else {
                        b.this.ngN.a(cloudMusicData);
                        return;
                    }
                }
                b.this.ngN.xJ(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.c.a
    public void cyM() {
        this.ngM.cancelLoadData();
    }
}
