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
import com.baidu.tieba.t;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ds extends FrameLayout implements View.OnClickListener {
    private TextView aOG;
    private TextView adi;
    private TextView bbW;
    private View eJI;
    private TextView eJJ;
    private TextView eJK;
    private TextView eJL;
    private PbTogetherhiAvatarList eJM;
    private Context mContext;
    private n togetherHiInfo;

    public ds(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.tb_richtext_togetherhi_plan, this);
        this.eJI = inflate.findViewById(t.g.togetherhi_plan_layout);
        this.aOG = (TextView) inflate.findViewById(t.g.togetherhi_activity_title);
        this.adi = (TextView) inflate.findViewById(t.g.togetherhi_activity_location);
        this.bbW = (TextView) inflate.findViewById(t.g.togetherhi_activity_time);
        this.eJJ = (TextView) inflate.findViewById(t.g.togetherhi_activity_user_number);
        this.eJK = (TextView) inflate.findViewById(t.g.togetherhi_activity_user_number_tv1);
        this.eJL = (TextView) inflate.findViewById(t.g.togetherhi_activity_user_number_tv2);
        this.eJM = (PbTogetherhiAvatarList) inflate.findViewById(t.g.togetherhi_avatar_list);
        inflate.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
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
        this.aOG.setText(nVar.QX);
        if (TextUtils.isEmpty(nVar.location)) {
            this.adi.setVisibility(8);
        } else {
            this.adi.setVisibility(0);
            this.adi.setText(nVar.location);
        }
        this.bbW.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(nVar.startTime * 1000)));
        this.eJJ.setText(Integer.toString(nVar.Rb));
        this.eJM.setPortraitList(nVar.Rc);
    }

    public void reset() {
        this.eJM.reset();
        this.bbW.setText("");
        this.aOG.setText("");
        this.adi.setText("");
        this.eJJ.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        at.k(this.eJI, t.f.pb_togetherhi_content_selector);
        at.c(this.aOG, t.d.cp_link_tip_a, 1);
        at.c(this.adi, t.d.cp_cont_c, 1);
        at.c(this.bbW, t.d.cp_cont_c, 1);
        at.c(this.eJJ, t.d.cp_cont_b, 1);
        at.c(this.eJK, t.d.cp_cont_c, 1);
        at.c(this.eJL, t.d.cp_cont_c, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.QY), this.togetherHiInfo.QX, this.togetherHiInfo.startTime, this.togetherHiInfo.QZ, this.togetherHiInfo.location, this.togetherHiInfo.Rb, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dt(context), i, 0);
    }
}
