package com.baidu.tieba.pb.video;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.view.j;
/* loaded from: classes2.dex */
public class d {
    public TextView fwG;
    public TextView fwH;
    public View mRootView;
    public TextView mTitleView;

    public d(View view2) {
        if (view2 != null) {
            this.mRootView = view2;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fwG = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fwH = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void ae(bd bdVar) {
        if (bdVar != null && bdVar.sg() != null) {
            bdVar.sx();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bdVar.sn());
            if (bdVar.st() && !StringUtils.isNull(bdVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bdVar.getTid();
                spannableStringBuilder.append((CharSequence) bdVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new al("c12841").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0126d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.mTitleView.setOnTouchListener(new j(spannableStringBuilder));
            this.mTitleView.setText(spannableStringBuilder);
            this.mTitleView.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            this.fwG.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.pb_video_header_replay_num), an.y(bdVar.rH())));
            this.fwH.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.pb_video_header_play_count), an.y(bdVar.sg().play_count.intValue())));
            BP();
        }
    }

    public void BP() {
        ak.c(this.mTitleView, d.C0126d.cp_cont_b, 1);
        ak.c(this.fwG, d.C0126d.cp_cont_f, 1);
        ak.c(this.fwH, d.C0126d.cp_cont_f, 1);
    }
}
