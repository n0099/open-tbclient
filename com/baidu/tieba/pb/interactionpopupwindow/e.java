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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData kaA;
    private f kaB;
    private TbImageView kaC;
    private TextView kaD;
    private TextView kaE;
    private View kaF;
    private View kaG;
    private LinearLayout kaH;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.kaB = fVar;
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
            this.kaA = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.kaC.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.kaD.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.kaE.setText(customDialogData.body);
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
        this.kaC = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.kaD = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.kaE = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.kaF = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.kaG = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.kaH = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        an.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        an.setViewTextColor(this.yesButton, (int) R.color.cp_link_tip_a);
        an.setViewTextColor(this.noButton, (int) R.color.cp_link_tip_a);
        an.setViewTextColor(this.kaD, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.kaE, (int) R.color.common_color_10122);
        an.setBackgroundColor(this.kaF, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.kaG, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.kaH, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.kaA != null && this.kaA.rightButton != null && !StringUtils.isNull(this.kaA.rightButton.action)) {
                bc.aWU().b(getTbPageContext(), new String[]{this.kaA.rightButton.action});
            }
            if (this.kaB != null) {
                this.kaB.dismiss();
            }
            ao aoVar = new ao(b.a.CLICK);
            aoVar.ag("obj_locate", 2);
            TiebaStatic.log(aoVar);
        } else if (view == this.noButton) {
            if (this.kaA != null && this.kaA.leftButton != null && !StringUtils.isNull(this.kaA.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.kaA.leftButton.action, true)));
            }
            if (this.kaB != null) {
                this.kaB.dismiss();
            }
            ao aoVar2 = new ao(b.a.CLICK);
            aoVar2.ag("obj_locate", 1);
            TiebaStatic.log(aoVar2);
        }
    }
}
