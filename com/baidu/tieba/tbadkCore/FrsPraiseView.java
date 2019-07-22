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
    private View bmR;
    private boolean ibe;
    private TextView jdl;
    private TextView jdm;
    private TextView jdn;
    private PraiseData jdo;
    private boolean jdp;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.ibe = false;
        this.jdp = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibe = false;
        this.jdp = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmR = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.jdl = (TextView) this.bmR.findViewById(R.id.frs_go_praise_list_num);
        this.jdm = (TextView) this.bmR.findViewById(R.id.frs_praise_user_name_text1);
        this.jdn = (TextView) this.bmR.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.jdo != null) {
                    str = FrsPraiseView.this.jdo.getTitle();
                }
                com.baidu.tbadk.util.r.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.ibe));
            }
        });
        this.jdn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jdo.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.jdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jdo.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.jdo = praiseData;
            qW(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.ibe = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.jdp = z;
    }

    private void qW(boolean z) {
        long num = this.jdo.getNum();
        this.jdn.setVisibility(8);
        this.jdm.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.jdo.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.jdm.setVisibility(0);
                        this.jdm.setText(Ey(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.jdm.setVisibility(0);
                        this.jdm.setText(Ey(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.jdn.setVisibility(0);
                        this.jdn.setText("、" + Ey(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.jdl.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.jdl.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.jdl.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Ey(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void jc(int i) {
        if (this.ibe) {
            if (this.jdp) {
                am.k(this.bmR, R.drawable.praise_video_selector);
                am.f(this.jdl, R.color.cp_cont_c, 1);
                am.f(this.jdm, R.color.cp_link_tip_c, 1);
                am.f(this.jdn, R.color.cp_link_tip_c, 1);
                return;
            }
            am.k(this.bmR, R.drawable.praise_head_selector);
            am.f(this.jdl, R.color.cp_cont_d, 1);
            am.f(this.jdm, R.color.cp_link_tip_c, 1);
            am.f(this.jdn, R.color.cp_link_tip_c, 1);
            return;
        }
        am.k(this.bmR, R.drawable.praise_view_btn_color);
        am.f(this.jdl, R.color.cp_cont_d, 1);
        am.f(this.jdm, R.color.cp_cont_c, 1);
        am.f(this.jdn, R.color.cp_cont_c, 1);
    }
}
