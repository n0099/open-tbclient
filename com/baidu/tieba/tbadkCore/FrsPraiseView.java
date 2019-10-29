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
    private View bGb;
    private boolean icI;
    private TextView jgD;
    private TextView jgE;
    private TextView jgF;
    private PraiseData jgG;
    private boolean jgH;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.icI = false;
        this.jgH = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.icI = false;
        this.jgH = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bGb = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.jgD = (TextView) this.bGb.findViewById(R.id.frs_go_praise_list_num);
        this.jgE = (TextView) this.bGb.findViewById(R.id.frs_praise_user_name_text1);
        this.jgF = (TextView) this.bGb.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.jgG != null) {
                    str = FrsPraiseView.this.jgG.getTitle();
                }
                com.baidu.tbadk.util.q.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.icI));
            }
        });
        this.jgF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jgG.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.jgE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jgG.getUser().get(0);
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
            this.jgG = praiseData;
            qJ(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.icI = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.jgH = z;
    }

    private void qJ(boolean z) {
        long num = this.jgG.getNum();
        this.jgF.setVisibility(8);
        this.jgE.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.jgG.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.jgE.setVisibility(0);
                        this.jgE.setText(DE(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.jgE.setVisibility(0);
                        this.jgE.setText(DE(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.jgF.setVisibility(0);
                        this.jgF.setText("、" + DE(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.jgD.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.jgD.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.jgD.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
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
        if (this.icI) {
            if (this.jgH) {
                am.setBackgroundResource(this.bGb, R.drawable.praise_video_selector);
                am.setViewTextColor(this.jgD, R.color.cp_cont_c, 1);
                am.setViewTextColor(this.jgE, R.color.cp_link_tip_c, 1);
                am.setViewTextColor(this.jgF, R.color.cp_link_tip_c, 1);
                return;
            }
            am.setBackgroundResource(this.bGb, R.drawable.praise_head_selector);
            am.setViewTextColor(this.jgD, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jgE, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.jgF, R.color.cp_link_tip_c, 1);
            return;
        }
        am.setBackgroundResource(this.bGb, R.drawable.praise_view_btn_color);
        am.setViewTextColor(this.jgD, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.jgE, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jgF, R.color.cp_cont_c, 1);
    }
}
