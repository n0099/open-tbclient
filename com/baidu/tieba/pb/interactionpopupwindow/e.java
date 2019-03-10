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
    private TextView bEG;
    private TextView bEH;
    private f dxp;
    private CustomDialogData hll;
    private TbImageView hlm;
    private TextView hln;
    private TextView hlo;
    private View hlp;
    private View hlq;
    private LinearLayout hlr;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dxp = fVar;
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
            this.hll = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hlm.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hln.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hlo.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bEH.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bEG.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hlm = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.hln = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.hlo = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.bEG = (TextView) getViewGroup().findViewById(d.g.yes);
        this.bEH = (TextView) getViewGroup().findViewById(d.g.no);
        this.hlp = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.hlq = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.hlr = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.bEG.setOnClickListener(this);
        this.bEH.setOnClickListener(this);
        al.k(this.bEG, d.f.dialog_single_button_bg_selector);
        al.j(this.bEG, d.C0236d.cp_link_tip_a);
        al.j(this.bEH, d.C0236d.cp_link_tip_a);
        al.j(this.hln, d.C0236d.cp_cont_b);
        al.j(this.hlo, d.C0236d.common_color_10122);
        al.l(this.hlp, d.C0236d.cp_bg_line_a);
        al.l(this.hlq, d.C0236d.cp_bg_line_a);
        al.k(this.hlr, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bEG) {
            if (this.hll != null && this.hll.rightButton != null && !StringUtils.isNull(this.hll.rightButton.action)) {
                ba.adD().c(getTbPageContext(), new String[]{this.hll.rightButton.action});
            }
            if (this.dxp != null) {
                this.dxp.dismiss();
            }
            am amVar = new am(b.a.hhY);
            amVar.T("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.bEH) {
            if (this.hll != null && this.hll.leftButton != null && !StringUtils.isNull(this.hll.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hll.leftButton.action, true)));
            }
            if (this.dxp != null) {
                this.dxp.dismiss();
            }
            am amVar2 = new am(b.a.hhY);
            amVar2.T("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
