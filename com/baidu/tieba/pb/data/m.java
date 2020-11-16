package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jLA;
    private Bitmap loB;
    private String loC;
    private com.baidu.tbadk.widget.richText.a loD;
    private int threadType;

    public Bitmap diw() {
        return this.loB;
    }

    public void E(Bitmap bitmap) {
        this.loB = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.loC;
    }

    public void OP(String str) {
        this.loC = str;
    }

    public void g(PostData postData) {
        this.jLA = postData;
    }

    public PostData dix() {
        return this.jLA;
    }

    public com.baidu.tbadk.widget.richText.a diy() {
        return this.loD;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.loD = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
