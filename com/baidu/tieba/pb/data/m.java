package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData kmq;
    private Bitmap lHf;
    private String lHg;
    private com.baidu.tbadk.widget.richText.a lHh;
    private int threadType;

    public Bitmap dnw() {
        return this.lHf;
    }

    public void F(Bitmap bitmap) {
        this.lHf = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lHg;
    }

    public void PD(String str) {
        this.lHg = str;
    }

    public void g(PostData postData) {
        this.kmq = postData;
    }

    public PostData dnx() {
        return this.kmq;
    }

    public com.baidu.tbadk.widget.richText.a dny() {
        return this.lHh;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lHh = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
