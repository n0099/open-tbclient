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
import com.baidu.adp.lib.guide.d;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static c iXT;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0407a {
        void onRefresh();
    }

    public static void a(final BaseActivity<?> baseActivity, View view, final boolean z, InterfaceC0407a interfaceC0407a) {
        int defaultBubbleEndTime;
        final SpannableString spannableString;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(2001283, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.getInst().setDefaultBubble(null);
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0407a != null) {
                    interfaceC0407a.onRefresh();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.dN(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tip1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
                al.f(textView, R.color.cp_cont_b, 1);
                al.f(textView2, R.color.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(R.dimen.fontsize32));
                aVar.aF(inflate);
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BaseActivity.this.getPageContext().getPageActivity(), true, 23004, "remind");
                        memberPayActivityConfig.setReferPageClickZone("posting_V8.9", "bubble_pop_ups_opende/renewalfee_button_V8.9");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    }
                });
                aVar.b(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TiebaStatic.log("remind_expired");
                    }
                });
                aVar.b(baseActivity.getPageContext());
                aVar.afG();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != b.agM().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_cont_g)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_cont_g)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_cont_g)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)), 10, 14, 34);
                }
                d dVar = new d();
                dVar.y(view).X(0).U(false);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.tbadkCore.b.a.3
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        TextView textView3 = new TextView(BaseActivity.this.getPageContext().getPageActivity());
                        if (z) {
                            textView3.setBackgroundResource(R.drawable.pop_float_top);
                        } else {
                            textView3.setBackgroundResource(R.drawable.pop_float);
                        }
                        int dimensionPixelSize = BaseActivity.this.getResources().getDimensionPixelSize(R.dimen.ds32);
                        int dimensionPixelSize2 = BaseActivity.this.getResources().getDimensionPixelSize(R.dimen.ds22);
                        if (z) {
                            textView3.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                        } else {
                            textView3.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
                        }
                        textView3.setGravity(17);
                        textView3.setText(spannableString);
                        textView3.setCompoundDrawablePadding(dimensionPixelSize);
                        textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.pop_float_arrow), (Drawable) null);
                        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.b.a.3.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.iXT != null) {
                                    a.iXT.dismiss();
                                }
                                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BaseActivity.this.getPageContext().getPageActivity(), true, 23004, "expiring");
                                memberPayActivityConfig.setReferPageClickZone("posting_V8.9", "bubble_pop_ups_opende/renewalfee_button_V8.9");
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                            }
                        });
                        return textView3;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hJ() {
                        return z ? 4 : 2;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hK() {
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
                dVar.T(true);
                dVar.V(false);
                iXT = dVar.hL();
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.i(BaseActivity.this.getPageContext().getPageActivity(), z);
                    }
                }, 1000L);
                b.agM().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Activity activity, boolean z) {
        if (iXT != null) {
            iXT.n(activity);
        }
        if (!z) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.iXT != null) {
                        a.iXT.dismiss();
                    }
                }
            }, 5000L);
        }
    }
}
