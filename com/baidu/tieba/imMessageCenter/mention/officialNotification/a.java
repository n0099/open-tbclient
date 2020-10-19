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
    private int ajp = 3;
    private TextView eig;
    private HeadImageView kes;
    private TextView ket;
    private TbRichTextView keu;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kes = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kes.setIsRound(true);
        this.kes.setOnClickListener(onClickListener);
        this.kes.setPlaceHolder(1);
        this.eig = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eig.setOnClickListener(onClickListener);
        this.ket = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.keu = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.keu.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.keu.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.keu.setLayoutStrategy(layoutStrategy);
        this.keu.setClickable(true);
        this.keu.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kes.setUserId(chatMessage.getUserInfo().getUserId());
            this.kes.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.ket.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.keu != null) {
                j.a(this.mPageContext.getContext(), this.keu, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.keu.setContentDescription(stringBuffer.toString());
                    this.keu.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ajp != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.eig, R.color.cp_cont_f);
            ap.setViewTextColor(this.ket, R.color.cp_cont_d);
            this.keu.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.keu.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.ajp = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
