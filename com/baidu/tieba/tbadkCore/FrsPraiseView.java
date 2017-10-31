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
    private TextView amU;
    private View cTw;
    private boolean fav;
    private TextView gmB;
    private TextView gmC;
    private PraiseData gmD;
    private boolean gmE;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fav = false;
        this.gmE = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fav = false;
        this.gmE = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cTw = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.amU = (TextView) this.cTw.findViewById(d.g.frs_go_praise_list_num);
        this.gmB = (TextView) this.cTw.findViewById(d.g.frs_praise_user_name_text1);
        this.gmC = (TextView) this.cTw.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gmD != null) {
                    str = FrsPraiseView.this.gmD.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fav));
            }
        });
        this.gmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gmD.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gmD.getUser().get(0);
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
            this.gmD = praiseData;
            mq(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fav = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gmE = z;
    }

    private void mq(boolean z) {
        long num = this.gmD.getNum();
        this.gmC.setVisibility(8);
        this.gmB.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gmD.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gmB.setVisibility(0);
                        this.gmB.setText(si(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gmB.setVisibility(0);
                        this.gmB.setText(si(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gmC.setVisibility(0);
                        this.gmC.setText("、" + si(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.amU.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.amU.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.amU.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String si(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dE(int i) {
        if (this.fav) {
            if (this.gmE) {
                aj.j(this.cTw, d.f.praise_video_selector);
                aj.c(this.amU, d.C0080d.cp_cont_c, 1);
                aj.c(this.gmB, d.C0080d.cp_link_tip_c, 1);
                aj.c(this.gmC, d.C0080d.cp_link_tip_c, 1);
                return;
            }
            aj.j(this.cTw, d.f.praise_head_selector);
            aj.c(this.amU, d.C0080d.cp_cont_d, 1);
            aj.c(this.gmB, d.C0080d.cp_link_tip_c, 1);
            aj.c(this.gmC, d.C0080d.cp_link_tip_c, 1);
            return;
        }
        aj.j(this.cTw, d.f.praise_view_btn_color);
        aj.c(this.amU, d.C0080d.cp_cont_d, 1);
        aj.c(this.gmB, d.C0080d.cp_cont_c, 1);
        aj.c(this.gmC, d.C0080d.cp_cont_c, 1);
    }
}
