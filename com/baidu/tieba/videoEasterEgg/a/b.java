package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes9.dex */
public class b implements a {
    private VideoEasterEggData kEZ;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void Z(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.kEZ = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.kEZ == null) {
            return null;
        }
        return this.kEZ.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void A(BdUniqueId bdUniqueId) {
        if (!aq.isEmpty(getPopImageUrl())) {
            c.gr().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
