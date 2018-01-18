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
    private View dVi;
    private boolean fXk;
    private TextView gVv;
    private TextView gVw;
    private PraiseData gVx;
    private boolean gVy;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fXk = false;
        this.gVy = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXk = false;
        this.gVy = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dVi = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.bbl = (TextView) this.dVi.findViewById(d.g.frs_go_praise_list_num);
        this.gVv = (TextView) this.dVi.findViewById(d.g.frs_praise_user_name_text1);
        this.gVw = (TextView) this.dVi.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gVx != null) {
                    str = FrsPraiseView.this.gVx.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fXk));
            }
        });
        this.gVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gVx.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gVx.getUser().get(0);
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
            this.gVx = praiseData;
            ms(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fXk = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gVy = z;
    }

    private void ms(boolean z) {
        long num = this.gVx.getNum();
        this.gVw.setVisibility(8);
        this.gVv.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gVx.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gVv.setVisibility(0);
                        this.gVv.setText(si(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gVv.setVisibility(0);
                        this.gVv.setText(si(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gVw.setVisibility(0);
                        this.gVw.setText("、" + si(user.get(1).getName_show()));
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

    private String si(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void gz(int i) {
        if (this.fXk) {
            if (this.gVy) {
                aj.s(this.dVi, d.f.praise_video_selector);
                aj.e(this.bbl, d.C0107d.cp_cont_c, 1);
                aj.e(this.gVv, d.C0107d.cp_link_tip_c, 1);
                aj.e(this.gVw, d.C0107d.cp_link_tip_c, 1);
                return;
            }
            aj.s(this.dVi, d.f.praise_head_selector);
            aj.e(this.bbl, d.C0107d.cp_cont_d, 1);
            aj.e(this.gVv, d.C0107d.cp_link_tip_c, 1);
            aj.e(this.gVw, d.C0107d.cp_link_tip_c, 1);
            return;
        }
        aj.s(this.dVi, d.f.praise_view_btn_color);
        aj.e(this.bbl, d.C0107d.cp_cont_d, 1);
        aj.e(this.gVv, d.C0107d.cp_cont_c, 1);
        aj.e(this.gVw, d.C0107d.cp_cont_c, 1);
    }
}
