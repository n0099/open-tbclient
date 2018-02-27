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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView aRh;
    private TextView aRi;
    private CustomDialogData fIs;
    private f fIt;
    private TbImageView fIu;
    private TextView fIv;
    private TextView fIw;
    private View fIx;
    private View fIy;
    private LinearLayout fIz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.fIt = fVar;
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
            this.fIs = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fIu.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fIv.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fIw.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.aRi.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.aRh.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fIu = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fIv = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fIw = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.aRh = (TextView) getViewGroup().findViewById(d.g.yes);
        this.aRi = (TextView) getViewGroup().findViewById(d.g.no);
        this.fIx = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fIy = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fIz = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.aRh.setOnClickListener(this);
        this.aRi.setOnClickListener(this);
        aj.s(this.aRh, d.f.dialog_single_button_bg_selector);
        aj.r(this.aRh, d.C0141d.cp_link_tip_a);
        aj.r(this.aRi, d.C0141d.cp_link_tip_a);
        aj.r(this.fIv, d.C0141d.cp_cont_b);
        aj.r(this.fIw, d.C0141d.common_color_10122);
        aj.t(this.fIx, d.C0141d.cp_bg_line_a);
        aj.t(this.fIy, d.C0141d.cp_bg_line_a);
        aj.s(this.fIz, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRh) {
            if (this.fIs != null && this.fIs.rightButton != null && !StringUtils.isNull(this.fIs.rightButton.action)) {
                aw.Dt().c(akN(), new String[]{this.fIs.rightButton.action});
            }
            if (this.fIt != null) {
                this.fIt.dismiss();
            }
            ak akVar = new ak(b.a.fFc);
            akVar.s("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.aRi) {
            if (this.fIs != null && this.fIs.leftButton != null && !StringUtils.isNull(this.fIs.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fIs.leftButton.action, true)));
            }
            if (this.fIt != null) {
                this.fIt.dismiss();
            }
            ak akVar2 = new ak(b.a.fFc);
            akVar2.s("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
