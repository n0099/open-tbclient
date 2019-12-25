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
/* loaded from: classes5.dex */
public class FrsPraiseView extends LinearLayout {
    private View cpR;
    private boolean iQZ;
    private TextView jZZ;
    private TextView kaa;
    private TextView kab;
    private PraiseData kac;
    private boolean kad;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.iQZ = false;
        this.kad = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iQZ = false;
        this.kad = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cpR = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.jZZ = (TextView) this.cpR.findViewById(R.id.frs_go_praise_list_num);
        this.kaa = (TextView) this.cpR.findViewById(R.id.frs_praise_user_name_text1);
        this.kab = (TextView) this.cpR.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.kac != null) {
                    str = FrsPraiseView.this.kac.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.iQZ));
            }
        });
        this.kab.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.kac.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.kaa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.kac.getUser().get(0);
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
            this.kac = praiseData;
            sr(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.iQZ = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.kad = z;
    }

    private void sr(boolean z) {
        long num = this.kac.getNum();
        this.kab.setVisibility(8);
        this.kaa.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.kac.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.kaa.setVisibility(0);
                        this.kaa.setText(It(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.kaa.setVisibility(0);
                        this.kaa.setText(It(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.kab.setVisibility(0);
                        this.kab.setText("、" + It(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.jZZ.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.jZZ.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.jZZ.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String It(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.iQZ) {
            if (this.kad) {
                am.setBackgroundResource(this.cpR, R.drawable.praise_video_selector);
                am.setViewTextColor(this.jZZ, R.color.cp_cont_c, 1);
                am.setViewTextColor(this.kaa, R.color.cp_link_tip_c, 1);
                am.setViewTextColor(this.kab, R.color.cp_link_tip_c, 1);
                return;
            }
            am.setBackgroundResource(this.cpR, R.drawable.praise_head_selector);
            am.setViewTextColor(this.jZZ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.kaa, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.kab, R.color.cp_link_tip_c, 1);
            return;
        }
        am.setBackgroundResource(this.cpR, R.drawable.praise_view_btn_color);
        am.setViewTextColor(this.jZZ, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.kaa, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.kab, R.color.cp_cont_c, 1);
    }
}
