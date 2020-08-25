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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes2.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private f kyA;
    private TbImageView kyB;
    private TextView kyC;
    private TextView kyD;
    private View kyE;
    private View kyF;
    private LinearLayout kyG;
    private CustomDialogData kyz;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.kyA = fVar;
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
            this.kyz = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.kyB.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.kyC.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.kyD.setText(customDialogData.body);
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
        this.kyB = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.kyC = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.kyD = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.kyE = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.kyF = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.kyG = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ap.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ap.setViewTextColor(this.yesButton, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.noButton, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.kyC, R.color.cp_cont_b);
        ap.setViewTextColor(this.kyD, R.color.common_color_10122);
        ap.setBackgroundColor(this.kyE, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.kyF, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.kyG, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.kyz != null && this.kyz.rightButton != null && !StringUtils.isNull(this.kyz.rightButton.action)) {
                be.bju().b(getTbPageContext(), new String[]{this.kyz.rightButton.action});
            }
            if (this.kyA != null) {
                this.kyA.dismiss();
            }
            aq aqVar = new aq(b.a.CLICK);
            aqVar.ai("obj_locate", 2);
            TiebaStatic.log(aqVar);
        } else if (view == this.noButton) {
            if (this.kyz != null && this.kyz.leftButton != null && !StringUtils.isNull(this.kyz.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.kyz.leftButton.action, true)));
            }
            if (this.kyA != null) {
                this.kyA.dismiss();
            }
            aq aqVar2 = new aq(b.a.CLICK);
            aqVar2.ai("obj_locate", 1);
            TiebaStatic.log(aqVar2);
        }
    }
}
