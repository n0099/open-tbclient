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
    private com.baidu.tieba.video.editvideo.data.a gLN;
    private b gLO;
    b.a gLP;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.gLN = aVar;
    }

    public boolean bww() {
        return (this.gLN == null || "normal".equalsIgnoreCase(this.gLN.value)) ? false : true;
    }

    public void tS(String str) {
        if ((this.gLO == null || !this.gLO.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String bwz = bwz();
            String str2 = "normal";
            if (this.gLN != null) {
                str2 = this.gLN.value;
            }
            this.gLO = new b(this.mContext, str, bwz, str2);
            if (this.gLP != null) {
                this.gLO.a(this.gLP);
            }
            this.gLO.bwA();
        }
    }

    public boolean bwx() {
        if (this.gLO != null) {
            return this.gLO.isRunning();
        }
        return false;
    }

    public void bwy() {
        if (this.gLO != null) {
            this.gLO.bwB();
        }
    }

    public void a(b.a aVar) {
        this.gLP = aVar;
        if (this.gLO != null) {
            this.gLO.a(this.gLP);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> cc(Context context) {
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

    private static String bwz() {
        return com.baidu.tieba.video.b.gJJ + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
