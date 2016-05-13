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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static com.baidu.adp.lib.guide.d erU;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void jm();
    }

    public static void a(BaseActivity<?> baseActivity, View view, boolean z, InterfaceC0073a interfaceC0073a) {
        int defaultBubbleEndTime;
        SpannableString spannableString;
        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.m11getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.m11getInst().setDefaultBubble(null);
                TbadkCoreApplication.m11getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0073a != null) {
                    interfaceC0073a.jm();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.aq(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(t.h.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(t.g.tip1);
                TextView textView2 = (TextView) inflate.findViewById(t.g.tip2);
                at.c(textView, t.d.cp_cont_b, 1);
                at.c(textView2, t.d.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(t.j.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(t.j.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(t.e.fontsize32));
                aVar.z(inflate);
                aVar.a(t.j.open_now, new b(baseActivity));
                aVar.b(t.j.group_create_private_isee, new c());
                aVar.b(baseActivity.getPageContext());
                aVar.rV();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.sR().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = t.d.cp_cont_g;
                int i3 = t.d.cp_link_tip_d;
                int i4 = t.f.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(t.j.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(at.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(at.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(t.j.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(at.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(at.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(t.j.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(at.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(at.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.o(view).N(0).u(false);
                gVar.a(new d(baseActivity, z, spannableString, i4));
                gVar.t(true);
                gVar.v(false);
                erU = gVar.cV();
                new Handler().postDelayed(new f(baseActivity, z), 300L);
                com.baidu.tbadk.core.sharedPref.b.sR().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z) {
        if (erU != null) {
            erU.d(activity);
        }
        if (!z) {
            new Handler().postDelayed(new g(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
