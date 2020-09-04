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
/* loaded from: classes15.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView dTM;
    private View dzk;
    private boolean evW;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView mdq;
    private TextView mdr;
    private PraiseData mds;
    private boolean mdt;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.evW = false;
        this.mdt = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evW = false;
        this.mdt = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dzk = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.dTM = (TextView) this.dzk.findViewById(R.id.frs_go_praise_list_num);
        this.mdq = (TextView) this.dzk.findViewById(R.id.frs_praise_user_name_text1);
        this.mdr = (TextView) this.dzk.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.mds != null) {
                    str = FrsPraiseView.this.mds.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.evW));
            }
        });
        this.mdr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.mds.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.mdq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.mds.getUser().get(0);
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
            this.mds = praiseData;
            vX(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.evW = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.mdt = z;
    }

    private void vX(boolean z) {
        long num = this.mds.getNum();
        this.mdr.setVisibility(8);
        this.mdq.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.mds.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.mdq.setVisibility(0);
                        this.mdq.setText(QC(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.mdq.setVisibility(0);
                        this.mdq.setText(QC(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.mdr.setVisibility(0);
                        this.mdr.setText("、" + QC(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.dTM.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.dTM.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.dTM.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String QC(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.evW) {
            if (this.mdt) {
                ap.setBackgroundResource(this.dzk, R.drawable.praise_video_selector);
                ap.setViewTextColor(this.dTM, R.color.cp_cont_c, 1);
                ap.setViewTextColor(this.mdq, R.color.cp_link_tip_c, 1);
                ap.setViewTextColor(this.mdr, R.color.cp_link_tip_c, 1);
                return;
            }
            ap.setBackgroundResource(this.dzk, R.drawable.praise_head_selector);
            ap.setViewTextColor(this.dTM, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.mdq, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.mdr, R.color.cp_link_tip_c, 1);
            return;
        }
        ap.setBackgroundResource(this.dzk, R.drawable.praise_view_btn_color);
        ap.setViewTextColor(this.dTM, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.mdq, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.mdr, R.color.cp_cont_c, 1);
    }
}
