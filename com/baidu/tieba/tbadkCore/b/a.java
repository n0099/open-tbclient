package com.baidu.tieba.tbadkCore.b;

import android.app.Activity;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static com.baidu.adp.lib.guide.d cnx;

    public static void a(BaseActivity<?> baseActivity, View view, boolean z, h hVar) {
        int defaultBubbleEndTime;
        SpannableString spannableString;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.m411getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(2001290, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.m411getInst().setDefaultBubble(null);
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(0);
                if (hVar != null) {
                    hVar.mM();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.ad(false);
                View inflate = com.baidu.adp.lib.g.b.hH().inflate(baseActivity.getPageContext().getPageActivity(), w.bubble_free_dialog_content, null);
                TextView textView = (TextView) inflate.findViewById(v.tip1);
                TextView textView2 = (TextView) inflate.findViewById(v.tip2);
                ba.b(textView, s.cp_cont_b, 1);
                ba.b(textView2, s.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(y.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(y.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(t.fontsize32));
                aVar.j(inflate);
                aVar.a(y.open_now, new b(baseActivity));
                aVar.b(y.group_create_private_isee, new c(baseActivity));
                aVar.b(baseActivity.getPageContext());
                aVar.re();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.rB().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = s.cp_cont_g;
                int i3 = s.cp_link_tip_d;
                int i4 = u.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(y.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(y.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(y.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(ba.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(ba.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.b(view).O(0).v(false);
                gVar.a(new d(baseActivity, z, spannableString, i4));
                gVar.u(true);
                gVar.w(false);
                cnx = gVar.gV();
                new Handler().postDelayed(new f(baseActivity, z), 300L);
                com.baidu.tbadk.core.sharedPref.b.rB().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity, boolean z) {
        if (cnx != null) {
            cnx.i(activity);
        }
        if (!z) {
            new Handler().postDelayed(new g(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
