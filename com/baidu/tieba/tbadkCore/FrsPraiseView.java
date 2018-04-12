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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView aot;
    private boolean fva;
    private TextView gtL;
    private TextView gtM;
    private PraiseData gtN;
    private boolean gtO;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private View root;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fva = false;
        this.gtO = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fva = false;
        this.gtO = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.root = View.inflate(this.mContext, d.i.frs_item_praise, this);
        this.aot = (TextView) this.root.findViewById(d.g.frs_go_praise_list_num);
        this.gtL = (TextView) this.root.findViewById(d.g.frs_praise_user_name_text1);
        this.gtM = (TextView) this.root.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str = "";
                if (FrsPraiseView.this.gtN != null) {
                    str = FrsPraiseView.this.gtN.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fva));
            }
        });
        this.gtM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MetaData metaData = FrsPraiseView.this.gtN.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gtL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MetaData metaData = FrsPraiseView.this.gtN.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.gtN = praiseData;
            mi(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fva = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gtO = z;
    }

    private void mi(boolean z) {
        long num = this.gtN.getNum();
        this.gtM.setVisibility(8);
        this.gtL.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gtN.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gtL.setVisibility(0);
                        this.gtL.setText(sG(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gtL.setVisibility(0);
                        this.gtL.setText(sG(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gtM.setVisibility(0);
                        this.gtM.setText("、" + sG(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.aot.setText(this.mContext.getString(d.k.common_praise_view_text));
            } else if (num <= 999999) {
                this.aot.setText(this.mContext.getString(d.k.etc) + num + this.mContext.getString(d.k.common_praise_view_text2));
            } else {
                this.aot.setText(this.mContext.getString(d.k.etc) + "999999+" + this.mContext.getString(d.k.common_praise_view_text2));
            }
        }
    }

    private String sG(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dA(int i) {
        if (this.fva) {
            if (this.gtO) {
                ak.i(this.root, d.f.praise_video_selector);
                ak.c(this.aot, d.C0126d.cp_cont_c, 1);
                ak.c(this.gtL, d.C0126d.cp_link_tip_c, 1);
                ak.c(this.gtM, d.C0126d.cp_link_tip_c, 1);
                return;
            }
            ak.i(this.root, d.f.praise_head_selector);
            ak.c(this.aot, d.C0126d.cp_cont_d, 1);
            ak.c(this.gtL, d.C0126d.cp_link_tip_c, 1);
            ak.c(this.gtM, d.C0126d.cp_link_tip_c, 1);
            return;
        }
        ak.i(this.root, d.f.praise_view_btn_color);
        ak.c(this.aot, d.C0126d.cp_cont_d, 1);
        ak.c(this.gtL, d.C0126d.cp_cont_c, 1);
        ak.c(this.gtM, d.C0126d.cp_cont_c, 1);
    }
}
