package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jsr;
    private Bitmap kVK;
    private String kVL;
    private com.baidu.tbadk.widget.richText.a kVM;
    private int threadType;

    public Bitmap ddp() {
        return this.kVK;
    }

    public void E(Bitmap bitmap) {
        this.kVK = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.kVL;
    }

    public void OE(String str) {
        this.kVL = str;
    }

    public void g(PostData postData) {
        this.jsr = postData;
    }

    public PostData ddq() {
        return this.jsr;
    }

    public com.baidu.tbadk.widget.richText.a ddr() {
        return this.kVM;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.kVM = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
