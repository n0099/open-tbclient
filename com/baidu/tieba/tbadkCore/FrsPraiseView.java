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
    private TextView amL;
    private View cKx;
    private boolean eSb;
    private TextView gee;
    private TextView gef;
    private PraiseData geg;
    private boolean geh;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eSb = false;
        this.geh = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSb = false;
        this.geh = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cKx = View.inflate(this.mContext, d.j.frs_item_praise, this);
        this.amL = (TextView) this.cKx.findViewById(d.h.frs_go_praise_list_num);
        this.gee = (TextView) this.cKx.findViewById(d.h.frs_praise_user_name_text1);
        this.gef = (TextView) this.cKx.findViewById(d.h.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.geg != null) {
                    str = FrsPraiseView.this.geg.getTitle();
                }
                com.baidu.tbadk.util.k.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.eSb));
            }
        });
        this.gef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.geg.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gee.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.geg.getUser().get(0);
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
            this.geg = praiseData;
            mw(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eSb = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.geh = z;
    }

    private void mw(boolean z) {
        long num = this.geg.getNum();
        this.gef.setVisibility(8);
        this.gee.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.geg.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gee.setVisibility(0);
                        this.gee.setText(rB(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gee.setVisibility(0);
                        this.gee.setText(rB(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gef.setVisibility(0);
                        this.gef.setText("、" + rB(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.amL.setText(this.mContext.getString(d.l.common_praise_view_text));
            } else if (num <= 999999) {
                this.amL.setText(this.mContext.getString(d.l.etc) + num + this.mContext.getString(d.l.common_praise_view_text2));
            } else {
                this.amL.setText(this.mContext.getString(d.l.etc) + "999999+" + this.mContext.getString(d.l.common_praise_view_text2));
            }
        }
    }

    private String rB(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dE(int i) {
        if (this.eSb) {
            if (this.geh) {
                aj.j(this.cKx, d.g.praise_video_selector);
                aj.c(this.amL, d.e.cp_cont_c, 1);
                aj.c(this.gee, d.e.cp_link_tip_c, 1);
                aj.c(this.gef, d.e.cp_link_tip_c, 1);
                return;
            }
            aj.j(this.cKx, d.g.praise_head_selector);
            aj.c(this.amL, d.e.cp_cont_d, 1);
            aj.c(this.gee, d.e.cp_link_tip_c, 1);
            aj.c(this.gef, d.e.cp_link_tip_c, 1);
            return;
        }
        aj.j(this.cKx, d.g.praise_view_btn_color);
        aj.c(this.amL, d.e.cp_cont_d, 1);
        aj.c(this.gee, d.e.cp_cont_c, 1);
        aj.c(this.gef, d.e.cp_cont_c, 1);
    }
}
