package com.baidu.tieba.tbadkCore.b;

import android.app.Activity;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static com.baidu.adp.lib.guide.d dyO;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0084a {
        void nu();
    }

    public static void a(BaseActivity<?> baseActivity, View view, boolean z, InterfaceC0084a interfaceC0084a) {
        int defaultBubbleEndTime;
        SpannableString spannableString;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.m411getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.m411getInst().setDefaultBubble(null);
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0084a != null) {
                    interfaceC0084a.nu();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.am(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(n.g.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(n.f.tip1);
                TextView textView2 = (TextView) inflate.findViewById(n.f.tip2);
                as.b(textView, n.c.cp_cont_b, 1);
                as.b(textView2, n.c.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(n.i.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(n.i.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(n.d.fontsize32));
                aVar.m(inflate);
                aVar.a(n.i.open_now, new b(baseActivity));
                aVar.b(n.i.group_create_private_isee, new c());
                aVar.b(baseActivity.getPageContext());
                aVar.tv();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.tZ().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = n.c.cp_cont_g;
                int i3 = n.c.cp_link_tip_d;
                int i4 = n.e.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(n.i.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(as.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(as.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(n.i.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(as.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(as.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(n.i.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(as.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(as.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.c(view).P(0).v(false);
                gVar.a(new d(baseActivity, z, spannableString, i4));
                gVar.u(true);
                gVar.w(false);
                dyO = gVar.gz();
                new Handler().postDelayed(new f(baseActivity, z), 300L);
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Activity activity, boolean z) {
        if (dyO != null) {
            dyO.i(activity);
        }
        if (!z) {
            new Handler().postDelayed(new g(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
