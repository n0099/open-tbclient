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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsPraiseView extends LinearLayout {
    private View dcP;
    private boolean hCM;
    private TextView iDY;
    private TextView iDZ;
    private TextView iEa;
    private PraiseData iEb;
    private boolean iEc;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.hCM = false;
        this.iEc = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hCM = false;
        this.iEc = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dcP = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.iDY = (TextView) this.dcP.findViewById(d.g.frs_go_praise_list_num);
        this.iDZ = (TextView) this.dcP.findViewById(d.g.frs_praise_user_name_text1);
        this.iEa = (TextView) this.dcP.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.iEb != null) {
                    str = FrsPraiseView.this.iEb.getTitle();
                }
                com.baidu.tbadk.util.r.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.hCM));
            }
        });
        this.iEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.iEb.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.iDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.iEb.getUser().get(0);
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
            this.iEb = praiseData;
            pR(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.hCM = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.iEc = z;
    }

    private void pR(boolean z) {
        long num = this.iEb.getNum();
        this.iEa.setVisibility(8);
        this.iDZ.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.iEb.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.iDZ.setVisibility(0);
                        this.iDZ.setText(Cn(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.iDZ.setVisibility(0);
                        this.iDZ.setText(Cn(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.iEa.setVisibility(0);
                        this.iEa.setText("、" + Cn(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.iDY.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.iDY.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.iDY.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String Cn(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void ii(int i) {
        if (this.hCM) {
            if (this.iEc) {
                al.k(this.dcP, d.f.praise_video_selector);
                al.d(this.iDY, d.C0277d.cp_cont_c, 1);
                al.d(this.iDZ, d.C0277d.cp_link_tip_c, 1);
                al.d(this.iEa, d.C0277d.cp_link_tip_c, 1);
                return;
            }
            al.k(this.dcP, d.f.praise_head_selector);
            al.d(this.iDY, d.C0277d.cp_cont_d, 1);
            al.d(this.iDZ, d.C0277d.cp_link_tip_c, 1);
            al.d(this.iEa, d.C0277d.cp_link_tip_c, 1);
            return;
        }
        al.k(this.dcP, d.f.praise_view_btn_color);
        al.d(this.iDY, d.C0277d.cp_cont_d, 1);
        al.d(this.iDZ, d.C0277d.cp_cont_c, 1);
        al.d(this.iEa, d.C0277d.cp_cont_c, 1);
    }
}
