package com.baidu.tieba.pb.video;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d {
    public TextView fMq;
    public TextView fMr;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fMq = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fMr = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void am(bb bbVar) {
        if (bbVar != null && bbVar.vC() != null) {
            bbVar.vT();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bbVar.vJ());
            if (bbVar.vP() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                spannableStringBuilder.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new an("c12841").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.mTitleView.setOnTouchListener(new k(spannableStringBuilder));
            this.mTitleView.setText(spannableStringBuilder);
            this.mTitleView.setLinkTextColor(am.getColor(d.C0140d.cp_link_tip_c));
            this.fMq.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), ap.D(bbVar.vb())));
            this.fMr.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), ap.D(bbVar.vC().play_count.intValue())));
            FG();
        }
    }

    public void FG() {
        am.c(this.mTitleView, d.C0140d.cp_cont_b, 1);
        am.c(this.fMq, d.C0140d.cp_cont_f, 1);
        am.c(this.fMr, d.C0140d.cp_cont_f, 1);
    }
}
