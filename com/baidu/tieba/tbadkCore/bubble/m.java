package com.baidu.tieba.tbadkCore.bubble;

import android.app.Activity;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.guide.g;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
import java.util.Date;
/* loaded from: classes.dex */
public class m {
    private static d bXQ;

    public static void a(BaseActivity<?> baseActivity, View view, boolean z, y yVar) {
        SpannableString spannableString;
        int defaultBubbleEndTime = TbadkCoreApplication.m255getInst().getDefaultBubbleEndTime();
        if (defaultBubbleEndTime > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                new h(baseActivity.getPageContext()).w(0, com.baidu.adp.lib.util.l.M(baseActivity.getPageContext().getPageActivity()), com.baidu.adp.lib.util.l.N(baseActivity.getPageContext().getPageActivity()));
                TbadkCoreApplication.m255getInst().setDefaultBubble(null);
                TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(0);
                if (yVar != null) {
                    yVar.jx();
                }
                a aVar = new a(baseActivity.getPageContext().getPageActivity());
                aVar.ai(false);
                View inflate = b.ei().inflate(baseActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.bubble_free_dialog_content, null);
                TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.tip1);
                TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.tip2);
                bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
                bc.b(textView2, com.baidu.tieba.t.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.fontsize32));
                aVar.j(inflate);
                aVar.a(com.baidu.tieba.z.open_now, new n(baseActivity));
                aVar.b(com.baidu.tieba.z.group_create_private_isee, new o(baseActivity));
                aVar.b(baseActivity.getPageContext());
                aVar.nX();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.oj().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = com.baidu.tieba.t.cp_cont_g;
                int i3 = com.baidu.tieba.t.cp_link_tip_d;
                int i4 = com.baidu.tieba.v.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.z.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(bc.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(bc.getColor(i3)), 10, 14, 34);
                }
                g gVar = new g();
                gVar.b(view).N(0).v(false);
                gVar.a(new p(baseActivity, z, spannableString, i4));
                gVar.u(true);
                gVar.w(false);
                bXQ = gVar.dx();
                new Handler().postDelayed(new r(baseActivity, z), 300L);
                com.baidu.tbadk.core.sharedPref.b.oj().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity, boolean z) {
        if (bXQ != null) {
            bXQ.i(activity);
        }
        if (!z) {
            new Handler().postDelayed(new s(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public static void a(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, x xVar) {
        if (bubbleData != null) {
            a aVar = new a(tbPageContext.getPageActivity());
            aVar.ai(false);
            Date date = new Date();
            Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
            String d = bf.d(date);
            String d2 = bf.d(date2);
            String format = String.format(tbPageContext.getResources().getString(com.baidu.tieba.z.bubble_free_dialog_text), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
            View inflate = b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.bubble_free_dialog_content, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.tip1);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.tip2);
            bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView2, com.baidu.tieba.t.cp_cont_c, 1);
            textView.setText(format);
            textView2.setText(String.valueOf(d) + tbPageContext.getString(com.baidu.tieba.z.to) + d2);
            aVar.j(inflate);
            aVar.a(com.baidu.tieba.z.use_now, new t(xVar, bubbleData));
            aVar.b(com.baidu.tieba.z.cancel, new u(xVar));
            aVar.b(tbPageContext);
            aVar.nX();
        }
    }

    public static void b(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, x xVar) {
        if (bubbleData != null) {
            a aVar = new a(tbPageContext.getPageActivity());
            aVar.ai(false);
            aVar.bW(String.format(tbPageContext.getString(com.baidu.tieba.z.bubble_pay_dialog_text), bubbleData.getLevel_name()));
            aVar.a(com.baidu.tieba.z.open_now, new v(xVar, bubbleData));
            aVar.b(com.baidu.tieba.z.cancel, new w(xVar));
            aVar.b(tbPageContext);
            aVar.nX();
        }
    }
}
