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
    private TextView ged;
    private TextView gee;
    private PraiseData gef;
    private boolean geg;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eSb = false;
        this.geg = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSb = false;
        this.geg = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cKx = View.inflate(this.mContext, d.j.frs_item_praise, this);
        this.amL = (TextView) this.cKx.findViewById(d.h.frs_go_praise_list_num);
        this.ged = (TextView) this.cKx.findViewById(d.h.frs_praise_user_name_text1);
        this.gee = (TextView) this.cKx.findViewById(d.h.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gef != null) {
                    str = FrsPraiseView.this.gef.getTitle();
                }
                com.baidu.tbadk.util.k.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.eSb));
            }
        });
        this.gee.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gef.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.ged.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gef.getUser().get(0);
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
            this.gef = praiseData;
            mw(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eSb = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.geg = z;
    }

    private void mw(boolean z) {
        long num = this.gef.getNum();
        this.gee.setVisibility(8);
        this.ged.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gef.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.ged.setVisibility(0);
                        this.ged.setText(rB(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.ged.setVisibility(0);
                        this.ged.setText(rB(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gee.setVisibility(0);
                        this.gee.setText("、" + rB(user.get(1).getName_show()));
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
            if (this.geg) {
                aj.j(this.cKx, d.g.praise_video_selector);
                aj.c(this.amL, d.e.cp_cont_c, 1);
                aj.c(this.ged, d.e.cp_link_tip_c, 1);
                aj.c(this.gee, d.e.cp_link_tip_c, 1);
                return;
            }
            aj.j(this.cKx, d.g.praise_head_selector);
            aj.c(this.amL, d.e.cp_cont_d, 1);
            aj.c(this.ged, d.e.cp_link_tip_c, 1);
            aj.c(this.gee, d.e.cp_link_tip_c, 1);
            return;
        }
        aj.j(this.cKx, d.g.praise_view_btn_color);
        aj.c(this.amL, d.e.cp_cont_d, 1);
        aj.c(this.ged, d.e.cp_cont_c, 1);
        aj.c(this.gee, d.e.cp_cont_c, 1);
    }
}
