package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jZd;
    private Bitmap lBX;
    private String lBY;
    private com.baidu.tbadk.widget.richText.a lBZ;
    private int threadType;

    public Bitmap dnL() {
        return this.lBX;
    }

    public void E(Bitmap bitmap) {
        this.lBX = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lBY;
    }

    public void PX(String str) {
        this.lBY = str;
    }

    public void g(PostData postData) {
        this.jZd = postData;
    }

    public PostData dnM() {
        return this.jZd;
    }

    public com.baidu.tbadk.widget.richText.a dnN() {
        return this.lBZ;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lBZ = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
