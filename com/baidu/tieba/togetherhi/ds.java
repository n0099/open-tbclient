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
    private TextView aSZ;
    private TextView aeu;
    private TextView bAf;
    private View fBD;
    private TextView fBE;
    private TextView fBF;
    private TextView fBG;
    private PbTogetherhiAvatarList fBH;
    private Context mContext;
    private n togetherHiInfo;

    public ds(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(u.h.tb_richtext_togetherhi_plan, this);
        this.fBD = inflate.findViewById(u.g.togetherhi_plan_layout);
        this.aSZ = (TextView) inflate.findViewById(u.g.togetherhi_activity_title);
        this.aeu = (TextView) inflate.findViewById(u.g.togetherhi_activity_location);
        this.bAf = (TextView) inflate.findViewById(u.g.togetherhi_activity_time);
        this.fBE = (TextView) inflate.findViewById(u.g.togetherhi_activity_user_number);
        this.fBF = (TextView) inflate.findViewById(u.g.togetherhi_activity_user_number_tv1);
        this.fBG = (TextView) inflate.findViewById(u.g.togetherhi_activity_user_number_tv2);
        this.fBH = (PbTogetherhiAvatarList) inflate.findViewById(u.g.togetherhi_avatar_list);
        inflate.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
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
        this.aSZ.setText(nVar.RZ);
        if (TextUtils.isEmpty(nVar.location)) {
            this.aeu.setVisibility(8);
        } else {
            this.aeu.setVisibility(0);
            this.aeu.setText(nVar.location);
        }
        this.bAf.setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(nVar.startTime * 1000)));
        this.fBE.setText(Integer.toString(nVar.Sd));
        this.fBH.setPortraitList(nVar.Se);
    }

    public void reset() {
        this.fBH.reset();
        this.bAf.setText("");
        this.aSZ.setText("");
        this.aeu.setText("");
        this.fBE.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        av.k(this.fBD, u.f.pb_togetherhi_content_selector);
        av.c(this.aSZ, u.d.cp_link_tip_a, 1);
        av.c(this.aeu, u.d.cp_cont_c, 1);
        av.c(this.bAf, u.d.cp_cont_c, 1);
        av.c(this.fBE, u.d.cp_cont_b, 1);
        av.c(this.fBF, u.d.cp_cont_c, 1);
        av.c(this.fBG, u.d.cp_cont_c, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.Sa), this.togetherHiInfo.RZ, this.togetherHiInfo.startTime, this.togetherHiInfo.Sb, this.togetherHiInfo.location, this.togetherHiInfo.Sd, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dt(context), i, 0);
    }
}
