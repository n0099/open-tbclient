package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsPraiseView extends LinearLayout {
    private View bnp;
    private boolean ied;
    private TextView jgN;
    private TextView jgO;
    private TextView jgP;
    private PraiseData jgQ;
    private boolean jgR;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ied = false;
        this.jgR = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ied = false;
        this.jgR = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bnp = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.jgN = (TextView) this.bnp.findViewById(R.id.frs_go_praise_list_num);
        this.jgO = (TextView) this.bnp.findViewById(R.id.frs_praise_user_name_text1);
        this.jgP = (TextView) this.bnp.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.jgQ != null) {
                    str = FrsPraiseView.this.jgQ.getTitle();
                }
                com.baidu.tbadk.util.q.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.ied));
            }
        });
        this.jgP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jgQ.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.e(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.jgO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jgQ.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.e(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.jgQ = praiseData;
            ra(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ied = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.jgR = z;
    }

    private void ra(boolean z) {
        long num = this.jgQ.getNum();
        this.jgP.setVisibility(8);
        this.jgO.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.jgQ.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.jgO.setVisibility(0);
                        this.jgO.setText(EZ(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.jgO.setVisibility(0);
                        this.jgO.setText(EZ(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.jgP.setVisibility(0);
                        this.jgP.setText("、" + EZ(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.jgN.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.jgN.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.jgN.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String EZ(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void jg(int i) {
        if (this.ied) {
            if (this.jgR) {
                am.k(this.bnp, R.drawable.praise_video_selector);
                am.f(this.jgN, R.color.cp_cont_c, 1);
                am.f(this.jgO, R.color.cp_link_tip_c, 1);
                am.f(this.jgP, R.color.cp_link_tip_c, 1);
                return;
            }
            am.k(this.bnp, R.drawable.praise_head_selector);
            am.f(this.jgN, R.color.cp_cont_d, 1);
            am.f(this.jgO, R.color.cp_link_tip_c, 1);
            am.f(this.jgP, R.color.cp_link_tip_c, 1);
            return;
        }
        am.k(this.bnp, R.drawable.praise_view_btn_color);
        am.f(this.jgN, R.color.cp_cont_d, 1);
        am.f(this.jgO, R.color.cp_cont_c, 1);
        am.f(this.jgP, R.color.cp_cont_c, 1);
    }
}
