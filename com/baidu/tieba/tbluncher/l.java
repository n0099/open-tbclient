package com.baidu.tieba.tbluncher;

import android.widget.TextView;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
final class l extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(MainTabActivity mainTabActivity, int i) {
        super(2001124);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        TextView textView2;
        int i;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2001124) {
            return;
        }
        if (!(customResponsedMessage2 instanceof NewsNotifyMessage)) {
            com.baidu.adp.lib.util.f.b("transform error");
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage2;
        int b = newsNotifyMessage.b() + newsNotifyMessage.c() + newsNotifyMessage.i();
        if (b > 0) {
            textView2 = this.a.z;
            textView2.setVisibility(0);
            boolean z = TbadkApplication.j().l() == 1;
            textView2.setTextColor(TbadkApplication.j().b().getResources().getColor(z ? com.baidu.b.a.c.top_msg_num_night : com.baidu.b.a.c.top_msg_num_day));
            if (b < 10) {
                textView2.setText(String.valueOf(b));
                this.a.G = com.baidu.b.a.e.icon_news_head_prompt_one;
                this.a.H = com.baidu.b.a.e.icon_news_head_prompt_one_1;
            } else if (b < 100) {
                textView2.setText(String.valueOf(b));
                this.a.G = com.baidu.b.a.e.icon_news_head_prompt_two;
                this.a.H = com.baidu.b.a.e.icon_news_head_prompt_two_1;
            } else {
                textView2.setText("   ");
                this.a.G = com.baidu.b.a.e.icon_news_head_prompt_more;
                this.a.H = com.baidu.b.a.e.icon_news_head_prompt_more_1;
            }
            if (!z) {
                i = this.a.G;
            } else {
                i = this.a.H;
            }
            textView2.setBackgroundResource(i);
            return;
        }
        textView = this.a.z;
        textView.setVisibility(8);
    }
}
