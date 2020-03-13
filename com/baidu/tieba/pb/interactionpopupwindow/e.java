package com.baidu.tieba.pb.interactionpopupwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData iDp;
    private f iDq;
    private TbImageView iDr;
    private TextView iDs;
    private TextView iDt;
    private View iDu;
    private View iDv;
    private LinearLayout iDw;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.iDq = fVar;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public int getLayout() {
        return R.layout.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    /* renamed from: b */
    public void a(CustomDialogData customDialogData) {
        if (customDialogData != null) {
            this.iDp = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.iDr.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.iDs.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.iDt.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.noButton.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.yesButton.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.iDr = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.iDs = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.iDt = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.iDu = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.iDv = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.iDw = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        am.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        am.setViewTextColor(this.yesButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.noButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.iDs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iDt, (int) R.color.common_color_10122);
        am.setBackgroundColor(this.iDu, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.iDv, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.iDw, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.iDp != null && this.iDp.rightButton != null && !StringUtils.isNull(this.iDp.rightButton.action)) {
                ba.aGG().b(getTbPageContext(), new String[]{this.iDp.rightButton.action});
            }
            if (this.iDq != null) {
                this.iDq.dismiss();
            }
            an anVar = new an(b.a.izO);
            anVar.X("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.noButton) {
            if (this.iDp != null && this.iDp.leftButton != null && !StringUtils.isNull(this.iDp.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.iDp.leftButton.action, true)));
            }
            if (this.iDq != null) {
                this.iDq.dismiss();
            }
            an anVar2 = new an(b.a.izO);
            anVar2.X("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
