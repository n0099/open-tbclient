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
    private TbImageView alx;
    private int cHv;
    private TextView dVH;
    private TextView eci;
    private TextView ecj;
    private TextView eck;
    private TextView ecl;
    private p ecm;
    private View.OnClickListener ecn;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cHv = 0;
        this.ecn = new b(this);
        view.setOnClickListener(this.ecn);
        this.dVH = (TextView) view.findViewById(t.g.title_text);
        this.eci = (TextView) view.findViewById(t.g.refresh_time);
        this.alx = (TbImageView) view.findViewById(t.g.live_cover);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.ecj = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.eck = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.eck.setVisibility(8);
        this.ecl = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(p pVar) {
        super.B(pVar);
        if (pVar != null && pVar.aMC() != null) {
            this.ecm = pVar;
            ZhiBoInfoTW aMC = pVar.aMC();
            this.dVH.setText(e(aMC.title));
            this.eci.setText(c(aMC));
            this.alx.c(aMC.livecover_src, 10, false);
            String forumName = StringUtils.isNull(aMC.forum_name) ? pVar.getForumName() : aMC.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.ecj.setVisibility(8);
            } else {
                this.ecj.setVisibility(0);
                this.ecj.setText(getContext().getString(t.j.chosen_pb_original_bar, forumName));
            }
            this.ecl.setText(ay.B(aMC.reply_num.intValue() == 0 ? pVar.aMy() : aMC.reply_num.intValue()));
            s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.od(String.valueOf(pVar.getThreadId()))) {
                this.cHv = t.d.cp_cont_c;
            } else {
                this.cHv = t.d.cp_cont_b;
            }
            at.c(this.dVH, this.cHv, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m11getInst().getString(t.j.photo_live_thread_expression_time, new Object[]{ay.x(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cA = at.cA(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
        bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cHv != 0 && this.dVH != null) {
                at.c(this.dVH, this.cHv, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
