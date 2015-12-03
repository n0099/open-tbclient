package com.baidu.tieba.recommendfrs.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView anq;
    private TextView deI;
    private TextView djA;
    private int djB;
    private TextView djx;
    private TextView djy;
    private TextView djz;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.djB = 0;
        this.deI = (TextView) view.findViewById(n.f.title_text);
        this.djx = (TextView) view.findViewById(n.f.refresh_time);
        this.anq = (TbImageView) view.findViewById(n.f.live_cover);
        View findViewById = view.findViewById(n.f.hot_thread_comment);
        this.djy = (TextView) findViewById.findViewById(n.f.hot_thread_line_tag);
        this.djz = (TextView) findViewById.findViewById(n.f.hot_thread_line_praise);
        this.djz.setVisibility(8);
        this.djA = (TextView) findViewById.findViewById(n.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.e eVar) {
        super.B(eVar);
        if (eVar != null && eVar.awu() != null) {
            ZhiBoInfoTW awu = eVar.awu();
            this.deI.setText(f(awu.title));
            this.djx.setText(c(awu));
            this.anq.d(awu.livecover_src, 10, false);
            String forumName = StringUtils.isNull(awu.forum_name) ? eVar.getForumName() : awu.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.djy.setVisibility(8);
            } else {
                this.djy.setVisibility(0);
                this.djy.setText(getContext().getString(n.i.chosen_pb_original_bar, forumName));
            }
            this.djA.setText(ax.w(awu.reply_num.intValue() == 0 ? eVar.awq() : awu.reply_num.intValue()));
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mF(String.valueOf(eVar.getThreadId()))) {
                this.djB = n.c.cp_cont_c;
            } else {
                this.djB = n.c.cp_cont_b;
            }
            as.b(this.deI, this.djB, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(n.i.photo_live_thread_expression_time, new Object[]{ax.s(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder f(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cE = as.cE(n.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
        bitmapDrawable.setBounds(0, 0, cE.getWidth(), cE.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        if (this.djB != 0 && this.deI != null) {
            as.b(this.deI, this.djB, 1);
        }
        return true;
    }
}
