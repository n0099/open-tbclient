package com.baidu.tieba.model;

import com.baidu.tieba.data.MapPostItem;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MapOverlayModel implements Serializable {
    private static final long serialVersionUID = -7899889727335905181L;
    private ArrayList mPosts = null;
    private int zoomLevel;

    public ArrayList getPosts() {
        return this.mPosts;
    }

    public void setPosts(ArrayList arrayList) {
        this.mPosts = arrayList;
    }

    public void addPost(MapPostItem mapPostItem) {
        if (this.mPosts == null) {
            this.mPosts = new ArrayList();
        }
        this.mPosts.add(mapPostItem);
    }

    public void setZoomLevel(int i) {
        this.zoomLevel = i;
    }

    public int getZoomLevel() {
        return this.zoomLevel;
    }
}
