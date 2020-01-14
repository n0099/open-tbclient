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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.Random;
/* loaded from: classes7.dex */
public class ap {
    private static TextView dCN;
    private static final int[] iMl = {R.string.i_have_a_bold_idea, R.string.give_you_a_god_comment_chance, R.string.wait_for_you_so_long_time_finally_you_come, R.string.hot_or_not_hot_up_to_you, R.string.let_us_talk_dont_shy};

    public static Intent aS(Context context, String str) {
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

    public static boolean o(PostData postData) {
        if (postData == null || postData.cJI() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i cJI = postData.cJI();
        if (cJI.keZ) {
            int cJg = cJI.cJg();
            return cJg == 2 || cJg == 1 || cJg == 3;
        }
        return false;
    }

    public static int cnI() {
        return iMl[new Random().nextInt(iMl.length)];
    }

    public static String FM(String str) {
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)});
    }

    public static SpannableString aE(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        String str = "";
        if (bjVar.aBW() == 1) {
            str = TbadkCoreApplication.getInst().getString(R.string.yuanchuang);
        } else if (bjVar.aBW() == 2) {
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
            if (dCN == null) {
                dCN = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = dCN;
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

    public static int cnJ() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
    }

    public static int cnK() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
    }
}
