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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView akJ;
    private TextView akK;
    private f bOZ;
    private CustomDialogData ftJ;
    private TbImageView ftK;
    private TextView ftL;
    private TextView ftM;
    private View ftN;
    private View ftO;
    private LinearLayout ftP;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bOZ = fVar;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public int getLayout() {
        return f.h.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    /* renamed from: b */
    public void a(CustomDialogData customDialogData) {
        if (customDialogData != null) {
            this.ftJ = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.ftK.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.ftL.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.ftM.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.akK.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.akJ.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.ftK = (TbImageView) getViewGroup().findViewById(f.g.dialog_image);
        this.ftL = (TextView) getViewGroup().findViewById(f.g.dialog_title);
        this.ftM = (TextView) getViewGroup().findViewById(f.g.dialog_body);
        this.akJ = (TextView) getViewGroup().findViewById(f.g.yes);
        this.akK = (TextView) getViewGroup().findViewById(f.g.no);
        this.ftN = getViewGroup().findViewById(f.g.bdDialog_divider_line);
        this.ftO = getViewGroup().findViewById(f.g.divider_yes_no_button);
        this.ftP = (LinearLayout) getViewGroup().findViewById(f.g.real_view);
        this.akJ.setOnClickListener(this);
        this.akK.setOnClickListener(this);
        am.i(this.akJ, f.C0146f.dialog_single_button_bg_selector);
        am.h(this.akJ, f.d.cp_link_tip_a);
        am.h(this.akK, f.d.cp_link_tip_a);
        am.h(this.ftL, f.d.cp_cont_b);
        am.h(this.ftM, f.d.common_color_10122);
        am.j(this.ftN, f.d.cp_bg_line_a);
        am.j(this.ftO, f.d.cp_bg_line_a);
        am.i(this.ftP, f.C0146f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.akJ) {
            if (this.ftJ != null && this.ftJ.rightButton != null && !StringUtils.isNull(this.ftJ.rightButton.action)) {
                az.zI().c(aiB(), new String[]{this.ftJ.rightButton.action});
            }
            if (this.bOZ != null) {
                this.bOZ.dismiss();
            }
            an anVar = new an(b.a.fqv);
            anVar.r("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.akK) {
            if (this.ftJ != null && this.ftJ.leftButton != null && !StringUtils.isNull(this.ftJ.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.ftJ.leftButton.action, true)));
            }
            if (this.bOZ != null) {
                this.bOZ.dismiss();
            }
            an anVar2 = new an(b.a.fqv);
            anVar2.r("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
