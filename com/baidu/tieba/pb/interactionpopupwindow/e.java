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
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData iDb;
    private f iDc;
    private TbImageView iDd;
    private TextView iDe;
    private TextView iDf;
    private View iDg;
    private View iDh;
    private LinearLayout iDi;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.iDc = fVar;
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
            this.iDb = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.iDd.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.iDe.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.iDf.setText(customDialogData.body);
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
        this.iDd = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.iDe = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.iDf = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.iDg = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.iDh = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.iDi = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        am.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        am.setViewTextColor(this.yesButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.noButton, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.iDe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iDf, (int) R.color.common_color_10122);
        am.setBackgroundColor(this.iDg, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.iDh, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.iDi, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.iDb != null && this.iDb.rightButton != null && !StringUtils.isNull(this.iDb.rightButton.action)) {
                ba.aGE().b(getTbPageContext(), new String[]{this.iDb.rightButton.action});
            }
            if (this.iDc != null) {
                this.iDc.dismiss();
            }
            an anVar = new an(b.a.izA);
            anVar.X("obj_locate", 2);
            TiebaStatic.log(anVar);
        } else if (view == this.noButton) {
            if (this.iDb != null && this.iDb.leftButton != null && !StringUtils.isNull(this.iDb.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.iDb.leftButton.action, true)));
            }
            if (this.iDc != null) {
                this.iDc.dismiss();
            }
            an anVar2 = new an(b.a.izA);
            anVar2.X("obj_locate", 1);
            TiebaStatic.log(anVar2);
        }
    }
}
