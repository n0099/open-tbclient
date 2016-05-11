package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class dc {
    private BaseActivity bek;
    private cw dih;

    public dc(cw cwVar, BaseActivity baseActivity) {
        this.dih = cwVar;
        this.bek = baseActivity;
    }

    public String t(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10320").s("obj_locate", 3).s("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }
}
