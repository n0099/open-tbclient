package com.baidu.tieba.recommendfrs.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendfrs.data.p;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<p, com.baidu.tbadk.mvc.d.b> {
    private TbImageView apK;
    private int cHk;
    private TextView dSP;
    private TextView dZb;
    private TextView dZc;
    private TextView dZd;
    private TextView dZe;
    private p dZf;
    private View.OnClickListener dZg;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cHk = 0;
        this.dZg = new b(this);
        view.setOnClickListener(this.dZg);
        this.dSP = (TextView) view.findViewById(t.g.title_text);
        this.dZb = (TextView) view.findViewById(t.g.refresh_time);
        this.apK = (TbImageView) view.findViewById(t.g.live_cover);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.dZc = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.dZd = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.dZd.setVisibility(8);
        this.dZe = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(p pVar) {
        super.B(pVar);
        if (pVar != null && pVar.aMr() != null) {
            this.dZf = pVar;
            ZhiBoInfoTW aMr = pVar.aMr();
            this.dSP.setText(e(aMr.title));
            this.dZb.setText(c(aMr));
            this.apK.c(aMr.livecover_src, 10, false);
            String forumName = StringUtils.isNull(aMr.forum_name) ? pVar.getForumName() : aMr.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.dZc.setVisibility(8);
            } else {
                this.dZc.setVisibility(0);
                this.dZc.setText(getContext().getString(t.j.chosen_pb_original_bar, forumName));
            }
            this.dZe.setText(ay.A(aMr.reply_num.intValue() == 0 ? pVar.aMn() : aMr.reply_num.intValue()));
            s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.oh(String.valueOf(pVar.getThreadId()))) {
                this.cHk = t.d.cp_cont_c;
            } else {
                this.cHk = t.d.cp_cont_b;
            }
            at.b(this.dSP, this.cHk, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(t.j.photo_live_thread_expression_time, new Object[]{ay.w(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cR = at.cR(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
        bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cHk != 0 && this.dSP != null) {
                at.b(this.dSP, this.cHk, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
