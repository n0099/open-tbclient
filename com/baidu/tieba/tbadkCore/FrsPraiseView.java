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
    private View dex;
    private boolean jZH;
    private TextView liW;
    private TextView liX;
    private TextView liY;
    private PraiseData liZ;
    private boolean lja;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.jZH = false;
        this.lja = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZH = false;
        this.lja = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dex = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.liW = (TextView) this.dex.findViewById(R.id.frs_go_praise_list_num);
        this.liX = (TextView) this.dex.findViewById(R.id.frs_praise_user_name_text1);
        this.liY = (TextView) this.dex.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.liZ != null) {
                    str = FrsPraiseView.this.liZ.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.jZH));
            }
        });
        this.liY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.liZ.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.liX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.liZ.getUser().get(0);
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
            this.liZ = praiseData;
            un(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.jZH = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.lja = z;
    }

    private void un(boolean z) {
        long num = this.liZ.getNum();
        this.liY.setVisibility(8);
        this.liX.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.liZ.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.liX.setVisibility(0);
                        this.liX.setText(Mq(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.liX.setVisibility(0);
                        this.liX.setText(Mq(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.liY.setVisibility(0);
                        this.liY.setText("、" + Mq(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.liW.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.liW.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.liW.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Mq(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.jZH) {
            if (this.lja) {
                am.setBackgroundResource(this.dex, R.drawable.praise_video_selector);
                am.setViewTextColor(this.liW, R.color.cp_cont_c, 1);
                am.setViewTextColor(this.liX, R.color.cp_link_tip_c, 1);
                am.setViewTextColor(this.liY, R.color.cp_link_tip_c, 1);
                return;
            }
            am.setBackgroundResource(this.dex, R.drawable.praise_head_selector);
            am.setViewTextColor(this.liW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.liX, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.liY, R.color.cp_link_tip_c, 1);
            return;
        }
        am.setBackgroundResource(this.dex, R.drawable.praise_view_btn_color);
        am.setViewTextColor(this.liW, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.liX, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.liY, R.color.cp_cont_c, 1);
    }
}
