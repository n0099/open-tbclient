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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class FrsPraiseView extends LinearLayout {
    private View bNv;
    private TextView gZZ;
    private boolean gaO;
    private TextView haa;
    private TextView hab;
    private PraiseData hac;
    private boolean had;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gaO = false;
        this.had = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaO = false;
        this.had = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bNv = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.gZZ = (TextView) this.bNv.findViewById(e.g.frs_go_praise_list_num);
        this.haa = (TextView) this.bNv.findViewById(e.g.frs_praise_user_name_text1);
        this.hab = (TextView) this.bNv.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.hac != null) {
                    str = FrsPraiseView.this.hac.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gaO));
            }
        });
        this.hab.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hac.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.haa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hac.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.hac = praiseData;
            mZ(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gaO = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.had = z;
    }

    private void mZ(boolean z) {
        long num = this.hac.getNum();
        this.hab.setVisibility(8);
        this.haa.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.hac.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.haa.setVisibility(0);
                        this.haa.setText(uK(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.haa.setVisibility(0);
                        this.haa.setText(uK(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hab.setVisibility(0);
                        this.hab.setText("、" + uK(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.gZZ.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.gZZ.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.gZZ.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
            }
        }
    }

    private String uK(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void ea(int i) {
        if (this.gaO) {
            if (this.had) {
                al.i(this.bNv, e.f.praise_video_selector);
                al.c(this.gZZ, e.d.cp_cont_c, 1);
                al.c(this.haa, e.d.cp_link_tip_c, 1);
                al.c(this.hab, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bNv, e.f.praise_head_selector);
            al.c(this.gZZ, e.d.cp_cont_d, 1);
            al.c(this.haa, e.d.cp_link_tip_c, 1);
            al.c(this.hab, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bNv, e.f.praise_view_btn_color);
        al.c(this.gZZ, e.d.cp_cont_d, 1);
        al.c(this.haa, e.d.cp_cont_c, 1);
        al.c(this.hab, e.d.cp_cont_c, 1);
    }
}
