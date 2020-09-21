package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes21.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData mOo;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void L(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.mOo = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.mOo == null) {
            return null;
        }
        return this.mOo.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(BdUniqueId bdUniqueId) {
        if (!at.isEmpty(getPopImageUrl())) {
            c.mR().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
