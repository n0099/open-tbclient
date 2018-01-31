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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView aPV;
    private TextView aPW;
    private CustomDialogData fFg;
    private f fFh;
    private TbImageView fFi;
    private TextView fFj;
    private TextView fFk;
    private View fFl;
    private View fFm;
    private LinearLayout fFn;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.fFh = fVar;
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
            this.fFg = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fFi.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fFj.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fFk.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.aPW.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.aPV.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fFi = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fFj = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fFk = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.aPV = (TextView) getViewGroup().findViewById(d.g.yes);
        this.aPW = (TextView) getViewGroup().findViewById(d.g.no);
        this.fFl = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fFm = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fFn = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.aPV.setOnClickListener(this);
        this.aPW.setOnClickListener(this);
        aj.s(this.aPV, d.f.dialog_single_button_bg_selector);
        aj.r(this.aPV, d.C0108d.cp_link_tip_a);
        aj.r(this.aPW, d.C0108d.cp_link_tip_a);
        aj.r(this.fFj, d.C0108d.cp_cont_b);
        aj.r(this.fFk, d.C0108d.common_color_10122);
        aj.t(this.fFl, d.C0108d.cp_bg_line_a);
        aj.t(this.fFm, d.C0108d.cp_bg_line_a);
        aj.s(this.fFn, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aPV) {
            if (this.fFg != null && this.fFg.rightButton != null && !StringUtils.isNull(this.fFg.rightButton.action)) {
                av.Da().c(akf(), new String[]{this.fFg.rightButton.action});
            }
            if (this.fFh != null) {
                this.fFh.dismiss();
            }
            ak akVar = new ak(b.a.fBM);
            akVar.s("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.aPW) {
            if (this.fFg != null && this.fFg.leftButton != null && !StringUtils.isNull(this.fFg.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fFg.leftButton.action, true)));
            }
            if (this.fFh != null) {
                this.fFh.dismiss();
            }
            ak akVar2 = new ak(b.a.fBM);
            akVar2.s("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
