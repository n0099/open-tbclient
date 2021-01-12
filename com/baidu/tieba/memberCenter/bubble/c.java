package com.baidu.tieba.memberCenter.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import java.util.Date;
/* loaded from: classes8.dex */
public class c {

    /* loaded from: classes8.dex */
    public interface a {
        void DW(int i);

        void dcS();
    }

    public static void a(TbPageContext<?> tbPageContext, final BubbleListData.BubbleData bubbleData, final a aVar) {
        if (bubbleData != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar2.jE(false);
            Date date = new Date();
            Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
            String dateStringDay = at.getDateStringDay(date);
            String dateStringDay2 = at.getDateStringDay(date2);
            String format = String.format(tbPageContext.getResources().getString(R.string.bubble_free_dialog_text), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
            View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tip1);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
            ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView2, R.color.CAM_X0108, 1);
            textView.setText(format);
            textView2.setText(dateStringDay + tbPageContext.getString(R.string.to) + dateStringDay2);
            aVar2.br(inflate);
            aVar2.a(R.string.use_immediately, new a.b() { // from class: com.baidu.tieba.memberCenter.bubble.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    if (a.this != null) {
                        a.this.DW(bubbleData.getBcode());
                    }
                }
            });
            aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.memberCenter.bubble.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    if (a.this != null) {
                        a.this.dcS();
                    }
                }
            });
            aVar2.b(tbPageContext);
            aVar2.bqe();
        }
    }

    public static void b(TbPageContext<?> tbPageContext, final BubbleListData.BubbleData bubbleData, final a aVar) {
        if (bubbleData != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar2.jE(false);
            aVar2.Ad(String.format(tbPageContext.getString(R.string.bubble_pay_dialog_text), bubbleData.getLevel_name()));
            aVar2.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.memberCenter.bubble.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    if (a.this != null) {
                        a.this.DW(bubbleData.getBcode());
                    }
                }
            });
            aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.memberCenter.bubble.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    if (a.this != null) {
                        a.this.dcS();
                    }
                }
            });
            aVar2.b(tbPageContext);
            aVar2.bqe();
        }
    }
}
