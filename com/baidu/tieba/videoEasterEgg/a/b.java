package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes22.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nwr;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void L(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nwr = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nwr == null) {
            return null;
        }
        return this.nwr.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(BdUniqueId bdUniqueId) {
        if (!at.isEmpty(getPopImageUrl())) {
            c.mS().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
