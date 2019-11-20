package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes4.dex */
public class b implements a {
    private VideoEasterEggData jGM;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void ae(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.jGM = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.jGM == null) {
            return null;
        }
        return this.jGM.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void z(BdUniqueId bdUniqueId) {
        if (!aq.isEmpty(getPopImageUrl())) {
            c.fT().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
