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
    private TextView aPT;
    private TextView aPU;
    private CustomDialogData fDl;
    private f fDm;
    private TbImageView fDn;
    private TextView fDo;
    private TextView fDp;
    private View fDq;
    private View fDr;
    private LinearLayout fDs;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.fDm = fVar;
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
            this.fDl = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fDn.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fDo.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fDp.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.aPU.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.aPT.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fDn = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fDo = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fDp = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.aPT = (TextView) getViewGroup().findViewById(d.g.yes);
        this.aPU = (TextView) getViewGroup().findViewById(d.g.no);
        this.fDq = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fDr = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fDs = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.aPT.setOnClickListener(this);
        this.aPU.setOnClickListener(this);
        aj.s(this.aPT, d.f.dialog_single_button_bg_selector);
        aj.r(this.aPT, d.C0108d.cp_link_tip_a);
        aj.r(this.aPU, d.C0108d.cp_link_tip_a);
        aj.r(this.fDo, d.C0108d.cp_cont_b);
        aj.r(this.fDp, d.C0108d.common_color_10122);
        aj.t(this.fDq, d.C0108d.cp_bg_line_a);
        aj.t(this.fDr, d.C0108d.cp_bg_line_a);
        aj.s(this.fDs, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aPT) {
            if (this.fDl != null && this.fDl.rightButton != null && !StringUtils.isNull(this.fDl.rightButton.action)) {
                av.Di().c(aiX(), new String[]{this.fDl.rightButton.action});
            }
            if (this.fDm != null) {
                this.fDm.dismiss();
            }
            ak akVar = new ak(b.a.fzR);
            akVar.s("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.aPU) {
            if (this.fDl != null && this.fDl.leftButton != null && !StringUtils.isNull(this.fDl.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fDl.leftButton.action, true)));
            }
            if (this.fDm != null) {
                this.fDm.dismiss();
            }
            ak akVar2 = new ak(b.a.fzR);
            akVar2.s("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
