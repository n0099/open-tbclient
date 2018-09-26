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
    private TextView anp;
    private TextView anq;
    private f bUO;
    private CustomDialogData fBs;
    private TbImageView fBt;
    private TextView fBu;
    private TextView fBv;
    private View fBw;
    private View fBx;
    private LinearLayout fBy;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bUO = fVar;
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
            this.fBs = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fBt.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fBu.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fBv.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.anq.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.anp.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fBt = (TbImageView) getViewGroup().findViewById(e.g.dialog_image);
        this.fBu = (TextView) getViewGroup().findViewById(e.g.dialog_title);
        this.fBv = (TextView) getViewGroup().findViewById(e.g.dialog_body);
        this.anp = (TextView) getViewGroup().findViewById(e.g.yes);
        this.anq = (TextView) getViewGroup().findViewById(e.g.no);
        this.fBw = getViewGroup().findViewById(e.g.bdDialog_divider_line);
        this.fBx = getViewGroup().findViewById(e.g.divider_yes_no_button);
        this.fBy = (LinearLayout) getViewGroup().findViewById(e.g.real_view);
        this.anp.setOnClickListener(this);
        this.anq.setOnClickListener(this);
        al.i(this.anp, e.f.dialog_single_button_bg_selector);
        al.h(this.anp, e.d.cp_link_tip_a);
        al.h(this.anq, e.d.cp_link_tip_a);
        al.h(this.fBu, e.d.cp_cont_b);
        al.h(this.fBv, e.d.common_color_10122);
        al.j(this.fBw, e.d.cp_bg_line_a);
        al.j(this.fBx, e.d.cp_bg_line_a);
        al.i(this.fBy, e.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anp) {
            if (this.fBs != null && this.fBs.rightButton != null && !StringUtils.isNull(this.fBs.rightButton.action)) {
                ay.AN().c(getTbPageContext(), new String[]{this.fBs.rightButton.action});
            }
            if (this.bUO != null) {
                this.bUO.dismiss();
            }
            am amVar = new am(b.a.fye);
            amVar.w("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.anq) {
            if (this.fBs != null && this.fBs.leftButton != null && !StringUtils.isNull(this.fBs.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fBs.leftButton.action, true)));
            }
            if (this.bUO != null) {
                this.bUO.dismiss();
            }
            am amVar2 = new am(b.a.fye);
            amVar2.w("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
