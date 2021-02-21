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
    private int ajU = 3;
    private TextView eIO;
    private TbRichTextView jvg;
    private HeadImageView kTN;
    private TextView kTO;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kTN = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kTN.setIsRound(true);
        this.kTN.setOnClickListener(onClickListener);
        this.kTN.setPlaceHolder(1);
        this.eIO = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eIO.setOnClickListener(onClickListener);
        this.kTO = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jvg = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jvg.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jvg.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jvg.setLayoutStrategy(layoutStrategy);
        this.jvg.setClickable(true);
        this.jvg.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kTN.setUserId(chatMessage.getUserInfo().getUserId());
            this.kTN.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kTO.setText(au.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jvg != null) {
                h.a(this.mPageContext.getContext(), this.jvg, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jvg.setContentDescription(stringBuffer.toString());
                    this.jvg.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ajU != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eIO, R.color.CAM_X0106);
            ap.setViewTextColor(this.kTO, R.color.CAM_X0109);
            this.jvg.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jvg.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            this.ajU = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
