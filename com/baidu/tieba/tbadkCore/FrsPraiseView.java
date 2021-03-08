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
    private TextView eKh;
    private View eoR;
    private boolean fnP;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView nxi;
    private TextView nxj;
    private PraiseData nxk;
    private boolean nxl;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fnP = false;
        this.nxl = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnP = false;
        this.nxl = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.eoR = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.eKh = (TextView) this.eoR.findViewById(R.id.frs_go_praise_list_num);
        this.nxi = (TextView) this.eoR.findViewById(R.id.frs_praise_user_name_text1);
        this.nxj = (TextView) this.eoR.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.nxk != null) {
                    str = FrsPraiseView.this.nxk.getTitle();
                }
                com.baidu.tbadk.util.u.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fnP));
            }
        });
        this.nxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.nxk.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.nxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.nxk.getUser().get(0);
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
            this.nxk = praiseData;
            ym(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fnP = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.nxl = z;
    }

    private void ym(boolean z) {
        long num = this.nxk.getNum();
        this.nxj.setVisibility(8);
        this.nxi.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.nxk.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.nxi.setVisibility(0);
                        this.nxi.setText(Tl(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.nxi.setVisibility(0);
                        this.nxi.setText(Tl(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.nxj.setVisibility(0);
                        this.nxj.setText("、" + Tl(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.eKh.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.eKh.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.eKh.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Tl(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.fnP) {
            if (this.nxl) {
                ap.setBackgroundResource(this.eoR, R.drawable.praise_video_selector);
                ap.setViewTextColor(this.eKh, R.color.CAM_X0108, 1);
                ap.setViewTextColor(this.nxi, R.color.CAM_X0304, 1);
                ap.setViewTextColor(this.nxj, R.color.CAM_X0304, 1);
                return;
            }
            ap.setBackgroundResource(this.eoR, R.drawable.praise_head_selector);
            ap.setViewTextColor(this.eKh, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.nxi, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.nxj, R.color.CAM_X0304, 1);
            return;
        }
        ap.setBackgroundResource(this.eoR, R.drawable.praise_view_btn_color);
        ap.setViewTextColor(this.eKh, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.nxi, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.nxj, R.color.CAM_X0108, 1);
    }
}
