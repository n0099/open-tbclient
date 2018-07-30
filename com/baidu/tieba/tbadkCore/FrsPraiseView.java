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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView awQ;
    private View bzb;
    private boolean fLM;
    private TextView gLa;
    private TextView gLb;
    private PraiseData gLc;
    private boolean gLd;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fLM = false;
        this.gLd = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLM = false;
        this.gLd = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bzb = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.awQ = (TextView) this.bzb.findViewById(d.g.frs_go_praise_list_num);
        this.gLa = (TextView) this.bzb.findViewById(d.g.frs_praise_user_name_text1);
        this.gLb = (TextView) this.bzb.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gLc != null) {
                    str = FrsPraiseView.this.gLc.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fLM));
            }
        });
        this.gLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gLc.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gLc.getUser().get(0);
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
            this.gLc = praiseData;
            ml(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fLM = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gLd = z;
    }

    private void ml(boolean z) {
        long num = this.gLc.getNum();
        this.gLb.setVisibility(8);
        this.gLa.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gLc.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gLa.setVisibility(0);
                        this.gLa.setText(tx(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gLa.setVisibility(0);
                        this.gLa.setText(tx(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gLb.setVisibility(0);
                        this.gLb.setText("、" + tx(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.awQ.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.awQ.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.awQ.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
            }
        }
    }

    private String tx(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dG(int i) {
        if (this.fLM) {
            if (this.gLd) {
                am.i(this.bzb, d.f.praise_video_selector);
                am.c(this.awQ, d.C0140d.cp_cont_c, 1);
                am.c(this.gLa, d.C0140d.cp_link_tip_c, 1);
                am.c(this.gLb, d.C0140d.cp_link_tip_c, 1);
                return;
            }
            am.i(this.bzb, d.f.praise_head_selector);
            am.c(this.awQ, d.C0140d.cp_cont_d, 1);
            am.c(this.gLa, d.C0140d.cp_link_tip_c, 1);
            am.c(this.gLb, d.C0140d.cp_link_tip_c, 1);
            return;
        }
        am.i(this.bzb, d.f.praise_view_btn_color);
        am.c(this.awQ, d.C0140d.cp_cont_d, 1);
        am.c(this.gLa, d.C0140d.cp_cont_c, 1);
        am.c(this.gLb, d.C0140d.cp_cont_c, 1);
    }
}
