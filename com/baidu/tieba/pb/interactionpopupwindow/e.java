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
    private TextView awy;
    private TextView awz;
    private f chB;
    private CustomDialogData fUb;
    private TbImageView fUc;
    private TextView fUd;
    private TextView fUe;
    private View fUf;
    private View fUg;
    private LinearLayout fUh;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.chB = fVar;
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
            this.fUb = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fUc.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fUd.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fUe.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.awz.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.awy.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fUc = (TbImageView) getViewGroup().findViewById(e.g.dialog_image);
        this.fUd = (TextView) getViewGroup().findViewById(e.g.dialog_title);
        this.fUe = (TextView) getViewGroup().findViewById(e.g.dialog_body);
        this.awy = (TextView) getViewGroup().findViewById(e.g.yes);
        this.awz = (TextView) getViewGroup().findViewById(e.g.no);
        this.fUf = getViewGroup().findViewById(e.g.bdDialog_divider_line);
        this.fUg = getViewGroup().findViewById(e.g.divider_yes_no_button);
        this.fUh = (LinearLayout) getViewGroup().findViewById(e.g.real_view);
        this.awy.setOnClickListener(this);
        this.awz.setOnClickListener(this);
        al.i(this.awy, e.f.dialog_single_button_bg_selector);
        al.h(this.awy, e.d.cp_link_tip_a);
        al.h(this.awz, e.d.cp_link_tip_a);
        al.h(this.fUd, e.d.cp_cont_b);
        al.h(this.fUe, e.d.common_color_10122);
        al.j(this.fUf, e.d.cp_bg_line_a);
        al.j(this.fUg, e.d.cp_bg_line_a);
        al.i(this.fUh, e.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awy) {
            if (this.fUb != null && this.fUb.rightButton != null && !StringUtils.isNull(this.fUb.rightButton.action)) {
                ay.Ef().c(getTbPageContext(), new String[]{this.fUb.rightButton.action});
            }
            if (this.chB != null) {
                this.chB.dismiss();
            }
            am amVar = new am(b.a.fQN);
            amVar.x("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.awz) {
            if (this.fUb != null && this.fUb.leftButton != null && !StringUtils.isNull(this.fUb.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fUb.leftButton.action, true)));
            }
            if (this.chB != null) {
                this.chB.dismiss();
            }
            am amVar2 = new am(b.a.fQN);
            amVar2.x("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
