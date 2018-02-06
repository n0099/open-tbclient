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
    private TextView bdl;
    private View ceJ;
    private TextView gYi;
    private TextView gYj;
    private PraiseData gYk;
    private boolean gYl;
    private boolean gaN;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gaN = false;
        this.gYl = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaN = false;
        this.gYl = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ceJ = View.inflate(this.mContext, d.h.frs_item_praise, this);
        this.bdl = (TextView) this.ceJ.findViewById(d.g.frs_go_praise_list_num);
        this.gYi = (TextView) this.ceJ.findViewById(d.g.frs_praise_user_name_text1);
        this.gYj = (TextView) this.ceJ.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gYk != null) {
                    str = FrsPraiseView.this.gYk.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gaN));
            }
        });
        this.gYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gYk.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gYi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gYk.getUser().get(0);
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
            this.gYk = praiseData;
            mC(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gaN = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gYl = z;
    }

    private void mC(boolean z) {
        long num = this.gYk.getNum();
        this.gYj.setVisibility(8);
        this.gYi.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gYk.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gYi.setVisibility(0);
                        this.gYi.setText(sy(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gYi.setVisibility(0);
                        this.gYi.setText(sy(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gYj.setVisibility(0);
                        this.gYj.setText("、" + sy(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.bdl.setText(this.mContext.getString(d.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.bdl.setText(this.mContext.getString(d.j.etc) + num + this.mContext.getString(d.j.common_praise_view_text2));
            } else {
                this.bdl.setText(this.mContext.getString(d.j.etc) + "999999+" + this.mContext.getString(d.j.common_praise_view_text2));
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
        if (this.gaN) {
            if (this.gYl) {
                aj.s(this.ceJ, d.f.praise_video_selector);
                aj.e(this.bdl, d.C0140d.cp_cont_c, 1);
                aj.e(this.gYi, d.C0140d.cp_link_tip_c, 1);
                aj.e(this.gYj, d.C0140d.cp_link_tip_c, 1);
                return;
            }
            aj.s(this.ceJ, d.f.praise_head_selector);
            aj.e(this.bdl, d.C0140d.cp_cont_d, 1);
            aj.e(this.gYi, d.C0140d.cp_link_tip_c, 1);
            aj.e(this.gYj, d.C0140d.cp_link_tip_c, 1);
            return;
        }
        aj.s(this.ceJ, d.f.praise_view_btn_color);
        aj.e(this.bdl, d.C0140d.cp_cont_d, 1);
        aj.e(this.gYi, d.C0140d.cp_cont_c, 1);
        aj.e(this.gYj, d.C0140d.cp_cont_c, 1);
    }
}
