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
    private TextView awx;
    private TextView awy;
    private f chu;
    private CustomDialogData fRj;
    private TbImageView fRk;
    private TextView fRl;
    private TextView fRm;
    private View fRn;
    private View fRo;
    private LinearLayout fRp;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.chu = fVar;
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
            this.fRj = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fRk.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fRl.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fRm.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.awy.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.awx.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fRk = (TbImageView) getViewGroup().findViewById(e.g.dialog_image);
        this.fRl = (TextView) getViewGroup().findViewById(e.g.dialog_title);
        this.fRm = (TextView) getViewGroup().findViewById(e.g.dialog_body);
        this.awx = (TextView) getViewGroup().findViewById(e.g.yes);
        this.awy = (TextView) getViewGroup().findViewById(e.g.no);
        this.fRn = getViewGroup().findViewById(e.g.bdDialog_divider_line);
        this.fRo = getViewGroup().findViewById(e.g.divider_yes_no_button);
        this.fRp = (LinearLayout) getViewGroup().findViewById(e.g.real_view);
        this.awx.setOnClickListener(this);
        this.awy.setOnClickListener(this);
        al.i(this.awx, e.f.dialog_single_button_bg_selector);
        al.h(this.awx, e.d.cp_link_tip_a);
        al.h(this.awy, e.d.cp_link_tip_a);
        al.h(this.fRl, e.d.cp_cont_b);
        al.h(this.fRm, e.d.common_color_10122);
        al.j(this.fRn, e.d.cp_bg_line_a);
        al.j(this.fRo, e.d.cp_bg_line_a);
        al.i(this.fRp, e.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awx) {
            if (this.fRj != null && this.fRj.rightButton != null && !StringUtils.isNull(this.fRj.rightButton.action)) {
                ay.Ef().c(getTbPageContext(), new String[]{this.fRj.rightButton.action});
            }
            if (this.chu != null) {
                this.chu.dismiss();
            }
            am amVar = new am(b.a.fNV);
            amVar.x("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.awy) {
            if (this.fRj != null && this.fRj.leftButton != null && !StringUtils.isNull(this.fRj.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fRj.leftButton.action, true)));
            }
            if (this.chu != null) {
                this.chu.dismiss();
            }
            am amVar2 = new am(b.a.fNV);
            amVar2.x("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
