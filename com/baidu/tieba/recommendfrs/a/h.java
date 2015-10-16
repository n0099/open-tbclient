package com.baidu.tieba.recommendfrs.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private View aKa;
    private TbImageView alA;
    private TextView cED;
    private TextView cJN;
    private TextView cJO;
    private TextView cJP;
    private TextView cJQ;

    public h(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cED = (TextView) view.findViewById(i.f.title_text);
        this.cJN = (TextView) view.findViewById(i.f.refresh_time);
        this.alA = (TbImageView) view.findViewById(i.f.live_cover);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.cJO = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.cJP = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.cJP.setVisibility(8);
        this.cJQ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKa = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null && bVar.aqg() != null) {
            ZhiBoInfoTW aqg = bVar.aqg();
            this.cED.setText(d(aqg.title));
            this.cJN.setText(b(aqg));
            this.alA.d(aqg.livecover_src, 10, false);
            if (StringUtils.isNull(aqg.forum_name)) {
                this.cJO.setVisibility(8);
            } else {
                this.cJO.setVisibility(0);
                this.cJO.setText(getContext().getString(i.h.chosen_pb_original_bar, aqg.forum_name));
            }
            this.cJQ.setText(as.s(aqg.reply_num.intValue()));
            this.aKa.setVisibility(bVar.aqe() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lL(String.valueOf(bVar.aqb()))) {
                an.b(this.cED, i.c.cp_cont_c, 1);
            } else {
                an.b(this.cED, i.c.cp_cont_b, 1);
            }
        }
    }

    private String b(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(i.h.photo_live_thread_expression_time, new Object[]{as.o(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder d(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cw = an.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), cw.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return as.a(spannableStringBuilder);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
