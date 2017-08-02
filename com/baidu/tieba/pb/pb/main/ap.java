package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ap {
    public static Intent ah(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean k(PostData postData) {
        if (postData == null || postData.bsz() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h bsz = postData.bsz();
        if (bsz.ggk) {
            int brY = bsz.brY();
            return brY == 2 || brY == 1 || brY == 3;
        }
        return false;
    }

    public static SpannableStringBuilder i(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a(context, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public static String a(MetaData metaData) {
        if (metaData == null || metaData.getGodUserData() == null) {
            return "";
        }
        String forumName = metaData.getGodUserData().getForumName();
        String godIntro = metaData.getGodIntro();
        if (metaData.getGodUserData().getType() != 2 || TextUtils.isEmpty(forumName)) {
            return getString(d.l.user_certification_intro, godIntro);
        }
        return getString(d.l.user_certification_intro_with_barname, UtilHelper.getForumNameWithBar(forumName), godIntro);
    }

    public static String getString(int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }
}
