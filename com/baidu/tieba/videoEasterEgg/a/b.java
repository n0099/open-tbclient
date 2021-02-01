package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes2.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nTY;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void M(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nTY = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nTY == null) {
            return null;
        }
        return this.nTY.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void F(BdUniqueId bdUniqueId) {
        if (!au.isEmpty(getPopImageUrl())) {
            d.mw().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
