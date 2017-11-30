package com.baidu.tieba.pb.interactionpopupwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView abC;
    private TextView abD;
    private CustomDialogData ePC;
    private f ePD;
    private TbImageView ePE;
    private TextView ePF;
    private TextView ePG;
    private View ePH;
    private View ePI;
    private LinearLayout ePJ;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.ePD = fVar;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public int getLayout() {
        return d.h.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    /* renamed from: b */
    public void a(CustomDialogData customDialogData) {
        if (customDialogData != null) {
            this.ePC = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.ePE.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.ePF.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.ePG.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.abD.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.abD.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.ePE = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.ePF = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.ePG = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.abC = (TextView) getViewGroup().findViewById(d.g.yes);
        this.abD = (TextView) getViewGroup().findViewById(d.g.no);
        this.ePH = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.ePI = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.ePJ = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.abC.setOnClickListener(this);
        this.abD.setOnClickListener(this);
        aj.j(this.abC, d.f.dialog_single_button_bg_selector);
        aj.i(this.abC, d.C0082d.cp_link_tip_a);
        aj.i(this.abD, d.C0082d.cp_link_tip_a);
        aj.i(this.ePF, d.C0082d.cp_cont_b);
        aj.i(this.ePG, d.C0082d.common_color_10122);
        aj.k(this.ePH, d.C0082d.cp_bg_line_a);
        aj.k(this.ePI, d.C0082d.cp_bg_line_a);
        aj.j(this.ePJ, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.abC) {
            if (this.ePC != null && this.ePC.rightButton != null && !StringUtils.isNull(this.ePC.rightButton.action)) {
                av.vL().c(abr(), new String[]{this.ePC.rightButton.action});
            }
            if (this.ePD != null) {
                this.ePD.dismiss();
            }
            ak akVar = new ak(b.a.eMn);
            akVar.r("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.abD) {
            if (this.ePC != null && this.ePC.leftButton != null && !StringUtils.isNull(this.ePC.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.ePC.leftButton.action, true)));
            }
            if (this.ePD != null) {
                this.ePD.dismiss();
            }
            ak akVar2 = new ak(b.a.eMn);
            akVar2.r("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
