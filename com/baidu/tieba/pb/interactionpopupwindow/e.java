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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData kjf;
    private f kjg;
    private TbImageView kjh;
    private TextView kji;
    private TextView kjj;
    private View kjk;
    private View kjl;
    private LinearLayout kjm;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.kjg = fVar;
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
            this.kjf = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.kjh.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.kji.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.kjj.setText(customDialogData.body);
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
        this.kjh = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.kji = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.kjj = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.kjk = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.kjl = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.kjm = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ao.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ao.setViewTextColor(this.yesButton, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.noButton, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.kji, R.color.cp_cont_b);
        ao.setViewTextColor(this.kjj, R.color.common_color_10122);
        ao.setBackgroundColor(this.kjk, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.kjl, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.kjm, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.kjf != null && this.kjf.rightButton != null && !StringUtils.isNull(this.kjf.rightButton.action)) {
                bd.baV().b(getTbPageContext(), new String[]{this.kjf.rightButton.action});
            }
            if (this.kjg != null) {
                this.kjg.dismiss();
            }
            ap apVar = new ap(b.a.CLICK);
            apVar.ah("obj_locate", 2);
            TiebaStatic.log(apVar);
        } else if (view == this.noButton) {
            if (this.kjf != null && this.kjf.leftButton != null && !StringUtils.isNull(this.kjf.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.kjf.leftButton.action, true)));
            }
            if (this.kjg != null) {
                this.kjg.dismiss();
            }
            ap apVar2 = new ap(b.a.CLICK);
            apVar2.ah("obj_locate", 1);
            TiebaStatic.log(apVar2);
        }
    }
}
