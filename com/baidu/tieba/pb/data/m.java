package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class m {
    private String content;
    private PostData jKP;
    private Bitmap loi;
    private String loj;
    private com.baidu.tbadk.widget.richText.a lok;
    private int threadType;

    public Bitmap diZ() {
        return this.loi;
    }

    public void E(Bitmap bitmap) {
        this.loi = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.loj;
    }

    public void Pt(String str) {
        this.loj = str;
    }

    public void g(PostData postData) {
        this.jKP = postData;
    }

    public PostData dja() {
        return this.jKP;
    }

    public com.baidu.tbadk.widget.richText.a djb() {
        return this.lok;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lok = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
