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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static com.baidu.adp.lib.guide.d fBo;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080a {
        void ld();
    }

    public static void a(BaseActivity<?> baseActivity, View view, boolean z, InterfaceC0080a interfaceC0080a) {
        int defaultBubbleEndTime;
        SpannableString spannableString;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.m9getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.m9getInst().setDefaultBubble(null);
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0080a != null) {
                    interfaceC0080a.ld();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.as(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(w.j.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.tip1);
                TextView textView2 = (TextView) inflate.findViewById(w.h.tip2);
                aq.c(textView, w.e.cp_cont_b, 1);
                aq.c(textView2, w.e.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(w.l.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(w.l.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(w.f.fontsize32));
                aVar.v(inflate);
                aVar.a(w.l.open_now, new b(baseActivity));
                aVar.b(w.l.group_create_private_isee, new c());
                aVar.b(baseActivity.getPageContext());
                aVar.tc();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = w.e.cp_cont_g;
                int i3 = w.e.cp_link_tip_d;
                int i4 = w.g.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(w.l.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(aq.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(aq.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(w.l.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(aq.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(aq.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(w.l.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(aq.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(aq.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.o(view).ad(0).z(false);
                gVar.a(new d(baseActivity, z, spannableString, i4));
                gVar.y(true);
                gVar.A(false);
                fBo = gVar.fc();
                new Handler().postDelayed(new f(baseActivity, z), 1000L);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z) {
        if (fBo != null) {
            fBo.j(activity);
        }
        if (!z) {
            new Handler().postDelayed(new g(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
