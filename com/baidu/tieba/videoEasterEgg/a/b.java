package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes22.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nLz;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void L(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nLz = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nLz == null) {
            return null;
        }
        return this.nLz.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(BdUniqueId bdUniqueId) {
        if (!au.isEmpty(getPopImageUrl())) {
            c.mS().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
