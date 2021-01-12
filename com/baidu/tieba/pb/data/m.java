package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData khK;
    private String lCA;
    private com.baidu.tbadk.widget.richText.a lCB;
    private Bitmap lCz;
    private int threadType;

    public Bitmap djE() {
        return this.lCz;
    }

    public void F(Bitmap bitmap) {
        this.lCz = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lCA;
    }

    public void Ou(String str) {
        this.lCA = str;
    }

    public void g(PostData postData) {
        this.khK = postData;
    }

    public PostData djF() {
        return this.khK;
    }

    public com.baidu.tbadk.widget.richText.a djG() {
        return this.lCB;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lCB = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
