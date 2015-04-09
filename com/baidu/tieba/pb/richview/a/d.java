package com.baidu.tieba.pb.richview.a;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class d implements c {
    private long bOC;
    private String big_cdn_src;
    private String big_src;
    private String cdn_src;
    private int height;
    private String src;
    private int width;

    public d(Content content) {
        if (content != null && content.type.longValue() == 3) {
            this.src = content.src;
            this.big_src = content.big_src;
            this.big_cdn_src = content.big_cdn_src;
            this.bOC = content.type.longValue();
            String str = content.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = Integer.valueOf(split[0]).intValue();
                    this.height = Integer.valueOf(split[1]).intValue();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.width <= 0) {
                this.width = 1;
            }
            if (this.height <= 0) {
                this.height = 1;
            }
            this.cdn_src = content.cdn_src;
        }
    }

    public String getSrc() {
        return this.src;
    }

    @Override // com.baidu.tieba.pb.richview.a.c
    public int getType() {
        return 3;
    }
}
