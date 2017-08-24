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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aoj;
    private View cCx;
    private boolean eYm;
    private TextView ghb;
    private TextView ghc;
    private PraiseData ghd;
    private boolean ghe;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eYm = false;
        this.ghe = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYm = false;
        this.ghe = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cCx = View.inflate(this.mContext, d.j.frs_item_praise, this);
        this.aoj = (TextView) this.cCx.findViewById(d.h.frs_go_praise_list_num);
        this.ghb = (TextView) this.cCx.findViewById(d.h.frs_praise_user_name_text1);
        this.ghc = (TextView) this.cCx.findViewById(d.h.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.ghd != null) {
                    str = FrsPraiseView.this.ghd.getTitle();
                }
                com.baidu.tbadk.util.l.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.eYm));
            }
        });
        this.ghc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.ghd.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.ghb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.ghd.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.ghd = praiseData;
            mu(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eYm = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.ghe = z;
    }

    private void mu(boolean z) {
        long num = this.ghd.getNum();
        this.ghc.setVisibility(8);
        this.ghb.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.ghd.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.ghb.setVisibility(0);
                        this.ghb.setText(rU(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.ghb.setVisibility(0);
                        this.ghb.setText(rU(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.ghc.setVisibility(0);
                        this.ghc.setText("、" + rU(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aoj.setText(this.mContext.getString(d.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.aoj.setText(this.mContext.getString(d.l.etc) + num + this.mContext.getString(d.l.common_praise_view_text2));
            } else {
                this.aoj.setText(this.mContext.getString(d.l.etc) + "999999+" + this.mContext.getString(d.l.common_praise_view_text2));
            }
        }
    }

    private String rU(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dt(int i) {
        if (this.eYm) {
            if (this.ghe) {
                ai.j(this.cCx, d.g.praise_video_selector);
                ai.c(this.aoj, d.e.cp_cont_c, 1);
                ai.c(this.ghb, d.e.cp_link_tip_c, 1);
                ai.c(this.ghc, d.e.cp_link_tip_c, 1);
                return;
            }
            ai.j(this.cCx, d.g.praise_head_selector);
            ai.c(this.aoj, d.e.cp_cont_d, 1);
            ai.c(this.ghb, d.e.cp_link_tip_c, 1);
            ai.c(this.ghc, d.e.cp_link_tip_c, 1);
            return;
        }
        ai.j(this.cCx, d.g.praise_view_btn_color);
        ai.c(this.aoj, d.e.cp_cont_d, 1);
        ai.c(this.ghb, d.e.cp_cont_c, 1);
        ai.c(this.ghc, d.e.cp_cont_c, 1);
    }
}
