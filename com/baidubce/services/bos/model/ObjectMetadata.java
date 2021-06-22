package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ObjectMetadata {
    public long appendOffset;
    public String bceContentSha256;
    public String cacheControl;
    public String contentDisposition;
    public String contentEncoding;
    public long contentLength;
    public String contentMd5;
    public String contentRange;
    public String contentType;
    public Long crc32;
    public String eTag;
    public String expires;
    public long instanceLength;
    public Date lastModified;
    public String objectType;
    public String storageClass;
    public Map<String, String> userMetadata;

    public ObjectMetadata() {
        this.userMetadata = new HashMap();
        this.contentLength = -1L;
        this.instanceLength = -1L;
    }

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    public long getAppendOffset() {
        return this.appendOffset;
    }

    public String getBceContentSha256() {
        return this.bceContentSha256;
    }

    public String getCacheControl() {
        return this.cacheControl;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Long getCrc32() {
        return this.crc32;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getExpires() {
        return this.expires;
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUserMetaDataOf(String str) {
        Map<String, String> map = this.userMetadata;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setAppendOffset(long j) {
        this.appendOffset = j;
    }

    public void setBceContentSha256(String str) {
        this.bceContentSha256 = str;
    }

    public void setCacheControl(String str) {
        this.cacheControl = str;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public void setContentRange(String str) {
        this.contentRange = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setExpires(String str) {
        this.expires = str;
    }

    public void setInstanceLength(long j) {
        this.instanceLength = j;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setObjectType(String str) {
        this.objectType = str;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setUserMetadata(Map<String, String> map) {
        CheckUtils.isNotNull(map, "userMetadata should not be null.");
        this.userMetadata = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectMetadata [");
        sb.append("userMetadata=");
        sb.append(this.userMetadata);
        if (this.bceContentSha256 != null) {
            sb.append(", bceContentSha256=");
            sb.append(this.bceContentSha256);
        }
        if (this.contentDisposition != null) {
            sb.append(", contentDisposition=");
            sb.append(this.contentDisposition);
        }
        if (this.contentEncoding != null) {
            sb.append(", contentEncoding=");
            sb.append(this.contentEncoding);
        }
        if (this.contentLength >= 0) {
            sb.append(", contentLength=");
            sb.append(this.contentLength);
        }
        if (this.contentMd5 != null) {
            sb.append(", contentMd5=");
            sb.append(this.contentMd5);
        }
        if (this.contentType != null) {
            sb.append(", contentType=");
            sb.append(this.contentType);
        }
        if (this.eTag != null) {
            sb.append(", eTag=");
            sb.append(this.eTag);
        }
        if (this.instanceLength >= 0) {
            sb.append(", instanceLength=");
            sb.append(this.instanceLength);
        }
        if (this.lastModified != null) {
            sb.append(", lastModified=");
            sb.append(this.lastModified);
        }
        if (this.cacheControl != null) {
            sb.append(", cacheControl=");
            sb.append(this.cacheControl);
        }
        if (this.storageClass != null) {
            sb.append(", storageClass=");
            sb.append(this.storageClass);
        }
        if (this.crc32 != null) {
            sb.append(", crc32=");
            sb.append(this.crc32);
        }
        sb.append(']');
        return sb.toString();
    }

    public ObjectMetadata(ObjectMetadata objectMetadata) {
        this.userMetadata = new HashMap();
        this.contentLength = -1L;
        this.instanceLength = -1L;
        if (objectMetadata.userMetadata != null) {
            this.userMetadata = new HashMap(objectMetadata.userMetadata);
        }
        setBceContentSha256(objectMetadata.getBceContentSha256());
        setContentDisposition(objectMetadata.getContentDisposition());
        setContentEncoding(objectMetadata.getContentEncoding());
        setContentLength(objectMetadata.getContentLength());
        setContentMd5(objectMetadata.getContentMd5());
        setContentType(objectMetadata.getContentType());
        setETag(objectMetadata.getETag());
        setCrc32(objectMetadata.getCrc32());
        setInstanceLength(objectMetadata.getInstanceLength());
        setLastModified(objectMetadata.getLastModified());
        setExpires(objectMetadata.getExpires());
        setAppendOffset(objectMetadata.getAppendOffset());
        setObjectType(objectMetadata.getObjectType());
        setCacheControl(objectMetadata.getCacheControl());
        setStorageClass(objectMetadata.getStorageClass());
    }
}
