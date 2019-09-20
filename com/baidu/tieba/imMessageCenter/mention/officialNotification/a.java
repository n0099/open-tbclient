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
    private TextView cdZ;
    private int ceL = 3;
    private HeadImageView gZX;
    private TextView gZY;
    private TbRichTextView gZZ;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.gZX = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.gZX.setIsRound(true);
        this.gZX.setOnClickListener(onClickListener);
        this.cdZ = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cdZ.setOnClickListener(onClickListener);
        this.gZY = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.gZZ = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.gZZ.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gZZ.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.gZZ.setLayoutStrategy(layoutStrategy);
        this.gZZ.setClickable(true);
        this.gZZ.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gZX.setUserId(chatMessage.getUserInfo().getUserId());
            this.gZX.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gZY.setText(aq.aF(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gZZ != null) {
                j.a(this.mPageContext.getContext(), this.gZZ, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gZZ.setContentDescription(stringBuffer.toString());
                    this.gZZ.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ceL != TbadkCoreApplication.getInst().getSkinType()) {
            am.l(this.mRootView, R.color.cp_bg_line_d);
            am.j(this.cdZ, R.color.cp_cont_f);
            am.j(this.gZY, R.color.cp_cont_d);
            this.gZZ.setTextColor(am.getColor(R.color.cp_cont_b));
            this.gZZ.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.ceL = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
