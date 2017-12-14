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
    private TextView ank;
    private View def;
    private boolean fiJ;
    private TextView gze;
    private TextView gzf;
    private PraiseData gzg;
    private boolean gzh;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fiJ = false;
        this.gzh = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fiJ = false;
        this.gzh = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.def = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.ank = (TextView) this.def.findViewById(d.g.frs_go_praise_list_num);
        this.gze = (TextView) this.def.findViewById(d.g.frs_praise_user_name_text1);
        this.gzf = (TextView) this.def.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gzg != null) {
                    str = FrsPraiseView.this.gzg.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fiJ));
            }
        });
        this.gzf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gzg.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gze.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gzg.getUser().get(0);
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
            this.gzg = praiseData;
            mX(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fiJ = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gzh = z;
    }

    private void mX(boolean z) {
        long num = this.gzg.getNum();
        this.gzf.setVisibility(8);
        this.gze.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gzg.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gze.setVisibility(0);
                        this.gze.setText(sP(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gze.setVisibility(0);
                        this.gze.setText(sP(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gzf.setVisibility(0);
                        this.gzf.setText("、" + sP(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.ank.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.ank.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.ank.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String sP(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dE(int i) {
        if (this.fiJ) {
            if (this.gzh) {
                aj.j(this.def, d.f.praise_video_selector);
                aj.c(this.ank, d.C0096d.cp_cont_c, 1);
                aj.c(this.gze, d.C0096d.cp_link_tip_c, 1);
                aj.c(this.gzf, d.C0096d.cp_link_tip_c, 1);
                return;
            }
            aj.j(this.def, d.f.praise_head_selector);
            aj.c(this.ank, d.C0096d.cp_cont_d, 1);
            aj.c(this.gze, d.C0096d.cp_link_tip_c, 1);
            aj.c(this.gzf, d.C0096d.cp_link_tip_c, 1);
            return;
        }
        aj.j(this.def, d.f.praise_view_btn_color);
        aj.c(this.ank, d.C0096d.cp_cont_d, 1);
        aj.c(this.gze, d.C0096d.cp_cont_c, 1);
        aj.c(this.gzf, d.C0096d.cp_cont_c, 1);
    }
}
