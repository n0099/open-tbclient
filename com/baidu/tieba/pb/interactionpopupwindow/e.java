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
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData ixE;
    private f ixF;
    private TbImageView ixG;
    private TextView ixH;
    private TextView ixI;
    private View ixJ;
    private View ixK;
    private LinearLayout ixL;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.ixF = fVar;
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
            this.ixE = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.ixG.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.ixH.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.ixI.setText(customDialogData.body);
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
        this.ixG = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.ixH = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.ixI = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.ixJ = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.ixK = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.ixL = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        am.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        am.setViewTextColor(this.yesButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.noButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.ixH, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ixI, (int) R.color.common_color_10122);
        am.setBackgroundColor(this.ixJ, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.ixK, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ixL, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.ixE != null && this.ixE.rightButton != null && !StringUtils.isNull(this.ixE.rightButton.action)) {
                ba.aEa().b(getTbPageContext(), new String[]{this.ixE.rightButton.action});
            }
            if (this.ixF != null) {
                this.ixF.dismiss();
            }
            an anVar = new an(c.a.iub);
            anVar.Z("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.noButton) {
            if (this.ixE != null && this.ixE.leftButton != null && !StringUtils.isNull(this.ixE.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.ixE.leftButton.action, true)));
            }
            if (this.ixF != null) {
                this.ixF.dismiss();
            }
            an anVar2 = new an(c.a.iub);
            anVar2.Z("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
