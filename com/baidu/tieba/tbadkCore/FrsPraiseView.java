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
    private View bRX;
    private boolean gjc;
    private TextView hip;
    private TextView hiq;
    private TextView hir;
    private PraiseData his;
    private boolean hit;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.gjc = false;
        this.hit = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjc = false;
        this.hit = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bRX = View.inflate(this.mContext, e.h.frs_item_praise, this);
        this.hip = (TextView) this.bRX.findViewById(e.g.frs_go_praise_list_num);
        this.hiq = (TextView) this.bRX.findViewById(e.g.frs_praise_user_name_text1);
        this.hir = (TextView) this.bRX.findViewById(e.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.his != null) {
                    str = FrsPraiseView.this.his.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.gjc));
            }
        });
        this.hir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.his.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.d(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.hiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.his.getUser().get(0);
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
            this.his = praiseData;
            nm(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.gjc = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.hit = z;
    }

    private void nm(boolean z) {
        long num = this.his.getNum();
        this.hir.setVisibility(8);
        this.hiq.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.his.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.hiq.setVisibility(0);
                        this.hiq.setText(vp(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.hiq.setVisibility(0);
                        this.hiq.setText(vp(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.hir.setVisibility(0);
                        this.hir.setText("、" + vp(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.hip.setText(this.mContext.getString(e.j.common_praise_view_text));
            } else if (num <= 999999) {
                this.hip.setText(this.mContext.getString(e.j.etc) + num + this.mContext.getString(e.j.common_praise_view_text2));
            } else {
                this.hip.setText(this.mContext.getString(e.j.etc) + "999999+" + this.mContext.getString(e.j.common_praise_view_text2));
            }
        }
    }

    private String vp(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void eC(int i) {
        if (this.gjc) {
            if (this.hit) {
                al.i(this.bRX, e.f.praise_video_selector);
                al.c(this.hip, e.d.cp_cont_c, 1);
                al.c(this.hiq, e.d.cp_link_tip_c, 1);
                al.c(this.hir, e.d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.bRX, e.f.praise_head_selector);
            al.c(this.hip, e.d.cp_cont_d, 1);
            al.c(this.hiq, e.d.cp_link_tip_c, 1);
            al.c(this.hir, e.d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.bRX, e.f.praise_view_btn_color);
        al.c(this.hip, e.d.cp_cont_d, 1);
        al.c(this.hiq, e.d.cp_cont_c, 1);
        al.c(this.hir, e.d.cp_cont_c, 1);
    }
}
