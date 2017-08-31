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
    private TextView anD;
    private View cIN;
    private boolean eWY;
    private TextView gfD;
    private TextView gfE;
    private PraiseData gfF;
    private boolean gfG;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eWY = false;
        this.gfG = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWY = false;
        this.gfG = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cIN = View.inflate(this.mContext, d.j.frs_item_praise, this);
        this.anD = (TextView) this.cIN.findViewById(d.h.frs_go_praise_list_num);
        this.gfD = (TextView) this.cIN.findViewById(d.h.frs_praise_user_name_text1);
        this.gfE = (TextView) this.cIN.findViewById(d.h.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gfF != null) {
                    str = FrsPraiseView.this.gfF.getTitle();
                }
                com.baidu.tbadk.util.l.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.eWY));
            }
        });
        this.gfE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gfF.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gfF.getUser().get(0);
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
            this.gfF = praiseData;
            mA(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eWY = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gfG = z;
    }

    private void mA(boolean z) {
        long num = this.gfF.getNum();
        this.gfE.setVisibility(8);
        this.gfD.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gfF.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gfD.setVisibility(0);
                        this.gfD.setText(rP(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gfD.setVisibility(0);
                        this.gfD.setText(rP(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gfE.setVisibility(0);
                        this.gfE.setText("、" + rP(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.anD.setText(this.mContext.getString(d.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.anD.setText(this.mContext.getString(d.l.etc) + num + this.mContext.getString(d.l.common_praise_view_text2));
            } else {
                this.anD.setText(this.mContext.getString(d.l.etc) + "999999+" + this.mContext.getString(d.l.common_praise_view_text2));
            }
        }
    }

    private String rP(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void du(int i) {
        if (this.eWY) {
            if (this.gfG) {
                aj.j(this.cIN, d.g.praise_video_selector);
                aj.c(this.anD, d.e.cp_cont_c, 1);
                aj.c(this.gfD, d.e.cp_link_tip_c, 1);
                aj.c(this.gfE, d.e.cp_link_tip_c, 1);
                return;
            }
            aj.j(this.cIN, d.g.praise_head_selector);
            aj.c(this.anD, d.e.cp_cont_d, 1);
            aj.c(this.gfD, d.e.cp_link_tip_c, 1);
            aj.c(this.gfE, d.e.cp_link_tip_c, 1);
            return;
        }
        aj.j(this.cIN, d.g.praise_view_btn_color);
        aj.c(this.anD, d.e.cp_cont_d, 1);
        aj.c(this.gfD, d.e.cp_cont_c, 1);
        aj.c(this.gfE, d.e.cp_cont_c, 1);
    }
}
