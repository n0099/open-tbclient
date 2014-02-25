package com.baidu.tieba.util;

import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class au implements aw {
    @Override // com.baidu.tieba.util.aw
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<av> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
