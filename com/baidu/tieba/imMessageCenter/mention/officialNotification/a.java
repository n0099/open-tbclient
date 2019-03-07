package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView bTX;
    private int bUJ = 3;
    private HeadImageView gzW;
    private TextView gzX;
    private TbRichTextView gzY;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.official_notification_text_item, viewGroup, false);
        this.gzW = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.gzW.setIsRound(true);
        this.gzW.setOnClickListener(onClickListener);
        this.bTX = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.bTX.setOnClickListener(onClickListener);
        this.gzX = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.gzY = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.gzY.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gzY.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.gzY.setLayoutStrategy(layoutStrategy);
        this.gzY.setClickable(true);
        this.gzY.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gzW.setUserId(chatMessage.getUserInfo().getUserId());
            this.gzW.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gzX.setText(ap.aq(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gzY != null) {
                j.a(this.mPageContext.getContext(), this.gzY, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gzY.setContentDescription(stringBuffer.toString());
                    this.gzY.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bUJ != TbadkCoreApplication.getInst().getSkinType()) {
            al.l(this.mRootView, d.C0236d.cp_bg_line_d);
            al.j(this.bTX, d.C0236d.cp_cont_f);
            al.j(this.gzX, d.C0236d.cp_cont_d);
            this.gzY.setTextColor(al.getColor(d.C0236d.cp_cont_b));
            this.gzY.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
            al.l(this.mBottomLine, d.C0236d.cp_bg_line_c);
            this.bUJ = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
