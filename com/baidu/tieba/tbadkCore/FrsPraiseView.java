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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsPraiseView extends LinearLayout {
    private View bmd;
    private boolean hUQ;
    private TextView iWP;
    private TextView iWQ;
    private TextView iWR;
    private PraiseData iWS;
    private boolean iWT;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.hUQ = false;
        this.iWT = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hUQ = false;
        this.iWT = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmd = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.iWP = (TextView) this.bmd.findViewById(R.id.frs_go_praise_list_num);
        this.iWQ = (TextView) this.bmd.findViewById(R.id.frs_praise_user_name_text1);
        this.iWR = (TextView) this.bmd.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.iWS != null) {
                    str = FrsPraiseView.this.iWS.getTitle();
                }
                com.baidu.tbadk.util.r.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.hUQ));
            }
        });
        this.iWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.iWS.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.iWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.iWS.getUser().get(0);
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
            this.iWS = praiseData;
            qG(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.hUQ = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.iWT = z;
    }

    private void qG(boolean z) {
        long num = this.iWS.getNum();
        this.iWR.setVisibility(8);
        this.iWQ.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.iWS.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.iWQ.setVisibility(0);
                        this.iWQ.setText(DJ(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.iWQ.setVisibility(0);
                        this.iWQ.setText(DJ(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.iWR.setVisibility(0);
                        this.iWR.setText("、" + DJ(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.iWP.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.iWP.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.iWP.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String DJ(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void iW(int i) {
        if (this.hUQ) {
            if (this.iWT) {
                al.k(this.bmd, R.drawable.praise_video_selector);
                al.f(this.iWP, R.color.cp_cont_c, 1);
                al.f(this.iWQ, R.color.cp_link_tip_c, 1);
                al.f(this.iWR, R.color.cp_link_tip_c, 1);
                return;
            }
            al.k(this.bmd, R.drawable.praise_head_selector);
            al.f(this.iWP, R.color.cp_cont_d, 1);
            al.f(this.iWQ, R.color.cp_link_tip_c, 1);
            al.f(this.iWR, R.color.cp_link_tip_c, 1);
            return;
        }
        al.k(this.bmd, R.drawable.praise_view_btn_color);
        al.f(this.iWP, R.color.cp_cont_d, 1);
        al.f(this.iWQ, R.color.cp_cont_c, 1);
        al.f(this.iWR, R.color.cp_cont_c, 1);
    }
}
