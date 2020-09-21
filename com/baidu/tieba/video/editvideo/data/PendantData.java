package com.baidu.tieba.video.editvideo.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes22.dex */
public class PendantData extends OrmObject {
    public static final int TYPE_BLACK_TEXT = 2;
    public static final int TYPE_BLUE_TEXT = 1;
    public static final int TYPE_NO = 0;
    public static final int TYPE_PENDANT = 4;
    public static final int TYPE_TRAN_TEXT = 3;
    public int bottom;
    public String id;
    public String img;
    public int left;
    public String name;
    public int pendantType;
    public String resource;
    public int right;
    public String seq;
    public String size;
    public int top;

    public PendantData() {
        this.pendantType = 4;
    }

    public PendantData(int i) {
        this.pendantType = 4;
        this.pendantType = i;
    }

    public void dFM() {
        if (!TextUtils.isEmpty(this.size)) {
            String[] split = this.size.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length == 4) {
                try {
                    this.top = Integer.parseInt(split[0]);
                    this.left = Integer.parseInt(split[1]);
                    this.bottom = Integer.parseInt(split[2]);
                    this.right = Integer.parseInt(split[3]);
                } catch (NumberFormatException e) {
                }
            }
        }
    }
}
