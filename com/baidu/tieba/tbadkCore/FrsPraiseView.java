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
/* loaded from: classes8.dex */
public class FrsPraiseView extends LinearLayout {
    private View cue;
    private boolean iVX;
    private TextView keH;
    private TextView keI;
    private TextView keJ;
    private PraiseData keK;
    private boolean keL;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.iVX = false;
        this.keL = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVX = false;
        this.keL = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cue = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.keH = (TextView) this.cue.findViewById(R.id.frs_go_praise_list_num);
        this.keI = (TextView) this.cue.findViewById(R.id.frs_praise_user_name_text1);
        this.keJ = (TextView) this.cue.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.keK != null) {
                    str = FrsPraiseView.this.keK.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.iVX));
            }
        });
        this.keJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.keK.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.keI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.keK.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.keK = praiseData;
            sH(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.iVX = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.keL = z;
    }

    private void sH(boolean z) {
        long num = this.keK.getNum();
        this.keJ.setVisibility(8);
        this.keI.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.keK.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.keI.setVisibility(0);
                        this.keI.setText(IR(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.keI.setVisibility(0);
                        this.keI.setText(IR(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.keJ.setVisibility(0);
                        this.keJ.setText("、" + IR(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.keH.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.keH.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.keH.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String IR(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.iVX) {
            if (this.keL) {
                am.setBackgroundResource(this.cue, R.drawable.praise_video_selector);
                am.setViewTextColor(this.keH, R.color.cp_cont_c, 1);
                am.setViewTextColor(this.keI, R.color.cp_link_tip_c, 1);
                am.setViewTextColor(this.keJ, R.color.cp_link_tip_c, 1);
                return;
            }
            am.setBackgroundResource(this.cue, R.drawable.praise_head_selector);
            am.setViewTextColor(this.keH, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.keI, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.keJ, R.color.cp_link_tip_c, 1);
            return;
        }
        am.setBackgroundResource(this.cue, R.drawable.praise_view_btn_color);
        am.setViewTextColor(this.keH, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.keI, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.keJ, R.color.cp_cont_c, 1);
    }
}
