package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes22.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nqw;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void L(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nqw = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nqw == null) {
            return null;
        }
        return this.nqw.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(BdUniqueId bdUniqueId) {
        if (!at.isEmpty(getPopImageUrl())) {
            c.mS().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
