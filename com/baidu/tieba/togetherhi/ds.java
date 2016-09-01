package com.baidu.tieba.togetherhi;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.richText.n;
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ds extends FrameLayout implements View.OnClickListener {
    private TextView aYh;
    private TextView ahp;
    private TextView bLH;
    private View fJY;
    private TextView fJZ;
    private TextView fKa;
    private TextView fKb;
    private PbTogetherhiAvatarList fKc;
    private Context mContext;
    private n togetherHiInfo;

    public ds(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.tb_richtext_togetherhi_plan, this);
        this.fJY = inflate.findViewById(t.g.togetherhi_plan_layout);
        this.aYh = (TextView) inflate.findViewById(t.g.togetherhi_activity_title);
        this.ahp = (TextView) inflate.findViewById(t.g.togetherhi_activity_location);
        this.bLH = (TextView) inflate.findViewById(t.g.togetherhi_activity_time);
        this.fJZ = (TextView) inflate.findViewById(t.g.togetherhi_activity_user_number);
        this.fKa = (TextView) inflate.findViewById(t.g.togetherhi_activity_user_number_tv1);
        this.fKb = (TextView) inflate.findViewById(t.g.togetherhi_activity_user_number_tv2);
        this.fKc = (PbTogetherhiAvatarList) inflate.findViewById(t.g.togetherhi_avatar_list);
        inflate.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(n nVar) {
        if (nVar == null) {
            setVisibility(8);
            return;
        }
        this.togetherHiInfo = nVar;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.aYh.setText(nVar.UO);
        if (TextUtils.isEmpty(nVar.location)) {
            this.ahp.setVisibility(8);
        } else {
            this.ahp.setVisibility(0);
            this.ahp.setText(nVar.location);
        }
        this.bLH.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(nVar.startTime * 1000)));
        this.fJZ.setText(Integer.toString(nVar.UT));
        this.fKc.setPortraitList(nVar.UU);
    }

    public void reset() {
        this.fKc.reset();
        this.bLH.setText("");
        this.aYh.setText("");
        this.ahp.setText("");
        this.fJZ.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        av.k(this.fJY, t.f.pb_togetherhi_content_selector);
        av.c(this.aYh, t.d.cp_link_tip_a, 1);
        av.c(this.ahp, t.d.cp_cont_c, 1);
        av.c(this.bLH, t.d.cp_cont_c, 1);
        av.c(this.fJZ, t.d.cp_cont_b, 1);
        av.c(this.fKa, t.d.cp_cont_c, 1);
        av.c(this.fKb, t.d.cp_cont_c, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.UQ), this.togetherHiInfo.UO, this.togetherHiInfo.startTime, this.togetherHiInfo.UR, this.togetherHiInfo.location, this.togetherHiInfo.UT, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dt(context), i, 0);
    }
}
