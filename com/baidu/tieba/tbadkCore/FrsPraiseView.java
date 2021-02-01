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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView eIG;
    private View eno;
    private boolean fmq;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView nuE;
    private TextView nuF;
    private PraiseData nuG;
    private boolean nuH;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fmq = false;
        this.nuH = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmq = false;
        this.nuH = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.eno = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.eIG = (TextView) this.eno.findViewById(R.id.frs_go_praise_list_num);
        this.nuE = (TextView) this.eno.findViewById(R.id.frs_praise_user_name_text1);
        this.nuF = (TextView) this.eno.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.nuG != null) {
                    str = FrsPraiseView.this.nuG.getTitle();
                }
                com.baidu.tbadk.util.u.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fmq));
            }
        });
        this.nuF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.nuG.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.nuE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.nuG.getUser().get(0);
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
            this.nuG = praiseData;
            ym(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fmq = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.nuH = z;
    }

    private void ym(boolean z) {
        long num = this.nuG.getNum();
        this.nuF.setVisibility(8);
        this.nuE.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.nuG.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.nuE.setVisibility(0);
                        this.nuE.setText(ST(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.nuE.setVisibility(0);
                        this.nuE.setText(ST(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.nuF.setVisibility(0);
                        this.nuF.setText("、" + ST(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.eIG.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.eIG.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.eIG.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String ST(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.fmq) {
            if (this.nuH) {
                ap.setBackgroundResource(this.eno, R.drawable.praise_video_selector);
                ap.setViewTextColor(this.eIG, R.color.CAM_X0108, 1);
                ap.setViewTextColor(this.nuE, R.color.CAM_X0304, 1);
                ap.setViewTextColor(this.nuF, R.color.CAM_X0304, 1);
                return;
            }
            ap.setBackgroundResource(this.eno, R.drawable.praise_head_selector);
            ap.setViewTextColor(this.eIG, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.nuE, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.nuF, R.color.CAM_X0304, 1);
            return;
        }
        ap.setBackgroundResource(this.eno, R.drawable.praise_view_btn_color);
        ap.setViewTextColor(this.eIG, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.nuE, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.nuF, R.color.CAM_X0108, 1);
    }
}
