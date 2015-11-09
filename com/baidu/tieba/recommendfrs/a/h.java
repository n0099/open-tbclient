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
    private View aIU;
    private TbImageView alF;
    private TextView cFZ;
    private TextView cLj;
    private TextView cLk;
    private TextView cLl;
    private TextView cLm;

    public h(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cFZ = (TextView) view.findViewById(i.f.title_text);
        this.cLj = (TextView) view.findViewById(i.f.refresh_time);
        this.alF = (TbImageView) view.findViewById(i.f.live_cover);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.cLk = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.cLl = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.cLl.setVisibility(8);
        this.cLm = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aIU = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null && bVar.aqI() != null) {
            ZhiBoInfoTW aqI = bVar.aqI();
            this.cFZ.setText(d(aqI.title));
            this.cLj.setText(b(aqI));
            this.alF.d(aqI.livecover_src, 10, false);
            if (StringUtils.isNull(aqI.forum_name)) {
                this.cLk.setVisibility(8);
            } else {
                this.cLk.setVisibility(0);
                this.cLk.setText(getContext().getString(i.h.chosen_pb_original_bar, aqI.forum_name));
            }
            this.cLm.setText(as.q(aqI.reply_num.intValue()));
            this.aIU.setVisibility(bVar.aqG() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(bVar.aqD()))) {
                an.b(this.cFZ, i.c.cp_cont_c, 1);
            } else {
                an.b(this.cFZ, i.c.cp_cont_b, 1);
            }
        }
    }

    private String b(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(i.h.photo_live_thread_expression_time, new Object[]{as.m(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
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
