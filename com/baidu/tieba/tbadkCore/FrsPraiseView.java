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
/* loaded from: classes6.dex */
public class FrsPraiseView extends LinearLayout {
    private View bSM;
    private boolean gmX;
    private TextView hmF;
    private TextView hmG;
    private TextView hmH;
    private PraiseData hmI;
    private boolean hmJ;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gmX = false;
        this.hmJ = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmX = false;
        this.hmJ = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bSM = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.hmF = (TextView) this.bSM.findViewById(e.g.frs_go_praise_list_num);
        this.hmG = (TextView) this.bSM.findViewById(e.g.frs_praise_user_name_text1);
        this.hmH = (TextView) this.bSM.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.hmI != null) {
                    str = FrsPraiseView.this.hmI.getTitle();
                }
                com.baidu.tbadk.util.o.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gmX));
            }
        });
        this.hmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hmI.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.hmG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hmI.getUser().get(0);
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
            this.hmI = praiseData;
            nq(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gmX = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.hmJ = z;
    }

    private void nq(boolean z) {
        long num = this.hmI.getNum();
        this.hmH.setVisibility(8);
        this.hmG.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.hmI.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.hmG.setVisibility(0);
                        this.hmG.setText(vI(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.hmG.setVisibility(0);
                        this.hmG.setText(vI(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hmH.setVisibility(0);
                        this.hmH.setText("、" + vI(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.hmF.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.hmF.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.hmF.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
            }
        }
    }

    private String vI(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void eD(int i) {
        if (this.gmX) {
            if (this.hmJ) {
                al.i(this.bSM, e.f.praise_video_selector);
                al.c(this.hmF, e.d.cp_cont_c, 1);
                al.c(this.hmG, e.d.cp_link_tip_c, 1);
                al.c(this.hmH, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bSM, e.f.praise_head_selector);
            al.c(this.hmF, e.d.cp_cont_d, 1);
            al.c(this.hmG, e.d.cp_link_tip_c, 1);
            al.c(this.hmH, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bSM, e.f.praise_view_btn_color);
        al.c(this.hmF, e.d.cp_cont_d, 1);
        al.c(this.hmG, e.d.cp_cont_c, 1);
        al.c(this.hmH, e.d.cp_cont_c, 1);
    }
}
