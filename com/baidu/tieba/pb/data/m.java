package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData kmq;
    private Bitmap lHe;
    private String lHf;
    private com.baidu.tbadk.widget.richText.a lHg;
    private int threadType;

    public Bitmap dnx() {
        return this.lHe;
    }

    public void F(Bitmap bitmap) {
        this.lHe = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lHf;
    }

    public void PC(String str) {
        this.lHf = str;
    }

    public void g(PostData postData) {
        this.kmq = postData;
    }

    public PostData dny() {
        return this.kmq;
    }

    public com.baidu.tbadk.widget.richText.a dnz() {
        return this.lHg;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lHg = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
