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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView bNg;
    private TextView bNh;
    private f dLA;
    private CustomDialogData hIP;
    private TbImageView hIQ;
    private TextView hIR;
    private TextView hIS;
    private View hIT;
    private View hIU;
    private LinearLayout hIV;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dLA = fVar;
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
            this.hIP = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hIQ.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hIR.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hIS.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bNh.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bNg.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hIQ = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.hIR = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.hIS = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.bNg = (TextView) getViewGroup().findViewById(R.id.yes);
        this.bNh = (TextView) getViewGroup().findViewById(R.id.no);
        this.hIT = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.hIU = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.hIV = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.bNg.setOnClickListener(this);
        this.bNh.setOnClickListener(this);
        am.k(this.bNg, R.drawable.dialog_single_button_bg_selector);
        am.j(this.bNg, R.color.cp_link_tip_a);
        am.j(this.bNh, R.color.cp_link_tip_a);
        am.j(this.hIR, R.color.cp_cont_b);
        am.j(this.hIS, R.color.common_color_10122);
        am.l(this.hIT, R.color.cp_bg_line_a);
        am.l(this.hIU, R.color.cp_bg_line_a);
        am.k(this.hIV, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bNg) {
            if (this.hIP != null && this.hIP.rightButton != null && !StringUtils.isNull(this.hIP.rightButton.action)) {
                bb.ajC().c(getTbPageContext(), new String[]{this.hIP.rightButton.action});
            }
            if (this.dLA != null) {
                this.dLA.dismiss();
            }
            an anVar = new an(b.a.hFu);
            anVar.P("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.bNh) {
            if (this.hIP != null && this.hIP.leftButton != null && !StringUtils.isNull(this.hIP.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hIP.leftButton.action, true)));
            }
            if (this.dLA != null) {
                this.dLA.dismiss();
            }
            an anVar2 = new an(b.a.hFu);
            anVar2.P("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
