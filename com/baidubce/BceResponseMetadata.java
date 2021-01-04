package com.baidubce;

import java.util.Date;
/* loaded from: classes6.dex */
public class BceResponseMetadata {
    private String bceContentSha256;
    private String bceRequestId;
    private String contentDisposition;
    private String contentEncoding;
    private long contentLength = -1;
    private String contentMd5;
    private String contentRange;
    private String contentType;
    private Long crc32;
    private Date date;
    private String eTag;
    private Date expires;
    private Date lastModified;
    private String location;
    private String server;
    private String transferEncoding;

    public String getBceRequestId() {
        return this.bceRequestId;
    }

    public void setBceRequestId(String str) {
        this.bceRequestId = str;
    }

    public String getBceContentSha256() {
        return this.bceContentSha256;
    }

    public void setBceContentSha256(String str) {
        this.bceContentSha256 = str;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public void setContentRange(String str) {
        this.contentRange = str;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public Long getCrc32() {
        return this.crc32;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public Date getExpires() {
        return this.expires;
    }

    public void setExpires(Date date) {
        this.expires = date;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public void setTransferEncoding(String str) {
        this.transferEncoding = str;
    }

    public String toString() {
        return "BceResponseMetadata [\n  bceRequestId=" + this.bceRequestId + ", \n  bceContentSha256=" + this.bceContentSha256 + ", \n  contentDisposition=" + this.contentDisposition + ", \n  contentEncoding=" + this.contentEncoding + ", \n  contentLength=" + this.contentLength + ", \n  contentMd5=" + this.contentMd5 + ", \n  contentRange=" + this.contentRange + ", \n  contentType=" + this.contentType + ", \n  date=" + this.date + ", \n  eTag=" + this.eTag + ", \n  expires=" + this.expires + ", \n  lastModified=" + this.lastModified + ", \n  server=" + this.server + ", \n  location=" + this.location + "]";
    }
}
