package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes22.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int ajq = 3;
    private TextView eqE;
    private HeadImageView kqR;
    private TextView kqS;
    private TbRichTextView kqT;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kqR = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kqR.setIsRound(true);
        this.kqR.setOnClickListener(onClickListener);
        this.kqR.setPlaceHolder(1);
        this.eqE = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eqE.setOnClickListener(onClickListener);
        this.kqS = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.kqT = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.kqT.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.kqT.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.kqT.setLayoutStrategy(layoutStrategy);
        this.kqT.setClickable(true);
        this.kqT.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kqR.setUserId(chatMessage.getUserInfo().getUserId());
            this.kqR.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kqS.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.kqT != null) {
                j.a(this.mPageContext.getContext(), this.kqT, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.kqT.setContentDescription(stringBuffer.toString());
                    this.kqT.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ajq != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.eqE, R.color.cp_cont_f);
            ap.setViewTextColor(this.kqS, R.color.cp_cont_d);
            this.kqT.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.kqT.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.ajq = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
