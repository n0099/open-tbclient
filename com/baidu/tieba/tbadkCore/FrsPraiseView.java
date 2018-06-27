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
    private TextView axk;
    private boolean fLy;
    private TextView gKd;
    private TextView gKe;
    private PraiseData gKf;
    private boolean gKg;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private View root;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fLy = false;
        this.gKg = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLy = false;
        this.gKg = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.root = View.inflate(this.mContext, d.i.frs_item_praise, this);
        this.axk = (TextView) this.root.findViewById(d.g.frs_go_praise_list_num);
        this.gKd = (TextView) this.root.findViewById(d.g.frs_praise_user_name_text1);
        this.gKe = (TextView) this.root.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gKf != null) {
                    str = FrsPraiseView.this.gKf.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fLy));
            }
        });
        this.gKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gKf.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gKf.getUser().get(0);
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
            this.gKf = praiseData;
            mA(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fLy = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gKg = z;
    }

    private void mA(boolean z) {
        long num = this.gKf.getNum();
        this.gKe.setVisibility(8);
        this.gKd.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gKf.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gKd.setVisibility(0);
                        this.gKd.setText(tz(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gKd.setVisibility(0);
                        this.gKd.setText(tz(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gKe.setVisibility(0);
                        this.gKe.setText("、" + tz(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.axk.setText(this.mContext.getString(d.k.common_praise_view_text));
            } else if (num <= 999999) {
                this.axk.setText(this.mContext.getString(d.k.etc) + num + this.mContext.getString(d.k.common_praise_view_text2));
            } else {
                this.axk.setText(this.mContext.getString(d.k.etc) + "999999+" + this.mContext.getString(d.k.common_praise_view_text2));
            }
        }
    }

    private String tz(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dD(int i) {
        if (this.fLy) {
            if (this.gKg) {
                am.i(this.root, d.f.praise_video_selector);
                am.c(this.axk, d.C0142d.cp_cont_c, 1);
                am.c(this.gKd, d.C0142d.cp_link_tip_c, 1);
                am.c(this.gKe, d.C0142d.cp_link_tip_c, 1);
                return;
            }
            am.i(this.root, d.f.praise_head_selector);
            am.c(this.axk, d.C0142d.cp_cont_d, 1);
            am.c(this.gKd, d.C0142d.cp_link_tip_c, 1);
            am.c(this.gKe, d.C0142d.cp_link_tip_c, 1);
            return;
        }
        am.i(this.root, d.f.praise_view_btn_color);
        am.c(this.axk, d.C0142d.cp_cont_d, 1);
        am.c(this.gKd, d.C0142d.cp_cont_c, 1);
        am.c(this.gKe, d.C0142d.cp_cont_c, 1);
    }
}
