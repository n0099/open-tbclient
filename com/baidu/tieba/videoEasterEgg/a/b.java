package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes16.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData mmy;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void J(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.mmy = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.mmy == null) {
            return null;
        }
        return this.mmy.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void E(BdUniqueId bdUniqueId) {
        if (!as.isEmpty(getPopImageUrl())) {
            c.ln().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
