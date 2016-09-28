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
import com.baidu.tieba.r;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class ds extends FrameLayout implements View.OnClickListener {
    private TextView aMI;
    private TextView agY;
    private TextView bLI;
    private View fMu;
    private TextView fMv;
    private TextView fMw;
    private TextView fMx;
    private PbTogetherhiAvatarList fMy;
    private Context mContext;
    private n togetherHiInfo;

    public ds(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.tb_richtext_togetherhi_plan, this);
        this.fMu = inflate.findViewById(r.g.togetherhi_plan_layout);
        this.aMI = (TextView) inflate.findViewById(r.g.togetherhi_activity_title);
        this.agY = (TextView) inflate.findViewById(r.g.togetherhi_activity_location);
        this.bLI = (TextView) inflate.findViewById(r.g.togetherhi_activity_time);
        this.fMv = (TextView) inflate.findViewById(r.g.togetherhi_activity_user_number);
        this.fMw = (TextView) inflate.findViewById(r.g.togetherhi_activity_user_number_tv1);
        this.fMx = (TextView) inflate.findViewById(r.g.togetherhi_activity_user_number_tv2);
        this.fMy = (PbTogetherhiAvatarList) inflate.findViewById(r.g.togetherhi_avatar_list);
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
        this.aMI.setText(nVar.UZ);
        if (TextUtils.isEmpty(nVar.location)) {
            this.agY.setVisibility(8);
        } else {
            this.agY.setVisibility(0);
            this.agY.setText(nVar.location);
        }
        this.bLI.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(nVar.startTime * 1000)));
        this.fMv.setText(Integer.toString(nVar.Vd));
        this.fMy.setPortraitList(nVar.Ve);
    }

    public void reset() {
        this.fMy.reset();
        this.bLI.setText("");
        this.aMI.setText("");
        this.agY.setText("");
        this.fMv.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        av.k(this.fMu, r.f.pb_togetherhi_content_selector);
        av.c(this.aMI, r.d.cp_link_tip_a, 1);
        av.c(this.agY, r.d.cp_cont_c, 1);
        av.c(this.bLI, r.d.cp_cont_c, 1);
        av.c(this.fMv, r.d.cp_cont_b, 1);
        av.c(this.fMw, r.d.cp_cont_c, 1);
        av.c(this.fMx, r.d.cp_cont_c, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.Va), this.togetherHiInfo.UZ, this.togetherHiInfo.startTime, this.togetherHiInfo.Vb, this.togetherHiInfo.location, this.togetherHiInfo.Vd, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dt(context), i, 0);
    }
}
