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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private TextView bNK;
    private TextView bNL;
    private f dNs;
    private CustomDialogData hLF;
    private TbImageView hLG;
    private TextView hLH;
    private TextView hLI;
    private View hLJ;
    private View hLK;
    private LinearLayout hLL;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.dNs = fVar;
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
            this.hLF = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.hLG.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.hLH.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.hLI.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.bNL.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.bNK.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.hLG = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.hLH = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.hLI = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.bNK = (TextView) getViewGroup().findViewById(R.id.yes);
        this.bNL = (TextView) getViewGroup().findViewById(R.id.no);
        this.hLJ = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.hLK = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.hLL = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.bNK.setOnClickListener(this);
        this.bNL.setOnClickListener(this);
        am.k(this.bNK, R.drawable.dialog_single_button_bg_selector);
        am.j(this.bNK, R.color.cp_link_tip_a);
        am.j(this.bNL, R.color.cp_link_tip_a);
        am.j(this.hLH, R.color.cp_cont_b);
        am.j(this.hLI, R.color.common_color_10122);
        am.l(this.hLJ, R.color.cp_bg_line_c);
        am.l(this.hLK, R.color.cp_bg_line_c);
        am.k(this.hLL, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bNK) {
            if (this.hLF != null && this.hLF.rightButton != null && !StringUtils.isNull(this.hLF.rightButton.action)) {
                ba.ajK().c(getTbPageContext(), new String[]{this.hLF.rightButton.action});
            }
            if (this.dNs != null) {
                this.dNs.dismiss();
            }
            an anVar = new an(b.a.hIi);
            anVar.P("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.bNL) {
            if (this.hLF != null && this.hLF.leftButton != null && !StringUtils.isNull(this.hLF.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.hLF.leftButton.action, true)));
            }
            if (this.dNs != null) {
                this.dNs.dismiss();
            }
            an anVar2 = new an(b.a.hIi);
            anVar2.P("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
