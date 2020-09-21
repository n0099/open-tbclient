package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jds;
    private String kGA;
    private com.baidu.tbadk.widget.richText.a kGB;
    private Bitmap kGz;
    private int threadType;

    public Bitmap cZG() {
        return this.kGz;
    }

    public void E(Bitmap bitmap) {
        this.kGz = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.kGA;
    }

    public void NP(String str) {
        this.kGA = str;
    }

    public void g(PostData postData) {
        this.jds = postData;
    }

    public PostData cZH() {
        return this.jds;
    }

    public com.baidu.tbadk.widget.richText.a cZI() {
        return this.kGB;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.kGB = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
