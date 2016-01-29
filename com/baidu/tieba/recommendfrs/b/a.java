package com.baidu.tieba.recommendfrs.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendfrs.data.l;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.r;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<l, com.baidu.tbadk.mvc.d.b> {
    private TbImageView apt;
    private TextView dGD;
    private TextView dGE;
    private TextView dGF;
    private TextView dGG;
    private int dGH;
    private l dGI;
    private View.OnClickListener dGJ;
    private TextView dyj;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dGH = 0;
        this.dGJ = new b(this);
        view.setOnClickListener(this.dGJ);
        this.dyj = (TextView) view.findViewById(t.g.title_text);
        this.dGD = (TextView) view.findViewById(t.g.refresh_time);
        this.apt = (TbImageView) view.findViewById(t.g.live_cover);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.dGE = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.dGF = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.dGF.setVisibility(8);
        this.dGG = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(l lVar) {
        super.B(lVar);
        if (lVar != null && lVar.aFD() != null) {
            this.dGI = lVar;
            ZhiBoInfoTW aFD = lVar.aFD();
            this.dyj.setText(e(aFD.title));
            this.dGD.setText(c(aFD));
            this.apt.d(aFD.livecover_src, 10, false);
            String forumName = StringUtils.isNull(aFD.forum_name) ? lVar.getForumName() : aFD.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.dGE.setVisibility(8);
            } else {
                this.dGE.setVisibility(0);
                this.dGE.setText(getContext().getString(t.j.chosen_pb_original_bar, forumName));
            }
            this.dGG.setText(aw.y(aFD.reply_num.intValue() == 0 ? lVar.aFz() : aFD.reply_num.intValue()));
            r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mU(String.valueOf(lVar.getThreadId()))) {
                this.dGH = t.d.cp_cont_c;
            } else {
                this.dGH = t.d.cp_cont_b;
            }
            ar.b(this.dyj, this.dGH, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(t.j.photo_live_thread_expression_time, new Object[]{aw.t(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cO = ar.cO(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.dGH != 0 && this.dyj != null) {
                ar.b(this.dyj, this.dGH, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
