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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static com.baidu.adp.lib.guide.d ffC;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void kj();
    }

    public static void a(BaseActivity<?> baseActivity, View view, boolean z, InterfaceC0072a interfaceC0072a) {
        int defaultBubbleEndTime;
        SpannableString spannableString;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.m9getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.m9getInst().setDefaultBubble(null);
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0072a != null) {
                    interfaceC0072a.kj();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.av(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(r.h.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(r.g.tip1);
                TextView textView2 = (TextView) inflate.findViewById(r.g.tip2);
                ar.c(textView, r.d.cp_cont_b, 1);
                ar.c(textView2, r.d.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(r.j.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(r.j.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(r.e.fontsize32));
                aVar.z(inflate);
                aVar.a(r.j.open_now, new b(baseActivity));
                aVar.b(r.j.group_create_private_isee, new c());
                aVar.b(baseActivity.getPageContext());
                aVar.tb();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.tW().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = r.d.cp_cont_g;
                int i3 = r.d.cp_link_tip_d;
                int i4 = r.f.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(r.j.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(ar.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ar.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(r.j.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(ar.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ar.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(r.j.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(ar.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(ar.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.o(view).ae(0).y(false);
                gVar.a(new d(baseActivity, z, spannableString, i4));
                gVar.x(true);
                gVar.z(false);
                ffC = gVar.dQ();
                new Handler().postDelayed(new f(baseActivity, z), 1000L);
                com.baidu.tbadk.core.sharedPref.b.tW().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z) {
        if (ffC != null) {
            ffC.j(activity);
        }
        if (!z) {
            new Handler().postDelayed(new g(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
