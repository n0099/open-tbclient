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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static c jhB;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0518a {
        void onRefresh();
    }

    public static void a(final BaseActivity<?> baseActivity, View view, final boolean z, InterfaceC0518a interfaceC0518a) {
        int defaultBubbleEndTime;
        final SpannableString spannableString;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && (defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime()) > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, baseActivity.getPageContext());
                TbadkCoreApplication.getInst().setDefaultBubble(null);
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
                if (interfaceC0518a != null) {
                    interfaceC0518a.onRefresh();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
                aVar.eh(false);
                View inflate = LayoutInflater.from(baseActivity.getPageContext().getPageActivity()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tip1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
                textView.setText(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_ended_tip));
                textView2.setText(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_ended_tip2));
                textView2.setTextSize(0, baseActivity.getResources().getDimensionPixelSize(R.dimen.fontsize32));
                aVar.aM(inflate);
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BaseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "remind");
                        memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    }
                });
                aVar.b(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TiebaStatic.log(TbadkCoreStatisticKey.REMIND_EXPIRED);
                    }
                });
                aVar.b(baseActivity.getPageContext());
                aVar.akO();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != b.alR().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_g)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_g)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(baseActivity.getPageContext().getPageActivity().getString(R.string.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_g)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)), 10, 14, 34);
                }
                d dVar = new d();
                dVar.y(view).I(0).B(false);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.tbadkCore.b.a.3
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
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
                        textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.pop_float_arrow), (Drawable) null);
                        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.b.a.3.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.jhB != null) {
                                    a.jhB.dismiss();
                                }
                                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BaseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "expiring");
                                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                            }
                        });
                        return textView3;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getAnchor() {
                        return z ? 4 : 2;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getFitPosition() {
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
                dVar.A(true);
                dVar.C(false);
                jhB = dVar.fu();
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.j(BaseActivity.this.getPageContext().getPageActivity(), z);
                    }
                }, 1000L);
                b.alR().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Activity activity, boolean z) {
        if (jhB != null) {
            jhB.show(activity);
        }
        if (!z) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.jhB != null) {
                        a.jhB.dismiss();
                    }
                }
            }, 5000L);
        }
    }
}
