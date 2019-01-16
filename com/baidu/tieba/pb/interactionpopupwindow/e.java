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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView axa;
    private TextView axb;
    private f cin;
    private CustomDialogData fUY;
    private TbImageView fUZ;
    private TextView fVa;
    private TextView fVb;
    private View fVc;
    private View fVd;
    private LinearLayout fVe;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.cin = fVar;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public int getLayout() {
        return e.h.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    /* renamed from: b */
    public void a(CustomDialogData customDialogData) {
        if (customDialogData != null) {
            this.fUY = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fUZ.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fVa.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fVb.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.axb.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.axa.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fUZ = (TbImageView) getViewGroup().findViewById(e.g.dialog_image);
        this.fVa = (TextView) getViewGroup().findViewById(e.g.dialog_title);
        this.fVb = (TextView) getViewGroup().findViewById(e.g.dialog_body);
        this.axa = (TextView) getViewGroup().findViewById(e.g.yes);
        this.axb = (TextView) getViewGroup().findViewById(e.g.no);
        this.fVc = getViewGroup().findViewById(e.g.bdDialog_divider_line);
        this.fVd = getViewGroup().findViewById(e.g.divider_yes_no_button);
        this.fVe = (LinearLayout) getViewGroup().findViewById(e.g.real_view);
        this.axa.setOnClickListener(this);
        this.axb.setOnClickListener(this);
        al.i(this.axa, e.f.dialog_single_button_bg_selector);
        al.h(this.axa, e.d.cp_link_tip_a);
        al.h(this.axb, e.d.cp_link_tip_a);
        al.h(this.fVa, e.d.cp_cont_b);
        al.h(this.fVb, e.d.common_color_10122);
        al.j(this.fVc, e.d.cp_bg_line_a);
        al.j(this.fVd, e.d.cp_bg_line_a);
        al.i(this.fVe, e.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axa) {
            if (this.fUY != null && this.fUY.rightButton != null && !StringUtils.isNull(this.fUY.rightButton.action)) {
                ay.Es().c(getTbPageContext(), new String[]{this.fUY.rightButton.action});
            }
            if (this.cin != null) {
                this.cin.dismiss();
            }
            am amVar = new am(b.a.fRK);
            amVar.y("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.axb) {
            if (this.fUY != null && this.fUY.leftButton != null && !StringUtils.isNull(this.fUY.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fUY.leftButton.action, true)));
            }
            if (this.cin != null) {
                this.cin.dismiss();
            }
            am amVar2 = new am(b.a.fRK);
            amVar2.y("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
