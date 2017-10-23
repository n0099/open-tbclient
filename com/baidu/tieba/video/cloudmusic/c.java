package com.baidu.tieba.video.cloudmusic;

import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes2.dex */
public class c implements d.a {
    private final CloudMusicModel gud;
    private final d.b gue;

    public c(CloudMusicModel cloudMusicModel, d.b bVar) {
        this.gud = cloudMusicModel;
        this.gue = bVar;
        bVar.a(this);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void bvp() {
        this.gue.mX(true);
        this.gud.a(new com.baidu.tieba.video.cloudmusic.model.a<CloudMusicData>() { // from class: com.baidu.tieba.video.cloudmusic.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.video.cloudmusic.model.a
            /* renamed from: b */
            public void Y(CloudMusicData cloudMusicData) {
                c.this.gue.mX(false);
                if (cloudMusicData != null) {
                    c.this.gue.mY(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        c.this.gue.mY(true);
                        return;
                    } else {
                        c.this.gue.a(cloudMusicData);
                        return;
                    }
                }
                c.this.gue.mY(true);
            }
        });
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.a
    public void aiy() {
        this.gud.cancelLoadData();
    }
}
