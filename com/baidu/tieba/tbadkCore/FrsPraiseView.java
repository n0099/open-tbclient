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
    private TextView ann;
    private View dcY;
    private boolean fhJ;
    private TextView gww;
    private TextView gwx;
    private PraiseData gwy;
    private boolean gwz;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fhJ = false;
        this.gwz = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhJ = false;
        this.gwz = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dcY = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.ann = (TextView) this.dcY.findViewById(d.g.frs_go_praise_list_num);
        this.gww = (TextView) this.dcY.findViewById(d.g.frs_praise_user_name_text1);
        this.gwx = (TextView) this.dcY.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gwy != null) {
                    str = FrsPraiseView.this.gwy.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fhJ));
            }
        });
        this.gwx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gwy.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gwy.getUser().get(0);
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
            this.gwy = praiseData;
            mV(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fhJ = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gwz = z;
    }

    private void mV(boolean z) {
        long num = this.gwy.getNum();
        this.gwx.setVisibility(8);
        this.gww.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gwy.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gww.setVisibility(0);
                        this.gww.setText(sK(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gww.setVisibility(0);
                        this.gww.setText(sK(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gwx.setVisibility(0);
                        this.gwx.setText("、" + sK(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.ann.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.ann.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.ann.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String sK(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dE(int i) {
        if (this.fhJ) {
            if (this.gwz) {
                aj.j(this.dcY, d.f.praise_video_selector);
                aj.c(this.ann, d.C0082d.cp_cont_c, 1);
                aj.c(this.gww, d.C0082d.cp_link_tip_c, 1);
                aj.c(this.gwx, d.C0082d.cp_link_tip_c, 1);
                return;
            }
            aj.j(this.dcY, d.f.praise_head_selector);
            aj.c(this.ann, d.C0082d.cp_cont_d, 1);
            aj.c(this.gww, d.C0082d.cp_link_tip_c, 1);
            aj.c(this.gwx, d.C0082d.cp_link_tip_c, 1);
            return;
        }
        aj.j(this.dcY, d.f.praise_view_btn_color);
        aj.c(this.ann, d.C0082d.cp_cont_d, 1);
        aj.c(this.gww, d.C0082d.cp_cont_c, 1);
        aj.c(this.gwx, d.C0082d.cp_cont_c, 1);
    }
}
