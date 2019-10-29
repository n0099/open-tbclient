package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int csX = 3;
    private TextView csn;
    private HeadImageView gXZ;
    private TextView gYa;
    private TbRichTextView gYb;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.gXZ = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.gXZ.setIsRound(true);
        this.gXZ.setOnClickListener(onClickListener);
        this.csn = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.csn.setOnClickListener(onClickListener);
        this.gYa = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.gYb = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.gYb.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gYb.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.gYb.setLayoutStrategy(layoutStrategy);
        this.gYb.setClickable(true);
        this.gYb.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gXZ.setUserId(chatMessage.getUserInfo().getUserId());
            this.gXZ.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gYa.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gYb != null) {
                j.a(this.mPageContext.getContext(), this.gYb, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gYb.setContentDescription(stringBuffer.toString());
                    this.gYb.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.csX != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.csn, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gYa, (int) R.color.cp_cont_d);
            this.gYb.setTextColor(am.getColor(R.color.cp_cont_b));
            this.gYb.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.csX = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
