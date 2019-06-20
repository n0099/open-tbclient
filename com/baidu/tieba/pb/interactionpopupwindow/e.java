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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView bMg;
    private TextView bMh;
    private f dHS;
    private CustomDialogData hCC;
    private TbImageView hCD;
    private TextView hCE;
    private TextView hCF;
    private View hCG;
    private View hCH;
    private LinearLayout hCI;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dHS = fVar;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public int getLayout() {
        return R.layout.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    /* renamed from: b */
    public void a(CustomDialogData customDialogData) {
        if (customDialogData != null) {
            this.hCC = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hCD.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hCE.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hCF.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bMh.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bMg.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hCD = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.hCE = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.hCF = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.bMg = (TextView) getViewGroup().findViewById(R.id.yes);
        this.bMh = (TextView) getViewGroup().findViewById(R.id.no);
        this.hCG = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.hCH = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.hCI = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.bMg.setOnClickListener(this);
        this.bMh.setOnClickListener(this);
        al.k(this.bMg, R.drawable.dialog_single_button_bg_selector);
        al.j(this.bMg, R.color.cp_link_tip_a);
        al.j(this.bMh, R.color.cp_link_tip_a);
        al.j(this.hCE, R.color.cp_cont_b);
        al.j(this.hCF, R.color.common_color_10122);
        al.l(this.hCG, R.color.cp_bg_line_a);
        al.l(this.hCH, R.color.cp_bg_line_a);
        al.k(this.hCI, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMg) {
            if (this.hCC != null && this.hCC.rightButton != null && !StringUtils.isNull(this.hCC.rightButton.action)) {
                ba.aiz().c(getTbPageContext(), new String[]{this.hCC.rightButton.action});
            }
            if (this.dHS != null) {
                this.dHS.dismiss();
            }
            am amVar = new am(b.a.hzh);
            amVar.P("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.bMh) {
            if (this.hCC != null && this.hCC.leftButton != null && !StringUtils.isNull(this.hCC.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hCC.leftButton.action, true)));
            }
            if (this.dHS != null) {
                this.dHS.dismiss();
            }
            am amVar2 = new am(b.a.hzh);
            amVar2.P("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
