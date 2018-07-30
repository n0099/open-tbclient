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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView akJ;
    private TextView akK;
    private f bPa;
    private CustomDialogData ftQ;
    private TbImageView ftR;
    private TextView ftS;
    private TextView ftT;
    private View ftU;
    private View ftV;
    private LinearLayout ftW;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bPa = fVar;
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
            this.ftQ = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.ftR.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.ftS.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.ftT.setText(customDialogData.body);
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
        this.ftR = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.ftS = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.ftT = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.akJ = (TextView) getViewGroup().findViewById(d.g.yes);
        this.akK = (TextView) getViewGroup().findViewById(d.g.no);
        this.ftU = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.ftV = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.ftW = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.akJ.setOnClickListener(this);
        this.akK.setOnClickListener(this);
        am.i(this.akJ, d.f.dialog_single_button_bg_selector);
        am.h(this.akJ, d.C0140d.cp_link_tip_a);
        am.h(this.akK, d.C0140d.cp_link_tip_a);
        am.h(this.ftS, d.C0140d.cp_cont_b);
        am.h(this.ftT, d.C0140d.common_color_10122);
        am.j(this.ftU, d.C0140d.cp_bg_line_a);
        am.j(this.ftV, d.C0140d.cp_bg_line_a);
        am.i(this.ftW, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.akJ) {
            if (this.ftQ != null && this.ftQ.rightButton != null && !StringUtils.isNull(this.ftQ.rightButton.action)) {
                ay.zK().c(aiy(), new String[]{this.ftQ.rightButton.action});
            }
            if (this.bPa != null) {
                this.bPa.dismiss();
            }
            an anVar = new an(b.a.fqC);
            anVar.r("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.akK) {
            if (this.ftQ != null && this.ftQ.leftButton != null && !StringUtils.isNull(this.ftQ.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.ftQ.leftButton.action, true)));
            }
            if (this.bPa != null) {
                this.bPa.dismiss();
            }
            an anVar2 = new an(b.a.fqC);
            anVar2.r("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
