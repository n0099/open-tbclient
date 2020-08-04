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
/* loaded from: classes15.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView dKA;
    private View dpe;
    private boolean elX;
    private TextView lLr;
    private TextView lLs;
    private PraiseData lLt;
    private boolean lLu;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.elX = false;
        this.lLu = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elX = false;
        this.lLu = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dpe = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.dKA = (TextView) this.dpe.findViewById(R.id.frs_go_praise_list_num);
        this.lLr = (TextView) this.dpe.findViewById(R.id.frs_praise_user_name_text1);
        this.lLs = (TextView) this.dpe.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.lLt != null) {
                    str = FrsPraiseView.this.lLt.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.elX));
            }
        });
        this.lLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.lLt.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.lLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.lLt.getUser().get(0);
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
            this.lLt = praiseData;
            vg(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.elX = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.lLu = z;
    }

    private void vg(boolean z) {
        long num = this.lLt.getNum();
        this.lLs.setVisibility(8);
        this.lLr.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.lLt.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.lLr.setVisibility(0);
                        this.lLr.setText(NB(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.lLr.setVisibility(0);
                        this.lLr.setText(NB(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.lLs.setVisibility(0);
                        this.lLs.setText("、" + NB(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.dKA.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.dKA.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.dKA.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String NB(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.elX) {
            if (this.lLu) {
                ao.setBackgroundResource(this.dpe, R.drawable.praise_video_selector);
                ao.setViewTextColor(this.dKA, R.color.cp_cont_c, 1);
                ao.setViewTextColor(this.lLr, R.color.cp_link_tip_c, 1);
                ao.setViewTextColor(this.lLs, R.color.cp_link_tip_c, 1);
                return;
            }
            ao.setBackgroundResource(this.dpe, R.drawable.praise_head_selector);
            ao.setViewTextColor(this.dKA, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.lLr, R.color.cp_link_tip_c, 1);
            ao.setViewTextColor(this.lLs, R.color.cp_link_tip_c, 1);
            return;
        }
        ao.setBackgroundResource(this.dpe, R.drawable.praise_view_btn_color);
        ao.setViewTextColor(this.dKA, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.lLr, R.color.cp_cont_c, 1);
        ao.setViewTextColor(this.lLs, R.color.cp_cont_c, 1);
    }
}
