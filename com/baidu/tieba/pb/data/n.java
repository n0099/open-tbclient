package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class n {
    private String content;
    private PostData kpS;
    private Bitmap lLn;
    private String lLo;
    private com.baidu.tbadk.widget.richText.a lLp;
    private int threadType;

    public Bitmap dlQ() {
        return this.lLn;
    }

    public void E(Bitmap bitmap) {
        this.lLn = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getThreadImgUrl() {
        return this.lLo;
    }

    public void Pm(String str) {
        this.lLo = str;
    }

    public void g(PostData postData) {
        this.kpS = postData;
    }

    public PostData dlR() {
        return this.kpS;
    }

    public com.baidu.tbadk.widget.richText.a dlS() {
        return this.lLp;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.lLp = aVar;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }
}
