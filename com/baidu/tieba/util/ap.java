package com.baidu.tieba.util;

import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class ap implements ar {
    @Override // com.baidu.tieba.util.ar
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tieba.util.ar
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.ar
    public LinkedList<aq> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tieba.util.ar
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.ar
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
