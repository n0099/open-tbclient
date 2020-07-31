package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class ListBucketsResponse extends BosResponse {
    private List<BucketSummary> buckets = new ArrayList();
    private User owner;

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public List<BucketSummary> getBuckets() {
        return this.buckets;
    }

    public void setBuckets(List<BucketSummary> list) {
        this.buckets = list;
    }
}
