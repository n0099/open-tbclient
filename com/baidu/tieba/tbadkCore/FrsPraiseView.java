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
    private View dZT;
    private boolean eXC;
    private TextView euG;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView mVW;
    private TextView mVX;
    private PraiseData mVY;
    private boolean mVZ;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.eXC = false;
        this.mVZ = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXC = false;
        this.mVZ = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.dZT = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.euG = (TextView) this.dZT.findViewById(R.id.frs_go_praise_list_num);
        this.mVW = (TextView) this.dZT.findViewById(R.id.frs_praise_user_name_text1);
        this.mVX = (TextView) this.dZT.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.mVY != null) {
                    str = FrsPraiseView.this.mVY.getTitle();
                }
                com.baidu.tbadk.util.t.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.eXC));
            }
        });
        this.mVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.mVY.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.mVW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.mVY.getUser().get(0);
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
            this.mVY = praiseData;
            xr(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.eXC = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.mVZ = z;
    }

    private void xr(boolean z) {
        long num = this.mVY.getNum();
        this.mVX.setVisibility(8);
        this.mVW.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.mVY.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.mVW.setVisibility(0);
                        this.mVW.setText(Sh(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.mVW.setVisibility(0);
                        this.mVW.setText(Sh(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.mVX.setVisibility(0);
                        this.mVX.setText("、" + Sh(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.euG.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.euG.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.euG.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Sh(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.eXC) {
            if (this.mVZ) {
                ap.setBackgroundResource(this.dZT, R.drawable.praise_video_selector);
                ap.setViewTextColor(this.euG, R.color.CAM_X0108, 1);
                ap.setViewTextColor(this.mVW, R.color.CAM_X0304, 1);
                ap.setViewTextColor(this.mVX, R.color.CAM_X0304, 1);
                return;
            }
            ap.setBackgroundResource(this.dZT, R.drawable.praise_head_selector);
            ap.setViewTextColor(this.euG, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.mVW, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.mVX, R.color.CAM_X0304, 1);
            return;
        }
        ap.setBackgroundResource(this.dZT, R.drawable.praise_view_btn_color);
        ap.setViewTextColor(this.euG, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mVW, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.mVX, R.color.CAM_X0108, 1);
    }
}
