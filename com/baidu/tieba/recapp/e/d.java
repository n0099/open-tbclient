package com.baidu.tieba.recapp.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes20.dex */
public class d {
    private final Context context;
    private final ViewGroup drb;
    public int page = 0;

    public d(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.drb = viewGroup;
    }

    public e a(AdCard.f fVar, e eVar) {
        if (fVar != null && fVar.style != null) {
            if (eVar == null || !fp(fVar.style, eVar.lrM)) {
                if (this.drb == null) {
                    return null;
                }
                this.drb.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(fVar.style)) {
                    if (this.page == 1) {
                        return new c(LayoutInflater.from(this.context).inflate(R.layout.videolist_tail_frame_ad_jump, this.drb, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new b(LayoutInflater.from(this.context).inflate(R.layout.tail_frame_ad_jump, this.drb, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(fVar.style)) {
                    return new a(LayoutInflater.from(this.context).inflate(R.layout.tail_frame_ad_download, this.drb, true), "apk_download");
                } else {
                    return null;
                }
            }
            return eVar;
        }
        return eVar;
    }

    private boolean fp(String str, String str2) {
        if ("apk_download".equals(str)) {
            return "apk_download".equals(str2);
        }
        if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
            return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
        }
        return false;
    }
}
