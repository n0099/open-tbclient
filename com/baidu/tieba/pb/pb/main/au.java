package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes9.dex */
public class au {
    private static TextView evA;
    private static final int[] jRa = {R.string.i_have_a_bold_idea, R.string.give_you_a_god_comment_chance, R.string.wait_for_you_so_long_time_finally_you_come, R.string.hot_or_not_hot_up_to_you, R.string.let_us_talk_dont_shy};

    public static Intent aC(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        intent.putExtra("key_start_from", 5);
        return intent;
    }

    public static int cGX() {
        return jRa[new Random().nextInt(jRa.length)];
    }

    public static String Jx(String str) {
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)});
    }

    public static SpannableString aJ(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        String str = "";
        if (bkVar.aSy() == 1) {
            str = TbadkCoreApplication.getInst().getString(R.string.yuanchuang);
        } else if (bkVar.aSy() == 2) {
            str = TbadkCoreApplication.getInst().getString(R.string.shoufa);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
        spannableString.setSpan(new com.baidu.tbadk.core.view.a.a(R.color.cp_bg_line_c, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.cp_cont_b, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
        return spannableString;
    }

    public static Layout c(SpannableStringBuilder spannableStringBuilder) {
        Context context = TbadkCoreApplication.getInst().getContext();
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2);
        int contentSize = TbConfig.getContentSize();
        try {
            if (evA == null) {
                evA = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = evA;
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            textView.setText(spannableStringBuilder);
            textView.setTextSize(0, contentSize);
            textView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            textView.getPaint().setFakeBoldText(true);
            textView.measure(View.MeasureSpec.makeMeasureSpec(equipmentWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            return textView.getLayout();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int cGY() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
    }

    public static int cGZ() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
    }

    public static int q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cCi() == null) {
            return 0;
        }
        if (eVar.cCi().aRV()) {
            return (com.baidu.tbadk.core.util.v.isEmpty(eVar.cCE()) && (eVar.cCh() == null || StringUtils.isNull(eVar.cCh().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
