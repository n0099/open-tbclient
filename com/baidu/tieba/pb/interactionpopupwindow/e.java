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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView acG;
    private TextView acH;
    private f bCX;
    private CustomDialogData fdi;
    private TbImageView fdj;
    private TextView fdk;
    private TextView fdl;
    private View fdm;
    private View fdn;
    private LinearLayout fdo;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.bCX = fVar;
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
            this.fdi = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.fdj.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.fdk.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.fdl.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.acH.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.acG.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.fdj = (TbImageView) getViewGroup().findViewById(d.g.dialog_image);
        this.fdk = (TextView) getViewGroup().findViewById(d.g.dialog_title);
        this.fdl = (TextView) getViewGroup().findViewById(d.g.dialog_body);
        this.acG = (TextView) getViewGroup().findViewById(d.g.yes);
        this.acH = (TextView) getViewGroup().findViewById(d.g.no);
        this.fdm = getViewGroup().findViewById(d.g.bdDialog_divider_line);
        this.fdn = getViewGroup().findViewById(d.g.divider_yes_no_button);
        this.fdo = (LinearLayout) getViewGroup().findViewById(d.g.real_view);
        this.acG.setOnClickListener(this);
        this.acH.setOnClickListener(this);
        ak.i(this.acG, d.f.dialog_single_button_bg_selector);
        ak.h(this.acG, d.C0126d.cp_link_tip_a);
        ak.h(this.acH, d.C0126d.cp_link_tip_a);
        ak.h(this.fdk, d.C0126d.cp_cont_b);
        ak.h(this.fdl, d.C0126d.common_color_10122);
        ak.j(this.fdm, d.C0126d.cp_bg_line_a);
        ak.j(this.fdn, d.C0126d.cp_bg_line_a);
        ak.i(this.fdo, d.f.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.acG) {
            if (this.fdi != null && this.fdi.rightButton != null && !StringUtils.isNull(this.fdi.rightButton.action)) {
                ax.wg().c(aeY(), new String[]{this.fdi.rightButton.action});
            }
            if (this.bCX != null) {
                this.bCX.dismiss();
            }
            al alVar = new al(b.a.eZV);
            alVar.r("obj_locate", 2);
            TiebaStatic.log(alVar);
        } else if (view2 == this.acH) {
            if (this.fdi != null && this.fdi.leftButton != null && !StringUtils.isNull(this.fdi.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.fdi.leftButton.action, true)));
            }
            if (this.bCX != null) {
                this.bCX.dismiss();
            }
            al alVar2 = new al(b.a.eZV);
            alVar2.r("obj_locate", 1);
            TiebaStatic.log(alVar2);
        }
    }
}
