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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView alk;
    private TextView alm;
    private f bOf;
    private CustomDialogData ftF;
    private TbImageView ftG;
    private TextView ftH;
    private TextView ftI;
    private View ftJ;
    private View ftK;
    private LinearLayout ftL;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bOf = fVar;
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
            this.ftF = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.ftG.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.ftH.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.ftI.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.alm.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.alk.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.ftG = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.ftH = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.ftI = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.alk = (TextView) getViewGroup().findViewById(d.g.yes);
        this.alm = (TextView) getViewGroup().findViewById(d.g.no);
        this.ftJ = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.ftK = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.ftL = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.alk.setOnClickListener(this);
        this.alm.setOnClickListener(this);
        am.i(this.alk, d.f.dialog_single_button_bg_selector);
        am.h(this.alk, d.C0142d.cp_link_tip_a);
        am.h(this.alm, d.C0142d.cp_link_tip_a);
        am.h(this.ftH, d.C0142d.cp_cont_b);
        am.h(this.ftI, d.C0142d.common_color_10122);
        am.j(this.ftJ, d.C0142d.cp_bg_line_a);
        am.j(this.ftK, d.C0142d.cp_bg_line_a);
        am.i(this.ftL, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.alk) {
            if (this.ftF != null && this.ftF.rightButton != null && !StringUtils.isNull(this.ftF.rightButton.action)) {
                az.zV().c(ahZ(), new String[]{this.ftF.rightButton.action});
            }
            if (this.bOf != null) {
                this.bOf.dismiss();
            }
            an anVar = new an(b.a.fqq);
            anVar.r("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.alm) {
            if (this.ftF != null && this.ftF.leftButton != null && !StringUtils.isNull(this.ftF.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.ftF.leftButton.action, true)));
            }
            if (this.bOf != null) {
                this.bOf.dismiss();
            }
            an anVar2 = new an(b.a.fqq);
            anVar2.r("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
