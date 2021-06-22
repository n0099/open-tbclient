package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ListBucketsResponse extends BosResponse {
    public List<BucketSummary> buckets = new ArrayList();
    public User owner;

    public List<BucketSummary> getBuckets() {
        return this.buckets;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setBuckets(List<BucketSummary> list) {
        this.buckets = list;
    }

    public void setOwner(User user) {
        this.owner = user;
    }
}
