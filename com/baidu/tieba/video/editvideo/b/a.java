package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.video.editvideo.data.a gYp;
    private b gYq;
    b.a gYr;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.gYp = aVar;
    }

    public boolean bBB() {
        return (this.gYp == null || "normal".equalsIgnoreCase(this.gYp.value)) ? false : true;
    }

    public void uP(String str) {
        if ((this.gYq == null || !this.gYq.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bBE = bBE();
            String str2 = "normal";
            if (this.gYp != null) {
                str2 = this.gYp.value;
            }
            this.gYq = new b(this.mContext, str, bBE, str2);
            if (this.gYr != null) {
                this.gYq.a(this.gYr);
            }
            this.gYq.bBF();
        }
    }

    public boolean bBC() {
        if (this.gYq != null) {
            return this.gYq.isRunning();
        }
        return false;
    }

    public void bBD() {
        if (this.gYq != null) {
            this.gYq.bBG();
        }
    }

    public void a(b.a aVar) {
        this.gYr = aVar;
        if (this.gYq != null) {
            this.gYq.a(this.gYr);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cn(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, d.f.filter_icon_avatar_default, context.getString(d.k.filter_nature), "nature");
        a(arrayList, d.f.filter_icon_avatar_hongkong, context.getString(d.k.filter_hongkong), "hongkong");
        a(arrayList, d.f.filter_icon_avatar_refreshing, context.getString(d.k.filter_refreshing), "refreshing");
        a(arrayList, d.f.filter_icon_avatar_girly, context.getString(d.k.filter_girly), "girly");
        a(arrayList, d.f.filter_icon_avatar_concrete, context.getString(d.k.filter_concrete), "concrete");
        a(arrayList, d.f.filter_icon_avatar_warm, context.getString(d.k.filter_warm), "warm");
        a(arrayList, d.f.filter_icon_avatar_cold, context.getString(d.k.filter_cold), "cold");
        a(arrayList, d.f.filter_icon_avatar_japanese, context.getString(d.k.filter_japanese), "Japanese");
        a(arrayList, d.f.filter_icon_avatar_cruz, context.getString(d.k.filter_hdr), "cruz");
        a(arrayList, d.f.filter_icon_avatar_abao, context.getString(d.k.filter_abao), "abao");
        a(arrayList, d.f.filter_icon_avatar_dew, context.getString(d.k.filter_dew), "dew");
        a(arrayList, d.f.filter_icon_avatar_slowlived, context.getString(d.k.filter_slowlived), "slowlived");
        a(arrayList, d.f.filter_icon_avatar_sweet, context.getString(d.k.filter_sweet), "sweet");
        a(arrayList, d.f.filter_icon_avatar_boardwalk, context.getString(d.k.filter_boardwalk), "boardwalk");
        a(arrayList, d.f.filter_icon_avatar_keylime, context.getString(d.k.filter_keylime), "keylime");
        a(arrayList, d.f.filter_icon_avatar_electric, context.getString(d.k.filter_electric), "electric");
        a(arrayList, d.f.filter_icon_avatar_silver, context.getString(d.k.filter_silver), "silver");
        a(arrayList, d.f.filter_icon_avatar_blackwhite, context.getString(d.k.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    private static void a(List<com.baidu.tieba.video.editvideo.data.a> list, int i, String str, String str2) {
        if (list != null) {
            list.add(new com.baidu.tieba.video.editvideo.data.a(str, i, str2));
        }
    }

    private static String bBE() {
        return com.baidu.tieba.video.b.gWl + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
