package com.baidubce.services.bos.model;
/* loaded from: classes5.dex */
public class PartETag {
    public String eTag;
    public int partNumber;

    public PartETag() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PartETag.class == obj.getClass()) {
            PartETag partETag = (PartETag) obj;
            String str = this.eTag;
            if (str == null) {
                if (partETag.eTag != null) {
                    return false;
                }
            } else if (!str.equals(partETag.eTag)) {
                return false;
            }
            return this.partNumber == partETag.partNumber;
        }
        return false;
    }

    public String getETag() {
        return this.eTag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public int hashCode() {
        String str = this.eTag;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.partNumber;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public String toString() {
        return "PartETag [partNumber=" + this.partNumber + ", eTag=" + this.eTag + "]";
    }

    public PartETag withETag(String str) {
        setETag(str);
        return this;
    }

    public PartETag withPartNumber(int i) {
        setPartNumber(i);
        return this;
    }

    public PartETag(int i, String str) {
        setPartNumber(i);
        setETag(str);
    }
}
