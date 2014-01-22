package com.baidu.tieba.util;

import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class as implements au {
    @Override // com.baidu.tieba.util.au
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tieba.util.au
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.au
    public LinkedList<at> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tieba.util.au
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.au
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
