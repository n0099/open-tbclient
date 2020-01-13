package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes7.dex */
public class b implements a {
    private VideoEasterEggData kDX;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void Z(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.kDX = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.kDX == null) {
            return null;
        }
        return this.kDX.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void A(BdUniqueId bdUniqueId) {
        if (!aq.isEmpty(getPopImageUrl())) {
            c.gr().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
