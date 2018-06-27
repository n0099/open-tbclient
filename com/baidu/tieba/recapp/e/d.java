package com.baidu.tieba.recapp.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class d {
    private final Context context;
    private final ViewGroup gtb;
    public int page = 0;

    public d(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.gtb = viewGroup;
    }

    public e a(AdCard.f fVar, e eVar) {
        if (fVar != null && fVar.style != null) {
            if (eVar == null || !ce(fVar.style, eVar.gtc)) {
                if (this.gtb == null) {
                    return null;
                }
                this.gtb.removeAllViews();
                if ("jump".equals(fVar.style)) {
                    if (this.page == 1) {
                        return new c(LayoutInflater.from(this.context).inflate(d.i.videolist_tail_frame_ad_jump, this.gtb, true), "jump");
                    }
                    return new b(LayoutInflater.from(this.context).inflate(d.i.tail_frame_ad_jump, this.gtb, true), "jump");
                } else if ("apk_download".equals(fVar.style)) {
                    return new a(LayoutInflater.from(this.context).inflate(d.i.tail_frame_ad_download, this.gtb, true), "apk_download");
                } else {
                    return null;
                }
            }
            return eVar;
        }
        return eVar;
    }

    private boolean ce(String str, String str2) {
        if ("apk_download".equals(str)) {
            return "apk_download".equals(str2);
        }
        if ("jump".equals(str)) {
            return "jump".equals(str2);
        }
        return false;
    }
}
