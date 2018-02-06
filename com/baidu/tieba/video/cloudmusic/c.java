package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel hoM;
    private final d.b hoN;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.hoM = cloudMusicModel;
        this.hoN = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bAU() {
        this.hoN.ni(true);
        this.hoM.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void bg(CloudMusicData cloudMusicData) {
                c.this.hoN.ni(false);
                if (cloudMusicData != null) {
                    c.this.hoN.nj(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.hoN.nj(true);
                        return;
                    } else {
                        c.this.hoN.a(cloudMusicData);
                        return;
                    }
                }
                c.this.hoN.nj(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void awP() {
        this.hoM.cancelLoadData();
    }
}
