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
    private TextView aRj;
    private TextView aRk;
    private CustomDialogData fII;
    private f fIJ;
    private TbImageView fIK;
    private TextView fIL;
    private TextView fIM;
    private View fIN;
    private View fIO;
    private LinearLayout fIP;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.fIJ = fVar;
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
            this.fII = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fIK.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fIL.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fIM.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.aRk.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.aRj.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fIK = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fIL = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fIM = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.aRj = (TextView) getViewGroup().findViewById(d.g.yes);
        this.aRk = (TextView) getViewGroup().findViewById(d.g.no);
        this.fIN = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fIO = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fIP = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.aRj.setOnClickListener(this);
        this.aRk.setOnClickListener(this);
        aj.s(this.aRj, d.f.dialog_single_button_bg_selector);
        aj.r(this.aRj, d.C0141d.cp_link_tip_a);
        aj.r(this.aRk, d.C0141d.cp_link_tip_a);
        aj.r(this.fIL, d.C0141d.cp_cont_b);
        aj.r(this.fIM, d.C0141d.common_color_10122);
        aj.t(this.fIN, d.C0141d.cp_bg_line_a);
        aj.t(this.fIO, d.C0141d.cp_bg_line_a);
        aj.s(this.fIP, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRj) {
            if (this.fII != null && this.fII.rightButton != null && !StringUtils.isNull(this.fII.rightButton.action)) {
                aw.Du().c(akO(), new String[]{this.fII.rightButton.action});
            }
            if (this.fIJ != null) {
                this.fIJ.dismiss();
            }
            ak akVar = new ak(b.a.fFs);
            akVar.s("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.aRk) {
            if (this.fII != null && this.fII.leftButton != null && !StringUtils.isNull(this.fII.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fII.leftButton.action, true)));
            }
            if (this.fIJ != null) {
                this.fIJ.dismiss();
            }
            ak akVar2 = new ak(b.a.fFs);
            akVar2.s("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
