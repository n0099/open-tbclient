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
    private View bOg;
    private boolean gck;
    private boolean hbA;
    private TextView hbw;
    private TextView hbx;
    private TextView hby;
    private PraiseData hbz;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gck = false;
        this.hbA = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gck = false;
        this.hbA = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bOg = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.hbw = (TextView) this.bOg.findViewById(e.g.frs_go_praise_list_num);
        this.hbx = (TextView) this.bOg.findViewById(e.g.frs_praise_user_name_text1);
        this.hby = (TextView) this.bOg.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.hbz != null) {
                    str = FrsPraiseView.this.hbz.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gck));
            }
        });
        this.hby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hbz.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.hbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.hbz.getUser().get(0);
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
            this.hbz = praiseData;
            nk(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gck = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.hbA = z;
    }

    private void nk(boolean z) {
        long num = this.hbz.getNum();
        this.hby.setVisibility(8);
        this.hbx.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.hbz.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.hbx.setVisibility(0);
                        this.hbx.setText(uO(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.hbx.setVisibility(0);
                        this.hbx.setText(uO(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hby.setVisibility(0);
                        this.hby.setText("、" + uO(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.hbw.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.hbw.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.hbw.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
            }
        }
    }

    private String uO(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void eo(int i) {
        if (this.gck) {
            if (this.hbA) {
                al.i(this.bOg, e.f.praise_video_selector);
                al.c(this.hbw, e.d.cp_cont_c, 1);
                al.c(this.hbx, e.d.cp_link_tip_c, 1);
                al.c(this.hby, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bOg, e.f.praise_head_selector);
            al.c(this.hbw, e.d.cp_cont_d, 1);
            al.c(this.hbx, e.d.cp_link_tip_c, 1);
            al.c(this.hby, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bOg, e.f.praise_view_btn_color);
        al.c(this.hbw, e.d.cp_cont_d, 1);
        al.c(this.hbx, e.d.cp_cont_c, 1);
        al.c(this.hby, e.d.cp_cont_c, 1);
    }
}
