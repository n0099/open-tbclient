package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes2.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nWC;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void M(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nWC = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nWC == null) {
            return null;
        }
        return this.nWC.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void G(BdUniqueId bdUniqueId) {
        if (!au.isEmpty(getPopImageUrl())) {
            d.mw().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
