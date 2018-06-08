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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsPraiseView extends LinearLayout {
    private TextView awB;
    private boolean fHx;
    private TextView gGk;
    private TextView gGl;
    private PraiseData gGm;
    private boolean gGn;
    private Context mContext;
    private String mPostId;
    private String mThreadId;
    private View root;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.fHx = false;
        this.gGn = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fHx = false;
        this.gGn = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.root = View.inflate(this.mContext, d.i.frs_item_praise, this);
        this.awB = (TextView) this.root.findViewById(d.g.frs_go_praise_list_num);
        this.gGk = (TextView) this.root.findViewById(d.g.frs_praise_user_name_text1);
        this.gGl = (TextView) this.root.findViewById(d.g.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.gGm != null) {
                    str = FrsPraiseView.this.gGm.getTitle();
                }
                com.baidu.tbadk.util.n.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.fHx));
            }
        });
        this.gGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gGm.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.gGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.gGm.getUser().get(0);
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
            this.gGm = praiseData;
            mp(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.fHx = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.gGn = z;
    }

    private void mp(boolean z) {
        long num = this.gGm.getNum();
        this.gGl.setVisibility(8);
        this.gGk.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.gGm.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.gGk.setVisibility(0);
                        this.gGk.setText(tA(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.gGk.setVisibility(0);
                        this.gGk.setText(tA(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.gGl.setVisibility(0);
                        this.gGl.setText("、" + tA(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.awB.setText(this.mContext.getString(d.k.common_praise_view_text));
            } else if (num <= 999999) {
                this.awB.setText(this.mContext.getString(d.k.etc) + num + this.mContext.getString(d.k.common_praise_view_text2));
            } else {
                this.awB.setText(this.mContext.getString(d.k.etc) + "999999+" + this.mContext.getString(d.k.common_praise_view_text2));
            }
        }
    }

    private String tA(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void dC(int i) {
        if (this.fHx) {
            if (this.gGn) {
                al.i(this.root, d.f.praise_video_selector);
                al.c(this.awB, d.C0141d.cp_cont_c, 1);
                al.c(this.gGk, d.C0141d.cp_link_tip_c, 1);
                al.c(this.gGl, d.C0141d.cp_link_tip_c, 1);
                return;
            }
            al.i(this.root, d.f.praise_head_selector);
            al.c(this.awB, d.C0141d.cp_cont_d, 1);
            al.c(this.gGk, d.C0141d.cp_link_tip_c, 1);
            al.c(this.gGl, d.C0141d.cp_link_tip_c, 1);
            return;
        }
        al.i(this.root, d.f.praise_view_btn_color);
        al.c(this.awB, d.C0141d.cp_cont_d, 1);
        al.c(this.gGk, d.C0141d.cp_cont_c, 1);
        al.c(this.gGl, d.C0141d.cp_cont_c, 1);
    }
}
