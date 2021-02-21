package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class n {
    private String content;
    private PostData kqg;
    private Bitmap lLC;
    private String lLD;
    private com.baidu.tbadk.widget.richText.a lLE;
    private int threadType;

    public Bitmap dlX() {
        return this.lLC;
    }

    public void E(Bitmap bitmap) {
        this.lLC = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lLD;
    }

    public void Pn(String str) {
        this.lLD = str;
    }

    public void g(PostData postData) {
        this.kqg = postData;
    }

    public PostData dlY() {
        return this.kqg;
    }

    public com.baidu.tbadk.widget.richText.a dlZ() {
        return this.lLE;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lLE = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
