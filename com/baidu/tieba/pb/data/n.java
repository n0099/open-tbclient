package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class n {
    private String content;
    private PostData ksi;
    private Bitmap lNE;
    private String lNF;
    private com.baidu.tbadk.widget.richText.a lNG;
    private int threadType;

    public Bitmap dmg() {
        return this.lNE;
    }

    public void E(Bitmap bitmap) {
        this.lNE = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lNF;
    }

    public void Pt(String str) {
        this.lNF = str;
    }

    public void g(PostData postData) {
        this.ksi = postData;
    }

    public PostData dmh() {
        return this.ksi;
    }

    public com.baidu.tbadk.widget.richText.a dmi() {
        return this.lNG;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lNG = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
