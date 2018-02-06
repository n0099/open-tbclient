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
    private TextView aRs;
    private TextView aRt;
    private CustomDialogData fID;
    private f fIE;
    private TbImageView fIF;
    private TextView fIG;
    private TextView fIH;
    private View fII;
    private View fIJ;
    private LinearLayout fIK;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.fIE = fVar;
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
            this.fID = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fIF.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fIG.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fIH.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.aRt.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.aRs.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fIF = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fIG = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fIH = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.aRs = (TextView) getViewGroup().findViewById(d.g.yes);
        this.aRt = (TextView) getViewGroup().findViewById(d.g.no);
        this.fII = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fIJ = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fIK = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.aRs.setOnClickListener(this);
        this.aRt.setOnClickListener(this);
        aj.s(this.aRs, d.f.dialog_single_button_bg_selector);
        aj.r(this.aRs, d.C0140d.cp_link_tip_a);
        aj.r(this.aRt, d.C0140d.cp_link_tip_a);
        aj.r(this.fIG, d.C0140d.cp_cont_b);
        aj.r(this.fIH, d.C0140d.common_color_10122);
        aj.t(this.fII, d.C0140d.cp_bg_line_a);
        aj.t(this.fIJ, d.C0140d.cp_bg_line_a);
        aj.s(this.fIK, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRs) {
            if (this.fID != null && this.fID.rightButton != null && !StringUtils.isNull(this.fID.rightButton.action)) {
                aw.Du().c(akO(), new String[]{this.fID.rightButton.action});
            }
            if (this.fIE != null) {
                this.fIE.dismiss();
            }
            ak akVar = new ak(b.a.fFn);
            akVar.s("obj_locate", 2);
            TiebaStatic.log(akVar);
        } else if (view == this.aRt) {
            if (this.fID != null && this.fID.leftButton != null && !StringUtils.isNull(this.fID.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fID.leftButton.action, true)));
            }
            if (this.fIE != null) {
                this.fIE.dismiss();
            }
            ak akVar2 = new ak(b.a.fFn);
            akVar2.s("obj_locate", 1);
            TiebaStatic.log(akVar2);
        }
    }
}
