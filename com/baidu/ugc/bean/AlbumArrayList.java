package com.baidu.ugc.bean;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public class AlbumArrayList<E> extends ArrayList<LocalAlbumInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.ugc.bean.LocalAlbumInfo */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(LocalAlbumInfo localAlbumInfo) {
        if (contains(localAlbumInfo)) {
            return false;
        }
        return super.add((AlbumArrayList<E>) localAlbumInfo);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof LocalAlbumInfo)) {
            return -1;
        }
        LocalAlbumInfo localAlbumInfo = (LocalAlbumInfo) obj;
        int i = 0;
        if (localAlbumInfo == null) {
            while (i < size()) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size()) {
                if (localAlbumInfo.equals(get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        if (!(obj instanceof LocalAlbumInfo)) {
            return false;
        }
        LocalAlbumInfo localAlbumInfo = (LocalAlbumInfo) obj;
        for (int i = 0; i < size(); i++) {
            if (localAlbumInfo.equals(get(i))) {
                if (remove(i) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
