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
    private TextView abA;
    private TextView abz;
    private CustomDialogData eQK;
    private f eQL;
    private TbImageView eQM;
    private TextView eQN;
    private TextView eQO;
    private View eQP;
    private View eQQ;
    private LinearLayout eQR;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.eQL = fVar;
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
            this.eQK = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.eQM.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.eQN.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.eQO.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.abA.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.abA.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.eQM = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.eQN = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.eQO = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.abz = (TextView) getViewGroup().findViewById(d.g.yes);
        this.abA = (TextView) getViewGroup().findViewById(d.g.no);
        this.eQP = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.eQQ = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.eQR = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.abz.setOnClickListener(this);
        this.abA.setOnClickListener(this);
        aj.j(this.abz, d.f.dialog_single_button_bg_selector);
        aj.i(this.abz, d.C0095d.cp_link_tip_a);
        aj.i(this.abA, d.C0095d.cp_link_tip_a);
        aj.i(this.eQN, d.C0095d.cp_cont_b);
        aj.i(this.eQO, d.C0095d.common_color_10122);
        aj.k(this.eQP, d.C0095d.cp_bg_line_a);
        aj.k(this.eQQ, d.C0095d.cp_bg_line_a);
        aj.j(this.eQR, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.abz) {
            if (this.eQK != null && this.eQK.rightButton != null && !StringUtils.isNull(this.eQK.rightButton.action)) {
                av.vI().c(abs(), new String[]{this.eQK.rightButton.action});
            }
            if (this.eQL != null) {
                this.eQL.dismiss();
            }
            ak akVar = new ak(b.a.eNv);
            akVar.r("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.abA) {
            if (this.eQK != null && this.eQK.leftButton != null && !StringUtils.isNull(this.eQK.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.eQK.leftButton.action, true)));
            }
            if (this.eQL != null) {
                this.eQL.dismiss();
            }
            ak akVar2 = new ak(b.a.eNv);
            akVar2.r("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
