package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.h;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int aln = 3;
    private TextView eKp;
    private TbRichTextView jwP;
    private HeadImageView kVP;
    private TextView kVQ;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kVP = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kVP.setIsRound(true);
        this.kVP.setOnClickListener(onClickListener);
        this.kVP.setPlaceHolder(1);
        this.eKp = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eKp.setOnClickListener(onClickListener);
        this.kVQ = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jwP = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jwP.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jwP.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jwP.setLayoutStrategy(layoutStrategy);
        this.jwP.setClickable(true);
        this.jwP.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kVP.setUserId(chatMessage.getUserInfo().getUserId());
            this.kVP.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kVQ.setText(au.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jwP != null) {
                h.a(this.mPageContext.getContext(), this.jwP, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jwP.setContentDescription(stringBuffer.toString());
                    this.jwP.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aln != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eKp, R.color.CAM_X0106);
            ap.setViewTextColor(this.kVQ, R.color.CAM_X0109);
            this.jwP.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwP.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            this.aln = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
