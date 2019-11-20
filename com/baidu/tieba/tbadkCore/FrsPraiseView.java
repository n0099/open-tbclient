package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsPraiseView extends LinearLayout {
    private View bFk;
    private boolean ibR;
    private TextView jfM;
    private TextView jfN;
    private TextView jfO;
    private PraiseData jfP;
    private boolean jfQ;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ibR = false;
        this.jfQ = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibR = false;
        this.jfQ = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bFk = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.jfM = (TextView) this.bFk.findViewById(R.id.frs_go_praise_list_num);
        this.jfN = (TextView) this.bFk.findViewById(R.id.frs_praise_user_name_text1);
        this.jfO = (TextView) this.bFk.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.jfP != null) {
                    str = FrsPraiseView.this.jfP.getTitle();
                }
                com.baidu.tbadk.util.q.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.ibR));
            }
        });
        this.jfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jfP.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.jfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jfP.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.jfP = praiseData;
            qJ(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ibR = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.jfQ = z;
    }

    private void qJ(boolean z) {
        long num = this.jfP.getNum();
        this.jfO.setVisibility(8);
        this.jfN.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.jfP.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.jfN.setVisibility(0);
                        this.jfN.setText(DE(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.jfN.setVisibility(0);
                        this.jfN.setText(DE(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.jfO.setVisibility(0);
                        this.jfO.setText("、" + DE(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.jfM.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.jfM.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.jfM.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String DE(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.ibR) {
            if (this.jfQ) {
                am.setBackgroundResource(this.bFk, R.drawable.praise_video_selector);
                am.setViewTextColor(this.jfM, R.color.cp_cont_c, 1);
                am.setViewTextColor(this.jfN, R.color.cp_link_tip_c, 1);
                am.setViewTextColor(this.jfO, R.color.cp_link_tip_c, 1);
                return;
            }
            am.setBackgroundResource(this.bFk, R.drawable.praise_head_selector);
            am.setViewTextColor(this.jfM, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jfN, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.jfO, R.color.cp_link_tip_c, 1);
            return;
        }
        am.setBackgroundResource(this.bFk, R.drawable.praise_view_btn_color);
        am.setViewTextColor(this.jfM, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.jfN, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jfO, R.color.cp_cont_c, 1);
    }
}
