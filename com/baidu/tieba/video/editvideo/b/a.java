package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private Context mContext;
    private com.baidu.tieba.video.editvideo.data.a nDa;
    private b nDb;
    b.a nDc;

    public a(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.nDa = aVar;
    }

    public String dUn() {
        return (this.nDa == null || "normal".equalsIgnoreCase(this.nDa.value)) ? "" : this.nDa.value;
    }

    public void gC(String str, String str2) {
        if ((this.nDb == null || !this.nDb.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            this.nDb = new b(this.mContext, str, dUq(), str2);
            if (this.nDc != null) {
                this.nDb.a(this.nDc);
            }
            this.nDb.dUr();
        }
    }

    public boolean dUo() {
        if (this.nDb != null) {
            return this.nDb.isRunning();
        }
        return false;
    }

    public void dUp() {
        if (this.nDb != null) {
            this.nDb.dUs();
        }
    }

    public void a(b.a aVar) {
        this.nDc = aVar;
        if (this.nDb != null) {
            this.nDb.a(this.nDc);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> gH(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, R.drawable.filter_icon_avatar_default, context.getString(R.string.filter_nature), "origin");
        a(arrayList, R.drawable.filter_icon_avatar_hongkong, context.getString(R.string.filter_hongkong), "hongkong");
        a(arrayList, R.drawable.filter_icon_avatar_refreshing, context.getString(R.string.filter_refreshing), "refreshing");
        a(arrayList, R.drawable.filter_icon_avatar_girly, context.getString(R.string.filter_girly), "girly");
        a(arrayList, R.drawable.filter_icon_avatar_concrete, context.getString(R.string.filter_concrete), "concrete");
        a(arrayList, R.drawable.filter_icon_avatar_warm, context.getString(R.string.filter_warm), "warm");
        a(arrayList, R.drawable.filter_icon_avatar_cold, context.getString(R.string.filter_cold), "cold");
        a(arrayList, R.drawable.filter_icon_avatar_japanese, context.getString(R.string.filter_japanese), "Japanese");
        a(arrayList, R.drawable.filter_icon_avatar_cruz, context.getString(R.string.filter_hdr), "cruz");
        a(arrayList, R.drawable.filter_icon_avatar_abao, context.getString(R.string.filter_abao), "abao");
        a(arrayList, R.drawable.filter_icon_avatar_dew, context.getString(R.string.filter_dew), "dew");
        a(arrayList, R.drawable.filter_icon_avatar_slowlived, context.getString(R.string.filter_slowlived), "slowlived");
        a(arrayList, R.drawable.filter_icon_avatar_sweet, context.getString(R.string.filter_sweet), "sweet");
        a(arrayList, R.drawable.filter_icon_avatar_boardwalk, context.getString(R.string.filter_boardwalk), "boardwalk");
        a(arrayList, R.drawable.filter_icon_avatar_keylime, context.getString(R.string.filter_keylime), "keylime");
        a(arrayList, R.drawable.filter_icon_avatar_electric, context.getString(R.string.filter_electric), "electric");
        a(arrayList, R.drawable.filter_icon_avatar_silver, context.getString(R.string.filter_silver), "silver");
        a(arrayList, R.drawable.filter_icon_avatar_blackwhite, context.getString(R.string.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    private static void a(List<com.baidu.tieba.video.editvideo.data.a> list, int i, String str, String str2) {
        if (list != null) {
            list.add(new com.baidu.tieba.video.editvideo.data.a(str, i, str2));
        }
    }

    private static String dUq() {
        return com.baidu.tieba.video.c.nAZ + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
