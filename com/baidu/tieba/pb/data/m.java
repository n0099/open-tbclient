package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jZf;
    private Bitmap lBZ;
    private String lCa;
    private com.baidu.tbadk.widget.richText.a lCb;
    private int threadType;

    public Bitmap dnM() {
        return this.lBZ;
    }

    public void E(Bitmap bitmap) {
        this.lBZ = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lCa;
    }

    public void PX(String str) {
        this.lCa = str;
    }

    public void g(PostData postData) {
        this.jZf = postData;
    }

    public PostData dnN() {
        return this.jZf;
    }

    public com.baidu.tbadk.widget.richText.a dnO() {
        return this.lCb;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lCb = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
