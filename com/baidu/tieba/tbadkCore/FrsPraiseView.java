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
    private View dcL;
    private boolean hDa;
    private TextView iEo;
    private TextView iEp;
    private TextView iEq;
    private PraiseData iEr;
    private boolean iEs;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.hDa = false;
        this.iEs = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hDa = false;
        this.iEs = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dcL = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.iEo = (TextView) this.dcL.findViewById(d.g.frs_go_praise_list_num);
        this.iEp = (TextView) this.dcL.findViewById(d.g.frs_praise_user_name_text1);
        this.iEq = (TextView) this.dcL.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.iEr != null) {
                    str = FrsPraiseView.this.iEr.getTitle();
                }
                com.baidu.tbadk.util.r.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.hDa));
            }
        });
        this.iEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.iEr.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.iEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.iEr.getUser().get(0);
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
            this.iEr = praiseData;
            pR(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.hDa = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.iEs = z;
    }

    private void pR(boolean z) {
        long num = this.iEr.getNum();
        this.iEq.setVisibility(8);
        this.iEp.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.iEr.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.iEp.setVisibility(0);
                        this.iEp.setText(Co(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.iEp.setVisibility(0);
                        this.iEp.setText(Co(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.iEq.setVisibility(0);
                        this.iEq.setText("、" + Co(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.iEo.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.iEo.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.iEo.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String Co(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void ij(int i) {
        if (this.hDa) {
            if (this.iEs) {
                al.k(this.dcL, d.f.praise_video_selector);
                al.d(this.iEo, d.C0277d.cp_cont_c, 1);
                al.d(this.iEp, d.C0277d.cp_link_tip_c, 1);
                al.d(this.iEq, d.C0277d.cp_link_tip_c, 1);
                return;
            }
            al.k(this.dcL, d.f.praise_head_selector);
            al.d(this.iEo, d.C0277d.cp_cont_d, 1);
            al.d(this.iEp, d.C0277d.cp_link_tip_c, 1);
            al.d(this.iEq, d.C0277d.cp_link_tip_c, 1);
            return;
        }
        al.k(this.dcL, d.f.praise_view_btn_color);
        al.d(this.iEo, d.C0277d.cp_cont_d, 1);
        al.d(this.iEp, d.C0277d.cp_cont_c, 1);
        al.d(this.iEq, d.C0277d.cp_cont_c, 1);
    }
}
