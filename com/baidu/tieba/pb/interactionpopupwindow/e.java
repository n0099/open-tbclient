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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView acH;
    private TextView acI;
    private f bDU;
    private CustomDialogData fep;
    private TbImageView feq;
    private TextView fer;
    private TextView fes;
    private View fet;
    private View feu;
    private LinearLayout fev;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bDU = fVar;
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
            this.fep = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.feq.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fer.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fes.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.acI.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.acH.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.feq = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fer = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fes = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.acH = (TextView) getViewGroup().findViewById(d.g.yes);
        this.acI = (TextView) getViewGroup().findViewById(d.g.no);
        this.fet = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.feu = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fev = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.acH.setOnClickListener(this);
        this.acI.setOnClickListener(this);
        ak.i(this.acH, d.f.dialog_single_button_bg_selector);
        ak.h(this.acH, d.C0126d.cp_link_tip_a);
        ak.h(this.acI, d.C0126d.cp_link_tip_a);
        ak.h(this.fer, d.C0126d.cp_cont_b);
        ak.h(this.fes, d.C0126d.common_color_10122);
        ak.j(this.fet, d.C0126d.cp_bg_line_a);
        ak.j(this.feu, d.C0126d.cp_bg_line_a);
        ak.i(this.fev, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.acH) {
            if (this.fep != null && this.fep.rightButton != null && !StringUtils.isNull(this.fep.rightButton.action)) {
                ax.wf().c(aeY(), new String[]{this.fep.rightButton.action});
            }
            if (this.bDU != null) {
                this.bDU.dismiss();
            }
            al alVar = new al(b.a.fbc);
            alVar.r("obj_locate", 2);
            TiebaStatic.log(alVar);
        } else if (view2 == this.acI) {
            if (this.fep != null && this.fep.leftButton != null && !StringUtils.isNull(this.fep.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fep.leftButton.action, true)));
            }
            if (this.bDU != null) {
                this.bDU.dismiss();
            }
            al alVar2 = new al(b.a.fbc);
            alVar2.r("obj_locate", 1);
            TiebaStatic.log(alVar2);
        }
    }
}
