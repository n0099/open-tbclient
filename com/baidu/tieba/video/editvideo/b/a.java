package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tieba.video.editvideo.data.a kvJ;
    private b kvK;
    b.a kvL;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        this.kvJ = aVar;
    }

    public boolean cOn() {
        return (this.kvJ == null || "normal".equalsIgnoreCase(this.kvJ.value)) ? false : true;
    }

    public void JM(String str) {
        if ((this.kvK == null || !this.kvK.isRunning()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            String cOp = cOp();
            String str2 = "normal";
            if (this.kvJ != null) {
                str2 = this.kvJ.value;
            }
            this.kvK = new b(this.mContext, str, cOp, str2);
            if (this.kvL != null) {
                this.kvK.a(this.kvL);
            }
            this.kvK.cOq();
        }
    }

    public boolean cOo() {
        if (this.kvK != null) {
            return this.kvK.isRunning();
        }
        return false;
    }

    public void interruptProcess() {
        if (this.kvK != null) {
            this.kvK.cOr();
        }
    }

    public void a(b.a aVar) {
        this.kvL = aVar;
        if (this.kvK != null) {
            this.kvK.a(this.kvL);
        }
    }

    public static List<com.baidu.tieba.video.editvideo.data.a> fz(Context context) {
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

    private static String cOp() {
        return com.baidu.tieba.video.c.ktO + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }
}
