package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes9.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData mfg;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void I(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.mfg = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.mfg == null) {
            return null;
        }
        return this.mfg.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(BdUniqueId bdUniqueId) {
        if (!ar.isEmpty(getPopImageUrl())) {
            c.ln().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
