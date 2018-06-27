package com.baidu.tieba.pb.video;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d {
    public TextView fMc;
    public TextView fMd;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fMc = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fMd = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void al(bc bcVar) {
        if (bcVar != null && bcVar.vN() != null) {
            bcVar.we();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bcVar.vU());
            if (bcVar.wa() && !StringUtils.isNull(bcVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bcVar.getTid();
                spannableStringBuilder.append((CharSequence) bcVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new an("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0142d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.mTitleView.setOnTouchListener(new k(spannableStringBuilder));
            this.mTitleView.setText(spannableStringBuilder);
            this.mTitleView.setLinkTextColor(am.getColor(d.C0142d.cp_link_tip_c));
            this.fMc.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.pb_video_header_replay_num), ap.C(bcVar.vn())));
            this.fMd.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.pb_video_header_play_count), ap.C(bcVar.vN().play_count.intValue())));
            FK();
        }
    }

    public void FK() {
        am.c(this.mTitleView, d.C0142d.cp_cont_b, 1);
        am.c(this.fMc, d.C0142d.cp_cont_f, 1);
        am.c(this.fMd, d.C0142d.cp_cont_f, 1);
    }
}
