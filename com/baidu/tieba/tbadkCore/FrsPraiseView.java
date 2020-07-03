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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView dED;
    private View djj;
    private boolean efN;
    private TextView lEa;
    private TextView lEb;
    private PraiseData lEc;
    private boolean lEd;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.efN = false;
        this.lEd = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efN = false;
        this.lEd = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.djj = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.dED = (TextView) this.djj.findViewById(R.id.frs_go_praise_list_num);
        this.lEa = (TextView) this.djj.findViewById(R.id.frs_praise_user_name_text1);
        this.lEb = (TextView) this.djj.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.lEc != null) {
                    str = FrsPraiseView.this.lEc.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.efN));
            }
        });
        this.lEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.lEc.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.lEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.lEc.getUser().get(0);
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
            this.lEc = praiseData;
            uC(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.efN = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.lEd = z;
    }

    private void uC(boolean z) {
        long num = this.lEc.getNum();
        this.lEb.setVisibility(8);
        this.lEa.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.lEc.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.lEa.setVisibility(0);
                        this.lEa.setText(MT(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.lEa.setVisibility(0);
                        this.lEa.setText(MT(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.lEb.setVisibility(0);
                        this.lEb.setText("、" + MT(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.dED.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.dED.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.dED.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String MT(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.efN) {
            if (this.lEd) {
                an.setBackgroundResource(this.djj, R.drawable.praise_video_selector);
                an.setViewTextColor(this.dED, R.color.cp_cont_c, 1);
                an.setViewTextColor(this.lEa, R.color.cp_link_tip_c, 1);
                an.setViewTextColor(this.lEb, R.color.cp_link_tip_c, 1);
                return;
            }
            an.setBackgroundResource(this.djj, R.drawable.praise_head_selector);
            an.setViewTextColor(this.dED, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.lEa, R.color.cp_link_tip_c, 1);
            an.setViewTextColor(this.lEb, R.color.cp_link_tip_c, 1);
            return;
        }
        an.setBackgroundResource(this.djj, R.drawable.praise_view_btn_color);
        an.setViewTextColor(this.dED, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.lEa, R.color.cp_cont_c, 1);
        an.setViewTextColor(this.lEb, R.color.cp_cont_c, 1);
    }
}
