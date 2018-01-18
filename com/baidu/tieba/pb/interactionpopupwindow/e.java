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
    private TextView aPS;
    private TextView aPT;
    private CustomDialogData fEL;
    private f fEM;
    private TbImageView fEN;
    private TextView fEO;
    private TextView fEP;
    private View fEQ;
    private View fER;
    private LinearLayout fES;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.fEM = fVar;
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
            this.fEL = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fEN.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fEO.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fEP.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.aPT.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.aPS.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fEN = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fEO = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fEP = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.aPS = (TextView) getViewGroup().findViewById(d.g.yes);
        this.aPT = (TextView) getViewGroup().findViewById(d.g.no);
        this.fEQ = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fER = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fES = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.aPS.setOnClickListener(this);
        this.aPT.setOnClickListener(this);
        aj.s(this.aPS, d.f.dialog_single_button_bg_selector);
        aj.r(this.aPS, d.C0107d.cp_link_tip_a);
        aj.r(this.aPT, d.C0107d.cp_link_tip_a);
        aj.r(this.fEO, d.C0107d.cp_cont_b);
        aj.r(this.fEP, d.C0107d.common_color_10122);
        aj.t(this.fEQ, d.C0107d.cp_bg_line_a);
        aj.t(this.fER, d.C0107d.cp_bg_line_a);
        aj.s(this.fES, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aPS) {
            if (this.fEL != null && this.fEL.rightButton != null && !StringUtils.isNull(this.fEL.rightButton.action)) {
                av.CZ().c(aka(), new String[]{this.fEL.rightButton.action});
            }
            if (this.fEM != null) {
                this.fEM.dismiss();
            }
            ak akVar = new ak(b.a.fBr);
            akVar.s("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.aPT) {
            if (this.fEL != null && this.fEL.leftButton != null && !StringUtils.isNull(this.fEL.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fEL.leftButton.action, true)));
            }
            if (this.fEM != null) {
                this.fEM.dismiss();
            }
            ak akVar2 = new ak(b.a.fBr);
            akVar2.s("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
