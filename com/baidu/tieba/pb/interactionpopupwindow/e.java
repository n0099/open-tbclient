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
    private TextView ask;
    private TextView asl;
    private f cdo;
    private CustomDialogData fIT;
    private TbImageView fIU;
    private TextView fIV;
    private TextView fIW;
    private View fIX;
    private View fIY;
    private LinearLayout fIZ;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.cdo = fVar;
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
            this.fIT = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fIU.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fIV.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fIW.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.asl.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.ask.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fIU = (TbImageView) getViewGroup().findViewById(e.g.dialog_image);
        this.fIV = (TextView) getViewGroup().findViewById(e.g.dialog_title);
        this.fIW = (TextView) getViewGroup().findViewById(e.g.dialog_body);
        this.ask = (TextView) getViewGroup().findViewById(e.g.yes);
        this.asl = (TextView) getViewGroup().findViewById(e.g.no);
        this.fIX = getViewGroup().findViewById(e.g.bdDialog_divider_line);
        this.fIY = getViewGroup().findViewById(e.g.divider_yes_no_button);
        this.fIZ = (LinearLayout) getViewGroup().findViewById(e.g.real_view);
        this.ask.setOnClickListener(this);
        this.asl.setOnClickListener(this);
        al.i(this.ask, e.f.dialog_single_button_bg_selector);
        al.h(this.ask, e.d.cp_link_tip_a);
        al.h(this.asl, e.d.cp_link_tip_a);
        al.h(this.fIV, e.d.cp_cont_b);
        al.h(this.fIW, e.d.common_color_10122);
        al.j(this.fIX, e.d.cp_bg_line_a);
        al.j(this.fIY, e.d.cp_bg_line_a);
        al.i(this.fIZ, e.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ask) {
            if (this.fIT != null && this.fIT.rightButton != null && !StringUtils.isNull(this.fIT.rightButton.action)) {
                ay.CU().c(getTbPageContext(), new String[]{this.fIT.rightButton.action});
            }
            if (this.cdo != null) {
                this.cdo.dismiss();
            }
            am amVar = new am(b.a.fFG);
            amVar.x("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.asl) {
            if (this.fIT != null && this.fIT.leftButton != null && !StringUtils.isNull(this.fIT.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fIT.leftButton.action, true)));
            }
            if (this.cdo != null) {
                this.cdo.dismiss();
            }
            am amVar2 = new am(b.a.fFG);
            amVar2.x("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
