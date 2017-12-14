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
    private TextView abw;
    private TextView abx;
    private CustomDialogData eQF;
    private f eQG;
    private TbImageView eQH;
    private TextView eQI;
    private TextView eQJ;
    private View eQK;
    private View eQL;
    private LinearLayout eQM;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.eQG = fVar;
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
            this.eQF = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.eQH.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.eQI.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.eQJ.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.abx.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.abx.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.eQH = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.eQI = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.eQJ = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.abw = (TextView) getViewGroup().findViewById(d.g.yes);
        this.abx = (TextView) getViewGroup().findViewById(d.g.no);
        this.eQK = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.eQL = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.eQM = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.abw.setOnClickListener(this);
        this.abx.setOnClickListener(this);
        aj.j(this.abw, d.f.dialog_single_button_bg_selector);
        aj.i(this.abw, d.C0096d.cp_link_tip_a);
        aj.i(this.abx, d.C0096d.cp_link_tip_a);
        aj.i(this.eQI, d.C0096d.cp_cont_b);
        aj.i(this.eQJ, d.C0096d.common_color_10122);
        aj.k(this.eQK, d.C0096d.cp_bg_line_a);
        aj.k(this.eQL, d.C0096d.cp_bg_line_a);
        aj.j(this.eQM, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.abw) {
            if (this.eQF != null && this.eQF.rightButton != null && !StringUtils.isNull(this.eQF.rightButton.action)) {
                av.vI().c(abs(), new String[]{this.eQF.rightButton.action});
            }
            if (this.eQG != null) {
                this.eQG.dismiss();
            }
            ak akVar = new ak(b.a.eNq);
            akVar.r("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.abx) {
            if (this.eQF != null && this.eQF.leftButton != null && !StringUtils.isNull(this.eQF.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.eQF.leftButton.action, true)));
            }
            if (this.eQG != null) {
                this.eQG.dismiss();
            }
            ak akVar2 = new ak(b.a.eNq);
            akVar2.r("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
