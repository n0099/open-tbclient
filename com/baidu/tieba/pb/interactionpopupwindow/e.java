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
    private CustomDialogData lOk;
    private f lOl;
    private TbImageView lOm;
    private TextView lOn;
    private TextView lOo;
    private View lOp;
    private View lOq;
    private LinearLayout lOr;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.lOl = fVar;
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
            this.lOk = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.lOm.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.lOn.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.lOo.setText(customDialogData.body);
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
        this.lOm = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.lOn = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.lOo = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.lOp = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.lOq = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.lOr = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ap.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ap.setViewTextColor(this.yesButton, R.color.CAM_X0302);
        ap.setViewTextColor(this.noButton, R.color.CAM_X0302);
        ap.setViewTextColor(this.lOn, R.color.CAM_X0105);
        ap.setViewTextColor(this.lOo, R.color.common_color_10122);
        ap.setBackgroundColor(this.lOp, R.color.CAM_X0204);
        ap.setBackgroundColor(this.lOq, R.color.CAM_X0204);
        ap.setBackgroundResource(this.lOr, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.lOk != null && this.lOk.rightButton != null && !StringUtils.isNull(this.lOk.rightButton.action)) {
                bf.bsY().b(getTbPageContext(), new String[]{this.lOk.rightButton.action});
            }
            if (this.lOl != null) {
                this.lOl.dismiss();
            }
            ar arVar = new ar(b.a.CLICK);
            arVar.aq("obj_locate", 2);
            TiebaStatic.log(arVar);
        } else if (view == this.noButton) {
            if (this.lOk != null && this.lOk.leftButton != null && !StringUtils.isNull(this.lOk.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.lOk.leftButton.action, true)));
            }
            if (this.lOl != null) {
                this.lOl.dismiss();
            }
            ar arVar2 = new ar(b.a.CLICK);
            arVar2.aq("obj_locate", 1);
            TiebaStatic.log(arVar2);
        }
    }
}
