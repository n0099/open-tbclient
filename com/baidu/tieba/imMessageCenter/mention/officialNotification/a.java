package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView ayV;
    private int azF = 3;
    private HeadImageView eJm;
    private TextView eJn;
    private TbRichTextView eJo;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.official_notification_text_item, viewGroup, false);
        this.eJm = (HeadImageView) this.mRootView.findViewById(f.g.iv_head);
        this.eJm.setIsRound(true);
        this.eJm.setOnClickListener(onClickListener);
        this.ayV = (TextView) this.mRootView.findViewById(f.g.tv_user_name);
        this.ayV.setOnClickListener(onClickListener);
        this.eJn = (TextView) this.mRootView.findViewById(f.g.tv_date);
        this.eJo = (TbRichTextView) this.mRootView.findViewById(f.g.tv_content);
        this.eJo.setTextSize(tbPageContext.getResources().getDimension(f.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eJo.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(f.e.tbds12), 1.0f);
        this.eJo.setLayoutStrategy(layoutStrategy);
        this.eJo.setClickable(true);
        this.eJo.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(f.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eJm.setUserId(chatMessage.getUserInfo().getUserId());
            this.eJm.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eJn.setText(ap.y(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eJo != null) {
                j.a(this.mPageContext.getContext(), this.eJo, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eJo.setContentDescription(stringBuffer.toString());
                    this.eJo.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.azF != TbadkCoreApplication.getInst().getSkinType()) {
            am.j(this.mRootView, f.d.cp_bg_line_d);
            am.h(this.ayV, f.d.cp_cont_f);
            am.h(this.eJn, f.d.cp_cont_d);
            this.eJo.setTextColor(am.getColor(f.d.cp_cont_b));
            this.eJo.setLinkTextColor(am.getColor(f.d.cp_link_tip_c));
            am.j(this.mBottomLine, f.d.cp_bg_line_c);
            this.azF = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
