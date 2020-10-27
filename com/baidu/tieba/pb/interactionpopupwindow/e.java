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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData liN;
    private f liO;
    private TbImageView liP;
    private TextView liQ;
    private TextView liR;
    private View liS;
    private View liT;
    private LinearLayout liU;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.liO = fVar;
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
            this.liN = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.liP.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.liQ.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.liR.setText(customDialogData.body);
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
        this.liP = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.liQ = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.liR = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.liS = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.liT = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.liU = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ap.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ap.setViewTextColor(this.yesButton, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.noButton, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.liQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.liR, R.color.common_color_10122);
        ap.setBackgroundColor(this.liS, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.liT, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.liU, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.liN != null && this.liN.rightButton != null && !StringUtils.isNull(this.liN.rightButton.action)) {
                be.boR().b(getTbPageContext(), new String[]{this.liN.rightButton.action});
            }
            if (this.liO != null) {
                this.liO.dismiss();
            }
            aq aqVar = new aq(b.a.CLICK);
            aqVar.aj("obj_locate", 2);
            TiebaStatic.log(aqVar);
        } else if (view == this.noButton) {
            if (this.liN != null && this.liN.leftButton != null && !StringUtils.isNull(this.liN.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.liN.leftButton.action, true)));
            }
            if (this.liO != null) {
                this.liO.dismiss();
            }
            aq aqVar2 = new aq(b.a.CLICK);
            aqVar2.aj("obj_locate", 1);
            TiebaStatic.log(aqVar2);
        }
    }
}
