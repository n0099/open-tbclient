package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes7.dex */
public class b implements a {
    private VideoEasterEggData kEc;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void Z(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.kEc = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.kEc == null) {
            return null;
        }
        return this.kEc.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void A(BdUniqueId bdUniqueId) {
        if (!aq.isEmpty(getPopImageUrl())) {
            c.gr().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
