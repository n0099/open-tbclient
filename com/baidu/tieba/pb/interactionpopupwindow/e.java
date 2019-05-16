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
    private TextView bMf;
    private TextView bMg;
    private f dHR;
    private TextView hCA;
    private TextView hCB;
    private View hCC;
    private View hCD;
    private LinearLayout hCE;
    private CustomDialogData hCy;
    private TbImageView hCz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dHR = fVar;
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
            this.hCy = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hCz.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hCA.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hCB.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bMg.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bMf.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hCz = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.hCA = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.hCB = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.bMf = (TextView) getViewGroup().findViewById(R.id.yes);
        this.bMg = (TextView) getViewGroup().findViewById(R.id.no);
        this.hCC = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.hCD = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.hCE = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.bMf.setOnClickListener(this);
        this.bMg.setOnClickListener(this);
        al.k(this.bMf, R.drawable.dialog_single_button_bg_selector);
        al.j(this.bMf, R.color.cp_link_tip_a);
        al.j(this.bMg, R.color.cp_link_tip_a);
        al.j(this.hCA, R.color.cp_cont_b);
        al.j(this.hCB, R.color.common_color_10122);
        al.l(this.hCC, R.color.cp_bg_line_a);
        al.l(this.hCD, R.color.cp_bg_line_a);
        al.k(this.hCE, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMf) {
            if (this.hCy != null && this.hCy.rightButton != null && !StringUtils.isNull(this.hCy.rightButton.action)) {
                ba.aiz().c(getTbPageContext(), new String[]{this.hCy.rightButton.action});
            }
            if (this.dHR != null) {
                this.dHR.dismiss();
            }
            am amVar = new am(b.a.hzd);
            amVar.P("obj_locate", 2);
            TiebaStatic.log(amVar);
        } else if (view == this.bMg) {
            if (this.hCy != null && this.hCy.leftButton != null && !StringUtils.isNull(this.hCy.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hCy.leftButton.action, true)));
            }
            if (this.dHR != null) {
                this.dHR.dismiss();
            }
            am amVar2 = new am(b.a.hzd);
            amVar2.P("obj_locate", 1);
            TiebaStatic.log(amVar2);
        }
    }
}
