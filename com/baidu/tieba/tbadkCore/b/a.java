package com.baidu.tieba.tbadkCore.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.guide.c;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static c giT;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0119a {
        void li();
    }

    public static void a(final BaseActivity<?> baseActivity, View view, final boolean z, InterfaceC0119a interfaceC0119a) {
        int defaultBubbleEndTime;
        final SpannableString spannableString;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.getInst().setDefaultBubble(null);
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0119a != null) {
                    interfaceC0119a.li();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.as(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(d.j.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tip1);
                TextView textView2 = (TextView) inflate.findViewById(d.h.tip2);
                ai.c(textView, d.e.cp_cont_b, 1);
                ai.c(textView2, d.e.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(d.l.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(d.l.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(d.f.fontsize32));
                aVar.v(inflate);
                aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) BaseActivity.this.getPageContext().getPageActivity(), true, 23004, "remind")));
                    }
                });
                aVar.b(d.l.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TiebaStatic.log("remind_expired");
                    }
                });
                aVar.b(baseActivity.getPageContext());
                aVar.ts();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != b.getInstance().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                int i2 = d.e.cp_cont_g;
                int i3 = d.e.cp_link_tip_d;
                final int i4 = d.g.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(d.l.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(ai.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ai.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(d.l.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(ai.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ai.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(d.l.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(ai.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(ai.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).ag(0).z(false);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.tbadkCore.b.a.3
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView3 = new TextView(BaseActivity.this.getPageContext().getPageActivity());
                        if (z) {
                            textView3.setBackgroundResource(d.g.pop_float_top);
                        } else {
                            textView3.setBackgroundResource(d.g.pop_float);
                        }
                        int dimensionPixelSize = BaseActivity.this.getResources().getDimensionPixelSize(d.f.ds32);
                        int dimensionPixelSize2 = BaseActivity.this.getResources().getDimensionPixelSize(d.f.ds22);
                        if (z) {
                            textView3.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                        } else {
                            textView3.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
                        }
                        textView3.setGravity(17);
                        textView3.setText(spannableString);
                        textView3.setCompoundDrawablePadding(dimensionPixelSize);
                        textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(i4), (Drawable) null);
                        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.b.a.3.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.giT != null) {
                                    a.giT.dismiss();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) BaseActivity.this.getPageContext().getPageActivity(), true, 23004, "expiring")));
                            }
                        });
                        return textView3;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int fi() {
                        return z ? 4 : 2;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int fj() {
                        return z ? 32 : 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return z ? 0 : 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return z ? 5 : 30;
                    }
                });
                dVar.y(true);
                dVar.A(false);
                giT = dVar.fk();
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.b(BaseActivity.this.getPageContext().getPageActivity(), z);
                    }
                }, 1000L);
                b.getInstance().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z) {
        if (giT != null) {
            giT.j(activity);
        }
        if (!z) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.giT != null) {
                        a.giT.dismiss();
                    }
                }
            }, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
