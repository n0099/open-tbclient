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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView awN;
    private View bzd;
    private boolean fLF;
    private TextView gLc;
    private TextView gLd;
    private PraiseData gLe;
    private boolean gLf;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fLF = false;
        this.gLf = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLF = false;
        this.gLf = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bzd = View.inflate(this.mContext, f.h.frs_item_praise, this);
        this.awN = (TextView) this.bzd.findViewById(f.g.frs_go_praise_list_num);
        this.gLc = (TextView) this.bzd.findViewById(f.g.frs_praise_user_name_text1);
        this.gLd = (TextView) this.bzd.findViewById(f.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gLe != null) {
                    str = FrsPraiseView.this.gLe.getTitle();
                }
                com.baidu.tbadk.util.m.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fLF));
            }
        });
        this.gLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gLe.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gLc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gLe.getUser().get(0);
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
            this.gLe = praiseData;
            ml(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fLF = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gLf = z;
    }

    private void ml(boolean z) {
        long num = this.gLe.getNum();
        this.gLd.setVisibility(8);
        this.gLc.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gLe.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gLc.setVisibility(0);
                        this.gLc.setText(tB(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gLc.setVisibility(0);
                        this.gLc.setText(tB(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gLd.setVisibility(0);
                        this.gLd.setText("、" + tB(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.awN.setText(this.mContext.getString(f.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.awN.setText(this.mContext.getString(f.j.etc) + num + this.mContext.getString(f.j.common_praise_view_text2));
            } else {
                this.awN.setText(this.mContext.getString(f.j.etc) + "999999+" + this.mContext.getString(f.j.common_praise_view_text2));
            }
        }
    }

    private String tB(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dF(int i) {
        if (this.fLF) {
            if (this.gLf) {
                am.i(this.bzd, f.C0146f.praise_video_selector);
                am.c(this.awN, f.d.cp_cont_c, 1);
                am.c(this.gLc, f.d.cp_link_tip_c, 1);
                am.c(this.gLd, f.d.cp_link_tip_c, 1);
                return;
            }
            am.i(this.bzd, f.C0146f.praise_head_selector);
            am.c(this.awN, f.d.cp_cont_d, 1);
            am.c(this.gLc, f.d.cp_link_tip_c, 1);
            am.c(this.gLd, f.d.cp_link_tip_c, 1);
            return;
        }
        am.i(this.bzd, f.C0146f.praise_view_btn_color);
        am.c(this.awN, f.d.cp_cont_d, 1);
        am.c(this.gLc, f.d.cp_cont_c, 1);
        am.c(this.gLd, f.d.cp_cont_c, 1);
    }
}
