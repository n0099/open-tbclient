package com.baidubce;

import java.util.Date;
/* loaded from: classes5.dex */
public class BceResponseMetadata {
    public String bceContentSha256;
    public String bceRequestId;
    public String contentDisposition;
    public String contentEncoding;
    public long contentLength = -1;
    public String contentMd5;
    public String contentRange;
    public String contentType;
    public Long crc32;
    public Date date;
    public String eTag;
    public Date expires;
    public Date lastModified;
    public String location;
    public String server;
    public String transferEncoding;

    public String getBceContentSha256() {
        return this.bceContentSha256;
    }

    public String getBceRequestId() {
        return this.bceRequestId;
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

    public Date getDate() {
        return this.date;
    }

    public String getETag() {
        return this.eTag;
    }

    public Date getExpires() {
        return this.expires;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public String getLocation() {
        return this.location;
    }

    public String getServer() {
        return this.server;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public void setBceContentSha256(String str) {
        this.bceContentSha256 = str;
    }

    public void setBceRequestId(String str) {
        this.bceRequestId = str;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setExpires(Date date) {
        this.expires = date;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public void setTransferEncoding(String str) {
        this.transferEncoding = str;
    }

    public String toString() {
        return "BceResponseMetadata [\n  bceRequestId=" + this.bceRequestId + ", \n  bceContentSha256=" + this.bceContentSha256 + ", \n  contentDisposition=" + this.contentDisposition + ", \n  contentEncoding=" + this.contentEncoding + ", \n  contentLength=" + this.contentLength + ", \n  contentMd5=" + this.contentMd5 + ", \n  contentRange=" + this.contentRange + ", \n  contentType=" + this.contentType + ", \n  date=" + this.date + ", \n  eTag=" + this.eTag + ", \n  expires=" + this.expires + ", \n  lastModified=" + this.lastModified + ", \n  server=" + this.server + ", \n  location=" + this.location + "]";
    }
}
