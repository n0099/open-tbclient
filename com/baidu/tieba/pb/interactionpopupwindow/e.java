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
    private TextView bEK;
    private TextView bEL;
    private f dxq;
    private CustomDialogData hkX;
    private TbImageView hkY;
    private TextView hkZ;
    private TextView hla;
    private View hlb;
    private View hlc;
    private LinearLayout hld;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dxq = fVar;
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
            this.hkX = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hkY.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hkZ.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hla.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bEL.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bEK.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hkY = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.hkZ = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.hla = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.bEK = (TextView) getViewGroup().findViewById(d.g.yes);
        this.bEL = (TextView) getViewGroup().findViewById(d.g.no);
        this.hlb = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.hlc = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.hld = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.bEK.setOnClickListener(this);
        this.bEL.setOnClickListener(this);
        al.k(this.bEK, d.f.dialog_single_button_bg_selector);
        al.j(this.bEK, d.C0277d.cp_link_tip_a);
        al.j(this.bEL, d.C0277d.cp_link_tip_a);
        al.j(this.hkZ, d.C0277d.cp_cont_b);
        al.j(this.hla, d.C0277d.common_color_10122);
        al.l(this.hlb, d.C0277d.cp_bg_line_a);
        al.l(this.hlc, d.C0277d.cp_bg_line_a);
        al.k(this.hld, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bEK) {
            if (this.hkX != null && this.hkX.rightButton != null && !StringUtils.isNull(this.hkX.rightButton.action)) {
                ba.adA().c(getTbPageContext(), new String[]{this.hkX.rightButton.action});
            }
            if (this.dxq != null) {
                this.dxq.dismiss();
            }
            am amVar = new am(b.a.hhK);
            amVar.T("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.bEL) {
            if (this.hkX != null && this.hkX.leftButton != null && !StringUtils.isNull(this.hkX.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hkX.leftButton.action, true)));
            }
            if (this.dxq != null) {
                this.dxq.dismiss();
            }
            am amVar2 = new am(b.a.hhK);
            amVar2.T("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
