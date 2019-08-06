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
    private TextView bNl;
    private TextView bNm;
    private f dLH;
    private CustomDialogData hJI;
    private TbImageView hJJ;
    private TextView hJK;
    private TextView hJL;
    private View hJM;
    private View hJN;
    private LinearLayout hJO;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dLH = fVar;
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
            this.hJI = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hJJ.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hJK.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hJL.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bNm.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bNl.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hJJ = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.hJK = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.hJL = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.bNl = (TextView) getViewGroup().findViewById(R.id.yes);
        this.bNm = (TextView) getViewGroup().findViewById(R.id.no);
        this.hJM = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.hJN = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.hJO = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.bNl.setOnClickListener(this);
        this.bNm.setOnClickListener(this);
        am.k(this.bNl, R.drawable.dialog_single_button_bg_selector);
        am.j(this.bNl, R.color.cp_link_tip_a);
        am.j(this.bNm, R.color.cp_link_tip_a);
        am.j(this.hJK, R.color.cp_cont_b);
        am.j(this.hJL, R.color.common_color_10122);
        am.l(this.hJM, R.color.cp_bg_line_a);
        am.l(this.hJN, R.color.cp_bg_line_a);
        am.k(this.hJO, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bNl) {
            if (this.hJI != null && this.hJI.rightButton != null && !StringUtils.isNull(this.hJI.rightButton.action)) {
                bb.ajE().c(getTbPageContext(), new String[]{this.hJI.rightButton.action});
            }
            if (this.dLH != null) {
                this.dLH.dismiss();
            }
            an anVar = new an(b.a.hGm);
            anVar.P("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.bNm) {
            if (this.hJI != null && this.hJI.leftButton != null && !StringUtils.isNull(this.hJI.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hJI.leftButton.action, true)));
            }
            if (this.dLH != null) {
                this.dLH.dismiss();
            }
            an anVar2 = new an(b.a.hGm);
            anVar2.P("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
