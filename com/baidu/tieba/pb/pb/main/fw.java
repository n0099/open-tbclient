package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.card.at;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class fw {
    public static Intent ag(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean i(PostData postData) {
        if (postData == null || postData.bio() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h bio = postData.bio();
        if (bio.fBJ) {
            int bhN = bio.bhN();
            return bhN == 2 || bhN == 1 || bhN == 3;
        }
        return false;
    }

    public static SpannableStringBuilder i(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a(context, str2, (ArrayList<at.a>) arrayList, true);
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
            return getString(w.l.user_certification_intro, godIntro);
        }
        return getString(w.l.user_certification_intro_with_barname, UtilHelper.getForumNameWithBar(forumName), godIntro);
    }

    public static String getString(int i, Object... objArr) {
        return TbadkCoreApplication.m9getInst().getString(i, objArr);
    }
}
