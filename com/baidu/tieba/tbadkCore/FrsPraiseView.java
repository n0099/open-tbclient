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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView bcZ;
    private View cex;
    private TextView gXT;
    private TextView gXU;
    private PraiseData gXV;
    private boolean gXW;
    private boolean gaC;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gaC = false;
        this.gXW = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaC = false;
        this.gXW = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cex = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.bcZ = (TextView) this.cex.findViewById(d.g.frs_go_praise_list_num);
        this.gXT = (TextView) this.cex.findViewById(d.g.frs_praise_user_name_text1);
        this.gXU = (TextView) this.cex.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gXV != null) {
                    str = FrsPraiseView.this.gXV.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gaC));
            }
        });
        this.gXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gXV.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gXV.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.gXV = praiseData;
            mC(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gaC = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gXW = z;
    }

    private void mC(boolean z) {
        long num = this.gXV.getNum();
        this.gXU.setVisibility(8);
        this.gXT.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gXV.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gXT.setVisibility(0);
                        this.gXT.setText(sy(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gXT.setVisibility(0);
                        this.gXT.setText(sy(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gXU.setVisibility(0);
                        this.gXU.setText("、" + sy(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.bcZ.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.bcZ.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.bcZ.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String sy(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void gB(int i) {
        if (this.gaC) {
            if (this.gXW) {
                aj.s(this.cex, d.f.praise_video_selector);
                aj.e(this.bcZ, d.C0141d.cp_cont_c, 1);
                aj.e(this.gXT, d.C0141d.cp_link_tip_c, 1);
                aj.e(this.gXU, d.C0141d.cp_link_tip_c, 1);
                return;
            }
            aj.s(this.cex, d.f.praise_head_selector);
            aj.e(this.bcZ, d.C0141d.cp_cont_d, 1);
            aj.e(this.gXT, d.C0141d.cp_link_tip_c, 1);
            aj.e(this.gXU, d.C0141d.cp_link_tip_c, 1);
            return;
        }
        aj.s(this.cex, d.f.praise_view_btn_color);
        aj.e(this.bcZ, d.C0141d.cp_cont_d, 1);
        aj.e(this.gXT, d.C0141d.cp_cont_c, 1);
        aj.e(this.gXU, d.C0141d.cp_cont_c, 1);
    }
}
