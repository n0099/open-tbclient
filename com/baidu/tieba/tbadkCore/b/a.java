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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static c nwh;

    /* renamed from: com.baidu.tieba.tbadkCore.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0872a {
        void onRefresh();
    }

    public static void a(final TbPageContext tbPageContext, View view, final boolean z, InterfaceC0872a interfaceC0872a) {
        final SpannableString spannableString;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class)) {
            long defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime();
            if (defaultBubbleEndTime > 0) {
                long currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (currentTimeMillis >= defaultBubbleEndTime) {
                    MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RESET_BUBBLE, TbPageContext.class, tbPageContext);
                    TbadkCoreApplication.getInst().setDefaultBubble(null);
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
                    if (interfaceC0872a != null) {
                        interfaceC0872a.onRefresh();
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                    aVar.jG(false);
                    View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.tip1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
                    ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                    textView.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip));
                    textView2.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip2));
                    textView2.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize32));
                    aVar.bn(inflate);
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.tbadkCore.b.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) TbPageContext.this.getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "remind");
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
                    aVar.b(tbPageContext);
                    aVar.bqx();
                    return;
                }
                long j = (defaultBubbleEndTime - currentTimeMillis) / 86400;
                if (j <= 3 && j >= 0 && System.currentTimeMillis() / 86400000 != b.brQ().getLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    int i = R.color.CAM_X0111;
                    int i2 = R.color.CAM_X0305;
                    final int i3 = R.drawable.pop_float_arrow;
                    if (j == 0) {
                        if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                            spannableString = new SpannableString(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip_today));
                            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i)), 0, spannableString.length(), 34);
                            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i2)), 9, 13, 34);
                        } else {
                            spannableString = new SpannableString(String.format(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip), 1));
                            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i)), 0, spannableString.length(), 34);
                            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i2)), 10, 14, 34);
                        }
                    } else {
                        spannableString = new SpannableString(String.format(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip), Long.valueOf(j)));
                        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(i2)), 10, 14, 34);
                    }
                    d dVar = new d();
                    dVar.y(view).an(0).ac(false);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.tbadkCore.b.a.3
                        @Override // com.baidu.adp.lib.guide.b
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView3 = new TextView(TbPageContext.this.getPageActivity());
                            if (z) {
                                textView3.setBackgroundResource(R.drawable.pop_float_top);
                            } else {
                                textView3.setBackgroundResource(R.drawable.pop_float);
                            }
                            int dimensionPixelSize = TbPageContext.this.getResources().getDimensionPixelSize(R.dimen.ds32);
                            int dimensionPixelSize2 = TbPageContext.this.getResources().getDimensionPixelSize(R.dimen.ds22);
                            if (z) {
                                textView3.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                            } else {
                                textView3.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
                            }
                            textView3.setGravity(17);
                            textView3.setText(spannableString);
                            textView3.setCompoundDrawablePadding(dimensionPixelSize);
                            textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i3), (Drawable) null);
                            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.b.a.3.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (a.nwh != null) {
                                        a.nwh.dismiss();
                                    }
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) TbPageContext.this.getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "expiring");
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
                    dVar.ab(true);
                    dVar.ad(false);
                    nwh = dVar.lF();
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.l(TbPageContext.this.getPageActivity(), z);
                        }
                    }, 1000L);
                    b.brQ().putLong("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Activity activity, boolean z) {
        if (nwh != null) {
            nwh.show(activity);
        }
        if (!z) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.nwh != null) {
                        a.nwh.dismiss();
                    }
                }
            }, 5000L);
        }
    }
}
