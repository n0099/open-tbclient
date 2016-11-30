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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.n;
import com.baidu.tieba.r;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ds extends FrameLayout implements View.OnClickListener {
    private TextView aOH;
    private TextView ahy;
    private TextView bOB;
    private View fTV;
    private TextView fTW;
    private TextView fTX;
    private TextView fTY;
    private PbTogetherhiAvatarList fTZ;
    private Context mContext;
    private n togetherHiInfo;

    public ds(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.tb_richtext_togetherhi_plan, this);
        this.fTV = inflate.findViewById(r.g.togetherhi_plan_layout);
        this.aOH = (TextView) inflate.findViewById(r.g.togetherhi_activity_title);
        this.ahy = (TextView) inflate.findViewById(r.g.togetherhi_activity_location);
        this.bOB = (TextView) inflate.findViewById(r.g.togetherhi_activity_time);
        this.fTW = (TextView) inflate.findViewById(r.g.togetherhi_activity_user_number);
        this.fTX = (TextView) inflate.findViewById(r.g.togetherhi_activity_user_number_tv1);
        this.fTY = (TextView) inflate.findViewById(r.g.togetherhi_activity_user_number_tv2);
        this.fTZ = (PbTogetherhiAvatarList) inflate.findViewById(r.g.togetherhi_avatar_list);
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
        this.aOH.setText(nVar.Vx);
        if (TextUtils.isEmpty(nVar.location)) {
            this.ahy.setVisibility(8);
        } else {
            this.ahy.setVisibility(0);
            this.ahy.setText(nVar.location);
        }
        this.bOB.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(nVar.startTime * 1000)));
        this.fTW.setText(Integer.toString(nVar.VB));
        this.fTZ.setPortraitList(nVar.VC);
    }

    public void reset() {
        this.fTZ.reset();
        this.bOB.setText("");
        this.aOH.setText("");
        this.ahy.setText("");
        this.fTW.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        at.k(this.fTV, r.f.pb_togetherhi_content_selector);
        at.c(this.aOH, r.d.cp_link_tip_a, 1);
        at.c(this.ahy, r.d.cp_cont_c, 1);
        at.c(this.bOB, r.d.cp_cont_c, 1);
        at.c(this.fTW, r.d.cp_cont_b, 1);
        at.c(this.fTX, r.d.cp_cont_c, 1);
        at.c(this.fTY, r.d.cp_cont_c, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.Vy), this.togetherHiInfo.Vx, this.togetherHiInfo.startTime, this.togetherHiInfo.Vz, this.togetherHiInfo.location, this.togetherHiInfo.VB, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dt(context), i, 0);
    }
}
