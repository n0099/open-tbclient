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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView akL;
    private TextView akM;
    private f bLW;
    private CustomDialogData fpM;
    private TbImageView fpN;
    private TextView fpO;
    private TextView fpP;
    private View fpQ;
    private View fpR;
    private LinearLayout fpS;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bLW = fVar;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public int getLayout() {
        return d.i.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    /* renamed from: b */
    public void a(CustomDialogData customDialogData) {
        if (customDialogData != null) {
            this.fpM = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fpN.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fpO.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fpP.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.akM.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.akL.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fpN = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fpO = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fpP = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.akL = (TextView) getViewGroup().findViewById(d.g.yes);
        this.akM = (TextView) getViewGroup().findViewById(d.g.no);
        this.fpQ = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fpR = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fpS = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.akL.setOnClickListener(this);
        this.akM.setOnClickListener(this);
        al.i(this.akL, d.f.dialog_single_button_bg_selector);
        al.h(this.akL, d.C0141d.cp_link_tip_a);
        al.h(this.akM, d.C0141d.cp_link_tip_a);
        al.h(this.fpO, d.C0141d.cp_cont_b);
        al.h(this.fpP, d.C0141d.common_color_10122);
        al.j(this.fpQ, d.C0141d.cp_bg_line_a);
        al.j(this.fpR, d.C0141d.cp_bg_line_a);
        al.i(this.fpS, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.akL) {
            if (this.fpM != null && this.fpM.rightButton != null && !StringUtils.isNull(this.fpM.rightButton.action)) {
                ay.zG().c(aiH(), new String[]{this.fpM.rightButton.action});
            }
            if (this.bLW != null) {
                this.bLW.dismiss();
            }
            am amVar = new am(b.a.fmx);
            amVar.r("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.akM) {
            if (this.fpM != null && this.fpM.leftButton != null && !StringUtils.isNull(this.fpM.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fpM.leftButton.action, true)));
            }
            if (this.bLW != null) {
                this.bLW.dismiss();
            }
            am amVar2 = new am(b.a.fmx);
            amVar2.r("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
