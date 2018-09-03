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
import com.baidu.tieba.f;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d {
    public TextView fMj;
    public TextView fMk;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(f.g.view_video_title);
            this.fMj = (TextView) this.mRootView.findViewById(f.g.pb_video_replay_num);
            this.fMk = (TextView) this.mRootView.findViewById(f.g.pb_video_play_count);
        }
    }

    public void am(bb bbVar) {
        if (bbVar != null && bbVar.vB() != null) {
            bbVar.vS();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bbVar.vI());
            if (bbVar.vO() && !StringUtils.isNull(bbVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
                spannableStringBuilder.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new an("c12841").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(f.d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.mTitleView.setOnTouchListener(new k(spannableStringBuilder));
            this.mTitleView.setText(spannableStringBuilder);
            this.mTitleView.setLinkTextColor(am.getColor(f.d.cp_link_tip_c));
            this.fMj.setText(String.format(TbadkCoreApplication.getInst().getString(f.j.pb_video_header_replay_num), ap.D(bbVar.va())));
            this.fMk.setText(String.format(TbadkCoreApplication.getInst().getString(f.j.pb_video_header_play_count), ap.D(bbVar.vB().play_count.intValue())));
            FG();
        }
    }

    public void FG() {
        am.c(this.mTitleView, f.d.cp_cont_b, 1);
        am.c(this.fMj, f.d.cp_cont_f, 1);
        am.c(this.fMk, f.d.cp_cont_f, 1);
    }
}
