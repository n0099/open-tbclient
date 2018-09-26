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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsPraiseView extends LinearLayout {
    private View bES;
    private boolean fTn;
    private TextView gSD;
    private TextView gSE;
    private TextView gSF;
    private PraiseData gSG;
    private boolean gSH;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fTn = false;
        this.gSH = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fTn = false;
        this.gSH = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bES = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.gSD = (TextView) this.bES.findViewById(e.g.frs_go_praise_list_num);
        this.gSE = (TextView) this.bES.findViewById(e.g.frs_praise_user_name_text1);
        this.gSF = (TextView) this.bES.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gSG != null) {
                    str = FrsPraiseView.this.gSG.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fTn));
            }
        });
        this.gSF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gSG.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gSE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gSG.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.gSG = praiseData;
            mI(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fTn = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gSH = z;
    }

    private void mI(boolean z) {
        long num = this.gSG.getNum();
        this.gSF.setVisibility(8);
        this.gSE.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gSG.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gSE.setVisibility(0);
                        this.gSE.setText(ui(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gSE.setVisibility(0);
                        this.gSE.setText(ui(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gSF.setVisibility(0);
                        this.gSF.setText("、" + ui(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.gSD.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.gSD.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.gSD.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
            }
        }
    }

    private String ui(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dQ(int i) {
        if (this.fTn) {
            if (this.gSH) {
                al.i(this.bES, e.f.praise_video_selector);
                al.c(this.gSD, e.d.cp_cont_c, 1);
                al.c(this.gSE, e.d.cp_link_tip_c, 1);
                al.c(this.gSF, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bES, e.f.praise_head_selector);
            al.c(this.gSD, e.d.cp_cont_d, 1);
            al.c(this.gSE, e.d.cp_link_tip_c, 1);
            al.c(this.gSF, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bES, e.f.praise_view_btn_color);
        al.c(this.gSD, e.d.cp_cont_d, 1);
        al.c(this.gSE, e.d.cp_cont_c, 1);
        al.c(this.gSF, e.d.cp_cont_c, 1);
    }
}
