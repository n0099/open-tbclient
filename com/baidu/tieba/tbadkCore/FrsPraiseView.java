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
/* loaded from: classes21.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView eBI;
    private View egT;
    private boolean feZ;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private TextView njW;
    private TextView njX;
    private PraiseData njY;
    private boolean njZ;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.feZ = false;
        this.njZ = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.feZ = false;
        this.njZ = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.egT = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.eBI = (TextView) this.egT.findViewById(R.id.frs_go_praise_list_num);
        this.njW = (TextView) this.egT.findViewById(R.id.frs_praise_user_name_text1);
        this.njX = (TextView) this.egT.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.njY != null) {
                    str = FrsPraiseView.this.njY.getTitle();
                }
                com.baidu.tbadk.util.t.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.feZ));
            }
        });
        this.njX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.njY.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.njW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.njY.getUser().get(0);
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
            this.njY = praiseData;
            xV(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.feZ = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.njZ = z;
    }

    private void xV(boolean z) {
        long num = this.njY.getNum();
        this.njX.setVisibility(8);
        this.njW.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.njY.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.njW.setVisibility(0);
                        this.njW.setText(Tv(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.njW.setVisibility(0);
                        this.njW.setText(Tv(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.njX.setVisibility(0);
                        this.njX.setText("、" + Tv(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.eBI.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.eBI.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.eBI.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Tv(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.feZ) {
            if (this.njZ) {
                ap.setBackgroundResource(this.egT, R.drawable.praise_video_selector);
                ap.setViewTextColor(this.eBI, R.color.CAM_X0108, 1);
                ap.setViewTextColor(this.njW, R.color.CAM_X0304, 1);
                ap.setViewTextColor(this.njX, R.color.CAM_X0304, 1);
                return;
            }
            ap.setBackgroundResource(this.egT, R.drawable.praise_head_selector);
            ap.setViewTextColor(this.eBI, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.njW, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.njX, R.color.CAM_X0304, 1);
            return;
        }
        ap.setBackgroundResource(this.egT, R.drawable.praise_view_btn_color);
        ap.setViewTextColor(this.eBI, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.njW, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.njX, R.color.CAM_X0108, 1);
    }
}
