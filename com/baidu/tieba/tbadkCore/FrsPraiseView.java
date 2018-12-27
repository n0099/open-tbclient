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
    private View bSa;
    private boolean glT;
    private TextView hlA;
    private TextView hlB;
    private TextView hlC;
    private PraiseData hlD;
    private boolean hlE;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.glT = false;
        this.hlE = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glT = false;
        this.hlE = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bSa = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.hlA = (TextView) this.bSa.findViewById(e.g.frs_go_praise_list_num);
        this.hlB = (TextView) this.bSa.findViewById(e.g.frs_praise_user_name_text1);
        this.hlC = (TextView) this.bSa.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.hlD != null) {
                    str = FrsPraiseView.this.hlD.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.glT));
            }
        });
        this.hlC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hlD.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.hlB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hlD.getUser().get(0);
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
            this.hlD = praiseData;
            np(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.glT = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.hlE = z;
    }

    private void np(boolean z) {
        long num = this.hlD.getNum();
        this.hlC.setVisibility(8);
        this.hlB.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.hlD.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.hlB.setVisibility(0);
                        this.hlB.setText(vs(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.hlB.setVisibility(0);
                        this.hlB.setText(vs(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hlC.setVisibility(0);
                        this.hlC.setText("、" + vs(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.hlA.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.hlA.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.hlA.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
            }
        }
    }

    private String vs(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void eD(int i) {
        if (this.glT) {
            if (this.hlE) {
                al.i(this.bSa, e.f.praise_video_selector);
                al.c(this.hlA, e.d.cp_cont_c, 1);
                al.c(this.hlB, e.d.cp_link_tip_c, 1);
                al.c(this.hlC, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bSa, e.f.praise_head_selector);
            al.c(this.hlA, e.d.cp_cont_d, 1);
            al.c(this.hlB, e.d.cp_link_tip_c, 1);
            al.c(this.hlC, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bSa, e.f.praise_view_btn_color);
        al.c(this.hlA, e.d.cp_cont_d, 1);
        al.c(this.hlB, e.d.cp_cont_c, 1);
        al.c(this.hlC, e.d.cp_cont_c, 1);
    }
}
