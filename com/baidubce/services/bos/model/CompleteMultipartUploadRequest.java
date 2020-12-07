package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.util.CheckUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes25.dex */
public class CompleteMultipartUploadRequest extends GenericUploadRequest {
    private ObjectMetadata objectMetadata;
    private List<PartETag> partETags;

    public CompleteMultipartUploadRequest() {
        this.objectMetadata = new ObjectMetadata();
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        this(str, str2, str3, list, null);
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) {
        super(str, str2, str3);
        this.objectMetadata = new ObjectMetadata();
        this.partETags = list;
        this.objectMetadata = objectMetadata;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public CompleteMultipartUploadRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public CompleteMultipartUploadRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public CompleteMultipartUploadRequest withKey(String str) {
        setKey(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericUploadRequest
    public CompleteMultipartUploadRequest withUploadId(String str) {
        setUploadId(str);
        return this;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public CompleteMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata) {
        setObjectMetadata(objectMetadata);
        return this;
    }

    public List<PartETag> getPartETags() {
        return this.partETags;
    }

    public void setPartETags(List<PartETag> list) {
        CheckUtils.isNotNull(list, "partETags should not be null.");
        for (int i = 0; i < list.size(); i++) {
            PartETag partETag = list.get(i);
            CheckUtils.isNotNull(partETag, "partETags[%s] should not be null.", Integer.valueOf(i));
            int partNumber = partETag.getPartNumber();
            CheckUtils.checkArgument(partNumber > 0, "partNumber should be positive. partETags[%s].partNumber:%s", Integer.valueOf(i), Integer.valueOf(partNumber));
            CheckUtils.isNotNull(partETag.getETag(), "partETags[%s].eTag should not be null.", Integer.valueOf(i));
        }
        Collections.sort(list, new Comparator<PartETag>() { // from class: com.baidubce.services.bos.model.CompleteMultipartUploadRequest.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(PartETag partETag2, PartETag partETag3) {
                return partETag2.getPartNumber() - partETag3.getPartNumber();
            }
        });
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            int partNumber2 = list.get(i2).getPartNumber();
            CheckUtils.checkArgument(partNumber2 != i3, "Duplicated partNumber %s.", Integer.valueOf(partNumber2));
            i2++;
            i3 = partNumber2;
        }
        this.partETags = list;
    }

    public CompleteMultipartUploadRequest withPartETags(List<PartETag> list) {
        setPartETags(list);
        return this;
    }
}
