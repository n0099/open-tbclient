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
    private View bSL;
    private boolean gmW;
    private TextView hmE;
    private TextView hmF;
    private TextView hmG;
    private PraiseData hmH;
    private boolean hmI;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gmW = false;
        this.hmI = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmW = false;
        this.hmI = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bSL = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.hmE = (TextView) this.bSL.findViewById(e.g.frs_go_praise_list_num);
        this.hmF = (TextView) this.bSL.findViewById(e.g.frs_praise_user_name_text1);
        this.hmG = (TextView) this.bSL.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.hmH != null) {
                    str = FrsPraiseView.this.hmH.getTitle();
                }
                com.baidu.tbadk.util.o.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gmW));
            }
        });
        this.hmG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hmH.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.hmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hmH.getUser().get(0);
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
            this.hmH = praiseData;
            nq(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gmW = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.hmI = z;
    }

    private void nq(boolean z) {
        long num = this.hmH.getNum();
        this.hmG.setVisibility(8);
        this.hmF.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.hmH.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.hmF.setVisibility(0);
                        this.hmF.setText(vI(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.hmF.setVisibility(0);
                        this.hmF.setText(vI(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hmG.setVisibility(0);
                        this.hmG.setText("、" + vI(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.hmE.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.hmE.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.hmE.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
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
        if (this.gmW) {
            if (this.hmI) {
                al.i(this.bSL, e.f.praise_video_selector);
                al.c(this.hmE, e.d.cp_cont_c, 1);
                al.c(this.hmF, e.d.cp_link_tip_c, 1);
                al.c(this.hmG, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bSL, e.f.praise_head_selector);
            al.c(this.hmE, e.d.cp_cont_d, 1);
            al.c(this.hmF, e.d.cp_link_tip_c, 1);
            al.c(this.hmG, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bSL, e.f.praise_view_btn_color);
        al.c(this.hmE, e.d.cp_cont_d, 1);
        al.c(this.hmF, e.d.cp_cont_c, 1);
        al.c(this.hmG, e.d.cp_cont_c, 1);
    }
}
