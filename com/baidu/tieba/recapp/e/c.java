package com.baidu.tieba.recapp.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class c {
    private final Context context;
    private final ViewGroup gHx;

    public c(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.gHx = viewGroup;
    }

    public d a(AdCard.e eVar, d dVar) {
        if (eVar != null && eVar.style != null) {
            if (dVar == null || !bT(eVar.style, dVar.gHy)) {
                if (this.gHx == null) {
                    return null;
                }
                this.gHx.removeAllViews();
                if (TbWebViewActivityConfig.PARAMS_KEY.equals(eVar.style)) {
                    return new b(LayoutInflater.from(this.context).inflate(d.h.tail_frame_ad_jump, this.gHx, true), TbWebViewActivityConfig.PARAMS_KEY);
                }
                if ("apk_download".equals(eVar.style)) {
                    return new a(LayoutInflater.from(this.context).inflate(d.h.tail_frame_ad_download, this.gHx, true), "apk_download");
                }
                return null;
            }
            return dVar;
        }
        return dVar;
    }

    private boolean bT(String str, String str2) {
        if ("apk_download".equals(str)) {
            return "apk_download".equals(str2);
        }
        if (TbWebViewActivityConfig.PARAMS_KEY.equals(str)) {
            return TbWebViewActivityConfig.PARAMS_KEY.equals(str2);
        }
        return false;
    }
}
