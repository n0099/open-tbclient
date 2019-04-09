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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView bEL;
    private TextView bEM;
    private f dxr;
    private CustomDialogData hkY;
    private TbImageView hkZ;
    private TextView hla;
    private TextView hlb;
    private View hlc;
    private View hld;
    private LinearLayout hle;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dxr = fVar;
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
            this.hkY = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hkZ.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hla.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hlb.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bEM.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bEL.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hkZ = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.hla = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.hlb = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.bEL = (TextView) getViewGroup().findViewById(d.g.yes);
        this.bEM = (TextView) getViewGroup().findViewById(d.g.no);
        this.hlc = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.hld = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.hle = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.bEL.setOnClickListener(this);
        this.bEM.setOnClickListener(this);
        al.k(this.bEL, d.f.dialog_single_button_bg_selector);
        al.j(this.bEL, d.C0277d.cp_link_tip_a);
        al.j(this.bEM, d.C0277d.cp_link_tip_a);
        al.j(this.hla, d.C0277d.cp_cont_b);
        al.j(this.hlb, d.C0277d.common_color_10122);
        al.l(this.hlc, d.C0277d.cp_bg_line_a);
        al.l(this.hld, d.C0277d.cp_bg_line_a);
        al.k(this.hle, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bEL) {
            if (this.hkY != null && this.hkY.rightButton != null && !StringUtils.isNull(this.hkY.rightButton.action)) {
                ba.adA().c(getTbPageContext(), new String[]{this.hkY.rightButton.action});
            }
            if (this.dxr != null) {
                this.dxr.dismiss();
            }
            am amVar = new am(b.a.hhL);
            amVar.T("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.bEM) {
            if (this.hkY != null && this.hkY.leftButton != null && !StringUtils.isNull(this.hkY.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hkY.leftButton.action, true)));
            }
            if (this.dxr != null) {
                this.dxr.dismiss();
            }
            am amVar2 = new am(b.a.hhL);
            amVar2.T("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
