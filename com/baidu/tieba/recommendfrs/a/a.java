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
import com.baidu.tieba.recommendfrs.data.j;
import com.baidu.tieba.tbadkCore.util.q;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<j, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aoA;
    private TextView dko;
    private TextView dqC;
    private TextView dqD;
    private TextView dqE;
    private TextView dqF;
    private int dqG;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dqG = 0;
        this.dko = (TextView) view.findViewById(n.g.title_text);
        this.dqC = (TextView) view.findViewById(n.g.refresh_time);
        this.aoA = (TbImageView) view.findViewById(n.g.live_cover);
        View findViewById = view.findViewById(n.g.hot_thread_comment);
        this.dqD = (TextView) findViewById.findViewById(n.g.hot_thread_line_tag);
        this.dqE = (TextView) findViewById.findViewById(n.g.hot_thread_line_praise);
        this.dqE.setVisibility(8);
        this.dqF = (TextView) findViewById.findViewById(n.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(j jVar) {
        super.B(jVar);
        if (jVar != null && jVar.ayy() != null) {
            ZhiBoInfoTW ayy = jVar.ayy();
            this.dko.setText(e(ayy.title));
            this.dqC.setText(c(ayy));
            this.aoA.d(ayy.livecover_src, 10, false);
            String forumName = StringUtils.isNull(ayy.forum_name) ? jVar.getForumName() : ayy.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.dqD.setVisibility(8);
            } else {
                this.dqD.setVisibility(0);
                this.dqD.setText(getContext().getString(n.j.chosen_pb_original_bar, forumName));
            }
            this.dqF.setText(ax.x(ayy.reply_num.intValue() == 0 ? jVar.ayu() : ayy.reply_num.intValue()));
            q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mD(String.valueOf(jVar.getThreadId()))) {
                this.dqG = n.d.cp_cont_c;
            } else {
                this.dqG = n.d.cp_cont_b;
            }
            as.b(this.dko, this.dqG, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m411getInst().getString(n.j.photo_live_thread_expression_time, new Object[]{ax.s(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cx = as.cx(n.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
        bitmapDrawable.setBounds(0, 0, cx.getWidth(), cx.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.dqG != 0 && this.dko != null) {
                as.b(this.dko, this.dqG, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
