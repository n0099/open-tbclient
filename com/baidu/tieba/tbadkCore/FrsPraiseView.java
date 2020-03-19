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
    private View cus;
    private boolean iXM;
    private PraiseData kgA;
    private boolean kgB;
    private TextView kgx;
    private TextView kgy;
    private TextView kgz;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.iXM = false;
        this.kgB = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iXM = false;
        this.kgB = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.cus = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.kgx = (TextView) this.cus.findViewById(R.id.frs_go_praise_list_num);
        this.kgy = (TextView) this.cus.findViewById(R.id.frs_praise_user_name_text1);
        this.kgz = (TextView) this.cus.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.kgA != null) {
                    str = FrsPraiseView.this.kgA.getTitle();
                }
                com.baidu.tbadk.util.s.b(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.iXM));
            }
        });
        this.kgz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.kgA.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.f.b.toLong(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.kgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.kgA.getUser().get(0);
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
            this.kgA = praiseData;
            sN(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.iXM = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.kgB = z;
    }

    private void sN(boolean z) {
        long num = this.kgA.getNum();
        this.kgz.setVisibility(8);
        this.kgy.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.kgA.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.kgy.setVisibility(0);
                        this.kgy.setText(IS(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.kgy.setVisibility(0);
                        this.kgy.setText(IS(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.kgz.setVisibility(0);
                        this.kgz.setText("、" + IS(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.kgx.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.kgx.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.kgx.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String IS(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void onChangeSkin(int i) {
        if (this.iXM) {
            if (this.kgB) {
                am.setBackgroundResource(this.cus, R.drawable.praise_video_selector);
                am.setViewTextColor(this.kgx, R.color.cp_cont_c, 1);
                am.setViewTextColor(this.kgy, R.color.cp_link_tip_c, 1);
                am.setViewTextColor(this.kgz, R.color.cp_link_tip_c, 1);
                return;
            }
            am.setBackgroundResource(this.cus, R.drawable.praise_head_selector);
            am.setViewTextColor(this.kgx, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.kgy, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.kgz, R.color.cp_link_tip_c, 1);
            return;
        }
        am.setBackgroundResource(this.cus, R.drawable.praise_view_btn_color);
        am.setViewTextColor(this.kgx, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.kgy, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.kgz, R.color.cp_cont_c, 1);
    }
}
