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
import com.baidu.tieba.u;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ds extends FrameLayout implements View.OnClickListener {
    private TextView aSd;
    private TextView adG;
    private TextView bxR;
    private View foD;
    private TextView foE;
    private TextView foF;
    private TextView foG;
    private PbTogetherhiAvatarList foH;
    private Context mContext;
    private n togetherHiInfo;

    public ds(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(u.h.tb_richtext_togetherhi_plan, this);
        this.foD = inflate.findViewById(u.g.togetherhi_plan_layout);
        this.aSd = (TextView) inflate.findViewById(u.g.togetherhi_activity_title);
        this.adG = (TextView) inflate.findViewById(u.g.togetherhi_activity_location);
        this.bxR = (TextView) inflate.findViewById(u.g.togetherhi_activity_time);
        this.foE = (TextView) inflate.findViewById(u.g.togetherhi_activity_user_number);
        this.foF = (TextView) inflate.findViewById(u.g.togetherhi_activity_user_number_tv1);
        this.foG = (TextView) inflate.findViewById(u.g.togetherhi_activity_user_number_tv2);
        this.foH = (PbTogetherhiAvatarList) inflate.findViewById(u.g.togetherhi_avatar_list);
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
        this.aSd.setText(nVar.Rp);
        if (TextUtils.isEmpty(nVar.location)) {
            this.adG.setVisibility(8);
        } else {
            this.adG.setVisibility(0);
            this.adG.setText(nVar.location);
        }
        this.bxR.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(nVar.startTime * 1000)));
        this.foE.setText(Integer.toString(nVar.Rt));
        this.foH.setPortraitList(nVar.Ru);
    }

    public void reset() {
        this.foH.reset();
        this.bxR.setText("");
        this.aSd.setText("");
        this.adG.setText("");
        this.foE.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        av.k(this.foD, u.f.pb_togetherhi_content_selector);
        av.c(this.aSd, u.d.cp_link_tip_a, 1);
        av.c(this.adG, u.d.cp_cont_c, 1);
        av.c(this.bxR, u.d.cp_cont_c, 1);
        av.c(this.foE, u.d.cp_cont_b, 1);
        av.c(this.foF, u.d.cp_cont_c, 1);
        av.c(this.foG, u.d.cp_cont_c, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.Rq), this.togetherHiInfo.Rp, this.togetherHiInfo.startTime, this.togetherHiInfo.Rr, this.togetherHiInfo.location, this.togetherHiInfo.Rt, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dt(context), i, 0);
    }
}
