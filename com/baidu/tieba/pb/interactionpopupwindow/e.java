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
    private TextView asX;
    private TextView asY;
    private f cdD;
    private CustomDialogData fKt;
    private TbImageView fKu;
    private TextView fKv;
    private TextView fKw;
    private View fKx;
    private View fKy;
    private LinearLayout fKz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.cdD = fVar;
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
            this.fKt = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fKu.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fKv.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fKw.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.asY.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.asX.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fKu = (TbImageView) getViewGroup().findViewById(e.g.dialog_image);
        this.fKv = (TextView) getViewGroup().findViewById(e.g.dialog_title);
        this.fKw = (TextView) getViewGroup().findViewById(e.g.dialog_body);
        this.asX = (TextView) getViewGroup().findViewById(e.g.yes);
        this.asY = (TextView) getViewGroup().findViewById(e.g.no);
        this.fKx = getViewGroup().findViewById(e.g.bdDialog_divider_line);
        this.fKy = getViewGroup().findViewById(e.g.divider_yes_no_button);
        this.fKz = (LinearLayout) getViewGroup().findViewById(e.g.real_view);
        this.asX.setOnClickListener(this);
        this.asY.setOnClickListener(this);
        al.i(this.asX, e.f.dialog_single_button_bg_selector);
        al.h(this.asX, e.d.cp_link_tip_a);
        al.h(this.asY, e.d.cp_link_tip_a);
        al.h(this.fKv, e.d.cp_cont_b);
        al.h(this.fKw, e.d.common_color_10122);
        al.j(this.fKx, e.d.cp_bg_line_a);
        al.j(this.fKy, e.d.cp_bg_line_a);
        al.i(this.fKz, e.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.asX) {
            if (this.fKt != null && this.fKt.rightButton != null && !StringUtils.isNull(this.fKt.rightButton.action)) {
                ay.Db().c(getTbPageContext(), new String[]{this.fKt.rightButton.action});
            }
            if (this.cdD != null) {
                this.cdD.dismiss();
            }
            am amVar = new am(b.a.fHf);
            amVar.x("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.asY) {
            if (this.fKt != null && this.fKt.leftButton != null && !StringUtils.isNull(this.fKt.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fKt.leftButton.action, true)));
            }
            if (this.cdD != null) {
                this.cdD.dismiss();
            }
            am amVar2 = new am(b.a.fHf);
            amVar2.x("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
