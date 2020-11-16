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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    private CustomDialogData lpf;
    private f lpg;
    private TbImageView lph;
    private TextView lpi;
    private TextView lpj;
    private View lpk;
    private View lpl;
    private LinearLayout lpm;
    private TextView noButton;
    private TextView yesButton;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(f fVar) {
        this.lpg = fVar;
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
            this.lpf = customDialogData;
            CustomDialogData.Head head = customDialogData.head;
            if (!TextUtils.isEmpty(head.imageUrl)) {
                this.lph.startLoad(head.imageUrl, 10, false);
            }
            if (!TextUtils.isEmpty(head.text)) {
                this.lpi.setText(head.text);
            }
            if (!TextUtils.isEmpty(customDialogData.body)) {
                this.lpj.setText(customDialogData.body);
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
        this.lph = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.lpi = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.lpj = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.yesButton = (TextView) getViewGroup().findViewById(R.id.yes);
        this.noButton = (TextView) getViewGroup().findViewById(R.id.no);
        this.lpk = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.lpl = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.lpm = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.yesButton.setOnClickListener(this);
        this.noButton.setOnClickListener(this);
        ap.setBackgroundResource(this.yesButton, R.drawable.dialog_single_button_bg_selector);
        ap.setViewTextColor(this.yesButton, R.color.CAM_X0302);
        ap.setViewTextColor(this.noButton, R.color.CAM_X0302);
        ap.setViewTextColor(this.lpi, R.color.CAM_X0105);
        ap.setViewTextColor(this.lpj, R.color.common_color_10122);
        ap.setBackgroundColor(this.lpk, R.color.CAM_X0204);
        ap.setBackgroundColor(this.lpl, R.color.CAM_X0204);
        ap.setBackgroundResource(this.lpm, R.drawable.dialog_background);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.yesButton) {
            if (this.lpf != null && this.lpf.rightButton != null && !StringUtils.isNull(this.lpf.rightButton.action)) {
                bf.bqF().b(getTbPageContext(), new String[]{this.lpf.rightButton.action});
            }
            if (this.lpg != null) {
                this.lpg.dismiss();
            }
            ar arVar = new ar(b.a.CLICK);
            arVar.ak("obj_locate", 2);
            TiebaStatic.log(arVar);
        } else if (view == this.noButton) {
            if (this.lpf != null && this.lpf.leftButton != null && !StringUtils.isNull(this.lpf.leftButton.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, this.lpf.leftButton.action, true)));
            }
            if (this.lpg != null) {
                this.lpg.dismiss();
            }
            ar arVar2 = new ar(b.a.CLICK);
            arVar2.ak("obj_locate", 1);
            TiebaStatic.log(arVar2);
        }
    }
}
