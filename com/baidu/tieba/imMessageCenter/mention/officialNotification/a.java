package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes9.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int ahx = 3;
    private TextView dEL;
    private HeadImageView jji;
    private TextView jjj;
    private TbRichTextView jjk;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.jji = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.jji.setIsRound(true);
        this.jji.setOnClickListener(onClickListener);
        this.jji.setPlaceHolder(1);
        this.dEL = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.dEL.setOnClickListener(onClickListener);
        this.jjj = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jjk = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jjk.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jjk.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jjk.setLayoutStrategy(layoutStrategy);
        this.jjk.setClickable(true);
        this.jjk.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.jji.setUserId(chatMessage.getUserInfo().getUserId());
            this.jji.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.jjj.setText(ar.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jjk != null) {
                j.a(this.mPageContext.getContext(), this.jjk, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jjk.setContentDescription(stringBuffer.toString());
                    this.jjk.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ahx != TbadkCoreApplication.getInst().getSkinType()) {
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            an.setViewTextColor(this.dEL, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.jjj, (int) R.color.cp_cont_d);
            this.jjk.setTextColor(an.getColor(R.color.cp_cont_b));
            this.jjk.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.ahx = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
