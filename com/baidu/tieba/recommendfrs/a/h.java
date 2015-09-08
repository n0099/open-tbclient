package com.baidu.tieba.recommendfrs.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private View aKX;
    private TbImageView anb;
    private TextView cCn;
    private TextView cCo;
    private TextView cCp;
    private TextView cCq;
    private TextView cxK;

    public h(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cxK = (TextView) view.findViewById(i.f.title_text);
        this.cCn = (TextView) view.findViewById(i.f.refresh_time);
        this.anb = (TbImageView) view.findViewById(i.f.live_cover);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.cCo = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.cCp = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.cCp.setVisibility(8);
        this.cCq = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKX = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null && bVar.anI() != null) {
            ZhiBoInfoTW anI = bVar.anI();
            this.cxK.setText(d(anI.title));
            this.cCn.setText(b(anI));
            this.anb.d(anI.livecover_src, 10, false);
            if (StringUtils.isNull(anI.forum_name)) {
                this.cCo.setVisibility(8);
            } else {
                this.cCo.setVisibility(0);
                this.cCo.setText(getContext().getString(i.h.chosen_pb_original_bar, anI.forum_name));
            }
            this.cCq.setText(aq.o(anI.reply_num.intValue()));
            this.aKX.setVisibility(bVar.anG() ? 0 : 4);
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(bVar.anD()))) {
                al.b(this.cxK, i.c.cp_cont_c, 1);
            } else {
                al.b(this.cxK, i.c.cp_cont_b, 1);
            }
        }
    }

    private String b(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(i.h.photo_live_thread_expression_time, new Object[]{aq.m(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder d(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cu = al.cu(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cu);
        bitmapDrawable.setBounds(0, 0, cu.getWidth(), cu.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return aq.a(spannableStringBuilder);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
