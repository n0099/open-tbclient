package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes16.dex */
public class b implements a {
    private VideoEasterEggData mEl;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void L(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.mEl = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.mEl == null) {
            return null;
        }
        return this.mEl.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void E(BdUniqueId bdUniqueId) {
        if (!at.isEmpty(getPopImageUrl())) {
            c.mM().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
