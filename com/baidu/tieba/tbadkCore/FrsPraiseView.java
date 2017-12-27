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
    private TextView bbl;
    private View dQu;
    private boolean fVK;
    private TextView hfV;
    private TextView hfW;
    private PraiseData hfX;
    private boolean hfY;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fVK = false;
        this.hfY = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVK = false;
        this.hfY = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dQu = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.bbl = (TextView) this.dQu.findViewById(d.g.frs_go_praise_list_num);
        this.hfV = (TextView) this.dQu.findViewById(d.g.frs_praise_user_name_text1);
        this.hfW = (TextView) this.dQu.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.hfX != null) {
                    str = FrsPraiseView.this.hfX.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fVK));
            }
        });
        this.hfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hfX.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.hfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hfX.getUser().get(0);
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
            this.hfX = praiseData;
            nq(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fVK = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.hfY = z;
    }

    private void nq(boolean z) {
        long num = this.hfX.getNum();
        this.hfW.setVisibility(8);
        this.hfV.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.hfX.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.hfV.setVisibility(0);
                        this.hfV.setText(sP(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.hfV.setVisibility(0);
                        this.hfV.setText(sP(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hfW.setVisibility(0);
                        this.hfW.setText("、" + sP(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.bbl.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.bbl.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.bbl.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String sP(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void gC(int i) {
        if (this.fVK) {
            if (this.hfY) {
                aj.s(this.dQu, d.f.praise_video_selector);
                aj.e(this.bbl, d.C0108d.cp_cont_c, 1);
                aj.e(this.hfV, d.C0108d.cp_link_tip_c, 1);
                aj.e(this.hfW, d.C0108d.cp_link_tip_c, 1);
                return;
            }
            aj.s(this.dQu, d.f.praise_head_selector);
            aj.e(this.bbl, d.C0108d.cp_cont_d, 1);
            aj.e(this.hfV, d.C0108d.cp_link_tip_c, 1);
            aj.e(this.hfW, d.C0108d.cp_link_tip_c, 1);
            return;
        }
        aj.s(this.dQu, d.f.praise_view_btn_color);
        aj.e(this.bbl, d.C0108d.cp_cont_d, 1);
        aj.e(this.hfV, d.C0108d.cp_cont_c, 1);
        aj.e(this.hfW, d.C0108d.cp_cont_c, 1);
    }
}
