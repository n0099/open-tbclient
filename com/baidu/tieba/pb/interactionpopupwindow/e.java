package com.baidu.tieba.pb.interactionpopupwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.c;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData iBi;
    private f iBj;
    private TbImageView iBk;
    private TextView iBl;
    private TextView iBm;
    private View iBn;
    private View iBo;
    private LinearLayout iBp;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.iBj = fVar;
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
            this.iBi = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.iBk.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.iBl.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.iBm.setText(customDialogData.body);
            }
            if (customDialogData.leftButton != null && !StringUtils.isNull(customDialogData.leftButton.text)) {
                this.noButton.setText(customDialogData.leftButton.text);
            }
            if (customDialogData.rightButton != null && !StringUtils.isNull(customDialogData.rightButton.text)) {
                this.yesButton.setText(customDialogData.rightButton.text);
            }
        }
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public void initView() {
        this.iBk = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.iBl = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.iBm = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.iBn = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.iBo = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.iBp = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        am.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        am.setViewTextColor(this.yesButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.noButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.iBl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iBm, (int) R.color.common_color_10122);
        am.setBackgroundColor(this.iBn, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.iBo, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.iBp, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.iBi != null && this.iBi.rightButton != null && !StringUtils.isNull(this.iBi.rightButton.action)) {
                ba.aEt().b(getTbPageContext(), new String[]{this.iBi.rightButton.action});
            }
            if (this.iBj != null) {
                this.iBj.dismiss();
            }
            an anVar = new an(c.a.ixF);
            anVar.Z("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.noButton) {
            if (this.iBi != null && this.iBi.leftButton != null && !StringUtils.isNull(this.iBi.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.iBi.leftButton.action, true)));
            }
            if (this.iBj != null) {
                this.iBj.dismiss();
            }
            an anVar2 = new an(c.a.ixF);
            anVar2.Z("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
