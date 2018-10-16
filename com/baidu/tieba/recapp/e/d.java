package com.baidu.tieba.recapp.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class d {
    private final Context context;
    private final ViewGroup gJj;
    public int page = 0;

    public d(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.gJj = viewGroup;
    }

    public e a(AdCard.f fVar, e eVar) {
        if (fVar != null && fVar.style != null) {
            if (eVar == null || !cw(fVar.style, eVar.gJk)) {
                if (this.gJj == null) {
                    return null;
                }
                this.gJj.removeAllViews();
                if ("jump".equals(fVar.style)) {
                    if (this.page == 1) {
                        return new c(LayoutInflater.from(this.context).inflate(e.h.videolist_tail_frame_ad_jump, this.gJj, true), "jump");
                    }
                    return new b(LayoutInflater.from(this.context).inflate(e.h.tail_frame_ad_jump, this.gJj, true), "jump");
                } else if ("apk_download".equals(fVar.style)) {
                    return new a(LayoutInflater.from(this.context).inflate(e.h.tail_frame_ad_download, this.gJj, true), "apk_download");
                } else {
                    return null;
                }
            }
            return eVar;
        }
        return eVar;
    }

    private boolean cw(String str, String str2) {
        if ("apk_download".equals(str)) {
            return "apk_download".equals(str2);
        }
        if ("jump".equals(str)) {
            return "jump".equals(str2);
        }
        return false;
    }
}
