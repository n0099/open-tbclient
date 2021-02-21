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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes2.dex */
public class ao {
    private static TextView fNA;
    private static final int[] lYT = {R.string.reply_hint_text_1, R.string.reply_hint_text_2, R.string.reply_hint_text_3};

    public static Intent aQ(Context context, String str) {
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

    public static String getString(int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    public static int dqk() {
        return lYT[new Random().nextInt(lYT.length)];
    }

    public static String PG(String str) {
        return TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(str, 7, false)});
    }

    public static SpannableString aN(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        String str = "";
        if (cbVar.bpP() == 1) {
            str = TbadkCoreApplication.getInst().getString(R.string.yuanchuang);
        } else if (cbVar.bpP() == 2) {
            str = TbadkCoreApplication.getInst().getString(R.string.shoufa);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
        spannableString.setSpan(new com.baidu.tbadk.core.view.a.a(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
        return spannableString;
    }

    public static Layout i(SpannableStringBuilder spannableStringBuilder) {
        Context context = TbadkCoreApplication.getInst().getContext();
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2);
        int contentSize = TbConfig.getContentSize();
        try {
            if (fNA == null) {
                fNA = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = fNA;
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

    public static int dql() {
        return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
    }

    public static int r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlg() == null) {
            return 0;
        }
        if (fVar.dlg().bpp()) {
            return (com.baidu.tbadk.core.util.y.isEmpty(fVar.dlD()) && (fVar.dlf() == null || StringUtils.isNull(fVar.dlf().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
