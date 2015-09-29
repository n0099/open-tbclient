package com.baidu.tieba.recommendfrs.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private View aJP;
    private TbImageView alz;
    private TextView cEs;
    private TextView cJo;
    private TextView cJp;
    private TextView cJq;
    private TextView cJr;

    public h(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cEs = (TextView) view.findViewById(i.f.title_text);
        this.cJo = (TextView) view.findViewById(i.f.refresh_time);
        this.alz = (TbImageView) view.findViewById(i.f.live_cover);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.cJp = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.cJq = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.cJq.setVisibility(8);
        this.cJr = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aJP = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null && bVar.aqa() != null) {
            ZhiBoInfoTW aqa = bVar.aqa();
            this.cEs.setText(d(aqa.title));
            this.cJo.setText(b(aqa));
            this.alz.d(aqa.livecover_src, 10, false);
            if (StringUtils.isNull(aqa.forum_name)) {
                this.cJp.setVisibility(8);
            } else {
                this.cJp.setVisibility(0);
                this.cJp.setText(getContext().getString(i.h.chosen_pb_original_bar, aqa.forum_name));
            }
            this.cJr.setText(ar.s(aqa.reply_num.intValue()));
            this.aJP.setVisibility(bVar.apY() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lI(String.valueOf(bVar.apV()))) {
                am.b(this.cEs, i.c.cp_cont_c, 1);
            } else {
                am.b(this.cEs, i.c.cp_cont_b, 1);
            }
        }
    }

    private String b(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(i.h.photo_live_thread_expression_time, new Object[]{ar.o(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder d(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cw = am.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), cw.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return ar.a(spannableStringBuilder);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
