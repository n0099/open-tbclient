package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jER;
    private Bitmap lij;
    private String lik;
    private com.baidu.tbadk.widget.richText.a lil;
    private int threadType;

    public Bitmap dgx() {
        return this.lij;
    }

    public void E(Bitmap bitmap) {
        this.lij = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lik;
    }

    public void Pc(String str) {
        this.lik = str;
    }

    public void g(PostData postData) {
        this.jER = postData;
    }

    public PostData dgy() {
        return this.jER;
    }

    public com.baidu.tbadk.widget.richText.a dgz() {
        return this.lil;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lil = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
