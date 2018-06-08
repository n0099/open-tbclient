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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d {
    public TextView fIa;
    public TextView fIb;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fIa = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fIb = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void ag(bd bdVar) {
        if (bdVar != null && bdVar.vD() != null) {
            bdVar.vU();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bdVar.vK());
            if (bdVar.vQ() && !StringUtils.isNull(bdVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bdVar.getTid();
                spannableStringBuilder.append((CharSequence) bdVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new am("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.mTitleView.setOnTouchListener(new k(spannableStringBuilder));
            this.mTitleView.setText(spannableStringBuilder);
            this.mTitleView.setLinkTextColor(al.getColor(d.C0141d.cp_link_tip_c));
            this.fIa.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.pb_video_header_replay_num), ao.B(bdVar.ve())));
            this.fIb.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.pb_video_header_play_count), ao.B(bdVar.vD().play_count.intValue())));
            Fs();
        }
    }

    public void Fs() {
        al.c(this.mTitleView, d.C0141d.cp_cont_b, 1);
        al.c(this.fIa, d.C0141d.cp_cont_f, 1);
        al.c(this.fIb, d.C0141d.cp_cont_f, 1);
    }
}
