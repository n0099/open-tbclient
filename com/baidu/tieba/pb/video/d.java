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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
/* loaded from: classes2.dex */
public class d {
    public TextView fXM;
    public TextView fXN;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fXM = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fXN = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void Z(bd bdVar) {
        if (bdVar != null && bdVar.zk() != null) {
            bdVar.zC();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bdVar.zs());
            if (bdVar.zy() && !StringUtils.isNull(bdVar.getTid())) {
                final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bdVar.getTid();
                spannableStringBuilder.append((CharSequence) bdVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.pb.video.d.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                        TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3"));
                    }

                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0107d.cp_link_tip_c));
                        textPaint.setUnderlineText(false);
                    }
                }));
            }
            this.mTitleView.setOnTouchListener(new m(spannableStringBuilder));
            this.mTitleView.setText(spannableStringBuilder);
            this.mTitleView.setLinkTextColor(aj.getColor(d.C0107d.cp_link_tip_c));
            this.fXM.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), am.F(bdVar.yK())));
            this.fXN.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), am.F(bdVar.zk().play_count.intValue())));
            It();
        }
    }

    public void It() {
        aj.e(this.mTitleView, d.C0107d.cp_cont_b, 1);
        aj.e(this.fXM, d.C0107d.cp_cont_f, 1);
        aj.e(this.fXN, d.C0107d.cp_cont_f, 1);
    }
}
