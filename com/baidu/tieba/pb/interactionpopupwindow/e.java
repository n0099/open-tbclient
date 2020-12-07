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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData lCC;
    private f lCD;
    private TbImageView lCE;
    private TextView lCF;
    private TextView lCG;
    private View lCH;
    private View lCI;
    private LinearLayout lCJ;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.lCD = fVar;
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
            this.lCC = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.lCE.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.lCF.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.lCG.setText(customDialogData.body);
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
        this.lCE = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.lCF = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.lCG = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.lCH = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.lCI = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.lCJ = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ap.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ap.setViewTextColor(this.yesButton, R.color.CAM_X0302);
        ap.setViewTextColor(this.noButton, R.color.CAM_X0302);
        ap.setViewTextColor(this.lCF, R.color.CAM_X0105);
        ap.setViewTextColor(this.lCG, R.color.common_color_10122);
        ap.setBackgroundColor(this.lCH, R.color.CAM_X0204);
        ap.setBackgroundColor(this.lCI, R.color.CAM_X0204);
        ap.setBackgroundResource(this.lCJ, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.lCC != null && this.lCC.rightButton != null && !StringUtils.isNull(this.lCC.rightButton.action)) {
                bf.bua().b(getTbPageContext(), new String[]{this.lCC.rightButton.action});
            }
            if (this.lCD != null) {
                this.lCD.dismiss();
            }
            ar arVar = new ar(b.a.CLICK);
            arVar.al("obj_locate", 2);
            TiebaStatic.log(arVar);
        } else if (view == this.noButton) {
            if (this.lCC != null && this.lCC.leftButton != null && !StringUtils.isNull(this.lCC.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.lCC.leftButton.action, true)));
            }
            if (this.lCD != null) {
                this.lCD.dismiss();
            }
            ar arVar2 = new ar(b.a.CLICK);
            arVar2.al("obj_locate", 1);
            TiebaStatic.log(arVar2);
        }
    }
}
