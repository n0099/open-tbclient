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
/* loaded from: classes20.dex */
public class FrsPraiseView extends LinearLayout {
    private View dBl;
    private TextView dVW;
    private boolean eyb;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView mmP;
    private TextView mmQ;
    private PraiseData mmR;
    private boolean mmS;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eyb = false;
        this.mmS = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eyb = false;
        this.mmS = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dBl = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.dVW = (TextView) this.dBl.findViewById(R.id.frs_go_praise_list_num);
        this.mmP = (TextView) this.dBl.findViewById(R.id.frs_praise_user_name_text1);
        this.mmQ = (TextView) this.dBl.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.mmR != null) {
                    str = FrsPraiseView.this.mmR.getTitle();
                }
                com.baidu.tbadk.util.t.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.eyb));
            }
        });
        this.mmQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.mmR.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.mmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.mmR.getUser().get(0);
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
            this.mmR = praiseData;
            wg(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eyb = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.mmS = z;
    }

    private void wg(boolean z) {
        long num = this.mmR.getNum();
        this.mmQ.setVisibility(8);
        this.mmP.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.mmR.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.mmP.setVisibility(0);
                        this.mmP.setText(Rc(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.mmP.setVisibility(0);
                        this.mmP.setText(Rc(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.mmQ.setVisibility(0);
                        this.mmQ.setText("、" + Rc(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.dVW.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.dVW.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.dVW.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Rc(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.eyb) {
            if (this.mmS) {
                ap.setBackgroundResource(this.dBl, R.drawable.praise_video_selector);
                ap.setViewTextColor(this.dVW, R.color.cp_cont_c, 1);
                ap.setViewTextColor(this.mmP, R.color.cp_link_tip_c, 1);
                ap.setViewTextColor(this.mmQ, R.color.cp_link_tip_c, 1);
                return;
            }
            ap.setBackgroundResource(this.dBl, R.drawable.praise_head_selector);
            ap.setViewTextColor(this.dVW, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.mmP, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.mmQ, R.color.cp_link_tip_c, 1);
            return;
        }
        ap.setBackgroundResource(this.dBl, R.drawable.praise_view_btn_color);
        ap.setViewTextColor(this.dVW, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.mmP, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.mmQ, R.color.cp_cont_c, 1);
    }
}
