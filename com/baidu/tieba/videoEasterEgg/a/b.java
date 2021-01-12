package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes2.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nKq;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void M(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nKq = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nKq == null) {
            return null;
        }
        return this.nKq.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void E(BdUniqueId bdUniqueId) {
        if (!at.isEmpty(getPopImageUrl())) {
            d.mx().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
