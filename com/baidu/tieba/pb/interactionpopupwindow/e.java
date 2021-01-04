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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData lHK;
    private f lHL;
    private TbImageView lHM;
    private TextView lHN;
    private TextView lHO;
    private View lHP;
    private View lHQ;
    private LinearLayout lHR;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.lHL = fVar;
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
            this.lHK = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.lHM.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.lHN.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.lHO.setText(customDialogData.body);
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
        this.lHM = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.lHN = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.lHO = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.lHP = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.lHQ = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.lHR = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ao.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ao.setViewTextColor(this.yesButton, R.color.CAM_X0302);
        ao.setViewTextColor(this.noButton, R.color.CAM_X0302);
        ao.setViewTextColor(this.lHN, R.color.CAM_X0105);
        ao.setViewTextColor(this.lHO, R.color.common_color_10122);
        ao.setBackgroundColor(this.lHP, R.color.CAM_X0204);
        ao.setBackgroundColor(this.lHQ, R.color.CAM_X0204);
        ao.setBackgroundResource(this.lHR, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.lHK != null && this.lHK.rightButton != null && !StringUtils.isNull(this.lHK.rightButton.action)) {
                be.bwu().b(getTbPageContext(), new String[]{this.lHK.rightButton.action});
            }
            if (this.lHL != null) {
                this.lHL.dismiss();
            }
            aq aqVar = new aq(b.a.CLICK);
            aqVar.an("obj_locate", 2);
            TiebaStatic.log(aqVar);
        } else if (view == this.noButton) {
            if (this.lHK != null && this.lHK.leftButton != null && !StringUtils.isNull(this.lHK.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.lHK.leftButton.action, true)));
            }
            if (this.lHL != null) {
                this.lHL.dismiss();
            }
            aq aqVar2 = new aq(b.a.CLICK);
            aqVar2.an("obj_locate", 1);
            TiebaStatic.log(aqVar2);
        }
    }
}
