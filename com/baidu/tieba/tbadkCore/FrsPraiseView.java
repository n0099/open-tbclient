package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView bbt;
    private View dVD;
    private boolean fXF;
    private TextView gVP;
    private TextView gVQ;
    private PraiseData gVR;
    private boolean gVS;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fXF = false;
        this.gVS = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXF = false;
        this.gVS = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dVD = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.bbt = (TextView) this.dVD.findViewById(d.g.frs_go_praise_list_num);
        this.gVP = (TextView) this.dVD.findViewById(d.g.frs_praise_user_name_text1);
        this.gVQ = (TextView) this.dVD.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gVR != null) {
                    str = FrsPraiseView.this.gVR.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fXF));
            }
        });
        this.gVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gVR.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gVR.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.gVR = praiseData;
            mu(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fXF = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gVS = z;
    }

    private void mu(boolean z) {
        long num = this.gVR.getNum();
        this.gVQ.setVisibility(8);
        this.gVP.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gVR.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gVP.setVisibility(0);
                        this.gVP.setText(sp(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gVP.setVisibility(0);
                        this.gVP.setText(sp(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gVQ.setVisibility(0);
                        this.gVQ.setText("、" + sp(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.bbt.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.bbt.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.bbt.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String sp(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void gz(int i) {
        if (this.fXF) {
            if (this.gVS) {
                aj.s(this.dVD, d.f.praise_video_selector);
                aj.e(this.bbt, d.C0108d.cp_cont_c, 1);
                aj.e(this.gVP, d.C0108d.cp_link_tip_c, 1);
                aj.e(this.gVQ, d.C0108d.cp_link_tip_c, 1);
                return;
            }
            aj.s(this.dVD, d.f.praise_head_selector);
            aj.e(this.bbt, d.C0108d.cp_cont_d, 1);
            aj.e(this.gVP, d.C0108d.cp_link_tip_c, 1);
            aj.e(this.gVQ, d.C0108d.cp_link_tip_c, 1);
            return;
        }
        aj.s(this.dVD, d.f.praise_view_btn_color);
        aj.e(this.bbt, d.C0108d.cp_cont_d, 1);
        aj.e(this.gVP, d.C0108d.cp_cont_c, 1);
        aj.e(this.gVQ, d.C0108d.cp_cont_c, 1);
    }
}
