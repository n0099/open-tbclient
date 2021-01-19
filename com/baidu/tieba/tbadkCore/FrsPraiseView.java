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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView eGA;
    private View elg;
    private boolean fjY;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView nkV;
    private TextView nkW;
    private PraiseData nkX;
    private boolean nkY;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fjY = false;
        this.nkY = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjY = false;
        this.nkY = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.elg = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.eGA = (TextView) this.elg.findViewById(R.id.frs_go_praise_list_num);
        this.nkV = (TextView) this.elg.findViewById(R.id.frs_praise_user_name_text1);
        this.nkW = (TextView) this.elg.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.nkX != null) {
                    str = FrsPraiseView.this.nkX.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fjY));
            }
        });
        this.nkW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.nkX.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.nkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.nkX.getUser().get(0);
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
            this.nkX = praiseData;
            xT(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fjY = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.nkY = z;
    }

    private void xT(boolean z) {
        long num = this.nkX.getNum();
        this.nkW.setVisibility(8);
        this.nkV.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.nkX.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.nkV.setVisibility(0);
                        this.nkV.setText(RW(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.nkV.setVisibility(0);
                        this.nkV.setText(RW(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.nkW.setVisibility(0);
                        this.nkW.setText("、" + RW(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.eGA.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.eGA.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.eGA.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String RW(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.fjY) {
            if (this.nkY) {
                ao.setBackgroundResource(this.elg, R.drawable.praise_video_selector);
                ao.setViewTextColor(this.eGA, R.color.CAM_X0108, 1);
                ao.setViewTextColor(this.nkV, R.color.CAM_X0304, 1);
                ao.setViewTextColor(this.nkW, R.color.CAM_X0304, 1);
                return;
            }
            ao.setBackgroundResource(this.elg, R.drawable.praise_head_selector);
            ao.setViewTextColor(this.eGA, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.nkV, R.color.CAM_X0304, 1);
            ao.setViewTextColor(this.nkW, R.color.CAM_X0304, 1);
            return;
        }
        ao.setBackgroundResource(this.elg, R.drawable.praise_view_btn_color);
        ao.setViewTextColor(this.eGA, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.nkV, R.color.CAM_X0108, 1);
        ao.setViewTextColor(this.nkW, R.color.CAM_X0108, 1);
    }
}
